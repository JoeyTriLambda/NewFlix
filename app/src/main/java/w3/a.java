package w3;

import android.graphics.PointF;
import v3.m;

/* compiled from: CircleShape.java */
/* loaded from: classes.dex */
public final class a implements b {

    /* renamed from: a, reason: collision with root package name */
    public final String f20892a;

    /* renamed from: b, reason: collision with root package name */
    public final m<PointF, PointF> f20893b;

    /* renamed from: c, reason: collision with root package name */
    public final v3.f f20894c;

    /* renamed from: d, reason: collision with root package name */
    public final boolean f20895d;

    /* renamed from: e, reason: collision with root package name */
    public final boolean f20896e;

    public a(String str, m<PointF, PointF> mVar, v3.f fVar, boolean z10, boolean z11) {
        this.f20892a = str;
        this.f20893b = mVar;
        this.f20894c = fVar;
        this.f20895d = z10;
        this.f20896e = z11;
    }

    public String getName() {
        return this.f20892a;
    }

    public m<PointF, PointF> getPosition() {
        return this.f20893b;
    }

    public v3.f getSize() {
        return this.f20894c;
    }

    public boolean isHidden() {
        return this.f20896e;
    }

    public boolean isReversed() {
        return this.f20895d;
    }

    @Override // w3.b
    public r3.c toContent(p3.f fVar, com.airbnb.lottie.model.layer.a aVar) {
        return new r3.f(fVar, aVar, this);
    }
}
