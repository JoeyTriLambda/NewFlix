package r3;

import android.graphics.Canvas;
import android.graphics.ColorFilter;
import android.graphics.LinearGradient;
import android.graphics.Matrix;
import android.graphics.Path;
import android.graphics.PointF;
import android.graphics.RadialGradient;
import android.graphics.RectF;
import android.graphics.Shader;
import com.airbnb.lottie.model.content.GradientType;
import java.util.ArrayList;
import java.util.List;
import s3.a;

/* compiled from: GradientFillContent.java */
/* loaded from: classes.dex */
public final class h implements e, a.InterfaceC0246a, k {

    /* renamed from: a, reason: collision with root package name */
    public final String f18495a;

    /* renamed from: b, reason: collision with root package name */
    public final boolean f18496b;

    /* renamed from: c, reason: collision with root package name */
    public final com.airbnb.lottie.model.layer.a f18497c;

    /* renamed from: d, reason: collision with root package name */
    public final b0.h<LinearGradient> f18498d = new b0.h<>();

    /* renamed from: e, reason: collision with root package name */
    public final b0.h<RadialGradient> f18499e = new b0.h<>();

    /* renamed from: f, reason: collision with root package name */
    public final Path f18500f;

    /* renamed from: g, reason: collision with root package name */
    public final q3.a f18501g;

    /* renamed from: h, reason: collision with root package name */
    public final RectF f18502h;

    /* renamed from: i, reason: collision with root package name */
    public final ArrayList f18503i;

    /* renamed from: j, reason: collision with root package name */
    public final GradientType f18504j;

    /* renamed from: k, reason: collision with root package name */
    public final s3.a<w3.c, w3.c> f18505k;

    /* renamed from: l, reason: collision with root package name */
    public final s3.a<Integer, Integer> f18506l;

    /* renamed from: m, reason: collision with root package name */
    public final s3.a<PointF, PointF> f18507m;

    /* renamed from: n, reason: collision with root package name */
    public final s3.a<PointF, PointF> f18508n;

    /* renamed from: o, reason: collision with root package name */
    public s3.p f18509o;

    /* renamed from: p, reason: collision with root package name */
    public s3.p f18510p;

    /* renamed from: q, reason: collision with root package name */
    public final p3.f f18511q;

    /* renamed from: r, reason: collision with root package name */
    public final int f18512r;

    public h(p3.f fVar, com.airbnb.lottie.model.layer.a aVar, w3.d dVar) {
        Path path = new Path();
        this.f18500f = path;
        this.f18501g = new q3.a(1);
        this.f18502h = new RectF();
        this.f18503i = new ArrayList();
        this.f18497c = aVar;
        this.f18495a = dVar.getName();
        this.f18496b = dVar.isHidden();
        this.f18511q = fVar;
        this.f18504j = dVar.getGradientType();
        path.setFillType(dVar.getFillType());
        this.f18512r = (int) (fVar.getComposition().getDuration() / 32.0f);
        s3.a<w3.c, w3.c> aVarCreateAnimation = dVar.getGradientColor().createAnimation();
        this.f18505k = aVarCreateAnimation;
        aVarCreateAnimation.addUpdateListener(this);
        aVar.addAnimation(aVarCreateAnimation);
        s3.a<Integer, Integer> aVarCreateAnimation2 = dVar.getOpacity().createAnimation();
        this.f18506l = aVarCreateAnimation2;
        aVarCreateAnimation2.addUpdateListener(this);
        aVar.addAnimation(aVarCreateAnimation2);
        s3.a<PointF, PointF> aVarCreateAnimation3 = dVar.getStartPoint().createAnimation();
        this.f18507m = aVarCreateAnimation3;
        aVarCreateAnimation3.addUpdateListener(this);
        aVar.addAnimation(aVarCreateAnimation3);
        s3.a<PointF, PointF> aVarCreateAnimation4 = dVar.getEndPoint().createAnimation();
        this.f18508n = aVarCreateAnimation4;
        aVarCreateAnimation4.addUpdateListener(this);
        aVar.addAnimation(aVarCreateAnimation4);
    }

    public final int[] a(int[] iArr) {
        s3.p pVar = this.f18510p;
        if (pVar != null) {
            Integer[] numArr = (Integer[]) pVar.getValue();
            int i10 = 0;
            if (iArr.length == numArr.length) {
                while (i10 < iArr.length) {
                    iArr[i10] = numArr[i10].intValue();
                    i10++;
                }
            } else {
                iArr = new int[numArr.length];
                while (i10 < numArr.length) {
                    iArr[i10] = numArr[i10].intValue();
                    i10++;
                }
            }
        }
        return iArr;
    }

    /* JADX WARN: Multi-variable type inference failed */
    @Override // u3.e
    public <T> void addValueCallback(T t10, b4.c<T> cVar) {
        if (t10 == p3.k.f17509d) {
            this.f18506l.setValueCallback(cVar);
            return;
        }
        ColorFilter colorFilter = p3.k.C;
        com.airbnb.lottie.model.layer.a aVar = this.f18497c;
        if (t10 == colorFilter) {
            s3.p pVar = this.f18509o;
            if (pVar != null) {
                aVar.removeAnimation(pVar);
            }
            if (cVar == null) {
                this.f18509o = null;
                return;
            }
            s3.p pVar2 = new s3.p(cVar);
            this.f18509o = pVar2;
            pVar2.addUpdateListener(this);
            aVar.addAnimation(this.f18509o);
            return;
        }
        if (t10 == p3.k.D) {
            s3.p pVar3 = this.f18510p;
            if (pVar3 != null) {
                aVar.removeAnimation(pVar3);
            }
            if (cVar == null) {
                this.f18510p = null;
                return;
            }
            s3.p pVar4 = new s3.p(cVar);
            this.f18510p = pVar4;
            pVar4.addUpdateListener(this);
            aVar.addAnimation(this.f18510p);
        }
    }

    public final int b() {
        float progress = this.f18507m.getProgress();
        int i10 = this.f18512r;
        int iRound = Math.round(progress * i10);
        int iRound2 = Math.round(this.f18508n.getProgress() * i10);
        int iRound3 = Math.round(this.f18505k.getProgress() * i10);
        int i11 = iRound != 0 ? 527 * iRound : 17;
        if (iRound2 != 0) {
            i11 = i11 * 31 * iRound2;
        }
        return iRound3 != 0 ? i11 * 31 * iRound3 : i11;
    }

    /* JADX WARN: Multi-variable type inference failed */
    @Override // r3.e
    public void draw(Canvas canvas, Matrix matrix, int i10) {
        Shader radialGradient;
        if (this.f18496b) {
            return;
        }
        p3.c.beginSection("GradientFillContent#draw");
        Path path = this.f18500f;
        path.reset();
        int i11 = 0;
        while (true) {
            ArrayList arrayList = this.f18503i;
            if (i11 >= arrayList.size()) {
                break;
            }
            path.addPath(((m) arrayList.get(i11)).getPath(), matrix);
            i11++;
        }
        path.computeBounds(this.f18502h, false);
        GradientType gradientType = GradientType.LINEAR;
        GradientType gradientType2 = this.f18504j;
        s3.a<w3.c, w3.c> aVar = this.f18505k;
        s3.a<PointF, PointF> aVar2 = this.f18508n;
        s3.a<PointF, PointF> aVar3 = this.f18507m;
        if (gradientType2 == gradientType) {
            long jB = b();
            b0.h<LinearGradient> hVar = this.f18498d;
            radialGradient = (LinearGradient) hVar.get(jB);
            if (radialGradient == null) {
                PointF value = aVar3.getValue();
                PointF value2 = aVar2.getValue();
                w3.c value3 = aVar.getValue();
                radialGradient = new LinearGradient(value.x, value.y, value2.x, value2.y, a(value3.getColors()), value3.getPositions(), Shader.TileMode.CLAMP);
                hVar.put(jB, radialGradient);
            }
        } else {
            long jB2 = b();
            b0.h<RadialGradient> hVar2 = this.f18499e;
            radialGradient = (RadialGradient) hVar2.get(jB2);
            if (radialGradient == null) {
                PointF value4 = aVar3.getValue();
                PointF value5 = aVar2.getValue();
                w3.c value6 = aVar.getValue();
                int[] iArrA = a(value6.getColors());
                float[] positions = value6.getPositions();
                float f10 = value4.x;
                float f11 = value4.y;
                float fHypot = (float) Math.hypot(value5.x - f10, value5.y - f11);
                radialGradient = new RadialGradient(f10, f11, fHypot <= 0.0f ? 0.001f : fHypot, iArrA, positions, Shader.TileMode.CLAMP);
                hVar2.put(jB2, radialGradient);
            }
        }
        radialGradient.setLocalMatrix(matrix);
        q3.a aVar4 = this.f18501g;
        aVar4.setShader(radialGradient);
        s3.p pVar = this.f18509o;
        if (pVar != null) {
            aVar4.setColorFilter((ColorFilter) pVar.getValue());
        }
        aVar4.setAlpha(a4.g.clamp((int) ((((i10 / 255.0f) * this.f18506l.getValue().intValue()) / 100.0f) * 255.0f), 0, 255));
        canvas.drawPath(path, aVar4);
        p3.c.endSection("GradientFillContent#draw");
    }

    @Override // r3.e
    public void getBounds(RectF rectF, Matrix matrix, boolean z10) {
        Path path = this.f18500f;
        path.reset();
        int i10 = 0;
        while (true) {
            ArrayList arrayList = this.f18503i;
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
        return this.f18495a;
    }

    @Override // s3.a.InterfaceC0246a
    public void onValueChanged() {
        this.f18511q.invalidateSelf();
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
                this.f18503i.add((m) cVar);
            }
        }
    }
}
