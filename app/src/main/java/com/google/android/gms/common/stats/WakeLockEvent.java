package com.google.android.gms.common.stats;

import android.os.Parcel;
import android.os.Parcelable;
import android.text.TextUtils;
import com.google.android.gms.common.annotation.KeepForSdk;
import com.google.android.gms.common.internal.safeparcel.SafeParcelWriter;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable;
import java.util.ArrayList;
import java.util.List;

/* compiled from: com.google.android.gms:play-services-basement@@18.3.0 */
@KeepForSdk
@SafeParcelable.Class
@Deprecated
/* loaded from: classes.dex */
public final class WakeLockEvent extends StatsEvent {
    public static final Parcelable.Creator<WakeLockEvent> CREATOR = new zza();

    /* renamed from: b, reason: collision with root package name */
    @SafeParcelable.VersionField
    public final int f7485b;

    /* renamed from: m, reason: collision with root package name */
    @SafeParcelable.Field
    public final long f7486m;

    /* renamed from: n, reason: collision with root package name */
    @SafeParcelable.Field
    public final int f7487n;

    /* renamed from: o, reason: collision with root package name */
    @SafeParcelable.Field
    public final String f7488o;

    /* renamed from: p, reason: collision with root package name */
    @SafeParcelable.Field
    public final String f7489p;

    /* renamed from: q, reason: collision with root package name */
    @SafeParcelable.Field
    public final String f7490q;

    /* renamed from: r, reason: collision with root package name */
    @SafeParcelable.Field
    public final int f7491r;

    /* renamed from: s, reason: collision with root package name */
    @SafeParcelable.Field
    public final List f7492s;

    /* renamed from: t, reason: collision with root package name */
    @SafeParcelable.Field
    public final String f7493t;

    /* renamed from: u, reason: collision with root package name */
    @SafeParcelable.Field
    public final long f7494u;

    /* renamed from: v, reason: collision with root package name */
    @SafeParcelable.Field
    public final int f7495v;

    /* renamed from: w, reason: collision with root package name */
    @SafeParcelable.Field
    public final String f7496w;

    /* renamed from: x, reason: collision with root package name */
    @SafeParcelable.Field
    public final float f7497x;

    /* renamed from: y, reason: collision with root package name */
    @SafeParcelable.Field
    public final long f7498y;

    /* renamed from: z, reason: collision with root package name */
    @SafeParcelable.Field
    public final boolean f7499z;

    @SafeParcelable.Constructor
    public WakeLockEvent(@SafeParcelable.Param int i10, @SafeParcelable.Param long j10, @SafeParcelable.Param int i11, @SafeParcelable.Param String str, @SafeParcelable.Param int i12, @SafeParcelable.Param ArrayList arrayList, @SafeParcelable.Param String str2, @SafeParcelable.Param long j11, @SafeParcelable.Param int i13, @SafeParcelable.Param String str3, @SafeParcelable.Param String str4, @SafeParcelable.Param float f10, @SafeParcelable.Param long j12, @SafeParcelable.Param String str5, @SafeParcelable.Param boolean z10) {
        this.f7485b = i10;
        this.f7486m = j10;
        this.f7487n = i11;
        this.f7488o = str;
        this.f7489p = str3;
        this.f7490q = str5;
        this.f7491r = i12;
        this.f7492s = arrayList;
        this.f7493t = str2;
        this.f7494u = j11;
        this.f7495v = i13;
        this.f7496w = str4;
        this.f7497x = f10;
        this.f7498y = j12;
        this.f7499z = z10;
    }

    @Override // android.os.Parcelable
    public final void writeToParcel(Parcel parcel, int i10) {
        int iBeginObjectHeader = SafeParcelWriter.beginObjectHeader(parcel);
        SafeParcelWriter.writeInt(parcel, 1, this.f7485b);
        SafeParcelWriter.writeLong(parcel, 2, this.f7486m);
        SafeParcelWriter.writeString(parcel, 4, this.f7488o, false);
        SafeParcelWriter.writeInt(parcel, 5, this.f7491r);
        SafeParcelWriter.writeStringList(parcel, 6, this.f7492s, false);
        SafeParcelWriter.writeLong(parcel, 8, this.f7494u);
        SafeParcelWriter.writeString(parcel, 10, this.f7489p, false);
        SafeParcelWriter.writeInt(parcel, 11, this.f7487n);
        SafeParcelWriter.writeString(parcel, 12, this.f7493t, false);
        SafeParcelWriter.writeString(parcel, 13, this.f7496w, false);
        SafeParcelWriter.writeInt(parcel, 14, this.f7495v);
        SafeParcelWriter.writeFloat(parcel, 15, this.f7497x);
        SafeParcelWriter.writeLong(parcel, 16, this.f7498y);
        SafeParcelWriter.writeString(parcel, 17, this.f7490q, false);
        SafeParcelWriter.writeBoolean(parcel, 18, this.f7499z);
        SafeParcelWriter.finishObjectHeader(parcel, iBeginObjectHeader);
    }

    @Override // com.google.android.gms.common.stats.StatsEvent
    public final int zza() {
        return this.f7487n;
    }

    @Override // com.google.android.gms.common.stats.StatsEvent
    public final long zzb() {
        return this.f7486m;
    }

    @Override // com.google.android.gms.common.stats.StatsEvent
    public final String zzc() {
        List list = this.f7492s;
        String strJoin = list == null ? "" : TextUtils.join(",", list);
        StringBuilder sb2 = new StringBuilder("\t");
        sb2.append(this.f7488o);
        sb2.append("\t");
        sb2.append(this.f7491r);
        sb2.append("\t");
        sb2.append(strJoin);
        sb2.append("\t");
        sb2.append(this.f7495v);
        sb2.append("\t");
        String str = this.f7489p;
        if (str == null) {
            str = "";
        }
        sb2.append(str);
        sb2.append("\t");
        String str2 = this.f7496w;
        if (str2 == null) {
            str2 = "";
        }
        sb2.append(str2);
        sb2.append("\t");
        sb2.append(this.f7497x);
        sb2.append("\t");
        String str3 = this.f7490q;
        sb2.append(str3 != null ? str3 : "");
        sb2.append("\t");
        sb2.append(this.f7499z);
        return sb2.toString();
    }
}
