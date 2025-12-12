package s5;

import android.os.Parcel;
import android.os.Parcelable;
import java.util.Arrays;
import l6.u;

/* compiled from: GeobFrame.java */
/* loaded from: classes.dex */
public final class f extends h {
    public static final Parcelable.Creator<f> CREATOR = new a();

    /* renamed from: m, reason: collision with root package name */
    public final String f19087m;

    /* renamed from: n, reason: collision with root package name */
    public final String f19088n;

    /* renamed from: o, reason: collision with root package name */
    public final String f19089o;

    /* renamed from: p, reason: collision with root package name */
    public final byte[] f19090p;

    /* compiled from: GeobFrame.java */
    public static class a implements Parcelable.Creator<f> {
        @Override // android.os.Parcelable.Creator
        public f createFromParcel(Parcel parcel) {
            return new f(parcel);
        }

        @Override // android.os.Parcelable.Creator
        public f[] newArray(int i10) {
            return new f[i10];
        }
    }

    public f(String str, String str2, String str3, byte[] bArr) {
        super("GEOB");
        this.f19087m = str;
        this.f19088n = str2;
        this.f19089o = str3;
        this.f19090p = bArr;
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null || f.class != obj.getClass()) {
            return false;
        }
        f fVar = (f) obj;
        return u.areEqual(this.f19087m, fVar.f19087m) && u.areEqual(this.f19088n, fVar.f19088n) && u.areEqual(this.f19089o, fVar.f19089o) && Arrays.equals(this.f19090p, fVar.f19090p);
    }

    public int hashCode() {
        String str = this.f19087m;
        int iHashCode = (527 + (str != null ? str.hashCode() : 0)) * 31;
        String str2 = this.f19088n;
        int iHashCode2 = (iHashCode + (str2 != null ? str2.hashCode() : 0)) * 31;
        String str3 = this.f19089o;
        return Arrays.hashCode(this.f19090p) + ((iHashCode2 + (str3 != null ? str3.hashCode() : 0)) * 31);
    }

    @Override // android.os.Parcelable
    public void writeToParcel(Parcel parcel, int i10) {
        parcel.writeString(this.f19087m);
        parcel.writeString(this.f19088n);
        parcel.writeString(this.f19089o);
        parcel.writeByteArray(this.f19090p);
    }

    public f(Parcel parcel) {
        super("GEOB");
        this.f19087m = parcel.readString();
        this.f19088n = parcel.readString();
        this.f19089o = parcel.readString();
        this.f19090p = parcel.createByteArray();
    }
}
