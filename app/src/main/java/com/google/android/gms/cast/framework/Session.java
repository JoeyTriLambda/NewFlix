package com.google.android.gms.cast.framework;

import android.content.Context;
import android.os.Bundle;
import android.os.RemoteException;
import com.google.android.gms.cast.internal.Logger;
import com.google.android.gms.common.internal.Preconditions;
import com.google.android.gms.dynamic.IObjectWrapper;

/* compiled from: com.google.android.gms:play-services-cast-framework@@21.4.0 */
/* loaded from: classes.dex */
public abstract class Session {

    /* renamed from: b, reason: collision with root package name */
    public static final Logger f6391b = new Logger("Session");

    /* renamed from: a, reason: collision with root package name */
    public final zzaw f6392a;

    public Session(Context context, String str, String str2) {
        this.f6392a = com.google.android.gms.internal.cast.zzag.zzd(context, str, str2, new zzbi(this));
    }

    public abstract void end(boolean z10);

    public long getSessionRemainingTimeMs() {
        Preconditions.checkMainThread("Must be called from the main thread.");
        return 0L;
    }

    public boolean isConnected() {
        Preconditions.checkMainThread("Must be called from the main thread.");
        zzaw zzawVar = this.f6392a;
        if (zzawVar != null) {
            try {
                return zzawVar.zzp();
            } catch (RemoteException e10) {
                f6391b.d(e10, "Unable to call %s on %s.", "isConnected", "zzaw");
            }
        }
        return false;
    }

    public boolean isConnecting() {
        Preconditions.checkMainThread("Must be called from the main thread.");
        zzaw zzawVar = this.f6392a;
        if (zzawVar != null) {
            try {
                return zzawVar.zzq();
            } catch (RemoteException e10) {
                f6391b.d(e10, "Unable to call %s on %s.", "isConnecting", "zzaw");
            }
        }
        return false;
    }

    public boolean isResuming() {
        Preconditions.checkMainThread("Must be called from the main thread.");
        zzaw zzawVar = this.f6392a;
        if (zzawVar != null) {
            try {
                return zzawVar.zzt();
            } catch (RemoteException e10) {
                f6391b.d(e10, "Unable to call %s on %s.", "isResuming", "zzaw");
            }
        }
        return false;
    }

    public final void notifyFailedToResumeSession(int i10) {
        zzaw zzawVar = this.f6392a;
        if (zzawVar == null) {
            return;
        }
        try {
            zzawVar.zzj(i10);
        } catch (RemoteException e10) {
            f6391b.d(e10, "Unable to call %s on %s.", "notifyFailedToResumeSession", "zzaw");
        }
    }

    public final void notifyFailedToStartSession(int i10) {
        zzaw zzawVar = this.f6392a;
        if (zzawVar == null) {
            return;
        }
        try {
            zzawVar.zzk(i10);
        } catch (RemoteException e10) {
            f6391b.d(e10, "Unable to call %s on %s.", "notifyFailedToStartSession", "zzaw");
        }
    }

    public final void notifySessionEnded(int i10) {
        zzaw zzawVar = this.f6392a;
        if (zzawVar == null) {
            return;
        }
        try {
            zzawVar.zzl(i10);
        } catch (RemoteException e10) {
            f6391b.d(e10, "Unable to call %s on %s.", "notifySessionEnded", "zzaw");
        }
    }

    public abstract void resume(Bundle bundle);

    public abstract void start(Bundle bundle);

    public final int zzm() {
        Preconditions.checkMainThread("Must be called from the main thread.");
        zzaw zzawVar = this.f6392a;
        if (zzawVar != null) {
            try {
                if (zzawVar.zze() >= 211100000) {
                    return zzawVar.zzf();
                }
            } catch (RemoteException e10) {
                f6391b.d(e10, "Unable to call %s on %s.", "getSessionStartType", "zzaw");
            }
        }
        return 0;
    }

    public final IObjectWrapper zzn() {
        zzaw zzawVar = this.f6392a;
        if (zzawVar != null) {
            try {
                return zzawVar.zzg();
            } catch (RemoteException e10) {
                f6391b.d(e10, "Unable to call %s on %s.", "getWrappedObject", "zzaw");
            }
        }
        return null;
    }

    public void onResuming(Bundle bundle) {
    }

    public void onStarting(Bundle bundle) {
    }

    public void zzk(Bundle bundle) {
    }
}
