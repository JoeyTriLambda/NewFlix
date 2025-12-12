package t5;

import android.os.Parcel;
import android.os.Parcelable;
import l6.l;

/* compiled from: TimeSignalCommand.java */
/* loaded from: classes.dex */
public final class g extends b {
    public static final Parcelable.Creator<g> CREATOR = new a();

    /* renamed from: b, reason: collision with root package name */
    public final long f19457b;

    /* renamed from: m, reason: collision with root package name */
    public final long f19458m;

    /* compiled from: TimeSignalCommand.java */
    public static class a implements Parcelable.Creator<g> {
        @Override // android.os.Parcelable.Creator
        public g createFromParcel(Parcel parcel) {
            return new g(parcel.readLong(), parcel.readLong());
        }

        @Override // android.os.Parcelable.Creator
        public g[] newArray(int i10) {
            return new g[i10];
        }
    }

    public g(long j10, long j11) {
        this.f19457b = j10;
        this.f19458m = j11;
    }

    public static long a(l lVar, long j10) {
        long unsignedByte = lVar.readUnsignedByte();
        if ((128 & unsignedByte) != 0) {
            return 8589934591L & ((((unsignedByte & 1) << 32) | lVar.readUnsignedInt()) + j10);
        }
        return -9223372036854775807L;
    }

    @Override // android.os.Parcelable
    public void writeToParcel(Parcel parcel, int i10) {
        parcel.writeLong(this.f19457b);
        parcel.writeLong(this.f19458m);
    }
}
