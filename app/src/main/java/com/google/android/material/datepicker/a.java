package com.google.android.material.datepicker;

import android.os.Bundle;
import android.os.Parcel;
import android.os.Parcelable;
import java.util.Arrays;
import java.util.GregorianCalendar;
import java.util.Objects;

/* compiled from: CalendarConstraints.java */
/* loaded from: classes.dex */
public final class a implements Parcelable {
    public static final Parcelable.Creator<a> CREATOR = new C0086a();

    /* renamed from: b, reason: collision with root package name */
    public final t f9022b;

    /* renamed from: m, reason: collision with root package name */
    public final t f9023m;

    /* renamed from: n, reason: collision with root package name */
    public final c f9024n;

    /* renamed from: o, reason: collision with root package name */
    public final t f9025o;

    /* renamed from: p, reason: collision with root package name */
    public final int f9026p;

    /* renamed from: q, reason: collision with root package name */
    public final int f9027q;

    /* renamed from: r, reason: collision with root package name */
    public final int f9028r;

    /* compiled from: CalendarConstraints.java */
    /* renamed from: com.google.android.material.datepicker.a$a, reason: collision with other inner class name */
    public class C0086a implements Parcelable.Creator<a> {
        /* JADX WARN: Can't rename method to resolve collision */
        @Override // android.os.Parcelable.Creator
        public a createFromParcel(Parcel parcel) {
            return new a((t) parcel.readParcelable(t.class.getClassLoader()), (t) parcel.readParcelable(t.class.getClassLoader()), (c) parcel.readParcelable(c.class.getClassLoader()), (t) parcel.readParcelable(t.class.getClassLoader()), parcel.readInt());
        }

        /* JADX WARN: Can't rename method to resolve collision */
        @Override // android.os.Parcelable.Creator
        public a[] newArray(int i10) {
            return new a[i10];
        }
    }

    /* compiled from: CalendarConstraints.java */
    public static final class b {

        /* renamed from: f, reason: collision with root package name */
        public static final long f9029f = a0.a(t.a(1900, 0).f9093q);

        /* renamed from: g, reason: collision with root package name */
        public static final long f9030g = a0.a(t.a(2100, 11).f9093q);

        /* renamed from: a, reason: collision with root package name */
        public final long f9031a;

        /* renamed from: b, reason: collision with root package name */
        public final long f9032b;

        /* renamed from: c, reason: collision with root package name */
        public Long f9033c;

        /* renamed from: d, reason: collision with root package name */
        public final int f9034d;

        /* renamed from: e, reason: collision with root package name */
        public final c f9035e;

        public b(a aVar) {
            this.f9031a = f9029f;
            this.f9032b = f9030g;
            this.f9035e = e.from(Long.MIN_VALUE);
            this.f9031a = aVar.f9022b.f9093q;
            this.f9032b = aVar.f9023m.f9093q;
            this.f9033c = Long.valueOf(aVar.f9025o.f9093q);
            this.f9034d = aVar.f9026p;
            this.f9035e = aVar.f9024n;
        }

        public a build() {
            Bundle bundle = new Bundle();
            bundle.putParcelable("DEEP_COPY_VALIDATOR_KEY", this.f9035e);
            t tVarB = t.b(this.f9031a);
            t tVarB2 = t.b(this.f9032b);
            c cVar = (c) bundle.getParcelable("DEEP_COPY_VALIDATOR_KEY");
            Long l10 = this.f9033c;
            return new a(tVarB, tVarB2, cVar, l10 == null ? null : t.b(l10.longValue()), this.f9034d);
        }

        public b setOpenAt(long j10) {
            this.f9033c = Long.valueOf(j10);
            return this;
        }
    }

    /* compiled from: CalendarConstraints.java */
    public interface c extends Parcelable {
        boolean isValid(long j10);
    }

    public a(t tVar, t tVar2, c cVar, t tVar3, int i10) {
        Objects.requireNonNull(tVar, "start cannot be null");
        Objects.requireNonNull(tVar2, "end cannot be null");
        Objects.requireNonNull(cVar, "validator cannot be null");
        this.f9022b = tVar;
        this.f9023m = tVar2;
        this.f9025o = tVar3;
        this.f9026p = i10;
        this.f9024n = cVar;
        if (tVar3 != null && tVar.compareTo(tVar3) > 0) {
            throw new IllegalArgumentException("start Month cannot be after current Month");
        }
        if (tVar3 != null && tVar3.compareTo(tVar2) > 0) {
            throw new IllegalArgumentException("current Month cannot be after end Month");
        }
        if (i10 < 0 || i10 > a0.e(null).getMaximum(7)) {
            throw new IllegalArgumentException("firstDayOfWeek is not valid");
        }
        if (!(tVar.f9088b instanceof GregorianCalendar)) {
            throw new IllegalArgumentException("Only Gregorian calendars are supported.");
        }
        int i11 = tVar2.f9090n;
        int i12 = tVar.f9090n;
        this.f9028r = (tVar2.f9089m - tVar.f9089m) + ((i11 - i12) * 12) + 1;
        this.f9027q = (i11 - i12) + 1;
    }

    @Override // android.os.Parcelable
    public int describeContents() {
        return 0;
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof a)) {
            return false;
        }
        a aVar = (a) obj;
        return this.f9022b.equals(aVar.f9022b) && this.f9023m.equals(aVar.f9023m) && w0.c.equals(this.f9025o, aVar.f9025o) && this.f9026p == aVar.f9026p && this.f9024n.equals(aVar.f9024n);
    }

    public c getDateValidator() {
        return this.f9024n;
    }

    public int hashCode() {
        return Arrays.hashCode(new Object[]{this.f9022b, this.f9023m, this.f9025o, Integer.valueOf(this.f9026p), this.f9024n});
    }

    @Override // android.os.Parcelable
    public void writeToParcel(Parcel parcel, int i10) {
        parcel.writeParcelable(this.f9022b, 0);
        parcel.writeParcelable(this.f9023m, 0);
        parcel.writeParcelable(this.f9025o, 0);
        parcel.writeParcelable(this.f9024n, 0);
        parcel.writeInt(this.f9026p);
    }
}
