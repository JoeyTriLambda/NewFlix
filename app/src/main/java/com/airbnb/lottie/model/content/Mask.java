package com.airbnb.lottie.model.content;

import v3.d;
import v3.h;

/* loaded from: classes.dex */
public final class Mask {

    /* renamed from: a, reason: collision with root package name */
    public final MaskMode f5405a;

    /* renamed from: b, reason: collision with root package name */
    public final h f5406b;

    /* renamed from: c, reason: collision with root package name */
    public final d f5407c;

    /* renamed from: d, reason: collision with root package name */
    public final boolean f5408d;

    public enum MaskMode {
        MASK_MODE_ADD,
        MASK_MODE_SUBTRACT,
        MASK_MODE_INTERSECT,
        MASK_MODE_NONE
    }

    public Mask(MaskMode maskMode, h hVar, d dVar, boolean z10) {
        this.f5405a = maskMode;
        this.f5406b = hVar;
        this.f5407c = dVar;
        this.f5408d = z10;
    }

    public MaskMode getMaskMode() {
        return this.f5405a;
    }

    public h getMaskPath() {
        return this.f5406b;
    }

    public d getOpacity() {
        return this.f5407c;
    }

    public boolean isInverted() {
        return this.f5408d;
    }
}
