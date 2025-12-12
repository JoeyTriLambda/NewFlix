package ye;

/* compiled from: ObservableDoOnLifecycle.java */
/* loaded from: classes2.dex */
public final class a0<T> extends a<T, T> {

    /* renamed from: m, reason: collision with root package name */
    public final se.f<? super qe.b> f22059m;

    /* renamed from: n, reason: collision with root package name */
    public final se.a f22060n;

    public a0(ne.k<T> kVar, se.f<? super qe.b> fVar, se.a aVar) {
        super(kVar);
        this.f22059m = fVar;
        this.f22060n = aVar;
    }

    @Override // ne.k
    public void subscribeActual(ne.q<? super T> qVar) {
        this.f22058b.subscribe(new we.g(qVar, this.f22059m, this.f22060n));
    }
}
