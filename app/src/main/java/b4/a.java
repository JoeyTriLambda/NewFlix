package b4;

import android.graphics.PointF;
import android.view.animation.Interpolator;

/* compiled from: Keyframe.java */
/* loaded from: classes.dex */
public class a<T> {

    /* renamed from: a, reason: collision with root package name */
    public final p3.d f4755a;

    /* renamed from: b, reason: collision with root package name */
    public final T f4756b;

    /* renamed from: c, reason: collision with root package name */
    public T f4757c;

    /* renamed from: d, reason: collision with root package name */
    public final Interpolator f4758d;

    /* renamed from: e, reason: collision with root package name */
    public final float f4759e;

    /* renamed from: f, reason: collision with root package name */
    public Float f4760f;

    /* renamed from: g, reason: collision with root package name */
    public float f4761g;

    /* renamed from: h, reason: collision with root package name */
    public float f4762h;

    /* renamed from: i, reason: collision with root package name */
    public int f4763i;

    /* renamed from: j, reason: collision with root package name */
    public int f4764j;

    /* renamed from: k, reason: collision with root package name */
    public float f4765k;

    /* renamed from: l, reason: collision with root package name */
    public float f4766l;

    /* renamed from: m, reason: collision with root package name */
    public PointF f4767m;

    /* renamed from: n, reason: collision with root package name */
    public PointF f4768n;

    public a(p3.d dVar, T t10, T t11, Interpolator interpolator, float f10, Float f11) {
        this.f4761g = -3987645.8f;
        this.f4762h = -3987645.8f;
        this.f4763i = 784923401;
        this.f4764j = 784923401;
        this.f4765k = Float.MIN_VALUE;
        this.f4766l = Float.MIN_VALUE;
        this.f4767m = null;
        this.f4768n = null;
        this.f4755a = dVar;
        this.f4756b = t10;
        this.f4757c = t11;
        this.f4758d = interpolator;
        this.f4759e = f10;
        this.f4760f = f11;
    }

    public boolean containsProgress(float f10) {
        return f10 >= getStartProgress() && f10 < getEndProgress();
    }

    public float getEndProgress() {
        p3.d dVar = this.f4755a;
        if (dVar == null) {
            return 1.0f;
        }
        if (this.f4766l == Float.MIN_VALUE) {
            if (this.f4760f == null) {
                this.f4766l = 1.0f;
            } else {
                this.f4766l = ((this.f4760f.floatValue() - this.f4759e) / dVar.getDurationFrames()) + getStartProgress();
            }
        }
        return this.f4766l;
    }

    public float getEndValueFloat() {
        if (this.f4762h == -3987645.8f) {
            this.f4762h = ((Float) this.f4757c).floatValue();
        }
        return this.f4762h;
    }

    public int getEndValueInt() {
        if (this.f4764j == 784923401) {
            this.f4764j = ((Integer) this.f4757c).intValue();
        }
        return this.f4764j;
    }

    public float getStartProgress() {
        p3.d dVar = this.f4755a;
        if (dVar == null) {
            return 0.0f;
        }
        if (this.f4765k == Float.MIN_VALUE) {
            this.f4765k = (this.f4759e - dVar.getStartFrame()) / dVar.getDurationFrames();
        }
        return this.f4765k;
    }

    public float getStartValueFloat() {
        if (this.f4761g == -3987645.8f) {
            this.f4761g = ((Float) this.f4756b).floatValue();
        }
        return this.f4761g;
    }

    public int getStartValueInt() {
        if (this.f4763i == 784923401) {
            this.f4763i = ((Integer) this.f4756b).intValue();
        }
        return this.f4763i;
    }

    public boolean isStatic() {
        return this.f4758d == null;
    }

    public String toString() {
        return "Keyframe{startValue=" + this.f4756b + ", endValue=" + this.f4757c + ", startFrame=" + this.f4759e + ", endFrame=" + this.f4760f + ", interpolator=" + this.f4758d + '}';
    }

    public a(T t10) {
        this.f4761g = -3987645.8f;
        this.f4762h = -3987645.8f;
        this.f4763i = 784923401;
        this.f4764j = 784923401;
        this.f4765k = Float.MIN_VALUE;
        this.f4766l = Float.MIN_VALUE;
        this.f4767m = null;
        this.f4768n = null;
        this.f4755a = null;
        this.f4756b = t10;
        this.f4757c = t10;
        this.f4758d = null;
        this.f4759e = Float.MIN_VALUE;
        this.f4760f = Float.valueOf(Float.MAX_VALUE);
    }
}
