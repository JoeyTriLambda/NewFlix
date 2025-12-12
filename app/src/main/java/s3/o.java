package s3;

import android.graphics.Matrix;
import android.graphics.PointF;
import java.util.Collections;
import s3.a;

/* compiled from: TransformKeyframeAnimation.java */
/* loaded from: classes.dex */
public final class o {

    /* renamed from: a, reason: collision with root package name */
    public final Matrix f19049a = new Matrix();

    /* renamed from: b, reason: collision with root package name */
    public final Matrix f19050b;

    /* renamed from: c, reason: collision with root package name */
    public final Matrix f19051c;

    /* renamed from: d, reason: collision with root package name */
    public final Matrix f19052d;

    /* renamed from: e, reason: collision with root package name */
    public final float[] f19053e;

    /* renamed from: f, reason: collision with root package name */
    public a<PointF, PointF> f19054f;

    /* renamed from: g, reason: collision with root package name */
    public a<?, PointF> f19055g;

    /* renamed from: h, reason: collision with root package name */
    public a<b4.d, b4.d> f19056h;

    /* renamed from: i, reason: collision with root package name */
    public a<Float, Float> f19057i;

    /* renamed from: j, reason: collision with root package name */
    public a<Integer, Integer> f19058j;

    /* renamed from: k, reason: collision with root package name */
    public c f19059k;

    /* renamed from: l, reason: collision with root package name */
    public c f19060l;

    /* renamed from: m, reason: collision with root package name */
    public a<?, Float> f19061m;

    /* renamed from: n, reason: collision with root package name */
    public a<?, Float> f19062n;

    public o(v3.l lVar) {
        this.f19054f = lVar.getAnchorPoint() == null ? null : lVar.getAnchorPoint().createAnimation();
        this.f19055g = lVar.getPosition() == null ? null : lVar.getPosition().createAnimation();
        this.f19056h = lVar.getScale() == null ? null : lVar.getScale().createAnimation();
        this.f19057i = lVar.getRotation() == null ? null : lVar.getRotation().createAnimation();
        c cVar = lVar.getSkew() == null ? null : (c) lVar.getSkew().createAnimation();
        this.f19059k = cVar;
        if (cVar != null) {
            this.f19050b = new Matrix();
            this.f19051c = new Matrix();
            this.f19052d = new Matrix();
            this.f19053e = new float[9];
        } else {
            this.f19050b = null;
            this.f19051c = null;
            this.f19052d = null;
            this.f19053e = null;
        }
        this.f19060l = lVar.getSkewAngle() == null ? null : (c) lVar.getSkewAngle().createAnimation();
        if (lVar.getOpacity() != null) {
            this.f19058j = lVar.getOpacity().createAnimation();
        }
        if (lVar.getStartOpacity() != null) {
            this.f19061m = lVar.getStartOpacity().createAnimation();
        } else {
            this.f19061m = null;
        }
        if (lVar.getEndOpacity() != null) {
            this.f19062n = lVar.getEndOpacity().createAnimation();
        } else {
            this.f19062n = null;
        }
    }

    public void addAnimationsToLayer(com.airbnb.lottie.model.layer.a aVar) {
        aVar.addAnimation(this.f19058j);
        aVar.addAnimation(this.f19061m);
        aVar.addAnimation(this.f19062n);
        aVar.addAnimation(this.f19054f);
        aVar.addAnimation(this.f19055g);
        aVar.addAnimation(this.f19056h);
        aVar.addAnimation(this.f19057i);
        aVar.addAnimation(this.f19059k);
        aVar.addAnimation(this.f19060l);
    }

    public void addListener(a.InterfaceC0246a interfaceC0246a) {
        a<Integer, Integer> aVar = this.f19058j;
        if (aVar != null) {
            aVar.addUpdateListener(interfaceC0246a);
        }
        a<?, Float> aVar2 = this.f19061m;
        if (aVar2 != null) {
            aVar2.addUpdateListener(interfaceC0246a);
        }
        a<?, Float> aVar3 = this.f19062n;
        if (aVar3 != null) {
            aVar3.addUpdateListener(interfaceC0246a);
        }
        a<PointF, PointF> aVar4 = this.f19054f;
        if (aVar4 != null) {
            aVar4.addUpdateListener(interfaceC0246a);
        }
        a<?, PointF> aVar5 = this.f19055g;
        if (aVar5 != null) {
            aVar5.addUpdateListener(interfaceC0246a);
        }
        a<b4.d, b4.d> aVar6 = this.f19056h;
        if (aVar6 != null) {
            aVar6.addUpdateListener(interfaceC0246a);
        }
        a<Float, Float> aVar7 = this.f19057i;
        if (aVar7 != null) {
            aVar7.addUpdateListener(interfaceC0246a);
        }
        c cVar = this.f19059k;
        if (cVar != null) {
            cVar.addUpdateListener(interfaceC0246a);
        }
        c cVar2 = this.f19060l;
        if (cVar2 != null) {
            cVar2.addUpdateListener(interfaceC0246a);
        }
    }

    public <T> boolean applyValueCallback(T t10, b4.c<T> cVar) {
        c cVar2;
        c cVar3;
        a<?, Float> aVar;
        a<?, Float> aVar2;
        if (t10 == p3.k.f17510e) {
            a<PointF, PointF> aVar3 = this.f19054f;
            if (aVar3 == null) {
                this.f19054f = new p(cVar, new PointF());
                return true;
            }
            aVar3.setValueCallback(cVar);
            return true;
        }
        if (t10 == p3.k.f17511f) {
            a<?, PointF> aVar4 = this.f19055g;
            if (aVar4 == null) {
                this.f19055g = new p(cVar, new PointF());
                return true;
            }
            aVar4.setValueCallback(cVar);
            return true;
        }
        if (t10 == p3.k.f17516k) {
            a<b4.d, b4.d> aVar5 = this.f19056h;
            if (aVar5 == null) {
                this.f19056h = new p(cVar, new b4.d());
                return true;
            }
            aVar5.setValueCallback(cVar);
            return true;
        }
        if (t10 == p3.k.f17517l) {
            a<Float, Float> aVar6 = this.f19057i;
            if (aVar6 == null) {
                this.f19057i = new p(cVar, Float.valueOf(0.0f));
                return true;
            }
            aVar6.setValueCallback(cVar);
            return true;
        }
        if (t10 == p3.k.f17508c) {
            a<Integer, Integer> aVar7 = this.f19058j;
            if (aVar7 == null) {
                this.f19058j = new p(cVar, 100);
                return true;
            }
            aVar7.setValueCallback(cVar);
            return true;
        }
        if (t10 == p3.k.f17530y && (aVar2 = this.f19061m) != null) {
            if (aVar2 == null) {
                this.f19061m = new p(cVar, 100);
                return true;
            }
            aVar2.setValueCallback(cVar);
            return true;
        }
        if (t10 == p3.k.f17531z && (aVar = this.f19062n) != null) {
            if (aVar == null) {
                this.f19062n = new p(cVar, 100);
                return true;
            }
            aVar.setValueCallback(cVar);
            return true;
        }
        if (t10 == p3.k.f17518m && (cVar3 = this.f19059k) != null) {
            if (cVar3 == null) {
                this.f19059k = new c(Collections.singletonList(new b4.a(Float.valueOf(0.0f))));
            }
            this.f19059k.setValueCallback(cVar);
            return true;
        }
        if (t10 != p3.k.f17519n || (cVar2 = this.f19060l) == null) {
            return false;
        }
        if (cVar2 == null) {
            this.f19060l = new c(Collections.singletonList(new b4.a(Float.valueOf(0.0f))));
        }
        this.f19060l.setValueCallback(cVar);
        return true;
    }

    public a<?, Float> getEndOpacity() {
        return this.f19062n;
    }

    public Matrix getMatrix() {
        float[] fArr;
        Matrix matrix = this.f19049a;
        matrix.reset();
        a<?, PointF> aVar = this.f19055g;
        if (aVar != null) {
            PointF value = aVar.getValue();
            float f10 = value.x;
            if (f10 != 0.0f || value.y != 0.0f) {
                matrix.preTranslate(f10, value.y);
            }
        }
        a<Float, Float> aVar2 = this.f19057i;
        if (aVar2 != null) {
            float fFloatValue = aVar2 instanceof p ? aVar2.getValue().floatValue() : ((c) aVar2).getFloatValue();
            if (fFloatValue != 0.0f) {
                matrix.preRotate(fFloatValue);
            }
        }
        if (this.f19059k != null) {
            float fCos = this.f19060l == null ? 0.0f : (float) Math.cos(Math.toRadians((-r2.getFloatValue()) + 90.0f));
            float fSin = this.f19060l == null ? 1.0f : (float) Math.sin(Math.toRadians((-r6.getFloatValue()) + 90.0f));
            float fTan = (float) Math.tan(Math.toRadians(this.f19059k.getFloatValue()));
            int i10 = 0;
            while (true) {
                fArr = this.f19053e;
                if (i10 >= 9) {
                    break;
                }
                fArr[i10] = 0.0f;
                i10++;
            }
            fArr[0] = fCos;
            fArr[1] = fSin;
            float f11 = -fSin;
            fArr[3] = f11;
            fArr[4] = fCos;
            fArr[8] = 1.0f;
            Matrix matrix2 = this.f19050b;
            matrix2.setValues(fArr);
            for (int i11 = 0; i11 < 9; i11++) {
                fArr[i11] = 0.0f;
            }
            fArr[0] = 1.0f;
            fArr[3] = fTan;
            fArr[4] = 1.0f;
            fArr[8] = 1.0f;
            Matrix matrix3 = this.f19051c;
            matrix3.setValues(fArr);
            for (int i12 = 0; i12 < 9; i12++) {
                fArr[i12] = 0.0f;
            }
            fArr[0] = fCos;
            fArr[1] = f11;
            fArr[3] = fSin;
            fArr[4] = fCos;
            fArr[8] = 1.0f;
            Matrix matrix4 = this.f19052d;
            matrix4.setValues(fArr);
            matrix3.preConcat(matrix2);
            matrix4.preConcat(matrix3);
            matrix.preConcat(matrix4);
        }
        a<b4.d, b4.d> aVar3 = this.f19056h;
        if (aVar3 != null) {
            b4.d value2 = aVar3.getValue();
            if (value2.getScaleX() != 1.0f || value2.getScaleY() != 1.0f) {
                matrix.preScale(value2.getScaleX(), value2.getScaleY());
            }
        }
        a<PointF, PointF> aVar4 = this.f19054f;
        if (aVar4 != null) {
            PointF value3 = aVar4.getValue();
            float f12 = value3.x;
            if (f12 != 0.0f || value3.y != 0.0f) {
                matrix.preTranslate(-f12, -value3.y);
            }
        }
        return matrix;
    }

    public Matrix getMatrixForRepeater(float f10) {
        a<?, PointF> aVar = this.f19055g;
        PointF value = aVar == null ? null : aVar.getValue();
        a<b4.d, b4.d> aVar2 = this.f19056h;
        b4.d value2 = aVar2 == null ? null : aVar2.getValue();
        Matrix matrix = this.f19049a;
        matrix.reset();
        if (value != null) {
            matrix.preTranslate(value.x * f10, value.y * f10);
        }
        if (value2 != null) {
            double d10 = f10;
            matrix.preScale((float) Math.pow(value2.getScaleX(), d10), (float) Math.pow(value2.getScaleY(), d10));
        }
        a<Float, Float> aVar3 = this.f19057i;
        if (aVar3 != null) {
            float fFloatValue = aVar3.getValue().floatValue();
            a<PointF, PointF> aVar4 = this.f19054f;
            PointF value3 = aVar4 != null ? aVar4.getValue() : null;
            matrix.preRotate(fFloatValue * f10, value3 == null ? 0.0f : value3.x, value3 != null ? value3.y : 0.0f);
        }
        return matrix;
    }

    public a<?, Integer> getOpacity() {
        return this.f19058j;
    }

    public a<?, Float> getStartOpacity() {
        return this.f19061m;
    }

    public void setProgress(float f10) {
        a<Integer, Integer> aVar = this.f19058j;
        if (aVar != null) {
            aVar.setProgress(f10);
        }
        a<?, Float> aVar2 = this.f19061m;
        if (aVar2 != null) {
            aVar2.setProgress(f10);
        }
        a<?, Float> aVar3 = this.f19062n;
        if (aVar3 != null) {
            aVar3.setProgress(f10);
        }
        a<PointF, PointF> aVar4 = this.f19054f;
        if (aVar4 != null) {
            aVar4.setProgress(f10);
        }
        a<?, PointF> aVar5 = this.f19055g;
        if (aVar5 != null) {
            aVar5.setProgress(f10);
        }
        a<b4.d, b4.d> aVar6 = this.f19056h;
        if (aVar6 != null) {
            aVar6.setProgress(f10);
        }
        a<Float, Float> aVar7 = this.f19057i;
        if (aVar7 != null) {
            aVar7.setProgress(f10);
        }
        c cVar = this.f19059k;
        if (cVar != null) {
            cVar.setProgress(f10);
        }
        c cVar2 = this.f19060l;
        if (cVar2 != null) {
            cVar2.setProgress(f10);
        }
    }
}
