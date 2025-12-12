package com.google.android.youtube.player.internal;

import android.os.Binder;
import android.os.IBinder;
import android.os.IInterface;
import android.os.Parcel;
import android.os.RemoteException;

/* loaded from: classes.dex */
public interface j extends IInterface {

    public static abstract class a extends Binder implements j {

        /* renamed from: com.google.android.youtube.player.internal.j$a$a, reason: collision with other inner class name */
        public static class C0097a implements j {

            /* renamed from: a, reason: collision with root package name */
            public final IBinder f9593a;

            public C0097a(IBinder iBinder) {
                this.f9593a = iBinder;
            }

            @Override // android.os.IInterface
            public final IBinder asBinder() {
                return this.f9593a;
            }
        }

        public a() {
            attachInterface(this, "com.google.android.youtube.player.internal.dynamic.IObjectWrapper");
        }

        public static j a(IBinder iBinder) {
            if (iBinder == null) {
                return null;
            }
            IInterface iInterfaceQueryLocalInterface = iBinder.queryLocalInterface("com.google.android.youtube.player.internal.dynamic.IObjectWrapper");
            return (iInterfaceQueryLocalInterface == null || !(iInterfaceQueryLocalInterface instanceof j)) ? new C0097a(iBinder) : (j) iInterfaceQueryLocalInterface;
        }

        @Override // android.os.Binder
        public boolean onTransact(int i10, Parcel parcel, Parcel parcel2, int i11) throws RemoteException {
            if (i10 != 1598968902) {
                return super.onTransact(i10, parcel, parcel2, i11);
            }
            parcel2.writeString("com.google.android.youtube.player.internal.dynamic.IObjectWrapper");
            return true;
        }

        @Override // android.os.IInterface
        public IBinder asBinder() {
            return this;
        }
    }
}
