package androidx.lifecycle;

import androidx.lifecycle.Lifecycle;

/* compiled from: SavedStateHandleController.kt */
/* loaded from: classes.dex */
public final class SavedStateHandleController implements j {

    /* renamed from: b, reason: collision with root package name */
    public boolean f3464b;

    public final void attachToLifecycle(androidx.savedstate.a aVar, Lifecycle lifecycle) {
        zf.i.checkNotNullParameter(aVar, "registry");
        zf.i.checkNotNullParameter(lifecycle, "lifecycle");
        if (!(!this.f3464b)) {
            throw new IllegalStateException("Already attached to lifecycleOwner".toString());
        }
        this.f3464b = true;
        lifecycle.addObserver(this);
        throw null;
    }

    public final boolean isAttached() {
        return this.f3464b;
    }

    @Override // androidx.lifecycle.j
    public void onStateChanged(l lVar, Lifecycle.Event event) {
        zf.i.checkNotNullParameter(lVar, "source");
        zf.i.checkNotNullParameter(event, "event");
        if (event == Lifecycle.Event.ON_DESTROY) {
            this.f3464b = false;
            lVar.getLifecycle().removeObserver(this);
        }
    }
}
