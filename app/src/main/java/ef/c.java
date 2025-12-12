package ef;

import io.reactivex.internal.disposables.DisposableHelper;
import java.util.concurrent.atomic.AtomicReference;
import ne.q;

/* compiled from: DisposableObserver.java */
/* loaded from: classes2.dex */
public abstract class c<T> implements q<T>, qe.b {

    /* renamed from: b, reason: collision with root package name */
    public final AtomicReference<qe.b> f11315b = new AtomicReference<>();

    @Override // qe.b
    public final void dispose() {
        DisposableHelper.dispose(this.f11315b);
    }

    @Override // ne.q
    public final void onSubscribe(qe.b bVar) {
        if (cf.e.setOnce(this.f11315b, bVar, getClass())) {
            onStart();
        }
    }

    public void onStart() {
    }
}
