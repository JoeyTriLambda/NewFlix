package io.reactivex.internal.operators.flowable;

import io.reactivex.internal.subscriptions.SubscriptionHelper;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.concurrent.atomic.AtomicLong;
import java.util.concurrent.atomic.AtomicReference;
import ne.e;
import ne.f;
import xe.a;
import zh.b;
import zh.c;

/* loaded from: classes2.dex */
public final class FlowableOnBackpressureLatest<T> extends a<T, T> {

    public static final class BackpressureLatestSubscriber<T> extends AtomicInteger implements f<T>, c {
        private static final long serialVersionUID = 163080509307634843L;

        /* renamed from: b, reason: collision with root package name */
        public final b<? super T> f13608b;

        /* renamed from: m, reason: collision with root package name */
        public c f13609m;

        /* renamed from: n, reason: collision with root package name */
        public volatile boolean f13610n;

        /* renamed from: o, reason: collision with root package name */
        public Throwable f13611o;

        /* renamed from: p, reason: collision with root package name */
        public volatile boolean f13612p;

        /* renamed from: q, reason: collision with root package name */
        public final AtomicLong f13613q = new AtomicLong();

        /* renamed from: r, reason: collision with root package name */
        public final AtomicReference<T> f13614r = new AtomicReference<>();

        public BackpressureLatestSubscriber(b<? super T> bVar) {
            this.f13608b = bVar;
        }

        public final boolean a(boolean z10, boolean z11, b<?> bVar, AtomicReference<T> atomicReference) {
            if (this.f13612p) {
                atomicReference.lazySet(null);
                return true;
            }
            if (!z10) {
                return false;
            }
            Throwable th2 = this.f13611o;
            if (th2 != null) {
                atomicReference.lazySet(null);
                bVar.onError(th2);
                return true;
            }
            if (!z11) {
                return false;
            }
            bVar.onComplete();
            return true;
        }

        /* JADX WARN: Code restructure failed: missing block: B:20:0x003e, code lost:
        
            if (r7 != r1.get()) goto L27;
         */
        /* JADX WARN: Code restructure failed: missing block: B:21:0x0040, code lost:
        
            r9 = r13.f13610n;
         */
        /* JADX WARN: Code restructure failed: missing block: B:22:0x0046, code lost:
        
            if (r2.get() != null) goto L24;
         */
        /* JADX WARN: Code restructure failed: missing block: B:23:0x0048, code lost:
        
            r11 = true;
         */
        /* JADX WARN: Code restructure failed: missing block: B:25:0x004d, code lost:
        
            if (a(r9, r11, r0, r2) == false) goto L27;
         */
        /* JADX WARN: Code restructure failed: missing block: B:26:0x004f, code lost:
        
            return;
         */
        /* JADX WARN: Code restructure failed: missing block: B:28:0x0052, code lost:
        
            if (r7 == 0) goto L30;
         */
        /* JADX WARN: Code restructure failed: missing block: B:29:0x0054, code lost:
        
            cf.b.produced(r1, r7);
         */
        /* JADX WARN: Code restructure failed: missing block: B:30:0x0057, code lost:
        
            r4 = addAndGet(-r4);
         */
        /*
            Code decompiled incorrectly, please refer to instructions dump.
            To view partially-correct code enable 'Show inconsistent code' option in preferences
        */
        public final void b() {
            /*
                r13 = this;
                int r0 = r13.getAndIncrement()
                if (r0 == 0) goto L7
                return
            L7:
                zh.b<? super T> r0 = r13.f13608b
                java.util.concurrent.atomic.AtomicLong r1 = r13.f13613q
                java.util.concurrent.atomic.AtomicReference<T> r2 = r13.f13614r
                r3 = 1
                r4 = 1
            Lf:
                r5 = 0
                r7 = r5
            L12:
                long r9 = r1.get()
                r11 = 0
                int r12 = (r7 > r9 ? 1 : (r7 == r9 ? 0 : -1))
                if (r12 == 0) goto L38
                boolean r9 = r13.f13610n
                r10 = 0
                java.lang.Object r10 = r2.getAndSet(r10)
                if (r10 != 0) goto L26
                r12 = 1
                goto L27
            L26:
                r12 = 0
            L27:
                boolean r9 = r13.a(r9, r12, r0, r2)
                if (r9 == 0) goto L2e
                return
            L2e:
                if (r12 == 0) goto L31
                goto L38
            L31:
                r0.onNext(r10)
                r9 = 1
                long r7 = r7 + r9
                goto L12
            L38:
                long r9 = r1.get()
                int r12 = (r7 > r9 ? 1 : (r7 == r9 ? 0 : -1))
                if (r12 != 0) goto L50
                boolean r9 = r13.f13610n
                java.lang.Object r10 = r2.get()
                if (r10 != 0) goto L49
                r11 = 1
            L49:
                boolean r9 = r13.a(r9, r11, r0, r2)
                if (r9 == 0) goto L50
                return
            L50:
                int r9 = (r7 > r5 ? 1 : (r7 == r5 ? 0 : -1))
                if (r9 == 0) goto L57
                cf.b.produced(r1, r7)
            L57:
                int r4 = -r4
                int r4 = r13.addAndGet(r4)
                if (r4 != 0) goto Lf
                return
            */
            throw new UnsupportedOperationException("Method not decompiled: io.reactivex.internal.operators.flowable.FlowableOnBackpressureLatest.BackpressureLatestSubscriber.b():void");
        }

        @Override // zh.c
        public void cancel() {
            if (this.f13612p) {
                return;
            }
            this.f13612p = true;
            this.f13609m.cancel();
            if (getAndIncrement() == 0) {
                this.f13614r.lazySet(null);
            }
        }

        @Override // zh.b
        public void onComplete() {
            this.f13610n = true;
            b();
        }

        @Override // zh.b
        public void onError(Throwable th2) {
            this.f13611o = th2;
            this.f13610n = true;
            b();
        }

        @Override // zh.b
        public void onNext(T t10) {
            this.f13614r.lazySet(t10);
            b();
        }

        @Override // zh.b
        public void onSubscribe(c cVar) {
            if (SubscriptionHelper.validate(this.f13609m, cVar)) {
                this.f13609m = cVar;
                this.f13608b.onSubscribe(this);
                cVar.request(Long.MAX_VALUE);
            }
        }

        @Override // zh.c
        public void request(long j10) {
            if (SubscriptionHelper.validate(j10)) {
                cf.b.add(this.f13613q, j10);
                b();
            }
        }
    }

    public FlowableOnBackpressureLatest(e<T> eVar) {
        super(eVar);
    }

    @Override // ne.e
    public void subscribeActual(b<? super T> bVar) {
        this.f21749m.subscribe((f) new BackpressureLatestSubscriber(bVar));
    }
}
