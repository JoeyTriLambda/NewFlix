package androidx.emoji2.text;

import android.annotation.SuppressLint;
import android.graphics.Paint;
import android.text.style.ReplacementSpan;

/* compiled from: EmojiSpan.java */
/* loaded from: classes.dex */
public abstract class k extends ReplacementSpan {

    /* renamed from: m, reason: collision with root package name */
    public final i f2639m;

    /* renamed from: b, reason: collision with root package name */
    public final Paint.FontMetricsInt f2638b = new Paint.FontMetricsInt();

    /* renamed from: n, reason: collision with root package name */
    public short f2640n = -1;

    /* renamed from: o, reason: collision with root package name */
    public float f2641o = 1.0f;

    public k(i iVar) {
        w0.h.checkNotNull(iVar, "metadata cannot be null");
        this.f2639m = iVar;
    }

    public final i getMetadata() {
        return this.f2639m;
    }

    @Override // android.text.style.ReplacementSpan
    public int getSize(Paint paint, @SuppressLint({"UnknownNullness"}) CharSequence charSequence, int i10, int i11, Paint.FontMetricsInt fontMetricsInt) {
        Paint.FontMetricsInt fontMetricsInt2 = this.f2638b;
        paint.getFontMetricsInt(fontMetricsInt2);
        i iVar = this.f2639m;
        this.f2641o = (Math.abs(fontMetricsInt2.descent - fontMetricsInt2.ascent) * 1.0f) / iVar.getHeight();
        iVar.getHeight();
        short width = (short) (iVar.getWidth() * this.f2641o);
        this.f2640n = width;
        if (fontMetricsInt != null) {
            fontMetricsInt.ascent = fontMetricsInt2.ascent;
            fontMetricsInt.descent = fontMetricsInt2.descent;
            fontMetricsInt.top = fontMetricsInt2.top;
            fontMetricsInt.bottom = fontMetricsInt2.bottom;
        }
        return width;
    }
}
