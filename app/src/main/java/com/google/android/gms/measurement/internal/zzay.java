package com.google.android.gms.measurement.internal;

import android.os.Bundle;
import android.text.TextUtils;
import com.google.android.gms.common.internal.Preconditions;
import java.util.Iterator;

/* compiled from: com.google.android.gms:play-services-measurement-impl@@21.6.1 */
/* loaded from: classes.dex */
public final class zzay {

    /* renamed from: a, reason: collision with root package name */
    public final String f7693a;

    /* renamed from: b, reason: collision with root package name */
    public final String f7694b;

    /* renamed from: c, reason: collision with root package name */
    public final String f7695c;

    /* renamed from: d, reason: collision with root package name */
    public final long f7696d;

    /* renamed from: e, reason: collision with root package name */
    public final long f7697e;

    /* renamed from: f, reason: collision with root package name */
    public final zzba f7698f;

    public zzay(zzho zzhoVar, String str, String str2, String str3, long j10, Bundle bundle) throws IllegalStateException {
        zzba zzbaVar;
        Preconditions.checkNotEmpty(str2);
        Preconditions.checkNotEmpty(str3);
        this.f7693a = str2;
        this.f7694b = str3;
        this.f7695c = TextUtils.isEmpty(str) ? null : str;
        this.f7696d = j10;
        this.f7697e = 0L;
        if (bundle == null || bundle.isEmpty()) {
            zzbaVar = new zzba(new Bundle());
        } else {
            Bundle bundle2 = new Bundle(bundle);
            Iterator<String> it = bundle2.keySet().iterator();
            while (it.hasNext()) {
                String next = it.next();
                if (next == null) {
                    zzhoVar.zzj().zzg().zza("Param name can't be null");
                    it.remove();
                } else {
                    Object objC = zzhoVar.zzt().C(bundle2.get(next), next);
                    if (objC == null) {
                        zzhoVar.zzj().zzu().zza("Param value can't be null", zzhoVar.zzk().zzb(next));
                        it.remove();
                    } else {
                        zzhoVar.zzt().k(bundle2, next, objC);
                    }
                }
            }
            zzbaVar = new zzba(bundle2);
        }
        this.f7698f = zzbaVar;
    }

    public final zzay a(zzho zzhoVar, long j10) {
        return new zzay(zzhoVar, this.f7695c, this.f7693a, this.f7694b, this.f7696d, j10, this.f7698f);
    }

    public final String toString() {
        return "Event{appId='" + this.f7693a + "', name='" + this.f7694b + "', params=" + String.valueOf(this.f7698f) + "}";
    }

    public zzay(zzho zzhoVar, String str, String str2, String str3, long j10, long j11, zzba zzbaVar) throws IllegalStateException {
        Preconditions.checkNotEmpty(str2);
        Preconditions.checkNotEmpty(str3);
        Preconditions.checkNotNull(zzbaVar);
        this.f7693a = str2;
        this.f7694b = str3;
        this.f7695c = TextUtils.isEmpty(str) ? null : str;
        this.f7696d = j10;
        this.f7697e = j11;
        if (j11 != 0 && j11 > j10) {
            zzhoVar.zzj().zzu().zza("Event created with reverse previous/current timestamps. appId, name", zzgb.zza(str2), zzgb.zza(str3));
        }
        this.f7698f = zzbaVar;
    }
}
