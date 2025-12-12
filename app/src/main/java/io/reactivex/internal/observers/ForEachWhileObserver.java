package io.reactivex.internal.observers;

import io.reactivex.exceptions.CompositeException;
import io.reactivex.internal.disposables.DisposableHelper;
import java.util.concurrent.atomic.AtomicReference;
import ne.q;
import qe.b;
import se.a;
import se.f;
import se.o;

/* loaded from: classes2.dex */
public final class ForEachWhileObserver<T> extends AtomicReference<b> implements q<T>, b {
    private static final long serialVersionUID = -4403180040475402120L;

    /* renamed from: b, reason: collision with root package name */
    public final o<? super T> f13574b;

    /* renamed from: m, reason: collision with root package name */
    public final f<? super Throwable> f13575m;

    /* renamed from: n, reason: collision with root package name */
    public final a f13576n;

    /* renamed from: o, reason: collision with root package name */
    public boolean f13577o;

    public ForEachWhileObserver(o<? super T> oVar, f<? super Throwable> fVar, a aVar) {
        this.f13574b = oVar;
        this.f13575m = fVar;
        this.f13576n = aVar;
    }

    @Override // qe.b
    public void dispose() {
        DisposableHelper.dispose(this);
    }

    @Override // ne.q
    public void onComplete() {
        if (this.f13577o) {
            return;
        }
        this.f13577o = true;
        try {
            this.f13576n.run();
        } catch (Throwable th2) {
            re.a.throwIfFatal(th2);
            ff.a.onError(th2);
        }
    }

    @Override // ne.q
    public void onError(Throwable th2) {
        if (this.f13577o) {
            ff.a.onError(th2);
            return;
        }
        this.f13577o = true;
        try {
            this.f13575m.accept(th2);
        } catch (Throwable th3) {
            re.a.throwIfFatal(th3);
            ff.a.onError(new CompositeException(th2, th3));
        }
    }

    @Override // ne.q
    public void onNext(T t10) {
        if (this.f13577o) {
            return;
        }
        try {
            if (this.f13574b.test(t10)) {
                return;
            }
            dispose();
            onComplete();
        } catch (Throwable th2) {
            re.a.throwIfFatal(th2);
            dispose();
            onError(th2);
        }
    }

    @Override // ne.q
    public void onSubscribe(b bVar) {
        DisposableHelper.setOnce(this, bVar);
    }
}
