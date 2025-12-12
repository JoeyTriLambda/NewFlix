package io.reactivex.internal.operators.observable;

import io.reactivex.internal.disposables.DisposableHelper;
import io.reactivex.internal.disposables.SequentialDisposable;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.atomic.AtomicBoolean;
import java.util.concurrent.atomic.AtomicReference;
import ne.k;
import ne.q;
import ne.r;
import qe.b;
import se.f;
import te.c;
import ye.c1;

/* loaded from: classes2.dex */
public final class ObservableRefCount<T> extends k<T> {

    /* renamed from: b, reason: collision with root package name */
    public final df.a<T> f14103b;

    /* renamed from: m, reason: collision with root package name */
    public final int f14104m;

    /* renamed from: n, reason: collision with root package name */
    public final long f14105n;

    /* renamed from: o, reason: collision with root package name */
    public final TimeUnit f14106o;

    /* renamed from: p, reason: collision with root package name */
    public final r f14107p;

    /* renamed from: q, reason: collision with root package name */
    public RefConnection f14108q;

    public static final class RefConnection extends AtomicReference<b> implements Runnable, f<b> {
        private static final long serialVersionUID = -4552101107598366241L;

        /* renamed from: b, reason: collision with root package name */
        public final ObservableRefCount<?> f14109b;

        /* renamed from: m, reason: collision with root package name */
        public SequentialDisposable f14110m;

        /* renamed from: n, reason: collision with root package name */
        public long f14111n;

        /* renamed from: o, reason: collision with root package name */
        public boolean f14112o;

        /* renamed from: p, reason: collision with root package name */
        public boolean f14113p;

        public RefConnection(ObservableRefCount<?> observableRefCount) {
            this.f14109b = observableRefCount;
        }

        @Override // java.lang.Runnable
        public void run() {
            this.f14109b.b(this);
        }

        @Override // se.f
        public void accept(b bVar) throws Exception {
            DisposableHelper.replace(this, bVar);
            synchronized (this.f14109b) {
                if (this.f14113p) {
                    ((c) this.f14109b.f14103b).resetIf(bVar);
                }
            }
        }
    }

    public static final class RefCountObserver<T> extends AtomicBoolean implements q<T>, b {
        private static final long serialVersionUID = -7419642935409022375L;

        /* renamed from: b, reason: collision with root package name */
        public final q<? super T> f14114b;

        /* renamed from: m, reason: collision with root package name */
        public final ObservableRefCount<T> f14115m;

        /* renamed from: n, reason: collision with root package name */
        public final RefConnection f14116n;

        /* renamed from: o, reason: collision with root package name */
        public b f14117o;

        public RefCountObserver(q<? super T> qVar, ObservableRefCount<T> observableRefCount, RefConnection refConnection) {
            this.f14114b = qVar;
            this.f14115m = observableRefCount;
            this.f14116n = refConnection;
        }

        @Override // qe.b
        public void dispose() {
            this.f14117o.dispose();
            if (compareAndSet(false, true)) {
                ObservableRefCount<T> observableRefCount = this.f14115m;
                RefConnection refConnection = this.f14116n;
                synchronized (observableRefCount) {
                    RefConnection refConnection2 = observableRefCount.f14108q;
                    if (refConnection2 != null && refConnection2 == refConnection) {
                        long j10 = refConnection.f14111n - 1;
                        refConnection.f14111n = j10;
                        if (j10 == 0 && refConnection.f14112o) {
                            if (observableRefCount.f14105n == 0) {
                                observableRefCount.b(refConnection);
                            } else {
                                SequentialDisposable sequentialDisposable = new SequentialDisposable();
                                refConnection.f14110m = sequentialDisposable;
                                sequentialDisposable.replace(observableRefCount.f14107p.scheduleDirect(refConnection, observableRefCount.f14105n, observableRefCount.f14106o));
                            }
                        }
                    }
                }
            }
        }

        @Override // ne.q
        public void onComplete() {
            if (compareAndSet(false, true)) {
                this.f14115m.a(this.f14116n);
                this.f14114b.onComplete();
            }
        }

        @Override // ne.q
        public void onError(Throwable th2) {
            if (!compareAndSet(false, true)) {
                ff.a.onError(th2);
            } else {
                this.f14115m.a(this.f14116n);
                this.f14114b.onError(th2);
            }
        }

        @Override // ne.q
        public void onNext(T t10) {
            this.f14114b.onNext(t10);
        }

        @Override // ne.q
        public void onSubscribe(b bVar) {
            if (DisposableHelper.validate(this.f14117o, bVar)) {
                this.f14117o = bVar;
                this.f14114b.onSubscribe(this);
            }
        }
    }

    public ObservableRefCount(df.a<T> aVar) {
        this(aVar, 1, 0L, TimeUnit.NANOSECONDS, null);
    }

    public final void a(RefConnection refConnection) {
        synchronized (this) {
            if (this.f14103b instanceof c1) {
                RefConnection refConnection2 = this.f14108q;
                if (refConnection2 != null && refConnection2 == refConnection) {
                    this.f14108q = null;
                    SequentialDisposable sequentialDisposable = refConnection.f14110m;
                    if (sequentialDisposable != null) {
                        sequentialDisposable.dispose();
                        refConnection.f14110m = null;
                    }
                }
                long j10 = refConnection.f14111n - 1;
                refConnection.f14111n = j10;
                if (j10 == 0) {
                    df.a<T> aVar = this.f14103b;
                    if (aVar instanceof b) {
                        ((b) aVar).dispose();
                    } else if (aVar instanceof c) {
                        ((c) aVar).resetIf(refConnection.get());
                    }
                }
            } else {
                RefConnection refConnection3 = this.f14108q;
                if (refConnection3 != null && refConnection3 == refConnection) {
                    SequentialDisposable sequentialDisposable2 = refConnection.f14110m;
                    if (sequentialDisposable2 != null) {
                        sequentialDisposable2.dispose();
                        refConnection.f14110m = null;
                    }
                    long j11 = refConnection.f14111n - 1;
                    refConnection.f14111n = j11;
                    if (j11 == 0) {
                        this.f14108q = null;
                        df.a<T> aVar2 = this.f14103b;
                        if (aVar2 instanceof b) {
                            ((b) aVar2).dispose();
                        } else if (aVar2 instanceof c) {
                            ((c) aVar2).resetIf(refConnection.get());
                        }
                    }
                }
            }
        }
    }

    public final void b(RefConnection refConnection) {
        synchronized (this) {
            if (refConnection.f14111n == 0 && refConnection == this.f14108q) {
                this.f14108q = null;
                b bVar = refConnection.get();
                DisposableHelper.dispose(refConnection);
                df.a<T> aVar = this.f14103b;
                if (aVar instanceof b) {
                    ((b) aVar).dispose();
                } else if (aVar instanceof c) {
                    if (bVar == null) {
                        refConnection.f14113p = true;
                    } else {
                        ((c) aVar).resetIf(bVar);
                    }
                }
            }
        }
    }

    @Override // ne.k
    public void subscribeActual(q<? super T> qVar) {
        RefConnection refConnection;
        boolean z10;
        SequentialDisposable sequentialDisposable;
        synchronized (this) {
            refConnection = this.f14108q;
            if (refConnection == null) {
                refConnection = new RefConnection(this);
                this.f14108q = refConnection;
            }
            long j10 = refConnection.f14111n;
            if (j10 == 0 && (sequentialDisposable = refConnection.f14110m) != null) {
                sequentialDisposable.dispose();
            }
            long j11 = j10 + 1;
            refConnection.f14111n = j11;
            if (refConnection.f14112o || j11 != this.f14104m) {
                z10 = false;
            } else {
                z10 = true;
                refConnection.f14112o = true;
            }
        }
        this.f14103b.subscribe(new RefCountObserver(qVar, this, refConnection));
        if (z10) {
            this.f14103b.connect(refConnection);
        }
    }

    public ObservableRefCount(df.a<T> aVar, int i10, long j10, TimeUnit timeUnit, r rVar) {
        this.f14103b = aVar;
        this.f14104m = i10;
        this.f14105n = j10;
        this.f14106o = timeUnit;
        this.f14107p = rVar;
    }
}
