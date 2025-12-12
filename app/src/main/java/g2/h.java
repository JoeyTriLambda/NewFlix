package g2;

import android.os.Binder;
import android.os.IBinder;
import android.os.IInterface;
import android.os.Parcel;
import android.os.RemoteException;
import g2.g;

/* compiled from: IMultiInstanceInvalidationService.java */
/* loaded from: classes.dex */
public interface h extends IInterface {
    void broadcastInvalidation(int i10, String[] strArr) throws RemoteException;

    int registerCallback(g gVar, String str) throws RemoteException;

    void unregisterCallback(g gVar, int i10) throws RemoteException;

    /* compiled from: IMultiInstanceInvalidationService.java */
    public static abstract class a extends Binder implements h {

        /* compiled from: IMultiInstanceInvalidationService.java */
        /* renamed from: g2.h$a$a, reason: collision with other inner class name */
        public static class C0151a implements h {

            /* renamed from: a, reason: collision with root package name */
            public final IBinder f12567a;

            public C0151a(IBinder iBinder) {
                this.f12567a = iBinder;
            }

            @Override // android.os.IInterface
            public IBinder asBinder() {
                return this.f12567a;
            }

            @Override // g2.h
            public void broadcastInvalidation(int i10, String[] strArr) throws RemoteException {
                Parcel parcelObtain = Parcel.obtain();
                try {
                    parcelObtain.writeInterfaceToken("androidx.room.IMultiInstanceInvalidationService");
                    parcelObtain.writeInt(i10);
                    parcelObtain.writeStringArray(strArr);
                    this.f12567a.transact(3, parcelObtain, null, 1);
                } finally {
                    parcelObtain.recycle();
                }
            }

            @Override // g2.h
            public int registerCallback(g gVar, String str) throws RemoteException {
                Parcel parcelObtain = Parcel.obtain();
                Parcel parcelObtain2 = Parcel.obtain();
                try {
                    parcelObtain.writeInterfaceToken("androidx.room.IMultiInstanceInvalidationService");
                    parcelObtain.writeStrongInterface(gVar);
                    parcelObtain.writeString(str);
                    this.f12567a.transact(1, parcelObtain, parcelObtain2, 0);
                    parcelObtain2.readException();
                    return parcelObtain2.readInt();
                } finally {
                    parcelObtain2.recycle();
                    parcelObtain.recycle();
                }
            }
        }

        public a() {
            attachInterface(this, "androidx.room.IMultiInstanceInvalidationService");
        }

        public static h asInterface(IBinder iBinder) {
            if (iBinder == null) {
                return null;
            }
            IInterface iInterfaceQueryLocalInterface = iBinder.queryLocalInterface("androidx.room.IMultiInstanceInvalidationService");
            return (iInterfaceQueryLocalInterface == null || !(iInterfaceQueryLocalInterface instanceof h)) ? new C0151a(iBinder) : (h) iInterfaceQueryLocalInterface;
        }

        @Override // android.os.Binder
        public boolean onTransact(int i10, Parcel parcel, Parcel parcel2, int i11) throws RemoteException {
            if (i10 >= 1 && i10 <= 16777215) {
                parcel.enforceInterface("androidx.room.IMultiInstanceInvalidationService");
            }
            if (i10 == 1598968902) {
                parcel2.writeString("androidx.room.IMultiInstanceInvalidationService");
                return true;
            }
            if (i10 == 1) {
                int iRegisterCallback = registerCallback(g.a.asInterface(parcel.readStrongBinder()), parcel.readString());
                parcel2.writeNoException();
                parcel2.writeInt(iRegisterCallback);
            } else if (i10 == 2) {
                unregisterCallback(g.a.asInterface(parcel.readStrongBinder()), parcel.readInt());
                parcel2.writeNoException();
            } else {
                if (i10 != 3) {
                    return super.onTransact(i10, parcel, parcel2, i11);
                }
                broadcastInvalidation(parcel.readInt(), parcel.createStringArray());
            }
            return true;
        }

        @Override // android.os.IInterface
        public IBinder asBinder() {
            return this;
        }
    }
}
