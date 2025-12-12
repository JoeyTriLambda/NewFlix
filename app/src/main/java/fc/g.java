package fc;

import android.net.Uri;
import cz.msebera.android.httpclient.HttpHost;

/* compiled from: HelperMethods.java */
/* loaded from: classes2.dex */
public final class g {
    public static boolean isRemotePath(Uri uri) {
        return uri.getScheme().equals(HttpHost.DEFAULT_SCHEME_NAME) || uri.getScheme().equals("https");
    }
}
