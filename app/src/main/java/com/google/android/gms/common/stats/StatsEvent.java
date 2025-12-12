package com.google.android.gms.common.stats;

import com.google.android.gms.common.annotation.KeepForSdk;
import com.google.android.gms.common.internal.ReflectedParcelable;
import com.google.android.gms.common.internal.safeparcel.AbstractSafeParcelable;

/* compiled from: com.google.android.gms:play-services-basement@@18.3.0 */
@KeepForSdk
@Deprecated
/* loaded from: classes.dex */
public abstract class StatsEvent extends AbstractSafeParcelable implements ReflectedParcelable {

    /* compiled from: com.google.android.gms:play-services-basement@@18.3.0 */
    @KeepForSdk
    public interface Types {
    }

    public final String toString() {
        return zzb() + "\t" + zza() + "\t-1" + zzc();
    }

    public abstract int zza();

    public abstract long zzb();

    public abstract String zzc();
}
