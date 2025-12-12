package com.google.android.gms.cast.framework;

import android.os.RemoteException;
import com.google.android.gms.cast.internal.Logger;
import com.google.android.gms.common.internal.ShowFirstParty;
import com.google.android.gms.dynamic.IObjectWrapper;

/* compiled from: com.google.android.gms:play-services-cast-framework@@21.4.0 */
@ShowFirstParty
/* loaded from: classes.dex */
public final class zzac {

    /* renamed from: b, reason: collision with root package name */
    public static final Logger f6784b = new Logger("DiscoveryManager");

    /* renamed from: a, reason: collision with root package name */
    public final zzaq f6785a;

    public zzac(zzaq zzaqVar) {
        this.f6785a = zzaqVar;
    }

    public final IObjectWrapper zza() {
        try {
            return this.f6785a.zze();
        } catch (RemoteException e10) {
            f6784b.d(e10, "Unable to call %s on %s.", "getWrappedThis", "zzaq");
            return null;
        }
    }
}
