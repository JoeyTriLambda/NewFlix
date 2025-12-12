package com.google.android.material.snackbar;

import android.content.Context;
import android.content.res.ColorStateList;
import android.graphics.PorterDuff;
import android.graphics.drawable.Drawable;
import android.os.Build;
import android.util.AttributeSet;
import android.view.View;
import android.view.ViewGroup;
import android.view.accessibility.AccessibilityManager;
import com.google.android.material.R;
import com.google.android.material.snackbar.BaseTransientBottomBar;

/* loaded from: classes.dex */
public final class Snackbar extends BaseTransientBottomBar<Snackbar> {
    public static final int[] C = {R.attr.snackbarButtonStyle, R.attr.snackbarTextViewStyle};
    public final AccessibilityManager B;

    public static final class SnackbarLayout extends BaseTransientBottomBar.g {
        public SnackbarLayout(Context context, AttributeSet attributeSet) {
            super(context, attributeSet);
        }

        @Override // com.google.android.material.snackbar.BaseTransientBottomBar.g, android.widget.FrameLayout, android.view.View
        public void onMeasure(int i10, int i11) {
            super.onMeasure(i10, i11);
            int childCount = getChildCount();
            int measuredWidth = (getMeasuredWidth() - getPaddingLeft()) - getPaddingRight();
            for (int i12 = 0; i12 < childCount; i12++) {
                View childAt = getChildAt(i12);
                if (childAt.getLayoutParams().width == -1) {
                    childAt.measure(View.MeasureSpec.makeMeasureSpec(measuredWidth, 1073741824), View.MeasureSpec.makeMeasureSpec(childAt.getMeasuredHeight(), 1073741824));
                }
            }
        }

        @Override // com.google.android.material.snackbar.BaseTransientBottomBar.g, android.view.View
        public /* bridge */ /* synthetic */ void setBackground(Drawable drawable) {
            super.setBackground(drawable);
        }

        @Override // com.google.android.material.snackbar.BaseTransientBottomBar.g, android.view.View
        public /* bridge */ /* synthetic */ void setBackgroundDrawable(Drawable drawable) {
            super.setBackgroundDrawable(drawable);
        }

        @Override // com.google.android.material.snackbar.BaseTransientBottomBar.g, android.view.View
        public /* bridge */ /* synthetic */ void setBackgroundTintList(ColorStateList colorStateList) {
            super.setBackgroundTintList(colorStateList);
        }

        @Override // com.google.android.material.snackbar.BaseTransientBottomBar.g, android.view.View
        public /* bridge */ /* synthetic */ void setBackgroundTintMode(PorterDuff.Mode mode) {
            super.setBackgroundTintMode(mode);
        }

        @Override // com.google.android.material.snackbar.BaseTransientBottomBar.g, android.view.View
        public /* bridge */ /* synthetic */ void setLayoutParams(ViewGroup.LayoutParams layoutParams) {
            super.setLayoutParams(layoutParams);
        }

        @Override // com.google.android.material.snackbar.BaseTransientBottomBar.g, android.view.View
        public /* bridge */ /* synthetic */ void setOnClickListener(View.OnClickListener onClickListener) {
            super.setOnClickListener(onClickListener);
        }
    }

    public Snackbar(Context context, ViewGroup viewGroup, SnackbarContentLayout snackbarContentLayout, SnackbarContentLayout snackbarContentLayout2) {
        super(context, viewGroup, snackbarContentLayout, snackbarContentLayout2);
        this.B = (AccessibilityManager) viewGroup.getContext().getSystemService("accessibility");
    }

    public static Snackbar make(View view, int i10, int i11) {
        return make(view, view.getResources().getText(i10), i11);
    }

    @Override // com.google.android.material.snackbar.BaseTransientBottomBar
    public void dismiss() {
        super.dismiss();
    }

    @Override // com.google.android.material.snackbar.BaseTransientBottomBar
    public int getDuration() {
        int duration = super.getDuration();
        if (duration == -2) {
            return -2;
        }
        return Build.VERSION.SDK_INT >= 29 ? this.B.getRecommendedTimeoutMillis(duration, 3) : duration;
    }

    public Snackbar setText(CharSequence charSequence) {
        ((SnackbarContentLayout) this.f9292i.getChildAt(0)).getMessageView().setText(charSequence);
        return this;
    }

    @Override // com.google.android.material.snackbar.BaseTransientBottomBar
    public void show() {
        super.show();
    }

    /* JADX WARN: Removed duplicated region for block: B:13:0x001e  */
    /* JADX WARN: Removed duplicated region for block: B:34:0x002c A[SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:36:0x002a A[SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:38:? A[LOOP:0: B:3:0x0002->B:38:?, LOOP_END, SYNTHETIC] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public static com.google.android.material.snackbar.Snackbar make(android.view.View r8, java.lang.CharSequence r9, int r10) {
        /*
            r0 = 0
            r1 = r0
        L2:
            boolean r2 = r8 instanceof androidx.coordinatorlayout.widget.CoordinatorLayout
            if (r2 == 0) goto L9
            android.view.ViewGroup r8 = (android.view.ViewGroup) r8
            goto L2d
        L9:
            boolean r2 = r8 instanceof android.widget.FrameLayout
            if (r2 == 0) goto L1c
            int r1 = r8.getId()
            r2 = 16908290(0x1020002, float:2.3877235E-38)
            if (r1 != r2) goto L19
            android.view.ViewGroup r8 = (android.view.ViewGroup) r8
            goto L2d
        L19:
            r1 = r8
            android.view.ViewGroup r1 = (android.view.ViewGroup) r1
        L1c:
            if (r8 == 0) goto L2a
            android.view.ViewParent r8 = r8.getParent()
            boolean r2 = r8 instanceof android.view.View
            if (r2 == 0) goto L29
            android.view.View r8 = (android.view.View) r8
            goto L2a
        L29:
            r8 = r0
        L2a:
            if (r8 != 0) goto L2
            r8 = r1
        L2d:
            if (r8 == 0) goto L6a
            android.content.Context r0 = r8.getContext()
            android.view.LayoutInflater r1 = android.view.LayoutInflater.from(r0)
            int[] r2 = com.google.android.material.snackbar.Snackbar.C
            android.content.res.TypedArray r2 = r0.obtainStyledAttributes(r2)
            r3 = 0
            r4 = -1
            int r5 = r2.getResourceId(r3, r4)
            r6 = 1
            int r7 = r2.getResourceId(r6, r4)
            r2.recycle()
            if (r5 == r4) goto L50
            if (r7 == r4) goto L50
            goto L51
        L50:
            r6 = 0
        L51:
            if (r6 == 0) goto L56
            int r2 = com.google.android.material.R.layout.mtrl_layout_snackbar_include
            goto L58
        L56:
            int r2 = com.google.android.material.R.layout.design_layout_snackbar_include
        L58:
            android.view.View r1 = r1.inflate(r2, r8, r3)
            com.google.android.material.snackbar.SnackbarContentLayout r1 = (com.google.android.material.snackbar.SnackbarContentLayout) r1
            com.google.android.material.snackbar.Snackbar r2 = new com.google.android.material.snackbar.Snackbar
            r2.<init>(r0, r8, r1, r1)
            r2.setText(r9)
            r2.setDuration(r10)
            return r2
        L6a:
            java.lang.IllegalArgumentException r8 = new java.lang.IllegalArgumentException
            java.lang.String r9 = "No suitable parent found from the given view. Please provide a valid view."
            r8.<init>(r9)
            throw r8
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.material.snackbar.Snackbar.make(android.view.View, java.lang.CharSequence, int):com.google.android.material.snackbar.Snackbar");
    }
}
