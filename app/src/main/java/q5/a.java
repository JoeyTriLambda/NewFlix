package q5;

import android.os.Parcel;
import android.os.Parcelable;
import java.util.Arrays;
import java.util.List;

/* compiled from: Metadata.java */
/* loaded from: classes.dex */
public final class a implements Parcelable {
    public static final Parcelable.Creator<a> CREATOR = new C0229a();

    /* renamed from: b, reason: collision with root package name */
    public final b[] f17886b;

    /* compiled from: Metadata.java */
    /* renamed from: q5.a$a, reason: collision with other inner class name */
    public static class C0229a implements Parcelable.Creator<a> {
        @Override // android.os.Parcelable.Creator
        public a[] newArray(int i10) {
            return new a[0];
        }

        @Override // android.os.Parcelable.Creator
        public a createFromParcel(Parcel parcel) {
            return new a(parcel);
        }
    }

    /* compiled from: Metadata.java */
    public interface b extends Parcelable {
    }

    public a(b... bVarArr) {
        this.f17886b = bVarArr == null ? new b[0] : bVarArr;
    }

    @Override // android.os.Parcelable
    public int describeContents() {
        return 0;
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null || a.class != obj.getClass()) {
            return false;
        }
        return Arrays.equals(this.f17886b, ((a) obj).f17886b);
    }

    public b get(int i10) {
        return this.f17886b[i10];
    }

    public int hashCode() {
        return Arrays.hashCode(this.f17886b);
    }

    public int length() {
        return this.f17886b.length;
    }

    @Override // android.os.Parcelable
    public void writeToParcel(Parcel parcel, int i10) {
        b[] bVarArr = this.f17886b;
        parcel.writeInt(bVarArr.length);
        for (b bVar : bVarArr) {
            parcel.writeParcelable(bVar, 0);
        }
    }

    public a(List<? extends b> list) {
        if (list != null) {
            b[] bVarArr = new b[list.size()];
            this.f17886b = bVarArr;
            list.toArray(bVarArr);
            return;
        }
        this.f17886b = new b[0];
    }

    public a(Parcel parcel) {
        this.f17886b = new b[parcel.readInt()];
        int i10 = 0;
        while (true) {
            b[] bVarArr = this.f17886b;
            if (i10 >= bVarArr.length) {
                return;
            }
            bVarArr[i10] = (b) parcel.readParcelable(b.class.getClassLoader());
            i10++;
        }
    }
}
