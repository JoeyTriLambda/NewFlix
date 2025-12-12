package org.jsoup;

import java.io.IOException;

/* loaded from: classes2.dex */
public class UnsupportedMimeTypeException extends IOException {

    /* renamed from: b, reason: collision with root package name */
    public final String f17122b;

    /* renamed from: m, reason: collision with root package name */
    public final String f17123m;

    public UnsupportedMimeTypeException(String str, String str2, String str3) {
        super(str);
        this.f17122b = str2;
        this.f17123m = str3;
    }

    @Override // java.lang.Throwable
    public String toString() {
        return super.toString() + ". Mimetype=" + this.f17122b + ", URL=" + this.f17123m;
    }
}
