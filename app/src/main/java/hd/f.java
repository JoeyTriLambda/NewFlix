package hd;

import android.os.Parcel;
import android.os.Parcelable;

/* compiled from: Episode.java */
/* loaded from: classes2.dex */
public final class f implements Parcelable {
    public static final Parcelable.Creator<f> CREATOR = new a();

    /* renamed from: b, reason: collision with root package name */
    public String f12992b;

    /* renamed from: m, reason: collision with root package name */
    public String f12993m;

    /* renamed from: n, reason: collision with root package name */
    public String f12994n;

    /* renamed from: o, reason: collision with root package name */
    public String f12995o;

    /* renamed from: p, reason: collision with root package name */
    public String f12996p;

    /* renamed from: q, reason: collision with root package name */
    public final String f12997q;

    /* renamed from: r, reason: collision with root package name */
    public final String f12998r;

    /* renamed from: s, reason: collision with root package name */
    public final String f12999s;

    /* renamed from: t, reason: collision with root package name */
    public String f13000t;

    /* renamed from: u, reason: collision with root package name */
    public int f13001u;

    /* renamed from: v, reason: collision with root package name */
    public boolean f13002v;

    /* renamed from: w, reason: collision with root package name */
    public final boolean f13003w;

    /* renamed from: x, reason: collision with root package name */
    public String f13004x;

    /* renamed from: y, reason: collision with root package name */
    public boolean f13005y;

    /* compiled from: Episode.java */
    public class a implements Parcelable.Creator<f> {
        /* JADX WARN: Can't rename method to resolve collision */
        @Override // android.os.Parcelable.Creator
        public f createFromParcel(Parcel parcel) {
            return new f(parcel);
        }

        /* JADX WARN: Can't rename method to resolve collision */
        @Override // android.os.Parcelable.Creator
        public f[] newArray(int i10) {
            return new f[i10];
        }
    }

    public f(Parcel parcel) {
        this.f13000t = "";
        this.f13002v = false;
        this.f13003w = false;
        this.f13004x = "N/A";
        this.f13005y = false;
        this.f12996p = parcel.readString();
        this.f12994n = parcel.readString();
        this.f12997q = parcel.readString();
        this.f12998r = parcel.readString();
        this.f12999s = parcel.readString();
        this.f13000t = parcel.readString();
        this.f13001u = parcel.readInt();
        this.f13002v = parcel.readByte() != 0;
        this.f13003w = parcel.readByte() != 0;
        this.f13004x = parcel.readString();
        this.f13005y = parcel.readByte() != 0;
        this.f12993m = parcel.readString();
    }

    @Override // android.os.Parcelable
    public int describeContents() {
        return 0;
    }

    public String toString() {
        if (this.f13002v || this.f13003w) {
            return this.f13000t;
        }
        return this.f13001u + ". " + this.f13000t;
    }

    @Override // android.os.Parcelable
    public void writeToParcel(Parcel parcel, int i10) {
        parcel.writeString(this.f12996p);
        parcel.writeString(this.f12994n);
        parcel.writeString(this.f12997q);
        parcel.writeString(this.f12998r);
        parcel.writeString(this.f12999s);
        parcel.writeString(this.f13000t);
        parcel.writeInt(this.f13001u);
        parcel.writeInt(this.f13002v ? 1 : 0);
        parcel.writeInt(this.f13003w ? 1 : 0);
        parcel.writeString(this.f13004x);
        parcel.writeInt(this.f13005y ? 1 : 0);
        parcel.writeString(this.f12993m);
    }

    public f() {
        this.f13000t = "";
        this.f13002v = false;
        this.f13003w = false;
        this.f13004x = "N/A";
        this.f13005y = false;
    }
}
