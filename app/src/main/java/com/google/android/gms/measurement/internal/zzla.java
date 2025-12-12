package com.google.android.gms.measurement.internal;

import android.content.ComponentName;
import android.content.Context;
import android.content.Intent;
import android.content.pm.ResolveInfo;
import android.os.Bundle;
import android.os.RemoteException;
import com.google.android.gms.common.internal.Preconditions;
import com.google.android.gms.common.internal.safeparcel.AbstractSafeParcelable;
import com.google.android.gms.common.stats.ConnectionTracker;
import com.google.android.gms.common.util.Clock;
import java.lang.reflect.InvocationTargetException;
import java.security.NoSuchAlgorithmException;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.concurrent.atomic.AtomicReference;
import org.apache.commons.lang3.time.DateUtils;

/* compiled from: com.google.android.gms:play-services-measurement-impl@@21.6.1 */
/* loaded from: classes.dex */
public final class zzla extends zzg {

    /* renamed from: c, reason: collision with root package name */
    public final zzlx f8385c;

    /* renamed from: d, reason: collision with root package name */
    public zzfq f8386d;

    /* renamed from: e, reason: collision with root package name */
    public volatile Boolean f8387e;

    /* renamed from: f, reason: collision with root package name */
    public final zzld f8388f;

    /* renamed from: g, reason: collision with root package name */
    public final zzms f8389g;

    /* renamed from: h, reason: collision with root package name */
    public final ArrayList f8390h;

    /* renamed from: i, reason: collision with root package name */
    public final zzlm f8391i;

    public zzla(zzho zzhoVar) {
        super(zzhoVar);
        this.f8390h = new ArrayList();
        this.f8389g = new zzms(zzhoVar.zzb());
        this.f8385c = new zzlx(this);
        this.f8388f = new zzld(this, zzhoVar);
        this.f8391i = new zzlm(this, zzhoVar);
    }

    public static /* synthetic */ void b(zzla zzlaVar, ComponentName componentName) throws IllegalStateException {
        zzlaVar.zzt();
        if (zzlaVar.f8386d != null) {
            zzlaVar.f8386d = null;
            zzlaVar.zzj().zzp().zza("Disconnected from device MeasurementService", componentName);
            zzlaVar.zzt();
            zzlaVar.zzad();
        }
    }

    public final void a(zzfq zzfqVar, AbstractSafeParcelable abstractSafeParcelable, zzn zznVar) throws IllegalStateException {
        int size;
        zzt();
        zzu();
        int i10 = 0;
        int i11 = 100;
        while (i10 < 1001 && i11 == 100) {
            ArrayList arrayList = new ArrayList();
            List<AbstractSafeParcelable> listZza = zzh().zza(100);
            if (listZza != null) {
                arrayList.addAll(listZza);
                size = listZza.size();
            } else {
                size = 0;
            }
            if (abstractSafeParcelable != null && size < 100) {
                arrayList.add(abstractSafeParcelable);
            }
            int size2 = arrayList.size();
            int i12 = 0;
            while (i12 < size2) {
                Object obj = arrayList.get(i12);
                i12++;
                AbstractSafeParcelable abstractSafeParcelable2 = (AbstractSafeParcelable) obj;
                if (abstractSafeParcelable2 instanceof zzbf) {
                    try {
                        zzfqVar.zza((zzbf) abstractSafeParcelable2, zznVar);
                    } catch (RemoteException e10) {
                        zzj().zzg().zza("Failed to send event to the service", e10);
                    }
                } else if (abstractSafeParcelable2 instanceof zzno) {
                    try {
                        zzfqVar.zza((zzno) abstractSafeParcelable2, zznVar);
                    } catch (RemoteException e11) {
                        zzj().zzg().zza("Failed to send user property to the service", e11);
                    }
                } else if (abstractSafeParcelable2 instanceof zzac) {
                    try {
                        zzfqVar.zza((zzac) abstractSafeParcelable2, zznVar);
                    } catch (RemoteException e12) {
                        zzj().zzg().zza("Failed to send conditional user property to the service", e12);
                    }
                } else {
                    zzj().zzg().zza("Discarding data. Unrecognized parcel type.");
                }
            }
            i10++;
            i11 = size;
        }
    }

    public final boolean c() {
        zzt();
        zzu();
        return !d() || zzq().zzg() >= zzbh.f7754n0.zza(null).intValue();
    }

    /* JADX WARN: Removed duplicated region for block: B:44:0x00f3  */
    /* JADX WARN: Removed duplicated region for block: B:47:0x010b  */
    /* JADX WARN: Removed duplicated region for block: B:49:0x010e  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public final boolean d() throws java.lang.IllegalStateException {
        /*
            Method dump skipped, instructions count: 304
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.gms.measurement.internal.zzla.d():boolean");
    }

    /* JADX WARN: Removed duplicated region for block: B:108:0x02cf  */
    /* JADX WARN: Removed duplicated region for block: B:111:0x02e5  */
    /* JADX WARN: Removed duplicated region for block: B:114:0x02ed  */
    /* JADX WARN: Removed duplicated region for block: B:117:0x0304  */
    /* JADX WARN: Removed duplicated region for block: B:120:0x0314  */
    /* JADX WARN: Removed duplicated region for block: B:123:0x0331  */
    /* JADX WARN: Removed duplicated region for block: B:132:0x02a5 A[EXC_TOP_SPLITTER, SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:29:0x00fa  */
    /* JADX WARN: Removed duplicated region for block: B:60:0x01c3  */
    /* JADX WARN: Removed duplicated region for block: B:61:0x01c6  */
    /* JADX WARN: Removed duplicated region for block: B:64:0x01fc  */
    /* JADX WARN: Removed duplicated region for block: B:65:0x0200  */
    /* JADX WARN: Removed duplicated region for block: B:68:0x0219  */
    /* JADX WARN: Removed duplicated region for block: B:71:0x022b  */
    /* JADX WARN: Removed duplicated region for block: B:87:0x0272  */
    /* JADX WARN: Removed duplicated region for block: B:91:0x0286  */
    /* JADX WARN: Removed duplicated region for block: B:92:0x0289  */
    /* JADX WARN: Removed duplicated region for block: B:95:0x02a1  */
    /* JADX WARN: Unreachable blocks removed: 1, instructions: 2 */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public final com.google.android.gms.measurement.internal.zzn e(boolean r50) throws java.lang.IllegalStateException, java.lang.IllegalAccessException, java.lang.NoSuchMethodException, java.security.NoSuchAlgorithmException, java.lang.ClassNotFoundException, java.lang.SecurityException, java.lang.IllegalArgumentException, java.lang.reflect.InvocationTargetException {
        /*
            Method dump skipped, instructions count: 884
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.gms.measurement.internal.zzla.e(boolean):com.google.android.gms.measurement.internal.zzn");
    }

    @Override // com.google.android.gms.measurement.internal.zzim, com.google.android.gms.measurement.internal.zzio
    public final /* bridge */ /* synthetic */ Context zza() {
        return super.zza();
    }

    public final zzal zzaa() {
        zzt();
        zzu();
        zzfq zzfqVar = this.f8386d;
        if (zzfqVar == null) {
            zzad();
            zzj().zzc().zza("Failed to get consents; not connected to service yet.");
            return null;
        }
        zzn zznVarE = e(false);
        Preconditions.checkNotNull(zznVarE);
        try {
            zzal zzalVarZza = zzfqVar.zza(zznVarE);
            zzam();
            return zzalVarZza;
        } catch (RemoteException e10) {
            zzj().zzg().zza("Failed to get consents; remote exception", e10);
            return null;
        }
    }

    public final void zzac() throws IllegalStateException, IllegalAccessException, NoSuchMethodException, NoSuchAlgorithmException, ClassNotFoundException, SecurityException, IllegalArgumentException, InvocationTargetException {
        zzt();
        zzu();
        zzn zznVarE = e(true);
        zzh().zzab();
        zza(new zzll(this, zznVarE));
    }

    public final void zzad() {
        zzt();
        zzu();
        if (zzah()) {
            return;
        }
        boolean zD = d();
        zzlx zzlxVar = this.f8385c;
        if (zD) {
            zzlxVar.zza();
            return;
        }
        if (zze().zzx()) {
            return;
        }
        List<ResolveInfo> listQueryIntentServices = zza().getPackageManager().queryIntentServices(new Intent().setClassName(zza(), "com.google.android.gms.measurement.AppMeasurementService"), 65536);
        if (!((listQueryIntentServices == null || listQueryIntentServices.isEmpty()) ? false : true)) {
            zzj().zzg().zza("Unable to use remote or local measurement implementation. Please register the AppMeasurementService service in the app manifest");
            return;
        }
        Intent intent = new Intent("com.google.android.gms.measurement.START");
        intent.setComponent(new ComponentName(zza(), "com.google.android.gms.measurement.AppMeasurementService"));
        zzlxVar.zza(intent);
    }

    public final void zzae() {
        zzt();
        zzu();
        zzlx zzlxVar = this.f8385c;
        zzlxVar.zzb();
        try {
            ConnectionTracker.getInstance().unbindService(zza(), zzlxVar);
        } catch (IllegalArgumentException | IllegalStateException unused) {
        }
        this.f8386d = null;
    }

    public final void zzaf() {
        zzt();
        zzu();
        zzn zznVarE = e(false);
        zzh().zzaa();
        zza(new zzlg(this, zznVarE));
    }

    public final void zzag() {
        zzt();
        zzu();
        zza(new zzlo(this, e(true)));
    }

    public final boolean zzah() {
        zzt();
        zzu();
        return this.f8386d != null;
    }

    public final void zzal() throws IllegalStateException {
        zzt();
        zzgd zzgdVarZzp = zzj().zzp();
        ArrayList arrayList = this.f8390h;
        zzgdVarZzp.zza("Processing queued up service tasks", Integer.valueOf(arrayList.size()));
        Iterator it = arrayList.iterator();
        while (it.hasNext()) {
            try {
                ((Runnable) it.next()).run();
            } catch (RuntimeException e10) {
                zzj().zzg().zza("Task exception while flushing queue", e10);
            }
        }
        arrayList.clear();
        this.f8391i.a();
    }

    public final void zzam() {
        zzt();
        this.f8389g.zzb();
        this.f8388f.zza(zzbh.K.zza(null).longValue());
    }

    @Override // com.google.android.gms.measurement.internal.zzim, com.google.android.gms.measurement.internal.zzio
    public final /* bridge */ /* synthetic */ Clock zzb() {
        return super.zzb();
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

    @Override // com.google.android.gms.measurement.internal.zzd
    public final /* bridge */ /* synthetic */ zzfv zzg() {
        return super.zzg();
    }

    @Override // com.google.android.gms.measurement.internal.zzd
    public final /* bridge */ /* synthetic */ zzfu zzh() {
        return super.zzh();
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

    public final void zza(com.google.android.gms.internal.measurement.zzdi zzdiVar) throws IllegalStateException {
        zzt();
        zzu();
        zza(new zzli(this, e(false), zzdiVar));
    }

    public final void zza(AtomicReference<String> atomicReference) {
        zzt();
        zzu();
        zza(new zzlj(this, atomicReference, e(false)));
    }

    public final void zza(com.google.android.gms.internal.measurement.zzdi zzdiVar, String str, String str2) throws IllegalStateException {
        zzt();
        zzu();
        zza(new zzlv(this, str, str2, e(false), zzdiVar));
    }

    public final void zza(AtomicReference<List<zzac>> atomicReference, String str, String str2, String str3) throws IllegalStateException {
        zzt();
        zzu();
        zza(new zzls(this, atomicReference, str, str2, str3, e(false)));
    }

    public final void zza(AtomicReference<List<zzmv>> atomicReference, Bundle bundle) throws IllegalStateException {
        zzt();
        zzu();
        zza(new zzle(this, atomicReference, e(false), bundle));
    }

    public final void zza(com.google.android.gms.internal.measurement.zzdi zzdiVar, String str, String str2, boolean z10) throws IllegalStateException {
        zzt();
        zzu();
        zza(new zzlc(this, str, str2, e(false), z10, zzdiVar));
    }

    public final void zza(AtomicReference<List<zzno>> atomicReference, String str, String str2, String str3, boolean z10) throws IllegalStateException {
        zzt();
        zzu();
        zza(new zzlu(this, atomicReference, str, str2, str3, e(false), z10));
    }

    public final void zza(zzbf zzbfVar, String str) {
        Preconditions.checkNotNull(zzbfVar);
        zzt();
        zzu();
        zza(new zzlq(this, e(true), zzh().zza(zzbfVar), zzbfVar, str));
    }

    public final void zza(com.google.android.gms.internal.measurement.zzdi zzdiVar, zzbf zzbfVar, String str) throws IllegalStateException {
        zzt();
        zzu();
        if (zzq().zza(12451000) != 0) {
            zzj().zzu().zza("Not bundling data. Service unavailable or out of date");
            zzq().zza(zzdiVar, new byte[0]);
        } else {
            zza(new zzlp(this, zzbfVar, str, zzdiVar));
        }
    }

    public final void zza(Runnable runnable) throws IllegalStateException {
        zzt();
        if (zzah()) {
            runnable.run();
            return;
        }
        ArrayList arrayList = this.f8390h;
        if (arrayList.size() >= 1000) {
            zzj().zzg().zza("Discarding data. Max runnable queue size reached");
            return;
        }
        arrayList.add(runnable);
        this.f8391i.zza(DateUtils.MILLIS_PER_MINUTE);
        zzad();
    }

    public final void zza(zzac zzacVar) throws IllegalStateException {
        Preconditions.checkNotNull(zzacVar);
        zzt();
        zzu();
        zza(new zzlt(this, e(true), zzh().zza(zzacVar), new zzac(zzacVar), zzacVar));
    }

    public final void zza(boolean z10) {
        zzt();
        zzu();
        if (z10) {
            zzh().zzaa();
        }
        if (c()) {
            zza(new zzlr(this, e(false)));
        }
    }

    public final void zza(zzks zzksVar) {
        zzt();
        zzu();
        zza(new zzlk(this, zzksVar));
    }

    public final void zza(Bundle bundle) {
        zzt();
        zzu();
        zza(new zzln(this, e(false), bundle));
    }

    public final void zza(zzfq zzfqVar) throws IllegalStateException {
        zzt();
        Preconditions.checkNotNull(zzfqVar);
        this.f8386d = zzfqVar;
        zzam();
        zzal();
    }

    public final void zza(zzno zznoVar) {
        zzt();
        zzu();
        zza(new zzlh(this, e(true), zzh().zza(zznoVar), zznoVar));
    }
}
