package com.google.android.gms.measurement.internal;

import android.os.Parcel;
import android.os.Parcelable;
import android.text.TextUtils;
import com.google.android.gms.common.internal.Preconditions;
import com.google.android.gms.common.internal.safeparcel.AbstractSafeParcelable;
import com.google.android.gms.common.internal.safeparcel.SafeParcelWriter;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable;
import java.util.ArrayList;
import java.util.List;

/* compiled from: com.google.android.gms:play-services-measurement-impl@@21.6.1 */
@SafeParcelable.Class
@SafeParcelable.Reserved
/* loaded from: classes.dex */
public final class zzn extends AbstractSafeParcelable {
    public static final Parcelable.Creator<zzn> CREATOR = new zzp();

    @SafeParcelable.Field
    public final boolean A;

    @SafeParcelable.Field
    public final String B;

    @SafeParcelable.Field
    public final Boolean C;

    @SafeParcelable.Field
    public final long D;

    @SafeParcelable.Field
    public final List<String> E;

    @SafeParcelable.Field
    public final String F;

    @SafeParcelable.Field
    public final String G;

    @SafeParcelable.Field
    public final String H;

    @SafeParcelable.Field
    public final String I;

    @SafeParcelable.Field
    public final boolean J;

    @SafeParcelable.Field
    public final long K;

    @SafeParcelable.Field
    public final int L;

    @SafeParcelable.Field
    public final String M;

    @SafeParcelable.Field
    public final int N;

    @SafeParcelable.Field
    public final long O;

    @SafeParcelable.Field
    public final String P;

    @SafeParcelable.Field
    public final String Q;

    /* renamed from: b, reason: collision with root package name */
    @SafeParcelable.Field
    public final String f8526b;

    /* renamed from: m, reason: collision with root package name */
    @SafeParcelable.Field
    public final String f8527m;

    /* renamed from: n, reason: collision with root package name */
    @SafeParcelable.Field
    public final String f8528n;

    /* renamed from: o, reason: collision with root package name */
    @SafeParcelable.Field
    public final String f8529o;

    /* renamed from: p, reason: collision with root package name */
    @SafeParcelable.Field
    public final long f8530p;

    /* renamed from: q, reason: collision with root package name */
    @SafeParcelable.Field
    public final long f8531q;

    /* renamed from: r, reason: collision with root package name */
    @SafeParcelable.Field
    public final String f8532r;

    /* renamed from: s, reason: collision with root package name */
    @SafeParcelable.Field
    public final boolean f8533s;

    /* renamed from: t, reason: collision with root package name */
    @SafeParcelable.Field
    public final boolean f8534t;

    /* renamed from: u, reason: collision with root package name */
    @SafeParcelable.Field
    public final long f8535u;

    /* renamed from: v, reason: collision with root package name */
    @SafeParcelable.Field
    public final String f8536v;

    /* renamed from: w, reason: collision with root package name */
    @SafeParcelable.Field
    @Deprecated
    public final long f8537w;

    /* renamed from: x, reason: collision with root package name */
    @SafeParcelable.Field
    public final long f8538x;

    /* renamed from: y, reason: collision with root package name */
    @SafeParcelable.Field
    public final int f8539y;

    /* renamed from: z, reason: collision with root package name */
    @SafeParcelable.Field
    public final boolean f8540z;

    public zzn(String str, String str2, String str3, long j10, String str4, long j11, long j12, String str5, boolean z10, boolean z11, String str6, long j13, long j14, int i10, boolean z12, boolean z13, String str7, Boolean bool, long j15, List list, String str8, String str9, String str10, boolean z14, long j16, int i11, String str11, int i12, long j17, String str12, String str13) {
        Preconditions.checkNotEmpty(str);
        this.f8526b = str;
        this.f8527m = TextUtils.isEmpty(str2) ? null : str2;
        this.f8528n = str3;
        this.f8535u = j10;
        this.f8529o = str4;
        this.f8530p = j11;
        this.f8531q = j12;
        this.f8532r = str5;
        this.f8533s = z10;
        this.f8534t = z11;
        this.f8536v = str6;
        this.f8537w = j13;
        this.f8538x = j14;
        this.f8539y = i10;
        this.f8540z = z12;
        this.A = z13;
        this.B = str7;
        this.C = bool;
        this.D = j15;
        this.E = list;
        this.F = null;
        this.G = str8;
        this.H = str9;
        this.I = str10;
        this.J = z14;
        this.K = j16;
        this.L = i11;
        this.M = str11;
        this.N = i12;
        this.O = j17;
        this.P = str12;
        this.Q = str13;
    }

    @Override // android.os.Parcelable
    public final void writeToParcel(Parcel parcel, int i10) {
        int iBeginObjectHeader = SafeParcelWriter.beginObjectHeader(parcel);
        SafeParcelWriter.writeString(parcel, 2, this.f8526b, false);
        SafeParcelWriter.writeString(parcel, 3, this.f8527m, false);
        SafeParcelWriter.writeString(parcel, 4, this.f8528n, false);
        SafeParcelWriter.writeString(parcel, 5, this.f8529o, false);
        SafeParcelWriter.writeLong(parcel, 6, this.f8530p);
        SafeParcelWriter.writeLong(parcel, 7, this.f8531q);
        SafeParcelWriter.writeString(parcel, 8, this.f8532r, false);
        SafeParcelWriter.writeBoolean(parcel, 9, this.f8533s);
        SafeParcelWriter.writeBoolean(parcel, 10, this.f8534t);
        SafeParcelWriter.writeLong(parcel, 11, this.f8535u);
        SafeParcelWriter.writeString(parcel, 12, this.f8536v, false);
        SafeParcelWriter.writeLong(parcel, 13, this.f8537w);
        SafeParcelWriter.writeLong(parcel, 14, this.f8538x);
        SafeParcelWriter.writeInt(parcel, 15, this.f8539y);
        SafeParcelWriter.writeBoolean(parcel, 16, this.f8540z);
        SafeParcelWriter.writeBoolean(parcel, 18, this.A);
        SafeParcelWriter.writeString(parcel, 19, this.B, false);
        SafeParcelWriter.writeBooleanObject(parcel, 21, this.C, false);
        SafeParcelWriter.writeLong(parcel, 22, this.D);
        SafeParcelWriter.writeStringList(parcel, 23, this.E, false);
        SafeParcelWriter.writeString(parcel, 24, this.F, false);
        SafeParcelWriter.writeString(parcel, 25, this.G, false);
        SafeParcelWriter.writeString(parcel, 26, this.H, false);
        SafeParcelWriter.writeString(parcel, 27, this.I, false);
        SafeParcelWriter.writeBoolean(parcel, 28, this.J);
        SafeParcelWriter.writeLong(parcel, 29, this.K);
        SafeParcelWriter.writeInt(parcel, 30, this.L);
        SafeParcelWriter.writeString(parcel, 31, this.M, false);
        SafeParcelWriter.writeInt(parcel, 32, this.N);
        SafeParcelWriter.writeLong(parcel, 34, this.O);
        SafeParcelWriter.writeString(parcel, 35, this.P, false);
        SafeParcelWriter.writeString(parcel, 36, this.Q, false);
        SafeParcelWriter.finishObjectHeader(parcel, iBeginObjectHeader);
    }

    @SafeParcelable.Constructor
    public zzn(@SafeParcelable.Param String str, @SafeParcelable.Param String str2, @SafeParcelable.Param String str3, @SafeParcelable.Param String str4, @SafeParcelable.Param long j10, @SafeParcelable.Param long j11, @SafeParcelable.Param String str5, @SafeParcelable.Param boolean z10, @SafeParcelable.Param boolean z11, @SafeParcelable.Param long j12, @SafeParcelable.Param String str6, @SafeParcelable.Param long j13, @SafeParcelable.Param long j14, @SafeParcelable.Param int i10, @SafeParcelable.Param boolean z12, @SafeParcelable.Param boolean z13, @SafeParcelable.Param String str7, @SafeParcelable.Param Boolean bool, @SafeParcelable.Param long j15, @SafeParcelable.Param ArrayList arrayList, @SafeParcelable.Param String str8, @SafeParcelable.Param String str9, @SafeParcelable.Param String str10, @SafeParcelable.Param String str11, @SafeParcelable.Param boolean z14, @SafeParcelable.Param long j16, @SafeParcelable.Param int i11, @SafeParcelable.Param String str12, @SafeParcelable.Param int i12, @SafeParcelable.Param long j17, @SafeParcelable.Param String str13, @SafeParcelable.Param String str14) {
        this.f8526b = str;
        this.f8527m = str2;
        this.f8528n = str3;
        this.f8535u = j12;
        this.f8529o = str4;
        this.f8530p = j10;
        this.f8531q = j11;
        this.f8532r = str5;
        this.f8533s = z10;
        this.f8534t = z11;
        this.f8536v = str6;
        this.f8537w = j13;
        this.f8538x = j14;
        this.f8539y = i10;
        this.f8540z = z12;
        this.A = z13;
        this.B = str7;
        this.C = bool;
        this.D = j15;
        this.E = arrayList;
        this.F = str8;
        this.G = str9;
        this.H = str10;
        this.I = str11;
        this.J = z14;
        this.K = j16;
        this.L = i11;
        this.M = str12;
        this.N = i12;
        this.O = j17;
        this.P = str13;
        this.Q = str14;
    }
}
