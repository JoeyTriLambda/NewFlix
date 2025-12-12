package v0;

import android.os.Build;
import android.text.PrecomputedText;
import android.text.Spannable;
import android.text.TextDirectionHeuristic;
import android.text.TextDirectionHeuristics;
import android.text.TextPaint;
import android.text.TextUtils;
import android.text.style.MetricAffectingSpan;

/* compiled from: PrecomputedTextCompat.java */
/* loaded from: classes.dex */
public final class d implements Spannable {
    @Override // java.lang.CharSequence
    public char charAt(int i10) {
        throw null;
    }

    public a getParams() {
        return null;
    }

    public PrecomputedText getPrecomputedText() {
        return null;
    }

    @Override // android.text.Spanned
    public int getSpanEnd(Object obj) {
        throw null;
    }

    @Override // android.text.Spanned
    public int getSpanFlags(Object obj) {
        throw null;
    }

    @Override // android.text.Spanned
    public int getSpanStart(Object obj) {
        throw null;
    }

    @Override // android.text.Spanned
    public <T> T[] getSpans(int i10, int i11, Class<T> cls) {
        if (Build.VERSION.SDK_INT < 29) {
            throw null;
        }
        o1.a.g(i10, i11, cls);
        throw null;
    }

    @Override // java.lang.CharSequence
    public int length() {
        throw null;
    }

    @Override // android.text.Spanned
    public int nextSpanTransition(int i10, int i11, Class cls) {
        throw null;
    }

    @Override // android.text.Spannable
    public void removeSpan(Object obj) {
        if (obj instanceof MetricAffectingSpan) {
            throw new IllegalArgumentException("MetricAffectingSpan can not be removed from PrecomputedText.");
        }
        if (Build.VERSION.SDK_INT < 29) {
            throw null;
        }
        o1.a.m(obj);
        throw null;
    }

    @Override // android.text.Spannable
    public void setSpan(Object obj, int i10, int i11, int i12) {
        if (obj instanceof MetricAffectingSpan) {
            throw new IllegalArgumentException("MetricAffectingSpan can not be set to PrecomputedText.");
        }
        if (Build.VERSION.SDK_INT < 29) {
            throw null;
        }
        o1.a.n(obj, i10, i11, i12);
        throw null;
    }

    @Override // java.lang.CharSequence
    public CharSequence subSequence(int i10, int i11) {
        throw null;
    }

    @Override // java.lang.CharSequence
    public String toString() {
        throw null;
    }

    /* compiled from: PrecomputedTextCompat.java */
    public static final class a {

        /* renamed from: a, reason: collision with root package name */
        public final TextPaint f20407a;

        /* renamed from: b, reason: collision with root package name */
        public final TextDirectionHeuristic f20408b;

        /* renamed from: c, reason: collision with root package name */
        public final int f20409c;

        /* renamed from: d, reason: collision with root package name */
        public final int f20410d;

        /* compiled from: PrecomputedTextCompat.java */
        /* renamed from: v0.d$a$a, reason: collision with other inner class name */
        public static class C0292a {

            /* renamed from: a, reason: collision with root package name */
            public final TextPaint f20411a;

            /* renamed from: b, reason: collision with root package name */
            public TextDirectionHeuristic f20412b;

            /* renamed from: c, reason: collision with root package name */
            public int f20413c;

            /* renamed from: d, reason: collision with root package name */
            public int f20414d;

            public C0292a(TextPaint textPaint) {
                this.f20411a = textPaint;
                if (Build.VERSION.SDK_INT >= 23) {
                    this.f20413c = 1;
                    this.f20414d = 1;
                } else {
                    this.f20414d = 0;
                    this.f20413c = 0;
                }
                this.f20412b = TextDirectionHeuristics.FIRSTSTRONG_LTR;
            }

            public a build() {
                return new a(this.f20411a, this.f20412b, this.f20413c, this.f20414d);
            }

            public C0292a setBreakStrategy(int i10) {
                this.f20413c = i10;
                return this;
            }

            public C0292a setHyphenationFrequency(int i10) {
                this.f20414d = i10;
                return this;
            }

            public C0292a setTextDirection(TextDirectionHeuristic textDirectionHeuristic) {
                this.f20412b = textDirectionHeuristic;
                return this;
            }
        }

        public a(TextPaint textPaint, TextDirectionHeuristic textDirectionHeuristic, int i10, int i11) {
            if (Build.VERSION.SDK_INT >= 29) {
                new PrecomputedText.Params.Builder(textPaint).setBreakStrategy(i10).setHyphenationFrequency(i11).setTextDirection(textDirectionHeuristic).build();
            }
            this.f20407a = textPaint;
            this.f20408b = textDirectionHeuristic;
            this.f20409c = i10;
            this.f20410d = i11;
        }

        public boolean equals(Object obj) {
            if (obj == this) {
                return true;
            }
            if (!(obj instanceof a)) {
                return false;
            }
            a aVar = (a) obj;
            return equalsWithoutTextDirection(aVar) && this.f20408b == aVar.getTextDirection();
        }

        public boolean equalsWithoutTextDirection(a aVar) {
            int i10 = Build.VERSION.SDK_INT;
            if (i10 >= 23) {
                if (this.f20409c != aVar.getBreakStrategy() || this.f20410d != aVar.getHyphenationFrequency()) {
                    return false;
                }
            }
            TextPaint textPaint = this.f20407a;
            if (textPaint.getTextSize() != aVar.getTextPaint().getTextSize() || textPaint.getTextScaleX() != aVar.getTextPaint().getTextScaleX() || textPaint.getTextSkewX() != aVar.getTextPaint().getTextSkewX() || textPaint.getLetterSpacing() != aVar.getTextPaint().getLetterSpacing() || !TextUtils.equals(textPaint.getFontFeatureSettings(), aVar.getTextPaint().getFontFeatureSettings()) || textPaint.getFlags() != aVar.getTextPaint().getFlags()) {
                return false;
            }
            if (i10 >= 24) {
                if (!textPaint.getTextLocales().equals(aVar.getTextPaint().getTextLocales())) {
                    return false;
                }
            } else if (!textPaint.getTextLocale().equals(aVar.getTextPaint().getTextLocale())) {
                return false;
            }
            return textPaint.getTypeface() == null ? aVar.getTextPaint().getTypeface() == null : textPaint.getTypeface().equals(aVar.getTextPaint().getTypeface());
        }

        public int getBreakStrategy() {
            return this.f20409c;
        }

        public int getHyphenationFrequency() {
            return this.f20410d;
        }

        public TextDirectionHeuristic getTextDirection() {
            return this.f20408b;
        }

        public TextPaint getTextPaint() {
            return this.f20407a;
        }

        public int hashCode() {
            int i10 = Build.VERSION.SDK_INT;
            int i11 = this.f20410d;
            int i12 = this.f20409c;
            TextDirectionHeuristic textDirectionHeuristic = this.f20408b;
            TextPaint textPaint = this.f20407a;
            return i10 >= 24 ? w0.c.hash(Float.valueOf(textPaint.getTextSize()), Float.valueOf(textPaint.getTextScaleX()), Float.valueOf(textPaint.getTextSkewX()), Float.valueOf(textPaint.getLetterSpacing()), Integer.valueOf(textPaint.getFlags()), textPaint.getTextLocales(), textPaint.getTypeface(), Boolean.valueOf(textPaint.isElegantTextHeight()), textDirectionHeuristic, Integer.valueOf(i12), Integer.valueOf(i11)) : w0.c.hash(Float.valueOf(textPaint.getTextSize()), Float.valueOf(textPaint.getTextScaleX()), Float.valueOf(textPaint.getTextSkewX()), Float.valueOf(textPaint.getLetterSpacing()), Integer.valueOf(textPaint.getFlags()), textPaint.getTextLocale(), textPaint.getTypeface(), Boolean.valueOf(textPaint.isElegantTextHeight()), textDirectionHeuristic, Integer.valueOf(i12), Integer.valueOf(i11));
        }

        public String toString() {
            StringBuilder sb2 = new StringBuilder("{");
            StringBuilder sb3 = new StringBuilder("textSize=");
            TextPaint textPaint = this.f20407a;
            sb3.append(textPaint.getTextSize());
            sb2.append(sb3.toString());
            sb2.append(", textScaleX=" + textPaint.getTextScaleX());
            sb2.append(", textSkewX=" + textPaint.getTextSkewX());
            int i10 = Build.VERSION.SDK_INT;
            sb2.append(", letterSpacing=" + textPaint.getLetterSpacing());
            sb2.append(", elegantTextHeight=" + textPaint.isElegantTextHeight());
            if (i10 >= 24) {
                sb2.append(", textLocale=" + textPaint.getTextLocales());
            } else {
                sb2.append(", textLocale=" + textPaint.getTextLocale());
            }
            sb2.append(", typeface=" + textPaint.getTypeface());
            if (i10 >= 26) {
                sb2.append(", variationSettings=" + textPaint.getFontVariationSettings());
            }
            sb2.append(", textDir=" + this.f20408b);
            sb2.append(", breakStrategy=" + this.f20409c);
            sb2.append(", hyphenationFrequency=" + this.f20410d);
            sb2.append("}");
            return sb2.toString();
        }

        public a(PrecomputedText.Params params) {
            this.f20407a = params.getTextPaint();
            this.f20408b = params.getTextDirection();
            this.f20409c = params.getBreakStrategy();
            this.f20410d = params.getHyphenationFrequency();
        }
    }
}
