package m6;

import android.os.Parcel;
import android.os.Parcelable;
import java.util.Arrays;

/* compiled from: ColorInfo.java */
/* loaded from: classes.dex */
public final class b implements Parcelable {
    public static final Parcelable.Creator<b> CREATOR = new a();

    /* renamed from: b, reason: collision with root package name */
    public final int f16115b;

    /* renamed from: m, reason: collision with root package name */
    public final int f16116m;

    /* renamed from: n, reason: collision with root package name */
    public final int f16117n;

    /* renamed from: o, reason: collision with root package name */
    public final byte[] f16118o;

    /* renamed from: p, reason: collision with root package name */
    public int f16119p;

    /* compiled from: ColorInfo.java */
    public static class a implements Parcelable.Creator<b> {
        @Override // android.os.Parcelable.Creator
        public b[] newArray(int i10) {
            return new b[0];
        }

        @Override // android.os.Parcelable.Creator
        public b createFromParcel(Parcel parcel) {
            return new b(parcel);
        }
    }

    public b(int i10, int i11, int i12, byte[] bArr) {
        this.f16115b = i10;
        this.f16116m = i11;
        this.f16117n = i12;
        this.f16118o = bArr;
    }

    @Override // android.os.Parcelable
    public int describeContents() {
        return 0;
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj != null && b.class == obj.getClass()) {
            b bVar = (b) obj;
            if (this.f16115b == bVar.f16115b && this.f16116m == bVar.f16116m && this.f16117n == bVar.f16117n && Arrays.equals(this.f16118o, bVar.f16118o)) {
                return true;
            }
        }
        return false;
    }

    public int hashCode() {
        if (this.f16119p == 0) {
            this.f16119p = Arrays.hashCode(this.f16118o) + ((((((527 + this.f16115b) * 31) + this.f16116m) * 31) + this.f16117n) * 31);
        }
        return this.f16119p;
    }

    public String toString() {
        StringBuilder sb2 = new StringBuilder("ColorInfo(");
        sb2.append(this.f16115b);
        sb2.append(", ");
        sb2.append(this.f16116m);
        sb2.append(", ");
        sb2.append(this.f16117n);
        sb2.append(", ");
        sb2.append(this.f16118o != null);
        sb2.append(")");
        return sb2.toString();
    }

    @Override // android.os.Parcelable
    public void writeToParcel(Parcel parcel, int i10) {
        parcel.writeInt(this.f16115b);
        parcel.writeInt(this.f16116m);
        parcel.writeInt(this.f16117n);
        byte[] bArr = this.f16118o;
        parcel.writeInt(bArr != null ? 1 : 0);
        if (bArr != null) {
            parcel.writeByteArray(bArr);
        }
    }

    public b(Parcel parcel) {
        this.f16115b = parcel.readInt();
        this.f16116m = parcel.readInt();
        this.f16117n = parcel.readInt();
        this.f16118o = parcel.readInt() != 0 ? parcel.createByteArray() : null;
    }
}
