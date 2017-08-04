package org.nuxeo.ipv;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;

import java.io.File;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.nuxeo.ecm.platform.test.PlatformFeature;
import org.nuxeo.ipv.asset.generated.xml.IPVAsset;
import org.nuxeo.runtime.test.runner.Deploy;
import org.nuxeo.runtime.test.runner.Features;
import org.nuxeo.runtime.test.runner.FeaturesRunner;

import com.google.inject.Inject;

@RunWith(FeaturesRunner.class)
@Features({ PlatformFeature.class })
@Deploy("org.nuxeo.ipv.nuxeo-ipv-core")
public class TestIpvService {

    @Inject
    protected IpvService ipvservice;

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
        File file = org.nuxeo.common.utils.FileUtils.getResourceFileFromContext("metadata.xml");
        IPVAsset ipva = ipvservice.unmarshallIPVXML(file);
        assertEquals(4, ipva.getTrack().size());

    }
}
