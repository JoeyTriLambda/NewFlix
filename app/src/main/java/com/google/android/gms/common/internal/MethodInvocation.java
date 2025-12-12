package com.google.android.gms.common.internal;

import android.os.Parcel;
import android.os.Parcelable;
import com.google.android.gms.common.annotation.KeepForSdk;
import com.google.android.gms.common.internal.safeparcel.AbstractSafeParcelable;
import com.google.android.gms.common.internal.safeparcel.SafeParcelWriter;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable;

/* compiled from: com.google.android.gms:play-services-base@@18.0.1 */
@KeepForSdk
@SafeParcelable.Class
/* loaded from: classes.dex */
public class MethodInvocation extends AbstractSafeParcelable {
    public static final Parcelable.Creator<MethodInvocation> CREATOR = new zan();

    /* renamed from: b, reason: collision with root package name */
    @SafeParcelable.Field
    public final int f7344b;

    /* renamed from: m, reason: collision with root package name */
    @SafeParcelable.Field
    public final int f7345m;

    /* renamed from: n, reason: collision with root package name */
    @SafeParcelable.Field
    public final int f7346n;

    /* renamed from: o, reason: collision with root package name */
    @SafeParcelable.Field
    public final long f7347o;

    /* renamed from: p, reason: collision with root package name */
    @SafeParcelable.Field
    public final long f7348p;

    /* renamed from: q, reason: collision with root package name */
    @SafeParcelable.Field
    public final String f7349q;

    /* renamed from: r, reason: collision with root package name */
    @SafeParcelable.Field
    public final String f7350r;

    /* renamed from: s, reason: collision with root package name */
    @SafeParcelable.Field
    public final int f7351s;

    /* renamed from: t, reason: collision with root package name */
    @SafeParcelable.Field
    public final int f7352t;

    @SafeParcelable.Constructor
    public MethodInvocation(@SafeParcelable.Param int i10, @SafeParcelable.Param int i11, @SafeParcelable.Param int i12, @SafeParcelable.Param long j10, @SafeParcelable.Param long j11, @SafeParcelable.Param String str, @SafeParcelable.Param String str2, @SafeParcelable.Param int i13, @SafeParcelable.Param int i14) {
        this.f7344b = i10;
        this.f7345m = i11;
        this.f7346n = i12;
        this.f7347o = j10;
        this.f7348p = j11;
        this.f7349q = str;
        this.f7350r = str2;
        this.f7351s = i13;
        this.f7352t = i14;
    }

    @Override // android.os.Parcelable
    public final void writeToParcel(Parcel parcel, int i10) {
        int iBeginObjectHeader = SafeParcelWriter.beginObjectHeader(parcel);
        SafeParcelWriter.writeInt(parcel, 1, this.f7344b);
        SafeParcelWriter.writeInt(parcel, 2, this.f7345m);
        SafeParcelWriter.writeInt(parcel, 3, this.f7346n);
        SafeParcelWriter.writeLong(parcel, 4, this.f7347o);
        SafeParcelWriter.writeLong(parcel, 5, this.f7348p);
        SafeParcelWriter.writeString(parcel, 6, this.f7349q, false);
        SafeParcelWriter.writeString(parcel, 7, this.f7350r, false);
        SafeParcelWriter.writeInt(parcel, 8, this.f7351s);
        SafeParcelWriter.writeInt(parcel, 9, this.f7352t);
        SafeParcelWriter.finishObjectHeader(parcel, iBeginObjectHeader);
    }
}
