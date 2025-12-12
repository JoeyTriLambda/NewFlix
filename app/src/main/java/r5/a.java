package r5;

import android.os.Parcel;
import android.os.Parcelable;
import java.util.Arrays;
import l6.u;
import q5.a;

/* compiled from: EventMessage.java */
/* loaded from: classes.dex */
public final class a implements a.b {
    public static final Parcelable.Creator<a> CREATOR = new C0239a();

    /* renamed from: b, reason: collision with root package name */
    public final String f18601b;

    /* renamed from: m, reason: collision with root package name */
    public final String f18602m;

    /* renamed from: n, reason: collision with root package name */
    public final long f18603n;

    /* renamed from: o, reason: collision with root package name */
    public final long f18604o;

    /* renamed from: p, reason: collision with root package name */
    public final byte[] f18605p;

    /* renamed from: q, reason: collision with root package name */
    public int f18606q;

    /* compiled from: EventMessage.java */
    /* renamed from: r5.a$a, reason: collision with other inner class name */
    public static class C0239a implements Parcelable.Creator<a> {
        @Override // android.os.Parcelable.Creator
        public a createFromParcel(Parcel parcel) {
            return new a(parcel);
        }

        @Override // android.os.Parcelable.Creator
        public a[] newArray(int i10) {
            return new a[i10];
        }
    }

    public a(String str, String str2, long j10, long j11, byte[] bArr) {
        this.f18601b = str;
        this.f18602m = str2;
        this.f18603n = j10;
        this.f18604o = j11;
        this.f18605p = bArr;
    }

    @Override // android.os.Parcelable
    public int describeContents() {
        return 0;
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null || a.class != obj.getClass()) {
            return false;
        }
        a aVar = (a) obj;
        return this.f18603n == aVar.f18603n && this.f18604o == aVar.f18604o && u.areEqual(this.f18601b, aVar.f18601b) && u.areEqual(this.f18602m, aVar.f18602m) && Arrays.equals(this.f18605p, aVar.f18605p);
    }

    public int hashCode() {
        if (this.f18606q == 0) {
            String str = this.f18601b;
            int iHashCode = (527 + (str != null ? str.hashCode() : 0)) * 31;
            String str2 = this.f18602m;
            int iHashCode2 = (iHashCode + (str2 != null ? str2.hashCode() : 0)) * 31;
            long j10 = this.f18603n;
            int i10 = (iHashCode2 + ((int) (j10 ^ (j10 >>> 32)))) * 31;
            long j11 = this.f18604o;
            this.f18606q = Arrays.hashCode(this.f18605p) + ((i10 + ((int) (j11 ^ (j11 >>> 32)))) * 31);
        }
        return this.f18606q;
    }

    @Override // android.os.Parcelable
    public void writeToParcel(Parcel parcel, int i10) {
        parcel.writeString(this.f18601b);
        parcel.writeString(this.f18602m);
        parcel.writeLong(this.f18603n);
        parcel.writeLong(this.f18604o);
        parcel.writeByteArray(this.f18605p);
    }

    public a(Parcel parcel) {
        this.f18601b = parcel.readString();
        this.f18602m = parcel.readString();
        this.f18603n = parcel.readLong();
        this.f18604o = parcel.readLong();
        this.f18605p = parcel.createByteArray();
    }
}
