package ef;

import io.reactivex.exceptions.CompositeException;
import io.reactivex.internal.disposables.DisposableHelper;
import io.reactivex.internal.disposables.EmptyDisposable;
import ne.q;

/* compiled from: SafeObserver.java */
/* loaded from: classes2.dex */
public final class d<T> implements q<T>, qe.b {

    /* renamed from: b, reason: collision with root package name */
    public final q<? super T> f11316b;

    /* renamed from: m, reason: collision with root package name */
    public qe.b f11317m;

    /* renamed from: n, reason: collision with root package name */
    public boolean f11318n;

    public d(q<? super T> qVar) {
        this.f11316b = qVar;
    }

    @Override // qe.b
    public void dispose() {
        this.f11317m.dispose();
    }

    @Override // ne.q
    public void onComplete() {
        if (this.f11318n) {
            return;
        }
        this.f11318n = true;
        qe.b bVar = this.f11317m;
        q<? super T> qVar = this.f11316b;
        if (bVar != null) {
            try {
                qVar.onComplete();
                return;
            } catch (Throwable th2) {
                re.a.throwIfFatal(th2);
                ff.a.onError(th2);
                return;
            }
        }
        NullPointerException nullPointerException = new NullPointerException("Subscription not set!");
        try {
            qVar.onSubscribe(EmptyDisposable.INSTANCE);
            try {
                qVar.onError(nullPointerException);
            } catch (Throwable th3) {
                re.a.throwIfFatal(th3);
                ff.a.onError(new CompositeException(nullPointerException, th3));
            }
        } catch (Throwable th4) {
            re.a.throwIfFatal(th4);
            ff.a.onError(new CompositeException(nullPointerException, th4));
        }
    }

    @Override // ne.q
    public void onError(Throwable th2) {
        if (this.f11318n) {
            ff.a.onError(th2);
            return;
        }
        this.f11318n = true;
        qe.b bVar = this.f11317m;
        q<? super T> qVar = this.f11316b;
        if (bVar != null) {
            if (th2 == null) {
                th2 = new NullPointerException("onError called with null. Null values are generally not allowed in 2.x operators and sources.");
            }
            try {
                qVar.onError(th2);
                return;
            } catch (Throwable th3) {
                re.a.throwIfFatal(th3);
                ff.a.onError(new CompositeException(th2, th3));
                return;
            }
        }
        NullPointerException nullPointerException = new NullPointerException("Subscription not set!");
        try {
            qVar.onSubscribe(EmptyDisposable.INSTANCE);
            try {
                qVar.onError(new CompositeException(th2, nullPointerException));
            } catch (Throwable th4) {
                re.a.throwIfFatal(th4);
                ff.a.onError(new CompositeException(th2, nullPointerException, th4));
            }
        } catch (Throwable th5) {
            re.a.throwIfFatal(th5);
            ff.a.onError(new CompositeException(th2, nullPointerException, th5));
        }
    }

    @Override // ne.q
    public void onNext(T t10) {
        if (this.f11318n) {
            return;
        }
        qe.b bVar = this.f11317m;
        q<? super T> qVar = this.f11316b;
        if (bVar == null) {
            this.f11318n = true;
            NullPointerException nullPointerException = new NullPointerException("Subscription not set!");
            try {
                qVar.onSubscribe(EmptyDisposable.INSTANCE);
                try {
                    qVar.onError(nullPointerException);
                    return;
                } catch (Throwable th2) {
                    re.a.throwIfFatal(th2);
                    ff.a.onError(new CompositeException(nullPointerException, th2));
                    return;
                }
            } catch (Throwable th3) {
                re.a.throwIfFatal(th3);
                ff.a.onError(new CompositeException(nullPointerException, th3));
                return;
            }
        }
        if (t10 == null) {
            NullPointerException nullPointerException2 = new NullPointerException("onNext called with null. Null values are generally not allowed in 2.x operators and sources.");
            try {
                this.f11317m.dispose();
                onError(nullPointerException2);
                return;
            } catch (Throwable th4) {
                re.a.throwIfFatal(th4);
                onError(new CompositeException(nullPointerException2, th4));
                return;
            }
        }
        try {
            qVar.onNext(t10);
        } catch (Throwable th5) {
            re.a.throwIfFatal(th5);
            try {
                this.f11317m.dispose();
                onError(th5);
            } catch (Throwable th6) {
                re.a.throwIfFatal(th6);
                onError(new CompositeException(th5, th6));
            }
        }
    }

    @Override // ne.q
    public void onSubscribe(qe.b bVar) {
        if (DisposableHelper.validate(this.f11317m, bVar)) {
            this.f11317m = bVar;
            try {
                this.f11316b.onSubscribe(this);
            } catch (Throwable th2) {
                re.a.throwIfFatal(th2);
                this.f11318n = true;
                try {
                    bVar.dispose();
                    ff.a.onError(th2);
                } catch (Throwable th3) {
                    re.a.throwIfFatal(th3);
                    ff.a.onError(new CompositeException(th2, th3));
                }
            }
        }
    }
}
