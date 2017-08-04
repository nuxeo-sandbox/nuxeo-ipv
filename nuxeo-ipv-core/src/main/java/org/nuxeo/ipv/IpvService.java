package org.nuxeo.ipv;

import java.io.File;

import org.nuxeo.ecm.core.api.NuxeoException;
import org.nuxeo.ipv.asset.generated.xml.IPVAsset;

public interface IpvService {

    public String getProcessDefinition(String processName) throws NuxeoException;

    public String createProcess(String processName, String defId, String url, String docId) throws NuxeoException;

    //the name of the IPV workflow to be invoked when a video is uploaded
    public String getDefaultIPVProcessName();
    
    
    public IPVAsset unmarshallIPVXML(File xmlFile);
}
