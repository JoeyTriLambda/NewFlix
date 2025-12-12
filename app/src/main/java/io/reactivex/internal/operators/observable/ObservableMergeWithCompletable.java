package io.reactivex.internal.operators.observable;

import cf.f;
import io.reactivex.internal.disposables.DisposableHelper;
import io.reactivex.internal.util.AtomicThrowable;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.concurrent.atomic.AtomicReference;
import ne.c;
import ne.k;
import ne.q;
import qe.b;

/* loaded from: classes2.dex */
public final class ObservableMergeWithCompletable<T> extends ye.a<T, T> {

    /* renamed from: m, reason: collision with root package name */
    public final c f14022m;

    public static final class MergeWithObserver<T> extends AtomicInteger implements q<T>, b {
        private static final long serialVersionUID = -4592979584110982903L;

        /* renamed from: b, reason: collision with root package name */
        public final q<? super T> f14023b;

        /* renamed from: m, reason: collision with root package name */
        public final AtomicReference<b> f14024m = new AtomicReference<>();

        /* renamed from: n, reason: collision with root package name */
        public final OtherObserver f14025n = new OtherObserver(this);

        /* renamed from: o, reason: collision with root package name */
        public final AtomicThrowable f14026o = new AtomicThrowable();

        /* renamed from: p, reason: collision with root package name */
        public volatile boolean f14027p;

        /* renamed from: q, reason: collision with root package name */
        public volatile boolean f14028q;

        public static final class OtherObserver extends AtomicReference<b> implements ne.b {
            private static final long serialVersionUID = -2935427570954647017L;

            /* renamed from: b, reason: collision with root package name */
            public final MergeWithObserver<?> f14029b;

            public OtherObserver(MergeWithObserver<?> mergeWithObserver) {
                this.f14029b = mergeWithObserver;
            }

            @Override // ne.b
            public void onComplete() {
                MergeWithObserver<?> mergeWithObserver = this.f14029b;
                mergeWithObserver.f14028q = true;
                if (mergeWithObserver.f14027p) {
                    f.onComplete(mergeWithObserver.f14023b, mergeWithObserver, mergeWithObserver.f14026o);
                }
            }

            @Override // ne.b
            public void onError(Throwable th2) {
                MergeWithObserver<?> mergeWithObserver = this.f14029b;
                DisposableHelper.dispose(mergeWithObserver.f14024m);
                f.onError(mergeWithObserver.f14023b, th2, mergeWithObserver, mergeWithObserver.f14026o);
            }

            @Override // ne.b
            public void onSubscribe(b bVar) {
                DisposableHelper.setOnce(this, bVar);
            }
        }

        public MergeWithObserver(q<? super T> qVar) {
            this.f14023b = qVar;
        }

        @Override // qe.b
        public void dispose() {
            DisposableHelper.dispose(this.f14024m);
            DisposableHelper.dispose(this.f14025n);
        }

        @Override // ne.q
        public void onComplete() {
            this.f14027p = true;
            if (this.f14028q) {
                f.onComplete(this.f14023b, this, this.f14026o);
            }
        }

        @Override // ne.q
        public void onError(Throwable th2) {
            DisposableHelper.dispose(this.f14025n);
            f.onError(this.f14023b, th2, this, this.f14026o);
        }

        @Override // ne.q
        public void onNext(T t10) {
            f.onNext(this.f14023b, t10, this, this.f14026o);
        }

        @Override // ne.q
        public void onSubscribe(b bVar) {
            DisposableHelper.setOnce(this.f14024m, bVar);
        }
    }

    public ObservableMergeWithCompletable(k<T> kVar, c cVar) {
        super(kVar);
        this.f14022m = cVar;
    }

    @Override // ne.k
    public void subscribeActual(q<? super T> qVar) {
        MergeWithObserver mergeWithObserver = new MergeWithObserver(qVar);
        qVar.onSubscribe(mergeWithObserver);
        this.f22058b.subscribe(mergeWithObserver);
        this.f14022m.subscribe(mergeWithObserver.f14025n);
    }
}
