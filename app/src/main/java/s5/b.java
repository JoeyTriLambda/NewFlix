package s5;

import android.os.Parcel;
import android.os.Parcelable;
import java.util.Arrays;

/* compiled from: BinaryFrame.java */
/* loaded from: classes.dex */
public final class b extends h {
    public static final Parcelable.Creator<b> CREATOR = new a();

    /* renamed from: m, reason: collision with root package name */
    public final byte[] f19072m;

    /* compiled from: BinaryFrame.java */
    public static class a implements Parcelable.Creator<b> {
        @Override // android.os.Parcelable.Creator
        public b createFromParcel(Parcel parcel) {
            return new b(parcel);
        }

        @Override // android.os.Parcelable.Creator
        public b[] newArray(int i10) {
            return new b[i10];
        }
    }

    public b(String str, byte[] bArr) {
        super(str);
        this.f19072m = bArr;
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null || b.class != obj.getClass()) {
            return false;
        }
        b bVar = (b) obj;
        return this.f19096b.equals(bVar.f19096b) && Arrays.equals(this.f19072m, bVar.f19072m);
    }

    public int hashCode() {
        return Arrays.hashCode(this.f19072m) + ac.c.b(this.f19096b, 527, 31);
    }

    @Override // android.os.Parcelable
    public void writeToParcel(Parcel parcel, int i10) {
        parcel.writeString(this.f19096b);
        parcel.writeByteArray(this.f19072m);
    }

    public b(Parcel parcel) {
        super(parcel.readString());
        this.f19072m = parcel.createByteArray();
    }
}
