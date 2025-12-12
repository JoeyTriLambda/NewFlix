package nc;

import xc.d;

/* compiled from: ListenerMux.java */
/* loaded from: classes2.dex */
public final class a implements Runnable {

    /* renamed from: b, reason: collision with root package name */
    public final /* synthetic */ c f16784b;

    public a(c cVar) {
        this.f16784b = cVar;
    }

    @Override // java.lang.Runnable
    public void run() {
        c cVar = this.f16784b;
        cVar.f16787m.onPrepared();
        d dVar = cVar.f16788n;
        if (dVar != null) {
            dVar.onPrepared();
        }
    }
}
