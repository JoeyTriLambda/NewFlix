package w3;

import r3.p;
import v3.l;

/* compiled from: Repeater.java */
/* loaded from: classes.dex */
public final class f implements b {

    /* renamed from: a, reason: collision with root package name */
    public final String f20912a;

    /* renamed from: b, reason: collision with root package name */
    public final v3.b f20913b;

    /* renamed from: c, reason: collision with root package name */
    public final v3.b f20914c;

    /* renamed from: d, reason: collision with root package name */
    public final l f20915d;

    /* renamed from: e, reason: collision with root package name */
    public final boolean f20916e;

    public f(String str, v3.b bVar, v3.b bVar2, l lVar, boolean z10) {
        this.f20912a = str;
        this.f20913b = bVar;
        this.f20914c = bVar2;
        this.f20915d = lVar;
        this.f20916e = z10;
    }

    public v3.b getCopies() {
        return this.f20913b;
    }

    public String getName() {
        return this.f20912a;
    }

    public v3.b getOffset() {
        return this.f20914c;
    }

    public l getTransform() {
        return this.f20915d;
    }

    public boolean isHidden() {
        return this.f20916e;
    }

    @Override // w3.b
    public r3.c toContent(p3.f fVar, com.airbnb.lottie.model.layer.a aVar) {
        return new p(fVar, aVar, this);
    }
}
