package com.google.android.gms.internal.measurement;

/* compiled from: com.google.android.gms:play-services-measurement-base@@21.6.1 */
/* loaded from: classes.dex */
final class zzku implements zzlx {
    private static final zzld zza = new zzkt();
    private final zzld zzb;

    public zzku() {
        this(new zzkv(zzjr.zza(), zza()));
    }

    private static zzld zza() {
        try {
            return (zzld) Class.forName("com.google.protobuf.DescriptorMessageInfoFactory").getDeclaredMethod("getInstance", new Class[0]).invoke(null, new Object[0]);
        } catch (Exception unused) {
            return zza;
        }
    }

    private zzku(zzld zzldVar) {
        this.zzb = (zzld) zzjw.zza(zzldVar, "messageInfoFactory");
    }

    @Override // com.google.android.gms.internal.measurement.zzlx
    public final <T> zzly<T> zza(Class<T> cls) {
        zzma.zza((Class<?>) cls);
        zzle zzleVarZza = this.zzb.zza(cls);
        if (zzleVarZza.zzc()) {
            if (zzjt.class.isAssignableFrom(cls)) {
                return zzlm.zza(zzma.zzb(), zzjk.zzb(), zzleVarZza.zza());
            }
            return zzlm.zza(zzma.zza(), zzjk.zza(), zzleVarZza.zza());
        }
        if (zzjt.class.isAssignableFrom(cls)) {
            if (zza(zzleVarZza)) {
                return zzlk.zza(cls, zzleVarZza, zzlq.zzb(), zzkl.zzb(), zzma.zzb(), zzjk.zzb(), zzlb.zzb());
            }
            return zzlk.zza(cls, zzleVarZza, zzlq.zzb(), zzkl.zzb(), zzma.zzb(), (zzji<?>) null, zzlb.zzb());
        }
        if (zza(zzleVarZza)) {
            return zzlk.zza(cls, zzleVarZza, zzlq.zza(), zzkl.zza(), zzma.zza(), zzjk.zza(), zzlb.zza());
        }
        return zzlk.zza(cls, zzleVarZza, zzlq.zza(), zzkl.zza(), zzma.zza(), (zzji<?>) null, zzlb.zza());
    }

    private static boolean zza(zzle zzleVar) {
        return zzkw.zza[zzleVar.zzb().ordinal()] != 1;
    }
}
