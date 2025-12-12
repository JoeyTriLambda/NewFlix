package androidx.savedstate;

import android.view.View;
import j2.c;
import zf.i;

/* compiled from: ViewTreeSavedStateRegistryOwner.kt */
/* loaded from: classes.dex */
public final class b {
    public static final void set(View view, c cVar) {
        i.checkNotNullParameter(view, "<this>");
        view.setTag(R.id.view_tree_saved_state_registry_owner, cVar);
    }
}
