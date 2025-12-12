package com.google.android.gms.measurement.internal;

import com.google.android.gms.measurement.internal.zziq;
import java.util.EnumMap;

/* compiled from: com.google.android.gms:play-services-measurement@@21.6.1 */
/* loaded from: classes.dex */
final class zzaj {

    /* renamed from: a, reason: collision with root package name */
    public final EnumMap<zziq.zza, zzai> f7655a;

    public zzaj() {
        this.f7655a = new EnumMap<>(zziq.zza.class);
    }

    public final String toString() {
        StringBuilder sb2 = new StringBuilder("1");
        for (zziq.zza zzaVar : zziq.zza.values()) {
            zzai zzaiVar = this.f7655a.get(zzaVar);
            if (zzaiVar == null) {
                zzaiVar = zzai.UNSET;
            }
            sb2.append(zzaiVar.f7654b);
        }
        return sb2.toString();
    }

    public final zzai zza(zziq.zza zzaVar) {
        zzai zzaiVar = this.f7655a.get(zzaVar);
        return zzaiVar == null ? zzai.UNSET : zzaiVar;
    }

    public zzaj(EnumMap<zziq.zza, zzai> enumMap) {
        EnumMap<zziq.zza, zzai> enumMap2 = new EnumMap<>(zziq.zza.class);
        this.f7655a = enumMap2;
        enumMap2.putAll(enumMap);
    }

    public static zzaj zza(String str) {
        EnumMap enumMap = new EnumMap(zziq.zza.class);
        if (str.length() >= zziq.zza.values().length) {
            int i10 = 0;
            if (str.charAt(0) == '1') {
                zziq.zza[] zzaVarArrValues = zziq.zza.values();
                int length = zzaVarArrValues.length;
                int i11 = 1;
                while (i10 < length) {
                    enumMap.put((EnumMap) zzaVarArrValues[i10], (zziq.zza) zzai.zza(str.charAt(i11)));
                    i10++;
                    i11++;
                }
                return new zzaj(enumMap);
            }
        }
        return new zzaj();
    }

    /* JADX WARN: Removed duplicated region for block: B:14:0x001b  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public final void zza(com.google.android.gms.measurement.internal.zziq.zza r3, int r4) {
        /*
            r2 = this;
            com.google.android.gms.measurement.internal.zzai r0 = com.google.android.gms.measurement.internal.zzai.UNSET
            r1 = -30
            if (r4 == r1) goto L1e
            r1 = -20
            if (r4 == r1) goto L1b
            r1 = -10
            if (r4 == r1) goto L18
            if (r4 == 0) goto L1b
            r1 = 30
            if (r4 == r1) goto L15
            goto L20
        L15:
            com.google.android.gms.measurement.internal.zzai r0 = com.google.android.gms.measurement.internal.zzai.INITIALIZATION
            goto L20
        L18:
            com.google.android.gms.measurement.internal.zzai r0 = com.google.android.gms.measurement.internal.zzai.MANIFEST
            goto L20
        L1b:
            com.google.android.gms.measurement.internal.zzai r0 = com.google.android.gms.measurement.internal.zzai.API
            goto L20
        L1e:
            com.google.android.gms.measurement.internal.zzai r0 = com.google.android.gms.measurement.internal.zzai.TCF
        L20:
            java.util.EnumMap<com.google.android.gms.measurement.internal.zziq$zza, com.google.android.gms.measurement.internal.zzai> r4 = r2.f7655a
            r4.put(r3, r0)
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.gms.measurement.internal.zzaj.zza(com.google.android.gms.measurement.internal.zziq$zza, int):void");
    }

    public final void zza(zziq.zza zzaVar, zzai zzaiVar) {
        this.f7655a.put((EnumMap<zziq.zza, zzai>) zzaVar, (zziq.zza) zzaiVar);
    }
}
