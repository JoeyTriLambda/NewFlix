package com.google.android.gms.internal.cast;

import a2.m;
import a2.n;
import android.content.Context;
import android.os.Looper;
import com.google.android.gms.cast.CastMediaControlIntent;
import com.google.android.gms.cast.internal.Logger;
import java.util.Collections;
import java.util.HashMap;
import java.util.Iterator;
import java.util.LinkedHashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;

/* compiled from: com.google.android.gms:play-services-cast-framework@@21.4.0 */
/* loaded from: classes.dex */
public final class zzay extends n.a {
    private static final Logger zzb = new Logger("MRDiscoveryCallback");
    private final zzbg zzf;
    private final Map zzd = Collections.synchronizedMap(new HashMap());
    private final LinkedHashSet zze = new LinkedHashSet();
    private final Set zzc = Collections.synchronizedSet(new LinkedHashSet());
    public final zzax zza = new zzax(this);

    public zzay(Context context) {
        this.zzf = new zzbg(context);
    }

    @Override // a2.n.a
    public final void onRouteAdded(n nVar, n.g gVar) {
        zzb.d("MediaRouterDiscoveryCallback.onRouteAdded.", new Object[0]);
        zzf(gVar, true);
    }

    @Override // a2.n.a
    public final void onRouteChanged(n nVar, n.g gVar) {
        zzb.d("MediaRouterDiscoveryCallback.onRouteChanged.", new Object[0]);
        zzf(gVar, true);
    }

    @Override // a2.n.a
    public final void onRouteRemoved(n nVar, n.g gVar) {
        zzb.d("MediaRouterDiscoveryCallback.onRouteRemoved.", new Object[0]);
        zzf(gVar, false);
    }

    public final void zza(List list) {
        zzb.d(o1.a.d("SetRouteDiscovery for ", list.size(), " IDs"), new Object[0]);
        LinkedHashSet<String> linkedHashSet = new LinkedHashSet();
        Iterator it = list.iterator();
        while (it.hasNext()) {
            linkedHashSet.add(zzes.zza((String) it.next()));
        }
        Map map = this.zzd;
        zzb.d("resetting routes. appIdToRouteInfo has these appId route keys: ".concat(String.valueOf(map.keySet())), new Object[0]);
        HashMap map2 = new HashMap();
        synchronized (this.zzd) {
            for (String str : linkedHashSet) {
                zzaw zzawVar = (zzaw) this.zzd.get(zzes.zza(str));
                if (zzawVar != null) {
                    map2.put(str, zzawVar);
                }
            }
            this.zzd.clear();
            this.zzd.putAll(map2);
        }
        Map map3 = this.zzd;
        zzb.d("Routes reset. appIdToRouteInfo has these appId route keys: ".concat(String.valueOf(map3.keySet())), new Object[0]);
        synchronized (this.zze) {
            this.zze.clear();
            this.zze.addAll(linkedHashSet);
        }
        zzb();
    }

    public final void zzb() {
        LinkedHashSet linkedHashSet = this.zze;
        Logger logger = zzb;
        logger.d(o1.a.d("Starting RouteDiscovery with ", linkedHashSet.size(), " IDs"), new Object[0]);
        logger.d("appIdToRouteInfo has these appId route keys: ".concat(String.valueOf(this.zzd.keySet())), new Object[0]);
        if (Looper.myLooper() == Looper.getMainLooper()) {
            zzc();
        } else {
            new zzed(Looper.getMainLooper()).post(new Runnable() { // from class: com.google.android.gms.internal.cast.zzav
                @Override // java.lang.Runnable
                public final void run() {
                    this.zza.zzc();
                }
            });
        }
    }

    public final void zzc() {
        this.zzf.zzb(this);
        synchronized (this.zze) {
            Iterator it = this.zze.iterator();
            while (it.hasNext()) {
                String str = (String) it.next();
                m mVarBuild = new m.a().addControlCategory(CastMediaControlIntent.categoryForCast(str)).build();
                if (((zzaw) this.zzd.get(str)) == null) {
                    this.zzd.put(str, new zzaw(mVarBuild));
                }
                zzb.d("Adding mediaRouter callback for control category " + CastMediaControlIntent.categoryForCast(str), new Object[0]);
                this.zzf.zza().addCallback(mVarBuild, this, 4);
            }
        }
        zzb.d("appIdToRouteInfo has these appId route keys: ".concat(String.valueOf(this.zzd.keySet())), new Object[0]);
    }

    public final void zzd() {
        zzb.d("Stopping RouteDiscovery.", new Object[0]);
        this.zzd.clear();
        if (Looper.myLooper() == Looper.getMainLooper()) {
            this.zzf.zzb(this);
        } else {
            new zzed(Looper.getMainLooper()).post(new Runnable() { // from class: com.google.android.gms.internal.cast.zzau
                @Override // java.lang.Runnable
                public final void run() {
                    this.zza.zze();
                }
            });
        }
    }

    public final void zze() {
        this.zzf.zzb(this);
    }

    public final void zzf(n.g gVar, boolean z10) {
        boolean z11;
        boolean zRemove;
        Logger logger = zzb;
        logger.d("MediaRouterDiscoveryCallback.updateRouteToAppIds (add=%b) route %s", Boolean.valueOf(z10), gVar);
        synchronized (this.zzd) {
            logger.d("appIdToRouteInfo has these appId route keys: ".concat(String.valueOf(this.zzd.keySet())), new Object[0]);
            z11 = false;
            for (Map.Entry entry : this.zzd.entrySet()) {
                String str = (String) entry.getKey();
                zzaw zzawVar = (zzaw) entry.getValue();
                if (gVar.matchesSelector(zzawVar.zzb)) {
                    if (z10) {
                        Logger logger2 = zzb;
                        logger2.d("Adding/updating route for appId " + str, new Object[0]);
                        zRemove = zzawVar.zza.add(gVar);
                        if (!zRemove) {
                            logger2.w("Route " + String.valueOf(gVar) + " already exists for appId " + str, new Object[0]);
                        }
                    } else {
                        Logger logger3 = zzb;
                        logger3.d("Removing route for appId " + str, new Object[0]);
                        zRemove = zzawVar.zza.remove(gVar);
                        if (!zRemove) {
                            logger3.w("Route " + String.valueOf(gVar) + " already removed from appId " + str, new Object[0]);
                        }
                    }
                    z11 = zRemove;
                }
            }
        }
        if (z11) {
            zzb.d("Invoking callback.onRouteUpdated.", new Object[0]);
            synchronized (this.zzc) {
                HashMap map = new HashMap();
                synchronized (this.zzd) {
                    for (String str2 : this.zzd.keySet()) {
                        zzaw zzawVar2 = (zzaw) this.zzd.get(zzes.zza(str2));
                        zzfu zzfuVarZzk = zzawVar2 == null ? zzfu.zzk() : zzfu.zzj(zzawVar2.zza);
                        if (!zzfuVarZzk.isEmpty()) {
                            map.put(str2, zzfuVarZzk);
                        }
                    }
                }
                zzft.zzc(map.entrySet());
                Iterator it = this.zzc.iterator();
                while (it.hasNext()) {
                    ((com.google.android.gms.cast.framework.zzbg) it.next()).zza();
                }
            }
        }
    }
}
