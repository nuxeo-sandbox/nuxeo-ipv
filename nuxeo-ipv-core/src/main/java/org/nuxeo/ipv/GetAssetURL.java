package org.nuxeo.ipv;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.nuxeo.ecm.automation.OperationContext;
import org.nuxeo.ecm.automation.core.Constants;
import org.nuxeo.ecm.automation.core.annotations.Context;
import org.nuxeo.ecm.automation.core.annotations.Operation;
import org.nuxeo.ecm.automation.core.annotations.OperationMethod;
import org.nuxeo.ecm.core.api.CoreSession;
import org.nuxeo.ecm.core.api.DocumentModel;
import org.nuxeo.ecm.core.api.NuxeoException;
import org.nuxeo.ipv.adapter.IpvAssetDocAdapter;
import org.nuxeo.runtime.api.Framework;

/**
 *
 */
@Operation(id = GetAssetURL.ID, category = Constants.CAT_DOCUMENT, label = "GetAssetUrl", description = "Describe here what your operation does.")
public class GetAssetURL {

    public static final String ID = "IPV.GetAssetURL";

    @Context
    protected CoreSession session;

    @Context
    protected OperationContext ctx;

    private static Log log = LogFactory.getLog(GetAssetURL.class);

    @OperationMethod
    public String run(DocumentModel input) {
        String ipvHostUrl = Framework.getProperty("nuxeo.ipv.hostUrl", "http://sandbox.aws.ipv.com");
        String assetUIUrl = Framework.getProperty("nuxeo.ipv.assetUiUrl", "/NuxeoLogger/Log/LogMediaAsset?mediaId=");

        IpvAssetDocAdapter ipvAsset = input.getAdapter(IpvAssetDocAdapter.class);
        String url = null;
        if (ipvAsset != null) {
            String curatorId = ipvAsset.getCuratorId();
            if (curatorId != null) {
                url = ipvHostUrl + assetUIUrl + curatorId;
            }
        }

        if (url == null) {
            String msg = "Can not build IPV URL: missing curatorId property";
            log.error(msg);
            throw new NuxeoException(msg);
        }

        // Force outcome to display the url in JSF UI
        ctx.put("Outcome", url);

        return url;
    }
}
