/*
 * ENCODING_AUDIO.java
 *
 * Created on 29/08/2011, 10:28:31
 */
package com.ic.projects.laudoecia.view.captura;

/**
 *
 * @author Amsterdam Luís <al@instrumentalcientifico.com.br>
 */
public enum ENCODING_AUDIO
{
    LINEAR("LINEAR"),
    ULAW("ULAW"),
    ULAW_RTP("ULAW/rtp"),
    ALAW("alaw"),
    IMA4("ima4"),
    IMA4_MS("ima4/ms"),
    MSADPCM("msadpcm"),
    DVI("dvi"),
    DVI_RTP("dvi/rtp"),
    G723("g723"),
    G723_RTP("g723/rtp"),
    G728("g728"),
    G728_RTP("g728/rtp"),
    G729("g729"),
    G729_RTP("g729/rtp"),
    G729A("g729a"),
    G729A_RTP("g729a/rtp"),
    GSM("gsm"),
    GSM_MS("gsm/ms"),
    GSM_RTP("gsm/rtp"),
    MAC3("MAC3"),
    MAC6("MAC6"),
    TRUESPEECH("truespeech"),
    MSNAUDIO("msnaudio"),
    MPEGLAYER3("mpeglayer3"),
    VOXWAREAC8("voxwareac8"),
    VOXWAREAC10("voxwareac10"),
    VOXWAREAC16("voxwareac16"),
    VOXWAREAC20("voxwareac20"),
    VOXWAREMETAVOICE("voxwaremetavoice"),
    VOXWAREMETASOUND("voxwaremetasound"),
    VOXWARERT29H("voxwarert29h"),
    VOXWAREVR12("voxwarevr12"),
    VOXWAREVR18("voxwarevr18"),
    VOXWARETQ40("voxwaretq40"),
    VOXWARETQ60("voxwaretq60"),
    MSRT24("msrt24"),
    MPEGAUDIO("mpegaudio"),
    MPEGAUDIO_RTP("mpegaudio/rtp"),
    DOLBYAC3("dolbyac3");

    private String desc;

    private ENCODING_AUDIO (String desc)
    {
        this.desc = desc;
    }

    public String getDesc ()
    {
        return desc;
    }

    @Override
    public String toString ()
    {
        return desc;
    }

}
