package com.google.android.gms.common;

/* compiled from: com.google.android.gms:play-services-basement@@18.3.0 */
/* loaded from: classes.dex */
class zzx {

    /* renamed from: d, reason: collision with root package name */
    public static final zzx f7554d = new zzx(true, null, null);

    /* renamed from: a, reason: collision with root package name */
    public final boolean f7555a;

    /* renamed from: b, reason: collision with root package name */
    public final String f7556b;

    /* renamed from: c, reason: collision with root package name */
    public final Throwable f7557c;

    public zzx(boolean z10, String str, Exception exc) {
        this.f7555a = z10;
        this.f7556b = str;
        this.f7557c = exc;
    }

    public static zzx b(String str) {
        return new zzx(false, str, null);
    }

    public static zzx c(String str, Exception exc) {
        return new zzx(false, str, exc);
    }

    public String a() {
        return this.f7556b;
    }
}
