package androidx.lifecycle;

import androidx.lifecycle.Lifecycle;

/* compiled from: SavedStateHandleSupport.kt */
/* loaded from: classes.dex */
public final class SavedStateHandleAttacher implements j {

    /* renamed from: b, reason: collision with root package name */
    public final SavedStateHandlesProvider f3463b;

    public SavedStateHandleAttacher(SavedStateHandlesProvider savedStateHandlesProvider) {
        zf.i.checkNotNullParameter(savedStateHandlesProvider, "provider");
        this.f3463b = savedStateHandlesProvider;
    }

    @Override // androidx.lifecycle.j
    public void onStateChanged(l lVar, Lifecycle.Event event) {
        zf.i.checkNotNullParameter(lVar, "source");
        zf.i.checkNotNullParameter(event, "event");
        if (event == Lifecycle.Event.ON_CREATE) {
            lVar.getLifecycle().removeObserver(this);
            this.f3463b.performRestore();
        } else {
            throw new IllegalStateException(("Next event must be ON_CREATE, it was " + event).toString());
        }
    }
}
