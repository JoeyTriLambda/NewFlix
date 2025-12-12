package io.reactivex.internal.operators.observable;

// REMOVED: Malware import
import io.reactivex.internal.disposables.DisposableHelper;
import io.reactivex.internal.util.AtomicThrowable;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.concurrent.atomic.AtomicReference;
import ne.k;
import ne.q;
import ne.t;
import ne.u;
import qe.b;

/* loaded from: classes2.dex */
public final class ObservableMergeWithSingle<T> extends ye.a<T, T> {

    /* renamed from: m, reason: collision with root package name */
    public final u<? extends T> f14041m;

    public static final class MergeWithObserver<T> extends AtomicInteger implements q<T>, b {
        private static final long serialVersionUID = -4592979584110982903L;

        /* renamed from: b, reason: collision with root package name */
        public final q<? super T> f14042b;

        /* renamed from: m, reason: collision with root package name */
        public final AtomicReference<b> f14043m = new AtomicReference<>();

        /* renamed from: n, reason: collision with root package name */
        public final OtherObserver<T> f14044n = new OtherObserver<>(this);

        /* renamed from: o, reason: collision with root package name */
        public final AtomicThrowable f14045o = new AtomicThrowable();

        /* renamed from: p, reason: collision with root package name */
        public volatile af.a f14046p;

        /* renamed from: q, reason: collision with root package name */
        public T f14047q;

        /* renamed from: r, reason: collision with root package name */
        public volatile boolean f14048r;

        /* renamed from: s, reason: collision with root package name */
        public volatile boolean f14049s;

        /* renamed from: t, reason: collision with root package name */
        public volatile int f14050t;

        public static final class OtherObserver<T> extends AtomicReference<b> implements t<T> {
            private static final long serialVersionUID = -2935427570954647017L;

            /* renamed from: b, reason: collision with root package name */
            public final MergeWithObserver<T> f14051b;

            public OtherObserver(MergeWithObserver<T> mergeWithObserver) {
                this.f14051b = mergeWithObserver;
            }

            @Override // ne.t
            public void onError(Throwable th2) {
                MergeWithObserver<T> mergeWithObserver = this.f14051b;
                if (!mergeWithObserver.f14045o.addThrowable(th2)) {
                    ff.a.onError(th2);
                    return;
                }
                DisposableHelper.dispose(mergeWithObserver.f14043m);
                if (mergeWithObserver.getAndIncrement() == 0) {
                    mergeWithObserver.a();
                }
            }

            @Override // ne.t
            public void onSubscribe(b bVar) {
                DisposableHelper.setOnce(this, bVar);
            }

            @Override // ne.t
            public void onSuccess(T t10) {
                MergeWithObserver<T> mergeWithObserver = this.f14051b;
                if (mergeWithObserver.compareAndSet(0, 1)) {
                    mergeWithObserver.f14042b.onNext(t10);
                    mergeWithObserver.f14050t = 2;
                } else {
                    mergeWithObserver.f14047q = t10;
                    mergeWithObserver.f14050t = 1;
                    if (mergeWithObserver.getAndIncrement() != 0) {
                        return;
                    }
                }
                mergeWithObserver.a();
            }
        }

        public MergeWithObserver(q<? super T> qVar) {
            this.f14042b = qVar;
        }

        public final void a() {
            q<? super T> qVar = this.f14042b;
            int iAddAndGet = 1;
            while (!this.f14048r) {
                if (this.f14045o.get() != null) {
                    this.f14047q = null;
                    this.f14046p = null;
                    qVar.onError(this.f14045o.terminate());
                    return;
                }
                int i10 = this.f14050t;
                if (i10 == 1) {
                    T t10 = this.f14047q;
                    this.f14047q = null;
                    this.f14050t = 2;
                    qVar.onNext(t10);
                    i10 = 2;
                }
                boolean z10 = this.f14049s;
                af.a aVar = this.f14046p;
                MProxy mProxyPoll = aVar != null ? aVar.poll() : null;
                boolean z11 = mProxyPoll == null;
                if (z10 && z11 && i10 == 2) {
                    this.f14046p = null;
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
            this.f14047q = null;
            this.f14046p = null;
        }

        @Override // qe.b
        public void dispose() {
            this.f14048r = true;
            DisposableHelper.dispose(this.f14043m);
            DisposableHelper.dispose(this.f14044n);
            if (getAndIncrement() == 0) {
                this.f14046p = null;
                this.f14047q = null;
            }
        }

        @Override // ne.q
        public void onComplete() {
            this.f14049s = true;
            if (getAndIncrement() == 0) {
                a();
            }
        }

        @Override // ne.q
        public void onError(Throwable th2) {
            if (!this.f14045o.addThrowable(th2)) {
                ff.a.onError(th2);
                return;
            }
            DisposableHelper.dispose(this.f14044n);
            if (getAndIncrement() == 0) {
                a();
            }
        }

        @Override // ne.q
        public void onNext(T t10) {
            if (compareAndSet(0, 1)) {
                this.f14042b.onNext(t10);
                if (decrementAndGet() == 0) {
                    return;
                }
            } else {
                af.a aVar = this.f14046p;
                if (aVar == null) {
                    aVar = new af.a(k.bufferSize());
                    this.f14046p = aVar;
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
            DisposableHelper.setOnce(this.f14043m, bVar);
        }
    }

    public ObservableMergeWithSingle(k<T> kVar, u<? extends T> uVar) {
        super(kVar);
        this.f14041m = uVar;
    }

    @Override // ne.k
    public void subscribeActual(q<? super T> qVar) {
        MergeWithObserver mergeWithObserver = new MergeWithObserver(qVar);
        qVar.onSubscribe(mergeWithObserver);
        this.f22058b.subscribe(mergeWithObserver);
        this.f14041m.subscribe(mergeWithObserver.f14044n);
    }
}
