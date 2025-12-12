package com.google.android.gms.common.internal;

import android.accounts.Account;
import android.os.Parcel;
import android.os.Parcelable;
import com.google.android.gms.auth.api.signin.GoogleSignInAccount;
import com.google.android.gms.common.internal.safeparcel.AbstractSafeParcelable;
import com.google.android.gms.common.internal.safeparcel.SafeParcelWriter;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable;

/* compiled from: com.google.android.gms:play-services-base@@18.0.1 */
@SafeParcelable.Class
/* loaded from: classes.dex */
public final class zat extends AbstractSafeParcelable {
    public static final Parcelable.Creator<zat> CREATOR = new zau();

    /* renamed from: b, reason: collision with root package name */
    @SafeParcelable.VersionField
    public final int f7384b;

    /* renamed from: m, reason: collision with root package name */
    @SafeParcelable.Field
    public final Account f7385m;

    /* renamed from: n, reason: collision with root package name */
    @SafeParcelable.Field
    public final int f7386n;

    /* renamed from: o, reason: collision with root package name */
    @SafeParcelable.Field
    public final GoogleSignInAccount f7387o;

    @SafeParcelable.Constructor
    public zat(@SafeParcelable.Param int i10, @SafeParcelable.Param Account account, @SafeParcelable.Param int i11, @SafeParcelable.Param GoogleSignInAccount googleSignInAccount) {
        this.f7384b = i10;
        this.f7385m = account;
        this.f7386n = i11;
        this.f7387o = googleSignInAccount;
    }

    @Override // android.os.Parcelable
    public final void writeToParcel(Parcel parcel, int i10) {
        int iBeginObjectHeader = SafeParcelWriter.beginObjectHeader(parcel);
        SafeParcelWriter.writeInt(parcel, 1, this.f7384b);
        SafeParcelWriter.writeParcelable(parcel, 2, this.f7385m, i10, false);
        SafeParcelWriter.writeInt(parcel, 3, this.f7386n);
        SafeParcelWriter.writeParcelable(parcel, 4, this.f7387o, i10, false);
        SafeParcelWriter.finishObjectHeader(parcel, iBeginObjectHeader);
    }

    public zat(Account account, int i10, GoogleSignInAccount googleSignInAccount) {
        this(2, account, i10, googleSignInAccount);
    }
}
