package org.nuxeo.ipv.adapter;

import java.util.List;

import org.nuxeo.ecm.core.api.CoreSession;
import org.nuxeo.ecm.core.api.DocumentModel;
import org.nuxeo.ecm.core.api.DocumentRef;
import org.nuxeo.ipv.asset.generated.xml.IPVXMLAssetMapping;

/**
 *
 */
public class IpvAssetDocAdapter {

    protected final DocumentModel doc;

    public String curatorIdXpath = "ipv:curatorId";

    public String generalTrackPrefix = "gt_";

    public String videoTrackPrefix = "vt_";

    public String audioTrackPrefix = "at_";

    public String otherTrackPrefix = "ot_";

    public IpvAssetDocAdapter(DocumentModel doc) {
        this.doc = doc;
    }

    public void setIPVAsset(IPVXMLAssetMapping ipvAsset) {
        @SuppressWarnings("unchecked")
        List<IPVXMLAssetMapping.Track> ipVTracks = ipvAsset.getTrack();
        for (IPVXMLAssetMapping.Track ipvTrack : ipVTracks) {
            if ("General".equals(ipvTrack.getType())) {
                doc.setPropertyValue(generalTrackPrefix + "Complete_name", ipvTrack.getCompleteName());
                doc.setPropertyValue(generalTrackPrefix + "Format", ipvTrack.getFormat());
                doc.setPropertyValue(generalTrackPrefix + "Format_profile", ipvTrack.getFormatProfile());
                doc.setPropertyValue(generalTrackPrefix + "Codec_ID", ipvTrack.getCodecID());
                doc.setPropertyValue(generalTrackPrefix + "File_size", ipvTrack.getFileSize());
                doc.setPropertyValue(generalTrackPrefix + "Duration", ipvTrack.getDuration());
                doc.setPropertyValue(generalTrackPrefix + "Overall_bit_rate_mode", ipvTrack.getOverallBitRateMode());
                doc.setPropertyValue(generalTrackPrefix + "Overall_bit_rate", ipvTrack.getOverallBitRate());
                doc.setPropertyValue(generalTrackPrefix + "Encoded_date", ipvTrack.getEncodedDate());
                doc.setPropertyValue(generalTrackPrefix + "Tagged_date", ipvTrack.getTaggedDate());
                doc.setPropertyValue(generalTrackPrefix + "Writing_library", ipvTrack.getWritingLibrary());
                doc.setPropertyValue(generalTrackPrefix + "Media_UUID", ipvTrack.getMediaUUID());
            }
            if ("Video".equals(ipvTrack.getType())) {
                doc.setPropertyValue(videoTrackPrefix + "Format", ipvTrack.getFormat());
                doc.setPropertyValue(videoTrackPrefix + "Format_version", ipvTrack.getFormatVersion());
                doc.setPropertyValue(videoTrackPrefix + "Format_profile", ipvTrack.getFormatProfile());
                doc.setPropertyValue(videoTrackPrefix + "Codec_ID", ipvTrack.getCodecID());
                doc.setPropertyValue(videoTrackPrefix + "Duration", ipvTrack.getDuration());
                doc.setPropertyValue(videoTrackPrefix + "Bit_rate_mode", ipvTrack.getBitRateMode());
                doc.setPropertyValue(videoTrackPrefix + "Bit_rate", ipvTrack.getBitRate());
                doc.setPropertyValue(videoTrackPrefix + "Width", ipvTrack.getWidth());
                doc.setPropertyValue(videoTrackPrefix + "Clean_aperture_width", ipvTrack.getCleanApertureWidth());
                doc.setPropertyValue(videoTrackPrefix + "Height", ipvTrack.getHeight());
                doc.setPropertyValue(videoTrackPrefix + "Clean_aperture_height", ipvTrack.getCleanApertureHeight());
                doc.setPropertyValue(videoTrackPrefix + "Display_aspect_ratio", ipvTrack.getDisplayAspectRatio());
                doc.setPropertyValue(videoTrackPrefix + "Clean_aperture_display_aspect_ratio",
                        ipvTrack.getCleanApertureDisplayAspectRatio());
                doc.setPropertyValue(videoTrackPrefix + "Frame_rate_mode", ipvTrack.getFrameRateMode());
                doc.setPropertyValue(videoTrackPrefix + "Frame_rate", ipvTrack.getFrameRate());
                doc.setPropertyValue(videoTrackPrefix + "Chroma_subsampling", ipvTrack.getChromaSubsampling());
                doc.setPropertyValue(videoTrackPrefix + "Scan_type", ipvTrack.getScanType());
                doc.setPropertyValue(videoTrackPrefix + "Bits__Pixel_Frame_", ipvTrack.getBitsPixelFrame());
                doc.setPropertyValue(videoTrackPrefix + "Stream_size", ipvTrack.getStreamSize());
                doc.setPropertyValue(videoTrackPrefix + "Writing_library", ipvTrack.getWritingLibrary());
                doc.setPropertyValue(videoTrackPrefix + "Language", ipvTrack.getLanguage());
                doc.setPropertyValue(videoTrackPrefix + "Encoded_date", ipvTrack.getEncodedDate());
                doc.setPropertyValue(videoTrackPrefix + "Tagged_date", ipvTrack.getTaggedDate());
                doc.setPropertyValue(videoTrackPrefix + "Color_primaries", ipvTrack.getColorPrimaries());
                doc.setPropertyValue(videoTrackPrefix + "Transfer_characteristics",
                        ipvTrack.getTransferCharacteristics());
                doc.setPropertyValue(videoTrackPrefix + "Matrix_coefficients", ipvTrack.getMatrixCoefficients());

            }

            if ("Audio".equals(ipvTrack.getType())) {
                doc.setPropertyValue(audioTrackPrefix + "Format_settings__Endianness",
                        ipvTrack.getFormatSettingsEndianness());
                doc.setPropertyValue(audioTrackPrefix + "Format_settings__Sign", ipvTrack.getFormatSettingsSign());
                doc.setPropertyValue(audioTrackPrefix + "Codec_ID", ipvTrack.getCodecID());
                doc.setPropertyValue(audioTrackPrefix + "Duration", ipvTrack.getDuration());
                doc.setPropertyValue(audioTrackPrefix + "Bit_rate_mode", ipvTrack.getBitRateMode());
                doc.setPropertyValue(audioTrackPrefix + "Bit_rate", ipvTrack.getBitRate());
                doc.setPropertyValue(audioTrackPrefix + "Channel_s_", ipvTrack.getChannelS());
                doc.setPropertyValue(audioTrackPrefix + "Channel_positions", ipvTrack.getChannelPositions());
                doc.setPropertyValue(audioTrackPrefix + "Sampling_rate", ipvTrack.getSamplingRate());
                doc.setPropertyValue(audioTrackPrefix + "Bit_depth", ipvTrack.getBitDepth());
                doc.setPropertyValue(audioTrackPrefix + "Stream_size", ipvTrack.getStreamSize());
                doc.setPropertyValue(audioTrackPrefix + "Language", ipvTrack.getLanguage());
                doc.setPropertyValue(audioTrackPrefix + "Encoded_date", ipvTrack.getEncodedDate());
                doc.setPropertyValue(audioTrackPrefix + "Tagged_date", ipvTrack.getTaggedDate());

            }
            if ("Other".equals(ipvTrack.getType())) {
                doc.setPropertyValue(otherTrackPrefix + "Type", ipvTrack.getType());
                doc.setPropertyValue(otherTrackPrefix + "Format", ipvTrack.getFormat());
                doc.setPropertyValue(otherTrackPrefix + "Duration", ipvTrack.getDuration());
                doc.setPropertyValue(otherTrackPrefix + "Time_code_of_first_frame", ipvTrack.getTimeCodeOfFirstFrame());
                doc.setPropertyValue(otherTrackPrefix + "Time_code__striped", ipvTrack.getTimeCodeStriped());
                doc.setPropertyValue(otherTrackPrefix + "Language", ipvTrack.getLanguage());
                doc.setPropertyValue(otherTrackPrefix + "Encoded_date", ipvTrack.getEncodedDate());
                doc.setPropertyValue(otherTrackPrefix + "Tagged_date", ipvTrack.getTaggedDate());
            }

        }

    }

    public void setCuratorId(String curatorId) {
        doc.setPropertyValue(curatorIdXpath, curatorId);

    }

    public String getCuratorId() {
        return (String) doc.getPropertyValue(curatorIdXpath);
    }

    // Basic methods
    //
    // Note that we voluntarily expose only a subset of the DocumentModel API in this adapter.
    // You may wish to complete it without exposing everything!
    // For instance to avoid letting people change the document state using your adapter,
    // because this would be handled through workflows / buttons / events in your application.
    //
    public void create() {
        CoreSession session = doc.getCoreSession();
        session.createDocument(doc);
    }

    public void save() {
        CoreSession session = doc.getCoreSession();
        session.saveDocument(doc);
    }

    public DocumentRef getParentRef() {
        return doc.getParentRef();
    }

    // Technical properties retrieval
    public String getId() {
        return doc.getId();
    }

    public String getName() {
        return doc.getName();
    }

    public String getPath() {
        return doc.getPathAsString();
    }

    public String getState() {
        return doc.getCurrentLifeCycleState();
    }
}
