package c4;

import android.graphics.Paint;
import android.graphics.Typeface;
import android.text.TextPaint;
import android.text.style.TypefaceSpan;

/* compiled from: MenuItemTypefaceSpan.java */
/* loaded from: classes.dex */
public final class b extends TypefaceSpan {

    /* renamed from: b, reason: collision with root package name */
    public final Typeface f5022b;

    public b(String str, Typeface typeface) {
        super(str);
        this.f5022b = typeface;
    }

    public static void a(Paint paint, Typeface typeface) {
        Typeface typeface2 = paint.getTypeface();
        int style = (typeface2 == null ? 0 : typeface2.getStyle()) & (~typeface.getStyle());
        if ((style & 1) != 0) {
            paint.setFakeBoldText(true);
        }
        if ((style & 2) != 0) {
            paint.setTextSkewX(-0.25f);
        }
        paint.setTypeface(typeface);
    }

    @Override // android.text.style.TypefaceSpan, android.text.style.CharacterStyle
    public void updateDrawState(TextPaint textPaint) {
        a(textPaint, this.f5022b);
    }

    @Override // android.text.style.TypefaceSpan, android.text.style.MetricAffectingSpan
    public void updateMeasureState(TextPaint textPaint) {
        a(textPaint, this.f5022b);
    }
}
