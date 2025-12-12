package com.google.android.gms.measurement.internal;

/* compiled from: com.google.android.gms:play-services-measurement-impl@@21.6.1 */
/* loaded from: classes.dex */
final class zzjt implements Runnable {

    /* renamed from: b, reason: collision with root package name */
    public final /* synthetic */ String f8285b;

    /* renamed from: m, reason: collision with root package name */
    public final /* synthetic */ String f8286m;

    /* renamed from: n, reason: collision with root package name */
    public final /* synthetic */ Object f8287n;

    /* renamed from: o, reason: collision with root package name */
    public final /* synthetic */ long f8288o;

    /* renamed from: p, reason: collision with root package name */
    public final /* synthetic */ zziy f8289p;

    public zzjt(zziy zziyVar, String str, String str2, Object obj, long j10) {
        this.f8285b = str;
        this.f8286m = str2;
        this.f8287n = obj;
        this.f8288o = j10;
        this.f8289p = zziyVar;
    }

    @Override // java.lang.Runnable
    public final void run() throws IllegalStateException {
        this.f8289p.j(this.f8285b, this.f8286m, this.f8287n, this.f8288o);
    }
}
