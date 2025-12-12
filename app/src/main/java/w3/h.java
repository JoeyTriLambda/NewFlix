package w3;

import android.graphics.Path;

/* compiled from: ShapeFill.java */
/* loaded from: classes.dex */
public final class h implements b {

    /* renamed from: a, reason: collision with root package name */
    public final boolean f20920a;

    /* renamed from: b, reason: collision with root package name */
    public final Path.FillType f20921b;

    /* renamed from: c, reason: collision with root package name */
    public final String f20922c;

    /* renamed from: d, reason: collision with root package name */
    public final v3.a f20923d;

    /* renamed from: e, reason: collision with root package name */
    public final v3.d f20924e;

    /* renamed from: f, reason: collision with root package name */
    public final boolean f20925f;

    public h(String str, boolean z10, Path.FillType fillType, v3.a aVar, v3.d dVar, boolean z11) {
        this.f20922c = str;
        this.f20920a = z10;
        this.f20921b = fillType;
        this.f20923d = aVar;
        this.f20924e = dVar;
        this.f20925f = z11;
    }

    public v3.a getColor() {
        return this.f20923d;
    }

    public Path.FillType getFillType() {
        return this.f20921b;
    }

    public String getName() {
        return this.f20922c;
    }

    public v3.d getOpacity() {
        return this.f20924e;
    }

    public boolean isHidden() {
        return this.f20925f;
    }

    @Override // w3.b
    public r3.c toContent(p3.f fVar, com.airbnb.lottie.model.layer.a aVar) {
        return new r3.g(fVar, aVar, this);
    }

    public String toString() {
        return "ShapeFill{color=, fillEnabled=" + this.f20920a + '}';
    }
}
