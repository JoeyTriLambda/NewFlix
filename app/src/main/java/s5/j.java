package s5;

import android.os.Parcel;
import android.os.Parcelable;
import l6.u;

/* compiled from: TextInformationFrame.java */
/* loaded from: classes.dex */
public final class j extends h {
    public static final Parcelable.Creator<j> CREATOR = new a();

    /* renamed from: m, reason: collision with root package name */
    public final String f19099m;

    /* renamed from: n, reason: collision with root package name */
    public final String f19100n;

    /* compiled from: TextInformationFrame.java */
    public static class a implements Parcelable.Creator<j> {
        @Override // android.os.Parcelable.Creator
        public j createFromParcel(Parcel parcel) {
            return new j(parcel);
        }

        @Override // android.os.Parcelable.Creator
        public j[] newArray(int i10) {
            return new j[i10];
        }
    }

    public j(String str, String str2, String str3) {
        super(str);
        this.f19099m = str2;
        this.f19100n = str3;
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null || j.class != obj.getClass()) {
            return false;
        }
        j jVar = (j) obj;
        return this.f19096b.equals(jVar.f19096b) && u.areEqual(this.f19099m, jVar.f19099m) && u.areEqual(this.f19100n, jVar.f19100n);
    }

    public int hashCode() {
        int iB = ac.c.b(this.f19096b, 527, 31);
        String str = this.f19099m;
        int iHashCode = (iB + (str != null ? str.hashCode() : 0)) * 31;
        String str2 = this.f19100n;
        return iHashCode + (str2 != null ? str2.hashCode() : 0);
    }

    @Override // android.os.Parcelable
    public void writeToParcel(Parcel parcel, int i10) {
        parcel.writeString(this.f19096b);
        parcel.writeString(this.f19099m);
        parcel.writeString(this.f19100n);
    }

    public j(Parcel parcel) {
        super(parcel.readString());
        this.f19099m = parcel.readString();
        this.f19100n = parcel.readString();
    }
}
