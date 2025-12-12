package androidx.lifecycle;

import android.view.View;
import androidx.lifecycle.runtime.R;

/* compiled from: ViewTreeLifecycleOwner.kt */
/* loaded from: classes.dex */
public final class f0 {
    public static final void set(View view, l lVar) {
        zf.i.checkNotNullParameter(view, "<this>");
        view.setTag(R.id.view_tree_lifecycle_owner, lVar);
    }
}
