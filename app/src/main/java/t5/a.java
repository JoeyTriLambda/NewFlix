package t5;

import android.os.Parcel;
import android.os.Parcelable;

/* compiled from: PrivateCommand.java */
/* loaded from: classes.dex */
public final class a extends b {
    public static final Parcelable.Creator<a> CREATOR = new C0258a();

    /* renamed from: b, reason: collision with root package name */
    public final long f19421b;

    /* renamed from: m, reason: collision with root package name */
    public final long f19422m;

    /* renamed from: n, reason: collision with root package name */
    public final byte[] f19423n;

    /* compiled from: PrivateCommand.java */
    /* renamed from: t5.a$a, reason: collision with other inner class name */
    public static class C0258a implements Parcelable.Creator<a> {
        @Override // android.os.Parcelable.Creator
        public a createFromParcel(Parcel parcel) {
            return new a(parcel);
        }

        @Override // android.os.Parcelable.Creator
        public a[] newArray(int i10) {
            return new a[i10];
        }
    }

    public a(long j10, byte[] bArr, long j11) {
        this.f19421b = j11;
        this.f19422m = j10;
        this.f19423n = bArr;
    }

    @Override // android.os.Parcelable
    public void writeToParcel(Parcel parcel, int i10) {
        parcel.writeLong(this.f19421b);
        parcel.writeLong(this.f19422m);
        byte[] bArr = this.f19423n;
        parcel.writeInt(bArr.length);
        parcel.writeByteArray(bArr);
    }

    public a(Parcel parcel) {
        this.f19421b = parcel.readLong();
        this.f19422m = parcel.readLong();
        byte[] bArr = new byte[parcel.readInt()];
        this.f19423n = bArr;
        parcel.readByteArray(bArr);
    }
}
