package androidx.emoji2.text;

import android.os.Build;
import android.text.TextPaint;
import androidx.emoji2.text.f;

/* compiled from: DefaultGlyphChecker.java */
/* loaded from: classes.dex */
public final class d implements f.d {

    /* renamed from: b, reason: collision with root package name */
    public static final ThreadLocal<StringBuilder> f2593b = new ThreadLocal<>();

    /* renamed from: a, reason: collision with root package name */
    public final TextPaint f2594a;

    public d() {
        TextPaint textPaint = new TextPaint();
        this.f2594a = textPaint;
        textPaint.setTextSize(10.0f);
    }

    public boolean hasGlyph(CharSequence charSequence, int i10, int i11, int i12) {
        int i13 = Build.VERSION.SDK_INT;
        if (i13 < 23 && i12 > i13) {
            return false;
        }
        ThreadLocal<StringBuilder> threadLocal = f2593b;
        if (threadLocal.get() == null) {
            threadLocal.set(new StringBuilder());
        }
        StringBuilder sb2 = threadLocal.get();
        sb2.setLength(0);
        while (i10 < i11) {
            sb2.append(charSequence.charAt(i10));
            i10++;
        }
        return o0.c.hasGlyph(this.f2594a, sb2.toString());
    }
}
