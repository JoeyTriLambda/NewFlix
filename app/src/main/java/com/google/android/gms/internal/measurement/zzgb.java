package com.google.android.gms.internal.measurement;

import com.google.android.gms.internal.measurement.zzjt;
import java.util.List;

/* compiled from: com.google.android.gms:play-services-measurement@@21.6.1 */
/* loaded from: classes.dex */
public final class zzgb {

    /* compiled from: com.google.android.gms:play-services-measurement@@21.6.1 */
    public static final class zza extends zzjt<zza, C0081zza> implements zzli {
        private static final zza zzc;
        private static volatile zzlp<zza> zzd;
        private zzkc<zzb> zze = zzjt.zzcc();

        /* compiled from: com.google.android.gms:play-services-measurement@@21.6.1 */
        /* renamed from: com.google.android.gms.internal.measurement.zzgb$zza$zza, reason: collision with other inner class name */
        public static final class C0081zza extends zzjt.zza<zza, C0081zza> implements zzli {
            private C0081zza() {
                super(zza.zzc);
            }

            public /* synthetic */ C0081zza(zzgc zzgcVar) {
                this();
            }
        }

        static {
            zza zzaVar = new zza();
            zzc = zzaVar;
            zzjt.zza((Class<zza>) zza.class, zzaVar);
        }

        private zza() {
        }

        public static zza zzc() {
            return zzc;
        }

        public final int zza() {
            return this.zze.size();
        }

        public final List<zzb> zzd() {
            return this.zze;
        }

        @Override // com.google.android.gms.internal.measurement.zzjt
        public final Object zza(int i10, Object obj, Object obj2) {
            zzgc zzgcVar = null;
            switch (zzgc.zza[i10 - 1]) {
                case 1:
                    return new zza();
                case 2:
                    return new C0081zza(zzgcVar);
                case 3:
                    return zzjt.zza(zzc, "\u0001\u0001\u0000\u0000\u0001\u0001\u0001\u0000\u0001\u0000\u0001\u001b", new Object[]{"zze", zzb.class});
                case 4:
                    return zzc;
                case 5:
                    zzlp<zza> zzcVar = zzd;
                    if (zzcVar == null) {
                        synchronized (zza.class) {
                            zzcVar = zzd;
                            if (zzcVar == null) {
                                zzcVar = new zzjt.zzc<>(zzc);
                                zzd = zzcVar;
                            }
                        }
                    }
                    return zzcVar;
                case 6:
                    return (byte) 1;
                case 7:
                    return null;
                default:
                    throw new UnsupportedOperationException();
            }
        }
    }

    /* compiled from: com.google.android.gms:play-services-measurement@@21.6.1 */
    public static final class zzb extends zzjt<zzb, zza> implements zzli {
        private static final zzb zzc;
        private static volatile zzlp<zzb> zzd;
        private int zze;
        private String zzf = "";
        private zzkc<zzd> zzg = zzjt.zzcc();

        /* compiled from: com.google.android.gms:play-services-measurement@@21.6.1 */
        public static final class zza extends zzjt.zza<zzb, zza> implements zzli {
            private zza() {
                super(zzb.zzc);
            }

            public /* synthetic */ zza(zzgc zzgcVar) {
                this();
            }
        }

        static {
            zzb zzbVar = new zzb();
            zzc = zzbVar;
            zzjt.zza((Class<zzb>) zzb.class, zzbVar);
        }

        private zzb() {
        }

        public final String zzb() {
            return this.zzf;
        }

        public final List<zzd> zzc() {
            return this.zzg;
        }

        @Override // com.google.android.gms.internal.measurement.zzjt
        public final Object zza(int i10, Object obj, Object obj2) {
            zzgc zzgcVar = null;
            switch (zzgc.zza[i10 - 1]) {
                case 1:
                    return new zzb();
                case 2:
                    return new zza(zzgcVar);
                case 3:
                    return zzjt.zza(zzc, "\u0001\u0002\u0000\u0001\u0001\u0002\u0002\u0000\u0001\u0000\u0001ဈ\u0000\u0002\u001b", new Object[]{"zze", "zzf", "zzg", zzd.class});
                case 4:
                    return zzc;
                case 5:
                    zzlp<zzb> zzcVar = zzd;
                    if (zzcVar == null) {
                        synchronized (zzb.class) {
                            zzcVar = zzd;
                            if (zzcVar == null) {
                                zzcVar = new zzjt.zzc<>(zzc);
                                zzd = zzcVar;
                            }
                        }
                    }
                    return zzcVar;
                case 6:
                    return (byte) 1;
                case 7:
                    return null;
                default:
                    throw new UnsupportedOperationException();
            }
        }
    }

    /* compiled from: com.google.android.gms:play-services-measurement@@21.6.1 */
    public static final class zzc extends zzjt<zzc, zza> implements zzli {
        private static final zzc zzc;
        private static volatile zzlp<zzc> zzd;
        private int zze;
        private zzkc<zzd> zzf = zzjt.zzcc();
        private zza zzg;

        /* compiled from: com.google.android.gms:play-services-measurement@@21.6.1 */
        public static final class zza extends zzjt.zza<zzc, zza> implements zzli {
            private zza() {
                super(zzc.zzc);
            }

            public /* synthetic */ zza(zzgc zzgcVar) {
                this();
            }
        }

        static {
            zzc zzcVar = new zzc();
            zzc = zzcVar;
            zzjt.zza((Class<zzc>) zzc.class, zzcVar);
        }

        private zzc() {
        }

        public final zza zza() {
            zza zzaVar = this.zzg;
            return zzaVar == null ? zza.zzc() : zzaVar;
        }

        public final List<zzd> zzc() {
            return this.zzf;
        }

        @Override // com.google.android.gms.internal.measurement.zzjt
        public final Object zza(int i10, Object obj, Object obj2) {
            zzgc zzgcVar = null;
            switch (zzgc.zza[i10 - 1]) {
                case 1:
                    return new zzc();
                case 2:
                    return new zza(zzgcVar);
                case 3:
                    return zzjt.zza(zzc, "\u0001\u0002\u0000\u0001\u0001\u0002\u0002\u0000\u0001\u0000\u0001\u001b\u0002ဉ\u0000", new Object[]{"zze", "zzf", zzd.class, "zzg"});
                case 4:
                    return zzc;
                case 5:
                    zzlp<zzc> zzcVar = zzd;
                    if (zzcVar == null) {
                        synchronized (zzc.class) {
                            zzcVar = zzd;
                            if (zzcVar == null) {
                                zzcVar = new zzjt.zzc<>(zzc);
                                zzd = zzcVar;
                            }
                        }
                    }
                    return zzcVar;
                case 6:
                    return (byte) 1;
                case 7:
                    return null;
                default:
                    throw new UnsupportedOperationException();
            }
        }
    }

    /* compiled from: com.google.android.gms:play-services-measurement@@21.6.1 */
    public static final class zzd extends zzjt<zzd, zzb> implements zzli {
        private static final zzd zzc;
        private static volatile zzlp<zzd> zzd;
        private int zze;
        private int zzf;
        private zzkc<zzd> zzg = zzjt.zzcc();
        private String zzh = "";
        private String zzi = "";
        private boolean zzj;
        private double zzk;

        /* compiled from: com.google.android.gms:play-services-measurement@@21.6.1 */
        public enum zza implements zzjv {
            UNKNOWN(0),
            STRING(1),
            NUMBER(2),
            BOOLEAN(3),
            STATEMENT(4);

            private static final zzjy<zza> zzf = new zzge();
            private final int zzh;

            zza(int i10) {
                this.zzh = i10;
            }

            public static zzjx zzb() {
                return zzgd.zza;
            }

            @Override // java.lang.Enum
            public final String toString() {
                return "<" + zza.class.getName() + '@' + Integer.toHexString(System.identityHashCode(this)) + " number=" + this.zzh + " name=" + name() + '>';
            }

            @Override // com.google.android.gms.internal.measurement.zzjv
            public final int zza() {
                return this.zzh;
            }

            public static zza zza(int i10) {
                if (i10 == 0) {
                    return UNKNOWN;
                }
                if (i10 == 1) {
                    return STRING;
                }
                if (i10 == 2) {
                    return NUMBER;
                }
                if (i10 == 3) {
                    return BOOLEAN;
                }
                if (i10 != 4) {
                    return null;
                }
                return STATEMENT;
            }
        }

        /* compiled from: com.google.android.gms:play-services-measurement@@21.6.1 */
        public static final class zzb extends zzjt.zza<zzd, zzb> implements zzli {
            private zzb() {
                super(zzd.zzc);
            }

            public /* synthetic */ zzb(zzgc zzgcVar) {
                this();
            }
        }

        static {
            zzd zzdVar = new zzd();
            zzc = zzdVar;
            zzjt.zza((Class<zzd>) zzd.class, zzdVar);
        }

        private zzd() {
        }

        public final double zza() {
            return this.zzk;
        }

        public final zza zzb() {
            zza zzaVarZza = zza.zza(this.zzf);
            return zzaVarZza == null ? zza.UNKNOWN : zzaVarZza;
        }

        public final String zzd() {
            return this.zzh;
        }

        public final String zze() {
            return this.zzi;
        }

        public final List<zzd> zzf() {
            return this.zzg;
        }

        public final boolean zzg() {
            return this.zzj;
        }

        public final boolean zzh() {
            return (this.zze & 8) != 0;
        }

        public final boolean zzi() {
            return (this.zze & 16) != 0;
        }

        public final boolean zzj() {
            return (this.zze & 4) != 0;
        }

        @Override // com.google.android.gms.internal.measurement.zzjt
        public final Object zza(int i10, Object obj, Object obj2) {
            zzgc zzgcVar = null;
            switch (zzgc.zza[i10 - 1]) {
                case 1:
                    return new zzd();
                case 2:
                    return new zzb(zzgcVar);
                case 3:
                    return zzjt.zza(zzc, "\u0001\u0006\u0000\u0001\u0001\u0006\u0006\u0000\u0001\u0000\u0001᠌\u0000\u0002\u001b\u0003ဈ\u0001\u0004ဈ\u0002\u0005ဇ\u0003\u0006က\u0004", new Object[]{"zze", "zzf", zza.zzb(), "zzg", zzd.class, "zzh", "zzi", "zzj", "zzk"});
                case 4:
                    return zzc;
                case 5:
                    zzlp<zzd> zzcVar = zzd;
                    if (zzcVar == null) {
                        synchronized (zzd.class) {
                            zzcVar = zzd;
                            if (zzcVar == null) {
                                zzcVar = new zzjt.zzc<>(zzc);
                                zzd = zzcVar;
                            }
                        }
                    }
                    return zzcVar;
                case 6:
                    return (byte) 1;
                case 7:
                    return null;
                default:
                    throw new UnsupportedOperationException();
            }
        }
    }
}
