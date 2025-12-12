package q7;

import android.graphics.Canvas;
import android.graphics.Matrix;
import android.graphics.Path;
import android.graphics.RectF;
import java.util.ArrayList;

/* compiled from: ShapePath.java */
/* loaded from: classes.dex */
public final class o {

    /* renamed from: a, reason: collision with root package name */
    @Deprecated
    public float f18007a;

    /* renamed from: b, reason: collision with root package name */
    @Deprecated
    public float f18008b;

    /* renamed from: c, reason: collision with root package name */
    @Deprecated
    public float f18009c;

    /* renamed from: d, reason: collision with root package name */
    @Deprecated
    public float f18010d;

    /* renamed from: e, reason: collision with root package name */
    @Deprecated
    public float f18011e;

    /* renamed from: f, reason: collision with root package name */
    @Deprecated
    public float f18012f;

    /* renamed from: g, reason: collision with root package name */
    public final ArrayList f18013g = new ArrayList();

    /* renamed from: h, reason: collision with root package name */
    public final ArrayList f18014h = new ArrayList();

    /* compiled from: ShapePath.java */
    public static class a extends f {

        /* renamed from: c, reason: collision with root package name */
        public final c f18015c;

        public a(c cVar) {
            this.f18015c = cVar;
        }

        @Override // q7.o.f
        public void draw(Matrix matrix, p7.a aVar, int i10, Canvas canvas) {
            c cVar = this.f18015c;
            aVar.drawCornerShadow(canvas, matrix, new RectF(cVar.f18020b, cVar.f18021c, cVar.f18022d, cVar.f18023e), i10, cVar.f18024f, cVar.f18025g);
        }
    }

    /* compiled from: ShapePath.java */
    public static class b extends f {

        /* renamed from: c, reason: collision with root package name */
        public final d f18016c;

        /* renamed from: d, reason: collision with root package name */
        public final float f18017d;

        /* renamed from: e, reason: collision with root package name */
        public final float f18018e;

        public b(d dVar, float f10, float f11) {
            this.f18016c = dVar;
            this.f18017d = f10;
            this.f18018e = f11;
        }

        public final float a() {
            d dVar = this.f18016c;
            return (float) Math.toDegrees(Math.atan((dVar.f18027c - this.f18018e) / (dVar.f18026b - this.f18017d)));
        }

        @Override // q7.o.f
        public void draw(Matrix matrix, p7.a aVar, int i10, Canvas canvas) {
            d dVar = this.f18016c;
            float f10 = dVar.f18027c;
            float f11 = this.f18018e;
            float f12 = dVar.f18026b;
            float f13 = this.f18017d;
            RectF rectF = new RectF(0.0f, 0.0f, (float) Math.hypot(f10 - f11, f12 - f13), 0.0f);
            Matrix matrix2 = this.f18030a;
            matrix2.set(matrix);
            matrix2.preTranslate(f13, f11);
            matrix2.preRotate(a());
            aVar.drawEdgeShadow(canvas, matrix2, rectF, i10);
        }
    }

    /* compiled from: ShapePath.java */
    public static class c extends e {

        /* renamed from: h, reason: collision with root package name */
        public static final RectF f18019h = new RectF();

        /* renamed from: b, reason: collision with root package name */
        @Deprecated
        public float f18020b;

        /* renamed from: c, reason: collision with root package name */
        @Deprecated
        public float f18021c;

        /* renamed from: d, reason: collision with root package name */
        @Deprecated
        public float f18022d;

        /* renamed from: e, reason: collision with root package name */
        @Deprecated
        public float f18023e;

        /* renamed from: f, reason: collision with root package name */
        @Deprecated
        public float f18024f;

        /* renamed from: g, reason: collision with root package name */
        @Deprecated
        public float f18025g;

        public c(float f10, float f11, float f12, float f13) {
            this.f18020b = f10;
            this.f18021c = f11;
            this.f18022d = f12;
            this.f18023e = f13;
        }

        @Override // q7.o.e
        public void applyToPath(Matrix matrix, Path path) {
            Matrix matrix2 = this.f18028a;
            matrix.invert(matrix2);
            path.transform(matrix2);
            RectF rectF = f18019h;
            rectF.set(this.f18020b, this.f18021c, this.f18022d, this.f18023e);
            path.arcTo(rectF, this.f18024f, this.f18025g, false);
            path.transform(matrix);
        }
    }

    /* compiled from: ShapePath.java */
    public static class d extends e {

        /* renamed from: b, reason: collision with root package name */
        public float f18026b;

        /* renamed from: c, reason: collision with root package name */
        public float f18027c;

        @Override // q7.o.e
        public void applyToPath(Matrix matrix, Path path) {
            Matrix matrix2 = this.f18028a;
            matrix.invert(matrix2);
            path.transform(matrix2);
            path.lineTo(this.f18026b, this.f18027c);
            path.transform(matrix);
        }
    }

    /* compiled from: ShapePath.java */
    public static abstract class e {

        /* renamed from: a, reason: collision with root package name */
        public final Matrix f18028a = new Matrix();

        public abstract void applyToPath(Matrix matrix, Path path);
    }

    /* compiled from: ShapePath.java */
    public static abstract class f {

        /* renamed from: b, reason: collision with root package name */
        public static final Matrix f18029b = new Matrix();

        /* renamed from: a, reason: collision with root package name */
        public final Matrix f18030a = new Matrix();

        public abstract void draw(Matrix matrix, p7.a aVar, int i10, Canvas canvas);

        public final void draw(p7.a aVar, int i10, Canvas canvas) {
            draw(f18029b, aVar, i10, canvas);
        }
    }

    public o() {
        reset(0.0f, 0.0f);
    }

    public final void a(float f10) {
        float f11 = this.f18011e;
        if (f11 == f10) {
            return;
        }
        float f12 = ((f10 - f11) + 360.0f) % 360.0f;
        if (f12 > 180.0f) {
            return;
        }
        float f13 = this.f18009c;
        float f14 = this.f18010d;
        c cVar = new c(f13, f14, f13, f14);
        cVar.f18024f = this.f18011e;
        cVar.f18025g = f12;
        this.f18014h.add(new a(cVar));
        this.f18011e = f10;
    }

    public void addArc(float f10, float f11, float f12, float f13, float f14, float f15) {
        c cVar = new c(f10, f11, f12, f13);
        cVar.f18024f = f14;
        cVar.f18025g = f15;
        this.f18013g.add(cVar);
        a aVar = new a(cVar);
        float f16 = f14 + f15;
        boolean z10 = f15 < 0.0f;
        if (z10) {
            f14 = (f14 + 180.0f) % 360.0f;
        }
        float f17 = z10 ? (180.0f + f16) % 360.0f : f16;
        a(f14);
        this.f18014h.add(aVar);
        this.f18011e = f17;
        double d10 = f16;
        this.f18009c = (((f12 - f10) / 2.0f) * ((float) Math.cos(Math.toRadians(d10)))) + ((f10 + f12) * 0.5f);
        this.f18010d = (((f13 - f11) / 2.0f) * ((float) Math.sin(Math.toRadians(d10)))) + ((f11 + f13) * 0.5f);
    }

    public void applyToPath(Matrix matrix, Path path) {
        ArrayList arrayList = this.f18013g;
        int size = arrayList.size();
        for (int i10 = 0; i10 < size; i10++) {
            ((e) arrayList.get(i10)).applyToPath(matrix, path);
        }
    }

    public void lineTo(float f10, float f11) {
        d dVar = new d();
        dVar.f18026b = f10;
        dVar.f18027c = f11;
        this.f18013g.add(dVar);
        b bVar = new b(dVar, this.f18009c, this.f18010d);
        float fA = bVar.a() + 270.0f;
        float fA2 = bVar.a() + 270.0f;
        a(fA);
        this.f18014h.add(bVar);
        this.f18011e = fA2;
        this.f18009c = f10;
        this.f18010d = f11;
    }

    public void reset(float f10, float f11) {
        reset(f10, f11, 270.0f, 0.0f);
    }

    public void reset(float f10, float f11, float f12, float f13) {
        this.f18007a = f10;
        this.f18008b = f11;
        this.f18009c = f10;
        this.f18010d = f11;
        this.f18011e = f12;
        this.f18012f = (f12 + f13) % 360.0f;
        this.f18013g.clear();
        this.f18014h.clear();
    }
}
