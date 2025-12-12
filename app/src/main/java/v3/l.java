package v3;

import android.graphics.PointF;
import s3.o;

/* compiled from: AnimatableTransform.java */
/* loaded from: classes.dex */
public final class l implements w3.b {

    /* renamed from: a, reason: collision with root package name */
    public final e f20452a;

    /* renamed from: b, reason: collision with root package name */
    public final m<PointF, PointF> f20453b;

    /* renamed from: c, reason: collision with root package name */
    public final g f20454c;

    /* renamed from: d, reason: collision with root package name */
    public final b f20455d;

    /* renamed from: e, reason: collision with root package name */
    public final d f20456e;

    /* renamed from: f, reason: collision with root package name */
    public final b f20457f;

    /* renamed from: g, reason: collision with root package name */
    public final b f20458g;

    /* renamed from: h, reason: collision with root package name */
    public final b f20459h;

    /* renamed from: i, reason: collision with root package name */
    public final b f20460i;

    public l() {
        this(null, null, null, null, null, null, null, null, null);
    }

    public o createAnimation() {
        return new o(this);
    }

    public e getAnchorPoint() {
        return this.f20452a;
    }

    public b getEndOpacity() {
        return this.f20460i;
    }

    public d getOpacity() {
        return this.f20456e;
    }

    public m<PointF, PointF> getPosition() {
        return this.f20453b;
    }

    public b getRotation() {
        return this.f20455d;
    }

    public g getScale() {
        return this.f20454c;
    }

    public b getSkew() {
        return this.f20457f;
    }

    public b getSkewAngle() {
        return this.f20458g;
    }

    public b getStartOpacity() {
        return this.f20459h;
    }

    @Override // w3.b
    public r3.c toContent(p3.f fVar, com.airbnb.lottie.model.layer.a aVar) {
        return null;
    }

    public l(e eVar, m<PointF, PointF> mVar, g gVar, b bVar, d dVar, b bVar2, b bVar3, b bVar4, b bVar5) {
        this.f20452a = eVar;
        this.f20453b = mVar;
        this.f20454c = gVar;
        this.f20455d = bVar;
        this.f20456e = dVar;
        this.f20459h = bVar2;
        this.f20460i = bVar3;
        this.f20457f = bVar4;
        this.f20458g = bVar5;
    }
}
