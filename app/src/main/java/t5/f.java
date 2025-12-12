package t5;

import android.os.Parcel;
import android.os.Parcelable;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/* compiled from: SpliceScheduleCommand.java */
/* loaded from: classes.dex */
public final class f extends t5.b {
    public static final Parcelable.Creator<f> CREATOR = new a();

    /* renamed from: b, reason: collision with root package name */
    public final List<c> f19443b;

    /* compiled from: SpliceScheduleCommand.java */
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

    /* compiled from: SpliceScheduleCommand.java */
    public static final class b {

        /* renamed from: a, reason: collision with root package name */
        public final int f19444a;

        /* renamed from: b, reason: collision with root package name */
        public final long f19445b;

        public b(int i10, long j10) {
            this.f19444a = i10;
            this.f19445b = j10;
        }
    }

    public f(ArrayList arrayList) {
        this.f19443b = Collections.unmodifiableList(arrayList);
    }

    @Override // android.os.Parcelable
    public void writeToParcel(Parcel parcel, int i10) {
        List<c> list = this.f19443b;
        int size = list.size();
        parcel.writeInt(size);
        for (int i11 = 0; i11 < size; i11++) {
            c cVar = list.get(i11);
            parcel.writeLong(cVar.f19446a);
            parcel.writeByte(cVar.f19447b ? (byte) 1 : (byte) 0);
            parcel.writeByte(cVar.f19448c ? (byte) 1 : (byte) 0);
            parcel.writeByte(cVar.f19449d ? (byte) 1 : (byte) 0);
            List<b> list2 = cVar.f19451f;
            int size2 = list2.size();
            parcel.writeInt(size2);
            for (int i12 = 0; i12 < size2; i12++) {
                b bVar = list2.get(i12);
                parcel.writeInt(bVar.f19444a);
                parcel.writeLong(bVar.f19445b);
            }
            parcel.writeLong(cVar.f19450e);
            parcel.writeByte(cVar.f19452g ? (byte) 1 : (byte) 0);
            parcel.writeLong(cVar.f19453h);
            parcel.writeInt(cVar.f19454i);
            parcel.writeInt(cVar.f19455j);
            parcel.writeInt(cVar.f19456k);
        }
    }

    public f(Parcel parcel) {
        int i10 = parcel.readInt();
        ArrayList arrayList = new ArrayList(i10);
        for (int i11 = 0; i11 < i10; i11++) {
            arrayList.add(new c(parcel));
        }
        this.f19443b = Collections.unmodifiableList(arrayList);
    }

    /* compiled from: SpliceScheduleCommand.java */
    public static final class c {

        /* renamed from: a, reason: collision with root package name */
        public final long f19446a;

        /* renamed from: b, reason: collision with root package name */
        public final boolean f19447b;

        /* renamed from: c, reason: collision with root package name */
        public final boolean f19448c;

        /* renamed from: d, reason: collision with root package name */
        public final boolean f19449d;

        /* renamed from: e, reason: collision with root package name */
        public final long f19450e;

        /* renamed from: f, reason: collision with root package name */
        public final List<b> f19451f;

        /* renamed from: g, reason: collision with root package name */
        public final boolean f19452g;

        /* renamed from: h, reason: collision with root package name */
        public final long f19453h;

        /* renamed from: i, reason: collision with root package name */
        public final int f19454i;

        /* renamed from: j, reason: collision with root package name */
        public final int f19455j;

        /* renamed from: k, reason: collision with root package name */
        public final int f19456k;

        public c(long j10, boolean z10, boolean z11, boolean z12, ArrayList arrayList, long j11, boolean z13, long j12, int i10, int i11, int i12) {
            this.f19446a = j10;
            this.f19447b = z10;
            this.f19448c = z11;
            this.f19449d = z12;
            this.f19451f = Collections.unmodifiableList(arrayList);
            this.f19450e = j11;
            this.f19452g = z13;
            this.f19453h = j12;
            this.f19454i = i10;
            this.f19455j = i11;
            this.f19456k = i12;
        }

        public c(Parcel parcel) {
            this.f19446a = parcel.readLong();
            this.f19447b = parcel.readByte() == 1;
            this.f19448c = parcel.readByte() == 1;
            this.f19449d = parcel.readByte() == 1;
            int i10 = parcel.readInt();
            ArrayList arrayList = new ArrayList(i10);
            for (int i11 = 0; i11 < i10; i11++) {
                arrayList.add(new b(parcel.readInt(), parcel.readLong()));
            }
            this.f19451f = Collections.unmodifiableList(arrayList);
            this.f19450e = parcel.readLong();
            this.f19452g = parcel.readByte() == 1;
            this.f19453h = parcel.readLong();
            this.f19454i = parcel.readInt();
            this.f19455j = parcel.readInt();
            this.f19456k = parcel.readInt();
        }
    }
}
