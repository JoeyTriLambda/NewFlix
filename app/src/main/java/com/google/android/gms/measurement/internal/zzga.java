package com.google.android.gms.measurement.internal;

import ac.c;
import com.uwetrottmann.trakt5.TraktV2;

/* compiled from: com.google.android.gms:play-services-measurement-impl@@21.6.1 */
/* loaded from: classes.dex */
final class zzga implements Runnable {

    /* renamed from: b, reason: collision with root package name */
    public final /* synthetic */ int f7949b;

    /* renamed from: m, reason: collision with root package name */
    public final /* synthetic */ String f7950m;

    /* renamed from: n, reason: collision with root package name */
    public final /* synthetic */ Object f7951n;

    /* renamed from: o, reason: collision with root package name */
    public final /* synthetic */ Object f7952o;

    /* renamed from: p, reason: collision with root package name */
    public final /* synthetic */ Object f7953p;

    /* renamed from: q, reason: collision with root package name */
    public final /* synthetic */ zzgb f7954q;

    public zzga(zzgb zzgbVar, int i10, String str, Object obj, Object obj2, Object obj3) {
        this.f7949b = i10;
        this.f7950m = str;
        this.f7951n = obj;
        this.f7952o = obj2;
        this.f7953p = obj3;
        this.f7954q = zzgbVar;
    }

    @Override // java.lang.Runnable
    public final void run() {
        zzgb zzgbVar = this.f7954q;
        zzgm zzgmVarZzn = zzgbVar.f8189a.zzn();
        if (!zzgmVarZzn.f8188b) {
            zzgbVar.zza(6, "Persisted config not initialized. Not logging error/warn");
            return;
        }
        if (zzgbVar.f7955c == 0) {
            if (zzgbVar.zze().zzy()) {
                zzgbVar.f7955c = 'C';
            } else {
                zzgbVar.f7955c = 'c';
            }
        }
        if (zzgbVar.f7956d < 0) {
            zzgbVar.f7956d = 87000L;
        }
        char cCharAt = "01VDIWEA?".charAt(this.f7949b);
        char c10 = zzgbVar.f7955c;
        long j10 = zzgbVar.f7956d;
        Object obj = this.f7951n;
        String str = this.f7950m;
        String strB = zzgb.b(true, str, obj, this.f7952o, this.f7953p);
        StringBuilder sb2 = new StringBuilder(TraktV2.API_VERSION);
        sb2.append(cCharAt);
        sb2.append(c10);
        sb2.append(j10);
        String strO = c.o(sb2, ":", strB);
        if (strO.length() > 1024) {
            strO = str.substring(0, 1024);
        }
        zzgq zzgqVar = zzgmVarZzn.f7995f;
        if (zzgqVar != null) {
            zzgqVar.zza(strO, 1L);
        }
    }
}
