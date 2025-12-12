package com.google.android.gms.internal.measurement;

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
public class zzng {
    public static final zzng zza;
    public static final zzng zzb;
    public static final zzng zzc;
    public static final zzng zzd;
    public static final zzng zze;
    public static final zzng zzf;
    public static final zzng zzg;
    public static final zzng zzh;
    public static final zzng zzi;
    public static final zzng zzj;
    public static final zzng zzk;
    public static final zzng zzl;
    public static final zzng zzm;
    public static final zzng zzn;
    public static final zzng zzo;
    public static final zzng zzp;
    public static final zzng zzq;
    public static final zzng zzr;
    private static final /* synthetic */ zzng[] zzs;
    private final zznq zzt;
    private final int zzu;

    static {
        zzng zzngVar = new zzng("DOUBLE", 0, zznq.DOUBLE, 1);
        zza = zzngVar;
        zzng zzngVar2 = new zzng("FLOAT", 1, zznq.FLOAT, 5);
        zzb = zzngVar2;
        zznq zznqVar = zznq.LONG;
        zzng zzngVar3 = new zzng("INT64", 2, zznqVar, 0);
        zzc = zzngVar3;
        zzng zzngVar4 = new zzng("UINT64", 3, zznqVar, 0);
        zzd = zzngVar4;
        zznq zznqVar2 = zznq.INT;
        zzng zzngVar5 = new zzng("INT32", 4, zznqVar2, 0);
        zze = zzngVar5;
        zzng zzngVar6 = new zzng("FIXED64", 5, zznqVar, 1);
        zzf = zzngVar6;
        zzng zzngVar7 = new zzng("FIXED32", 6, zznqVar2, 5);
        zzg = zzngVar7;
        zzng zzngVar8 = new zzng("BOOL", 7, zznq.BOOLEAN, 0);
        zzh = zzngVar8;
        int i10 = 2;
        zznj zznjVar = new zznj("STRING", zznq.STRING);
        zzi = zznjVar;
        zznq zznqVar3 = zznq.MESSAGE;
        zznl zznlVar = new zznl("GROUP", zznqVar3);
        zzj = zznlVar;
        zznn zznnVar = new zznn("MESSAGE", zznqVar3);
        zzk = zznnVar;
        zznp zznpVar = new zznp("BYTES", zznq.BYTE_STRING);
        zzl = zznpVar;
        zzng zzngVar9 = new zzng("UINT32", 12, zznqVar2, 0);
        zzm = zzngVar9;
        zzng zzngVar10 = new zzng("ENUM", 13, zznq.ENUM, 0);
        zzn = zzngVar10;
        zzng zzngVar11 = new zzng("SFIXED32", 14, zznqVar2, 5);
        zzo = zzngVar11;
        zzng zzngVar12 = new zzng("SFIXED64", 15, zznqVar, 1);
        zzp = zzngVar12;
        zzng zzngVar13 = new zzng("SINT32", 16, zznqVar2, 0);
        zzq = zzngVar13;
        zzng zzngVar14 = new zzng("SINT64", 17, zznqVar, 0);
        zzr = zzngVar14;
        zzs = new zzng[]{zzngVar, zzngVar2, zzngVar3, zzngVar4, zzngVar5, zzngVar6, zzngVar7, zzngVar8, zznjVar, zznlVar, zznnVar, zznpVar, zzngVar9, zzngVar10, zzngVar11, zzngVar12, zzngVar13, zzngVar14};
    }

    public static zzng[] values() {
        return (zzng[]) zzs.clone();
    }

    public final int zza() {
        return this.zzu;
    }

    public final zznq zzb() {
        return this.zzt;
    }

    private zzng(String str, int i10, zznq zznqVar, int i11) {
        this.zzt = zznqVar;
        this.zzu = i11;
    }
}
