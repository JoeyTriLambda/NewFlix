package u0;

import android.content.Context;
import android.net.Uri;
import android.os.Build;
import u0.f;

/* compiled from: FontProvider.java */
/* loaded from: classes.dex */
public final /* synthetic */ class e {
    public static f.a a(Context context, Uri uri) {
        return Build.VERSION.SDK_INT < 24 ? new f.b(context, uri) : new f.c(context, uri);
    }
}
