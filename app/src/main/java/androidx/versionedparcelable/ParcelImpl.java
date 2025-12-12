package androidx.versionedparcelable;

import android.annotation.SuppressLint;
import android.os.Parcel;
import android.os.Parcelable;
import java.lang.reflect.InvocationTargetException;
import s2.b;
import s2.c;

@SuppressLint({"BanParcelableUsage"})
/* loaded from: classes.dex */
public class ParcelImpl implements Parcelable {
    public static final Parcelable.Creator<ParcelImpl> CREATOR = new a();

    /* renamed from: b, reason: collision with root package name */
    public final c f4449b;

    public static class a implements Parcelable.Creator<ParcelImpl> {
        /* JADX WARN: Can't rename method to resolve collision */
        @Override // android.os.Parcelable.Creator
        public ParcelImpl createFromParcel(Parcel parcel) {
            return new ParcelImpl(parcel);
        }

        /* JADX WARN: Can't rename method to resolve collision */
        @Override // android.os.Parcelable.Creator
        public ParcelImpl[] newArray(int i10) {
            return new ParcelImpl[i10];
        }
    }

    public ParcelImpl(c cVar) {
        this.f4449b = cVar;
    }

    @Override // android.os.Parcelable
    public int describeContents() {
        return 0;
    }

    public <T extends c> T getVersionedParcel() {
        return (T) this.f4449b;
    }

    @Override // android.os.Parcelable
    public void writeToParcel(Parcel parcel, int i10) throws IllegalAccessException, IllegalArgumentException, InvocationTargetException {
        new b(parcel).writeVersionedParcelable(this.f4449b);
    }

    public ParcelImpl(Parcel parcel) {
        this.f4449b = new b(parcel).readVersionedParcelable();
    }
}
