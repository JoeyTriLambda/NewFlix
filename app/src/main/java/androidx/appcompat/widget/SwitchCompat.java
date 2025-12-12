package androidx.appcompat.widget;

import android.R;
import android.animation.ObjectAnimator;
import android.content.Context;
import android.content.res.ColorStateList;
import android.content.res.Resources;
import android.graphics.Canvas;
import android.graphics.PorterDuff;
import android.graphics.Rect;
import android.graphics.Region;
import android.graphics.Typeface;
import android.graphics.drawable.Drawable;
import android.os.Build;
import android.text.InputFilter;
import android.text.Layout;
import android.text.StaticLayout;
import android.text.TextPaint;
import android.text.TextUtils;
import android.text.method.TransformationMethod;
import android.util.AttributeSet;
import android.util.Property;
import android.view.ActionMode;
import android.view.VelocityTracker;
import android.view.View;
import android.view.ViewConfiguration;
import android.view.accessibility.AccessibilityEvent;
import android.view.accessibility.AccessibilityNodeInfo;
import android.widget.CompoundButton;
import androidx.emoji2.text.f;
import cz.msebera.android.httpclient.message.TokenParser;
import java.lang.ref.WeakReference;
import java.lang.reflect.InvocationTargetException;

/* loaded from: classes.dex */
public class SwitchCompat extends CompoundButton {

    /* renamed from: f0, reason: collision with root package name */
    public static final a f1176f0 = new a();

    /* renamed from: g0, reason: collision with root package name */
    public static final int[] f1177g0 = {R.attr.state_checked};
    public CharSequence A;
    public CharSequence B;
    public CharSequence C;
    public boolean D;
    public int E;
    public final int F;
    public float G;
    public float H;
    public final VelocityTracker I;
    public final int J;
    public float K;
    public int L;
    public int M;
    public int N;
    public int O;
    public int P;
    public int Q;
    public int R;
    public boolean S;
    public final TextPaint T;
    public ColorStateList U;
    public StaticLayout V;
    public StaticLayout W;

    /* renamed from: a0, reason: collision with root package name */
    public v.a f1178a0;

    /* renamed from: b, reason: collision with root package name */
    public Drawable f1179b;

    /* renamed from: b0, reason: collision with root package name */
    public ObjectAnimator f1180b0;

    /* renamed from: c0, reason: collision with root package name */
    public n f1181c0;

    /* renamed from: d0, reason: collision with root package name */
    public c f1182d0;

    /* renamed from: e0, reason: collision with root package name */
    public final Rect f1183e0;

    /* renamed from: m, reason: collision with root package name */
    public ColorStateList f1184m;

    /* renamed from: n, reason: collision with root package name */
    public PorterDuff.Mode f1185n;

    /* renamed from: o, reason: collision with root package name */
    public boolean f1186o;

    /* renamed from: p, reason: collision with root package name */
    public boolean f1187p;

    /* renamed from: q, reason: collision with root package name */
    public Drawable f1188q;

    /* renamed from: r, reason: collision with root package name */
    public ColorStateList f1189r;

    /* renamed from: s, reason: collision with root package name */
    public PorterDuff.Mode f1190s;

    /* renamed from: t, reason: collision with root package name */
    public boolean f1191t;

    /* renamed from: u, reason: collision with root package name */
    public boolean f1192u;

    /* renamed from: v, reason: collision with root package name */
    public int f1193v;

    /* renamed from: w, reason: collision with root package name */
    public int f1194w;

    /* renamed from: x, reason: collision with root package name */
    public int f1195x;

    /* renamed from: y, reason: collision with root package name */
    public boolean f1196y;

    /* renamed from: z, reason: collision with root package name */
    public CharSequence f1197z;

    public class a extends Property<SwitchCompat, Float> {
        public a() {
            super(Float.class, "thumbPos");
        }

        @Override // android.util.Property
        public Float get(SwitchCompat switchCompat) {
            return Float.valueOf(switchCompat.K);
        }

        @Override // android.util.Property
        public void set(SwitchCompat switchCompat, Float f10) {
            switchCompat.setThumbPosition(f10.floatValue());
        }
    }

    public static class b {
        public static void a(ObjectAnimator objectAnimator, boolean z10) {
            objectAnimator.setAutoCancel(z10);
        }
    }

    public static class c extends f.e {

        /* renamed from: a, reason: collision with root package name */
        public final WeakReference f1198a;

        public c(SwitchCompat switchCompat) {
            this.f1198a = new WeakReference(switchCompat);
        }

        @Override // androidx.emoji2.text.f.e
        public void onFailed(Throwable th2) {
            SwitchCompat switchCompat = (SwitchCompat) this.f1198a.get();
            if (switchCompat != null) {
                switchCompat.d();
            }
        }

        @Override // androidx.emoji2.text.f.e
        public void onInitialized() {
            SwitchCompat switchCompat = (SwitchCompat) this.f1198a.get();
            if (switchCompat != null) {
                switchCompat.d();
            }
        }
    }

    public SwitchCompat(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, androidx.appcompat.R.attr.switchStyle);
    }

    private n getEmojiTextViewHelper() {
        if (this.f1181c0 == null) {
            this.f1181c0 = new n(this);
        }
        return this.f1181c0;
    }

    private boolean getTargetCheckedState() {
        return this.K > 0.5f;
    }

    private int getThumbOffset() {
        return (int) (((k1.isLayoutRtl(this) ? 1.0f - this.K : this.K) * getThumbScrollRange()) + 0.5f);
    }

    private int getThumbScrollRange() {
        Drawable drawable = this.f1188q;
        if (drawable == null) {
            return 0;
        }
        Rect rect = this.f1183e0;
        drawable.getPadding(rect);
        Drawable drawable2 = this.f1179b;
        Rect opticalBounds = drawable2 != null ? i0.getOpticalBounds(drawable2) : i0.f1375c;
        return ((((this.L - this.N) - rect.left) - rect.right) - opticalBounds.left) - opticalBounds.right;
    }

    private void setTextOffInternal(CharSequence charSequence) {
        this.B = charSequence;
        TransformationMethod transformationMethodWrapTransformationMethod = getEmojiTextViewHelper().wrapTransformationMethod(this.f1178a0);
        if (transformationMethodWrapTransformationMethod != null) {
            charSequence = transformationMethodWrapTransformationMethod.getTransformation(charSequence, this);
        }
        this.C = charSequence;
        this.W = null;
        if (this.D) {
            e();
        }
    }

    private void setTextOnInternal(CharSequence charSequence) {
        this.f1197z = charSequence;
        TransformationMethod transformationMethodWrapTransformationMethod = getEmojiTextViewHelper().wrapTransformationMethod(this.f1178a0);
        if (transformationMethodWrapTransformationMethod != null) {
            charSequence = transformationMethodWrapTransformationMethod.getTransformation(charSequence, this);
        }
        this.A = charSequence;
        this.V = null;
        if (this.D) {
            e();
        }
    }

    public final void a() {
        Drawable drawable = this.f1179b;
        if (drawable != null) {
            if (this.f1186o || this.f1187p) {
                Drawable drawableMutate = p0.a.wrap(drawable).mutate();
                this.f1179b = drawableMutate;
                if (this.f1186o) {
                    p0.a.setTintList(drawableMutate, this.f1184m);
                }
                if (this.f1187p) {
                    p0.a.setTintMode(this.f1179b, this.f1185n);
                }
                if (this.f1179b.isStateful()) {
                    this.f1179b.setState(getDrawableState());
                }
            }
        }
    }

    public final void b() {
        Drawable drawable = this.f1188q;
        if (drawable != null) {
            if (this.f1191t || this.f1192u) {
                Drawable drawableMutate = p0.a.wrap(drawable).mutate();
                this.f1188q = drawableMutate;
                if (this.f1191t) {
                    p0.a.setTintList(drawableMutate, this.f1189r);
                }
                if (this.f1192u) {
                    p0.a.setTintMode(this.f1188q, this.f1190s);
                }
                if (this.f1188q.isStateful()) {
                    this.f1188q.setState(getDrawableState());
                }
            }
        }
    }

    public final StaticLayout c(CharSequence charSequence) {
        return new StaticLayout(charSequence, this.T, charSequence != null ? (int) Math.ceil(Layout.getDesiredWidth(charSequence, r2)) : 0, Layout.Alignment.ALIGN_NORMAL, 1.0f, 0.0f, true);
    }

    public final void d() {
        setTextOnInternal(this.f1197z);
        setTextOffInternal(this.B);
        requestLayout();
    }

    @Override // android.view.View
    public void draw(Canvas canvas) {
        int i10;
        int i11;
        int i12 = this.O;
        int i13 = this.P;
        int i14 = this.Q;
        int i15 = this.R;
        int thumbOffset = getThumbOffset() + i12;
        Drawable drawable = this.f1179b;
        Rect opticalBounds = drawable != null ? i0.getOpticalBounds(drawable) : i0.f1375c;
        Drawable drawable2 = this.f1188q;
        Rect rect = this.f1183e0;
        if (drawable2 != null) {
            drawable2.getPadding(rect);
            int i16 = rect.left;
            thumbOffset += i16;
            if (opticalBounds != null) {
                int i17 = opticalBounds.left;
                if (i17 > i16) {
                    i12 += i17 - i16;
                }
                int i18 = opticalBounds.top;
                int i19 = rect.top;
                i10 = i18 > i19 ? (i18 - i19) + i13 : i13;
                int i20 = opticalBounds.right;
                int i21 = rect.right;
                if (i20 > i21) {
                    i14 -= i20 - i21;
                }
                int i22 = opticalBounds.bottom;
                int i23 = rect.bottom;
                if (i22 > i23) {
                    i11 = i15 - (i22 - i23);
                }
                this.f1188q.setBounds(i12, i10, i14, i11);
            } else {
                i10 = i13;
            }
            i11 = i15;
            this.f1188q.setBounds(i12, i10, i14, i11);
        }
        Drawable drawable3 = this.f1179b;
        if (drawable3 != null) {
            drawable3.getPadding(rect);
            int i24 = thumbOffset - rect.left;
            int i25 = thumbOffset + this.N + rect.right;
            this.f1179b.setBounds(i24, i13, i25, i15);
            Drawable background = getBackground();
            if (background != null) {
                p0.a.setHotspotBounds(background, i24, i13, i25, i15);
            }
        }
        super.draw(canvas);
    }

    @Override // android.widget.CompoundButton, android.widget.TextView, android.view.View
    public void drawableHotspotChanged(float f10, float f11) {
        super.drawableHotspotChanged(f10, f11);
        Drawable drawable = this.f1179b;
        if (drawable != null) {
            p0.a.setHotspot(drawable, f10, f11);
        }
        Drawable drawable2 = this.f1188q;
        if (drawable2 != null) {
            p0.a.setHotspot(drawable2, f10, f11);
        }
    }

    @Override // android.widget.CompoundButton, android.widget.TextView, android.view.View
    public void drawableStateChanged() {
        super.drawableStateChanged();
        int[] drawableState = getDrawableState();
        Drawable drawable = this.f1179b;
        boolean state = false;
        if (drawable != null && drawable.isStateful()) {
            state = false | drawable.setState(drawableState);
        }
        Drawable drawable2 = this.f1188q;
        if (drawable2 != null && drawable2.isStateful()) {
            state |= drawable2.setState(drawableState);
        }
        if (state) {
            invalidate();
        }
    }

    public final void e() {
        if (this.f1182d0 == null && this.f1181c0.isEnabled() && androidx.emoji2.text.f.isConfigured()) {
            androidx.emoji2.text.f fVar = androidx.emoji2.text.f.get();
            int loadState = fVar.getLoadState();
            if (loadState == 3 || loadState == 0) {
                c cVar = new c(this);
                this.f1182d0 = cVar;
                fVar.registerInitCallback(cVar);
            }
        }
    }

    @Override // android.widget.CompoundButton, android.widget.TextView
    public int getCompoundPaddingLeft() {
        if (!k1.isLayoutRtl(this)) {
            return super.getCompoundPaddingLeft();
        }
        int compoundPaddingLeft = super.getCompoundPaddingLeft() + this.L;
        return !TextUtils.isEmpty(getText()) ? compoundPaddingLeft + this.f1195x : compoundPaddingLeft;
    }

    @Override // android.widget.CompoundButton, android.widget.TextView
    public int getCompoundPaddingRight() {
        if (k1.isLayoutRtl(this)) {
            return super.getCompoundPaddingRight();
        }
        int compoundPaddingRight = super.getCompoundPaddingRight() + this.L;
        return !TextUtils.isEmpty(getText()) ? compoundPaddingRight + this.f1195x : compoundPaddingRight;
    }

    @Override // android.widget.TextView
    public ActionMode.Callback getCustomSelectionActionModeCallback() {
        return d1.i.unwrapCustomSelectionActionModeCallback(super.getCustomSelectionActionModeCallback());
    }

    public boolean getShowText() {
        return this.D;
    }

    public boolean getSplitTrack() {
        return this.f1196y;
    }

    public int getSwitchMinWidth() {
        return this.f1194w;
    }

    public int getSwitchPadding() {
        return this.f1195x;
    }

    public CharSequence getTextOff() {
        return this.B;
    }

    public CharSequence getTextOn() {
        return this.f1197z;
    }

    public Drawable getThumbDrawable() {
        return this.f1179b;
    }

    public final float getThumbPosition() {
        return this.K;
    }

    public int getThumbTextPadding() {
        return this.f1193v;
    }

    public ColorStateList getThumbTintList() {
        return this.f1184m;
    }

    public PorterDuff.Mode getThumbTintMode() {
        return this.f1185n;
    }

    public Drawable getTrackDrawable() {
        return this.f1188q;
    }

    public ColorStateList getTrackTintList() {
        return this.f1189r;
    }

    public PorterDuff.Mode getTrackTintMode() {
        return this.f1190s;
    }

    @Override // android.widget.CompoundButton, android.widget.TextView, android.view.View
    public void jumpDrawablesToCurrentState() {
        super.jumpDrawablesToCurrentState();
        Drawable drawable = this.f1179b;
        if (drawable != null) {
            drawable.jumpToCurrentState();
        }
        Drawable drawable2 = this.f1188q;
        if (drawable2 != null) {
            drawable2.jumpToCurrentState();
        }
        ObjectAnimator objectAnimator = this.f1180b0;
        if (objectAnimator == null || !objectAnimator.isStarted()) {
            return;
        }
        this.f1180b0.end();
        this.f1180b0 = null;
    }

    @Override // android.widget.CompoundButton, android.widget.TextView, android.view.View
    public int[] onCreateDrawableState(int i10) {
        int[] iArrOnCreateDrawableState = super.onCreateDrawableState(i10 + 1);
        if (isChecked()) {
            View.mergeDrawableStates(iArrOnCreateDrawableState, f1177g0);
        }
        return iArrOnCreateDrawableState;
    }

    @Override // android.widget.CompoundButton, android.widget.TextView, android.view.View
    public void onDraw(Canvas canvas) throws IllegalAccessException, IllegalArgumentException, InvocationTargetException {
        int width;
        super.onDraw(canvas);
        Drawable drawable = this.f1188q;
        Rect rect = this.f1183e0;
        if (drawable != null) {
            drawable.getPadding(rect);
        } else {
            rect.setEmpty();
        }
        int i10 = this.P;
        int i11 = this.R;
        int i12 = i10 + rect.top;
        int i13 = i11 - rect.bottom;
        Drawable drawable2 = this.f1179b;
        if (drawable != null) {
            if (!this.f1196y || drawable2 == null) {
                drawable.draw(canvas);
            } else {
                Rect opticalBounds = i0.getOpticalBounds(drawable2);
                drawable2.copyBounds(rect);
                rect.left += opticalBounds.left;
                rect.right -= opticalBounds.right;
                int iSave = canvas.save();
                canvas.clipRect(rect, Region.Op.DIFFERENCE);
                drawable.draw(canvas);
                canvas.restoreToCount(iSave);
            }
        }
        int iSave2 = canvas.save();
        if (drawable2 != null) {
            drawable2.draw(canvas);
        }
        StaticLayout staticLayout = getTargetCheckedState() ? this.V : this.W;
        if (staticLayout != null) {
            int[] drawableState = getDrawableState();
            ColorStateList colorStateList = this.U;
            TextPaint textPaint = this.T;
            if (colorStateList != null) {
                textPaint.setColor(colorStateList.getColorForState(drawableState, 0));
            }
            textPaint.drawableState = drawableState;
            if (drawable2 != null) {
                Rect bounds = drawable2.getBounds();
                width = bounds.left + bounds.right;
            } else {
                width = getWidth();
            }
            canvas.translate((width / 2) - (staticLayout.getWidth() / 2), ((i12 + i13) / 2) - (staticLayout.getHeight() / 2));
            staticLayout.draw(canvas);
        }
        canvas.restoreToCount(iSave2);
    }

    @Override // android.view.View
    public void onInitializeAccessibilityEvent(AccessibilityEvent accessibilityEvent) {
        super.onInitializeAccessibilityEvent(accessibilityEvent);
        accessibilityEvent.setClassName("android.widget.Switch");
    }

    @Override // android.view.View
    public void onInitializeAccessibilityNodeInfo(AccessibilityNodeInfo accessibilityNodeInfo) {
        super.onInitializeAccessibilityNodeInfo(accessibilityNodeInfo);
        accessibilityNodeInfo.setClassName("android.widget.Switch");
        if (Build.VERSION.SDK_INT < 30) {
            CharSequence charSequence = isChecked() ? this.f1197z : this.B;
            if (TextUtils.isEmpty(charSequence)) {
                return;
            }
            CharSequence text = accessibilityNodeInfo.getText();
            if (TextUtils.isEmpty(text)) {
                accessibilityNodeInfo.setText(charSequence);
                return;
            }
            StringBuilder sb2 = new StringBuilder();
            sb2.append(text);
            sb2.append(TokenParser.SP);
            sb2.append(charSequence);
            accessibilityNodeInfo.setText(sb2);
        }
    }

    @Override // android.widget.TextView, android.view.View
    public void onLayout(boolean z10, int i10, int i11, int i12, int i13) throws IllegalAccessException, IllegalArgumentException, InvocationTargetException {
        int iMax;
        int width;
        int paddingLeft;
        int height;
        int paddingTop;
        super.onLayout(z10, i10, i11, i12, i13);
        int iMax2 = 0;
        if (this.f1179b != null) {
            Drawable drawable = this.f1188q;
            Rect rect = this.f1183e0;
            if (drawable != null) {
                drawable.getPadding(rect);
            } else {
                rect.setEmpty();
            }
            Rect opticalBounds = i0.getOpticalBounds(this.f1179b);
            iMax = Math.max(0, opticalBounds.left - rect.left);
            iMax2 = Math.max(0, opticalBounds.right - rect.right);
        } else {
            iMax = 0;
        }
        if (k1.isLayoutRtl(this)) {
            paddingLeft = getPaddingLeft() + iMax;
            width = ((this.L + paddingLeft) - iMax) - iMax2;
        } else {
            width = (getWidth() - getPaddingRight()) - iMax2;
            paddingLeft = (width - this.L) + iMax + iMax2;
        }
        int gravity = getGravity() & 112;
        if (gravity == 16) {
            int height2 = ((getHeight() + getPaddingTop()) - getPaddingBottom()) / 2;
            int i14 = this.M;
            int i15 = height2 - (i14 / 2);
            height = i14 + i15;
            paddingTop = i15;
        } else if (gravity != 80) {
            paddingTop = getPaddingTop();
            height = this.M + paddingTop;
        } else {
            height = getHeight() - getPaddingBottom();
            paddingTop = height - this.M;
        }
        this.O = paddingLeft;
        this.P = paddingTop;
        this.R = height;
        this.Q = width;
    }

    @Override // android.widget.TextView, android.view.View
    public void onMeasure(int i10, int i11) throws IllegalAccessException, IllegalArgumentException, InvocationTargetException {
        int intrinsicWidth;
        int intrinsicHeight;
        if (this.D) {
            if (this.V == null) {
                this.V = c(this.A);
            }
            if (this.W == null) {
                this.W = c(this.C);
            }
        }
        Drawable drawable = this.f1179b;
        int intrinsicHeight2 = 0;
        Rect rect = this.f1183e0;
        if (drawable != null) {
            drawable.getPadding(rect);
            intrinsicWidth = (this.f1179b.getIntrinsicWidth() - rect.left) - rect.right;
            intrinsicHeight = this.f1179b.getIntrinsicHeight();
        } else {
            intrinsicWidth = 0;
            intrinsicHeight = 0;
        }
        this.N = Math.max(this.D ? (this.f1193v * 2) + Math.max(this.V.getWidth(), this.W.getWidth()) : 0, intrinsicWidth);
        Drawable drawable2 = this.f1188q;
        if (drawable2 != null) {
            drawable2.getPadding(rect);
            intrinsicHeight2 = this.f1188q.getIntrinsicHeight();
        } else {
            rect.setEmpty();
        }
        int iMax = rect.left;
        int iMax2 = rect.right;
        Drawable drawable3 = this.f1179b;
        if (drawable3 != null) {
            Rect opticalBounds = i0.getOpticalBounds(drawable3);
            iMax = Math.max(iMax, opticalBounds.left);
            iMax2 = Math.max(iMax2, opticalBounds.right);
        }
        int iMax3 = this.S ? Math.max(this.f1194w, (this.N * 2) + iMax + iMax2) : this.f1194w;
        int iMax4 = Math.max(intrinsicHeight2, intrinsicHeight);
        this.L = iMax3;
        this.M = iMax4;
        super.onMeasure(i10, i11);
        if (getMeasuredHeight() < iMax4) {
            setMeasuredDimension(getMeasuredWidthAndState(), iMax4);
        }
    }

    @Override // android.view.View
    public void onPopulateAccessibilityEvent(AccessibilityEvent accessibilityEvent) {
        super.onPopulateAccessibilityEvent(accessibilityEvent);
        CharSequence charSequence = isChecked() ? this.f1197z : this.B;
        if (charSequence != null) {
            accessibilityEvent.getText().add(charSequence);
        }
    }

    /* JADX WARN: Removed duplicated region for block: B:40:0x0091  */
    @Override // android.widget.TextView, android.view.View
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public boolean onTouchEvent(android.view.MotionEvent r11) throws android.content.res.Resources.NotFoundException {
        /*
            Method dump skipped, instructions count: 332
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.appcompat.widget.SwitchCompat.onTouchEvent(android.view.MotionEvent):boolean");
    }

    @Override // android.widget.TextView
    public void setAllCaps(boolean z10) {
        super.setAllCaps(z10);
        getEmojiTextViewHelper().c(z10);
    }

    @Override // android.widget.CompoundButton, android.widget.Checkable
    public void setChecked(boolean z10) throws Resources.NotFoundException {
        super.setChecked(z10);
        boolean zIsChecked = isChecked();
        if (zIsChecked) {
            if (Build.VERSION.SDK_INT >= 30) {
                CharSequence string = this.f1197z;
                if (string == null) {
                    string = getResources().getString(androidx.appcompat.R.string.abc_capital_on);
                }
                x0.j0.setStateDescription(this, string);
            }
        } else if (Build.VERSION.SDK_INT >= 30) {
            CharSequence string2 = this.B;
            if (string2 == null) {
                string2 = getResources().getString(androidx.appcompat.R.string.abc_capital_off);
            }
            x0.j0.setStateDescription(this, string2);
        }
        if (getWindowToken() == null || !x0.j0.isLaidOut(this)) {
            ObjectAnimator objectAnimator = this.f1180b0;
            if (objectAnimator != null) {
                objectAnimator.cancel();
            }
            setThumbPosition(zIsChecked ? 1.0f : 0.0f);
            return;
        }
        ObjectAnimator objectAnimatorOfFloat = ObjectAnimator.ofFloat(this, f1176f0, zIsChecked ? 1.0f : 0.0f);
        this.f1180b0 = objectAnimatorOfFloat;
        objectAnimatorOfFloat.setDuration(250L);
        b.a(this.f1180b0, true);
        this.f1180b0.start();
    }

    @Override // android.widget.TextView
    public void setCustomSelectionActionModeCallback(ActionMode.Callback callback) {
        super.setCustomSelectionActionModeCallback(d1.i.wrapCustomSelectionActionModeCallback(this, callback));
    }

    public void setEmojiCompatEnabled(boolean z10) {
        getEmojiTextViewHelper().d(z10);
        setTextOnInternal(this.f1197z);
        setTextOffInternal(this.B);
        requestLayout();
    }

    public final void setEnforceSwitchWidth(boolean z10) {
        this.S = z10;
        invalidate();
    }

    @Override // android.widget.TextView
    public void setFilters(InputFilter[] inputFilterArr) {
        super.setFilters(getEmojiTextViewHelper().a(inputFilterArr));
    }

    public void setShowText(boolean z10) {
        if (this.D != z10) {
            this.D = z10;
            requestLayout();
            if (z10) {
                e();
            }
        }
    }

    public void setSplitTrack(boolean z10) {
        this.f1196y = z10;
        invalidate();
    }

    public void setSwitchMinWidth(int i10) {
        this.f1194w = i10;
        requestLayout();
    }

    public void setSwitchPadding(int i10) {
        this.f1195x = i10;
        requestLayout();
    }

    public void setSwitchTextAppearance(Context context, int i10) {
        c1 c1VarObtainStyledAttributes = c1.obtainStyledAttributes(context, i10, androidx.appcompat.R.styleable.TextAppearance);
        ColorStateList colorStateList = c1VarObtainStyledAttributes.getColorStateList(androidx.appcompat.R.styleable.TextAppearance_android_textColor);
        if (colorStateList != null) {
            this.U = colorStateList;
        } else {
            this.U = getTextColors();
        }
        int dimensionPixelSize = c1VarObtainStyledAttributes.getDimensionPixelSize(androidx.appcompat.R.styleable.TextAppearance_android_textSize, 0);
        if (dimensionPixelSize != 0) {
            float f10 = dimensionPixelSize;
            TextPaint textPaint = this.T;
            if (f10 != textPaint.getTextSize()) {
                textPaint.setTextSize(f10);
                requestLayout();
            }
        }
        int i11 = c1VarObtainStyledAttributes.getInt(androidx.appcompat.R.styleable.TextAppearance_android_typeface, -1);
        setSwitchTypeface(i11 != 1 ? i11 != 2 ? i11 != 3 ? null : Typeface.MONOSPACE : Typeface.SERIF : Typeface.SANS_SERIF, c1VarObtainStyledAttributes.getInt(androidx.appcompat.R.styleable.TextAppearance_android_textStyle, -1));
        if (c1VarObtainStyledAttributes.getBoolean(androidx.appcompat.R.styleable.TextAppearance_textAllCaps, false)) {
            this.f1178a0 = new v.a(getContext());
        } else {
            this.f1178a0 = null;
        }
        setTextOnInternal(this.f1197z);
        setTextOffInternal(this.B);
        c1VarObtainStyledAttributes.recycle();
    }

    public void setSwitchTypeface(Typeface typeface, int i10) {
        TextPaint textPaint = this.T;
        if (i10 <= 0) {
            textPaint.setFakeBoldText(false);
            textPaint.setTextSkewX(0.0f);
            setSwitchTypeface(typeface);
        } else {
            Typeface typefaceDefaultFromStyle = typeface == null ? Typeface.defaultFromStyle(i10) : Typeface.create(typeface, i10);
            setSwitchTypeface(typefaceDefaultFromStyle);
            int i11 = (~(typefaceDefaultFromStyle != null ? typefaceDefaultFromStyle.getStyle() : 0)) & i10;
            textPaint.setFakeBoldText((i11 & 1) != 0);
            textPaint.setTextSkewX((i11 & 2) != 0 ? -0.25f : 0.0f);
        }
    }

    public void setTextOff(CharSequence charSequence) throws Resources.NotFoundException {
        setTextOffInternal(charSequence);
        requestLayout();
        if (isChecked() || Build.VERSION.SDK_INT < 30) {
            return;
        }
        CharSequence string = this.B;
        if (string == null) {
            string = getResources().getString(androidx.appcompat.R.string.abc_capital_off);
        }
        x0.j0.setStateDescription(this, string);
    }

    public void setTextOn(CharSequence charSequence) throws Resources.NotFoundException {
        setTextOnInternal(charSequence);
        requestLayout();
        if (!isChecked() || Build.VERSION.SDK_INT < 30) {
            return;
        }
        CharSequence string = this.f1197z;
        if (string == null) {
            string = getResources().getString(androidx.appcompat.R.string.abc_capital_on);
        }
        x0.j0.setStateDescription(this, string);
    }

    public void setThumbDrawable(Drawable drawable) {
        Drawable drawable2 = this.f1179b;
        if (drawable2 != null) {
            drawable2.setCallback(null);
        }
        this.f1179b = drawable;
        if (drawable != null) {
            drawable.setCallback(this);
        }
        requestLayout();
    }

    public void setThumbPosition(float f10) {
        this.K = f10;
        invalidate();
    }

    public void setThumbResource(int i10) {
        setThumbDrawable(s.a.getDrawable(getContext(), i10));
    }

    public void setThumbTextPadding(int i10) {
        this.f1193v = i10;
        requestLayout();
    }

    public void setThumbTintList(ColorStateList colorStateList) {
        this.f1184m = colorStateList;
        this.f1186o = true;
        a();
    }

    public void setThumbTintMode(PorterDuff.Mode mode) {
        this.f1185n = mode;
        this.f1187p = true;
        a();
    }

    public void setTrackDrawable(Drawable drawable) {
        Drawable drawable2 = this.f1188q;
        if (drawable2 != null) {
            drawable2.setCallback(null);
        }
        this.f1188q = drawable;
        if (drawable != null) {
            drawable.setCallback(this);
        }
        requestLayout();
    }

    public void setTrackResource(int i10) {
        setTrackDrawable(s.a.getDrawable(getContext(), i10));
    }

    public void setTrackTintList(ColorStateList colorStateList) {
        this.f1189r = colorStateList;
        this.f1191t = true;
        b();
    }

    public void setTrackTintMode(PorterDuff.Mode mode) {
        this.f1190s = mode;
        this.f1192u = true;
        b();
    }

    @Override // android.widget.CompoundButton, android.widget.Checkable
    public void toggle() throws Resources.NotFoundException {
        setChecked(!isChecked());
    }

    @Override // android.widget.CompoundButton, android.widget.TextView, android.view.View
    public boolean verifyDrawable(Drawable drawable) {
        return super.verifyDrawable(drawable) || drawable == this.f1179b || drawable == this.f1188q;
    }

    public SwitchCompat(Context context, AttributeSet attributeSet, int i10) throws Resources.NotFoundException {
        super(context, attributeSet, i10);
        this.f1184m = null;
        this.f1185n = null;
        this.f1186o = false;
        this.f1187p = false;
        this.f1189r = null;
        this.f1190s = null;
        this.f1191t = false;
        this.f1192u = false;
        this.I = VelocityTracker.obtain();
        this.S = true;
        this.f1183e0 = new Rect();
        x0.checkAppCompatTheme(this, getContext());
        TextPaint textPaint = new TextPaint(1);
        this.T = textPaint;
        textPaint.density = getResources().getDisplayMetrics().density;
        int[] iArr = androidx.appcompat.R.styleable.SwitchCompat;
        c1 c1VarObtainStyledAttributes = c1.obtainStyledAttributes(context, attributeSet, iArr, i10, 0);
        x0.j0.saveAttributeDataForStyleable(this, context, iArr, attributeSet, c1VarObtainStyledAttributes.getWrappedTypeArray(), i10, 0);
        Drawable drawable = c1VarObtainStyledAttributes.getDrawable(androidx.appcompat.R.styleable.SwitchCompat_android_thumb);
        this.f1179b = drawable;
        if (drawable != null) {
            drawable.setCallback(this);
        }
        Drawable drawable2 = c1VarObtainStyledAttributes.getDrawable(androidx.appcompat.R.styleable.SwitchCompat_track);
        this.f1188q = drawable2;
        if (drawable2 != null) {
            drawable2.setCallback(this);
        }
        setTextOnInternal(c1VarObtainStyledAttributes.getText(androidx.appcompat.R.styleable.SwitchCompat_android_textOn));
        setTextOffInternal(c1VarObtainStyledAttributes.getText(androidx.appcompat.R.styleable.SwitchCompat_android_textOff));
        this.D = c1VarObtainStyledAttributes.getBoolean(androidx.appcompat.R.styleable.SwitchCompat_showText, true);
        this.f1193v = c1VarObtainStyledAttributes.getDimensionPixelSize(androidx.appcompat.R.styleable.SwitchCompat_thumbTextPadding, 0);
        this.f1194w = c1VarObtainStyledAttributes.getDimensionPixelSize(androidx.appcompat.R.styleable.SwitchCompat_switchMinWidth, 0);
        this.f1195x = c1VarObtainStyledAttributes.getDimensionPixelSize(androidx.appcompat.R.styleable.SwitchCompat_switchPadding, 0);
        this.f1196y = c1VarObtainStyledAttributes.getBoolean(androidx.appcompat.R.styleable.SwitchCompat_splitTrack, false);
        ColorStateList colorStateList = c1VarObtainStyledAttributes.getColorStateList(androidx.appcompat.R.styleable.SwitchCompat_thumbTint);
        if (colorStateList != null) {
            this.f1184m = colorStateList;
            this.f1186o = true;
        }
        PorterDuff.Mode tintMode = i0.parseTintMode(c1VarObtainStyledAttributes.getInt(androidx.appcompat.R.styleable.SwitchCompat_thumbTintMode, -1), null);
        if (this.f1185n != tintMode) {
            this.f1185n = tintMode;
            this.f1187p = true;
        }
        if (this.f1186o || this.f1187p) {
            a();
        }
        ColorStateList colorStateList2 = c1VarObtainStyledAttributes.getColorStateList(androidx.appcompat.R.styleable.SwitchCompat_trackTint);
        if (colorStateList2 != null) {
            this.f1189r = colorStateList2;
            this.f1191t = true;
        }
        PorterDuff.Mode tintMode2 = i0.parseTintMode(c1VarObtainStyledAttributes.getInt(androidx.appcompat.R.styleable.SwitchCompat_trackTintMode, -1), null);
        if (this.f1190s != tintMode2) {
            this.f1190s = tintMode2;
            this.f1192u = true;
        }
        if (this.f1191t || this.f1192u) {
            b();
        }
        int resourceId = c1VarObtainStyledAttributes.getResourceId(androidx.appcompat.R.styleable.SwitchCompat_switchTextAppearance, 0);
        if (resourceId != 0) {
            setSwitchTextAppearance(context, resourceId);
        }
        new b0(this).f(attributeSet, i10);
        c1VarObtainStyledAttributes.recycle();
        ViewConfiguration viewConfiguration = ViewConfiguration.get(context);
        this.F = viewConfiguration.getScaledTouchSlop();
        this.J = viewConfiguration.getScaledMinimumFlingVelocity();
        getEmojiTextViewHelper().b(attributeSet, i10);
        refreshDrawableState();
        setChecked(isChecked());
    }

    public void setSwitchTypeface(Typeface typeface) {
        TextPaint textPaint = this.T;
        if ((textPaint.getTypeface() == null || textPaint.getTypeface().equals(typeface)) && (textPaint.getTypeface() != null || typeface == null)) {
            return;
        }
        textPaint.setTypeface(typeface);
        requestLayout();
        invalidate();
    }
}
