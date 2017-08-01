package org.nuxeo.ipv;

import java.io.IOException;
import java.net.URI;

import org.nuxeo.ecm.core.api.DocumentModel;
import org.nuxeo.ecm.core.api.NuxeoException;
import org.nuxeo.ecm.core.api.event.DocumentEventTypes;
import org.nuxeo.ecm.core.blob.BlobManager;
import org.nuxeo.ecm.core.event.Event;
import org.nuxeo.ecm.core.event.EventBundle;
import org.nuxeo.ecm.core.event.EventContext;
import org.nuxeo.ecm.core.event.PostCommitFilteringEventListener;
import org.nuxeo.ecm.core.event.impl.DocumentEventContext;
import org.nuxeo.ecm.platform.video.VideoDocument;
import org.nuxeo.runtime.api.Framework;

public class StartIPVWorkflowListener implements PostCommitFilteringEventListener {

    @Override
    public void handleEvent(EventBundle events) {
        for (Event event : events) {
            handleEvent(event);
        }
    }

    protected void handleEvent(Event event) {
        EventContext ctx = event.getContext();
        if (!(ctx instanceof DocumentEventContext)) {
            return;
        }
        DocumentEventContext docCtx = (DocumentEventContext) ctx;
        DocumentModel doc = docCtx.getSourceDocument();
        VideoDocument video = doc.getAdapter(VideoDocument.class);
        if (video == null) {
            return; // need to process only videos;
        }
        IpvService ipvService = Framework.getLocalService(IpvService.class);
        URI uri;
        try {
            uri = Framework.getLocalService(BlobManager.class).getURI(video.getVideo().getBlob(),
                    BlobManager.UsageHint.DOWNLOAD, null);
        } catch (IOException e) {
            throw new NuxeoException("Can not fetch presigned url in S3", e);
        }
        if (uri == null) {
            throw new NuxeoException("Sset nuxeo.s3storage.directdownload = true");
        }

        ipvService.createProcess(ipvService.getDefaultIPVProcessName(), ipvService.getDefaultIPVDefId(),
                uri.toString(), doc.getId());

    }

    @Override
    public boolean acceptEvent(Event event) {
        return DocumentEventTypes.DOCUMENT_CREATED.equals(event.getName());
    }

}
