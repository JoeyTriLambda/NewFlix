package androidx.fragment.app;

import android.annotation.SuppressLint;
import android.os.Bundle;
import android.os.Parcel;
import android.os.Parcelable;

/* compiled from: FragmentState.java */
@SuppressLint({"BanParcelableUsage"})
/* loaded from: classes.dex */
public final class d0 implements Parcelable {
    public static final Parcelable.Creator<d0> CREATOR = new a();

    /* renamed from: b, reason: collision with root package name */
    public final String f2774b;

    /* renamed from: m, reason: collision with root package name */
    public final String f2775m;

    /* renamed from: n, reason: collision with root package name */
    public final boolean f2776n;

    /* renamed from: o, reason: collision with root package name */
    public final int f2777o;

    /* renamed from: p, reason: collision with root package name */
    public final int f2778p;

    /* renamed from: q, reason: collision with root package name */
    public final String f2779q;

    /* renamed from: r, reason: collision with root package name */
    public final boolean f2780r;

    /* renamed from: s, reason: collision with root package name */
    public final boolean f2781s;

    /* renamed from: t, reason: collision with root package name */
    public final boolean f2782t;

    /* renamed from: u, reason: collision with root package name */
    public final Bundle f2783u;

    /* renamed from: v, reason: collision with root package name */
    public final boolean f2784v;

    /* renamed from: w, reason: collision with root package name */
    public final int f2785w;

    /* renamed from: x, reason: collision with root package name */
    public Bundle f2786x;

    /* compiled from: FragmentState.java */
    public class a implements Parcelable.Creator<d0> {
        /* JADX WARN: Can't rename method to resolve collision */
        @Override // android.os.Parcelable.Creator
        public d0 createFromParcel(Parcel parcel) {
            return new d0(parcel);
        }

        /* JADX WARN: Can't rename method to resolve collision */
        @Override // android.os.Parcelable.Creator
        public d0[] newArray(int i10) {
            return new d0[i10];
        }
    }

    public d0(Fragment fragment) {
        this.f2774b = fragment.getClass().getName();
        this.f2775m = fragment.f2679q;
        this.f2776n = fragment.f2687y;
        this.f2777o = fragment.H;
        this.f2778p = fragment.I;
        this.f2779q = fragment.J;
        this.f2780r = fragment.M;
        this.f2781s = fragment.f2686x;
        this.f2782t = fragment.L;
        this.f2783u = fragment.f2680r;
        this.f2784v = fragment.K;
        this.f2785w = fragment.Z.ordinal();
    }

    @Override // android.os.Parcelable
    public int describeContents() {
        return 0;
    }

    public String toString() {
        StringBuilder sbQ = ac.c.q(128, "FragmentState{");
        sbQ.append(this.f2774b);
        sbQ.append(" (");
        sbQ.append(this.f2775m);
        sbQ.append(")}:");
        if (this.f2776n) {
            sbQ.append(" fromLayout");
        }
        int i10 = this.f2778p;
        if (i10 != 0) {
            sbQ.append(" id=0x");
            sbQ.append(Integer.toHexString(i10));
        }
        String str = this.f2779q;
        if (str != null && !str.isEmpty()) {
            sbQ.append(" tag=");
            sbQ.append(str);
        }
        if (this.f2780r) {
            sbQ.append(" retainInstance");
        }
        if (this.f2781s) {
            sbQ.append(" removing");
        }
        if (this.f2782t) {
            sbQ.append(" detached");
        }
        if (this.f2784v) {
            sbQ.append(" hidden");
        }
        return sbQ.toString();
    }

    @Override // android.os.Parcelable
    public void writeToParcel(Parcel parcel, int i10) {
        parcel.writeString(this.f2774b);
        parcel.writeString(this.f2775m);
        parcel.writeInt(this.f2776n ? 1 : 0);
        parcel.writeInt(this.f2777o);
        parcel.writeInt(this.f2778p);
        parcel.writeString(this.f2779q);
        parcel.writeInt(this.f2780r ? 1 : 0);
        parcel.writeInt(this.f2781s ? 1 : 0);
        parcel.writeInt(this.f2782t ? 1 : 0);
        parcel.writeBundle(this.f2783u);
        parcel.writeInt(this.f2784v ? 1 : 0);
        parcel.writeBundle(this.f2786x);
        parcel.writeInt(this.f2785w);
    }

    public d0(Parcel parcel) {
        this.f2774b = parcel.readString();
        this.f2775m = parcel.readString();
        this.f2776n = parcel.readInt() != 0;
        this.f2777o = parcel.readInt();
        this.f2778p = parcel.readInt();
        this.f2779q = parcel.readString();
        this.f2780r = parcel.readInt() != 0;
        this.f2781s = parcel.readInt() != 0;
        this.f2782t = parcel.readInt() != 0;
        this.f2783u = parcel.readBundle();
        this.f2784v = parcel.readInt() != 0;
        this.f2786x = parcel.readBundle();
        this.f2785w = parcel.readInt();
    }
}
