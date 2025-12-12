package androidx.leanback.widget;

import android.content.Context;
import android.util.AttributeSet;
import android.view.View;

/* loaded from: classes.dex */
class GuidedActionItemContainer extends x {

    /* renamed from: o, reason: collision with root package name */
    public final boolean f3054o;

    public GuidedActionItemContainer(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, 0);
    }

    @Override // android.view.ViewGroup, android.view.ViewParent
    public View focusSearch(View view, int i10) {
        if (this.f3054o || !a1.isDescendant(this, view)) {
            return super.focusSearch(view, i10);
        }
        View viewFocusSearch = super.focusSearch(view, i10);
        if (a1.isDescendant(this, viewFocusSearch)) {
            return viewFocusSearch;
        }
        return null;
    }

    public GuidedActionItemContainer(Context context, AttributeSet attributeSet, int i10) {
        super(context, attributeSet, i10);
        this.f3054o = true;
    }
}
