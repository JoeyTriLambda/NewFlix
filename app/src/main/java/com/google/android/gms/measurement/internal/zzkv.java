package com.google.android.gms.measurement.internal;

import android.app.Activity;
import android.content.Context;
import android.os.Bundle;
import com.google.android.gms.common.internal.Preconditions;
import com.google.android.gms.common.util.Clock;
import com.unity3d.ads.metadata.MediationMetaData;
import java.util.Objects;
import java.util.concurrent.ConcurrentHashMap;

/* compiled from: com.google.android.gms:play-services-measurement-impl@@21.6.1 */
/* loaded from: classes.dex */
public final class zzkv extends zzg {

    /* renamed from: c, reason: collision with root package name */
    public volatile zzks f8362c;

    /* renamed from: d, reason: collision with root package name */
    public volatile zzks f8363d;

    /* renamed from: e, reason: collision with root package name */
    public zzks f8364e;

    /* renamed from: f, reason: collision with root package name */
    public final ConcurrentHashMap f8365f;

    /* renamed from: g, reason: collision with root package name */
    public Activity f8366g;

    /* renamed from: h, reason: collision with root package name */
    public volatile boolean f8367h;

    /* renamed from: i, reason: collision with root package name */
    public volatile zzks f8368i;

    /* renamed from: j, reason: collision with root package name */
    public zzks f8369j;

    /* renamed from: k, reason: collision with root package name */
    public boolean f8370k;

    /* renamed from: l, reason: collision with root package name */
    public final Object f8371l;

    public zzkv(zzho zzhoVar) {
        super(zzhoVar);
        this.f8371l = new Object();
        this.f8365f = new ConcurrentHashMap();
    }

    public final String a(Class cls) {
        String canonicalName = cls.getCanonicalName();
        if (canonicalName == null) {
            return "Activity";
        }
        String[] strArrSplit = canonicalName.split("\\.");
        String str = strArrSplit.length > 0 ? strArrSplit[strArrSplit.length - 1] : "";
        return str.length() > zze().a(null, false) ? str.substring(0, zze().a(null, false)) : str;
    }

    public final void b(Activity activity, zzks zzksVar, boolean z10) throws IllegalStateException {
        zzks zzksVar2;
        zzks zzksVar3 = this.f8362c == null ? this.f8363d : this.f8362c;
        if (zzksVar.f8352b == null) {
            zzksVar2 = new zzks(zzksVar.f8351a, activity != null ? a(activity.getClass()) : null, zzksVar.f8353c, zzksVar.f8355e, zzksVar.f8356f);
        } else {
            zzksVar2 = zzksVar;
        }
        this.f8363d = this.f8362c;
        this.f8362c = zzksVar2;
        zzl().zzb(new zzkx(this, zzksVar2, zzksVar3, zzb().elapsedRealtime(), z10));
    }

    /* JADX WARN: Removed duplicated region for block: B:12:0x0026  */
    /* JADX WARN: Removed duplicated region for block: B:48:0x00a2  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public final void c(com.google.android.gms.measurement.internal.zzks r10, com.google.android.gms.measurement.internal.zzks r11, long r12, boolean r14, android.os.Bundle r15) throws java.lang.IllegalStateException, java.lang.IllegalAccessException, java.lang.ClassNotFoundException, java.lang.IllegalArgumentException, java.lang.reflect.InvocationTargetException {
        /*
            r9 = this;
            r9.zzt()
            r0 = 0
            r1 = 1
            if (r11 == 0) goto L26
            long r2 = r10.f8353c
            long r4 = r11.f8353c
            int r6 = (r4 > r2 ? 1 : (r4 == r2 ? 0 : -1))
            if (r6 != 0) goto L26
            java.lang.String r2 = r11.f8352b
            java.lang.String r3 = r10.f8352b
            boolean r2 = java.util.Objects.equals(r2, r3)
            if (r2 == 0) goto L26
            java.lang.String r2 = r11.f8351a
            java.lang.String r3 = r10.f8351a
            boolean r2 = java.util.Objects.equals(r2, r3)
            if (r2 != 0) goto L24
            goto L26
        L24:
            r2 = 0
            goto L27
        L26:
            r2 = 1
        L27:
            if (r14 == 0) goto L2e
            com.google.android.gms.measurement.internal.zzks r14 = r9.f8364e
            if (r14 == 0) goto L2e
            r0 = 1
        L2e:
            if (r2 == 0) goto Lac
            android.os.Bundle r6 = new android.os.Bundle
            if (r15 == 0) goto L38
            r6.<init>(r15)
            goto L3b
        L38:
            r6.<init>()
        L3b:
            com.google.android.gms.measurement.internal.zznt.zza(r10, r6, r1)
            if (r11 == 0) goto L59
            java.lang.String r14 = r11.f8351a
            if (r14 == 0) goto L49
            java.lang.String r15 = "_pn"
            r6.putString(r15, r14)
        L49:
            java.lang.String r14 = r11.f8352b
            if (r14 == 0) goto L52
            java.lang.String r15 = "_pc"
            r6.putString(r15, r14)
        L52:
            java.lang.String r14 = "_pi"
            long r2 = r11.f8353c
            r6.putLong(r14, r2)
        L59:
            r14 = 0
            if (r0 == 0) goto L74
            com.google.android.gms.measurement.internal.zzmi r11 = r9.zzp()
            com.google.android.gms.measurement.internal.zzmo r11 = r11.f8495f
            long r2 = r11.f8507b
            long r2 = r12 - r2
            r11.f8507b = r12
            int r11 = (r2 > r14 ? 1 : (r2 == r14 ? 0 : -1))
            if (r11 <= 0) goto L74
            com.google.android.gms.measurement.internal.zznt r11 = r9.zzq()
            r11.zza(r6, r2)
        L74:
            com.google.android.gms.measurement.internal.zzae r11 = r9.zze()
            boolean r11 = r11.zzv()
            if (r11 != 0) goto L85
            java.lang.String r11 = "_mst"
            r2 = 1
            r6.putLong(r11, r2)
        L85:
            boolean r11 = r10.f8355e
            if (r11 == 0) goto L8c
            java.lang.String r11 = "app"
            goto L8e
        L8c:
            java.lang.String r11 = "auto"
        L8e:
            r4 = r11
            com.google.android.gms.common.util.Clock r11 = r9.zzb()
            long r2 = r11.currentTimeMillis()
            boolean r11 = r10.f8355e
            if (r11 == 0) goto La2
            long r7 = r10.f8356f
            int r11 = (r7 > r14 ? 1 : (r7 == r14 ? 0 : -1))
            if (r11 == 0) goto La2
            goto La3
        La2:
            r7 = r2
        La3:
            com.google.android.gms.measurement.internal.zziy r3 = r9.zzm()
            java.lang.String r5 = "_vs"
            r3.i(r4, r5, r6, r7)
        Lac:
            if (r0 == 0) goto Lb3
            com.google.android.gms.measurement.internal.zzks r11 = r9.f8364e
            r9.d(r11, r1, r12)
        Lb3:
            r9.f8364e = r10
            boolean r11 = r10.f8355e
            if (r11 == 0) goto Lbb
            r9.f8369j = r10
        Lbb:
            com.google.android.gms.measurement.internal.zzla r11 = r9.zzo()
            r11.zza(r10)
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.gms.measurement.internal.zzkv.c(com.google.android.gms.measurement.internal.zzks, com.google.android.gms.measurement.internal.zzks, long, boolean, android.os.Bundle):void");
    }

    public final void d(zzks zzksVar, boolean z10, long j10) {
        zzc().zza(zzb().elapsedRealtime());
        if (!zzp().zza(zzksVar != null && zzksVar.f8354d, z10, j10) || zzksVar == null) {
            return;
        }
        zzksVar.f8354d = false;
    }

    public final zzks e(Activity activity) {
        Preconditions.checkNotNull(activity);
        zzks zzksVar = (zzks) this.f8365f.get(activity);
        if (zzksVar == null) {
            zzks zzksVar2 = new zzks(null, a(activity.getClass()), zzq().zzm());
            this.f8365f.put(activity, zzksVar2);
            zzksVar = zzksVar2;
        }
        return this.f8368i != null ? this.f8368i : zzksVar;
    }

    @Override // com.google.android.gms.measurement.internal.zzim, com.google.android.gms.measurement.internal.zzio
    public final /* bridge */ /* synthetic */ Context zza() {
        return super.zza();
    }

    public final zzks zzaa() {
        return this.f8362c;
    }

    @Override // com.google.android.gms.measurement.internal.zzim, com.google.android.gms.measurement.internal.zzio
    public final /* bridge */ /* synthetic */ Clock zzb() {
        return super.zzb();
    }

    @Override // com.google.android.gms.measurement.internal.zzd
    public final /* bridge */ /* synthetic */ zza zzc() {
        return super.zzc();
    }

    @Override // com.google.android.gms.measurement.internal.zzim, com.google.android.gms.measurement.internal.zzio
    public final /* bridge */ /* synthetic */ zzad zzd() {
        return super.zzd();
    }

    @Override // com.google.android.gms.measurement.internal.zzim
    public final /* bridge */ /* synthetic */ zzae zze() {
        return super.zze();
    }

    @Override // com.google.android.gms.measurement.internal.zzim
    public final /* bridge */ /* synthetic */ zzaz zzf() {
        return super.zzf();
    }

    @Override // com.google.android.gms.measurement.internal.zzim
    public final /* bridge */ /* synthetic */ zzfw zzi() {
        return super.zzi();
    }

    @Override // com.google.android.gms.measurement.internal.zzim, com.google.android.gms.measurement.internal.zzio
    public final /* bridge */ /* synthetic */ zzgb zzj() {
        return super.zzj();
    }

    @Override // com.google.android.gms.measurement.internal.zzim
    public final /* bridge */ /* synthetic */ zzgm zzk() {
        return super.zzk();
    }

    @Override // com.google.android.gms.measurement.internal.zzim, com.google.android.gms.measurement.internal.zzio
    public final /* bridge */ /* synthetic */ zzhh zzl() {
        return super.zzl();
    }

    @Override // com.google.android.gms.measurement.internal.zzd
    public final /* bridge */ /* synthetic */ zziy zzm() {
        return super.zzm();
    }

    @Override // com.google.android.gms.measurement.internal.zzd
    public final /* bridge */ /* synthetic */ zzla zzo() {
        return super.zzo();
    }

    @Override // com.google.android.gms.measurement.internal.zzd
    public final /* bridge */ /* synthetic */ zzmi zzp() {
        return super.zzp();
    }

    @Override // com.google.android.gms.measurement.internal.zzim
    public final /* bridge */ /* synthetic */ zznt zzq() {
        return super.zzq();
    }

    @Override // com.google.android.gms.measurement.internal.zzd, com.google.android.gms.measurement.internal.zzim
    public final /* bridge */ /* synthetic */ void zzt() {
        super.zzt();
    }

    @Override // com.google.android.gms.measurement.internal.zzg
    public final boolean zzz() {
        return false;
    }

    public final zzks zza(boolean z10) {
        zzu();
        zzt();
        if (!z10) {
            return this.f8364e;
        }
        zzks zzksVar = this.f8364e;
        return zzksVar != null ? zzksVar : this.f8369j;
    }

    public final void zzb(Activity activity) throws IllegalStateException {
        synchronized (this.f8371l) {
            this.f8370k = false;
            this.f8367h = true;
        }
        long jElapsedRealtime = zzb().elapsedRealtime();
        if (!zze().zzv()) {
            this.f8362c = null;
            zzl().zzb(new zzkz(this, jElapsedRealtime));
        } else {
            zzks zzksVarE = e(activity);
            this.f8363d = this.f8362c;
            this.f8362c = null;
            zzl().zzb(new zzky(this, zzksVarE, jElapsedRealtime));
        }
    }

    public final void zzc(Activity activity) throws IllegalStateException {
        synchronized (this.f8371l) {
            this.f8370k = true;
            if (activity != this.f8366g) {
                synchronized (this.f8371l) {
                    this.f8366g = activity;
                    this.f8367h = false;
                }
                if (zze().zzv()) {
                    this.f8368i = null;
                    zzl().zzb(new zzlb(this));
                }
            }
        }
        if (!zze().zzv()) {
            this.f8362c = this.f8368i;
            zzl().zzb(new zzkw(this));
        } else {
            b(activity, e(activity), false);
            zza zzaVarZzc = zzc();
            zzaVarZzc.zzl().zzb(new zze(zzaVarZzc, zzaVarZzc.zzb().elapsedRealtime()));
        }
    }

    public final void zza(Activity activity, Bundle bundle) {
        Bundle bundle2;
        if (!zze().zzv() || bundle == null || (bundle2 = bundle.getBundle("com.google.app_measurement.screen_service")) == null) {
            return;
        }
        this.f8365f.put(activity, new zzks(bundle2.getString(MediationMetaData.KEY_NAME), bundle2.getString("referrer_name"), bundle2.getLong("id")));
    }

    public final void zza(Activity activity) {
        synchronized (this.f8371l) {
            if (activity == this.f8366g) {
                this.f8366g = null;
            }
        }
        if (zze().zzv()) {
            this.f8365f.remove(activity);
        }
    }

    public final void zzb(Activity activity, Bundle bundle) {
        zzks zzksVar;
        if (!zze().zzv() || bundle == null || (zzksVar = (zzks) this.f8365f.get(activity)) == null) {
            return;
        }
        Bundle bundle2 = new Bundle();
        bundle2.putLong("id", zzksVar.f8353c);
        bundle2.putString(MediationMetaData.KEY_NAME, zzksVar.f8351a);
        bundle2.putString("referrer_name", zzksVar.f8352b);
        bundle.putBundle("com.google.app_measurement.screen_service", bundle2);
    }

    @Deprecated
    public final void zza(Activity activity, String str, String str2) throws IllegalStateException {
        if (!zze().zzv()) {
            zzj().zzv().zza("setCurrentScreen cannot be called while screen reporting is disabled.");
            return;
        }
        zzks zzksVar = this.f8362c;
        if (zzksVar == null) {
            zzj().zzv().zza("setCurrentScreen cannot be called while no activity active");
            return;
        }
        if (this.f8365f.get(activity) == null) {
            zzj().zzv().zza("setCurrentScreen must be called with an activity in the activity lifecycle");
            return;
        }
        if (str2 == null) {
            str2 = a(activity.getClass());
        }
        boolean zEquals = Objects.equals(zzksVar.f8352b, str2);
        boolean zEquals2 = Objects.equals(zzksVar.f8351a, str);
        if (zEquals && zEquals2) {
            zzj().zzv().zza("setCurrentScreen cannot be called with the same class and name");
            return;
        }
        if (str != null && (str.length() <= 0 || str.length() > zze().a(null, false))) {
            zzj().zzv().zza("Invalid screen name length in setCurrentScreen. Length", Integer.valueOf(str.length()));
            return;
        }
        if (str2 != null && (str2.length() <= 0 || str2.length() > zze().a(null, false))) {
            zzj().zzv().zza("Invalid class name length in setCurrentScreen. Length", Integer.valueOf(str2.length()));
            return;
        }
        zzj().zzp().zza("Setting current screen to name, class", str == null ? "null" : str, str2);
        zzks zzksVar2 = new zzks(str, str2, zzq().zzm());
        this.f8365f.put(activity, zzksVar2);
        b(activity, zzksVar2, true);
    }

    public final void zza(Bundle bundle, long j10) {
        String str;
        synchronized (this.f8371l) {
            if (!this.f8370k) {
                zzj().zzv().zza("Cannot log screen view event when the app is in the background.");
                return;
            }
            String strA = null;
            if (bundle != null) {
                String string = bundle.getString("screen_name");
                if (string != null && (string.length() <= 0 || string.length() > zze().a(null, false))) {
                    zzj().zzv().zza("Invalid screen name length for screen view. Length", Integer.valueOf(string.length()));
                    return;
                }
                String string2 = bundle.getString("screen_class");
                if (string2 != null && (string2.length() <= 0 || string2.length() > zze().a(null, false))) {
                    zzj().zzv().zza("Invalid screen class length for screen view. Length", Integer.valueOf(string2.length()));
                    return;
                } else {
                    str = string;
                    strA = string2;
                }
            } else {
                str = null;
            }
            if (strA == null) {
                Activity activity = this.f8366g;
                strA = activity != null ? a(activity.getClass()) : "Activity";
            }
            String str2 = strA;
            zzks zzksVar = this.f8362c;
            if (this.f8367h && zzksVar != null) {
                this.f8367h = false;
                boolean zEquals = Objects.equals(zzksVar.f8352b, str2);
                boolean zEquals2 = Objects.equals(zzksVar.f8351a, str);
                if (zEquals && zEquals2) {
                    zzj().zzv().zza("Ignoring call to log screen view event with duplicate parameters.");
                    return;
                }
            }
            zzj().zzp().zza("Logging screen view with name, class", str == null ? "null" : str, str2 == null ? "null" : str2);
            zzks zzksVar2 = this.f8362c == null ? this.f8363d : this.f8362c;
            zzks zzksVar3 = new zzks(str, str2, zzq().zzm(), true, j10);
            this.f8362c = zzksVar3;
            this.f8363d = zzksVar2;
            this.f8368i = zzksVar3;
            zzl().zzb(new zzku(this, bundle, zzksVar3, zzksVar2, zzb().elapsedRealtime()));
        }
    }
}
