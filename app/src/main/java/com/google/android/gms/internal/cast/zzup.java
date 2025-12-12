package com.google.android.gms.internal.cast;

/* compiled from: com.google.android.gms:play-services-cast@@21.4.0 */
/* loaded from: classes.dex */
final class zzup implements zzvj {
    private static final zzuv zza = new zzun();
    private final zzuv zzb;

    public zzup() {
        zzuv zzuvVar;
        zzuv[] zzuvVarArr = new zzuv[2];
        zzuvVarArr[0] = zztl.zza();
        try {
            zzuvVar = (zzuv) Class.forName("com.google.protobuf.DescriptorMessageInfoFactory").getDeclaredMethod("getInstance", new Class[0]).invoke(null, new Object[0]);
        } catch (Exception unused) {
            zzuvVar = zza;
        }
        zzuvVarArr[1] = zzuvVar;
        zzuo zzuoVar = new zzuo(zzuvVarArr);
        byte[] bArr = zzty.zzd;
        this.zzb = zzuoVar;
    }

    private static boolean zzb(zzuu zzuuVar) {
        return zzuuVar.zzc() + (-1) != 1;
    }

    @Override // com.google.android.gms.internal.cast.zzvj
    public final zzvi zza(Class cls) {
        zzvk.zzp(cls);
        zzuu zzuuVarZzb = this.zzb.zzb(cls);
        return zzuuVarZzb.zzb() ? zztp.class.isAssignableFrom(cls) ? zzvb.zzi(zzvk.zzn(), zzth.zzb(), zzuuVarZzb.zza()) : zzvb.zzi(zzvk.zzm(), zzth.zza(), zzuuVarZzb.zza()) : zztp.class.isAssignableFrom(cls) ? zzb(zzuuVarZzb) ? zzva.zzi(cls, zzuuVarZzb, zzvd.zzb(), zzul.zzd(), zzvk.zzn(), zzth.zzb(), zzut.zzb()) : zzva.zzi(cls, zzuuVarZzb, zzvd.zzb(), zzul.zzd(), zzvk.zzn(), null, zzut.zzb()) : zzb(zzuuVarZzb) ? zzva.zzi(cls, zzuuVarZzb, zzvd.zza(), zzul.zzc(), zzvk.zzm(), zzth.zza(), zzut.zza()) : zzva.zzi(cls, zzuuVarZzb, zzvd.zza(), zzul.zzc(), zzvk.zzm(), null, zzut.zza());
    }
}
