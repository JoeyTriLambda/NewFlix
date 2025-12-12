package com.google.android.material.internal;

import android.os.Build;
import android.text.Layout;
import android.text.StaticLayout;
import android.text.TextDirectionHeuristic;
import android.text.TextDirectionHeuristics;
import android.text.TextPaint;
import android.text.TextUtils;
import i7.o;
import java.lang.reflect.Constructor;
import w0.h;

/* loaded from: classes.dex */
public final class StaticLayoutBuilderCompat {

    /* renamed from: m, reason: collision with root package name */
    public static final int f9181m;

    /* renamed from: n, reason: collision with root package name */
    public static boolean f9182n;

    /* renamed from: o, reason: collision with root package name */
    public static Constructor<StaticLayout> f9183o;

    /* renamed from: p, reason: collision with root package name */
    public static TextDirectionHeuristic f9184p;

    /* renamed from: a, reason: collision with root package name */
    public CharSequence f9185a;

    /* renamed from: b, reason: collision with root package name */
    public final TextPaint f9186b;

    /* renamed from: c, reason: collision with root package name */
    public final int f9187c;

    /* renamed from: d, reason: collision with root package name */
    public int f9188d;

    /* renamed from: k, reason: collision with root package name */
    public boolean f9195k;

    /* renamed from: e, reason: collision with root package name */
    public Layout.Alignment f9189e = Layout.Alignment.ALIGN_NORMAL;

    /* renamed from: f, reason: collision with root package name */
    public int f9190f = Integer.MAX_VALUE;

    /* renamed from: g, reason: collision with root package name */
    public float f9191g = 0.0f;

    /* renamed from: h, reason: collision with root package name */
    public float f9192h = 1.0f;

    /* renamed from: i, reason: collision with root package name */
    public int f9193i = f9181m;

    /* renamed from: j, reason: collision with root package name */
    public boolean f9194j = true;

    /* renamed from: l, reason: collision with root package name */
    public TextUtils.TruncateAt f9196l = null;

    public static class StaticLayoutBuilderCompatException extends Exception {
        public StaticLayoutBuilderCompatException(Exception exc) {
            super("Error thrown initializing StaticLayout " + exc.getMessage(), exc);
        }
    }

    static {
        f9181m = Build.VERSION.SDK_INT >= 23 ? 1 : 0;
    }

    public StaticLayoutBuilderCompat(CharSequence charSequence, TextPaint textPaint, int i10) {
        this.f9185a = charSequence;
        this.f9186b = textPaint;
        this.f9187c = i10;
        this.f9188d = charSequence.length();
    }

    public static StaticLayoutBuilderCompat obtain(CharSequence charSequence, TextPaint textPaint, int i10) {
        return new StaticLayoutBuilderCompat(charSequence, textPaint, i10);
    }

    public StaticLayout build() throws NoSuchMethodException, SecurityException, StaticLayoutBuilderCompatException {
        if (this.f9185a == null) {
            this.f9185a = "";
        }
        int iMax = Math.max(0, this.f9187c);
        CharSequence charSequenceEllipsize = this.f9185a;
        int i10 = this.f9190f;
        TextPaint textPaint = this.f9186b;
        if (i10 == 1) {
            charSequenceEllipsize = TextUtils.ellipsize(charSequenceEllipsize, textPaint, iMax, this.f9196l);
        }
        int iMin = Math.min(charSequenceEllipsize.length(), this.f9188d);
        this.f9188d = iMin;
        int i11 = Build.VERSION.SDK_INT;
        if (i11 < 23) {
            if (!f9182n) {
                try {
                    f9184p = this.f9195k && i11 >= 23 ? TextDirectionHeuristics.RTL : TextDirectionHeuristics.LTR;
                    Class cls = Integer.TYPE;
                    Class cls2 = Float.TYPE;
                    Constructor<StaticLayout> declaredConstructor = StaticLayout.class.getDeclaredConstructor(CharSequence.class, cls, cls, TextPaint.class, cls, Layout.Alignment.class, TextDirectionHeuristic.class, cls2, cls2, Boolean.TYPE, TextUtils.TruncateAt.class, cls, cls);
                    f9183o = declaredConstructor;
                    declaredConstructor.setAccessible(true);
                    f9182n = true;
                } catch (Exception e10) {
                    throw new StaticLayoutBuilderCompatException(e10);
                }
            }
            try {
                return (StaticLayout) ((Constructor) h.checkNotNull(f9183o)).newInstance(charSequenceEllipsize, 0, Integer.valueOf(this.f9188d), textPaint, Integer.valueOf(iMax), this.f9189e, h.checkNotNull(f9184p), Float.valueOf(1.0f), Float.valueOf(0.0f), Boolean.valueOf(this.f9194j), null, Integer.valueOf(iMax), Integer.valueOf(this.f9190f));
            } catch (Exception e11) {
                throw new StaticLayoutBuilderCompatException(e11);
            }
        }
        if (this.f9195k && this.f9190f == 1) {
            this.f9189e = Layout.Alignment.ALIGN_OPPOSITE;
        }
        StaticLayout.Builder builderObtain = StaticLayout.Builder.obtain(charSequenceEllipsize, 0, iMin, textPaint, iMax);
        builderObtain.setAlignment(this.f9189e);
        builderObtain.setIncludePad(this.f9194j);
        builderObtain.setTextDirection(this.f9195k ? TextDirectionHeuristics.RTL : TextDirectionHeuristics.LTR);
        TextUtils.TruncateAt truncateAt = this.f9196l;
        if (truncateAt != null) {
            builderObtain.setEllipsize(truncateAt);
        }
        builderObtain.setMaxLines(this.f9190f);
        float f10 = this.f9191g;
        if (f10 != 0.0f || this.f9192h != 1.0f) {
            builderObtain.setLineSpacing(f10, this.f9192h);
        }
        if (this.f9190f > 1) {
            builderObtain.setHyphenationFrequency(this.f9193i);
        }
        return builderObtain.build();
    }

    public StaticLayoutBuilderCompat setAlignment(Layout.Alignment alignment) {
        this.f9189e = alignment;
        return this;
    }

    public StaticLayoutBuilderCompat setEllipsize(TextUtils.TruncateAt truncateAt) {
        this.f9196l = truncateAt;
        return this;
    }

    public StaticLayoutBuilderCompat setHyphenationFrequency(int i10) {
        this.f9193i = i10;
        return this;
    }

    public StaticLayoutBuilderCompat setIncludePad(boolean z10) {
        this.f9194j = z10;
        return this;
    }

    public StaticLayoutBuilderCompat setIsRtl(boolean z10) {
        this.f9195k = z10;
        return this;
    }

    public StaticLayoutBuilderCompat setLineSpacing(float f10, float f11) {
        this.f9191g = f10;
        this.f9192h = f11;
        return this;
    }

    public StaticLayoutBuilderCompat setMaxLines(int i10) {
        this.f9190f = i10;
        return this;
    }

    public StaticLayoutBuilderCompat setStaticLayoutBuilderConfigurer(o oVar) {
        return this;
    }
}
