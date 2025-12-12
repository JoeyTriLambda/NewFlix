package w3;

import r3.q;

/* compiled from: ShapePath.java */
/* loaded from: classes.dex */
public final class j implements b {

    /* renamed from: a, reason: collision with root package name */
    public final String f20929a;

    /* renamed from: b, reason: collision with root package name */
    public final int f20930b;

    /* renamed from: c, reason: collision with root package name */
    public final v3.h f20931c;

    /* renamed from: d, reason: collision with root package name */
    public final boolean f20932d;

    public j(String str, int i10, v3.h hVar, boolean z10) {
        this.f20929a = str;
        this.f20930b = i10;
        this.f20931c = hVar;
        this.f20932d = z10;
    }

    public String getName() {
        return this.f20929a;
    }

    public v3.h getShapePath() {
        return this.f20931c;
    }

    public boolean isHidden() {
        return this.f20932d;
    }

    @Override // w3.b
    public r3.c toContent(p3.f fVar, com.airbnb.lottie.model.layer.a aVar) {
        return new q(fVar, aVar, this);
    }

    public String toString() {
        StringBuilder sb2 = new StringBuilder("ShapePath{name=");
        sb2.append(this.f20929a);
        sb2.append(", index=");
        return ac.c.l(sb2, this.f20930b, '}');
    }
}
