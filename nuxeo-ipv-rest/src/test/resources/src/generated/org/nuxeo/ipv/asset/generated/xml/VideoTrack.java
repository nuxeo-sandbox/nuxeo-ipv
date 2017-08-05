//
// This file was generated by the JavaTM Architecture for XML Binding(JAXB) Reference Implementation, v2.2.8-b130911.1802 
// See <a href="http://java.sun.com/xml/jaxb">http://java.sun.com/xml/jaxb</a> 
// Any modifications to this file will be lost upon recompilation of the source schema. 
// Generated on: 2017.08.04 at 04:48:12 PM PDT 
//


package org.nuxeo.ipv.asset.generated.xml;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Java class for videoTrack complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType name="videoTrack">
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;sequence>
 *         &lt;element name="Format" type="{http://www.w3.org/2001/XMLSchema}string"/>
 *         &lt;element name="Format_version" type="{http://www.w3.org/2001/XMLSchema}string"/>
 *         &lt;element name="Format_profile" type="{http://www.w3.org/2001/XMLSchema}short"/>
 *         &lt;element name="Codec_ID" type="{http://www.w3.org/2001/XMLSchema}string"/>
 *         &lt;element name="Duration" type="{http://www.w3.org/2001/XMLSchema}string"/>
 *         &lt;element name="Bit_rate_mode" type="{http://www.w3.org/2001/XMLSchema}string"/>
 *         &lt;element name="Bit_rate" type="{http://www.w3.org/2001/XMLSchema}string"/>
 *         &lt;element name="Width" type="{http://www.w3.org/2001/XMLSchema}string"/>
 *         &lt;element name="Clean_aperture_width" type="{http://www.w3.org/2001/XMLSchema}string"/>
 *         &lt;element name="Height" type="{http://www.w3.org/2001/XMLSchema}string"/>
 *         &lt;element name="Clean_aperture_height" type="{http://www.w3.org/2001/XMLSchema}string"/>
 *         &lt;element name="Display_aspect_ratio" type="{http://www.w3.org/2001/XMLSchema}string"/>
 *         &lt;element name="Clean_aperture_display_aspect_ratio" type="{http://www.w3.org/2001/XMLSchema}string"/>
 *         &lt;element name="Frame_rate_mode" type="{http://www.w3.org/2001/XMLSchema}string"/>
 *         &lt;element name="Frame_rate" type="{http://www.w3.org/2001/XMLSchema}string"/>
 *         &lt;element name="Chroma_subsampling" type="{http://www.w3.org/2001/XMLSchema}string"/>
 *         &lt;element name="Scan_type" type="{http://www.w3.org/2001/XMLSchema}string"/>
 *         &lt;element name="Bits__Pixel_Frame_" type="{http://www.w3.org/2001/XMLSchema}float"/>
 *         &lt;element name="Stream_size" type="{http://www.w3.org/2001/XMLSchema}string"/>
 *         &lt;element name="Writing_library" type="{http://www.w3.org/2001/XMLSchema}string"/>
 *         &lt;element name="Language" type="{http://www.w3.org/2001/XMLSchema}string"/>
 *         &lt;element name="Encoded_date" type="{http://www.w3.org/2001/XMLSchema}string"/>
 *         &lt;element name="Tagged_date" type="{http://www.w3.org/2001/XMLSchema}string"/>
 *         &lt;element name="Color_primaries" type="{http://www.w3.org/2001/XMLSchema}string"/>
 *         &lt;element name="Transfer_characteristics" type="{http://www.w3.org/2001/XMLSchema}string"/>
 *         &lt;element name="Matrix_coefficients" type="{http://www.w3.org/2001/XMLSchema}string"/>
 *       &lt;/sequence>
 *     &lt;/restriction>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "videoTrack", propOrder = {
    "format",
    "formatVersion",
    "formatProfile",
    "codecID",
    "duration",
    "bitRateMode",
    "bitRate",
    "width",
    "cleanApertureWidth",
    "height",
    "cleanApertureHeight",
    "displayAspectRatio",
    "cleanApertureDisplayAspectRatio",
    "frameRateMode",
    "frameRate",
    "chromaSubsampling",
    "scanType",
    "bitsPixelFrame",
    "streamSize",
    "writingLibrary",
    "language",
    "encodedDate",
    "taggedDate",
    "colorPrimaries",
    "transferCharacteristics",
    "matrixCoefficients"
})
public class VideoTrack {

    @XmlElement(name = "Format", required = true)
    protected String format;
    @XmlElement(name = "Format_version", required = true)
    protected String formatVersion;
    @XmlElement(name = "Format_profile")
    protected short formatProfile;
    @XmlElement(name = "Codec_ID", required = true)
    protected String codecID;
    @XmlElement(name = "Duration", required = true)
    protected String duration;
    @XmlElement(name = "Bit_rate_mode", required = true)
    protected String bitRateMode;
    @XmlElement(name = "Bit_rate", required = true)
    protected String bitRate;
    @XmlElement(name = "Width", required = true)
    protected String width;
    @XmlElement(name = "Clean_aperture_width", required = true)
    protected String cleanApertureWidth;
    @XmlElement(name = "Height", required = true)
    protected String height;
    @XmlElement(name = "Clean_aperture_height", required = true)
    protected String cleanApertureHeight;
    @XmlElement(name = "Display_aspect_ratio", required = true)
    protected String displayAspectRatio;
    @XmlElement(name = "Clean_aperture_display_aspect_ratio", required = true)
    protected String cleanApertureDisplayAspectRatio;
    @XmlElement(name = "Frame_rate_mode", required = true)
    protected String frameRateMode;
    @XmlElement(name = "Frame_rate", required = true)
    protected String frameRate;
    @XmlElement(name = "Chroma_subsampling", required = true)
    protected String chromaSubsampling;
    @XmlElement(name = "Scan_type", required = true)
    protected String scanType;
    @XmlElement(name = "Bits__Pixel_Frame_")
    protected float bitsPixelFrame;
    @XmlElement(name = "Stream_size", required = true)
    protected String streamSize;
    @XmlElement(name = "Writing_library", required = true)
    protected String writingLibrary;
    @XmlElement(name = "Language", required = true)
    protected String language;
    @XmlElement(name = "Encoded_date", required = true)
    protected String encodedDate;
    @XmlElement(name = "Tagged_date", required = true)
    protected String taggedDate;
    @XmlElement(name = "Color_primaries", required = true)
    protected String colorPrimaries;
    @XmlElement(name = "Transfer_characteristics", required = true)
    protected String transferCharacteristics;
    @XmlElement(name = "Matrix_coefficients", required = true)
    protected String matrixCoefficients;

    /**
     * Gets the value of the format property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getFormat() {
        return format;
    }

    /**
     * Sets the value of the format property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setFormat(String value) {
        this.format = value;
    }

    /**
     * Gets the value of the formatVersion property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getFormatVersion() {
        return formatVersion;
    }

    /**
     * Sets the value of the formatVersion property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setFormatVersion(String value) {
        this.formatVersion = value;
    }

    /**
     * Gets the value of the formatProfile property.
     * 
     */
    public short getFormatProfile() {
        return formatProfile;
    }

    /**
     * Sets the value of the formatProfile property.
     * 
     */
    public void setFormatProfile(short value) {
        this.formatProfile = value;
    }

    /**
     * Gets the value of the codecID property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getCodecID() {
        return codecID;
    }

    /**
     * Sets the value of the codecID property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setCodecID(String value) {
        this.codecID = value;
    }

    /**
     * Gets the value of the duration property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getDuration() {
        return duration;
    }

    /**
     * Sets the value of the duration property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setDuration(String value) {
        this.duration = value;
    }

    /**
     * Gets the value of the bitRateMode property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getBitRateMode() {
        return bitRateMode;
    }

    /**
     * Sets the value of the bitRateMode property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setBitRateMode(String value) {
        this.bitRateMode = value;
    }

    /**
     * Gets the value of the bitRate property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getBitRate() {
        return bitRate;
    }

    /**
     * Sets the value of the bitRate property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setBitRate(String value) {
        this.bitRate = value;
    }

    /**
     * Gets the value of the width property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getWidth() {
        return width;
    }

    /**
     * Sets the value of the width property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setWidth(String value) {
        this.width = value;
    }

    /**
     * Gets the value of the cleanApertureWidth property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getCleanApertureWidth() {
        return cleanApertureWidth;
    }

    /**
     * Sets the value of the cleanApertureWidth property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setCleanApertureWidth(String value) {
        this.cleanApertureWidth = value;
    }

    /**
     * Gets the value of the height property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getHeight() {
        return height;
    }

    /**
     * Sets the value of the height property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setHeight(String value) {
        this.height = value;
    }

    /**
     * Gets the value of the cleanApertureHeight property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getCleanApertureHeight() {
        return cleanApertureHeight;
    }

    /**
     * Sets the value of the cleanApertureHeight property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setCleanApertureHeight(String value) {
        this.cleanApertureHeight = value;
    }

    /**
     * Gets the value of the displayAspectRatio property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getDisplayAspectRatio() {
        return displayAspectRatio;
    }

    /**
     * Sets the value of the displayAspectRatio property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setDisplayAspectRatio(String value) {
        this.displayAspectRatio = value;
    }

    /**
     * Gets the value of the cleanApertureDisplayAspectRatio property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getCleanApertureDisplayAspectRatio() {
        return cleanApertureDisplayAspectRatio;
    }

    /**
     * Sets the value of the cleanApertureDisplayAspectRatio property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setCleanApertureDisplayAspectRatio(String value) {
        this.cleanApertureDisplayAspectRatio = value;
    }

    /**
     * Gets the value of the frameRateMode property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getFrameRateMode() {
        return frameRateMode;
    }

    /**
     * Sets the value of the frameRateMode property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setFrameRateMode(String value) {
        this.frameRateMode = value;
    }

    /**
     * Gets the value of the frameRate property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getFrameRate() {
        return frameRate;
    }

    /**
     * Sets the value of the frameRate property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setFrameRate(String value) {
        this.frameRate = value;
    }

    /**
     * Gets the value of the chromaSubsampling property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getChromaSubsampling() {
        return chromaSubsampling;
    }

    /**
     * Sets the value of the chromaSubsampling property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setChromaSubsampling(String value) {
        this.chromaSubsampling = value;
    }

    /**
     * Gets the value of the scanType property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getScanType() {
        return scanType;
    }

    /**
     * Sets the value of the scanType property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setScanType(String value) {
        this.scanType = value;
    }

    /**
     * Gets the value of the bitsPixelFrame property.
     * 
     */
    public float getBitsPixelFrame() {
        return bitsPixelFrame;
    }

    /**
     * Sets the value of the bitsPixelFrame property.
     * 
     */
    public void setBitsPixelFrame(float value) {
        this.bitsPixelFrame = value;
    }

    /**
     * Gets the value of the streamSize property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getStreamSize() {
        return streamSize;
    }

    /**
     * Sets the value of the streamSize property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setStreamSize(String value) {
        this.streamSize = value;
    }

    /**
     * Gets the value of the writingLibrary property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getWritingLibrary() {
        return writingLibrary;
    }

    /**
     * Sets the value of the writingLibrary property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setWritingLibrary(String value) {
        this.writingLibrary = value;
    }

    /**
     * Gets the value of the language property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getLanguage() {
        return language;
    }

    /**
     * Sets the value of the language property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setLanguage(String value) {
        this.language = value;
    }

    /**
     * Gets the value of the encodedDate property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getEncodedDate() {
        return encodedDate;
    }

    /**
     * Sets the value of the encodedDate property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setEncodedDate(String value) {
        this.encodedDate = value;
    }

    /**
     * Gets the value of the taggedDate property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getTaggedDate() {
        return taggedDate;
    }

    /**
     * Sets the value of the taggedDate property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setTaggedDate(String value) {
        this.taggedDate = value;
    }

    /**
     * Gets the value of the colorPrimaries property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getColorPrimaries() {
        return colorPrimaries;
    }

    /**
     * Sets the value of the colorPrimaries property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setColorPrimaries(String value) {
        this.colorPrimaries = value;
    }

    /**
     * Gets the value of the transferCharacteristics property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getTransferCharacteristics() {
        return transferCharacteristics;
    }

    /**
     * Sets the value of the transferCharacteristics property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setTransferCharacteristics(String value) {
        this.transferCharacteristics = value;
    }

    /**
     * Gets the value of the matrixCoefficients property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getMatrixCoefficients() {
        return matrixCoefficients;
    }

    /**
     * Sets the value of the matrixCoefficients property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setMatrixCoefficients(String value) {
        this.matrixCoefficients = value;
    }

}