package la;

import java.util.HashMap;
import java.util.concurrent.locks.ReentrantReadWriteLock;

/* compiled from: PropertyValuesHolder.java */
/* loaded from: classes.dex */
public class i implements Cloneable {

    /* renamed from: r, reason: collision with root package name */
    public static final e f16019r = new e();

    /* renamed from: s, reason: collision with root package name */
    public static final c f16020s = new c();

    /* renamed from: b, reason: collision with root package name */
    public String f16021b;

    /* renamed from: m, reason: collision with root package name */
    public Class f16022m;

    /* renamed from: n, reason: collision with root package name */
    public h f16023n = null;

    /* renamed from: o, reason: collision with root package name */
    public final Object[] f16024o;

    /* renamed from: p, reason: collision with root package name */
    public j f16025p;

    /* renamed from: q, reason: collision with root package name */
    public Object f16026q;

    static {
        new HashMap();
        new HashMap();
    }

    public i(String str) {
        new ReentrantReadWriteLock();
        this.f16024o = new Object[1];
        this.f16021b = str;
    }

    public static i ofFloat(String str, float... fArr) {
        return new a(str, fArr);
    }

    public static i ofInt(String str, int... iArr) {
        return new b(str, iArr);
    }

    public void a(float f10) {
        this.f16026q = this.f16023n.getValue(f10);
    }

    public Object b() {
        return this.f16026q;
    }

    public String getPropertyName() {
        return this.f16021b;
    }

    public void setFloatValues(float... fArr) {
        this.f16022m = Float.TYPE;
        this.f16023n = h.ofFloat(fArr);
    }

    public void setIntValues(int... iArr) {
        this.f16022m = Integer.TYPE;
        this.f16023n = h.ofInt(iArr);
    }

    public String toString() {
        return this.f16021b + ": " + this.f16023n.toString();
    }

    /* compiled from: PropertyValuesHolder.java */
    public static class a extends i {

        /* renamed from: t, reason: collision with root package name */
        public d f16027t;

        /* renamed from: u, reason: collision with root package name */
        public float f16028u;

        public a(String str, float... fArr) {
            super(str);
            setFloatValues(fArr);
        }

        @Override // la.i
        public final void a(float f10) {
            this.f16028u = this.f16027t.getFloatValue(f10);
        }

        @Override // la.i
        public final Object b() {
            return Float.valueOf(this.f16028u);
        }

        @Override // la.i
        public void setFloatValues(float... fArr) {
            super.setFloatValues(fArr);
            this.f16027t = (d) this.f16023n;
        }

        @Override // la.i
        /* renamed from: clone, reason: merged with bridge method [inline-methods] */
        public a mo87clone() {
            a aVar = (a) super.mo87clone();
            aVar.f16027t = (d) aVar.f16023n;
            return aVar;
        }
    }

    /* compiled from: PropertyValuesHolder.java */
    public static class b extends i {

        /* renamed from: t, reason: collision with root package name */
        public f f16029t;

        /* renamed from: u, reason: collision with root package name */
        public int f16030u;

        public b(String str, int... iArr) {
            super(str);
            setIntValues(iArr);
        }

        @Override // la.i
        public final void a(float f10) {
            this.f16030u = this.f16029t.getIntValue(f10);
        }

        @Override // la.i
        public final Object b() {
            return Integer.valueOf(this.f16030u);
        }

        @Override // la.i
        public void setIntValues(int... iArr) {
            super.setIntValues(iArr);
            this.f16029t = (f) this.f16023n;
        }

        @Override // la.i
        /* renamed from: clone */
        public b mo87clone() {
            b bVar = (b) super.mo87clone();
            bVar.f16029t = (f) bVar.f16023n;
            return bVar;
        }
    }

    @Override // 
    /* renamed from: clone, reason: collision with other method in class */
    public i mo87clone() {
        try {
            i iVar = (i) super.clone();
            iVar.f16021b = this.f16021b;
            iVar.f16023n = this.f16023n.clone();
            iVar.f16025p = this.f16025p;
            return iVar;
        } catch (CloneNotSupportedException unused) {
            return null;
        }
    }
}
