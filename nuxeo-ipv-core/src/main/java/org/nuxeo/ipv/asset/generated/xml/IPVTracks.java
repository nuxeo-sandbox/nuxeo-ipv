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
 * <p>Java class for ipvtraks complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType name="ipvtraks">
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;sequence>
 *         &lt;element name="generalTrack" type="{http://www.nuxeo.org/ecm/schemas/ipv/}generalTrack"/>
 *         &lt;element name="videoTrack" type="{http://www.nuxeo.org/ecm/schemas/ipv/}videoTrack"/>
 *         &lt;element name="audioTrack" type="{http://www.nuxeo.org/ecm/schemas/ipv/}audioTrack"/>
 *         &lt;element name="otherTrack" type="{http://www.nuxeo.org/ecm/schemas/ipv/}otherTrack"/>
 *       &lt;/sequence>
 *     &lt;/restriction>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "ipvtraks", propOrder = {
    "generalTrack",
    "videoTrack",
    "audioTrack",
    "otherTrack"
})
public class IPVTracks {

    @XmlElement(required = true)
    protected GeneralTrack generalTrack;
    @XmlElement(required = true)
    protected VideoTrack videoTrack;
    @XmlElement(required = true)
    protected AudioTrack audioTrack;
    @XmlElement(required = true)
    protected OtherTrack otherTrack;

    /**
     * Gets the value of the generalTrack property.
     * 
     * @return
     *     possible object is
     *     {@link GeneralTrack }
     *     
     */
    public GeneralTrack getGeneralTrack() {
        return generalTrack;
    }

    /**
     * Sets the value of the generalTrack property.
     * 
     * @param value
     *     allowed object is
     *     {@link GeneralTrack }
     *     
     */
    public void setGeneralTrack(GeneralTrack value) {
        this.generalTrack = value;
    }

    /**
     * Gets the value of the videoTrack property.
     * 
     * @return
     *     possible object is
     *     {@link VideoTrack }
     *     
     */
    public VideoTrack getVideoTrack() {
        return videoTrack;
    }

    /**
     * Sets the value of the videoTrack property.
     * 
     * @param value
     *     allowed object is
     *     {@link VideoTrack }
     *     
     */
    public void setVideoTrack(VideoTrack value) {
        this.videoTrack = value;
    }

    /**
     * Gets the value of the audioTrack property.
     * 
     * @return
     *     possible object is
     *     {@link AudioTrack }
     *     
     */
    public AudioTrack getAudioTrack() {
        return audioTrack;
    }

    /**
     * Sets the value of the audioTrack property.
     * 
     * @param value
     *     allowed object is
     *     {@link AudioTrack }
     *     
     */
    public void setAudioTrack(AudioTrack value) {
        this.audioTrack = value;
    }

    /**
     * Gets the value of the otherTrack property.
     * 
     * @return
     *     possible object is
     *     {@link OtherTrack }
     *     
     */
    public OtherTrack getOtherTrack() {
        return otherTrack;
    }

    /**
     * Sets the value of the otherTrack property.
     * 
     * @param value
     *     allowed object is
     *     {@link OtherTrack }
     *     
     */
    public void setOtherTrack(OtherTrack value) {
        this.otherTrack = value;
    }

}
