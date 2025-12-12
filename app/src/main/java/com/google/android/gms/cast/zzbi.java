package com.google.android.gms.cast;

import android.os.RemoteException;
import com.google.android.gms.cast.internal.Logger;
import com.google.android.gms.common.api.internal.RemoteCall;
import com.google.android.gms.tasks.TaskCompletionSource;

/* compiled from: com.google.android.gms:play-services-cast@@21.4.0 */
/* loaded from: classes.dex */
public final /* synthetic */ class zzbi implements RemoteCall {
    static {
        new zzbi();
    }

    private /* synthetic */ zzbi() {
    }

    /* JADX WARN: Multi-variable type inference failed */
    @Override // com.google.android.gms.common.api.internal.RemoteCall
    public final void accept(Object obj, Object obj2) throws RemoteException {
        Logger logger = zzbt.F;
        ((com.google.android.gms.cast.internal.zzag) ((com.google.android.gms.cast.internal.zzx) obj).getService()).zzl();
        ((TaskCompletionSource) obj2).setResult(null);
    }
}
