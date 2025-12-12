package com.airbnb.lottie.model.content;

import android.graphics.PointF;
import p3.f;
import r3.c;
import r3.n;
import v3.m;
import w3.b;

/* loaded from: classes.dex */
public final class PolystarShape implements b {

    /* renamed from: a, reason: collision with root package name */
    public final String f5423a;

    /* renamed from: b, reason: collision with root package name */
    public final Type f5424b;

    /* renamed from: c, reason: collision with root package name */
    public final v3.b f5425c;

    /* renamed from: d, reason: collision with root package name */
    public final m<PointF, PointF> f5426d;

    /* renamed from: e, reason: collision with root package name */
    public final v3.b f5427e;

    /* renamed from: f, reason: collision with root package name */
    public final v3.b f5428f;

    /* renamed from: g, reason: collision with root package name */
    public final v3.b f5429g;

    /* renamed from: h, reason: collision with root package name */
    public final v3.b f5430h;

    /* renamed from: i, reason: collision with root package name */
    public final v3.b f5431i;

    /* renamed from: j, reason: collision with root package name */
    public final boolean f5432j;

    public enum Type {
        STAR(1),
        /* JADX INFO: Fake field, exist only in values array */
        POLYGON(2);


        /* renamed from: b, reason: collision with root package name */
        public final int f5435b;

        Type(int i10) {
            this.f5435b = i10;
        }

        public static Type forValue(int i10) {
            for (Type type : values()) {
                if (type.f5435b == i10) {
                    return type;
                }
            }
            return null;
        }
    }

    public PolystarShape(String str, Type type, v3.b bVar, m<PointF, PointF> mVar, v3.b bVar2, v3.b bVar3, v3.b bVar4, v3.b bVar5, v3.b bVar6, boolean z10) {
        this.f5423a = str;
        this.f5424b = type;
        this.f5425c = bVar;
        this.f5426d = mVar;
        this.f5427e = bVar2;
        this.f5428f = bVar3;
        this.f5429g = bVar4;
        this.f5430h = bVar5;
        this.f5431i = bVar6;
        this.f5432j = z10;
    }

    public v3.b getInnerRadius() {
        return this.f5428f;
    }

    public v3.b getInnerRoundedness() {
        return this.f5430h;
    }

    public String getName() {
        return this.f5423a;
    }

    public v3.b getOuterRadius() {
        return this.f5429g;
    }

    public v3.b getOuterRoundedness() {
        return this.f5431i;
    }

    public v3.b getPoints() {
        return this.f5425c;
    }

    public m<PointF, PointF> getPosition() {
        return this.f5426d;
    }

    public v3.b getRotation() {
        return this.f5427e;
    }

    public Type getType() {
        return this.f5424b;
    }

    public boolean isHidden() {
        return this.f5432j;
    }

    @Override // w3.b
    public c toContent(f fVar, com.airbnb.lottie.model.layer.a aVar) {
        return new n(fVar, aVar, this);
    }
}
