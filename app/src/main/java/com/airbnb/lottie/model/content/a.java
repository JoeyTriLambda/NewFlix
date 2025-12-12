package com.airbnb.lottie.model.content;

import com.airbnb.lottie.model.content.ShapeStroke;
import java.util.List;
import r3.i;
import v3.c;
import v3.d;
import v3.f;
import w3.b;

/* compiled from: GradientStroke.java */
/* loaded from: classes.dex */
public final class a implements b {

    /* renamed from: a, reason: collision with root package name */
    public final String f5457a;

    /* renamed from: b, reason: collision with root package name */
    public final GradientType f5458b;

    /* renamed from: c, reason: collision with root package name */
    public final c f5459c;

    /* renamed from: d, reason: collision with root package name */
    public final d f5460d;

    /* renamed from: e, reason: collision with root package name */
    public final f f5461e;

    /* renamed from: f, reason: collision with root package name */
    public final f f5462f;

    /* renamed from: g, reason: collision with root package name */
    public final v3.b f5463g;

    /* renamed from: h, reason: collision with root package name */
    public final ShapeStroke.LineCapType f5464h;

    /* renamed from: i, reason: collision with root package name */
    public final ShapeStroke.LineJoinType f5465i;

    /* renamed from: j, reason: collision with root package name */
    public final float f5466j;

    /* renamed from: k, reason: collision with root package name */
    public final List<v3.b> f5467k;

    /* renamed from: l, reason: collision with root package name */
    public final v3.b f5468l;

    /* renamed from: m, reason: collision with root package name */
    public final boolean f5469m;

    public a(String str, GradientType gradientType, c cVar, d dVar, f fVar, f fVar2, v3.b bVar, ShapeStroke.LineCapType lineCapType, ShapeStroke.LineJoinType lineJoinType, float f10, List<v3.b> list, v3.b bVar2, boolean z10) {
        this.f5457a = str;
        this.f5458b = gradientType;
        this.f5459c = cVar;
        this.f5460d = dVar;
        this.f5461e = fVar;
        this.f5462f = fVar2;
        this.f5463g = bVar;
        this.f5464h = lineCapType;
        this.f5465i = lineJoinType;
        this.f5466j = f10;
        this.f5467k = list;
        this.f5468l = bVar2;
        this.f5469m = z10;
    }

    public ShapeStroke.LineCapType getCapType() {
        return this.f5464h;
    }

    public v3.b getDashOffset() {
        return this.f5468l;
    }

    public f getEndPoint() {
        return this.f5462f;
    }

    public c getGradientColor() {
        return this.f5459c;
    }

    public GradientType getGradientType() {
        return this.f5458b;
    }

    public ShapeStroke.LineJoinType getJoinType() {
        return this.f5465i;
    }

    public List<v3.b> getLineDashPattern() {
        return this.f5467k;
    }

    public float getMiterLimit() {
        return this.f5466j;
    }

    public String getName() {
        return this.f5457a;
    }

    public d getOpacity() {
        return this.f5460d;
    }

    public f getStartPoint() {
        return this.f5461e;
    }

    public v3.b getWidth() {
        return this.f5463g;
    }

    public boolean isHidden() {
        return this.f5469m;
    }

    @Override // w3.b
    public r3.c toContent(p3.f fVar, com.airbnb.lottie.model.layer.a aVar) {
        return new i(fVar, aVar, this);
    }
}
