package w5;

import android.net.Uri;

/* compiled from: DashMediaSource.java */
/* loaded from: classes.dex */
public final class c implements Runnable {

    /* renamed from: b, reason: collision with root package name */
    public final /* synthetic */ e f20974b;

    public c(e eVar) {
        this.f20974b = eVar;
    }

    @Override // java.lang.Runnable
    public void run() {
        Uri uri;
        e eVar = this.f20974b;
        synchronized (eVar.f20984t) {
            uri = eVar.B;
        }
        com.google.android.exoplayer2.upstream.a aVar = new com.google.android.exoplayer2.upstream.a(eVar.f20989y, uri, 4, eVar.f20982r);
        long jStartLoading = eVar.f20990z.startLoading(aVar, eVar.f20983s, eVar.f20979o);
        eVar.f20981q.loadStarted(aVar.f6042a, aVar.f6043b, jStartLoading);
    }
}
