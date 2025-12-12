package r3;

import android.graphics.Path;
import android.graphics.PointF;
import com.airbnb.lottie.model.content.PolystarShape;
import com.airbnb.lottie.model.content.ShapeTrimPath;
import java.util.List;
import s3.a;

/* compiled from: PolystarContent.java */
/* loaded from: classes.dex */
public final class n implements m, a.InterfaceC0246a, k {

    /* renamed from: b, reason: collision with root package name */
    public final String f18530b;

    /* renamed from: c, reason: collision with root package name */
    public final p3.f f18531c;

    /* renamed from: d, reason: collision with root package name */
    public final PolystarShape.Type f18532d;

    /* renamed from: e, reason: collision with root package name */
    public final boolean f18533e;

    /* renamed from: f, reason: collision with root package name */
    public final s3.a<?, Float> f18534f;

    /* renamed from: g, reason: collision with root package name */
    public final s3.a<?, PointF> f18535g;

    /* renamed from: h, reason: collision with root package name */
    public final s3.a<?, Float> f18536h;

    /* renamed from: i, reason: collision with root package name */
    public final s3.a<?, Float> f18537i;

    /* renamed from: j, reason: collision with root package name */
    public final s3.a<?, Float> f18538j;

    /* renamed from: k, reason: collision with root package name */
    public final s3.a<?, Float> f18539k;

    /* renamed from: l, reason: collision with root package name */
    public final s3.a<?, Float> f18540l;

    /* renamed from: n, reason: collision with root package name */
    public boolean f18542n;

    /* renamed from: a, reason: collision with root package name */
    public final Path f18529a = new Path();

    /* renamed from: m, reason: collision with root package name */
    public final b f18541m = new b();

    public n(p3.f fVar, com.airbnb.lottie.model.layer.a aVar, PolystarShape polystarShape) {
        this.f18531c = fVar;
        this.f18530b = polystarShape.getName();
        PolystarShape.Type type = polystarShape.getType();
        this.f18532d = type;
        this.f18533e = polystarShape.isHidden();
        s3.a<Float, Float> aVarCreateAnimation = polystarShape.getPoints().createAnimation();
        this.f18534f = aVarCreateAnimation;
        s3.a<PointF, PointF> aVarCreateAnimation2 = polystarShape.getPosition().createAnimation();
        this.f18535g = aVarCreateAnimation2;
        s3.a<Float, Float> aVarCreateAnimation3 = polystarShape.getRotation().createAnimation();
        this.f18536h = aVarCreateAnimation3;
        s3.a<Float, Float> aVarCreateAnimation4 = polystarShape.getOuterRadius().createAnimation();
        this.f18538j = aVarCreateAnimation4;
        s3.a<Float, Float> aVarCreateAnimation5 = polystarShape.getOuterRoundedness().createAnimation();
        this.f18540l = aVarCreateAnimation5;
        PolystarShape.Type type2 = PolystarShape.Type.STAR;
        if (type == type2) {
            this.f18537i = polystarShape.getInnerRadius().createAnimation();
            this.f18539k = polystarShape.getInnerRoundedness().createAnimation();
        } else {
            this.f18537i = null;
            this.f18539k = null;
        }
        aVar.addAnimation(aVarCreateAnimation);
        aVar.addAnimation(aVarCreateAnimation2);
        aVar.addAnimation(aVarCreateAnimation3);
        aVar.addAnimation(aVarCreateAnimation4);
        aVar.addAnimation(aVarCreateAnimation5);
        if (type == type2) {
            aVar.addAnimation(this.f18537i);
            aVar.addAnimation(this.f18539k);
        }
        aVarCreateAnimation.addUpdateListener(this);
        aVarCreateAnimation2.addUpdateListener(this);
        aVarCreateAnimation3.addUpdateListener(this);
        aVarCreateAnimation4.addUpdateListener(this);
        aVarCreateAnimation5.addUpdateListener(this);
        if (type == type2) {
            this.f18537i.addUpdateListener(this);
            this.f18539k.addUpdateListener(this);
        }
    }

    @Override // u3.e
    public <T> void addValueCallback(T t10, b4.c<T> cVar) {
        s3.a<?, Float> aVar;
        s3.a<?, Float> aVar2;
        if (t10 == p3.k.f17524s) {
            this.f18534f.setValueCallback(cVar);
            return;
        }
        if (t10 == p3.k.f17525t) {
            this.f18536h.setValueCallback(cVar);
            return;
        }
        if (t10 == p3.k.f17515j) {
            this.f18535g.setValueCallback(cVar);
            return;
        }
        if (t10 == p3.k.f17526u && (aVar2 = this.f18537i) != null) {
            aVar2.setValueCallback(cVar);
            return;
        }
        if (t10 == p3.k.f17527v) {
            this.f18538j.setValueCallback(cVar);
            return;
        }
        if (t10 == p3.k.f17528w && (aVar = this.f18539k) != null) {
            aVar.setValueCallback(cVar);
        } else if (t10 == p3.k.f17529x) {
            this.f18540l.setValueCallback(cVar);
        }
    }

    @Override // r3.c
    public String getName() {
        return this.f18530b;
    }

    @Override // r3.m
    public Path getPath() {
        float fCos;
        double d10;
        float f10;
        float f11;
        Path path;
        float f12;
        float f13;
        float f14;
        Path path2;
        float f15;
        float f16;
        n nVar;
        float f17;
        s3.a<?, PointF> aVar;
        double d11;
        double d12;
        float f18;
        double d13;
        n nVar2 = this;
        boolean z10 = nVar2.f18542n;
        Path path3 = nVar2.f18529a;
        if (z10) {
            return path3;
        }
        path3.reset();
        if (nVar2.f18533e) {
            nVar2.f18542n = true;
            return path3;
        }
        int iOrdinal = nVar2.f18532d.ordinal();
        s3.a<?, PointF> aVar2 = nVar2.f18535g;
        s3.a<?, Float> aVar3 = nVar2.f18540l;
        s3.a<?, Float> aVar4 = nVar2.f18538j;
        s3.a<?, Float> aVar5 = nVar2.f18536h;
        s3.a<?, Float> aVar6 = nVar2.f18534f;
        if (iOrdinal != 0) {
            if (iOrdinal == 1) {
                int iFloor = (int) Math.floor(aVar6.getValue().floatValue());
                double radians = Math.toRadians((aVar5 == null ? 0.0d : aVar5.getValue().floatValue()) - 90.0d);
                double d14 = iFloor;
                float fFloatValue = aVar3.getValue().floatValue() / 100.0f;
                float fFloatValue2 = aVar4.getValue().floatValue();
                double d15 = fFloatValue2;
                float fCos2 = (float) (Math.cos(radians) * d15);
                float fSin = (float) (Math.sin(radians) * d15);
                path3.moveTo(fCos2, fSin);
                double d16 = (float) (6.283185307179586d / d14);
                double d17 = radians + d16;
                double dCeil = Math.ceil(d14);
                int i10 = 0;
                double d18 = d16;
                while (i10 < dCeil) {
                    float fCos3 = (float) (Math.cos(d17) * d15);
                    int i11 = i10;
                    float fSin2 = (float) (Math.sin(d17) * d15);
                    if (fFloatValue != 0.0f) {
                        double d19 = d15;
                        double dAtan2 = (float) (Math.atan2(fSin, fCos2) - 1.5707963267948966d);
                        float fCos4 = (float) Math.cos(dAtan2);
                        float fSin3 = (float) Math.sin(dAtan2);
                        aVar = aVar2;
                        d11 = d17;
                        double dAtan22 = (float) (Math.atan2(fSin2, fCos3) - 1.5707963267948966d);
                        float f19 = fFloatValue2 * fFloatValue * 0.25f;
                        d12 = d18;
                        f18 = fCos3;
                        d13 = d19;
                        path3.cubicTo(fCos2 - (fCos4 * f19), fSin - (fSin3 * f19), (((float) Math.cos(dAtan22)) * f19) + fCos3, (f19 * ((float) Math.sin(dAtan22))) + fSin2, f18, fSin2);
                    } else {
                        aVar = aVar2;
                        d11 = d17;
                        d12 = d18;
                        f18 = fCos3;
                        d13 = d15;
                        path3.lineTo(f18, fSin2);
                    }
                    double d20 = d11 + d12;
                    fSin = fSin2;
                    d15 = d13;
                    d18 = d12;
                    aVar2 = aVar;
                    i10 = i11 + 1;
                    fCos2 = f18;
                    d17 = d20;
                }
                PointF value = aVar2.getValue();
                path3.offset(value.x, value.y);
                path3.close();
                nVar2 = this;
            }
            path = path3;
        } else {
            float fFloatValue3 = aVar6.getValue().floatValue();
            double radians2 = Math.toRadians((aVar5 == null ? 0.0d : aVar5.getValue().floatValue()) - 90.0d);
            double d21 = fFloatValue3;
            float f20 = (float) (6.283185307179586d / d21);
            float f21 = f20 / 2.0f;
            float f22 = fFloatValue3 - ((int) fFloatValue3);
            if (f22 != 0.0f) {
                radians2 += (1.0f - f22) * f21;
            }
            float fFloatValue4 = aVar4.getValue().floatValue();
            n nVar3 = this;
            float fFloatValue5 = nVar3.f18537i.getValue().floatValue();
            s3.a<?, Float> aVar7 = nVar3.f18539k;
            float fFloatValue6 = aVar7 != null ? aVar7.getValue().floatValue() / 100.0f : 0.0f;
            float fFloatValue7 = aVar3 != null ? aVar3.getValue().floatValue() / 100.0f : 0.0f;
            if (f22 != 0.0f) {
                float fA = o1.a.a(fFloatValue4, fFloatValue5, f22, fFloatValue5);
                double d22 = fA;
                fCos = (float) (Math.cos(radians2) * d22);
                float fSin4 = (float) (d22 * Math.sin(radians2));
                path3.moveTo(fCos, fSin4);
                f11 = fA;
                d10 = radians2 + ((f20 * f22) / 2.0f);
                f10 = fSin4;
            } else {
                double d23 = fFloatValue4;
                fCos = (float) (Math.cos(radians2) * d23);
                float fSin5 = (float) (d23 * Math.sin(radians2));
                path3.moveTo(fCos, fSin5);
                d10 = radians2 + f21;
                f10 = fSin5;
                f11 = 0.0f;
            }
            double dCeil2 = Math.ceil(d21) * 2.0d;
            double d24 = d10;
            float f23 = fFloatValue5;
            float f24 = fCos;
            int i12 = 0;
            boolean z11 = false;
            while (true) {
                double d25 = i12;
                if (d25 >= dCeil2) {
                    break;
                }
                float f25 = z11 ? fFloatValue4 : f23;
                if (f11 == 0.0f || d25 != dCeil2 - 2.0d) {
                    f12 = f20;
                    f13 = f21;
                } else {
                    f12 = f20;
                    f13 = (f20 * f22) / 2.0f;
                }
                if (f11 == 0.0f || d25 != dCeil2 - 1.0d) {
                    f14 = fFloatValue4;
                } else {
                    f14 = fFloatValue4;
                    f25 = f11;
                }
                double d26 = f25;
                float f26 = f13;
                float f27 = f21;
                float fCos5 = (float) (Math.cos(d24) * d26);
                float fSin6 = (float) (d26 * Math.sin(d24));
                if (fFloatValue6 == 0.0f && fFloatValue7 == 0.0f) {
                    path3.lineTo(fCos5, fSin6);
                    path2 = path3;
                    f15 = f23;
                    f17 = f26;
                    f16 = f22;
                    nVar = this;
                } else {
                    float f28 = f10;
                    double dAtan23 = (float) (Math.atan2(f10, f24) - 1.5707963267948966d);
                    float fCos6 = (float) Math.cos(dAtan23);
                    float fSin7 = (float) Math.sin(dAtan23);
                    path2 = path3;
                    double dAtan24 = (float) (Math.atan2(fSin6, fCos5) - 1.5707963267948966d);
                    float fCos7 = (float) Math.cos(dAtan24);
                    float fSin8 = (float) Math.sin(dAtan24);
                    float f29 = z11 ? fFloatValue6 : fFloatValue7;
                    float f30 = z11 ? fFloatValue7 : fFloatValue6;
                    float f31 = (z11 ? f23 : f14) * f29 * 0.47829f;
                    float f32 = fCos6 * f31;
                    float f33 = f31 * fSin7;
                    float f34 = (z11 ? f14 : f23) * f30 * 0.47829f;
                    float f35 = fCos7 * f34;
                    float f36 = f34 * fSin8;
                    if (f22 != 0.0f) {
                        if (i12 == 0) {
                            f32 *= f22;
                            f33 *= f22;
                        } else if (d25 == dCeil2 - 1.0d) {
                            f35 *= f22;
                            f36 *= f22;
                        }
                    }
                    f15 = f23;
                    f16 = f22;
                    nVar = this;
                    path2.cubicTo(f24 - f32, f28 - f33, fCos5 + f35, fSin6 + f36, fCos5, fSin6);
                    f17 = f26;
                }
                d24 += f17;
                z11 = !z11;
                i12++;
                nVar3 = nVar;
                f24 = fCos5;
                f10 = fSin6;
                f22 = f16;
                fFloatValue4 = f14;
                f20 = f12;
                f21 = f27;
                f23 = f15;
                path3 = path2;
            }
            nVar2 = nVar3;
            PointF value2 = aVar2.getValue();
            path = path3;
            path.offset(value2.x, value2.y);
            path.close();
        }
        path.close();
        nVar2.f18541m.apply(path);
        nVar2.f18542n = true;
        return path;
    }

    @Override // s3.a.InterfaceC0246a
    public void onValueChanged() {
        this.f18542n = false;
        this.f18531c.invalidateSelf();
    }

    @Override // u3.e
    public void resolveKeyPath(u3.d dVar, int i10, List<u3.d> list, u3.d dVar2) {
        a4.g.resolveKeyPath(dVar, i10, list, dVar2, this);
    }

    @Override // r3.c
    public void setContents(List<c> list, List<c> list2) {
        for (int i10 = 0; i10 < list.size(); i10++) {
            c cVar = list.get(i10);
            if (cVar instanceof s) {
                s sVar = (s) cVar;
                if (sVar.f18576c == ShapeTrimPath.Type.SIMULTANEOUSLY) {
                    this.f18541m.f18465a.add(sVar);
                    sVar.a(this);
                }
            }
        }
    }
}
