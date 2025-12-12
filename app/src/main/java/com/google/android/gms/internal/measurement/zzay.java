package com.google.android.gms.internal.measurement;

import ac.c;
import java.util.ArrayList;
import java.util.List;

/* compiled from: com.google.android.gms:play-services-measurement@@21.6.1 */
/* loaded from: classes.dex */
public abstract class zzay {
    final List<zzbv> zza = new ArrayList();

    public final zzaq zza(String str) {
        if (this.zza.contains(zzg.zza(str))) {
            throw new UnsupportedOperationException(c.j("Command not implemented: ", str));
        }
        throw new IllegalArgumentException("Command not supported");
    }

    public abstract zzaq zza(String str, zzh zzhVar, List<zzaq> list);
}
