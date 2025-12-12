package androidx.activity;

import android.view.View;

/* compiled from: ViewTreeOnBackPressedDispatcherOwner.kt */
/* loaded from: classes.dex */
public final class o {
    public static final void set(View view, m mVar) {
        zf.i.checkNotNullParameter(view, "<this>");
        zf.i.checkNotNullParameter(mVar, "onBackPressedDispatcherOwner");
        view.setTag(R.id.view_tree_on_back_pressed_dispatcher_owner, mVar);
    }
}
