package w3;

import android.graphics.PointF;
import r3.o;
import v3.m;

/* compiled from: RectangleShape.java */
/* loaded from: classes.dex */
public final class e implements b {

    /* renamed from: a, reason: collision with root package name */
    public final String f20907a;

    /* renamed from: b, reason: collision with root package name */
    public final m<PointF, PointF> f20908b;

    /* renamed from: c, reason: collision with root package name */
    public final v3.f f20909c;

    /* renamed from: d, reason: collision with root package name */
    public final v3.b f20910d;

    /* renamed from: e, reason: collision with root package name */
    public final boolean f20911e;

    public e(String str, m<PointF, PointF> mVar, v3.f fVar, v3.b bVar, boolean z10) {
        this.f20907a = str;
        this.f20908b = mVar;
        this.f20909c = fVar;
        this.f20910d = bVar;
        this.f20911e = z10;
    }

    public v3.b getCornerRadius() {
        return this.f20910d;
    }

    public String getName() {
        return this.f20907a;
    }

    public m<PointF, PointF> getPosition() {
        return this.f20908b;
    }

    public v3.f getSize() {
        return this.f20909c;
    }

    public boolean isHidden() {
        return this.f20911e;
    }

    @Override // w3.b
    public r3.c toContent(p3.f fVar, com.airbnb.lottie.model.layer.a aVar) {
        return new o(fVar, aVar, this);
    }

    public String toString() {
        return "RectangleShape{position=" + this.f20908b + ", size=" + this.f20909c + '}';
    }
}
