package androidx.lifecycle;

import androidx.lifecycle.Lifecycle;

/* compiled from: WithLifecycleState.kt */
/* loaded from: classes.dex */
public final class WithLifecycleStateKt$suspendWithStateAtLeastUnchecked$2$observer$1 implements j {
    @Override // androidx.lifecycle.j
    public void onStateChanged(l lVar, Lifecycle.Event event) {
        zf.i.checkNotNullParameter(lVar, "source");
        zf.i.checkNotNullParameter(event, "event");
        if (event == Lifecycle.Event.Companion.upTo(null) || event == Lifecycle.Event.ON_DESTROY) {
            throw null;
        }
    }
}
