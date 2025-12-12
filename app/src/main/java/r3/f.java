package r3;

import android.graphics.Path;
import android.graphics.PointF;
import com.airbnb.lottie.model.content.ShapeTrimPath;
import java.util.List;
import s3.a;

/* compiled from: EllipseContent.java */
/* loaded from: classes.dex */
public final class f implements m, a.InterfaceC0246a, k {

    /* renamed from: b, reason: collision with root package name */
    public final String f18478b;

    /* renamed from: c, reason: collision with root package name */
    public final p3.f f18479c;

    /* renamed from: d, reason: collision with root package name */
    public final s3.a<?, PointF> f18480d;

    /* renamed from: e, reason: collision with root package name */
    public final s3.a<?, PointF> f18481e;

    /* renamed from: f, reason: collision with root package name */
    public final w3.a f18482f;

    /* renamed from: h, reason: collision with root package name */
    public boolean f18484h;

    /* renamed from: a, reason: collision with root package name */
    public final Path f18477a = new Path();

    /* renamed from: g, reason: collision with root package name */
    public final b f18483g = new b();

    public f(p3.f fVar, com.airbnb.lottie.model.layer.a aVar, w3.a aVar2) {
        this.f18478b = aVar2.getName();
        this.f18479c = fVar;
        s3.a<PointF, PointF> aVarCreateAnimation = aVar2.getSize().createAnimation();
        this.f18480d = aVarCreateAnimation;
        s3.a<PointF, PointF> aVarCreateAnimation2 = aVar2.getPosition().createAnimation();
        this.f18481e = aVarCreateAnimation2;
        this.f18482f = aVar2;
        aVar.addAnimation(aVarCreateAnimation);
        aVar.addAnimation(aVarCreateAnimation2);
        aVarCreateAnimation.addUpdateListener(this);
        aVarCreateAnimation2.addUpdateListener(this);
    }

    @Override // u3.e
    public <T> void addValueCallback(T t10, b4.c<T> cVar) {
        if (t10 == p3.k.f17512g) {
            this.f18480d.setValueCallback(cVar);
        } else if (t10 == p3.k.f17515j) {
            this.f18481e.setValueCallback(cVar);
        }
    }

    @Override // r3.c
    public String getName() {
        return this.f18478b;
    }

    @Override // r3.m
    public Path getPath() {
        boolean z10 = this.f18484h;
        Path path = this.f18477a;
        if (z10) {
            return path;
        }
        path.reset();
        w3.a aVar = this.f18482f;
        if (aVar.isHidden()) {
            this.f18484h = true;
            return path;
        }
        PointF value = this.f18480d.getValue();
        float f10 = value.x / 2.0f;
        float f11 = value.y / 2.0f;
        float f12 = f10 * 0.55228f;
        float f13 = f11 * 0.55228f;
        path.reset();
        if (aVar.isReversed()) {
            float f14 = -f11;
            path.moveTo(0.0f, f14);
            float f15 = 0.0f - f12;
            float f16 = -f10;
            float f17 = 0.0f - f13;
            path.cubicTo(f15, f14, f16, f17, f16, 0.0f);
            float f18 = f13 + 0.0f;
            path.cubicTo(f16, f18, f15, f11, 0.0f, f11);
            float f19 = f12 + 0.0f;
            path.cubicTo(f19, f11, f10, f18, f10, 0.0f);
            path.cubicTo(f10, f17, f19, f14, 0.0f, f14);
        } else {
            float f20 = -f11;
            path.moveTo(0.0f, f20);
            float f21 = f12 + 0.0f;
            float f22 = 0.0f - f13;
            path.cubicTo(f21, f20, f10, f22, f10, 0.0f);
            float f23 = f13 + 0.0f;
            path.cubicTo(f10, f23, f21, f11, 0.0f, f11);
            float f24 = 0.0f - f12;
            float f25 = -f10;
            path.cubicTo(f24, f11, f25, f23, f25, 0.0f);
            path.cubicTo(f25, f22, f24, f20, 0.0f, f20);
        }
        PointF value2 = this.f18481e.getValue();
        path.offset(value2.x, value2.y);
        path.close();
        this.f18483g.apply(path);
        this.f18484h = true;
        return path;
    }

    @Override // s3.a.InterfaceC0246a
    public void onValueChanged() {
        this.f18484h = false;
        this.f18479c.invalidateSelf();
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
                    this.f18483g.f18465a.add(sVar);
                    sVar.a(this);
                }
            }
        }
    }
}
