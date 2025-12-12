package tc;

import android.content.Context;
import android.net.Uri;
import android.os.Handler;
import com.loopj.android.http.AsyncHttpClient;
import flix.com.vision.App;
import java.util.HashMap;
import k6.d;
import k6.j;
import k6.n;
import u5.h;

/* compiled from: MediaSourceBuilder.java */
/* loaded from: classes2.dex */
public abstract class d {
    public abstract h build(Context context, Uri uri, String str, Handler handler, n<? super k6.d> nVar);

    public d.a buildDataSourceFactory(Context context, String str, n<? super k6.d> nVar) {
        HashMap map = mc.a.f16262a;
        return new j(context, nVar, new mc.b(str, nVar, AsyncHttpClient.DEFAULT_SOCKET_TIMEOUT, 30000, true, App.G));
    }
}
