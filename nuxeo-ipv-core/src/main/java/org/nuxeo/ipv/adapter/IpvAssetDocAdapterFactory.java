package org.nuxeo.ipv.adapter;

import org.nuxeo.ecm.core.api.DocumentModel;
import org.nuxeo.ecm.core.api.adapter.DocumentAdapterFactory;
import org.nuxeo.ipv.IpvService;

public class IpvAssetDocAdapterFactory implements DocumentAdapterFactory {

    @Override
    public Object getAdapter(DocumentModel doc, Class<?> itf) {
        if (doc.hasFacet(IpvService.IPV_ASSET_FACET) && "Video".equals(doc.getType())) {
            return new IpvAssetDocAdapter(doc);
        } else {
            return null;
        }
    }
}
