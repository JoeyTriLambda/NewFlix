package com.google.android.gms.cast;

import com.google.android.gms.cast.Cast;
import com.google.android.gms.cast.internal.CastUtils;
import com.google.android.gms.cast.internal.Logger;
import com.google.android.gms.common.api.Status;
import com.google.android.gms.common.api.internal.ListenerHolder;
import com.google.android.gms.common.internal.Preconditions;
import com.google.android.gms.tasks.TaskCompletionSource;
import java.util.HashMap;
import java.util.Iterator;

/* compiled from: com.google.android.gms:play-services-cast@@21.4.0 */
/* loaded from: classes.dex */
final class zzbs extends com.google.android.gms.cast.internal.zzah {

    /* renamed from: a, reason: collision with root package name */
    public final /* synthetic */ zzbt f6976a;

    public zzbs(zzbt zzbtVar) {
        this.f6976a = zzbtVar;
    }

    @Override // com.google.android.gms.cast.internal.zzai
    public final void zzb(ApplicationMetadata applicationMetadata, String str, String str2, boolean z10) {
        zzbt zzbtVar = this.f6976a;
        zzbtVar.f6986s = applicationMetadata;
        zzbtVar.f6987t = str;
        com.google.android.gms.cast.internal.zzq zzqVar = new com.google.android.gms.cast.internal.zzq(new Status(0), applicationMetadata, str, str2, z10);
        zzbt zzbtVar2 = this.f6976a;
        synchronized (zzbtVar2.f6984q) {
            TaskCompletionSource taskCompletionSource = zzbtVar2.f6981n;
            if (taskCompletionSource != null) {
                taskCompletionSource.setResult(zzqVar);
            }
            zzbtVar2.f6981n = null;
        }
    }

    @Override // com.google.android.gms.cast.internal.zzai
    public final void zzc(int i10) {
        Logger logger = zzbt.F;
        this.f6976a.e(i10);
    }

    @Override // com.google.android.gms.cast.internal.zzai
    public final void zzd(final int i10) {
        zzbt zzbtVar = this.f6976a;
        zzbt.c(zzbtVar, i10);
        if (zzbtVar.C != null) {
            zzbt.g(zzbtVar).post(new Runnable() { // from class: com.google.android.gms.cast.zzbq
                @Override // java.lang.Runnable
                public final void run() {
                    this.f6972b.f6976a.C.onApplicationDisconnected(i10);
                }
            });
        }
    }

    @Override // com.google.android.gms.cast.internal.zzai
    public final void zze(int i10) {
        zzbt.c(this.f6976a, i10);
    }

    @Override // com.google.android.gms.cast.internal.zzai
    public final void zzf(final com.google.android.gms.cast.internal.zza zzaVar) {
        zzbt.g(this.f6976a).post(new Runnable() { // from class: com.google.android.gms.cast.zzbm
            @Override // java.lang.Runnable
            public final void run() {
                boolean z10;
                zzbt zzbtVar = this.f6963b.f6976a;
                Logger logger = zzbt.F;
                String strZza = zzaVar.zza();
                if (CastUtils.zze(strZza, zzbtVar.f6987t)) {
                    z10 = false;
                } else {
                    zzbtVar.f6987t = strZza;
                    z10 = true;
                }
                zzbt.F.d("hasChanged=%b, mFirstApplicationStatusUpdate=%b", Boolean.valueOf(z10), Boolean.valueOf(zzbtVar.f6980m));
                Cast.Listener listener = zzbtVar.C;
                if (listener != null && (z10 || zzbtVar.f6980m)) {
                    listener.onApplicationStatusChanged();
                }
                zzbtVar.f6980m = false;
            }
        });
    }

    @Override // com.google.android.gms.cast.internal.zzai
    public final void zzg(int i10) {
        zzbt.c(this.f6976a, i10);
    }

    @Override // com.google.android.gms.cast.internal.zzai
    public final void zzh(String str, byte[] bArr) {
        zzbt.F.d("IGNORING: Receive (type=binary, ns=%s) <%d bytes>", str, Integer.valueOf(bArr.length));
    }

    @Override // com.google.android.gms.cast.internal.zzai
    public final void zzi(final int i10) {
        zzbt.g(this.f6976a).post(new Runnable() { // from class: com.google.android.gms.cast.zzbo
            @Override // java.lang.Runnable
            public final void run() {
                zzbs zzbsVar = this.f6967b;
                int i11 = i10;
                if (i11 != 0) {
                    zzbt zzbtVar = zzbsVar.f6976a;
                    zzbtVar.E = 1;
                    synchronized (zzbtVar.D) {
                        Iterator it = zzbsVar.f6976a.D.iterator();
                        while (it.hasNext()) {
                            ((zzq) it.next()).zzb(i11);
                        }
                    }
                    zzbsVar.f6976a.d();
                    return;
                }
                zzbt zzbtVar2 = zzbsVar.f6976a;
                zzbtVar2.E = 2;
                zzbtVar2.f6979l = true;
                zzbtVar2.f6980m = true;
                synchronized (zzbtVar2.D) {
                    Iterator it2 = zzbsVar.f6976a.D.iterator();
                    while (it2.hasNext()) {
                        ((zzq) it2.next()).zza();
                    }
                }
            }
        });
    }

    @Override // com.google.android.gms.cast.internal.zzai
    public final void zzj(final com.google.android.gms.cast.internal.zzab zzabVar) {
        zzbt.g(this.f6976a).post(new Runnable() { // from class: com.google.android.gms.cast.zzbl
            @Override // java.lang.Runnable
            public final void run() {
                boolean z10;
                boolean z11;
                boolean z12;
                zzbt zzbtVar = this.f6961b.f6976a;
                Logger logger = zzbt.F;
                com.google.android.gms.cast.internal.zzab zzabVar2 = zzabVar;
                ApplicationMetadata applicationMetadataZze = zzabVar2.zze();
                boolean zZze = CastUtils.zze(applicationMetadataZze, zzbtVar.f6986s);
                Cast.Listener listener = zzbtVar.C;
                if (!zZze) {
                    zzbtVar.f6986s = applicationMetadataZze;
                    listener.onApplicationMetadataChanged(applicationMetadataZze);
                }
                double dZzb = zzabVar2.zzb();
                if (Double.isNaN(dZzb) || Math.abs(dZzb - zzbtVar.f6988u) <= 1.0E-7d) {
                    z10 = false;
                } else {
                    zzbtVar.f6988u = dZzb;
                    z10 = true;
                }
                boolean zZzg = zzabVar2.zzg();
                if (zZzg != zzbtVar.f6989v) {
                    zzbtVar.f6989v = zZzg;
                    z10 = true;
                }
                Logger logger2 = zzbt.F;
                logger2.d("hasVolumeChanged=%b, mFirstDeviceStatusUpdate=%b", Boolean.valueOf(z10), Boolean.valueOf(zzbtVar.f6979l));
                if (listener != null && (z10 || zzbtVar.f6979l)) {
                    listener.onVolumeChanged();
                }
                Double.isNaN(zzabVar2.zza());
                int iZzc = zzabVar2.zzc();
                if (iZzc != zzbtVar.f6990w) {
                    zzbtVar.f6990w = iZzc;
                    z11 = true;
                } else {
                    z11 = false;
                }
                logger2.d("hasActiveInputChanged=%b, mFirstDeviceStatusUpdate=%b", Boolean.valueOf(z11), Boolean.valueOf(zzbtVar.f6979l));
                if (listener != null && (z11 || zzbtVar.f6979l)) {
                    listener.onActiveInputStateChanged(zzbtVar.f6990w);
                }
                int iZzd = zzabVar2.zzd();
                if (iZzd != zzbtVar.f6991x) {
                    zzbtVar.f6991x = iZzd;
                    z12 = true;
                } else {
                    z12 = false;
                }
                logger2.d("hasStandbyStateChanged=%b, mFirstDeviceStatusUpdate=%b", Boolean.valueOf(z12), Boolean.valueOf(zzbtVar.f6979l));
                if (listener != null && (z12 || zzbtVar.f6979l)) {
                    listener.onStandbyStateChanged(zzbtVar.f6991x);
                }
                if (!CastUtils.zze(zzbtVar.f6992y, zzabVar2.zzf())) {
                    zzbtVar.f6992y = zzabVar2.zzf();
                }
                zzbtVar.f6979l = false;
            }
        });
    }

    @Override // com.google.android.gms.cast.internal.zzai
    public final void zzk(final int i10) {
        zzbt.g(this.f6976a).post(new Runnable() { // from class: com.google.android.gms.cast.zzbn
            @Override // java.lang.Runnable
            public final void run() {
                zzbs zzbsVar = this.f6965b;
                zzbt zzbtVar = zzbsVar.f6976a;
                zzbtVar.f6990w = -1;
                zzbtVar.f6991x = -1;
                zzbtVar.f6986s = null;
                zzbtVar.f6987t = null;
                zzbtVar.f6988u = 0.0d;
                zzbtVar.f();
                zzbtVar.f6989v = false;
                zzbtVar.f6992y = null;
                zzbt zzbtVar2 = zzbsVar.f6976a;
                zzbtVar2.E = 1;
                int i11 = i10;
                synchronized (zzbtVar2.D) {
                    Iterator it = zzbsVar.f6976a.D.iterator();
                    while (it.hasNext()) {
                        ((zzq) it.next()).zzd(i11);
                    }
                }
                zzbsVar.f6976a.d();
                zzbt zzbtVar3 = zzbsVar.f6976a;
                zzbtVar3.doUnregisterEventListener((ListenerHolder.ListenerKey) Preconditions.checkNotNull(zzbtVar3.registerListener(zzbtVar3.f6977j, "castDeviceControllerListenerKey").getListenerKey(), "Key must not be null"), 8415);
            }
        });
    }

    @Override // com.google.android.gms.cast.internal.zzai
    public final void zzl(String str, long j10) {
        zzbt.b(this.f6976a, j10, 0);
    }

    @Override // com.google.android.gms.cast.internal.zzai
    public final void zzm(String str, long j10, int i10) {
        zzbt.b(this.f6976a, j10, i10);
    }

    @Override // com.google.android.gms.cast.internal.zzai
    public final void zzn(String str, double d10, boolean z10) {
        zzbt.F.d("Deprecated callback: \"onStatusReceived\"", new Object[0]);
    }

    @Override // com.google.android.gms.cast.internal.zzai
    public final void zzo(final int i10) {
        zzbt.g(this.f6976a).post(new Runnable() { // from class: com.google.android.gms.cast.zzbr
            @Override // java.lang.Runnable
            public final void run() {
                zzbs zzbsVar = this.f6974b;
                zzbt zzbtVar = zzbsVar.f6976a;
                zzbtVar.E = 3;
                int i11 = i10;
                synchronized (zzbtVar.D) {
                    Iterator it = zzbsVar.f6976a.D.iterator();
                    while (it.hasNext()) {
                        ((zzq) it.next()).zzc(i11);
                    }
                }
            }
        });
    }

    @Override // com.google.android.gms.cast.internal.zzai
    public final void zzp(final String str, final String str2) {
        zzbt.F.d("Receive (type=text, ns=%s) %s", str, str2);
        zzbt.g(this.f6976a).post(new Runnable() { // from class: com.google.android.gms.cast.zzbp
            @Override // java.lang.Runnable
            public final void run() {
                Cast.MessageReceivedCallback messageReceivedCallback;
                zzbs zzbsVar = this.f6969b;
                HashMap map = zzbsVar.f6976a.B;
                String str3 = str;
                synchronized (map) {
                    messageReceivedCallback = (Cast.MessageReceivedCallback) zzbsVar.f6976a.B.get(str3);
                }
                if (messageReceivedCallback != null) {
                    messageReceivedCallback.onMessageReceived(zzbsVar.f6976a.f6993z, str3, str2);
                } else {
                    zzbt.F.d("Discarded message for unknown namespace '%s'", str3);
                }
            }
        });
    }
}
