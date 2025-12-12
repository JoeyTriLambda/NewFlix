package io.reactivex.internal.operators.observable;

import java.util.concurrent.atomic.AtomicBoolean;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.concurrent.atomic.AtomicReference;
import ne.k;
import ne.q;
import qe.b;

/* loaded from: classes2.dex */
public final class ObservableCache<T> extends ye.a<T, T> implements q<T> {

    /* renamed from: v, reason: collision with root package name */
    public static final CacheDisposable[] f13754v = new CacheDisposable[0];

    /* renamed from: w, reason: collision with root package name */
    public static final CacheDisposable[] f13755w = new CacheDisposable[0];

    /* renamed from: m, reason: collision with root package name */
    public final AtomicBoolean f13756m;

    /* renamed from: n, reason: collision with root package name */
    public final int f13757n;

    /* renamed from: o, reason: collision with root package name */
    public final AtomicReference<CacheDisposable<T>[]> f13758o;

    /* renamed from: p, reason: collision with root package name */
    public volatile long f13759p;

    /* renamed from: q, reason: collision with root package name */
    public final a<T> f13760q;

    /* renamed from: r, reason: collision with root package name */
    public a<T> f13761r;

    /* renamed from: s, reason: collision with root package name */
    public int f13762s;

    /* renamed from: t, reason: collision with root package name */
    public Throwable f13763t;

    /* renamed from: u, reason: collision with root package name */
    public volatile boolean f13764u;

    public static final class CacheDisposable<T> extends AtomicInteger implements b {
        private static final long serialVersionUID = 6770240836423125754L;

        /* renamed from: b, reason: collision with root package name */
        public final q<? super T> f13765b;

        /* renamed from: m, reason: collision with root package name */
        public final ObservableCache<T> f13766m;

        /* renamed from: n, reason: collision with root package name */
        public a<T> f13767n;

        /* renamed from: o, reason: collision with root package name */
        public int f13768o;

        /* renamed from: p, reason: collision with root package name */
        public long f13769p;

        /* renamed from: q, reason: collision with root package name */
        public volatile boolean f13770q;

        public CacheDisposable(q<? super T> qVar, ObservableCache<T> observableCache) {
            this.f13765b = qVar;
            this.f13766m = observableCache;
            this.f13767n = observableCache.f13760q;
        }

        @Override // qe.b
        public void dispose() {
            boolean z10;
            CacheDisposable<T>[] cacheDisposableArr;
            if (this.f13770q) {
                return;
            }
            this.f13770q = true;
            ObservableCache<T> observableCache = this.f13766m;
            do {
                AtomicReference<CacheDisposable<T>[]> atomicReference = observableCache.f13758o;
                CacheDisposable<T>[] cacheDisposableArr2 = atomicReference.get();
                int length = cacheDisposableArr2.length;
                if (length == 0) {
                    return;
                }
                z10 = false;
                int i10 = 0;
                while (true) {
                    if (i10 >= length) {
                        i10 = -1;
                        break;
                    } else if (cacheDisposableArr2[i10] == this) {
                        break;
                    } else {
                        i10++;
                    }
                }
                if (i10 < 0) {
                    return;
                }
                if (length == 1) {
                    cacheDisposableArr = ObservableCache.f13754v;
                } else {
                    CacheDisposable<T>[] cacheDisposableArr3 = new CacheDisposable[length - 1];
                    System.arraycopy(cacheDisposableArr2, 0, cacheDisposableArr3, 0, i10);
                    System.arraycopy(cacheDisposableArr2, i10 + 1, cacheDisposableArr3, i10, (length - i10) - 1);
                    cacheDisposableArr = cacheDisposableArr3;
                }
                while (true) {
                    if (atomicReference.compareAndSet(cacheDisposableArr2, cacheDisposableArr)) {
                        z10 = true;
                        break;
                    } else if (atomicReference.get() != cacheDisposableArr2) {
                        break;
                    }
                }
            } while (!z10);
        }
    }

    public static final class a<T> {

        /* renamed from: a, reason: collision with root package name */
        public final T[] f13771a;

        /* renamed from: b, reason: collision with root package name */
        public volatile a<T> f13772b;

        public a(int i10) {
            this.f13771a = (T[]) new Object[i10];
        }
    }

    public ObservableCache(k<T> kVar, int i10) {
        super(kVar);
        this.f13757n = i10;
        this.f13756m = new AtomicBoolean();
        a<T> aVar = new a<>(i10);
        this.f13760q = aVar;
        this.f13761r = aVar;
        this.f13758o = new AtomicReference<>(f13754v);
    }

    public final void a(CacheDisposable<T> cacheDisposable) {
        if (cacheDisposable.getAndIncrement() != 0) {
            return;
        }
        long j10 = cacheDisposable.f13769p;
        int i10 = cacheDisposable.f13768o;
        a<T> aVar = cacheDisposable.f13767n;
        q<? super T> qVar = cacheDisposable.f13765b;
        int i11 = this.f13757n;
        int iAddAndGet = 1;
        while (!cacheDisposable.f13770q) {
            boolean z10 = this.f13764u;
            boolean z11 = this.f13759p == j10;
            if (z10 && z11) {
                cacheDisposable.f13767n = null;
                Throwable th2 = this.f13763t;
                if (th2 != null) {
                    qVar.onError(th2);
                    return;
                } else {
                    qVar.onComplete();
                    return;
                }
            }
            if (z11) {
                cacheDisposable.f13769p = j10;
                cacheDisposable.f13768o = i10;
                cacheDisposable.f13767n = aVar;
                iAddAndGet = cacheDisposable.addAndGet(-iAddAndGet);
                if (iAddAndGet == 0) {
                    return;
                }
            } else {
                if (i10 == i11) {
                    aVar = aVar.f13772b;
                    i10 = 0;
                }
                qVar.onNext(aVar.f13771a[i10]);
                i10++;
                j10++;
            }
        }
        cacheDisposable.f13767n = null;
    }

    @Override // ne.q
    public void onComplete() {
        this.f13764u = true;
        for (CacheDisposable<T> cacheDisposable : this.f13758o.getAndSet(f13755w)) {
            a(cacheDisposable);
        }
    }

    @Override // ne.q
    public void onError(Throwable th2) {
        this.f13763t = th2;
        this.f13764u = true;
        for (CacheDisposable<T> cacheDisposable : this.f13758o.getAndSet(f13755w)) {
            a(cacheDisposable);
        }
    }

    @Override // ne.q
    public void onNext(T t10) {
        int i10 = this.f13762s;
        if (i10 == this.f13757n) {
            a<T> aVar = new a<>(i10);
            aVar.f13771a[0] = t10;
            this.f13762s = 1;
            this.f13761r.f13772b = aVar;
            this.f13761r = aVar;
        } else {
            this.f13761r.f13771a[i10] = t10;
            this.f13762s = i10 + 1;
        }
        this.f13759p++;
        for (CacheDisposable<T> cacheDisposable : this.f13758o.get()) {
            a(cacheDisposable);
        }
    }

    @Override // ne.k
    public void subscribeActual(q<? super T> qVar) {
        boolean z10;
        CacheDisposable<T> cacheDisposable = new CacheDisposable<>(qVar, this);
        qVar.onSubscribe(cacheDisposable);
        do {
            AtomicReference<CacheDisposable<T>[]> atomicReference = this.f13758o;
            CacheDisposable<T>[] cacheDisposableArr = atomicReference.get();
            if (cacheDisposableArr == f13755w) {
                break;
            }
            int length = cacheDisposableArr.length;
            CacheDisposable<T>[] cacheDisposableArr2 = new CacheDisposable[length + 1];
            System.arraycopy(cacheDisposableArr, 0, cacheDisposableArr2, 0, length);
            cacheDisposableArr2[length] = cacheDisposable;
            while (true) {
                if (atomicReference.compareAndSet(cacheDisposableArr, cacheDisposableArr2)) {
                    z10 = true;
                    break;
                } else if (atomicReference.get() != cacheDisposableArr) {
                    z10 = false;
                    break;
                }
            }
        } while (!z10);
        AtomicBoolean atomicBoolean = this.f13756m;
        if (atomicBoolean.get() || !atomicBoolean.compareAndSet(false, true)) {
            a(cacheDisposable);
        } else {
            this.f22058b.subscribe(this);
        }
    }

    @Override // ne.q
    public void onSubscribe(b bVar) {
    }
}
