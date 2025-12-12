package com.google.android.material.datepicker;

import android.os.Parcel;
import android.os.Parcelable;
import com.google.android.material.datepicker.a;
import java.util.Arrays;

/* compiled from: DateValidatorPointForward.java */
/* loaded from: classes.dex */
public final class e implements a.c {
    public static final Parcelable.Creator<e> CREATOR = new a();

    /* renamed from: b, reason: collision with root package name */
    public final long f9055b;

    /* compiled from: DateValidatorPointForward.java */
    public class a implements Parcelable.Creator<e> {
        /* JADX WARN: Can't rename method to resolve collision */
        @Override // android.os.Parcelable.Creator
        public e createFromParcel(Parcel parcel) {
            return new e(parcel.readLong());
        }

        /* JADX WARN: Can't rename method to resolve collision */
        @Override // android.os.Parcelable.Creator
        public e[] newArray(int i10) {
            return new e[i10];
        }
    }

    public e(long j10) {
        this.f9055b = j10;
    }

    public static e from(long j10) {
        return new e(j10);
    }

    @Override // android.os.Parcelable
    public int describeContents() {
        return 0;
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        return (obj instanceof e) && this.f9055b == ((e) obj).f9055b;
    }

    public int hashCode() {
        return Arrays.hashCode(new Object[]{Long.valueOf(this.f9055b)});
    }

    @Override // com.google.android.material.datepicker.a.c
    public boolean isValid(long j10) {
        return j10 >= this.f9055b;
    }

    @Override // android.os.Parcelable
    public void writeToParcel(Parcel parcel, int i10) {
        parcel.writeLong(this.f9055b);
    }
}
