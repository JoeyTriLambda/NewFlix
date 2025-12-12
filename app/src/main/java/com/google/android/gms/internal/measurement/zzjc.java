package com.google.android.gms.internal.measurement;

import java.io.IOException;
import java.util.List;
import java.util.Map;

/* compiled from: com.google.android.gms:play-services-measurement-base@@21.6.1 */
/* loaded from: classes.dex */
final class zzjc implements zznt {
    private final zzja zza;

    private zzjc(zzja zzjaVar) {
        zzja zzjaVar2 = (zzja) zzjw.zza(zzjaVar, "output");
        this.zza = zzjaVar2;
        zzjaVar2.zza = this;
    }

    public static zzjc zza(zzja zzjaVar) {
        zzjc zzjcVar = zzjaVar.zza;
        return zzjcVar != null ? zzjcVar : new zzjc(zzjaVar);
    }

    @Override // com.google.android.gms.internal.measurement.zznt
    public final void zzb(int i10, List<Double> list, boolean z10) throws IOException {
        int i11 = 0;
        if (!z10) {
            while (i11 < list.size()) {
                this.zza.zzb(i10, list.get(i11).doubleValue());
                i11++;
            }
            return;
        }
        this.zza.zzj(i10, 2);
        int iZza = 0;
        for (int i12 = 0; i12 < list.size(); i12++) {
            iZza += zzja.zza(list.get(i12).doubleValue());
        }
        this.zza.zzk(iZza);
        while (i11 < list.size()) {
            this.zza.zzb(list.get(i11).doubleValue());
            i11++;
        }
    }

    @Override // com.google.android.gms.internal.measurement.zznt
    public final void zzc(int i10, List<Integer> list, boolean z10) throws IOException {
        int i11 = 0;
        if (!z10) {
            while (i11 < list.size()) {
                this.zza.zzh(i10, list.get(i11).intValue());
                i11++;
            }
            return;
        }
        this.zza.zzj(i10, 2);
        int iZza = 0;
        for (int i12 = 0; i12 < list.size(); i12++) {
            iZza += zzja.zza(list.get(i12).intValue());
        }
        this.zza.zzk(iZza);
        while (i11 < list.size()) {
            this.zza.zzi(list.get(i11).intValue());
            i11++;
        }
    }

    @Override // com.google.android.gms.internal.measurement.zznt
    public final void zzd(int i10, List<Integer> list, boolean z10) throws IOException {
        int i11 = 0;
        if (!z10) {
            while (i11 < list.size()) {
                this.zza.zzg(i10, list.get(i11).intValue());
                i11++;
            }
            return;
        }
        this.zza.zzj(i10, 2);
        int iZzb = 0;
        for (int i12 = 0; i12 < list.size(); i12++) {
            iZzb += zzja.zzb(list.get(i12).intValue());
        }
        this.zza.zzk(iZzb);
        while (i11 < list.size()) {
            this.zza.zzh(list.get(i11).intValue());
            i11++;
        }
    }

    @Override // com.google.android.gms.internal.measurement.zznt
    public final void zze(int i10, List<Long> list, boolean z10) throws IOException {
        int i11 = 0;
        if (!z10) {
            while (i11 < list.size()) {
                this.zza.zzf(i10, list.get(i11).longValue());
                i11++;
            }
            return;
        }
        this.zza.zzj(i10, 2);
        int iZza = 0;
        for (int i12 = 0; i12 < list.size(); i12++) {
            iZza += zzja.zza(list.get(i12).longValue());
        }
        this.zza.zzk(iZza);
        while (i11 < list.size()) {
            this.zza.zzf(list.get(i11).longValue());
            i11++;
        }
    }

    @Override // com.google.android.gms.internal.measurement.zznt
    public final void zzf(int i10, List<Float> list, boolean z10) throws IOException {
        int i11 = 0;
        if (!z10) {
            while (i11 < list.size()) {
                this.zza.zzb(i10, list.get(i11).floatValue());
                i11++;
            }
            return;
        }
        this.zza.zzj(i10, 2);
        int iZza = 0;
        for (int i12 = 0; i12 < list.size(); i12++) {
            iZza += zzja.zza(list.get(i12).floatValue());
        }
        this.zza.zzk(iZza);
        while (i11 < list.size()) {
            this.zza.zzb(list.get(i11).floatValue());
            i11++;
        }
    }

    @Override // com.google.android.gms.internal.measurement.zznt
    public final void zzg(int i10, List<Integer> list, boolean z10) throws IOException {
        int i11 = 0;
        if (!z10) {
            while (i11 < list.size()) {
                this.zza.zzh(i10, list.get(i11).intValue());
                i11++;
            }
            return;
        }
        this.zza.zzj(i10, 2);
        int iZzc = 0;
        for (int i12 = 0; i12 < list.size(); i12++) {
            iZzc += zzja.zzc(list.get(i12).intValue());
        }
        this.zza.zzk(iZzc);
        while (i11 < list.size()) {
            this.zza.zzi(list.get(i11).intValue());
            i11++;
        }
    }

    @Override // com.google.android.gms.internal.measurement.zznt
    public final void zzh(int i10, List<Long> list, boolean z10) throws IOException {
        int i11 = 0;
        if (!z10) {
            while (i11 < list.size()) {
                this.zza.zzh(i10, list.get(i11).longValue());
                i11++;
            }
            return;
        }
        this.zza.zzj(i10, 2);
        int iZzb = 0;
        for (int i12 = 0; i12 < list.size(); i12++) {
            iZzb += zzja.zzb(list.get(i12).longValue());
        }
        this.zza.zzk(iZzb);
        while (i11 < list.size()) {
            this.zza.zzh(list.get(i11).longValue());
            i11++;
        }
    }

    @Override // com.google.android.gms.internal.measurement.zznt
    public final void zzi(int i10, List<Integer> list, boolean z10) throws IOException {
        int i11 = 0;
        if (!z10) {
            while (i11 < list.size()) {
                this.zza.zzg(i10, list.get(i11).intValue());
                i11++;
            }
            return;
        }
        this.zza.zzj(i10, 2);
        int iZzd = 0;
        for (int i12 = 0; i12 < list.size(); i12++) {
            iZzd += zzja.zzd(list.get(i12).intValue());
        }
        this.zza.zzk(iZzd);
        while (i11 < list.size()) {
            this.zza.zzh(list.get(i11).intValue());
            i11++;
        }
    }

    @Override // com.google.android.gms.internal.measurement.zznt
    public final void zzj(int i10, List<Long> list, boolean z10) throws IOException {
        int i11 = 0;
        if (!z10) {
            while (i11 < list.size()) {
                this.zza.zzf(i10, list.get(i11).longValue());
                i11++;
            }
            return;
        }
        this.zza.zzj(i10, 2);
        int iZzc = 0;
        for (int i12 = 0; i12 < list.size(); i12++) {
            iZzc += zzja.zzc(list.get(i12).longValue());
        }
        this.zza.zzk(iZzc);
        while (i11 < list.size()) {
            this.zza.zzf(list.get(i11).longValue());
            i11++;
        }
    }

    @Override // com.google.android.gms.internal.measurement.zznt
    public final void zzk(int i10, List<Integer> list, boolean z10) throws IOException {
        int i11 = 0;
        if (!z10) {
            while (i11 < list.size()) {
                this.zza.zzi(i10, list.get(i11).intValue());
                i11++;
            }
            return;
        }
        this.zza.zzj(i10, 2);
        int iZze = 0;
        for (int i12 = 0; i12 < list.size(); i12++) {
            iZze += zzja.zze(list.get(i12).intValue());
        }
        this.zza.zzk(iZze);
        while (i11 < list.size()) {
            this.zza.zzj(list.get(i11).intValue());
            i11++;
        }
    }

    @Override // com.google.android.gms.internal.measurement.zznt
    public final void zzl(int i10, List<Long> list, boolean z10) throws IOException {
        int i11 = 0;
        if (!z10) {
            while (i11 < list.size()) {
                this.zza.zzg(i10, list.get(i11).longValue());
                i11++;
            }
            return;
        }
        this.zza.zzj(i10, 2);
        int iZzd = 0;
        for (int i12 = 0; i12 < list.size(); i12++) {
            iZzd += zzja.zzd(list.get(i12).longValue());
        }
        this.zza.zzk(iZzd);
        while (i11 < list.size()) {
            this.zza.zzg(list.get(i11).longValue());
            i11++;
        }
    }

    @Override // com.google.android.gms.internal.measurement.zznt
    public final void zzm(int i10, List<Integer> list, boolean z10) throws IOException {
        int i11 = 0;
        if (!z10) {
            while (i11 < list.size()) {
                this.zza.zzk(i10, list.get(i11).intValue());
                i11++;
            }
            return;
        }
        this.zza.zzj(i10, 2);
        int iZzg = 0;
        for (int i12 = 0; i12 < list.size(); i12++) {
            iZzg += zzja.zzg(list.get(i12).intValue());
        }
        this.zza.zzk(iZzg);
        while (i11 < list.size()) {
            this.zza.zzk(list.get(i11).intValue());
            i11++;
        }
    }

    @Override // com.google.android.gms.internal.measurement.zznt
    public final void zzn(int i10, List<Long> list, boolean z10) throws IOException {
        int i11 = 0;
        if (!z10) {
            while (i11 < list.size()) {
                this.zza.zzh(i10, list.get(i11).longValue());
                i11++;
            }
            return;
        }
        this.zza.zzj(i10, 2);
        int iZze = 0;
        for (int i12 = 0; i12 < list.size(); i12++) {
            iZze += zzja.zze(list.get(i12).longValue());
        }
        this.zza.zzk(iZze);
        while (i11 < list.size()) {
            this.zza.zzh(list.get(i11).longValue());
            i11++;
        }
    }

    @Override // com.google.android.gms.internal.measurement.zznt
    public final int zza() {
        return zzns.zza;
    }

    @Override // com.google.android.gms.internal.measurement.zznt
    public final void zza(int i10, boolean z10) throws IOException {
        this.zza.zzb(i10, z10);
    }

    @Override // com.google.android.gms.internal.measurement.zznt
    public final void zza(int i10, List<Boolean> list, boolean z10) throws IOException {
        int i11 = 0;
        if (z10) {
            this.zza.zzj(i10, 2);
            int iZza = 0;
            for (int i12 = 0; i12 < list.size(); i12++) {
                iZza += zzja.zza(list.get(i12).booleanValue());
            }
            this.zza.zzk(iZza);
            while (i11 < list.size()) {
                this.zza.zzb(list.get(i11).booleanValue());
                i11++;
            }
            return;
        }
        while (i11 < list.size()) {
            this.zza.zzb(i10, list.get(i11).booleanValue());
            i11++;
        }
    }

    @Override // com.google.android.gms.internal.measurement.zznt
    public final void zzb(int i10, int i11) throws IOException {
        this.zza.zzg(i10, i11);
    }

    @Override // com.google.android.gms.internal.measurement.zznt
    public final void zzd(int i10, int i11) throws IOException {
        this.zza.zzg(i10, i11);
    }

    @Override // com.google.android.gms.internal.measurement.zznt
    public final void zze(int i10, int i11) throws IOException {
        this.zza.zzi(i10, i11);
    }

    @Override // com.google.android.gms.internal.measurement.zznt
    public final void zzf(int i10, int i11) throws IOException {
        this.zza.zzk(i10, i11);
    }

    @Override // com.google.android.gms.internal.measurement.zznt
    public final void zzb(int i10, long j10) throws IOException {
        this.zza.zzh(i10, j10);
    }

    @Override // com.google.android.gms.internal.measurement.zznt
    public final void zze(int i10, long j10) throws IOException {
        this.zza.zzh(i10, j10);
    }

    @Override // com.google.android.gms.internal.measurement.zznt
    public final void zzc(int i10, int i11) throws IOException {
        this.zza.zzh(i10, i11);
    }

    @Override // com.google.android.gms.internal.measurement.zznt
    public final void zzd(int i10, long j10) throws IOException {
        this.zza.zzg(i10, j10);
    }

    @Override // com.google.android.gms.internal.measurement.zznt
    public final void zzb(int i10, Object obj, zzly zzlyVar) throws IOException {
        this.zza.zzc(i10, (zzlg) obj, zzlyVar);
    }

    @Override // com.google.android.gms.internal.measurement.zznt
    public final void zzc(int i10, long j10) throws IOException {
        this.zza.zzf(i10, j10);
    }

    @Override // com.google.android.gms.internal.measurement.zznt
    public final void zza(int i10, zzij zzijVar) throws IOException {
        this.zza.zzc(i10, zzijVar);
    }

    @Override // com.google.android.gms.internal.measurement.zznt
    public final void zzb(int i10, List<?> list, zzly zzlyVar) throws IOException {
        for (int i11 = 0; i11 < list.size(); i11++) {
            zzb(i10, list.get(i11), zzlyVar);
        }
    }

    @Override // com.google.android.gms.internal.measurement.zznt
    public final void zza(int i10, List<zzij> list) throws IOException {
        for (int i11 = 0; i11 < list.size(); i11++) {
            this.zza.zzc(i10, list.get(i11));
        }
    }

    @Override // com.google.android.gms.internal.measurement.zznt
    @Deprecated
    public final void zzb(int i10) throws IOException {
        this.zza.zzj(i10, 3);
    }

    @Override // com.google.android.gms.internal.measurement.zznt
    public final void zza(int i10, double d10) throws IOException {
        this.zza.zzb(i10, d10);
    }

    @Override // com.google.android.gms.internal.measurement.zznt
    public final void zzb(int i10, List<String> list) throws IOException {
        int i11 = 0;
        if (list instanceof zzkm) {
            zzkm zzkmVar = (zzkm) list;
            while (i11 < list.size()) {
                Object objZzb = zzkmVar.zzb(i11);
                if (objZzb instanceof String) {
                    this.zza.zzb(i10, (String) objZzb);
                } else {
                    this.zza.zzc(i10, (zzij) objZzb);
                }
                i11++;
            }
            return;
        }
        while (i11 < list.size()) {
            this.zza.zzb(i10, list.get(i11));
            i11++;
        }
    }

    @Override // com.google.android.gms.internal.measurement.zznt
    @Deprecated
    public final void zza(int i10) throws IOException {
        this.zza.zzj(i10, 4);
    }

    @Override // com.google.android.gms.internal.measurement.zznt
    public final void zza(int i10, int i11) throws IOException {
        this.zza.zzh(i10, i11);
    }

    @Override // com.google.android.gms.internal.measurement.zznt
    public final void zza(int i10, long j10) throws IOException {
        this.zza.zzf(i10, j10);
    }

    @Override // com.google.android.gms.internal.measurement.zznt
    public final void zza(int i10, float f10) throws IOException {
        this.zza.zzb(i10, f10);
    }

    @Override // com.google.android.gms.internal.measurement.zznt
    public final void zza(int i10, Object obj, zzly zzlyVar) throws IOException {
        zzja zzjaVar = this.zza;
        zzjaVar.zzj(i10, 3);
        zzlyVar.zza((zzly) obj, (zznt) zzjaVar.zza);
        zzjaVar.zzj(i10, 4);
    }

    @Override // com.google.android.gms.internal.measurement.zznt
    public final void zza(int i10, List<?> list, zzly zzlyVar) throws IOException {
        for (int i11 = 0; i11 < list.size(); i11++) {
            zza(i10, list.get(i11), zzlyVar);
        }
    }

    @Override // com.google.android.gms.internal.measurement.zznt
    public final <K, V> void zza(int i10, zzkx<K, V> zzkxVar, Map<K, V> map) throws IOException {
        for (Map.Entry<K, V> entry : map.entrySet()) {
            this.zza.zzj(i10, 2);
            this.zza.zzk(zzky.zza(zzkxVar, entry.getKey(), entry.getValue()));
            zzky.zza(this.zza, zzkxVar, entry.getKey(), entry.getValue());
        }
    }

    @Override // com.google.android.gms.internal.measurement.zznt
    public final void zza(int i10, Object obj) throws IOException {
        if (obj instanceof zzij) {
            this.zza.zzd(i10, (zzij) obj);
        } else {
            this.zza.zzb(i10, (zzlg) obj);
        }
    }

    @Override // com.google.android.gms.internal.measurement.zznt
    public final void zza(int i10, String str) throws IOException {
        this.zza.zzb(i10, str);
    }
}
