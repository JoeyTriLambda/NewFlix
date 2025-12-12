package com.google.android.gms.measurement.internal;

/* compiled from: com.google.android.gms:play-services-measurement@@21.6.1 */
/* loaded from: classes.dex */
final class zzhw implements Runnable {

    /* renamed from: b, reason: collision with root package name */
    public final /* synthetic */ String f8137b;

    /* renamed from: m, reason: collision with root package name */
    public final /* synthetic */ String f8138m;

    /* renamed from: n, reason: collision with root package name */
    public final /* synthetic */ String f8139n;

    /* renamed from: o, reason: collision with root package name */
    public final /* synthetic */ long f8140o;

    /* renamed from: p, reason: collision with root package name */
    public final /* synthetic */ zzhs f8141p;

    public zzhw(zzhs zzhsVar, String str, String str2, String str3, long j10) {
        this.f8137b = str;
        this.f8138m = str2;
        this.f8139n = str3;
        this.f8140o = j10;
        this.f8141p = zzhsVar;
    }

    @Override // java.lang.Runnable
    public final void run() {
        String str = this.f8138m;
        zzhs zzhsVar = this.f8141p;
        String str2 = this.f8137b;
        if (str2 == null) {
            zzhsVar.f8127a.zza(str, null);
        } else {
            zzhsVar.f8127a.zza(str, new zzks(this.f8139n, str2, this.f8140o));
        }
    }
}
