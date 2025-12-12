package com.bumptech.glide.load;

/* loaded from: classes.dex */
public enum ImageHeaderParser$ImageType {
    GIF(true),
    JPEG(false),
    RAW(false),
    PNG_A(true),
    PNG(false),
    WEBP_A(true),
    WEBP(false),
    UNKNOWN(false);


    /* renamed from: b, reason: collision with root package name */
    public final boolean f5571b;

    ImageHeaderParser$ImageType(boolean z10) {
        this.f5571b = z10;
    }

    public boolean hasAlpha() {
        return this.f5571b;
    }
}
