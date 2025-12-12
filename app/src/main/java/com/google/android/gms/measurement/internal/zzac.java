package com.google.android.gms.measurement.internal;

import android.os.Parcel;
import android.os.Parcelable;
import com.google.android.gms.common.internal.Preconditions;
import com.google.android.gms.common.internal.safeparcel.AbstractSafeParcelable;
import com.google.android.gms.common.internal.safeparcel.SafeParcelWriter;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable;

/* compiled from: com.google.android.gms:play-services-measurement-impl@@21.6.1 */
@SafeParcelable.Class
/* loaded from: classes.dex */
public final class zzac extends AbstractSafeParcelable {
    public static final Parcelable.Creator<zzac> CREATOR = new zzaf();

    /* renamed from: b, reason: collision with root package name */
    @SafeParcelable.Field
    public String f7627b;

    /* renamed from: m, reason: collision with root package name */
    @SafeParcelable.Field
    public String f7628m;

    /* renamed from: n, reason: collision with root package name */
    @SafeParcelable.Field
    public zzno f7629n;

    /* renamed from: o, reason: collision with root package name */
    @SafeParcelable.Field
    public long f7630o;

    /* renamed from: p, reason: collision with root package name */
    @SafeParcelable.Field
    public boolean f7631p;

    /* renamed from: q, reason: collision with root package name */
    @SafeParcelable.Field
    public String f7632q;

    /* renamed from: r, reason: collision with root package name */
    @SafeParcelable.Field
    public final zzbf f7633r;

    /* renamed from: s, reason: collision with root package name */
    @SafeParcelable.Field
    public long f7634s;

    /* renamed from: t, reason: collision with root package name */
    @SafeParcelable.Field
    public zzbf f7635t;

    /* renamed from: u, reason: collision with root package name */
    @SafeParcelable.Field
    public final long f7636u;

    /* renamed from: v, reason: collision with root package name */
    @SafeParcelable.Field
    public final zzbf f7637v;

    public zzac(zzac zzacVar) {
        Preconditions.checkNotNull(zzacVar);
        this.f7627b = zzacVar.f7627b;
        this.f7628m = zzacVar.f7628m;
        this.f7629n = zzacVar.f7629n;
        this.f7630o = zzacVar.f7630o;
        this.f7631p = zzacVar.f7631p;
        this.f7632q = zzacVar.f7632q;
        this.f7633r = zzacVar.f7633r;
        this.f7634s = zzacVar.f7634s;
        this.f7635t = zzacVar.f7635t;
        this.f7636u = zzacVar.f7636u;
        this.f7637v = zzacVar.f7637v;
    }

    @Override // android.os.Parcelable
    public final void writeToParcel(Parcel parcel, int i10) {
        int iBeginObjectHeader = SafeParcelWriter.beginObjectHeader(parcel);
        SafeParcelWriter.writeString(parcel, 2, this.f7627b, false);
        SafeParcelWriter.writeString(parcel, 3, this.f7628m, false);
        SafeParcelWriter.writeParcelable(parcel, 4, this.f7629n, i10, false);
        SafeParcelWriter.writeLong(parcel, 5, this.f7630o);
        SafeParcelWriter.writeBoolean(parcel, 6, this.f7631p);
        SafeParcelWriter.writeString(parcel, 7, this.f7632q, false);
        SafeParcelWriter.writeParcelable(parcel, 8, this.f7633r, i10, false);
        SafeParcelWriter.writeLong(parcel, 9, this.f7634s);
        SafeParcelWriter.writeParcelable(parcel, 10, this.f7635t, i10, false);
        SafeParcelWriter.writeLong(parcel, 11, this.f7636u);
        SafeParcelWriter.writeParcelable(parcel, 12, this.f7637v, i10, false);
        SafeParcelWriter.finishObjectHeader(parcel, iBeginObjectHeader);
    }

    @SafeParcelable.Constructor
    public zzac(@SafeParcelable.Param String str, @SafeParcelable.Param String str2, @SafeParcelable.Param zzno zznoVar, @SafeParcelable.Param long j10, @SafeParcelable.Param boolean z10, @SafeParcelable.Param String str3, @SafeParcelable.Param zzbf zzbfVar, @SafeParcelable.Param long j11, @SafeParcelable.Param zzbf zzbfVar2, @SafeParcelable.Param long j12, @SafeParcelable.Param zzbf zzbfVar3) {
        this.f7627b = str;
        this.f7628m = str2;
        this.f7629n = zznoVar;
        this.f7630o = j10;
        this.f7631p = z10;
        this.f7632q = str3;
        this.f7633r = zzbfVar;
        this.f7634s = j11;
        this.f7635t = zzbfVar2;
        this.f7636u = j12;
        this.f7637v = zzbfVar3;
    }
}
