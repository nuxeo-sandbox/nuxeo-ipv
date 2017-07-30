package org.nuxeo.ipv;

public interface IpvService {

    public String getProcessDefinition(String processName) throws Exception;

    public String createProcess(String processName, String defId, String url, String docId) throws Exception;
}
