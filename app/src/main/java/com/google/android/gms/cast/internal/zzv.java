package com.google.android.gms.cast.internal;

import com.google.android.gms.cast.ApplicationMetadata;
import com.google.android.gms.common.api.Status;
import com.google.android.gms.common.api.internal.BaseImplementation;
import com.google.android.gms.internal.cast.zzed;
import java.util.concurrent.atomic.AtomicReference;

/* compiled from: com.google.android.gms:play-services-cast@@21.4.0 */
/* loaded from: classes.dex */
final class zzv extends zzah {

    /* renamed from: a, reason: collision with root package name */
    public final AtomicReference f6880a;

    /* renamed from: b, reason: collision with root package name */
    public final zzed f6881b;

    public zzv(zzw zzwVar) {
        this.f6880a = new AtomicReference(zzwVar);
        this.f6881b = new zzed(zzwVar.getLooper());
    }

    @Override // com.google.android.gms.cast.internal.zzai
    public final void zzb(ApplicationMetadata applicationMetadata, String str, String str2, boolean z10) {
        zzw zzwVar = (zzw) this.f6880a.get();
        if (zzwVar == null) {
            return;
        }
        zzwVar.f6885a = applicationMetadata;
        zzwVar.f6902r = applicationMetadata.getApplicationId();
        zzwVar.f6903s = str2;
        zzwVar.f6892h = str;
        synchronized (zzw.f6883y) {
            try {
                BaseImplementation.ResultHolder resultHolder = zzwVar.f6906v;
                if (resultHolder != null) {
                    resultHolder.setResult(new zzq(new Status(0), applicationMetadata, str, str2, z10));
                    zzwVar.f6906v = null;
                }
            } catch (Throwable th2) {
                throw th2;
            }
        }
    }

    @Override // com.google.android.gms.cast.internal.zzai
    public final void zzc(int i10) {
        zzw zzwVar = (zzw) this.f6880a.get();
        if (zzwVar == null) {
            return;
        }
        zzwVar.zzR(i10);
    }

    @Override // com.google.android.gms.cast.internal.zzai
    public final void zzd(int i10) {
        zzw zzwVar = (zzw) this.f6880a.get();
        if (zzwVar == null) {
            return;
        }
        zzwVar.f6902r = null;
        zzwVar.f6903s = null;
        zzwVar.c(i10);
        if (zzwVar.f6887c != null) {
            this.f6881b.post(new zzr(zzwVar, i10));
        }
    }

    @Override // com.google.android.gms.cast.internal.zzai
    public final void zze(int i10) {
        zzw zzwVar = (zzw) this.f6880a.get();
        if (zzwVar == null) {
            return;
        }
        Logger logger = zzw.f6882x;
        zzwVar.c(i10);
    }

    @Override // com.google.android.gms.cast.internal.zzai
    public final void zzf(zza zzaVar) {
        zzw zzwVar = (zzw) this.f6880a.get();
        if (zzwVar == null) {
            return;
        }
        zzw.f6882x.d("onApplicationStatusChanged", new Object[0]);
        this.f6881b.post(new zzt(zzwVar, zzaVar));
    }

    @Override // com.google.android.gms.cast.internal.zzai
    public final void zzg(int i10) {
        zzw zzwVar = (zzw) this.f6880a.get();
        if (zzwVar == null) {
            return;
        }
        Logger logger = zzw.f6882x;
        zzwVar.c(i10);
    }

    @Override // com.google.android.gms.cast.internal.zzai
    public final void zzh(String str, byte[] bArr) {
        if (((zzw) this.f6880a.get()) == null) {
            return;
        }
        zzw.f6882x.d("IGNORING: Receive (type=binary, ns=%s) <%d bytes>", str, Integer.valueOf(bArr.length));
    }

    @Override // com.google.android.gms.cast.internal.zzai
    public final void zzj(zzab zzabVar) {
        zzw zzwVar = (zzw) this.f6880a.get();
        if (zzwVar == null) {
            return;
        }
        zzw.f6882x.d("onDeviceStatusChanged", new Object[0]);
        this.f6881b.post(new zzs(zzwVar, zzabVar));
    }

    @Override // com.google.android.gms.cast.internal.zzai
    public final void zzk(int i10) {
        zzw zzwVarZzq = zzq();
        if (zzwVarZzq == null) {
            return;
        }
        zzw.f6882x.d("ICastDeviceControllerListener.onDisconnected: %d", Integer.valueOf(i10));
        if (i10 != 0) {
            zzwVarZzq.triggerConnectionSuspended(2);
        }
    }

    @Override // com.google.android.gms.cast.internal.zzai
    public final void zzl(String str, long j10) {
        zzw zzwVar = (zzw) this.f6880a.get();
        if (zzwVar == null) {
            return;
        }
        Logger logger = zzw.f6882x;
        zzwVar.b(0, j10);
    }

    @Override // com.google.android.gms.cast.internal.zzai
    public final void zzm(String str, long j10, int i10) {
        zzw zzwVar = (zzw) this.f6880a.get();
        if (zzwVar == null) {
            return;
        }
        Logger logger = zzw.f6882x;
        zzwVar.b(i10, j10);
    }

    @Override // com.google.android.gms.cast.internal.zzai
    public final void zzn(String str, double d10, boolean z10) {
        zzw.f6882x.d("Deprecated callback: \"onStatusreceived\"", new Object[0]);
    }

    @Override // com.google.android.gms.cast.internal.zzai
    public final void zzp(String str, String str2) {
        zzw zzwVar = (zzw) this.f6880a.get();
        if (zzwVar == null) {
            return;
        }
        zzw.f6882x.d("Receive (type=text, ns=%s) %s", str, str2);
        this.f6881b.post(new zzu(zzwVar, str, str2));
    }

    public final zzw zzq() {
        zzw zzwVar = (zzw) this.f6880a.getAndSet(null);
        if (zzwVar == null) {
            return null;
        }
        Logger logger = zzw.f6882x;
        zzwVar.f6896l = false;
        zzwVar.f6899o = -1;
        zzwVar.f6900p = -1;
        zzwVar.f6885a = null;
        zzwVar.f6892h = null;
        zzwVar.f6897m = 0.0d;
        zzwVar.e();
        zzwVar.f6893i = false;
        zzwVar.f6898n = null;
        return zzwVar;
    }

    public final boolean zzr() {
        return this.f6880a.get() == null;
    }

    @Override // com.google.android.gms.cast.internal.zzai
    public final void zzi(int i10) {
    }

    @Override // com.google.android.gms.cast.internal.zzai
    public final void zzo(int i10) {
    }
}
