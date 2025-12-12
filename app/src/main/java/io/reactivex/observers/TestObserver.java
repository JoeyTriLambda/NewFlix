package io.reactivex.observers;

import ef.a;
import io.reactivex.internal.disposables.DisposableHelper;
import io.reactivex.internal.util.VolatileSizeArrayList;
import java.util.concurrent.CountDownLatch;
import java.util.concurrent.atomic.AtomicReference;
import ne.b;
import ne.h;
import ne.q;
import ne.t;

/* loaded from: classes2.dex */
public final class TestObserver<T> extends a<T, TestObserver<T>> implements q<T>, h<T>, t<T>, b {

    /* renamed from: p, reason: collision with root package name */
    public final q<? super T> f14552p;

    /* renamed from: q, reason: collision with root package name */
    public final AtomicReference<qe.b> f14553q;

    public TestObserver() {
        this(EmptyObserver.f14554b);
    }

    @Override // qe.b
    public final void dispose() {
        DisposableHelper.dispose(this.f14553q);
    }

    @Override // ne.q
    public void onComplete() {
        CountDownLatch countDownLatch = this.f11310b;
        if (!this.f11313o) {
            this.f11313o = true;
            if (this.f14553q.get() == null) {
                this.f11312n.add(new IllegalStateException("onSubscribe not called in proper order"));
            }
        }
        try {
            Thread.currentThread();
            this.f14552p.onComplete();
        } finally {
            countDownLatch.countDown();
        }
    }

    @Override // ne.q
    public void onError(Throwable th2) {
        CountDownLatch countDownLatch = this.f11310b;
        boolean z10 = this.f11313o;
        VolatileSizeArrayList volatileSizeArrayList = this.f11312n;
        if (!z10) {
            this.f11313o = true;
            if (this.f14553q.get() == null) {
                volatileSizeArrayList.add(new IllegalStateException("onSubscribe not called in proper order"));
            }
        }
        try {
            Thread.currentThread();
            if (th2 == null) {
                volatileSizeArrayList.add(new NullPointerException("onError received a null Throwable"));
            } else {
                volatileSizeArrayList.add(th2);
            }
            this.f14552p.onError(th2);
        } finally {
            countDownLatch.countDown();
        }
    }

    @Override // ne.q
    public void onNext(T t10) {
        boolean z10 = this.f11313o;
        VolatileSizeArrayList volatileSizeArrayList = this.f11312n;
        if (!z10) {
            this.f11313o = true;
            if (this.f14553q.get() == null) {
                volatileSizeArrayList.add(new IllegalStateException("onSubscribe not called in proper order"));
            }
        }
        Thread.currentThread();
        this.f11311m.add(t10);
        if (t10 == null) {
            volatileSizeArrayList.add(new NullPointerException("onNext received a null value"));
        }
        this.f14552p.onNext(t10);
    }

    @Override // ne.q
    public void onSubscribe(qe.b bVar) {
        boolean z10;
        Thread.currentThread();
        VolatileSizeArrayList volatileSizeArrayList = this.f11312n;
        if (bVar == null) {
            volatileSizeArrayList.add(new NullPointerException("onSubscribe received a null Subscription"));
            return;
        }
        AtomicReference<qe.b> atomicReference = this.f14553q;
        while (true) {
            if (atomicReference.compareAndSet(null, bVar)) {
                z10 = true;
                break;
            } else if (atomicReference.get() != null) {
                z10 = false;
                break;
            }
        }
        if (z10) {
            this.f14552p.onSubscribe(bVar);
            return;
        }
        bVar.dispose();
        if (atomicReference.get() != DisposableHelper.f13533b) {
            volatileSizeArrayList.add(new IllegalStateException("onSubscribe received multiple subscriptions: " + bVar));
        }
    }

    @Override // ne.h
    public void onSuccess(T t10) {
        onNext(t10);
        onComplete();
    }

    public TestObserver(q<? super T> qVar) {
        this.f14553q = new AtomicReference<>();
        this.f14552p = qVar;
    }

    /* JADX WARN: Failed to restore enum class, 'enum' modifier and super class removed */
    /* JADX WARN: Unknown enum class pattern. Please report as an issue! */
    public static final class EmptyObserver implements q<Object> {

        /* renamed from: b, reason: collision with root package name */
        public static final EmptyObserver f14554b;

        /* renamed from: m, reason: collision with root package name */
        public static final /* synthetic */ EmptyObserver[] f14555m;

        static {
            EmptyObserver emptyObserver = new EmptyObserver();
            f14554b = emptyObserver;
            f14555m = new EmptyObserver[]{emptyObserver};
        }

        public static EmptyObserver valueOf(String str) {
            return (EmptyObserver) Enum.valueOf(EmptyObserver.class, str);
        }

        public static EmptyObserver[] values() {
            return (EmptyObserver[]) f14555m.clone();
        }

        @Override // ne.q
        public void onComplete() {
        }

        @Override // ne.q
        public void onError(Throwable th2) {
        }

        @Override // ne.q
        public void onNext(Object obj) {
        }

        @Override // ne.q
        public void onSubscribe(qe.b bVar) {
        }
    }
}
