package a7;

import android.animation.TypeEvaluator;
import android.graphics.drawable.Drawable;
import android.util.Property;

/* compiled from: CircularRevealWidget.java */
/* loaded from: classes.dex */
public interface c {

    /* compiled from: CircularRevealWidget.java */
    public static class a implements TypeEvaluator<d> {

        /* renamed from: b, reason: collision with root package name */
        public static final a f369b = new a();

        /* renamed from: a, reason: collision with root package name */
        public final d f370a = new d();

        @Override // android.animation.TypeEvaluator
        public d evaluate(float f10, d dVar, d dVar2) {
            float fLerp = j7.a.lerp(dVar.f373a, dVar2.f373a, f10);
            float fLerp2 = j7.a.lerp(dVar.f374b, dVar2.f374b, f10);
            float fLerp3 = j7.a.lerp(dVar.f375c, dVar2.f375c, f10);
            d dVar3 = this.f370a;
            dVar3.set(fLerp, fLerp2, fLerp3);
            return dVar3;
        }
    }

    /* compiled from: CircularRevealWidget.java */
    public static class b extends Property<c, d> {

        /* renamed from: a, reason: collision with root package name */
        public static final b f371a = new b();

        public b() {
            super(d.class, "circularReveal");
        }

        @Override // android.util.Property
        public d get(c cVar) {
            return cVar.getRevealInfo();
        }

        @Override // android.util.Property
        public void set(c cVar, d dVar) {
            cVar.setRevealInfo(dVar);
        }
    }

    /* compiled from: CircularRevealWidget.java */
    /* renamed from: a7.c$c, reason: collision with other inner class name */
    public static class C0007c extends Property<c, Integer> {

        /* renamed from: a, reason: collision with root package name */
        public static final C0007c f372a = new C0007c();

        public C0007c() {
            super(Integer.class, "circularRevealScrimColor");
        }

        @Override // android.util.Property
        public Integer get(c cVar) {
            return Integer.valueOf(cVar.getCircularRevealScrimColor());
        }

        @Override // android.util.Property
        public void set(c cVar, Integer num) {
            cVar.setCircularRevealScrimColor(num.intValue());
        }
    }

    /* compiled from: CircularRevealWidget.java */
    public static class d {

        /* renamed from: a, reason: collision with root package name */
        public float f373a;

        /* renamed from: b, reason: collision with root package name */
        public float f374b;

        /* renamed from: c, reason: collision with root package name */
        public float f375c;

        public d() {
        }

        public d(float f10, float f11, float f12) {
            this.f373a = f10;
            this.f374b = f11;
            this.f375c = f12;
        }

        public void set(float f10, float f11, float f12) {
            this.f373a = f10;
            this.f374b = f11;
            this.f375c = f12;
        }
    }

    void buildCircularRevealCache();

    void destroyCircularRevealCache();

    int getCircularRevealScrimColor();

    d getRevealInfo();

    void setCircularRevealOverlayDrawable(Drawable drawable);

    void setCircularRevealScrimColor(int i10);

    void setRevealInfo(d dVar);
}
