package androidx.emoji2.text;

import android.annotation.SuppressLint;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.text.TextPaint;

/* compiled from: TypefaceEmojiSpan.java */
/* loaded from: classes.dex */
public final class q extends k {

    /* renamed from: p, reason: collision with root package name */
    public static TextPaint f2664p;

    public q(i iVar) {
        super(iVar);
    }

    @Override // android.text.style.ReplacementSpan
    public void draw(Canvas canvas, @SuppressLint({"UnknownNullness"}) CharSequence charSequence, int i10, int i11, float f10, int i12, int i13, int i14, Paint paint) {
        if (f.get().isEmojiSpanIndicatorEnabled()) {
            float f11 = i12;
            float f12 = f10 + this.f2640n;
            float f13 = i14;
            if (f2664p == null) {
                TextPaint textPaint = new TextPaint();
                f2664p = textPaint;
                textPaint.setColor(f.get().getEmojiSpanIndicatorColor());
                f2664p.setStyle(Paint.Style.FILL);
            }
            canvas.drawRect(f10, f11, f12, f13, f2664p);
        }
        getMetadata().draw(canvas, f10, i13, paint);
    }
}
