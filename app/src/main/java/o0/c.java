package o0;

import android.graphics.Paint;
import android.graphics.Rect;
import android.os.Build;

/* compiled from: PaintCompat.java */
/* loaded from: classes.dex */
public final class c {

    /* renamed from: a, reason: collision with root package name */
    public static final ThreadLocal<w0.d<Rect, Rect>> f16888a = new ThreadLocal<>();

    /* compiled from: PaintCompat.java */
    public static class a {
        public static boolean a(Paint paint, String str) {
            return paint.hasGlyph(str);
        }
    }

    public static boolean hasGlyph(Paint paint, String str) {
        if (Build.VERSION.SDK_INT >= 23) {
            return a.a(paint, str);
        }
        int length = str.length();
        if (length == 1 && Character.isWhitespace(str.charAt(0))) {
            return true;
        }
        float fMeasureText = paint.measureText("\udfffd");
        float fMeasureText2 = paint.measureText("m");
        float fMeasureText3 = paint.measureText(str);
        float fMeasureText4 = 0.0f;
        if (fMeasureText3 == 0.0f) {
            return false;
        }
        if (str.codePointCount(0, str.length()) > 1) {
            if (fMeasureText3 > fMeasureText2 * 2.0f) {
                return false;
            }
            int i10 = 0;
            while (i10 < length) {
                int iCharCount = Character.charCount(str.codePointAt(i10)) + i10;
                fMeasureText4 += paint.measureText(str, i10, iCharCount);
                i10 = iCharCount;
            }
            if (fMeasureText3 >= fMeasureText4) {
                return false;
            }
        }
        if (fMeasureText3 != fMeasureText) {
            return true;
        }
        ThreadLocal<w0.d<Rect, Rect>> threadLocal = f16888a;
        w0.d<Rect, Rect> dVar = threadLocal.get();
        if (dVar == null) {
            dVar = new w0.d<>(new Rect(), new Rect());
            threadLocal.set(dVar);
        } else {
            dVar.f20843a.setEmpty();
            dVar.f20844b.setEmpty();
        }
        paint.getTextBounds("\udfffd", 0, 2, dVar.f20843a);
        paint.getTextBounds(str, 0, length, dVar.f20844b);
        return !r6.equals(r3);
    }
}
