package com.google.android.gms.measurement.internal;

import android.content.ComponentName;
import android.content.Context;
import android.content.Intent;
import android.content.ServiceConnection;
import android.os.Bundle;
import android.os.DeadObjectException;
import android.os.IBinder;
import android.os.IInterface;
import android.os.Looper;
import android.os.RemoteException;
import com.google.android.gms.common.ConnectionResult;
import com.google.android.gms.common.internal.BaseGmsClient;
import com.google.android.gms.common.internal.Preconditions;
import com.google.android.gms.common.stats.ConnectionTracker;

/* compiled from: com.google.android.gms:play-services-measurement-impl@@21.6.1 */
/* loaded from: classes.dex */
public final class zzlx implements ServiceConnection, BaseGmsClient.BaseConnectionCallbacks, BaseGmsClient.BaseOnConnectionFailedListener {

    /* renamed from: a, reason: collision with root package name */
    public volatile boolean f8462a;

    /* renamed from: b, reason: collision with root package name */
    public volatile zzfy f8463b;

    /* renamed from: c, reason: collision with root package name */
    public final /* synthetic */ zzla f8464c;

    public zzlx(zzla zzlaVar) {
        this.f8464c = zzlaVar;
    }

    @Override // com.google.android.gms.common.internal.BaseGmsClient.BaseConnectionCallbacks
    public final void onConnected(Bundle bundle) {
        Preconditions.checkMainThread("MeasurementServiceConnection.onConnected");
        synchronized (this) {
            try {
                Preconditions.checkNotNull(this.f8463b);
                this.f8464c.zzl().zzb(new zzly(this, this.f8463b.getService()));
            } catch (DeadObjectException | IllegalStateException unused) {
                this.f8463b = null;
                this.f8462a = false;
            }
        }
    }

    @Override // com.google.android.gms.common.internal.BaseGmsClient.BaseOnConnectionFailedListener
    public final void onConnectionFailed(ConnectionResult connectionResult) throws IllegalStateException {
        Preconditions.checkMainThread("MeasurementServiceConnection.onConnectionFailed");
        zzgb zzgbVarZzm = this.f8464c.f8189a.zzm();
        if (zzgbVarZzm != null) {
            zzgbVarZzm.zzu().zza("Service connection failed", connectionResult);
        }
        synchronized (this) {
            this.f8462a = false;
            this.f8463b = null;
        }
        this.f8464c.zzl().zzb(new zzma(this));
    }

    @Override // com.google.android.gms.common.internal.BaseGmsClient.BaseConnectionCallbacks
    public final void onConnectionSuspended(int i10) throws IllegalStateException {
        Preconditions.checkMainThread("MeasurementServiceConnection.onConnectionSuspended");
        zzla zzlaVar = this.f8464c;
        zzlaVar.zzj().zzc().zza("Service connection suspended");
        zzlaVar.zzl().zzb(new zzmb(this));
    }

    @Override // android.content.ServiceConnection
    public final void onServiceConnected(ComponentName componentName, IBinder iBinder) {
        Preconditions.checkMainThread("MeasurementServiceConnection.onServiceConnected");
        synchronized (this) {
            if (iBinder == null) {
                this.f8462a = false;
                this.f8464c.zzj().zzg().zza("Service connected with null binder");
                return;
            }
            zzfq zzfsVar = null;
            try {
                String interfaceDescriptor = iBinder.getInterfaceDescriptor();
                if ("com.google.android.gms.measurement.internal.IMeasurementService".equals(interfaceDescriptor)) {
                    IInterface iInterfaceQueryLocalInterface = iBinder.queryLocalInterface("com.google.android.gms.measurement.internal.IMeasurementService");
                    zzfsVar = iInterfaceQueryLocalInterface instanceof zzfq ? (zzfq) iInterfaceQueryLocalInterface : new zzfs(iBinder);
                    this.f8464c.zzj().zzp().zza("Bound to IMeasurementService interface");
                } else {
                    this.f8464c.zzj().zzg().zza("Got binder with a wrong descriptor", interfaceDescriptor);
                }
            } catch (RemoteException unused) {
                this.f8464c.zzj().zzg().zza("Service connect failed to get IMeasurementService");
            }
            if (zzfsVar == null) {
                this.f8462a = false;
                try {
                    ConnectionTracker.getInstance().unbindService(this.f8464c.zza(), this.f8464c.f8385c);
                } catch (IllegalArgumentException unused2) {
                }
            } else {
                this.f8464c.zzl().zzb(new zzlw(this, zzfsVar));
            }
        }
    }

    @Override // android.content.ServiceConnection
    public final void onServiceDisconnected(ComponentName componentName) throws IllegalStateException {
        Preconditions.checkMainThread("MeasurementServiceConnection.onServiceDisconnected");
        zzla zzlaVar = this.f8464c;
        zzlaVar.zzj().zzc().zza("Service disconnected");
        zzlaVar.zzl().zzb(new zzlz(this, componentName));
    }

    public final void zza(Intent intent) {
        this.f8464c.zzt();
        Context contextZza = this.f8464c.zza();
        ConnectionTracker connectionTracker = ConnectionTracker.getInstance();
        synchronized (this) {
            if (this.f8462a) {
                this.f8464c.zzj().zzp().zza("Connection attempt already in progress");
                return;
            }
            this.f8464c.zzj().zzp().zza("Using local app measurement service");
            this.f8462a = true;
            connectionTracker.bindService(contextZza, intent, this.f8464c.f8385c, 129);
        }
    }

    public final void zzb() {
        if (this.f8463b != null && (this.f8463b.isConnected() || this.f8463b.isConnecting())) {
            this.f8463b.disconnect();
        }
        this.f8463b = null;
    }

    public final void zza() {
        this.f8464c.zzt();
        Context contextZza = this.f8464c.zza();
        synchronized (this) {
            if (this.f8462a) {
                this.f8464c.zzj().zzp().zza("Connection attempt already in progress");
                return;
            }
            if (this.f8463b != null && (this.f8463b.isConnecting() || this.f8463b.isConnected())) {
                this.f8464c.zzj().zzp().zza("Already awaiting connection attempt");
                return;
            }
            this.f8463b = new zzfy(contextZza, Looper.getMainLooper(), this, this);
            this.f8464c.zzj().zzp().zza("Connecting to remote service");
            this.f8462a = true;
            Preconditions.checkNotNull(this.f8463b);
            this.f8463b.checkAvailabilityAndConnect();
        }
    }
}
