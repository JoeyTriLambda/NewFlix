package com.google.android.gms.cast;

import java.util.HashMap;

/* compiled from: com.google.android.gms:play-services-cast@@21.4.0 */
/* loaded from: classes.dex */
final class zzcd {

    /* renamed from: a, reason: collision with root package name */
    public final HashMap f6995a = new HashMap();

    /* renamed from: b, reason: collision with root package name */
    public final HashMap f6996b = new HashMap();

    /* renamed from: c, reason: collision with root package name */
    public final HashMap f6997c = new HashMap();

    public final int zza(String str) {
        Integer num = (Integer) this.f6997c.get(str);
        if (num != null) {
            return num.intValue();
        }
        return 0;
    }

    public final zzcd zzb(String str, String str2, int i10) {
        this.f6995a.put(str, str2);
        this.f6996b.put(str2, str);
        this.f6997c.put(str, Integer.valueOf(i10));
        return this;
    }

    public final String zzc(String str) {
        return (String) this.f6995a.get(str);
    }

    public final String zzd(String str) {
        return (String) this.f6996b.get(str);
    }
}
