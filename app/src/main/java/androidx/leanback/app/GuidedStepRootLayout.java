package androidx.leanback.app;

import android.content.Context;
import android.util.AttributeSet;
import android.view.View;
import android.widget.LinearLayout;
import androidx.leanback.widget.a1;

/* loaded from: classes.dex */
class GuidedStepRootLayout extends LinearLayout {
    public GuidedStepRootLayout(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
    }

    @Override // android.view.ViewGroup, android.view.ViewParent
    public View focusSearch(View view, int i10) {
        View viewFocusSearch = super.focusSearch(view, i10);
        if ((i10 != 17 && i10 != 66) || a1.isDescendant(this, viewFocusSearch)) {
            return viewFocusSearch;
        }
        getLayoutDirection();
        return view;
    }
}
