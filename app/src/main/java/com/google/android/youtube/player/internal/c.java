package com.google.android.youtube.player.internal;

import android.os.Binder;
import android.os.IBinder;
import android.os.IInterface;
import android.os.Parcel;
import android.os.RemoteException;
import com.google.android.youtube.player.internal.h;

/* loaded from: classes.dex */
public interface c extends IInterface {

    public static abstract class a extends Binder implements c {
        public a() {
            attachInterface(this, "com.google.android.youtube.player.internal.IConnectionCallbacks");
        }

        @Override // android.os.Binder
        public boolean onTransact(int i10, Parcel parcel, Parcel parcel2, int i11) throws RemoteException {
            if (i10 != 1) {
                if (i10 != 1598968902) {
                    return super.onTransact(i10, parcel, parcel2, i11);
                }
                parcel2.writeString("com.google.android.youtube.player.internal.IConnectionCallbacks");
                return true;
            }
            parcel.enforceInterface("com.google.android.youtube.player.internal.IConnectionCallbacks");
            ((h.e) this).a(parcel.readString(), parcel.readStrongBinder());
            parcel2.writeNoException();
            return true;
        }

        @Override // android.os.IInterface
        public IBinder asBinder() {
            return this;
        }
    }
}
