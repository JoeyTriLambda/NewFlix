package hf;

import cf.a;
import io.reactivex.internal.util.NotificationLite;
import ne.q;

/* compiled from: SerializedSubject.java */
/* loaded from: classes2.dex */
public final class a<T> extends b<T> implements a.InterfaceC0063a<Object> {

    /* renamed from: b, reason: collision with root package name */
    public final b<T> f13068b;

    /* renamed from: m, reason: collision with root package name */
    public boolean f13069m;

    /* renamed from: n, reason: collision with root package name */
    public cf.a<Object> f13070n;

    /* renamed from: o, reason: collision with root package name */
    public volatile boolean f13071o;

    public a(b<T> bVar) {
        this.f13068b = bVar;
    }

    public final void a() {
        cf.a<Object> aVar;
        while (true) {
            synchronized (this) {
                aVar = this.f13070n;
                if (aVar == null) {
                    this.f13069m = false;
                    return;
                }
                this.f13070n = null;
            }
            aVar.forEachWhile(this);
        }
    }

    @Override // ne.q
    public void onComplete() {
        if (this.f13071o) {
            return;
        }
        synchronized (this) {
            if (this.f13071o) {
                return;
            }
            this.f13071o = true;
            if (!this.f13069m) {
                this.f13069m = true;
                this.f13068b.onComplete();
                return;
            }
            cf.a<Object> aVar = this.f13070n;
            if (aVar == null) {
                aVar = new cf.a<>(4);
                this.f13070n = aVar;
            }
            aVar.add(NotificationLite.complete());
        }
    }

    @Override // ne.q
    public void onError(Throwable th2) {
        if (this.f13071o) {
            ff.a.onError(th2);
            return;
        }
        synchronized (this) {
            boolean z10 = true;
            if (!this.f13071o) {
                this.f13071o = true;
                if (this.f13069m) {
                    cf.a<Object> aVar = this.f13070n;
                    if (aVar == null) {
                        aVar = new cf.a<>(4);
                        this.f13070n = aVar;
                    }
                    aVar.setFirst(NotificationLite.error(th2));
                    return;
                }
                this.f13069m = true;
                z10 = false;
            }
            if (z10) {
                ff.a.onError(th2);
            } else {
                this.f13068b.onError(th2);
            }
        }
    }

    @Override // ne.q
    public void onNext(T t10) {
        if (this.f13071o) {
            return;
        }
        synchronized (this) {
            if (this.f13071o) {
                return;
            }
            if (!this.f13069m) {
                this.f13069m = true;
                this.f13068b.onNext(t10);
                a();
            } else {
                cf.a<Object> aVar = this.f13070n;
                if (aVar == null) {
                    aVar = new cf.a<>(4);
                    this.f13070n = aVar;
                }
                aVar.add(NotificationLite.next(t10));
            }
        }
    }

    @Override // ne.q
    public void onSubscribe(qe.b bVar) {
        boolean z10 = true;
        if (!this.f13071o) {
            synchronized (this) {
                if (!this.f13071o) {
                    if (this.f13069m) {
                        cf.a<Object> aVar = this.f13070n;
                        if (aVar == null) {
                            aVar = new cf.a<>(4);
                            this.f13070n = aVar;
                        }
                        aVar.add(NotificationLite.disposable(bVar));
                        return;
                    }
                    this.f13069m = true;
                    z10 = false;
                }
            }
        }
        if (z10) {
            bVar.dispose();
        } else {
            this.f13068b.onSubscribe(bVar);
            a();
        }
    }

    @Override // ne.k
    public void subscribeActual(q<? super T> qVar) {
        this.f13068b.subscribe(qVar);
    }

    @Override // se.o
    public boolean test(Object obj) {
        return NotificationLite.acceptFull(obj, this.f13068b);
    }
}
