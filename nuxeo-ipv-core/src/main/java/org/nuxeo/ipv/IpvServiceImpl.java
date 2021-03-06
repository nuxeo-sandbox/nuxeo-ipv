package org.nuxeo.ipv;

import java.io.File;
import java.io.InputStream;
import java.io.UnsupportedEncodingException;

import javax.xml.bind.JAXBContext;
import javax.xml.bind.JAXBException;
import javax.xml.bind.Unmarshaller;

import org.apache.commons.io.IOUtils;
import org.apache.commons.lang.StringUtils;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.apache.http.HttpResponse;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.entity.StringEntity;
import org.apache.http.impl.client.DefaultHttpClient;
import org.json.JSONException;
import org.json.JSONObject;
import org.nuxeo.ecm.core.api.CoreInstance;
import org.nuxeo.ecm.core.api.CoreSession;
import org.nuxeo.ecm.core.api.DocumentModel;
import org.nuxeo.ecm.core.api.IdRef;
import org.nuxeo.ecm.core.api.NuxeoException;
import org.nuxeo.ipv.adapter.IpvAssetDocAdapter;
import org.nuxeo.ipv.asset.generated.xml.IPVXMLAssetMapping;
import org.nuxeo.runtime.api.Framework;
import org.nuxeo.runtime.model.ComponentContext;
import org.nuxeo.runtime.model.ComponentInstance;
import org.nuxeo.runtime.model.DefaultComponent;

public class IpvServiceImpl extends DefaultComponent implements IpvService {

    public Log log = LogFactory.getLog(IpvServiceImpl.class);

    /**
     * Component activated notification. Called when the component is activated. All component dependencies are resolved
     * at that moment. Use this method to initialize the component.
     *
     * @param context the component context.
     */
    @Override
    public void activate(ComponentContext context) {
        super.activate(context);
    }

    /**
     * Component deactivated notification. Called before a component is unregistered. Use this method to do cleanup if
     * any and free any resources held by the component.
     *
     * @param context the component context.
     */
    @Override
    public void deactivate(ComponentContext context) {
        super.deactivate(context);
    }

    /**
     * Application started notification. Called after the application started. You can do here any initialization that
     * requires a working application (all resolved bundles and components are active at that moment)
     *
     * @param context the component context. Use it to get the current bundle context
     * @throws Exception
     */
    @Override
    public void applicationStarted(ComponentContext context) {
        // do nothing by default. You can remove this method if not used.
    }

    @Override
    public void registerContribution(Object contribution, String extensionPoint, ComponentInstance contributor) {
        // Add some logic here to handle contributions
    }

    @Override
    public void unregisterContribution(Object contribution, String extensionPoint, ComponentInstance contributor) {
        // Logic to do when unregistering any contribution
    }

    protected JSONObject makePostRequest(String restActionUrl, StringEntity input) {

        DefaultHttpClient httpClient = new DefaultHttpClient();
        try {
            String ipvHostUrl = Framework.getProperty("nuxeo.ipv.hostUrl", "http://sandbox.aws.ipv.com");
            HttpPost postRequest = new HttpPost(ipvHostUrl +":11170/ProcessEngineService/web"
                    + restActionUrl);

            input.setContentType("application/json");
            postRequest.setEntity(input);

            HttpResponse response = httpClient.execute(postRequest);

            if (response.getStatusLine().getStatusCode() != 200) {
                throw new NuxeoException("Failed : HTTP error code : " + response.getStatusLine().getStatusCode());
            }

            InputStream is = response.getEntity().getContent();
            String output = IOUtils.toString(is, "UTF-8");
            IOUtils.closeQuietly(is);

            if (!StringUtils.isEmpty(output)) {
                return new JSONObject(output);
            }
        } catch (Exception e) {

            e.printStackTrace();
            throw new NuxeoException(e);

        } finally {
            if (httpClient.getConnectionManager() != null) {
                httpClient.getConnectionManager().shutdown();
            }

        }

        return null;
    }

    @Override
    public String getProcessDefinition(String processName) throws NuxeoException {
        JSONObject json = new JSONObject();
        try {
            json.put("name", processName);
            StringEntity input = new StringEntity(json.toString());
            JSONObject response = makePostRequest("/processdefinition/name", input);
            return ((JSONObject) response.get("GetProcessDefinitionByNameResult")).getString("Id");

        } catch (UnsupportedEncodingException | JSONException e) {
            throw new NuxeoException(e);
        }

    }

    @Override
    public String createProcess(String processName, String defId, String url, String docId) throws NuxeoException {
        String payload = "{" + "    \"process\": {" + "        \"Name\": \"" + processName + "\","
                + "        \"DefinitionId\": \"" + defId + "\"," + "        \"Arguments\": [" + "            {"
                + "                \"Name\": \"IngestFileFullPath\"," + "                \"Expression\": \"\\\"" + url
                + "\\\"\"" + "            }," + "            {" + "                \"Name\": \"XMLMetadata\","
                + "                \"Expression\": \"\\\"<nuxeoid>" + docId + "</nuxeoid>\\\"\"" + "            }"
                + "        ]," + "        \"Token\": \"[Insert Optional Token Metadata eg. User Id, Filename]\""
                + "    }," + "    \"waitForCompletion\": false," + "    \"timeout\": \"P0Y0M0DT0H0M0S\"" + "}";

        StringEntity input;
        try {
            input = new StringEntity(payload);
            JSONObject response = makePostRequest("/processes/create", input);
            return ((JSONObject) response.get("CreateProcessResult")).getString("Id");
        } catch (UnsupportedEncodingException | JSONException e) {
            throw new NuxeoException(e);
        }
    }

    @Override
    public String getDefaultIPVProcessName() {
        return Framework.getProperty("nuxeo.ipv.process.name", "Nuxeo Test");
    }

    @Override
    public IPVXMLAssetMapping unmarshallIPVXML(File xmlFile) {

        try {
            JAXBContext jaxbContext = JAXBContext.newInstance("org.nuxeo.ipv.asset.generated.xml");
            Unmarshaller unmarshaller = jaxbContext.createUnmarshaller();
            return (org.nuxeo.ipv.asset.generated.xml.IPVXMLAssetMapping) unmarshaller.unmarshal(xmlFile);

        } catch (JAXBException e) {
            log.error("Can not unmarshall XML document");
            throw new NuxeoException(e);
        }

    }

    @Override
    public void attachIPVData(String docId, String curatorId, IPVXMLAssetMapping ipvAssert, String repoName) {
        CoreInstance.doPrivileged(repoName, (CoreSession session) -> {
            DocumentModel doc = session.getDocument(new IdRef(docId));
            if (!doc.hasFacet(IPV_ASSET_FACET)) {
                doc.addFacet(IPV_ASSET_FACET);
                doc = session.saveDocument(doc);
            }
            IpvAssetDocAdapter ipvDoc = doc.getAdapter(IpvAssetDocAdapter.class);
            ipvDoc.setCuratorId(curatorId);
            ipvDoc.setIPVAsset(ipvAssert);
            ipvDoc.save();
        });
    }
}
