package com.google.android.gms.common.api.internal;

import android.os.RemoteException;
import com.google.android.gms.common.annotation.KeepForSdk;

/* compiled from: com.google.android.gms:play-services-base@@18.0.1 */
@KeepForSdk
/* loaded from: classes.dex */
public interface RemoteCall<T, U> {
    @KeepForSdk
    void accept(T t10, U u10) throws RemoteException;
}
