package hd;

import android.os.Parcel;
import android.os.Parcelable;

/* compiled from: Season.java */
/* loaded from: classes2.dex */
public final class j implements Parcelable {
    public static final Parcelable.Creator<j> CREATOR = new a();

    /* renamed from: b, reason: collision with root package name */
    public String f13012b;

    /* renamed from: m, reason: collision with root package name */
    public int f13013m;

    /* renamed from: n, reason: collision with root package name */
    public int f13014n;

    /* renamed from: o, reason: collision with root package name */
    public String f13015o;

    /* renamed from: p, reason: collision with root package name */
    public String f13016p;

    /* renamed from: q, reason: collision with root package name */
    public String f13017q;

    /* compiled from: Season.java */
    public class a implements Parcelable.Creator<j> {
        /* JADX WARN: Can't rename method to resolve collision */
        @Override // android.os.Parcelable.Creator
        public j createFromParcel(Parcel parcel) {
            return new j(parcel);
        }

        /* JADX WARN: Can't rename method to resolve collision */
        @Override // android.os.Parcelable.Creator
        public j[] newArray(int i10) {
            return new j[i10];
        }
    }

    public j() {
    }

    @Override // android.os.Parcelable
    public int describeContents() {
        return 0;
    }

    @Override // android.os.Parcelable
    public void writeToParcel(Parcel parcel, int i10) {
        parcel.writeString(this.f13012b);
        parcel.writeInt(this.f13013m);
        parcel.writeInt(this.f13014n);
        parcel.writeString(this.f13015o);
        parcel.writeString(this.f13016p);
        parcel.writeString(this.f13017q);
    }

    public j(Parcel parcel) {
        this.f13012b = parcel.readString();
        this.f13013m = parcel.readInt();
        this.f13014n = parcel.readInt();
        this.f13015o = parcel.readString();
        this.f13016p = parcel.readString();
        this.f13017q = parcel.readString();
    }
}
