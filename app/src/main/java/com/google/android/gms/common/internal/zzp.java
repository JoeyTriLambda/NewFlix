package com.google.android.gms.common.internal;

import android.content.ComponentName;
import android.content.Context;
import android.content.ServiceConnection;
import android.os.IBinder;
import android.os.StrictMode;
import com.google.android.gms.common.stats.ConnectionTracker;
import com.google.android.gms.common.util.PlatformVersion;
import java.util.HashMap;
import java.util.Iterator;
import java.util.concurrent.Executor;

/* compiled from: com.google.android.gms:play-services-basement@@18.3.0 */
/* loaded from: classes.dex */
final class zzp implements ServiceConnection, zzt {

    /* renamed from: a, reason: collision with root package name */
    public final HashMap f7426a = new HashMap();

    /* renamed from: b, reason: collision with root package name */
    public int f7427b = 2;

    /* renamed from: c, reason: collision with root package name */
    public boolean f7428c;

    /* renamed from: d, reason: collision with root package name */
    public IBinder f7429d;

    /* renamed from: e, reason: collision with root package name */
    public final zzo f7430e;

    /* renamed from: f, reason: collision with root package name */
    public ComponentName f7431f;

    /* renamed from: g, reason: collision with root package name */
    public final /* synthetic */ zzs f7432g;

    public zzp(zzs zzsVar, zzo zzoVar) {
        this.f7432g = zzsVar;
        this.f7430e = zzoVar;
    }

    @Override // android.content.ServiceConnection
    public final void onBindingDied(ComponentName componentName) {
        onServiceDisconnected(componentName);
    }

    @Override // android.content.ServiceConnection
    public final void onServiceConnected(ComponentName componentName, IBinder iBinder) {
        synchronized (this.f7432g.f7434d) {
            this.f7432g.f7436f.removeMessages(1, this.f7430e);
            this.f7429d = iBinder;
            this.f7431f = componentName;
            Iterator it = this.f7426a.values().iterator();
            while (it.hasNext()) {
                ((ServiceConnection) it.next()).onServiceConnected(componentName, iBinder);
            }
            this.f7427b = 1;
        }
    }

    @Override // android.content.ServiceConnection
    public final void onServiceDisconnected(ComponentName componentName) {
        synchronized (this.f7432g.f7434d) {
            this.f7432g.f7436f.removeMessages(1, this.f7430e);
            this.f7429d = null;
            this.f7431f = componentName;
            Iterator it = this.f7426a.values().iterator();
            while (it.hasNext()) {
                ((ServiceConnection) it.next()).onServiceDisconnected(componentName);
            }
            this.f7427b = 2;
        }
    }

    public final int zza() {
        return this.f7427b;
    }

    public final ComponentName zzb() {
        return this.f7431f;
    }

    public final IBinder zzc() {
        return this.f7429d;
    }

    public final void zzd(ServiceConnection serviceConnection, ServiceConnection serviceConnection2, String str) {
        this.f7426a.put(serviceConnection, serviceConnection2);
    }

    public final void zze(String str, Executor executor) {
        this.f7427b = 3;
        StrictMode.VmPolicy vmPolicy = StrictMode.getVmPolicy();
        if (PlatformVersion.isAtLeastS()) {
            StrictMode.setVmPolicy(new StrictMode.VmPolicy.Builder(vmPolicy).permitUnsafeIntentLaunch().build());
        }
        try {
            zzs zzsVar = this.f7432g;
            ConnectionTracker connectionTracker = zzsVar.f7437g;
            Context context = zzsVar.f7435e;
            boolean zZza = connectionTracker.zza(context, str, this.f7430e.zzb(context), this, 4225, executor);
            this.f7428c = zZza;
            if (zZza) {
                this.f7432g.f7436f.sendMessageDelayed(this.f7432g.f7436f.obtainMessage(1, this.f7430e), this.f7432g.f7439i);
            } else {
                this.f7427b = 2;
                try {
                    zzs zzsVar2 = this.f7432g;
                    zzsVar2.f7437g.unbindService(zzsVar2.f7435e, this);
                } catch (IllegalArgumentException unused) {
                }
            }
        } finally {
            StrictMode.setVmPolicy(vmPolicy);
        }
    }

    public final void zzf(ServiceConnection serviceConnection, String str) {
        this.f7426a.remove(serviceConnection);
    }

    public final void zzg(String str) {
        this.f7432g.f7436f.removeMessages(1, this.f7430e);
        zzs zzsVar = this.f7432g;
        zzsVar.f7437g.unbindService(zzsVar.f7435e, this);
        this.f7428c = false;
        this.f7427b = 2;
    }

    public final boolean zzh(ServiceConnection serviceConnection) {
        return this.f7426a.containsKey(serviceConnection);
    }

    public final boolean zzi() {
        return this.f7426a.isEmpty();
    }

    public final boolean zzj() {
        return this.f7428c;
    }
}
