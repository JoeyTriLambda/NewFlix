package io.reactivex.internal.operators.flowable;

import io.reactivex.exceptions.MissingBackpressureException;
import io.reactivex.internal.queue.SpscArrayQueue;
import io.reactivex.internal.subscriptions.BasicIntQueueSubscription;
import io.reactivex.internal.subscriptions.SubscriptionHelper;
import java.util.concurrent.atomic.AtomicLong;
import ne.f;
import ve.e;
import xe.a;
import zh.b;
import zh.c;

/* loaded from: classes2.dex */
public final class FlowableOnBackpressureBuffer<T> extends a<T, T> {

    /* renamed from: n, reason: collision with root package name */
    public final int f13587n;

    /* renamed from: o, reason: collision with root package name */
    public final boolean f13588o;

    /* renamed from: p, reason: collision with root package name */
    public final boolean f13589p;

    /* renamed from: q, reason: collision with root package name */
    public final se.a f13590q;

    public static final class BackpressureBufferSubscriber<T> extends BasicIntQueueSubscription<T> implements f<T> {
        private static final long serialVersionUID = -2514538129242366402L;

        /* renamed from: b, reason: collision with root package name */
        public final b<? super T> f13591b;

        /* renamed from: m, reason: collision with root package name */
        public final e<T> f13592m;

        /* renamed from: n, reason: collision with root package name */
        public final boolean f13593n;

        /* renamed from: o, reason: collision with root package name */
        public final se.a f13594o;

        /* renamed from: p, reason: collision with root package name */
        public c f13595p;

        /* renamed from: q, reason: collision with root package name */
        public volatile boolean f13596q;

        /* renamed from: r, reason: collision with root package name */
        public volatile boolean f13597r;

        /* renamed from: s, reason: collision with root package name */
        public Throwable f13598s;

        /* renamed from: t, reason: collision with root package name */
        public final AtomicLong f13599t = new AtomicLong();

        public BackpressureBufferSubscriber(b<? super T> bVar, int i10, boolean z10, boolean z11, se.a aVar) {
            this.f13591b = bVar;
            this.f13594o = aVar;
            this.f13593n = z11;
            this.f13592m = z10 ? new af.a<>(i10) : new SpscArrayQueue<>(i10);
        }

        public final boolean a(boolean z10, boolean z11, b<? super T> bVar) {
            if (this.f13596q) {
                this.f13592m.clear();
                return true;
            }
            if (!z10) {
                return false;
            }
            if (this.f13593n) {
                if (!z11) {
                    return false;
                }
                Throwable th2 = this.f13598s;
                if (th2 != null) {
                    bVar.onError(th2);
                } else {
                    bVar.onComplete();
                }
                return true;
            }
            Throwable th3 = this.f13598s;
            if (th3 != null) {
                this.f13592m.clear();
                bVar.onError(th3);
                return true;
            }
            if (!z11) {
                return false;
            }
            bVar.onComplete();
            return true;
        }

        public final void b() {
            if (getAndIncrement() == 0) {
                e<T> eVar = this.f13592m;
                b<? super T> bVar = this.f13591b;
                int iAddAndGet = 1;
                while (!a(this.f13597r, eVar.isEmpty(), bVar)) {
                    long j10 = this.f13599t.get();
                    long j11 = 0;
                    while (j11 != j10) {
                        boolean z10 = this.f13597r;
                        T tPoll = eVar.poll();
                        boolean z11 = tPoll == null;
                        if (a(z10, z11, bVar)) {
                            return;
                        }
                        if (z11) {
                            break;
                        }
                        bVar.onNext(tPoll);
                        j11++;
                    }
                    if (j11 == j10 && a(this.f13597r, eVar.isEmpty(), bVar)) {
                        return;
                    }
                    if (j11 != 0 && j10 != Long.MAX_VALUE) {
                        this.f13599t.addAndGet(-j11);
                    }
                    iAddAndGet = addAndGet(-iAddAndGet);
                    if (iAddAndGet == 0) {
                        return;
                    }
                }
            }
        }

        @Override // zh.c
        public void cancel() {
            if (this.f13596q) {
                return;
            }
            this.f13596q = true;
            this.f13595p.cancel();
            if (getAndIncrement() == 0) {
                this.f13592m.clear();
            }
        }

        @Override // ve.f
        public void clear() {
            this.f13592m.clear();
        }

        @Override // ve.f
        public boolean isEmpty() {
            return this.f13592m.isEmpty();
        }

        @Override // zh.b
        public void onComplete() {
            this.f13597r = true;
            b();
        }

        @Override // zh.b
        public void onError(Throwable th2) {
            this.f13598s = th2;
            this.f13597r = true;
            b();
        }

        @Override // zh.b
        public void onNext(T t10) {
            if (this.f13592m.offer(t10)) {
                b();
                return;
            }
            this.f13595p.cancel();
            MissingBackpressureException missingBackpressureException = new MissingBackpressureException("Buffer is full");
            try {
                this.f13594o.run();
            } catch (Throwable th2) {
                re.a.throwIfFatal(th2);
                missingBackpressureException.initCause(th2);
            }
            onError(missingBackpressureException);
        }

        @Override // zh.b
        public void onSubscribe(c cVar) {
            if (SubscriptionHelper.validate(this.f13595p, cVar)) {
                this.f13595p = cVar;
                this.f13591b.onSubscribe(this);
                cVar.request(Long.MAX_VALUE);
            }
        }

        @Override // ve.f
        public T poll() throws Exception {
            return this.f13592m.poll();
        }

        @Override // zh.c
        public void request(long j10) {
            if (SubscriptionHelper.validate(j10)) {
                cf.b.add(this.f13599t, j10);
                b();
            }
        }
    }

    public FlowableOnBackpressureBuffer(ne.e<T> eVar, int i10, boolean z10, boolean z11, se.a aVar) {
        super(eVar);
        this.f13587n = i10;
        this.f13588o = z10;
        this.f13589p = z11;
        this.f13590q = aVar;
    }

    @Override // ne.e
    public void subscribeActual(b<? super T> bVar) {
        this.f21749m.subscribe((f) new BackpressureBufferSubscriber(bVar, this.f13587n, this.f13588o, this.f13589p, this.f13590q));
    }
}
