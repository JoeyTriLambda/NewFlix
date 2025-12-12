package hd;

import android.os.Parcel;
import android.os.Parcelable;
import java.util.HashMap;
import java.util.Map;

/* compiled from: StreamUrl.java */
/* loaded from: classes2.dex */
public final class k implements Parcelable {
    public static final Parcelable.Creator<k> CREATOR = new a();

    /* renamed from: b, reason: collision with root package name */
    public final String f13018b;

    /* renamed from: m, reason: collision with root package name */
    public final String f13019m;

    /* renamed from: n, reason: collision with root package name */
    public String f13020n;

    /* renamed from: o, reason: collision with root package name */
    public String f13021o;

    /* renamed from: p, reason: collision with root package name */
    public final String f13022p;

    /* renamed from: q, reason: collision with root package name */
    public int f13023q;

    /* renamed from: r, reason: collision with root package name */
    public String f13024r;

    /* renamed from: s, reason: collision with root package name */
    public final String f13025s;

    /* renamed from: t, reason: collision with root package name */
    public int f13026t;

    /* renamed from: u, reason: collision with root package name */
    public String f13027u;

    /* renamed from: v, reason: collision with root package name */
    public final boolean f13028v;

    /* renamed from: w, reason: collision with root package name */
    public String f13029w;

    /* compiled from: StreamUrl.java */
    public class a implements Parcelable.Creator<k> {
        /* JADX WARN: Can't rename method to resolve collision */
        @Override // android.os.Parcelable.Creator
        public k createFromParcel(Parcel parcel) {
            return new k(parcel);
        }

        /* JADX WARN: Can't rename method to resolve collision */
        @Override // android.os.Parcelable.Creator
        public k[] newArray(int i10) {
            return new k[i10];
        }
    }

    public k(Parcel parcel) {
        this.f13028v = true;
        this.f13018b = parcel.readString();
        this.f13019m = parcel.readString();
        this.f13020n = parcel.readString();
        this.f13021o = parcel.readString();
        this.f13022p = parcel.readString();
        this.f13023q = parcel.readInt();
        this.f13024r = parcel.readString();
        this.f13025s = parcel.readString();
        this.f13026t = parcel.readInt();
        this.f13027u = parcel.readString();
        this.f13028v = parcel.readByte() != 0;
        this.f13029w = parcel.readString();
    }

    @Override // android.os.Parcelable
    public int describeContents() {
        return 0;
    }

    public Map<String, String> getHeaders() {
        HashMap map = new HashMap();
        map.put("User-Agent", this.f13021o);
        map.put("Referer", this.f13020n);
        return map;
    }

    @Override // android.os.Parcelable
    public void writeToParcel(Parcel parcel, int i10) {
        parcel.writeString(this.f13018b);
        parcel.writeString(this.f13019m);
        parcel.writeString(this.f13020n);
        parcel.writeString(this.f13021o);
        parcel.writeString(this.f13022p);
        parcel.writeInt(this.f13023q);
        parcel.writeString(this.f13024r);
        parcel.writeString(this.f13025s);
        parcel.writeInt(this.f13026t);
        parcel.writeString(this.f13027u);
        parcel.writeInt(this.f13028v ? 1 : 0);
        parcel.writeString(this.f13029w);
    }

    public k() {
        this.f13028v = true;
    }
}
