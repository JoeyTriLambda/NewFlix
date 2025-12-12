package r3;

import android.graphics.Canvas;
import android.graphics.ColorFilter;
import android.graphics.Matrix;
import android.graphics.Path;
import android.graphics.RectF;
import java.util.ArrayList;
import java.util.List;
import s3.a;

/* compiled from: FillContent.java */
/* loaded from: classes.dex */
public final class g implements e, a.InterfaceC0246a, k {

    /* renamed from: a, reason: collision with root package name */
    public final Path f18485a;

    /* renamed from: b, reason: collision with root package name */
    public final q3.a f18486b;

    /* renamed from: c, reason: collision with root package name */
    public final com.airbnb.lottie.model.layer.a f18487c;

    /* renamed from: d, reason: collision with root package name */
    public final String f18488d;

    /* renamed from: e, reason: collision with root package name */
    public final boolean f18489e;

    /* renamed from: f, reason: collision with root package name */
    public final ArrayList f18490f;

    /* renamed from: g, reason: collision with root package name */
    public final s3.a<Integer, Integer> f18491g;

    /* renamed from: h, reason: collision with root package name */
    public final s3.a<Integer, Integer> f18492h;

    /* renamed from: i, reason: collision with root package name */
    public s3.p f18493i;

    /* renamed from: j, reason: collision with root package name */
    public final p3.f f18494j;

    public g(p3.f fVar, com.airbnb.lottie.model.layer.a aVar, w3.h hVar) {
        Path path = new Path();
        this.f18485a = path;
        this.f18486b = new q3.a(1);
        this.f18490f = new ArrayList();
        this.f18487c = aVar;
        this.f18488d = hVar.getName();
        this.f18489e = hVar.isHidden();
        this.f18494j = fVar;
        if (hVar.getColor() == null || hVar.getOpacity() == null) {
            this.f18491g = null;
            this.f18492h = null;
            return;
        }
        path.setFillType(hVar.getFillType());
        s3.a<Integer, Integer> aVarCreateAnimation = hVar.getColor().createAnimation();
        this.f18491g = aVarCreateAnimation;
        aVarCreateAnimation.addUpdateListener(this);
        aVar.addAnimation(aVarCreateAnimation);
        s3.a<Integer, Integer> aVarCreateAnimation2 = hVar.getOpacity().createAnimation();
        this.f18492h = aVarCreateAnimation2;
        aVarCreateAnimation2.addUpdateListener(this);
        aVar.addAnimation(aVarCreateAnimation2);
    }

    @Override // u3.e
    public <T> void addValueCallback(T t10, b4.c<T> cVar) {
        if (t10 == p3.k.f17506a) {
            this.f18491g.setValueCallback(cVar);
            return;
        }
        if (t10 == p3.k.f17509d) {
            this.f18492h.setValueCallback(cVar);
            return;
        }
        if (t10 == p3.k.C) {
            s3.p pVar = this.f18493i;
            com.airbnb.lottie.model.layer.a aVar = this.f18487c;
            if (pVar != null) {
                aVar.removeAnimation(pVar);
            }
            if (cVar == null) {
                this.f18493i = null;
                return;
            }
            s3.p pVar2 = new s3.p(cVar);
            this.f18493i = pVar2;
            pVar2.addUpdateListener(this);
            aVar.addAnimation(this.f18493i);
        }
    }

    @Override // r3.e
    public void draw(Canvas canvas, Matrix matrix, int i10) {
        if (this.f18489e) {
            return;
        }
        p3.c.beginSection("FillContent#draw");
        int intValue = ((s3.b) this.f18491g).getIntValue();
        q3.a aVar = this.f18486b;
        aVar.setColor(intValue);
        int i11 = 0;
        aVar.setAlpha(a4.g.clamp((int) ((((i10 / 255.0f) * this.f18492h.getValue().intValue()) / 100.0f) * 255.0f), 0, 255));
        s3.p pVar = this.f18493i;
        if (pVar != null) {
            aVar.setColorFilter((ColorFilter) pVar.getValue());
        }
        Path path = this.f18485a;
        path.reset();
        while (true) {
            ArrayList arrayList = this.f18490f;
            if (i11 >= arrayList.size()) {
                canvas.drawPath(path, aVar);
                p3.c.endSection("FillContent#draw");
                return;
            } else {
                path.addPath(((m) arrayList.get(i11)).getPath(), matrix);
                i11++;
            }
        }
    }

    @Override // r3.e
    public void getBounds(RectF rectF, Matrix matrix, boolean z10) {
        Path path = this.f18485a;
        path.reset();
        int i10 = 0;
        while (true) {
            ArrayList arrayList = this.f18490f;
            if (i10 >= arrayList.size()) {
                path.computeBounds(rectF, false);
                rectF.set(rectF.left - 1.0f, rectF.top - 1.0f, rectF.right + 1.0f, rectF.bottom + 1.0f);
                return;
            } else {
                path.addPath(((m) arrayList.get(i10)).getPath(), matrix);
                i10++;
            }
        }
    }

    @Override // r3.c
    public String getName() {
        return this.f18488d;
    }

    @Override // s3.a.InterfaceC0246a
    public void onValueChanged() {
        this.f18494j.invalidateSelf();
    }

    @Override // u3.e
    public void resolveKeyPath(u3.d dVar, int i10, List<u3.d> list, u3.d dVar2) {
        a4.g.resolveKeyPath(dVar, i10, list, dVar2, this);
    }

    @Override // r3.c
    public void setContents(List<c> list, List<c> list2) {
        for (int i10 = 0; i10 < list2.size(); i10++) {
            c cVar = list2.get(i10);
            if (cVar instanceof m) {
                this.f18490f.add((m) cVar);
            }
        }
    }
}
