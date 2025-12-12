package tc;

import android.content.Context;
import android.net.Uri;
import android.os.Handler;
import k6.n;
import u5.h;
import w5.h;

/* compiled from: DashMediaSourceBuilder.java */
/* loaded from: classes2.dex */
public final class a extends d {
    @Override // tc.d
    public h build(Context context, Uri uri, String str, Handler handler, n<? super k6.d> nVar) {
        return new w5.e(uri, buildDataSourceFactory(context, str, null), new h.a(buildDataSourceFactory(context, str, nVar)), handler, null);
    }
}
