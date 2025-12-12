package androidx.fragment.app;

import androidx.lifecycle.Lifecycle;

/* loaded from: classes.dex */
class FragmentManager$6 implements androidx.lifecycle.j {
    @Override // androidx.lifecycle.j
    public void onStateChanged(androidx.lifecycle.l lVar, Lifecycle.Event event) {
        if (event == Lifecycle.Event.ON_START || event == Lifecycle.Event.ON_DESTROY) {
            throw null;
        }
    }
}
