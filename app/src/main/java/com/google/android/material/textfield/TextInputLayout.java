package com.google.android.material.textfield;

import android.animation.ValueAnimator;
import android.annotation.TargetApi;
import android.content.Context;
import android.content.res.ColorStateList;
import android.content.res.Configuration;
import android.content.res.Resources;
import android.graphics.Canvas;
import android.graphics.PorterDuff;
import android.graphics.Rect;
import android.graphics.RectF;
import android.graphics.Typeface;
import android.graphics.drawable.ColorDrawable;
import android.graphics.drawable.Drawable;
import android.graphics.drawable.LayerDrawable;
import android.graphics.drawable.RippleDrawable;
import android.graphics.drawable.StateListDrawable;
import android.os.Build;
import android.os.Parcel;
import android.os.Parcelable;
import android.text.Editable;
import android.text.TextUtils;
import android.text.TextWatcher;
import android.util.AttributeSet;
import android.util.Log;
import android.util.SparseArray;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewStructure;
import android.view.ViewTreeObserver;
import android.view.accessibility.AccessibilityEvent;
import android.view.animation.LinearInterpolator;
import android.widget.AutoCompleteTextView;
import android.widget.EditText;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import androidx.appcompat.widget.AppCompatTextView;
import androidx.appcompat.widget.c1;
import androidx.appcompat.widget.i0;
import androidx.appcompat.widget.k;
import com.google.android.material.R;
import com.google.android.material.internal.CheckableImageButton;
import d1.i;
import i7.r;
import i7.t;
import java.util.Iterator;
import java.util.LinkedHashSet;
import q7.l;
import v7.g;
import v7.m;
import v7.n;
import v7.o;
import v7.p;
import v7.s;
import x0.j0;

/* loaded from: classes.dex */
public class TextInputLayout extends LinearLayout implements ViewTreeObserver.OnGlobalLayoutListener {
    public static final int N0 = R.style.Widget_Design_TextInputLayout;
    public static final int[][] O0 = {new int[]{android.R.attr.state_pressed}, new int[0]};
    public int A;
    public int A0;
    public int B;
    public int B0;
    public CharSequence C;
    public int C0;
    public boolean D;
    public int D0;
    public AppCompatTextView E;
    public int E0;
    public ColorStateList F;
    public boolean F0;
    public int G;
    public final com.google.android.material.internal.a G0;
    public androidx.transition.b H;
    public boolean H0;
    public androidx.transition.b I;
    public boolean I0;
    public ColorStateList J;
    public ValueAnimator J0;
    public ColorStateList K;
    public boolean K0;
    public ColorStateList L;
    public boolean L0;
    public ColorStateList M;
    public boolean M0;
    public boolean N;
    public CharSequence O;
    public boolean P;
    public q7.g Q;
    public q7.g R;
    public StateListDrawable S;
    public boolean T;
    public q7.g U;
    public q7.g V;
    public l W;

    /* renamed from: a0, reason: collision with root package name */
    public boolean f9407a0;

    /* renamed from: b, reason: collision with root package name */
    public final FrameLayout f9408b;

    /* renamed from: b0, reason: collision with root package name */
    public final int f9409b0;

    /* renamed from: c0, reason: collision with root package name */
    public int f9410c0;

    /* renamed from: d0, reason: collision with root package name */
    public int f9411d0;

    /* renamed from: e0, reason: collision with root package name */
    public int f9412e0;

    /* renamed from: f0, reason: collision with root package name */
    public int f9413f0;

    /* renamed from: g0, reason: collision with root package name */
    public int f9414g0;

    /* renamed from: h0, reason: collision with root package name */
    public int f9415h0;

    /* renamed from: i0, reason: collision with root package name */
    public int f9416i0;

    /* renamed from: j0, reason: collision with root package name */
    public final Rect f9417j0;

    /* renamed from: k0, reason: collision with root package name */
    public final Rect f9418k0;

    /* renamed from: l0, reason: collision with root package name */
    public final RectF f9419l0;

    /* renamed from: m, reason: collision with root package name */
    public final s f9420m;

    /* renamed from: m0, reason: collision with root package name */
    public Typeface f9421m0;

    /* renamed from: n, reason: collision with root package name */
    public final com.google.android.material.textfield.a f9422n;

    /* renamed from: n0, reason: collision with root package name */
    public ColorDrawable f9423n0;

    /* renamed from: o, reason: collision with root package name */
    public EditText f9424o;

    /* renamed from: o0, reason: collision with root package name */
    public int f9425o0;

    /* renamed from: p, reason: collision with root package name */
    public CharSequence f9426p;

    /* renamed from: p0, reason: collision with root package name */
    public final LinkedHashSet<f> f9427p0;

    /* renamed from: q, reason: collision with root package name */
    public int f9428q;

    /* renamed from: q0, reason: collision with root package name */
    public ColorDrawable f9429q0;

    /* renamed from: r, reason: collision with root package name */
    public int f9430r;

    /* renamed from: r0, reason: collision with root package name */
    public int f9431r0;

    /* renamed from: s, reason: collision with root package name */
    public int f9432s;

    /* renamed from: s0, reason: collision with root package name */
    public Drawable f9433s0;

    /* renamed from: t, reason: collision with root package name */
    public int f9434t;

    /* renamed from: t0, reason: collision with root package name */
    public ColorStateList f9435t0;

    /* renamed from: u, reason: collision with root package name */
    public final n f9436u;

    /* renamed from: u0, reason: collision with root package name */
    public ColorStateList f9437u0;

    /* renamed from: v, reason: collision with root package name */
    public boolean f9438v;

    /* renamed from: v0, reason: collision with root package name */
    public int f9439v0;

    /* renamed from: w, reason: collision with root package name */
    public int f9440w;

    /* renamed from: w0, reason: collision with root package name */
    public int f9441w0;

    /* renamed from: x, reason: collision with root package name */
    public boolean f9442x;

    /* renamed from: x0, reason: collision with root package name */
    public int f9443x0;

    /* renamed from: y, reason: collision with root package name */
    public e f9444y;

    /* renamed from: y0, reason: collision with root package name */
    public ColorStateList f9445y0;

    /* renamed from: z, reason: collision with root package name */
    public AppCompatTextView f9446z;

    /* renamed from: z0, reason: collision with root package name */
    public int f9447z0;

    public class b implements Runnable {
        public b() {
        }

        @Override // java.lang.Runnable
        public void run() {
            CheckableImageButton checkableImageButton = TextInputLayout.this.f9422n.f9462r;
            checkableImageButton.performClick();
            checkableImageButton.jumpDrawablesToCurrentState();
        }
    }

    public class c implements ValueAnimator.AnimatorUpdateListener {
        public c() {
        }

        @Override // android.animation.ValueAnimator.AnimatorUpdateListener
        public void onAnimationUpdate(ValueAnimator valueAnimator) throws NoSuchMethodException, SecurityException {
            TextInputLayout.this.G0.setExpansionFraction(((Float) valueAnimator.getAnimatedValue()).floatValue());
        }
    }

    public static class d extends x0.a {

        /* renamed from: d, reason: collision with root package name */
        public final TextInputLayout f9453d;

        public d(TextInputLayout textInputLayout) {
            this.f9453d = textInputLayout;
        }

        @Override // x0.a
        public void onInitializeAccessibilityNodeInfo(View view, y0.d dVar) {
            super.onInitializeAccessibilityNodeInfo(view, dVar);
            TextInputLayout textInputLayout = this.f9453d;
            EditText editText = textInputLayout.getEditText();
            CharSequence text = editText != null ? editText.getText() : null;
            CharSequence hint = textInputLayout.getHint();
            CharSequence error = textInputLayout.getError();
            CharSequence placeholderText = textInputLayout.getPlaceholderText();
            int counterMaxLength = textInputLayout.getCounterMaxLength();
            CharSequence counterOverflowDescription = textInputLayout.getCounterOverflowDescription();
            boolean z10 = !TextUtils.isEmpty(text);
            boolean z11 = !TextUtils.isEmpty(hint);
            boolean z12 = !textInputLayout.F0;
            boolean z13 = !TextUtils.isEmpty(error);
            boolean z14 = z13 || !TextUtils.isEmpty(counterOverflowDescription);
            String string = z11 ? hint.toString() : "";
            s sVar = textInputLayout.f9420m;
            View view2 = sVar.f20610m;
            if (view2.getVisibility() == 0) {
                dVar.setLabelFor(view2);
                dVar.setTraversalAfter(view2);
            } else {
                dVar.setTraversalAfter(sVar.f20612o);
            }
            if (z10) {
                dVar.setText(text);
            } else if (!TextUtils.isEmpty(string)) {
                dVar.setText(string);
                if (z12 && placeholderText != null) {
                    dVar.setText(string + ", " + ((Object) placeholderText));
                }
            } else if (placeholderText != null) {
                dVar.setText(placeholderText);
            }
            if (!TextUtils.isEmpty(string)) {
                if (Build.VERSION.SDK_INT >= 26) {
                    dVar.setHintText(string);
                } else {
                    if (z10) {
                        string = ((Object) text) + ", " + string;
                    }
                    dVar.setText(string);
                }
                dVar.setShowingHintText(!z10);
            }
            if (text == null || text.length() != counterMaxLength) {
                counterMaxLength = -1;
            }
            dVar.setMaxTextLength(counterMaxLength);
            if (z14) {
                if (!z13) {
                    error = counterOverflowDescription;
                }
                dVar.setError(error);
            }
            View view3 = textInputLayout.f9436u.f20586y;
            if (view3 != null) {
                dVar.setLabelFor(view3);
            }
            textInputLayout.f9422n.b().onInitializeAccessibilityNodeInfo(view, dVar);
        }

        @Override // x0.a
        public void onPopulateAccessibilityEvent(View view, AccessibilityEvent accessibilityEvent) {
            super.onPopulateAccessibilityEvent(view, accessibilityEvent);
            this.f9453d.f9422n.b().onPopulateAccessibilityEvent(view, accessibilityEvent);
        }
    }

    public interface e {
    }

    public interface f {
        void onEditTextAttached(TextInputLayout textInputLayout);
    }

    public interface g {
        void onEndIconChanged(TextInputLayout textInputLayout, int i10);
    }

    public static class h extends f1.a {
        public static final Parcelable.Creator<h> CREATOR = new a();

        /* renamed from: n, reason: collision with root package name */
        public CharSequence f9454n;

        /* renamed from: o, reason: collision with root package name */
        public boolean f9455o;

        public class a implements Parcelable.ClassLoaderCreator<h> {
            @Override // android.os.Parcelable.Creator
            public h[] newArray(int i10) {
                return new h[i10];
            }

            /* JADX WARN: Can't rename method to resolve collision */
            @Override // android.os.Parcelable.ClassLoaderCreator
            public h createFromParcel(Parcel parcel, ClassLoader classLoader) {
                return new h(parcel, classLoader);
            }

            @Override // android.os.Parcelable.Creator
            public h createFromParcel(Parcel parcel) {
                return new h(parcel, null);
            }
        }

        public h(Parcelable parcelable) {
            super(parcelable);
        }

        public String toString() {
            return "TextInputLayout.SavedState{" + Integer.toHexString(System.identityHashCode(this)) + " error=" + ((Object) this.f9454n) + "}";
        }

        @Override // f1.a, android.os.Parcelable
        public void writeToParcel(Parcel parcel, int i10) {
            super.writeToParcel(parcel, i10);
            TextUtils.writeToParcel(this.f9454n, parcel, i10);
            parcel.writeInt(this.f9455o ? 1 : 0);
        }

        public h(Parcel parcel, ClassLoader classLoader) {
            super(parcel, classLoader);
            this.f9454n = (CharSequence) TextUtils.CHAR_SEQUENCE_CREATOR.createFromParcel(parcel);
            this.f9455o = parcel.readInt() == 1;
        }
    }

    public TextInputLayout(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, R.attr.textInputStyle);
    }

    private Drawable getEditTextBoxBackground() {
        EditText editText = this.f9424o;
        if (editText instanceof AutoCompleteTextView) {
            if (!(editText.getInputType() != 0)) {
                int color = c7.a.getColor(this.f9424o, R.attr.colorControlHighlight);
                int i10 = this.f9410c0;
                int[][] iArr = O0;
                if (i10 != 2) {
                    if (i10 != 1) {
                        return null;
                    }
                    q7.g gVar = this.Q;
                    int i11 = this.f9416i0;
                    return new RippleDrawable(new ColorStateList(iArr, new int[]{c7.a.layer(color, i11, 0.1f), i11}), gVar, gVar);
                }
                Context context = getContext();
                q7.g gVar2 = this.Q;
                int color2 = c7.a.getColor(context, R.attr.colorSurface, "TextInputLayout");
                q7.g gVar3 = new q7.g(gVar2.getShapeAppearanceModel());
                int iLayer = c7.a.layer(color, color2, 0.1f);
                gVar3.setFillColor(new ColorStateList(iArr, new int[]{iLayer, 0}));
                gVar3.setTint(color2);
                ColorStateList colorStateList = new ColorStateList(iArr, new int[]{iLayer, color2});
                q7.g gVar4 = new q7.g(gVar2.getShapeAppearanceModel());
                gVar4.setTint(-1);
                return new LayerDrawable(new Drawable[]{new RippleDrawable(colorStateList, gVar3, gVar4), gVar2});
            }
        }
        return this.Q;
    }

    private Drawable getOrCreateFilledDropDownMenuBackground() {
        if (this.S == null) {
            StateListDrawable stateListDrawable = new StateListDrawable();
            this.S = stateListDrawable;
            stateListDrawable.addState(new int[]{android.R.attr.state_above_anchor}, getOrCreateOutlinedDropDownMenuBackground());
            this.S.addState(new int[0], f(false));
        }
        return this.S;
    }

    private Drawable getOrCreateOutlinedDropDownMenuBackground() {
        if (this.R == null) {
            this.R = f(true);
        }
        return this.R;
    }

    public static void k(ViewGroup viewGroup, boolean z10) {
        int childCount = viewGroup.getChildCount();
        for (int i10 = 0; i10 < childCount; i10++) {
            View childAt = viewGroup.getChildAt(i10);
            childAt.setEnabled(z10);
            if (childAt instanceof ViewGroup) {
                k((ViewGroup) childAt, z10);
            }
        }
    }

    private void setEditText(EditText editText) throws NoSuchMethodException, SecurityException {
        if (this.f9424o != null) {
            throw new IllegalArgumentException("We already have an EditText, can only have one");
        }
        if (getEndIconMode() != 3 && !(editText instanceof TextInputEditText)) {
            Log.i("TextInputLayout", "EditText added is not a TextInputEditText. Please switch to using that class instead.");
        }
        this.f9424o = editText;
        int i10 = this.f9428q;
        if (i10 != -1) {
            setMinEms(i10);
        } else {
            setMinWidth(this.f9432s);
        }
        int i11 = this.f9430r;
        if (i11 != -1) {
            setMaxEms(i11);
        } else {
            setMaxWidth(this.f9434t);
        }
        this.T = false;
        i();
        setTextInputAccessibilityDelegate(new d(this));
        Typeface typeface = this.f9424o.getTypeface();
        com.google.android.material.internal.a aVar = this.G0;
        aVar.setTypefaces(typeface);
        aVar.setExpandedTextSize(this.f9424o.getTextSize());
        int i12 = Build.VERSION.SDK_INT;
        aVar.setExpandedLetterSpacing(this.f9424o.getLetterSpacing());
        int gravity = this.f9424o.getGravity();
        aVar.setCollapsedTextGravity((gravity & (-113)) | 48);
        aVar.setExpandedTextGravity(gravity);
        this.E0 = j0.getMinimumHeight(editText);
        this.f9424o.addTextChangedListener(new a(editText));
        if (this.f9435t0 == null) {
            this.f9435t0 = this.f9424o.getHintTextColors();
        }
        if (this.N) {
            if (TextUtils.isEmpty(this.O)) {
                CharSequence hint = this.f9424o.getHint();
                this.f9426p = hint;
                setHint(hint);
                this.f9424o.setHint((CharSequence) null);
            }
            this.P = true;
        }
        if (i12 >= 29) {
            p();
        }
        if (this.f9446z != null) {
            n(this.f9424o.getText());
        }
        r();
        this.f9436u.b();
        this.f9420m.bringToFront();
        com.google.android.material.textfield.a aVar2 = this.f9422n;
        aVar2.bringToFront();
        Iterator<f> it = this.f9427p0.iterator();
        while (it.hasNext()) {
            it.next().onEditTextAttached(this);
        }
        aVar2.m();
        if (!isEnabled()) {
            editText.setEnabled(false);
        }
        u(false, true);
    }

    private void setHintInternal(CharSequence charSequence) throws NoSuchMethodException, SecurityException {
        if (TextUtils.equals(charSequence, this.O)) {
            return;
        }
        this.O = charSequence;
        this.G0.setText(charSequence);
        if (this.F0) {
            return;
        }
        j();
    }

    private void setPlaceholderTextEnabled(boolean z10) {
        if (this.D == z10) {
            return;
        }
        if (z10) {
            AppCompatTextView appCompatTextView = this.E;
            if (appCompatTextView != null) {
                this.f9408b.addView(appCompatTextView);
                this.E.setVisibility(0);
            }
        } else {
            AppCompatTextView appCompatTextView2 = this.E;
            if (appCompatTextView2 != null) {
                appCompatTextView2.setVisibility(8);
            }
            this.E = null;
        }
        this.D = z10;
    }

    public final void a(float f10) {
        com.google.android.material.internal.a aVar = this.G0;
        if (aVar.getExpansionFraction() == f10) {
            return;
        }
        if (this.J0 == null) {
            ValueAnimator valueAnimator = new ValueAnimator();
            this.J0 = valueAnimator;
            valueAnimator.setInterpolator(k7.g.resolveThemeInterpolator(getContext(), R.attr.motionEasingEmphasizedInterpolator, p6.a.f17605b));
            this.J0.setDuration(k7.g.resolveThemeDuration(getContext(), R.attr.motionDurationMedium4, 167));
            this.J0.addUpdateListener(new c());
        }
        this.J0.setFloatValues(aVar.getExpansionFraction(), f10);
        this.J0.start();
    }

    public void addOnEditTextAttachedListener(f fVar) {
        this.f9427p0.add(fVar);
        if (this.f9424o != null) {
            fVar.onEditTextAttached(this);
        }
    }

    @Override // android.view.ViewGroup
    public void addView(View view, int i10, ViewGroup.LayoutParams layoutParams) throws NoSuchMethodException, SecurityException {
        if (!(view instanceof EditText)) {
            super.addView(view, i10, layoutParams);
            return;
        }
        FrameLayout.LayoutParams layoutParams2 = new FrameLayout.LayoutParams(layoutParams);
        layoutParams2.gravity = (layoutParams2.gravity & (-113)) | 16;
        FrameLayout frameLayout = this.f9408b;
        frameLayout.addView(view, layoutParams2);
        frameLayout.setLayoutParams(layoutParams);
        t();
        setEditText((EditText) view);
    }

    /* JADX WARN: Removed duplicated region for block: B:18:0x0029  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public final void b() {
        /*
            r6 = this;
            q7.g r0 = r6.Q
            if (r0 != 0) goto L5
            return
        L5:
            q7.l r0 = r0.getShapeAppearanceModel()
            q7.l r1 = r6.W
            if (r0 == r1) goto L12
            q7.g r0 = r6.Q
            r0.setShapeAppearanceModel(r1)
        L12:
            int r0 = r6.f9410c0
            r1 = 2
            r2 = -1
            r3 = 0
            r4 = 1
            if (r0 != r1) goto L29
            int r0 = r6.f9412e0
            if (r0 <= r2) goto L24
            int r0 = r6.f9415h0
            if (r0 == 0) goto L24
            r0 = 1
            goto L25
        L24:
            r0 = 0
        L25:
            if (r0 == 0) goto L29
            r0 = 1
            goto L2a
        L29:
            r0 = 0
        L2a:
            if (r0 == 0) goto L36
            q7.g r0 = r6.Q
            int r1 = r6.f9412e0
            float r1 = (float) r1
            int r5 = r6.f9415h0
            r0.setStroke(r1, r5)
        L36:
            int r0 = r6.f9416i0
            int r1 = r6.f9410c0
            if (r1 != r4) goto L48
            int r0 = com.google.android.material.R.attr.colorSurface
            int r0 = c7.a.getColor(r6, r0, r3)
            int r1 = r6.f9416i0
            int r0 = c7.a.layer(r0, r1)
        L48:
            r6.f9416i0 = r0
            q7.g r1 = r6.Q
            android.content.res.ColorStateList r0 = android.content.res.ColorStateList.valueOf(r0)
            r1.setFillColor(r0)
            q7.g r0 = r6.U
            if (r0 == 0) goto L8d
            q7.g r1 = r6.V
            if (r1 != 0) goto L5c
            goto L8d
        L5c:
            int r1 = r6.f9412e0
            if (r1 <= r2) goto L65
            int r1 = r6.f9415h0
            if (r1 == 0) goto L65
            r3 = 1
        L65:
            if (r3 == 0) goto L8a
            android.widget.EditText r1 = r6.f9424o
            boolean r1 = r1.isFocused()
            if (r1 == 0) goto L76
            int r1 = r6.f9439v0
            android.content.res.ColorStateList r1 = android.content.res.ColorStateList.valueOf(r1)
            goto L7c
        L76:
            int r1 = r6.f9415h0
            android.content.res.ColorStateList r1 = android.content.res.ColorStateList.valueOf(r1)
        L7c:
            r0.setFillColor(r1)
            q7.g r0 = r6.V
            int r1 = r6.f9415h0
            android.content.res.ColorStateList r1 = android.content.res.ColorStateList.valueOf(r1)
            r0.setFillColor(r1)
        L8a:
            r6.invalidate()
        L8d:
            r6.s()
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.material.textfield.TextInputLayout.b():void");
    }

    public final int c() {
        float collapsedTextHeight;
        if (!this.N) {
            return 0;
        }
        int i10 = this.f9410c0;
        com.google.android.material.internal.a aVar = this.G0;
        if (i10 == 0) {
            collapsedTextHeight = aVar.getCollapsedTextHeight();
        } else {
            if (i10 != 2) {
                return 0;
            }
            collapsedTextHeight = aVar.getCollapsedTextHeight() / 2.0f;
        }
        return (int) collapsedTextHeight;
    }

    public final androidx.transition.b d() {
        androidx.transition.b bVar = new androidx.transition.b();
        bVar.setDuration(k7.g.resolveThemeDuration(getContext(), R.attr.motionDurationShort2, 87));
        bVar.setInterpolator(k7.g.resolveThemeInterpolator(getContext(), R.attr.motionEasingLinearInterpolator, p6.a.f17604a));
        return bVar;
    }

    @Override // android.view.ViewGroup, android.view.View
    @TargetApi(26)
    public void dispatchProvideAutofillStructure(ViewStructure viewStructure, int i10) {
        EditText editText = this.f9424o;
        if (editText == null) {
            super.dispatchProvideAutofillStructure(viewStructure, i10);
            return;
        }
        if (this.f9426p != null) {
            boolean z10 = this.P;
            this.P = false;
            CharSequence hint = editText.getHint();
            this.f9424o.setHint(this.f9426p);
            try {
                super.dispatchProvideAutofillStructure(viewStructure, i10);
                return;
            } finally {
                this.f9424o.setHint(hint);
                this.P = z10;
            }
        }
        viewStructure.setAutofillId(getAutofillId());
        onProvideAutofillStructure(viewStructure, i10);
        onProvideAutofillVirtualStructure(viewStructure, i10);
        FrameLayout frameLayout = this.f9408b;
        viewStructure.setChildCount(frameLayout.getChildCount());
        for (int i11 = 0; i11 < frameLayout.getChildCount(); i11++) {
            View childAt = frameLayout.getChildAt(i11);
            ViewStructure viewStructureNewChild = viewStructure.newChild(i11);
            childAt.dispatchProvideAutofillStructure(viewStructureNewChild, i10);
            if (childAt == this.f9424o) {
                viewStructureNewChild.setHint(getHint());
            }
        }
    }

    @Override // android.view.ViewGroup, android.view.View
    public void dispatchRestoreInstanceState(SparseArray<Parcelable> sparseArray) {
        this.L0 = true;
        super.dispatchRestoreInstanceState(sparseArray);
        this.L0 = false;
    }

    @Override // android.view.View
    public void draw(Canvas canvas) {
        q7.g gVar;
        super.draw(canvas);
        boolean z10 = this.N;
        com.google.android.material.internal.a aVar = this.G0;
        if (z10) {
            aVar.draw(canvas);
        }
        if (this.V == null || (gVar = this.U) == null) {
            return;
        }
        gVar.draw(canvas);
        if (this.f9424o.isFocused()) {
            Rect bounds = this.V.getBounds();
            Rect bounds2 = this.U.getBounds();
            float expansionFraction = aVar.getExpansionFraction();
            int iCenterX = bounds2.centerX();
            bounds.left = p6.a.lerp(iCenterX, bounds2.left, expansionFraction);
            bounds.right = p6.a.lerp(iCenterX, bounds2.right, expansionFraction);
            this.V.draw(canvas);
        }
    }

    @Override // android.view.ViewGroup, android.view.View
    public void drawableStateChanged() throws NoSuchMethodException, SecurityException {
        if (this.K0) {
            return;
        }
        this.K0 = true;
        super.drawableStateChanged();
        int[] drawableState = getDrawableState();
        com.google.android.material.internal.a aVar = this.G0;
        boolean state = aVar != null ? aVar.setState(drawableState) | false : false;
        if (this.f9424o != null) {
            u(j0.isLaidOut(this) && isEnabled(), false);
        }
        r();
        x();
        if (state) {
            invalidate();
        }
        this.K0 = false;
    }

    public final boolean e() {
        return this.N && !TextUtils.isEmpty(this.O) && (this.Q instanceof v7.g);
    }

    public final q7.g f(boolean z10) throws Resources.NotFoundException {
        float dimensionPixelOffset = getResources().getDimensionPixelOffset(R.dimen.mtrl_shape_corner_size_small_component);
        float f10 = z10 ? dimensionPixelOffset : 0.0f;
        EditText editText = this.f9424o;
        float popupElevation = editText instanceof p ? ((p) editText).getPopupElevation() : getResources().getDimensionPixelOffset(R.dimen.m3_comp_outlined_autocomplete_menu_container_elevation);
        int dimensionPixelOffset2 = getResources().getDimensionPixelOffset(R.dimen.mtrl_exposed_dropdown_menu_popup_vertical_padding);
        l lVarBuild = l.builder().setTopLeftCornerSize(f10).setTopRightCornerSize(f10).setBottomLeftCornerSize(dimensionPixelOffset).setBottomRightCornerSize(dimensionPixelOffset).build();
        EditText editText2 = this.f9424o;
        q7.g gVarCreateWithElevationOverlay = q7.g.createWithElevationOverlay(getContext(), popupElevation, editText2 instanceof p ? ((p) editText2).getDropDownBackgroundTintList() : null);
        gVarCreateWithElevationOverlay.setShapeAppearanceModel(lVarBuild);
        gVarCreateWithElevationOverlay.setPadding(0, dimensionPixelOffset2, 0, dimensionPixelOffset2);
        return gVarCreateWithElevationOverlay;
    }

    public final int g(int i10, boolean z10) {
        return ((z10 || getPrefixText() == null) ? (!z10 || getSuffixText() == null) ? this.f9424o.getCompoundPaddingLeft() : this.f9422n.c() : this.f9420m.a()) + i10;
    }

    @Override // android.widget.LinearLayout, android.view.View
    public int getBaseline() {
        EditText editText = this.f9424o;
        if (editText == null) {
            return super.getBaseline();
        }
        return c() + getPaddingTop() + editText.getBaseline();
    }

    public q7.g getBoxBackground() {
        int i10 = this.f9410c0;
        if (i10 == 1 || i10 == 2) {
            return this.Q;
        }
        throw new IllegalStateException();
    }

    public int getBoxBackgroundColor() {
        return this.f9416i0;
    }

    public int getBoxBackgroundMode() {
        return this.f9410c0;
    }

    public int getBoxCollapsedPaddingTop() {
        return this.f9411d0;
    }

    public float getBoxCornerRadiusBottomEnd() {
        boolean zIsLayoutRtl = t.isLayoutRtl(this);
        RectF rectF = this.f9419l0;
        return zIsLayoutRtl ? this.W.getBottomLeftCornerSize().getCornerSize(rectF) : this.W.getBottomRightCornerSize().getCornerSize(rectF);
    }

    public float getBoxCornerRadiusBottomStart() {
        boolean zIsLayoutRtl = t.isLayoutRtl(this);
        RectF rectF = this.f9419l0;
        return zIsLayoutRtl ? this.W.getBottomRightCornerSize().getCornerSize(rectF) : this.W.getBottomLeftCornerSize().getCornerSize(rectF);
    }

    public float getBoxCornerRadiusTopEnd() {
        boolean zIsLayoutRtl = t.isLayoutRtl(this);
        RectF rectF = this.f9419l0;
        return zIsLayoutRtl ? this.W.getTopLeftCornerSize().getCornerSize(rectF) : this.W.getTopRightCornerSize().getCornerSize(rectF);
    }

    public float getBoxCornerRadiusTopStart() {
        boolean zIsLayoutRtl = t.isLayoutRtl(this);
        RectF rectF = this.f9419l0;
        return zIsLayoutRtl ? this.W.getTopRightCornerSize().getCornerSize(rectF) : this.W.getTopLeftCornerSize().getCornerSize(rectF);
    }

    public int getBoxStrokeColor() {
        return this.f9443x0;
    }

    public ColorStateList getBoxStrokeErrorColor() {
        return this.f9445y0;
    }

    public int getBoxStrokeWidth() {
        return this.f9413f0;
    }

    public int getBoxStrokeWidthFocused() {
        return this.f9414g0;
    }

    public int getCounterMaxLength() {
        return this.f9440w;
    }

    public CharSequence getCounterOverflowDescription() {
        AppCompatTextView appCompatTextView;
        if (this.f9438v && this.f9442x && (appCompatTextView = this.f9446z) != null) {
            return appCompatTextView.getContentDescription();
        }
        return null;
    }

    public ColorStateList getCounterOverflowTextColor() {
        return this.K;
    }

    public ColorStateList getCounterTextColor() {
        return this.J;
    }

    public ColorStateList getCursorColor() {
        return this.L;
    }

    public ColorStateList getCursorErrorColor() {
        return this.M;
    }

    public ColorStateList getDefaultHintTextColor() {
        return this.f9435t0;
    }

    public EditText getEditText() {
        return this.f9424o;
    }

    public CharSequence getEndIconContentDescription() {
        return this.f9422n.f9462r.getContentDescription();
    }

    public Drawable getEndIconDrawable() {
        return this.f9422n.f9462r.getDrawable();
    }

    public int getEndIconMinSize() {
        return this.f9422n.f9468x;
    }

    public int getEndIconMode() {
        return this.f9422n.f9464t;
    }

    public ImageView.ScaleType getEndIconScaleType() {
        return this.f9422n.f9469y;
    }

    public CheckableImageButton getEndIconView() {
        return this.f9422n.f9462r;
    }

    public CharSequence getError() {
        n nVar = this.f9436u;
        if (nVar.f20578q) {
            return nVar.f20577p;
        }
        return null;
    }

    public int getErrorAccessibilityLiveRegion() {
        return this.f9436u.f20581t;
    }

    public CharSequence getErrorContentDescription() {
        return this.f9436u.f20580s;
    }

    public int getErrorCurrentTextColors() {
        AppCompatTextView appCompatTextView = this.f9436u.f20579r;
        if (appCompatTextView != null) {
            return appCompatTextView.getCurrentTextColor();
        }
        return -1;
    }

    public Drawable getErrorIconDrawable() {
        return this.f9422n.f9458n.getDrawable();
    }

    public CharSequence getHelperText() {
        n nVar = this.f9436u;
        if (nVar.f20585x) {
            return nVar.f20584w;
        }
        return null;
    }

    public int getHelperTextCurrentTextColor() {
        AppCompatTextView appCompatTextView = this.f9436u.f20586y;
        if (appCompatTextView != null) {
            return appCompatTextView.getCurrentTextColor();
        }
        return -1;
    }

    public CharSequence getHint() {
        if (this.N) {
            return this.O;
        }
        return null;
    }

    public final float getHintCollapsedTextHeight() {
        return this.G0.getCollapsedTextHeight();
    }

    public final int getHintCurrentCollapsedTextColor() {
        return this.G0.getCurrentCollapsedTextColor();
    }

    public ColorStateList getHintTextColor() {
        return this.f9437u0;
    }

    public e getLengthCounter() {
        return this.f9444y;
    }

    public int getMaxEms() {
        return this.f9430r;
    }

    public int getMaxWidth() {
        return this.f9434t;
    }

    public int getMinEms() {
        return this.f9428q;
    }

    public int getMinWidth() {
        return this.f9432s;
    }

    @Deprecated
    public CharSequence getPasswordVisibilityToggleContentDescription() {
        return this.f9422n.f9462r.getContentDescription();
    }

    @Deprecated
    public Drawable getPasswordVisibilityToggleDrawable() {
        return this.f9422n.f9462r.getDrawable();
    }

    public CharSequence getPlaceholderText() {
        if (this.D) {
            return this.C;
        }
        return null;
    }

    public int getPlaceholderTextAppearance() {
        return this.G;
    }

    public ColorStateList getPlaceholderTextColor() {
        return this.F;
    }

    public CharSequence getPrefixText() {
        return this.f9420m.f20611n;
    }

    public ColorStateList getPrefixTextColor() {
        return this.f9420m.f20610m.getTextColors();
    }

    public TextView getPrefixTextView() {
        return this.f9420m.f20610m;
    }

    public l getShapeAppearanceModel() {
        return this.W;
    }

    public CharSequence getStartIconContentDescription() {
        return this.f9420m.f20612o.getContentDescription();
    }

    public Drawable getStartIconDrawable() {
        return this.f9420m.f20612o.getDrawable();
    }

    public int getStartIconMinSize() {
        return this.f9420m.f20615r;
    }

    public ImageView.ScaleType getStartIconScaleType() {
        return this.f9420m.f20616s;
    }

    public CharSequence getSuffixText() {
        return this.f9422n.A;
    }

    public ColorStateList getSuffixTextColor() {
        return this.f9422n.B.getTextColors();
    }

    public TextView getSuffixTextView() {
        return this.f9422n.B;
    }

    public Typeface getTypeface() {
        return this.f9421m0;
    }

    public final int h(int i10, boolean z10) {
        return i10 - ((z10 || getSuffixText() == null) ? (!z10 || getPrefixText() == null) ? this.f9424o.getCompoundPaddingRight() : this.f9420m.a() : this.f9422n.c());
    }

    public final void i() {
        int i10 = this.f9410c0;
        if (i10 == 0) {
            this.Q = null;
            this.U = null;
            this.V = null;
        } else if (i10 == 1) {
            this.Q = new q7.g(this.W);
            this.U = new q7.g();
            this.V = new q7.g();
        } else {
            if (i10 != 2) {
                throw new IllegalArgumentException(ac.c.m(new StringBuilder(), this.f9410c0, " is illegal; only @BoxBackgroundMode constants are supported."));
            }
            if (!this.N || (this.Q instanceof v7.g)) {
                this.Q = new q7.g(this.W);
            } else {
                l lVar = this.W;
                int i11 = v7.g.K;
                if (lVar == null) {
                    lVar = new l();
                }
                this.Q = new g.b(new g.a(lVar, new RectF()));
            }
            this.U = null;
            this.V = null;
        }
        s();
        x();
        if (this.f9410c0 == 1) {
            if (n7.c.isFontScaleAtLeast2_0(getContext())) {
                this.f9411d0 = getResources().getDimensionPixelSize(R.dimen.material_font_2_0_box_collapsed_padding_top);
            } else if (n7.c.isFontScaleAtLeast1_3(getContext())) {
                this.f9411d0 = getResources().getDimensionPixelSize(R.dimen.material_font_1_3_box_collapsed_padding_top);
            }
        }
        if (this.f9424o != null && this.f9410c0 == 1) {
            if (n7.c.isFontScaleAtLeast2_0(getContext())) {
                EditText editText = this.f9424o;
                j0.setPaddingRelative(editText, j0.getPaddingStart(editText), getResources().getDimensionPixelSize(R.dimen.material_filled_edittext_font_2_0_padding_top), j0.getPaddingEnd(this.f9424o), getResources().getDimensionPixelSize(R.dimen.material_filled_edittext_font_2_0_padding_bottom));
            } else if (n7.c.isFontScaleAtLeast1_3(getContext())) {
                EditText editText2 = this.f9424o;
                j0.setPaddingRelative(editText2, j0.getPaddingStart(editText2), getResources().getDimensionPixelSize(R.dimen.material_filled_edittext_font_1_3_padding_top), j0.getPaddingEnd(this.f9424o), getResources().getDimensionPixelSize(R.dimen.material_filled_edittext_font_1_3_padding_bottom));
            }
        }
        if (this.f9410c0 != 0) {
            t();
        }
        EditText editText3 = this.f9424o;
        if (editText3 instanceof AutoCompleteTextView) {
            AutoCompleteTextView autoCompleteTextView = (AutoCompleteTextView) editText3;
            if (autoCompleteTextView.getDropDownBackground() == null) {
                int i12 = this.f9410c0;
                if (i12 == 2) {
                    autoCompleteTextView.setDropDownBackgroundDrawable(getOrCreateOutlinedDropDownMenuBackground());
                } else if (i12 == 1) {
                    autoCompleteTextView.setDropDownBackgroundDrawable(getOrCreateFilledDropDownMenuBackground());
                }
            }
        }
    }

    public boolean isEndIconVisible() {
        return this.f9422n.d();
    }

    public boolean isErrorEnabled() {
        return this.f9436u.f20578q;
    }

    public boolean isHelperTextEnabled() {
        return this.f9436u.f20585x;
    }

    public boolean isProvidingHint() {
        return this.P;
    }

    public final void j() {
        if (e()) {
            int width = this.f9424o.getWidth();
            int gravity = this.f9424o.getGravity();
            com.google.android.material.internal.a aVar = this.G0;
            RectF rectF = this.f9419l0;
            aVar.getCollapsedTextActualBounds(rectF, width, gravity);
            if (rectF.width() <= 0.0f || rectF.height() <= 0.0f) {
                return;
            }
            float f10 = rectF.left;
            float f11 = this.f9409b0;
            rectF.left = f10 - f11;
            rectF.right += f11;
            rectF.offset(-getPaddingLeft(), ((-getPaddingTop()) - (rectF.height() / 2.0f)) + this.f9412e0);
            v7.g gVar = (v7.g) this.Q;
            gVar.getClass();
            gVar.h(rectF.left, rectF.top, rectF.right, rectF.bottom);
        }
    }

    /* JADX WARN: Removed duplicated region for block: B:9:0x0018  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public final void l(android.widget.TextView r3, int r4) {
        /*
            r2 = this;
            r0 = 1
            d1.i.setTextAppearance(r3, r4)     // Catch: java.lang.Exception -> L1b
            int r4 = android.os.Build.VERSION.SDK_INT     // Catch: java.lang.Exception -> L1b
            r1 = 23
            if (r4 < r1) goto L18
            android.content.res.ColorStateList r4 = r3.getTextColors()     // Catch: java.lang.Exception -> L1b
            int r4 = r4.getDefaultColor()     // Catch: java.lang.Exception -> L1b
            r1 = -65281(0xffffffffffff00ff, float:NaN)
            if (r4 != r1) goto L18
            goto L1c
        L18:
            r4 = 0
            r0 = 0
            goto L1c
        L1b:
        L1c:
            if (r0 == 0) goto L30
            int r4 = com.google.android.material.R.style.TextAppearance_AppCompat_Caption
            d1.i.setTextAppearance(r3, r4)
            android.content.Context r4 = r2.getContext()
            int r0 = com.google.android.material.R.color.design_error
            int r4 = m0.a.getColor(r4, r0)
            r3.setTextColor(r4)
        L30:
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.material.textfield.TextInputLayout.l(android.widget.TextView, int):void");
    }

    public final boolean m() {
        n nVar = this.f9436u;
        return (nVar.f20576o != 1 || nVar.f20579r == null || TextUtils.isEmpty(nVar.f20577p)) ? false : true;
    }

    public final void n(Editable editable) throws NoSuchMethodException, SecurityException {
        int iB = ((pd.a) this.f9444y).b(editable);
        boolean z10 = this.f9442x;
        int i10 = this.f9440w;
        if (i10 == -1) {
            this.f9446z.setText(String.valueOf(iB));
            this.f9446z.setContentDescription(null);
            this.f9442x = false;
        } else {
            this.f9442x = iB > i10;
            Context context = getContext();
            this.f9446z.setContentDescription(context.getString(this.f9442x ? R.string.character_counter_overflowed_content_description : R.string.character_counter_content_description, Integer.valueOf(iB), Integer.valueOf(this.f9440w)));
            if (z10 != this.f9442x) {
                o();
            }
            this.f9446z.setText(v0.a.getInstance().unicodeWrap(getContext().getString(R.string.character_counter_pattern, Integer.valueOf(iB), Integer.valueOf(this.f9440w))));
        }
        if (this.f9424o == null || z10 == this.f9442x) {
            return;
        }
        u(false, false);
        x();
        r();
    }

    public final void o() {
        ColorStateList colorStateList;
        ColorStateList colorStateList2;
        AppCompatTextView appCompatTextView = this.f9446z;
        if (appCompatTextView != null) {
            l(appCompatTextView, this.f9442x ? this.A : this.B);
            if (!this.f9442x && (colorStateList2 = this.J) != null) {
                this.f9446z.setTextColor(colorStateList2);
            }
            if (!this.f9442x || (colorStateList = this.K) == null) {
                return;
            }
            this.f9446z.setTextColor(colorStateList);
        }
    }

    @Override // android.view.View
    public void onConfigurationChanged(Configuration configuration) throws NoSuchMethodException, SecurityException {
        super.onConfigurationChanged(configuration);
        this.G0.maybeUpdateFontWeightAdjustment(configuration);
    }

    @Override // android.view.ViewTreeObserver.OnGlobalLayoutListener
    public void onGlobalLayout() {
        int iMax;
        com.google.android.material.textfield.a aVar = this.f9422n;
        aVar.getViewTreeObserver().removeOnGlobalLayoutListener(this);
        boolean z10 = false;
        this.M0 = false;
        if (this.f9424o != null && this.f9424o.getMeasuredHeight() < (iMax = Math.max(aVar.getMeasuredHeight(), this.f9420m.getMeasuredHeight()))) {
            this.f9424o.setMinimumHeight(iMax);
            z10 = true;
        }
        boolean zQ = q();
        if (z10 || zQ) {
            this.f9424o.post(new androidx.activity.d(this, 18));
        }
    }

    @Override // android.widget.LinearLayout, android.view.ViewGroup, android.view.View
    public void onLayout(boolean z10, int i10, int i11, int i12, int i13) throws NoSuchMethodException, SecurityException {
        super.onLayout(z10, i10, i11, i12, i13);
        EditText editText = this.f9424o;
        if (editText != null) {
            Rect rect = this.f9417j0;
            i7.b.getDescendantRect(this, editText, rect);
            q7.g gVar = this.U;
            if (gVar != null) {
                int i14 = rect.bottom;
                gVar.setBounds(rect.left, i14 - this.f9413f0, rect.right, i14);
            }
            q7.g gVar2 = this.V;
            if (gVar2 != null) {
                int i15 = rect.bottom;
                gVar2.setBounds(rect.left, i15 - this.f9414g0, rect.right, i15);
            }
            if (this.N) {
                float textSize = this.f9424o.getTextSize();
                com.google.android.material.internal.a aVar = this.G0;
                aVar.setExpandedTextSize(textSize);
                int gravity = this.f9424o.getGravity();
                aVar.setCollapsedTextGravity((gravity & (-113)) | 48);
                aVar.setExpandedTextGravity(gravity);
                if (this.f9424o == null) {
                    throw new IllegalStateException();
                }
                boolean zIsLayoutRtl = t.isLayoutRtl(this);
                int i16 = rect.bottom;
                Rect rect2 = this.f9418k0;
                rect2.bottom = i16;
                int i17 = this.f9410c0;
                if (i17 == 1) {
                    rect2.left = g(rect.left, zIsLayoutRtl);
                    rect2.top = rect.top + this.f9411d0;
                    rect2.right = h(rect.right, zIsLayoutRtl);
                } else if (i17 != 2) {
                    rect2.left = g(rect.left, zIsLayoutRtl);
                    rect2.top = getPaddingTop();
                    rect2.right = h(rect.right, zIsLayoutRtl);
                } else {
                    rect2.left = this.f9424o.getPaddingLeft() + rect.left;
                    rect2.top = rect.top - c();
                    rect2.right = rect.right - this.f9424o.getPaddingRight();
                }
                aVar.setCollapsedBounds(rect2);
                if (this.f9424o == null) {
                    throw new IllegalStateException();
                }
                float expandedTextHeight = aVar.getExpandedTextHeight();
                rect2.left = this.f9424o.getCompoundPaddingLeft() + rect.left;
                rect2.top = this.f9410c0 == 1 && this.f9424o.getMinLines() <= 1 ? (int) (rect.centerY() - (expandedTextHeight / 2.0f)) : rect.top + this.f9424o.getCompoundPaddingTop();
                rect2.right = rect.right - this.f9424o.getCompoundPaddingRight();
                rect2.bottom = this.f9410c0 == 1 && this.f9424o.getMinLines() <= 1 ? (int) (rect2.top + expandedTextHeight) : rect.bottom - this.f9424o.getCompoundPaddingBottom();
                aVar.setExpandedBounds(rect2);
                aVar.recalculate();
                if (!e() || this.F0) {
                    return;
                }
                j();
            }
        }
    }

    @Override // android.widget.LinearLayout, android.view.View
    public void onMeasure(int i10, int i11) {
        EditText editText;
        super.onMeasure(i10, i11);
        boolean z10 = this.M0;
        com.google.android.material.textfield.a aVar = this.f9422n;
        if (!z10) {
            aVar.getViewTreeObserver().addOnGlobalLayoutListener(this);
            this.M0 = true;
        }
        if (this.E != null && (editText = this.f9424o) != null) {
            this.E.setGravity(editText.getGravity());
            this.E.setPadding(this.f9424o.getCompoundPaddingLeft(), this.f9424o.getCompoundPaddingTop(), this.f9424o.getCompoundPaddingRight(), this.f9424o.getCompoundPaddingBottom());
        }
        aVar.m();
    }

    @Override // android.view.View
    public void onRestoreInstanceState(Parcelable parcelable) {
        if (!(parcelable instanceof h)) {
            super.onRestoreInstanceState(parcelable);
            return;
        }
        h hVar = (h) parcelable;
        super.onRestoreInstanceState(hVar.getSuperState());
        setError(hVar.f9454n);
        if (hVar.f9455o) {
            post(new b());
        }
        requestLayout();
    }

    @Override // android.widget.LinearLayout, android.view.View
    public void onRtlPropertiesChanged(int i10) {
        super.onRtlPropertiesChanged(i10);
        boolean z10 = i10 == 1;
        if (z10 != this.f9407a0) {
            q7.c topLeftCornerSize = this.W.getTopLeftCornerSize();
            RectF rectF = this.f9419l0;
            float cornerSize = topLeftCornerSize.getCornerSize(rectF);
            float cornerSize2 = this.W.getTopRightCornerSize().getCornerSize(rectF);
            l lVarBuild = l.builder().setTopLeftCorner(this.W.getTopRightCorner()).setTopRightCorner(this.W.getTopLeftCorner()).setBottomLeftCorner(this.W.getBottomRightCorner()).setBottomRightCorner(this.W.getBottomLeftCorner()).setTopLeftCornerSize(cornerSize2).setTopRightCornerSize(cornerSize).setBottomLeftCornerSize(this.W.getBottomRightCornerSize().getCornerSize(rectF)).setBottomRightCornerSize(this.W.getBottomLeftCornerSize().getCornerSize(rectF)).build();
            this.f9407a0 = z10;
            setShapeAppearanceModel(lVarBuild);
        }
    }

    @Override // android.view.View
    public Parcelable onSaveInstanceState() {
        h hVar = new h(super.onSaveInstanceState());
        if (m()) {
            hVar.f9454n = getError();
        }
        com.google.android.material.textfield.a aVar = this.f9422n;
        hVar.f9455o = (aVar.f9464t != 0) && aVar.f9462r.isChecked();
        return hVar;
    }

    public final void p() {
        ColorStateList colorStateList;
        ColorStateList colorStateListOrNull = this.L;
        if (colorStateListOrNull == null) {
            colorStateListOrNull = c7.a.getColorStateListOrNull(getContext(), R.attr.colorControlActivated);
        }
        EditText editText = this.f9424o;
        if (editText == null || editText.getTextCursorDrawable() == null) {
            return;
        }
        Drawable drawableMutate = p0.a.wrap(this.f9424o.getTextCursorDrawable()).mutate();
        if ((m() || (this.f9446z != null && this.f9442x)) && (colorStateList = this.M) != null) {
            colorStateListOrNull = colorStateList;
        }
        p0.a.setTintList(drawableMutate, colorStateListOrNull);
    }

    /* JADX WARN: Removed duplicated region for block: B:41:0x0099  */
    /* JADX WARN: Removed duplicated region for block: B:44:0x00a1  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public final boolean q() {
        /*
            Method dump skipped, instructions count: 326
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.material.textfield.TextInputLayout.q():boolean");
    }

    public final void r() {
        Drawable background;
        AppCompatTextView appCompatTextView;
        EditText editText = this.f9424o;
        if (editText == null || this.f9410c0 != 0 || (background = editText.getBackground()) == null) {
            return;
        }
        if (i0.canSafelyMutateDrawable(background)) {
            background = background.mutate();
        }
        if (m()) {
            background.setColorFilter(k.getPorterDuffColorFilter(getErrorCurrentTextColors(), PorterDuff.Mode.SRC_IN));
        } else if (this.f9442x && (appCompatTextView = this.f9446z) != null) {
            background.setColorFilter(k.getPorterDuffColorFilter(appCompatTextView.getCurrentTextColor(), PorterDuff.Mode.SRC_IN));
        } else {
            p0.a.clearColorFilter(background);
            this.f9424o.refreshDrawableState();
        }
    }

    public void refreshStartIconDrawableState() {
        s sVar = this.f9420m;
        m.c(sVar.f20609b, sVar.f20612o, sVar.f20613p);
    }

    public final void s() {
        EditText editText = this.f9424o;
        if (editText == null || this.Q == null) {
            return;
        }
        if ((this.T || editText.getBackground() == null) && this.f9410c0 != 0) {
            j0.setBackground(this.f9424o, getEditTextBoxBackground());
            this.T = true;
        }
    }

    public void setBoxBackgroundColor(int i10) {
        if (this.f9416i0 != i10) {
            this.f9416i0 = i10;
            this.f9447z0 = i10;
            this.B0 = i10;
            this.C0 = i10;
            b();
        }
    }

    public void setBoxBackgroundColorResource(int i10) {
        setBoxBackgroundColor(m0.a.getColor(getContext(), i10));
    }

    public void setBoxBackgroundColorStateList(ColorStateList colorStateList) {
        int defaultColor = colorStateList.getDefaultColor();
        this.f9447z0 = defaultColor;
        this.f9416i0 = defaultColor;
        this.A0 = colorStateList.getColorForState(new int[]{-16842910}, -1);
        this.B0 = colorStateList.getColorForState(new int[]{android.R.attr.state_focused, android.R.attr.state_enabled}, -1);
        this.C0 = colorStateList.getColorForState(new int[]{android.R.attr.state_hovered, android.R.attr.state_enabled}, -1);
        b();
    }

    public void setBoxBackgroundMode(int i10) {
        if (i10 == this.f9410c0) {
            return;
        }
        this.f9410c0 = i10;
        if (this.f9424o != null) {
            i();
        }
    }

    public void setBoxCollapsedPaddingTop(int i10) {
        this.f9411d0 = i10;
    }

    public void setBoxCornerFamily(int i10) {
        this.W = this.W.toBuilder().setTopLeftCorner(i10, this.W.getTopLeftCornerSize()).setTopRightCorner(i10, this.W.getTopRightCornerSize()).setBottomLeftCorner(i10, this.W.getBottomLeftCornerSize()).setBottomRightCorner(i10, this.W.getBottomRightCornerSize()).build();
        b();
    }

    public void setBoxStrokeColor(int i10) {
        if (this.f9443x0 != i10) {
            this.f9443x0 = i10;
            x();
        }
    }

    public void setBoxStrokeColorStateList(ColorStateList colorStateList) {
        if (colorStateList.isStateful()) {
            this.f9439v0 = colorStateList.getDefaultColor();
            this.D0 = colorStateList.getColorForState(new int[]{-16842910}, -1);
            this.f9441w0 = colorStateList.getColorForState(new int[]{android.R.attr.state_hovered, android.R.attr.state_enabled}, -1);
            this.f9443x0 = colorStateList.getColorForState(new int[]{android.R.attr.state_focused, android.R.attr.state_enabled}, -1);
        } else if (this.f9443x0 != colorStateList.getDefaultColor()) {
            this.f9443x0 = colorStateList.getDefaultColor();
        }
        x();
    }

    public void setBoxStrokeErrorColor(ColorStateList colorStateList) {
        if (this.f9445y0 != colorStateList) {
            this.f9445y0 = colorStateList;
            x();
        }
    }

    public void setBoxStrokeWidth(int i10) {
        this.f9413f0 = i10;
        x();
    }

    public void setBoxStrokeWidthFocused(int i10) {
        this.f9414g0 = i10;
        x();
    }

    public void setBoxStrokeWidthFocusedResource(int i10) {
        setBoxStrokeWidthFocused(getResources().getDimensionPixelSize(i10));
    }

    public void setBoxStrokeWidthResource(int i10) {
        setBoxStrokeWidth(getResources().getDimensionPixelSize(i10));
    }

    public void setCounterEnabled(boolean z10) throws NoSuchMethodException, SecurityException {
        if (this.f9438v != z10) {
            n nVar = this.f9436u;
            if (z10) {
                AppCompatTextView appCompatTextView = new AppCompatTextView(getContext());
                this.f9446z = appCompatTextView;
                appCompatTextView.setId(R.id.textinput_counter);
                Typeface typeface = this.f9421m0;
                if (typeface != null) {
                    this.f9446z.setTypeface(typeface);
                }
                this.f9446z.setMaxLines(1);
                nVar.a(this.f9446z, 2);
                x0.k.setMarginStart((ViewGroup.MarginLayoutParams) this.f9446z.getLayoutParams(), getResources().getDimensionPixelOffset(R.dimen.mtrl_textinput_counter_margin_start));
                o();
                if (this.f9446z != null) {
                    EditText editText = this.f9424o;
                    n(editText != null ? editText.getText() : null);
                }
            } else {
                nVar.g(this.f9446z, 2);
                this.f9446z = null;
            }
            this.f9438v = z10;
        }
    }

    public void setCounterMaxLength(int i10) throws NoSuchMethodException, SecurityException {
        if (this.f9440w != i10) {
            if (i10 > 0) {
                this.f9440w = i10;
            } else {
                this.f9440w = -1;
            }
            if (!this.f9438v || this.f9446z == null) {
                return;
            }
            EditText editText = this.f9424o;
            n(editText == null ? null : editText.getText());
        }
    }

    public void setCounterOverflowTextAppearance(int i10) {
        if (this.A != i10) {
            this.A = i10;
            o();
        }
    }

    public void setCounterOverflowTextColor(ColorStateList colorStateList) {
        if (this.K != colorStateList) {
            this.K = colorStateList;
            o();
        }
    }

    public void setCounterTextAppearance(int i10) {
        if (this.B != i10) {
            this.B = i10;
            o();
        }
    }

    public void setCounterTextColor(ColorStateList colorStateList) {
        if (this.J != colorStateList) {
            this.J = colorStateList;
            o();
        }
    }

    public void setCursorColor(ColorStateList colorStateList) {
        if (this.L != colorStateList) {
            this.L = colorStateList;
            p();
        }
    }

    public void setCursorErrorColor(ColorStateList colorStateList) {
        if (this.M != colorStateList) {
            this.M = colorStateList;
            if (m() || (this.f9446z != null && this.f9442x)) {
                p();
            }
        }
    }

    public void setDefaultHintTextColor(ColorStateList colorStateList) throws NoSuchMethodException, SecurityException {
        this.f9435t0 = colorStateList;
        this.f9437u0 = colorStateList;
        if (this.f9424o != null) {
            u(false, false);
        }
    }

    @Override // android.view.View
    public void setEnabled(boolean z10) {
        k(this, z10);
        super.setEnabled(z10);
    }

    public void setEndIconActivated(boolean z10) {
        this.f9422n.f9462r.setActivated(z10);
    }

    public void setEndIconCheckable(boolean z10) {
        this.f9422n.f9462r.setCheckable(z10);
    }

    public void setEndIconContentDescription(int i10) {
        com.google.android.material.textfield.a aVar = this.f9422n;
        CharSequence text = i10 != 0 ? aVar.getResources().getText(i10) : null;
        CheckableImageButton checkableImageButton = aVar.f9462r;
        if (checkableImageButton.getContentDescription() != text) {
            checkableImageButton.setContentDescription(text);
        }
    }

    public void setEndIconDrawable(int i10) {
        com.google.android.material.textfield.a aVar = this.f9422n;
        Drawable drawable = i10 != 0 ? s.a.getDrawable(aVar.getContext(), i10) : null;
        CheckableImageButton checkableImageButton = aVar.f9462r;
        checkableImageButton.setImageDrawable(drawable);
        if (drawable != null) {
            ColorStateList colorStateList = aVar.f9466v;
            PorterDuff.Mode mode = aVar.f9467w;
            TextInputLayout textInputLayout = aVar.f9456b;
            m.a(textInputLayout, checkableImageButton, colorStateList, mode);
            m.c(textInputLayout, checkableImageButton, aVar.f9466v);
        }
    }

    public void setEndIconMinSize(int i10) {
        com.google.android.material.textfield.a aVar = this.f9422n;
        if (i10 < 0) {
            aVar.getClass();
            throw new IllegalArgumentException("endIconSize cannot be less than 0");
        }
        if (i10 != aVar.f9468x) {
            aVar.f9468x = i10;
            CheckableImageButton checkableImageButton = aVar.f9462r;
            checkableImageButton.setMinimumWidth(i10);
            checkableImageButton.setMinimumHeight(i10);
            CheckableImageButton checkableImageButton2 = aVar.f9458n;
            checkableImageButton2.setMinimumWidth(i10);
            checkableImageButton2.setMinimumHeight(i10);
        }
    }

    public void setEndIconMode(int i10) {
        this.f9422n.g(i10);
    }

    public void setEndIconOnClickListener(View.OnClickListener onClickListener) {
        com.google.android.material.textfield.a aVar = this.f9422n;
        View.OnLongClickListener onLongClickListener = aVar.f9470z;
        CheckableImageButton checkableImageButton = aVar.f9462r;
        checkableImageButton.setOnClickListener(onClickListener);
        m.d(checkableImageButton, onLongClickListener);
    }

    public void setEndIconOnLongClickListener(View.OnLongClickListener onLongClickListener) {
        com.google.android.material.textfield.a aVar = this.f9422n;
        aVar.f9470z = onLongClickListener;
        CheckableImageButton checkableImageButton = aVar.f9462r;
        checkableImageButton.setOnLongClickListener(onLongClickListener);
        m.d(checkableImageButton, onLongClickListener);
    }

    public void setEndIconScaleType(ImageView.ScaleType scaleType) {
        com.google.android.material.textfield.a aVar = this.f9422n;
        aVar.f9469y = scaleType;
        aVar.f9462r.setScaleType(scaleType);
        aVar.f9458n.setScaleType(scaleType);
    }

    public void setEndIconTintList(ColorStateList colorStateList) {
        com.google.android.material.textfield.a aVar = this.f9422n;
        if (aVar.f9466v != colorStateList) {
            aVar.f9466v = colorStateList;
            m.a(aVar.f9456b, aVar.f9462r, colorStateList, aVar.f9467w);
        }
    }

    public void setEndIconTintMode(PorterDuff.Mode mode) {
        com.google.android.material.textfield.a aVar = this.f9422n;
        if (aVar.f9467w != mode) {
            aVar.f9467w = mode;
            m.a(aVar.f9456b, aVar.f9462r, aVar.f9466v, mode);
        }
    }

    public void setEndIconVisible(boolean z10) {
        this.f9422n.h(z10);
    }

    public void setError(CharSequence charSequence) {
        n nVar = this.f9436u;
        if (!nVar.f20578q) {
            if (TextUtils.isEmpty(charSequence)) {
                return;
            } else {
                setErrorEnabled(true);
            }
        }
        if (TextUtils.isEmpty(charSequence)) {
            nVar.f();
            return;
        }
        nVar.c();
        nVar.f20577p = charSequence;
        nVar.f20579r.setText(charSequence);
        int i10 = nVar.f20575n;
        if (i10 != 1) {
            nVar.f20576o = 1;
        }
        nVar.i(i10, nVar.f20576o, nVar.h(nVar.f20579r, charSequence));
    }

    public void setErrorAccessibilityLiveRegion(int i10) {
        n nVar = this.f9436u;
        nVar.f20581t = i10;
        AppCompatTextView appCompatTextView = nVar.f20579r;
        if (appCompatTextView != null) {
            j0.setAccessibilityLiveRegion(appCompatTextView, i10);
        }
    }

    public void setErrorContentDescription(CharSequence charSequence) {
        n nVar = this.f9436u;
        nVar.f20580s = charSequence;
        AppCompatTextView appCompatTextView = nVar.f20579r;
        if (appCompatTextView != null) {
            appCompatTextView.setContentDescription(charSequence);
        }
    }

    public void setErrorEnabled(boolean z10) {
        n nVar = this.f9436u;
        if (nVar.f20578q == z10) {
            return;
        }
        nVar.c();
        TextInputLayout textInputLayout = nVar.f20569h;
        if (z10) {
            AppCompatTextView appCompatTextView = new AppCompatTextView(nVar.f20568g);
            nVar.f20579r = appCompatTextView;
            appCompatTextView.setId(R.id.textinput_error);
            nVar.f20579r.setTextAlignment(5);
            Typeface typeface = nVar.B;
            if (typeface != null) {
                nVar.f20579r.setTypeface(typeface);
            }
            int i10 = nVar.f20582u;
            nVar.f20582u = i10;
            AppCompatTextView appCompatTextView2 = nVar.f20579r;
            if (appCompatTextView2 != null) {
                textInputLayout.l(appCompatTextView2, i10);
            }
            ColorStateList colorStateList = nVar.f20583v;
            nVar.f20583v = colorStateList;
            AppCompatTextView appCompatTextView3 = nVar.f20579r;
            if (appCompatTextView3 != null && colorStateList != null) {
                appCompatTextView3.setTextColor(colorStateList);
            }
            CharSequence charSequence = nVar.f20580s;
            nVar.f20580s = charSequence;
            AppCompatTextView appCompatTextView4 = nVar.f20579r;
            if (appCompatTextView4 != null) {
                appCompatTextView4.setContentDescription(charSequence);
            }
            int i11 = nVar.f20581t;
            nVar.f20581t = i11;
            AppCompatTextView appCompatTextView5 = nVar.f20579r;
            if (appCompatTextView5 != null) {
                j0.setAccessibilityLiveRegion(appCompatTextView5, i11);
            }
            nVar.f20579r.setVisibility(4);
            nVar.a(nVar.f20579r, 0);
        } else {
            nVar.f();
            nVar.g(nVar.f20579r, 0);
            nVar.f20579r = null;
            textInputLayout.r();
            textInputLayout.x();
        }
        nVar.f20578q = z10;
    }

    public void setErrorIconDrawable(int i10) {
        com.google.android.material.textfield.a aVar = this.f9422n;
        aVar.i(i10 != 0 ? s.a.getDrawable(aVar.getContext(), i10) : null);
        m.c(aVar.f9456b, aVar.f9458n, aVar.f9459o);
    }

    public void setErrorIconOnClickListener(View.OnClickListener onClickListener) {
        com.google.android.material.textfield.a aVar = this.f9422n;
        CheckableImageButton checkableImageButton = aVar.f9458n;
        View.OnLongClickListener onLongClickListener = aVar.f9461q;
        checkableImageButton.setOnClickListener(onClickListener);
        m.d(checkableImageButton, onLongClickListener);
    }

    public void setErrorIconOnLongClickListener(View.OnLongClickListener onLongClickListener) {
        com.google.android.material.textfield.a aVar = this.f9422n;
        aVar.f9461q = onLongClickListener;
        CheckableImageButton checkableImageButton = aVar.f9458n;
        checkableImageButton.setOnLongClickListener(onLongClickListener);
        m.d(checkableImageButton, onLongClickListener);
    }

    public void setErrorIconTintList(ColorStateList colorStateList) {
        com.google.android.material.textfield.a aVar = this.f9422n;
        if (aVar.f9459o != colorStateList) {
            aVar.f9459o = colorStateList;
            m.a(aVar.f9456b, aVar.f9458n, colorStateList, aVar.f9460p);
        }
    }

    public void setErrorIconTintMode(PorterDuff.Mode mode) {
        com.google.android.material.textfield.a aVar = this.f9422n;
        if (aVar.f9460p != mode) {
            aVar.f9460p = mode;
            m.a(aVar.f9456b, aVar.f9458n, aVar.f9459o, mode);
        }
    }

    public void setErrorTextAppearance(int i10) {
        n nVar = this.f9436u;
        nVar.f20582u = i10;
        AppCompatTextView appCompatTextView = nVar.f20579r;
        if (appCompatTextView != null) {
            nVar.f20569h.l(appCompatTextView, i10);
        }
    }

    public void setErrorTextColor(ColorStateList colorStateList) {
        n nVar = this.f9436u;
        nVar.f20583v = colorStateList;
        AppCompatTextView appCompatTextView = nVar.f20579r;
        if (appCompatTextView == null || colorStateList == null) {
            return;
        }
        appCompatTextView.setTextColor(colorStateList);
    }

    public void setExpandedHintEnabled(boolean z10) throws NoSuchMethodException, SecurityException {
        if (this.H0 != z10) {
            this.H0 = z10;
            u(false, false);
        }
    }

    public void setHelperText(CharSequence charSequence) {
        if (TextUtils.isEmpty(charSequence)) {
            if (isHelperTextEnabled()) {
                setHelperTextEnabled(false);
                return;
            }
            return;
        }
        if (!isHelperTextEnabled()) {
            setHelperTextEnabled(true);
        }
        n nVar = this.f9436u;
        nVar.c();
        nVar.f20584w = charSequence;
        nVar.f20586y.setText(charSequence);
        int i10 = nVar.f20575n;
        if (i10 != 2) {
            nVar.f20576o = 2;
        }
        nVar.i(i10, nVar.f20576o, nVar.h(nVar.f20586y, charSequence));
    }

    public void setHelperTextColor(ColorStateList colorStateList) {
        n nVar = this.f9436u;
        nVar.A = colorStateList;
        AppCompatTextView appCompatTextView = nVar.f20586y;
        if (appCompatTextView == null || colorStateList == null) {
            return;
        }
        appCompatTextView.setTextColor(colorStateList);
    }

    public void setHelperTextEnabled(boolean z10) {
        n nVar = this.f9436u;
        if (nVar.f20585x == z10) {
            return;
        }
        nVar.c();
        if (z10) {
            AppCompatTextView appCompatTextView = new AppCompatTextView(nVar.f20568g);
            nVar.f20586y = appCompatTextView;
            appCompatTextView.setId(R.id.textinput_helper_text);
            nVar.f20586y.setTextAlignment(5);
            Typeface typeface = nVar.B;
            if (typeface != null) {
                nVar.f20586y.setTypeface(typeface);
            }
            nVar.f20586y.setVisibility(4);
            j0.setAccessibilityLiveRegion(nVar.f20586y, 1);
            int i10 = nVar.f20587z;
            nVar.f20587z = i10;
            AppCompatTextView appCompatTextView2 = nVar.f20586y;
            if (appCompatTextView2 != null) {
                i.setTextAppearance(appCompatTextView2, i10);
            }
            ColorStateList colorStateList = nVar.A;
            nVar.A = colorStateList;
            AppCompatTextView appCompatTextView3 = nVar.f20586y;
            if (appCompatTextView3 != null && colorStateList != null) {
                appCompatTextView3.setTextColor(colorStateList);
            }
            nVar.a(nVar.f20586y, 1);
            nVar.f20586y.setAccessibilityDelegate(new o(nVar));
        } else {
            nVar.c();
            int i11 = nVar.f20575n;
            if (i11 == 2) {
                nVar.f20576o = 0;
            }
            nVar.i(i11, nVar.f20576o, nVar.h(nVar.f20586y, ""));
            nVar.g(nVar.f20586y, 1);
            nVar.f20586y = null;
            TextInputLayout textInputLayout = nVar.f20569h;
            textInputLayout.r();
            textInputLayout.x();
        }
        nVar.f20585x = z10;
    }

    public void setHelperTextTextAppearance(int i10) {
        n nVar = this.f9436u;
        nVar.f20587z = i10;
        AppCompatTextView appCompatTextView = nVar.f20586y;
        if (appCompatTextView != null) {
            i.setTextAppearance(appCompatTextView, i10);
        }
    }

    public void setHint(CharSequence charSequence) throws NoSuchMethodException, SecurityException {
        if (this.N) {
            setHintInternal(charSequence);
            sendAccessibilityEvent(2048);
        }
    }

    public void setHintAnimationEnabled(boolean z10) {
        this.I0 = z10;
    }

    public void setHintEnabled(boolean z10) throws NoSuchMethodException, SecurityException {
        if (z10 != this.N) {
            this.N = z10;
            if (z10) {
                CharSequence hint = this.f9424o.getHint();
                if (!TextUtils.isEmpty(hint)) {
                    if (TextUtils.isEmpty(this.O)) {
                        setHint(hint);
                    }
                    this.f9424o.setHint((CharSequence) null);
                }
                this.P = true;
            } else {
                this.P = false;
                if (!TextUtils.isEmpty(this.O) && TextUtils.isEmpty(this.f9424o.getHint())) {
                    this.f9424o.setHint(this.O);
                }
                setHintInternal(null);
            }
            if (this.f9424o != null) {
                t();
            }
        }
    }

    public void setHintTextAppearance(int i10) throws NoSuchMethodException, SecurityException {
        com.google.android.material.internal.a aVar = this.G0;
        aVar.setCollapsedTextAppearance(i10);
        this.f9437u0 = aVar.getCollapsedTextColor();
        if (this.f9424o != null) {
            u(false, false);
            t();
        }
    }

    public void setHintTextColor(ColorStateList colorStateList) throws NoSuchMethodException, SecurityException {
        if (this.f9437u0 != colorStateList) {
            if (this.f9435t0 == null) {
                this.G0.setCollapsedTextColor(colorStateList);
            }
            this.f9437u0 = colorStateList;
            if (this.f9424o != null) {
                u(false, false);
            }
        }
    }

    public void setLengthCounter(e eVar) {
        this.f9444y = eVar;
    }

    public void setMaxEms(int i10) {
        this.f9430r = i10;
        EditText editText = this.f9424o;
        if (editText == null || i10 == -1) {
            return;
        }
        editText.setMaxEms(i10);
    }

    public void setMaxWidth(int i10) {
        this.f9434t = i10;
        EditText editText = this.f9424o;
        if (editText == null || i10 == -1) {
            return;
        }
        editText.setMaxWidth(i10);
    }

    public void setMaxWidthResource(int i10) {
        setMaxWidth(getContext().getResources().getDimensionPixelSize(i10));
    }

    public void setMinEms(int i10) {
        this.f9428q = i10;
        EditText editText = this.f9424o;
        if (editText == null || i10 == -1) {
            return;
        }
        editText.setMinEms(i10);
    }

    public void setMinWidth(int i10) {
        this.f9432s = i10;
        EditText editText = this.f9424o;
        if (editText == null || i10 == -1) {
            return;
        }
        editText.setMinWidth(i10);
    }

    public void setMinWidthResource(int i10) {
        setMinWidth(getContext().getResources().getDimensionPixelSize(i10));
    }

    @Deprecated
    public void setPasswordVisibilityToggleContentDescription(int i10) {
        com.google.android.material.textfield.a aVar = this.f9422n;
        aVar.f9462r.setContentDescription(i10 != 0 ? aVar.getResources().getText(i10) : null);
    }

    @Deprecated
    public void setPasswordVisibilityToggleDrawable(int i10) {
        com.google.android.material.textfield.a aVar = this.f9422n;
        aVar.f9462r.setImageDrawable(i10 != 0 ? s.a.getDrawable(aVar.getContext(), i10) : null);
    }

    @Deprecated
    public void setPasswordVisibilityToggleEnabled(boolean z10) {
        com.google.android.material.textfield.a aVar = this.f9422n;
        if (z10 && aVar.f9464t != 1) {
            aVar.g(1);
        } else if (z10) {
            aVar.getClass();
        } else {
            aVar.g(0);
        }
    }

    @Deprecated
    public void setPasswordVisibilityToggleTintList(ColorStateList colorStateList) {
        com.google.android.material.textfield.a aVar = this.f9422n;
        aVar.f9466v = colorStateList;
        m.a(aVar.f9456b, aVar.f9462r, colorStateList, aVar.f9467w);
    }

    @Deprecated
    public void setPasswordVisibilityToggleTintMode(PorterDuff.Mode mode) {
        com.google.android.material.textfield.a aVar = this.f9422n;
        aVar.f9467w = mode;
        m.a(aVar.f9456b, aVar.f9462r, aVar.f9466v, mode);
    }

    public void setPlaceholderText(CharSequence charSequence) {
        if (this.E == null) {
            AppCompatTextView appCompatTextView = new AppCompatTextView(getContext());
            this.E = appCompatTextView;
            appCompatTextView.setId(R.id.textinput_placeholder);
            j0.setImportantForAccessibility(this.E, 2);
            androidx.transition.b bVarD = d();
            this.H = bVarD;
            bVarD.setStartDelay(67L);
            this.I = d();
            setPlaceholderTextAppearance(this.G);
            setPlaceholderTextColor(this.F);
        }
        if (TextUtils.isEmpty(charSequence)) {
            setPlaceholderTextEnabled(false);
        } else {
            if (!this.D) {
                setPlaceholderTextEnabled(true);
            }
            this.C = charSequence;
        }
        EditText editText = this.f9424o;
        v(editText == null ? null : editText.getText());
    }

    public void setPlaceholderTextAppearance(int i10) {
        this.G = i10;
        AppCompatTextView appCompatTextView = this.E;
        if (appCompatTextView != null) {
            i.setTextAppearance(appCompatTextView, i10);
        }
    }

    public void setPlaceholderTextColor(ColorStateList colorStateList) {
        if (this.F != colorStateList) {
            this.F = colorStateList;
            AppCompatTextView appCompatTextView = this.E;
            if (appCompatTextView == null || colorStateList == null) {
                return;
            }
            appCompatTextView.setTextColor(colorStateList);
        }
    }

    public void setPrefixText(CharSequence charSequence) {
        s sVar = this.f9420m;
        sVar.getClass();
        sVar.f20611n = TextUtils.isEmpty(charSequence) ? null : charSequence;
        sVar.f20610m.setText(charSequence);
        sVar.e();
    }

    public void setPrefixTextAppearance(int i10) {
        i.setTextAppearance(this.f9420m.f20610m, i10);
    }

    public void setPrefixTextColor(ColorStateList colorStateList) {
        this.f9420m.f20610m.setTextColor(colorStateList);
    }

    public void setShapeAppearanceModel(l lVar) {
        q7.g gVar = this.Q;
        if (gVar == null || gVar.getShapeAppearanceModel() == lVar) {
            return;
        }
        this.W = lVar;
        b();
    }

    public void setStartIconCheckable(boolean z10) {
        this.f9420m.f20612o.setCheckable(z10);
    }

    public void setStartIconContentDescription(CharSequence charSequence) {
        CheckableImageButton checkableImageButton = this.f9420m.f20612o;
        if (checkableImageButton.getContentDescription() != charSequence) {
            checkableImageButton.setContentDescription(charSequence);
        }
    }

    public void setStartIconDrawable(int i10) {
        setStartIconDrawable(i10 != 0 ? s.a.getDrawable(getContext(), i10) : null);
    }

    public void setStartIconMinSize(int i10) {
        s sVar = this.f9420m;
        if (i10 < 0) {
            sVar.getClass();
            throw new IllegalArgumentException("startIconSize cannot be less than 0");
        }
        if (i10 != sVar.f20615r) {
            sVar.f20615r = i10;
            CheckableImageButton checkableImageButton = sVar.f20612o;
            checkableImageButton.setMinimumWidth(i10);
            checkableImageButton.setMinimumHeight(i10);
        }
    }

    public void setStartIconOnClickListener(View.OnClickListener onClickListener) {
        s sVar = this.f9420m;
        View.OnLongClickListener onLongClickListener = sVar.f20617t;
        CheckableImageButton checkableImageButton = sVar.f20612o;
        checkableImageButton.setOnClickListener(onClickListener);
        m.d(checkableImageButton, onLongClickListener);
    }

    public void setStartIconOnLongClickListener(View.OnLongClickListener onLongClickListener) {
        s sVar = this.f9420m;
        sVar.f20617t = onLongClickListener;
        CheckableImageButton checkableImageButton = sVar.f20612o;
        checkableImageButton.setOnLongClickListener(onLongClickListener);
        m.d(checkableImageButton, onLongClickListener);
    }

    public void setStartIconScaleType(ImageView.ScaleType scaleType) {
        s sVar = this.f9420m;
        sVar.f20616s = scaleType;
        sVar.f20612o.setScaleType(scaleType);
    }

    public void setStartIconTintList(ColorStateList colorStateList) {
        s sVar = this.f9420m;
        if (sVar.f20613p != colorStateList) {
            sVar.f20613p = colorStateList;
            m.a(sVar.f20609b, sVar.f20612o, colorStateList, sVar.f20614q);
        }
    }

    public void setStartIconTintMode(PorterDuff.Mode mode) {
        s sVar = this.f9420m;
        if (sVar.f20614q != mode) {
            sVar.f20614q = mode;
            m.a(sVar.f20609b, sVar.f20612o, sVar.f20613p, mode);
        }
    }

    public void setStartIconVisible(boolean z10) {
        this.f9420m.c(z10);
    }

    public void setSuffixText(CharSequence charSequence) {
        com.google.android.material.textfield.a aVar = this.f9422n;
        aVar.getClass();
        aVar.A = TextUtils.isEmpty(charSequence) ? null : charSequence;
        aVar.B.setText(charSequence);
        aVar.n();
    }

    public void setSuffixTextAppearance(int i10) {
        i.setTextAppearance(this.f9422n.B, i10);
    }

    public void setSuffixTextColor(ColorStateList colorStateList) {
        this.f9422n.B.setTextColor(colorStateList);
    }

    public void setTextInputAccessibilityDelegate(d dVar) {
        EditText editText = this.f9424o;
        if (editText != null) {
            j0.setAccessibilityDelegate(editText, dVar);
        }
    }

    public void setTypeface(Typeface typeface) throws NoSuchMethodException, SecurityException {
        if (typeface != this.f9421m0) {
            this.f9421m0 = typeface;
            this.G0.setTypefaces(typeface);
            n nVar = this.f9436u;
            if (typeface != nVar.B) {
                nVar.B = typeface;
                AppCompatTextView appCompatTextView = nVar.f20579r;
                if (appCompatTextView != null) {
                    appCompatTextView.setTypeface(typeface);
                }
                AppCompatTextView appCompatTextView2 = nVar.f20586y;
                if (appCompatTextView2 != null) {
                    appCompatTextView2.setTypeface(typeface);
                }
            }
            AppCompatTextView appCompatTextView3 = this.f9446z;
            if (appCompatTextView3 != null) {
                appCompatTextView3.setTypeface(typeface);
            }
        }
    }

    public final void t() {
        if (this.f9410c0 != 1) {
            FrameLayout frameLayout = this.f9408b;
            LinearLayout.LayoutParams layoutParams = (LinearLayout.LayoutParams) frameLayout.getLayoutParams();
            int iC = c();
            if (iC != layoutParams.topMargin) {
                layoutParams.topMargin = iC;
                frameLayout.requestLayout();
            }
        }
    }

    public final void u(boolean z10, boolean z11) throws NoSuchMethodException, SecurityException {
        ColorStateList colorStateList;
        AppCompatTextView appCompatTextView;
        boolean zIsEnabled = isEnabled();
        EditText editText = this.f9424o;
        boolean z12 = (editText == null || TextUtils.isEmpty(editText.getText())) ? false : true;
        EditText editText2 = this.f9424o;
        boolean z13 = editText2 != null && editText2.hasFocus();
        ColorStateList colorStateList2 = this.f9435t0;
        com.google.android.material.internal.a aVar = this.G0;
        if (colorStateList2 != null) {
            aVar.setCollapsedAndExpandedTextColor(colorStateList2);
        }
        if (!zIsEnabled) {
            ColorStateList colorStateList3 = this.f9435t0;
            aVar.setCollapsedAndExpandedTextColor(ColorStateList.valueOf(colorStateList3 != null ? colorStateList3.getColorForState(new int[]{-16842910}, this.D0) : this.D0));
        } else if (m()) {
            AppCompatTextView appCompatTextView2 = this.f9436u.f20579r;
            aVar.setCollapsedAndExpandedTextColor(appCompatTextView2 != null ? appCompatTextView2.getTextColors() : null);
        } else if (this.f9442x && (appCompatTextView = this.f9446z) != null) {
            aVar.setCollapsedAndExpandedTextColor(appCompatTextView.getTextColors());
        } else if (z13 && (colorStateList = this.f9437u0) != null) {
            aVar.setCollapsedTextColor(colorStateList);
        }
        com.google.android.material.textfield.a aVar2 = this.f9422n;
        s sVar = this.f9420m;
        if (z12 || !this.H0 || (isEnabled() && z13)) {
            if (z11 || this.F0) {
                ValueAnimator valueAnimator = this.J0;
                if (valueAnimator != null && valueAnimator.isRunning()) {
                    this.J0.cancel();
                }
                if (z10 && this.I0) {
                    a(1.0f);
                } else {
                    aVar.setExpansionFraction(1.0f);
                }
                this.F0 = false;
                if (e()) {
                    j();
                }
                EditText editText3 = this.f9424o;
                v(editText3 != null ? editText3.getText() : null);
                sVar.f20618u = false;
                sVar.e();
                aVar2.C = false;
                aVar2.n();
                return;
            }
            return;
        }
        if (z11 || !this.F0) {
            ValueAnimator valueAnimator2 = this.J0;
            if (valueAnimator2 != null && valueAnimator2.isRunning()) {
                this.J0.cancel();
            }
            if (z10 && this.I0) {
                a(0.0f);
            } else {
                aVar.setExpansionFraction(0.0f);
            }
            if (e() && (!((v7.g) this.Q).J.f20540v.isEmpty()) && e()) {
                ((v7.g) this.Q).h(0.0f, 0.0f, 0.0f, 0.0f);
            }
            this.F0 = true;
            AppCompatTextView appCompatTextView3 = this.E;
            if (appCompatTextView3 != null && this.D) {
                appCompatTextView3.setText((CharSequence) null);
                androidx.transition.g.beginDelayedTransition(this.f9408b, this.I);
                this.E.setVisibility(4);
            }
            sVar.f20618u = true;
            sVar.e();
            aVar2.C = true;
            aVar2.n();
        }
    }

    public final void v(Editable editable) {
        int iB = ((pd.a) this.f9444y).b(editable);
        FrameLayout frameLayout = this.f9408b;
        if (iB != 0 || this.F0) {
            AppCompatTextView appCompatTextView = this.E;
            if (appCompatTextView == null || !this.D) {
                return;
            }
            appCompatTextView.setText((CharSequence) null);
            androidx.transition.g.beginDelayedTransition(frameLayout, this.I);
            this.E.setVisibility(4);
            return;
        }
        if (this.E == null || !this.D || TextUtils.isEmpty(this.C)) {
            return;
        }
        this.E.setText(this.C);
        androidx.transition.g.beginDelayedTransition(frameLayout, this.H);
        this.E.setVisibility(0);
        this.E.bringToFront();
        announceForAccessibility(this.C);
    }

    public final void w(boolean z10, boolean z11) {
        int defaultColor = this.f9445y0.getDefaultColor();
        int colorForState = this.f9445y0.getColorForState(new int[]{android.R.attr.state_hovered, android.R.attr.state_enabled}, defaultColor);
        int colorForState2 = this.f9445y0.getColorForState(new int[]{android.R.attr.state_activated, android.R.attr.state_enabled}, defaultColor);
        if (z10) {
            this.f9415h0 = colorForState2;
        } else if (z11) {
            this.f9415h0 = colorForState;
        } else {
            this.f9415h0 = defaultColor;
        }
    }

    public final void x() {
        AppCompatTextView appCompatTextView;
        EditText editText;
        EditText editText2;
        if (this.Q == null || this.f9410c0 == 0) {
            return;
        }
        boolean z10 = false;
        boolean z11 = isFocused() || ((editText2 = this.f9424o) != null && editText2.hasFocus());
        if (isHovered() || ((editText = this.f9424o) != null && editText.isHovered())) {
            z10 = true;
        }
        if (!isEnabled()) {
            this.f9415h0 = this.D0;
        } else if (m()) {
            if (this.f9445y0 != null) {
                w(z11, z10);
            } else {
                this.f9415h0 = getErrorCurrentTextColors();
            }
        } else if (!this.f9442x || (appCompatTextView = this.f9446z) == null) {
            if (z11) {
                this.f9415h0 = this.f9443x0;
            } else if (z10) {
                this.f9415h0 = this.f9441w0;
            } else {
                this.f9415h0 = this.f9439v0;
            }
        } else if (this.f9445y0 != null) {
            w(z11, z10);
        } else {
            this.f9415h0 = appCompatTextView.getCurrentTextColor();
        }
        if (Build.VERSION.SDK_INT >= 29) {
            p();
        }
        com.google.android.material.textfield.a aVar = this.f9422n;
        aVar.l();
        CheckableImageButton checkableImageButton = aVar.f9458n;
        ColorStateList colorStateList = aVar.f9459o;
        TextInputLayout textInputLayout = aVar.f9456b;
        m.c(textInputLayout, checkableImageButton, colorStateList);
        ColorStateList colorStateList2 = aVar.f9466v;
        CheckableImageButton checkableImageButton2 = aVar.f9462r;
        m.c(textInputLayout, checkableImageButton2, colorStateList2);
        if (aVar.b() instanceof v7.k) {
            if (!textInputLayout.m() || checkableImageButton2.getDrawable() == null) {
                m.a(textInputLayout, checkableImageButton2, aVar.f9466v, aVar.f9467w);
            } else {
                Drawable drawableMutate = p0.a.wrap(checkableImageButton2.getDrawable()).mutate();
                p0.a.setTint(drawableMutate, textInputLayout.getErrorCurrentTextColors());
                checkableImageButton2.setImageDrawable(drawableMutate);
            }
        }
        refreshStartIconDrawableState();
        if (this.f9410c0 == 2) {
            int i10 = this.f9412e0;
            if (z11 && isEnabled()) {
                this.f9412e0 = this.f9414g0;
            } else {
                this.f9412e0 = this.f9413f0;
            }
            if (this.f9412e0 != i10 && e() && !this.F0) {
                if (e()) {
                    ((v7.g) this.Q).h(0.0f, 0.0f, 0.0f, 0.0f);
                }
                j();
            }
        }
        if (this.f9410c0 == 1) {
            if (!isEnabled()) {
                this.f9416i0 = this.A0;
            } else if (z10 && !z11) {
                this.f9416i0 = this.C0;
            } else if (z11) {
                this.f9416i0 = this.B0;
            } else {
                this.f9416i0 = this.f9447z0;
            }
        }
        b();
    }

    /* JADX WARN: Illegal instructions before constructor call */
    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r3v45 */
    /* JADX WARN: Type inference failed for: r3v46, types: [boolean, int] */
    /* JADX WARN: Type inference failed for: r3v66 */
    public TextInputLayout(Context context, AttributeSet attributeSet, int i10) throws NoSuchMethodException, SecurityException {
        ?? r32;
        int i11 = N0;
        super(x7.a.wrap(context, attributeSet, i10, i11), attributeSet, i10);
        this.f9428q = -1;
        this.f9430r = -1;
        this.f9432s = -1;
        this.f9434t = -1;
        this.f9436u = new n(this);
        this.f9444y = new pd.a(19);
        this.f9417j0 = new Rect();
        this.f9418k0 = new Rect();
        this.f9419l0 = new RectF();
        this.f9427p0 = new LinkedHashSet<>();
        com.google.android.material.internal.a aVar = new com.google.android.material.internal.a(this);
        this.G0 = aVar;
        this.M0 = false;
        Context context2 = getContext();
        setOrientation(1);
        setWillNotDraw(false);
        setAddStatesFromChildren(true);
        FrameLayout frameLayout = new FrameLayout(context2);
        this.f9408b = frameLayout;
        frameLayout.setAddStatesFromChildren(true);
        LinearInterpolator linearInterpolator = p6.a.f17604a;
        aVar.setTextSizeInterpolator(linearInterpolator);
        aVar.setPositionInterpolator(linearInterpolator);
        aVar.setCollapsedTextGravity(8388659);
        int[] iArr = R.styleable.TextInputLayout;
        int i12 = R.styleable.TextInputLayout_counterTextAppearance;
        int i13 = R.styleable.TextInputLayout_counterOverflowTextAppearance;
        int i14 = R.styleable.TextInputLayout_errorTextAppearance;
        int i15 = R.styleable.TextInputLayout_helperTextTextAppearance;
        int i16 = R.styleable.TextInputLayout_hintTextAppearance;
        c1 c1VarObtainTintedStyledAttributes = r.obtainTintedStyledAttributes(context2, attributeSet, iArr, i10, i11, i12, i13, i14, i15, i16);
        s sVar = new s(this, c1VarObtainTintedStyledAttributes);
        this.f9420m = sVar;
        this.N = c1VarObtainTintedStyledAttributes.getBoolean(R.styleable.TextInputLayout_hintEnabled, true);
        setHint(c1VarObtainTintedStyledAttributes.getText(R.styleable.TextInputLayout_android_hint));
        this.I0 = c1VarObtainTintedStyledAttributes.getBoolean(R.styleable.TextInputLayout_hintAnimationEnabled, true);
        this.H0 = c1VarObtainTintedStyledAttributes.getBoolean(R.styleable.TextInputLayout_expandedHintEnabled, true);
        int i17 = R.styleable.TextInputLayout_android_minEms;
        if (c1VarObtainTintedStyledAttributes.hasValue(i17)) {
            setMinEms(c1VarObtainTintedStyledAttributes.getInt(i17, -1));
        } else {
            int i18 = R.styleable.TextInputLayout_android_minWidth;
            if (c1VarObtainTintedStyledAttributes.hasValue(i18)) {
                setMinWidth(c1VarObtainTintedStyledAttributes.getDimensionPixelSize(i18, -1));
            }
        }
        int i19 = R.styleable.TextInputLayout_android_maxEms;
        if (c1VarObtainTintedStyledAttributes.hasValue(i19)) {
            setMaxEms(c1VarObtainTintedStyledAttributes.getInt(i19, -1));
        } else {
            int i20 = R.styleable.TextInputLayout_android_maxWidth;
            if (c1VarObtainTintedStyledAttributes.hasValue(i20)) {
                setMaxWidth(c1VarObtainTintedStyledAttributes.getDimensionPixelSize(i20, -1));
            }
        }
        this.W = l.builder(context2, attributeSet, i10, i11).build();
        this.f9409b0 = context2.getResources().getDimensionPixelOffset(R.dimen.mtrl_textinput_box_label_cutout_padding);
        this.f9411d0 = c1VarObtainTintedStyledAttributes.getDimensionPixelOffset(R.styleable.TextInputLayout_boxCollapsedPaddingTop, 0);
        this.f9413f0 = c1VarObtainTintedStyledAttributes.getDimensionPixelSize(R.styleable.TextInputLayout_boxStrokeWidth, context2.getResources().getDimensionPixelSize(R.dimen.mtrl_textinput_box_stroke_width_default));
        this.f9414g0 = c1VarObtainTintedStyledAttributes.getDimensionPixelSize(R.styleable.TextInputLayout_boxStrokeWidthFocused, context2.getResources().getDimensionPixelSize(R.dimen.mtrl_textinput_box_stroke_width_focused));
        this.f9412e0 = this.f9413f0;
        float dimension = c1VarObtainTintedStyledAttributes.getDimension(R.styleable.TextInputLayout_boxCornerRadiusTopStart, -1.0f);
        float dimension2 = c1VarObtainTintedStyledAttributes.getDimension(R.styleable.TextInputLayout_boxCornerRadiusTopEnd, -1.0f);
        float dimension3 = c1VarObtainTintedStyledAttributes.getDimension(R.styleable.TextInputLayout_boxCornerRadiusBottomEnd, -1.0f);
        float dimension4 = c1VarObtainTintedStyledAttributes.getDimension(R.styleable.TextInputLayout_boxCornerRadiusBottomStart, -1.0f);
        l.a builder = this.W.toBuilder();
        if (dimension >= 0.0f) {
            builder.setTopLeftCornerSize(dimension);
        }
        if (dimension2 >= 0.0f) {
            builder.setTopRightCornerSize(dimension2);
        }
        if (dimension3 >= 0.0f) {
            builder.setBottomRightCornerSize(dimension3);
        }
        if (dimension4 >= 0.0f) {
            builder.setBottomLeftCornerSize(dimension4);
        }
        this.W = builder.build();
        ColorStateList colorStateList = n7.c.getColorStateList(context2, c1VarObtainTintedStyledAttributes, R.styleable.TextInputLayout_boxBackgroundColor);
        if (colorStateList != null) {
            int defaultColor = colorStateList.getDefaultColor();
            this.f9447z0 = defaultColor;
            this.f9416i0 = defaultColor;
            if (colorStateList.isStateful()) {
                this.A0 = colorStateList.getColorForState(new int[]{-16842910}, -1);
                this.B0 = colorStateList.getColorForState(new int[]{android.R.attr.state_focused, android.R.attr.state_enabled}, -1);
                this.C0 = colorStateList.getColorForState(new int[]{android.R.attr.state_hovered, android.R.attr.state_enabled}, -1);
            } else {
                this.B0 = this.f9447z0;
                ColorStateList colorStateList2 = s.a.getColorStateList(context2, R.color.mtrl_filled_background_color);
                this.A0 = colorStateList2.getColorForState(new int[]{-16842910}, -1);
                this.C0 = colorStateList2.getColorForState(new int[]{android.R.attr.state_hovered}, -1);
            }
        } else {
            this.f9416i0 = 0;
            this.f9447z0 = 0;
            this.A0 = 0;
            this.B0 = 0;
            this.C0 = 0;
        }
        int i21 = R.styleable.TextInputLayout_android_textColorHint;
        if (c1VarObtainTintedStyledAttributes.hasValue(i21)) {
            ColorStateList colorStateList3 = c1VarObtainTintedStyledAttributes.getColorStateList(i21);
            this.f9437u0 = colorStateList3;
            this.f9435t0 = colorStateList3;
        }
        int i22 = R.styleable.TextInputLayout_boxStrokeColor;
        ColorStateList colorStateList4 = n7.c.getColorStateList(context2, c1VarObtainTintedStyledAttributes, i22);
        this.f9443x0 = c1VarObtainTintedStyledAttributes.getColor(i22, 0);
        this.f9439v0 = m0.a.getColor(context2, R.color.mtrl_textinput_default_box_stroke_color);
        this.D0 = m0.a.getColor(context2, R.color.mtrl_textinput_disabled_color);
        this.f9441w0 = m0.a.getColor(context2, R.color.mtrl_textinput_hovered_box_stroke_color);
        if (colorStateList4 != null) {
            setBoxStrokeColorStateList(colorStateList4);
        }
        int i23 = R.styleable.TextInputLayout_boxStrokeErrorColor;
        if (c1VarObtainTintedStyledAttributes.hasValue(i23)) {
            setBoxStrokeErrorColor(n7.c.getColorStateList(context2, c1VarObtainTintedStyledAttributes, i23));
        }
        if (c1VarObtainTintedStyledAttributes.getResourceId(i16, -1) != -1) {
            r32 = 0;
            setHintTextAppearance(c1VarObtainTintedStyledAttributes.getResourceId(i16, 0));
        } else {
            r32 = 0;
        }
        this.L = c1VarObtainTintedStyledAttributes.getColorStateList(R.styleable.TextInputLayout_cursorColor);
        this.M = c1VarObtainTintedStyledAttributes.getColorStateList(R.styleable.TextInputLayout_cursorErrorColor);
        int resourceId = c1VarObtainTintedStyledAttributes.getResourceId(i14, r32);
        CharSequence text = c1VarObtainTintedStyledAttributes.getText(R.styleable.TextInputLayout_errorContentDescription);
        int i24 = c1VarObtainTintedStyledAttributes.getInt(R.styleable.TextInputLayout_errorAccessibilityLiveRegion, 1);
        boolean z10 = c1VarObtainTintedStyledAttributes.getBoolean(R.styleable.TextInputLayout_errorEnabled, r32);
        int resourceId2 = c1VarObtainTintedStyledAttributes.getResourceId(i15, r32);
        boolean z11 = c1VarObtainTintedStyledAttributes.getBoolean(R.styleable.TextInputLayout_helperTextEnabled, r32);
        CharSequence text2 = c1VarObtainTintedStyledAttributes.getText(R.styleable.TextInputLayout_helperText);
        int resourceId3 = c1VarObtainTintedStyledAttributes.getResourceId(R.styleable.TextInputLayout_placeholderTextAppearance, r32);
        CharSequence text3 = c1VarObtainTintedStyledAttributes.getText(R.styleable.TextInputLayout_placeholderText);
        boolean z12 = c1VarObtainTintedStyledAttributes.getBoolean(R.styleable.TextInputLayout_counterEnabled, r32);
        setCounterMaxLength(c1VarObtainTintedStyledAttributes.getInt(R.styleable.TextInputLayout_counterMaxLength, -1));
        this.B = c1VarObtainTintedStyledAttributes.getResourceId(i12, 0);
        this.A = c1VarObtainTintedStyledAttributes.getResourceId(i13, 0);
        setBoxBackgroundMode(c1VarObtainTintedStyledAttributes.getInt(R.styleable.TextInputLayout_boxBackgroundMode, 0));
        setErrorContentDescription(text);
        setErrorAccessibilityLiveRegion(i24);
        setCounterOverflowTextAppearance(this.A);
        setHelperTextTextAppearance(resourceId2);
        setErrorTextAppearance(resourceId);
        setCounterTextAppearance(this.B);
        setPlaceholderText(text3);
        setPlaceholderTextAppearance(resourceId3);
        int i25 = R.styleable.TextInputLayout_errorTextColor;
        if (c1VarObtainTintedStyledAttributes.hasValue(i25)) {
            setErrorTextColor(c1VarObtainTintedStyledAttributes.getColorStateList(i25));
        }
        int i26 = R.styleable.TextInputLayout_helperTextTextColor;
        if (c1VarObtainTintedStyledAttributes.hasValue(i26)) {
            setHelperTextColor(c1VarObtainTintedStyledAttributes.getColorStateList(i26));
        }
        int i27 = R.styleable.TextInputLayout_hintTextColor;
        if (c1VarObtainTintedStyledAttributes.hasValue(i27)) {
            setHintTextColor(c1VarObtainTintedStyledAttributes.getColorStateList(i27));
        }
        int i28 = R.styleable.TextInputLayout_counterTextColor;
        if (c1VarObtainTintedStyledAttributes.hasValue(i28)) {
            setCounterTextColor(c1VarObtainTintedStyledAttributes.getColorStateList(i28));
        }
        int i29 = R.styleable.TextInputLayout_counterOverflowTextColor;
        if (c1VarObtainTintedStyledAttributes.hasValue(i29)) {
            setCounterOverflowTextColor(c1VarObtainTintedStyledAttributes.getColorStateList(i29));
        }
        int i30 = R.styleable.TextInputLayout_placeholderTextColor;
        if (c1VarObtainTintedStyledAttributes.hasValue(i30)) {
            setPlaceholderTextColor(c1VarObtainTintedStyledAttributes.getColorStateList(i30));
        }
        com.google.android.material.textfield.a aVar2 = new com.google.android.material.textfield.a(this, c1VarObtainTintedStyledAttributes);
        this.f9422n = aVar2;
        boolean z13 = c1VarObtainTintedStyledAttributes.getBoolean(R.styleable.TextInputLayout_android_enabled, true);
        c1VarObtainTintedStyledAttributes.recycle();
        j0.setImportantForAccessibility(this, 2);
        if (Build.VERSION.SDK_INT >= 26) {
            j0.setImportantForAutofill(this, 1);
        }
        frameLayout.addView(sVar);
        frameLayout.addView(aVar2);
        addView(frameLayout);
        setEnabled(z13);
        setHelperTextEnabled(z11);
        setErrorEnabled(z10);
        setCounterEnabled(z12);
        setHelperText(text2);
    }

    public void setStartIconDrawable(Drawable drawable) {
        this.f9420m.b(drawable);
    }

    public void setHint(int i10) throws NoSuchMethodException, SecurityException {
        setHint(i10 != 0 ? getResources().getText(i10) : null);
    }

    public void setStartIconContentDescription(int i10) {
        setStartIconContentDescription(i10 != 0 ? getResources().getText(i10) : null);
    }

    @Deprecated
    public void setPasswordVisibilityToggleContentDescription(CharSequence charSequence) {
        this.f9422n.f9462r.setContentDescription(charSequence);
    }

    @Deprecated
    public void setPasswordVisibilityToggleDrawable(Drawable drawable) {
        this.f9422n.f9462r.setImageDrawable(drawable);
    }

    public void setErrorIconDrawable(Drawable drawable) {
        this.f9422n.i(drawable);
    }

    public void setEndIconContentDescription(CharSequence charSequence) {
        CheckableImageButton checkableImageButton = this.f9422n.f9462r;
        if (checkableImageButton.getContentDescription() != charSequence) {
            checkableImageButton.setContentDescription(charSequence);
        }
    }

    public void setEndIconDrawable(Drawable drawable) {
        com.google.android.material.textfield.a aVar = this.f9422n;
        CheckableImageButton checkableImageButton = aVar.f9462r;
        checkableImageButton.setImageDrawable(drawable);
        if (drawable != null) {
            ColorStateList colorStateList = aVar.f9466v;
            PorterDuff.Mode mode = aVar.f9467w;
            TextInputLayout textInputLayout = aVar.f9456b;
            m.a(textInputLayout, checkableImageButton, colorStateList, mode);
            m.c(textInputLayout, checkableImageButton, aVar.f9466v);
        }
    }

    public class a implements TextWatcher {

        /* renamed from: b, reason: collision with root package name */
        public int f9448b;

        /* renamed from: m, reason: collision with root package name */
        public final /* synthetic */ EditText f9449m;

        public a(EditText editText) {
            this.f9449m = editText;
            this.f9448b = editText.getLineCount();
        }

        @Override // android.text.TextWatcher
        public void afterTextChanged(Editable editable) throws NoSuchMethodException, SecurityException {
            TextInputLayout textInputLayout = TextInputLayout.this;
            textInputLayout.u(!textInputLayout.L0, false);
            if (textInputLayout.f9438v) {
                textInputLayout.n(editable);
            }
            if (textInputLayout.D) {
                textInputLayout.v(editable);
            }
            EditText editText = this.f9449m;
            int lineCount = editText.getLineCount();
            int i10 = this.f9448b;
            if (lineCount != i10) {
                if (lineCount < i10) {
                    int minimumHeight = j0.getMinimumHeight(editText);
                    int i11 = textInputLayout.E0;
                    if (minimumHeight != i11) {
                        editText.setMinimumHeight(i11);
                    }
                }
                this.f9448b = lineCount;
            }
        }

        @Override // android.text.TextWatcher
        public void beforeTextChanged(CharSequence charSequence, int i10, int i11, int i12) {
        }

        @Override // android.text.TextWatcher
        public void onTextChanged(CharSequence charSequence, int i10, int i11, int i12) {
        }
    }
}
