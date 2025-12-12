package com.google.android.gms.internal.measurement;

import ac.c;
import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.Callable;

/* compiled from: com.google.android.gms:play-services-measurement@@21.6.1 */
/* loaded from: classes.dex */
public final class zzl {
    private Map<String, Callable<? extends zzal>> zza = new HashMap();

    public final zzaq zza(String str) {
        if (!this.zza.containsKey(str)) {
            return zzaq.zzc;
        }
        try {
            return this.zza.get(str).call();
        } catch (Exception unused) {
            throw new IllegalStateException(c.j("Failed to create API implementation: ", str));
        }
    }

    public final void zza(String str, Callable<? extends zzal> callable) {
        this.zza.put(str, callable);
    }
}
