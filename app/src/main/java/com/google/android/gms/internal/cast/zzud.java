package com.google.android.gms.internal.cast;

/* compiled from: com.google.android.gms:play-services-cast@@21.4.0 */
/* loaded from: classes.dex */
public class zzud {
    private static final zzte zzb = zzte.zza;
    protected volatile zzux zza;
    private volatile zzsu zzc;

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof zzud)) {
            return false;
        }
        zzud zzudVar = (zzud) obj;
        zzux zzuxVar = this.zza;
        zzux zzuxVar2 = zzudVar.zza;
        if (zzuxVar == null && zzuxVar2 == null) {
            return zzb().equals(zzudVar.zzb());
        }
        if (zzuxVar != null && zzuxVar2 != null) {
            return zzuxVar.equals(zzuxVar2);
        }
        if (zzuxVar != null) {
            zzudVar.zzc(zzuxVar.zzt());
            return zzuxVar.equals(zzudVar.zza);
        }
        zzc(zzuxVar2.zzt());
        return this.zza.equals(zzuxVar2);
    }

    public int hashCode() {
        return 1;
    }

    public final int zza() {
        if (this.zzc != null) {
            return ((zzsr) this.zzc).zza.length;
        }
        if (this.zza != null) {
            return this.zza.zzu();
        }
        return 0;
    }

    public final zzsu zzb() {
        if (this.zzc != null) {
            return this.zzc;
        }
        synchronized (this) {
            if (this.zzc != null) {
                return this.zzc;
            }
            if (this.zza == null) {
                this.zzc = zzsu.zzb;
            } else {
                this.zzc = this.zza.zzr();
            }
            return this.zzc;
        }
    }

    public final void zzc(zzux zzuxVar) {
        if (this.zza != null) {
            return;
        }
        synchronized (this) {
            if (this.zza != null) {
                return;
            }
            try {
                this.zza = zzuxVar;
                this.zzc = zzsu.zzb;
            } catch (zzua unused) {
                this.zza = zzuxVar;
                this.zzc = zzsu.zzb;
            }
        }
    }
}
