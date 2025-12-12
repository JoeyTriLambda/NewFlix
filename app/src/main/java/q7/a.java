package q7;

import android.graphics.RectF;
import java.util.Arrays;

/* compiled from: AbsoluteCornerSize.java */
/* loaded from: classes.dex */
public final class a implements c {

    /* renamed from: a, reason: collision with root package name */
    public final float f17924a;

    public a(float f10) {
        this.f17924a = f10;
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        return (obj instanceof a) && this.f17924a == ((a) obj).f17924a;
    }

    @Override // q7.c
    public float getCornerSize(RectF rectF) {
        return this.f17924a;
    }

    public int hashCode() {
        return Arrays.hashCode(new Object[]{Float.valueOf(this.f17924a)});
    }
}
