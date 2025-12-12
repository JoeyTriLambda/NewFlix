package com.airbnb.lottie.model.content;

import ac.c;
import p3.f;
import r3.s;
import w3.b;

/* loaded from: classes.dex */
public final class ShapeTrimPath implements b {

    /* renamed from: a, reason: collision with root package name */
    public final String f5448a;

    /* renamed from: b, reason: collision with root package name */
    public final Type f5449b;

    /* renamed from: c, reason: collision with root package name */
    public final v3.b f5450c;

    /* renamed from: d, reason: collision with root package name */
    public final v3.b f5451d;

    /* renamed from: e, reason: collision with root package name */
    public final v3.b f5452e;

    /* renamed from: f, reason: collision with root package name */
    public final boolean f5453f;

    public enum Type {
        SIMULTANEOUSLY,
        INDIVIDUALLY;

        public static Type forId(int i10) {
            if (i10 == 1) {
                return SIMULTANEOUSLY;
            }
            if (i10 == 2) {
                return INDIVIDUALLY;
            }
            throw new IllegalArgumentException(c.f("Unknown trim path type ", i10));
        }
    }

    public ShapeTrimPath(String str, Type type, v3.b bVar, v3.b bVar2, v3.b bVar3, boolean z10) {
        this.f5448a = str;
        this.f5449b = type;
        this.f5450c = bVar;
        this.f5451d = bVar2;
        this.f5452e = bVar3;
        this.f5453f = z10;
    }

    public v3.b getEnd() {
        return this.f5451d;
    }

    public String getName() {
        return this.f5448a;
    }

    public v3.b getOffset() {
        return this.f5452e;
    }

    public v3.b getStart() {
        return this.f5450c;
    }

    public Type getType() {
        return this.f5449b;
    }

    public boolean isHidden() {
        return this.f5453f;
    }

    @Override // w3.b
    public r3.c toContent(f fVar, com.airbnb.lottie.model.layer.a aVar) {
        return new s(aVar, this);
    }

    public String toString() {
        return "Trim Path: {start: " + this.f5450c + ", end: " + this.f5451d + ", offset: " + this.f5452e + "}";
    }
}
