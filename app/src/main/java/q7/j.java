package q7;

import android.graphics.RectF;
import java.util.Arrays;

/* compiled from: RelativeCornerSize.java */
/* loaded from: classes.dex */
public final class j implements c {

    /* renamed from: a, reason: collision with root package name */
    public final float f17966a;

    public j(float f10) {
        this.f17966a = f10;
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        return (obj instanceof j) && this.f17966a == ((j) obj).f17966a;
    }

    @Override // q7.c
    public float getCornerSize(RectF rectF) {
        return Math.min(rectF.width(), rectF.height()) * this.f17966a;
    }

    public int hashCode() {
        return Arrays.hashCode(new Object[]{Float.valueOf(this.f17966a)});
    }
}
