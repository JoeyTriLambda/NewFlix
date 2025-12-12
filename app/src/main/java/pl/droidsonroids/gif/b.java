package pl.droidsonroids.gif;

import android.graphics.drawable.Drawable;
import android.os.Parcel;
import android.os.Parcelable;
import android.view.View;

/* compiled from: GifViewSavedState.java */
/* loaded from: classes2.dex */
public final class b extends View.BaseSavedState {
    public static final Parcelable.Creator<b> CREATOR = new a();

    /* renamed from: b, reason: collision with root package name */
    public final long[][] f17767b;

    /* compiled from: GifViewSavedState.java */
    public class a implements Parcelable.Creator<b> {
        @Override // android.os.Parcelable.Creator
        public b createFromParcel(Parcel parcel) {
            return new b(parcel);
        }

        @Override // android.os.Parcelable.Creator
        public b[] newArray(int i10) {
            return new b[i10];
        }
    }

    public b(Parcelable parcelable, Drawable... drawableArr) {
        super(parcelable);
        this.f17767b = new long[drawableArr.length][];
        for (int i10 = 0; i10 < drawableArr.length; i10++) {
            Drawable drawable = drawableArr[i10];
            if (drawable instanceof pl.droidsonroids.gif.a) {
                this.f17767b[i10] = ((pl.droidsonroids.gif.a) drawable).f17755r.i();
            } else {
                this.f17767b[i10] = null;
            }
        }
    }

    @Override // android.view.View.BaseSavedState, android.view.AbsSavedState, android.os.Parcelable
    public void writeToParcel(Parcel parcel, int i10) {
        super.writeToParcel(parcel, i10);
        long[][] jArr = this.f17767b;
        parcel.writeInt(jArr.length);
        for (long[] jArr2 : jArr) {
            parcel.writeLongArray(jArr2);
        }
    }

    public b(Parcel parcel) {
        super(parcel);
        this.f17767b = new long[parcel.readInt()][];
        int i10 = 0;
        while (true) {
            long[][] jArr = this.f17767b;
            if (i10 >= jArr.length) {
                return;
            }
            jArr[i10] = parcel.createLongArray();
            i10++;
        }
    }
}
