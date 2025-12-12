package com.google.android.gms.internal.measurement;

import com.google.android.gms.internal.measurement.zzjt;
import java.util.List;

/* compiled from: com.google.android.gms:play-services-measurement@@21.6.1 */
/* loaded from: classes.dex */
public final class zzfh {

    /* compiled from: com.google.android.gms:play-services-measurement@@21.6.1 */
    public static final class zza extends zzjt<zza, C0075zza> implements zzli {
        private static final zza zzc;
        private static volatile zzlp<zza> zzd;
        private int zze;
        private int zzf;
        private zzkc<zze> zzg = zzjt.zzcc();
        private zzkc<zzb> zzh = zzjt.zzcc();
        private boolean zzi;
        private boolean zzj;

        /* compiled from: com.google.android.gms:play-services-measurement@@21.6.1 */
        /* renamed from: com.google.android.gms.internal.measurement.zzfh$zza$zza, reason: collision with other inner class name */
        public static final class C0075zza extends zzjt.zza<zza, C0075zza> implements zzli {
            private C0075zza() {
                super(zza.zzc);
            }

            public final int zza() {
                return ((zza) this.zza).zzb();
            }

            public final int zzb() {
                return ((zza) this.zza).zzc();
            }

            public /* synthetic */ C0075zza(zzfg zzfgVar) {
                this();
            }

            public final C0075zza zza(int i10, zzb.zza zzaVar) {
                zzak();
                ((zza) this.zza).zza(i10, (zzb) ((zzjt) zzaVar.zzah()));
                return this;
            }

            public final zze zzb(int i10) {
                return ((zza) this.zza).zzb(i10);
            }

            public final C0075zza zza(int i10, zze.zza zzaVar) {
                zzak();
                ((zza) this.zza).zza(i10, (zze) ((zzjt) zzaVar.zzah()));
                return this;
            }

            public final zzb zza(int i10) {
                return ((zza) this.zza).zza(i10);
            }
        }

        static {
            zza zzaVar = new zza();
            zzc = zzaVar;
            zzjt.zza((Class<zza>) zza.class, zzaVar);
        }

        private zza() {
        }

        public final int zza() {
            return this.zzf;
        }

        public final int zzb() {
            return this.zzh.size();
        }

        public final int zzc() {
            return this.zzg.size();
        }

        public final List<zzb> zze() {
            return this.zzh;
        }

        public final List<zze> zzf() {
            return this.zzg;
        }

        public final boolean zzg() {
            return (this.zze & 1) != 0;
        }

        public final zzb zza(int i10) {
            return this.zzh.get(i10);
        }

        public final zze zzb(int i10) {
            return this.zzg.get(i10);
        }

        @Override // com.google.android.gms.internal.measurement.zzjt
        public final Object zza(int i10, Object obj, Object obj2) {
            zzfg zzfgVar = null;
            switch (zzfg.zza[i10 - 1]) {
                case 1:
                    return new zza();
                case 2:
                    return new C0075zza(zzfgVar);
                case 3:
                    return zzjt.zza(zzc, "\u0001\u0005\u0000\u0001\u0001\u0005\u0005\u0000\u0002\u0000\u0001င\u0000\u0002\u001b\u0003\u001b\u0004ဇ\u0001\u0005ဇ\u0002", new Object[]{"zze", "zzf", "zzg", zze.class, "zzh", zzb.class, "zzi", "zzj"});
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

        /* JADX INFO: Access modifiers changed from: private */
        public final void zza(int i10, zzb zzbVar) {
            zzbVar.getClass();
            zzkc<zzb> zzkcVar = this.zzh;
            if (!zzkcVar.zzc()) {
                this.zzh = zzjt.zza(zzkcVar);
            }
            this.zzh.set(i10, zzbVar);
        }

        /* JADX INFO: Access modifiers changed from: private */
        public final void zza(int i10, zze zzeVar) {
            zzeVar.getClass();
            zzkc<zze> zzkcVar = this.zzg;
            if (!zzkcVar.zzc()) {
                this.zzg = zzjt.zza(zzkcVar);
            }
            this.zzg.set(i10, zzeVar);
        }
    }

    /* compiled from: com.google.android.gms:play-services-measurement@@21.6.1 */
    public static final class zzb extends zzjt<zzb, zza> implements zzli {
        private static final zzb zzc;
        private static volatile zzlp<zzb> zzd;
        private int zze;
        private int zzf;
        private String zzg = "";
        private zzkc<zzc> zzh = zzjt.zzcc();
        private boolean zzi;
        private zzd zzj;
        private boolean zzk;
        private boolean zzl;
        private boolean zzm;

        /* compiled from: com.google.android.gms:play-services-measurement@@21.6.1 */
        public static final class zza extends zzjt.zza<zzb, zza> implements zzli {
            private zza() {
                super(zzb.zzc);
            }

            public final int zza() {
                return ((zzb) this.zza).zza();
            }

            public final String zzb() {
                return ((zzb) this.zza).zzf();
            }

            public /* synthetic */ zza(zzfg zzfgVar) {
                this();
            }

            public final zza zza(String str) {
                zzak();
                ((zzb) this.zza).zza(str);
                return this;
            }

            public final zza zza(int i10, zzc zzcVar) {
                zzak();
                ((zzb) this.zza).zza(i10, zzcVar);
                return this;
            }

            public final zzc zza(int i10) {
                return ((zzb) this.zza).zza(i10);
            }
        }

        static {
            zzb zzbVar = new zzb();
            zzc = zzbVar;
            zzjt.zza((Class<zzb>) zzb.class, zzbVar);
        }

        private zzb() {
        }

        public static zza zzc() {
            return zzc.zzbx();
        }

        public final int zza() {
            return this.zzh.size();
        }

        public final int zzb() {
            return this.zzf;
        }

        public final zzd zze() {
            zzd zzdVar = this.zzj;
            return zzdVar == null ? zzd.zzc() : zzdVar;
        }

        public final String zzf() {
            return this.zzg;
        }

        public final List<zzc> zzg() {
            return this.zzh;
        }

        public final boolean zzh() {
            return this.zzk;
        }

        public final boolean zzi() {
            return this.zzl;
        }

        public final boolean zzj() {
            return this.zzm;
        }

        public final boolean zzk() {
            return (this.zze & 8) != 0;
        }

        public final boolean zzl() {
            return (this.zze & 1) != 0;
        }

        public final boolean zzm() {
            return (this.zze & 64) != 0;
        }

        public final zzc zza(int i10) {
            return this.zzh.get(i10);
        }

        @Override // com.google.android.gms.internal.measurement.zzjt
        public final Object zza(int i10, Object obj, Object obj2) {
            zzfg zzfgVar = null;
            switch (zzfg.zza[i10 - 1]) {
                case 1:
                    return new zzb();
                case 2:
                    return new zza(zzfgVar);
                case 3:
                    return zzjt.zza(zzc, "\u0001\b\u0000\u0001\u0001\b\b\u0000\u0001\u0000\u0001င\u0000\u0002ဈ\u0001\u0003\u001b\u0004ဇ\u0002\u0005ဉ\u0003\u0006ဇ\u0004\u0007ဇ\u0005\bဇ\u0006", new Object[]{"zze", "zzf", "zzg", "zzh", zzc.class, "zzi", "zzj", "zzk", "zzl", "zzm"});
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

        /* JADX INFO: Access modifiers changed from: private */
        public final void zza(String str) {
            str.getClass();
            this.zze |= 2;
            this.zzg = str;
        }

        /* JADX INFO: Access modifiers changed from: private */
        public final void zza(int i10, zzc zzcVar) {
            zzcVar.getClass();
            zzkc<zzc> zzkcVar = this.zzh;
            if (!zzkcVar.zzc()) {
                this.zzh = zzjt.zza(zzkcVar);
            }
            this.zzh.set(i10, zzcVar);
        }
    }

    /* compiled from: com.google.android.gms:play-services-measurement@@21.6.1 */
    public static final class zzc extends zzjt<zzc, zza> implements zzli {
        private static final zzc zzc;
        private static volatile zzlp<zzc> zzd;
        private int zze;
        private zzf zzf;
        private zzd zzg;
        private boolean zzh;
        private String zzi = "";

        /* compiled from: com.google.android.gms:play-services-measurement@@21.6.1 */
        public static final class zza extends zzjt.zza<zzc, zza> implements zzli {
            private zza() {
                super(zzc.zzc);
            }

            public final zza zza(String str) {
                zzak();
                ((zzc) this.zza).zza(str);
                return this;
            }

            public /* synthetic */ zza(zzfg zzfgVar) {
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

        public static zzc zzb() {
            return zzc;
        }

        public final zzd zzc() {
            zzd zzdVar = this.zzg;
            return zzdVar == null ? zzd.zzc() : zzdVar;
        }

        public final zzf zzd() {
            zzf zzfVar = this.zzf;
            return zzfVar == null ? zzf.zzd() : zzfVar;
        }

        public final String zze() {
            return this.zzi;
        }

        public final boolean zzf() {
            return this.zzh;
        }

        public final boolean zzg() {
            return (this.zze & 4) != 0;
        }

        public final boolean zzh() {
            return (this.zze & 2) != 0;
        }

        public final boolean zzi() {
            return (this.zze & 8) != 0;
        }

        public final boolean zzj() {
            return (this.zze & 1) != 0;
        }

        @Override // com.google.android.gms.internal.measurement.zzjt
        public final Object zza(int i10, Object obj, Object obj2) {
            zzfg zzfgVar = null;
            switch (zzfg.zza[i10 - 1]) {
                case 1:
                    return new zzc();
                case 2:
                    return new zza(zzfgVar);
                case 3:
                    return zzjt.zza(zzc, "\u0001\u0004\u0000\u0001\u0001\u0004\u0004\u0000\u0000\u0000\u0001ဉ\u0000\u0002ဉ\u0001\u0003ဇ\u0002\u0004ဈ\u0003", new Object[]{"zze", "zzf", "zzg", "zzh", "zzi"});
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

        /* JADX INFO: Access modifiers changed from: private */
        public final void zza(String str) {
            str.getClass();
            this.zze |= 8;
            this.zzi = str;
        }
    }

    /* compiled from: com.google.android.gms:play-services-measurement@@21.6.1 */
    public static final class zze extends zzjt<zze, zza> implements zzli {
        private static final zze zzc;
        private static volatile zzlp<zze> zzd;
        private int zze;
        private int zzf;
        private String zzg = "";
        private zzc zzh;
        private boolean zzi;
        private boolean zzj;
        private boolean zzk;

        /* compiled from: com.google.android.gms:play-services-measurement@@21.6.1 */
        public static final class zza extends zzjt.zza<zze, zza> implements zzli {
            private zza() {
                super(zze.zzc);
            }

            public final zza zza(String str) {
                zzak();
                ((zze) this.zza).zza(str);
                return this;
            }

            public /* synthetic */ zza(zzfg zzfgVar) {
                this();
            }
        }

        static {
            zze zzeVar = new zze();
            zzc = zzeVar;
            zzjt.zza((Class<zze>) zze.class, zzeVar);
        }

        private zze() {
        }

        public static zza zzc() {
            return zzc.zzbx();
        }

        public final int zza() {
            return this.zzf;
        }

        public final zzc zzb() {
            zzc zzcVar = this.zzh;
            return zzcVar == null ? zzc.zzb() : zzcVar;
        }

        public final String zze() {
            return this.zzg;
        }

        public final boolean zzf() {
            return this.zzi;
        }

        public final boolean zzg() {
            return this.zzj;
        }

        public final boolean zzh() {
            return this.zzk;
        }

        public final boolean zzi() {
            return (this.zze & 1) != 0;
        }

        public final boolean zzj() {
            return (this.zze & 32) != 0;
        }

        @Override // com.google.android.gms.internal.measurement.zzjt
        public final Object zza(int i10, Object obj, Object obj2) {
            zzfg zzfgVar = null;
            switch (zzfg.zza[i10 - 1]) {
                case 1:
                    return new zze();
                case 2:
                    return new zza(zzfgVar);
                case 3:
                    return zzjt.zza(zzc, "\u0001\u0006\u0000\u0001\u0001\u0006\u0006\u0000\u0000\u0000\u0001င\u0000\u0002ဈ\u0001\u0003ဉ\u0002\u0004ဇ\u0003\u0005ဇ\u0004\u0006ဇ\u0005", new Object[]{"zze", "zzf", "zzg", "zzh", "zzi", "zzj", "zzk"});
                case 4:
                    return zzc;
                case 5:
                    zzlp<zze> zzcVar = zzd;
                    if (zzcVar == null) {
                        synchronized (zze.class) {
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

        /* JADX INFO: Access modifiers changed from: private */
        public final void zza(String str) {
            str.getClass();
            this.zze |= 2;
            this.zzg = str;
        }
    }

    /* compiled from: com.google.android.gms:play-services-measurement@@21.6.1 */
    public static final class zzf extends zzjt<zzf, zzb> implements zzli {
        private static final zzf zzc;
        private static volatile zzlp<zzf> zzd;
        private int zze;
        private int zzf;
        private boolean zzh;
        private String zzg = "";
        private zzkc<String> zzi = zzjt.zzcc();

        /* compiled from: com.google.android.gms:play-services-measurement@@21.6.1 */
        public enum zza implements zzjv {
            UNKNOWN_MATCH_TYPE(0),
            REGEXP(1),
            BEGINS_WITH(2),
            ENDS_WITH(3),
            PARTIAL(4),
            EXACT(5),
            IN_LIST(6);

            private static final zzjy<zza> zzh = new zzfl();
            private final int zzj;

            zza(int i10) {
                this.zzj = i10;
            }

            public static zzjx zzb() {
                return zzfk.zza;
            }

            @Override // java.lang.Enum
            public final String toString() {
                return "<" + zza.class.getName() + '@' + Integer.toHexString(System.identityHashCode(this)) + " number=" + this.zzj + " name=" + name() + '>';
            }

            @Override // com.google.android.gms.internal.measurement.zzjv
            public final int zza() {
                return this.zzj;
            }

            public static zza zza(int i10) {
                switch (i10) {
                    case 0:
                        return UNKNOWN_MATCH_TYPE;
                    case 1:
                        return REGEXP;
                    case 2:
                        return BEGINS_WITH;
                    case 3:
                        return ENDS_WITH;
                    case 4:
                        return PARTIAL;
                    case 5:
                        return EXACT;
                    case 6:
                        return IN_LIST;
                    default:
                        return null;
                }
            }
        }

        /* compiled from: com.google.android.gms:play-services-measurement@@21.6.1 */
        public static final class zzb extends zzjt.zza<zzf, zzb> implements zzli {
            private zzb() {
                super(zzf.zzc);
            }

            public /* synthetic */ zzb(zzfg zzfgVar) {
                this();
            }
        }

        static {
            zzf zzfVar = new zzf();
            zzc = zzfVar;
            zzjt.zza((Class<zzf>) zzf.class, zzfVar);
        }

        private zzf() {
        }

        public static zzf zzd() {
            return zzc;
        }

        public final int zza() {
            return this.zzi.size();
        }

        public final zza zzb() {
            zza zzaVarZza = zza.zza(this.zzf);
            return zzaVarZza == null ? zza.UNKNOWN_MATCH_TYPE : zzaVarZza;
        }

        public final String zze() {
            return this.zzg;
        }

        public final List<String> zzf() {
            return this.zzi;
        }

        public final boolean zzg() {
            return this.zzh;
        }

        public final boolean zzh() {
            return (this.zze & 4) != 0;
        }

        public final boolean zzi() {
            return (this.zze & 2) != 0;
        }

        public final boolean zzj() {
            return (this.zze & 1) != 0;
        }

        @Override // com.google.android.gms.internal.measurement.zzjt
        public final Object zza(int i10, Object obj, Object obj2) {
            zzfg zzfgVar = null;
            switch (zzfg.zza[i10 - 1]) {
                case 1:
                    return new zzf();
                case 2:
                    return new zzb(zzfgVar);
                case 3:
                    return zzjt.zza(zzc, "\u0001\u0004\u0000\u0001\u0001\u0004\u0004\u0000\u0001\u0000\u0001᠌\u0000\u0002ဈ\u0001\u0003ဇ\u0002\u0004\u001a", new Object[]{"zze", "zzf", zza.zzb(), "zzg", "zzh", "zzi"});
                case 4:
                    return zzc;
                case 5:
                    zzlp<zzf> zzcVar = zzd;
                    if (zzcVar == null) {
                        synchronized (zzf.class) {
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
    public static final class zzd extends zzjt<zzd, zza> implements zzli {
        private static final zzd zzc;
        private static volatile zzlp<zzd> zzd;
        private int zze;
        private int zzf;
        private boolean zzg;
        private String zzh = "";
        private String zzi = "";
        private String zzj = "";

        /* compiled from: com.google.android.gms:play-services-measurement@@21.6.1 */
        public static final class zza extends zzjt.zza<zzd, zza> implements zzli {
            private zza() {
                super(zzd.zzc);
            }

            public /* synthetic */ zza(zzfg zzfgVar) {
                this();
            }
        }

        /* compiled from: com.google.android.gms:play-services-measurement@@21.6.1 */
        public enum zzb implements zzjv {
            UNKNOWN_COMPARISON_TYPE(0),
            LESS_THAN(1),
            GREATER_THAN(2),
            EQUAL(3),
            BETWEEN(4);

            private static final zzjy<zzb> zzf = new zzfi();
            private final int zzh;

            zzb(int i10) {
                this.zzh = i10;
            }

            public static zzjx zzb() {
                return zzfj.zza;
            }

            @Override // java.lang.Enum
            public final String toString() {
                return "<" + zzb.class.getName() + '@' + Integer.toHexString(System.identityHashCode(this)) + " number=" + this.zzh + " name=" + name() + '>';
            }

            @Override // com.google.android.gms.internal.measurement.zzjv
            public final int zza() {
                return this.zzh;
            }

            public static zzb zza(int i10) {
                if (i10 == 0) {
                    return UNKNOWN_COMPARISON_TYPE;
                }
                if (i10 == 1) {
                    return LESS_THAN;
                }
                if (i10 == 2) {
                    return GREATER_THAN;
                }
                if (i10 == 3) {
                    return EQUAL;
                }
                if (i10 != 4) {
                    return null;
                }
                return BETWEEN;
            }
        }

        static {
            zzd zzdVar = new zzd();
            zzc = zzdVar;
            zzjt.zza((Class<zzd>) zzd.class, zzdVar);
        }

        private zzd() {
        }

        public static zzd zzc() {
            return zzc;
        }

        public final zzb zza() {
            zzb zzbVarZza = zzb.zza(this.zzf);
            return zzbVarZza == null ? zzb.UNKNOWN_COMPARISON_TYPE : zzbVarZza;
        }

        public final String zzd() {
            return this.zzh;
        }

        public final String zze() {
            return this.zzj;
        }

        public final String zzf() {
            return this.zzi;
        }

        public final boolean zzg() {
            return this.zzg;
        }

        public final boolean zzh() {
            return (this.zze & 1) != 0;
        }

        public final boolean zzi() {
            return (this.zze & 4) != 0;
        }

        public final boolean zzj() {
            return (this.zze & 2) != 0;
        }

        public final boolean zzk() {
            return (this.zze & 16) != 0;
        }

        public final boolean zzl() {
            return (this.zze & 8) != 0;
        }

        @Override // com.google.android.gms.internal.measurement.zzjt
        public final Object zza(int i10, Object obj, Object obj2) {
            zzfg zzfgVar = null;
            switch (zzfg.zza[i10 - 1]) {
                case 1:
                    return new zzd();
                case 2:
                    return new zza(zzfgVar);
                case 3:
                    return zzjt.zza(zzc, "\u0001\u0005\u0000\u0001\u0001\u0005\u0005\u0000\u0000\u0000\u0001᠌\u0000\u0002ဇ\u0001\u0003ဈ\u0002\u0004ဈ\u0003\u0005ဈ\u0004", new Object[]{"zze", "zzf", zzb.zzb(), "zzg", "zzh", "zzi", "zzj"});
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
