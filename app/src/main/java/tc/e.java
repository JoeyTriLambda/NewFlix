package tc;

import a6.a;
import android.content.Context;
import android.net.Uri;
import android.os.Handler;
import k6.n;
import u5.h;

/* compiled from: SsMediaSourceBuilder.java */
/* loaded from: classes2.dex */
public final class e extends d {
    @Override // tc.d
    public h build(Context context, Uri uri, String str, Handler handler, n<? super k6.d> nVar) {
        return new a6.e(uri, buildDataSourceFactory(context, str, null), new a.C0005a(buildDataSourceFactory(context, str, nVar)), handler, null);
    }
}
