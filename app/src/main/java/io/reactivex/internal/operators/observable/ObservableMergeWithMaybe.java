package io.reactivex.internal.operators.observable;

// REMOVED: Malware import
import io.reactivex.internal.disposables.DisposableHelper;
import io.reactivex.internal.util.AtomicThrowable;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.concurrent.atomic.AtomicReference;
import ne.h;
import ne.i;
import ne.k;
import ne.q;
import qe.b;

/* loaded from: classes2.dex */
public final class ObservableMergeWithMaybe<T> extends ye.a<T, T> {

    /* renamed from: m, reason: collision with root package name */
    public final i<? extends T> f14030m;

    public static final class MergeWithObserver<T> extends AtomicInteger implements q<T>, b {
        private static final long serialVersionUID = -4592979584110982903L;

        /* renamed from: b, reason: collision with root package name */
        public final q<? super T> f14031b;

        /* renamed from: m, reason: collision with root package name */
        public final AtomicReference<b> f14032m = new AtomicReference<>();

        /* renamed from: n, reason: collision with root package name */
        public final OtherObserver<T> f14033n = new OtherObserver<>(this);

        /* renamed from: o, reason: collision with root package name */
        public final AtomicThrowable f14034o = new AtomicThrowable();

        /* renamed from: p, reason: collision with root package name */
        public volatile af.a f14035p;

        /* renamed from: q, reason: collision with root package name */
        public T f14036q;

        /* renamed from: r, reason: collision with root package name */
        public volatile boolean f14037r;

        /* renamed from: s, reason: collision with root package name */
        public volatile boolean f14038s;

        /* renamed from: t, reason: collision with root package name */
        public volatile int f14039t;

        public static final class OtherObserver<T> extends AtomicReference<b> implements h<T> {
            private static final long serialVersionUID = -2935427570954647017L;

            /* renamed from: b, reason: collision with root package name */
            public final MergeWithObserver<T> f14040b;

            public OtherObserver(MergeWithObserver<T> mergeWithObserver) {
                this.f14040b = mergeWithObserver;
            }

            @Override // ne.h
            public void onComplete() {
                MergeWithObserver<T> mergeWithObserver = this.f14040b;
                mergeWithObserver.f14039t = 2;
                if (mergeWithObserver.getAndIncrement() == 0) {
                    mergeWithObserver.a();
                }
            }

            @Override // ne.h
            public void onError(Throwable th2) {
                MergeWithObserver<T> mergeWithObserver = this.f14040b;
                if (!mergeWithObserver.f14034o.addThrowable(th2)) {
                    ff.a.onError(th2);
                    return;
                }
                DisposableHelper.dispose(mergeWithObserver.f14032m);
                if (mergeWithObserver.getAndIncrement() == 0) {
                    mergeWithObserver.a();
                }
            }

            @Override // ne.h
            public void onSubscribe(b bVar) {
                DisposableHelper.setOnce(this, bVar);
            }

            @Override // ne.h
            public void onSuccess(T t10) {
                MergeWithObserver<T> mergeWithObserver = this.f14040b;
                if (mergeWithObserver.compareAndSet(0, 1)) {
                    mergeWithObserver.f14031b.onNext(t10);
                    mergeWithObserver.f14039t = 2;
                } else {
                    mergeWithObserver.f14036q = t10;
                    mergeWithObserver.f14039t = 1;
                    if (mergeWithObserver.getAndIncrement() != 0) {
                        return;
                    }
                }
                mergeWithObserver.a();
            }
        }

        public MergeWithObserver(q<? super T> qVar) {
            this.f14031b = qVar;
        }

        public final void a() {
            q<? super T> qVar = this.f14031b;
            int iAddAndGet = 1;
            while (!this.f14037r) {
                if (this.f14034o.get() != null) {
                    this.f14036q = null;
                    this.f14035p = null;
                    qVar.onError(this.f14034o.terminate());
                    return;
                }
                int i10 = this.f14039t;
                if (i10 == 1) {
                    T t10 = this.f14036q;
                    this.f14036q = null;
                    this.f14039t = 2;
                    qVar.onNext(t10);
                    i10 = 2;
                }
                boolean z10 = this.f14038s;
                af.a aVar = this.f14035p;
                MProxy mProxyPoll = aVar != null ? aVar.poll() : null;
                boolean z11 = mProxyPoll == null;
                if (z10 && z11 && i10 == 2) {
                    this.f14035p = null;
                    qVar.onComplete();
                    return;
                } else if (z11) {
                    iAddAndGet = addAndGet(-iAddAndGet);
                    if (iAddAndGet == 0) {
                        return;
                    }
                } else {
                    qVar.onNext(mProxyPoll);
                }
            }
            this.f14036q = null;
            this.f14035p = null;
        }

        @Override // qe.b
        public void dispose() {
            this.f14037r = true;
            DisposableHelper.dispose(this.f14032m);
            DisposableHelper.dispose(this.f14033n);
            if (getAndIncrement() == 0) {
                this.f14035p = null;
                this.f14036q = null;
            }
        }

        @Override // ne.q
        public void onComplete() {
            this.f14038s = true;
            if (getAndIncrement() == 0) {
                a();
            }
        }

        @Override // ne.q
        public void onError(Throwable th2) {
            if (!this.f14034o.addThrowable(th2)) {
                ff.a.onError(th2);
                return;
            }
            DisposableHelper.dispose(this.f14033n);
            if (getAndIncrement() == 0) {
                a();
            }
        }

        @Override // ne.q
        public void onNext(T t10) {
            if (compareAndSet(0, 1)) {
                this.f14031b.onNext(t10);
                if (decrementAndGet() == 0) {
                    return;
                }
            } else {
                af.a aVar = this.f14035p;
                if (aVar == null) {
                    aVar = new af.a(k.bufferSize());
                    this.f14035p = aVar;
                }
                aVar.offer(t10);
                if (getAndIncrement() != 0) {
                    return;
                }
            }
            a();
        }

        @Override // ne.q
        public void onSubscribe(b bVar) {
            DisposableHelper.setOnce(this.f14032m, bVar);
        }
    }

    public ObservableMergeWithMaybe(k<T> kVar, i<? extends T> iVar) {
        super(kVar);
        this.f14030m = iVar;
    }

    @Override // ne.k
    public void subscribeActual(q<? super T> qVar) {
        MergeWithObserver mergeWithObserver = new MergeWithObserver(qVar);
        qVar.onSubscribe(mergeWithObserver);
        this.f22058b.subscribe(mergeWithObserver);
        this.f14030m.subscribe(mergeWithObserver.f14033n);
    }
}
