package s5;

import android.os.Parcel;
import android.os.Parcelable;
import java.util.Arrays;
import l6.u;

/* compiled from: ChapterTocFrame.java */
/* loaded from: classes.dex */
public final class d extends h {
    public static final Parcelable.Creator<d> CREATOR = new a();

    /* renamed from: m, reason: collision with root package name */
    public final String f19079m;

    /* renamed from: n, reason: collision with root package name */
    public final boolean f19080n;

    /* renamed from: o, reason: collision with root package name */
    public final boolean f19081o;

    /* renamed from: p, reason: collision with root package name */
    public final String[] f19082p;

    /* renamed from: q, reason: collision with root package name */
    public final h[] f19083q;

    /* compiled from: ChapterTocFrame.java */
    public static class a implements Parcelable.Creator<d> {
        @Override // android.os.Parcelable.Creator
        public d createFromParcel(Parcel parcel) {
            return new d(parcel);
        }

        @Override // android.os.Parcelable.Creator
        public d[] newArray(int i10) {
            return new d[i10];
        }
    }

    public d(String str, boolean z10, boolean z11, String[] strArr, h[] hVarArr) {
        super("CTOC");
        this.f19079m = str;
        this.f19080n = z10;
        this.f19081o = z11;
        this.f19082p = strArr;
        this.f19083q = hVarArr;
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null || d.class != obj.getClass()) {
            return false;
        }
        d dVar = (d) obj;
        return this.f19080n == dVar.f19080n && this.f19081o == dVar.f19081o && u.areEqual(this.f19079m, dVar.f19079m) && Arrays.equals(this.f19082p, dVar.f19082p) && Arrays.equals(this.f19083q, dVar.f19083q);
    }

    public int hashCode() {
        int i10 = (((527 + (this.f19080n ? 1 : 0)) * 31) + (this.f19081o ? 1 : 0)) * 31;
        String str = this.f19079m;
        return i10 + (str != null ? str.hashCode() : 0);
    }

    @Override // android.os.Parcelable
    public void writeToParcel(Parcel parcel, int i10) {
        parcel.writeString(this.f19079m);
        parcel.writeByte(this.f19080n ? (byte) 1 : (byte) 0);
        parcel.writeByte(this.f19081o ? (byte) 1 : (byte) 0);
        parcel.writeStringArray(this.f19082p);
        h[] hVarArr = this.f19083q;
        parcel.writeInt(hVarArr.length);
        for (h hVar : hVarArr) {
            parcel.writeParcelable(hVar, 0);
        }
    }

    public d(Parcel parcel) {
        super("CTOC");
        this.f19079m = parcel.readString();
        this.f19080n = parcel.readByte() != 0;
        this.f19081o = parcel.readByte() != 0;
        this.f19082p = parcel.createStringArray();
        int i10 = parcel.readInt();
        this.f19083q = new h[i10];
        for (int i11 = 0; i11 < i10; i11++) {
            this.f19083q[i11] = (h) parcel.readParcelable(h.class.getClassLoader());
        }
    }
}
