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
 * <p>Java class for audioTrack complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType name="audioTrack">
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;sequence>
 *         &lt;element name="Format" type="{http://www.w3.org/2001/XMLSchema}string"/>
 *         &lt;element name="Format_settings__Endianness" type="{http://www.w3.org/2001/XMLSchema}string"/>
 *         &lt;element name="Format_settings__Sign" type="{http://www.w3.org/2001/XMLSchema}string"/>
 *         &lt;element name="Codec_ID" type="{http://www.w3.org/2001/XMLSchema}string"/>
 *         &lt;element name="Duration" type="{http://www.w3.org/2001/XMLSchema}string"/>
 *         &lt;element name="Bit_rate_mode" type="{http://www.w3.org/2001/XMLSchema}string"/>
 *         &lt;element name="Bit_rate" type="{http://www.w3.org/2001/XMLSchema}string"/>
 *         &lt;element name="Channel_s_" type="{http://www.w3.org/2001/XMLSchema}string"/>
 *         &lt;element name="Channel_positions" type="{http://www.w3.org/2001/XMLSchema}string"/>
 *         &lt;element name="Sampling_rate" type="{http://www.w3.org/2001/XMLSchema}string"/>
 *         &lt;element name="Bit_depth" type="{http://www.w3.org/2001/XMLSchema}string"/>
 *         &lt;element name="Stream_size" type="{http://www.w3.org/2001/XMLSchema}string"/>
 *         &lt;element name="Language" type="{http://www.w3.org/2001/XMLSchema}string"/>
 *         &lt;element name="Encoded_date" type="{http://www.w3.org/2001/XMLSchema}string"/>
 *         &lt;element name="Tagged_date" type="{http://www.w3.org/2001/XMLSchema}string"/>
 *       &lt;/sequence>
 *     &lt;/restriction>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "audioTrack", propOrder = {
    "format",
    "formatSettingsEndianness",
    "formatSettingsSign",
    "codecID",
    "duration",
    "bitRateMode",
    "bitRate",
    "channelS",
    "channelPositions",
    "samplingRate",
    "bitDepth",
    "streamSize",
    "language",
    "encodedDate",
    "taggedDate"
})
public class AudioTrack {

    @XmlElement(name = "Format", required = true)
    protected String format;
    @XmlElement(name = "Format_settings__Endianness", required = true)
    protected String formatSettingsEndianness;
    @XmlElement(name = "Format_settings__Sign", required = true)
    protected String formatSettingsSign;
    @XmlElement(name = "Codec_ID", required = true)
    protected String codecID;
    @XmlElement(name = "Duration", required = true)
    protected String duration;
    @XmlElement(name = "Bit_rate_mode", required = true)
    protected String bitRateMode;
    @XmlElement(name = "Bit_rate", required = true)
    protected String bitRate;
    @XmlElement(name = "Channel_s_", required = true)
    protected String channelS;
    @XmlElement(name = "Channel_positions", required = true)
    protected String channelPositions;
    @XmlElement(name = "Sampling_rate", required = true)
    protected String samplingRate;
    @XmlElement(name = "Bit_depth", required = true)
    protected String bitDepth;
    @XmlElement(name = "Stream_size", required = true)
    protected String streamSize;
    @XmlElement(name = "Language", required = true)
    protected String language;
    @XmlElement(name = "Encoded_date", required = true)
    protected String encodedDate;
    @XmlElement(name = "Tagged_date", required = true)
    protected String taggedDate;

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
     * Gets the value of the formatSettingsEndianness property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getFormatSettingsEndianness() {
        return formatSettingsEndianness;
    }

    /**
     * Sets the value of the formatSettingsEndianness property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setFormatSettingsEndianness(String value) {
        this.formatSettingsEndianness = value;
    }

    /**
     * Gets the value of the formatSettingsSign property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getFormatSettingsSign() {
        return formatSettingsSign;
    }

    /**
     * Sets the value of the formatSettingsSign property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setFormatSettingsSign(String value) {
        this.formatSettingsSign = value;
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
     * Gets the value of the channelS property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getChannelS() {
        return channelS;
    }

    /**
     * Sets the value of the channelS property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setChannelS(String value) {
        this.channelS = value;
    }

    /**
     * Gets the value of the channelPositions property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getChannelPositions() {
        return channelPositions;
    }

    /**
     * Sets the value of the channelPositions property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setChannelPositions(String value) {
        this.channelPositions = value;
    }

    /**
     * Gets the value of the samplingRate property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getSamplingRate() {
        return samplingRate;
    }

    /**
     * Sets the value of the samplingRate property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setSamplingRate(String value) {
        this.samplingRate = value;
    }

    /**
     * Gets the value of the bitDepth property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getBitDepth() {
        return bitDepth;
    }

    /**
     * Sets the value of the bitDepth property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setBitDepth(String value) {
        this.bitDepth = value;
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

}
