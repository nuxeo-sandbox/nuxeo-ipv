package org.nuxeo.ipv;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;

import java.io.File;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.nuxeo.ecm.core.api.CoreSession;
import org.nuxeo.ecm.core.api.DocumentModel;
import org.nuxeo.ecm.platform.test.PlatformFeature;
import org.nuxeo.ipv.asset.generated.xml.IPVXMLAssetMapping;
import org.nuxeo.runtime.test.runner.Deploy;
import org.nuxeo.runtime.test.runner.Features;
import org.nuxeo.runtime.test.runner.FeaturesRunner;
import org.nuxeo.runtime.test.runner.LocalDeploy;

import com.google.inject.Inject;

@RunWith(FeaturesRunner.class)
@Features({ PlatformFeature.class })
@Deploy("org.nuxeo.ipv.nuxeo-ipv-core")
@LocalDeploy("org.nuxeo.ipv.nuxeo-ipv-core:core-types-contrib.xml")
public class TestIpvService {

    @Inject
    protected IpvService ipvservice;

    @Inject
    protected CoreSession session;

    @Test
    public void testService() {
        assertNotNull(ipvservice);
    }

    @Test
    public void itCanCreateProcess() throws Exception {
        String id = ipvservice.getProcessDefinition("Nuxeo Test");
        System.out.println(id);
        ipvservice.createProcess("Unit test", id, "aws://path/here/file.mov", "test-12345");
    }

    @Test
    public void testUnmarshallingDocument() {
        DocumentModel asset1 = session.createDocumentModel("/default-domain", "asset1", "Video");
        asset1 = session.createDocument(asset1);
        asset1 = session.saveDocument(asset1);
        session.save();

        File file = org.nuxeo.common.utils.FileUtils.getResourceFileFromContext("metadata.xml");
        IPVXMLAssetMapping ipva = ipvservice.unmarshallIPVXML(file);
        assertEquals(4, ipva.getTrack().size());
        ipvservice.attachIPVData(asset1.getId(), "curatorId", ipva, session.getRepositoryName());
        asset1 = session.getDocument(asset1.getRef());
        assertEquals("Variable", (String) asset1.getPropertyValue("ipv:ipvasset/generalTrack/Overall_bit_rate_mode"));
        assertEquals("4:4:4", (String) asset1.getPropertyValue("ipv:ipvasset/videoTrack/Chroma_subsampling"));

    }

}
