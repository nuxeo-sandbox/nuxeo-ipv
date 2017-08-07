package org.nuxeo.ipv.adapter;

import java.io.Serializable;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.xml.bind.annotation.XmlElement;

import org.nuxeo.ecm.core.api.CoreSession;
import org.nuxeo.ecm.core.api.DocumentModel;
import org.nuxeo.ecm.core.api.DocumentRef;
import org.nuxeo.ipv.asset.generated.xml.IPVXMLAssetMapping;

/**
 *
 */
public class IpvAssetDocAdapter {

    protected final DocumentModel doc;

    public String ipvAssetXpath = "ipv:ipvasset";

    public String generalTrackXpath = "generalTrack";

    public String videoTrackXpath = "videoTrack";

    public String audioTrackXpath = "audioTrack";

    public String otherTrackXpath = "otherTrack";

    public IpvAssetDocAdapter(DocumentModel doc) {
        this.doc = doc;
    }

    public void setIPVAsset(IPVXMLAssetMapping ipvAsset) {
        @SuppressWarnings("unchecked")
        Map<String, Serializable> allTracks = (Map<String, Serializable>) doc.getPropertyValue(ipvAssetXpath);
        List<IPVXMLAssetMapping.Track> ipVTracks = ipvAsset.getTrack();
        for (IPVXMLAssetMapping.Track ipvTrack : ipVTracks) {
            if ("General".equals(ipvTrack.getType())) {
                Map<String, Serializable> track = new HashMap<String, Serializable>();
                track.put("Complete_name", ipvTrack.getCompleteName());
                track.put("Format", ipvTrack.getFormat());
                track.put("Format_profile", ipvTrack.getFormatProfile());
                track.put("Codec_ID", ipvTrack.getCodecID());
                track.put("File_size", ipvTrack.getFileSize());
                track.put("Duration", ipvTrack.getDuration());
                track.put("Overall_bit_rate_mode", ipvTrack.getOverallBitRateMode());
                track.put("Overall_bit_rate", ipvTrack.getOverallBitRate());
                track.put("Encoded_date", ipvTrack.getEncodedDate());
                track.put("Tagged_date", ipvTrack.getTaggedDate());
                track.put("Writing_library", ipvTrack.getWritingLibrary());
                track.put("Media_UUID", ipvTrack.getMediaUUID());
                allTracks.put(generalTrackXpath, (Serializable) track);
            }
            if ("Video".equals(ipvTrack.getType())) {
                Map<String, Serializable> track = new HashMap<String, Serializable>();
                track.put("Format", ipvTrack.getFormat());
                track.put("Format_version", ipvTrack.getFormatVersion());
                track.put("Format_profile", ipvTrack.getFormatProfile());
                track.put("Codec_ID", ipvTrack.getCodecID());
                track.put("Duration", ipvTrack.getDuration());
                track.put("Bit_rate_mode", ipvTrack.getBitRateMode());
                track.put("Bit_rate", ipvTrack.getBitRate());
                track.put("Width", ipvTrack.getWidth());
                track.put("Clean_aperture_width", ipvTrack.getCleanApertureWidth());
                track.put("Height", ipvTrack.getHeight());
                track.put("Clean_aperture_height", ipvTrack.getCleanApertureHeight());
                track.put("Display_aspect_ratio", ipvTrack.getDisplayAspectRatio());
                track.put("Clean_aperture_display_aspect_ratio", ipvTrack.getCleanApertureDisplayAspectRatio());
                track.put("Frame_rate_mode", ipvTrack.getFrameRateMode());
                track.put("Frame_rate", ipvTrack.getFrameRate());
                track.put("Chroma_subsampling", ipvTrack.getChromaSubsampling());
                track.put("Scan_type", ipvTrack.getScanType());
                track.put("Bits__Pixel_Frame_", ipvTrack.getBitsPixelFrame());
                track.put("Stream_size", ipvTrack.getStreamSize());
                track.put("Writing_library", ipvTrack.getWritingLibrary());
                track.put("Language", ipvTrack.getLanguage());
                track.put("Encoded_date", ipvTrack.getEncodedDate());
                track.put("Tagged_date", ipvTrack.getTaggedDate());
                track.put("Color_primaries", ipvTrack.getColorPrimaries());
                track.put("Transfer_characteristics", ipvTrack.getTransferCharacteristics());
                track.put("Matrix_coefficients", ipvTrack.getMatrixCoefficients());
                allTracks.put(videoTrackXpath, (Serializable) track);

            }

            if ("Audio".equals(ipvTrack.getType())) {
                Map<String, Serializable> track = new HashMap<String, Serializable>();
                track.put("Format_settings__Endianness", ipvTrack.getFormatSettingsEndianness());
                track.put("Format_settings__Sign", ipvTrack.getFormatSettingsSign());
                track.put("Codec_ID", ipvTrack.getCodecID());
                track.put("Duration", ipvTrack.getDuration());
                track.put("Bit_rate_mode", ipvTrack.getBitRateMode());
                track.put("Bit_rate", ipvTrack.getBitRate());
                track.put("Channel_s_", ipvTrack.getChannelS());
                track.put("Channel_positions", ipvTrack.getChannelPositions());
                track.put("Sampling_rate", ipvTrack.getSamplingRate());
                track.put("Bit_depth", ipvTrack.getBitDepth());
                track.put("Stream_size", ipvTrack.getStreamSize());
                track.put("Language", ipvTrack.getLanguage());
                track.put("Encoded_date", ipvTrack.getEncodedDate());
                track.put("Tagged_date", ipvTrack.getTaggedDate());
                allTracks.put(audioTrackXpath, (Serializable) track);

            }
            if ("Other".equals(ipvTrack.getType())) {

                Map<String, Serializable> track = new HashMap<String, Serializable>();
                track.put("Type", ipvTrack.getType());
                track.put("Format", ipvTrack.getFormat());
                track.put("Duration", ipvTrack.getDuration());
                track.put("Time_code_of_first_frame", ipvTrack.getTimeCodeOfFirstFrame());
                track.put("Time_code__striped", ipvTrack.getTimeCodeStriped());
                track.put("Language", ipvTrack.getLanguage());
                track.put("Encoded_date", ipvTrack.getEncodedDate());
                track.put("Tagged_date", ipvTrack.getTaggedDate());
                
                allTracks.put(otherTrackXpath, (Serializable) track);

            }

        }
        doc.setPropertyValue(ipvAssetXpath, (Serializable) allTracks);

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
