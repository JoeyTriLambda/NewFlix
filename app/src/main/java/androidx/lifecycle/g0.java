package androidx.lifecycle;

import android.view.View;
import androidx.lifecycle.viewmodel.R;

/* compiled from: ViewTreeViewModelStoreOwner.kt */
/* loaded from: classes.dex */
public final class g0 {
    public static final void set(View view, e0 e0Var) {
        zf.i.checkNotNullParameter(view, "<this>");
        view.setTag(R.id.view_tree_view_model_store_owner, e0Var);
    }
}
