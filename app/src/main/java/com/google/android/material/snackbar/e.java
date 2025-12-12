package com.google.android.material.snackbar;

import android.view.View;
import com.google.android.material.behavior.SwipeDismissBehavior;

/* compiled from: BaseTransientBottomBar.java */
/* loaded from: classes.dex */
public final class e implements SwipeDismissBehavior.b {

    /* renamed from: a, reason: collision with root package name */
    public final /* synthetic */ BaseTransientBottomBar f9331a;

    public e(BaseTransientBottomBar baseTransientBottomBar) {
        this.f9331a = baseTransientBottomBar;
    }

    public void onDismiss(View view) {
        if (view.getParent() != null) {
            view.setVisibility(8);
        }
        this.f9331a.dispatchDismiss(0);
    }

    public void onDragStateChanged(int i10) {
        BaseTransientBottomBar baseTransientBottomBar = this.f9331a;
        if (i10 == 0) {
            g.b().restoreTimeoutIfPaused(baseTransientBottomBar.f9304u);
        } else if (i10 == 1 || i10 == 2) {
            g.b().pauseTimeout(baseTransientBottomBar.f9304u);
        }
    }
}
