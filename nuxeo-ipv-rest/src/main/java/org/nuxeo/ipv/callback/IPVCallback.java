package org.nuxeo.ipv.callback;

import java.io.ByteArrayInputStream;
import java.io.File;
import java.io.IOException;
import java.io.InputStream;

import javax.servlet.http.HttpServletRequest;
import javax.ws.rs.FormParam;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.core.Context;
import javax.ws.rs.core.Response;
import javax.ws.rs.core.Response.Status;

import org.apache.commons.fileupload.FileItem;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.nuxeo.common.utils.FileUtils;
import org.nuxeo.ecm.core.api.Blob;
import org.nuxeo.ecm.core.api.Blobs;
import org.nuxeo.ecm.core.api.DocumentNotFoundException;
import org.nuxeo.ecm.core.api.NuxeoException;
import org.nuxeo.ecm.core.api.repository.RepositoryManager;
import org.nuxeo.ecm.webengine.WebException;
import org.nuxeo.ecm.webengine.forms.FormData;
import org.nuxeo.ecm.webengine.model.WebObject;
import org.nuxeo.ecm.webengine.model.impl.AbstractResource;
import org.nuxeo.ecm.webengine.model.impl.ResourceTypeImpl;
import org.nuxeo.ipv.IpvService;
import org.nuxeo.ipv.asset.generated.xml.IPVXMLAssetMapping;
import org.nuxeo.runtime.api.Framework;

@Path("/ipv")
@WebObject(type = "ipv")
public class IPVCallback extends AbstractResource<ResourceTypeImpl> {
    public static Log log = LogFactory.getLog(IPVCallback.class);

    @GET
    public Response doGet() {
        return Response.status(Response.Status.OK).build();
    }

    // IPV does not know how to send a file
    @POST
    @Path("callbackfile")
    public Response doPost(@Context HttpServletRequest request) {
        String nuxeoId = null;
        String curatorId = null;
        String contentType = request.getHeader("Content-Type");
        if (contentType == null || !contentType.contains("multipart")) {
            return Response.status(Response.Status.BAD_REQUEST).build();
        }
        FormData formData = new FormData(request);
        if (formData.getString("nuxeoId") != null) {
            nuxeoId = formData.getString("nuxeoId");
        }
        if (formData.getString("curatorId") != null) {
            curatorId = formData.getString("curatorId");
        }

        FileItem metdataXML = formData.getFileItem("metadata");
        if (metdataXML == null) {
            throw WebException.wrap("Failed to metdata", null);
        }

        Blob xml = getBlob(metdataXML);
        // send these for now?
        if (xml == null) {
            return Response.status(Response.Status.NO_CONTENT).build();
        }
        if (nuxeoId == null) {
            return Response.status(Response.Status.NOT_ACCEPTABLE).build();
        }
        IPVXMLAssetMapping ipvAsset = Framework.getLocalService(IpvService.class).unmarshallIPVXML(xml.getFile());
        return Response.status(Status.OK).build();
    }

    // accept string as IPV does not know how to send a file
    @POST
    @Path("callback")
    public Response doPostCallback(@Context HttpServletRequest request, @FormParam(value = "nuxeoId") String nuxeoId,
            @FormParam(value = "curatorId") String curatorId, @FormParam(value = "metadata") String metadata) {

        log.debug("IPV sends back nuxeoId: " + nuxeoId);
        log.debug("IPV sends back curatorId: " + curatorId);

        if (nuxeoId == null) {
            return Response.status(Response.Status.NOT_ACCEPTABLE).build();
        }
        if (metadata == null) {
            return Response.status(Response.Status.NO_CONTENT).build();
        }

        File tmpXML = null;
        ;
        try {
            tmpXML = Framework.createTempFile("ipv", "xml");
            FileUtils.writeFile(tmpXML, metadata);
        } catch (IOException e) {
            throw new NuxeoException(e);
        }

        // unmarshall to see if works
        try {
            Framework.getLocalService(IpvService.class).attachIPVData(nuxeoId,
                    Framework.getLocalService(IpvService.class).unmarshallIPVXML(tmpXML),
                    Framework.getLocalService(RepositoryManager.class).getDefaultRepositoryName());
        } catch (DocumentNotFoundException e) {
            return Response.status(Response.Status.NOT_ACCEPTABLE).build();
        }
        return Response.status(Status.OK).build();
    }

    protected Blob getBlob(FileItem item) {
        try {
            InputStream in;
            if (item.isInMemory()) {
                in = new ByteArrayInputStream(item.get());
            } else {
                in = item.getInputStream();
            }
            String ctype = item.getContentType();
            Blob blob = Blobs.createBlob(in, ctype == null ? "application/octet-stream" : ctype);
            blob.setFilename(item.getName());
            in.close();
            return blob;
        } catch (IOException e) {
            throw WebException.wrap("Failed to get blob data", e);
        }
    }
}
