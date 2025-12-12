package io.reactivex.subjects;

import af.a;
import hf.b;
import io.reactivex.internal.disposables.EmptyDisposable;
import io.reactivex.internal.observers.BasicIntQueueDisposable;
import java.util.concurrent.atomic.AtomicBoolean;
import java.util.concurrent.atomic.AtomicReference;
import ne.k;
import ne.q;

/* loaded from: classes2.dex */
public final class UnicastSubject<T> extends b<T> {

    /* renamed from: b, reason: collision with root package name */
    public final a<T> f14562b;

    /* renamed from: m, reason: collision with root package name */
    public final AtomicReference<q<? super T>> f14563m;

    /* renamed from: n, reason: collision with root package name */
    public final AtomicReference<Runnable> f14564n;

    /* renamed from: o, reason: collision with root package name */
    public final boolean f14565o;

    /* renamed from: p, reason: collision with root package name */
    public volatile boolean f14566p;

    /* renamed from: q, reason: collision with root package name */
    public volatile boolean f14567q;

    /* renamed from: r, reason: collision with root package name */
    public Throwable f14568r;

    /* renamed from: s, reason: collision with root package name */
    public final AtomicBoolean f14569s;

    /* renamed from: t, reason: collision with root package name */
    public final BasicIntQueueDisposable<T> f14570t;

    /* renamed from: u, reason: collision with root package name */
    public boolean f14571u;

    public final class UnicastQueueDisposable extends BasicIntQueueDisposable<T> {
        private static final long serialVersionUID = 7926949470189395511L;

        public UnicastQueueDisposable() {
        }

        @Override // ve.f
        public void clear() {
            UnicastSubject.this.f14562b.clear();
        }

        @Override // qe.b
        public void dispose() {
            if (UnicastSubject.this.f14566p) {
                return;
            }
            UnicastSubject.this.f14566p = true;
            UnicastSubject.this.a();
            UnicastSubject.this.f14563m.lazySet(null);
            if (UnicastSubject.this.f14570t.getAndIncrement() == 0) {
                UnicastSubject.this.f14563m.lazySet(null);
                UnicastSubject unicastSubject = UnicastSubject.this;
                if (unicastSubject.f14571u) {
                    return;
                }
                unicastSubject.f14562b.clear();
            }
        }

        @Override // ve.f
        public boolean isEmpty() {
            return UnicastSubject.this.f14562b.isEmpty();
        }

        @Override // ve.f
        public T poll() throws Exception {
            return UnicastSubject.this.f14562b.poll();
        }

        @Override // ve.c
        public int requestFusion(int i10) {
            if ((i10 & 2) == 0) {
                return 0;
            }
            UnicastSubject.this.f14571u = true;
            return 2;
        }
    }

    public UnicastSubject(int i10) {
        this.f14562b = new a<>(ue.a.verifyPositive(i10, "capacityHint"));
        this.f14564n = new AtomicReference<>();
        this.f14565o = true;
        this.f14563m = new AtomicReference<>();
        this.f14569s = new AtomicBoolean();
        this.f14570t = new UnicastQueueDisposable();
    }

    public static <T> UnicastSubject<T> create() {
        return new UnicastSubject<>(k.bufferSize());
    }

    public final void a() {
        boolean z10;
        AtomicReference<Runnable> atomicReference = this.f14564n;
        Runnable runnable = atomicReference.get();
        if (runnable != null) {
            while (true) {
                if (atomicReference.compareAndSet(runnable, null)) {
                    z10 = true;
                    break;
                } else if (atomicReference.get() != runnable) {
                    z10 = false;
                    break;
                }
            }
            if (z10) {
                runnable.run();
            }
        }
    }

    public final void b() {
        boolean z10;
        boolean z11;
        if (this.f14570t.getAndIncrement() != 0) {
            return;
        }
        q<? super T> qVar = this.f14563m.get();
        int iAddAndGet = 1;
        while (qVar == null) {
            iAddAndGet = this.f14570t.addAndGet(-iAddAndGet);
            if (iAddAndGet == 0) {
                return;
            } else {
                qVar = this.f14563m.get();
            }
        }
        if (this.f14571u) {
            a<T> aVar = this.f14562b;
            boolean z12 = !this.f14565o;
            int iAddAndGet2 = 1;
            while (!this.f14566p) {
                boolean z13 = this.f14567q;
                if (z12 && z13) {
                    Throwable th2 = this.f14568r;
                    if (th2 != null) {
                        this.f14563m.lazySet(null);
                        aVar.clear();
                        qVar.onError(th2);
                        z11 = true;
                    } else {
                        z11 = false;
                    }
                    if (z11) {
                        return;
                    }
                }
                qVar.onNext(null);
                if (z13) {
                    this.f14563m.lazySet(null);
                    Throwable th3 = this.f14568r;
                    if (th3 != null) {
                        qVar.onError(th3);
                        return;
                    } else {
                        qVar.onComplete();
                        return;
                    }
                }
                iAddAndGet2 = this.f14570t.addAndGet(-iAddAndGet2);
                if (iAddAndGet2 == 0) {
                    return;
                }
            }
            this.f14563m.lazySet(null);
            return;
        }
        a<T> aVar2 = this.f14562b;
        boolean z14 = !this.f14565o;
        boolean z15 = true;
        int iAddAndGet3 = 1;
        while (!this.f14566p) {
            boolean z16 = this.f14567q;
            T tPoll = this.f14562b.poll();
            boolean z17 = tPoll == null;
            if (z16) {
                if (z14 && z15) {
                    Throwable th4 = this.f14568r;
                    if (th4 != null) {
                        this.f14563m.lazySet(null);
                        aVar2.clear();
                        qVar.onError(th4);
                        z10 = true;
                    } else {
                        z10 = false;
                    }
                    if (z10) {
                        return;
                    } else {
                        z15 = false;
                    }
                }
                if (z17) {
                    this.f14563m.lazySet(null);
                    Throwable th5 = this.f14568r;
                    if (th5 != null) {
                        qVar.onError(th5);
                        return;
                    } else {
                        qVar.onComplete();
                        return;
                    }
                }
            }
            if (z17) {
                iAddAndGet3 = this.f14570t.addAndGet(-iAddAndGet3);
                if (iAddAndGet3 == 0) {
                    return;
                }
            } else {
                qVar.onNext(tPoll);
            }
        }
        this.f14563m.lazySet(null);
        aVar2.clear();
    }

    @Override // ne.q
    public void onComplete() {
        if (this.f14567q || this.f14566p) {
            return;
        }
        this.f14567q = true;
        a();
        b();
    }

    @Override // ne.q
    public void onError(Throwable th2) {
        ue.a.requireNonNull(th2, "onError called with null. Null values are generally not allowed in 2.x operators and sources.");
        if (this.f14567q || this.f14566p) {
            ff.a.onError(th2);
            return;
        }
        this.f14568r = th2;
        this.f14567q = true;
        a();
        b();
    }

    @Override // ne.q
    public void onNext(T t10) {
        ue.a.requireNonNull(t10, "onNext called with null. Null values are generally not allowed in 2.x operators and sources.");
        if (this.f14567q || this.f14566p) {
            return;
        }
        this.f14562b.offer(t10);
        b();
    }

    @Override // ne.q
    public void onSubscribe(qe.b bVar) {
        if (this.f14567q || this.f14566p) {
            bVar.dispose();
        }
    }

    @Override // ne.k
    public void subscribeActual(q<? super T> qVar) {
        if (this.f14569s.get() || !this.f14569s.compareAndSet(false, true)) {
            EmptyDisposable.error(new IllegalStateException("Only a single observer allowed."), qVar);
            return;
        }
        qVar.onSubscribe(this.f14570t);
        this.f14563m.lazySet(qVar);
        if (this.f14566p) {
            this.f14563m.lazySet(null);
        } else {
            b();
        }
    }

    public static <T> UnicastSubject<T> create(int i10) {
        return new UnicastSubject<>(i10);
    }

    public static <T> UnicastSubject<T> create(int i10, Runnable runnable) {
        return new UnicastSubject<>(i10, runnable);
    }

    public UnicastSubject(int i10, Runnable runnable) {
        this.f14562b = new a<>(ue.a.verifyPositive(i10, "capacityHint"));
        this.f14564n = new AtomicReference<>(ue.a.requireNonNull(runnable, "onTerminate"));
        this.f14565o = true;
        this.f14563m = new AtomicReference<>();
        this.f14569s = new AtomicBoolean();
        this.f14570t = new UnicastQueueDisposable();
    }
}
