package androidx.emoji2.text;

import android.annotation.SuppressLint;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.Typeface;
import org.apache.commons.lang3.StringUtils;

/* compiled from: EmojiMetadata.java */
/* loaded from: classes.dex */
public final class i {

    /* renamed from: d, reason: collision with root package name */
    public static final ThreadLocal<m1.a> f2623d = new ThreadLocal<>();

    /* renamed from: a, reason: collision with root package name */
    public final int f2624a;

    /* renamed from: b, reason: collision with root package name */
    public final o f2625b;

    /* renamed from: c, reason: collision with root package name */
    public volatile int f2626c = 0;

    public i(o oVar, int i10) {
        this.f2625b = oVar;
        this.f2624a = i10;
    }

    public final m1.a a() {
        ThreadLocal<m1.a> threadLocal = f2623d;
        m1.a aVar = threadLocal.get();
        if (aVar == null) {
            aVar = new m1.a();
            threadLocal.set(aVar);
        }
        this.f2625b.getMetadataList().list(aVar, this.f2624a);
        return aVar;
    }

    public void draw(Canvas canvas, float f10, float f11, Paint paint) {
        o oVar = this.f2625b;
        Typeface typeface = oVar.f2657d;
        Typeface typeface2 = paint.getTypeface();
        paint.setTypeface(typeface);
        canvas.drawText(oVar.getEmojiCharArray(), this.f2624a * 2, 2, f10, f11, paint);
        paint.setTypeface(typeface2);
    }

    public int getCodepointAt(int i10) {
        return a().codepoints(i10);
    }

    public int getCodepointsLength() {
        return a().codepointsLength();
    }

    @SuppressLint({"KotlinPropertyAccess"})
    public int getHasGlyph() {
        return this.f2626c;
    }

    public short getHeight() {
        return a().height();
    }

    public int getId() {
        return a().id();
    }

    public short getSdkAdded() {
        return a().sdkAdded();
    }

    public short getWidth() {
        return a().width();
    }

    public boolean isDefaultEmoji() {
        return a().emojiStyle();
    }

    @SuppressLint({"KotlinPropertyAccess"})
    public void setHasGlyph(boolean z10) {
        this.f2626c = z10 ? 2 : 1;
    }

    public String toString() {
        StringBuilder sb2 = new StringBuilder();
        sb2.append(super.toString());
        sb2.append(", id:");
        sb2.append(Integer.toHexString(getId()));
        sb2.append(", codepoints:");
        int codepointsLength = getCodepointsLength();
        for (int i10 = 0; i10 < codepointsLength; i10++) {
            sb2.append(Integer.toHexString(getCodepointAt(i10)));
            sb2.append(StringUtils.SPACE);
        }
        return sb2.toString();
    }
}
