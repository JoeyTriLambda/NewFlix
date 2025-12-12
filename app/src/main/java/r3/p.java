package r3;

import android.graphics.Canvas;
import android.graphics.Matrix;
import android.graphics.Path;
import android.graphics.RectF;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.ListIterator;
import s3.a;

/* compiled from: RepeaterContent.java */
/* loaded from: classes.dex */
public final class p implements e, m, j, a.InterfaceC0246a, k {

    /* renamed from: a, reason: collision with root package name */
    public final Matrix f18553a = new Matrix();

    /* renamed from: b, reason: collision with root package name */
    public final Path f18554b = new Path();

    /* renamed from: c, reason: collision with root package name */
    public final p3.f f18555c;

    /* renamed from: d, reason: collision with root package name */
    public final com.airbnb.lottie.model.layer.a f18556d;

    /* renamed from: e, reason: collision with root package name */
    public final String f18557e;

    /* renamed from: f, reason: collision with root package name */
    public final boolean f18558f;

    /* renamed from: g, reason: collision with root package name */
    public final s3.a<Float, Float> f18559g;

    /* renamed from: h, reason: collision with root package name */
    public final s3.a<Float, Float> f18560h;

    /* renamed from: i, reason: collision with root package name */
    public final s3.o f18561i;

    /* renamed from: j, reason: collision with root package name */
    public d f18562j;

    public p(p3.f fVar, com.airbnb.lottie.model.layer.a aVar, w3.f fVar2) {
        this.f18555c = fVar;
        this.f18556d = aVar;
        this.f18557e = fVar2.getName();
        this.f18558f = fVar2.isHidden();
        s3.a<Float, Float> aVarCreateAnimation = fVar2.getCopies().createAnimation();
        this.f18559g = aVarCreateAnimation;
        aVar.addAnimation(aVarCreateAnimation);
        aVarCreateAnimation.addUpdateListener(this);
        s3.a<Float, Float> aVarCreateAnimation2 = fVar2.getOffset().createAnimation();
        this.f18560h = aVarCreateAnimation2;
        aVar.addAnimation(aVarCreateAnimation2);
        aVarCreateAnimation2.addUpdateListener(this);
        s3.o oVarCreateAnimation = fVar2.getTransform().createAnimation();
        this.f18561i = oVarCreateAnimation;
        oVarCreateAnimation.addAnimationsToLayer(aVar);
        oVarCreateAnimation.addListener(this);
    }

    @Override // r3.j
    public void absorbContent(ListIterator<c> listIterator) {
        if (this.f18562j != null) {
            return;
        }
        while (listIterator.hasPrevious() && listIterator.previous() != this) {
        }
        ArrayList arrayList = new ArrayList();
        while (listIterator.hasPrevious()) {
            arrayList.add(listIterator.previous());
            listIterator.remove();
        }
        Collections.reverse(arrayList);
        this.f18562j = new d(this.f18555c, this.f18556d, "Repeater", this.f18558f, arrayList, null);
    }

    @Override // u3.e
    public <T> void addValueCallback(T t10, b4.c<T> cVar) {
        if (this.f18561i.applyValueCallback(t10, cVar)) {
            return;
        }
        if (t10 == p3.k.f17522q) {
            this.f18559g.setValueCallback(cVar);
        } else if (t10 == p3.k.f17523r) {
            this.f18560h.setValueCallback(cVar);
        }
    }

    @Override // r3.e
    public void draw(Canvas canvas, Matrix matrix, int i10) {
        float fFloatValue = this.f18559g.getValue().floatValue();
        float fFloatValue2 = this.f18560h.getValue().floatValue();
        s3.o oVar = this.f18561i;
        float fFloatValue3 = oVar.getStartOpacity().getValue().floatValue() / 100.0f;
        float fFloatValue4 = oVar.getEndOpacity().getValue().floatValue() / 100.0f;
        for (int i11 = ((int) fFloatValue) - 1; i11 >= 0; i11--) {
            Matrix matrix2 = this.f18553a;
            matrix2.set(matrix);
            float f10 = i11;
            matrix2.preConcat(oVar.getMatrixForRepeater(f10 + fFloatValue2));
            this.f18562j.draw(canvas, matrix2, (int) (a4.g.lerp(fFloatValue3, fFloatValue4, f10 / fFloatValue) * i10));
        }
    }

    @Override // r3.e
    public void getBounds(RectF rectF, Matrix matrix, boolean z10) {
        this.f18562j.getBounds(rectF, matrix, z10);
    }

    @Override // r3.c
    public String getName() {
        return this.f18557e;
    }

    @Override // r3.m
    public Path getPath() {
        Path path = this.f18562j.getPath();
        Path path2 = this.f18554b;
        path2.reset();
        float fFloatValue = this.f18559g.getValue().floatValue();
        float fFloatValue2 = this.f18560h.getValue().floatValue();
        for (int i10 = ((int) fFloatValue) - 1; i10 >= 0; i10--) {
            Matrix matrix = this.f18553a;
            matrix.set(this.f18561i.getMatrixForRepeater(i10 + fFloatValue2));
            path2.addPath(path, matrix);
        }
        return path2;
    }

    @Override // s3.a.InterfaceC0246a
    public void onValueChanged() {
        this.f18555c.invalidateSelf();
    }

    @Override // u3.e
    public void resolveKeyPath(u3.d dVar, int i10, List<u3.d> list, u3.d dVar2) {
        a4.g.resolveKeyPath(dVar, i10, list, dVar2, this);
    }

    @Override // r3.c
    public void setContents(List<c> list, List<c> list2) {
        this.f18562j.setContents(list, list2);
    }
}
