package com.airbnb.lottie.model.layer;

import android.graphics.Canvas;
import android.graphics.Matrix;
import android.graphics.Path;
import android.graphics.PorterDuff;
import android.graphics.PorterDuffXfermode;
import android.graphics.RectF;
import com.airbnb.lottie.model.content.Mask;
import com.airbnb.lottie.model.layer.Layer;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Iterator;
import java.util.List;
import p3.f;
import r3.e;
import s3.a;
import s3.c;
import s3.g;
import s3.o;
import u3.d;

/* compiled from: BaseLayer.java */
/* loaded from: classes.dex */
public abstract class a implements e, a.InterfaceC0246a, u3.e {

    /* renamed from: a, reason: collision with root package name */
    public final Path f5499a = new Path();

    /* renamed from: b, reason: collision with root package name */
    public final Matrix f5500b = new Matrix();

    /* renamed from: c, reason: collision with root package name */
    public final q3.a f5501c = new q3.a(1);

    /* renamed from: d, reason: collision with root package name */
    public final q3.a f5502d = new q3.a(1, PorterDuff.Mode.DST_IN);

    /* renamed from: e, reason: collision with root package name */
    public final q3.a f5503e = new q3.a(1, PorterDuff.Mode.DST_OUT);

    /* renamed from: f, reason: collision with root package name */
    public final q3.a f5504f;

    /* renamed from: g, reason: collision with root package name */
    public final q3.a f5505g;

    /* renamed from: h, reason: collision with root package name */
    public final RectF f5506h;

    /* renamed from: i, reason: collision with root package name */
    public final RectF f5507i;

    /* renamed from: j, reason: collision with root package name */
    public final RectF f5508j;

    /* renamed from: k, reason: collision with root package name */
    public final RectF f5509k;

    /* renamed from: l, reason: collision with root package name */
    public final String f5510l;

    /* renamed from: m, reason: collision with root package name */
    public final Matrix f5511m;

    /* renamed from: n, reason: collision with root package name */
    public final f f5512n;

    /* renamed from: o, reason: collision with root package name */
    public final Layer f5513o;

    /* renamed from: p, reason: collision with root package name */
    public final g f5514p;

    /* renamed from: q, reason: collision with root package name */
    public c f5515q;

    /* renamed from: r, reason: collision with root package name */
    public a f5516r;

    /* renamed from: s, reason: collision with root package name */
    public a f5517s;

    /* renamed from: t, reason: collision with root package name */
    public List<a> f5518t;

    /* renamed from: u, reason: collision with root package name */
    public final ArrayList f5519u;

    /* renamed from: v, reason: collision with root package name */
    public final o f5520v;

    /* renamed from: w, reason: collision with root package name */
    public boolean f5521w;

    public a(f fVar, Layer layer) {
        q3.a aVar = new q3.a(1);
        this.f5504f = aVar;
        this.f5505g = new q3.a(PorterDuff.Mode.CLEAR);
        this.f5506h = new RectF();
        this.f5507i = new RectF();
        this.f5508j = new RectF();
        this.f5509k = new RectF();
        this.f5511m = new Matrix();
        this.f5519u = new ArrayList();
        this.f5521w = true;
        this.f5512n = fVar;
        this.f5513o = layer;
        this.f5510l = ac.c.o(new StringBuilder(), layer.f5472c, "#draw");
        if (layer.f5490u == Layer.MatteType.INVERT) {
            aVar.setXfermode(new PorterDuffXfermode(PorterDuff.Mode.DST_OUT));
        } else {
            aVar.setXfermode(new PorterDuffXfermode(PorterDuff.Mode.DST_IN));
        }
        o oVarCreateAnimation = layer.f5478i.createAnimation();
        this.f5520v = oVarCreateAnimation;
        oVarCreateAnimation.addListener(this);
        List<Mask> list = layer.f5477h;
        if (list != null && !list.isEmpty()) {
            g gVar = new g(list);
            this.f5514p = gVar;
            Iterator<s3.a<w3.g, Path>> it = gVar.getMaskAnimations().iterator();
            while (it.hasNext()) {
                it.next().addUpdateListener(this);
            }
            for (s3.a<Integer, Integer> aVar2 : this.f5514p.getOpacityAnimations()) {
                addAnimation(aVar2);
                aVar2.addUpdateListener(this);
            }
        }
        Layer layer2 = this.f5513o;
        if (layer2.f5489t.isEmpty()) {
            if (true != this.f5521w) {
                this.f5521w = true;
                this.f5512n.invalidateSelf();
                return;
            }
            return;
        }
        c cVar = new c(layer2.f5489t);
        this.f5515q = cVar;
        cVar.setIsDiscrete();
        this.f5515q.addUpdateListener(new x3.a(this));
        boolean z10 = this.f5515q.getValue().floatValue() == 1.0f;
        if (z10 != this.f5521w) {
            this.f5521w = z10;
            this.f5512n.invalidateSelf();
        }
        addAnimation(this.f5515q);
    }

    public final void a() {
        if (this.f5518t != null) {
            return;
        }
        if (this.f5517s == null) {
            this.f5518t = Collections.emptyList();
            return;
        }
        this.f5518t = new ArrayList();
        for (a aVar = this.f5517s; aVar != null; aVar = aVar.f5517s) {
            this.f5518t.add(aVar);
        }
    }

    public void addAnimation(s3.a<?, ?> aVar) {
        if (aVar == null) {
            return;
        }
        this.f5519u.add(aVar);
    }

    @Override // u3.e
    public <T> void addValueCallback(T t10, b4.c<T> cVar) {
        this.f5520v.applyValueCallback(t10, cVar);
    }

    public final void b(Canvas canvas) {
        p3.c.beginSection("Layer#clearLayer");
        RectF rectF = this.f5506h;
        canvas.drawRect(rectF.left - 1.0f, rectF.top - 1.0f, rectF.right + 1.0f, rectF.bottom + 1.0f, this.f5505g);
        p3.c.endSection("Layer#clearLayer");
    }

    public final boolean c() {
        g gVar = this.f5514p;
        return (gVar == null || gVar.getMaskAnimations().isEmpty()) ? false : true;
    }

    /* JADX WARN: Removed duplicated region for block: B:51:0x0137  */
    /* JADX WARN: Removed duplicated region for block: B:57:0x0149  */
    /* JADX WARN: Removed duplicated region for block: B:58:0x014f  */
    /* JADX WARN: Removed duplicated region for block: B:65:0x01a2  */
    /* JADX WARN: Removed duplicated region for block: B:68:0x01ae  */
    /* JADX WARN: Removed duplicated region for block: B:97:0x0261  */
    @Override // r3.e
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public void draw(android.graphics.Canvas r23, android.graphics.Matrix r24, int r25) {
        /*
            Method dump skipped, instructions count: 991
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: com.airbnb.lottie.model.layer.a.draw(android.graphics.Canvas, android.graphics.Matrix, int):void");
    }

    public abstract void drawLayer(Canvas canvas, Matrix matrix, int i10);

    @Override // r3.e
    public void getBounds(RectF rectF, Matrix matrix, boolean z10) {
        this.f5506h.set(0.0f, 0.0f, 0.0f, 0.0f);
        a();
        Matrix matrix2 = this.f5511m;
        matrix2.set(matrix);
        if (z10) {
            List<a> list = this.f5518t;
            if (list != null) {
                for (int size = list.size() - 1; size >= 0; size--) {
                    matrix2.preConcat(this.f5518t.get(size).f5520v.getMatrix());
                }
            } else {
                a aVar = this.f5517s;
                if (aVar != null) {
                    matrix2.preConcat(aVar.f5520v.getMatrix());
                }
            }
        }
        matrix2.preConcat(this.f5520v.getMatrix());
    }

    @Override // r3.c
    public String getName() {
        return this.f5513o.f5472c;
    }

    @Override // s3.a.InterfaceC0246a
    public void onValueChanged() {
        this.f5512n.invalidateSelf();
    }

    public void removeAnimation(s3.a<?, ?> aVar) {
        this.f5519u.remove(aVar);
    }

    @Override // u3.e
    public void resolveKeyPath(d dVar, int i10, List<d> list, d dVar2) {
        if (dVar.matches(getName(), i10)) {
            if (!"__container".equals(getName())) {
                dVar2 = dVar2.addKey(getName());
                if (dVar.fullyResolvesTo(getName(), i10)) {
                    list.add(dVar2.resolve(this));
                }
            }
            if (dVar.propagateToChildren(getName(), i10)) {
                resolveChildKeyPath(dVar, dVar.incrementDepthBy(getName(), i10) + i10, list, dVar2);
            }
        }
    }

    public void setProgress(float f10) {
        this.f5520v.setProgress(f10);
        int i10 = 0;
        g gVar = this.f5514p;
        if (gVar != null) {
            for (int i11 = 0; i11 < gVar.getMaskAnimations().size(); i11++) {
                gVar.getMaskAnimations().get(i11).setProgress(f10);
            }
        }
        float f11 = this.f5513o.f5482m;
        if (f11 != 0.0f) {
            f10 /= f11;
        }
        c cVar = this.f5515q;
        if (cVar != null) {
            cVar.setProgress(f10 / f11);
        }
        a aVar = this.f5516r;
        if (aVar != null) {
            aVar.setProgress(aVar.f5513o.f5482m * f10);
        }
        while (true) {
            ArrayList arrayList = this.f5519u;
            if (i10 >= arrayList.size()) {
                return;
            }
            ((s3.a) arrayList.get(i10)).setProgress(f10);
            i10++;
        }
    }

    @Override // r3.c
    public void setContents(List<r3.c> list, List<r3.c> list2) {
    }

    public void resolveChildKeyPath(d dVar, int i10, List<d> list, d dVar2) {
    }
}
