package x6;

import android.graphics.Rect;
import android.graphics.RectF;
import android.view.View;
import androidx.recyclerview.widget.RecyclerView;

/* compiled from: CarouselOrientationHelper.java */
/* loaded from: classes.dex */
public abstract class f {

    /* renamed from: a, reason: collision with root package name */
    public final int f21632a;

    public f(int i10) {
        this.f21632a = i10;
    }

    public abstract int a();

    public abstract int b();

    public abstract int c();

    public abstract void containMaskWithinBounds(RectF rectF, RectF rectF2, RectF rectF3);

    public abstract int d();

    public abstract int e();

    public abstract int f();

    public abstract float getMaskMargins(RecyclerView.m mVar);

    public abstract RectF getMaskRect(float f10, float f11, float f12, float f13);

    public abstract void layoutDecoratedWithMargins(View view, int i10, int i11);

    public abstract void moveMaskOnEdgeOutsideBounds(RectF rectF, RectF rectF2, RectF rectF3);

    public abstract void offsetChild(View view, Rect rect, float f10, float f11);
}
