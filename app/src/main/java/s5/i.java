package s5;

import android.os.Parcel;
import android.os.Parcelable;
import java.util.Arrays;
import l6.u;

/* compiled from: PrivFrame.java */
/* loaded from: classes.dex */
public final class i extends h {
    public static final Parcelable.Creator<i> CREATOR = new a();

    /* renamed from: m, reason: collision with root package name */
    public final String f19097m;

    /* renamed from: n, reason: collision with root package name */
    public final byte[] f19098n;

    /* compiled from: PrivFrame.java */
    public static class a implements Parcelable.Creator<i> {
        @Override // android.os.Parcelable.Creator
        public i createFromParcel(Parcel parcel) {
            return new i(parcel);
        }

        @Override // android.os.Parcelable.Creator
        public i[] newArray(int i10) {
            return new i[i10];
        }
    }

    public i(String str, byte[] bArr) {
        super("PRIV");
        this.f19097m = str;
        this.f19098n = bArr;
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null || i.class != obj.getClass()) {
            return false;
        }
        i iVar = (i) obj;
        return u.areEqual(this.f19097m, iVar.f19097m) && Arrays.equals(this.f19098n, iVar.f19098n);
    }

    public int hashCode() {
        String str = this.f19097m;
        return Arrays.hashCode(this.f19098n) + ((527 + (str != null ? str.hashCode() : 0)) * 31);
    }

    @Override // android.os.Parcelable
    public void writeToParcel(Parcel parcel, int i10) {
        parcel.writeString(this.f19097m);
        parcel.writeByteArray(this.f19098n);
    }

    public i(Parcel parcel) {
        super("PRIV");
        this.f19097m = parcel.readString();
        this.f19098n = parcel.createByteArray();
    }
}
