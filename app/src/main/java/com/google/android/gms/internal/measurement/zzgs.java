package com.google.android.gms.internal.measurement;

import android.content.Context;
import b8.g;
import com.google.common.base.Optional;

/* compiled from: com.google.android.gms:play-services-measurement-impl@@21.6.1 */
/* loaded from: classes.dex */
final class zzgs extends zzhr {
    private final Context zza;
    private final g<Optional<zzhe>> zzb;

    public zzgs(Context context, g<Optional<zzhe>> gVar) {
        if (context == null) {
            throw new NullPointerException("Null context");
        }
        this.zza = context;
        this.zzb = gVar;
    }

    public final boolean equals(Object obj) {
        g<Optional<zzhe>> gVar;
        if (obj == this) {
            return true;
        }
        if (obj instanceof zzhr) {
            zzhr zzhrVar = (zzhr) obj;
            if (this.zza.equals(zzhrVar.zza()) && ((gVar = this.zzb) != null ? gVar.equals(zzhrVar.zzb()) : zzhrVar.zzb() == null)) {
                return true;
            }
        }
        return false;
    }

    public final int hashCode() {
        int iHashCode = (this.zza.hashCode() ^ 1000003) * 1000003;
        g<Optional<zzhe>> gVar = this.zzb;
        return iHashCode ^ (gVar == null ? 0 : gVar.hashCode());
    }

    public final String toString() {
        return "FlagsContext{context=" + String.valueOf(this.zza) + ", hermeticFileOverrides=" + String.valueOf(this.zzb) + "}";
    }

    @Override // com.google.android.gms.internal.measurement.zzhr
    public final Context zza() {
        return this.zza;
    }

    @Override // com.google.android.gms.internal.measurement.zzhr
    public final g<Optional<zzhe>> zzb() {
        return this.zzb;
    }
}
