package q7;

import android.graphics.RectF;
import java.util.Arrays;

/* compiled from: AdjustedCornerSize.java */
/* loaded from: classes.dex */
public final class b implements c {

    /* renamed from: a, reason: collision with root package name */
    public final c f17925a;

    /* renamed from: b, reason: collision with root package name */
    public final float f17926b;

    public b(float f10, c cVar) {
        while (cVar instanceof b) {
            cVar = ((b) cVar).f17925a;
            f10 += ((b) cVar).f17926b;
        }
        this.f17925a = cVar;
        this.f17926b = f10;
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof b)) {
            return false;
        }
        b bVar = (b) obj;
        return this.f17925a.equals(bVar.f17925a) && this.f17926b == bVar.f17926b;
    }

    @Override // q7.c
    public float getCornerSize(RectF rectF) {
        return Math.max(0.0f, this.f17925a.getCornerSize(rectF) + this.f17926b);
    }

    public int hashCode() {
        return Arrays.hashCode(new Object[]{this.f17925a, Float.valueOf(this.f17926b)});
    }
}
