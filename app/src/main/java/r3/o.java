package r3;

import android.graphics.Path;
import android.graphics.PointF;
import android.graphics.RectF;
import com.airbnb.lottie.model.content.ShapeTrimPath;
import java.util.List;
import s3.a;

/* compiled from: RectangleContent.java */
/* loaded from: classes.dex */
public final class o implements a.InterfaceC0246a, k, m {

    /* renamed from: c, reason: collision with root package name */
    public final String f18545c;

    /* renamed from: d, reason: collision with root package name */
    public final boolean f18546d;

    /* renamed from: e, reason: collision with root package name */
    public final p3.f f18547e;

    /* renamed from: f, reason: collision with root package name */
    public final s3.a<?, PointF> f18548f;

    /* renamed from: g, reason: collision with root package name */
    public final s3.a<?, PointF> f18549g;

    /* renamed from: h, reason: collision with root package name */
    public final s3.a<?, Float> f18550h;

    /* renamed from: j, reason: collision with root package name */
    public boolean f18552j;

    /* renamed from: a, reason: collision with root package name */
    public final Path f18543a = new Path();

    /* renamed from: b, reason: collision with root package name */
    public final RectF f18544b = new RectF();

    /* renamed from: i, reason: collision with root package name */
    public final b f18551i = new b();

    public o(p3.f fVar, com.airbnb.lottie.model.layer.a aVar, w3.e eVar) {
        this.f18545c = eVar.getName();
        this.f18546d = eVar.isHidden();
        this.f18547e = fVar;
        s3.a<PointF, PointF> aVarCreateAnimation = eVar.getPosition().createAnimation();
        this.f18548f = aVarCreateAnimation;
        s3.a<PointF, PointF> aVarCreateAnimation2 = eVar.getSize().createAnimation();
        this.f18549g = aVarCreateAnimation2;
        s3.a<Float, Float> aVarCreateAnimation3 = eVar.getCornerRadius().createAnimation();
        this.f18550h = aVarCreateAnimation3;
        aVar.addAnimation(aVarCreateAnimation);
        aVar.addAnimation(aVarCreateAnimation2);
        aVar.addAnimation(aVarCreateAnimation3);
        aVarCreateAnimation.addUpdateListener(this);
        aVarCreateAnimation2.addUpdateListener(this);
        aVarCreateAnimation3.addUpdateListener(this);
    }

    @Override // u3.e
    public <T> void addValueCallback(T t10, b4.c<T> cVar) {
        if (t10 == p3.k.f17513h) {
            this.f18549g.setValueCallback(cVar);
        } else if (t10 == p3.k.f17515j) {
            this.f18548f.setValueCallback(cVar);
        } else if (t10 == p3.k.f17514i) {
            this.f18550h.setValueCallback(cVar);
        }
    }

    @Override // r3.c
    public String getName() {
        return this.f18545c;
    }

    @Override // r3.m
    public Path getPath() {
        boolean z10 = this.f18552j;
        Path path = this.f18543a;
        if (z10) {
            return path;
        }
        path.reset();
        if (this.f18546d) {
            this.f18552j = true;
            return path;
        }
        PointF value = this.f18549g.getValue();
        float f10 = value.x / 2.0f;
        float f11 = value.y / 2.0f;
        s3.a<?, Float> aVar = this.f18550h;
        float floatValue = aVar == null ? 0.0f : ((s3.c) aVar).getFloatValue();
        float fMin = Math.min(f10, f11);
        if (floatValue > fMin) {
            floatValue = fMin;
        }
        PointF value2 = this.f18548f.getValue();
        path.moveTo(value2.x + f10, (value2.y - f11) + floatValue);
        path.lineTo(value2.x + f10, (value2.y + f11) - floatValue);
        RectF rectF = this.f18544b;
        if (floatValue > 0.0f) {
            float f12 = value2.x;
            float f13 = floatValue * 2.0f;
            float f14 = value2.y;
            rectF.set((f12 + f10) - f13, (f14 + f11) - f13, f12 + f10, f14 + f11);
            path.arcTo(rectF, 0.0f, 90.0f, false);
        }
        path.lineTo((value2.x - f10) + floatValue, value2.y + f11);
        if (floatValue > 0.0f) {
            float f15 = value2.x;
            float f16 = value2.y;
            float f17 = floatValue * 2.0f;
            rectF.set(f15 - f10, (f16 + f11) - f17, (f15 - f10) + f17, f16 + f11);
            path.arcTo(rectF, 90.0f, 90.0f, false);
        }
        path.lineTo(value2.x - f10, (value2.y - f11) + floatValue);
        if (floatValue > 0.0f) {
            float f18 = value2.x;
            float f19 = value2.y;
            float f20 = floatValue * 2.0f;
            rectF.set(f18 - f10, f19 - f11, (f18 - f10) + f20, (f19 - f11) + f20);
            path.arcTo(rectF, 180.0f, 90.0f, false);
        }
        path.lineTo((value2.x + f10) - floatValue, value2.y - f11);
        if (floatValue > 0.0f) {
            float f21 = value2.x;
            float f22 = floatValue * 2.0f;
            float f23 = value2.y;
            rectF.set((f21 + f10) - f22, f23 - f11, f21 + f10, (f23 - f11) + f22);
            path.arcTo(rectF, 270.0f, 90.0f, false);
        }
        path.close();
        this.f18551i.apply(path);
        this.f18552j = true;
        return path;
    }

    @Override // s3.a.InterfaceC0246a
    public void onValueChanged() {
        this.f18552j = false;
        this.f18547e.invalidateSelf();
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
                    this.f18551i.f18465a.add(sVar);
                    sVar.a(this);
                }
            }
        }
    }
}
