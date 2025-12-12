package androidx.leanback.widget;

import android.R;
import android.content.Context;
import android.util.AttributeSet;
import android.view.View;
import android.widget.Checkable;
import android.widget.ImageView;

/* loaded from: classes.dex */
class CheckableImageView extends ImageView implements Checkable {

    /* renamed from: m, reason: collision with root package name */
    public static final int[] f3047m = {R.attr.state_checked};

    /* renamed from: b, reason: collision with root package name */
    public boolean f3048b;

    public CheckableImageView(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, 0);
    }

    @Override // android.widget.Checkable
    public boolean isChecked() {
        return this.f3048b;
    }

    @Override // android.widget.ImageView, android.view.View
    public int[] onCreateDrawableState(int i10) {
        int[] iArrOnCreateDrawableState = super.onCreateDrawableState(i10 + 1);
        if (isChecked()) {
            View.mergeDrawableStates(iArrOnCreateDrawableState, f3047m);
        }
        return iArrOnCreateDrawableState;
    }

    @Override // android.widget.Checkable
    public void setChecked(boolean z10) {
        if (this.f3048b != z10) {
            this.f3048b = z10;
            refreshDrawableState();
        }
    }

    @Override // android.widget.Checkable
    public void toggle() {
        setChecked(!this.f3048b);
    }

    public CheckableImageView(Context context, AttributeSet attributeSet, int i10) {
        super(context, attributeSet, i10);
    }
}
