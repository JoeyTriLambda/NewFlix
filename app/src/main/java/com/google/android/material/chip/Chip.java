package com.google.android.material.chip;

import android.annotation.TargetApi;
import android.content.Context;
import android.content.res.ColorStateList;
import android.content.res.TypedArray;
import android.graphics.PorterDuff;
import android.graphics.Rect;
import android.graphics.RectF;
import android.graphics.Typeface;
import android.graphics.drawable.Drawable;
import android.graphics.drawable.InsetDrawable;
import android.graphics.drawable.RippleDrawable;
import android.os.Build;
import android.os.Bundle;
import android.text.TextPaint;
import android.text.TextUtils;
import android.util.AttributeSet;
import android.util.Log;
import android.util.TypedValue;
import android.view.KeyEvent;
import android.view.MotionEvent;
import android.view.PointerIcon;
import android.view.View;
import android.view.ViewParent;
import android.view.accessibility.AccessibilityNodeInfo;
import android.widget.Checkable;
import android.widget.CompoundButton;
import android.widget.TextView;
import androidx.appcompat.widget.g;
import com.google.android.material.R;
import com.google.android.material.chip.a;
import i7.r;
import i7.t;
import java.util.List;
import n7.f;
import p6.h;
import q7.i;
import q7.l;
import q7.p;
import x0.j0;
import y0.d;
import z6.c;

/* loaded from: classes.dex */
public class Chip extends g implements a.InterfaceC0085a, p, Checkable {
    public static final int H = R.style.Widget_MaterialComponents_Chip_Action;
    public static final Rect I = new Rect();
    public static final int[] J = {android.R.attr.state_selected};
    public static final int[] K = {android.R.attr.state_checkable};
    public int A;
    public CharSequence B;
    public final b C;
    public boolean D;
    public final Rect E;
    public final RectF F;
    public final a G;

    /* renamed from: p, reason: collision with root package name */
    public com.google.android.material.chip.a f8963p;

    /* renamed from: q, reason: collision with root package name */
    public InsetDrawable f8964q;

    /* renamed from: r, reason: collision with root package name */
    public RippleDrawable f8965r;

    /* renamed from: s, reason: collision with root package name */
    public View.OnClickListener f8966s;

    /* renamed from: t, reason: collision with root package name */
    public CompoundButton.OnCheckedChangeListener f8967t;

    /* renamed from: u, reason: collision with root package name */
    public boolean f8968u;

    /* renamed from: v, reason: collision with root package name */
    public boolean f8969v;

    /* renamed from: w, reason: collision with root package name */
    public boolean f8970w;

    /* renamed from: x, reason: collision with root package name */
    public boolean f8971x;

    /* renamed from: y, reason: collision with root package name */
    public boolean f8972y;

    /* renamed from: z, reason: collision with root package name */
    public int f8973z;

    public class b extends g1.a {
        public b(Chip chip) {
            super(chip);
        }

        @Override // g1.a
        public int getVirtualViewAt(float f10, float f11) {
            int i10 = Chip.H;
            Chip chip = Chip.this;
            return (chip.c() && chip.getCloseIconTouchBounds().contains(f10, f11)) ? 1 : 0;
        }

        @Override // g1.a
        public void getVisibleVirtualViews(List<Integer> list) {
            list.add(0);
            int i10 = Chip.H;
            Chip chip = Chip.this;
            if (chip.c() && chip.isCloseIconVisible() && chip.f8966s != null) {
                list.add(1);
            }
        }

        @Override // g1.a
        public boolean onPerformActionForVirtualView(int i10, int i11, Bundle bundle) {
            if (i11 != 16) {
                return false;
            }
            Chip chip = Chip.this;
            if (i10 == 0) {
                return chip.performClick();
            }
            if (i10 == 1) {
                return chip.performCloseIconClick();
            }
            return false;
        }

        @Override // g1.a
        public void onPopulateNodeForHost(d dVar) {
            Chip chip = Chip.this;
            dVar.setCheckable(chip.isCheckable());
            dVar.setClickable(chip.isClickable());
            dVar.setClassName(chip.getAccessibilityClassName());
            CharSequence text = chip.getText();
            if (Build.VERSION.SDK_INT >= 23) {
                dVar.setText(text);
            } else {
                dVar.setContentDescription(text);
            }
        }

        @Override // g1.a
        public void onPopulateNodeForVirtualView(int i10, d dVar) {
            if (i10 != 1) {
                dVar.setContentDescription("");
                dVar.setBoundsInParent(Chip.I);
                return;
            }
            Chip chip = Chip.this;
            CharSequence closeIconContentDescription = chip.getCloseIconContentDescription();
            if (closeIconContentDescription != null) {
                dVar.setContentDescription(closeIconContentDescription);
            } else {
                CharSequence text = chip.getText();
                Context context = chip.getContext();
                int i11 = R.string.mtrl_chip_close_icon_content_description;
                Object[] objArr = new Object[1];
                objArr[0] = TextUtils.isEmpty(text) ? "" : text;
                dVar.setContentDescription(context.getString(i11, objArr).trim());
            }
            dVar.setBoundsInParent(chip.getCloseIconTouchBoundsInt());
            dVar.addAction(d.a.f21822g);
            dVar.setEnabled(chip.isEnabled());
        }

        @Override // g1.a
        public void onVirtualViewKeyboardFocusChanged(int i10, boolean z10) {
            if (i10 == 1) {
                Chip chip = Chip.this;
                chip.f8971x = z10;
                chip.refreshDrawableState();
            }
        }
    }

    public Chip(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, R.attr.chipStyle);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public RectF getCloseIconTouchBounds() {
        RectF rectF = this.F;
        rectF.setEmpty();
        if (c() && this.f8966s != null) {
            this.f8963p.getCloseIconTouchBounds(rectF);
        }
        return rectF;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public Rect getCloseIconTouchBoundsInt() {
        RectF closeIconTouchBounds = getCloseIconTouchBounds();
        int i10 = (int) closeIconTouchBounds.left;
        int i11 = (int) closeIconTouchBounds.top;
        int i12 = (int) closeIconTouchBounds.right;
        int i13 = (int) closeIconTouchBounds.bottom;
        Rect rect = this.E;
        rect.set(i10, i11, i12, i13);
        return rect;
    }

    private n7.d getTextAppearance() {
        com.google.android.material.chip.a aVar = this.f8963p;
        if (aVar != null) {
            return aVar.getTextAppearance();
        }
        return null;
    }

    private void setCloseIconHovered(boolean z10) {
        if (this.f8970w != z10) {
            this.f8970w = z10;
            refreshDrawableState();
        }
    }

    private void setCloseIconPressed(boolean z10) {
        if (this.f8969v != z10) {
            this.f8969v = z10;
            refreshDrawableState();
        }
    }

    public final boolean c() {
        com.google.android.material.chip.a aVar = this.f8963p;
        return (aVar == null || aVar.getCloseIcon() == null) ? false : true;
    }

    public final void d() {
        if (c() && isCloseIconVisible() && this.f8966s != null) {
            j0.setAccessibilityDelegate(this, this.C);
            this.D = true;
        } else {
            j0.setAccessibilityDelegate(this, null);
            this.D = false;
        }
    }

    @Override // android.view.View
    public boolean dispatchHoverEvent(MotionEvent motionEvent) {
        return !this.D ? super.dispatchHoverEvent(motionEvent) : this.C.dispatchHoverEvent(motionEvent) || super.dispatchHoverEvent(motionEvent);
    }

    @Override // android.view.View
    public boolean dispatchKeyEvent(KeyEvent keyEvent) {
        if (!this.D) {
            return super.dispatchKeyEvent(keyEvent);
        }
        b bVar = this.C;
        if (!bVar.dispatchKeyEvent(keyEvent) || bVar.getKeyboardFocusedVirtualViewId() == Integer.MIN_VALUE) {
            return super.dispatchKeyEvent(keyEvent);
        }
        return true;
    }

    /* JADX WARN: Type inference failed for: r2v0, types: [boolean, int] */
    @Override // androidx.appcompat.widget.g, android.widget.CompoundButton, android.widget.TextView, android.view.View
    public void drawableStateChanged() {
        super.drawableStateChanged();
        com.google.android.material.chip.a aVar = this.f8963p;
        boolean closeIconState = false;
        int i10 = 0;
        closeIconState = false;
        if (aVar != null && aVar.isCloseIconStateful()) {
            com.google.android.material.chip.a aVar2 = this.f8963p;
            ?? IsEnabled = isEnabled();
            int i11 = IsEnabled;
            if (this.f8971x) {
                i11 = IsEnabled + 1;
            }
            int i12 = i11;
            if (this.f8970w) {
                i12 = i11 + 1;
            }
            int i13 = i12;
            if (this.f8969v) {
                i13 = i12 + 1;
            }
            int i14 = i13;
            if (isChecked()) {
                i14 = i13 + 1;
            }
            int[] iArr = new int[i14];
            if (isEnabled()) {
                iArr[0] = 16842910;
                i10 = 1;
            }
            if (this.f8971x) {
                iArr[i10] = 16842908;
                i10++;
            }
            if (this.f8970w) {
                iArr[i10] = 16843623;
                i10++;
            }
            if (this.f8969v) {
                iArr[i10] = 16842919;
                i10++;
            }
            if (isChecked()) {
                iArr[i10] = 16842913;
            }
            closeIconState = aVar2.setCloseIconState(iArr);
        }
        if (closeIconState) {
            invalidate();
        }
    }

    public final void e() {
        this.f8965r = new RippleDrawable(o7.b.sanitizeRippleDrawableColor(this.f8963p.getRippleColor()), getBackgroundDrawable(), null);
        this.f8963p.setUseCompatRipple(false);
        j0.setBackground(this, this.f8965r);
        f();
    }

    public boolean ensureAccessibleTouchTarget(int i10) {
        this.A = i10;
        if (!shouldEnsureMinTouchTargetSize()) {
            InsetDrawable insetDrawable = this.f8964q;
            if (insetDrawable == null) {
                int[] iArr = o7.b.f17032a;
                e();
            } else if (insetDrawable != null) {
                this.f8964q = null;
                setMinWidth(0);
                setMinHeight((int) getChipMinHeight());
                int[] iArr2 = o7.b.f17032a;
                e();
            }
            return false;
        }
        int iMax = Math.max(0, i10 - this.f8963p.getIntrinsicHeight());
        int iMax2 = Math.max(0, i10 - this.f8963p.getIntrinsicWidth());
        if (iMax2 <= 0 && iMax <= 0) {
            InsetDrawable insetDrawable2 = this.f8964q;
            if (insetDrawable2 == null) {
                int[] iArr3 = o7.b.f17032a;
                e();
            } else if (insetDrawable2 != null) {
                this.f8964q = null;
                setMinWidth(0);
                setMinHeight((int) getChipMinHeight());
                int[] iArr4 = o7.b.f17032a;
                e();
            }
            return false;
        }
        int i11 = iMax2 > 0 ? iMax2 / 2 : 0;
        int i12 = iMax > 0 ? iMax / 2 : 0;
        if (this.f8964q != null) {
            Rect rect = new Rect();
            this.f8964q.getPadding(rect);
            if (rect.top == i12 && rect.bottom == i12 && rect.left == i11 && rect.right == i11) {
                int[] iArr5 = o7.b.f17032a;
                e();
                return true;
            }
        }
        if (getMinHeight() != i10) {
            setMinHeight(i10);
        }
        if (getMinWidth() != i10) {
            setMinWidth(i10);
        }
        this.f8964q = new InsetDrawable((Drawable) this.f8963p, i11, i12, i11, i12);
        int[] iArr6 = o7.b.f17032a;
        e();
        return true;
    }

    public final void f() {
        com.google.android.material.chip.a aVar;
        if (TextUtils.isEmpty(getText()) || (aVar = this.f8963p) == null) {
            return;
        }
        int iK = (int) (this.f8963p.k() + this.f8963p.getTextEndPadding() + aVar.getChipEndPadding());
        int iJ = (int) (this.f8963p.j() + this.f8963p.getTextStartPadding() + this.f8963p.getChipStartPadding());
        if (this.f8964q != null) {
            Rect rect = new Rect();
            this.f8964q.getPadding(rect);
            iJ += rect.left;
            iK += rect.right;
        }
        j0.setPaddingRelative(this, iJ, getPaddingTop(), iK, getPaddingBottom());
    }

    public final void g() {
        TextPaint paint = getPaint();
        com.google.android.material.chip.a aVar = this.f8963p;
        if (aVar != null) {
            paint.drawableState = aVar.getState();
        }
        n7.d textAppearance = getTextAppearance();
        if (textAppearance != null) {
            textAppearance.updateDrawState(getContext(), paint, this.G);
        }
    }

    @Override // android.widget.CheckBox, android.widget.CompoundButton, android.widget.Button, android.widget.TextView, android.view.View
    public CharSequence getAccessibilityClassName() {
        if (!TextUtils.isEmpty(this.B)) {
            return this.B;
        }
        if (!isCheckable()) {
            return isClickable() ? "android.widget.Button" : "android.view.View";
        }
        ViewParent parent = getParent();
        return ((parent instanceof c) && ((c) parent).isSingleSelection()) ? "android.widget.RadioButton" : "android.widget.Button";
    }

    public Drawable getBackgroundDrawable() {
        InsetDrawable insetDrawable = this.f8964q;
        return insetDrawable == null ? this.f8963p : insetDrawable;
    }

    public Drawable getCheckedIcon() {
        com.google.android.material.chip.a aVar = this.f8963p;
        if (aVar != null) {
            return aVar.getCheckedIcon();
        }
        return null;
    }

    public ColorStateList getCheckedIconTint() {
        com.google.android.material.chip.a aVar = this.f8963p;
        if (aVar != null) {
            return aVar.getCheckedIconTint();
        }
        return null;
    }

    public ColorStateList getChipBackgroundColor() {
        com.google.android.material.chip.a aVar = this.f8963p;
        if (aVar != null) {
            return aVar.getChipBackgroundColor();
        }
        return null;
    }

    public float getChipCornerRadius() {
        com.google.android.material.chip.a aVar = this.f8963p;
        if (aVar != null) {
            return Math.max(0.0f, aVar.getChipCornerRadius());
        }
        return 0.0f;
    }

    public Drawable getChipDrawable() {
        return this.f8963p;
    }

    public float getChipEndPadding() {
        com.google.android.material.chip.a aVar = this.f8963p;
        if (aVar != null) {
            return aVar.getChipEndPadding();
        }
        return 0.0f;
    }

    public Drawable getChipIcon() {
        com.google.android.material.chip.a aVar = this.f8963p;
        if (aVar != null) {
            return aVar.getChipIcon();
        }
        return null;
    }

    public float getChipIconSize() {
        com.google.android.material.chip.a aVar = this.f8963p;
        if (aVar != null) {
            return aVar.getChipIconSize();
        }
        return 0.0f;
    }

    public ColorStateList getChipIconTint() {
        com.google.android.material.chip.a aVar = this.f8963p;
        if (aVar != null) {
            return aVar.getChipIconTint();
        }
        return null;
    }

    public float getChipMinHeight() {
        com.google.android.material.chip.a aVar = this.f8963p;
        if (aVar != null) {
            return aVar.getChipMinHeight();
        }
        return 0.0f;
    }

    public float getChipStartPadding() {
        com.google.android.material.chip.a aVar = this.f8963p;
        if (aVar != null) {
            return aVar.getChipStartPadding();
        }
        return 0.0f;
    }

    public ColorStateList getChipStrokeColor() {
        com.google.android.material.chip.a aVar = this.f8963p;
        if (aVar != null) {
            return aVar.getChipStrokeColor();
        }
        return null;
    }

    public float getChipStrokeWidth() {
        com.google.android.material.chip.a aVar = this.f8963p;
        if (aVar != null) {
            return aVar.getChipStrokeWidth();
        }
        return 0.0f;
    }

    @Deprecated
    public CharSequence getChipText() {
        return getText();
    }

    public Drawable getCloseIcon() {
        com.google.android.material.chip.a aVar = this.f8963p;
        if (aVar != null) {
            return aVar.getCloseIcon();
        }
        return null;
    }

    public CharSequence getCloseIconContentDescription() {
        com.google.android.material.chip.a aVar = this.f8963p;
        if (aVar != null) {
            return aVar.getCloseIconContentDescription();
        }
        return null;
    }

    public float getCloseIconEndPadding() {
        com.google.android.material.chip.a aVar = this.f8963p;
        if (aVar != null) {
            return aVar.getCloseIconEndPadding();
        }
        return 0.0f;
    }

    public float getCloseIconSize() {
        com.google.android.material.chip.a aVar = this.f8963p;
        if (aVar != null) {
            return aVar.getCloseIconSize();
        }
        return 0.0f;
    }

    public float getCloseIconStartPadding() {
        com.google.android.material.chip.a aVar = this.f8963p;
        if (aVar != null) {
            return aVar.getCloseIconStartPadding();
        }
        return 0.0f;
    }

    public ColorStateList getCloseIconTint() {
        com.google.android.material.chip.a aVar = this.f8963p;
        if (aVar != null) {
            return aVar.getCloseIconTint();
        }
        return null;
    }

    @Override // android.widget.TextView
    public TextUtils.TruncateAt getEllipsize() {
        com.google.android.material.chip.a aVar = this.f8963p;
        if (aVar != null) {
            return aVar.getEllipsize();
        }
        return null;
    }

    @Override // android.widget.TextView, android.view.View
    public void getFocusedRect(Rect rect) {
        if (this.D) {
            b bVar = this.C;
            if (bVar.getKeyboardFocusedVirtualViewId() == 1 || bVar.getAccessibilityFocusedVirtualViewId() == 1) {
                rect.set(getCloseIconTouchBoundsInt());
                return;
            }
        }
        super.getFocusedRect(rect);
    }

    public h getHideMotionSpec() {
        com.google.android.material.chip.a aVar = this.f8963p;
        if (aVar != null) {
            return aVar.getHideMotionSpec();
        }
        return null;
    }

    public float getIconEndPadding() {
        com.google.android.material.chip.a aVar = this.f8963p;
        if (aVar != null) {
            return aVar.getIconEndPadding();
        }
        return 0.0f;
    }

    public float getIconStartPadding() {
        com.google.android.material.chip.a aVar = this.f8963p;
        if (aVar != null) {
            return aVar.getIconStartPadding();
        }
        return 0.0f;
    }

    public ColorStateList getRippleColor() {
        com.google.android.material.chip.a aVar = this.f8963p;
        if (aVar != null) {
            return aVar.getRippleColor();
        }
        return null;
    }

    public l getShapeAppearanceModel() {
        return this.f8963p.getShapeAppearanceModel();
    }

    public h getShowMotionSpec() {
        com.google.android.material.chip.a aVar = this.f8963p;
        if (aVar != null) {
            return aVar.getShowMotionSpec();
        }
        return null;
    }

    public float getTextEndPadding() {
        com.google.android.material.chip.a aVar = this.f8963p;
        if (aVar != null) {
            return aVar.getTextEndPadding();
        }
        return 0.0f;
    }

    public float getTextStartPadding() {
        com.google.android.material.chip.a aVar = this.f8963p;
        if (aVar != null) {
            return aVar.getTextStartPadding();
        }
        return 0.0f;
    }

    public boolean isCheckable() {
        com.google.android.material.chip.a aVar = this.f8963p;
        return aVar != null && aVar.isCheckable();
    }

    public boolean isCloseIconVisible() {
        com.google.android.material.chip.a aVar = this.f8963p;
        return aVar != null && aVar.isCloseIconVisible();
    }

    @Override // android.widget.TextView, android.view.View
    public void onAttachedToWindow() {
        super.onAttachedToWindow();
        i.setParentAbsoluteElevation(this, this.f8963p);
    }

    @Override // com.google.android.material.chip.a.InterfaceC0085a
    public void onChipDrawableSizeChange() {
        ensureAccessibleTouchTarget(this.A);
        requestLayout();
        invalidateOutline();
    }

    @Override // android.widget.CompoundButton, android.widget.TextView, android.view.View
    public int[] onCreateDrawableState(int i10) {
        int[] iArrOnCreateDrawableState = super.onCreateDrawableState(i10 + 2);
        if (isChecked()) {
            View.mergeDrawableStates(iArrOnCreateDrawableState, J);
        }
        if (isCheckable()) {
            View.mergeDrawableStates(iArrOnCreateDrawableState, K);
        }
        return iArrOnCreateDrawableState;
    }

    @Override // android.widget.TextView, android.view.View
    public void onFocusChanged(boolean z10, int i10, Rect rect) {
        super.onFocusChanged(z10, i10, rect);
        if (this.D) {
            this.C.onFocusChanged(z10, i10, rect);
        }
    }

    @Override // android.view.View
    public boolean onHoverEvent(MotionEvent motionEvent) {
        int actionMasked = motionEvent.getActionMasked();
        if (actionMasked == 7) {
            setCloseIconHovered(getCloseIconTouchBounds().contains(motionEvent.getX(), motionEvent.getY()));
        } else if (actionMasked == 10) {
            setCloseIconHovered(false);
        }
        return super.onHoverEvent(motionEvent);
    }

    @Override // android.view.View
    public void onInitializeAccessibilityNodeInfo(AccessibilityNodeInfo accessibilityNodeInfo) {
        int i10;
        super.onInitializeAccessibilityNodeInfo(accessibilityNodeInfo);
        accessibilityNodeInfo.setClassName(getAccessibilityClassName());
        accessibilityNodeInfo.setCheckable(isCheckable());
        accessibilityNodeInfo.setClickable(isClickable());
        if (getParent() instanceof c) {
            c cVar = (c) getParent();
            d dVarWrap = d.wrap(accessibilityNodeInfo);
            int i11 = -1;
            if (cVar.isSingleLine()) {
                int i12 = 0;
                int i13 = 0;
                while (true) {
                    if (i12 >= cVar.getChildCount()) {
                        break;
                    }
                    View childAt = cVar.getChildAt(i12);
                    if (childAt instanceof Chip) {
                        if (!(cVar.getChildAt(i12).getVisibility() == 0)) {
                            continue;
                        } else {
                            if (((Chip) childAt) == this) {
                                i11 = i13;
                                break;
                            }
                            i13++;
                        }
                    }
                    i12++;
                }
                i10 = i11;
            } else {
                i10 = -1;
            }
            dVarWrap.setCollectionItemInfo(d.f.obtain(cVar.getRowIndex(this), 1, i10, 1, false, isChecked()));
        }
    }

    @Override // android.widget.Button, android.widget.TextView, android.view.View
    @TargetApi(24)
    public PointerIcon onResolvePointerIcon(MotionEvent motionEvent, int i10) {
        return (getCloseIconTouchBounds().contains(motionEvent.getX(), motionEvent.getY()) && isEnabled()) ? PointerIcon.getSystemIcon(getContext(), 1002) : super.onResolvePointerIcon(motionEvent, i10);
    }

    @Override // android.widget.TextView, android.view.View
    @TargetApi(17)
    public void onRtlPropertiesChanged(int i10) {
        super.onRtlPropertiesChanged(i10);
        if (this.f8973z != i10) {
            this.f8973z = i10;
            f();
        }
    }

    /* JADX WARN: Code restructure failed: missing block: B:8:0x001e, code lost:
    
        if (r0 != 3) goto L22;
     */
    @Override // android.widget.TextView, android.view.View
    @android.annotation.SuppressLint({"ClickableViewAccessibility"})
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public boolean onTouchEvent(android.view.MotionEvent r6) {
        /*
            r5 = this;
            int r0 = r6.getActionMasked()
            android.graphics.RectF r1 = r5.getCloseIconTouchBounds()
            float r2 = r6.getX()
            float r3 = r6.getY()
            boolean r1 = r1.contains(r2, r3)
            r2 = 1
            r3 = 0
            if (r0 == 0) goto L39
            if (r0 == r2) goto L2b
            r4 = 2
            if (r0 == r4) goto L21
            r1 = 3
            if (r0 == r1) goto L34
            goto L40
        L21:
            boolean r0 = r5.f8969v
            if (r0 == 0) goto L40
            if (r1 != 0) goto L3e
            r5.setCloseIconPressed(r3)
            goto L3e
        L2b:
            boolean r0 = r5.f8969v
            if (r0 == 0) goto L34
            r5.performCloseIconClick()
            r0 = 1
            goto L35
        L34:
            r0 = 0
        L35:
            r5.setCloseIconPressed(r3)
            goto L41
        L39:
            if (r1 == 0) goto L40
            r5.setCloseIconPressed(r2)
        L3e:
            r0 = 1
            goto L41
        L40:
            r0 = 0
        L41:
            if (r0 != 0) goto L4b
            boolean r6 = super.onTouchEvent(r6)
            if (r6 == 0) goto L4a
            goto L4b
        L4a:
            r2 = 0
        L4b:
            return r2
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.material.chip.Chip.onTouchEvent(android.view.MotionEvent):boolean");
    }

    public boolean performCloseIconClick() {
        boolean z10 = false;
        playSoundEffect(0);
        View.OnClickListener onClickListener = this.f8966s;
        if (onClickListener != null) {
            onClickListener.onClick(this);
            z10 = true;
        }
        if (this.D) {
            this.C.sendEventForVirtualView(1, 1);
        }
        return z10;
    }

    public void setAccessibilityClassName(CharSequence charSequence) {
        this.B = charSequence;
    }

    @Override // android.view.View
    public void setBackground(Drawable drawable) {
        if (drawable == getBackgroundDrawable() || drawable == this.f8965r) {
            super.setBackground(drawable);
        } else {
            Log.w("Chip", "Do not set the background; Chip manages its own background drawable.");
        }
    }

    @Override // android.view.View
    public void setBackgroundColor(int i10) {
        Log.w("Chip", "Do not set the background color; Chip manages its own background drawable.");
    }

    @Override // androidx.appcompat.widget.g, android.view.View
    public void setBackgroundDrawable(Drawable drawable) {
        if (drawable == getBackgroundDrawable() || drawable == this.f8965r) {
            super.setBackgroundDrawable(drawable);
        } else {
            Log.w("Chip", "Do not set the background drawable; Chip manages its own background drawable.");
        }
    }

    @Override // androidx.appcompat.widget.g, android.view.View
    public void setBackgroundResource(int i10) {
        Log.w("Chip", "Do not set the background resource; Chip manages its own background drawable.");
    }

    @Override // android.view.View
    public void setBackgroundTintList(ColorStateList colorStateList) {
        Log.w("Chip", "Do not set the background tint list; Chip manages its own background drawable.");
    }

    @Override // android.view.View
    public void setBackgroundTintMode(PorterDuff.Mode mode) {
        Log.w("Chip", "Do not set the background tint mode; Chip manages its own background drawable.");
    }

    public void setCheckable(boolean z10) {
        com.google.android.material.chip.a aVar = this.f8963p;
        if (aVar != null) {
            aVar.setCheckable(z10);
        }
    }

    public void setCheckableResource(int i10) {
        com.google.android.material.chip.a aVar = this.f8963p;
        if (aVar != null) {
            aVar.setCheckableResource(i10);
        }
    }

    @Override // android.widget.CompoundButton, android.widget.Checkable
    public void setChecked(boolean z10) {
        com.google.android.material.chip.a aVar = this.f8963p;
        if (aVar == null) {
            this.f8968u = z10;
        } else if (aVar.isCheckable()) {
            super.setChecked(z10);
        }
    }

    public void setCheckedIcon(Drawable drawable) {
        com.google.android.material.chip.a aVar = this.f8963p;
        if (aVar != null) {
            aVar.setCheckedIcon(drawable);
        }
    }

    @Deprecated
    public void setCheckedIconEnabled(boolean z10) {
        setCheckedIconVisible(z10);
    }

    @Deprecated
    public void setCheckedIconEnabledResource(int i10) {
        setCheckedIconVisible(i10);
    }

    public void setCheckedIconResource(int i10) {
        com.google.android.material.chip.a aVar = this.f8963p;
        if (aVar != null) {
            aVar.setCheckedIconResource(i10);
        }
    }

    public void setCheckedIconTint(ColorStateList colorStateList) {
        com.google.android.material.chip.a aVar = this.f8963p;
        if (aVar != null) {
            aVar.setCheckedIconTint(colorStateList);
        }
    }

    public void setCheckedIconTintResource(int i10) {
        com.google.android.material.chip.a aVar = this.f8963p;
        if (aVar != null) {
            aVar.setCheckedIconTintResource(i10);
        }
    }

    public void setCheckedIconVisible(int i10) {
        com.google.android.material.chip.a aVar = this.f8963p;
        if (aVar != null) {
            aVar.setCheckedIconVisible(i10);
        }
    }

    public void setChipBackgroundColor(ColorStateList colorStateList) {
        com.google.android.material.chip.a aVar = this.f8963p;
        if (aVar != null) {
            aVar.setChipBackgroundColor(colorStateList);
        }
    }

    public void setChipBackgroundColorResource(int i10) {
        com.google.android.material.chip.a aVar = this.f8963p;
        if (aVar != null) {
            aVar.setChipBackgroundColorResource(i10);
        }
    }

    @Deprecated
    public void setChipCornerRadius(float f10) {
        com.google.android.material.chip.a aVar = this.f8963p;
        if (aVar != null) {
            aVar.setChipCornerRadius(f10);
        }
    }

    @Deprecated
    public void setChipCornerRadiusResource(int i10) {
        com.google.android.material.chip.a aVar = this.f8963p;
        if (aVar != null) {
            aVar.setChipCornerRadiusResource(i10);
        }
    }

    public void setChipDrawable(com.google.android.material.chip.a aVar) {
        com.google.android.material.chip.a aVar2 = this.f8963p;
        if (aVar2 != aVar) {
            if (aVar2 != null) {
                aVar2.setDelegate(null);
            }
            this.f8963p = aVar;
            aVar.P0 = false;
            aVar.setDelegate(this);
            ensureAccessibleTouchTarget(this.A);
        }
    }

    public void setChipEndPadding(float f10) {
        com.google.android.material.chip.a aVar = this.f8963p;
        if (aVar != null) {
            aVar.setChipEndPadding(f10);
        }
    }

    public void setChipEndPaddingResource(int i10) {
        com.google.android.material.chip.a aVar = this.f8963p;
        if (aVar != null) {
            aVar.setChipEndPaddingResource(i10);
        }
    }

    public void setChipIcon(Drawable drawable) {
        com.google.android.material.chip.a aVar = this.f8963p;
        if (aVar != null) {
            aVar.setChipIcon(drawable);
        }
    }

    @Deprecated
    public void setChipIconEnabled(boolean z10) {
        setChipIconVisible(z10);
    }

    @Deprecated
    public void setChipIconEnabledResource(int i10) {
        setChipIconVisible(i10);
    }

    public void setChipIconResource(int i10) {
        com.google.android.material.chip.a aVar = this.f8963p;
        if (aVar != null) {
            aVar.setChipIconResource(i10);
        }
    }

    public void setChipIconSize(float f10) {
        com.google.android.material.chip.a aVar = this.f8963p;
        if (aVar != null) {
            aVar.setChipIconSize(f10);
        }
    }

    public void setChipIconSizeResource(int i10) {
        com.google.android.material.chip.a aVar = this.f8963p;
        if (aVar != null) {
            aVar.setChipIconSizeResource(i10);
        }
    }

    public void setChipIconTint(ColorStateList colorStateList) {
        com.google.android.material.chip.a aVar = this.f8963p;
        if (aVar != null) {
            aVar.setChipIconTint(colorStateList);
        }
    }

    public void setChipIconTintResource(int i10) {
        com.google.android.material.chip.a aVar = this.f8963p;
        if (aVar != null) {
            aVar.setChipIconTintResource(i10);
        }
    }

    public void setChipIconVisible(int i10) {
        com.google.android.material.chip.a aVar = this.f8963p;
        if (aVar != null) {
            aVar.setChipIconVisible(i10);
        }
    }

    public void setChipMinHeight(float f10) {
        com.google.android.material.chip.a aVar = this.f8963p;
        if (aVar != null) {
            aVar.setChipMinHeight(f10);
        }
    }

    public void setChipMinHeightResource(int i10) {
        com.google.android.material.chip.a aVar = this.f8963p;
        if (aVar != null) {
            aVar.setChipMinHeightResource(i10);
        }
    }

    public void setChipStartPadding(float f10) {
        com.google.android.material.chip.a aVar = this.f8963p;
        if (aVar != null) {
            aVar.setChipStartPadding(f10);
        }
    }

    public void setChipStartPaddingResource(int i10) {
        com.google.android.material.chip.a aVar = this.f8963p;
        if (aVar != null) {
            aVar.setChipStartPaddingResource(i10);
        }
    }

    public void setChipStrokeColor(ColorStateList colorStateList) {
        com.google.android.material.chip.a aVar = this.f8963p;
        if (aVar != null) {
            aVar.setChipStrokeColor(colorStateList);
        }
    }

    public void setChipStrokeColorResource(int i10) {
        com.google.android.material.chip.a aVar = this.f8963p;
        if (aVar != null) {
            aVar.setChipStrokeColorResource(i10);
        }
    }

    public void setChipStrokeWidth(float f10) {
        com.google.android.material.chip.a aVar = this.f8963p;
        if (aVar != null) {
            aVar.setChipStrokeWidth(f10);
        }
    }

    public void setChipStrokeWidthResource(int i10) {
        com.google.android.material.chip.a aVar = this.f8963p;
        if (aVar != null) {
            aVar.setChipStrokeWidthResource(i10);
        }
    }

    @Deprecated
    public void setChipText(CharSequence charSequence) {
        setText(charSequence);
    }

    @Deprecated
    public void setChipTextResource(int i10) {
        setText(getResources().getString(i10));
    }

    public void setCloseIcon(Drawable drawable) {
        com.google.android.material.chip.a aVar = this.f8963p;
        if (aVar != null) {
            aVar.setCloseIcon(drawable);
        }
        d();
    }

    public void setCloseIconContentDescription(CharSequence charSequence) {
        com.google.android.material.chip.a aVar = this.f8963p;
        if (aVar != null) {
            aVar.setCloseIconContentDescription(charSequence);
        }
    }

    @Deprecated
    public void setCloseIconEnabled(boolean z10) {
        setCloseIconVisible(z10);
    }

    @Deprecated
    public void setCloseIconEnabledResource(int i10) {
        setCloseIconVisible(i10);
    }

    public void setCloseIconEndPadding(float f10) {
        com.google.android.material.chip.a aVar = this.f8963p;
        if (aVar != null) {
            aVar.setCloseIconEndPadding(f10);
        }
    }

    public void setCloseIconEndPaddingResource(int i10) {
        com.google.android.material.chip.a aVar = this.f8963p;
        if (aVar != null) {
            aVar.setCloseIconEndPaddingResource(i10);
        }
    }

    public void setCloseIconResource(int i10) {
        com.google.android.material.chip.a aVar = this.f8963p;
        if (aVar != null) {
            aVar.setCloseIconResource(i10);
        }
        d();
    }

    public void setCloseIconSize(float f10) {
        com.google.android.material.chip.a aVar = this.f8963p;
        if (aVar != null) {
            aVar.setCloseIconSize(f10);
        }
    }

    public void setCloseIconSizeResource(int i10) {
        com.google.android.material.chip.a aVar = this.f8963p;
        if (aVar != null) {
            aVar.setCloseIconSizeResource(i10);
        }
    }

    public void setCloseIconStartPadding(float f10) {
        com.google.android.material.chip.a aVar = this.f8963p;
        if (aVar != null) {
            aVar.setCloseIconStartPadding(f10);
        }
    }

    public void setCloseIconStartPaddingResource(int i10) {
        com.google.android.material.chip.a aVar = this.f8963p;
        if (aVar != null) {
            aVar.setCloseIconStartPaddingResource(i10);
        }
    }

    public void setCloseIconTint(ColorStateList colorStateList) {
        com.google.android.material.chip.a aVar = this.f8963p;
        if (aVar != null) {
            aVar.setCloseIconTint(colorStateList);
        }
    }

    public void setCloseIconTintResource(int i10) {
        com.google.android.material.chip.a aVar = this.f8963p;
        if (aVar != null) {
            aVar.setCloseIconTintResource(i10);
        }
    }

    public void setCloseIconVisible(int i10) {
        setCloseIconVisible(getResources().getBoolean(i10));
    }

    @Override // androidx.appcompat.widget.g, android.widget.TextView
    public void setCompoundDrawables(Drawable drawable, Drawable drawable2, Drawable drawable3, Drawable drawable4) {
        if (drawable != null) {
            throw new UnsupportedOperationException("Please set start drawable using R.attr#chipIcon.");
        }
        if (drawable3 != null) {
            throw new UnsupportedOperationException("Please set end drawable using R.attr#closeIcon.");
        }
        super.setCompoundDrawables(drawable, drawable2, drawable3, drawable4);
    }

    @Override // androidx.appcompat.widget.g, android.widget.TextView
    public void setCompoundDrawablesRelative(Drawable drawable, Drawable drawable2, Drawable drawable3, Drawable drawable4) {
        if (drawable != null) {
            throw new UnsupportedOperationException("Please set start drawable using R.attr#chipIcon.");
        }
        if (drawable3 != null) {
            throw new UnsupportedOperationException("Please set end drawable using R.attr#closeIcon.");
        }
        super.setCompoundDrawablesRelative(drawable, drawable2, drawable3, drawable4);
    }

    @Override // android.widget.TextView
    public void setCompoundDrawablesRelativeWithIntrinsicBounds(int i10, int i11, int i12, int i13) {
        if (i10 != 0) {
            throw new UnsupportedOperationException("Please set start drawable using R.attr#chipIcon.");
        }
        if (i12 != 0) {
            throw new UnsupportedOperationException("Please set end drawable using R.attr#closeIcon.");
        }
        super.setCompoundDrawablesRelativeWithIntrinsicBounds(i10, i11, i12, i13);
    }

    @Override // android.widget.TextView
    public void setCompoundDrawablesWithIntrinsicBounds(int i10, int i11, int i12, int i13) {
        if (i10 != 0) {
            throw new UnsupportedOperationException("Please set start drawable using R.attr#chipIcon.");
        }
        if (i12 != 0) {
            throw new UnsupportedOperationException("Please set end drawable using R.attr#closeIcon.");
        }
        super.setCompoundDrawablesWithIntrinsicBounds(i10, i11, i12, i13);
    }

    @Override // android.view.View
    public void setElevation(float f10) {
        super.setElevation(f10);
        com.google.android.material.chip.a aVar = this.f8963p;
        if (aVar != null) {
            aVar.setElevation(f10);
        }
    }

    @Override // android.widget.TextView
    public void setEllipsize(TextUtils.TruncateAt truncateAt) {
        if (this.f8963p == null) {
            return;
        }
        if (truncateAt == TextUtils.TruncateAt.MARQUEE) {
            throw new UnsupportedOperationException("Text within a chip are not allowed to scroll.");
        }
        super.setEllipsize(truncateAt);
        com.google.android.material.chip.a aVar = this.f8963p;
        if (aVar != null) {
            aVar.setEllipsize(truncateAt);
        }
    }

    public void setEnsureMinTouchTargetSize(boolean z10) {
        this.f8972y = z10;
        ensureAccessibleTouchTarget(this.A);
    }

    @Override // android.widget.TextView
    public void setGravity(int i10) {
        if (i10 != 8388627) {
            Log.w("Chip", "Chip text must be vertically center and start aligned");
        } else {
            super.setGravity(i10);
        }
    }

    public void setHideMotionSpec(h hVar) {
        com.google.android.material.chip.a aVar = this.f8963p;
        if (aVar != null) {
            aVar.setHideMotionSpec(hVar);
        }
    }

    public void setHideMotionSpecResource(int i10) {
        com.google.android.material.chip.a aVar = this.f8963p;
        if (aVar != null) {
            aVar.setHideMotionSpecResource(i10);
        }
    }

    public void setIconEndPadding(float f10) {
        com.google.android.material.chip.a aVar = this.f8963p;
        if (aVar != null) {
            aVar.setIconEndPadding(f10);
        }
    }

    public void setIconEndPaddingResource(int i10) {
        com.google.android.material.chip.a aVar = this.f8963p;
        if (aVar != null) {
            aVar.setIconEndPaddingResource(i10);
        }
    }

    public void setIconStartPadding(float f10) {
        com.google.android.material.chip.a aVar = this.f8963p;
        if (aVar != null) {
            aVar.setIconStartPadding(f10);
        }
    }

    public void setIconStartPaddingResource(int i10) {
        com.google.android.material.chip.a aVar = this.f8963p;
        if (aVar != null) {
            aVar.setIconStartPaddingResource(i10);
        }
    }

    @Override // android.view.View
    public void setLayoutDirection(int i10) {
        if (this.f8963p == null) {
            return;
        }
        super.setLayoutDirection(i10);
    }

    @Override // android.widget.TextView
    public void setLines(int i10) {
        if (i10 > 1) {
            throw new UnsupportedOperationException("Chip does not support multi-line text");
        }
        super.setLines(i10);
    }

    @Override // android.widget.TextView
    public void setMaxLines(int i10) {
        if (i10 > 1) {
            throw new UnsupportedOperationException("Chip does not support multi-line text");
        }
        super.setMaxLines(i10);
    }

    @Override // android.widget.TextView
    public void setMaxWidth(int i10) {
        super.setMaxWidth(i10);
        com.google.android.material.chip.a aVar = this.f8963p;
        if (aVar != null) {
            aVar.setMaxWidth(i10);
        }
    }

    @Override // android.widget.TextView
    public void setMinLines(int i10) {
        if (i10 > 1) {
            throw new UnsupportedOperationException("Chip does not support multi-line text");
        }
        super.setMinLines(i10);
    }

    @Override // android.widget.CompoundButton
    public void setOnCheckedChangeListener(CompoundButton.OnCheckedChangeListener onCheckedChangeListener) {
        this.f8967t = onCheckedChangeListener;
    }

    public void setOnCloseIconClickListener(View.OnClickListener onClickListener) {
        this.f8966s = onClickListener;
        d();
    }

    public void setRippleColor(ColorStateList colorStateList) {
        com.google.android.material.chip.a aVar = this.f8963p;
        if (aVar != null) {
            aVar.setRippleColor(colorStateList);
        }
        if (this.f8963p.getUseCompatRipple()) {
            return;
        }
        e();
    }

    public void setRippleColorResource(int i10) {
        com.google.android.material.chip.a aVar = this.f8963p;
        if (aVar != null) {
            aVar.setRippleColorResource(i10);
            if (this.f8963p.getUseCompatRipple()) {
                return;
            }
            e();
        }
    }

    @Override // q7.p
    public void setShapeAppearanceModel(l lVar) {
        this.f8963p.setShapeAppearanceModel(lVar);
    }

    public void setShowMotionSpec(h hVar) {
        com.google.android.material.chip.a aVar = this.f8963p;
        if (aVar != null) {
            aVar.setShowMotionSpec(hVar);
        }
    }

    public void setShowMotionSpecResource(int i10) {
        com.google.android.material.chip.a aVar = this.f8963p;
        if (aVar != null) {
            aVar.setShowMotionSpecResource(i10);
        }
    }

    @Override // android.widget.TextView
    public void setSingleLine(boolean z10) {
        if (!z10) {
            throw new UnsupportedOperationException("Chip does not support multi-line text");
        }
        super.setSingleLine(z10);
    }

    @Override // android.widget.TextView
    public void setText(CharSequence charSequence, TextView.BufferType bufferType) {
        com.google.android.material.chip.a aVar = this.f8963p;
        if (aVar == null) {
            return;
        }
        if (charSequence == null) {
            charSequence = "";
        }
        super.setText(aVar.P0 ? null : charSequence, bufferType);
        com.google.android.material.chip.a aVar2 = this.f8963p;
        if (aVar2 != null) {
            aVar2.setText(charSequence);
        }
    }

    public void setTextAppearance(n7.d dVar) {
        com.google.android.material.chip.a aVar = this.f8963p;
        if (aVar != null) {
            aVar.setTextAppearance(dVar);
        }
        g();
    }

    public void setTextAppearanceResource(int i10) {
        setTextAppearance(getContext(), i10);
    }

    public void setTextEndPadding(float f10) {
        com.google.android.material.chip.a aVar = this.f8963p;
        if (aVar != null) {
            aVar.setTextEndPadding(f10);
        }
    }

    public void setTextEndPaddingResource(int i10) {
        com.google.android.material.chip.a aVar = this.f8963p;
        if (aVar != null) {
            aVar.setTextEndPaddingResource(i10);
        }
    }

    @Override // android.widget.TextView
    public void setTextSize(int i10, float f10) {
        super.setTextSize(i10, f10);
        com.google.android.material.chip.a aVar = this.f8963p;
        if (aVar != null) {
            aVar.setTextSize(TypedValue.applyDimension(i10, f10, getResources().getDisplayMetrics()));
        }
        g();
    }

    public void setTextStartPadding(float f10) {
        com.google.android.material.chip.a aVar = this.f8963p;
        if (aVar != null) {
            aVar.setTextStartPadding(f10);
        }
    }

    public void setTextStartPaddingResource(int i10) {
        com.google.android.material.chip.a aVar = this.f8963p;
        if (aVar != null) {
            aVar.setTextStartPaddingResource(i10);
        }
    }

    public boolean shouldEnsureMinTouchTargetSize() {
        return this.f8972y;
    }

    /* JADX WARN: Illegal instructions before constructor call */
    public Chip(Context context, AttributeSet attributeSet, int i10) {
        int i11 = H;
        super(x7.a.wrap(context, attributeSet, i10, i11), attributeSet, i10);
        this.E = new Rect();
        this.F = new RectF();
        this.G = new a();
        Context context2 = getContext();
        if (attributeSet != null) {
            if (attributeSet.getAttributeValue("http://schemas.android.com/apk/res/android", "background") != null) {
                Log.w("Chip", "Do not set the background; Chip manages its own background drawable.");
            }
            if (attributeSet.getAttributeValue("http://schemas.android.com/apk/res/android", "drawableLeft") != null) {
                throw new UnsupportedOperationException("Please set left drawable using R.attr#chipIcon.");
            }
            if (attributeSet.getAttributeValue("http://schemas.android.com/apk/res/android", "drawableStart") != null) {
                throw new UnsupportedOperationException("Please set start drawable using R.attr#chipIcon.");
            }
            if (attributeSet.getAttributeValue("http://schemas.android.com/apk/res/android", "drawableEnd") != null) {
                throw new UnsupportedOperationException("Please set end drawable using R.attr#closeIcon.");
            }
            if (attributeSet.getAttributeValue("http://schemas.android.com/apk/res/android", "drawableRight") != null) {
                throw new UnsupportedOperationException("Please set end drawable using R.attr#closeIcon.");
            }
            if (!attributeSet.getAttributeBooleanValue("http://schemas.android.com/apk/res/android", "singleLine", true) || attributeSet.getAttributeIntValue("http://schemas.android.com/apk/res/android", "lines", 1) != 1 || attributeSet.getAttributeIntValue("http://schemas.android.com/apk/res/android", "minLines", 1) != 1 || attributeSet.getAttributeIntValue("http://schemas.android.com/apk/res/android", "maxLines", 1) != 1) {
                throw new UnsupportedOperationException("Chip does not support multi-line text");
            }
            if (attributeSet.getAttributeIntValue("http://schemas.android.com/apk/res/android", "gravity", 8388627) != 8388627) {
                Log.w("Chip", "Chip text must be vertically center and start aligned");
            }
        }
        com.google.android.material.chip.a aVarCreateFromAttributes = com.google.android.material.chip.a.createFromAttributes(context2, attributeSet, i10, i11);
        int[] iArr = R.styleable.Chip;
        int i12 = 0;
        TypedArray typedArrayObtainStyledAttributes = r.obtainStyledAttributes(context2, attributeSet, iArr, i10, i11, new int[0]);
        this.f8972y = typedArrayObtainStyledAttributes.getBoolean(R.styleable.Chip_ensureMinTouchTargetSize, false);
        this.A = (int) Math.ceil(typedArrayObtainStyledAttributes.getDimension(R.styleable.Chip_chipMinTouchTargetSize, (float) Math.ceil(t.dpToPx(getContext(), 48))));
        typedArrayObtainStyledAttributes.recycle();
        setChipDrawable(aVarCreateFromAttributes);
        aVarCreateFromAttributes.setElevation(j0.getElevation(this));
        TypedArray typedArrayObtainStyledAttributes2 = r.obtainStyledAttributes(context2, attributeSet, iArr, i10, i11, new int[0]);
        if (Build.VERSION.SDK_INT < 23) {
            setTextColor(n7.c.getColorStateList(context2, typedArrayObtainStyledAttributes2, R.styleable.Chip_android_textColor));
        }
        boolean zHasValue = typedArrayObtainStyledAttributes2.hasValue(R.styleable.Chip_shapeAppearance);
        typedArrayObtainStyledAttributes2.recycle();
        this.C = new b(this);
        d();
        if (!zHasValue) {
            setOutlineProvider(new z6.b(this));
        }
        setChecked(this.f8968u);
        setText(aVarCreateFromAttributes.getText());
        setEllipsize(aVarCreateFromAttributes.getEllipsize());
        g();
        if (!this.f8963p.P0) {
            setLines(1);
            setHorizontallyScrolling(true);
        }
        setGravity(8388627);
        f();
        if (shouldEnsureMinTouchTargetSize()) {
            setMinHeight(this.A);
        }
        this.f8973z = j0.getLayoutDirection(this);
        super.setOnCheckedChangeListener(new z6.a(this, i12));
    }

    public void setCloseIconVisible(boolean z10) {
        com.google.android.material.chip.a aVar = this.f8963p;
        if (aVar != null) {
            aVar.setCloseIconVisible(z10);
        }
        d();
    }

    public void setCheckedIconVisible(boolean z10) {
        com.google.android.material.chip.a aVar = this.f8963p;
        if (aVar != null) {
            aVar.setCheckedIconVisible(z10);
        }
    }

    public void setChipIconVisible(boolean z10) {
        com.google.android.material.chip.a aVar = this.f8963p;
        if (aVar != null) {
            aVar.setChipIconVisible(z10);
        }
    }

    @Override // android.widget.TextView
    public void setCompoundDrawablesRelativeWithIntrinsicBounds(Drawable drawable, Drawable drawable2, Drawable drawable3, Drawable drawable4) {
        if (drawable != null) {
            throw new UnsupportedOperationException("Please set start drawable using R.attr#chipIcon.");
        }
        if (drawable3 == null) {
            super.setCompoundDrawablesRelativeWithIntrinsicBounds(drawable, drawable2, drawable3, drawable4);
            return;
        }
        throw new UnsupportedOperationException("Please set end drawable using R.attr#closeIcon.");
    }

    @Override // android.widget.TextView
    public void setCompoundDrawablesWithIntrinsicBounds(Drawable drawable, Drawable drawable2, Drawable drawable3, Drawable drawable4) {
        if (drawable != null) {
            throw new UnsupportedOperationException("Please set left drawable using R.attr#chipIcon.");
        }
        if (drawable3 == null) {
            super.setCompoundDrawablesWithIntrinsicBounds(drawable, drawable2, drawable3, drawable4);
            return;
        }
        throw new UnsupportedOperationException("Please set right drawable using R.attr#closeIcon.");
    }

    @Override // android.widget.TextView
    public void setTextAppearance(Context context, int i10) {
        super.setTextAppearance(context, i10);
        com.google.android.material.chip.a aVar = this.f8963p;
        if (aVar != null) {
            aVar.setTextAppearanceResource(i10);
        }
        g();
    }

    @Override // android.widget.TextView
    public void setTextAppearance(int i10) {
        super.setTextAppearance(i10);
        com.google.android.material.chip.a aVar = this.f8963p;
        if (aVar != null) {
            aVar.setTextAppearanceResource(i10);
        }
        g();
    }

    public class a extends f {
        public a() {
        }

        @Override // n7.f
        public void onFontRetrieved(Typeface typeface, boolean z10) {
            Chip chip = Chip.this;
            com.google.android.material.chip.a aVar = chip.f8963p;
            chip.setText(aVar.P0 ? aVar.getText() : chip.getText());
            chip.requestLayout();
            chip.invalidate();
        }

        @Override // n7.f
        public void onFontRetrievalFailed(int i10) {
        }
    }

    public void setInternalOnCheckedChangeListener(i7.g<Chip> gVar) {
    }
}
