package s5;

import android.os.Parcel;
import android.os.Parcelable;
import java.util.Arrays;
import l6.u;

/* compiled from: ApicFrame.java */
/* loaded from: classes.dex */
public final class a extends h {
    public static final Parcelable.Creator<a> CREATOR = new C0247a();

    /* renamed from: m, reason: collision with root package name */
    public final String f19068m;

    /* renamed from: n, reason: collision with root package name */
    public final String f19069n;

    /* renamed from: o, reason: collision with root package name */
    public final int f19070o;

    /* renamed from: p, reason: collision with root package name */
    public final byte[] f19071p;

    /* compiled from: ApicFrame.java */
    /* renamed from: s5.a$a, reason: collision with other inner class name */
    public static class C0247a implements Parcelable.Creator<a> {
        @Override // android.os.Parcelable.Creator
        public a createFromParcel(Parcel parcel) {
            return new a(parcel);
        }

        @Override // android.os.Parcelable.Creator
        public a[] newArray(int i10) {
            return new a[i10];
        }
    }

    public a(String str, String str2, int i10, byte[] bArr) {
        super("APIC");
        this.f19068m = str;
        this.f19069n = str2;
        this.f19070o = i10;
        this.f19071p = bArr;
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null || a.class != obj.getClass()) {
            return false;
        }
        a aVar = (a) obj;
        return this.f19070o == aVar.f19070o && u.areEqual(this.f19068m, aVar.f19068m) && u.areEqual(this.f19069n, aVar.f19069n) && Arrays.equals(this.f19071p, aVar.f19071p);
    }

    public int hashCode() {
        int i10 = (527 + this.f19070o) * 31;
        String str = this.f19068m;
        int iHashCode = (i10 + (str != null ? str.hashCode() : 0)) * 31;
        String str2 = this.f19069n;
        return Arrays.hashCode(this.f19071p) + ((iHashCode + (str2 != null ? str2.hashCode() : 0)) * 31);
    }

    @Override // android.os.Parcelable
    public void writeToParcel(Parcel parcel, int i10) {
        parcel.writeString(this.f19068m);
        parcel.writeString(this.f19069n);
        parcel.writeInt(this.f19070o);
        parcel.writeByteArray(this.f19071p);
    }

    public a(Parcel parcel) {
        super("APIC");
        this.f19068m = parcel.readString();
        this.f19069n = parcel.readString();
        this.f19070o = parcel.readInt();
        this.f19071p = parcel.createByteArray();
    }
}
