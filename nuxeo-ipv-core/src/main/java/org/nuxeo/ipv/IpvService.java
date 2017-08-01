package org.nuxeo.ipv;

import org.nuxeo.ecm.core.api.NuxeoException;

public interface IpvService {

    public String getProcessDefinition(String processName) throws NuxeoException;

    public String createProcess(String processName, String defId, String url, String docId) throws NuxeoException;

    //the name of the IPV workflow to be invoked when a video is uploaded
    public String getDefaultIPVProcessName();
    
    //the name of the IPV workflow instance to be invoked when a video is uploaded; lets put the 
    //date like in their UI
    public String getDefaultIPVDefId();
}
