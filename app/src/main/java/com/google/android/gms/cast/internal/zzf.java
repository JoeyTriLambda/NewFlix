package com.google.android.gms.cast.internal;

import android.os.RemoteException;
import com.google.android.gms.common.api.internal.RemoteCall;
import com.google.android.gms.tasks.TaskCompletionSource;

/* compiled from: com.google.android.gms:play-services-cast@@21.4.0 */
/* loaded from: classes.dex */
public final /* synthetic */ class zzf implements RemoteCall {
    /* JADX WARN: Multi-variable type inference failed */
    @Override // com.google.android.gms.common.api.internal.RemoteCall
    public final void accept(Object obj, Object obj2) throws RemoteException {
        ((zzaj) ((zzo) obj).getService()).zze(new zzj((TaskCompletionSource) obj2), null, null, null);
    }
}
