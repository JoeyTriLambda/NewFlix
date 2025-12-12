package com.google.android.gms.measurement.internal;

import java.util.Map;

/* compiled from: com.google.android.gms:play-services-measurement@@21.6.1 */
/* loaded from: classes.dex */
final class zzhg implements com.google.android.gms.internal.measurement.zzo {

    /* renamed from: a, reason: collision with root package name */
    public final /* synthetic */ String f8071a;

    /* renamed from: b, reason: collision with root package name */
    public final /* synthetic */ zzgy f8072b;

    public zzhg(zzgy zzgyVar, String str) {
        this.f8071a = str;
        this.f8072b = zzgyVar;
    }

    @Override // com.google.android.gms.internal.measurement.zzo
    public final String zza(String str) {
        Map map = (Map) this.f8072b.f8046d.get(this.f8071a);
        if (map == null || !map.containsKey(str)) {
            return null;
        }
        return (String) map.get(str);
    }
}
