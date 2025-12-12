package com.google.android.gms.internal.measurement;

import ac.c;
import android.content.Context;
import b8.b;
import b8.g;
import com.google.android.gms.internal.measurement.zzhd;
import com.google.common.base.Suppliers;
import java.util.Collection;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.concurrent.atomic.AtomicReference;

/* compiled from: com.google.android.gms:play-services-measurement-impl@@21.6.1 */
/* loaded from: classes.dex */
public abstract class zzhg<T> {
    private static volatile zzhr zzb = null;
    private static volatile boolean zzc = false;
    private final zzho zzg;
    private final String zzh;
    private final T zzi;
    private volatile int zzj;
    private volatile T zzk;
    private final boolean zzl;
    private static final Object zza = new Object();
    private static final AtomicReference<Collection<zzhg<?>>> zzd = new AtomicReference<>();
    private static zzhv zze = new zzhv(new zzhu() { // from class: com.google.android.gms.internal.measurement.zzhl
        @Override // com.google.android.gms.internal.measurement.zzhu
        public final boolean zza() {
            return zzhg.zzd();
        }
    });
    private static final AtomicInteger zzf = new AtomicInteger();

    public static /* synthetic */ zzhg zza(zzho zzhoVar, String str, Boolean bool, boolean z10) {
        return new zzhn(zzhoVar, str, bool, true);
    }

    private final T zzb(zzhr zzhrVar) {
        Object objZza;
        zzgy zzgyVarZza = this.zzg.zzb != null ? zzhf.zza(zzhrVar.zza(), this.zzg.zzb) ? this.zzg.zzg ? zzgr.zza(zzhrVar.zza().getContentResolver(), zzhh.zza(zzhh.zza(zzhrVar.zza(), this.zzg.zzb.getLastPathSegment())), new Runnable() { // from class: com.google.android.gms.internal.measurement.zzhj
            @Override // java.lang.Runnable
            public final void run() {
                zzhg.zzc();
            }
        }) : zzgr.zza(zzhrVar.zza().getContentResolver(), this.zzg.zzb, new Runnable() { // from class: com.google.android.gms.internal.measurement.zzhj
            @Override // java.lang.Runnable
            public final void run() {
                zzhg.zzc();
            }
        }) : null : zzht.zza(zzhrVar.zza(), this.zzg.zza, new Runnable() { // from class: com.google.android.gms.internal.measurement.zzhj
            @Override // java.lang.Runnable
            public final void run() {
                zzhg.zzc();
            }
        });
        if (zzgyVarZza == null || (objZza = zzgyVarZza.zza(zzb())) == null) {
            return null;
        }
        return zza(objZza);
    }

    public static void zzc() {
        zzf.incrementAndGet();
    }

    public static /* synthetic */ boolean zzd() {
        return true;
    }

    public abstract T zza(Object obj);

    private zzhg(zzho zzhoVar, String str, T t10, boolean z10) {
        this.zzj = -1;
        String str2 = zzhoVar.zza;
        if (str2 == null && zzhoVar.zzb == null) {
            throw new IllegalArgumentException("Must pass a valid SharedPreferences file name or ContentProvider URI");
        }
        if (str2 != null && zzhoVar.zzb != null) {
            throw new IllegalArgumentException("Must pass one of SharedPreferences file name or ContentProvider URI");
        }
        this.zzg = zzhoVar;
        this.zzh = str;
        this.zzi = t10;
        this.zzl = z10;
    }

    public static /* synthetic */ zzhg zza(zzho zzhoVar, String str, Double d10, boolean z10) {
        return new zzhm(zzhoVar, str, d10, true);
    }

    public static /* synthetic */ zzhg zza(zzho zzhoVar, String str, Long l10, boolean z10) {
        return new zzhk(zzhoVar, str, l10, true);
    }

    public static /* synthetic */ zzhg zza(zzho zzhoVar, String str, String str2, boolean z10) {
        return new zzhp(zzhoVar, str, str2, true);
    }

    /* JADX WARN: Removed duplicated region for block: B:32:0x0079 A[Catch: all -> 0x0090, TryCatch #0 {, blocks: (B:8:0x001c, B:10:0x0020, B:12:0x0029, B:14:0x0039, B:18:0x0052, B:20:0x005d, B:33:0x007b, B:36:0x0083, B:37:0x0086, B:38:0x008a, B:23:0x0064, B:32:0x0079, B:26:0x006b, B:29:0x0072, B:39:0x008e), top: B:46:0x001c }] */
    /* JADX WARN: Removed duplicated region for block: B:35:0x0081  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public final T zza() {
        /*
            r8 = this;
            boolean r0 = r8.zzl
            if (r0 != 0) goto L11
            com.google.android.gms.internal.measurement.zzhv r0 = com.google.android.gms.internal.measurement.zzhg.zze
            java.lang.String r1 = r8.zzh
            boolean r0 = r0.zza(r1)
            java.lang.String r1 = "Attempt to access PhenotypeFlag not via codegen. All new PhenotypeFlags must be accessed through codegen APIs. If you believe you are seeing this error by mistake, you can add your flag to the exemption list located at //java/com/google/android/libraries/phenotype/client/lockdown/flags.textproto. Send the addition CL to ph-reviews@. See go/phenotype-android-codegen for information about generated code. See go/ph-lockdown for more information about this error."
            b8.e.checkState(r0, r1)
        L11:
            java.util.concurrent.atomic.AtomicInteger r0 = com.google.android.gms.internal.measurement.zzhg.zzf
            int r0 = r0.get()
            int r1 = r8.zzj
            if (r1 >= r0) goto L93
            monitor-enter(r8)
            int r1 = r8.zzj     // Catch: java.lang.Throwable -> L90
            if (r1 >= r0) goto L8e
            com.google.android.gms.internal.measurement.zzhr r1 = com.google.android.gms.internal.measurement.zzhg.zzb     // Catch: java.lang.Throwable -> L90
            com.google.common.base.Optional r2 = com.google.common.base.Optional.absent()     // Catch: java.lang.Throwable -> L90
            r3 = 0
            if (r1 == 0) goto L4d
            b8.g r2 = r1.zzb()     // Catch: java.lang.Throwable -> L90
            java.lang.Object r2 = r2.get()     // Catch: java.lang.Throwable -> L90
            com.google.common.base.Optional r2 = (com.google.common.base.Optional) r2     // Catch: java.lang.Throwable -> L90
            boolean r4 = r2.isPresent()     // Catch: java.lang.Throwable -> L90
            if (r4 == 0) goto L4d
            java.lang.Object r3 = r2.get()     // Catch: java.lang.Throwable -> L90
            com.google.android.gms.internal.measurement.zzhe r3 = (com.google.android.gms.internal.measurement.zzhe) r3     // Catch: java.lang.Throwable -> L90
            com.google.android.gms.internal.measurement.zzho r4 = r8.zzg     // Catch: java.lang.Throwable -> L90
            android.net.Uri r5 = r4.zzb     // Catch: java.lang.Throwable -> L90
            java.lang.String r6 = r4.zza     // Catch: java.lang.Throwable -> L90
            java.lang.String r4 = r4.zzd     // Catch: java.lang.Throwable -> L90
            java.lang.String r7 = r8.zzh     // Catch: java.lang.Throwable -> L90
            java.lang.String r3 = r3.zza(r5, r6, r4, r7)     // Catch: java.lang.Throwable -> L90
        L4d:
            if (r1 == 0) goto L51
            r4 = 1
            goto L52
        L51:
            r4 = 0
        L52:
            java.lang.String r5 = "Must call PhenotypeFlagInitializer.maybeInit() first"
            b8.e.checkState(r4, r5)     // Catch: java.lang.Throwable -> L90
            com.google.android.gms.internal.measurement.zzho r4 = r8.zzg     // Catch: java.lang.Throwable -> L90
            boolean r4 = r4.zzf     // Catch: java.lang.Throwable -> L90
            if (r4 == 0) goto L6b
            java.lang.Object r4 = r8.zza(r1)     // Catch: java.lang.Throwable -> L90
            if (r4 == 0) goto L64
            goto L7b
        L64:
            java.lang.Object r4 = r8.zzb(r1)     // Catch: java.lang.Throwable -> L90
            if (r4 == 0) goto L79
            goto L7b
        L6b:
            java.lang.Object r4 = r8.zzb(r1)     // Catch: java.lang.Throwable -> L90
            if (r4 == 0) goto L72
            goto L7b
        L72:
            java.lang.Object r4 = r8.zza(r1)     // Catch: java.lang.Throwable -> L90
            if (r4 == 0) goto L79
            goto L7b
        L79:
            T r4 = r8.zzi     // Catch: java.lang.Throwable -> L90
        L7b:
            boolean r1 = r2.isPresent()     // Catch: java.lang.Throwable -> L90
            if (r1 == 0) goto L8a
            if (r3 != 0) goto L86
            T r4 = r8.zzi     // Catch: java.lang.Throwable -> L90
            goto L8a
        L86:
            java.lang.Object r4 = r8.zza(r3)     // Catch: java.lang.Throwable -> L90
        L8a:
            r8.zzk = r4     // Catch: java.lang.Throwable -> L90
            r8.zzj = r0     // Catch: java.lang.Throwable -> L90
        L8e:
            monitor-exit(r8)     // Catch: java.lang.Throwable -> L90
            goto L93
        L90:
            r0 = move-exception
            monitor-exit(r8)     // Catch: java.lang.Throwable -> L90
            throw r0
        L93:
            T r0 = r8.zzk
            return r0
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.gms.internal.measurement.zzhg.zza():java.lang.Object");
    }

    public final String zzb() {
        return zza(this.zzg.zzd);
    }

    public static void zzb(final Context context) {
        if (zzb != null || context == null) {
            return;
        }
        Object obj = zza;
        synchronized (obj) {
            if (zzb == null) {
                synchronized (obj) {
                    zzhr zzhrVar = zzb;
                    Context applicationContext = context.getApplicationContext();
                    if (applicationContext != null) {
                        context = applicationContext;
                    }
                    if (zzhrVar == null || zzhrVar.zza() != context) {
                        if (zzhrVar != null) {
                            zzgr.zzc();
                            zzht.zza();
                            zzgz.zza();
                        }
                        zzb = new zzgs(context, Suppliers.memoize(new g() { // from class: com.google.android.gms.internal.measurement.zzhi
                            @Override // b8.g
                            public final Object get() {
                                return zzhd.zza.zza(context);
                            }
                        }));
                        zzf.incrementAndGet();
                    }
                }
            }
        }
    }

    private final T zza(zzhr zzhrVar) {
        b<Context, Boolean> bVar;
        zzho zzhoVar = this.zzg;
        if (!zzhoVar.zze && ((bVar = zzhoVar.zzh) == null || bVar.apply(zzhrVar.zza()).booleanValue())) {
            zzgz zzgzVarZza = zzgz.zza(zzhrVar.zza());
            zzho zzhoVar2 = this.zzg;
            Object objZza = zzgzVarZza.zza(zzhoVar2.zze ? null : zza(zzhoVar2.zzc));
            if (objZza != null) {
                return zza(objZza);
            }
        }
        return null;
    }

    private final String zza(String str) {
        return (str == null || !str.isEmpty()) ? c.B(str, this.zzh) : this.zzh;
    }
}
