package ad;

import android.net.Uri;

/* compiled from: MediaSourceUtil.java */
/* loaded from: classes2.dex */
public final class b {
    public static String getExtension(Uri uri) {
        String lastPathSegment = uri.getLastPathSegment();
        if (lastPathSegment == null) {
            return null;
        }
        int iLastIndexOf = lastPathSegment.lastIndexOf(46);
        if (iLastIndexOf == -1 && uri.getPathSegments().size() > 1) {
            lastPathSegment = uri.getPathSegments().get(uri.getPathSegments().size() - 2);
            iLastIndexOf = lastPathSegment.lastIndexOf(46);
        }
        if (iLastIndexOf == -1) {
            lastPathSegment = "." + uri.getLastPathSegment();
            iLastIndexOf = 0;
        }
        return lastPathSegment.substring(iLastIndexOf).toLowerCase();
    }
}
