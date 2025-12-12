package com.google.android.gms.internal.cast;

import ac.c;

/* compiled from: com.google.android.gms:play-services-cast@@21.4.0 */
/* loaded from: classes.dex */
final class zzfr {
    private final Object zza;
    private final Object zzb;
    private final Object zzc;

    public zzfr(Object obj, Object obj2, Object obj3) {
        this.zza = obj;
        this.zzb = obj2;
        this.zzc = obj3;
    }

    public final IllegalArgumentException zza() {
        Object obj = this.zzc;
        Object obj2 = this.zzb;
        Object obj3 = this.zza;
        String strValueOf = String.valueOf(obj3);
        String strValueOf2 = String.valueOf(obj2);
        String strValueOf3 = String.valueOf(obj3);
        String strValueOf4 = String.valueOf(obj);
        StringBuilder sb2 = new StringBuilder("Multiple entries with same key: ");
        sb2.append(strValueOf);
        sb2.append("=");
        sb2.append(strValueOf2);
        sb2.append(" and ");
        return new IllegalArgumentException(c.p(sb2, strValueOf3, "=", strValueOf4));
    }
}
