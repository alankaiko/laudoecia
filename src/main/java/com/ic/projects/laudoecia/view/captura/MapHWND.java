/*
 * MapHWND.java
 *
 * Created on 20/08/2012, 16:49:43
 */
package com.ic.projects.laudoecia.view.captura;

import com.sun.jna.Pointer;
import com.sun.jna.win32.StdCallLibrary;
import com.sun.jna.win32.W32APIFunctionMapper;
import com.sun.jna.win32.W32APITypeMapper;
import java.util.HashMap;
import java.util.Map;

@SuppressWarnings({"rawtypes", "unchecked"})
interface MapHWND extends StdCallLibrary
{
    
    Map UNICODE_OPTIONS = new HashMap()
    {
        
        {
            put(OPTION_TYPE_MAPPER, W32APITypeMapper.UNICODE);
            put(OPTION_FUNCTION_MAPPER, W32APIFunctionMapper.UNICODE);
        }

    };

    Map ASCII_OPTIONS = new HashMap()
    {
        
        {
            put(OPTION_TYPE_MAPPER, W32APITypeMapper.ASCII);
            put(OPTION_FUNCTION_MAPPER, W32APIFunctionMapper.ASCII);
        }

    };

    Map DEFAULT_OPTIONS = Boolean.getBoolean("w32.ascii") ? ASCII_OPTIONS
                          : UNICODE_OPTIONS;

    HANDLE INVALID_HANDLE_VALUE = new HANDLE()
    {
        
        {
            super.setPointer(Pointer.createConstant(-1));
        }

        @Override
        public void setPointer (Pointer p)
        {
            throw new UnsupportedOperationException("Immutable reference");
        }

    };

}
