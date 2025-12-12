package u0;

import u0.m;

/* compiled from: CallbackWithHandler.java */
/* loaded from: classes.dex */
public final class b implements Runnable {

    /* renamed from: b, reason: collision with root package name */
    public final /* synthetic */ m.c f19927b;

    /* renamed from: m, reason: collision with root package name */
    public final /* synthetic */ int f19928m;

    public b(m.c cVar, int i10) {
        this.f19927b = cVar;
        this.f19928m = i10;
    }

    @Override // java.lang.Runnable
    public void run() {
        this.f19927b.onTypefaceRequestFailed(this.f19928m);
    }
}
