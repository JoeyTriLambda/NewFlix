package io.reactivex.internal.operators.flowable;

import io.reactivex.exceptions.MissingBackpressureException;
import io.reactivex.internal.subscriptions.SubscriptionHelper;
import java.util.concurrent.atomic.AtomicLong;
import ne.e;
import ne.f;
import xe.a;
import zh.b;
import zh.c;

/* loaded from: classes2.dex */
public final class FlowableOnBackpressureError<T> extends a<T, T> {

    public static final class BackpressureErrorSubscriber<T> extends AtomicLong implements f<T>, c {
        private static final long serialVersionUID = -3176480756392482682L;

        /* renamed from: b, reason: collision with root package name */
        public final b<? super T> f13605b;

        /* renamed from: m, reason: collision with root package name */
        public c f13606m;

        /* renamed from: n, reason: collision with root package name */
        public boolean f13607n;

        public BackpressureErrorSubscriber(b<? super T> bVar) {
            this.f13605b = bVar;
        }

        @Override // zh.c
        public void cancel() {
            this.f13606m.cancel();
        }

        @Override // zh.b
        public void onComplete() {
            if (this.f13607n) {
                return;
            }
            this.f13607n = true;
            this.f13605b.onComplete();
        }

        @Override // zh.b
        public void onError(Throwable th2) {
            if (this.f13607n) {
                ff.a.onError(th2);
            } else {
                this.f13607n = true;
                this.f13605b.onError(th2);
            }
        }

        @Override // zh.b
        public void onNext(T t10) {
            if (this.f13607n) {
                return;
            }
            if (get() == 0) {
                onError(new MissingBackpressureException("could not emit value due to lack of requests"));
            } else {
                this.f13605b.onNext(t10);
                cf.b.produced(this, 1L);
            }
        }

        @Override // zh.b
        public void onSubscribe(c cVar) {
            if (SubscriptionHelper.validate(this.f13606m, cVar)) {
                this.f13606m = cVar;
                this.f13605b.onSubscribe(this);
                cVar.request(Long.MAX_VALUE);
            }
        }

        @Override // zh.c
        public void request(long j10) {
            if (SubscriptionHelper.validate(j10)) {
                cf.b.add(this, j10);
            }
        }
    }

    public FlowableOnBackpressureError(e<T> eVar) {
        super(eVar);
    }

    @Override // ne.e
    public void subscribeActual(b<? super T> bVar) {
        this.f21749m.subscribe((f) new BackpressureErrorSubscriber(bVar));
    }
}
