package t5;

import android.os.Parcel;
import android.os.Parcelable;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/* compiled from: SpliceInsertCommand.java */
/* loaded from: classes.dex */
public final class d extends t5.b {
    public static final Parcelable.Creator<d> CREATOR = new a();

    /* renamed from: b, reason: collision with root package name */
    public final long f19427b;

    /* renamed from: m, reason: collision with root package name */
    public final boolean f19428m;

    /* renamed from: n, reason: collision with root package name */
    public final boolean f19429n;

    /* renamed from: o, reason: collision with root package name */
    public final boolean f19430o;

    /* renamed from: p, reason: collision with root package name */
    public final boolean f19431p;

    /* renamed from: q, reason: collision with root package name */
    public final long f19432q;

    /* renamed from: r, reason: collision with root package name */
    public final long f19433r;

    /* renamed from: s, reason: collision with root package name */
    public final List<b> f19434s;

    /* renamed from: t, reason: collision with root package name */
    public final boolean f19435t;

    /* renamed from: u, reason: collision with root package name */
    public final long f19436u;

    /* renamed from: v, reason: collision with root package name */
    public final int f19437v;

    /* renamed from: w, reason: collision with root package name */
    public final int f19438w;

    /* renamed from: x, reason: collision with root package name */
    public final int f19439x;

    /* compiled from: SpliceInsertCommand.java */
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

    /* compiled from: SpliceInsertCommand.java */
    public static final class b {

        /* renamed from: a, reason: collision with root package name */
        public final int f19440a;

        /* renamed from: b, reason: collision with root package name */
        public final long f19441b;

        /* renamed from: c, reason: collision with root package name */
        public final long f19442c;

        public b(int i10, long j10, long j11) {
            this.f19440a = i10;
            this.f19441b = j10;
            this.f19442c = j11;
        }

        public static b createFromParcel(Parcel parcel) {
            return new b(parcel.readInt(), parcel.readLong(), parcel.readLong());
        }

        public void writeToParcel(Parcel parcel) {
            parcel.writeInt(this.f19440a);
            parcel.writeLong(this.f19441b);
            parcel.writeLong(this.f19442c);
        }
    }

    public d(long j10, boolean z10, boolean z11, boolean z12, boolean z13, long j11, long j12, List<b> list, boolean z14, long j13, int i10, int i11, int i12) {
        this.f19427b = j10;
        this.f19428m = z10;
        this.f19429n = z11;
        this.f19430o = z12;
        this.f19431p = z13;
        this.f19432q = j11;
        this.f19433r = j12;
        this.f19434s = Collections.unmodifiableList(list);
        this.f19435t = z14;
        this.f19436u = j13;
        this.f19437v = i10;
        this.f19438w = i11;
        this.f19439x = i12;
    }

    @Override // android.os.Parcelable
    public void writeToParcel(Parcel parcel, int i10) {
        parcel.writeLong(this.f19427b);
        parcel.writeByte(this.f19428m ? (byte) 1 : (byte) 0);
        parcel.writeByte(this.f19429n ? (byte) 1 : (byte) 0);
        parcel.writeByte(this.f19430o ? (byte) 1 : (byte) 0);
        parcel.writeByte(this.f19431p ? (byte) 1 : (byte) 0);
        parcel.writeLong(this.f19432q);
        parcel.writeLong(this.f19433r);
        List<b> list = this.f19434s;
        int size = list.size();
        parcel.writeInt(size);
        for (int i11 = 0; i11 < size; i11++) {
            list.get(i11).writeToParcel(parcel);
        }
        parcel.writeByte(this.f19435t ? (byte) 1 : (byte) 0);
        parcel.writeLong(this.f19436u);
        parcel.writeInt(this.f19437v);
        parcel.writeInt(this.f19438w);
        parcel.writeInt(this.f19439x);
    }

    public d(Parcel parcel) {
        this.f19427b = parcel.readLong();
        this.f19428m = parcel.readByte() == 1;
        this.f19429n = parcel.readByte() == 1;
        this.f19430o = parcel.readByte() == 1;
        this.f19431p = parcel.readByte() == 1;
        this.f19432q = parcel.readLong();
        this.f19433r = parcel.readLong();
        int i10 = parcel.readInt();
        ArrayList arrayList = new ArrayList(i10);
        for (int i11 = 0; i11 < i10; i11++) {
            arrayList.add(b.createFromParcel(parcel));
        }
        this.f19434s = Collections.unmodifiableList(arrayList);
        this.f19435t = parcel.readByte() == 1;
        this.f19436u = parcel.readLong();
        this.f19437v = parcel.readInt();
        this.f19438w = parcel.readInt();
        this.f19439x = parcel.readInt();
    }
}
