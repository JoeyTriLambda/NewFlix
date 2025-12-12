package hd;

import android.os.Parcel;
import android.os.Parcelable;
import java.util.ArrayList;

/* compiled from: ChannelTv.java */
/* loaded from: classes2.dex */
public final class d implements Parcelable {
    public static final Parcelable.Creator<d> CREATOR;

    /* renamed from: b, reason: collision with root package name */
    public boolean f12979b;

    /* renamed from: m, reason: collision with root package name */
    public String f12980m;

    /* renamed from: n, reason: collision with root package name */
    public final String f12981n;

    /* renamed from: o, reason: collision with root package name */
    public String f12982o;

    /* renamed from: p, reason: collision with root package name */
    public String f12983p;

    /* renamed from: q, reason: collision with root package name */
    public String f12984q;

    /* renamed from: r, reason: collision with root package name */
    public String f12985r;

    /* renamed from: s, reason: collision with root package name */
    public final String f12986s;

    /* renamed from: t, reason: collision with root package name */
    public String f12987t;

    /* renamed from: u, reason: collision with root package name */
    public int f12988u;

    /* renamed from: v, reason: collision with root package name */
    public final ArrayList<k> f12989v;

    /* compiled from: ChannelTv.java */
    public class a implements Parcelable.Creator<d> {
        /* JADX WARN: Can't rename method to resolve collision */
        @Override // android.os.Parcelable.Creator
        public d createFromParcel(Parcel parcel) {
            return new d(parcel);
        }

        /* JADX WARN: Can't rename method to resolve collision */
        @Override // android.os.Parcelable.Creator
        public d[] newArray(int i10) {
            return new d[i10];
        }
    }

    static {
        new kd.a();
        CREATOR = new a();
    }

    public d(Parcel parcel) {
        this.f12979b = false;
        this.f12985r = "";
        this.f12988u = -1;
        this.f12989v = new ArrayList<>();
        this.f12983p = parcel.readString();
        this.f12984q = parcel.readString();
        this.f12985r = parcel.readString();
        this.f12986s = parcel.readString();
        this.f12987t = parcel.readString();
        this.f12982o = parcel.readString();
        this.f12980m = parcel.readString();
        this.f12981n = parcel.readString();
        this.f12988u = parcel.readInt();
        this.f12989v = parcel.readArrayList(k.class.getClassLoader());
        if (parcel.readInt() == 1) {
            this.f12979b = true;
        } else {
            this.f12979b = false;
        }
    }

    @Override // android.os.Parcelable
    public int describeContents() {
        return 0;
    }

    public boolean equals(Object obj) {
        return this.f12984q.equalsIgnoreCase(((d) obj).f12984q);
    }

    public String toString() {
        return this.f12984q;
    }

    @Override // android.os.Parcelable
    public void writeToParcel(Parcel parcel, int i10) {
        parcel.writeString(this.f12983p);
        parcel.writeString(this.f12984q);
        parcel.writeString(this.f12985r);
        parcel.writeString(this.f12986s);
        parcel.writeString(this.f12987t);
        parcel.writeString(this.f12982o);
        parcel.writeString(this.f12980m);
        parcel.writeString(this.f12981n);
        parcel.writeInt(this.f12988u);
        parcel.writeList(this.f12989v);
        parcel.writeInt(this.f12979b ? 1 : 0);
    }

    public d() {
        this.f12979b = false;
        this.f12985r = "";
        this.f12988u = -1;
        this.f12989v = new ArrayList<>();
    }

    public d(d dVar) {
        this.f12979b = false;
        this.f12985r = "";
        this.f12988u = -1;
        ArrayList<k> arrayList = new ArrayList<>();
        this.f12989v = arrayList;
        this.f12983p = dVar.f12983p;
        this.f12984q = dVar.f12984q;
        this.f12985r = dVar.f12985r;
        this.f12986s = dVar.f12986s;
        this.f12987t = dVar.f12987t;
        this.f12982o = dVar.f12982o;
        this.f12981n = dVar.f12981n;
        this.f12980m = dVar.f12980m;
        this.f12988u = dVar.f12988u;
        arrayList.addAll(dVar.f12989v);
    }
}
