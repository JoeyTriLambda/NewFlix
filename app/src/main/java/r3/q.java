package r3;

import android.graphics.Path;
import com.airbnb.lottie.model.content.ShapeTrimPath;
import java.util.List;
import s3.a;

/* compiled from: ShapeContent.java */
/* loaded from: classes.dex */
public final class q implements m, a.InterfaceC0246a {

    /* renamed from: b, reason: collision with root package name */
    public final boolean f18564b;

    /* renamed from: c, reason: collision with root package name */
    public final p3.f f18565c;

    /* renamed from: d, reason: collision with root package name */
    public final s3.a<?, Path> f18566d;

    /* renamed from: e, reason: collision with root package name */
    public boolean f18567e;

    /* renamed from: a, reason: collision with root package name */
    public final Path f18563a = new Path();

    /* renamed from: f, reason: collision with root package name */
    public final b f18568f = new b();

    public q(p3.f fVar, com.airbnb.lottie.model.layer.a aVar, w3.j jVar) {
        jVar.getName();
        this.f18564b = jVar.isHidden();
        this.f18565c = fVar;
        s3.a<w3.g, Path> aVarCreateAnimation = jVar.getShapePath().createAnimation();
        this.f18566d = aVarCreateAnimation;
        aVar.addAnimation(aVarCreateAnimation);
        aVarCreateAnimation.addUpdateListener(this);
    }

    @Override // r3.m
    public Path getPath() {
        boolean z10 = this.f18567e;
        Path path = this.f18563a;
        if (z10) {
            return path;
        }
        path.reset();
        if (this.f18564b) {
            this.f18567e = true;
            return path;
        }
        path.set(this.f18566d.getValue());
        path.setFillType(Path.FillType.EVEN_ODD);
        this.f18568f.apply(path);
        this.f18567e = true;
        return path;
    }

    @Override // s3.a.InterfaceC0246a
    public void onValueChanged() {
        this.f18567e = false;
        this.f18565c.invalidateSelf();
    }

    @Override // r3.c
    public void setContents(List<c> list, List<c> list2) {
        for (int i10 = 0; i10 < list.size(); i10++) {
            c cVar = list.get(i10);
            if (cVar instanceof s) {
                s sVar = (s) cVar;
                if (sVar.f18576c == ShapeTrimPath.Type.SIMULTANEOUSLY) {
                    this.f18568f.f18465a.add(sVar);
                    sVar.a(this);
                }
            }
        }
    }
}
