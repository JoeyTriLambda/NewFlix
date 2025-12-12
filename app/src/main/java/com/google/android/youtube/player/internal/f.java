package com.google.android.youtube.player.internal;

import android.os.Binder;
import android.os.IBinder;
import android.os.IInterface;
import android.os.Parcel;
import android.os.RemoteException;

/* loaded from: classes.dex */
public interface f extends IInterface {

    public static abstract class a extends Binder implements f {

        /* renamed from: com.google.android.youtube.player.internal.f$a$a, reason: collision with other inner class name */
        public static class C0096a implements f {

            /* renamed from: a, reason: collision with root package name */
            public final IBinder f9570a;

            public C0096a(IBinder iBinder) {
                this.f9570a = iBinder;
            }

            @Override // com.google.android.youtube.player.internal.f
            public final IBinder a() throws RemoteException {
                Parcel parcelObtain = Parcel.obtain();
                Parcel parcelObtain2 = Parcel.obtain();
                try {
                    parcelObtain.writeInterfaceToken("com.google.android.youtube.player.internal.IYouTubeService");
                    this.f9570a.transact(1, parcelObtain, parcelObtain2, 0);
                    parcelObtain2.readException();
                    return parcelObtain2.readStrongBinder();
                } finally {
                    parcelObtain2.recycle();
                    parcelObtain.recycle();
                }
            }

            @Override // android.os.IInterface
            public final IBinder asBinder() {
                return this.f9570a;
            }

            @Override // com.google.android.youtube.player.internal.f
            public final void a(boolean z10) throws RemoteException {
                Parcel parcelObtain = Parcel.obtain();
                Parcel parcelObtain2 = Parcel.obtain();
                try {
                    parcelObtain.writeInterfaceToken("com.google.android.youtube.player.internal.IYouTubeService");
                    parcelObtain.writeInt(z10 ? 1 : 0);
                    this.f9570a.transact(3, parcelObtain, parcelObtain2, 0);
                    parcelObtain2.readException();
                } finally {
                    parcelObtain2.recycle();
                    parcelObtain.recycle();
                }
            }
        }

        public static f a(IBinder iBinder) {
            if (iBinder == null) {
                return null;
            }
            IInterface iInterfaceQueryLocalInterface = iBinder.queryLocalInterface("com.google.android.youtube.player.internal.IYouTubeService");
            return (iInterfaceQueryLocalInterface == null || !(iInterfaceQueryLocalInterface instanceof f)) ? new C0096a(iBinder) : (f) iInterfaceQueryLocalInterface;
        }
    }

    IBinder a() throws RemoteException;

    void a(boolean z10) throws RemoteException;
}
