package ye;

/* compiled from: ObservableFromUnsafeSource.java */
/* loaded from: classes2.dex */
public final class n0<T> extends ne.k<T> {

    /* renamed from: b, reason: collision with root package name */
    public final ne.o<T> f22290b;

    public n0(ne.o<T> oVar) {
        this.f22290b = oVar;
    }

    @Override // ne.k
    public void subscribeActual(ne.q<? super T> qVar) {
        this.f22290b.subscribe(qVar);
    }
}
