package com.google.android.gms.internal.measurement;

import com.google.android.gms.internal.measurement.zzgb;
import java.util.Collections;
import java.util.Iterator;
import java.util.List;
import java.util.concurrent.Callable;

/* compiled from: com.google.android.gms:play-services-measurement@@21.6.1 */
/* loaded from: classes.dex */
public final class zzb {
    zzac zza;
    private final zzf zzb;
    private zzh zzc;
    private final zzaa zzd;

    public zzb() {
        this(new zzf());
    }

    public final zzac zza() {
        return this.zza;
    }

    public final /* synthetic */ zzal zzb() throws Exception {
        return new zzw(this.zzd);
    }

    public final boolean zzc() {
        return !this.zza.zzc().isEmpty();
    }

    public final boolean zzd() {
        return !this.zza.zzb().equals(this.zza.zza());
    }

    private zzb(zzf zzfVar) {
        this.zzb = zzfVar;
        this.zzc = zzfVar.zza.zza();
        this.zza = new zzac();
        this.zzd = new zzaa();
        zzfVar.zza("internal.registerCallback", new Callable() { // from class: com.google.android.gms.internal.measurement.zza
            @Override // java.util.concurrent.Callable
            public final Object call() {
                return this.zza.zzb();
            }
        });
        zzfVar.zza("internal.eventLogger", new Callable() { // from class: com.google.android.gms.internal.measurement.zzd
            @Override // java.util.concurrent.Callable
            public final Object call() {
                return new zzk(this.zza.zza);
            }
        });
    }

    public final void zza(zzgb.zzc zzcVar) throws zzc {
        zzal zzalVar;
        try {
            this.zzc = this.zzb.zza.zza();
            if (this.zzb.zza(this.zzc, (zzgb.zzd[]) zzcVar.zzc().toArray(new zzgb.zzd[0])) instanceof zzaj) {
                throw new IllegalStateException("Program loading failed");
            }
            for (zzgb.zzb zzbVar : zzcVar.zza().zzd()) {
                List<zzgb.zzd> listZzc = zzbVar.zzc();
                String strZzb = zzbVar.zzb();
                Iterator<zzgb.zzd> it = listZzc.iterator();
                while (it.hasNext()) {
                    zzaq zzaqVarZza = this.zzb.zza(this.zzc, it.next());
                    if (!(zzaqVarZza instanceof zzap)) {
                        throw new IllegalArgumentException("Invalid rule definition");
                    }
                    zzh zzhVar = this.zzc;
                    if (zzhVar.zzb(strZzb)) {
                        zzaq zzaqVarZza2 = zzhVar.zza(strZzb);
                        if (!(zzaqVarZza2 instanceof zzal)) {
                            throw new IllegalStateException("Invalid function name: " + strZzb);
                        }
                        zzalVar = (zzal) zzaqVarZza2;
                    } else {
                        zzalVar = null;
                    }
                    if (zzalVar == null) {
                        throw new IllegalStateException("Rule function is undefined: " + strZzb);
                    }
                    zzalVar.zza(this.zzc, Collections.singletonList(zzaqVarZza));
                }
            }
        } catch (Throwable th2) {
            throw new zzc(th2);
        }
    }

    public final void zza(String str, Callable<? extends zzal> callable) {
        this.zzb.zza(str, callable);
    }

    public final boolean zza(zzad zzadVar) throws zzc {
        try {
            this.zza.zza(zzadVar);
            this.zzb.zzb.zzc("runtime.counter", new zzai(Double.valueOf(0.0d)));
            this.zzd.zza(this.zzc.zza(), this.zza);
            if (zzd()) {
                return true;
            }
            return zzc();
        } catch (Throwable th2) {
            throw new zzc(th2);
        }
    }
}
