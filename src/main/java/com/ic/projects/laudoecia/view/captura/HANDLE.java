/*
 * HANDLE.java
 *
 * Created on 20/08/2012, 17:53:52
 */

package com.ic.projects.laudoecia.view.captura;

import com.sun.jna.FromNativeContext;
import com.sun.jna.PointerType;

/**
 *
 * @author Amsterdam Luís <al@instrumentalcientifico.com.br>
 */
class HANDLE extends PointerType
{

    @Override
    public Object fromNative (Object nativeValue, FromNativeContext context)
    {
        Object o = super.fromNative(nativeValue, context);
        if (MapHWND.INVALID_HANDLE_VALUE.equals(o))
        {
            return MapHWND.INVALID_HANDLE_VALUE;
        }
        return o;
    }

}
