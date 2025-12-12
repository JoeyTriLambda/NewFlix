package p6;

import android.view.animation.DecelerateInterpolator;
import android.view.animation.LinearInterpolator;

/* compiled from: AnimationUtils.java */
/* loaded from: classes.dex */
public final class a {

    /* renamed from: a, reason: collision with root package name */
    public static final LinearInterpolator f17604a = new LinearInterpolator();

    /* renamed from: b, reason: collision with root package name */
    public static final p1.b f17605b = new p1.b();

    /* renamed from: c, reason: collision with root package name */
    public static final p1.a f17606c = new p1.a();

    /* renamed from: d, reason: collision with root package name */
    public static final p1.c f17607d = new p1.c();

    /* renamed from: e, reason: collision with root package name */
    public static final DecelerateInterpolator f17608e = new DecelerateInterpolator();

    public static float lerp(float f10, float f11, float f12) {
        return o1.a.a(f11, f10, f12, f10);
    }

    public static int lerp(int i10, int i11, float f10) {
        return Math.round(f10 * (i11 - i10)) + i10;
    }

    public static float lerp(float f10, float f11, float f12, float f13, float f14) {
        return f14 <= f12 ? f10 : f14 >= f13 ? f11 : lerp(f10, f11, (f14 - f12) / (f13 - f12));
    }
}
