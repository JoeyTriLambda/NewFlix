package w3;

import android.graphics.Path;
import com.airbnb.lottie.model.content.GradientType;

/* compiled from: GradientFill.java */
/* loaded from: classes.dex */
public final class d implements b {

    /* renamed from: a, reason: collision with root package name */
    public final GradientType f20899a;

    /* renamed from: b, reason: collision with root package name */
    public final Path.FillType f20900b;

    /* renamed from: c, reason: collision with root package name */
    public final v3.c f20901c;

    /* renamed from: d, reason: collision with root package name */
    public final v3.d f20902d;

    /* renamed from: e, reason: collision with root package name */
    public final v3.f f20903e;

    /* renamed from: f, reason: collision with root package name */
    public final v3.f f20904f;

    /* renamed from: g, reason: collision with root package name */
    public final String f20905g;

    /* renamed from: h, reason: collision with root package name */
    public final boolean f20906h;

    public d(String str, GradientType gradientType, Path.FillType fillType, v3.c cVar, v3.d dVar, v3.f fVar, v3.f fVar2, v3.b bVar, v3.b bVar2, boolean z10) {
        this.f20899a = gradientType;
        this.f20900b = fillType;
        this.f20901c = cVar;
        this.f20902d = dVar;
        this.f20903e = fVar;
        this.f20904f = fVar2;
        this.f20905g = str;
        this.f20906h = z10;
    }

    public v3.f getEndPoint() {
        return this.f20904f;
    }

    public Path.FillType getFillType() {
        return this.f20900b;
    }

    public v3.c getGradientColor() {
        return this.f20901c;
    }

    public GradientType getGradientType() {
        return this.f20899a;
    }

    public String getName() {
        return this.f20905g;
    }

    public v3.d getOpacity() {
        return this.f20902d;
    }

    public v3.f getStartPoint() {
        return this.f20903e;
    }

    public boolean isHidden() {
        return this.f20906h;
    }

    @Override // w3.b
    public r3.c toContent(p3.f fVar, com.airbnb.lottie.model.layer.a aVar) {
        return new r3.h(fVar, aVar, this);
    }
}
