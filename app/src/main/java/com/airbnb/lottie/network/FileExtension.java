package com.airbnb.lottie.network;

/* loaded from: classes.dex */
public enum FileExtension {
    JSON(".json"),
    ZIP(".zip");


    /* renamed from: b, reason: collision with root package name */
    public final String f5528b;

    FileExtension(String str) {
        this.f5528b = str;
    }

    public String tempExtension() {
        return ".temp" + this.f5528b;
    }

    @Override // java.lang.Enum
    public String toString() {
        return this.f5528b;
    }
}
