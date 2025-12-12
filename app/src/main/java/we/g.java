package we;

import io.reactivex.internal.disposables.DisposableHelper;
import io.reactivex.internal.disposables.EmptyDisposable;
import ne.q;

/* compiled from: DisposableLambdaObserver.java */
/* loaded from: classes2.dex */
public final class g<T> implements q<T>, qe.b {

    /* renamed from: b, reason: collision with root package name */
    public final q<? super T> f21137b;

    /* renamed from: m, reason: collision with root package name */
    public final se.f<? super qe.b> f21138m;

    /* renamed from: n, reason: collision with root package name */
    public final se.a f21139n;

    /* renamed from: o, reason: collision with root package name */
    public qe.b f21140o;

    public g(q<? super T> qVar, se.f<? super qe.b> fVar, se.a aVar) {
        this.f21137b = qVar;
        this.f21138m = fVar;
        this.f21139n = aVar;
    }

    @Override // qe.b
    public void dispose() {
        qe.b bVar = this.f21140o;
        DisposableHelper disposableHelper = DisposableHelper.f13533b;
        if (bVar != disposableHelper) {
            this.f21140o = disposableHelper;
            try {
                this.f21139n.run();
            } catch (Throwable th2) {
                re.a.throwIfFatal(th2);
                ff.a.onError(th2);
            }
            bVar.dispose();
        }
    }

    @Override // ne.q
    public void onComplete() {
        qe.b bVar = this.f21140o;
        DisposableHelper disposableHelper = DisposableHelper.f13533b;
        if (bVar != disposableHelper) {
            this.f21140o = disposableHelper;
            this.f21137b.onComplete();
        }
    }

    @Override // ne.q
    public void onError(Throwable th2) {
        qe.b bVar = this.f21140o;
        DisposableHelper disposableHelper = DisposableHelper.f13533b;
        if (bVar == disposableHelper) {
            ff.a.onError(th2);
        } else {
            this.f21140o = disposableHelper;
            this.f21137b.onError(th2);
        }
    }

    @Override // ne.q
    public void onNext(T t10) {
        this.f21137b.onNext(t10);
    }

    @Override // ne.q
    public void onSubscribe(qe.b bVar) {
        q<? super T> qVar = this.f21137b;
        try {
            this.f21138m.accept(bVar);
            if (DisposableHelper.validate(this.f21140o, bVar)) {
                this.f21140o = bVar;
                qVar.onSubscribe(this);
            }
        } catch (Throwable th2) {
            re.a.throwIfFatal(th2);
            bVar.dispose();
            this.f21140o = DisposableHelper.f13533b;
            EmptyDisposable.error(th2, qVar);
        }
    }
}
