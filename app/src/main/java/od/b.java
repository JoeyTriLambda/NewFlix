package od;

import android.content.Context;
import android.os.AsyncTask;
import java.util.ArrayList;

/* compiled from: AdultStreamResolver.java */
/* loaded from: classes2.dex */
public final class b {

    /* renamed from: a, reason: collision with root package name */
    public final ArrayList<id.b> f17074a = new ArrayList<>();

    /* renamed from: b, reason: collision with root package name */
    public final gd.a f17075b;

    /* renamed from: c, reason: collision with root package name */
    public id.b f17076c;

    public b(Context context, gd.a aVar) {
        this.f17075b = aVar;
    }

    public void addLink(String str, String str2) {
        id.b bVar = new id.b();
        bVar.f13363b = str2;
        bVar.f13364m = str;
        if (str2 == null || !str2.contains("1080")) {
            this.f17074a.add(bVar);
        } else {
            this.f17076c = bVar;
        }
    }

    public void process(String str) {
        new a(this, str).executeOnExecutor(AsyncTask.THREAD_POOL_EXECUTOR, new Void[0]);
    }
}
