package s5;

import android.os.Parcel;
import android.os.Parcelable;
import java.util.Arrays;
import l6.u;

/* compiled from: ChapterFrame.java */
/* loaded from: classes.dex */
public final class c extends h {
    public static final Parcelable.Creator<c> CREATOR = new a();

    /* renamed from: m, reason: collision with root package name */
    public final String f19073m;

    /* renamed from: n, reason: collision with root package name */
    public final int f19074n;

    /* renamed from: o, reason: collision with root package name */
    public final int f19075o;

    /* renamed from: p, reason: collision with root package name */
    public final long f19076p;

    /* renamed from: q, reason: collision with root package name */
    public final long f19077q;

    /* renamed from: r, reason: collision with root package name */
    public final h[] f19078r;

    /* compiled from: ChapterFrame.java */
    public static class a implements Parcelable.Creator<c> {
        @Override // android.os.Parcelable.Creator
        public c createFromParcel(Parcel parcel) {
            return new c(parcel);
        }

        @Override // android.os.Parcelable.Creator
        public c[] newArray(int i10) {
            return new c[i10];
        }
    }

    public c(String str, int i10, int i11, long j10, long j11, h[] hVarArr) {
        super("CHAP");
        this.f19073m = str;
        this.f19074n = i10;
        this.f19075o = i11;
        this.f19076p = j10;
        this.f19077q = j11;
        this.f19078r = hVarArr;
    }

    @Override // s5.h, android.os.Parcelable
    public int describeContents() {
        return 0;
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null || c.class != obj.getClass()) {
            return false;
        }
        c cVar = (c) obj;
        return this.f19074n == cVar.f19074n && this.f19075o == cVar.f19075o && this.f19076p == cVar.f19076p && this.f19077q == cVar.f19077q && u.areEqual(this.f19073m, cVar.f19073m) && Arrays.equals(this.f19078r, cVar.f19078r);
    }

    public int hashCode() {
        int i10 = (((((((527 + this.f19074n) * 31) + this.f19075o) * 31) + ((int) this.f19076p)) * 31) + ((int) this.f19077q)) * 31;
        String str = this.f19073m;
        return i10 + (str != null ? str.hashCode() : 0);
    }

    @Override // android.os.Parcelable
    public void writeToParcel(Parcel parcel, int i10) {
        parcel.writeString(this.f19073m);
        parcel.writeInt(this.f19074n);
        parcel.writeInt(this.f19075o);
        parcel.writeLong(this.f19076p);
        parcel.writeLong(this.f19077q);
        h[] hVarArr = this.f19078r;
        parcel.writeInt(hVarArr.length);
        for (h hVar : hVarArr) {
            parcel.writeParcelable(hVar, 0);
        }
    }

    public c(Parcel parcel) {
        super("CHAP");
        this.f19073m = parcel.readString();
        this.f19074n = parcel.readInt();
        this.f19075o = parcel.readInt();
        this.f19076p = parcel.readLong();
        this.f19077q = parcel.readLong();
        int i10 = parcel.readInt();
        this.f19078r = new h[i10];
        for (int i11 = 0; i11 < i10; i11++) {
            this.f19078r[i11] = (h) parcel.readParcelable(h.class.getClassLoader());
        }
    }
}
