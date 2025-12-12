package com.google.android.material.chip;

import android.R;
import android.annotation.TargetApi;
import android.content.Context;
import android.content.res.ColorStateList;
import android.content.res.TypedArray;
import android.graphics.Canvas;
import android.graphics.ColorFilter;
import android.graphics.Outline;
import android.graphics.Paint;
import android.graphics.Path;
import android.graphics.PointF;
import android.graphics.PorterDuff;
import android.graphics.PorterDuffColorFilter;
import android.graphics.Rect;
import android.graphics.RectF;
import android.graphics.drawable.Drawable;
import android.graphics.drawable.RippleDrawable;
import android.graphics.drawable.ShapeDrawable;
import android.graphics.drawable.shapes.OvalShape;
import android.os.Build;
import android.text.TextPaint;
import android.text.TextUtils;
import android.util.AttributeSet;
import i7.p;
import i7.r;
import java.lang.ref.WeakReference;
import java.lang.reflect.InvocationTargetException;
import java.util.Arrays;
import n7.c;
import n7.d;
import o7.b;
import p6.h;
import q7.g;

/* compiled from: ChipDrawable.java */
/* loaded from: classes.dex */
public final class a extends g implements Drawable.Callback, p.b {
    public static final int[] S0 = {R.attr.state_enabled};
    public static final ShapeDrawable T0 = new ShapeDrawable(new OvalShape());
    public int A0;
    public int B0;
    public int C0;
    public boolean D0;
    public int E0;
    public int F0;
    public ColorFilter G0;
    public PorterDuffColorFilter H0;
    public ColorStateList I0;
    public ColorStateList J;
    public PorterDuff.Mode J0;
    public ColorStateList K;
    public int[] K0;
    public float L;
    public boolean L0;
    public float M;
    public ColorStateList M0;
    public ColorStateList N;
    public WeakReference<InterfaceC0085a> N0;
    public float O;
    public TextUtils.TruncateAt O0;
    public ColorStateList P;
    public boolean P0;
    public CharSequence Q;
    public int Q0;
    public boolean R;
    public boolean R0;
    public Drawable S;
    public ColorStateList T;
    public float U;
    public boolean V;
    public boolean W;
    public Drawable X;
    public RippleDrawable Y;
    public ColorStateList Z;

    /* renamed from: a0, reason: collision with root package name */
    public float f8976a0;

    /* renamed from: b0, reason: collision with root package name */
    public CharSequence f8977b0;

    /* renamed from: c0, reason: collision with root package name */
    public boolean f8978c0;

    /* renamed from: d0, reason: collision with root package name */
    public boolean f8979d0;

    /* renamed from: e0, reason: collision with root package name */
    public Drawable f8980e0;

    /* renamed from: f0, reason: collision with root package name */
    public ColorStateList f8981f0;

    /* renamed from: g0, reason: collision with root package name */
    public h f8982g0;

    /* renamed from: h0, reason: collision with root package name */
    public h f8983h0;

    /* renamed from: i0, reason: collision with root package name */
    public float f8984i0;

    /* renamed from: j0, reason: collision with root package name */
    public float f8985j0;

    /* renamed from: k0, reason: collision with root package name */
    public float f8986k0;

    /* renamed from: l0, reason: collision with root package name */
    public float f8987l0;

    /* renamed from: m0, reason: collision with root package name */
    public float f8988m0;

    /* renamed from: n0, reason: collision with root package name */
    public float f8989n0;

    /* renamed from: o0, reason: collision with root package name */
    public float f8990o0;

    /* renamed from: p0, reason: collision with root package name */
    public float f8991p0;

    /* renamed from: q0, reason: collision with root package name */
    public final Context f8992q0;

    /* renamed from: r0, reason: collision with root package name */
    public final Paint f8993r0;

    /* renamed from: s0, reason: collision with root package name */
    public final Paint.FontMetrics f8994s0;

    /* renamed from: t0, reason: collision with root package name */
    public final RectF f8995t0;

    /* renamed from: u0, reason: collision with root package name */
    public final PointF f8996u0;

    /* renamed from: v0, reason: collision with root package name */
    public final Path f8997v0;

    /* renamed from: w0, reason: collision with root package name */
    public final p f8998w0;

    /* renamed from: x0, reason: collision with root package name */
    public int f8999x0;

    /* renamed from: y0, reason: collision with root package name */
    public int f9000y0;

    /* renamed from: z0, reason: collision with root package name */
    public int f9001z0;

    /* compiled from: ChipDrawable.java */
    /* renamed from: com.google.android.material.chip.a$a, reason: collision with other inner class name */
    public interface InterfaceC0085a {
        void onChipDrawableSizeChange();
    }

    public a(Context context, AttributeSet attributeSet, int i10, int i11) {
        super(context, attributeSet, i10, i11);
        this.M = -1.0f;
        this.f8993r0 = new Paint(1);
        this.f8994s0 = new Paint.FontMetrics();
        this.f8995t0 = new RectF();
        this.f8996u0 = new PointF();
        this.f8997v0 = new Path();
        this.F0 = 255;
        this.J0 = PorterDuff.Mode.SRC_IN;
        this.N0 = new WeakReference<>(null);
        initializeElevationOverlay(context);
        this.f8992q0 = context;
        p pVar = new p(this);
        this.f8998w0 = pVar;
        this.Q = "";
        pVar.getTextPaint().density = context.getResources().getDisplayMetrics().density;
        int[] iArr = S0;
        setState(iArr);
        setCloseIconState(iArr);
        this.P0 = true;
        int[] iArr2 = b.f17032a;
        T0.setTint(-1);
    }

    public static a createFromAttributes(Context context, AttributeSet attributeSet, int i10, int i11) {
        a aVar = new a(context, attributeSet, i10, i11);
        TypedArray typedArrayObtainStyledAttributes = r.obtainStyledAttributes(aVar.f8992q0, attributeSet, com.google.android.material.R.styleable.Chip, i10, i11, new int[0]);
        aVar.R0 = typedArrayObtainStyledAttributes.hasValue(com.google.android.material.R.styleable.Chip_shapeAppearance);
        int i12 = com.google.android.material.R.styleable.Chip_chipSurfaceColor;
        Context context2 = aVar.f8992q0;
        ColorStateList colorStateList = c.getColorStateList(context2, typedArrayObtainStyledAttributes, i12);
        if (aVar.J != colorStateList) {
            aVar.J = colorStateList;
            aVar.onStateChange(aVar.getState());
        }
        aVar.setChipBackgroundColor(c.getColorStateList(context2, typedArrayObtainStyledAttributes, com.google.android.material.R.styleable.Chip_chipBackgroundColor));
        aVar.setChipMinHeight(typedArrayObtainStyledAttributes.getDimension(com.google.android.material.R.styleable.Chip_chipMinHeight, 0.0f));
        int i13 = com.google.android.material.R.styleable.Chip_chipCornerRadius;
        if (typedArrayObtainStyledAttributes.hasValue(i13)) {
            aVar.setChipCornerRadius(typedArrayObtainStyledAttributes.getDimension(i13, 0.0f));
        }
        aVar.setChipStrokeColor(c.getColorStateList(context2, typedArrayObtainStyledAttributes, com.google.android.material.R.styleable.Chip_chipStrokeColor));
        aVar.setChipStrokeWidth(typedArrayObtainStyledAttributes.getDimension(com.google.android.material.R.styleable.Chip_chipStrokeWidth, 0.0f));
        aVar.setRippleColor(c.getColorStateList(context2, typedArrayObtainStyledAttributes, com.google.android.material.R.styleable.Chip_rippleColor));
        aVar.setText(typedArrayObtainStyledAttributes.getText(com.google.android.material.R.styleable.Chip_android_text));
        d textAppearance = c.getTextAppearance(context2, typedArrayObtainStyledAttributes, com.google.android.material.R.styleable.Chip_android_textAppearance);
        textAppearance.setTextSize(typedArrayObtainStyledAttributes.getDimension(com.google.android.material.R.styleable.Chip_android_textSize, textAppearance.getTextSize()));
        if (Build.VERSION.SDK_INT < 23) {
            textAppearance.setTextColor(c.getColorStateList(context2, typedArrayObtainStyledAttributes, com.google.android.material.R.styleable.Chip_android_textColor));
        }
        aVar.setTextAppearance(textAppearance);
        int i14 = typedArrayObtainStyledAttributes.getInt(com.google.android.material.R.styleable.Chip_android_ellipsize, 0);
        if (i14 == 1) {
            aVar.setEllipsize(TextUtils.TruncateAt.START);
        } else if (i14 == 2) {
            aVar.setEllipsize(TextUtils.TruncateAt.MIDDLE);
        } else if (i14 == 3) {
            aVar.setEllipsize(TextUtils.TruncateAt.END);
        }
        aVar.setChipIconVisible(typedArrayObtainStyledAttributes.getBoolean(com.google.android.material.R.styleable.Chip_chipIconVisible, false));
        if (attributeSet != null && attributeSet.getAttributeValue("http://schemas.android.com/apk/res-auto", "chipIconEnabled") != null && attributeSet.getAttributeValue("http://schemas.android.com/apk/res-auto", "chipIconVisible") == null) {
            aVar.setChipIconVisible(typedArrayObtainStyledAttributes.getBoolean(com.google.android.material.R.styleable.Chip_chipIconEnabled, false));
        }
        aVar.setChipIcon(c.getDrawable(context2, typedArrayObtainStyledAttributes, com.google.android.material.R.styleable.Chip_chipIcon));
        int i15 = com.google.android.material.R.styleable.Chip_chipIconTint;
        if (typedArrayObtainStyledAttributes.hasValue(i15)) {
            aVar.setChipIconTint(c.getColorStateList(context2, typedArrayObtainStyledAttributes, i15));
        }
        aVar.setChipIconSize(typedArrayObtainStyledAttributes.getDimension(com.google.android.material.R.styleable.Chip_chipIconSize, -1.0f));
        aVar.setCloseIconVisible(typedArrayObtainStyledAttributes.getBoolean(com.google.android.material.R.styleable.Chip_closeIconVisible, false));
        if (attributeSet != null && attributeSet.getAttributeValue("http://schemas.android.com/apk/res-auto", "closeIconEnabled") != null && attributeSet.getAttributeValue("http://schemas.android.com/apk/res-auto", "closeIconVisible") == null) {
            aVar.setCloseIconVisible(typedArrayObtainStyledAttributes.getBoolean(com.google.android.material.R.styleable.Chip_closeIconEnabled, false));
        }
        aVar.setCloseIcon(c.getDrawable(context2, typedArrayObtainStyledAttributes, com.google.android.material.R.styleable.Chip_closeIcon));
        aVar.setCloseIconTint(c.getColorStateList(context2, typedArrayObtainStyledAttributes, com.google.android.material.R.styleable.Chip_closeIconTint));
        aVar.setCloseIconSize(typedArrayObtainStyledAttributes.getDimension(com.google.android.material.R.styleable.Chip_closeIconSize, 0.0f));
        aVar.setCheckable(typedArrayObtainStyledAttributes.getBoolean(com.google.android.material.R.styleable.Chip_android_checkable, false));
        aVar.setCheckedIconVisible(typedArrayObtainStyledAttributes.getBoolean(com.google.android.material.R.styleable.Chip_checkedIconVisible, false));
        if (attributeSet != null && attributeSet.getAttributeValue("http://schemas.android.com/apk/res-auto", "checkedIconEnabled") != null && attributeSet.getAttributeValue("http://schemas.android.com/apk/res-auto", "checkedIconVisible") == null) {
            aVar.setCheckedIconVisible(typedArrayObtainStyledAttributes.getBoolean(com.google.android.material.R.styleable.Chip_checkedIconEnabled, false));
        }
        aVar.setCheckedIcon(c.getDrawable(context2, typedArrayObtainStyledAttributes, com.google.android.material.R.styleable.Chip_checkedIcon));
        int i16 = com.google.android.material.R.styleable.Chip_checkedIconTint;
        if (typedArrayObtainStyledAttributes.hasValue(i16)) {
            aVar.setCheckedIconTint(c.getColorStateList(context2, typedArrayObtainStyledAttributes, i16));
        }
        aVar.setShowMotionSpec(h.createFromAttribute(context2, typedArrayObtainStyledAttributes, com.google.android.material.R.styleable.Chip_showMotionSpec));
        aVar.setHideMotionSpec(h.createFromAttribute(context2, typedArrayObtainStyledAttributes, com.google.android.material.R.styleable.Chip_hideMotionSpec));
        aVar.setChipStartPadding(typedArrayObtainStyledAttributes.getDimension(com.google.android.material.R.styleable.Chip_chipStartPadding, 0.0f));
        aVar.setIconStartPadding(typedArrayObtainStyledAttributes.getDimension(com.google.android.material.R.styleable.Chip_iconStartPadding, 0.0f));
        aVar.setIconEndPadding(typedArrayObtainStyledAttributes.getDimension(com.google.android.material.R.styleable.Chip_iconEndPadding, 0.0f));
        aVar.setTextStartPadding(typedArrayObtainStyledAttributes.getDimension(com.google.android.material.R.styleable.Chip_textStartPadding, 0.0f));
        aVar.setTextEndPadding(typedArrayObtainStyledAttributes.getDimension(com.google.android.material.R.styleable.Chip_textEndPadding, 0.0f));
        aVar.setCloseIconStartPadding(typedArrayObtainStyledAttributes.getDimension(com.google.android.material.R.styleable.Chip_closeIconStartPadding, 0.0f));
        aVar.setCloseIconEndPadding(typedArrayObtainStyledAttributes.getDimension(com.google.android.material.R.styleable.Chip_closeIconEndPadding, 0.0f));
        aVar.setChipEndPadding(typedArrayObtainStyledAttributes.getDimension(com.google.android.material.R.styleable.Chip_chipEndPadding, 0.0f));
        aVar.setMaxWidth(typedArrayObtainStyledAttributes.getDimensionPixelSize(com.google.android.material.R.styleable.Chip_android_maxWidth, Integer.MAX_VALUE));
        typedArrayObtainStyledAttributes.recycle();
        return aVar;
    }

    public static boolean l(ColorStateList colorStateList) {
        return colorStateList != null && colorStateList.isStateful();
    }

    public static boolean m(Drawable drawable) {
        return drawable != null && drawable.isStateful();
    }

    public static void r(Drawable drawable) {
        if (drawable != null) {
            drawable.setCallback(null);
        }
    }

    @Override // q7.g, android.graphics.drawable.Drawable
    public void draw(Canvas canvas) {
        int i10;
        Rect bounds = getBounds();
        if (bounds.isEmpty() || getAlpha() == 0) {
            return;
        }
        int i11 = this.F0;
        int iSaveLayerAlpha = i11 < 255 ? v6.a.saveLayerAlpha(canvas, bounds.left, bounds.top, bounds.right, bounds.bottom, i11) : 0;
        boolean z10 = this.R0;
        Paint paint = this.f8993r0;
        RectF rectF = this.f8995t0;
        if (!z10) {
            paint.setColor(this.f8999x0);
            paint.setStyle(Paint.Style.FILL);
            rectF.set(bounds);
            canvas.drawRoundRect(rectF, getChipCornerRadius(), getChipCornerRadius(), paint);
        }
        if (!this.R0) {
            paint.setColor(this.f9000y0);
            paint.setStyle(Paint.Style.FILL);
            ColorFilter colorFilter = this.G0;
            if (colorFilter == null) {
                colorFilter = this.H0;
            }
            paint.setColorFilter(colorFilter);
            rectF.set(bounds);
            canvas.drawRoundRect(rectF, getChipCornerRadius(), getChipCornerRadius(), paint);
        }
        if (this.R0) {
            super.draw(canvas);
        }
        if (this.O > 0.0f && !this.R0) {
            paint.setColor(this.A0);
            paint.setStyle(Paint.Style.STROKE);
            if (!this.R0) {
                ColorFilter colorFilter2 = this.G0;
                if (colorFilter2 == null) {
                    colorFilter2 = this.H0;
                }
                paint.setColorFilter(colorFilter2);
            }
            float f10 = bounds.left;
            float f11 = this.O / 2.0f;
            rectF.set(f10 + f11, bounds.top + f11, bounds.right - f11, bounds.bottom - f11);
            float f12 = this.M - (this.O / 2.0f);
            canvas.drawRoundRect(rectF, f12, f12, paint);
        }
        paint.setColor(this.B0);
        paint.setStyle(Paint.Style.FILL);
        rectF.set(bounds);
        if (this.R0) {
            RectF rectF2 = new RectF(bounds);
            Path path = this.f8997v0;
            calculatePathForSize(rectF2, path);
            super.drawShape(canvas, paint, path, getBoundsAsRectF());
        } else {
            canvas.drawRoundRect(rectF, getChipCornerRadius(), getChipCornerRadius(), paint);
        }
        if (p()) {
            i(bounds, rectF);
            float f13 = rectF.left;
            float f14 = rectF.top;
            canvas.translate(f13, f14);
            this.S.setBounds(0, 0, (int) rectF.width(), (int) rectF.height());
            this.S.draw(canvas);
            canvas.translate(-f13, -f14);
        }
        if (o()) {
            i(bounds, rectF);
            float f15 = rectF.left;
            float f16 = rectF.top;
            canvas.translate(f15, f16);
            this.f8980e0.setBounds(0, 0, (int) rectF.width(), (int) rectF.height());
            this.f8980e0.draw(canvas);
            canvas.translate(-f15, -f16);
        }
        if (this.P0 && this.Q != null) {
            PointF pointF = this.f8996u0;
            pointF.set(0.0f, 0.0f);
            Paint.Align align = Paint.Align.LEFT;
            CharSequence charSequence = this.Q;
            p pVar = this.f8998w0;
            if (charSequence != null) {
                float fJ = j() + this.f8984i0 + this.f8987l0;
                if (p0.a.getLayoutDirection(this) == 0) {
                    pointF.x = bounds.left + fJ;
                    align = Paint.Align.LEFT;
                } else {
                    pointF.x = bounds.right - fJ;
                    align = Paint.Align.RIGHT;
                }
                float fCenterY = bounds.centerY();
                TextPaint textPaint = pVar.getTextPaint();
                Paint.FontMetrics fontMetrics = this.f8994s0;
                textPaint.getFontMetrics(fontMetrics);
                pointF.y = fCenterY - ((fontMetrics.descent + fontMetrics.ascent) / 2.0f);
            }
            rectF.setEmpty();
            if (this.Q != null) {
                float fJ2 = j() + this.f8984i0 + this.f8987l0;
                float fK = k() + this.f8991p0 + this.f8988m0;
                if (p0.a.getLayoutDirection(this) == 0) {
                    rectF.left = bounds.left + fJ2;
                    rectF.right = bounds.right - fK;
                } else {
                    rectF.left = bounds.left + fK;
                    rectF.right = bounds.right - fJ2;
                }
                rectF.top = bounds.top;
                rectF.bottom = bounds.bottom;
            }
            if (pVar.getTextAppearance() != null) {
                pVar.getTextPaint().drawableState = getState();
                pVar.updateTextPaintDrawState(this.f8992q0);
            }
            pVar.getTextPaint().setTextAlign(align);
            boolean z11 = Math.round(pVar.getTextWidth(getText().toString())) > Math.round(rectF.width());
            if (z11) {
                int iSave = canvas.save();
                canvas.clipRect(rectF);
                i10 = iSave;
            } else {
                i10 = 0;
            }
            CharSequence charSequenceEllipsize = this.Q;
            if (z11 && this.O0 != null) {
                charSequenceEllipsize = TextUtils.ellipsize(charSequenceEllipsize, pVar.getTextPaint(), rectF.width(), this.O0);
            }
            int i12 = i10;
            canvas.drawText(charSequenceEllipsize, 0, charSequenceEllipsize.length(), pointF.x, pointF.y, pVar.getTextPaint());
            if (z11) {
                canvas.restoreToCount(i12);
            }
        }
        if (q()) {
            rectF.setEmpty();
            if (q()) {
                float f17 = this.f8991p0 + this.f8990o0;
                if (p0.a.getLayoutDirection(this) == 0) {
                    float f18 = bounds.right - f17;
                    rectF.right = f18;
                    rectF.left = f18 - this.f8976a0;
                } else {
                    float f19 = bounds.left + f17;
                    rectF.left = f19;
                    rectF.right = f19 + this.f8976a0;
                }
                float fExactCenterY = bounds.exactCenterY();
                float f20 = this.f8976a0;
                float f21 = fExactCenterY - (f20 / 2.0f);
                rectF.top = f21;
                rectF.bottom = f21 + f20;
            }
            float f22 = rectF.left;
            float f23 = rectF.top;
            canvas.translate(f22, f23);
            this.X.setBounds(0, 0, (int) rectF.width(), (int) rectF.height());
            int[] iArr = b.f17032a;
            this.Y.setBounds(this.X.getBounds());
            this.Y.jumpToCurrentState();
            this.Y.draw(canvas);
            canvas.translate(-f22, -f23);
        }
        if (this.F0 < 255) {
            canvas.restoreToCount(iSaveLayerAlpha);
        }
    }

    @Override // q7.g, android.graphics.drawable.Drawable
    public int getAlpha() {
        return this.F0;
    }

    public Drawable getCheckedIcon() {
        return this.f8980e0;
    }

    public ColorStateList getCheckedIconTint() {
        return this.f8981f0;
    }

    public ColorStateList getChipBackgroundColor() {
        return this.K;
    }

    public float getChipCornerRadius() {
        return this.R0 ? getTopLeftCornerResolvedSize() : this.M;
    }

    public float getChipEndPadding() {
        return this.f8991p0;
    }

    public Drawable getChipIcon() {
        Drawable drawable = this.S;
        if (drawable != null) {
            return p0.a.unwrap(drawable);
        }
        return null;
    }

    public float getChipIconSize() {
        return this.U;
    }

    public ColorStateList getChipIconTint() {
        return this.T;
    }

    public float getChipMinHeight() {
        return this.L;
    }

    public float getChipStartPadding() {
        return this.f8984i0;
    }

    public ColorStateList getChipStrokeColor() {
        return this.N;
    }

    public float getChipStrokeWidth() {
        return this.O;
    }

    public Drawable getCloseIcon() {
        Drawable drawable = this.X;
        if (drawable != null) {
            return p0.a.unwrap(drawable);
        }
        return null;
    }

    public CharSequence getCloseIconContentDescription() {
        return this.f8977b0;
    }

    public float getCloseIconEndPadding() {
        return this.f8990o0;
    }

    public float getCloseIconSize() {
        return this.f8976a0;
    }

    public float getCloseIconStartPadding() {
        return this.f8989n0;
    }

    public int[] getCloseIconState() {
        return this.K0;
    }

    public ColorStateList getCloseIconTint() {
        return this.Z;
    }

    public void getCloseIconTouchBounds(RectF rectF) {
        Rect bounds = getBounds();
        rectF.setEmpty();
        if (q()) {
            float f10 = this.f8991p0 + this.f8990o0 + this.f8976a0 + this.f8989n0 + this.f8988m0;
            if (p0.a.getLayoutDirection(this) == 0) {
                float f11 = bounds.right;
                rectF.right = f11;
                rectF.left = f11 - f10;
            } else {
                float f12 = bounds.left;
                rectF.left = f12;
                rectF.right = f12 + f10;
            }
            rectF.top = bounds.top;
            rectF.bottom = bounds.bottom;
        }
    }

    @Override // android.graphics.drawable.Drawable
    public ColorFilter getColorFilter() {
        return this.G0;
    }

    public TextUtils.TruncateAt getEllipsize() {
        return this.O0;
    }

    public h getHideMotionSpec() {
        return this.f8983h0;
    }

    public float getIconEndPadding() {
        return this.f8986k0;
    }

    public float getIconStartPadding() {
        return this.f8985j0;
    }

    @Override // android.graphics.drawable.Drawable
    public int getIntrinsicHeight() {
        return (int) this.L;
    }

    @Override // android.graphics.drawable.Drawable
    public int getIntrinsicWidth() {
        return Math.min(Math.round(k() + this.f8998w0.getTextWidth(getText().toString()) + j() + this.f8984i0 + this.f8987l0 + this.f8988m0 + this.f8991p0), this.Q0);
    }

    @Override // q7.g, android.graphics.drawable.Drawable
    public int getOpacity() {
        return -3;
    }

    @Override // q7.g, android.graphics.drawable.Drawable
    @TargetApi(21)
    public void getOutline(Outline outline) {
        if (this.R0) {
            super.getOutline(outline);
            return;
        }
        Rect bounds = getBounds();
        if (bounds.isEmpty()) {
            outline.setRoundRect(0, 0, getIntrinsicWidth(), getIntrinsicHeight(), this.M);
        } else {
            outline.setRoundRect(bounds, this.M);
        }
        outline.setAlpha(getAlpha() / 255.0f);
    }

    public ColorStateList getRippleColor() {
        return this.P;
    }

    public h getShowMotionSpec() {
        return this.f8982g0;
    }

    public CharSequence getText() {
        return this.Q;
    }

    public d getTextAppearance() {
        return this.f8998w0.getTextAppearance();
    }

    public float getTextEndPadding() {
        return this.f8988m0;
    }

    public float getTextStartPadding() {
        return this.f8987l0;
    }

    public boolean getUseCompatRipple() {
        return this.L0;
    }

    public final void h(Drawable drawable) throws IllegalAccessException, NoSuchMethodException, SecurityException, IllegalArgumentException, InvocationTargetException {
        if (drawable == null) {
            return;
        }
        drawable.setCallback(this);
        p0.a.setLayoutDirection(drawable, p0.a.getLayoutDirection(this));
        drawable.setLevel(getLevel());
        drawable.setVisible(isVisible(), false);
        if (drawable == this.X) {
            if (drawable.isStateful()) {
                drawable.setState(getCloseIconState());
            }
            p0.a.setTintList(drawable, this.Z);
            return;
        }
        Drawable drawable2 = this.S;
        if (drawable == drawable2 && this.V) {
            p0.a.setTintList(drawable2, this.T);
        }
        if (drawable.isStateful()) {
            drawable.setState(getState());
        }
    }

    /* JADX WARN: Removed duplicated region for block: B:28:0x0072 A[PHI: r1
  0x0072: PHI (r1v10 float) = (r1v9 float), (r1v9 float), (r1v17 float) binds: [B:23:0x0051, B:24:0x0053, B:26:0x006a] A[DONT_GENERATE, DONT_INLINE]] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public final void i(android.graphics.Rect r6, android.graphics.RectF r7) {
        /*
            r5 = this;
            r7.setEmpty()
            boolean r0 = r5.p()
            if (r0 != 0) goto Lf
            boolean r0 = r5.o()
            if (r0 == 0) goto L81
        Lf:
            float r0 = r5.f8984i0
            float r1 = r5.f8985j0
            float r0 = r0 + r1
            boolean r1 = r5.D0
            if (r1 == 0) goto L1b
            android.graphics.drawable.Drawable r1 = r5.f8980e0
            goto L1d
        L1b:
            android.graphics.drawable.Drawable r1 = r5.S
        L1d:
            float r2 = r5.U
            r3 = 0
            int r4 = (r2 > r3 ? 1 : (r2 == r3 ? 0 : -1))
            if (r4 > 0) goto L2b
            if (r1 == 0) goto L2b
            int r1 = r1.getIntrinsicWidth()
            float r2 = (float) r1
        L2b:
            int r1 = p0.a.getLayoutDirection(r5)
            if (r1 != 0) goto L3b
            int r1 = r6.left
            float r1 = (float) r1
            float r1 = r1 + r0
            r7.left = r1
            float r1 = r1 + r2
            r7.right = r1
            goto L44
        L3b:
            int r1 = r6.right
            float r1 = (float) r1
            float r1 = r1 - r0
            r7.right = r1
            float r1 = r1 - r2
            r7.left = r1
        L44:
            boolean r0 = r5.D0
            if (r0 == 0) goto L4b
            android.graphics.drawable.Drawable r0 = r5.f8980e0
            goto L4d
        L4b:
            android.graphics.drawable.Drawable r0 = r5.S
        L4d:
            float r1 = r5.U
            int r2 = (r1 > r3 ? 1 : (r1 == r3 ? 0 : -1))
            if (r2 > 0) goto L72
            if (r0 == 0) goto L72
            android.content.Context r1 = r5.f8992q0
            r2 = 24
            float r1 = i7.t.dpToPx(r1, r2)
            double r1 = (double) r1
            double r1 = java.lang.Math.ceil(r1)
            float r1 = (float) r1
            int r2 = r0.getIntrinsicHeight()
            float r2 = (float) r2
            int r2 = (r2 > r1 ? 1 : (r2 == r1 ? 0 : -1))
            if (r2 > 0) goto L72
            int r0 = r0.getIntrinsicHeight()
            float r0 = (float) r0
            goto L73
        L72:
            r0 = r1
        L73:
            float r6 = r6.exactCenterY()
            r1 = 1073741824(0x40000000, float:2.0)
            float r1 = r0 / r1
            float r6 = r6 - r1
            r7.top = r6
            float r6 = r6 + r0
            r7.bottom = r6
        L81:
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.material.chip.a.i(android.graphics.Rect, android.graphics.RectF):void");
    }

    @Override // android.graphics.drawable.Drawable.Callback
    public void invalidateDrawable(Drawable drawable) {
        Drawable.Callback callback = getCallback();
        if (callback != null) {
            callback.invalidateDrawable(this);
        }
    }

    public boolean isCheckable() {
        return this.f8978c0;
    }

    public boolean isCloseIconStateful() {
        return m(this.X);
    }

    public boolean isCloseIconVisible() {
        return this.W;
    }

    @Override // q7.g, android.graphics.drawable.Drawable
    public boolean isStateful() {
        if (l(this.J) || l(this.K) || l(this.N)) {
            return true;
        }
        if (this.L0 && l(this.M0)) {
            return true;
        }
        d textAppearance = this.f8998w0.getTextAppearance();
        if ((textAppearance == null || textAppearance.getTextColor() == null || !textAppearance.getTextColor().isStateful()) ? false : true) {
            return true;
        }
        return (this.f8979d0 && this.f8980e0 != null && this.f8978c0) || m(this.S) || m(this.f8980e0) || l(this.I0);
    }

    public final float j() {
        if (!p() && !o()) {
            return 0.0f;
        }
        float f10 = this.f8985j0;
        Drawable drawable = this.D0 ? this.f8980e0 : this.S;
        float intrinsicWidth = this.U;
        if (intrinsicWidth <= 0.0f && drawable != null) {
            intrinsicWidth = drawable.getIntrinsicWidth();
        }
        return intrinsicWidth + f10 + this.f8986k0;
    }

    public final float k() {
        if (q()) {
            return this.f8989n0 + this.f8976a0 + this.f8990o0;
        }
        return 0.0f;
    }

    public final boolean n(int[] iArr, int[] iArr2) {
        boolean z10;
        boolean z11;
        boolean zOnStateChange = super.onStateChange(iArr);
        ColorStateList colorStateList = this.J;
        int iCompositeElevationOverlayIfNeeded = compositeElevationOverlayIfNeeded(colorStateList != null ? colorStateList.getColorForState(iArr, this.f8999x0) : 0);
        boolean state = true;
        if (this.f8999x0 != iCompositeElevationOverlayIfNeeded) {
            this.f8999x0 = iCompositeElevationOverlayIfNeeded;
            zOnStateChange = true;
        }
        ColorStateList colorStateList2 = this.K;
        int iCompositeElevationOverlayIfNeeded2 = compositeElevationOverlayIfNeeded(colorStateList2 != null ? colorStateList2.getColorForState(iArr, this.f9000y0) : 0);
        if (this.f9000y0 != iCompositeElevationOverlayIfNeeded2) {
            this.f9000y0 = iCompositeElevationOverlayIfNeeded2;
            zOnStateChange = true;
        }
        int iLayer = c7.a.layer(iCompositeElevationOverlayIfNeeded, iCompositeElevationOverlayIfNeeded2);
        if ((this.f9001z0 != iLayer) | (getFillColor() == null)) {
            this.f9001z0 = iLayer;
            setFillColor(ColorStateList.valueOf(iLayer));
            zOnStateChange = true;
        }
        ColorStateList colorStateList3 = this.N;
        int colorForState = colorStateList3 != null ? colorStateList3.getColorForState(iArr, this.A0) : 0;
        if (this.A0 != colorForState) {
            this.A0 = colorForState;
            zOnStateChange = true;
        }
        int colorForState2 = (this.M0 == null || !b.shouldDrawRippleCompat(iArr)) ? 0 : this.M0.getColorForState(iArr, this.B0);
        if (this.B0 != colorForState2) {
            this.B0 = colorForState2;
            if (this.L0) {
                zOnStateChange = true;
            }
        }
        p pVar = this.f8998w0;
        int colorForState3 = (pVar.getTextAppearance() == null || pVar.getTextAppearance().getTextColor() == null) ? 0 : pVar.getTextAppearance().getTextColor().getColorForState(iArr, this.C0);
        if (this.C0 != colorForState3) {
            this.C0 = colorForState3;
            zOnStateChange = true;
        }
        int[] state2 = getState();
        if (state2 == null) {
            z10 = false;
        } else {
            for (int i10 : state2) {
                if (i10 == 16842912) {
                    z10 = true;
                    break;
                }
            }
            z10 = false;
        }
        boolean z12 = z10 && this.f8978c0;
        if (this.D0 == z12 || this.f8980e0 == null) {
            z11 = false;
        } else {
            float fJ = j();
            this.D0 = z12;
            if (fJ != j()) {
                zOnStateChange = true;
                z11 = true;
            } else {
                zOnStateChange = true;
                z11 = false;
            }
        }
        ColorStateList colorStateList4 = this.I0;
        int colorForState4 = colorStateList4 != null ? colorStateList4.getColorForState(iArr, this.E0) : 0;
        if (this.E0 != colorForState4) {
            this.E0 = colorForState4;
            this.H0 = e7.a.updateTintFilter(this, this.I0, this.J0);
        } else {
            state = zOnStateChange;
        }
        if (m(this.S)) {
            state |= this.S.setState(iArr);
        }
        if (m(this.f8980e0)) {
            state |= this.f8980e0.setState(iArr);
        }
        if (m(this.X)) {
            int[] iArr3 = new int[iArr.length + iArr2.length];
            System.arraycopy(iArr, 0, iArr3, 0, iArr.length);
            System.arraycopy(iArr2, 0, iArr3, iArr.length, iArr2.length);
            state |= this.X.setState(iArr3);
        }
        int[] iArr4 = b.f17032a;
        if (m(this.Y)) {
            state |= this.Y.setState(iArr2);
        }
        if (state) {
            invalidateSelf();
        }
        if (z11) {
            onSizeChange();
        }
        return state;
    }

    public final boolean o() {
        return this.f8979d0 && this.f8980e0 != null && this.D0;
    }

    @Override // android.graphics.drawable.Drawable
    public boolean onLayoutDirectionChanged(int i10) {
        boolean zOnLayoutDirectionChanged = super.onLayoutDirectionChanged(i10);
        if (p()) {
            zOnLayoutDirectionChanged |= p0.a.setLayoutDirection(this.S, i10);
        }
        if (o()) {
            zOnLayoutDirectionChanged |= p0.a.setLayoutDirection(this.f8980e0, i10);
        }
        if (q()) {
            zOnLayoutDirectionChanged |= p0.a.setLayoutDirection(this.X, i10);
        }
        if (!zOnLayoutDirectionChanged) {
            return true;
        }
        invalidateSelf();
        return true;
    }

    @Override // android.graphics.drawable.Drawable
    public boolean onLevelChange(int i10) {
        boolean zOnLevelChange = super.onLevelChange(i10);
        if (p()) {
            zOnLevelChange |= this.S.setLevel(i10);
        }
        if (o()) {
            zOnLevelChange |= this.f8980e0.setLevel(i10);
        }
        if (q()) {
            zOnLevelChange |= this.X.setLevel(i10);
        }
        if (zOnLevelChange) {
            invalidateSelf();
        }
        return zOnLevelChange;
    }

    public void onSizeChange() {
        InterfaceC0085a interfaceC0085a = this.N0.get();
        if (interfaceC0085a != null) {
            interfaceC0085a.onChipDrawableSizeChange();
        }
    }

    @Override // q7.g, android.graphics.drawable.Drawable, i7.p.b
    public boolean onStateChange(int[] iArr) {
        if (this.R0) {
            super.onStateChange(iArr);
        }
        return n(iArr, getCloseIconState());
    }

    @Override // i7.p.b
    public void onTextSizeChange() {
        onSizeChange();
        invalidateSelf();
    }

    public final boolean p() {
        return this.R && this.S != null;
    }

    public final boolean q() {
        return this.W && this.X != null;
    }

    @Override // android.graphics.drawable.Drawable.Callback
    public void scheduleDrawable(Drawable drawable, Runnable runnable, long j10) {
        Drawable.Callback callback = getCallback();
        if (callback != null) {
            callback.scheduleDrawable(this, runnable, j10);
        }
    }

    @Override // q7.g, android.graphics.drawable.Drawable
    public void setAlpha(int i10) {
        if (this.F0 != i10) {
            this.F0 = i10;
            invalidateSelf();
        }
    }

    public void setCheckable(boolean z10) {
        if (this.f8978c0 != z10) {
            this.f8978c0 = z10;
            float fJ = j();
            if (!z10 && this.D0) {
                this.D0 = false;
            }
            float fJ2 = j();
            invalidateSelf();
            if (fJ != fJ2) {
                onSizeChange();
            }
        }
    }

    public void setCheckableResource(int i10) {
        setCheckable(this.f8992q0.getResources().getBoolean(i10));
    }

    public void setCheckedIcon(Drawable drawable) {
        if (this.f8980e0 != drawable) {
            float fJ = j();
            this.f8980e0 = drawable;
            float fJ2 = j();
            r(this.f8980e0);
            h(this.f8980e0);
            invalidateSelf();
            if (fJ != fJ2) {
                onSizeChange();
            }
        }
    }

    public void setCheckedIconResource(int i10) {
        setCheckedIcon(s.a.getDrawable(this.f8992q0, i10));
    }

    public void setCheckedIconTint(ColorStateList colorStateList) {
        if (this.f8981f0 != colorStateList) {
            this.f8981f0 = colorStateList;
            if (this.f8979d0 && this.f8980e0 != null && this.f8978c0) {
                p0.a.setTintList(this.f8980e0, colorStateList);
            }
            onStateChange(getState());
        }
    }

    public void setCheckedIconTintResource(int i10) {
        setCheckedIconTint(s.a.getColorStateList(this.f8992q0, i10));
    }

    public void setCheckedIconVisible(int i10) {
        setCheckedIconVisible(this.f8992q0.getResources().getBoolean(i10));
    }

    public void setChipBackgroundColor(ColorStateList colorStateList) {
        if (this.K != colorStateList) {
            this.K = colorStateList;
            onStateChange(getState());
        }
    }

    public void setChipBackgroundColorResource(int i10) {
        setChipBackgroundColor(s.a.getColorStateList(this.f8992q0, i10));
    }

    @Deprecated
    public void setChipCornerRadius(float f10) {
        if (this.M != f10) {
            this.M = f10;
            setShapeAppearanceModel(getShapeAppearanceModel().withCornerSize(f10));
        }
    }

    @Deprecated
    public void setChipCornerRadiusResource(int i10) {
        setChipCornerRadius(this.f8992q0.getResources().getDimension(i10));
    }

    public void setChipEndPadding(float f10) {
        if (this.f8991p0 != f10) {
            this.f8991p0 = f10;
            invalidateSelf();
            onSizeChange();
        }
    }

    public void setChipEndPaddingResource(int i10) {
        setChipEndPadding(this.f8992q0.getResources().getDimension(i10));
    }

    public void setChipIcon(Drawable drawable) {
        Drawable chipIcon = getChipIcon();
        if (chipIcon != drawable) {
            float fJ = j();
            this.S = drawable != null ? p0.a.wrap(drawable).mutate() : null;
            float fJ2 = j();
            r(chipIcon);
            if (p()) {
                h(this.S);
            }
            invalidateSelf();
            if (fJ != fJ2) {
                onSizeChange();
            }
        }
    }

    public void setChipIconResource(int i10) {
        setChipIcon(s.a.getDrawable(this.f8992q0, i10));
    }

    public void setChipIconSize(float f10) {
        if (this.U != f10) {
            float fJ = j();
            this.U = f10;
            float fJ2 = j();
            invalidateSelf();
            if (fJ != fJ2) {
                onSizeChange();
            }
        }
    }

    public void setChipIconSizeResource(int i10) {
        setChipIconSize(this.f8992q0.getResources().getDimension(i10));
    }

    public void setChipIconTint(ColorStateList colorStateList) {
        this.V = true;
        if (this.T != colorStateList) {
            this.T = colorStateList;
            if (p()) {
                p0.a.setTintList(this.S, colorStateList);
            }
            onStateChange(getState());
        }
    }

    public void setChipIconTintResource(int i10) {
        setChipIconTint(s.a.getColorStateList(this.f8992q0, i10));
    }

    public void setChipIconVisible(int i10) {
        setChipIconVisible(this.f8992q0.getResources().getBoolean(i10));
    }

    public void setChipMinHeight(float f10) {
        if (this.L != f10) {
            this.L = f10;
            invalidateSelf();
            onSizeChange();
        }
    }

    public void setChipMinHeightResource(int i10) {
        setChipMinHeight(this.f8992q0.getResources().getDimension(i10));
    }

    public void setChipStartPadding(float f10) {
        if (this.f8984i0 != f10) {
            this.f8984i0 = f10;
            invalidateSelf();
            onSizeChange();
        }
    }

    public void setChipStartPaddingResource(int i10) {
        setChipStartPadding(this.f8992q0.getResources().getDimension(i10));
    }

    public void setChipStrokeColor(ColorStateList colorStateList) {
        if (this.N != colorStateList) {
            this.N = colorStateList;
            if (this.R0) {
                setStrokeColor(colorStateList);
            }
            onStateChange(getState());
        }
    }

    public void setChipStrokeColorResource(int i10) {
        setChipStrokeColor(s.a.getColorStateList(this.f8992q0, i10));
    }

    public void setChipStrokeWidth(float f10) {
        if (this.O != f10) {
            this.O = f10;
            this.f8993r0.setStrokeWidth(f10);
            if (this.R0) {
                super.setStrokeWidth(f10);
            }
            invalidateSelf();
        }
    }

    public void setChipStrokeWidthResource(int i10) {
        setChipStrokeWidth(this.f8992q0.getResources().getDimension(i10));
    }

    public void setCloseIcon(Drawable drawable) {
        Drawable closeIcon = getCloseIcon();
        if (closeIcon != drawable) {
            float fK = k();
            this.X = drawable != null ? p0.a.wrap(drawable).mutate() : null;
            int[] iArr = b.f17032a;
            this.Y = new RippleDrawable(b.sanitizeRippleDrawableColor(getRippleColor()), this.X, T0);
            float fK2 = k();
            r(closeIcon);
            if (q()) {
                h(this.X);
            }
            invalidateSelf();
            if (fK != fK2) {
                onSizeChange();
            }
        }
    }

    public void setCloseIconContentDescription(CharSequence charSequence) {
        if (this.f8977b0 != charSequence) {
            this.f8977b0 = v0.a.getInstance().unicodeWrap(charSequence);
            invalidateSelf();
        }
    }

    public void setCloseIconEndPadding(float f10) {
        if (this.f8990o0 != f10) {
            this.f8990o0 = f10;
            invalidateSelf();
            if (q()) {
                onSizeChange();
            }
        }
    }

    public void setCloseIconEndPaddingResource(int i10) {
        setCloseIconEndPadding(this.f8992q0.getResources().getDimension(i10));
    }

    public void setCloseIconResource(int i10) {
        setCloseIcon(s.a.getDrawable(this.f8992q0, i10));
    }

    public void setCloseIconSize(float f10) {
        if (this.f8976a0 != f10) {
            this.f8976a0 = f10;
            invalidateSelf();
            if (q()) {
                onSizeChange();
            }
        }
    }

    public void setCloseIconSizeResource(int i10) {
        setCloseIconSize(this.f8992q0.getResources().getDimension(i10));
    }

    public void setCloseIconStartPadding(float f10) {
        if (this.f8989n0 != f10) {
            this.f8989n0 = f10;
            invalidateSelf();
            if (q()) {
                onSizeChange();
            }
        }
    }

    public void setCloseIconStartPaddingResource(int i10) {
        setCloseIconStartPadding(this.f8992q0.getResources().getDimension(i10));
    }

    public boolean setCloseIconState(int[] iArr) {
        if (Arrays.equals(this.K0, iArr)) {
            return false;
        }
        this.K0 = iArr;
        if (q()) {
            return n(getState(), iArr);
        }
        return false;
    }

    public void setCloseIconTint(ColorStateList colorStateList) {
        if (this.Z != colorStateList) {
            this.Z = colorStateList;
            if (q()) {
                p0.a.setTintList(this.X, colorStateList);
            }
            onStateChange(getState());
        }
    }

    public void setCloseIconTintResource(int i10) {
        setCloseIconTint(s.a.getColorStateList(this.f8992q0, i10));
    }

    public void setCloseIconVisible(boolean z10) {
        if (this.W != z10) {
            boolean zQ = q();
            this.W = z10;
            boolean zQ2 = q();
            if (zQ != zQ2) {
                if (zQ2) {
                    h(this.X);
                } else {
                    r(this.X);
                }
                invalidateSelf();
                onSizeChange();
            }
        }
    }

    @Override // q7.g, android.graphics.drawable.Drawable
    public void setColorFilter(ColorFilter colorFilter) {
        if (this.G0 != colorFilter) {
            this.G0 = colorFilter;
            invalidateSelf();
        }
    }

    public void setDelegate(InterfaceC0085a interfaceC0085a) {
        this.N0 = new WeakReference<>(interfaceC0085a);
    }

    public void setEllipsize(TextUtils.TruncateAt truncateAt) {
        this.O0 = truncateAt;
    }

    public void setHideMotionSpec(h hVar) {
        this.f8983h0 = hVar;
    }

    public void setHideMotionSpecResource(int i10) {
        setHideMotionSpec(h.createFromResource(this.f8992q0, i10));
    }

    public void setIconEndPadding(float f10) {
        if (this.f8986k0 != f10) {
            float fJ = j();
            this.f8986k0 = f10;
            float fJ2 = j();
            invalidateSelf();
            if (fJ != fJ2) {
                onSizeChange();
            }
        }
    }

    public void setIconEndPaddingResource(int i10) {
        setIconEndPadding(this.f8992q0.getResources().getDimension(i10));
    }

    public void setIconStartPadding(float f10) {
        if (this.f8985j0 != f10) {
            float fJ = j();
            this.f8985j0 = f10;
            float fJ2 = j();
            invalidateSelf();
            if (fJ != fJ2) {
                onSizeChange();
            }
        }
    }

    public void setIconStartPaddingResource(int i10) {
        setIconStartPadding(this.f8992q0.getResources().getDimension(i10));
    }

    public void setMaxWidth(int i10) {
        this.Q0 = i10;
    }

    public void setRippleColor(ColorStateList colorStateList) {
        if (this.P != colorStateList) {
            this.P = colorStateList;
            this.M0 = this.L0 ? b.sanitizeRippleDrawableColor(colorStateList) : null;
            onStateChange(getState());
        }
    }

    public void setRippleColorResource(int i10) {
        setRippleColor(s.a.getColorStateList(this.f8992q0, i10));
    }

    public void setShowMotionSpec(h hVar) {
        this.f8982g0 = hVar;
    }

    public void setShowMotionSpecResource(int i10) {
        setShowMotionSpec(h.createFromResource(this.f8992q0, i10));
    }

    public void setText(CharSequence charSequence) {
        if (charSequence == null) {
            charSequence = "";
        }
        if (TextUtils.equals(this.Q, charSequence)) {
            return;
        }
        this.Q = charSequence;
        this.f8998w0.setTextWidthDirty(true);
        invalidateSelf();
        onSizeChange();
    }

    public void setTextAppearance(d dVar) {
        this.f8998w0.setTextAppearance(dVar, this.f8992q0);
    }

    public void setTextAppearanceResource(int i10) {
        setTextAppearance(new d(this.f8992q0, i10));
    }

    public void setTextEndPadding(float f10) {
        if (this.f8988m0 != f10) {
            this.f8988m0 = f10;
            invalidateSelf();
            onSizeChange();
        }
    }

    public void setTextEndPaddingResource(int i10) {
        setTextEndPadding(this.f8992q0.getResources().getDimension(i10));
    }

    public void setTextSize(float f10) {
        d textAppearance = getTextAppearance();
        if (textAppearance != null) {
            textAppearance.setTextSize(f10);
            this.f8998w0.getTextPaint().setTextSize(f10);
            onTextSizeChange();
        }
    }

    public void setTextStartPadding(float f10) {
        if (this.f8987l0 != f10) {
            this.f8987l0 = f10;
            invalidateSelf();
            onSizeChange();
        }
    }

    public void setTextStartPaddingResource(int i10) {
        setTextStartPadding(this.f8992q0.getResources().getDimension(i10));
    }

    @Override // q7.g, android.graphics.drawable.Drawable
    public void setTintList(ColorStateList colorStateList) {
        if (this.I0 != colorStateList) {
            this.I0 = colorStateList;
            onStateChange(getState());
        }
    }

    @Override // q7.g, android.graphics.drawable.Drawable
    public void setTintMode(PorterDuff.Mode mode) {
        if (this.J0 != mode) {
            this.J0 = mode;
            this.H0 = e7.a.updateTintFilter(this, this.I0, mode);
            invalidateSelf();
        }
    }

    public void setUseCompatRipple(boolean z10) {
        if (this.L0 != z10) {
            this.L0 = z10;
            this.M0 = z10 ? b.sanitizeRippleDrawableColor(this.P) : null;
            onStateChange(getState());
        }
    }

    @Override // android.graphics.drawable.Drawable
    public boolean setVisible(boolean z10, boolean z11) {
        boolean visible = super.setVisible(z10, z11);
        if (p()) {
            visible |= this.S.setVisible(z10, z11);
        }
        if (o()) {
            visible |= this.f8980e0.setVisible(z10, z11);
        }
        if (q()) {
            visible |= this.X.setVisible(z10, z11);
        }
        if (visible) {
            invalidateSelf();
        }
        return visible;
    }

    @Override // android.graphics.drawable.Drawable.Callback
    public void unscheduleDrawable(Drawable drawable, Runnable runnable) {
        Drawable.Callback callback = getCallback();
        if (callback != null) {
            callback.unscheduleDrawable(this, runnable);
        }
    }

    public void setCheckedIconVisible(boolean z10) {
        if (this.f8979d0 != z10) {
            boolean zO = o();
            this.f8979d0 = z10;
            boolean zO2 = o();
            if (zO != zO2) {
                if (zO2) {
                    h(this.f8980e0);
                } else {
                    r(this.f8980e0);
                }
                invalidateSelf();
                onSizeChange();
            }
        }
    }

    public void setChipIconVisible(boolean z10) {
        if (this.R != z10) {
            boolean zP = p();
            this.R = z10;
            boolean zP2 = p();
            if (zP != zP2) {
                if (zP2) {
                    h(this.S);
                } else {
                    r(this.S);
                }
                invalidateSelf();
                onSizeChange();
            }
        }
    }
}
