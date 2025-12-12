package t7;

import android.os.Bundle;
import android.os.Parcel;
import android.os.Parcelable;
import b0.k;

/* compiled from: ExtendableSavedState.java */
/* loaded from: classes.dex */
public final class a extends f1.a {
    public static final Parcelable.Creator<a> CREATOR = new C0259a();

    /* renamed from: n, reason: collision with root package name */
    public final k<String, Bundle> f19468n;

    /* compiled from: ExtendableSavedState.java */
    /* renamed from: t7.a$a, reason: collision with other inner class name */
    public class C0259a implements Parcelable.ClassLoaderCreator<a> {
        @Override // android.os.Parcelable.Creator
        public a[] newArray(int i10) {
            return new a[i10];
        }

        @Override // android.os.Parcelable.ClassLoaderCreator
        public a createFromParcel(Parcel parcel, ClassLoader classLoader) {
            return new a(parcel, classLoader);
        }

        @Override // android.os.Parcelable.Creator
        public a createFromParcel(Parcel parcel) {
            return new a(parcel, null);
        }
    }

    public /* synthetic */ a() {
        throw null;
    }

    public a(Parcelable parcelable) {
        super(parcelable);
        this.f19468n = new k<>();
    }

    public String toString() {
        return "ExtendableSavedState{" + Integer.toHexString(System.identityHashCode(this)) + " states=" + this.f19468n + "}";
    }

    @Override // f1.a, android.os.Parcelable
    public void writeToParcel(Parcel parcel, int i10) {
        super.writeToParcel(parcel, i10);
        k<String, Bundle> kVar = this.f19468n;
        int size = kVar.size();
        parcel.writeInt(size);
        String[] strArr = new String[size];
        Bundle[] bundleArr = new Bundle[size];
        for (int i11 = 0; i11 < size; i11++) {
            strArr[i11] = kVar.keyAt(i11);
            bundleArr[i11] = kVar.valueAt(i11);
        }
        parcel.writeStringArray(strArr);
        parcel.writeTypedArray(bundleArr, 0);
    }

    public a(Parcel parcel, ClassLoader classLoader) {
        super(parcel, classLoader);
        int i10 = parcel.readInt();
        String[] strArr = new String[i10];
        parcel.readStringArray(strArr);
        Bundle[] bundleArr = new Bundle[i10];
        parcel.readTypedArray(bundleArr, Bundle.CREATOR);
        this.f19468n = new k<>(i10);
        for (int i11 = 0; i11 < i10; i11++) {
            this.f19468n.put(strArr[i11], bundleArr[i11]);
        }
    }
}
