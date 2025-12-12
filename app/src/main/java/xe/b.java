package xe;

import ne.e;
import ne.k;
import ne.q;
import zh.c;

/* compiled from: FlowableFromObservable.java */
/* loaded from: classes2.dex */
public final class b<T> extends e<T> {

    /* renamed from: m, reason: collision with root package name */
    public final k<T> f21750m;

    public b(k<T> kVar) {
        this.f21750m = kVar;
    }

    @Override // ne.e
    public void subscribeActual(zh.b<? super T> bVar) {
        this.f21750m.subscribe(new a(bVar));
    }

    /* compiled from: FlowableFromObservable.java */
    public static final class a<T> implements q<T>, c {

        /* renamed from: b, reason: collision with root package name */
        public final zh.b<? super T> f21751b;

        /* renamed from: m, reason: collision with root package name */
        public qe.b f21752m;

        public a(zh.b<? super T> bVar) {
            this.f21751b = bVar;
        }

        @Override // zh.c
        public void cancel() {
            this.f21752m.dispose();
        }

        @Override // ne.q
        public void onComplete() {
            this.f21751b.onComplete();
        }

        @Override // ne.q
        public void onError(Throwable th2) {
            this.f21751b.onError(th2);
        }

        @Override // ne.q
        public void onNext(T t10) {
            this.f21751b.onNext(t10);
        }

        @Override // ne.q
        public void onSubscribe(qe.b bVar) {
            this.f21752m = bVar;
            this.f21751b.onSubscribe(this);
        }

        @Override // zh.c
        public void request(long j10) {
        }
    }
}
