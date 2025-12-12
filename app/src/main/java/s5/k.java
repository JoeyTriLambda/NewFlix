package s5;

import android.os.Parcel;
import android.os.Parcelable;
import l6.u;

/* compiled from: UrlLinkFrame.java */
/* loaded from: classes.dex */
public final class k extends h {
    public static final Parcelable.Creator<k> CREATOR = new a();

    /* renamed from: m, reason: collision with root package name */
    public final String f19101m;

    /* renamed from: n, reason: collision with root package name */
    public final String f19102n;

    /* compiled from: UrlLinkFrame.java */
    public static class a implements Parcelable.Creator<k> {
        @Override // android.os.Parcelable.Creator
        public k createFromParcel(Parcel parcel) {
            return new k(parcel);
        }

        @Override // android.os.Parcelable.Creator
        public k[] newArray(int i10) {
            return new k[i10];
        }
    }

    public k(String str, String str2, String str3) {
        super(str);
        this.f19101m = str2;
        this.f19102n = str3;
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null || k.class != obj.getClass()) {
            return false;
        }
        k kVar = (k) obj;
        return this.f19096b.equals(kVar.f19096b) && u.areEqual(this.f19101m, kVar.f19101m) && u.areEqual(this.f19102n, kVar.f19102n);
    }

    public int hashCode() {
        int iB = ac.c.b(this.f19096b, 527, 31);
        String str = this.f19101m;
        int iHashCode = (iB + (str != null ? str.hashCode() : 0)) * 31;
        String str2 = this.f19102n;
        return iHashCode + (str2 != null ? str2.hashCode() : 0);
    }

    @Override // android.os.Parcelable
    public void writeToParcel(Parcel parcel, int i10) {
        parcel.writeString(this.f19096b);
        parcel.writeString(this.f19101m);
        parcel.writeString(this.f19102n);
    }

    public k(Parcel parcel) {
        super(parcel.readString());
        this.f19101m = parcel.readString();
        this.f19102n = parcel.readString();
    }
}
