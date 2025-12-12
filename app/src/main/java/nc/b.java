package nc;

/* compiled from: ListenerMux.java */
/* loaded from: classes2.dex */
public final class b implements Runnable {

    /* renamed from: b, reason: collision with root package name */
    public final /* synthetic */ c f16785b;

    public b(c cVar) {
        this.f16785b = cVar;
    }

    @Override // java.lang.Runnable
    public void run() {
        xc.b bVar = this.f16785b.f16789o;
        if (bVar != null) {
            bVar.onCompletion();
        }
    }
}
