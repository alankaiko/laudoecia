/*
 * ENCODING_VIDEO.java
 *
 * Created on 29/08/2011, 10:28:31
 */
package com.ic.projects.laudoecia.view.captura;

/**
 *
 * @author Amsterdam Luís <al@instrumentalcientifico.com.br>
 */
public enum ENCODING_VIDEO
{
    CINEPAK("cvid"),
    JPEG("jpeg"),
    JPEG_RTP("jpeg/rtp"),
    MPEG("mpeg"),
    MPEG_RTP("mpeg/rtp"),
    H261("h261"),
    H261_RTP("h261/rtp"),
    H263("h263"),
    H263_RTP("h263/rtp"),
    H263_1998_RTP("h263-1998/rtp"),
    RGB("rgb"),
    YUV("yuv"),
    IRGB("irgb"),
    SMC("smc"),
    RLE("rle"),
    RPZA("rpza"),
    MJPG("mjpg"),
    MJPA("mjpa"),
    MJPB("mjpb"),
    INDEO32("iv32"),
    INDEO41("iv41"),
    INDEO50("iv50");

    private String desc;

    private ENCODING_VIDEO (String desc)
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
        for (ENCODING_VIDEO encoding_video : ENCODING_VIDEO.values())
        {
            if (encoding_video.getDesc().equals(desc))
            {
                return true;
            }
        }
        return false;
    }

}
