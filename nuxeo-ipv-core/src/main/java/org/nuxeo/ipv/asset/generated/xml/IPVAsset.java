//
// This file was generated by the JavaTM Architecture for XML Binding(JAXB) Reference Implementation, v2.2.8-b130911.1802 
// See <a href="http://java.sun.com/xml/jaxb">http://java.sun.com/xml/jaxb</a> 
// Any modifications to this file will be lost upon recompilation of the source schema. 
// Generated on: 2017.08.03 at 04:04:40 PM PDT 
//


package org.nuxeo.ipv.asset.generated.xml;

import java.util.ArrayList;
import java.util.List;
import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlAttribute;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Java class for anonymous complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType>
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;sequence>
 *         &lt;element name="track" maxOccurs="unbounded">
 *           &lt;complexType>
 *             &lt;complexContent>
 *               &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *                 &lt;sequence>
 *                   &lt;element name="Complete_name" type="{http://www.w3.org/2001/XMLSchema}string"/>
 *                   &lt;element name="Format" type="{http://www.w3.org/2001/XMLSchema}string"/>
 *                   &lt;element name="Format_profile" type="{http://www.w3.org/2001/XMLSchema}string"/>
 *                   &lt;element name="Codec_ID" type="{http://www.w3.org/2001/XMLSchema}string"/>
 *                   &lt;element name="File_size" type="{http://www.w3.org/2001/XMLSchema}string"/>
 *                   &lt;element name="Duration" type="{http://www.w3.org/2001/XMLSchema}string"/>
 *                   &lt;element name="Overall_bit_rate_mode" type="{http://www.w3.org/2001/XMLSchema}string"/>
 *                   &lt;element name="Overall_bit_rate" type="{http://www.w3.org/2001/XMLSchema}string"/>
 *                   &lt;element name="Encoded_date" type="{http://www.w3.org/2001/XMLSchema}string"/>
 *                   &lt;element name="Tagged_date" type="{http://www.w3.org/2001/XMLSchema}string"/>
 *                   &lt;element name="Writing_library" type="{http://www.w3.org/2001/XMLSchema}string"/>
 *                   &lt;element name="Media_UUID" type="{http://www.w3.org/2001/XMLSchema}string"/>
 *                 &lt;/sequence>
 *                 &lt;attribute name="type" type="{http://www.w3.org/2001/XMLSchema}string" />
 *               &lt;/restriction>
 *             &lt;/complexContent>
 *           &lt;/complexType>
 *         &lt;/element>
 *       &lt;/sequence>
 *     &lt;/restriction>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "", propOrder = {
    "track"
})
@XmlRootElement(name = "File")
public class IPVAsset {

    @XmlElement(required = true)
    protected List<IPVAsset.Track> track;

    /**
     * Gets the value of the track property.
     * 
     * <p>
     * This accessor method returns a reference to the live list,
     * not a snapshot. Therefore any modification you make to the
     * returned list will be present inside the JAXB object.
     * This is why there is not a <CODE>set</CODE> method for the track property.
     * 
     * <p>
     * For example, to add a new item, do as follows:
     * <pre>
     *    getTrack().add(newItem);
     * </pre>
     * 
     * 
     * <p>
     * Objects of the following type(s) are allowed in the list
     * {@link IPVAsset.Track }
     * 
     * 
     */
    public List<IPVAsset.Track> getTrack() {
        if (track == null) {
            track = new ArrayList<IPVAsset.Track>();
        }
        return this.track;
    }


    /**
     * <p>Java class for anonymous complex type.
     * 
     * <p>The following schema fragment specifies the expected content contained within this class.
     * 
     * <pre>
     * &lt;complexType>
     *   &lt;complexContent>
     *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
     *       &lt;sequence>
     *         &lt;element name="Complete_name" type="{http://www.w3.org/2001/XMLSchema}string"/>
     *         &lt;element name="Format" type="{http://www.w3.org/2001/XMLSchema}string"/>
     *         &lt;element name="Format_profile" type="{http://www.w3.org/2001/XMLSchema}string"/>
     *         &lt;element name="Codec_ID" type="{http://www.w3.org/2001/XMLSchema}string"/>
     *         &lt;element name="File_size" type="{http://www.w3.org/2001/XMLSchema}string"/>
     *         &lt;element name="Duration" type="{http://www.w3.org/2001/XMLSchema}string"/>
     *         &lt;element name="Overall_bit_rate_mode" type="{http://www.w3.org/2001/XMLSchema}string"/>
     *         &lt;element name="Overall_bit_rate" type="{http://www.w3.org/2001/XMLSchema}string"/>
     *         &lt;element name="Encoded_date" type="{http://www.w3.org/2001/XMLSchema}string"/>
     *         &lt;element name="Tagged_date" type="{http://www.w3.org/2001/XMLSchema}string"/>
     *         &lt;element name="Writing_library" type="{http://www.w3.org/2001/XMLSchema}string"/>
     *         &lt;element name="Media_UUID" type="{http://www.w3.org/2001/XMLSchema}string"/>
     *       &lt;/sequence>
     *       &lt;attribute name="type" type="{http://www.w3.org/2001/XMLSchema}string" />
     *     &lt;/restriction>
     *   &lt;/complexContent>
     * &lt;/complexType>
     * </pre>
     * 
     * 
     */
    @XmlAccessorType(XmlAccessType.FIELD)
    @XmlType(name = "", propOrder = {
        "completeName",
        "format",
        "formatProfile",
        "codecID",
        "fileSize",
        "duration",
        "overallBitRateMode",
        "overallBitRate",
        "encodedDate",
        "taggedDate",
        "writingLibrary",
        "mediaUUID"
    })
    public static class Track {

        @XmlElement(name = "Complete_name", required = true)
        protected String completeName;
        @XmlElement(name = "Format", required = true)
        protected String format;
        @XmlElement(name = "Format_profile", required = true)
        protected String formatProfile;
        @XmlElement(name = "Codec_ID", required = true)
        protected String codecID;
        @XmlElement(name = "File_size", required = true)
        protected String fileSize;
        @XmlElement(name = "Duration", required = true)
        protected String duration;
        @XmlElement(name = "Overall_bit_rate_mode", required = true)
        protected String overallBitRateMode;
        @XmlElement(name = "Overall_bit_rate", required = true)
        protected String overallBitRate;
        @XmlElement(name = "Encoded_date", required = true)
        protected String encodedDate;
        @XmlElement(name = "Tagged_date", required = true)
        protected String taggedDate;
        @XmlElement(name = "Writing_library", required = true)
        protected String writingLibrary;
        @XmlElement(name = "Media_UUID", required = true)
        protected String mediaUUID;
        @XmlAttribute(name = "type")
        protected String type;

        /**
         * Gets the value of the completeName property.
         * 
         * @return
         *     possible object is
         *     {@link String }
         *     
         */
        public String getCompleteName() {
            return completeName;
        }

        /**
         * Sets the value of the completeName property.
         * 
         * @param value
         *     allowed object is
         *     {@link String }
         *     
         */
        public void setCompleteName(String value) {
            this.completeName = value;
        }

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
         * Gets the value of the formatProfile property.
         * 
         * @return
         *     possible object is
         *     {@link String }
         *     
         */
        public String getFormatProfile() {
            return formatProfile;
        }

        /**
         * Sets the value of the formatProfile property.
         * 
         * @param value
         *     allowed object is
         *     {@link String }
         *     
         */
        public void setFormatProfile(String value) {
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
         * Gets the value of the fileSize property.
         * 
         * @return
         *     possible object is
         *     {@link String }
         *     
         */
        public String getFileSize() {
            return fileSize;
        }

        /**
         * Sets the value of the fileSize property.
         * 
         * @param value
         *     allowed object is
         *     {@link String }
         *     
         */
        public void setFileSize(String value) {
            this.fileSize = value;
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
         * Gets the value of the overallBitRateMode property.
         * 
         * @return
         *     possible object is
         *     {@link String }
         *     
         */
        public String getOverallBitRateMode() {
            return overallBitRateMode;
        }

        /**
         * Sets the value of the overallBitRateMode property.
         * 
         * @param value
         *     allowed object is
         *     {@link String }
         *     
         */
        public void setOverallBitRateMode(String value) {
            this.overallBitRateMode = value;
        }

        /**
         * Gets the value of the overallBitRate property.
         * 
         * @return
         *     possible object is
         *     {@link String }
         *     
         */
        public String getOverallBitRate() {
            return overallBitRate;
        }

        /**
         * Sets the value of the overallBitRate property.
         * 
         * @param value
         *     allowed object is
         *     {@link String }
         *     
         */
        public void setOverallBitRate(String value) {
            this.overallBitRate = value;
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
         * Gets the value of the mediaUUID property.
         * 
         * @return
         *     possible object is
         *     {@link String }
         *     
         */
        public String getMediaUUID() {
            return mediaUUID;
        }

        /**
         * Sets the value of the mediaUUID property.
         * 
         * @param value
         *     allowed object is
         *     {@link String }
         *     
         */
        public void setMediaUUID(String value) {
            this.mediaUUID = value;
        }

        /**
         * Gets the value of the type property.
         * 
         * @return
         *     possible object is
         *     {@link String }
         *     
         */
        public String getType() {
            return type;
        }

        /**
         * Sets the value of the type property.
         * 
         * @param value
         *     allowed object is
         *     {@link String }
         *     
         */
        public void setType(String value) {
            this.type = value;
        }

    }

}
