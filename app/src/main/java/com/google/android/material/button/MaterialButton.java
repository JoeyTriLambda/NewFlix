package com.google.android.material.button;

import android.R;
import android.content.Context;
import android.content.res.ColorStateList;
import android.content.res.TypedArray;
import android.graphics.PorterDuff;
import android.graphics.Rect;
import android.graphics.drawable.Drawable;
import android.graphics.drawable.RippleDrawable;
import android.os.Build;
import android.os.Parcel;
import android.os.Parcelable;
import android.text.Layout;
import android.text.TextPaint;
import android.text.TextUtils;
import android.util.AttributeSet;
import android.util.Log;
import android.view.View;
import android.view.accessibility.AccessibilityEvent;
import android.view.accessibility.AccessibilityNodeInfo;
import android.widget.Button;
import android.widget.Checkable;
import android.widget.CompoundButton;
import androidx.appcompat.widget.f;
import com.google.android.material.button.MaterialButtonToggleGroup;
import d1.i;
import i7.r;
import i7.t;
import java.util.Iterator;
import java.util.LinkedHashSet;
import q7.l;
import q7.p;
import x0.j0;

/* loaded from: classes.dex */
public class MaterialButton extends f implements Checkable, p {
    public static final int[] C = {R.attr.state_checkable};
    public static final int[] D = {R.attr.state_checked};
    public static final int E = com.google.android.material.R.style.Widget_MaterialComponents_Button;
    public boolean A;
    public int B;

    /* renamed from: o, reason: collision with root package name */
    public final u6.a f8883o;

    /* renamed from: p, reason: collision with root package name */
    public final LinkedHashSet<a> f8884p;

    /* renamed from: q, reason: collision with root package name */
    public b f8885q;

    /* renamed from: r, reason: collision with root package name */
    public PorterDuff.Mode f8886r;

    /* renamed from: s, reason: collision with root package name */
    public ColorStateList f8887s;

    /* renamed from: t, reason: collision with root package name */
    public Drawable f8888t;

    /* renamed from: u, reason: collision with root package name */
    public String f8889u;

    /* renamed from: v, reason: collision with root package name */
    public int f8890v;

    /* renamed from: w, reason: collision with root package name */
    public int f8891w;

    /* renamed from: x, reason: collision with root package name */
    public int f8892x;

    /* renamed from: y, reason: collision with root package name */
    public int f8893y;

    /* renamed from: z, reason: collision with root package name */
    public boolean f8894z;

    public interface a {
        void onCheckedChanged(MaterialButton materialButton, boolean z10);
    }

    public interface b {
    }

    public static class c extends f1.a {
        public static final Parcelable.Creator<c> CREATOR = new a();

        /* renamed from: n, reason: collision with root package name */
        public boolean f8895n;

        public class a implements Parcelable.ClassLoaderCreator<c> {
            @Override // android.os.Parcelable.Creator
            public c[] newArray(int i10) {
                return new c[i10];
            }

            /* JADX WARN: Can't rename method to resolve collision */
            @Override // android.os.Parcelable.ClassLoaderCreator
            public c createFromParcel(Parcel parcel, ClassLoader classLoader) {
                return new c(parcel, classLoader);
            }

            @Override // android.os.Parcelable.Creator
            public c createFromParcel(Parcel parcel) {
                return new c(parcel, null);
            }
        }

        public c(Parcelable parcelable) {
            super(parcelable);
        }

        @Override // f1.a, android.os.Parcelable
        public void writeToParcel(Parcel parcel, int i10) {
            super.writeToParcel(parcel, i10);
            parcel.writeInt(this.f8895n ? 1 : 0);
        }

        public c(Parcel parcel, ClassLoader classLoader) {
            super(parcel, classLoader);
            if (classLoader == null) {
                c.class.getClassLoader();
            }
            this.f8895n = parcel.readInt() == 1;
        }
    }

    public MaterialButton(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, com.google.android.material.R.attr.materialButtonStyle);
    }

    private Layout.Alignment getActualTextAlignment() {
        int textAlignment = getTextAlignment();
        return textAlignment != 1 ? (textAlignment == 6 || textAlignment == 3) ? Layout.Alignment.ALIGN_OPPOSITE : textAlignment != 4 ? Layout.Alignment.ALIGN_NORMAL : Layout.Alignment.ALIGN_CENTER : getGravityTextAlignment();
    }

    private Layout.Alignment getGravityTextAlignment() {
        int gravity = getGravity() & 8388615;
        return gravity != 1 ? (gravity == 5 || gravity == 8388613) ? Layout.Alignment.ALIGN_OPPOSITE : Layout.Alignment.ALIGN_NORMAL : Layout.Alignment.ALIGN_CENTER;
    }

    private int getTextHeight() {
        if (getLineCount() > 1) {
            return getLayout().getHeight();
        }
        TextPaint paint = getPaint();
        String string = getText().toString();
        if (getTransformationMethod() != null) {
            string = getTransformationMethod().getTransformation(string, this).toString();
        }
        Rect rect = new Rect();
        paint.getTextBounds(string, 0, string.length(), rect);
        return Math.min(rect.height(), getLayout().getHeight());
    }

    private int getTextLayoutWidth() {
        int lineCount = getLineCount();
        float fMax = 0.0f;
        for (int i10 = 0; i10 < lineCount; i10++) {
            fMax = Math.max(fMax, getLayout().getLineWidth(i10));
        }
        return (int) Math.ceil(fMax);
    }

    public final boolean a() {
        u6.a aVar = this.f8883o;
        return (aVar == null || aVar.f20130o) ? false : true;
    }

    public final void b() {
        int i10 = this.B;
        if (i10 == 1 || i10 == 2) {
            i.setCompoundDrawablesRelative(this, this.f8888t, null, null, null);
            return;
        }
        if (i10 == 3 || i10 == 4) {
            i.setCompoundDrawablesRelative(this, null, null, this.f8888t, null);
            return;
        }
        if (i10 == 16 || i10 == 32) {
            i.setCompoundDrawablesRelative(this, null, this.f8888t, null, null);
        }
    }

    public final void c(boolean z10) {
        Drawable drawable = this.f8888t;
        boolean z11 = true;
        if (drawable != null) {
            Drawable drawableMutate = p0.a.wrap(drawable).mutate();
            this.f8888t = drawableMutate;
            p0.a.setTintList(drawableMutate, this.f8887s);
            PorterDuff.Mode mode = this.f8886r;
            if (mode != null) {
                p0.a.setTintMode(this.f8888t, mode);
            }
            int intrinsicWidth = this.f8890v;
            if (intrinsicWidth == 0) {
                intrinsicWidth = this.f8888t.getIntrinsicWidth();
            }
            int intrinsicHeight = this.f8890v;
            if (intrinsicHeight == 0) {
                intrinsicHeight = this.f8888t.getIntrinsicHeight();
            }
            Drawable drawable2 = this.f8888t;
            int i10 = this.f8891w;
            int i11 = this.f8892x;
            drawable2.setBounds(i10, i11, intrinsicWidth + i10, intrinsicHeight + i11);
            this.f8888t.setVisible(true, z10);
        }
        if (z10) {
            b();
            return;
        }
        Drawable[] compoundDrawablesRelative = i.getCompoundDrawablesRelative(this);
        Drawable drawable3 = compoundDrawablesRelative[0];
        Drawable drawable4 = compoundDrawablesRelative[1];
        Drawable drawable5 = compoundDrawablesRelative[2];
        int i12 = this.B;
        if (!(i12 == 1 || i12 == 2) || drawable3 == this.f8888t) {
            if (!(i12 == 3 || i12 == 4) || drawable5 == this.f8888t) {
                if (!(i12 == 16 || i12 == 32) || drawable4 == this.f8888t) {
                    z11 = false;
                }
            }
        }
        if (z11) {
            b();
        }
    }

    public final void d(int i10, int i11) {
        if (this.f8888t == null || getLayout() == null) {
            return;
        }
        int i12 = this.B;
        if (!(i12 == 1 || i12 == 2)) {
            if (!(i12 == 3 || i12 == 4)) {
                if (i12 != 16 && i12 != 32) {
                    z = false;
                }
                if (z) {
                    this.f8891w = 0;
                    if (i12 == 16) {
                        this.f8892x = 0;
                        c(false);
                        return;
                    }
                    int intrinsicHeight = this.f8890v;
                    if (intrinsicHeight == 0) {
                        intrinsicHeight = this.f8888t.getIntrinsicHeight();
                    }
                    int iMax = Math.max(0, (((((i11 - getTextHeight()) - getPaddingTop()) - intrinsicHeight) - this.f8893y) - getPaddingBottom()) / 2);
                    if (this.f8892x != iMax) {
                        this.f8892x = iMax;
                        c(false);
                        return;
                    }
                    return;
                }
                return;
            }
        }
        this.f8892x = 0;
        Layout.Alignment actualTextAlignment = getActualTextAlignment();
        int i13 = this.B;
        if (i13 == 1 || i13 == 3 || ((i13 == 2 && actualTextAlignment == Layout.Alignment.ALIGN_NORMAL) || (i13 == 4 && actualTextAlignment == Layout.Alignment.ALIGN_OPPOSITE))) {
            this.f8891w = 0;
            c(false);
            return;
        }
        int intrinsicWidth = this.f8890v;
        if (intrinsicWidth == 0) {
            intrinsicWidth = this.f8888t.getIntrinsicWidth();
        }
        int textLayoutWidth = ((((i10 - getTextLayoutWidth()) - j0.getPaddingEnd(this)) - intrinsicWidth) - this.f8893y) - j0.getPaddingStart(this);
        if (actualTextAlignment == Layout.Alignment.ALIGN_CENTER) {
            textLayoutWidth /= 2;
        }
        if ((j0.getLayoutDirection(this) == 1) != (this.B == 4)) {
            textLayoutWidth = -textLayoutWidth;
        }
        if (this.f8891w != textLayoutWidth) {
            this.f8891w = textLayoutWidth;
            c(false);
        }
    }

    public String getA11yClassName() {
        if (TextUtils.isEmpty(this.f8889u)) {
            return (isCheckable() ? CompoundButton.class : Button.class).getName();
        }
        return this.f8889u;
    }

    @Override // android.view.View
    public ColorStateList getBackgroundTintList() {
        return getSupportBackgroundTintList();
    }

    @Override // android.view.View
    public PorterDuff.Mode getBackgroundTintMode() {
        return getSupportBackgroundTintMode();
    }

    public int getCornerRadius() {
        if (a()) {
            return this.f8883o.f20122g;
        }
        return 0;
    }

    public Drawable getIcon() {
        return this.f8888t;
    }

    public int getIconGravity() {
        return this.B;
    }

    public int getIconPadding() {
        return this.f8893y;
    }

    public int getIconSize() {
        return this.f8890v;
    }

    public ColorStateList getIconTint() {
        return this.f8887s;
    }

    public PorterDuff.Mode getIconTintMode() {
        return this.f8886r;
    }

    public int getInsetBottom() {
        return this.f8883o.getInsetBottom();
    }

    public int getInsetTop() {
        return this.f8883o.getInsetTop();
    }

    public ColorStateList getRippleColor() {
        if (a()) {
            return this.f8883o.f20127l;
        }
        return null;
    }

    public l getShapeAppearanceModel() {
        if (a()) {
            return this.f8883o.f20117b;
        }
        throw new IllegalStateException("Attempted to get ShapeAppearanceModel from a MaterialButton which has an overwritten background.");
    }

    public ColorStateList getStrokeColor() {
        if (a()) {
            return this.f8883o.f20126k;
        }
        return null;
    }

    public int getStrokeWidth() {
        if (a()) {
            return this.f8883o.f20123h;
        }
        return 0;
    }

    @Override // androidx.appcompat.widget.f
    public ColorStateList getSupportBackgroundTintList() {
        return a() ? this.f8883o.f20125j : super.getSupportBackgroundTintList();
    }

    @Override // androidx.appcompat.widget.f
    public PorterDuff.Mode getSupportBackgroundTintMode() {
        return a() ? this.f8883o.f20124i : super.getSupportBackgroundTintMode();
    }

    public boolean isCheckable() {
        u6.a aVar = this.f8883o;
        return aVar != null && aVar.f20132q;
    }

    @Override // android.widget.Checkable
    public boolean isChecked() {
        return this.f8894z;
    }

    @Override // android.widget.TextView, android.view.View
    public void onAttachedToWindow() {
        super.onAttachedToWindow();
        if (a()) {
            q7.i.setParentAbsoluteElevation(this, this.f8883o.a(false));
        }
    }

    @Override // android.widget.TextView, android.view.View
    public int[] onCreateDrawableState(int i10) {
        int[] iArrOnCreateDrawableState = super.onCreateDrawableState(i10 + 2);
        if (isCheckable()) {
            View.mergeDrawableStates(iArrOnCreateDrawableState, C);
        }
        if (isChecked()) {
            View.mergeDrawableStates(iArrOnCreateDrawableState, D);
        }
        return iArrOnCreateDrawableState;
    }

    @Override // androidx.appcompat.widget.f, android.view.View
    public void onInitializeAccessibilityEvent(AccessibilityEvent accessibilityEvent) {
        super.onInitializeAccessibilityEvent(accessibilityEvent);
        accessibilityEvent.setClassName(getA11yClassName());
        accessibilityEvent.setChecked(isChecked());
    }

    @Override // androidx.appcompat.widget.f, android.view.View
    public void onInitializeAccessibilityNodeInfo(AccessibilityNodeInfo accessibilityNodeInfo) {
        super.onInitializeAccessibilityNodeInfo(accessibilityNodeInfo);
        accessibilityNodeInfo.setClassName(getA11yClassName());
        accessibilityNodeInfo.setCheckable(isCheckable());
        accessibilityNodeInfo.setChecked(isChecked());
        accessibilityNodeInfo.setClickable(isClickable());
    }

    @Override // androidx.appcompat.widget.f, android.widget.TextView, android.view.View
    public void onLayout(boolean z10, int i10, int i11, int i12, int i13) {
        u6.a aVar;
        super.onLayout(z10, i10, i11, i12, i13);
        if (Build.VERSION.SDK_INT == 21 && (aVar = this.f8883o) != null) {
            int i14 = i13 - i11;
            int i15 = i12 - i10;
            Drawable drawable = aVar.f20128m;
            if (drawable != null) {
                drawable.setBounds(aVar.f20118c, aVar.f20120e, i15 - aVar.f20119d, i14 - aVar.f20121f);
            }
        }
        d(getMeasuredWidth(), getMeasuredHeight());
    }

    @Override // android.widget.TextView, android.view.View
    public void onRestoreInstanceState(Parcelable parcelable) {
        if (!(parcelable instanceof c)) {
            super.onRestoreInstanceState(parcelable);
            return;
        }
        c cVar = (c) parcelable;
        super.onRestoreInstanceState(cVar.getSuperState());
        setChecked(cVar.f8895n);
    }

    @Override // android.widget.TextView, android.view.View
    public Parcelable onSaveInstanceState() {
        c cVar = new c(super.onSaveInstanceState());
        cVar.f8895n = this.f8894z;
        return cVar;
    }

    @Override // androidx.appcompat.widget.f, android.widget.TextView
    public void onTextChanged(CharSequence charSequence, int i10, int i11, int i12) {
        super.onTextChanged(charSequence, i10, i11, i12);
        d(getMeasuredWidth(), getMeasuredHeight());
    }

    @Override // android.view.View
    public boolean performClick() {
        if (this.f8883o.f20133r) {
            toggle();
        }
        return super.performClick();
    }

    @Override // android.view.View
    public void refreshDrawableState() {
        super.refreshDrawableState();
        if (this.f8888t != null) {
            if (this.f8888t.setState(getDrawableState())) {
                invalidate();
            }
        }
    }

    public void setA11yClassName(String str) {
        this.f8889u = str;
    }

    @Override // android.view.View
    public void setBackground(Drawable drawable) {
        setBackgroundDrawable(drawable);
    }

    @Override // android.view.View
    public void setBackgroundColor(int i10) {
        if (!a()) {
            super.setBackgroundColor(i10);
            return;
        }
        u6.a aVar = this.f8883o;
        if (aVar.a(false) != null) {
            aVar.a(false).setTint(i10);
        }
    }

    @Override // androidx.appcompat.widget.f, android.view.View
    public void setBackgroundDrawable(Drawable drawable) {
        if (!a()) {
            super.setBackgroundDrawable(drawable);
            return;
        }
        if (drawable == getBackground()) {
            getBackground().setState(drawable.getState());
            return;
        }
        Log.w("MaterialButton", "MaterialButton manages its own background to control elevation, shape, color and states. Consider using backgroundTint, shapeAppearance and other attributes where available. A custom background will ignore these attributes and you should consider handling interaction states such as pressed, focused and disabled");
        u6.a aVar = this.f8883o;
        aVar.f20130o = true;
        ColorStateList colorStateList = aVar.f20125j;
        MaterialButton materialButton = aVar.f20116a;
        materialButton.setSupportBackgroundTintList(colorStateList);
        materialButton.setSupportBackgroundTintMode(aVar.f20124i);
        super.setBackgroundDrawable(drawable);
    }

    @Override // androidx.appcompat.widget.f, android.view.View
    public void setBackgroundResource(int i10) {
        setBackgroundDrawable(i10 != 0 ? s.a.getDrawable(getContext(), i10) : null);
    }

    @Override // android.view.View
    public void setBackgroundTintList(ColorStateList colorStateList) {
        setSupportBackgroundTintList(colorStateList);
    }

    @Override // android.view.View
    public void setBackgroundTintMode(PorterDuff.Mode mode) {
        setSupportBackgroundTintMode(mode);
    }

    public void setCheckable(boolean z10) {
        if (a()) {
            this.f8883o.f20132q = z10;
        }
    }

    @Override // android.widget.Checkable
    public void setChecked(boolean z10) {
        if (isCheckable() && isEnabled() && this.f8894z != z10) {
            this.f8894z = z10;
            refreshDrawableState();
            if (getParent() instanceof MaterialButtonToggleGroup) {
                MaterialButtonToggleGroup materialButtonToggleGroup = (MaterialButtonToggleGroup) getParent();
                boolean z11 = this.f8894z;
                if (!materialButtonToggleGroup.f8902q) {
                    materialButtonToggleGroup.b(getId(), z11);
                }
            }
            if (this.A) {
                return;
            }
            this.A = true;
            Iterator<a> it = this.f8884p.iterator();
            while (it.hasNext()) {
                it.next().onCheckedChanged(this, this.f8894z);
            }
            this.A = false;
        }
    }

    public void setCornerRadius(int i10) {
        if (a()) {
            u6.a aVar = this.f8883o;
            if (aVar.f20131p && aVar.f20122g == i10) {
                return;
            }
            aVar.f20122g = i10;
            aVar.f20131p = true;
            aVar.b(aVar.f20117b.withCornerSize(i10));
        }
    }

    public void setCornerRadiusResource(int i10) {
        if (a()) {
            setCornerRadius(getResources().getDimensionPixelSize(i10));
        }
    }

    @Override // android.view.View
    public void setElevation(float f10) {
        super.setElevation(f10);
        if (a()) {
            this.f8883o.a(false).setElevation(f10);
        }
    }

    public void setIcon(Drawable drawable) {
        if (this.f8888t != drawable) {
            this.f8888t = drawable;
            c(true);
            d(getMeasuredWidth(), getMeasuredHeight());
        }
    }

    public void setIconGravity(int i10) {
        if (this.B != i10) {
            this.B = i10;
            d(getMeasuredWidth(), getMeasuredHeight());
        }
    }

    public void setIconPadding(int i10) {
        if (this.f8893y != i10) {
            this.f8893y = i10;
            setCompoundDrawablePadding(i10);
        }
    }

    public void setIconResource(int i10) {
        setIcon(i10 != 0 ? s.a.getDrawable(getContext(), i10) : null);
    }

    public void setIconSize(int i10) {
        if (i10 < 0) {
            throw new IllegalArgumentException("iconSize cannot be less than 0");
        }
        if (this.f8890v != i10) {
            this.f8890v = i10;
            c(true);
        }
    }

    public void setIconTint(ColorStateList colorStateList) {
        if (this.f8887s != colorStateList) {
            this.f8887s = colorStateList;
            c(false);
        }
    }

    public void setIconTintMode(PorterDuff.Mode mode) {
        if (this.f8886r != mode) {
            this.f8886r = mode;
            c(false);
        }
    }

    public void setIconTintResource(int i10) {
        setIconTint(s.a.getColorStateList(getContext(), i10));
    }

    public void setInsetBottom(int i10) {
        this.f8883o.setInsetBottom(i10);
    }

    public void setInsetTop(int i10) {
        this.f8883o.setInsetTop(i10);
    }

    public void setInternalBackground(Drawable drawable) {
        super.setBackgroundDrawable(drawable);
    }

    public void setOnPressedChangeListenerInternal(b bVar) {
        this.f8885q = bVar;
    }

    @Override // android.view.View
    public void setPressed(boolean z10) {
        b bVar = this.f8885q;
        if (bVar != null) {
            ((MaterialButtonToggleGroup.e) bVar).onPressedChanged(this, z10);
        }
        super.setPressed(z10);
    }

    public void setRippleColor(ColorStateList colorStateList) {
        if (a()) {
            u6.a aVar = this.f8883o;
            if (aVar.f20127l != colorStateList) {
                aVar.f20127l = colorStateList;
                boolean z10 = u6.a.f20114u;
                MaterialButton materialButton = aVar.f20116a;
                if (z10 && (materialButton.getBackground() instanceof RippleDrawable)) {
                    ((RippleDrawable) materialButton.getBackground()).setColor(o7.b.sanitizeRippleDrawableColor(colorStateList));
                } else {
                    if (z10 || !(materialButton.getBackground() instanceof o7.a)) {
                        return;
                    }
                    ((o7.a) materialButton.getBackground()).setTintList(o7.b.sanitizeRippleDrawableColor(colorStateList));
                }
            }
        }
    }

    public void setRippleColorResource(int i10) {
        if (a()) {
            setRippleColor(s.a.getColorStateList(getContext(), i10));
        }
    }

    @Override // q7.p
    public void setShapeAppearanceModel(l lVar) {
        if (!a()) {
            throw new IllegalStateException("Attempted to set ShapeAppearanceModel on a MaterialButton which has an overwritten background.");
        }
        this.f8883o.b(lVar);
    }

    public void setShouldDrawSurfaceColorStroke(boolean z10) {
        if (a()) {
            u6.a aVar = this.f8883o;
            aVar.f20129n = z10;
            aVar.e();
        }
    }

    public void setStrokeColor(ColorStateList colorStateList) {
        if (a()) {
            u6.a aVar = this.f8883o;
            if (aVar.f20126k != colorStateList) {
                aVar.f20126k = colorStateList;
                aVar.e();
            }
        }
    }

    public void setStrokeColorResource(int i10) {
        if (a()) {
            setStrokeColor(s.a.getColorStateList(getContext(), i10));
        }
    }

    public void setStrokeWidth(int i10) {
        if (a()) {
            u6.a aVar = this.f8883o;
            if (aVar.f20123h != i10) {
                aVar.f20123h = i10;
                aVar.e();
            }
        }
    }

    public void setStrokeWidthResource(int i10) {
        if (a()) {
            setStrokeWidth(getResources().getDimensionPixelSize(i10));
        }
    }

    @Override // androidx.appcompat.widget.f
    public void setSupportBackgroundTintList(ColorStateList colorStateList) {
        if (!a()) {
            super.setSupportBackgroundTintList(colorStateList);
            return;
        }
        u6.a aVar = this.f8883o;
        if (aVar.f20125j != colorStateList) {
            aVar.f20125j = colorStateList;
            if (aVar.a(false) != null) {
                p0.a.setTintList(aVar.a(false), aVar.f20125j);
            }
        }
    }

    @Override // androidx.appcompat.widget.f
    public void setSupportBackgroundTintMode(PorterDuff.Mode mode) {
        if (!a()) {
            super.setSupportBackgroundTintMode(mode);
            return;
        }
        u6.a aVar = this.f8883o;
        if (aVar.f20124i != mode) {
            aVar.f20124i = mode;
            if (aVar.a(false) == null || aVar.f20124i == null) {
                return;
            }
            p0.a.setTintMode(aVar.a(false), aVar.f20124i);
        }
    }

    @Override // android.view.View
    public void setTextAlignment(int i10) {
        super.setTextAlignment(i10);
        d(getMeasuredWidth(), getMeasuredHeight());
    }

    public void setToggleCheckedStateOnClick(boolean z10) {
        this.f8883o.f20133r = z10;
    }

    @Override // android.widget.Checkable
    public void toggle() {
        setChecked(!this.f8894z);
    }

    /* JADX WARN: Illegal instructions before constructor call */
    public MaterialButton(Context context, AttributeSet attributeSet, int i10) {
        int i11 = E;
        super(x7.a.wrap(context, attributeSet, i10, i11), attributeSet, i10);
        this.f8884p = new LinkedHashSet<>();
        this.f8894z = false;
        this.A = false;
        Context context2 = getContext();
        TypedArray typedArrayObtainStyledAttributes = r.obtainStyledAttributes(context2, attributeSet, com.google.android.material.R.styleable.MaterialButton, i10, i11, new int[0]);
        this.f8893y = typedArrayObtainStyledAttributes.getDimensionPixelSize(com.google.android.material.R.styleable.MaterialButton_iconPadding, 0);
        this.f8886r = t.parseTintMode(typedArrayObtainStyledAttributes.getInt(com.google.android.material.R.styleable.MaterialButton_iconTintMode, -1), PorterDuff.Mode.SRC_IN);
        this.f8887s = n7.c.getColorStateList(getContext(), typedArrayObtainStyledAttributes, com.google.android.material.R.styleable.MaterialButton_iconTint);
        this.f8888t = n7.c.getDrawable(getContext(), typedArrayObtainStyledAttributes, com.google.android.material.R.styleable.MaterialButton_icon);
        this.B = typedArrayObtainStyledAttributes.getInteger(com.google.android.material.R.styleable.MaterialButton_iconGravity, 1);
        this.f8890v = typedArrayObtainStyledAttributes.getDimensionPixelSize(com.google.android.material.R.styleable.MaterialButton_iconSize, 0);
        u6.a aVar = new u6.a(this, l.builder(context2, attributeSet, i10, i11).build());
        this.f8883o = aVar;
        aVar.f20118c = typedArrayObtainStyledAttributes.getDimensionPixelOffset(com.google.android.material.R.styleable.MaterialButton_android_insetLeft, 0);
        aVar.f20119d = typedArrayObtainStyledAttributes.getDimensionPixelOffset(com.google.android.material.R.styleable.MaterialButton_android_insetRight, 0);
        aVar.f20120e = typedArrayObtainStyledAttributes.getDimensionPixelOffset(com.google.android.material.R.styleable.MaterialButton_android_insetTop, 0);
        aVar.f20121f = typedArrayObtainStyledAttributes.getDimensionPixelOffset(com.google.android.material.R.styleable.MaterialButton_android_insetBottom, 0);
        int i12 = com.google.android.material.R.styleable.MaterialButton_cornerRadius;
        if (typedArrayObtainStyledAttributes.hasValue(i12)) {
            int dimensionPixelSize = typedArrayObtainStyledAttributes.getDimensionPixelSize(i12, -1);
            aVar.f20122g = dimensionPixelSize;
            aVar.b(aVar.f20117b.withCornerSize(dimensionPixelSize));
            aVar.f20131p = true;
        }
        aVar.f20123h = typedArrayObtainStyledAttributes.getDimensionPixelSize(com.google.android.material.R.styleable.MaterialButton_strokeWidth, 0);
        aVar.f20124i = t.parseTintMode(typedArrayObtainStyledAttributes.getInt(com.google.android.material.R.styleable.MaterialButton_backgroundTintMode, -1), PorterDuff.Mode.SRC_IN);
        aVar.f20125j = n7.c.getColorStateList(getContext(), typedArrayObtainStyledAttributes, com.google.android.material.R.styleable.MaterialButton_backgroundTint);
        aVar.f20126k = n7.c.getColorStateList(getContext(), typedArrayObtainStyledAttributes, com.google.android.material.R.styleable.MaterialButton_strokeColor);
        aVar.f20127l = n7.c.getColorStateList(getContext(), typedArrayObtainStyledAttributes, com.google.android.material.R.styleable.MaterialButton_rippleColor);
        aVar.f20132q = typedArrayObtainStyledAttributes.getBoolean(com.google.android.material.R.styleable.MaterialButton_android_checkable, false);
        aVar.f20135t = typedArrayObtainStyledAttributes.getDimensionPixelSize(com.google.android.material.R.styleable.MaterialButton_elevation, 0);
        aVar.f20133r = typedArrayObtainStyledAttributes.getBoolean(com.google.android.material.R.styleable.MaterialButton_toggleCheckedStateOnClick, true);
        int paddingStart = j0.getPaddingStart(this);
        int paddingTop = getPaddingTop();
        int paddingEnd = j0.getPaddingEnd(this);
        int paddingBottom = getPaddingBottom();
        if (typedArrayObtainStyledAttributes.hasValue(com.google.android.material.R.styleable.MaterialButton_android_background)) {
            aVar.f20130o = true;
            setSupportBackgroundTintList(aVar.f20125j);
            setSupportBackgroundTintMode(aVar.f20124i);
        } else {
            aVar.d();
        }
        j0.setPaddingRelative(this, paddingStart + aVar.f20118c, paddingTop + aVar.f20120e, paddingEnd + aVar.f20119d, paddingBottom + aVar.f20121f);
        typedArrayObtainStyledAttributes.recycle();
        setCompoundDrawablePadding(this.f8893y);
        c(this.f8888t != null);
    }
}
