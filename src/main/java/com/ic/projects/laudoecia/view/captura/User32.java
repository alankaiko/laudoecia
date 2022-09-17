/*
 * User32.java
 *
 * Created on 20/08/2012, 16:52:59
 */
package com.ic.projects.laudoecia.view.captura;

import com.sun.jna.win32.StdCallLibrary;

interface User32 extends StdCallLibrary, MapHWND
{
    
    boolean DestroyWindow (int hndw);

    boolean ShowWindow (long hWnd, int nCmdShow);

    HWND FindWindow (String winClass, String title);

    int SetWindowPos (
            int hwnd,
            int hWndInsertAfter,
            int x,
            int y,
            int cx,
            int cy,
            int wFlags);

    int SendMessageA (
            int hwnd,
            int wMsg,
            int wParam,
            Object lParam);

}
