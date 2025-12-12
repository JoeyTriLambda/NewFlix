package androidx.fragment.app;

import android.annotation.SuppressLint;
import android.os.Parcel;
import android.os.Parcelable;
import androidx.fragment.app.y;
import java.util.ArrayList;

/* compiled from: FragmentManagerState.java */
@SuppressLint({"BanParcelableUsage"})
/* loaded from: classes.dex */
public final class a0 implements Parcelable {
    public static final Parcelable.Creator<a0> CREATOR = new a();

    /* renamed from: b, reason: collision with root package name */
    public ArrayList<String> f2740b;

    /* renamed from: m, reason: collision with root package name */
    public ArrayList<String> f2741m;

    /* renamed from: n, reason: collision with root package name */
    public b[] f2742n;

    /* renamed from: o, reason: collision with root package name */
    public int f2743o;

    /* renamed from: p, reason: collision with root package name */
    public String f2744p;

    /* renamed from: q, reason: collision with root package name */
    public final ArrayList<String> f2745q;

    /* renamed from: r, reason: collision with root package name */
    public final ArrayList<c> f2746r;

    /* renamed from: s, reason: collision with root package name */
    public ArrayList<y.k> f2747s;

    /* compiled from: FragmentManagerState.java */
    public class a implements Parcelable.Creator<a0> {
        /* JADX WARN: Can't rename method to resolve collision */
        @Override // android.os.Parcelable.Creator
        public a0 createFromParcel(Parcel parcel) {
            return new a0(parcel);
        }

        /* JADX WARN: Can't rename method to resolve collision */
        @Override // android.os.Parcelable.Creator
        public a0[] newArray(int i10) {
            return new a0[i10];
        }
    }

    public a0() {
        this.f2744p = null;
        this.f2745q = new ArrayList<>();
        this.f2746r = new ArrayList<>();
    }

    @Override // android.os.Parcelable
    public int describeContents() {
        return 0;
    }

    @Override // android.os.Parcelable
    public void writeToParcel(Parcel parcel, int i10) {
        parcel.writeStringList(this.f2740b);
        parcel.writeStringList(this.f2741m);
        parcel.writeTypedArray(this.f2742n, i10);
        parcel.writeInt(this.f2743o);
        parcel.writeString(this.f2744p);
        parcel.writeStringList(this.f2745q);
        parcel.writeTypedList(this.f2746r);
        parcel.writeTypedList(this.f2747s);
    }

    public a0(Parcel parcel) {
        this.f2744p = null;
        this.f2745q = new ArrayList<>();
        this.f2746r = new ArrayList<>();
        this.f2740b = parcel.createStringArrayList();
        this.f2741m = parcel.createStringArrayList();
        this.f2742n = (b[]) parcel.createTypedArray(b.CREATOR);
        this.f2743o = parcel.readInt();
        this.f2744p = parcel.readString();
        this.f2745q = parcel.createStringArrayList();
        this.f2746r = parcel.createTypedArrayList(c.CREATOR);
        this.f2747s = parcel.createTypedArrayList(y.k.CREATOR);
    }
}
