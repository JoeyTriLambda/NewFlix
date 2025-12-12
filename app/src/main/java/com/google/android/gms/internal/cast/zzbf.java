package com.google.android.gms.internal.cast;

import a2.m;
import a2.n;
import a2.v;
import android.content.Context;
import android.content.Intent;
import android.os.Build;
import android.os.Bundle;
import android.os.Looper;
import android.support.v4.media.session.MediaSessionCompat;
import com.google.android.gms.cast.framework.CastOptions;
import com.google.android.gms.cast.internal.Logger;
import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.Map;
import java.util.Set;

/* compiled from: com.google.android.gms:play-services-cast-framework@@21.4.0 */
/* loaded from: classes.dex */
public final class zzbf extends zzal {
    private static final Logger zza = new Logger("MediaRouterProxy");
    private final n zzb;
    private final CastOptions zzc;
    private final Map zzd = new HashMap();
    private zzbn zze;
    private boolean zzf;

    public zzbf(Context context, n nVar, final CastOptions castOptions, com.google.android.gms.cast.internal.zzn zznVar) {
        this.zzb = nVar;
        this.zzc = castOptions;
        if (Build.VERSION.SDK_INT <= 32) {
            zza.i("Don't need to set MediaRouterParams for Android S v2 or below", new Object[0]);
            return;
        }
        zza.d("Set up MediaRouterParams based on module flag and CastOptions for Android T or above", new Object[0]);
        this.zze = new zzbn(castOptions);
        Intent intent = new Intent(context, (Class<?>) v.class);
        intent.setPackage(context.getPackageName());
        boolean z10 = !context.getPackageManager().queryBroadcastReceivers(intent, 0).isEmpty();
        this.zzf = z10;
        if (z10) {
            zzo.zzd(zzml.CAST_OUTPUT_SWITCHER_ENABLED);
        }
        zznVar.zza(new String[]{"com.google.android.gms.cast.FLAG_OUTPUT_SWITCHER_ENABLED"}).addOnCompleteListener(new OnCompleteListener() { // from class: com.google.android.gms.internal.cast.zzbc
            @Override // com.google.android.gms.tasks.OnCompleteListener
            public final void onComplete(Task task) {
                this.zza.zzp(castOptions, task);
            }
        });
    }

    private final void zzt(m mVar, int i10) {
        Set set = (Set) this.zzd.get(mVar);
        if (set == null) {
            return;
        }
        Iterator it = set.iterator();
        while (it.hasNext()) {
            this.zzb.addCallback(mVar, (n.a) it.next(), i10);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: zzu, reason: merged with bridge method [inline-methods] */
    public final void zzq(m mVar) {
        Set set = (Set) this.zzd.get(mVar);
        if (set == null) {
            return;
        }
        Iterator it = set.iterator();
        while (it.hasNext()) {
            this.zzb.removeCallback((n.a) it.next());
        }
    }

    @Override // com.google.android.gms.internal.cast.zzam
    public final Bundle zzb(String str) {
        for (n.g gVar : this.zzb.getRoutes()) {
            if (gVar.getId().equals(str)) {
                return gVar.getExtras();
            }
        }
        return null;
    }

    @Override // com.google.android.gms.internal.cast.zzam
    public final String zzc() {
        return this.zzb.getSelectedRoute().getId();
    }

    @Override // com.google.android.gms.internal.cast.zzam
    public final void zzd(Bundle bundle, final int i10) {
        final m mVarFromBundle = m.fromBundle(bundle);
        if (mVarFromBundle == null) {
            return;
        }
        if (Looper.myLooper() == Looper.getMainLooper()) {
            zzt(mVarFromBundle, i10);
        } else {
            new zzed(Looper.getMainLooper()).post(new Runnable() { // from class: com.google.android.gms.internal.cast.zzbe
                @Override // java.lang.Runnable
                public final void run() {
                    this.zza.zzo(mVarFromBundle, i10);
                }
            });
        }
    }

    @Override // com.google.android.gms.internal.cast.zzam
    public final void zze(Bundle bundle, zzao zzaoVar) {
        m mVarFromBundle = m.fromBundle(bundle);
        if (mVarFromBundle == null) {
            return;
        }
        if (!this.zzd.containsKey(mVarFromBundle)) {
            this.zzd.put(mVarFromBundle, new HashSet());
        }
        ((Set) this.zzd.get(mVarFromBundle)).add(new zzat(zzaoVar));
    }

    @Override // com.google.android.gms.internal.cast.zzam
    public final void zzf() {
        Iterator it = this.zzd.values().iterator();
        while (it.hasNext()) {
            Iterator it2 = ((Set) it.next()).iterator();
            while (it2.hasNext()) {
                this.zzb.removeCallback((n.a) it2.next());
            }
        }
        this.zzd.clear();
    }

    @Override // com.google.android.gms.internal.cast.zzam
    public final void zzg(Bundle bundle) {
        final m mVarFromBundle = m.fromBundle(bundle);
        if (mVarFromBundle == null) {
            return;
        }
        if (Looper.myLooper() == Looper.getMainLooper()) {
            zzq(mVarFromBundle);
        } else {
            new zzed(Looper.getMainLooper()).post(new Runnable() { // from class: com.google.android.gms.internal.cast.zzbd
                @Override // java.lang.Runnable
                public final void run() {
                    this.zza.zzq(mVarFromBundle);
                }
            });
        }
    }

    @Override // com.google.android.gms.internal.cast.zzam
    public final void zzh() {
        n nVar = this.zzb;
        nVar.selectRoute(nVar.getDefaultRoute());
    }

    @Override // com.google.android.gms.internal.cast.zzam
    public final void zzi(String str) {
        zza.d("select route with routeId = %s", str);
        for (n.g gVar : this.zzb.getRoutes()) {
            if (gVar.getId().equals(str)) {
                zza.d("media route is found and selected", new Object[0]);
                this.zzb.selectRoute(gVar);
                return;
            }
        }
    }

    @Override // com.google.android.gms.internal.cast.zzam
    public final void zzj(int i10) {
        this.zzb.unselect(i10);
    }

    @Override // com.google.android.gms.internal.cast.zzam
    public final boolean zzk() {
        n.g bluetoothRoute = this.zzb.getBluetoothRoute();
        return bluetoothRoute != null && this.zzb.getSelectedRoute().getId().equals(bluetoothRoute.getId());
    }

    @Override // com.google.android.gms.internal.cast.zzam
    public final boolean zzl() {
        n.g defaultRoute = this.zzb.getDefaultRoute();
        return defaultRoute != null && this.zzb.getSelectedRoute().getId().equals(defaultRoute.getId());
    }

    @Override // com.google.android.gms.internal.cast.zzam
    public final boolean zzm(Bundle bundle, int i10) {
        m mVarFromBundle = m.fromBundle(bundle);
        if (mVarFromBundle == null) {
            return false;
        }
        return this.zzb.isRouteAvailable(mVarFromBundle, i10);
    }

    public final zzbn zzn() {
        return this.zze;
    }

    public final /* synthetic */ void zzo(m mVar, int i10) {
        synchronized (this.zzd) {
            zzt(mVar, i10);
        }
    }

    /* JADX WARN: Removed duplicated region for block: B:17:0x0034  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public final /* synthetic */ void zzp(com.google.android.gms.cast.framework.CastOptions r8, com.google.android.gms.tasks.Task r9) {
        /*
            r7 = this;
            boolean r0 = r9.isSuccessful()
            r1 = 0
            r2 = 1
            if (r0 == 0) goto L34
            java.lang.Object r9 = r9.getResult()
            android.os.Bundle r9 = (android.os.Bundle) r9
            java.lang.String r0 = "com.google.android.gms.cast.FLAG_OUTPUT_SWITCHER_ENABLED"
            if (r9 == 0) goto L1a
            boolean r3 = r9.containsKey(r0)
            if (r3 == 0) goto L1a
            r3 = 1
            goto L1b
        L1a:
            r3 = 0
        L1b:
            com.google.android.gms.cast.internal.Logger r4 = com.google.android.gms.internal.cast.zzbf.zza
            java.lang.Object[] r5 = new java.lang.Object[r2]
            if (r2 == r3) goto L24
            java.lang.String r6 = "not existed"
            goto L26
        L24:
            java.lang.String r6 = "existed"
        L26:
            r5[r1] = r6
            java.lang.String r6 = "The module-to-client output switcher flag %s"
            r4.d(r6, r5)
            if (r3 == 0) goto L34
            boolean r9 = r9.getBoolean(r0)
            goto L35
        L34:
            r9 = 1
        L35:
            com.google.android.gms.cast.internal.Logger r0 = com.google.android.gms.internal.cast.zzbf.zza
            r3 = 2
            java.lang.Object[] r4 = new java.lang.Object[r3]
            java.lang.Boolean r5 = java.lang.Boolean.valueOf(r9)
            r4[r1] = r5
            boolean r5 = r8.zzh()
            java.lang.Boolean r5 = java.lang.Boolean.valueOf(r5)
            r4[r2] = r5
            java.lang.String r5 = "Set up output switcher flags: %b (from module), %b (from CastOptions)"
            r0.i(r5, r4)
            if (r9 == 0) goto L59
            boolean r8 = r8.zzh()
            if (r8 == 0) goto L59
            r8 = 1
            goto L5a
        L59:
            r8 = 0
        L5a:
            a2.n r9 = r7.zzb
            if (r9 == 0) goto Lbf
            com.google.android.gms.cast.framework.CastOptions r4 = r7.zzc
            if (r4 != 0) goto L63
            goto Lbf
        L63:
            boolean r5 = r4.zzf()
            boolean r4 = r4.zze()
            a2.u$a r6 = new a2.u$a
            r6.<init>()
            a2.u$a r6 = r6.setMediaTransferReceiverEnabled(r8)
            a2.u$a r6 = r6.setTransferToLocalEnabled(r5)
            a2.u$a r6 = r6.setOutputSwitcherEnabled(r4)
            a2.u r6 = r6.build()
            r9.setRouterParams(r6)
            r9 = 4
            java.lang.Object[] r9 = new java.lang.Object[r9]
            boolean r6 = r7.zzf
            java.lang.Boolean r6 = java.lang.Boolean.valueOf(r6)
            r9[r1] = r6
            java.lang.Boolean r8 = java.lang.Boolean.valueOf(r8)
            r9[r2] = r8
            java.lang.Boolean r8 = java.lang.Boolean.valueOf(r5)
            r9[r3] = r8
            r8 = 3
            java.lang.Boolean r1 = java.lang.Boolean.valueOf(r4)
            r9[r8] = r1
            java.lang.String r8 = "media transfer = %b, session transfer = %b, transfer to local = %b, in-app output switcher = %b"
            r0.i(r8, r9)
            if (r5 == 0) goto Lbf
            a2.n r8 = r7.zzb
            com.google.android.gms.internal.cast.zzbb r9 = new com.google.android.gms.internal.cast.zzbb
            com.google.android.gms.internal.cast.zzbn r0 = r7.zze
            java.lang.Object r0 = com.google.android.gms.common.internal.Preconditions.checkNotNull(r0)
            com.google.android.gms.internal.cast.zzbn r0 = (com.google.android.gms.internal.cast.zzbn) r0
            r9.<init>(r0)
            r8.setOnPrepareTransferListener(r9)
            com.google.android.gms.internal.cast.zzml r8 = com.google.android.gms.internal.cast.zzml.CAST_TRANSFER_TO_LOCAL_ENABLED
            com.google.android.gms.internal.cast.zzo.zzd(r8)
        Lbf:
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.gms.internal.cast.zzbf.zzp(com.google.android.gms.cast.framework.CastOptions, com.google.android.gms.tasks.Task):void");
    }

    public final void zzr(MediaSessionCompat mediaSessionCompat) {
        this.zzb.setMediaSessionCompat(mediaSessionCompat);
    }

    public final boolean zzs() {
        return this.zzf;
    }
}
