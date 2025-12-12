package com.airbnb.lottie.model;

import ac.c;

/* loaded from: classes.dex */
public final class DocumentData {

    /* renamed from: a, reason: collision with root package name */
    public final String f5389a;

    /* renamed from: b, reason: collision with root package name */
    public final String f5390b;

    /* renamed from: c, reason: collision with root package name */
    public final float f5391c;

    /* renamed from: d, reason: collision with root package name */
    public final Justification f5392d;

    /* renamed from: e, reason: collision with root package name */
    public final int f5393e;

    /* renamed from: f, reason: collision with root package name */
    public final float f5394f;

    /* renamed from: g, reason: collision with root package name */
    public final float f5395g;

    /* renamed from: h, reason: collision with root package name */
    public final int f5396h;

    /* renamed from: i, reason: collision with root package name */
    public final int f5397i;

    /* renamed from: j, reason: collision with root package name */
    public final float f5398j;

    /* renamed from: k, reason: collision with root package name */
    public final boolean f5399k;

    public enum Justification {
        /* JADX INFO: Fake field, exist only in values array */
        LEFT_ALIGN,
        /* JADX INFO: Fake field, exist only in values array */
        RIGHT_ALIGN,
        CENTER
    }

    public DocumentData(String str, String str2, float f10, Justification justification, int i10, float f11, float f12, int i11, int i12, float f13, boolean z10) {
        this.f5389a = str;
        this.f5390b = str2;
        this.f5391c = f10;
        this.f5392d = justification;
        this.f5393e = i10;
        this.f5394f = f11;
        this.f5395g = f12;
        this.f5396h = i11;
        this.f5397i = i12;
        this.f5398j = f13;
        this.f5399k = z10;
    }

    public int hashCode() {
        int iOrdinal = ((this.f5392d.ordinal() + (((int) (c.b(this.f5390b, this.f5389a.hashCode() * 31, 31) + this.f5391c)) * 31)) * 31) + this.f5393e;
        long jFloatToRawIntBits = Float.floatToRawIntBits(this.f5394f);
        return (((iOrdinal * 31) + ((int) (jFloatToRawIntBits ^ (jFloatToRawIntBits >>> 32)))) * 31) + this.f5396h;
    }
}
