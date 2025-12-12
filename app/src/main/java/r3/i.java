package r3;

import android.graphics.Canvas;
import android.graphics.LinearGradient;
import android.graphics.Matrix;
import android.graphics.PointF;
import android.graphics.RadialGradient;
import android.graphics.RectF;
import android.graphics.Shader;
import com.airbnb.lottie.model.content.GradientType;

/* compiled from: GradientStrokeContent.java */
/* loaded from: classes.dex */
public final class i extends a {

    /* renamed from: o, reason: collision with root package name */
    public final String f18513o;

    /* renamed from: p, reason: collision with root package name */
    public final boolean f18514p;

    /* renamed from: q, reason: collision with root package name */
    public final b0.h<LinearGradient> f18515q;

    /* renamed from: r, reason: collision with root package name */
    public final b0.h<RadialGradient> f18516r;

    /* renamed from: s, reason: collision with root package name */
    public final RectF f18517s;

    /* renamed from: t, reason: collision with root package name */
    public final GradientType f18518t;

    /* renamed from: u, reason: collision with root package name */
    public final int f18519u;

    /* renamed from: v, reason: collision with root package name */
    public final s3.a<w3.c, w3.c> f18520v;

    /* renamed from: w, reason: collision with root package name */
    public final s3.a<PointF, PointF> f18521w;

    /* renamed from: x, reason: collision with root package name */
    public final s3.a<PointF, PointF> f18522x;

    /* renamed from: y, reason: collision with root package name */
    public s3.p f18523y;

    public i(p3.f fVar, com.airbnb.lottie.model.layer.a aVar, com.airbnb.lottie.model.content.a aVar2) {
        super(fVar, aVar, aVar2.getCapType().toPaintCap(), aVar2.getJoinType().toPaintJoin(), aVar2.getMiterLimit(), aVar2.getOpacity(), aVar2.getWidth(), aVar2.getLineDashPattern(), aVar2.getDashOffset());
        this.f18515q = new b0.h<>();
        this.f18516r = new b0.h<>();
        this.f18517s = new RectF();
        this.f18513o = aVar2.getName();
        this.f18518t = aVar2.getGradientType();
        this.f18514p = aVar2.isHidden();
        this.f18519u = (int) (fVar.getComposition().getDuration() / 32.0f);
        s3.a<w3.c, w3.c> aVarCreateAnimation = aVar2.getGradientColor().createAnimation();
        this.f18520v = aVarCreateAnimation;
        aVarCreateAnimation.addUpdateListener(this);
        aVar.addAnimation(aVarCreateAnimation);
        s3.a<PointF, PointF> aVarCreateAnimation2 = aVar2.getStartPoint().createAnimation();
        this.f18521w = aVarCreateAnimation2;
        aVarCreateAnimation2.addUpdateListener(this);
        aVar.addAnimation(aVarCreateAnimation2);
        s3.a<PointF, PointF> aVarCreateAnimation3 = aVar2.getEndPoint().createAnimation();
        this.f18522x = aVarCreateAnimation3;
        aVarCreateAnimation3.addUpdateListener(this);
        aVar.addAnimation(aVarCreateAnimation3);
    }

    public final int[] a(int[] iArr) {
        s3.p pVar = this.f18523y;
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
    @Override // r3.a, u3.e
    public <T> void addValueCallback(T t10, b4.c<T> cVar) {
        super.addValueCallback(t10, cVar);
        if (t10 == p3.k.D) {
            s3.p pVar = this.f18523y;
            com.airbnb.lottie.model.layer.a aVar = this.f18454f;
            if (pVar != null) {
                aVar.removeAnimation(pVar);
            }
            if (cVar == null) {
                this.f18523y = null;
                return;
            }
            s3.p pVar2 = new s3.p(cVar);
            this.f18523y = pVar2;
            pVar2.addUpdateListener(this);
            aVar.addAnimation(this.f18523y);
        }
    }

    public final int b() {
        float progress = this.f18521w.getProgress();
        int i10 = this.f18519u;
        int iRound = Math.round(progress * i10);
        int iRound2 = Math.round(this.f18522x.getProgress() * i10);
        int iRound3 = Math.round(this.f18520v.getProgress() * i10);
        int i11 = iRound != 0 ? 527 * iRound : 17;
        if (iRound2 != 0) {
            i11 = i11 * 31 * iRound2;
        }
        return iRound3 != 0 ? i11 * 31 * iRound3 : i11;
    }

    /* JADX WARN: Multi-variable type inference failed */
    @Override // r3.a, r3.e
    public void draw(Canvas canvas, Matrix matrix, int i10) {
        Shader radialGradient;
        if (this.f18514p) {
            return;
        }
        getBounds(this.f18517s, matrix, false);
        GradientType gradientType = GradientType.LINEAR;
        GradientType gradientType2 = this.f18518t;
        s3.a<w3.c, w3.c> aVar = this.f18520v;
        s3.a<PointF, PointF> aVar2 = this.f18522x;
        s3.a<PointF, PointF> aVar3 = this.f18521w;
        if (gradientType2 == gradientType) {
            long jB = b();
            b0.h<LinearGradient> hVar = this.f18515q;
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
            b0.h<RadialGradient> hVar2 = this.f18516r;
            radialGradient = (RadialGradient) hVar2.get(jB2);
            if (radialGradient == null) {
                PointF value4 = aVar3.getValue();
                PointF value5 = aVar2.getValue();
                w3.c value6 = aVar.getValue();
                int[] iArrA = a(value6.getColors());
                float[] positions = value6.getPositions();
                radialGradient = new RadialGradient(value4.x, value4.y, (float) Math.hypot(value5.x - r10, value5.y - r11), iArrA, positions, Shader.TileMode.CLAMP);
                hVar2.put(jB2, radialGradient);
            }
        }
        radialGradient.setLocalMatrix(matrix);
        this.f18457i.setShader(radialGradient);
        super.draw(canvas, matrix, i10);
    }

    @Override // r3.c
    public String getName() {
        return this.f18513o;
    }
}
