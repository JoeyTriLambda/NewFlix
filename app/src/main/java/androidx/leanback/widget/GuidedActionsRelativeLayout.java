package androidx.leanback.widget;

import android.content.Context;
import android.util.AttributeSet;
import android.view.KeyEvent;
import android.view.View;
import android.view.ViewGroup;
import android.widget.RelativeLayout;
import androidx.leanback.R;

/* loaded from: classes.dex */
class GuidedActionsRelativeLayout extends RelativeLayout {

    /* renamed from: b, reason: collision with root package name */
    public final float f3055b;

    /* renamed from: m, reason: collision with root package name */
    public boolean f3056m;

    public GuidedActionsRelativeLayout(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, 0);
    }

    @Override // android.view.ViewGroup, android.view.View
    public boolean dispatchKeyEvent(KeyEvent keyEvent) {
        return super.dispatchKeyEvent(keyEvent);
    }

    @Override // android.widget.RelativeLayout, android.view.ViewGroup, android.view.View
    public void onLayout(boolean z10, int i10, int i11, int i12, int i13) {
        super.onLayout(z10, i10, i11, i12, i13);
        this.f3056m = false;
    }

    @Override // android.widget.RelativeLayout, android.view.View
    public void onMeasure(int i10, int i11) {
        View viewFindViewById;
        int size = View.MeasureSpec.getSize(i11);
        if (size > 0 && (viewFindViewById = findViewById(R.id.guidedactions_sub_list)) != null) {
            ViewGroup.MarginLayoutParams marginLayoutParams = (ViewGroup.MarginLayoutParams) viewFindViewById.getLayoutParams();
            if (marginLayoutParams.topMargin < 0 && !this.f3056m) {
                this.f3056m = true;
            }
            if (this.f3056m) {
                marginLayoutParams.topMargin = (int) ((this.f3055b * size) / 100.0f);
            }
        }
        super.onMeasure(i10, i11);
    }

    public GuidedActionsRelativeLayout(Context context, AttributeSet attributeSet, int i10) {
        super(context, attributeSet, i10);
        this.f3056m = false;
        this.f3055b = GuidanceStylingRelativeLayout.getKeyLinePercent(context);
    }
}
