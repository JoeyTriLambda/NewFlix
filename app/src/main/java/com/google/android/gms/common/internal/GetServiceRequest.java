package com.google.android.gms.common.internal;

import android.accounts.Account;
import android.os.Bundle;
import android.os.IBinder;
import android.os.Parcel;
import android.os.Parcelable;
import com.google.android.gms.common.Feature;
import com.google.android.gms.common.annotation.KeepForSdk;
import com.google.android.gms.common.api.Scope;
import com.google.android.gms.common.internal.IAccountAccessor;
import com.google.android.gms.common.internal.safeparcel.AbstractSafeParcelable;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable;

/* compiled from: com.google.android.gms:play-services-basement@@18.3.0 */
@KeepForSdk
@SafeParcelable.Class
@SafeParcelable.Reserved
/* loaded from: classes.dex */
public class GetServiceRequest extends AbstractSafeParcelable {

    /* renamed from: b, reason: collision with root package name */
    @SafeParcelable.VersionField
    public final int f7327b;

    /* renamed from: m, reason: collision with root package name */
    @SafeParcelable.Field
    public final int f7328m;

    /* renamed from: n, reason: collision with root package name */
    @SafeParcelable.Field
    public final int f7329n;

    /* renamed from: o, reason: collision with root package name */
    @SafeParcelable.Field
    public String f7330o;

    /* renamed from: p, reason: collision with root package name */
    @SafeParcelable.Field
    public IBinder f7331p;

    /* renamed from: q, reason: collision with root package name */
    @SafeParcelable.Field
    public Scope[] f7332q;

    /* renamed from: r, reason: collision with root package name */
    @SafeParcelable.Field
    public Bundle f7333r;

    /* renamed from: s, reason: collision with root package name */
    @SafeParcelable.Field
    public Account f7334s;

    /* renamed from: t, reason: collision with root package name */
    @SafeParcelable.Field
    public Feature[] f7335t;

    /* renamed from: u, reason: collision with root package name */
    @SafeParcelable.Field
    public Feature[] f7336u;

    /* renamed from: v, reason: collision with root package name */
    @SafeParcelable.Field
    public final boolean f7337v;

    /* renamed from: w, reason: collision with root package name */
    @SafeParcelable.Field
    public final int f7338w;

    /* renamed from: x, reason: collision with root package name */
    @SafeParcelable.Field
    public boolean f7339x;

    /* renamed from: y, reason: collision with root package name */
    @SafeParcelable.Field
    public final String f7340y;
    public static final Parcelable.Creator<GetServiceRequest> CREATOR = new zzn();

    /* renamed from: z, reason: collision with root package name */
    public static final Scope[] f7326z = new Scope[0];
    public static final Feature[] A = new Feature[0];

    @SafeParcelable.Constructor
    public GetServiceRequest(@SafeParcelable.Param int i10, @SafeParcelable.Param int i11, @SafeParcelable.Param int i12, @SafeParcelable.Param String str, @SafeParcelable.Param IBinder iBinder, @SafeParcelable.Param Scope[] scopeArr, @SafeParcelable.Param Bundle bundle, @SafeParcelable.Param Account account, @SafeParcelable.Param Feature[] featureArr, @SafeParcelable.Param Feature[] featureArr2, @SafeParcelable.Param boolean z10, @SafeParcelable.Param int i13, @SafeParcelable.Param boolean z11, @SafeParcelable.Param String str2) {
        scopeArr = scopeArr == null ? f7326z : scopeArr;
        bundle = bundle == null ? new Bundle() : bundle;
        Feature[] featureArr3 = A;
        featureArr = featureArr == null ? featureArr3 : featureArr;
        featureArr2 = featureArr2 == null ? featureArr3 : featureArr2;
        this.f7327b = i10;
        this.f7328m = i11;
        this.f7329n = i12;
        if ("com.google.android.gms".equals(str)) {
            this.f7330o = "com.google.android.gms";
        } else {
            this.f7330o = str;
        }
        if (i10 < 2) {
            this.f7334s = iBinder != null ? AccountAccessor.getAccountBinderSafe(IAccountAccessor.Stub.asInterface(iBinder)) : null;
        } else {
            this.f7331p = iBinder;
            this.f7334s = account;
        }
        this.f7332q = scopeArr;
        this.f7333r = bundle;
        this.f7335t = featureArr;
        this.f7336u = featureArr2;
        this.f7337v = z10;
        this.f7338w = i13;
        this.f7339x = z11;
        this.f7340y = str2;
    }

    @Override // android.os.Parcelable
    public final void writeToParcel(Parcel parcel, int i10) {
        zzn.a(this, parcel, i10);
    }

    public final String zza() {
        return this.f7340y;
    }
}
