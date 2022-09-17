package com.ic.projects.laudoecia.model.notentities;

import java.io.BufferedReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class SCSIDevice implements java.io.Serializable
{
    private String bus;
    private String target;
    private String lun;
    private String description = "";

    //<editor-fold defaultstate="collapsed" desc="Getters and Setters">

    public String getBus ()
    {
        return bus;
    }

    public void setBus (String bus)
    {
        this.bus = bus;
    }

    public String getDescription ()
    {
        return description;
    }

    public void setDescription (String description)
    {
        this.description = description;
    }

    public String getLun ()
    {
        return lun;
    }

    public void setLun (String lun)
    {
        this.lun = lun;
    }

    public String getTarget ()
    {
        return target;
    }

    public void setTarget (String target)
    {
        this.target = target;
    }

    //</editor-fold>

    private static SCSIDevice createDeviceFromScanbusLine (String s)
    {
        SCSIDevice dev = null;

        if (stringHasDeviceInfo(s))
        {
            dev = new SCSIDevice();
            int begin = 0;
            int end = s.indexOf(',');
            if (end > 0)
            {
                dev.bus = (s.substring(begin, end)).trim();
                begin = end + 1;
                end = s.indexOf(',', begin);
                dev.target = (s.substring(begin, end)).trim();
                begin = end + 1;
                end = s.indexOf('\t', begin);
                dev.lun = (s.substring(begin, end)).trim();
                begin = end;
                begin = s.indexOf(')') + 1;
                end = s.length();
                dev.description = (s.substring(begin, end)).trim();
            }
        }
        return dev;
    }

    private static boolean stringHasDeviceInfo (String line)
    {
        return (java.util.regex.Pattern.matches("\\s*\\d*,\\d*,\\d*\\s*\\d*\\)\\s'.*", line));
    }

    public boolean valid ()
    {
        return bus != null && !bus.isEmpty() && target != null && !target.isEmpty() && lun != null && !lun.isEmpty() && description != null && !description.isEmpty();
    }

    public static List<SCSIDevice> devicesScannedFrom (BufferedReader buffReader)
    {
        String line;
        List<SCSIDevice> devices = new ArrayList<>();

        try
        {
            while ((line = buffReader.readLine()) != null)
            {
                if ((line.length() > 0) && (line.indexOf("scsibus") < 0) && (line.indexOf("*") < 0))
                {
                    SCSIDevice from = createDeviceFromScanbusLine(line.trim());
                    if (from != null && from.valid())
                    {
                        devices.add(from);
                    }
                }
            }
        }
        catch (IOException ie)
        {
            System.out.println(ie);
        }
        return devices;
    }

    @Override
    public String toString ()
    {
        return ("(" + bus + "," + target + "," + lun + ") " + description);
    }

    public static SCSIDevice toSCSIDevice (String dispToString)
    {
        SCSIDevice dev = new SCSIDevice();
        dev.setBus(dispToString.substring(1, 2));
        dev.setTarget(dispToString.substring(3, 4));
        dev.setLun(dispToString.substring(5, 6));
        dev.setDescription(dispToString.substring(8, dispToString.length()));
        return dev.valid() ? dev : null;
    }

    public String deviceString ()
    {
        return ("" + bus + "," + target + "," + lun);
    }

}