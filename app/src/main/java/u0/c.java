package u0;

import android.os.Handler;
import u0.l;
import u0.m;

/* compiled from: CallbackWithHandler.java */
/* loaded from: classes.dex */
public final class c {

    /* renamed from: a, reason: collision with root package name */
    public final m.c f19929a;

    /* renamed from: b, reason: collision with root package name */
    public final Handler f19930b;

    public c(m.c cVar, Handler handler) {
        this.f19929a = cVar;
        this.f19930b = handler;
    }

    public final void a(l.a aVar) {
        int i10 = aVar.f19955b;
        boolean z10 = i10 == 0;
        Handler handler = this.f19930b;
        m.c cVar = this.f19929a;
        if (z10) {
            handler.post(new a(cVar, aVar.f19954a));
        } else {
            handler.post(new b(cVar, i10));
        }
    }
}
