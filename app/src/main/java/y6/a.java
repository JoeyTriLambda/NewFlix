package y6;

import android.annotation.SuppressLint;
import android.content.Context;
import android.content.res.ColorStateList;
import android.content.res.Resources;
import android.graphics.Canvas;
import android.graphics.PorterDuff;
import android.graphics.Rect;
import android.graphics.drawable.AnimatedStateListDrawable;
import android.graphics.drawable.Drawable;
import android.os.Build;
import android.os.Parcel;
import android.os.Parcelable;
import android.text.TextUtils;
import android.util.AttributeSet;
import android.view.View;
import android.view.accessibility.AccessibilityNodeInfo;
import android.view.autofill.AutofillManager;
import android.widget.CompoundButton;
import androidx.appcompat.widget.c1;
import androidx.appcompat.widget.g;
import com.google.android.material.R;
import com.unity3d.services.core.request.metrics.MetricCommonTags;
import i7.r;
import i7.t;
import java.util.Iterator;
import java.util.LinkedHashSet;

/* compiled from: MaterialCheckBox.java */
/* loaded from: classes.dex */
public final class a extends g {
    public static final int J = R.style.Widget_MaterialComponents_CompoundButton_CheckBox;
    public static final int[] K = {R.attr.state_indeterminate};
    public static final int[] L;
    public static final int[][] M;

    @SuppressLint({"DiscouragedApi"})
    public static final int N;
    public ColorStateList A;
    public PorterDuff.Mode B;
    public int C;
    public int[] D;
    public boolean E;
    public CharSequence F;
    public CompoundButton.OnCheckedChangeListener G;
    public final r2.d H;
    public final C0320a I;

    /* renamed from: p, reason: collision with root package name */
    public final LinkedHashSet<c> f22005p;

    /* renamed from: q, reason: collision with root package name */
    public final LinkedHashSet<b> f22006q;

    /* renamed from: r, reason: collision with root package name */
    public ColorStateList f22007r;

    /* renamed from: s, reason: collision with root package name */
    public boolean f22008s;

    /* renamed from: t, reason: collision with root package name */
    public boolean f22009t;

    /* renamed from: u, reason: collision with root package name */
    public boolean f22010u;

    /* renamed from: v, reason: collision with root package name */
    public CharSequence f22011v;

    /* renamed from: w, reason: collision with root package name */
    public Drawable f22012w;

    /* renamed from: x, reason: collision with root package name */
    public Drawable f22013x;

    /* renamed from: y, reason: collision with root package name */
    public boolean f22014y;

    /* renamed from: z, reason: collision with root package name */
    public ColorStateList f22015z;

    /* compiled from: MaterialCheckBox.java */
    /* renamed from: y6.a$a, reason: collision with other inner class name */
    public class C0320a extends r2.c {
        public C0320a() {
        }

        @Override // r2.c
        public void onAnimationEnd(Drawable drawable) {
            super.onAnimationEnd(drawable);
            ColorStateList colorStateList = a.this.f22015z;
            if (colorStateList != null) {
                p0.a.setTintList(drawable, colorStateList);
            }
        }

        @Override // r2.c
        public void onAnimationStart(Drawable drawable) {
            super.onAnimationStart(drawable);
            a aVar = a.this;
            ColorStateList colorStateList = aVar.f22015z;
            if (colorStateList != null) {
                p0.a.setTint(drawable, colorStateList.getColorForState(aVar.D, colorStateList.getDefaultColor()));
            }
        }
    }

    /* compiled from: MaterialCheckBox.java */
    public interface b {
        void onCheckedStateChangedListener(a aVar, int i10);
    }

    /* compiled from: MaterialCheckBox.java */
    public interface c {
        void onErrorChanged(a aVar, boolean z10);
    }

    /* compiled from: MaterialCheckBox.java */
    public static class d extends View.BaseSavedState {
        public static final Parcelable.Creator<d> CREATOR = new C0321a();

        /* renamed from: b, reason: collision with root package name */
        public int f22017b;

        /* compiled from: MaterialCheckBox.java */
        /* renamed from: y6.a$d$a, reason: collision with other inner class name */
        public class C0321a implements Parcelable.Creator<d> {
            @Override // android.os.Parcelable.Creator
            public d createFromParcel(Parcel parcel) {
                return new d(parcel);
            }

            @Override // android.os.Parcelable.Creator
            public d[] newArray(int i10) {
                return new d[i10];
            }
        }

        public d(Parcelable parcelable) {
            super(parcelable);
        }

        public String toString() {
            StringBuilder sb2 = new StringBuilder("MaterialCheckBox.SavedState{");
            sb2.append(Integer.toHexString(System.identityHashCode(this)));
            sb2.append(" CheckedState=");
            int i10 = this.f22017b;
            return ac.c.o(sb2, i10 != 1 ? i10 != 2 ? "unchecked" : "indeterminate" : "checked", "}");
        }

        @Override // android.view.View.BaseSavedState, android.view.AbsSavedState, android.os.Parcelable
        public void writeToParcel(Parcel parcel, int i10) {
            super.writeToParcel(parcel, i10);
            parcel.writeValue(Integer.valueOf(this.f22017b));
        }

        public d(Parcel parcel) {
            super(parcel);
            this.f22017b = ((Integer) parcel.readValue(d.class.getClassLoader())).intValue();
        }
    }

    static {
        int i10 = R.attr.state_error;
        L = new int[]{i10};
        M = new int[][]{new int[]{android.R.attr.state_enabled, i10}, new int[]{android.R.attr.state_enabled, android.R.attr.state_checked}, new int[]{android.R.attr.state_enabled, -16842912}, new int[]{-16842910, android.R.attr.state_checked}, new int[]{-16842910, -16842912}};
        N = Resources.getSystem().getIdentifier("btn_check_material_anim", "drawable", MetricCommonTags.METRIC_COMMON_TAG_PLATFORM_ANDROID);
    }

    public a(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, R.attr.checkboxStyle);
    }

    private String getButtonStateDescription() {
        int i10 = this.C;
        return i10 == 1 ? getResources().getString(R.string.mtrl_checkbox_state_description_checked) : i10 == 0 ? getResources().getString(R.string.mtrl_checkbox_state_description_unchecked) : getResources().getString(R.string.mtrl_checkbox_state_description_indeterminate);
    }

    private ColorStateList getMaterialThemeColorsTintList() {
        if (this.f22007r == null) {
            int color = c7.a.getColor(this, R.attr.colorControlActivated);
            int color2 = c7.a.getColor(this, R.attr.colorError);
            int color3 = c7.a.getColor(this, R.attr.colorSurface);
            int color4 = c7.a.getColor(this, R.attr.colorOnSurface);
            this.f22007r = new ColorStateList(M, new int[]{c7.a.layer(color3, color2, 1.0f), c7.a.layer(color3, color, 1.0f), c7.a.layer(color3, color4, 0.54f), c7.a.layer(color3, color4, 0.38f), c7.a.layer(color3, color4, 0.38f)});
        }
        return this.f22007r;
    }

    private ColorStateList getSuperButtonTintList() {
        ColorStateList colorStateList = this.f22015z;
        return colorStateList != null ? colorStateList : super.getButtonTintList() != null ? super.getButtonTintList() : getSupportButtonTintList();
    }

    public final void a() throws NoSuchFieldException, SecurityException {
        ColorStateList colorStateList;
        ColorStateList colorStateList2;
        this.f22012w = e7.a.createTintableMutatedDrawableIfNeeded(this.f22012w, this.f22015z, d1.c.getButtonTintMode(this));
        this.f22013x = e7.a.createTintableMutatedDrawableIfNeeded(this.f22013x, this.A, this.B);
        if (this.f22014y) {
            r2.d dVar = this.H;
            if (dVar != null) {
                C0320a c0320a = this.I;
                dVar.unregisterAnimationCallback(c0320a);
                dVar.registerAnimationCallback(c0320a);
            }
            if (Build.VERSION.SDK_INT >= 24) {
                Drawable drawable = this.f22012w;
                if ((drawable instanceof AnimatedStateListDrawable) && dVar != null) {
                    int i10 = R.id.checked;
                    int i11 = R.id.unchecked;
                    ((AnimatedStateListDrawable) drawable).addTransition(i10, i11, dVar, false);
                    ((AnimatedStateListDrawable) this.f22012w).addTransition(R.id.indeterminate, i11, dVar, false);
                }
            }
        }
        Drawable drawable2 = this.f22012w;
        if (drawable2 != null && (colorStateList2 = this.f22015z) != null) {
            p0.a.setTintList(drawable2, colorStateList2);
        }
        Drawable drawable3 = this.f22013x;
        if (drawable3 != null && (colorStateList = this.A) != null) {
            p0.a.setTintList(drawable3, colorStateList);
        }
        super.setButtonDrawable(e7.a.compositeTwoLayeredDrawable(this.f22012w, this.f22013x));
        refreshDrawableState();
    }

    @Override // android.widget.CompoundButton
    public Drawable getButtonDrawable() {
        return this.f22012w;
    }

    public Drawable getButtonIconDrawable() {
        return this.f22013x;
    }

    public ColorStateList getButtonIconTintList() {
        return this.A;
    }

    public PorterDuff.Mode getButtonIconTintMode() {
        return this.B;
    }

    @Override // android.widget.CompoundButton
    public ColorStateList getButtonTintList() {
        return this.f22015z;
    }

    public int getCheckedState() {
        return this.C;
    }

    public CharSequence getErrorAccessibilityLabel() {
        return this.f22011v;
    }

    @Override // android.widget.CompoundButton, android.widget.Checkable
    public boolean isChecked() {
        return this.C == 1;
    }

    public boolean isErrorShown() {
        return this.f22010u;
    }

    @Override // android.widget.TextView, android.view.View
    public void onAttachedToWindow() {
        super.onAttachedToWindow();
        if (this.f22008s && this.f22015z == null && this.A == null) {
            setUseMaterialThemeColors(true);
        }
    }

    @Override // android.widget.CompoundButton, android.widget.TextView, android.view.View
    public int[] onCreateDrawableState(int i10) {
        int[] iArrOnCreateDrawableState = super.onCreateDrawableState(i10 + 2);
        if (getCheckedState() == 2) {
            View.mergeDrawableStates(iArrOnCreateDrawableState, K);
        }
        if (isErrorShown()) {
            View.mergeDrawableStates(iArrOnCreateDrawableState, L);
        }
        this.D = e7.a.getCheckedState(iArrOnCreateDrawableState);
        return iArrOnCreateDrawableState;
    }

    @Override // android.widget.CompoundButton, android.widget.TextView, android.view.View
    public void onDraw(Canvas canvas) {
        Drawable buttonDrawable;
        if (!this.f22009t || !TextUtils.isEmpty(getText()) || (buttonDrawable = d1.c.getButtonDrawable(this)) == null) {
            super.onDraw(canvas);
            return;
        }
        int width = ((getWidth() - buttonDrawable.getIntrinsicWidth()) / 2) * (t.isLayoutRtl(this) ? -1 : 1);
        int iSave = canvas.save();
        canvas.translate(width, 0.0f);
        super.onDraw(canvas);
        canvas.restoreToCount(iSave);
        if (getBackground() != null) {
            Rect bounds = buttonDrawable.getBounds();
            p0.a.setHotspotBounds(getBackground(), bounds.left + width, bounds.top, bounds.right + width, bounds.bottom);
        }
    }

    @Override // android.view.View
    public void onInitializeAccessibilityNodeInfo(AccessibilityNodeInfo accessibilityNodeInfo) {
        super.onInitializeAccessibilityNodeInfo(accessibilityNodeInfo);
        if (accessibilityNodeInfo != null && isErrorShown()) {
            accessibilityNodeInfo.setText(((Object) accessibilityNodeInfo.getText()) + ", " + ((Object) this.f22011v));
        }
    }

    @Override // android.widget.CompoundButton, android.widget.TextView, android.view.View
    public void onRestoreInstanceState(Parcelable parcelable) {
        if (!(parcelable instanceof d)) {
            super.onRestoreInstanceState(parcelable);
            return;
        }
        d dVar = (d) parcelable;
        super.onRestoreInstanceState(dVar.getSuperState());
        setCheckedState(dVar.f22017b);
    }

    @Override // android.widget.CompoundButton, android.widget.TextView, android.view.View
    public Parcelable onSaveInstanceState() {
        d dVar = new d(super.onSaveInstanceState());
        dVar.f22017b = getCheckedState();
        return dVar;
    }

    @Override // androidx.appcompat.widget.g, android.widget.CompoundButton
    public void setButtonDrawable(int i10) throws NoSuchFieldException, SecurityException {
        setButtonDrawable(s.a.getDrawable(getContext(), i10));
    }

    public void setButtonIconDrawable(Drawable drawable) throws NoSuchFieldException, SecurityException {
        this.f22013x = drawable;
        a();
    }

    public void setButtonIconDrawableResource(int i10) throws NoSuchFieldException, SecurityException {
        setButtonIconDrawable(s.a.getDrawable(getContext(), i10));
    }

    public void setButtonIconTintList(ColorStateList colorStateList) throws NoSuchFieldException, SecurityException {
        if (this.A == colorStateList) {
            return;
        }
        this.A = colorStateList;
        a();
    }

    public void setButtonIconTintMode(PorterDuff.Mode mode) throws NoSuchFieldException, SecurityException {
        if (this.B == mode) {
            return;
        }
        this.B = mode;
        a();
    }

    @Override // android.widget.CompoundButton
    public void setButtonTintList(ColorStateList colorStateList) throws NoSuchFieldException, SecurityException {
        if (this.f22015z == colorStateList) {
            return;
        }
        this.f22015z = colorStateList;
        a();
    }

    @Override // android.widget.CompoundButton
    public void setButtonTintMode(PorterDuff.Mode mode) throws NoSuchFieldException, SecurityException {
        setSupportButtonTintMode(mode);
        a();
    }

    public void setCenterIfNoTextEnabled(boolean z10) {
        this.f22009t = z10;
    }

    @Override // android.widget.CompoundButton, android.widget.Checkable
    public void setChecked(boolean z10) {
        setCheckedState(z10 ? 1 : 0);
    }

    public void setCheckedState(int i10) {
        AutofillManager autofillManager;
        CompoundButton.OnCheckedChangeListener onCheckedChangeListener;
        if (this.C != i10) {
            this.C = i10;
            super.setChecked(i10 == 1);
            refreshDrawableState();
            if (Build.VERSION.SDK_INT >= 30 && this.F == null) {
                super.setStateDescription(getButtonStateDescription());
            }
            if (this.E) {
                return;
            }
            this.E = true;
            LinkedHashSet<b> linkedHashSet = this.f22006q;
            if (linkedHashSet != null) {
                Iterator<b> it = linkedHashSet.iterator();
                while (it.hasNext()) {
                    it.next().onCheckedStateChangedListener(this, this.C);
                }
            }
            if (this.C != 2 && (onCheckedChangeListener = this.G) != null) {
                onCheckedChangeListener.onCheckedChanged(this, isChecked());
            }
            if (Build.VERSION.SDK_INT >= 26 && (autofillManager = (AutofillManager) getContext().getSystemService(AutofillManager.class)) != null) {
                autofillManager.notifyValueChanged(this);
            }
            this.E = false;
        }
    }

    @Override // android.widget.TextView, android.view.View
    public void setEnabled(boolean z10) {
        super.setEnabled(z10);
    }

    public void setErrorAccessibilityLabel(CharSequence charSequence) {
        this.f22011v = charSequence;
    }

    public void setErrorAccessibilityLabelResource(int i10) {
        setErrorAccessibilityLabel(i10 != 0 ? getResources().getText(i10) : null);
    }

    public void setErrorShown(boolean z10) {
        if (this.f22010u == z10) {
            return;
        }
        this.f22010u = z10;
        refreshDrawableState();
        Iterator<c> it = this.f22005p.iterator();
        while (it.hasNext()) {
            it.next().onErrorChanged(this, this.f22010u);
        }
    }

    @Override // android.widget.CompoundButton
    public void setOnCheckedChangeListener(CompoundButton.OnCheckedChangeListener onCheckedChangeListener) {
        this.G = onCheckedChangeListener;
    }

    @Override // android.widget.CompoundButton, android.view.View
    public void setStateDescription(CharSequence charSequence) {
        this.F = charSequence;
        if (charSequence != null) {
            super.setStateDescription(charSequence);
        } else {
            if (Build.VERSION.SDK_INT < 30 || charSequence != null) {
                return;
            }
            super.setStateDescription(getButtonStateDescription());
        }
    }

    public void setUseMaterialThemeColors(boolean z10) {
        this.f22008s = z10;
        if (z10) {
            d1.c.setButtonTintList(this, getMaterialThemeColorsTintList());
        } else {
            d1.c.setButtonTintList(this, null);
        }
    }

    @Override // android.widget.CompoundButton, android.widget.Checkable
    public void toggle() {
        setChecked(!isChecked());
    }

    /* JADX WARN: Illegal instructions before constructor call */
    public a(Context context, AttributeSet attributeSet, int i10) throws NoSuchFieldException, SecurityException {
        int i11 = J;
        super(x7.a.wrap(context, attributeSet, i10, i11), attributeSet, i10);
        this.f22005p = new LinkedHashSet<>();
        this.f22006q = new LinkedHashSet<>();
        this.H = r2.d.create(getContext(), R.drawable.mtrl_checkbox_button_checked_unchecked);
        this.I = new C0320a();
        Context context2 = getContext();
        this.f22012w = d1.c.getButtonDrawable(this);
        this.f22015z = getSuperButtonTintList();
        setSupportButtonTintList(null);
        c1 c1VarObtainTintedStyledAttributes = r.obtainTintedStyledAttributes(context2, attributeSet, R.styleable.MaterialCheckBox, i10, i11, new int[0]);
        this.f22013x = c1VarObtainTintedStyledAttributes.getDrawable(R.styleable.MaterialCheckBox_buttonIcon);
        if (this.f22012w != null && r.isMaterial3Theme(context2)) {
            if (c1VarObtainTintedStyledAttributes.getResourceId(R.styleable.MaterialCheckBox_android_button, 0) == N && c1VarObtainTintedStyledAttributes.getResourceId(R.styleable.MaterialCheckBox_buttonCompat, 0) == 0) {
                super.setButtonDrawable((Drawable) null);
                this.f22012w = s.a.getDrawable(context2, R.drawable.mtrl_checkbox_button);
                this.f22014y = true;
                if (this.f22013x == null) {
                    this.f22013x = s.a.getDrawable(context2, R.drawable.mtrl_checkbox_button_icon);
                }
            }
        }
        this.A = n7.c.getColorStateList(context2, c1VarObtainTintedStyledAttributes, R.styleable.MaterialCheckBox_buttonIconTint);
        this.B = t.parseTintMode(c1VarObtainTintedStyledAttributes.getInt(R.styleable.MaterialCheckBox_buttonIconTintMode, -1), PorterDuff.Mode.SRC_IN);
        this.f22008s = c1VarObtainTintedStyledAttributes.getBoolean(R.styleable.MaterialCheckBox_useMaterialThemeColors, false);
        this.f22009t = c1VarObtainTintedStyledAttributes.getBoolean(R.styleable.MaterialCheckBox_centerIfNoTextEnabled, true);
        this.f22010u = c1VarObtainTintedStyledAttributes.getBoolean(R.styleable.MaterialCheckBox_errorShown, false);
        this.f22011v = c1VarObtainTintedStyledAttributes.getText(R.styleable.MaterialCheckBox_errorAccessibilityLabel);
        int i12 = R.styleable.MaterialCheckBox_checkedState;
        if (c1VarObtainTintedStyledAttributes.hasValue(i12)) {
            setCheckedState(c1VarObtainTintedStyledAttributes.getInt(i12, 0));
        }
        c1VarObtainTintedStyledAttributes.recycle();
        a();
    }

    @Override // androidx.appcompat.widget.g, android.widget.CompoundButton
    public void setButtonDrawable(Drawable drawable) throws NoSuchFieldException, SecurityException {
        this.f22012w = drawable;
        this.f22014y = false;
        a();
    }
}
