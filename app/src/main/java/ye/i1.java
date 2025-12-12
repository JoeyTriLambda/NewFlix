package ye;

/* compiled from: ObservableSerialized.java */
/* loaded from: classes2.dex */
public final class i1<T> extends a<T, T> {
    public i1(ne.k<T> kVar) {
        super(kVar);
    }

    @Override // ne.k
    public void subscribeActual(ne.q<? super T> qVar) {
        this.f22058b.subscribe(new ef.e(qVar));
    }
}
