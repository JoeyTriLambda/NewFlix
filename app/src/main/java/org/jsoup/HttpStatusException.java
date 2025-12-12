package org.jsoup;

import java.io.IOException;

/* loaded from: classes2.dex */
public class HttpStatusException extends IOException {

    /* renamed from: b, reason: collision with root package name */
    public final int f17120b;

    /* renamed from: m, reason: collision with root package name */
    public final String f17121m;

    public HttpStatusException(String str, int i10, String str2) {
        super(str);
        this.f17120b = i10;
        this.f17121m = str2;
    }

    @Override // java.lang.Throwable
    public String toString() {
        return super.toString() + ". Status=" + this.f17120b + ", URL=" + this.f17121m;
    }
}
