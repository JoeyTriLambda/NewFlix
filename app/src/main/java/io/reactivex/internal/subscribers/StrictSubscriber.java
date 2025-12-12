package io.reactivex.internal.subscribers;

import io.reactivex.internal.subscriptions.SubscriptionHelper;
import io.reactivex.internal.util.AtomicThrowable;
import java.util.concurrent.atomic.AtomicBoolean;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.concurrent.atomic.AtomicLong;
import java.util.concurrent.atomic.AtomicReference;
import ne.f;
import zh.b;
import zh.c;

/* loaded from: classes2.dex */
public class StrictSubscriber<T> extends AtomicInteger implements f<T>, c {
    private static final long serialVersionUID = -4945028590049415624L;

    /* renamed from: b, reason: collision with root package name */
    public final b<? super T> f14528b;

    /* renamed from: m, reason: collision with root package name */
    public final AtomicThrowable f14529m = new AtomicThrowable();

    /* renamed from: n, reason: collision with root package name */
    public final AtomicLong f14530n = new AtomicLong();

    /* renamed from: o, reason: collision with root package name */
    public final AtomicReference<c> f14531o = new AtomicReference<>();

    /* renamed from: p, reason: collision with root package name */
    public final AtomicBoolean f14532p = new AtomicBoolean();

    /* renamed from: q, reason: collision with root package name */
    public volatile boolean f14533q;

    public StrictSubscriber(b<? super T> bVar) {
        this.f14528b = bVar;
    }

    @Override // zh.c
    public void cancel() {
        if (this.f14533q) {
            return;
        }
        SubscriptionHelper.cancel(this.f14531o);
    }

    @Override // zh.b
    public void onComplete() {
        this.f14533q = true;
        cf.f.onComplete(this.f14528b, this, this.f14529m);
    }

    @Override // zh.b
    public void onError(Throwable th2) {
        this.f14533q = true;
        cf.f.onError(this.f14528b, th2, this, this.f14529m);
    }

    @Override // zh.b
    public void onNext(T t10) {
        cf.f.onNext(this.f14528b, t10, this, this.f14529m);
    }

    @Override // zh.b
    public void onSubscribe(c cVar) {
        if (this.f14532p.compareAndSet(false, true)) {
            this.f14528b.onSubscribe(this);
            SubscriptionHelper.deferredSetOnce(this.f14531o, this.f14530n, cVar);
        } else {
            cVar.cancel();
            cancel();
            onError(new IllegalStateException("§2.12 violated: onSubscribe must be called at most once"));
        }
    }

    @Override // zh.c
    public void request(long j10) {
        if (j10 > 0) {
            SubscriptionHelper.deferredRequest(this.f14531o, this.f14530n, j10);
        } else {
            cancel();
            onError(new IllegalArgumentException(ac.c.h("§3.9 violated: positive request amount required but it was ", j10)));
        }
    }
}
