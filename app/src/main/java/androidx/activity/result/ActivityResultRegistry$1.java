package androidx.activity.result;

import androidx.lifecycle.Lifecycle;
import androidx.lifecycle.j;
import androidx.lifecycle.l;

/* loaded from: classes.dex */
class ActivityResultRegistry$1 implements j {
    @Override // androidx.lifecycle.j
    public void onStateChanged(l lVar, Lifecycle.Event event) {
        if (Lifecycle.Event.ON_START.equals(event) || Lifecycle.Event.ON_STOP.equals(event) || Lifecycle.Event.ON_DESTROY.equals(event)) {
            throw null;
        }
    }
}
