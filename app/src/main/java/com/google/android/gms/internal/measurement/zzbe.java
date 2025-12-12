package com.google.android.gms.internal.measurement;

import java.util.Arrays;
import java.util.Collections;
import java.util.Iterator;
import java.util.List;

/* compiled from: com.google.android.gms:play-services-measurement@@21.6.1 */
/* loaded from: classes.dex */
public final class zzbe {
    private static zzaf zza(zzaf zzafVar, zzh zzhVar, zzal zzalVar, Boolean bool, Boolean bool2) {
        zzaf zzafVar2 = new zzaf();
        Iterator<Integer> itZzg = zzafVar.zzg();
        while (itZzg.hasNext()) {
            int iIntValue = itZzg.next().intValue();
            if (zzafVar.zzc(iIntValue)) {
                zzaq zzaqVarZza = zzalVar.zza(zzhVar, Arrays.asList(zzafVar.zza(iIntValue), new zzai(Double.valueOf(iIntValue)), zzafVar));
                if (zzaqVarZza.zzd().equals(bool)) {
                    return zzafVar2;
                }
                if (bool2 == null || zzaqVarZza.zzd().equals(bool2)) {
                    zzafVar2.zzb(iIntValue, zzaqVarZza);
                }
            }
        }
        return zzafVar2;
    }

    private static zzaf zza(zzaf zzafVar, zzh zzhVar, zzal zzalVar) {
        return zza(zzafVar, zzhVar, zzalVar, null, null);
    }

    /* JADX WARN: Failed to restore switch over string. Please report as a decompilation issue */
    public static zzaq zza(String str, zzaf zzafVar, zzh zzhVar, List<zzaq> list) {
        String strZzf;
        zzal zzalVar;
        double dMin;
        zzh zzhVar2;
        str.getClass();
        char c10 = 65535;
        switch (str.hashCode()) {
            case -1776922004:
                if (str.equals("toString")) {
                    c10 = 0;
                    break;
                }
                break;
            case -1354795244:
                if (str.equals("concat")) {
                    c10 = 1;
                    break;
                }
                break;
            case -1274492040:
                if (str.equals("filter")) {
                    c10 = 2;
                    break;
                }
                break;
            case -934873754:
                if (str.equals("reduce")) {
                    c10 = 3;
                    break;
                }
                break;
            case -895859076:
                if (str.equals("splice")) {
                    c10 = 4;
                    break;
                }
                break;
            case -678635926:
                if (str.equals("forEach")) {
                    c10 = 5;
                    break;
                }
                break;
            case -467511597:
                if (str.equals("lastIndexOf")) {
                    c10 = 6;
                    break;
                }
                break;
            case -277637751:
                if (str.equals("unshift")) {
                    c10 = 7;
                    break;
                }
                break;
            case 107868:
                if (str.equals("map")) {
                    c10 = '\b';
                    break;
                }
                break;
            case 111185:
                if (str.equals("pop")) {
                    c10 = '\t';
                    break;
                }
                break;
            case 3267882:
                if (str.equals("join")) {
                    c10 = '\n';
                    break;
                }
                break;
            case 3452698:
                if (str.equals("push")) {
                    c10 = 11;
                    break;
                }
                break;
            case 3536116:
                if (str.equals("some")) {
                    c10 = '\f';
                    break;
                }
                break;
            case 3536286:
                if (str.equals("sort")) {
                    c10 = '\r';
                    break;
                }
                break;
            case 96891675:
                if (str.equals("every")) {
                    c10 = 14;
                    break;
                }
                break;
            case 109407362:
                if (str.equals("shift")) {
                    c10 = 15;
                    break;
                }
                break;
            case 109526418:
                if (str.equals("slice")) {
                    c10 = 16;
                    break;
                }
                break;
            case 965561430:
                if (str.equals("reduceRight")) {
                    c10 = 17;
                    break;
                }
                break;
            case 1099846370:
                if (str.equals("reverse")) {
                    c10 = 18;
                    break;
                }
                break;
            case 1943291465:
                if (str.equals("indexOf")) {
                    c10 = 19;
                    break;
                }
                break;
        }
        double dZzb = 0.0d;
        switch (c10) {
            case 0:
                zzg.zza("toString", 0, list);
                return new zzas(zzafVar.toString());
            case 1:
                zzaf zzafVar2 = (zzaf) zzafVar.zzc();
                if (!list.isEmpty()) {
                    Iterator<zzaq> it = list.iterator();
                    while (it.hasNext()) {
                        zzaq zzaqVarZza = zzhVar.zza(it.next());
                        if (!(zzaqVarZza instanceof zzaj)) {
                            int iZzb = zzafVar2.zzb();
                            if (zzaqVarZza instanceof zzaf) {
                                zzaf zzafVar3 = (zzaf) zzaqVarZza;
                                Iterator<Integer> itZzg = zzafVar3.zzg();
                                while (itZzg.hasNext()) {
                                    Integer next = itZzg.next();
                                    zzafVar2.zzb(next.intValue() + iZzb, zzafVar3.zza(next.intValue()));
                                }
                            } else {
                                zzafVar2.zzb(iZzb, zzaqVarZza);
                            }
                        } else {
                            throw new IllegalStateException("Failed evaluation of arguments");
                        }
                    }
                }
                return zzafVar2;
            case 2:
                zzg.zza("filter", 1, list);
                zzaq zzaqVarZza2 = zzhVar.zza(list.get(0));
                if (zzaqVarZza2 instanceof zzar) {
                    if (zzafVar.zza() == 0) {
                        return new zzaf();
                    }
                    zzaf zzafVar4 = (zzaf) zzafVar.zzc();
                    zzaf zzafVarZza = zza(zzafVar, zzhVar, (zzar) zzaqVarZza2, null, Boolean.TRUE);
                    zzaf zzafVar5 = new zzaf();
                    Iterator<Integer> itZzg2 = zzafVarZza.zzg();
                    while (itZzg2.hasNext()) {
                        zzafVar5.zza(zzafVar4.zza(itZzg2.next().intValue()));
                    }
                    return zzafVar5;
                }
                throw new IllegalArgumentException("Callback should be a method");
            case 3:
                return zza(zzafVar, zzhVar, list, true);
            case 4:
                if (list.isEmpty()) {
                    return new zzaf();
                }
                int iZza = (int) zzg.zza(zzhVar.zza(list.get(0)).zze().doubleValue());
                if (iZza < 0) {
                    iZza = Math.max(0, zzafVar.zzb() + iZza);
                } else if (iZza > zzafVar.zzb()) {
                    iZza = zzafVar.zzb();
                }
                int iZzb2 = zzafVar.zzb();
                zzaf zzafVar6 = new zzaf();
                if (list.size() <= 1) {
                    while (iZza < iZzb2) {
                        zzafVar6.zza(zzafVar.zza(iZza));
                        zzafVar.zzb(iZza, null);
                        iZza++;
                    }
                    return zzafVar6;
                }
                int iMax = Math.max(0, (int) zzg.zza(zzhVar.zza(list.get(1)).zze().doubleValue()));
                if (iMax > 0) {
                    for (int i10 = iZza; i10 < Math.min(iZzb2, iZza + iMax); i10++) {
                        zzafVar6.zza(zzafVar.zza(iZza));
                        zzafVar.zzb(iZza);
                    }
                }
                if (list.size() > 2) {
                    for (int i11 = 2; i11 < list.size(); i11++) {
                        zzaq zzaqVarZza3 = zzhVar.zza(list.get(i11));
                        if (!(zzaqVarZza3 instanceof zzaj)) {
                            zzafVar.zza((iZza + i11) - 2, zzaqVarZza3);
                        } else {
                            throw new IllegalArgumentException("Failed to parse elements to add");
                        }
                    }
                }
                return zzafVar6;
            case 5:
                zzg.zza("forEach", 1, list);
                zzaq zzaqVarZza4 = zzhVar.zza(list.get(0));
                if (zzaqVarZza4 instanceof zzar) {
                    if (zzafVar.zza() == 0) {
                        return zzaq.zzc;
                    }
                    zza(zzafVar, zzhVar, (zzar) zzaqVarZza4);
                    return zzaq.zzc;
                }
                throw new IllegalArgumentException("Callback should be a method");
            case 6:
                zzg.zzc("lastIndexOf", 2, list);
                zzaq zzaqVarZza5 = zzaq.zzc;
                if (!list.isEmpty()) {
                    zzaqVarZza5 = zzhVar.zza(list.get(0));
                }
                double dZzb2 = zzafVar.zzb() - 1;
                if (list.size() > 1) {
                    zzaq zzaqVarZza6 = zzhVar.zza(list.get(1));
                    if (Double.isNaN(zzaqVarZza6.zze().doubleValue())) {
                        dZzb2 = zzafVar.zzb() - 1;
                    } else {
                        dZzb2 = zzg.zza(zzaqVarZza6.zze().doubleValue());
                    }
                    if (dZzb2 < 0.0d) {
                        dZzb2 += zzafVar.zzb();
                    }
                }
                if (dZzb2 < 0.0d) {
                    return new zzai(Double.valueOf(-1.0d));
                }
                for (int iMin = (int) Math.min(zzafVar.zzb(), dZzb2); iMin >= 0; iMin--) {
                    if (zzafVar.zzc(iMin) && zzg.zza(zzafVar.zza(iMin), zzaqVarZza5)) {
                        return new zzai(Double.valueOf(iMin));
                    }
                }
                return new zzai(Double.valueOf(-1.0d));
            case 7:
                if (!list.isEmpty()) {
                    zzaf zzafVar7 = new zzaf();
                    Iterator<zzaq> it2 = list.iterator();
                    while (it2.hasNext()) {
                        zzaq zzaqVarZza7 = zzhVar.zza(it2.next());
                        if (!(zzaqVarZza7 instanceof zzaj)) {
                            zzafVar7.zza(zzaqVarZza7);
                        } else {
                            throw new IllegalStateException("Argument evaluation failed");
                        }
                    }
                    int iZzb3 = zzafVar7.zzb();
                    Iterator<Integer> itZzg3 = zzafVar.zzg();
                    while (itZzg3.hasNext()) {
                        Integer next2 = itZzg3.next();
                        zzafVar7.zzb(next2.intValue() + iZzb3, zzafVar.zza(next2.intValue()));
                    }
                    zzafVar.zzj();
                    Iterator<Integer> itZzg4 = zzafVar7.zzg();
                    while (itZzg4.hasNext()) {
                        Integer next3 = itZzg4.next();
                        zzafVar.zzb(next3.intValue(), zzafVar7.zza(next3.intValue()));
                    }
                }
                return new zzai(Double.valueOf(zzafVar.zzb()));
            case '\b':
                zzg.zza("map", 1, list);
                zzaq zzaqVarZza8 = zzhVar.zza(list.get(0));
                if (zzaqVarZza8 instanceof zzar) {
                    if (zzafVar.zzb() == 0) {
                        return new zzaf();
                    }
                    return zza(zzafVar, zzhVar, (zzar) zzaqVarZza8);
                }
                throw new IllegalArgumentException("Callback should be a method");
            case '\t':
                zzg.zza("pop", 0, list);
                int iZzb4 = zzafVar.zzb();
                if (iZzb4 == 0) {
                    return zzaq.zzc;
                }
                int i12 = iZzb4 - 1;
                zzaq zzaqVarZza9 = zzafVar.zza(i12);
                zzafVar.zzb(i12);
                return zzaqVarZza9;
            case '\n':
                zzg.zzc("join", 1, list);
                if (zzafVar.zzb() == 0) {
                    return zzaq.zzj;
                }
                if (list.isEmpty()) {
                    strZzf = ",";
                } else {
                    zzaq zzaqVarZza10 = zzhVar.zza(list.get(0));
                    strZzf = ((zzaqVarZza10 instanceof zzao) || (zzaqVarZza10 instanceof zzax)) ? "" : zzaqVarZza10.zzf();
                }
                return new zzas(zzafVar.zzb(strZzf));
            case 11:
                if (!list.isEmpty()) {
                    Iterator<zzaq> it3 = list.iterator();
                    while (it3.hasNext()) {
                        zzafVar.zza(zzhVar.zza(it3.next()));
                    }
                }
                return new zzai(Double.valueOf(zzafVar.zzb()));
            case '\f':
                zzg.zza("some", 1, list);
                zzaq zzaqVarZza11 = zzhVar.zza(list.get(0));
                if (zzaqVarZza11 instanceof zzal) {
                    if (zzafVar.zzb() != 0) {
                        zzal zzalVar2 = (zzal) zzaqVarZza11;
                        Iterator<Integer> itZzg5 = zzafVar.zzg();
                        while (itZzg5.hasNext()) {
                            int iIntValue = itZzg5.next().intValue();
                            if (zzafVar.zzc(iIntValue) && zzalVar2.zza(zzhVar, Arrays.asList(zzafVar.zza(iIntValue), new zzai(Double.valueOf(iIntValue)), zzafVar)).zzd().booleanValue()) {
                                return zzaq.zzh;
                            }
                        }
                    }
                    return zzaq.zzi;
                }
                throw new IllegalArgumentException("Callback should be a method");
            case '\r':
                zzg.zzc("sort", 1, list);
                if (zzafVar.zzb() >= 2) {
                    List<zzaq> listZzi = zzafVar.zzi();
                    if (list.isEmpty()) {
                        zzalVar = null;
                    } else {
                        zzaq zzaqVarZza12 = zzhVar.zza(list.get(0));
                        if (zzaqVarZza12 instanceof zzal) {
                            zzalVar = (zzal) zzaqVarZza12;
                        } else {
                            throw new IllegalArgumentException("Comparator should be a method");
                        }
                    }
                    Collections.sort(listZzi, new zzbh(zzalVar, zzhVar));
                    zzafVar.zzj();
                    Iterator<zzaq> it4 = listZzi.iterator();
                    int i13 = 0;
                    while (it4.hasNext()) {
                        zzafVar.zzb(i13, it4.next());
                        i13++;
                    }
                }
                return zzafVar;
            case 14:
                zzg.zza("every", 1, list);
                zzaq zzaqVarZza13 = zzhVar.zza(list.get(0));
                if (zzaqVarZza13 instanceof zzar) {
                    if (zzafVar.zzb() != 0 && zza(zzafVar, zzhVar, (zzar) zzaqVarZza13, Boolean.FALSE, Boolean.TRUE).zzb() != zzafVar.zzb()) {
                        return zzaq.zzi;
                    }
                    return zzaq.zzh;
                }
                throw new IllegalArgumentException("Callback should be a method");
            case 15:
                zzg.zza("shift", 0, list);
                if (zzafVar.zzb() == 0) {
                    return zzaq.zzc;
                }
                zzaq zzaqVarZza14 = zzafVar.zza(0);
                zzafVar.zzb(0);
                return zzaqVarZza14;
            case 16:
                zzg.zzc("slice", 2, list);
                if (list.isEmpty()) {
                    return zzafVar.zzc();
                }
                double dZzb3 = zzafVar.zzb();
                double dZza = zzg.zza(zzhVar.zza(list.get(0)).zze().doubleValue());
                if (dZza < 0.0d) {
                    dMin = Math.max(dZza + dZzb3, 0.0d);
                } else {
                    dMin = Math.min(dZza, dZzb3);
                }
                if (list.size() == 2) {
                    double dZza2 = zzg.zza(zzhVar.zza(list.get(1)).zze().doubleValue());
                    if (dZza2 < 0.0d) {
                        dZzb3 = Math.max(dZzb3 + dZza2, 0.0d);
                    } else {
                        dZzb3 = Math.min(dZzb3, dZza2);
                    }
                }
                zzaf zzafVar8 = new zzaf();
                for (int i14 = (int) dMin; i14 < dZzb3; i14++) {
                    zzafVar8.zza(zzafVar.zza(i14));
                }
                return zzafVar8;
            case 17:
                return zza(zzafVar, zzhVar, list, false);
            case 18:
                zzg.zza("reverse", 0, list);
                int iZzb5 = zzafVar.zzb();
                if (iZzb5 != 0) {
                    for (int i15 = 0; i15 < iZzb5 / 2; i15++) {
                        if (zzafVar.zzc(i15)) {
                            zzaq zzaqVarZza15 = zzafVar.zza(i15);
                            zzafVar.zzb(i15, null);
                            int i16 = (iZzb5 - 1) - i15;
                            if (zzafVar.zzc(i16)) {
                                zzafVar.zzb(i15, zzafVar.zza(i16));
                            }
                            zzafVar.zzb(i16, zzaqVarZza15);
                        }
                    }
                }
                return zzafVar;
            case 19:
                zzg.zzc("indexOf", 2, list);
                zzaq zzaqVarZza16 = zzaq.zzc;
                if (list.isEmpty()) {
                    zzhVar2 = zzhVar;
                } else {
                    zzhVar2 = zzhVar;
                    zzaqVarZza16 = zzhVar2.zza(list.get(0));
                }
                if (list.size() > 1) {
                    double dZza3 = zzg.zza(zzhVar2.zza(list.get(1)).zze().doubleValue());
                    if (dZza3 >= zzafVar.zzb()) {
                        return new zzai(Double.valueOf(-1.0d));
                    }
                    dZzb = dZza3 < 0.0d ? zzafVar.zzb() + dZza3 : dZza3;
                }
                Iterator<Integer> itZzg6 = zzafVar.zzg();
                while (itZzg6.hasNext()) {
                    int iIntValue2 = itZzg6.next().intValue();
                    double d10 = iIntValue2;
                    if (d10 >= dZzb && zzg.zza(zzafVar.zza(iIntValue2), zzaqVarZza16)) {
                        return new zzai(Double.valueOf(d10));
                    }
                }
                return new zzai(Double.valueOf(-1.0d));
            default:
                throw new IllegalArgumentException("Command not supported");
        }
    }

    private static zzaq zza(zzaf zzafVar, zzh zzhVar, List<zzaq> list, boolean z10) {
        zzaq zzaqVarZza;
        zzg.zzb("reduce", 1, list);
        zzg.zzc("reduce", 2, list);
        zzaq zzaqVarZza2 = zzhVar.zza(list.get(0));
        if (zzaqVarZza2 instanceof zzal) {
            if (list.size() == 2) {
                zzaqVarZza = zzhVar.zza(list.get(1));
                if (zzaqVarZza instanceof zzaj) {
                    throw new IllegalArgumentException("Failed to parse initial value");
                }
            } else {
                if (zzafVar.zzb() == 0) {
                    throw new IllegalStateException("Empty array with no initial value error");
                }
                zzaqVarZza = null;
            }
            zzal zzalVar = (zzal) zzaqVarZza2;
            int iZzb = zzafVar.zzb();
            int i10 = z10 ? 0 : iZzb - 1;
            int i11 = z10 ? iZzb - 1 : 0;
            int i12 = z10 ? 1 : -1;
            if (zzaqVarZza == null) {
                zzaqVarZza = zzafVar.zza(i10);
                i10 += i12;
            }
            while ((i11 - i10) * i12 >= 0) {
                if (zzafVar.zzc(i10)) {
                    zzaqVarZza = zzalVar.zza(zzhVar, Arrays.asList(zzaqVarZza, zzafVar.zza(i10), new zzai(Double.valueOf(i10)), zzafVar));
                    if (zzaqVarZza instanceof zzaj) {
                        throw new IllegalStateException("Reduce operation failed");
                    }
                    i10 += i12;
                } else {
                    i10 += i12;
                }
            }
            return zzaqVarZza;
        }
        throw new IllegalArgumentException("Callback should be a method");
    }
}
