package com.google.android.gms.common.internal;

import android.os.IBinder;
import android.os.Parcel;
import android.os.Parcelable;
import com.google.android.gms.common.ConnectionResult;
import com.google.android.gms.common.internal.IAccountAccessor;
import com.google.android.gms.common.internal.safeparcel.AbstractSafeParcelable;
import com.google.android.gms.common.internal.safeparcel.SafeParcelWriter;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable;

/* compiled from: com.google.android.gms:play-services-base@@18.0.1 */
@SafeParcelable.Class
/* loaded from: classes.dex */
public final class zav extends AbstractSafeParcelable {
    public static final Parcelable.Creator<zav> CREATOR = new zaw();

    /* renamed from: b, reason: collision with root package name */
    @SafeParcelable.VersionField
    public final int f7388b;

    /* renamed from: m, reason: collision with root package name */
    @SafeParcelable.Field
    public final IBinder f7389m;

    /* renamed from: n, reason: collision with root package name */
    @SafeParcelable.Field
    public final ConnectionResult f7390n;

    /* renamed from: o, reason: collision with root package name */
    @SafeParcelable.Field
    public final boolean f7391o;

    /* renamed from: p, reason: collision with root package name */
    @SafeParcelable.Field
    public final boolean f7392p;

    @SafeParcelable.Constructor
    public zav(@SafeParcelable.Param int i10, @SafeParcelable.Param IBinder iBinder, @SafeParcelable.Param ConnectionResult connectionResult, @SafeParcelable.Param boolean z10, @SafeParcelable.Param boolean z11) {
        this.f7388b = i10;
        this.f7389m = iBinder;
        this.f7390n = connectionResult;
        this.f7391o = z10;
        this.f7392p = z11;
    }

    public final boolean equals(Object obj) {
        if (obj == null) {
            return false;
        }
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof zav)) {
            return false;
        }
        zav zavVar = (zav) obj;
        return this.f7390n.equals(zavVar.f7390n) && Objects.equal(zab(), zavVar.zab());
    }

    @Override // android.os.Parcelable
    public final void writeToParcel(Parcel parcel, int i10) {
        int iBeginObjectHeader = SafeParcelWriter.beginObjectHeader(parcel);
        SafeParcelWriter.writeInt(parcel, 1, this.f7388b);
        SafeParcelWriter.writeIBinder(parcel, 2, this.f7389m, false);
        SafeParcelWriter.writeParcelable(parcel, 3, this.f7390n, i10, false);
        SafeParcelWriter.writeBoolean(parcel, 4, this.f7391o);
        SafeParcelWriter.writeBoolean(parcel, 5, this.f7392p);
        SafeParcelWriter.finishObjectHeader(parcel, iBeginObjectHeader);
    }

    public final ConnectionResult zaa() {
        return this.f7390n;
    }

    public final IAccountAccessor zab() {
        IBinder iBinder = this.f7389m;
        if (iBinder == null) {
            return null;
        }
        return IAccountAccessor.Stub.asInterface(iBinder);
    }

    public final boolean zac() {
        return this.f7391o;
    }

    public final boolean zad() {
        return this.f7392p;
    }
}
