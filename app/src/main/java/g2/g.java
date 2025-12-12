package g2;

import android.os.Binder;
import android.os.IBinder;
import android.os.IInterface;
import android.os.Parcel;
import android.os.RemoteException;
import g2.l;

/* compiled from: IMultiInstanceInvalidationCallback.java */
/* loaded from: classes.dex */
public interface g extends IInterface {
    void onInvalidation(String[] strArr) throws RemoteException;

    /* compiled from: IMultiInstanceInvalidationCallback.java */
    public static abstract class a extends Binder implements g {

        /* compiled from: IMultiInstanceInvalidationCallback.java */
        /* renamed from: g2.g$a$a, reason: collision with other inner class name */
        public static class C0150a implements g {

            /* renamed from: a, reason: collision with root package name */
            public final IBinder f12566a;

            public C0150a(IBinder iBinder) {
                this.f12566a = iBinder;
            }

            @Override // android.os.IInterface
            public IBinder asBinder() {
                return this.f12566a;
            }

            @Override // g2.g
            public void onInvalidation(String[] strArr) throws RemoteException {
                Parcel parcelObtain = Parcel.obtain();
                try {
                    parcelObtain.writeInterfaceToken("androidx.room.IMultiInstanceInvalidationCallback");
                    parcelObtain.writeStringArray(strArr);
                    this.f12566a.transact(1, parcelObtain, null, 1);
                } finally {
                    parcelObtain.recycle();
                }
            }
        }

        public a() {
            attachInterface(this, "androidx.room.IMultiInstanceInvalidationCallback");
        }

        public static g asInterface(IBinder iBinder) {
            if (iBinder == null) {
                return null;
            }
            IInterface iInterfaceQueryLocalInterface = iBinder.queryLocalInterface("androidx.room.IMultiInstanceInvalidationCallback");
            return (iInterfaceQueryLocalInterface == null || !(iInterfaceQueryLocalInterface instanceof g)) ? new C0150a(iBinder) : (g) iInterfaceQueryLocalInterface;
        }

        @Override // android.os.Binder
        public boolean onTransact(int i10, Parcel parcel, Parcel parcel2, int i11) throws RemoteException {
            if (i10 >= 1 && i10 <= 16777215) {
                parcel.enforceInterface("androidx.room.IMultiInstanceInvalidationCallback");
            }
            if (i10 == 1598968902) {
                parcel2.writeString("androidx.room.IMultiInstanceInvalidationCallback");
                return true;
            }
            if (i10 != 1) {
                return super.onTransact(i10, parcel, parcel2, i11);
            }
            ((l.b) this).onInvalidation(parcel.createStringArray());
            return true;
        }

        @Override // android.os.IInterface
        public IBinder asBinder() {
            return this;
        }
    }
}
