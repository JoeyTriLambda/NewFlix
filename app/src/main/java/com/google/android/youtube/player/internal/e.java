package com.google.android.youtube.player.internal;

import android.os.Binder;
import android.os.Bundle;
import android.os.IBinder;
import android.os.IInterface;
import android.os.Parcel;
import android.os.RemoteException;

/* loaded from: classes.dex */
public interface e extends IInterface {

    public static abstract class a extends Binder implements e {

        /* renamed from: com.google.android.youtube.player.internal.e$a$a, reason: collision with other inner class name */
        public static class C0095a implements e {

            /* renamed from: a, reason: collision with root package name */
            public final IBinder f9569a;

            public C0095a(IBinder iBinder) {
                this.f9569a = iBinder;
            }

            @Override // com.google.android.youtube.player.internal.e
            public final void a(c cVar, int i10, String str, String str2, String str3, Bundle bundle) throws RemoteException {
                Parcel parcelObtain = Parcel.obtain();
                Parcel parcelObtain2 = Parcel.obtain();
                try {
                    parcelObtain.writeInterfaceToken("com.google.android.youtube.player.internal.IServiceBroker");
                    parcelObtain.writeStrongBinder(cVar != null ? cVar.asBinder() : null);
                    parcelObtain.writeInt(i10);
                    parcelObtain.writeString(str);
                    parcelObtain.writeString(str2);
                    parcelObtain.writeString(str3);
                    if (bundle != null) {
                        parcelObtain.writeInt(1);
                        bundle.writeToParcel(parcelObtain, 0);
                    } else {
                        parcelObtain.writeInt(0);
                    }
                    this.f9569a.transact(1, parcelObtain, parcelObtain2, 0);
                    parcelObtain2.readException();
                } finally {
                    parcelObtain2.recycle();
                    parcelObtain.recycle();
                }
            }

            @Override // android.os.IInterface
            public final IBinder asBinder() {
                return this.f9569a;
            }
        }

        public static e a(IBinder iBinder) {
            if (iBinder == null) {
                return null;
            }
            IInterface iInterfaceQueryLocalInterface = iBinder.queryLocalInterface("com.google.android.youtube.player.internal.IServiceBroker");
            return (iInterfaceQueryLocalInterface == null || !(iInterfaceQueryLocalInterface instanceof e)) ? new C0095a(iBinder) : (e) iInterfaceQueryLocalInterface;
        }
    }

    void a(c cVar, int i10, String str, String str2, String str3, Bundle bundle) throws RemoteException;
}
