package od;

import android.content.Context;
import android.os.AsyncTask;
import java.util.ArrayList;

/* compiled from: AdultVideosFetcherRelated.java */
/* loaded from: classes2.dex */
public final class f {

    /* renamed from: a, reason: collision with root package name */
    public final ArrayList<id.c> f17083a = new ArrayList<>();

    /* renamed from: b, reason: collision with root package name */
    public final gd.c f17084b;

    public f(Context context, gd.c cVar) {
        this.f17084b = cVar;
    }

    public void process(String str) {
        new e(this, str).executeOnExecutor(AsyncTask.THREAD_POOL_EXECUTOR, new Void[0]);
    }
}
