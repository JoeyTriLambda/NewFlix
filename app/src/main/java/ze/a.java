package ze;

import ne.s;
import ne.t;
import ne.u;
import qe.b;
import se.n;

/* compiled from: SingleMap.java */
/* loaded from: classes2.dex */
public final class a<T, R> extends s<R> {

    /* renamed from: a, reason: collision with root package name */
    public final u<? extends T> f22716a;

    /* renamed from: b, reason: collision with root package name */
    public final n<? super T, ? extends R> f22717b;

    /* compiled from: SingleMap.java */
    /* renamed from: ze.a$a, reason: collision with other inner class name */
    public static final class C0337a<T, R> implements t<T> {

        /* renamed from: b, reason: collision with root package name */
        public final t<? super R> f22718b;

        /* renamed from: m, reason: collision with root package name */
        public final n<? super T, ? extends R> f22719m;

        public C0337a(t<? super R> tVar, n<? super T, ? extends R> nVar) {
            this.f22718b = tVar;
            this.f22719m = nVar;
        }

        @Override // ne.t
        public void onError(Throwable th2) {
            this.f22718b.onError(th2);
        }

        @Override // ne.t
        public void onSubscribe(b bVar) {
            this.f22718b.onSubscribe(bVar);
        }

        @Override // ne.t
        public void onSuccess(T t10) {
            try {
                this.f22718b.onSuccess(ue.a.requireNonNull(this.f22719m.apply(t10), "The mapper function returned a null value."));
            } catch (Throwable th2) {
                re.a.throwIfFatal(th2);
                onError(th2);
            }
        }
    }

    public a(u<? extends T> uVar, n<? super T, ? extends R> nVar) {
        this.f22716a = uVar;
        this.f22717b = nVar;
    }

    @Override // ne.s
    public void subscribeActual(t<? super R> tVar) {
        this.f22716a.subscribe(new C0337a(tVar, this.f22717b));
    }
}
