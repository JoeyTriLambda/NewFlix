package io.reactivex.internal.observers;

import io.reactivex.internal.disposables.DisposableHelper;
import io.reactivex.internal.util.NotificationLite;
import java.util.Queue;
import java.util.concurrent.atomic.AtomicReference;
import ne.q;
import qe.b;

/* loaded from: classes2.dex */
public final class BlockingObserver<T> extends AtomicReference<b> implements q<T>, b {

    /* renamed from: m, reason: collision with root package name */
    public static final Object f13570m = new Object();
    private static final long serialVersionUID = -4875965440900746268L;

    /* renamed from: b, reason: collision with root package name */
    public final Queue<Object> f13571b;

    public BlockingObserver(Queue<Object> queue) {
        this.f13571b = queue;
    }

    @Override // qe.b
    public void dispose() {
        if (DisposableHelper.dispose(this)) {
            this.f13571b.offer(f13570m);
        }
    }

    public boolean isDisposed() {
        return get() == DisposableHelper.f13533b;
    }

    @Override // ne.q
    public void onComplete() {
        this.f13571b.offer(NotificationLite.complete());
    }

    @Override // ne.q
    public void onError(Throwable th2) {
        this.f13571b.offer(NotificationLite.error(th2));
    }

    @Override // ne.q
    public void onNext(T t10) {
        this.f13571b.offer(NotificationLite.next(t10));
    }

    @Override // ne.q
    public void onSubscribe(b bVar) {
        DisposableHelper.setOnce(this, bVar);
    }
}
