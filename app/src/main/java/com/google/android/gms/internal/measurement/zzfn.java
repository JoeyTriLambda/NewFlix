package com.google.android.gms.internal.measurement;

import com.google.android.gms.internal.measurement.zzfh;
import com.google.android.gms.internal.measurement.zzgb;
import com.google.android.gms.internal.measurement.zzjt;
import java.util.Collections;
import java.util.List;

/* compiled from: com.google.android.gms:play-services-measurement@@21.6.1 */
/* loaded from: classes.dex */
public final class zzfn {

    /* compiled from: com.google.android.gms:play-services-measurement@@21.6.1 */
    public static final class zza extends zzjt<zza, C0076zza> implements zzli {
        private static final zza zzc;
        private static volatile zzlp<zza> zzd;
        private int zze;
        private boolean zzi;
        private zzkc<zzb> zzf = zzjt.zzcc();
        private zzkc<zzc> zzg = zzjt.zzcc();
        private zzkc<zzf> zzh = zzjt.zzcc();
        private zzkc<zzb> zzj = zzjt.zzcc();

        /* compiled from: com.google.android.gms:play-services-measurement@@21.6.1 */
        /* renamed from: com.google.android.gms.internal.measurement.zzfn$zza$zza, reason: collision with other inner class name */
        public static final class C0076zza extends zzjt.zza<zza, C0076zza> implements zzli {
            private C0076zza() {
                super(zza.zzc);
            }

            public /* synthetic */ C0076zza(zzfm zzfmVar) {
                this();
            }
        }

        /* compiled from: com.google.android.gms:play-services-measurement@@21.6.1 */
        public static final class zzb extends zzjt<zzb, C0077zza> implements zzli {
            private static final zzb zzc;
            private static volatile zzlp<zzb> zzd;
            private int zze;
            private int zzf;
            private int zzg;

            /* compiled from: com.google.android.gms:play-services-measurement@@21.6.1 */
            /* renamed from: com.google.android.gms.internal.measurement.zzfn$zza$zzb$zza, reason: collision with other inner class name */
            public static final class C0077zza extends zzjt.zza<zzb, C0077zza> implements zzli {
                private C0077zza() {
                    super(zzb.zzc);
                }

                public /* synthetic */ C0077zza(zzfm zzfmVar) {
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

            public final zzd zzb() {
                zzd zzdVarZza = zzd.zza(this.zzg);
                return zzdVarZza == null ? zzd.CONSENT_STATUS_UNSPECIFIED : zzdVarZza;
            }

            public final zze zzc() {
                zze zzeVarZza = zze.zza(this.zzf);
                return zzeVarZza == null ? zze.CONSENT_TYPE_UNSPECIFIED : zzeVarZza;
            }

            @Override // com.google.android.gms.internal.measurement.zzjt
            public final Object zza(int i10, Object obj, Object obj2) {
                zzfm zzfmVar = null;
                switch (zzfm.zza[i10 - 1]) {
                    case 1:
                        return new zzb();
                    case 2:
                        return new C0077zza(zzfmVar);
                    case 3:
                        return zzjt.zza(zzc, "\u0001\u0002\u0000\u0001\u0001\u0002\u0002\u0000\u0000\u0000\u0001᠌\u0000\u0002᠌\u0001", new Object[]{"zze", "zzf", zze.zzb(), "zzg", zzd.zzb()});
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
        public static final class zzc extends zzjt<zzc, C0078zza> implements zzli {
            private static final zzc zzc;
            private static volatile zzlp<zzc> zzd;
            private int zze;
            private int zzf;
            private int zzg;

            /* compiled from: com.google.android.gms:play-services-measurement@@21.6.1 */
            /* renamed from: com.google.android.gms.internal.measurement.zzfn$zza$zzc$zza, reason: collision with other inner class name */
            public static final class C0078zza extends zzjt.zza<zzc, C0078zza> implements zzli {
                private C0078zza() {
                    super(zzc.zzc);
                }

                public /* synthetic */ C0078zza(zzfm zzfmVar) {
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

            public final zze zzb() {
                zze zzeVarZza = zze.zza(this.zzg);
                return zzeVarZza == null ? zze.CONSENT_TYPE_UNSPECIFIED : zzeVarZza;
            }

            public final zze zzc() {
                zze zzeVarZza = zze.zza(this.zzf);
                return zzeVarZza == null ? zze.CONSENT_TYPE_UNSPECIFIED : zzeVarZza;
            }

            @Override // com.google.android.gms.internal.measurement.zzjt
            public final Object zza(int i10, Object obj, Object obj2) {
                zzfm zzfmVar = null;
                switch (zzfm.zza[i10 - 1]) {
                    case 1:
                        return new zzc();
                    case 2:
                        return new C0078zza(zzfmVar);
                    case 3:
                        return zzjt.zza(zzc, "\u0001\u0002\u0000\u0001\u0001\u0002\u0002\u0000\u0000\u0000\u0001᠌\u0000\u0002᠌\u0001", new Object[]{"zze", "zzf", zze.zzb(), "zzg", zze.zzb()});
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
        public enum zzd implements zzjv {
            CONSENT_STATUS_UNSPECIFIED(0),
            GRANTED(1),
            DENIED(2);

            private static final zzjy<zzd> zzd = new zzfo();
            private final int zzf;

            zzd(int i10) {
                this.zzf = i10;
            }

            public static zzjx zzb() {
                return zzfp.zza;
            }

            @Override // java.lang.Enum
            public final String toString() {
                return "<" + zzd.class.getName() + '@' + Integer.toHexString(System.identityHashCode(this)) + " number=" + this.zzf + " name=" + name() + '>';
            }

            @Override // com.google.android.gms.internal.measurement.zzjv
            public final int zza() {
                return this.zzf;
            }

            public static zzd zza(int i10) {
                if (i10 == 0) {
                    return CONSENT_STATUS_UNSPECIFIED;
                }
                if (i10 == 1) {
                    return GRANTED;
                }
                if (i10 != 2) {
                    return null;
                }
                return DENIED;
            }
        }

        /* compiled from: com.google.android.gms:play-services-measurement@@21.6.1 */
        public enum zze implements zzjv {
            CONSENT_TYPE_UNSPECIFIED(0),
            AD_STORAGE(1),
            ANALYTICS_STORAGE(2),
            AD_USER_DATA(3),
            AD_PERSONALIZATION(4);

            private static final zzjy<zze> zzf = new zzfr();
            private final int zzh;

            zze(int i10) {
                this.zzh = i10;
            }

            public static zzjx zzb() {
                return zzfq.zza;
            }

            @Override // java.lang.Enum
            public final String toString() {
                return "<" + zze.class.getName() + '@' + Integer.toHexString(System.identityHashCode(this)) + " number=" + this.zzh + " name=" + name() + '>';
            }

            @Override // com.google.android.gms.internal.measurement.zzjv
            public final int zza() {
                return this.zzh;
            }

            public static zze zza(int i10) {
                if (i10 == 0) {
                    return CONSENT_TYPE_UNSPECIFIED;
                }
                if (i10 == 1) {
                    return AD_STORAGE;
                }
                if (i10 == 2) {
                    return ANALYTICS_STORAGE;
                }
                if (i10 == 3) {
                    return AD_USER_DATA;
                }
                if (i10 != 4) {
                    return null;
                }
                return AD_PERSONALIZATION;
            }
        }

        /* compiled from: com.google.android.gms:play-services-measurement@@21.6.1 */
        public static final class zzf extends zzjt<zzf, C0079zza> implements zzli {
            private static final zzf zzc;
            private static volatile zzlp<zzf> zzd;
            private int zze;
            private String zzf = "";
            private String zzg = "";

            /* compiled from: com.google.android.gms:play-services-measurement@@21.6.1 */
            /* renamed from: com.google.android.gms.internal.measurement.zzfn$zza$zzf$zza, reason: collision with other inner class name */
            public static final class C0079zza extends zzjt.zza<zzf, C0079zza> implements zzli {
                private C0079zza() {
                    super(zzf.zzc);
                }

                public /* synthetic */ C0079zza(zzfm zzfmVar) {
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

            public final String zzb() {
                return this.zzf;
            }

            @Override // com.google.android.gms.internal.measurement.zzjt
            public final Object zza(int i10, Object obj, Object obj2) {
                zzfm zzfmVar = null;
                switch (zzfm.zza[i10 - 1]) {
                    case 1:
                        return new zzf();
                    case 2:
                        return new C0079zza(zzfmVar);
                    case 3:
                        return zzjt.zza(zzc, "\u0001\u0002\u0000\u0001\u0001\u0002\u0002\u0000\u0000\u0000\u0001ဈ\u0000\u0002ဈ\u0001", new Object[]{"zze", "zzf", "zzg"});
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

        static {
            zza zzaVar = new zza();
            zzc = zzaVar;
            zzjt.zza((Class<zza>) zza.class, zzaVar);
        }

        private zza() {
        }

        public static zza zzb() {
            return zzc;
        }

        public final List<zzf> zzc() {
            return this.zzh;
        }

        public final List<zzb> zzd() {
            return this.zzf;
        }

        public final List<zzc> zze() {
            return this.zzg;
        }

        public final List<zzb> zzf() {
            return this.zzj;
        }

        public final boolean zzg() {
            return this.zzi;
        }

        public final boolean zzh() {
            return (this.zze & 1) != 0;
        }

        @Override // com.google.android.gms.internal.measurement.zzjt
        public final Object zza(int i10, Object obj, Object obj2) {
            zzfm zzfmVar = null;
            switch (zzfm.zza[i10 - 1]) {
                case 1:
                    return new zza();
                case 2:
                    return new C0076zza(zzfmVar);
                case 3:
                    return zzjt.zza(zzc, "\u0001\u0005\u0000\u0001\u0001\u0005\u0005\u0000\u0004\u0000\u0001\u001b\u0002\u001b\u0003\u001b\u0004ဇ\u0000\u0005\u001b", new Object[]{"zze", "zzf", zzb.class, "zzg", zzc.class, "zzh", zzf.class, "zzi", "zzj", zzb.class});
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
        private zzkc<zzf> zzg = zzjt.zzcc();
        private boolean zzh;

        /* compiled from: com.google.android.gms:play-services-measurement@@21.6.1 */
        public static final class zza extends zzjt.zza<zzb, zza> implements zzli {
            private zza() {
                super(zzb.zzc);
            }

            public /* synthetic */ zza(zzfm zzfmVar) {
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

        @Override // com.google.android.gms.internal.measurement.zzjt
        public final Object zza(int i10, Object obj, Object obj2) {
            zzfm zzfmVar = null;
            switch (zzfm.zza[i10 - 1]) {
                case 1:
                    return new zzb();
                case 2:
                    return new zza(zzfmVar);
                case 3:
                    return zzjt.zza(zzc, "\u0001\u0003\u0000\u0001\u0001\u0003\u0003\u0000\u0001\u0000\u0001ဈ\u0000\u0002\u001b\u0003ဇ\u0001", new Object[]{"zze", "zzf", "zzg", zzf.class, "zzh"});
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
        private String zzf = "";
        private boolean zzg;
        private boolean zzh;
        private int zzi;

        /* compiled from: com.google.android.gms:play-services-measurement@@21.6.1 */
        public static final class zza extends zzjt.zza<zzc, zza> implements zzli {
            private zza() {
                super(zzc.zzc);
            }

            public final int zza() {
                return ((zzc) this.zza).zza();
            }

            public final String zzb() {
                return ((zzc) this.zza).zzc();
            }

            public final boolean zzc() {
                return ((zzc) this.zza).zzd();
            }

            public final boolean zzd() {
                return ((zzc) this.zza).zze();
            }

            public final boolean zze() {
                return ((zzc) this.zza).zzf();
            }

            public final boolean zzf() {
                return ((zzc) this.zza).zzg();
            }

            public final boolean zzg() {
                return ((zzc) this.zza).zzh();
            }

            public /* synthetic */ zza(zzfm zzfmVar) {
                this();
            }

            public final zza zza(String str) {
                zzak();
                ((zzc) this.zza).zza(str);
                return this;
            }
        }

        static {
            zzc zzcVar = new zzc();
            zzc = zzcVar;
            zzjt.zza((Class<zzc>) zzc.class, zzcVar);
        }

        private zzc() {
        }

        public final int zza() {
            return this.zzi;
        }

        public final String zzc() {
            return this.zzf;
        }

        public final boolean zzd() {
            return this.zzg;
        }

        public final boolean zze() {
            return this.zzh;
        }

        public final boolean zzf() {
            return (this.zze & 2) != 0;
        }

        public final boolean zzg() {
            return (this.zze & 4) != 0;
        }

        public final boolean zzh() {
            return (this.zze & 8) != 0;
        }

        @Override // com.google.android.gms.internal.measurement.zzjt
        public final Object zza(int i10, Object obj, Object obj2) {
            zzfm zzfmVar = null;
            switch (zzfm.zza[i10 - 1]) {
                case 1:
                    return new zzc();
                case 2:
                    return new zza(zzfmVar);
                case 3:
                    return zzjt.zza(zzc, "\u0001\u0004\u0000\u0001\u0001\u0004\u0004\u0000\u0000\u0000\u0001ဈ\u0000\u0002ဇ\u0001\u0003ဇ\u0002\u0004င\u0003", new Object[]{"zze", "zzf", "zzg", "zzh", "zzi"});
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
            this.zze |= 1;
            this.zzf = str;
        }
    }

    /* compiled from: com.google.android.gms:play-services-measurement@@21.6.1 */
    public static final class zzd extends zzjt<zzd, zza> implements zzli {
        private static final zzd zzc;
        private static volatile zzlp<zzd> zzd;
        private int zze;
        private long zzf;
        private int zzh;
        private boolean zzm;
        private zza zzr;
        private zze zzs;
        private zzh zzt;
        private zzf zzu;
        private String zzg = "";
        private zzkc<zzg> zzi = zzjt.zzcc();
        private zzkc<zzc> zzj = zzjt.zzcc();
        private zzkc<zzfh.zza> zzk = zzjt.zzcc();
        private String zzl = "";
        private zzkc<zzgb.zzc> zzn = zzjt.zzcc();
        private zzkc<zzb> zzo = zzjt.zzcc();
        private String zzp = "";
        private String zzq = "";

        /* compiled from: com.google.android.gms:play-services-measurement@@21.6.1 */
        public static final class zza extends zzjt.zza<zzd, zza> implements zzli {
            private zza() {
                super(zzd.zzc);
            }

            public final int zza() {
                return ((zzd) this.zza).zzb();
            }

            public final zza zzb() {
                zzak();
                ((zzd) this.zza).zzt();
                return this;
            }

            public final String zzc() {
                return ((zzd) this.zza).zzj();
            }

            public final List<zzfh.zza> zzd() {
                return Collections.unmodifiableList(((zzd) this.zza).zzk());
            }

            public final List<zzb> zze() {
                return Collections.unmodifiableList(((zzd) this.zza).zzl());
            }

            public /* synthetic */ zza(zzfm zzfmVar) {
                this();
            }

            public final zzc zza(int i10) {
                return ((zzd) this.zza).zza(i10);
            }

            public final zza zza(int i10, zzc.zza zzaVar) {
                zzak();
                ((zzd) this.zza).zza(i10, (zzc) ((zzjt) zzaVar.zzah()));
                return this;
            }
        }

        static {
            zzd zzdVar = new zzd();
            zzc = zzdVar;
            zzjt.zza((Class<zzd>) zzd.class, zzdVar);
        }

        private zzd() {
        }

        public static zza zze() {
            return zzc.zzbx();
        }

        public static zzd zzg() {
            return zzc;
        }

        /* JADX INFO: Access modifiers changed from: private */
        public final void zzt() {
            this.zzk = zzjt.zzcc();
        }

        public final int zza() {
            return this.zzn.size();
        }

        public final int zzb() {
            return this.zzj.size();
        }

        public final long zzc() {
            return this.zzf;
        }

        public final zza zzd() {
            zza zzaVar = this.zzr;
            return zzaVar == null ? zza.zzb() : zzaVar;
        }

        public final zzh zzh() {
            zzh zzhVar = this.zzt;
            return zzhVar == null ? zzh.zzc() : zzhVar;
        }

        public final String zzi() {
            return this.zzg;
        }

        public final String zzj() {
            return this.zzp;
        }

        public final List<zzfh.zza> zzk() {
            return this.zzk;
        }

        public final List<zzb> zzl() {
            return this.zzo;
        }

        public final List<zzgb.zzc> zzm() {
            return this.zzn;
        }

        public final List<zzg> zzn() {
            return this.zzi;
        }

        public final boolean zzo() {
            return this.zzm;
        }

        public final boolean zzp() {
            return (this.zze & 128) != 0;
        }

        public final boolean zzq() {
            return (this.zze & 2) != 0;
        }

        public final boolean zzr() {
            return (this.zze & 512) != 0;
        }

        public final boolean zzs() {
            return (this.zze & 1) != 0;
        }

        public final zzc zza(int i10) {
            return this.zzj.get(i10);
        }

        @Override // com.google.android.gms.internal.measurement.zzjt
        public final Object zza(int i10, Object obj, Object obj2) {
            zzfm zzfmVar = null;
            switch (zzfm.zza[i10 - 1]) {
                case 1:
                    return new zzd();
                case 2:
                    return new zza(zzfmVar);
                case 3:
                    return zzjt.zza(zzc, "\u0001\u0010\u0000\u0001\u0001\u0012\u0010\u0000\u0005\u0000\u0001ဂ\u0000\u0002ဈ\u0001\u0003င\u0002\u0004\u001b\u0005\u001b\u0006\u001b\u0007ဈ\u0003\bဇ\u0004\t\u001b\n\u001b\u000bဈ\u0005\u000eဈ\u0006\u000fဉ\u0007\u0010ဉ\b\u0011ဉ\t\u0012ဉ\n", new Object[]{"zze", "zzf", "zzg", "zzh", "zzi", zzg.class, "zzj", zzc.class, "zzk", zzfh.zza.class, "zzl", "zzm", "zzn", zzgb.zzc.class, "zzo", zzb.class, "zzp", "zzq", "zzr", "zzs", "zzt", "zzu"});
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

        /* JADX INFO: Access modifiers changed from: private */
        public final void zza(int i10, zzc zzcVar) {
            zzcVar.getClass();
            zzkc<zzc> zzkcVar = this.zzj;
            if (!zzkcVar.zzc()) {
                this.zzj = zzjt.zza(zzkcVar);
            }
            this.zzj.set(i10, zzcVar);
        }
    }

    /* compiled from: com.google.android.gms:play-services-measurement@@21.6.1 */
    public static final class zze extends zzjt<zze, zza> implements zzli {
        private static final zze zzc;
        private static volatile zzlp<zze> zzd;
        private int zze;
        private int zzf = 14;
        private int zzg = 11;
        private int zzh = 60;

        /* compiled from: com.google.android.gms:play-services-measurement@@21.6.1 */
        public static final class zza extends zzjt.zza<zze, zza> implements zzli {
            private zza() {
                super(zze.zzc);
            }

            public /* synthetic */ zza(zzfm zzfmVar) {
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

        @Override // com.google.android.gms.internal.measurement.zzjt
        public final Object zza(int i10, Object obj, Object obj2) {
            zzfm zzfmVar = null;
            switch (zzfm.zza[i10 - 1]) {
                case 1:
                    return new zze();
                case 2:
                    return new zza(zzfmVar);
                case 3:
                    return zzjt.zza(zzc, "\u0001\u0003\u0000\u0001\u0001\u0003\u0003\u0000\u0000\u0000\u0001င\u0000\u0002င\u0001\u0003င\u0002", new Object[]{"zze", "zzf", "zzg", "zzh"});
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
    }

    /* compiled from: com.google.android.gms:play-services-measurement@@21.6.1 */
    public static final class zzf extends zzjt<zzf, zza> implements zzli {
        private static final zzf zzc;
        private static volatile zzlp<zzf> zzd;
        private int zze;
        private String zzf = "";
        private String zzg = "";

        /* compiled from: com.google.android.gms:play-services-measurement@@21.6.1 */
        public static final class zza extends zzjt.zza<zzf, zza> implements zzli {
            private zza() {
                super(zzf.zzc);
            }

            public /* synthetic */ zza(zzfm zzfmVar) {
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

        @Override // com.google.android.gms.internal.measurement.zzjt
        public final Object zza(int i10, Object obj, Object obj2) {
            zzfm zzfmVar = null;
            switch (zzfm.zza[i10 - 1]) {
                case 1:
                    return new zzf();
                case 2:
                    return new zza(zzfmVar);
                case 3:
                    return zzjt.zza(zzc, "\u0001\u0002\u0000\u0001\u0001\u0002\u0002\u0000\u0000\u0000\u0001ဈ\u0000\u0002ဈ\u0001", new Object[]{"zze", "zzf", "zzg"});
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
    public static final class zzg extends zzjt<zzg, zza> implements zzli {
        private static final zzg zzc;
        private static volatile zzlp<zzg> zzd;
        private int zze;
        private String zzf = "";
        private String zzg = "";

        /* compiled from: com.google.android.gms:play-services-measurement@@21.6.1 */
        public static final class zza extends zzjt.zza<zzg, zza> implements zzli {
            private zza() {
                super(zzg.zzc);
            }

            public /* synthetic */ zza(zzfm zzfmVar) {
                this();
            }
        }

        static {
            zzg zzgVar = new zzg();
            zzc = zzgVar;
            zzjt.zza((Class<zzg>) zzg.class, zzgVar);
        }

        private zzg() {
        }

        public final String zzb() {
            return this.zzf;
        }

        public final String zzc() {
            return this.zzg;
        }

        @Override // com.google.android.gms.internal.measurement.zzjt
        public final Object zza(int i10, Object obj, Object obj2) {
            zzfm zzfmVar = null;
            switch (zzfm.zza[i10 - 1]) {
                case 1:
                    return new zzg();
                case 2:
                    return new zza(zzfmVar);
                case 3:
                    return zzjt.zza(zzc, "\u0001\u0002\u0000\u0001\u0001\u0002\u0002\u0000\u0000\u0000\u0001ဈ\u0000\u0002ဈ\u0001", new Object[]{"zze", "zzf", "zzg"});
                case 4:
                    return zzc;
                case 5:
                    zzlp<zzg> zzcVar = zzd;
                    if (zzcVar == null) {
                        synchronized (zzg.class) {
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
    public static final class zzh extends zzjt<zzh, zza> implements zzli {
        private static final zzh zzc;
        private static volatile zzlp<zzh> zzd;
        private int zze;
        private String zzf = "";
        private String zzg = "";
        private String zzh = "";
        private int zzi;

        /* compiled from: com.google.android.gms:play-services-measurement@@21.6.1 */
        public static final class zza extends zzjt.zza<zzh, zza> implements zzli {
            private zza() {
                super(zzh.zzc);
            }

            public /* synthetic */ zza(zzfm zzfmVar) {
                this();
            }
        }

        static {
            zzh zzhVar = new zzh();
            zzc = zzhVar;
            zzjt.zza((Class<zzh>) zzh.class, zzhVar);
        }

        private zzh() {
        }

        public static zzh zzc() {
            return zzc;
        }

        public final int zza() {
            return this.zzi;
        }

        public final String zzd() {
            return this.zzg;
        }

        public final String zze() {
            return this.zzf;
        }

        @Override // com.google.android.gms.internal.measurement.zzjt
        public final Object zza(int i10, Object obj, Object obj2) {
            zzfm zzfmVar = null;
            switch (zzfm.zza[i10 - 1]) {
                case 1:
                    return new zzh();
                case 2:
                    return new zza(zzfmVar);
                case 3:
                    return zzjt.zza(zzc, "\u0001\u0004\u0000\u0001\u0001\u0004\u0004\u0000\u0000\u0000\u0001ဈ\u0000\u0002ဈ\u0001\u0003ဈ\u0002\u0004င\u0003", new Object[]{"zze", "zzf", "zzg", "zzh", "zzi"});
                case 4:
                    return zzc;
                case 5:
                    zzlp<zzh> zzcVar = zzd;
                    if (zzcVar == null) {
                        synchronized (zzh.class) {
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
