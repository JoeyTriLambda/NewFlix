package androidx.fragment.app;

import android.annotation.SuppressLint;
import android.os.Parcel;
import android.os.Parcelable;
import android.text.TextUtils;
import android.util.Log;
import androidx.fragment.app.g0;
import androidx.lifecycle.Lifecycle;
import java.util.ArrayList;

/* compiled from: BackStackRecordState.java */
@SuppressLint({"BanParcelableUsage"})
/* loaded from: classes.dex */
public final class b implements Parcelable {
    public static final Parcelable.Creator<b> CREATOR = new a();

    /* renamed from: b, reason: collision with root package name */
    public final int[] f2748b;

    /* renamed from: m, reason: collision with root package name */
    public final ArrayList<String> f2749m;

    /* renamed from: n, reason: collision with root package name */
    public final int[] f2750n;

    /* renamed from: o, reason: collision with root package name */
    public final int[] f2751o;

    /* renamed from: p, reason: collision with root package name */
    public final int f2752p;

    /* renamed from: q, reason: collision with root package name */
    public final String f2753q;

    /* renamed from: r, reason: collision with root package name */
    public final int f2754r;

    /* renamed from: s, reason: collision with root package name */
    public final int f2755s;

    /* renamed from: t, reason: collision with root package name */
    public final CharSequence f2756t;

    /* renamed from: u, reason: collision with root package name */
    public final int f2757u;

    /* renamed from: v, reason: collision with root package name */
    public final CharSequence f2758v;

    /* renamed from: w, reason: collision with root package name */
    public final ArrayList<String> f2759w;

    /* renamed from: x, reason: collision with root package name */
    public final ArrayList<String> f2760x;

    /* renamed from: y, reason: collision with root package name */
    public final boolean f2761y;

    /* compiled from: BackStackRecordState.java */
    public class a implements Parcelable.Creator<b> {
        /* JADX WARN: Can't rename method to resolve collision */
        @Override // android.os.Parcelable.Creator
        public b createFromParcel(Parcel parcel) {
            return new b(parcel);
        }

        /* JADX WARN: Can't rename method to resolve collision */
        @Override // android.os.Parcelable.Creator
        public b[] newArray(int i10) {
            return new b[i10];
        }
    }

    public b(androidx.fragment.app.a aVar) {
        int size = aVar.f2809a.size();
        this.f2748b = new int[size * 6];
        if (!aVar.f2815g) {
            throw new IllegalStateException("Not on back stack");
        }
        this.f2749m = new ArrayList<>(size);
        this.f2750n = new int[size];
        this.f2751o = new int[size];
        int i10 = 0;
        int i11 = 0;
        while (i10 < size) {
            g0.a aVar2 = aVar.f2809a.get(i10);
            int i12 = i11 + 1;
            this.f2748b[i11] = aVar2.f2824a;
            ArrayList<String> arrayList = this.f2749m;
            Fragment fragment = aVar2.f2825b;
            arrayList.add(fragment != null ? fragment.f2679q : null);
            int[] iArr = this.f2748b;
            int i13 = i12 + 1;
            iArr[i12] = aVar2.f2826c ? 1 : 0;
            int i14 = i13 + 1;
            iArr[i13] = aVar2.f2827d;
            int i15 = i14 + 1;
            iArr[i14] = aVar2.f2828e;
            int i16 = i15 + 1;
            iArr[i15] = aVar2.f2829f;
            iArr[i16] = aVar2.f2830g;
            this.f2750n[i10] = aVar2.f2831h.ordinal();
            this.f2751o[i10] = aVar2.f2832i.ordinal();
            i10++;
            i11 = i16 + 1;
        }
        this.f2752p = aVar.f2814f;
        this.f2753q = aVar.f2816h;
        this.f2754r = aVar.f2739r;
        this.f2755s = aVar.f2817i;
        this.f2756t = aVar.f2818j;
        this.f2757u = aVar.f2819k;
        this.f2758v = aVar.f2820l;
        this.f2759w = aVar.f2821m;
        this.f2760x = aVar.f2822n;
        this.f2761y = aVar.f2823o;
    }

    @Override // android.os.Parcelable
    public int describeContents() {
        return 0;
    }

    public androidx.fragment.app.a instantiate(y yVar) {
        androidx.fragment.app.a aVar = new androidx.fragment.app.a(yVar);
        int i10 = 0;
        int i11 = 0;
        int i12 = 0;
        while (true) {
            int[] iArr = this.f2748b;
            boolean z10 = true;
            if (i11 >= iArr.length) {
                break;
            }
            g0.a aVar2 = new g0.a();
            int i13 = i11 + 1;
            aVar2.f2824a = iArr[i11];
            if (y.isLoggingEnabled(2)) {
                Log.v("FragmentManager", "Instantiate " + aVar + " op #" + i12 + " base fragment #" + iArr[i13]);
            }
            aVar2.f2831h = Lifecycle.State.values()[this.f2750n[i12]];
            aVar2.f2832i = Lifecycle.State.values()[this.f2751o[i12]];
            int i14 = i13 + 1;
            if (iArr[i13] == 0) {
                z10 = false;
            }
            aVar2.f2826c = z10;
            int i15 = i14 + 1;
            int i16 = iArr[i14];
            aVar2.f2827d = i16;
            int i17 = i15 + 1;
            int i18 = iArr[i15];
            aVar2.f2828e = i18;
            int i19 = i17 + 1;
            int i20 = iArr[i17];
            aVar2.f2829f = i20;
            int i21 = iArr[i19];
            aVar2.f2830g = i21;
            aVar.f2810b = i16;
            aVar.f2811c = i18;
            aVar.f2812d = i20;
            aVar.f2813e = i21;
            aVar.a(aVar2);
            i12++;
            i11 = i19 + 1;
        }
        aVar.f2814f = this.f2752p;
        aVar.f2816h = this.f2753q;
        aVar.f2815g = true;
        aVar.f2817i = this.f2755s;
        aVar.f2818j = this.f2756t;
        aVar.f2819k = this.f2757u;
        aVar.f2820l = this.f2758v;
        aVar.f2821m = this.f2759w;
        aVar.f2822n = this.f2760x;
        aVar.f2823o = this.f2761y;
        aVar.f2739r = this.f2754r;
        while (true) {
            ArrayList<String> arrayList = this.f2749m;
            if (i10 >= arrayList.size()) {
                aVar.c(1);
                return aVar;
            }
            String str = arrayList.get(i10);
            if (str != null) {
                aVar.f2809a.get(i10).f2825b = yVar.z(str);
            }
            i10++;
        }
    }

    @Override // android.os.Parcelable
    public void writeToParcel(Parcel parcel, int i10) {
        parcel.writeIntArray(this.f2748b);
        parcel.writeStringList(this.f2749m);
        parcel.writeIntArray(this.f2750n);
        parcel.writeIntArray(this.f2751o);
        parcel.writeInt(this.f2752p);
        parcel.writeString(this.f2753q);
        parcel.writeInt(this.f2754r);
        parcel.writeInt(this.f2755s);
        TextUtils.writeToParcel(this.f2756t, parcel, 0);
        parcel.writeInt(this.f2757u);
        TextUtils.writeToParcel(this.f2758v, parcel, 0);
        parcel.writeStringList(this.f2759w);
        parcel.writeStringList(this.f2760x);
        parcel.writeInt(this.f2761y ? 1 : 0);
    }

    public b(Parcel parcel) {
        this.f2748b = parcel.createIntArray();
        this.f2749m = parcel.createStringArrayList();
        this.f2750n = parcel.createIntArray();
        this.f2751o = parcel.createIntArray();
        this.f2752p = parcel.readInt();
        this.f2753q = parcel.readString();
        this.f2754r = parcel.readInt();
        this.f2755s = parcel.readInt();
        this.f2756t = (CharSequence) TextUtils.CHAR_SEQUENCE_CREATOR.createFromParcel(parcel);
        this.f2757u = parcel.readInt();
        this.f2758v = (CharSequence) TextUtils.CHAR_SEQUENCE_CREATOR.createFromParcel(parcel);
        this.f2759w = parcel.createStringArrayList();
        this.f2760x = parcel.createStringArrayList();
        this.f2761y = parcel.readInt() != 0;
    }
}
