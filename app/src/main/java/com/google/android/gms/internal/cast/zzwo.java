package com.google.android.gms.internal.cast;

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
/* compiled from: com.google.android.gms:play-services-cast@@21.4.0 */
/* loaded from: classes.dex */
public final class zzwo {
    public static final zzwo zza;
    public static final zzwo zzb;
    public static final zzwo zzc;
    public static final zzwo zzd;
    public static final zzwo zze;
    public static final zzwo zzf;
    public static final zzwo zzg;
    public static final zzwo zzh;
    public static final zzwo zzi;
    public static final zzwo zzj;
    public static final zzwo zzk;
    public static final zzwo zzl;
    public static final zzwo zzm;
    public static final zzwo zzn;
    public static final zzwo zzo;
    public static final zzwo zzp;
    public static final zzwo zzq;
    public static final zzwo zzr;
    private static final /* synthetic */ zzwo[] zzs;
    private final zzwp zzt;

    static {
        zzwo zzwoVar = new zzwo("DOUBLE", 0, zzwp.DOUBLE, 1);
        zza = zzwoVar;
        zzwo zzwoVar2 = new zzwo("FLOAT", 1, zzwp.FLOAT, 5);
        zzb = zzwoVar2;
        zzwp zzwpVar = zzwp.LONG;
        zzwo zzwoVar3 = new zzwo("INT64", 2, zzwpVar, 0);
        zzc = zzwoVar3;
        zzwo zzwoVar4 = new zzwo("UINT64", 3, zzwpVar, 0);
        zzd = zzwoVar4;
        zzwp zzwpVar2 = zzwp.INT;
        zzwo zzwoVar5 = new zzwo("INT32", 4, zzwpVar2, 0);
        zze = zzwoVar5;
        zzwo zzwoVar6 = new zzwo("FIXED64", 5, zzwpVar, 1);
        zzf = zzwoVar6;
        zzwo zzwoVar7 = new zzwo("FIXED32", 6, zzwpVar2, 5);
        zzg = zzwoVar7;
        zzwo zzwoVar8 = new zzwo("BOOL", 7, zzwp.BOOLEAN, 0);
        zzh = zzwoVar8;
        zzwo zzwoVar9 = new zzwo("STRING", 8, zzwp.STRING, 2);
        zzi = zzwoVar9;
        zzwp zzwpVar3 = zzwp.MESSAGE;
        zzwo zzwoVar10 = new zzwo("GROUP", 9, zzwpVar3, 3);
        zzj = zzwoVar10;
        zzwo zzwoVar11 = new zzwo("MESSAGE", 10, zzwpVar3, 2);
        zzk = zzwoVar11;
        zzwo zzwoVar12 = new zzwo("BYTES", 11, zzwp.BYTE_STRING, 2);
        zzl = zzwoVar12;
        zzwo zzwoVar13 = new zzwo("UINT32", 12, zzwpVar2, 0);
        zzm = zzwoVar13;
        zzwo zzwoVar14 = new zzwo("ENUM", 13, zzwp.ENUM, 0);
        zzn = zzwoVar14;
        zzwo zzwoVar15 = new zzwo("SFIXED32", 14, zzwpVar2, 5);
        zzo = zzwoVar15;
        zzwo zzwoVar16 = new zzwo("SFIXED64", 15, zzwpVar, 1);
        zzp = zzwoVar16;
        zzwo zzwoVar17 = new zzwo("SINT32", 16, zzwpVar2, 0);
        zzq = zzwoVar17;
        zzwo zzwoVar18 = new zzwo("SINT64", 17, zzwpVar, 0);
        zzr = zzwoVar18;
        zzs = new zzwo[]{zzwoVar, zzwoVar2, zzwoVar3, zzwoVar4, zzwoVar5, zzwoVar6, zzwoVar7, zzwoVar8, zzwoVar9, zzwoVar10, zzwoVar11, zzwoVar12, zzwoVar13, zzwoVar14, zzwoVar15, zzwoVar16, zzwoVar17, zzwoVar18};
    }

    private zzwo(String str, int i10, zzwp zzwpVar, int i11) {
        this.zzt = zzwpVar;
    }

    public static zzwo[] values() {
        return (zzwo[]) zzs.clone();
    }

    public final zzwp zza() {
        return this.zzt;
    }
}
