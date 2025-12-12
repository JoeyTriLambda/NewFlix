package com.google.android.material.datepicker;

import android.os.Build;
import android.os.Parcel;
import android.os.Parcelable;
import android.text.format.DateUtils;
import java.util.Arrays;
import java.util.Calendar;
import java.util.Date;
import java.util.Locale;

/* compiled from: Month.java */
/* loaded from: classes.dex */
public final class t implements Comparable<t>, Parcelable {
    public static final Parcelable.Creator<t> CREATOR = new a();

    /* renamed from: b, reason: collision with root package name */
    public final Calendar f9088b;

    /* renamed from: m, reason: collision with root package name */
    public final int f9089m;

    /* renamed from: n, reason: collision with root package name */
    public final int f9090n;

    /* renamed from: o, reason: collision with root package name */
    public final int f9091o;

    /* renamed from: p, reason: collision with root package name */
    public final int f9092p;

    /* renamed from: q, reason: collision with root package name */
    public final long f9093q;

    /* renamed from: r, reason: collision with root package name */
    public String f9094r;

    /* compiled from: Month.java */
    public class a implements Parcelable.Creator<t> {
        /* JADX WARN: Can't rename method to resolve collision */
        @Override // android.os.Parcelable.Creator
        public t createFromParcel(Parcel parcel) {
            return t.a(parcel.readInt(), parcel.readInt());
        }

        /* JADX WARN: Can't rename method to resolve collision */
        @Override // android.os.Parcelable.Creator
        public t[] newArray(int i10) {
            return new t[i10];
        }
    }

    public t(Calendar calendar) {
        calendar.set(5, 1);
        Calendar calendarC = a0.c(calendar);
        this.f9088b = calendarC;
        this.f9089m = calendarC.get(2);
        this.f9090n = calendarC.get(1);
        this.f9091o = calendarC.getMaximum(7);
        this.f9092p = calendarC.getActualMaximum(5);
        this.f9093q = calendarC.getTimeInMillis();
    }

    public static t a(int i10, int i11) {
        Calendar calendarE = a0.e(null);
        calendarE.set(1, i10);
        calendarE.set(2, i11);
        return new t(calendarE);
    }

    public static t b(long j10) {
        Calendar calendarE = a0.e(null);
        calendarE.setTimeInMillis(j10);
        return new t(calendarE);
    }

    public final String c() {
        if (this.f9094r == null) {
            long timeInMillis = this.f9088b.getTimeInMillis();
            this.f9094r = Build.VERSION.SDK_INT >= 24 ? a0.b("yMMMM", Locale.getDefault()).format(new Date(timeInMillis)) : DateUtils.formatDateTime(null, timeInMillis, 8228);
        }
        return this.f9094r;
    }

    @Override // android.os.Parcelable
    public int describeContents() {
        return 0;
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof t)) {
            return false;
        }
        t tVar = (t) obj;
        return this.f9089m == tVar.f9089m && this.f9090n == tVar.f9090n;
    }

    public int hashCode() {
        return Arrays.hashCode(new Object[]{Integer.valueOf(this.f9089m), Integer.valueOf(this.f9090n)});
    }

    @Override // android.os.Parcelable
    public void writeToParcel(Parcel parcel, int i10) {
        parcel.writeInt(this.f9090n);
        parcel.writeInt(this.f9089m);
    }

    @Override // java.lang.Comparable
    public int compareTo(t tVar) {
        return this.f9088b.compareTo(tVar.f9088b);
    }
}
