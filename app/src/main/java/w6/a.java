package w6;

import android.R;
import android.content.res.ColorStateList;
import android.content.res.Resources;
import android.graphics.RectF;
import android.graphics.drawable.Drawable;
import android.os.Build;
import android.view.View;
import android.view.accessibility.AccessibilityEvent;
import android.view.accessibility.AccessibilityNodeInfo;
import android.widget.Checkable;
import androidx.cardview.widget.CardView;
import q7.l;
import q7.p;

/* compiled from: MaterialCardView.java */
/* loaded from: classes.dex */
public class a extends CardView implements Checkable, p {

    /* renamed from: u, reason: collision with root package name */
    public static final int[] f21023u = {R.attr.state_checkable};

    /* renamed from: v, reason: collision with root package name */
    public static final int[] f21024v = {R.attr.state_checked};

    /* renamed from: w, reason: collision with root package name */
    public static final int[] f21025w = {com.google.android.material.R.attr.state_dragged};

    /* renamed from: s, reason: collision with root package name */
    public boolean f21026s;

    /* renamed from: t, reason: collision with root package name */
    public boolean f21027t;

    /* compiled from: MaterialCardView.java */
    /* renamed from: w6.a$a, reason: collision with other inner class name */
    public interface InterfaceC0306a {
    }

    private RectF getBoundsAsRectF() {
        new RectF();
        throw null;
    }

    @Override // androidx.cardview.widget.CardView
    public ColorStateList getCardBackgroundColor() {
        throw null;
    }

    public ColorStateList getCardForegroundColor() {
        throw null;
    }

    public float getCardViewRadius() {
        return super.getRadius();
    }

    public Drawable getCheckedIcon() {
        throw null;
    }

    public int getCheckedIconGravity() {
        throw null;
    }

    public int getCheckedIconMargin() {
        throw null;
    }

    public int getCheckedIconSize() {
        throw null;
    }

    public ColorStateList getCheckedIconTint() {
        throw null;
    }

    @Override // androidx.cardview.widget.CardView
    public int getContentPaddingBottom() {
        throw null;
    }

    @Override // androidx.cardview.widget.CardView
    public int getContentPaddingLeft() {
        throw null;
    }

    @Override // androidx.cardview.widget.CardView
    public int getContentPaddingRight() {
        throw null;
    }

    @Override // androidx.cardview.widget.CardView
    public int getContentPaddingTop() {
        throw null;
    }

    public float getProgress() {
        throw null;
    }

    @Override // androidx.cardview.widget.CardView
    public float getRadius() {
        throw null;
    }

    public ColorStateList getRippleColor() {
        throw null;
    }

    public l getShapeAppearanceModel() {
        throw null;
    }

    @Deprecated
    public int getStrokeColor() {
        throw null;
    }

    public ColorStateList getStrokeColorStateList() {
        throw null;
    }

    public int getStrokeWidth() {
        throw null;
    }

    public boolean isCheckable() {
        return false;
    }

    @Override // android.widget.Checkable
    public boolean isChecked() {
        return this.f21026s;
    }

    public boolean isDragged() {
        return this.f21027t;
    }

    @Override // android.view.ViewGroup, android.view.View
    public void onAttachedToWindow() {
        super.onAttachedToWindow();
        throw null;
    }

    @Override // android.view.ViewGroup, android.view.View
    public int[] onCreateDrawableState(int i10) {
        int[] iArrOnCreateDrawableState = super.onCreateDrawableState(i10 + 3);
        if (isCheckable()) {
            View.mergeDrawableStates(iArrOnCreateDrawableState, f21023u);
        }
        if (isChecked()) {
            View.mergeDrawableStates(iArrOnCreateDrawableState, f21024v);
        }
        if (isDragged()) {
            View.mergeDrawableStates(iArrOnCreateDrawableState, f21025w);
        }
        return iArrOnCreateDrawableState;
    }

    @Override // android.view.View
    public void onInitializeAccessibilityEvent(AccessibilityEvent accessibilityEvent) {
        super.onInitializeAccessibilityEvent(accessibilityEvent);
        accessibilityEvent.setClassName("androidx.cardview.widget.CardView");
        accessibilityEvent.setChecked(isChecked());
    }

    @Override // android.view.View
    public void onInitializeAccessibilityNodeInfo(AccessibilityNodeInfo accessibilityNodeInfo) {
        super.onInitializeAccessibilityNodeInfo(accessibilityNodeInfo);
        accessibilityNodeInfo.setClassName("androidx.cardview.widget.CardView");
        accessibilityNodeInfo.setCheckable(isCheckable());
        accessibilityNodeInfo.setClickable(isClickable());
        accessibilityNodeInfo.setChecked(isChecked());
    }

    @Override // androidx.cardview.widget.CardView, android.widget.FrameLayout, android.view.View
    public void onMeasure(int i10, int i11) {
        super.onMeasure(i10, i11);
        getMeasuredWidth();
        getMeasuredHeight();
        throw null;
    }

    @Override // android.view.View
    public void setBackground(Drawable drawable) {
        setBackgroundDrawable(drawable);
    }

    public void setBackgroundInternal(Drawable drawable) {
        super.setBackgroundDrawable(drawable);
    }

    @Override // androidx.cardview.widget.CardView
    public void setCardBackgroundColor(int i10) {
        ColorStateList.valueOf(i10);
        throw null;
    }

    @Override // androidx.cardview.widget.CardView
    public void setCardElevation(float f10) {
        super.setCardElevation(f10);
        throw null;
    }

    public void setCardForegroundColor(ColorStateList colorStateList) {
        throw null;
    }

    public void setCheckable(boolean z10) {
        throw null;
    }

    @Override // android.widget.Checkable
    public void setChecked(boolean z10) {
        if (this.f21026s != z10) {
            toggle();
        }
    }

    public void setCheckedIcon(Drawable drawable) {
        throw null;
    }

    public void setCheckedIconGravity(int i10) {
        throw null;
    }

    public void setCheckedIconMargin(int i10) {
        throw null;
    }

    public void setCheckedIconMarginResource(int i10) throws Resources.NotFoundException {
        if (i10 == -1) {
            return;
        }
        getResources().getDimensionPixelSize(i10);
        throw null;
    }

    public void setCheckedIconResource(int i10) {
        s.a.getDrawable(getContext(), i10);
        throw null;
    }

    public void setCheckedIconSize(int i10) {
        throw null;
    }

    public void setCheckedIconSizeResource(int i10) throws Resources.NotFoundException {
        if (i10 == 0) {
            return;
        }
        getResources().getDimensionPixelSize(i10);
        throw null;
    }

    public void setCheckedIconTint(ColorStateList colorStateList) {
        throw null;
    }

    @Override // android.view.View
    public void setClickable(boolean z10) {
        super.setClickable(z10);
    }

    public void setDragged(boolean z10) {
        if (this.f21027t != z10) {
            this.f21027t = z10;
            refreshDrawableState();
            if (Build.VERSION.SDK_INT > 26) {
                throw null;
            }
            invalidate();
        }
    }

    @Override // androidx.cardview.widget.CardView
    public void setMaxCardElevation(float f10) {
        super.setMaxCardElevation(f10);
        throw null;
    }

    @Override // androidx.cardview.widget.CardView
    public void setPreventCornerOverlap(boolean z10) {
        super.setPreventCornerOverlap(z10);
        throw null;
    }

    public void setProgress(float f10) {
        throw null;
    }

    @Override // androidx.cardview.widget.CardView
    public void setRadius(float f10) {
        super.setRadius(f10);
        throw null;
    }

    public void setRippleColor(ColorStateList colorStateList) {
        throw null;
    }

    public void setRippleColorResource(int i10) {
        s.a.getColorStateList(getContext(), i10);
        throw null;
    }

    @Override // q7.p
    public void setShapeAppearanceModel(l lVar) {
        setClipToOutline(lVar.isRoundRect(getBoundsAsRectF()));
        throw null;
    }

    public void setStrokeColor(int i10) {
        setStrokeColor(ColorStateList.valueOf(i10));
    }

    public void setStrokeWidth(int i10) {
        throw null;
    }

    @Override // androidx.cardview.widget.CardView
    public void setUseCompatPadding(boolean z10) {
        super.setUseCompatPadding(z10);
        throw null;
    }

    @Override // android.widget.Checkable
    public void toggle() {
        if (isCheckable() && isEnabled()) {
            this.f21026s = !this.f21026s;
            refreshDrawableState();
            if (Build.VERSION.SDK_INT > 26) {
                throw null;
            }
            throw null;
        }
    }

    @Override // androidx.cardview.widget.CardView
    public void setCardBackgroundColor(ColorStateList colorStateList) {
        throw null;
    }

    public void setStrokeColor(ColorStateList colorStateList) {
        throw null;
    }

    @Override // android.view.View
    public void setBackgroundDrawable(Drawable drawable) {
    }

    public void setOnCheckedChangeListener(InterfaceC0306a interfaceC0306a) {
    }
}
