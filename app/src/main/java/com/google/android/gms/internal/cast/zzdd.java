package com.google.android.gms.internal.cast;

import android.annotation.TargetApi;
import android.content.Context;
import android.net.ConnectivityManager;
import android.net.LinkProperties;
import android.net.Network;
import android.net.NetworkRequest;
import com.google.android.gms.cast.internal.Logger;
import com.google.android.gms.common.internal.Preconditions;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;

/* compiled from: com.google.android.gms:play-services-cast@@21.4.0 */
/* loaded from: classes.dex */
public final class zzdd implements zzda {
    private static final Logger zzb = new Logger("ConnectivityMonitor");
    private final zzrx zzc;
    private final ConnectivityManager zze;
    private boolean zzh;
    private final Context zzi;
    private final Object zzj = new Object();
    public final Set zza = Collections.synchronizedSet(new HashSet());
    private final Map zzf = Collections.synchronizedMap(new HashMap());
    private final List zzg = Collections.synchronizedList(new ArrayList());
    private final ConnectivityManager.NetworkCallback zzd = new zzdc(this);

    @TargetApi(23)
    public zzdd(Context context, zzrx zzrxVar) {
        this.zzc = zzrxVar;
        this.zzi = context;
        this.zze = (ConnectivityManager) context.getSystemService("connectivity");
    }

    public static /* bridge */ /* synthetic */ void zzc(zzdd zzddVar) {
        synchronized (Preconditions.checkNotNull(zzddVar.zzj)) {
            if (zzddVar.zzf != null && zzddVar.zzg != null) {
                zzb.d("all networks are unavailable.", new Object[0]);
                zzddVar.zzf.clear();
                zzddVar.zzg.clear();
                zzddVar.zzg();
            }
        }
    }

    public static /* bridge */ /* synthetic */ void zzd(zzdd zzddVar, Network network) {
        synchronized (Preconditions.checkNotNull(zzddVar.zzj)) {
            if (zzddVar.zzf != null && zzddVar.zzg != null) {
                zzb.d("the network is lost", new Object[0]);
                if (zzddVar.zzg.remove(network)) {
                    zzddVar.zzf.remove(network);
                }
                zzddVar.zzg();
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void zzf(Network network, LinkProperties linkProperties) {
        synchronized (Preconditions.checkNotNull(this.zzj)) {
            if (this.zzf != null && this.zzg != null) {
                zzb.d("a new network is available", new Object[0]);
                if (this.zzf.containsKey(network)) {
                    this.zzg.remove(network);
                }
                this.zzf.put(network, linkProperties);
                this.zzg.add(network);
                zzg();
            }
        }
    }

    private final void zzg() {
        if (this.zzc == null) {
            return;
        }
        synchronized (this.zza) {
            for (final zzcz zzczVar : this.zza) {
                if (!this.zzc.isShutdown()) {
                    this.zzc.execute(new Runnable() { // from class: com.google.android.gms.internal.cast.zzdb
                        @Override // java.lang.Runnable
                        public final void run() {
                            this.zza.zze();
                            zzczVar.zza();
                        }
                    });
                }
            }
        }
    }

    @Override // com.google.android.gms.internal.cast.zzda
    @TargetApi(23)
    public final void zza() {
        LinkProperties linkProperties;
        zzb.d("Start monitoring connectivity changes", new Object[0]);
        if (this.zzh || this.zze == null || m0.a.checkSelfPermission(this.zzi, "android.permission.ACCESS_NETWORK_STATE") != 0) {
            return;
        }
        Network activeNetwork = this.zze.getActiveNetwork();
        if (activeNetwork != null && (linkProperties = this.zze.getLinkProperties(activeNetwork)) != null) {
            zzf(activeNetwork, linkProperties);
        }
        this.zze.registerNetworkCallback(new NetworkRequest.Builder().addTransportType(1).build(), this.zzd);
        this.zzh = true;
    }

    public final boolean zze() {
        List list = this.zzg;
        return (list == null || list.isEmpty()) ? false : true;
    }
}
