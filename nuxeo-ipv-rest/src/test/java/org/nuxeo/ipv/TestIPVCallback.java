package org.nuxeo.ipv;

import static org.junit.Assert.assertEquals;

import java.io.File;
import java.io.IOException;

import javax.ws.rs.core.Response;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.nuxeo.common.utils.FileUtils;
import org.nuxeo.ecm.core.api.CoreSession;
import org.nuxeo.ecm.core.test.CoreFeature;
import org.nuxeo.ecm.webengine.forms.FormData;
import org.nuxeo.ecm.webengine.test.WebEngineFeature;
import org.nuxeo.runtime.test.runner.Deploy;
import org.nuxeo.runtime.test.runner.Features;
import org.nuxeo.runtime.test.runner.FeaturesRunner;
import org.nuxeo.runtime.test.runner.Jetty;
import org.nuxeo.runtime.test.runner.LocalDeploy;

import com.google.inject.Inject;
import com.sun.jersey.api.client.Client;
import com.sun.jersey.api.client.ClientResponse;
import com.sun.jersey.api.client.WebResource;
import com.sun.jersey.api.representation.Form;

@RunWith(FeaturesRunner.class)
@Features({ WebEngineFeature.class, CoreFeature.class })
@Jetty(port = 18090)
@Deploy({ "org.nuxeo.ipv.nuxeo-ipv-core", "org.nuxeo.ipv.nuxeo-ipv-rest" })
@LocalDeploy({ "org.nuxeo.ipv.nuxeo-ipv-rest:ipv-rest-test-contrib.xml" })
public class TestIPVCallback {

    protected static final String BASE_URL = "http://bisk-dam-demo.cloud.nuxeo.com/nuxeo/site";

    private static final String CONTENT_TYPE = "application/x-www-form-urlencoded";

    private static final Integer TIMEOUT = 1000 * 60 * 5; // 5min

    protected Client client;

    @Inject
    CoreSession session;

    @Before
    public void setup() {
        client = Client.create();
        client.setConnectTimeout(TIMEOUT);
        client.setReadTimeout(TIMEOUT);
        client.setFollowRedirects(Boolean.FALSE);
    }

    @Test
    public void postCallback() throws IOException {
        //just run against the real demo server for now as an example for IPV

        File file = org.nuxeo.common.utils.FileUtils.getResourceFileFromContext("metadata.xml");
        String metdata = FileUtils.readFile(file);
        Form form = new Form();
        form.putSingle("nuxeoId", "nuxeoId");
        form.putSingle("curatorId", "curatorId");
        form.putSingle("metadata", metdata);
        WebResource webResource = client.resource(BASE_URL).path("ipv").path("callback");
        ClientResponse response = webResource.accept(CONTENT_TYPE).type(CONTENT_TYPE).post(ClientResponse.class,
                form);

        assertEquals(200, response.getStatus());
    }

}