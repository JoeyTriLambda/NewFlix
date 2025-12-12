package la;

import android.view.animation.Interpolator;

/* compiled from: Keyframe.java */
/* loaded from: classes.dex */
public abstract class g implements Cloneable {

    /* renamed from: b, reason: collision with root package name */
    public float f16011b;

    /* renamed from: m, reason: collision with root package name */
    public Interpolator f16012m = null;

    public static g ofFloat(float f10, float f11) {
        return new a(f10, f11);
    }

    public static g ofInt(float f10, int i10) {
        return new b(f10, i10);
    }

    @Override // 
    /* renamed from: clone, reason: collision with other method in class */
    public abstract g mo86clone();

    public float getFraction() {
        return this.f16011b;
    }

    public Interpolator getInterpolator() {
        return this.f16012m;
    }

    public abstract Object getValue();

    public void setInterpolator(Interpolator interpolator) {
        this.f16012m = interpolator;
    }

    /* compiled from: Keyframe.java */
    public static class a extends g {

        /* renamed from: n, reason: collision with root package name */
        public final float f16013n;

        public a(float f10, float f11) {
            this.f16011b = f10;
            this.f16013n = f11;
        }

        public float getFloatValue() {
            return this.f16013n;
        }

        @Override // la.g
        public Object getValue() {
            return Float.valueOf(this.f16013n);
        }

        @Override // la.g
        /* renamed from: clone, reason: merged with bridge method [inline-methods] */
        public a mo86clone() {
            a aVar = new a(getFraction(), this.f16013n);
            aVar.setInterpolator(getInterpolator());
            return aVar;
        }

        public a(float f10) {
            this.f16011b = f10;
        }
    }

    /* compiled from: Keyframe.java */
    public static class b extends g {

        /* renamed from: n, reason: collision with root package name */
        public final int f16014n;

        public b(float f10, int i10) {
            this.f16011b = f10;
            this.f16014n = i10;
        }

        public int getIntValue() {
            return this.f16014n;
        }

        @Override // la.g
        public Object getValue() {
            return Integer.valueOf(this.f16014n);
        }

        @Override // la.g
        /* renamed from: clone */
        public b mo86clone() {
            b bVar = new b(getFraction(), this.f16014n);
            bVar.setInterpolator(getInterpolator());
            return bVar;
        }

        public b(float f10) {
            this.f16011b = f10;
        }
    }

    public static g ofFloat(float f10) {
        return new a(f10);
    }

    public static g ofInt(float f10) {
        return new b(f10);
    }
}
