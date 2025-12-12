package io.reactivex.internal.operators.flowable;

import io.reactivex.internal.subscriptions.SubscriptionHelper;
import java.util.concurrent.atomic.AtomicLong;
import ne.e;
import se.f;
import xe.a;
import zh.b;
import zh.c;

/* loaded from: classes2.dex */
public final class FlowableOnBackpressureDrop<T> extends a<T, T> implements f<T> {

    /* renamed from: n, reason: collision with root package name */
    public final FlowableOnBackpressureDrop f13600n;

    public static final class BackpressureDropSubscriber<T> extends AtomicLong implements ne.f<T>, c {
        private static final long serialVersionUID = -6246093802440953054L;

        /* renamed from: b, reason: collision with root package name */
        public final b<? super T> f13601b;

        /* renamed from: m, reason: collision with root package name */
        public final f<? super T> f13602m;

        /* renamed from: n, reason: collision with root package name */
        public c f13603n;

        /* renamed from: o, reason: collision with root package name */
        public boolean f13604o;

        public BackpressureDropSubscriber(b bVar, FlowableOnBackpressureDrop flowableOnBackpressureDrop) {
            this.f13601b = bVar;
            this.f13602m = flowableOnBackpressureDrop;
        }

        @Override // zh.c
        public void cancel() {
            this.f13603n.cancel();
        }

        @Override // zh.b
        public void onComplete() {
            if (this.f13604o) {
                return;
            }
            this.f13604o = true;
            this.f13601b.onComplete();
        }

        @Override // zh.b
        public void onError(Throwable th2) {
            if (this.f13604o) {
                ff.a.onError(th2);
            } else {
                this.f13604o = true;
                this.f13601b.onError(th2);
            }
        }

        @Override // zh.b
        public void onNext(T t10) {
            if (this.f13604o) {
                return;
            }
            if (get() != 0) {
                this.f13601b.onNext(t10);
                cf.b.produced(this, 1L);
                return;
            }
            try {
                this.f13602m.accept(t10);
            } catch (Throwable th2) {
                re.a.throwIfFatal(th2);
                cancel();
                onError(th2);
            }
        }

        @Override // zh.b
        public void onSubscribe(c cVar) {
            if (SubscriptionHelper.validate(this.f13603n, cVar)) {
                this.f13603n = cVar;
                this.f13601b.onSubscribe(this);
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

    public FlowableOnBackpressureDrop(e<T> eVar) {
        super(eVar);
        this.f13600n = this;
    }

    @Override // ne.e
    public void subscribeActual(b<? super T> bVar) {
        this.f21749m.subscribe((ne.f) new BackpressureDropSubscriber(bVar, this.f13600n));
    }

    @Override // se.f
    public void accept(T t10) {
    }
}
