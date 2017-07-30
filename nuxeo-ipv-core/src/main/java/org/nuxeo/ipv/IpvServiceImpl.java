package org.nuxeo.ipv;

import java.io.InputStream;

import org.apache.commons.io.IOUtils;
import org.apache.commons.lang.StringUtils;
import org.apache.http.HttpResponse;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.entity.StringEntity;
import org.apache.http.impl.client.DefaultHttpClient;
import org.json.JSONObject;
import org.nuxeo.ecm.core.api.NuxeoException;
import org.nuxeo.runtime.model.ComponentContext;
import org.nuxeo.runtime.model.ComponentInstance;
import org.nuxeo.runtime.model.DefaultComponent;

public class IpvServiceImpl extends DefaultComponent implements IpvService {

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

    protected JSONObject makePostRequest(String restActionUrl,StringEntity input) {

        DefaultHttpClient httpClient = new DefaultHttpClient();
        try {

            HttpPost postRequest = new HttpPost(
                    "http://sandbox.aws.ipv.com:11170/ProcessEngineService/web"+ restActionUrl);

            input.setContentType("application/json");
            postRequest.setEntity(input);

            HttpResponse response = httpClient.execute(postRequest);

            if (response.getStatusLine().getStatusCode() != 200) {
                throw new NuxeoException("Failed : HTTP error code : " + response.getStatusLine().getStatusCode());
            }

            InputStream is = response.getEntity().getContent();
            String output = IOUtils.toString(is, "UTF-8");
            IOUtils.closeQuietly(is);

            if(!StringUtils.isEmpty(output)) {
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
    public String getProcessDefinition(String processName) throws Exception {
        JSONObject json = new JSONObject();
        json.put("name", processName);
        StringEntity input = new StringEntity(json.toString());

        JSONObject response = makePostRequest("/processdefinition/name",input);
        return ((JSONObject)response.get("GetProcessDefinitionByNameResult")).getString("Id");
    }
    
    @Override
    public String createProcess(String processName, String defId, String url, String docId) throws Exception {
        String payload = "{" + 
                "    \"process\": {" + 
                "        \"Name\": \""+ processName +"\"," + 
                "        \"DefinitionId\": \""+ defId +"\"," + 
                "        \"Arguments\": [" + 
                "            {" + 
                "                \"Name\": \"IngestFileFullPath\"," + 
                "                \"Expression\": \"\\\""+url+"\\\"\"" + 
                "            }," + 
                "            {" + 
                "                \"Name\": \"XMLMetadata\"," + 
                "                \"Expression\": \"\\\"<nuxeoid>"+docId+"</nuxeoid>\\\"\"" + 
                "            }" + 
                "        ]," + 
                "        \"Token\": \"[Insert Optional Token Metadata eg. User Id, Filename]\"" + 
                "    }," + 
                "    \"waitForCompletion\": false," + 
                "    \"timeout\": \"P0Y0M0DT0H0M0S\"" + 
                "}";
        
        StringEntity input = new StringEntity(payload);

        JSONObject response = makePostRequest("/processes/create",input);
        return ((JSONObject)response.get("CreateProcessResult")).getString("Id");
    }

}
