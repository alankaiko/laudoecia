/*
 * Avicap32.java
 *
 * Created on 20/08/2012, 16:49:16
 */
package com.ic.projects.laudoecia.view.captura;

import com.sun.jna.win32.StdCallLibrary;

interface Avicap32 extends StdCallLibrary, MapHWND
{
    
    int capCreateCaptureWindowA (
            String lpszWindowName, //Cria a função da Janela captura  
            int dwStye, //estilo da janela  
            int x, //..  
            int y, //..  
            int nWidth, //..  
            int nHeight, //posição janela e tamanho  
            int hWndParent, //identificador da janela pai  
            int nID); //janela ID  

    boolean capGetDriverDescription (
            int wDriverIndex,
            String lpszName,
            int cbName,
            String lpszVer,
            int cbVer);
    
    //********************************* Constantes ********************************  
    
    short WM_USER = 1024;
    int WM_CAP_START = WM_USER;
    int WS_CHILD = 0x40000000;
    int WS_VISIBLE = 0x10000000;
    int SWP_NOZORDER = 0x4;
    int HWND_BOTTOM = 1;
    int SWP_NOMOVE = 0x2;
    
    int WM_CAP_GET_FRAME = 1084;

    // Defines start of the message range  
    int WM_CAP_GET_CAPSTREAMPTR = (WM_CAP_START + 1);
    int WM_CAP_SET_CALLBACK_ERROR = (WM_CAP_START + 2);
    int WM_CAP_SET_CALLBACK_STATUS = (WM_CAP_START + 3);
    int WM_CAP_SET_CALLBACK_YIELD = (WM_CAP_START + 4);
    int WM_CAP_SET_CALLBACK_FRAME = (WM_CAP_START + 5);
    int WM_CAP_SET_CALLBACK_VIDEOSTREAM = (WM_CAP_START + 6);
    int WM_CAP_SET_CALLBACK_WAVESTREAM = (WM_CAP_START + 7);
    int WM_CAP_GET_USER_DATA = (WM_CAP_START + 8);
    int WM_CAP_SET_USER_DATA = (WM_CAP_START + 9);
    int WM_CAP_DRIVER_CONNECT = 0x40a;//(WM_CAP_START+  10);    
    int WM_CAP_DRIVER_DISCONNECT = (WM_CAP_START + 11);
    int WM_CAP_DRIVER_GET_NAME = (WM_CAP_START + 12);
    int WM_CAP_DRIVER_GET_VERSION = (WM_CAP_START + 13);
    int WM_CAP_DRIVER_GET_CAPS = (WM_CAP_START + 14);
    int WM_CAP_FILE_SET_CAPTURE_FILE = (WM_CAP_START + 20);
    int WM_CAP_FILE_GET_CAPTURE_FILE = (WM_CAP_START + 21);
    int WM_CAP_FILE_ALLOCATE = (WM_CAP_START + 22);
    int WM_CAP_FILE_SAVEAS = (WM_CAP_START + 23);
    int WM_CAP_FILE_SET_INFOCHUNK = (WM_CAP_START + 24);
    int WM_CAP_FILE_SAVEDIB = (WM_CAP_START + 25);
    int WM_CAP_EDIT_COPY = (WM_CAP_START + 30);
    int WM_CAP_SET_AUDIOFORMAT = (WM_CAP_START + 35);
    int WM_CAP_GET_AUDIOFORMAT = (WM_CAP_START + 36);
    int WM_CAP_DLG_VIDEOFORMAT = (WM_CAP_START + 41);
    int WM_CAP_DLG_VIDEOSOURCE = (WM_CAP_START + 42);
    int WM_CAP_DLG_VIDEODISPLAY = (WM_CAP_START + 43);
    int WM_CAP_GET_VIDEOFORMAT = (WM_CAP_START + 44);
    int WM_CAP_SET_VIDEOFORMAT = (WM_CAP_START + 45);
    int WM_CAP_DLG_VIDEOCOMPRESSION = (WM_CAP_START + 46);
    int WM_CAP_SET_PREVIEW = 0x432;//(WM_CAP_START+  50);    
    int WM_CAP_SET_OVERLAY = (WM_CAP_START + 51);
    int WM_CAP_SET_PREVIEWRATE = 0x434;//(WM_CAP_START+  52);    
    int WM_CAP_SET_SCALE = 0x435;//(WM_CAP_START+  53);    
    int WM_CAP_GET_STATUS = (WM_CAP_START + 54);
    int WM_CAP_SET_SCROLL = (WM_CAP_START + 55);
    int WM_CAP_GRAB_FRAME = (WM_CAP_START + 60);
    int WM_CAP_GRAB_FRAME_NOSTOP = (WM_CAP_START + 61);
    int WM_CAP_SEQUENCE = (WM_CAP_START + 62);
    int WM_CAP_SEQUENCE_NOFILE = (WM_CAP_START + 63);
    int WM_CAP_SET_SEQUENCE_SETUP = (WM_CAP_START + 64);
    int WM_CAP_GET_SEQUENCE_SETUP = (WM_CAP_START + 65);
    int WM_CAP_SET_MCI_DEVICE = (WM_CAP_START + 66);
    int WM_CAP_GET_MCI_DEVICE = (WM_CAP_START + 67);
    int WM_CAP_STOP = (WM_CAP_START + 68);
    int WM_CAP_ABORT = (WM_CAP_START + 69);
    int WM_CAP_SINGLE_FRAME_OPEN = (WM_CAP_START + 70);
    int WM_CAP_SINGLE_FRAME_CLOSE = (WM_CAP_START + 71);
    int WM_CAP_SINGLE_FRAME = (WM_CAP_START + 72);
    int WM_CAP_PAL_OPEN = (WM_CAP_START + 80);
    int WM_CAP_PAL_SAVE = (WM_CAP_START + 81);
    int WM_CAP_PAL_PASTE = (WM_CAP_START + 82);
    int WM_CAP_PAL_AUTOCREATE = (WM_CAP_START + 83);
    int WM_CAP_PAL_MANUALCREATE = (WM_CAP_START + 84);

    // Following added post VFW 1.1  
    int WM_CAP_SET_CALLBACK_CAPCONTROL = (WM_CAP_START + 90);

    // Defines end of the message range  
    int WM_CAP_END = WM_CAP_SET_CALLBACK_CAPCONTROL;

    int IDS_CAP_BEGIN = 300; //(* "Capture Start" *)  
    int IDS_CAP_END = 301; //(* "Capture End" *)   
    int IDS_CAP_INFO = 401; //(* "%s" *)  
    int IDS_CAP_OUTOFMEM = 402; //(* "Out of memory" *)  
    int IDS_CAP_FILEEXISTS = 403; //(* "File '%s' exists -- overwrite it?" *)  
    int IDS_CAP_ERRORPALOPEN = 404; //(* "Error opening palette '%s'" *)  
    int IDS_CAP_ERRORPALSAVE = 405; //(* "Error saving palette '%s'" *)  
    int IDS_CAP_ERRORDIBSAVE = 406; //(* "Error saving frame '%s'" *)  
    int IDS_CAP_DEFAVIEXT = 407; //(* "avi" *)  
    int IDS_CAP_DEFPALEXT = 408; //(* "pal" *)  
    int IDS_CAP_CANTOPEN = 409; //(* "Cannot open '%s'" *)  
    int IDS_CAP_SEQ_MSGSTART = 410; //(* "Select OK to start capture\nof video sequence\nto %s." *)  
    int IDS_CAP_SEQ_MSGSTOP = 411; //(* "Hit ESCAPE or click to end capture" *)   
    int IDS_CAP_VIDEDITERR = 412; //(* "An error occurred while trying to run VidEdit." *)  
    int IDS_CAP_READONLYFILE = 413; //(* "The file '%s' is a read-only file." *)  
    int IDS_CAP_WRITEERROR = 414; //(* "Unable to write to file '%s'.\nDisk may be full." *)  
    int IDS_CAP_NODISKSPACE = 415; //(* "There is no space to create a capture file on the specified device." *)  
    int IDS_CAP_SETFILESIZE = 416; //(* "Set File Size" *)  
    int IDS_CAP_SAVEASPERCENT = 417; //(* "SaveAs: %2ld%%  Hit Escape to abort." *)  
    int IDS_CAP_DRIVER_ERROR = 418; //(* Driver specific error message *)  
    int IDS_CAP_WAVE_OPEN_ERROR = 419; //(* "Error: Cannot open the wave input device.\nCheck sample size, frequency, and channels." *)  
    int IDS_CAP_WAVE_ALLOC_ERROR = 420; //(* "Error: Out of memory for wave buffers." *)  
    int IDS_CAP_WAVE_PREPARE_ERROR = 421; //(* "Error: Cannot prepare wave buffers." *)  
    int IDS_CAP_WAVE_ADD_ERROR = 422; //(* "Error: Cannot add wave buffers." *)  
    int IDS_CAP_WAVE_SIZE_ERROR = 423; //(* "Error: Bad wave size." *)  
    int IDS_CAP_VIDEO_OPEN_ERROR = 424; //(* "Error: Cannot open the video input device." *)    
    int IDS_CAP_VIDEO_ALLOC_ERROR = 425; //(* "Error: Out of memory for video buffers." *)  
    int IDS_CAP_VIDEO_PREPARE_ERROR = 426; //(* "Error: Cannot prepare video buffers." *)  
    int IDS_CAP_VIDEO_ADD_ERROR = 427; //(* "Error: Cannot add video buffers." *)  
    int IDS_CAP_VIDEO_SIZE_ERROR = 428; //(* "Error: Bad video size." *)  
    int IDS_CAP_FILE_OPEN_ERROR = 429; //(* "Error: Cannot open capture file." *)  
    int IDS_CAP_FILE_WRITE_ERROR = 430; //(* "Error: Cannot write to capture file.  Disk may be full." *)  
    int IDS_CAP_RECORDING_ERROR = 431; //(* "Error: Cannot write to capture file.  Data rate too high or disk full." *)  
    int IDS_CAP_RECORDING_ERROR2 = 432; //(* "Error while recording" *)  
    int IDS_CAP_AVI_INIT_ERROR = 433; //(* "Error: Unable to initialize for capture." *)  
    int IDS_CAP_NO_FRAME_CAP_ERROR = 434; //(* "Warning: No frames captured.\nConfirm that vertical sync interrupts\nare configured and enabled." *)  
    int IDS_CAP_NO_PALETTE_WARN = 435; //(* "Warning: Using default palette." *)  
    int IDS_CAP_MCI_CONTROL_ERROR = 436; //(* "Error: Unable to access MCI device." *)  
    int IDS_CAP_MCI_CANT_STEP_ERROR = 437; //(* "Error: Unable to step MCI device." *)  
    int IDS_CAP_NO_AUDIO_CAP_ERROR = 438; //(* "Error: No audio data captured.\nCheck audio card settings." *)  
    int IDS_CAP_AVI_DRAWDIB_ERROR = 439; //(* "Error: Unable to draw this data format." *)  
    int IDS_CAP_COMPRESSOR_ERROR = 440; //(* "Error: Unable to initialize compressor." *)  
    int IDS_CAP_AUDIO_DROP_ERROR = 441; //(* "Error: Audio data was lost during capture, reduce capture rate." *)  

    //(* status string IDs *)  
    int IDS_CAP_STAT_LIVE_MODE = 500; //(* "Live window" *)  
    int IDS_CAP_STAT_OVERLAY_MODE = 501; //(* "Overlay window" *)  
    int IDS_CAP_STAT_CAP_INIT = 502; //(* "Setting up for capture - Please wait" *)  
    int IDS_CAP_STAT_CAP_FINI = 503; //(* "Finished capture, now writing frame %ld" *)  
    int IDS_CAP_STAT_PALETTE_BUILD = 504; //(* "Building palette map" *)  
    int IDS_CAP_STAT_OPTPAL_BUILD = 505; //(* "Computing optimal palette" *)  
    int IDS_CAP_STAT_I_FRAMES = 506; //(* "%d frames" *)  
    int IDS_CAP_STAT_L_FRAMES = 507; //(* "%ld frames" *)  
    int IDS_CAP_STAT_CAP_L_FRAMES = 508; //(* "Captured %ld frames" *)  
    int IDS_CAP_STAT_CAP_AUDIO = 509; //(* "Capturing audio" *)  
    int IDS_CAP_STAT_VIDEOCURRENT = 510; //(* "Captured %ld frames (%ld dropped) %d.%03d sec." *)  
    int IDS_CAP_STAT_VIDEOAUDIO = 511; //(* "Captured %d.%03d sec.  %ld frames (%ld dropped) (%d.%03d fps).  %ld audio bytes (%d,%03d sps)" *)  
    int IDS_CAP_STAT_VIDEOONLY = 512; //(* "Captured %d.%03d sec.  %ld frames (%ld dropped) (%d.%03d fps)" *)  
    int IDS_CAP_STAT_FRAMESDROPPED = 513; //(* "Dropped %ld of %ld frames (%d.%02d%%) during capture." *)  

}