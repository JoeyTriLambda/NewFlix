package f1;

import android.annotation.SuppressLint;
import android.os.Parcel;
import android.os.Parcelable;

/* compiled from: AbsSavedState.java */
@SuppressLint({"BanParcelableUsage"})
/* loaded from: classes.dex */
public abstract class a implements Parcelable {

    /* renamed from: b, reason: collision with root package name */
    public final Parcelable f11377b;

    /* renamed from: m, reason: collision with root package name */
    public static final C0138a f11376m = new C0138a();
    public static final Parcelable.Creator<a> CREATOR = new b();

    /* compiled from: AbsSavedState.java */
    /* renamed from: f1.a$a, reason: collision with other inner class name */
    public class C0138a extends a {
    }

    /* compiled from: AbsSavedState.java */
    public class b implements Parcelable.ClassLoaderCreator<a> {
        @Override // android.os.Parcelable.Creator
        public a[] newArray(int i10) {
            return new a[i10];
        }

        /* JADX WARN: Can't rename method to resolve collision */
        @Override // android.os.Parcelable.ClassLoaderCreator
        public a createFromParcel(Parcel parcel, ClassLoader classLoader) {
            if (parcel.readParcelable(classLoader) == null) {
                return a.f11376m;
            }
            throw new IllegalStateException("superState must be null");
        }

        @Override // android.os.Parcelable.Creator
        public a createFromParcel(Parcel parcel) {
            return createFromParcel(parcel, (ClassLoader) null);
        }
    }

    public a() {
        this.f11377b = null;
    }

    @Override // android.os.Parcelable
    public int describeContents() {
        return 0;
    }

    public final Parcelable getSuperState() {
        return this.f11377b;
    }

    @Override // android.os.Parcelable
    public void writeToParcel(Parcel parcel, int i10) {
        parcel.writeParcelable(this.f11377b, i10);
    }

    public a(Parcelable parcelable) {
        if (parcelable != null) {
            this.f11377b = parcelable == f11376m ? null : parcelable;
            return;
        }
        throw new IllegalArgumentException("superState must not be null");
    }

    public a(Parcel parcel, ClassLoader classLoader) {
        Parcelable parcelable = parcel.readParcelable(classLoader);
        this.f11377b = parcelable == null ? f11376m : parcelable;
    }
}
