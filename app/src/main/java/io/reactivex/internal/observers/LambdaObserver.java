package io.reactivex.internal.observers;

import io.reactivex.exceptions.CompositeException;
import io.reactivex.internal.disposables.DisposableHelper;
import java.util.concurrent.atomic.AtomicReference;
import ne.q;
import qe.b;
import se.a;
import se.f;

/* loaded from: classes2.dex */
public final class LambdaObserver<T> extends AtomicReference<b> implements q<T>, b {
    private static final long serialVersionUID = -7251123623727029452L;

    /* renamed from: b, reason: collision with root package name */
    public final f<? super T> f13583b;

    /* renamed from: m, reason: collision with root package name */
    public final f<? super Throwable> f13584m;

    /* renamed from: n, reason: collision with root package name */
    public final a f13585n;

    /* renamed from: o, reason: collision with root package name */
    public final f<? super b> f13586o;

    public LambdaObserver(f<? super T> fVar, f<? super Throwable> fVar2, a aVar, f<? super b> fVar3) {
        this.f13583b = fVar;
        this.f13584m = fVar2;
        this.f13585n = aVar;
        this.f13586o = fVar3;
    }

    @Override // qe.b
    public void dispose() {
        DisposableHelper.dispose(this);
    }

    public boolean isDisposed() {
        return get() == DisposableHelper.f13533b;
    }

    @Override // ne.q
    public void onComplete() {
        if (isDisposed()) {
            return;
        }
        lazySet(DisposableHelper.f13533b);
        try {
            this.f13585n.run();
        } catch (Throwable th2) {
            re.a.throwIfFatal(th2);
            ff.a.onError(th2);
        }
    }

    @Override // ne.q
    public void onError(Throwable th2) {
        if (isDisposed()) {
            ff.a.onError(th2);
            return;
        }
        lazySet(DisposableHelper.f13533b);
        try {
            this.f13584m.accept(th2);
        } catch (Throwable th3) {
            re.a.throwIfFatal(th3);
            ff.a.onError(new CompositeException(th2, th3));
        }
    }

    @Override // ne.q
    public void onNext(T t10) {
        if (isDisposed()) {
            return;
        }
        try {
            this.f13583b.accept(t10);
        } catch (Throwable th2) {
            re.a.throwIfFatal(th2);
            get().dispose();
            onError(th2);
        }
    }

    @Override // ne.q
    public void onSubscribe(b bVar) {
        if (DisposableHelper.setOnce(this, bVar)) {
            try {
                this.f13586o.accept(this);
            } catch (Throwable th2) {
                re.a.throwIfFatal(th2);
                bVar.dispose();
                onError(th2);
            }
        }
    }
}
