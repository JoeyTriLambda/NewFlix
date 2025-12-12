package com.google.android.material.internal;

import android.animation.TimeInterpolator;
import android.content.res.ColorStateList;
import android.content.res.Configuration;
import android.graphics.Bitmap;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.graphics.Rect;
import android.graphics.RectF;
import android.graphics.Typeface;
import android.os.Build;
import android.text.Layout;
import android.text.StaticLayout;
import android.text.TextPaint;
import android.text.TextUtils;
import android.util.Log;
import android.view.View;
import com.google.android.material.internal.StaticLayoutBuilderCompat;
import i7.o;
import n7.a;
import n7.d;
import n7.g;
import v0.f;
import x0.h;
import x0.j0;

/* compiled from: CollapsingTextHelper.java */
/* loaded from: classes.dex */
public final class a {
    public Typeface A;
    public Typeface B;
    public Typeface C;
    public n7.a D;
    public n7.a E;
    public CharSequence G;
    public CharSequence H;
    public boolean I;
    public Bitmap K;
    public float L;
    public float M;
    public float N;
    public float O;
    public float P;
    public int Q;
    public int[] R;
    public boolean S;
    public final TextPaint T;
    public final TextPaint U;
    public TimeInterpolator V;
    public TimeInterpolator W;
    public float X;
    public float Y;
    public float Z;

    /* renamed from: a, reason: collision with root package name */
    public final View f9198a;

    /* renamed from: a0, reason: collision with root package name */
    public ColorStateList f9199a0;

    /* renamed from: b, reason: collision with root package name */
    public float f9200b;

    /* renamed from: b0, reason: collision with root package name */
    public float f9201b0;

    /* renamed from: c, reason: collision with root package name */
    public boolean f9202c;

    /* renamed from: c0, reason: collision with root package name */
    public float f9203c0;

    /* renamed from: d, reason: collision with root package name */
    public float f9204d;

    /* renamed from: d0, reason: collision with root package name */
    public float f9205d0;

    /* renamed from: e, reason: collision with root package name */
    public float f9206e;

    /* renamed from: e0, reason: collision with root package name */
    public ColorStateList f9207e0;

    /* renamed from: f, reason: collision with root package name */
    public int f9208f;

    /* renamed from: f0, reason: collision with root package name */
    public float f9209f0;

    /* renamed from: g, reason: collision with root package name */
    public final Rect f9210g;

    /* renamed from: g0, reason: collision with root package name */
    public float f9211g0;

    /* renamed from: h, reason: collision with root package name */
    public final Rect f9212h;

    /* renamed from: h0, reason: collision with root package name */
    public float f9213h0;

    /* renamed from: i, reason: collision with root package name */
    public final RectF f9214i;

    /* renamed from: i0, reason: collision with root package name */
    public StaticLayout f9215i0;

    /* renamed from: j0, reason: collision with root package name */
    public float f9217j0;

    /* renamed from: k0, reason: collision with root package name */
    public float f9219k0;

    /* renamed from: l0, reason: collision with root package name */
    public float f9221l0;

    /* renamed from: m0, reason: collision with root package name */
    public CharSequence f9223m0;

    /* renamed from: n, reason: collision with root package name */
    public ColorStateList f9224n;

    /* renamed from: o, reason: collision with root package name */
    public ColorStateList f9226o;

    /* renamed from: p, reason: collision with root package name */
    public int f9228p;

    /* renamed from: q, reason: collision with root package name */
    public float f9230q;

    /* renamed from: r, reason: collision with root package name */
    public float f9232r;

    /* renamed from: s, reason: collision with root package name */
    public float f9233s;

    /* renamed from: t, reason: collision with root package name */
    public float f9234t;

    /* renamed from: u, reason: collision with root package name */
    public float f9235u;

    /* renamed from: v, reason: collision with root package name */
    public float f9236v;

    /* renamed from: w, reason: collision with root package name */
    public Typeface f9237w;

    /* renamed from: x, reason: collision with root package name */
    public Typeface f9238x;

    /* renamed from: y, reason: collision with root package name */
    public Typeface f9239y;

    /* renamed from: z, reason: collision with root package name */
    public Typeface f9240z;

    /* renamed from: j, reason: collision with root package name */
    public int f9216j = 16;

    /* renamed from: k, reason: collision with root package name */
    public int f9218k = 16;

    /* renamed from: l, reason: collision with root package name */
    public float f9220l = 15.0f;

    /* renamed from: m, reason: collision with root package name */
    public float f9222m = 15.0f;
    public TextUtils.TruncateAt F = TextUtils.TruncateAt.END;
    public boolean J = true;

    /* renamed from: n0, reason: collision with root package name */
    public int f9225n0 = 1;

    /* renamed from: o0, reason: collision with root package name */
    public float f9227o0 = 0.0f;

    /* renamed from: p0, reason: collision with root package name */
    public float f9229p0 = 1.0f;

    /* renamed from: q0, reason: collision with root package name */
    public int f9231q0 = StaticLayoutBuilderCompat.f9181m;

    /* compiled from: CollapsingTextHelper.java */
    /* renamed from: com.google.android.material.internal.a$a, reason: collision with other inner class name */
    public class C0088a implements a.InterfaceC0207a {
        public C0088a() {
        }

        @Override // n7.a.InterfaceC0207a
        public void apply(Typeface typeface) throws NoSuchMethodException, SecurityException {
            a.this.setCollapsedTypeface(typeface);
        }
    }

    /* compiled from: CollapsingTextHelper.java */
    public class b implements a.InterfaceC0207a {
        public b() {
        }

        @Override // n7.a.InterfaceC0207a
        public void apply(Typeface typeface) throws NoSuchMethodException, SecurityException {
            a.this.setExpandedTypeface(typeface);
        }
    }

    public a(View view) throws NoSuchMethodException, SecurityException {
        this.f9198a = view;
        TextPaint textPaint = new TextPaint(129);
        this.T = textPaint;
        this.U = new TextPaint(textPaint);
        this.f9212h = new Rect();
        this.f9210g = new Rect();
        this.f9214i = new RectF();
        float f10 = this.f9204d;
        this.f9206e = o1.a.a(1.0f, f10, 0.5f, f10);
        maybeUpdateFontWeightAdjustment(view.getContext().getResources().getConfiguration());
    }

    public static int a(int i10, int i11, float f10) {
        float f11 = 1.0f - f10;
        return Color.argb(Math.round((Color.alpha(i11) * f10) + (Color.alpha(i10) * f11)), Math.round((Color.red(i11) * f10) + (Color.red(i10) * f11)), Math.round((Color.green(i11) * f10) + (Color.green(i10) * f11)), Math.round((Color.blue(i11) * f10) + (Color.blue(i10) * f11)));
    }

    public static float e(float f10, float f11, float f12, TimeInterpolator timeInterpolator) {
        if (timeInterpolator != null) {
            f12 = timeInterpolator.getInterpolation(f12);
        }
        return p6.a.lerp(f10, f11, f12);
    }

    public final boolean b(CharSequence charSequence) {
        boolean z10 = j0.getLayoutDirection(this.f9198a) == 1;
        if (this.J) {
            return (z10 ? f.f20418d : f.f20417c).isRtl(charSequence, 0, charSequence.length());
        }
        return z10;
    }

    public final void c(float f10, boolean z10) throws NoSuchMethodException, SecurityException {
        float f11;
        float f12;
        Typeface typeface;
        boolean z11;
        Layout.Alignment alignment;
        if (this.G == null) {
            return;
        }
        float fWidth = this.f9212h.width();
        float fWidth2 = this.f9210g.width();
        if (Math.abs(f10 - 1.0f) < 1.0E-5f) {
            f11 = this.f9222m;
            f12 = this.f9209f0;
            this.L = 1.0f;
            typeface = this.f9237w;
        } else {
            float f13 = this.f9220l;
            float f14 = this.f9211g0;
            Typeface typeface2 = this.f9240z;
            if (Math.abs(f10 - 0.0f) < 1.0E-5f) {
                this.L = 1.0f;
            } else {
                this.L = e(this.f9220l, this.f9222m, f10, this.W) / this.f9220l;
            }
            float f15 = this.f9222m / this.f9220l;
            fWidth = (z10 || this.f9202c || fWidth2 * f15 <= fWidth) ? fWidth2 : Math.min(fWidth / f15, fWidth2);
            f11 = f13;
            f12 = f14;
            typeface = typeface2;
        }
        TextPaint textPaint = this.T;
        if (fWidth > 0.0f) {
            boolean z12 = this.M != f11;
            boolean z13 = this.f9213h0 != f12;
            boolean z14 = this.C != typeface;
            StaticLayout staticLayout = this.f9215i0;
            z11 = z12 || z13 || (staticLayout != null && (fWidth > ((float) staticLayout.getWidth()) ? 1 : (fWidth == ((float) staticLayout.getWidth()) ? 0 : -1)) != 0) || z14 || this.S;
            this.M = f11;
            this.f9213h0 = f12;
            this.C = typeface;
            this.S = false;
            textPaint.setLinearText(this.L != 1.0f);
        } else {
            z11 = false;
        }
        if (this.H == null || z11) {
            textPaint.setTextSize(this.M);
            textPaint.setTypeface(this.C);
            textPaint.setLetterSpacing(this.f9213h0);
            boolean zB = b(this.G);
            this.I = zB;
            int i10 = this.f9225n0;
            if (!(i10 > 1 && (!zB || this.f9202c))) {
                i10 = 1;
            }
            StaticLayout staticLayoutBuild = null;
            try {
                if (i10 == 1) {
                    alignment = Layout.Alignment.ALIGN_NORMAL;
                } else {
                    int absoluteGravity = h.getAbsoluteGravity(this.f9216j, zB ? 1 : 0) & 7;
                    alignment = absoluteGravity != 1 ? absoluteGravity != 5 ? this.I ? Layout.Alignment.ALIGN_OPPOSITE : Layout.Alignment.ALIGN_NORMAL : this.I ? Layout.Alignment.ALIGN_NORMAL : Layout.Alignment.ALIGN_OPPOSITE : Layout.Alignment.ALIGN_CENTER;
                }
                staticLayoutBuild = StaticLayoutBuilderCompat.obtain(this.G, textPaint, (int) fWidth).setEllipsize(this.F).setIsRtl(zB).setAlignment(alignment).setIncludePad(false).setMaxLines(i10).setLineSpacing(this.f9227o0, this.f9229p0).setHyphenationFrequency(this.f9231q0).setStaticLayoutBuilderConfigurer(null).build();
            } catch (StaticLayoutBuilderCompat.StaticLayoutBuilderCompatException e10) {
                Log.e("CollapsingTextHelper", e10.getCause().getMessage(), e10);
            }
            StaticLayout staticLayout2 = (StaticLayout) w0.h.checkNotNull(staticLayoutBuild);
            this.f9215i0 = staticLayout2;
            this.H = staticLayout2.getText();
        }
    }

    public final int d(ColorStateList colorStateList) {
        if (colorStateList == null) {
            return 0;
        }
        int[] iArr = this.R;
        return iArr != null ? colorStateList.getColorForState(iArr, 0) : colorStateList.getDefaultColor();
    }

    public void draw(Canvas canvas) {
        int iSave = canvas.save();
        if (this.H != null) {
            RectF rectF = this.f9214i;
            if (rectF.width() <= 0.0f || rectF.height() <= 0.0f) {
                return;
            }
            TextPaint textPaint = this.T;
            textPaint.setTextSize(this.M);
            float f10 = this.f9235u;
            float f11 = this.f9236v;
            float f12 = this.L;
            if (f12 != 1.0f && !this.f9202c) {
                canvas.scale(f12, f12, f10, f11);
            }
            boolean z10 = true;
            if (this.f9225n0 <= 1 || (this.I && !this.f9202c)) {
                z10 = false;
            }
            if (!z10 || (this.f9202c && this.f9200b <= this.f9206e)) {
                canvas.translate(f10, f11);
                this.f9215i0.draw(canvas);
            } else {
                float lineStart = this.f9235u - this.f9215i0.getLineStart(0);
                int alpha = textPaint.getAlpha();
                canvas.translate(lineStart, f11);
                if (!this.f9202c) {
                    textPaint.setAlpha((int) (this.f9221l0 * alpha));
                    if (Build.VERSION.SDK_INT >= 31) {
                        textPaint.setShadowLayer(this.N, this.O, this.P, c7.a.compositeARGBWithAlpha(this.Q, textPaint.getAlpha()));
                    }
                    this.f9215i0.draw(canvas);
                }
                if (!this.f9202c) {
                    textPaint.setAlpha((int) (this.f9219k0 * alpha));
                }
                int i10 = Build.VERSION.SDK_INT;
                if (i10 >= 31) {
                    textPaint.setShadowLayer(this.N, this.O, this.P, c7.a.compositeARGBWithAlpha(this.Q, textPaint.getAlpha()));
                }
                int lineBaseline = this.f9215i0.getLineBaseline(0);
                CharSequence charSequence = this.f9223m0;
                float f13 = lineBaseline;
                canvas.drawText(charSequence, 0, charSequence.length(), 0.0f, f13, textPaint);
                if (i10 >= 31) {
                    textPaint.setShadowLayer(this.N, this.O, this.P, this.Q);
                }
                if (!this.f9202c) {
                    String strTrim = this.f9223m0.toString().trim();
                    if (strTrim.endsWith("…")) {
                        strTrim = strTrim.substring(0, strTrim.length() - 1);
                    }
                    String str = strTrim;
                    textPaint.setAlpha(alpha);
                    canvas.drawText(str, 0, Math.min(this.f9215i0.getLineEnd(0), str.length()), 0.0f, f13, (Paint) textPaint);
                }
            }
            canvas.restoreToCount(iSave);
        }
    }

    public final boolean f(Typeface typeface) {
        n7.a aVar = this.E;
        if (aVar != null) {
            aVar.cancel();
        }
        if (this.f9239y == typeface) {
            return false;
        }
        this.f9239y = typeface;
        Typeface typefaceMaybeCopyWithFontWeightAdjustment = g.maybeCopyWithFontWeightAdjustment(this.f9198a.getContext().getResources().getConfiguration(), typeface);
        this.f9238x = typefaceMaybeCopyWithFontWeightAdjustment;
        if (typefaceMaybeCopyWithFontWeightAdjustment == null) {
            typefaceMaybeCopyWithFontWeightAdjustment = this.f9239y;
        }
        this.f9237w = typefaceMaybeCopyWithFontWeightAdjustment;
        return true;
    }

    public final boolean g(Typeface typeface) {
        n7.a aVar = this.D;
        if (aVar != null) {
            aVar.cancel();
        }
        if (this.B == typeface) {
            return false;
        }
        this.B = typeface;
        Typeface typefaceMaybeCopyWithFontWeightAdjustment = g.maybeCopyWithFontWeightAdjustment(this.f9198a.getContext().getResources().getConfiguration(), typeface);
        this.A = typefaceMaybeCopyWithFontWeightAdjustment;
        if (typefaceMaybeCopyWithFontWeightAdjustment == null) {
            typefaceMaybeCopyWithFontWeightAdjustment = this.B;
        }
        this.f9240z = typefaceMaybeCopyWithFontWeightAdjustment;
        return true;
    }

    /* JADX WARN: Removed duplicated region for block: B:40:0x0077  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public void getCollapsedTextActualBounds(android.graphics.RectF r9, int r10, int r11) {
        /*
            r8 = this;
            java.lang.CharSequence r0 = r8.G
            boolean r0 = r8.b(r0)
            r8.I = r0
            r1 = 5
            r2 = 8388613(0x800005, float:1.175495E-38)
            r3 = 1
            r4 = 1073741824(0x40000000, float:2.0)
            r5 = 17
            android.graphics.Rect r6 = r8.f9212h
            if (r11 == r5) goto L3b
            r7 = r11 & 7
            if (r7 != r3) goto L1a
            goto L3b
        L1a:
            r7 = r11 & r2
            if (r7 == r2) goto L30
            r7 = r11 & 5
            if (r7 != r1) goto L23
            goto L30
        L23:
            if (r0 == 0) goto L2c
            int r0 = r6.right
            float r0 = (float) r0
            float r7 = r8.f9217j0
        L2a:
            float r0 = r0 - r7
            goto L41
        L2c:
            int r0 = r6.left
        L2e:
            float r0 = (float) r0
            goto L41
        L30:
            if (r0 == 0) goto L35
            int r0 = r6.left
            goto L2e
        L35:
            int r0 = r6.right
            float r0 = (float) r0
            float r7 = r8.f9217j0
            goto L2a
        L3b:
            float r0 = (float) r10
            float r0 = r0 / r4
            float r7 = r8.f9217j0
            float r7 = r7 / r4
            goto L2a
        L41:
            int r7 = r6.left
            float r7 = (float) r7
            float r0 = java.lang.Math.max(r0, r7)
            r9.left = r0
            int r7 = r6.top
            float r7 = (float) r7
            r9.top = r7
            if (r11 == r5) goto L77
            r5 = r11 & 7
            if (r5 != r3) goto L56
            goto L77
        L56:
            r10 = r11 & r2
            if (r10 == r2) goto L6b
            r10 = r11 & 5
            if (r10 != r1) goto L5f
            goto L6b
        L5f:
            boolean r10 = r8.I
            if (r10 == 0) goto L67
            int r10 = r6.right
        L65:
            float r10 = (float) r10
            goto L7d
        L67:
            float r10 = r8.f9217j0
            float r10 = r10 + r0
            goto L7d
        L6b:
            boolean r10 = r8.I
            if (r10 == 0) goto L74
            float r10 = r8.f9217j0
            float r0 = r0 + r10
            r10 = r0
            goto L7d
        L74:
            int r10 = r6.right
            goto L65
        L77:
            float r10 = (float) r10
            float r10 = r10 / r4
            float r11 = r8.f9217j0
            float r11 = r11 / r4
            float r10 = r10 + r11
        L7d:
            int r11 = r6.right
            float r11 = (float) r11
            float r10 = java.lang.Math.min(r10, r11)
            r9.right = r10
            int r10 = r6.top
            float r10 = (float) r10
            float r11 = r8.getCollapsedTextHeight()
            float r11 = r11 + r10
            r9.bottom = r11
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.material.internal.a.getCollapsedTextActualBounds(android.graphics.RectF, int, int):void");
    }

    public ColorStateList getCollapsedTextColor() {
        return this.f9226o;
    }

    public int getCollapsedTextGravity() {
        return this.f9218k;
    }

    public float getCollapsedTextHeight() {
        TextPaint textPaint = this.U;
        textPaint.setTextSize(this.f9222m);
        textPaint.setTypeface(this.f9237w);
        textPaint.setLetterSpacing(this.f9209f0);
        return -textPaint.ascent();
    }

    public float getCollapsedTextSize() {
        return this.f9222m;
    }

    public Typeface getCollapsedTypeface() {
        Typeface typeface = this.f9237w;
        return typeface != null ? typeface : Typeface.DEFAULT;
    }

    public int getCurrentCollapsedTextColor() {
        return d(this.f9226o);
    }

    public int getExpandedLineCount() {
        return this.f9228p;
    }

    public float getExpandedTextFullHeight() {
        TextPaint textPaint = this.U;
        textPaint.setTextSize(this.f9220l);
        textPaint.setTypeface(this.f9240z);
        textPaint.setLetterSpacing(this.f9211g0);
        return textPaint.descent() + (-textPaint.ascent());
    }

    public int getExpandedTextGravity() {
        return this.f9216j;
    }

    public float getExpandedTextHeight() {
        TextPaint textPaint = this.U;
        textPaint.setTextSize(this.f9220l);
        textPaint.setTypeface(this.f9240z);
        textPaint.setLetterSpacing(this.f9211g0);
        return -textPaint.ascent();
    }

    public float getExpandedTextSize() {
        return this.f9220l;
    }

    public Typeface getExpandedTypeface() {
        Typeface typeface = this.f9240z;
        return typeface != null ? typeface : Typeface.DEFAULT;
    }

    public float getExpansionFraction() {
        return this.f9200b;
    }

    public float getFadeModeThresholdFraction() {
        return this.f9206e;
    }

    public int getHyphenationFrequency() {
        return this.f9231q0;
    }

    public int getLineCount() {
        StaticLayout staticLayout = this.f9215i0;
        if (staticLayout != null) {
            return staticLayout.getLineCount();
        }
        return 0;
    }

    public float getLineSpacingAdd() {
        return this.f9215i0.getSpacingAdd();
    }

    public float getLineSpacingMultiplier() {
        return this.f9215i0.getSpacingMultiplier();
    }

    public int getMaxLines() {
        return this.f9225n0;
    }

    public TimeInterpolator getPositionInterpolator() {
        return this.V;
    }

    public CharSequence getText() {
        return this.G;
    }

    public TextUtils.TruncateAt getTitleTextEllipsize() {
        return this.F;
    }

    public final void h(float f10) throws NoSuchMethodException, SecurityException {
        c(f10, false);
        j0.postInvalidateOnAnimation(this.f9198a);
    }

    public final boolean isStateful() {
        ColorStateList colorStateList;
        ColorStateList colorStateList2 = this.f9226o;
        return (colorStateList2 != null && colorStateList2.isStateful()) || ((colorStateList = this.f9224n) != null && colorStateList.isStateful());
    }

    public void maybeUpdateFontWeightAdjustment(Configuration configuration) throws NoSuchMethodException, SecurityException {
        if (Build.VERSION.SDK_INT >= 31) {
            Typeface typeface = this.f9239y;
            if (typeface != null) {
                this.f9238x = g.maybeCopyWithFontWeightAdjustment(configuration, typeface);
            }
            Typeface typeface2 = this.B;
            if (typeface2 != null) {
                this.A = g.maybeCopyWithFontWeightAdjustment(configuration, typeface2);
            }
            Typeface typeface3 = this.f9238x;
            if (typeface3 == null) {
                typeface3 = this.f9239y;
            }
            this.f9237w = typeface3;
            Typeface typeface4 = this.A;
            if (typeface4 == null) {
                typeface4 = this.B;
            }
            this.f9240z = typeface4;
            recalculate(true);
        }
    }

    public void recalculate() throws NoSuchMethodException, SecurityException {
        recalculate(false);
    }

    public void setCollapsedAndExpandedTextColor(ColorStateList colorStateList) throws NoSuchMethodException, SecurityException {
        if (this.f9226o == colorStateList && this.f9224n == colorStateList) {
            return;
        }
        this.f9226o = colorStateList;
        this.f9224n = colorStateList;
        recalculate();
    }

    public void setCollapsedBounds(Rect rect) {
        setCollapsedBounds(rect.left, rect.top, rect.right, rect.bottom);
    }

    public void setCollapsedTextAppearance(int i10) throws NoSuchMethodException, SecurityException {
        View view = this.f9198a;
        d dVar = new d(view.getContext(), i10);
        if (dVar.getTextColor() != null) {
            this.f9226o = dVar.getTextColor();
        }
        if (dVar.getTextSize() != 0.0f) {
            this.f9222m = dVar.getTextSize();
        }
        ColorStateList colorStateList = dVar.f16735a;
        if (colorStateList != null) {
            this.f9199a0 = colorStateList;
        }
        this.Y = dVar.f16739e;
        this.Z = dVar.f16740f;
        this.X = dVar.f16741g;
        this.f9209f0 = dVar.f16743i;
        n7.a aVar = this.E;
        if (aVar != null) {
            aVar.cancel();
        }
        this.E = new n7.a(new C0088a(), dVar.getFallbackFont());
        dVar.getFontAsync(view.getContext(), this.E);
        recalculate();
    }

    public void setCollapsedTextColor(ColorStateList colorStateList) throws NoSuchMethodException, SecurityException {
        if (this.f9226o != colorStateList) {
            this.f9226o = colorStateList;
            recalculate();
        }
    }

    public void setCollapsedTextGravity(int i10) throws NoSuchMethodException, SecurityException {
        if (this.f9218k != i10) {
            this.f9218k = i10;
            recalculate();
        }
    }

    public void setCollapsedTextSize(float f10) throws NoSuchMethodException, SecurityException {
        if (this.f9222m != f10) {
            this.f9222m = f10;
            recalculate();
        }
    }

    public void setCollapsedTypeface(Typeface typeface) throws NoSuchMethodException, SecurityException {
        if (f(typeface)) {
            recalculate();
        }
    }

    public void setCurrentOffsetY(int i10) {
        this.f9208f = i10;
    }

    public void setExpandedBounds(Rect rect) {
        setExpandedBounds(rect.left, rect.top, rect.right, rect.bottom);
    }

    public void setExpandedLetterSpacing(float f10) throws NoSuchMethodException, SecurityException {
        if (this.f9211g0 != f10) {
            this.f9211g0 = f10;
            recalculate();
        }
    }

    public void setExpandedTextAppearance(int i10) throws NoSuchMethodException, SecurityException {
        View view = this.f9198a;
        d dVar = new d(view.getContext(), i10);
        if (dVar.getTextColor() != null) {
            this.f9224n = dVar.getTextColor();
        }
        if (dVar.getTextSize() != 0.0f) {
            this.f9220l = dVar.getTextSize();
        }
        ColorStateList colorStateList = dVar.f16735a;
        if (colorStateList != null) {
            this.f9207e0 = colorStateList;
        }
        this.f9203c0 = dVar.f16739e;
        this.f9205d0 = dVar.f16740f;
        this.f9201b0 = dVar.f16741g;
        this.f9211g0 = dVar.f16743i;
        n7.a aVar = this.D;
        if (aVar != null) {
            aVar.cancel();
        }
        this.D = new n7.a(new b(), dVar.getFallbackFont());
        dVar.getFontAsync(view.getContext(), this.D);
        recalculate();
    }

    public void setExpandedTextColor(ColorStateList colorStateList) throws NoSuchMethodException, SecurityException {
        if (this.f9224n != colorStateList) {
            this.f9224n = colorStateList;
            recalculate();
        }
    }

    public void setExpandedTextGravity(int i10) throws NoSuchMethodException, SecurityException {
        if (this.f9216j != i10) {
            this.f9216j = i10;
            recalculate();
        }
    }

    public void setExpandedTextSize(float f10) throws NoSuchMethodException, SecurityException {
        if (this.f9220l != f10) {
            this.f9220l = f10;
            recalculate();
        }
    }

    public void setExpandedTypeface(Typeface typeface) throws NoSuchMethodException, SecurityException {
        if (g(typeface)) {
            recalculate();
        }
    }

    public void setExpansionFraction(float f10) throws NoSuchMethodException, SecurityException {
        float f11;
        float fClamp = r0.a.clamp(f10, 0.0f, 1.0f);
        if (fClamp != this.f9200b) {
            this.f9200b = fClamp;
            boolean z10 = this.f9202c;
            RectF rectF = this.f9214i;
            Rect rect = this.f9212h;
            Rect rect2 = this.f9210g;
            if (z10) {
                if (fClamp < this.f9206e) {
                    rect = rect2;
                }
                rectF.set(rect);
            } else {
                rectF.left = e(rect2.left, rect.left, fClamp, this.V);
                rectF.top = e(this.f9230q, this.f9232r, fClamp, this.V);
                rectF.right = e(rect2.right, rect.right, fClamp, this.V);
                rectF.bottom = e(rect2.bottom, rect.bottom, fClamp, this.V);
            }
            if (!this.f9202c) {
                this.f9235u = e(this.f9233s, this.f9234t, fClamp, this.V);
                this.f9236v = e(this.f9230q, this.f9232r, fClamp, this.V);
                h(fClamp);
                f11 = fClamp;
            } else if (fClamp < this.f9206e) {
                this.f9235u = this.f9233s;
                this.f9236v = this.f9230q;
                h(0.0f);
                f11 = 0.0f;
            } else {
                this.f9235u = this.f9234t;
                this.f9236v = this.f9232r - Math.max(0, this.f9208f);
                h(1.0f);
                f11 = 1.0f;
            }
            p1.b bVar = p6.a.f17605b;
            this.f9219k0 = 1.0f - e(0.0f, 1.0f, 1.0f - fClamp, bVar);
            View view = this.f9198a;
            j0.postInvalidateOnAnimation(view);
            this.f9221l0 = e(1.0f, 0.0f, fClamp, bVar);
            j0.postInvalidateOnAnimation(view);
            ColorStateList colorStateList = this.f9226o;
            ColorStateList colorStateList2 = this.f9224n;
            TextPaint textPaint = this.T;
            if (colorStateList != colorStateList2) {
                textPaint.setColor(a(d(colorStateList2), getCurrentCollapsedTextColor(), f11));
            } else {
                textPaint.setColor(getCurrentCollapsedTextColor());
            }
            int i10 = Build.VERSION.SDK_INT;
            float f12 = this.f9209f0;
            float f13 = this.f9211g0;
            if (f12 != f13) {
                textPaint.setLetterSpacing(e(f13, f12, fClamp, bVar));
            } else {
                textPaint.setLetterSpacing(f12);
            }
            this.N = e(this.f9201b0, this.X, fClamp, null);
            this.O = e(this.f9203c0, this.Y, fClamp, null);
            this.P = e(this.f9205d0, this.Z, fClamp, null);
            int iA = a(d(this.f9207e0), d(this.f9199a0), fClamp);
            this.Q = iA;
            textPaint.setShadowLayer(this.N, this.O, this.P, iA);
            if (this.f9202c) {
                int alpha = textPaint.getAlpha();
                float f14 = this.f9206e;
                textPaint.setAlpha((int) ((fClamp <= f14 ? p6.a.lerp(1.0f, 0.0f, this.f9204d, f14, fClamp) : p6.a.lerp(0.0f, 1.0f, f14, 1.0f, fClamp)) * alpha));
                if (i10 >= 31) {
                    textPaint.setShadowLayer(this.N, this.O, this.P, c7.a.compositeARGBWithAlpha(this.Q, textPaint.getAlpha()));
                }
            }
            j0.postInvalidateOnAnimation(view);
        }
    }

    public void setFadeModeEnabled(boolean z10) {
        this.f9202c = z10;
    }

    public void setFadeModeStartFraction(float f10) {
        this.f9204d = f10;
        this.f9206e = o1.a.a(1.0f, f10, 0.5f, f10);
    }

    public void setHyphenationFrequency(int i10) {
        this.f9231q0 = i10;
    }

    public void setLineSpacingAdd(float f10) {
        this.f9227o0 = f10;
    }

    public void setLineSpacingMultiplier(float f10) {
        this.f9229p0 = f10;
    }

    public void setMaxLines(int i10) throws NoSuchMethodException, SecurityException {
        if (i10 != this.f9225n0) {
            this.f9225n0 = i10;
            Bitmap bitmap = this.K;
            if (bitmap != null) {
                bitmap.recycle();
                this.K = null;
            }
            recalculate();
        }
    }

    public void setPositionInterpolator(TimeInterpolator timeInterpolator) throws NoSuchMethodException, SecurityException {
        this.V = timeInterpolator;
        recalculate();
    }

    public void setRtlTextDirectionHeuristicsEnabled(boolean z10) {
        this.J = z10;
    }

    public final boolean setState(int[] iArr) throws NoSuchMethodException, SecurityException {
        this.R = iArr;
        if (!isStateful()) {
            return false;
        }
        recalculate();
        return true;
    }

    public void setStaticLayoutBuilderConfigurer(o oVar) throws NoSuchMethodException, SecurityException {
        if (oVar != null) {
            recalculate(true);
        }
    }

    public void setText(CharSequence charSequence) throws NoSuchMethodException, SecurityException {
        if (charSequence == null || !TextUtils.equals(this.G, charSequence)) {
            this.G = charSequence;
            this.H = null;
            Bitmap bitmap = this.K;
            if (bitmap != null) {
                bitmap.recycle();
                this.K = null;
            }
            recalculate();
        }
    }

    public void setTextSizeInterpolator(TimeInterpolator timeInterpolator) throws NoSuchMethodException, SecurityException {
        this.W = timeInterpolator;
        recalculate();
    }

    public void setTitleTextEllipsize(TextUtils.TruncateAt truncateAt) throws NoSuchMethodException, SecurityException {
        this.F = truncateAt;
        recalculate();
    }

    public void setTypefaces(Typeface typeface) throws NoSuchMethodException, SecurityException {
        boolean zF = f(typeface);
        boolean zG = g(typeface);
        if (zF || zG) {
            recalculate();
        }
    }

    public void recalculate(boolean z10) throws NoSuchMethodException, SecurityException {
        float fMeasureText;
        float f10;
        StaticLayout staticLayout;
        View view = this.f9198a;
        if ((view.getHeight() <= 0 || view.getWidth() <= 0) && !z10) {
            return;
        }
        c(1.0f, z10);
        CharSequence charSequence = this.H;
        TextPaint textPaint = this.T;
        if (charSequence != null && (staticLayout = this.f9215i0) != null) {
            this.f9223m0 = TextUtils.ellipsize(charSequence, textPaint, staticLayout.getWidth(), this.F);
        }
        CharSequence charSequence2 = this.f9223m0;
        if (charSequence2 != null) {
            this.f9217j0 = textPaint.measureText(charSequence2, 0, charSequence2.length());
        } else {
            this.f9217j0 = 0.0f;
        }
        int absoluteGravity = h.getAbsoluteGravity(this.f9218k, this.I ? 1 : 0);
        int i10 = absoluteGravity & 112;
        Rect rect = this.f9212h;
        if (i10 == 48) {
            this.f9232r = rect.top;
        } else if (i10 != 80) {
            this.f9232r = rect.centerY() - ((textPaint.descent() - textPaint.ascent()) / 2.0f);
        } else {
            this.f9232r = textPaint.ascent() + rect.bottom;
        }
        int i11 = absoluteGravity & 8388615;
        if (i11 == 1) {
            this.f9234t = rect.centerX() - (this.f9217j0 / 2.0f);
        } else if (i11 != 5) {
            this.f9234t = rect.left;
        } else {
            this.f9234t = rect.right - this.f9217j0;
        }
        c(0.0f, z10);
        float height = this.f9215i0 != null ? r1.getHeight() : 0.0f;
        StaticLayout staticLayout2 = this.f9215i0;
        if (staticLayout2 == null || this.f9225n0 <= 1) {
            CharSequence charSequence3 = this.H;
            fMeasureText = charSequence3 != null ? textPaint.measureText(charSequence3, 0, charSequence3.length()) : 0.0f;
        } else {
            fMeasureText = staticLayout2.getWidth();
        }
        StaticLayout staticLayout3 = this.f9215i0;
        this.f9228p = staticLayout3 != null ? staticLayout3.getLineCount() : 0;
        int absoluteGravity2 = h.getAbsoluteGravity(this.f9216j, this.I ? 1 : 0);
        int i12 = absoluteGravity2 & 112;
        Rect rect2 = this.f9210g;
        if (i12 == 48) {
            this.f9230q = rect2.top;
        } else if (i12 != 80) {
            this.f9230q = rect2.centerY() - (height / 2.0f);
        } else {
            this.f9230q = textPaint.descent() + (rect2.bottom - height);
        }
        int i13 = absoluteGravity2 & 8388615;
        if (i13 == 1) {
            this.f9233s = rect2.centerX() - (fMeasureText / 2.0f);
        } else if (i13 != 5) {
            this.f9233s = rect2.left;
        } else {
            this.f9233s = rect2.right - fMeasureText;
        }
        Bitmap bitmap = this.K;
        if (bitmap != null) {
            bitmap.recycle();
            this.K = null;
        }
        h(this.f9200b);
        float f11 = this.f9200b;
        boolean z11 = this.f9202c;
        RectF rectF = this.f9214i;
        if (z11) {
            if (f11 < this.f9206e) {
                rect = rect2;
            }
            rectF.set(rect);
        } else {
            rectF.left = e(rect2.left, rect.left, f11, this.V);
            rectF.top = e(this.f9230q, this.f9232r, f11, this.V);
            rectF.right = e(rect2.right, rect.right, f11, this.V);
            rectF.bottom = e(rect2.bottom, rect.bottom, f11, this.V);
        }
        if (!this.f9202c) {
            this.f9235u = e(this.f9233s, this.f9234t, f11, this.V);
            this.f9236v = e(this.f9230q, this.f9232r, f11, this.V);
            h(f11);
            f10 = f11;
        } else if (f11 < this.f9206e) {
            this.f9235u = this.f9233s;
            this.f9236v = this.f9230q;
            h(0.0f);
            f10 = 0.0f;
        } else {
            this.f9235u = this.f9234t;
            this.f9236v = this.f9232r - Math.max(0, this.f9208f);
            h(1.0f);
            f10 = 1.0f;
        }
        p1.b bVar = p6.a.f17605b;
        this.f9219k0 = 1.0f - e(0.0f, 1.0f, 1.0f - f11, bVar);
        j0.postInvalidateOnAnimation(view);
        this.f9221l0 = e(1.0f, 0.0f, f11, bVar);
        j0.postInvalidateOnAnimation(view);
        ColorStateList colorStateList = this.f9226o;
        ColorStateList colorStateList2 = this.f9224n;
        if (colorStateList != colorStateList2) {
            textPaint.setColor(a(d(colorStateList2), getCurrentCollapsedTextColor(), f10));
        } else {
            textPaint.setColor(getCurrentCollapsedTextColor());
        }
        int i14 = Build.VERSION.SDK_INT;
        float f12 = this.f9209f0;
        float f13 = this.f9211g0;
        if (f12 != f13) {
            textPaint.setLetterSpacing(e(f13, f12, f11, bVar));
        } else {
            textPaint.setLetterSpacing(f12);
        }
        this.N = e(this.f9201b0, this.X, f11, null);
        this.O = e(this.f9203c0, this.Y, f11, null);
        this.P = e(this.f9205d0, this.Z, f11, null);
        int iA = a(d(this.f9207e0), d(this.f9199a0), f11);
        this.Q = iA;
        textPaint.setShadowLayer(this.N, this.O, this.P, iA);
        if (this.f9202c) {
            int alpha = textPaint.getAlpha();
            float f14 = this.f9206e;
            textPaint.setAlpha((int) ((f11 <= f14 ? p6.a.lerp(1.0f, 0.0f, this.f9204d, f14, f11) : p6.a.lerp(0.0f, 1.0f, f14, 1.0f, f11)) * alpha));
            if (i14 >= 31) {
                textPaint.setShadowLayer(this.N, this.O, this.P, c7.a.compositeARGBWithAlpha(this.Q, textPaint.getAlpha()));
            }
        }
        j0.postInvalidateOnAnimation(view);
    }

    public void setCollapsedBounds(int i10, int i11, int i12, int i13) {
        Rect rect = this.f9212h;
        if (rect.left == i10 && rect.top == i11 && rect.right == i12 && rect.bottom == i13) {
            return;
        }
        rect.set(i10, i11, i12, i13);
        this.S = true;
    }

    public void setExpandedBounds(int i10, int i11, int i12, int i13) {
        Rect rect = this.f9210g;
        if (rect.left == i10 && rect.top == i11 && rect.right == i12 && rect.bottom == i13) {
            return;
        }
        rect.set(i10, i11, i12, i13);
        this.S = true;
    }
}
