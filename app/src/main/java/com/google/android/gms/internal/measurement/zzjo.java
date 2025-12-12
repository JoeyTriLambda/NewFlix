package com.google.android.gms.internal.measurement;

import java.lang.reflect.Type;

/* JADX WARN: Enum visitor error
jadx.core.utils.exceptions.JadxRuntimeException: Init of enum field 'zzc' uses external variables
	at jadx.core.dex.visitors.EnumVisitor.createEnumFieldByConstructor(EnumVisitor.java:451)
	at jadx.core.dex.visitors.EnumVisitor.processEnumFieldByRegister(EnumVisitor.java:395)
	at jadx.core.dex.visitors.EnumVisitor.extractEnumFieldsFromFilledArray(EnumVisitor.java:324)
	at jadx.core.dex.visitors.EnumVisitor.extractEnumFieldsFromInsn(EnumVisitor.java:262)
	at jadx.core.dex.visitors.EnumVisitor.convertToEnum(EnumVisitor.java:151)
	at jadx.core.dex.visitors.EnumVisitor.visit(EnumVisitor.java:100)
 */
/* JADX WARN: Failed to restore enum class, 'enum' modifier and super class removed */
/* compiled from: com.google.android.gms:play-services-measurement-base@@21.6.1 */
/* loaded from: classes.dex */
public final class zzjo {
    public static final zzjo zza;
    private static final zzjo zzaa;
    private static final zzjo zzab;
    private static final zzjo zzac;
    private static final zzjo zzad;
    private static final zzjo zzae;
    private static final zzjo zzaf;
    private static final zzjo zzag;
    private static final zzjo zzah;
    private static final zzjo zzai;
    private static final zzjo zzaj;
    private static final zzjo zzak;
    private static final zzjo zzal;
    private static final zzjo zzam;
    private static final zzjo zzan;
    private static final zzjo zzao;
    private static final zzjo zzap;
    private static final zzjo zzaq;
    private static final zzjo zzar;
    private static final zzjo zzas;
    private static final zzjo zzat;
    private static final zzjo zzau;
    private static final zzjo zzav;
    private static final zzjo zzaw;
    private static final zzjo zzax;
    private static final zzjo zzay;
    private static final zzjo[] zzaz;
    public static final zzjo zzb;
    private static final Type[] zzba;
    private static final /* synthetic */ zzjo[] zzbb;
    private static final zzjo zzc;
    private static final zzjo zzd;
    private static final zzjo zze;
    private static final zzjo zzf;
    private static final zzjo zzg;
    private static final zzjo zzh;
    private static final zzjo zzi;
    private static final zzjo zzj;
    private static final zzjo zzk;
    private static final zzjo zzl;
    private static final zzjo zzm;
    private static final zzjo zzn;
    private static final zzjo zzo;
    private static final zzjo zzp;
    private static final zzjo zzq;
    private static final zzjo zzr;
    private static final zzjo zzs;
    private static final zzjo zzt;
    private static final zzjo zzu;
    private static final zzjo zzv;
    private static final zzjo zzw;
    private static final zzjo zzx;
    private static final zzjo zzy;
    private static final zzjo zzz;
    private final zzkd zzbc;
    private final int zzbd;
    private final zzjq zzbe;
    private final Class<?> zzbf;
    private final boolean zzbg;

    static {
        zzjq zzjqVar = zzjq.SCALAR;
        zzkd zzkdVar = zzkd.zze;
        zzjo zzjoVar = new zzjo("DOUBLE", 0, 0, zzjqVar, zzkdVar);
        zzc = zzjoVar;
        zzkd zzkdVar2 = zzkd.zzd;
        zzjo zzjoVar2 = new zzjo("FLOAT", 1, 1, zzjqVar, zzkdVar2);
        zzd = zzjoVar2;
        zzkd zzkdVar3 = zzkd.zzc;
        zzjo zzjoVar3 = new zzjo("INT64", 2, 2, zzjqVar, zzkdVar3);
        zze = zzjoVar3;
        zzjo zzjoVar4 = new zzjo("UINT64", 3, 3, zzjqVar, zzkdVar3);
        zzf = zzjoVar4;
        zzkd zzkdVar4 = zzkd.zzb;
        zzjo zzjoVar5 = new zzjo("INT32", 4, 4, zzjqVar, zzkdVar4);
        zzg = zzjoVar5;
        zzjo zzjoVar6 = new zzjo("FIXED64", 5, 5, zzjqVar, zzkdVar3);
        zzh = zzjoVar6;
        zzjo zzjoVar7 = new zzjo("FIXED32", 6, 6, zzjqVar, zzkdVar4);
        zzi = zzjoVar7;
        zzkd zzkdVar5 = zzkd.zzf;
        zzjo zzjoVar8 = new zzjo("BOOL", 7, 7, zzjqVar, zzkdVar5);
        zzj = zzjoVar8;
        zzkd zzkdVar6 = zzkd.zzg;
        zzjo zzjoVar9 = new zzjo("STRING", 8, 8, zzjqVar, zzkdVar6);
        zzk = zzjoVar9;
        zzkd zzkdVar7 = zzkd.zzj;
        zzjo zzjoVar10 = new zzjo("MESSAGE", 9, 9, zzjqVar, zzkdVar7);
        zzl = zzjoVar10;
        zzkd zzkdVar8 = zzkd.zzh;
        zzjo zzjoVar11 = new zzjo("BYTES", 10, 10, zzjqVar, zzkdVar8);
        zzm = zzjoVar11;
        zzjo zzjoVar12 = new zzjo("UINT32", 11, 11, zzjqVar, zzkdVar4);
        zzn = zzjoVar12;
        zzkd zzkdVar9 = zzkd.zzi;
        zzjo zzjoVar13 = new zzjo("ENUM", 12, 12, zzjqVar, zzkdVar9);
        zzo = zzjoVar13;
        zzjo zzjoVar14 = new zzjo("SFIXED32", 13, 13, zzjqVar, zzkdVar4);
        zzp = zzjoVar14;
        zzjo zzjoVar15 = new zzjo("SFIXED64", 14, 14, zzjqVar, zzkdVar3);
        zzq = zzjoVar15;
        zzjo zzjoVar16 = new zzjo("SINT32", 15, 15, zzjqVar, zzkdVar4);
        zzr = zzjoVar16;
        zzjo zzjoVar17 = new zzjo("SINT64", 16, 16, zzjqVar, zzkdVar3);
        zzs = zzjoVar17;
        zzjo zzjoVar18 = new zzjo("GROUP", 17, 17, zzjqVar, zzkdVar7);
        zzt = zzjoVar18;
        zzjq zzjqVar2 = zzjq.VECTOR;
        zzjo zzjoVar19 = new zzjo("DOUBLE_LIST", 18, 18, zzjqVar2, zzkdVar);
        zzu = zzjoVar19;
        zzjo zzjoVar20 = new zzjo("FLOAT_LIST", 19, 19, zzjqVar2, zzkdVar2);
        zzv = zzjoVar20;
        zzjo zzjoVar21 = new zzjo("INT64_LIST", 20, 20, zzjqVar2, zzkdVar3);
        zzw = zzjoVar21;
        zzjo zzjoVar22 = new zzjo("UINT64_LIST", 21, 21, zzjqVar2, zzkdVar3);
        zzx = zzjoVar22;
        zzjo zzjoVar23 = new zzjo("INT32_LIST", 22, 22, zzjqVar2, zzkdVar4);
        zzy = zzjoVar23;
        zzjo zzjoVar24 = new zzjo("FIXED64_LIST", 23, 23, zzjqVar2, zzkdVar3);
        zzz = zzjoVar24;
        zzjo zzjoVar25 = new zzjo("FIXED32_LIST", 24, 24, zzjqVar2, zzkdVar4);
        zzaa = zzjoVar25;
        zzjo zzjoVar26 = new zzjo("BOOL_LIST", 25, 25, zzjqVar2, zzkdVar5);
        zzab = zzjoVar26;
        zzjo zzjoVar27 = new zzjo("STRING_LIST", 26, 26, zzjqVar2, zzkdVar6);
        zzac = zzjoVar27;
        zzjo zzjoVar28 = new zzjo("MESSAGE_LIST", 27, 27, zzjqVar2, zzkdVar7);
        zzad = zzjoVar28;
        zzjo zzjoVar29 = new zzjo("BYTES_LIST", 28, 28, zzjqVar2, zzkdVar8);
        zzae = zzjoVar29;
        zzjo zzjoVar30 = new zzjo("UINT32_LIST", 29, 29, zzjqVar2, zzkdVar4);
        zzaf = zzjoVar30;
        zzjo zzjoVar31 = new zzjo("ENUM_LIST", 30, 30, zzjqVar2, zzkdVar9);
        zzag = zzjoVar31;
        zzjo zzjoVar32 = new zzjo("SFIXED32_LIST", 31, 31, zzjqVar2, zzkdVar4);
        zzah = zzjoVar32;
        zzjo zzjoVar33 = new zzjo("SFIXED64_LIST", 32, 32, zzjqVar2, zzkdVar3);
        zzai = zzjoVar33;
        zzjo zzjoVar34 = new zzjo("SINT32_LIST", 33, 33, zzjqVar2, zzkdVar4);
        zzaj = zzjoVar34;
        zzjo zzjoVar35 = new zzjo("SINT64_LIST", 34, 34, zzjqVar2, zzkdVar3);
        zzak = zzjoVar35;
        zzjq zzjqVar3 = zzjq.PACKED_VECTOR;
        zzjo zzjoVar36 = new zzjo("DOUBLE_LIST_PACKED", 35, 35, zzjqVar3, zzkdVar);
        zza = zzjoVar36;
        zzjo zzjoVar37 = new zzjo("FLOAT_LIST_PACKED", 36, 36, zzjqVar3, zzkdVar2);
        zzal = zzjoVar37;
        zzjo zzjoVar38 = new zzjo("INT64_LIST_PACKED", 37, 37, zzjqVar3, zzkdVar3);
        zzam = zzjoVar38;
        zzjo zzjoVar39 = new zzjo("UINT64_LIST_PACKED", 38, 38, zzjqVar3, zzkdVar3);
        zzan = zzjoVar39;
        zzjo zzjoVar40 = new zzjo("INT32_LIST_PACKED", 39, 39, zzjqVar3, zzkdVar4);
        zzao = zzjoVar40;
        zzjo zzjoVar41 = new zzjo("FIXED64_LIST_PACKED", 40, 40, zzjqVar3, zzkdVar3);
        zzap = zzjoVar41;
        zzjo zzjoVar42 = new zzjo("FIXED32_LIST_PACKED", 41, 41, zzjqVar3, zzkdVar4);
        zzaq = zzjoVar42;
        zzjo zzjoVar43 = new zzjo("BOOL_LIST_PACKED", 42, 42, zzjqVar3, zzkdVar5);
        zzar = zzjoVar43;
        zzjo zzjoVar44 = new zzjo("UINT32_LIST_PACKED", 43, 43, zzjqVar3, zzkdVar4);
        zzas = zzjoVar44;
        zzjo zzjoVar45 = new zzjo("ENUM_LIST_PACKED", 44, 44, zzjqVar3, zzkdVar9);
        zzat = zzjoVar45;
        zzjo zzjoVar46 = new zzjo("SFIXED32_LIST_PACKED", 45, 45, zzjqVar3, zzkdVar4);
        zzau = zzjoVar46;
        zzjo zzjoVar47 = new zzjo("SFIXED64_LIST_PACKED", 46, 46, zzjqVar3, zzkdVar3);
        zzav = zzjoVar47;
        zzjo zzjoVar48 = new zzjo("SINT32_LIST_PACKED", 47, 47, zzjqVar3, zzkdVar4);
        zzaw = zzjoVar48;
        zzjo zzjoVar49 = new zzjo("SINT64_LIST_PACKED", 48, 48, zzjqVar3, zzkdVar3);
        zzb = zzjoVar49;
        zzjo zzjoVar50 = new zzjo("GROUP_LIST", 49, 49, zzjqVar2, zzkdVar7);
        zzax = zzjoVar50;
        zzjo zzjoVar51 = new zzjo("MAP", 50, 50, zzjq.MAP, zzkd.zza);
        zzay = zzjoVar51;
        zzbb = new zzjo[]{zzjoVar, zzjoVar2, zzjoVar3, zzjoVar4, zzjoVar5, zzjoVar6, zzjoVar7, zzjoVar8, zzjoVar9, zzjoVar10, zzjoVar11, zzjoVar12, zzjoVar13, zzjoVar14, zzjoVar15, zzjoVar16, zzjoVar17, zzjoVar18, zzjoVar19, zzjoVar20, zzjoVar21, zzjoVar22, zzjoVar23, zzjoVar24, zzjoVar25, zzjoVar26, zzjoVar27, zzjoVar28, zzjoVar29, zzjoVar30, zzjoVar31, zzjoVar32, zzjoVar33, zzjoVar34, zzjoVar35, zzjoVar36, zzjoVar37, zzjoVar38, zzjoVar39, zzjoVar40, zzjoVar41, zzjoVar42, zzjoVar43, zzjoVar44, zzjoVar45, zzjoVar46, zzjoVar47, zzjoVar48, zzjoVar49, zzjoVar50, zzjoVar51};
        zzba = new Type[0];
        zzjo[] zzjoVarArrValues = values();
        zzaz = new zzjo[zzjoVarArrValues.length];
        for (zzjo zzjoVar52 : zzjoVarArrValues) {
            zzaz[zzjoVar52.zzbd] = zzjoVar52;
        }
    }

    private zzjo(String str, int i10, int i11, zzjq zzjqVar, zzkd zzkdVar) {
        int i12;
        this.zzbd = i11;
        this.zzbe = zzjqVar;
        this.zzbc = zzkdVar;
        int iOrdinal = zzjqVar.ordinal();
        if (iOrdinal == 1 || iOrdinal == 3) {
            this.zzbf = zzkdVar.zza();
        } else {
            this.zzbf = null;
        }
        this.zzbg = (zzjqVar != zzjq.SCALAR || (i12 = zzjn.zza[zzkdVar.ordinal()]) == 1 || i12 == 2 || i12 == 3) ? false : true;
    }

    public static zzjo[] values() {
        return (zzjo[]) zzbb.clone();
    }

    public final int zza() {
        return this.zzbd;
    }
}
