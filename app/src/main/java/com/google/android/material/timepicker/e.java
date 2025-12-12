package com.google.android.material.timepicker;

import android.content.res.Resources;
import android.os.Parcel;
import android.os.Parcelable;
import java.util.Arrays;

/* compiled from: TimeModel.java */
/* loaded from: classes.dex */
public final class e implements Parcelable {
    public static final Parcelable.Creator<e> CREATOR = new a();

    /* renamed from: b, reason: collision with root package name */
    public final int f9503b;

    /* renamed from: m, reason: collision with root package name */
    public final int f9504m;

    /* renamed from: n, reason: collision with root package name */
    public final int f9505n;

    /* renamed from: o, reason: collision with root package name */
    public final int f9506o;

    /* compiled from: TimeModel.java */
    public class a implements Parcelable.Creator<e> {
        /* JADX WARN: Can't rename method to resolve collision */
        @Override // android.os.Parcelable.Creator
        public e createFromParcel(Parcel parcel) {
            return new e(parcel);
        }

        /* JADX WARN: Can't rename method to resolve collision */
        @Override // android.os.Parcelable.Creator
        public e[] newArray(int i10) {
            return new e[i10];
        }
    }

    public e() {
        this(0);
    }

    public static String formatText(Resources resources, CharSequence charSequence) {
        return formatText(resources, charSequence, "%02d");
    }

    @Override // android.os.Parcelable
    public int describeContents() {
        return 0;
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof e)) {
            return false;
        }
        e eVar = (e) obj;
        return this.f9504m == eVar.f9504m && this.f9505n == eVar.f9505n && this.f9503b == eVar.f9503b && this.f9506o == eVar.f9506o;
    }

    public int hashCode() {
        return Arrays.hashCode(new Object[]{Integer.valueOf(this.f9503b), Integer.valueOf(this.f9504m), Integer.valueOf(this.f9505n), Integer.valueOf(this.f9506o)});
    }

    @Override // android.os.Parcelable
    public void writeToParcel(Parcel parcel, int i10) {
        parcel.writeInt(this.f9504m);
        parcel.writeInt(this.f9505n);
        parcel.writeInt(this.f9506o);
        parcel.writeInt(this.f9503b);
    }

    public e(int i10) {
        this(0, 0, 10, i10);
    }

    public static String formatText(Resources resources, CharSequence charSequence, String str) {
        try {
            return String.format(resources.getConfiguration().locale, str, Integer.valueOf(Integer.parseInt(String.valueOf(charSequence))));
        } catch (NumberFormatException unused) {
            return null;
        }
    }

    public e(int i10, int i11, int i12, int i13) {
        this.f9504m = i10;
        this.f9505n = i11;
        this.f9506o = i12;
        this.f9503b = i13;
        new b(59);
        new b(i13 == 1 ? 23 : 12);
    }

    public e(Parcel parcel) {
        this(parcel.readInt(), parcel.readInt(), parcel.readInt(), parcel.readInt());
    }
}
