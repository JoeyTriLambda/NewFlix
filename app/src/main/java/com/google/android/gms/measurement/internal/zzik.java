package com.google.android.gms.measurement.internal;

import android.database.sqlite.SQLiteException;
import android.os.Bundle;
import com.google.android.gms.common.internal.Preconditions;
import com.google.android.gms.internal.measurement.zzpy;
import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.Callable;

/* compiled from: com.google.android.gms:play-services-measurement@@21.6.1 */
/* loaded from: classes.dex */
final class zzik implements Callable<List<zzmv>> {

    /* renamed from: b, reason: collision with root package name */
    public final /* synthetic */ zzn f8185b;

    /* renamed from: m, reason: collision with root package name */
    public final /* synthetic */ Bundle f8186m;

    /* renamed from: n, reason: collision with root package name */
    public final /* synthetic */ zzhs f8187n;

    public zzik(zzhs zzhsVar, zzn zznVar, Bundle bundle) {
        this.f8185b = zznVar;
        this.f8186m = bundle;
        this.f8187n = zzhsVar;
    }

    @Override // java.util.concurrent.Callable
    public final /* synthetic */ List<zzmv> call() throws Exception {
        String str;
        zzhs zzhsVar = this.f8187n;
        zzhsVar.f8127a.J();
        zznd zzndVar = zzhsVar.f8127a;
        zzndVar.zzl().zzt();
        if (zzpy.zza()) {
            zzae zzaeVarZze = zzndVar.zze();
            zzn zznVar = this.f8185b;
            if (zzaeVarZze.zze(zznVar.f8526b, zzbh.E0) && (str = zznVar.f8526b) != null) {
                Bundle bundle = this.f8186m;
                if (bundle != null) {
                    int[] intArray = bundle.getIntArray("uriSources");
                    long[] longArray = bundle.getLongArray("uriTimestamps");
                    if (intArray != null) {
                        if (longArray == null || longArray.length != intArray.length) {
                            zzndVar.zzj().zzg().zza("Uri sources and timestamps do not match");
                        } else {
                            for (int i10 = 0; i10 < intArray.length; i10++) {
                                zzan zzanVarZzf = zzndVar.zzf();
                                int i11 = intArray[i10];
                                long j10 = longArray[i10];
                                Preconditions.checkNotEmpty(str);
                                zzanVarZzf.zzt();
                                zzanVarZzf.zzak();
                                try {
                                    int iDelete = zzanVarZzf.a().delete("trigger_uris", "app_id=? and source=? and timestamp_millis<=?", new String[]{str, String.valueOf(i11), String.valueOf(j10)});
                                    zzanVarZzf.zzj().zzp().zza("Pruned " + iDelete + " trigger URIs. appId, source, timestamp", str, Integer.valueOf(i11), Long.valueOf(j10));
                                } catch (SQLiteException e10) {
                                    zzanVarZzf.zzj().zzg().zza("Error pruning trigger URIs. appId", zzgb.zza(str), e10);
                                }
                            }
                        }
                    }
                }
                return zzndVar.zzf().zzi(str);
            }
        }
        return new ArrayList();
    }
}
