package com.google.android.gms.common.api.internal;

import android.os.Bundle;
import android.util.Log;
import com.google.android.gms.common.ConnectionResult;
import com.google.android.gms.common.internal.Preconditions;

/* compiled from: com.google.android.gms:play-services-base@@18.0.1 */
/* loaded from: classes.dex */
final class zaaa implements zaca {

    /* renamed from: a, reason: collision with root package name */
    public Bundle f7130a;

    /* renamed from: b, reason: collision with root package name */
    public ConnectionResult f7131b;

    /* renamed from: c, reason: collision with root package name */
    public ConnectionResult f7132c;

    /* renamed from: d, reason: collision with root package name */
    public boolean f7133d;

    /* renamed from: e, reason: collision with root package name */
    public int f7134e;

    public static void c(zaaa zaaaVar) {
        ConnectionResult connectionResult = zaaaVar.f7131b;
        boolean z10 = connectionResult != null && connectionResult.isSuccess();
        zaaaVar.getClass();
        if (!z10) {
            ConnectionResult connectionResult2 = zaaaVar.f7131b;
            zaaaVar.getClass();
            if (connectionResult2 != null) {
                ConnectionResult connectionResult3 = zaaaVar.f7132c;
                if (connectionResult3 != null && connectionResult3.isSuccess()) {
                    throw null;
                }
            }
            if (zaaaVar.f7131b != null && zaaaVar.f7132c != null) {
                throw null;
            }
            return;
        }
        ConnectionResult connectionResult4 = zaaaVar.f7132c;
        if (!(connectionResult4 != null && connectionResult4.isSuccess())) {
            ConnectionResult connectionResult5 = zaaaVar.f7132c;
            if (!(connectionResult5 != null && connectionResult5.getErrorCode() == 4)) {
                ConnectionResult connectionResult6 = zaaaVar.f7132c;
                if (connectionResult6 != null) {
                    if (zaaaVar.f7134e == 1) {
                        zaaaVar.b();
                        return;
                    } else {
                        zaaaVar.a(connectionResult6);
                        throw null;
                    }
                }
                return;
            }
        }
        int i10 = zaaaVar.f7134e;
        if (i10 == 1) {
            zaaaVar.b();
        } else if (i10 != 2) {
            Log.wtf("CompositeGAC", "Attempted to call success callbacks in CONNECTION_MODE_NONE. Callbacks should be disabled via GmsClientSupervisor", new AssertionError());
        } else {
            zaaaVar.getClass();
            ((zabe) Preconditions.checkNotNull(null)).zab(zaaaVar.f7130a);
            zaaaVar.b();
        }
        zaaaVar.f7134e = 0;
    }

    public final void a(ConnectionResult connectionResult) {
        int i10 = this.f7134e;
        if (i10 == 1) {
            b();
        } else {
            if (i10 == 2) {
                throw null;
            }
            Log.wtf("CompositeGAC", "Attempted to call failure callbacks in CONNECTION_MODE_NONE. Callbacks should be disabled via GmsClientSupervisor", new Exception());
        }
        this.f7134e = 0;
    }

    public final void b() {
        throw null;
    }
}
