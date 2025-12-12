package i7;

import android.os.Parcel;
import android.os.Parcelable;
import android.util.SparseArray;

/* compiled from: ParcelableSparseArray.java */
/* loaded from: classes.dex */
public final class l extends SparseArray<Parcelable> implements Parcelable {
    public static final Parcelable.Creator<l> CREATOR = new a();

    /* compiled from: ParcelableSparseArray.java */
    public class a implements Parcelable.ClassLoaderCreator<l> {
        @Override // android.os.Parcelable.Creator
        public l[] newArray(int i10) {
            return new l[i10];
        }

        /* JADX WARN: Can't rename method to resolve collision */
        @Override // android.os.Parcelable.ClassLoaderCreator
        public l createFromParcel(Parcel parcel, ClassLoader classLoader) {
            return new l(parcel, classLoader);
        }

        @Override // android.os.Parcelable.Creator
        public l createFromParcel(Parcel parcel) {
            return new l(parcel, null);
        }
    }

    public l() {
    }

    @Override // android.os.Parcelable
    public int describeContents() {
        return 0;
    }

    @Override // android.os.Parcelable
    public void writeToParcel(Parcel parcel, int i10) {
        int size = size();
        int[] iArr = new int[size];
        Parcelable[] parcelableArr = new Parcelable[size];
        for (int i11 = 0; i11 < size; i11++) {
            iArr[i11] = keyAt(i11);
            parcelableArr[i11] = valueAt(i11);
        }
        parcel.writeInt(size);
        parcel.writeIntArray(iArr);
        parcel.writeParcelableArray(parcelableArr, i10);
    }

    public l(Parcel parcel, ClassLoader classLoader) {
        int i10 = parcel.readInt();
        int[] iArr = new int[i10];
        parcel.readIntArray(iArr);
        Parcelable[] parcelableArray = parcel.readParcelableArray(classLoader);
        for (int i11 = 0; i11 < i10; i11++) {
            put(iArr[i11], parcelableArray[i11]);
        }
    }
}
