package com.google.android.gms.internal.measurement;

/* compiled from: com.google.android.gms:play-services-measurement-base@@21.6.1 */
/* loaded from: classes.dex */
public class zzkk {
    private static final zzjg zza = zzjg.zza;
    private zzij zzb;
    private volatile zzlg zzc;
    private volatile zzij zzd;

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof zzkk)) {
            return false;
        }
        zzkk zzkkVar = (zzkk) obj;
        zzlg zzlgVar = this.zzc;
        zzlg zzlgVar2 = zzkkVar.zzc;
        return (zzlgVar == null && zzlgVar2 == null) ? zzc().equals(zzkkVar.zzc()) : (zzlgVar == null || zzlgVar2 == null) ? zzlgVar != null ? zzlgVar.equals(zzkkVar.zzb(zzlgVar.zzaj())) : zzb(zzlgVar2.zzaj()).equals(zzlgVar2) : zzlgVar.equals(zzlgVar2);
    }

    public int hashCode() {
        return 1;
    }

    public final zzlg zza(zzlg zzlgVar) {
        zzlg zzlgVar2 = this.zzc;
        this.zzb = null;
        this.zzd = null;
        this.zzc = zzlgVar;
        return zzlgVar2;
    }

    public final int zzb() {
        if (this.zzd != null) {
            return this.zzd.zzb();
        }
        if (this.zzc != null) {
            return this.zzc.zzbw();
        }
        return 0;
    }

    public final zzij zzc() {
        if (this.zzd != null) {
            return this.zzd;
        }
        synchronized (this) {
            if (this.zzd != null) {
                return this.zzd;
            }
            if (this.zzc == null) {
                this.zzd = zzij.zza;
            } else {
                this.zzd = this.zzc.zzbu();
            }
            return this.zzd;
        }
    }

    private final zzlg zzb(zzlg zzlgVar) {
        if (this.zzc == null) {
            synchronized (this) {
                if (this.zzc == null) {
                    try {
                        this.zzc = zzlgVar;
                        this.zzd = zzij.zza;
                    } catch (zzkb unused) {
                        this.zzc = zzlgVar;
                        this.zzd = zzij.zza;
                    }
                }
            }
        }
        return this.zzc;
    }
}
