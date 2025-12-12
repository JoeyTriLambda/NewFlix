package com.google.android.material.textfield;

import android.annotation.SuppressLint;
import android.content.res.ColorStateList;
import android.graphics.PorterDuff;
import android.graphics.drawable.Drawable;
import android.os.Build;
import android.text.Editable;
import android.text.TextUtils;
import android.util.SparseArray;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.accessibility.AccessibilityManager;
import android.widget.EditText;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.LinearLayout;
import androidx.appcompat.widget.AppCompatTextView;
import androidx.appcompat.widget.c1;
import com.google.android.material.R;
import com.google.android.material.internal.CheckableImageButton;
import com.google.android.material.textfield.TextInputLayout;
import d1.i;
import i7.q;
import i7.t;
import java.util.Iterator;
import java.util.LinkedHashSet;
import v7.e;
import v7.f;
import v7.l;
import v7.m;
import v7.r;
import x0.j0;
import x0.k;
import y0.c;

/* compiled from: EndCompoundLayout.java */
@SuppressLint({"ViewConstructor"})
/* loaded from: classes.dex */
public final class a extends LinearLayout {
    public CharSequence A;
    public final AppCompatTextView B;
    public boolean C;
    public EditText D;
    public final AccessibilityManager E;
    public c.a F;
    public final C0091a G;

    /* renamed from: b, reason: collision with root package name */
    public final TextInputLayout f9456b;

    /* renamed from: m, reason: collision with root package name */
    public final FrameLayout f9457m;

    /* renamed from: n, reason: collision with root package name */
    public final CheckableImageButton f9458n;

    /* renamed from: o, reason: collision with root package name */
    public ColorStateList f9459o;

    /* renamed from: p, reason: collision with root package name */
    public PorterDuff.Mode f9460p;

    /* renamed from: q, reason: collision with root package name */
    public View.OnLongClickListener f9461q;

    /* renamed from: r, reason: collision with root package name */
    public final CheckableImageButton f9462r;

    /* renamed from: s, reason: collision with root package name */
    public final d f9463s;

    /* renamed from: t, reason: collision with root package name */
    public int f9464t;

    /* renamed from: u, reason: collision with root package name */
    public final LinkedHashSet<TextInputLayout.g> f9465u;

    /* renamed from: v, reason: collision with root package name */
    public ColorStateList f9466v;

    /* renamed from: w, reason: collision with root package name */
    public PorterDuff.Mode f9467w;

    /* renamed from: x, reason: collision with root package name */
    public int f9468x;

    /* renamed from: y, reason: collision with root package name */
    public ImageView.ScaleType f9469y;

    /* renamed from: z, reason: collision with root package name */
    public View.OnLongClickListener f9470z;

    /* compiled from: EndCompoundLayout.java */
    /* renamed from: com.google.android.material.textfield.a$a, reason: collision with other inner class name */
    public class C0091a extends q {
        public C0091a() {
        }

        @Override // android.text.TextWatcher
        public void afterTextChanged(Editable editable) {
            a.this.b().afterEditTextChanged(editable);
        }

        @Override // i7.q, android.text.TextWatcher
        public void beforeTextChanged(CharSequence charSequence, int i10, int i11, int i12) {
            a.this.b().a();
        }
    }

    /* compiled from: EndCompoundLayout.java */
    public class b implements TextInputLayout.f {
        public b() {
        }

        @Override // com.google.android.material.textfield.TextInputLayout.f
        public void onEditTextAttached(TextInputLayout textInputLayout) {
            a aVar = a.this;
            if (aVar.D == textInputLayout.getEditText()) {
                return;
            }
            EditText editText = aVar.D;
            C0091a c0091a = aVar.G;
            if (editText != null) {
                editText.removeTextChangedListener(c0091a);
                if (aVar.D.getOnFocusChangeListener() == aVar.b().d()) {
                    aVar.D.setOnFocusChangeListener(null);
                }
            }
            EditText editText2 = textInputLayout.getEditText();
            aVar.D = editText2;
            if (editText2 != null) {
                editText2.addTextChangedListener(c0091a);
            }
            aVar.b().onEditTextAttached(aVar.D);
            aVar.j(aVar.b());
        }
    }

    /* compiled from: EndCompoundLayout.java */
    public class c implements View.OnAttachStateChangeListener {
        public c() {
        }

        @Override // android.view.View.OnAttachStateChangeListener
        public void onViewAttachedToWindow(View view) {
            AccessibilityManager accessibilityManager;
            a aVar = a.this;
            if (aVar.F == null || (accessibilityManager = aVar.E) == null || !j0.isAttachedToWindow(aVar)) {
                return;
            }
            y0.c.addTouchExplorationStateChangeListener(accessibilityManager, aVar.F);
        }

        @Override // android.view.View.OnAttachStateChangeListener
        public void onViewDetachedFromWindow(View view) {
            AccessibilityManager accessibilityManager;
            a aVar = a.this;
            c.a aVar2 = aVar.F;
            if (aVar2 == null || (accessibilityManager = aVar.E) == null) {
                return;
            }
            y0.c.removeTouchExplorationStateChangeListener(accessibilityManager, aVar2);
        }
    }

    /* compiled from: EndCompoundLayout.java */
    public static class d {

        /* renamed from: a, reason: collision with root package name */
        public final SparseArray<l> f9474a = new SparseArray<>();

        /* renamed from: b, reason: collision with root package name */
        public final a f9475b;

        /* renamed from: c, reason: collision with root package name */
        public final int f9476c;

        /* renamed from: d, reason: collision with root package name */
        public final int f9477d;

        public d(a aVar, c1 c1Var) {
            this.f9475b = aVar;
            this.f9476c = c1Var.getResourceId(R.styleable.TextInputLayout_endIconDrawable, 0);
            this.f9477d = c1Var.getResourceId(R.styleable.TextInputLayout_passwordToggleDrawable, 0);
        }
    }

    public a(TextInputLayout textInputLayout, c1 c1Var) {
        CharSequence text;
        super(textInputLayout.getContext());
        this.f9464t = 0;
        this.f9465u = new LinkedHashSet<>();
        this.G = new C0091a();
        b bVar = new b();
        this.E = (AccessibilityManager) getContext().getSystemService("accessibility");
        this.f9456b = textInputLayout;
        setVisibility(8);
        setOrientation(0);
        setLayoutParams(new FrameLayout.LayoutParams(-2, -1, 8388613));
        FrameLayout frameLayout = new FrameLayout(getContext());
        this.f9457m = frameLayout;
        frameLayout.setVisibility(8);
        frameLayout.setLayoutParams(new LinearLayout.LayoutParams(-2, -1));
        LayoutInflater layoutInflaterFrom = LayoutInflater.from(getContext());
        CheckableImageButton checkableImageButtonA = a(this, layoutInflaterFrom, R.id.text_input_error_icon);
        this.f9458n = checkableImageButtonA;
        CheckableImageButton checkableImageButtonA2 = a(frameLayout, layoutInflaterFrom, R.id.text_input_end_icon);
        this.f9462r = checkableImageButtonA2;
        this.f9463s = new d(this, c1Var);
        AppCompatTextView appCompatTextView = new AppCompatTextView(getContext());
        this.B = appCompatTextView;
        int i10 = R.styleable.TextInputLayout_errorIconTint;
        if (c1Var.hasValue(i10)) {
            this.f9459o = n7.c.getColorStateList(getContext(), c1Var, i10);
        }
        int i11 = R.styleable.TextInputLayout_errorIconTintMode;
        if (c1Var.hasValue(i11)) {
            this.f9460p = t.parseTintMode(c1Var.getInt(i11, -1), null);
        }
        int i12 = R.styleable.TextInputLayout_errorIconDrawable;
        if (c1Var.hasValue(i12)) {
            i(c1Var.getDrawable(i12));
        }
        checkableImageButtonA.setContentDescription(getResources().getText(R.string.error_icon_content_description));
        j0.setImportantForAccessibility(checkableImageButtonA, 2);
        checkableImageButtonA.setClickable(false);
        checkableImageButtonA.setPressable(false);
        checkableImageButtonA.setFocusable(false);
        int i13 = R.styleable.TextInputLayout_passwordToggleEnabled;
        if (!c1Var.hasValue(i13)) {
            int i14 = R.styleable.TextInputLayout_endIconTint;
            if (c1Var.hasValue(i14)) {
                this.f9466v = n7.c.getColorStateList(getContext(), c1Var, i14);
            }
            int i15 = R.styleable.TextInputLayout_endIconTintMode;
            if (c1Var.hasValue(i15)) {
                this.f9467w = t.parseTintMode(c1Var.getInt(i15, -1), null);
            }
        }
        int i16 = R.styleable.TextInputLayout_endIconMode;
        if (c1Var.hasValue(i16)) {
            g(c1Var.getInt(i16, 0));
            int i17 = R.styleable.TextInputLayout_endIconContentDescription;
            if (c1Var.hasValue(i17) && checkableImageButtonA2.getContentDescription() != (text = c1Var.getText(i17))) {
                checkableImageButtonA2.setContentDescription(text);
            }
            checkableImageButtonA2.setCheckable(c1Var.getBoolean(R.styleable.TextInputLayout_endIconCheckable, true));
        } else if (c1Var.hasValue(i13)) {
            int i18 = R.styleable.TextInputLayout_passwordToggleTint;
            if (c1Var.hasValue(i18)) {
                this.f9466v = n7.c.getColorStateList(getContext(), c1Var, i18);
            }
            int i19 = R.styleable.TextInputLayout_passwordToggleTintMode;
            if (c1Var.hasValue(i19)) {
                this.f9467w = t.parseTintMode(c1Var.getInt(i19, -1), null);
            }
            g(c1Var.getBoolean(i13, false) ? 1 : 0);
            CharSequence text2 = c1Var.getText(R.styleable.TextInputLayout_passwordToggleContentDescription);
            if (checkableImageButtonA2.getContentDescription() != text2) {
                checkableImageButtonA2.setContentDescription(text2);
            }
        }
        int dimensionPixelSize = c1Var.getDimensionPixelSize(R.styleable.TextInputLayout_endIconMinSize, getResources().getDimensionPixelSize(R.dimen.mtrl_min_touch_target_size));
        if (dimensionPixelSize < 0) {
            throw new IllegalArgumentException("endIconSize cannot be less than 0");
        }
        if (dimensionPixelSize != this.f9468x) {
            this.f9468x = dimensionPixelSize;
            checkableImageButtonA2.setMinimumWidth(dimensionPixelSize);
            checkableImageButtonA2.setMinimumHeight(dimensionPixelSize);
            checkableImageButtonA.setMinimumWidth(dimensionPixelSize);
            checkableImageButtonA.setMinimumHeight(dimensionPixelSize);
        }
        int i20 = R.styleable.TextInputLayout_endIconScaleType;
        if (c1Var.hasValue(i20)) {
            ImageView.ScaleType scaleTypeB = m.b(c1Var.getInt(i20, -1));
            this.f9469y = scaleTypeB;
            checkableImageButtonA2.setScaleType(scaleTypeB);
            checkableImageButtonA.setScaleType(scaleTypeB);
        }
        appCompatTextView.setVisibility(8);
        appCompatTextView.setId(R.id.textinput_suffix_text);
        appCompatTextView.setLayoutParams(new LinearLayout.LayoutParams(-2, -2, 80.0f));
        j0.setAccessibilityLiveRegion(appCompatTextView, 1);
        i.setTextAppearance(appCompatTextView, c1Var.getResourceId(R.styleable.TextInputLayout_suffixTextAppearance, 0));
        int i21 = R.styleable.TextInputLayout_suffixTextColor;
        if (c1Var.hasValue(i21)) {
            appCompatTextView.setTextColor(c1Var.getColorStateList(i21));
        }
        CharSequence text3 = c1Var.getText(R.styleable.TextInputLayout_suffixText);
        this.A = TextUtils.isEmpty(text3) ? null : text3;
        appCompatTextView.setText(text3);
        n();
        frameLayout.addView(checkableImageButtonA2);
        addView(appCompatTextView);
        addView(frameLayout);
        addView(checkableImageButtonA);
        textInputLayout.addOnEditTextAttachedListener(bVar);
        addOnAttachStateChangeListener(new c());
    }

    public final CheckableImageButton a(ViewGroup viewGroup, LayoutInflater layoutInflater, int i10) {
        CheckableImageButton checkableImageButton = (CheckableImageButton) layoutInflater.inflate(R.layout.design_text_input_end_icon, viewGroup, false);
        checkableImageButton.setId(i10);
        if (Build.VERSION.SDK_INT <= 22) {
            checkableImageButton.setBackground(o7.b.createOvalRippleLollipop(checkableImageButton.getContext(), (int) t.dpToPx(checkableImageButton.getContext(), 4)));
        }
        if (n7.c.isFontScaleAtLeast1_3(getContext())) {
            k.setMarginStart((ViewGroup.MarginLayoutParams) checkableImageButton.getLayoutParams(), 0);
        }
        return checkableImageButton;
    }

    public final l b() {
        l fVar;
        int i10 = this.f9464t;
        d dVar = this.f9463s;
        SparseArray<l> sparseArray = dVar.f9474a;
        l rVar = sparseArray.get(i10);
        if (rVar == null) {
            a aVar = dVar.f9475b;
            if (i10 == -1) {
                fVar = new f(aVar);
            } else if (i10 == 0) {
                fVar = new v7.q(aVar);
            } else if (i10 == 1) {
                rVar = new r(aVar, dVar.f9477d);
                sparseArray.append(i10, rVar);
            } else if (i10 == 2) {
                fVar = new e(aVar);
            } else {
                if (i10 != 3) {
                    throw new IllegalArgumentException(ac.c.f("Invalid end icon mode: ", i10));
                }
                fVar = new v7.k(aVar);
            }
            rVar = fVar;
            sparseArray.append(i10, rVar);
        }
        return rVar;
    }

    public final int c() {
        int marginStart;
        if (d() || e()) {
            CheckableImageButton checkableImageButton = this.f9462r;
            marginStart = k.getMarginStart((ViewGroup.MarginLayoutParams) checkableImageButton.getLayoutParams()) + checkableImageButton.getMeasuredWidth();
        } else {
            marginStart = 0;
        }
        return j0.getPaddingEnd(this.B) + j0.getPaddingEnd(this) + marginStart;
    }

    public final boolean d() {
        return this.f9457m.getVisibility() == 0 && this.f9462r.getVisibility() == 0;
    }

    public final boolean e() {
        return this.f9458n.getVisibility() == 0;
    }

    public final void f(boolean z10) {
        boolean z11;
        boolean zIsActivated;
        boolean zIsChecked;
        l lVarB = b();
        boolean zI = lVarB.i();
        CheckableImageButton checkableImageButton = this.f9462r;
        boolean z12 = true;
        if (!zI || (zIsChecked = checkableImageButton.isChecked()) == lVarB.j()) {
            z11 = false;
        } else {
            checkableImageButton.setChecked(!zIsChecked);
            z11 = true;
        }
        if (!(lVarB instanceof v7.k) || (zIsActivated = checkableImageButton.isActivated()) == lVarB.h()) {
            z12 = z11;
        } else {
            checkableImageButton.setActivated(!zIsActivated);
        }
        if (z10 || z12) {
            m.c(this.f9456b, checkableImageButton, this.f9466v);
        }
    }

    public final void g(int i10) {
        TextInputLayout textInputLayout;
        if (this.f9464t == i10) {
            return;
        }
        l lVarB = b();
        c.a aVar = this.F;
        AccessibilityManager accessibilityManager = this.E;
        if (aVar != null && accessibilityManager != null) {
            y0.c.removeTouchExplorationStateChangeListener(accessibilityManager, aVar);
        }
        this.F = null;
        lVarB.n();
        int i11 = this.f9464t;
        this.f9464t = i10;
        Iterator<TextInputLayout.g> it = this.f9465u.iterator();
        while (true) {
            boolean zHasNext = it.hasNext();
            textInputLayout = this.f9456b;
            if (!zHasNext) {
                break;
            } else {
                it.next().onEndIconChanged(textInputLayout, i11);
            }
        }
        h(i10 != 0);
        l lVarB2 = b();
        int iC = this.f9463s.f9476c;
        if (iC == 0) {
            iC = lVarB2.c();
        }
        Drawable drawable = iC != 0 ? s.a.getDrawable(getContext(), iC) : null;
        CheckableImageButton checkableImageButton = this.f9462r;
        checkableImageButton.setImageDrawable(drawable);
        if (drawable != null) {
            m.a(textInputLayout, checkableImageButton, this.f9466v, this.f9467w);
            m.c(textInputLayout, checkableImageButton, this.f9466v);
        }
        int iB = lVarB2.b();
        CharSequence text = iB != 0 ? getResources().getText(iB) : null;
        if (checkableImageButton.getContentDescription() != text) {
            checkableImageButton.setContentDescription(text);
        }
        checkableImageButton.setCheckable(lVarB2.i());
        if (!lVarB2.g(textInputLayout.getBoxBackgroundMode())) {
            throw new IllegalStateException("The current box background mode " + textInputLayout.getBoxBackgroundMode() + " is not supported by the end icon mode " + i10);
        }
        lVarB2.m();
        c.a touchExplorationStateChangeListener = lVarB2.getTouchExplorationStateChangeListener();
        this.F = touchExplorationStateChangeListener;
        if (touchExplorationStateChangeListener != null && accessibilityManager != null && j0.isAttachedToWindow(this)) {
            y0.c.addTouchExplorationStateChangeListener(accessibilityManager, this.F);
        }
        View.OnClickListener onClickListenerE = lVarB2.e();
        View.OnLongClickListener onLongClickListener = this.f9470z;
        checkableImageButton.setOnClickListener(onClickListenerE);
        m.d(checkableImageButton, onLongClickListener);
        EditText editText = this.D;
        if (editText != null) {
            lVarB2.onEditTextAttached(editText);
            j(lVarB2);
        }
        m.a(textInputLayout, checkableImageButton, this.f9466v, this.f9467w);
        f(true);
    }

    public final void h(boolean z10) {
        if (d() != z10) {
            this.f9462r.setVisibility(z10 ? 0 : 8);
            k();
            m();
            this.f9456b.q();
        }
    }

    public final void i(Drawable drawable) {
        CheckableImageButton checkableImageButton = this.f9458n;
        checkableImageButton.setImageDrawable(drawable);
        l();
        m.a(this.f9456b, checkableImageButton, this.f9459o, this.f9460p);
    }

    public final void j(l lVar) {
        if (this.D == null) {
            return;
        }
        if (lVar.d() != null) {
            this.D.setOnFocusChangeListener(lVar.d());
        }
        if (lVar.f() != null) {
            this.f9462r.setOnFocusChangeListener(lVar.f());
        }
    }

    public final void k() {
        this.f9457m.setVisibility((this.f9462r.getVisibility() != 0 || e()) ? 8 : 0);
        setVisibility(d() || e() || ((this.A == null || this.C) ? '\b' : (char) 0) == 0 ? 0 : 8);
    }

    public final void l() {
        CheckableImageButton checkableImageButton = this.f9458n;
        Drawable drawable = checkableImageButton.getDrawable();
        TextInputLayout textInputLayout = this.f9456b;
        checkableImageButton.setVisibility(drawable != null && textInputLayout.isErrorEnabled() && textInputLayout.m() ? 0 : 8);
        k();
        m();
        if (this.f9464t != 0) {
            return;
        }
        textInputLayout.q();
    }

    public final void m() {
        TextInputLayout textInputLayout = this.f9456b;
        if (textInputLayout.f9424o == null) {
            return;
        }
        j0.setPaddingRelative(this.B, getContext().getResources().getDimensionPixelSize(R.dimen.material_input_text_to_prefix_suffix_padding), textInputLayout.f9424o.getPaddingTop(), (d() || e()) ? 0 : j0.getPaddingEnd(textInputLayout.f9424o), textInputLayout.f9424o.getPaddingBottom());
    }

    public final void n() {
        AppCompatTextView appCompatTextView = this.B;
        int visibility = appCompatTextView.getVisibility();
        int i10 = (this.A == null || this.C) ? 8 : 0;
        if (visibility != i10) {
            b().k(i10 == 0);
        }
        k();
        appCompatTextView.setVisibility(i10);
        this.f9456b.q();
    }
}
