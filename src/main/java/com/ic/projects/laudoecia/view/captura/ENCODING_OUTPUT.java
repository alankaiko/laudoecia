/*
 * ENCODING_OUTPUT.java
 *
 * Created on 29/08/2011, 10:28:31
 */
package com.ic.projects.laudoecia.view.captura;

/**
 *
 * @author Amsterdam Luís <al@instrumentalcientifico.com.br>
 */
public enum ENCODING_OUTPUT
{
    VIDEO_QUICKTIME("video.quicktime"),
    VIDEO_X_MSVIDEO("video.x_msvideo"),
    VIDEO_MPEG("video.mpeg"),
    VIDEO_VIVO("video.vivo"),
    AUDIO_BASIC("audio.basic"),
    AUDIO_X_WAV("audio.x_wav"),
    AUDIO_X_AIFF("audio.x_aiff"),
    AUDIO_MIDI("audio.midi"),
    AUDIO_RMF("audio.rmf"),
    AUDIO_X_GSM("audio.x_gsm"),
    AUDIO_MPEG("audio.mpeg");

    private String desc;

    private ENCODING_OUTPUT (String desc)
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
    
    public static boolean validarDesc (String desc)
    {
        for (ENCODING_OUTPUT encoding_output : ENCODING_OUTPUT.values())
        {
            if (encoding_output.getDesc().equals(desc))
            {
                return true;
            }
        }
        return false;
    }

}
