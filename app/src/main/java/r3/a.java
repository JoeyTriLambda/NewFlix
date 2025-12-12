package r3;

import android.graphics.Matrix;
import android.graphics.Paint;
import android.graphics.Path;
import android.graphics.PathMeasure;
import android.graphics.RectF;
import com.airbnb.lottie.model.content.ShapeTrimPath;
import java.util.ArrayList;
import java.util.List;
import s3.a;

/* compiled from: BaseStrokeContent.java */
/* loaded from: classes.dex */
public abstract class a implements a.InterfaceC0246a, k, e {

    /* renamed from: e, reason: collision with root package name */
    public final p3.f f18453e;

    /* renamed from: f, reason: collision with root package name */
    public final com.airbnb.lottie.model.layer.a f18454f;

    /* renamed from: h, reason: collision with root package name */
    public final float[] f18456h;

    /* renamed from: i, reason: collision with root package name */
    public final q3.a f18457i;

    /* renamed from: j, reason: collision with root package name */
    public final s3.a<?, Float> f18458j;

    /* renamed from: k, reason: collision with root package name */
    public final s3.a<?, Integer> f18459k;

    /* renamed from: l, reason: collision with root package name */
    public final ArrayList f18460l;

    /* renamed from: m, reason: collision with root package name */
    public final s3.a<?, Float> f18461m;

    /* renamed from: n, reason: collision with root package name */
    public s3.p f18462n;

    /* renamed from: a, reason: collision with root package name */
    public final PathMeasure f18449a = new PathMeasure();

    /* renamed from: b, reason: collision with root package name */
    public final Path f18450b = new Path();

    /* renamed from: c, reason: collision with root package name */
    public final Path f18451c = new Path();

    /* renamed from: d, reason: collision with root package name */
    public final RectF f18452d = new RectF();

    /* renamed from: g, reason: collision with root package name */
    public final ArrayList f18455g = new ArrayList();

    /* compiled from: BaseStrokeContent.java */
    /* renamed from: r3.a$a, reason: collision with other inner class name */
    public static final class C0237a {

        /* renamed from: a, reason: collision with root package name */
        public final ArrayList f18463a = new ArrayList();

        /* renamed from: b, reason: collision with root package name */
        public final s f18464b;

        public C0237a(s sVar) {
            this.f18464b = sVar;
        }
    }

    public a(p3.f fVar, com.airbnb.lottie.model.layer.a aVar, Paint.Cap cap, Paint.Join join, float f10, v3.d dVar, v3.b bVar, List<v3.b> list, v3.b bVar2) {
        q3.a aVar2 = new q3.a(1);
        this.f18457i = aVar2;
        this.f18453e = fVar;
        this.f18454f = aVar;
        aVar2.setStyle(Paint.Style.STROKE);
        aVar2.setStrokeCap(cap);
        aVar2.setStrokeJoin(join);
        aVar2.setStrokeMiter(f10);
        this.f18459k = dVar.createAnimation();
        this.f18458j = bVar.createAnimation();
        if (bVar2 == null) {
            this.f18461m = null;
        } else {
            this.f18461m = bVar2.createAnimation();
        }
        this.f18460l = new ArrayList(list.size());
        this.f18456h = new float[list.size()];
        for (int i10 = 0; i10 < list.size(); i10++) {
            this.f18460l.add(list.get(i10).createAnimation());
        }
        aVar.addAnimation(this.f18459k);
        aVar.addAnimation(this.f18458j);
        for (int i11 = 0; i11 < this.f18460l.size(); i11++) {
            aVar.addAnimation((s3.a) this.f18460l.get(i11));
        }
        s3.a<?, Float> aVar3 = this.f18461m;
        if (aVar3 != null) {
            aVar.addAnimation(aVar3);
        }
        this.f18459k.addUpdateListener(this);
        this.f18458j.addUpdateListener(this);
        for (int i12 = 0; i12 < list.size(); i12++) {
            ((s3.a) this.f18460l.get(i12)).addUpdateListener(this);
        }
        s3.a<?, Float> aVar4 = this.f18461m;
        if (aVar4 != null) {
            aVar4.addUpdateListener(this);
        }
    }

    @Override // u3.e
    public <T> void addValueCallback(T t10, b4.c<T> cVar) {
        if (t10 == p3.k.f17509d) {
            this.f18459k.setValueCallback(cVar);
            return;
        }
        if (t10 == p3.k.f17520o) {
            this.f18458j.setValueCallback(cVar);
            return;
        }
        if (t10 == p3.k.C) {
            s3.p pVar = this.f18462n;
            com.airbnb.lottie.model.layer.a aVar = this.f18454f;
            if (pVar != null) {
                aVar.removeAnimation(pVar);
            }
            if (cVar == null) {
                this.f18462n = null;
                return;
            }
            s3.p pVar2 = new s3.p(cVar);
            this.f18462n = pVar2;
            pVar2.addUpdateListener(this);
            aVar.addAnimation(this.f18462n);
        }
    }

    /* JADX WARN: Removed duplicated region for block: B:62:0x01aa  */
    @Override // r3.e
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public void draw(android.graphics.Canvas r21, android.graphics.Matrix r22, int r23) {
        /*
            Method dump skipped, instructions count: 558
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: r3.a.draw(android.graphics.Canvas, android.graphics.Matrix, int):void");
    }

    @Override // r3.e
    public void getBounds(RectF rectF, Matrix matrix, boolean z10) {
        p3.c.beginSection("StrokeContent#getBounds");
        Path path = this.f18450b;
        path.reset();
        int i10 = 0;
        while (true) {
            ArrayList arrayList = this.f18455g;
            if (i10 >= arrayList.size()) {
                RectF rectF2 = this.f18452d;
                path.computeBounds(rectF2, false);
                float floatValue = ((s3.c) this.f18458j).getFloatValue() / 2.0f;
                rectF2.set(rectF2.left - floatValue, rectF2.top - floatValue, rectF2.right + floatValue, rectF2.bottom + floatValue);
                rectF.set(rectF2);
                rectF.set(rectF.left - 1.0f, rectF.top - 1.0f, rectF.right + 1.0f, rectF.bottom + 1.0f);
                p3.c.endSection("StrokeContent#getBounds");
                return;
            }
            C0237a c0237a = (C0237a) arrayList.get(i10);
            for (int i11 = 0; i11 < c0237a.f18463a.size(); i11++) {
                path.addPath(((m) c0237a.f18463a.get(i11)).getPath(), matrix);
            }
            i10++;
        }
    }

    @Override // s3.a.InterfaceC0246a
    public void onValueChanged() {
        this.f18453e.invalidateSelf();
    }

    @Override // u3.e
    public void resolveKeyPath(u3.d dVar, int i10, List<u3.d> list, u3.d dVar2) {
        a4.g.resolveKeyPath(dVar, i10, list, dVar2, this);
    }

    @Override // r3.c
    public void setContents(List<c> list, List<c> list2) {
        ShapeTrimPath.Type type;
        ArrayList arrayList;
        int size = list.size() - 1;
        C0237a c0237a = null;
        s sVar = null;
        while (true) {
            type = ShapeTrimPath.Type.INDIVIDUALLY;
            if (size < 0) {
                break;
            }
            c cVar = list.get(size);
            if (cVar instanceof s) {
                s sVar2 = (s) cVar;
                if (sVar2.f18576c == type) {
                    sVar = sVar2;
                }
            }
            size--;
        }
        if (sVar != null) {
            sVar.a(this);
        }
        int size2 = list2.size();
        while (true) {
            size2--;
            arrayList = this.f18455g;
            if (size2 < 0) {
                break;
            }
            c cVar2 = list2.get(size2);
            if (cVar2 instanceof s) {
                s sVar3 = (s) cVar2;
                if (sVar3.f18576c == type) {
                    if (c0237a != null) {
                        arrayList.add(c0237a);
                    }
                    C0237a c0237a2 = new C0237a(sVar3);
                    sVar3.a(this);
                    c0237a = c0237a2;
                }
            }
            if (cVar2 instanceof m) {
                if (c0237a == null) {
                    c0237a = new C0237a(sVar);
                }
                c0237a.f18463a.add((m) cVar2);
            }
        }
        if (c0237a != null) {
            arrayList.add(c0237a);
        }
    }
}
