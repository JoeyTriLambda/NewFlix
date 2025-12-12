package tc;

import android.content.Context;
import android.net.Uri;
import android.os.Handler;
import k6.n;
import u5.h;

/* compiled from: HlsMediaSourceBuilder.java */
/* loaded from: classes2.dex */
public final class c extends d {
    @Override // tc.d
    public h build(Context context, Uri uri, String str, Handler handler, n<? super k6.d> nVar) {
        return new y5.h(uri, buildDataSourceFactory(context, str, nVar), handler, null);
    }
}
