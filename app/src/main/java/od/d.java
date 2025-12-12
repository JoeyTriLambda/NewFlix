package od;

import android.content.Context;
import android.os.AsyncTask;
import java.util.ArrayList;

/* compiled from: AdultVideosFetcher.java */
/* loaded from: classes2.dex */
public final class d {

    /* renamed from: a, reason: collision with root package name */
    public final ArrayList<id.c> f17079a = new ArrayList<>();

    /* renamed from: b, reason: collision with root package name */
    public final gd.c f17080b;

    public d(Context context, gd.c cVar) {
        this.f17080b = cVar;
    }

    public void process(String str, int i10) {
        if (str.endsWith("p=0") && i10 > -1) {
            str = str.replace("p=0", "p=" + i10);
        } else if (i10 > -1) {
            str = str + i10;
        }
        new c(this, str).executeOnExecutor(AsyncTask.THREAD_POOL_EXECUTOR, new Void[0]);
    }
}
