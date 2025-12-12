package ef;

import io.reactivex.internal.disposables.DisposableHelper;
import io.reactivex.internal.util.NotificationLite;
import ne.q;

/* compiled from: SerializedObserver.java */
/* loaded from: classes2.dex */
public final class e<T> implements q<T>, qe.b {

    /* renamed from: b, reason: collision with root package name */
    public final q<? super T> f11319b;

    /* renamed from: m, reason: collision with root package name */
    public final boolean f11320m;

    /* renamed from: n, reason: collision with root package name */
    public qe.b f11321n;

    /* renamed from: o, reason: collision with root package name */
    public boolean f11322o;

    /* renamed from: p, reason: collision with root package name */
    public cf.a<Object> f11323p;

    /* renamed from: q, reason: collision with root package name */
    public volatile boolean f11324q;

    public e(q<? super T> qVar) {
        this(qVar, false);
    }

    public final void a() {
        cf.a<Object> aVar;
        do {
            synchronized (this) {
                aVar = this.f11323p;
                if (aVar == null) {
                    this.f11322o = false;
                    return;
                }
                this.f11323p = null;
            }
        } while (!aVar.accept(this.f11319b));
    }

    @Override // qe.b
    public void dispose() {
        this.f11321n.dispose();
    }

    @Override // ne.q
    public void onComplete() {
        if (this.f11324q) {
            return;
        }
        synchronized (this) {
            if (this.f11324q) {
                return;
            }
            if (!this.f11322o) {
                this.f11324q = true;
                this.f11322o = true;
                this.f11319b.onComplete();
            } else {
                cf.a<Object> aVar = this.f11323p;
                if (aVar == null) {
                    aVar = new cf.a<>(4);
                    this.f11323p = aVar;
                }
                aVar.add(NotificationLite.complete());
            }
        }
    }

    @Override // ne.q
    public void onError(Throwable th2) {
        if (this.f11324q) {
            ff.a.onError(th2);
            return;
        }
        synchronized (this) {
            boolean z10 = true;
            if (!this.f11324q) {
                if (this.f11322o) {
                    this.f11324q = true;
                    cf.a<Object> aVar = this.f11323p;
                    if (aVar == null) {
                        aVar = new cf.a<>(4);
                        this.f11323p = aVar;
                    }
                    Object objError = NotificationLite.error(th2);
                    if (this.f11320m) {
                        aVar.add(objError);
                    } else {
                        aVar.setFirst(objError);
                    }
                    return;
                }
                this.f11324q = true;
                this.f11322o = true;
                z10 = false;
            }
            if (z10) {
                ff.a.onError(th2);
            } else {
                this.f11319b.onError(th2);
            }
        }
    }

    @Override // ne.q
    public void onNext(T t10) {
        if (this.f11324q) {
            return;
        }
        if (t10 == null) {
            this.f11321n.dispose();
            onError(new NullPointerException("onNext called with null. Null values are generally not allowed in 2.x operators and sources."));
            return;
        }
        synchronized (this) {
            if (this.f11324q) {
                return;
            }
            if (!this.f11322o) {
                this.f11322o = true;
                this.f11319b.onNext(t10);
                a();
            } else {
                cf.a<Object> aVar = this.f11323p;
                if (aVar == null) {
                    aVar = new cf.a<>(4);
                    this.f11323p = aVar;
                }
                aVar.add(NotificationLite.next(t10));
            }
        }
    }

    @Override // ne.q
    public void onSubscribe(qe.b bVar) {
        if (DisposableHelper.validate(this.f11321n, bVar)) {
            this.f11321n = bVar;
            this.f11319b.onSubscribe(this);
        }
    }

    public e(q<? super T> qVar, boolean z10) {
        this.f11319b = qVar;
        this.f11320m = z10;
    }
}
