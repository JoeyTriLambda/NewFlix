package androidx.fragment.app;

import android.annotation.SuppressLint;
import android.os.Parcel;
import android.os.Parcelable;
import java.util.ArrayList;

/* compiled from: BackStackState.java */
@SuppressLint({"BanParcelableUsage"})
/* loaded from: classes.dex */
public final class c implements Parcelable {
    public static final Parcelable.Creator<c> CREATOR = new a();

    /* renamed from: b, reason: collision with root package name */
    public final ArrayList f2769b;

    /* renamed from: m, reason: collision with root package name */
    public final ArrayList f2770m;

    /* compiled from: BackStackState.java */
    public class a implements Parcelable.Creator<c> {
        /* JADX WARN: Can't rename method to resolve collision */
        @Override // android.os.Parcelable.Creator
        public c createFromParcel(Parcel parcel) {
            return new c(parcel);
        }

        /* JADX WARN: Can't rename method to resolve collision */
        @Override // android.os.Parcelable.Creator
        public c[] newArray(int i10) {
            return new c[i10];
        }
    }

    public c(Parcel parcel) {
        this.f2769b = parcel.createStringArrayList();
        this.f2770m = parcel.createTypedArrayList(b.CREATOR);
    }

    @Override // android.os.Parcelable
    public int describeContents() {
        return 0;
    }

    @Override // android.os.Parcelable
    public void writeToParcel(Parcel parcel, int i10) {
        parcel.writeStringList(this.f2769b);
        parcel.writeTypedList(this.f2770m);
    }
}
