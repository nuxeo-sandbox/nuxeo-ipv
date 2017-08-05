package org.nuxeo.ipv;

import java.io.File;

import org.nuxeo.ecm.core.api.CoreSession;
import org.nuxeo.ecm.core.api.DocumentModel;
import org.nuxeo.ecm.core.api.NuxeoException;
import org.nuxeo.ipv.asset.generated.xml.IPVXMLAssetMapping;

public interface IpvService {

    public static final String IPV_ASSET_FACET = "IpvAsset";

    public String getProcessDefinition(String processName) throws NuxeoException;

    public String createProcess(String processName, String defId, String url, String docId) throws NuxeoException;

    // the name of the IPV workflow to be invoked when a video is uploaded
    public String getDefaultIPVProcessName();

    public IPVXMLAssetMapping unmarshallIPVXML(File xmlFile);

    // Uses an unrestricted session
    public void attachIPVData(String docId, IPVXMLAssetMapping ipvAssert, String repoName);
}