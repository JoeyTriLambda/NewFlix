package com.google.android.gms.common.internal;

import android.os.IInterface;
import android.os.Parcel;
import android.os.RemoteException;

/* compiled from: com.google.android.gms:play-services-basement@@18.3.0 */
/* loaded from: classes.dex */
public interface ICancelToken extends IInterface {

    /* compiled from: com.google.android.gms:play-services-basement@@18.3.0 */
    public static abstract class Stub extends com.google.android.gms.internal.common.zzb implements ICancelToken {
        public Stub() {
            super("com.google.android.gms.common.internal.ICancelToken");
        }

        @Override // com.google.android.gms.internal.common.zzb
        public final boolean zza(int i10, Parcel parcel, Parcel parcel2, int i11) throws RemoteException {
            if (i10 != 2) {
                return false;
            }
            cancel();
            return true;
        }
    }

    void cancel() throws RemoteException;
}
