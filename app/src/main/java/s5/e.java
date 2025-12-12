package s5;

import android.os.Parcel;
import android.os.Parcelable;
import l6.u;

/* compiled from: CommentFrame.java */
/* loaded from: classes.dex */
public final class e extends h {
    public static final Parcelable.Creator<e> CREATOR = new a();

    /* renamed from: m, reason: collision with root package name */
    public final String f19084m;

    /* renamed from: n, reason: collision with root package name */
    public final String f19085n;

    /* renamed from: o, reason: collision with root package name */
    public final String f19086o;

    /* compiled from: CommentFrame.java */
    public static class a implements Parcelable.Creator<e> {
        @Override // android.os.Parcelable.Creator
        public e createFromParcel(Parcel parcel) {
            return new e(parcel);
        }

        @Override // android.os.Parcelable.Creator
        public e[] newArray(int i10) {
            return new e[i10];
        }
    }

    public e(String str, String str2, String str3) {
        super("COMM");
        this.f19084m = str;
        this.f19085n = str2;
        this.f19086o = str3;
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null || e.class != obj.getClass()) {
            return false;
        }
        e eVar = (e) obj;
        return u.areEqual(this.f19085n, eVar.f19085n) && u.areEqual(this.f19084m, eVar.f19084m) && u.areEqual(this.f19086o, eVar.f19086o);
    }

    public int hashCode() {
        String str = this.f19084m;
        int iHashCode = (527 + (str != null ? str.hashCode() : 0)) * 31;
        String str2 = this.f19085n;
        int iHashCode2 = (iHashCode + (str2 != null ? str2.hashCode() : 0)) * 31;
        String str3 = this.f19086o;
        return iHashCode2 + (str3 != null ? str3.hashCode() : 0);
    }

    @Override // android.os.Parcelable
    public void writeToParcel(Parcel parcel, int i10) {
        parcel.writeString(this.f19096b);
        parcel.writeString(this.f19084m);
        parcel.writeString(this.f19086o);
    }

    public e(Parcel parcel) {
        super("COMM");
        this.f19084m = parcel.readString();
        this.f19085n = parcel.readString();
        this.f19086o = parcel.readString();
    }
}
