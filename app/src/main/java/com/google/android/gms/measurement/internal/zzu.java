package com.google.android.gms.measurement.internal;

import b0.b;
import com.google.android.gms.internal.measurement.zzft;
import com.google.android.gms.internal.measurement.zzou;
import java.util.ArrayList;
import java.util.BitSet;
import java.util.Collections;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

/* compiled from: com.google.android.gms:play-services-measurement@@21.6.1 */
/* loaded from: classes.dex */
final class zzu {

    /* renamed from: a, reason: collision with root package name */
    public final String f8617a;

    /* renamed from: b, reason: collision with root package name */
    public final boolean f8618b;

    /* renamed from: c, reason: collision with root package name */
    public final zzft.zzl f8619c;

    /* renamed from: d, reason: collision with root package name */
    public final BitSet f8620d;

    /* renamed from: e, reason: collision with root package name */
    public final BitSet f8621e;

    /* renamed from: f, reason: collision with root package name */
    public final Map<Integer, Long> f8622f;

    /* renamed from: g, reason: collision with root package name */
    public final b f8623g;

    /* renamed from: h, reason: collision with root package name */
    public final /* synthetic */ zzs f8624h;

    public zzu() {
        throw null;
    }

    public zzu(zzs zzsVar, String str) {
        this.f8624h = zzsVar;
        this.f8617a = str;
        this.f8618b = true;
        this.f8620d = new BitSet();
        this.f8621e = new BitSet();
        this.f8622f = new b();
        this.f8623g = new b();
    }

    public final zzft.zzc a(int i10) {
        ArrayList arrayList;
        List listEmptyList;
        zzft.zzc.zza zzaVarZzb = zzft.zzc.zzb();
        zzaVarZzb.zza(i10);
        zzaVarZzb.zza(this.f8618b);
        zzft.zzl zzlVar = this.f8619c;
        if (zzlVar != null) {
            zzaVarZzb.zza(zzlVar);
        }
        zzft.zzl.zza zzaVarZzd = zzft.zzl.zze().zzb(zznm.n(this.f8620d)).zzd(zznm.n(this.f8621e));
        Map<Integer, Long> map = this.f8622f;
        if (map == null) {
            arrayList = null;
        } else {
            ArrayList arrayList2 = new ArrayList(map.size());
            Iterator<Integer> it = map.keySet().iterator();
            while (it.hasNext()) {
                int iIntValue = it.next().intValue();
                Long l10 = map.get(Integer.valueOf(iIntValue));
                if (l10 != null) {
                    arrayList2.add((zzft.zzd) ((com.google.android.gms.internal.measurement.zzjt) zzft.zzd.zzc().zza(iIntValue).zza(l10.longValue()).zzah()));
                }
            }
            arrayList = arrayList2;
        }
        if (arrayList != null) {
            zzaVarZzd.zza(arrayList);
        }
        b bVar = this.f8623g;
        if (bVar == null) {
            listEmptyList = Collections.emptyList();
        } else {
            ArrayList arrayList3 = new ArrayList(bVar.size());
            for (Integer num : bVar.keySet()) {
                zzft.zzm.zza zzaVarZza = zzft.zzm.zzc().zza(num.intValue());
                List list = (List) bVar.get(num);
                if (list != null) {
                    Collections.sort(list);
                    zzaVarZza.zza(list);
                }
                arrayList3.add((zzft.zzm) ((com.google.android.gms.internal.measurement.zzjt) zzaVarZza.zzah()));
            }
            listEmptyList = arrayList3;
        }
        zzaVarZzd.zzc(listEmptyList);
        zzaVarZzb.zza(zzaVarZzd);
        return (zzft.zzc) ((com.google.android.gms.internal.measurement.zzjt) zzaVarZzb.zzah());
    }

    public final void b(zzab zzabVar) {
        int iA = zzabVar.a();
        Boolean bool = zzabVar.f7623c;
        if (bool != null) {
            this.f8621e.set(iA, bool.booleanValue());
        }
        Boolean bool2 = zzabVar.f7624d;
        if (bool2 != null) {
            this.f8620d.set(iA, bool2.booleanValue());
        }
        if (zzabVar.f7625e != null) {
            Integer numValueOf = Integer.valueOf(iA);
            Map<Integer, Long> map = this.f8622f;
            Long l10 = map.get(numValueOf);
            long jLongValue = zzabVar.f7625e.longValue() / 1000;
            if (l10 == null || jLongValue > l10.longValue()) {
                map.put(Integer.valueOf(iA), Long.valueOf(jLongValue));
            }
        }
        if (zzabVar.f7626f != null) {
            Integer numValueOf2 = Integer.valueOf(iA);
            b bVar = this.f8623g;
            List arrayList = (List) bVar.get(numValueOf2);
            if (arrayList == null) {
                arrayList = new ArrayList();
                bVar.put(Integer.valueOf(iA), arrayList);
            }
            if (zzabVar.f()) {
                arrayList.clear();
            }
            boolean zZza = zzou.zza();
            String str = this.f8617a;
            zzs zzsVar = this.f8624h;
            if (zZza && zzsVar.zze().zzf(str, zzbh.f7744i0) && zzabVar.e()) {
                arrayList.clear();
            }
            if (!zzou.zza() || !zzsVar.zze().zzf(str, zzbh.f7744i0)) {
                arrayList.add(Long.valueOf(zzabVar.f7626f.longValue() / 1000));
                return;
            }
            long jLongValue2 = zzabVar.f7626f.longValue() / 1000;
            if (arrayList.contains(Long.valueOf(jLongValue2))) {
                return;
            }
            arrayList.add(Long.valueOf(jLongValue2));
        }
    }

    /* JADX WARN: Multi-variable type inference failed */
    public zzu(zzs zzsVar, String str, zzft.zzl zzlVar, BitSet bitSet, BitSet bitSet2, b bVar, b bVar2) {
        this.f8624h = zzsVar;
        this.f8617a = str;
        this.f8620d = bitSet;
        this.f8621e = bitSet2;
        this.f8622f = bVar;
        this.f8623g = new b();
        for (K k10 : bVar2.keySet()) {
            ArrayList arrayList = new ArrayList();
            arrayList.add((Long) bVar2.get(k10));
            this.f8623g.put(k10, arrayList);
        }
        this.f8618b = false;
        this.f8619c = zzlVar;
    }
}
