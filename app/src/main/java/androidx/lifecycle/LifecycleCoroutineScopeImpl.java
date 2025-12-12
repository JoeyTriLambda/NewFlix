package androidx.lifecycle;

import androidx.lifecycle.Lifecycle;
import kg.p1;
import kotlin.coroutines.CoroutineContext;

/* compiled from: Lifecycle.kt */
/* loaded from: classes.dex */
public final class LifecycleCoroutineScopeImpl extends h implements j {
    @Override // kg.g0
    public CoroutineContext getCoroutineContext() {
        return null;
    }

    public Lifecycle getLifecycle$lifecycle_common() {
        return null;
    }

    @Override // androidx.lifecycle.j
    public void onStateChanged(l lVar, Lifecycle.Event event) {
        zf.i.checkNotNullParameter(lVar, "source");
        zf.i.checkNotNullParameter(event, "event");
        if (getLifecycle$lifecycle_common().getCurrentState().compareTo(Lifecycle.State.DESTROYED) <= 0) {
            getLifecycle$lifecycle_common().removeObserver(this);
            p1.cancel$default(getCoroutineContext(), null, 1, null);
        }
    }
}
