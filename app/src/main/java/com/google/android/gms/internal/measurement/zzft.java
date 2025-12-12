package com.google.android.gms.internal.measurement;

import com.google.android.gms.internal.measurement.zzjt;
import java.util.Collections;
import java.util.List;
import okhttp3.internal.http2.Http2;
import okhttp3.internal.http2.Http2Connection;

/* compiled from: com.google.android.gms:play-services-measurement@@21.6.1 */
/* loaded from: classes.dex */
public final class zzft {

    /* compiled from: com.google.android.gms:play-services-measurement@@21.6.1 */
    public static final class zza extends zzjt<zza, C0080zza> implements zzli {
        private static final zza zzc;
        private static volatile zzlp<zza> zzd;
        private int zze;
        private String zzf = "";
        private String zzg = "";
        private String zzh = "";
        private String zzi = "";
        private String zzj = "";
        private String zzk = "";
        private String zzl = "";

        /* compiled from: com.google.android.gms:play-services-measurement@@21.6.1 */
        /* renamed from: com.google.android.gms.internal.measurement.zzft$zza$zza, reason: collision with other inner class name */
        public static final class C0080zza extends zzjt.zza<zza, C0080zza> implements zzli {
            private C0080zza() {
                super(zza.zzc);
            }

            public /* synthetic */ C0080zza(zzfs zzfsVar) {
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

        @Override // com.google.android.gms.internal.measurement.zzjt
        public final Object zza(int i10, Object obj, Object obj2) {
            zzfs zzfsVar = null;
            switch (zzfs.zza[i10 - 1]) {
                case 1:
                    return new zza();
                case 2:
                    return new C0080zza(zzfsVar);
                case 3:
                    return zzjt.zza(zzc, "\u0001\u0007\u0000\u0001\u0001\u0007\u0007\u0000\u0000\u0000\u0001ဈ\u0000\u0002ဈ\u0001\u0003ဈ\u0002\u0004ဈ\u0003\u0005ဈ\u0004\u0006ဈ\u0005\u0007ဈ\u0006", new Object[]{"zze", "zzf", "zzg", "zzh", "zzi", "zzj", "zzk", "zzl"});
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
        private boolean zzf;
        private boolean zzg;
        private boolean zzh;
        private boolean zzi;
        private boolean zzj;
        private boolean zzk;
        private boolean zzl;

        /* compiled from: com.google.android.gms:play-services-measurement@@21.6.1 */
        public static final class zza extends zzjt.zza<zzb, zza> implements zzli {
            private zza() {
                super(zzb.zzc);
            }

            public final zza zza(boolean z10) {
                zzak();
                ((zzb) this.zza).zza(z10);
                return this;
            }

            public final zza zzb(boolean z10) {
                zzak();
                ((zzb) this.zza).zzb(z10);
                return this;
            }

            public final zza zzc(boolean z10) {
                zzak();
                ((zzb) this.zza).zzc(z10);
                return this;
            }

            public final zza zzd(boolean z10) {
                zzak();
                ((zzb) this.zza).zzd(z10);
                return this;
            }

            public final zza zze(boolean z10) {
                zzak();
                ((zzb) this.zza).zze(z10);
                return this;
            }

            public final zza zzf(boolean z10) {
                zzak();
                ((zzb) this.zza).zzf(z10);
                return this;
            }

            public final zza zzg(boolean z10) {
                zzak();
                ((zzb) this.zza).zzg(z10);
                return this;
            }

            public /* synthetic */ zza(zzfs zzfsVar) {
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

        public static zza zza() {
            return zzc.zzbx();
        }

        public static zzb zzc() {
            return zzc;
        }

        public final boolean zzh() {
            return this.zzg;
        }

        public final boolean zzi() {
            return this.zzh;
        }

        public final boolean zzj() {
            return this.zzi;
        }

        /* JADX INFO: Access modifiers changed from: private */
        public final void zzd(boolean z10) {
            this.zze |= 64;
            this.zzl = z10;
        }

        /* JADX INFO: Access modifiers changed from: private */
        public final void zze(boolean z10) {
            this.zze |= 2;
            this.zzg = z10;
        }

        /* JADX INFO: Access modifiers changed from: private */
        public final void zzf(boolean z10) {
            this.zze |= 4;
            this.zzh = z10;
        }

        /* JADX INFO: Access modifiers changed from: private */
        public final void zzg(boolean z10) {
            this.zze |= 8;
            this.zzi = z10;
        }

        @Override // com.google.android.gms.internal.measurement.zzjt
        public final Object zza(int i10, Object obj, Object obj2) {
            zzfs zzfsVar = null;
            switch (zzfs.zza[i10 - 1]) {
                case 1:
                    return new zzb();
                case 2:
                    return new zza(zzfsVar);
                case 3:
                    return zzjt.zza(zzc, "\u0001\u0007\u0000\u0001\u0001\u0007\u0007\u0000\u0000\u0000\u0001ဇ\u0000\u0002ဇ\u0001\u0003ဇ\u0002\u0004ဇ\u0003\u0005ဇ\u0004\u0006ဇ\u0005\u0007ဇ\u0006", new Object[]{"zze", "zzf", "zzg", "zzh", "zzi", "zzj", "zzk", "zzl"});
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
        public final void zzb(boolean z10) {
            this.zze |= 16;
            this.zzj = z10;
        }

        /* JADX INFO: Access modifiers changed from: private */
        public final void zzc(boolean z10) {
            this.zze |= 1;
            this.zzf = z10;
        }

        public final boolean zzd() {
            return this.zzk;
        }

        public final boolean zze() {
            return this.zzj;
        }

        public final boolean zzf() {
            return this.zzf;
        }

        public final boolean zzg() {
            return this.zzl;
        }

        /* JADX INFO: Access modifiers changed from: private */
        public final void zza(boolean z10) {
            this.zze |= 32;
            this.zzk = z10;
        }
    }

    /* compiled from: com.google.android.gms:play-services-measurement@@21.6.1 */
    public static final class zzc extends zzjt<zzc, zza> implements zzli {
        private static final zzc zzc;
        private static volatile zzlp<zzc> zzd;
        private int zze;
        private int zzf;
        private zzl zzg;
        private zzl zzh;
        private boolean zzi;

        /* compiled from: com.google.android.gms:play-services-measurement@@21.6.1 */
        public static final class zza extends zzjt.zza<zzc, zza> implements zzli {
            private zza() {
                super(zzc.zzc);
            }

            public final zza zza(int i10) {
                zzak();
                ((zzc) this.zza).zza(i10);
                return this;
            }

            public /* synthetic */ zza(zzfs zzfsVar) {
                this();
            }

            public final zza zza(zzl.zza zzaVar) {
                zzak();
                ((zzc) this.zza).zza((zzl) ((zzjt) zzaVar.zzah()));
                return this;
            }

            public final zza zza(boolean z10) {
                zzak();
                ((zzc) this.zza).zza(z10);
                return this;
            }

            public final zza zza(zzl zzlVar) {
                zzak();
                ((zzc) this.zza).zzb(zzlVar);
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

        public static zza zzb() {
            return zzc.zzbx();
        }

        public final int zza() {
            return this.zzf;
        }

        public final zzl zzd() {
            zzl zzlVar = this.zzg;
            return zzlVar == null ? zzl.zzg() : zzlVar;
        }

        public final zzl zze() {
            zzl zzlVar = this.zzh;
            return zzlVar == null ? zzl.zzg() : zzlVar;
        }

        public final boolean zzf() {
            return this.zzi;
        }

        public final boolean zzg() {
            return (this.zze & 1) != 0;
        }

        public final boolean zzh() {
            return (this.zze & 8) != 0;
        }

        public final boolean zzi() {
            return (this.zze & 4) != 0;
        }

        @Override // com.google.android.gms.internal.measurement.zzjt
        public final Object zza(int i10, Object obj, Object obj2) {
            zzfs zzfsVar = null;
            switch (zzfs.zza[i10 - 1]) {
                case 1:
                    return new zzc();
                case 2:
                    return new zza(zzfsVar);
                case 3:
                    return zzjt.zza(zzc, "\u0001\u0004\u0000\u0001\u0001\u0004\u0004\u0000\u0000\u0000\u0001င\u0000\u0002ဉ\u0001\u0003ဉ\u0002\u0004ဇ\u0003", new Object[]{"zze", "zzf", "zzg", "zzh", "zzi"});
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
        public final void zzb(zzl zzlVar) {
            zzlVar.getClass();
            this.zzh = zzlVar;
            this.zze |= 4;
        }

        /* JADX INFO: Access modifiers changed from: private */
        public final void zza(int i10) {
            this.zze |= 1;
            this.zzf = i10;
        }

        /* JADX INFO: Access modifiers changed from: private */
        public final void zza(zzl zzlVar) {
            zzlVar.getClass();
            this.zzg = zzlVar;
            this.zze |= 2;
        }

        /* JADX INFO: Access modifiers changed from: private */
        public final void zza(boolean z10) {
            this.zze |= 8;
            this.zzi = z10;
        }
    }

    /* compiled from: com.google.android.gms:play-services-measurement@@21.6.1 */
    public static final class zzd extends zzjt<zzd, zza> implements zzli {
        private static final zzd zzc;
        private static volatile zzlp<zzd> zzd;
        private int zze;
        private int zzf;
        private long zzg;

        /* compiled from: com.google.android.gms:play-services-measurement@@21.6.1 */
        public static final class zza extends zzjt.zza<zzd, zza> implements zzli {
            private zza() {
                super(zzd.zzc);
            }

            public final zza zza(long j10) {
                zzak();
                ((zzd) this.zza).zza(j10);
                return this;
            }

            public /* synthetic */ zza(zzfs zzfsVar) {
                this();
            }

            public final zza zza(int i10) {
                zzak();
                ((zzd) this.zza).zza(i10);
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

        public static zza zzc() {
            return zzc.zzbx();
        }

        public final int zza() {
            return this.zzf;
        }

        public final long zzb() {
            return this.zzg;
        }

        public final boolean zze() {
            return (this.zze & 2) != 0;
        }

        public final boolean zzf() {
            return (this.zze & 1) != 0;
        }

        @Override // com.google.android.gms.internal.measurement.zzjt
        public final Object zza(int i10, Object obj, Object obj2) {
            zzfs zzfsVar = null;
            switch (zzfs.zza[i10 - 1]) {
                case 1:
                    return new zzd();
                case 2:
                    return new zza(zzfsVar);
                case 3:
                    return zzjt.zza(zzc, "\u0001\u0002\u0000\u0001\u0001\u0002\u0002\u0000\u0000\u0000\u0001င\u0000\u0002ဂ\u0001", new Object[]{"zze", "zzf", "zzg"});
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
        public final void zza(long j10) {
            this.zze |= 2;
            this.zzg = j10;
        }

        /* JADX INFO: Access modifiers changed from: private */
        public final void zza(int i10) {
            this.zze |= 1;
            this.zzf = i10;
        }
    }

    /* compiled from: com.google.android.gms:play-services-measurement@@21.6.1 */
    public static final class zze extends zzjt<zze, zza> implements zzli {
        private static final zze zzc;
        private static volatile zzlp<zze> zzd;
        private int zze;
        private zzkc<zzg> zzf = zzjt.zzcc();
        private String zzg = "";
        private long zzh;
        private long zzi;
        private int zzj;

        /* compiled from: com.google.android.gms:play-services-measurement@@21.6.1 */
        public static final class zza extends zzjt.zza<zze, zza> implements zzli {
            private zza() {
                super(zze.zzc);
            }

            public final int zza() {
                return ((zze) this.zza).zzb();
            }

            public final long zzb() {
                return ((zze) this.zza).zzc();
            }

            public final long zzc() {
                return ((zze) this.zza).zzd();
            }

            public final zza zzd() {
                zzak();
                ((zze) this.zza).zzl();
                return this;
            }

            public final String zze() {
                return ((zze) this.zza).zzg();
            }

            public final List<zzg> zzf() {
                return Collections.unmodifiableList(((zze) this.zza).zzh());
            }

            public final boolean zzg() {
                return ((zze) this.zza).zzk();
            }

            public /* synthetic */ zza(zzfs zzfsVar) {
                this();
            }

            public final zza zza(Iterable<? extends zzg> iterable) {
                zzak();
                ((zze) this.zza).zza(iterable);
                return this;
            }

            public final zza zzb(long j10) {
                zzak();
                ((zze) this.zza).zzb(j10);
                return this;
            }

            public final zza zza(zzg.zza zzaVar) {
                zzak();
                ((zze) this.zza).zza((zzg) ((zzjt) zzaVar.zzah()));
                return this;
            }

            public final zzg zzb(int i10) {
                return ((zze) this.zza).zza(i10);
            }

            public final zza zza(zzg zzgVar) {
                zzak();
                ((zze) this.zza).zza(zzgVar);
                return this;
            }

            public final zza zza(int i10) {
                zzak();
                ((zze) this.zza).zzb(i10);
                return this;
            }

            public final zza zza(String str) {
                zzak();
                ((zze) this.zza).zza(str);
                return this;
            }

            public final zza zza(int i10, zzg.zza zzaVar) {
                zzak();
                ((zze) this.zza).zza(i10, (zzg) ((zzjt) zzaVar.zzah()));
                return this;
            }

            public final zza zza(int i10, zzg zzgVar) {
                zzak();
                ((zze) this.zza).zza(i10, zzgVar);
                return this;
            }

            public final zza zza(long j10) {
                zzak();
                ((zze) this.zza).zza(j10);
                return this;
            }
        }

        static {
            zze zzeVar = new zze();
            zzc = zzeVar;
            zzjt.zza((Class<zze>) zze.class, zzeVar);
        }

        private zze() {
        }

        public static zza zze() {
            return zzc.zzbx();
        }

        /* JADX INFO: Access modifiers changed from: private */
        public final void zzl() {
            this.zzf = zzjt.zzcc();
        }

        private final void zzm() {
            zzkc<zzg> zzkcVar = this.zzf;
            if (zzkcVar.zzc()) {
                return;
            }
            this.zzf = zzjt.zza(zzkcVar);
        }

        public final int zza() {
            return this.zzj;
        }

        public final int zzb() {
            return this.zzf.size();
        }

        public final long zzc() {
            return this.zzi;
        }

        public final long zzd() {
            return this.zzh;
        }

        public final String zzg() {
            return this.zzg;
        }

        public final List<zzg> zzh() {
            return this.zzf;
        }

        public final boolean zzi() {
            return (this.zze & 8) != 0;
        }

        public final boolean zzj() {
            return (this.zze & 4) != 0;
        }

        public final boolean zzk() {
            return (this.zze & 2) != 0;
        }

        public final zzg zza(int i10) {
            return this.zzf.get(i10);
        }

        /* JADX INFO: Access modifiers changed from: private */
        public final void zzb(int i10) {
            zzm();
            this.zzf.remove(i10);
        }

        @Override // com.google.android.gms.internal.measurement.zzjt
        public final Object zza(int i10, Object obj, Object obj2) {
            zzfs zzfsVar = null;
            switch (zzfs.zza[i10 - 1]) {
                case 1:
                    return new zze();
                case 2:
                    return new zza(zzfsVar);
                case 3:
                    return zzjt.zza(zzc, "\u0001\u0005\u0000\u0001\u0001\u0005\u0005\u0000\u0001\u0000\u0001\u001b\u0002ဈ\u0000\u0003ဂ\u0001\u0004ဂ\u0002\u0005င\u0003", new Object[]{"zze", "zzf", zzg.class, "zzg", "zzh", "zzi", "zzj"});
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
        public final void zzb(long j10) {
            this.zze |= 2;
            this.zzh = j10;
        }

        /* JADX INFO: Access modifiers changed from: private */
        public final void zza(Iterable<? extends zzg> iterable) {
            zzm();
            zzhz.zza(iterable, this.zzf);
        }

        /* JADX INFO: Access modifiers changed from: private */
        public final void zza(zzg zzgVar) {
            zzgVar.getClass();
            zzm();
            this.zzf.add(zzgVar);
        }

        /* JADX INFO: Access modifiers changed from: private */
        public final void zza(String str) {
            str.getClass();
            this.zze |= 1;
            this.zzg = str;
        }

        /* JADX INFO: Access modifiers changed from: private */
        public final void zza(int i10, zzg zzgVar) {
            zzgVar.getClass();
            zzm();
            this.zzf.set(i10, zzgVar);
        }

        /* JADX INFO: Access modifiers changed from: private */
        public final void zza(long j10) {
            this.zze |= 4;
            this.zzi = j10;
        }
    }

    /* compiled from: com.google.android.gms:play-services-measurement@@21.6.1 */
    public static final class zzf extends zzjt<zzf, zza> implements zzli {
        private static final zzf zzc;
        private static volatile zzlp<zzf> zzd;
        private int zze;
        private String zzf = "";
        private long zzg;

        /* compiled from: com.google.android.gms:play-services-measurement@@21.6.1 */
        public static final class zza extends zzjt.zza<zzf, zza> implements zzli {
            private zza() {
                super(zzf.zzc);
            }

            public final zza zza(long j10) {
                zzak();
                ((zzf) this.zza).zza(j10);
                return this;
            }

            public /* synthetic */ zza(zzfs zzfsVar) {
                this();
            }

            public final zza zza(String str) {
                zzak();
                ((zzf) this.zza).zza(str);
                return this;
            }
        }

        static {
            zzf zzfVar = new zzf();
            zzc = zzfVar;
            zzjt.zza((Class<zzf>) zzf.class, zzfVar);
        }

        private zzf() {
        }

        public static zza zza() {
            return zzc.zzbx();
        }

        @Override // com.google.android.gms.internal.measurement.zzjt
        public final Object zza(int i10, Object obj, Object obj2) {
            zzfs zzfsVar = null;
            switch (zzfs.zza[i10 - 1]) {
                case 1:
                    return new zzf();
                case 2:
                    return new zza(zzfsVar);
                case 3:
                    return zzjt.zza(zzc, "\u0001\u0002\u0000\u0001\u0001\u0002\u0002\u0000\u0000\u0000\u0001ဈ\u0000\u0002ဂ\u0001", new Object[]{"zze", "zzf", "zzg"});
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

        /* JADX INFO: Access modifiers changed from: private */
        public final void zza(long j10) {
            this.zze |= 2;
            this.zzg = j10;
        }

        /* JADX INFO: Access modifiers changed from: private */
        public final void zza(String str) {
            str.getClass();
            this.zze |= 1;
            this.zzf = str;
        }
    }

    /* compiled from: com.google.android.gms:play-services-measurement@@21.6.1 */
    public static final class zzg extends zzjt<zzg, zza> implements zzli {
        private static final zzg zzc;
        private static volatile zzlp<zzg> zzd;
        private int zze;
        private long zzh;
        private float zzi;
        private double zzj;
        private String zzf = "";
        private String zzg = "";
        private zzkc<zzg> zzk = zzjt.zzcc();

        /* compiled from: com.google.android.gms:play-services-measurement@@21.6.1 */
        public static final class zza extends zzjt.zza<zzg, zza> implements zzli {
            private zza() {
                super(zzg.zzc);
            }

            public final int zza() {
                return ((zzg) this.zza).zzc();
            }

            public final zza zzb() {
                zzak();
                ((zzg) this.zza).zzo();
                return this;
            }

            public final zza zzc() {
                zzak();
                ((zzg) this.zza).zzp();
                return this;
            }

            public final zza zzd() {
                zzak();
                ((zzg) this.zza).zzq();
                return this;
            }

            public final zza zze() {
                zzak();
                ((zzg) this.zza).zzr();
                return this;
            }

            public final String zzf() {
                return ((zzg) this.zza).zzg();
            }

            public final String zzg() {
                return ((zzg) this.zza).zzh();
            }

            public /* synthetic */ zza(zzfs zzfsVar) {
                this();
            }

            public final zza zza(Iterable<? extends zzg> iterable) {
                zzak();
                ((zzg) this.zza).zza(iterable);
                return this;
            }

            public final zza zzb(String str) {
                zzak();
                ((zzg) this.zza).zzb(str);
                return this;
            }

            public final zza zza(zza zzaVar) {
                zzak();
                ((zzg) this.zza).zze((zzg) ((zzjt) zzaVar.zzah()));
                return this;
            }

            public final zza zza(double d10) {
                zzak();
                ((zzg) this.zza).zza(d10);
                return this;
            }

            public final zza zza(long j10) {
                zzak();
                ((zzg) this.zza).zza(j10);
                return this;
            }

            public final zza zza(String str) {
                zzak();
                ((zzg) this.zza).zza(str);
                return this;
            }
        }

        static {
            zzg zzgVar = new zzg();
            zzc = zzgVar;
            zzjt.zza((Class<zzg>) zzg.class, zzgVar);
        }

        private zzg() {
        }

        public static zza zze() {
            return zzc.zzbx();
        }

        /* JADX INFO: Access modifiers changed from: private */
        public final void zzo() {
            this.zze &= -17;
            this.zzj = 0.0d;
        }

        /* JADX INFO: Access modifiers changed from: private */
        public final void zzp() {
            this.zze &= -5;
            this.zzh = 0L;
        }

        /* JADX INFO: Access modifiers changed from: private */
        public final void zzq() {
            this.zzk = zzjt.zzcc();
        }

        /* JADX INFO: Access modifiers changed from: private */
        public final void zzr() {
            this.zze &= -3;
            this.zzg = zzc.zzg;
        }

        private final void zzs() {
            zzkc<zzg> zzkcVar = this.zzk;
            if (zzkcVar.zzc()) {
                return;
            }
            this.zzk = zzjt.zza(zzkcVar);
        }

        public final double zza() {
            return this.zzj;
        }

        public final float zzb() {
            return this.zzi;
        }

        public final int zzc() {
            return this.zzk.size();
        }

        public final long zzd() {
            return this.zzh;
        }

        public final String zzg() {
            return this.zzf;
        }

        public final String zzh() {
            return this.zzg;
        }

        public final List<zzg> zzi() {
            return this.zzk;
        }

        public final boolean zzj() {
            return (this.zze & 16) != 0;
        }

        public final boolean zzk() {
            return (this.zze & 8) != 0;
        }

        public final boolean zzl() {
            return (this.zze & 4) != 0;
        }

        public final boolean zzm() {
            return (this.zze & 1) != 0;
        }

        public final boolean zzn() {
            return (this.zze & 2) != 0;
        }

        /* JADX INFO: Access modifiers changed from: private */
        public final void zze(zzg zzgVar) {
            zzgVar.getClass();
            zzs();
            this.zzk.add(zzgVar);
        }

        @Override // com.google.android.gms.internal.measurement.zzjt
        public final Object zza(int i10, Object obj, Object obj2) {
            zzfs zzfsVar = null;
            switch (zzfs.zza[i10 - 1]) {
                case 1:
                    return new zzg();
                case 2:
                    return new zza(zzfsVar);
                case 3:
                    return zzjt.zza(zzc, "\u0001\u0006\u0000\u0001\u0001\u0006\u0006\u0000\u0001\u0000\u0001ဈ\u0000\u0002ဈ\u0001\u0003ဂ\u0002\u0004ခ\u0003\u0005က\u0004\u0006\u001b", new Object[]{"zze", "zzf", "zzg", "zzh", "zzi", "zzj", "zzk", zzg.class});
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

        /* JADX INFO: Access modifiers changed from: private */
        public final void zzb(String str) {
            str.getClass();
            this.zze |= 2;
            this.zzg = str;
        }

        /* JADX INFO: Access modifiers changed from: private */
        public final void zza(Iterable<? extends zzg> iterable) {
            zzs();
            zzhz.zza(iterable, this.zzk);
        }

        /* JADX INFO: Access modifiers changed from: private */
        public final void zza(double d10) {
            this.zze |= 16;
            this.zzj = d10;
        }

        /* JADX INFO: Access modifiers changed from: private */
        public final void zza(long j10) {
            this.zze |= 4;
            this.zzh = j10;
        }

        /* JADX INFO: Access modifiers changed from: private */
        public final void zza(String str) {
            str.getClass();
            this.zze |= 1;
            this.zzf = str;
        }
    }

    /* compiled from: com.google.android.gms:play-services-measurement@@21.6.1 */
    public static final class zzh extends zzjt<zzh, zza> implements zzli {
        private static final zzh zzc;
        private static volatile zzlp<zzh> zzd;
        private int zze;
        private String zzf = "";
        private String zzg = "";
        private zza zzh;

        /* compiled from: com.google.android.gms:play-services-measurement@@21.6.1 */
        public static final class zza extends zzjt.zza<zzh, zza> implements zzli {
            private zza() {
                super(zzh.zzc);
            }

            public /* synthetic */ zza(zzfs zzfsVar) {
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

        @Override // com.google.android.gms.internal.measurement.zzjt
        public final Object zza(int i10, Object obj, Object obj2) {
            zzfs zzfsVar = null;
            switch (zzfs.zza[i10 - 1]) {
                case 1:
                    return new zzh();
                case 2:
                    return new zza(zzfsVar);
                case 3:
                    return zzjt.zza(zzc, "\u0001\u0003\u0000\u0001\u0001\u0003\u0003\u0000\u0000\u0000\u0001ဈ\u0000\u0002ဈ\u0001\u0003ဉ\u0002", new Object[]{"zze", "zzf", "zzg", "zzh"});
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

    /* compiled from: com.google.android.gms:play-services-measurement@@21.6.1 */
    public static final class zzi extends zzjt<zzi, zzb> implements zzli {
        private static final zzi zzc;
        private static volatile zzlp<zzi> zzd;
        private int zze;
        private zzkc<zzj> zzf = zzjt.zzcc();
        private String zzg = "";
        private String zzh = "";
        private int zzi;

        /* compiled from: com.google.android.gms:play-services-measurement@@21.6.1 */
        public enum zza implements zzjv {
            SDK(0),
            SGTM(1);

            private static final zzjy<zza> zzc = new zzfy();
            private final int zze;

            zza(int i10) {
                this.zze = i10;
            }

            public static zzjx zzb() {
                return zzfx.zza;
            }

            @Override // java.lang.Enum
            public final String toString() {
                return "<" + zza.class.getName() + '@' + Integer.toHexString(System.identityHashCode(this)) + " number=" + this.zze + " name=" + name() + '>';
            }

            @Override // com.google.android.gms.internal.measurement.zzjv
            public final int zza() {
                return this.zze;
            }

            public static zza zza(int i10) {
                if (i10 == 0) {
                    return SDK;
                }
                if (i10 != 1) {
                    return null;
                }
                return SGTM;
            }
        }

        /* compiled from: com.google.android.gms:play-services-measurement@@21.6.1 */
        public static final class zzb extends zzjt.zza<zzi, zzb> implements zzli {
            private zzb() {
                super(zzi.zzc);
            }

            public final int zza() {
                return ((zzi) this.zza).zza();
            }

            public /* synthetic */ zzb(zzfs zzfsVar) {
                this();
            }

            public final zzb zza(zzj.zza zzaVar) {
                zzak();
                ((zzi) this.zza).zza((zzj) ((zzjt) zzaVar.zzah()));
                return this;
            }

            public final zzb zza(String str) {
                zzak();
                ((zzi) this.zza).zza(str);
                return this;
            }

            public final zzj zza(int i10) {
                return ((zzi) this.zza).zza(0);
            }
        }

        static {
            zzi zziVar = new zzi();
            zzc = zziVar;
            zzjt.zza((Class<zzi>) zzi.class, zziVar);
        }

        private zzi() {
        }

        public static zzb zzb() {
            return zzc.zzbx();
        }

        public final int zza() {
            return this.zzf.size();
        }

        public final List<zzj> zzd() {
            return this.zzf;
        }

        public final zzj zza(int i10) {
            return this.zzf.get(0);
        }

        @Override // com.google.android.gms.internal.measurement.zzjt
        public final Object zza(int i10, Object obj, Object obj2) {
            zzfs zzfsVar = null;
            switch (zzfs.zza[i10 - 1]) {
                case 1:
                    return new zzi();
                case 2:
                    return new zzb(zzfsVar);
                case 3:
                    return zzjt.zza(zzc, "\u0001\u0004\u0000\u0001\u0001\t\u0004\u0000\u0001\u0000\u0001\u001b\u0007ဈ\u0000\bဈ\u0001\t᠌\u0002", new Object[]{"zze", "zzf", zzj.class, "zzg", "zzh", "zzi", zza.zzb()});
                case 4:
                    return zzc;
                case 5:
                    zzlp<zzi> zzcVar = zzd;
                    if (zzcVar == null) {
                        synchronized (zzi.class) {
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
        public final void zza(zzj zzjVar) {
            zzjVar.getClass();
            zzkc<zzj> zzkcVar = this.zzf;
            if (!zzkcVar.zzc()) {
                this.zzf = zzjt.zza(zzkcVar);
            }
            this.zzf.add(zzjVar);
        }

        /* JADX INFO: Access modifiers changed from: private */
        public final void zza(String str) {
            str.getClass();
            this.zze |= 2;
            this.zzh = str;
        }
    }

    /* compiled from: com.google.android.gms:play-services-measurement@@21.6.1 */
    public static final class zzj extends zzjt<zzj, zza> implements zzli {
        private static final zzj zzc;
        private static volatile zzlp<zzj> zzd;
        private long zzab;
        private int zzac;
        private boolean zzaf;
        private int zzai;
        private int zzaj;
        private int zzak;
        private long zzam;
        private long zzan;
        private int zzaq;
        private zzk zzas;
        private long zzau;
        private long zzav;
        private int zzay;
        private boolean zzaz;
        private boolean zzbb;
        private zzh zzbc;
        private long zzbg;
        private boolean zzbh;
        private boolean zzbj;
        private int zzbl;
        private zzb zzbn;
        private int zzbo;
        private int zze;
        private int zzf;
        private int zzg;
        private long zzj;
        private long zzk;
        private long zzl;
        private long zzm;
        private long zzn;
        private int zzs;
        private long zzw;
        private long zzx;
        private boolean zzz;
        private zzkc<zze> zzh = zzjt.zzcc();
        private zzkc<zzn> zzi = zzjt.zzcc();
        private String zzo = "";
        private String zzp = "";
        private String zzq = "";
        private String zzr = "";
        private String zzt = "";
        private String zzu = "";
        private String zzv = "";
        private String zzy = "";
        private String zzaa = "";
        private String zzad = "";
        private String zzae = "";
        private zzkc<zzc> zzag = zzjt.zzcc();
        private String zzah = "";
        private String zzal = "";
        private String zzao = "";
        private String zzap = "";
        private String zzar = "";
        private zzka zzat = zzjt.zzca();
        private String zzaw = "";
        private String zzax = "";
        private String zzba = "";
        private String zzbd = "";
        private zzkc<String> zzbe = zzjt.zzcc();
        private String zzbf = "";
        private String zzbi = "";
        private String zzbk = "";
        private String zzbm = "";

        /* compiled from: com.google.android.gms:play-services-measurement@@21.6.1 */
        public static final class zza extends zzjt.zza<zzj, zza> implements zzli {
            private zza() {
                super(zzj.zzc);
            }

            public final int zza() {
                return ((zzj) this.zza).zza();
            }

            public final List<zze> zzaa() {
                return Collections.unmodifiableList(((zzj) this.zza).zzap());
            }

            public final List<zzn> zzab() {
                return Collections.unmodifiableList(((zzj) this.zza).zzaq());
            }

            public final boolean zzac() {
                return ((zzj) this.zza).zzas();
            }

            public final boolean zzad() {
                return ((zzj) this.zza).zzat();
            }

            public final int zzb() {
                return ((zzj) this.zza).zzb();
            }

            public final int zzc() {
                return ((zzj) this.zza).zzd();
            }

            public final int zzd() {
                return ((zzj) this.zza).zzh();
            }

            public final long zze() {
                return ((zzj) this.zza).zzl();
            }

            public final long zzf() {
                return ((zzj) this.zza).zzp();
            }

            public final zza zzg() {
                zzak();
                ((zzj) this.zza).zzci();
                return this;
            }

            public final zza zzh() {
                zzak();
                ((zzj) this.zza).zzcj();
                return this;
            }

            public final zza zzi() {
                zzak();
                ((zzj) this.zza).zzck();
                return this;
            }

            public final zza zzj() {
                zzak();
                ((zzj) this.zza).zzcl();
                return this;
            }

            public final zza zzk() {
                zzak();
                ((zzj) this.zza).zzcm();
                return this;
            }

            public final zza zzl() {
                zzak();
                ((zzj) this.zza).zzcn();
                return this;
            }

            public final zza zzm() {
                zzak();
                ((zzj) this.zza).zzco();
                return this;
            }

            public final zza zzn() {
                zzak();
                ((zzj) this.zza).zzcp();
                return this;
            }

            public final zza zzo() {
                zzak();
                ((zzj) this.zza).zzcq();
                return this;
            }

            public final zza zzp() {
                zzak();
                ((zzj) this.zza).zzcr();
                return this;
            }

            public final zza zzq() {
                zzak();
                ((zzj) this.zza).zzcs();
                return this;
            }

            public final zza zzr() {
                zzak();
                ((zzj) this.zza).zzct();
                return this;
            }

            public final zza zzs() {
                zzak();
                ((zzj) this.zza).zzcu();
                return this;
            }

            public final String zzt() {
                return ((zzj) this.zza).zzx();
            }

            public final String zzu() {
                return ((zzj) this.zza).zzy();
            }

            public final String zzv() {
                return ((zzj) this.zza).zzab();
            }

            public final String zzw() {
                return ((zzj) this.zza).zzad();
            }

            public final String zzx() {
                return ((zzj) this.zza).zzah();
            }

            public final String zzy() {
                return ((zzj) this.zza).h_();
            }

            public final String zzz() {
                return ((zzj) this.zza).zzal();
            }

            public /* synthetic */ zza(zzfs zzfsVar) {
                this();
            }

            public final zze zza(int i10) {
                return ((zzj) this.zza).zza(i10);
            }

            public final zza zzb(Iterable<? extends zze> iterable) {
                zzak();
                ((zzj) this.zza).zzb(iterable);
                return this;
            }

            public final zza zzc(Iterable<? extends Integer> iterable) {
                zzak();
                ((zzj) this.zza).zzc(iterable);
                return this;
            }

            public final zza zzd(Iterable<String> iterable) {
                zzak();
                ((zzj) this.zza).zzd(iterable);
                return this;
            }

            public final zza zze(Iterable<? extends zzn> iterable) {
                zzak();
                ((zzj) this.zza).zze(iterable);
                return this;
            }

            public final zza zzf(int i10) {
                zzak();
                ((zzj) this.zza).zzh(i10);
                return this;
            }

            public final zza zza(Iterable<? extends zzc> iterable) {
                zzak();
                ((zzj) this.zza).zza(iterable);
                return this;
            }

            public final zza zzg(String str) {
                zzak();
                ((zzj) this.zza).zzg(str);
                return this;
            }

            public final zza zzh(String str) {
                zzak();
                ((zzj) this.zza).zzh(str);
                return this;
            }

            public final zza zzi(String str) {
                zzak();
                ((zzj) this.zza).zzi(str);
                return this;
            }

            public final zza zzj(String str) {
                zzak();
                ((zzj) this.zza).zzj((String) null);
                return this;
            }

            public final zza zzk(String str) {
                zzak();
                ((zzj) this.zza).zzk(str);
                return this;
            }

            public final zza zzl(String str) {
                zzak();
                ((zzj) this.zza).zzl(str);
                return this;
            }

            public final zza zzm(String str) {
                zzak();
                ((zzj) this.zza).zzm(str);
                return this;
            }

            public final zza zzn(String str) {
                zzak();
                ((zzj) this.zza).zzn(str);
                return this;
            }

            public final zza zzo(String str) {
                zzak();
                ((zzj) this.zza).zzo(str);
                return this;
            }

            public final zza zzp(String str) {
                zzak();
                ((zzj) this.zza).zzp(str);
                return this;
            }

            public final zza zzq(String str) {
                zzak();
                ((zzj) this.zza).zzq(str);
                return this;
            }

            public final zza zzr(String str) {
                zzak();
                ((zzj) this.zza).zzr(str);
                return this;
            }

            public final zza zzs(String str) {
                zzak();
                ((zzj) this.zza).zzs(str);
                return this;
            }

            public final zza zzb(int i10) {
                zzak();
                ((zzj) this.zza).zzd(i10);
                return this;
            }

            public final zza zzc(int i10) {
                zzak();
                ((zzj) this.zza).zze(i10);
                return this;
            }

            public final zza zzd(int i10) {
                zzak();
                ((zzj) this.zza).zzf(i10);
                return this;
            }

            public final zza zze(String str) {
                zzak();
                ((zzj) this.zza).zze(str);
                return this;
            }

            public final zza zzf(String str) {
                zzak();
                ((zzj) this.zza).zzf(str);
                return this;
            }

            public final zza zza(zze.zza zzaVar) {
                zzak();
                ((zzj) this.zza).zza((zze) ((zzjt) zzaVar.zzah()));
                return this;
            }

            public final zza zzg(int i10) {
                zzak();
                ((zzj) this.zza).zzi(i10);
                return this;
            }

            public final zza zzh(long j10) {
                zzak();
                ((zzj) this.zza).zzh(j10);
                return this;
            }

            public final zza zzi(int i10) {
                zzak();
                ((zzj) this.zza).zzk(i10);
                return this;
            }

            public final zza zzj(long j10) {
                zzak();
                ((zzj) this.zza).zzj(j10);
                return this;
            }

            public final zza zzk(long j10) {
                zzak();
                ((zzj) this.zza).zzk(j10);
                return this;
            }

            public final zza zzl(long j10) {
                zzak();
                ((zzj) this.zza).zzl(j10);
                return this;
            }

            public final zza zzb(String str) {
                zzak();
                ((zzj) this.zza).zzb(str);
                return this;
            }

            public final zza zzc(String str) {
                zzak();
                ((zzj) this.zza).zzc(str);
                return this;
            }

            public final zza zzd(String str) {
                zzak();
                ((zzj) this.zza).zzd(str);
                return this;
            }

            public final zza zze(int i10) {
                zzak();
                ((zzj) this.zza).zzg(i10);
                return this;
            }

            public final zza zzf(long j10) {
                zzak();
                ((zzj) this.zza).zzf(j10);
                return this;
            }

            public final zza zza(zzn.zza zzaVar) {
                zzak();
                ((zzj) this.zza).zza((zzn) ((zzjt) zzaVar.zzah()));
                return this;
            }

            public final zza zzg(long j10) {
                zzak();
                ((zzj) this.zza).zzg(j10);
                return this;
            }

            public final zza zzh(int i10) {
                zzak();
                ((zzj) this.zza).zzj(1);
                return this;
            }

            public final zza zzi(long j10) {
                zzak();
                ((zzj) this.zza).zzi(j10);
                return this;
            }

            public final zza zzj(int i10) {
                zzak();
                ((zzj) this.zza).zzl(i10);
                return this;
            }

            public final zzn zzk(int i10) {
                return ((zzj) this.zza).zzb(i10);
            }

            public final zza zzb(long j10) {
                zzak();
                ((zzj) this.zza).zzb(j10);
                return this;
            }

            public final zza zzc(long j10) {
                zzak();
                ((zzj) this.zza).zzc(j10);
                return this;
            }

            public final zza zzd(long j10) {
                zzak();
                ((zzj) this.zza).zzd(j10);
                return this;
            }

            public final zza zze(long j10) {
                zzak();
                ((zzj) this.zza).zze(j10);
                return this;
            }

            public final zza zza(zzn zznVar) {
                zzak();
                ((zzj) this.zza).zza(zznVar);
                return this;
            }

            public final zza zzb(boolean z10) {
                zzak();
                ((zzj) this.zza).zzb(z10);
                return this;
            }

            public final zza zzc(boolean z10) {
                zzak();
                ((zzj) this.zza).zzc(z10);
                return this;
            }

            public final zza zzd(boolean z10) {
                zzak();
                ((zzj) this.zza).zzd(z10);
                return this;
            }

            public final zza zza(String str) {
                zzak();
                ((zzj) this.zza).zza(str);
                return this;
            }

            public final zza zza(zzb zzbVar) {
                zzak();
                ((zzj) this.zza).zza(zzbVar);
                return this;
            }

            public final zza zza(long j10) {
                zzak();
                ((zzj) this.zza).zza(j10);
                return this;
            }

            public final zza zza(boolean z10) {
                zzak();
                ((zzj) this.zza).zza(z10);
                return this;
            }

            public final zza zza(int i10, zze.zza zzaVar) {
                zzak();
                ((zzj) this.zza).zza(i10, (zze) ((zzjt) zzaVar.zzah()));
                return this;
            }

            public final zza zza(int i10, zze zzeVar) {
                zzak();
                ((zzj) this.zza).zza(i10, zzeVar);
                return this;
            }

            public final zza zza(zzk.zza zzaVar) {
                zzak();
                ((zzj) this.zza).zza((zzk) ((zzjt) zzaVar.zzah()));
                return this;
            }

            public final zza zza(int i10, zzn zznVar) {
                zzak();
                ((zzj) this.zza).zza(i10, zznVar);
                return this;
            }
        }

        static {
            zzj zzjVar = new zzj();
            zzc = zzjVar;
            zzjt.zza((Class<zzj>) zzj.class, zzjVar);
        }

        private zzj() {
        }

        /* JADX INFO: Access modifiers changed from: private */
        public final void zzci() {
            this.zze &= -262145;
            this.zzaa = zzc.zzaa;
        }

        /* JADX INFO: Access modifiers changed from: private */
        public final void zzcj() {
            this.zzag = zzjt.zzcc();
        }

        /* JADX INFO: Access modifiers changed from: private */
        public final void zzck() {
            this.zze &= -257;
            this.zzq = zzc.zzq;
        }

        /* JADX INFO: Access modifiers changed from: private */
        public final void zzcl() {
            this.zze &= Integer.MAX_VALUE;
            this.zzao = zzc.zzao;
        }

        /* JADX INFO: Access modifiers changed from: private */
        public final void zzcm() {
            this.zzh = zzjt.zzcc();
        }

        /* JADX INFO: Access modifiers changed from: private */
        public final void zzcn() {
            this.zze &= -2097153;
            this.zzad = zzc.zzad;
        }

        /* JADX INFO: Access modifiers changed from: private */
        public final void zzco() {
            this.zze &= -131073;
            this.zzz = false;
        }

        /* JADX INFO: Access modifiers changed from: private */
        public final void zzcp() {
            this.zze &= -129;
            this.zzp = zzc.zzp;
        }

        /* JADX INFO: Access modifiers changed from: private */
        public final void zzcq() {
            this.zze &= -33;
            this.zzn = 0L;
        }

        /* JADX INFO: Access modifiers changed from: private */
        public final void zzcr() {
            this.zze &= -17;
            this.zzm = 0L;
        }

        /* JADX INFO: Access modifiers changed from: private */
        public final void zzcs() {
            this.zze &= -65537;
            this.zzy = zzc.zzy;
        }

        /* JADX INFO: Access modifiers changed from: private */
        public final void zzct() {
            this.zzf &= -8193;
            this.zzbd = zzc.zzbd;
        }

        /* JADX INFO: Access modifiers changed from: private */
        public final void zzcu() {
            this.zze &= -268435457;
            this.zzal = zzc.zzal;
        }

        private final void zzcv() {
            zzkc<zze> zzkcVar = this.zzh;
            if (zzkcVar.zzc()) {
                return;
            }
            this.zzh = zzjt.zza(zzkcVar);
        }

        private final void zzcw() {
            zzkc<zzn> zzkcVar = this.zzi;
            if (zzkcVar.zzc()) {
                return;
            }
            this.zzi = zzjt.zza(zzkcVar);
        }

        public static zza zzu() {
            return zzc.zzbx();
        }

        public final String h_() {
            return this.zzp;
        }

        public final int zza() {
            return this.zzbl;
        }

        public final String zzaa() {
            return this.zzv;
        }

        public final String zzab() {
            return this.zzbi;
        }

        public final String zzac() {
            return this.zzax;
        }

        public final String zzad() {
            return this.zzbk;
        }

        public final String zzae() {
            return this.zzq;
        }

        public final String zzaf() {
            return this.zzao;
        }

        public final String zzag() {
            return this.zzah;
        }

        public final String zzah() {
            return this.zzae;
        }

        public final String zzai() {
            return this.zzad;
        }

        public final String zzak() {
            return this.zzo;
        }

        public final String zzal() {
            return this.zzy;
        }

        public final String zzam() {
            return this.zzbd;
        }

        public final String zzan() {
            return this.zzr;
        }

        public final List<zzc> zzao() {
            return this.zzag;
        }

        public final List<zze> zzap() {
            return this.zzh;
        }

        public final List<zzn> zzaq() {
            return this.zzi;
        }

        public final boolean zzar() {
            return this.zzbh;
        }

        public final boolean zzas() {
            return this.zzbj;
        }

        public final boolean zzat() {
            return this.zzz;
        }

        public final boolean zzau() {
            return this.zzaf;
        }

        public final boolean zzav() {
            return (this.zze & 33554432) != 0;
        }

        public final boolean zzaw() {
            return (this.zzf & 4194304) != 0;
        }

        public final boolean zzax() {
            return (this.zze & 1048576) != 0;
        }

        public final boolean zzay() {
            return (this.zze & 536870912) != 0;
        }

        public final boolean zzaz() {
            return (this.zzf & 131072) != 0;
        }

        public final int zzb() {
            return this.zzai;
        }

        public final boolean zzba() {
            return (this.zzf & 128) != 0;
        }

        public final boolean zzbb() {
            return (this.zzf & 524288) != 0;
        }

        public final boolean zzbc() {
            return (this.zze & 524288) != 0;
        }

        public final boolean zzbd() {
            return (this.zzf & 16) != 0;
        }

        public final boolean zzbe() {
            return (this.zze & 8) != 0;
        }

        public final boolean zzbf() {
            return (this.zze & Http2.INITIAL_MAX_FRAME_SIZE) != 0;
        }

        public final boolean zzbg() {
            return (this.zzf & 262144) != 0;
        }

        public final boolean zzbh() {
            return (this.zze & 131072) != 0;
        }

        public final boolean zzbi() {
            return (this.zze & 32) != 0;
        }

        public final boolean zzbj() {
            return (this.zze & 16) != 0;
        }

        public final boolean zzbk() {
            return (this.zze & 1) != 0;
        }

        public final boolean zzbl() {
            return (this.zzf & 2) != 0;
        }

        public final boolean zzbm() {
            return (this.zze & 8388608) != 0;
        }

        public final boolean zzbn() {
            return (this.zzf & 8192) != 0;
        }

        public final boolean zzbo() {
            return (this.zze & 4) != 0;
        }

        public final boolean zzbp() {
            return (this.zzf & 32768) != 0;
        }

        public final boolean zzbq() {
            return (this.zze & 1024) != 0;
        }

        public final boolean zzbr() {
            return (this.zze & 2) != 0;
        }

        public final boolean zzbs() {
            return (this.zze & 32768) != 0;
        }

        public final int zzc() {
            return this.zzac;
        }

        public final int zzd() {
            return this.zzh.size();
        }

        public final int zze() {
            return this.zzg;
        }

        public final int zzf() {
            return this.zzaq;
        }

        public final int zzg() {
            return this.zzs;
        }

        public final int zzh() {
            return this.zzi.size();
        }

        public final long zzi() {
            return this.zzam;
        }

        public final long zzj() {
            return this.zzab;
        }

        public final long zzk() {
            return this.zzau;
        }

        public final long zzl() {
            return this.zzl;
        }

        public final long zzm() {
            return this.zzw;
        }

        public final long zzn() {
            return this.zzn;
        }

        public final long zzo() {
            return this.zzm;
        }

        public final long zzp() {
            return this.zzk;
        }

        public final long zzq() {
            return this.zzbg;
        }

        public final long zzr() {
            return this.zzj;
        }

        public final long zzs() {
            return this.zzx;
        }

        public final zzb zzt() {
            zzb zzbVar = this.zzbn;
            return zzbVar == null ? zzb.zzc() : zzbVar;
        }

        public final String zzw() {
            return this.zzar;
        }

        public final String zzx() {
            return this.zzu;
        }

        public final String zzy() {
            return this.zzaa;
        }

        public final String zzz() {
            return this.zzt;
        }

        public final zze zza(int i10) {
            return this.zzh.get(i10);
        }

        public final zzn zzb(int i10) {
            return this.zzi.get(i10);
        }

        /* JADX INFO: Access modifiers changed from: private */
        public final void zzn(String str) {
            str.getClass();
            this.zze |= 2097152;
            this.zzad = str;
        }

        /* JADX INFO: Access modifiers changed from: private */
        public final void zzo(String str) {
            str.getClass();
            this.zze |= 128;
            this.zzp = str;
        }

        /* JADX INFO: Access modifiers changed from: private */
        public final void zzp(String str) {
            str.getClass();
            this.zze |= 64;
            this.zzo = str;
        }

        /* JADX INFO: Access modifiers changed from: private */
        public final void zzq(String str) {
            str.getClass();
            this.zze |= 65536;
            this.zzy = str;
        }

        /* JADX INFO: Access modifiers changed from: private */
        public final void zzr(String str) {
            str.getClass();
            this.zzf |= 8192;
            this.zzbd = str;
        }

        /* JADX INFO: Access modifiers changed from: private */
        public final void zzs(String str) {
            str.getClass();
            this.zze |= 512;
            this.zzr = str;
        }

        @Override // com.google.android.gms.internal.measurement.zzjt
        public final Object zza(int i10, Object obj, Object obj2) {
            zzfs zzfsVar = null;
            switch (zzfs.zza[i10 - 1]) {
                case 1:
                    return new zzj();
                case 2:
                    return new zza(zzfsVar);
                case 3:
                    return zzjt.zza(zzc, "\u0001=\u0000\u0002\u0001M=\u0000\u0005\u0000\u0001င\u0000\u0002\u001b\u0003\u001b\u0004ဂ\u0001\u0005ဂ\u0002\u0006ဂ\u0003\u0007ဂ\u0005\bဈ\u0006\tဈ\u0007\nဈ\b\u000bဈ\t\fင\n\rဈ\u000b\u000eဈ\f\u0010ဈ\r\u0011ဂ\u000e\u0012ဂ\u000f\u0013ဈ\u0010\u0014ဇ\u0011\u0015ဈ\u0012\u0016ဂ\u0013\u0017င\u0014\u0018ဈ\u0015\u0019ဈ\u0016\u001aဂ\u0004\u001cဇ\u0017\u001d\u001b\u001eဈ\u0018\u001fင\u0019 င\u001a!င\u001b\"ဈ\u001c#ဂ\u001d$ဂ\u001e%ဈ\u001f&ဈ 'င!)ဈ\",ဉ#-\u001d.ဂ$/ဂ%2ဈ&4ဈ'5᠌(7ဇ)9ဈ*:ဇ+;ဉ,?ဈ-@\u001aAဈ.Cဂ/Dဇ0Gဈ1Hဇ2Iဈ3Jင4Kဈ5Lဉ6Mင7", new Object[]{"zze", "zzf", "zzg", "zzh", zze.class, "zzi", zzn.class, "zzj", "zzk", "zzl", "zzn", "zzo", "zzp", "zzq", "zzr", "zzs", "zzt", "zzu", "zzv", "zzw", "zzx", "zzy", "zzz", "zzaa", "zzab", "zzac", "zzad", "zzae", "zzm", "zzaf", "zzag", zzc.class, "zzah", "zzai", "zzaj", "zzak", "zzal", "zzam", "zzan", "zzao", "zzap", "zzaq", "zzar", "zzas", "zzat", "zzau", "zzav", "zzaw", "zzax", "zzay", zzfv.zzb(), "zzaz", "zzba", "zzbb", "zzbc", "zzbd", "zzbe", "zzbf", "zzbg", "zzbh", "zzbi", "zzbj", "zzbk", "zzbl", "zzbm", "zzbn", "zzbo"});
                case 4:
                    return zzc;
                case 5:
                    zzlp<zzj> zzcVar = zzd;
                    if (zzcVar == null) {
                        synchronized (zzj.class) {
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
        public final void zzm(String str) {
            str.getClass();
            this.zze |= 4194304;
            this.zzae = str;
        }

        /* JADX INFO: Access modifiers changed from: private */
        public final void zzj(String str) {
            str.getClass();
            this.zze |= Integer.MIN_VALUE;
            this.zzao = str;
        }

        /* JADX INFO: Access modifiers changed from: private */
        public final void zzk(String str) {
            str.getClass();
            this.zzf |= Http2.INITIAL_MAX_FRAME_SIZE;
            this.zzbf = str;
        }

        /* JADX INFO: Access modifiers changed from: private */
        public final void zzl(String str) {
            str.getClass();
            this.zze |= Http2Connection.OKHTTP_CLIENT_WINDOW_SIZE;
            this.zzah = str;
        }

        /* JADX INFO: Access modifiers changed from: private */
        public final void zzf(int i10) {
            this.zzf |= 1048576;
            this.zzbl = i10;
        }

        /* JADX INFO: Access modifiers changed from: private */
        public final void zzg(int i10) {
            this.zze |= 33554432;
            this.zzai = i10;
        }

        /* JADX INFO: Access modifiers changed from: private */
        public final void zzh(int i10) {
            this.zze |= 1048576;
            this.zzac = i10;
        }

        /* JADX INFO: Access modifiers changed from: private */
        public final void zzi(int i10) {
            this.zzf |= 8388608;
            this.zzbo = i10;
        }

        /* JADX INFO: Access modifiers changed from: private */
        public final void zze(Iterable<? extends zzn> iterable) {
            zzcw();
            zzhz.zza(iterable, this.zzi);
        }

        /* JADX INFO: Access modifiers changed from: private */
        public final void zzc(Iterable<? extends Integer> iterable) {
            zzka zzkaVar = this.zzat;
            if (!zzkaVar.zzc()) {
                int size = zzkaVar.size();
                this.zzat = zzkaVar.zzc(size == 0 ? 10 : size << 1);
            }
            zzhz.zza(iterable, this.zzat);
        }

        /* JADX INFO: Access modifiers changed from: private */
        public final void zzd(Iterable<String> iterable) {
            zzkc<String> zzkcVar = this.zzbe;
            if (!zzkcVar.zzc()) {
                this.zzbe = zzjt.zza(zzkcVar);
            }
            zzhz.zza(iterable, this.zzbe);
        }

        /* JADX INFO: Access modifiers changed from: private */
        public final void zzf(String str) {
            str.getClass();
            this.zzf |= 131072;
            this.zzbi = str;
        }

        /* JADX INFO: Access modifiers changed from: private */
        public final void zzg(String str) {
            str.getClass();
            this.zzf |= 128;
            this.zzax = str;
        }

        /* JADX INFO: Access modifiers changed from: private */
        public final void zzh(String str) {
            str.getClass();
            this.zzf |= 524288;
            this.zzbk = str;
        }

        /* JADX INFO: Access modifiers changed from: private */
        public final void zzi(String str) {
            str.getClass();
            this.zze |= 256;
            this.zzq = str;
        }

        /* JADX INFO: Access modifiers changed from: private */
        public final void zzj(int i10) {
            this.zze |= 1;
            this.zzg = 1;
        }

        /* JADX INFO: Access modifiers changed from: private */
        public final void zzk(int i10) {
            this.zzf |= 2;
            this.zzaq = i10;
        }

        /* JADX INFO: Access modifiers changed from: private */
        public final void zzl(int i10) {
            this.zze |= 1024;
            this.zzs = i10;
        }

        /* JADX INFO: Access modifiers changed from: private */
        public final void zzb(Iterable<? extends zze> iterable) {
            zzcv();
            zzhz.zza(iterable, this.zzh);
        }

        /* JADX INFO: Access modifiers changed from: private */
        public final void zze(int i10) {
            zzcw();
            this.zzi.remove(i10);
        }

        /* JADX INFO: Access modifiers changed from: private */
        public final void zzj(long j10) {
            this.zzf |= 32768;
            this.zzbg = j10;
        }

        /* JADX INFO: Access modifiers changed from: private */
        public final void zzk(long j10) {
            this.zze |= 2;
            this.zzj = j10;
        }

        /* JADX INFO: Access modifiers changed from: private */
        public final void zzl(long j10) {
            this.zze |= 32768;
            this.zzx = j10;
        }

        /* JADX INFO: Access modifiers changed from: private */
        public final void zzb(String str) {
            str.getClass();
            this.zze |= 4096;
            this.zzu = str;
        }

        /* JADX INFO: Access modifiers changed from: private */
        public final void zze(String str) {
            str.getClass();
            this.zze |= 8192;
            this.zzv = str;
        }

        /* JADX INFO: Access modifiers changed from: private */
        public final void zzf(long j10) {
            this.zze |= Http2.INITIAL_MAX_FRAME_SIZE;
            this.zzw = j10;
        }

        /* JADX INFO: Access modifiers changed from: private */
        public final void zzg(long j10) {
            this.zze |= 32;
            this.zzn = j10;
        }

        /* JADX INFO: Access modifiers changed from: private */
        public final void zzh(long j10) {
            this.zze |= 16;
            this.zzm = j10;
        }

        /* JADX INFO: Access modifiers changed from: private */
        public final void zzi(long j10) {
            this.zze |= 4;
            this.zzk = j10;
        }

        /* JADX INFO: Access modifiers changed from: private */
        public final void zzd(int i10) {
            zzcv();
            this.zzh.remove(i10);
        }

        /* JADX INFO: Access modifiers changed from: private */
        public final void zzb(long j10) {
            this.zze |= 536870912;
            this.zzam = j10;
        }

        /* JADX INFO: Access modifiers changed from: private */
        public final void zzc(String str) {
            str.getClass();
            this.zze |= 262144;
            this.zzaa = str;
        }

        /* JADX INFO: Access modifiers changed from: private */
        public final void zzd(String str) {
            str.getClass();
            this.zze |= 2048;
            this.zzt = str;
        }

        /* JADX INFO: Access modifiers changed from: private */
        public final void zze(long j10) {
            this.zze |= 8;
            this.zzl = j10;
        }

        /* JADX INFO: Access modifiers changed from: private */
        public final void zzb(boolean z10) {
            this.zzf |= 262144;
            this.zzbj = z10;
        }

        /* JADX INFO: Access modifiers changed from: private */
        public final void zzc(long j10) {
            this.zze |= 524288;
            this.zzab = j10;
        }

        /* JADX INFO: Access modifiers changed from: private */
        public final void zzd(long j10) {
            this.zzf |= 16;
            this.zzau = j10;
        }

        /* JADX INFO: Access modifiers changed from: private */
        public final void zzc(boolean z10) {
            this.zze |= 131072;
            this.zzz = z10;
        }

        /* JADX INFO: Access modifiers changed from: private */
        public final void zzd(boolean z10) {
            this.zze |= 8388608;
            this.zzaf = z10;
        }

        /* JADX INFO: Access modifiers changed from: private */
        public final void zza(Iterable<? extends zzc> iterable) {
            zzkc<zzc> zzkcVar = this.zzag;
            if (!zzkcVar.zzc()) {
                this.zzag = zzjt.zza(zzkcVar);
            }
            zzhz.zza(iterable, this.zzag);
        }

        /* JADX INFO: Access modifiers changed from: private */
        public final void zza(zze zzeVar) {
            zzeVar.getClass();
            zzcv();
            this.zzh.add(zzeVar);
        }

        /* JADX INFO: Access modifiers changed from: private */
        public final void zza(zzn zznVar) {
            zznVar.getClass();
            zzcw();
            this.zzi.add(zznVar);
        }

        /* JADX INFO: Access modifiers changed from: private */
        public final void zza(String str) {
            str.getClass();
            this.zzf |= 4;
            this.zzar = str;
        }

        /* JADX INFO: Access modifiers changed from: private */
        public final void zza(zzb zzbVar) {
            zzbVar.getClass();
            this.zzbn = zzbVar;
            this.zzf |= 4194304;
        }

        /* JADX INFO: Access modifiers changed from: private */
        public final void zza(long j10) {
            this.zzf |= 32;
            this.zzav = j10;
        }

        /* JADX INFO: Access modifiers changed from: private */
        public final void zza(boolean z10) {
            this.zzf |= 65536;
            this.zzbh = z10;
        }

        /* JADX INFO: Access modifiers changed from: private */
        public final void zza(int i10, zze zzeVar) {
            zzeVar.getClass();
            zzcv();
            this.zzh.set(i10, zzeVar);
        }

        /* JADX INFO: Access modifiers changed from: private */
        public final void zza(zzk zzkVar) {
            zzkVar.getClass();
            this.zzas = zzkVar;
            this.zzf |= 8;
        }

        /* JADX INFO: Access modifiers changed from: private */
        public final void zza(int i10, zzn zznVar) {
            zznVar.getClass();
            zzcw();
            this.zzi.set(i10, zznVar);
        }
    }

    /* compiled from: com.google.android.gms:play-services-measurement@@21.6.1 */
    public static final class zzk extends zzjt<zzk, zza> implements zzli {
        private static final zzk zzc;
        private static volatile zzlp<zzk> zzd;
        private int zze;
        private int zzf = 1;
        private zzkc<zzf> zzg = zzjt.zzcc();

        /* compiled from: com.google.android.gms:play-services-measurement@@21.6.1 */
        public static final class zza extends zzjt.zza<zzk, zza> implements zzli {
            private zza() {
                super(zzk.zzc);
            }

            public final zza zza(zzf.zza zzaVar) {
                zzak();
                ((zzk) this.zza).zza((zzf) ((zzjt) zzaVar.zzah()));
                return this;
            }

            public /* synthetic */ zza(zzfs zzfsVar) {
                this();
            }
        }

        /* compiled from: com.google.android.gms:play-services-measurement@@21.6.1 */
        public enum zzb implements zzjv {
            RADS(1),
            PROVISIONING(2);

            private static final zzjy<zzb> zzc = new zzfz();
            private final int zze;

            zzb(int i10) {
                this.zze = i10;
            }

            public static zzjx zzb() {
                return zzga.zza;
            }

            @Override // java.lang.Enum
            public final String toString() {
                return "<" + zzb.class.getName() + '@' + Integer.toHexString(System.identityHashCode(this)) + " number=" + this.zze + " name=" + name() + '>';
            }

            @Override // com.google.android.gms.internal.measurement.zzjv
            public final int zza() {
                return this.zze;
            }

            public static zzb zza(int i10) {
                if (i10 == 1) {
                    return RADS;
                }
                if (i10 != 2) {
                    return null;
                }
                return PROVISIONING;
            }
        }

        static {
            zzk zzkVar = new zzk();
            zzc = zzkVar;
            zzjt.zza((Class<zzk>) zzk.class, zzkVar);
        }

        private zzk() {
        }

        public static zza zza() {
            return zzc.zzbx();
        }

        @Override // com.google.android.gms.internal.measurement.zzjt
        public final Object zza(int i10, Object obj, Object obj2) {
            zzfs zzfsVar = null;
            switch (zzfs.zza[i10 - 1]) {
                case 1:
                    return new zzk();
                case 2:
                    return new zza(zzfsVar);
                case 3:
                    return zzjt.zza(zzc, "\u0001\u0002\u0000\u0001\u0001\u0002\u0002\u0000\u0001\u0000\u0001᠌\u0000\u0002\u001b", new Object[]{"zze", "zzf", zzb.zzb(), "zzg", zzf.class});
                case 4:
                    return zzc;
                case 5:
                    zzlp<zzk> zzcVar = zzd;
                    if (zzcVar == null) {
                        synchronized (zzk.class) {
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
        public final void zza(zzf zzfVar) {
            zzfVar.getClass();
            zzkc<zzf> zzkcVar = this.zzg;
            if (!zzkcVar.zzc()) {
                this.zzg = zzjt.zza(zzkcVar);
            }
            this.zzg.add(zzfVar);
        }
    }

    /* compiled from: com.google.android.gms:play-services-measurement@@21.6.1 */
    public static final class zzl extends zzjt<zzl, zza> implements zzli {
        private static final zzl zzc;
        private static volatile zzlp<zzl> zzd;
        private zzjz zze = zzjt.zzcb();
        private zzjz zzf = zzjt.zzcb();
        private zzkc<zzd> zzg = zzjt.zzcc();
        private zzkc<zzm> zzh = zzjt.zzcc();

        /* compiled from: com.google.android.gms:play-services-measurement@@21.6.1 */
        public static final class zza extends zzjt.zza<zzl, zza> implements zzli {
            private zza() {
                super(zzl.zzc);
            }

            public final zza zza(Iterable<? extends zzd> iterable) {
                zzak();
                ((zzl) this.zza).zza(iterable);
                return this;
            }

            public final zza zzb(Iterable<? extends Long> iterable) {
                zzak();
                ((zzl) this.zza).zzb(iterable);
                return this;
            }

            public final zza zzc(Iterable<? extends zzm> iterable) {
                zzak();
                ((zzl) this.zza).zzc(iterable);
                return this;
            }

            public final zza zzd(Iterable<? extends Long> iterable) {
                zzak();
                ((zzl) this.zza).zzd(iterable);
                return this;
            }

            public /* synthetic */ zza(zzfs zzfsVar) {
                this();
            }

            public final zza zza() {
                zzak();
                ((zzl) this.zza).zzl();
                return this;
            }

            public final zza zzb() {
                zzak();
                ((zzl) this.zza).zzm();
                return this;
            }

            public final zza zzc() {
                zzak();
                ((zzl) this.zza).zzn();
                return this;
            }

            public final zza zzd() {
                zzak();
                ((zzl) this.zza).zzo();
                return this;
            }
        }

        static {
            zzl zzlVar = new zzl();
            zzc = zzlVar;
            zzjt.zza((Class<zzl>) zzl.class, zzlVar);
        }

        private zzl() {
        }

        public static zza zze() {
            return zzc.zzbx();
        }

        public static zzl zzg() {
            return zzc;
        }

        /* JADX INFO: Access modifiers changed from: private */
        public final void zzl() {
            this.zzg = zzjt.zzcc();
        }

        /* JADX INFO: Access modifiers changed from: private */
        public final void zzm() {
            this.zzf = zzjt.zzcb();
        }

        /* JADX INFO: Access modifiers changed from: private */
        public final void zzn() {
            this.zzh = zzjt.zzcc();
        }

        /* JADX INFO: Access modifiers changed from: private */
        public final void zzo() {
            this.zze = zzjt.zzcb();
        }

        public final int zza() {
            return this.zzg.size();
        }

        public final int zzb() {
            return this.zzf.size();
        }

        public final int zzc() {
            return this.zzh.size();
        }

        public final int zzd() {
            return this.zze.size();
        }

        public final List<zzd> zzh() {
            return this.zzg;
        }

        public final List<Long> zzi() {
            return this.zzf;
        }

        public final List<zzm> zzj() {
            return this.zzh;
        }

        public final List<Long> zzk() {
            return this.zze;
        }

        @Override // com.google.android.gms.internal.measurement.zzjt
        public final Object zza(int i10, Object obj, Object obj2) {
            zzfs zzfsVar = null;
            switch (zzfs.zza[i10 - 1]) {
                case 1:
                    return new zzl();
                case 2:
                    return new zza(zzfsVar);
                case 3:
                    return zzjt.zza(zzc, "\u0001\u0004\u0000\u0000\u0001\u0004\u0004\u0000\u0004\u0000\u0001\u0015\u0002\u0015\u0003\u001b\u0004\u001b", new Object[]{"zze", "zzf", "zzg", zzd.class, "zzh", zzm.class});
                case 4:
                    return zzc;
                case 5:
                    zzlp<zzl> zzcVar = zzd;
                    if (zzcVar == null) {
                        synchronized (zzl.class) {
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
        public final void zzb(Iterable<? extends Long> iterable) {
            zzjz zzjzVar = this.zzf;
            if (!zzjzVar.zzc()) {
                this.zzf = zzjt.zza(zzjzVar);
            }
            zzhz.zza(iterable, this.zzf);
        }

        /* JADX INFO: Access modifiers changed from: private */
        public final void zzc(Iterable<? extends zzm> iterable) {
            zzkc<zzm> zzkcVar = this.zzh;
            if (!zzkcVar.zzc()) {
                this.zzh = zzjt.zza(zzkcVar);
            }
            zzhz.zza(iterable, this.zzh);
        }

        /* JADX INFO: Access modifiers changed from: private */
        public final void zzd(Iterable<? extends Long> iterable) {
            zzjz zzjzVar = this.zze;
            if (!zzjzVar.zzc()) {
                this.zze = zzjt.zza(zzjzVar);
            }
            zzhz.zza(iterable, this.zze);
        }

        /* JADX INFO: Access modifiers changed from: private */
        public final void zza(Iterable<? extends zzd> iterable) {
            zzkc<zzd> zzkcVar = this.zzg;
            if (!zzkcVar.zzc()) {
                this.zzg = zzjt.zza(zzkcVar);
            }
            zzhz.zza(iterable, this.zzg);
        }
    }

    /* compiled from: com.google.android.gms:play-services-measurement@@21.6.1 */
    public static final class zzm extends zzjt<zzm, zza> implements zzli {
        private static final zzm zzc;
        private static volatile zzlp<zzm> zzd;
        private int zze;
        private int zzf;
        private zzjz zzg = zzjt.zzcb();

        /* compiled from: com.google.android.gms:play-services-measurement@@21.6.1 */
        public static final class zza extends zzjt.zza<zzm, zza> implements zzli {
            private zza() {
                super(zzm.zzc);
            }

            public final zza zza(Iterable<? extends Long> iterable) {
                zzak();
                ((zzm) this.zza).zza(iterable);
                return this;
            }

            public /* synthetic */ zza(zzfs zzfsVar) {
                this();
            }

            public final zza zza(int i10) {
                zzak();
                ((zzm) this.zza).zzb(i10);
                return this;
            }
        }

        static {
            zzm zzmVar = new zzm();
            zzc = zzmVar;
            zzjt.zza((Class<zzm>) zzm.class, zzmVar);
        }

        private zzm() {
        }

        public static zza zzc() {
            return zzc.zzbx();
        }

        public final int zza() {
            return this.zzg.size();
        }

        public final int zzb() {
            return this.zzf;
        }

        public final List<Long> zze() {
            return this.zzg;
        }

        public final boolean zzf() {
            return (this.zze & 1) != 0;
        }

        /* JADX INFO: Access modifiers changed from: private */
        public final void zzb(int i10) {
            this.zze |= 1;
            this.zzf = i10;
        }

        public final long zza(int i10) {
            return this.zzg.zzb(i10);
        }

        @Override // com.google.android.gms.internal.measurement.zzjt
        public final Object zza(int i10, Object obj, Object obj2) {
            zzfs zzfsVar = null;
            switch (zzfs.zza[i10 - 1]) {
                case 1:
                    return new zzm();
                case 2:
                    return new zza(zzfsVar);
                case 3:
                    return zzjt.zza(zzc, "\u0001\u0002\u0000\u0001\u0001\u0002\u0002\u0000\u0001\u0000\u0001င\u0000\u0002\u0014", new Object[]{"zze", "zzf", "zzg"});
                case 4:
                    return zzc;
                case 5:
                    zzlp<zzm> zzcVar = zzd;
                    if (zzcVar == null) {
                        synchronized (zzm.class) {
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
        public final void zza(Iterable<? extends Long> iterable) {
            zzjz zzjzVar = this.zzg;
            if (!zzjzVar.zzc()) {
                this.zzg = zzjt.zza(zzjzVar);
            }
            zzhz.zza(iterable, this.zzg);
        }
    }

    /* compiled from: com.google.android.gms:play-services-measurement@@21.6.1 */
    public static final class zzn extends zzjt<zzn, zza> implements zzli {
        private static final zzn zzc;
        private static volatile zzlp<zzn> zzd;
        private int zze;
        private long zzf;
        private String zzg = "";
        private String zzh = "";
        private long zzi;
        private float zzj;
        private double zzk;

        /* compiled from: com.google.android.gms:play-services-measurement@@21.6.1 */
        public static final class zza extends zzjt.zza<zzn, zza> implements zzli {
            private zza() {
                super(zzn.zzc);
            }

            public final zza zza() {
                zzak();
                ((zzn) this.zza).zzn();
                return this;
            }

            public final zza zzb() {
                zzak();
                ((zzn) this.zza).zzo();
                return this;
            }

            public final zza zzc() {
                zzak();
                ((zzn) this.zza).zzp();
                return this;
            }

            public /* synthetic */ zza(zzfs zzfsVar) {
                this();
            }

            public final zza zza(double d10) {
                zzak();
                ((zzn) this.zza).zza(d10);
                return this;
            }

            public final zza zzb(long j10) {
                zzak();
                ((zzn) this.zza).zzb(j10);
                return this;
            }

            public final zza zza(long j10) {
                zzak();
                ((zzn) this.zza).zza(j10);
                return this;
            }

            public final zza zzb(String str) {
                zzak();
                ((zzn) this.zza).zzb(str);
                return this;
            }

            public final zza zza(String str) {
                zzak();
                ((zzn) this.zza).zza(str);
                return this;
            }
        }

        static {
            zzn zznVar = new zzn();
            zzc = zznVar;
            zzjt.zza((Class<zzn>) zzn.class, zznVar);
        }

        private zzn() {
        }

        public static zza zze() {
            return zzc.zzbx();
        }

        /* JADX INFO: Access modifiers changed from: private */
        public final void zzn() {
            this.zze &= -33;
            this.zzk = 0.0d;
        }

        /* JADX INFO: Access modifiers changed from: private */
        public final void zzo() {
            this.zze &= -9;
            this.zzi = 0L;
        }

        /* JADX INFO: Access modifiers changed from: private */
        public final void zzp() {
            this.zze &= -5;
            this.zzh = zzc.zzh;
        }

        public final double zza() {
            return this.zzk;
        }

        public final float zzb() {
            return this.zzj;
        }

        public final long zzc() {
            return this.zzi;
        }

        public final long zzd() {
            return this.zzf;
        }

        public final String zzg() {
            return this.zzg;
        }

        public final String zzh() {
            return this.zzh;
        }

        public final boolean zzi() {
            return (this.zze & 32) != 0;
        }

        public final boolean zzj() {
            return (this.zze & 16) != 0;
        }

        public final boolean zzk() {
            return (this.zze & 8) != 0;
        }

        public final boolean zzl() {
            return (this.zze & 1) != 0;
        }

        public final boolean zzm() {
            return (this.zze & 4) != 0;
        }

        @Override // com.google.android.gms.internal.measurement.zzjt
        public final Object zza(int i10, Object obj, Object obj2) {
            zzfs zzfsVar = null;
            switch (zzfs.zza[i10 - 1]) {
                case 1:
                    return new zzn();
                case 2:
                    return new zza(zzfsVar);
                case 3:
                    return zzjt.zza(zzc, "\u0001\u0006\u0000\u0001\u0001\u0006\u0006\u0000\u0000\u0000\u0001ဂ\u0000\u0002ဈ\u0001\u0003ဈ\u0002\u0004ဂ\u0003\u0005ခ\u0004\u0006က\u0005", new Object[]{"zze", "zzf", "zzg", "zzh", "zzi", "zzj", "zzk"});
                case 4:
                    return zzc;
                case 5:
                    zzlp<zzn> zzcVar = zzd;
                    if (zzcVar == null) {
                        synchronized (zzn.class) {
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
        public final void zzb(long j10) {
            this.zze |= 1;
            this.zzf = j10;
        }

        /* JADX INFO: Access modifiers changed from: private */
        public final void zzb(String str) {
            str.getClass();
            this.zze |= 4;
            this.zzh = str;
        }

        /* JADX INFO: Access modifiers changed from: private */
        public final void zza(double d10) {
            this.zze |= 32;
            this.zzk = d10;
        }

        /* JADX INFO: Access modifiers changed from: private */
        public final void zza(long j10) {
            this.zze |= 8;
            this.zzi = j10;
        }

        /* JADX INFO: Access modifiers changed from: private */
        public final void zza(String str) {
            str.getClass();
            this.zze |= 2;
            this.zzg = str;
        }
    }
}
