package org.adblockplus.libadblockplus.android.webview.content_type;

import android.webkit.WebResourceRequest;
import java.util.HashMap;
import java.util.Map;
import org.adblockplus.libadblockplus.FilterEngine;

/* loaded from: classes2.dex */
public class UrlFileExtensionTypeDetector implements ContentTypeDetector {
    private static final String[] EXTENSIONS_CSS;
    private static final String[] EXTENSIONS_FONT;
    private static final String[] EXTENSIONS_HTML;
    private static final String[] EXTENSIONS_IMAGE;
    private static final String[] EXTENSIONS_JS;
    private static final String[] EXTENSIONS_MEDIA;
    private static final Map<String, FilterEngine.ContentType> extensionTypeMap = new HashMap();

    static {
        String[] strArr = {"js"};
        EXTENSIONS_JS = strArr;
        String[] strArr2 = {"css"};
        EXTENSIONS_CSS = strArr2;
        String[] strArr3 = {"ttf", "woff", "woff2"};
        EXTENSIONS_FONT = strArr3;
        String[] strArr4 = {"htm", "html"};
        EXTENSIONS_HTML = strArr4;
        String[] strArr5 = {"gif", "png", "jpg", "jpe", "jpeg", "bmp", "apng", "cur", "jfif", "ico", "pjpeg", "pjp", "svg", "tif", "tiff", "webp"};
        EXTENSIONS_IMAGE = strArr5;
        String[] strArr6 = {"webm", "mkv", "flv", "vob", "ogv", "drc", "mng", "avi", "mov", "gifv", "qt", "wmv", "yuv", "rm", "rmvb", "asf", "amv", "mp4", "m4p", "mp2", "mpe", "mpv", "mpg", "mpeg", "m2v", "m4v", "svi", "3gp", "3g2", "mxf", "roq", "nsv", "8svx", "aa", "aac", "aax", "act", "aiff", "alac", "amr", "ape", "au", "awb", "cda", "dct", "dss", "dvf", "flac", "gsm", "iklax", "ivs", "m4a", "m4b", "mmf", "mogg", "mp3", "mpc", "msv", "nmf", "oga", "ogg", "opus", "ra", "raw", "rf64", "sln", "tta", "voc", "vox", "wav", "wma", "wv"};
        EXTENSIONS_MEDIA = strArr6;
        mapExtensions(strArr, FilterEngine.ContentType.SCRIPT);
        mapExtensions(strArr2, FilterEngine.ContentType.STYLESHEET);
        mapExtensions(strArr3, FilterEngine.ContentType.FONT);
        mapExtensions(strArr4, FilterEngine.ContentType.SUBDOCUMENT);
        mapExtensions(strArr5, FilterEngine.ContentType.IMAGE);
        mapExtensions(strArr6, FilterEngine.ContentType.MEDIA);
    }

    private static void mapExtensions(String[] strArr, FilterEngine.ContentType contentType) {
        for (String str : strArr) {
            extensionTypeMap.put(str.toLowerCase(), contentType);
        }
    }

    @Override // org.adblockplus.libadblockplus.android.webview.content_type.ContentTypeDetector
    public FilterEngine.ContentType detect(WebResourceRequest webResourceRequest) {
        String path;
        int iLastIndexOf;
        String strSubstring;
        if (webResourceRequest == null || webResourceRequest.getUrl() == null || (path = webResourceRequest.getUrl().getPath()) == null || (iLastIndexOf = path.lastIndexOf(46)) == -1 || (strSubstring = path.substring(iLastIndexOf + 1)) == null) {
            return null;
        }
        return extensionTypeMap.get(strSubstring.toLowerCase());
    }
}
