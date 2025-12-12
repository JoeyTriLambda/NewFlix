package com.google.android.gms.common.api;

import android.app.Activity;
import android.app.PendingIntent;
import android.content.IntentSender;
import android.os.Parcel;
import android.os.Parcelable;
import com.google.android.gms.common.ConnectionResult;
import com.google.android.gms.common.annotation.KeepForSdk;
import com.google.android.gms.common.internal.Objects;
import com.google.android.gms.common.internal.Preconditions;
import com.google.android.gms.common.internal.ReflectedParcelable;
import com.google.android.gms.common.internal.ShowFirstParty;
import com.google.android.gms.common.internal.safeparcel.AbstractSafeParcelable;
import com.google.android.gms.common.internal.safeparcel.SafeParcelWriter;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable;
import com.google.errorprone.annotations.ResultIgnorabilityUnspecified;

/* compiled from: com.google.android.gms:play-services-basement@@18.3.0 */
@SafeParcelable.Class
/* loaded from: classes.dex */
public final class Status extends AbstractSafeParcelable implements Result, ReflectedParcelable {
    public static final Parcelable.Creator<Status> CREATOR;

    /* renamed from: p, reason: collision with root package name */
    @ShowFirstParty
    @KeepForSdk
    public static final Status f7069p;

    /* renamed from: q, reason: collision with root package name */
    @ShowFirstParty
    @KeepForSdk
    public static final Status f7070q;

    /* renamed from: r, reason: collision with root package name */
    @ShowFirstParty
    @KeepForSdk
    public static final Status f7071r;

    /* renamed from: s, reason: collision with root package name */
    @ShowFirstParty
    @KeepForSdk
    public static final Status f7072s;

    /* renamed from: t, reason: collision with root package name */
    @ShowFirstParty
    @KeepForSdk
    public static final Status f7073t;

    /* renamed from: b, reason: collision with root package name */
    @SafeParcelable.Field
    public final int f7074b;

    /* renamed from: m, reason: collision with root package name */
    @SafeParcelable.Field
    public final String f7075m;

    /* renamed from: n, reason: collision with root package name */
    @SafeParcelable.Field
    public final PendingIntent f7076n;

    /* renamed from: o, reason: collision with root package name */
    @SafeParcelable.Field
    public final ConnectionResult f7077o;

    static {
        new Status(-1);
        f7069p = new Status(0);
        f7070q = new Status(14);
        f7071r = new Status(8);
        f7072s = new Status(15);
        f7073t = new Status(16);
        new Status(17);
        new Status(18);
        CREATOR = new zzb();
    }

    @SafeParcelable.Constructor
    public Status(@SafeParcelable.Param int i10, @SafeParcelable.Param String str, @SafeParcelable.Param PendingIntent pendingIntent, @SafeParcelable.Param ConnectionResult connectionResult) {
        this.f7074b = i10;
        this.f7075m = str;
        this.f7076n = pendingIntent;
        this.f7077o = connectionResult;
    }

    public boolean equals(Object obj) {
        if (!(obj instanceof Status)) {
            return false;
        }
        Status status = (Status) obj;
        return this.f7074b == status.f7074b && Objects.equal(this.f7075m, status.f7075m) && Objects.equal(this.f7076n, status.f7076n) && Objects.equal(this.f7077o, status.f7077o);
    }

    public ConnectionResult getConnectionResult() {
        return this.f7077o;
    }

    @ResultIgnorabilityUnspecified
    public int getStatusCode() {
        return this.f7074b;
    }

    public String getStatusMessage() {
        return this.f7075m;
    }

    public boolean hasResolution() {
        return this.f7076n != null;
    }

    public int hashCode() {
        return Objects.hashCode(Integer.valueOf(this.f7074b), this.f7075m, this.f7076n, this.f7077o);
    }

    public boolean isSuccess() {
        return this.f7074b <= 0;
    }

    public void startResolutionForResult(Activity activity, int i10) throws IntentSender.SendIntentException {
        if (hasResolution()) {
            PendingIntent pendingIntent = this.f7076n;
            Preconditions.checkNotNull(pendingIntent);
            activity.startIntentSenderForResult(pendingIntent.getIntentSender(), i10, null, 0, 0, 0);
        }
    }

    public String toString() {
        Objects.ToStringHelper stringHelper = Objects.toStringHelper(this);
        stringHelper.add("statusCode", zza());
        stringHelper.add("resolution", this.f7076n);
        return stringHelper.toString();
    }

    @Override // android.os.Parcelable
    public void writeToParcel(Parcel parcel, int i10) {
        int iBeginObjectHeader = SafeParcelWriter.beginObjectHeader(parcel);
        SafeParcelWriter.writeInt(parcel, 1, getStatusCode());
        SafeParcelWriter.writeString(parcel, 2, getStatusMessage(), false);
        SafeParcelWriter.writeParcelable(parcel, 3, this.f7076n, i10, false);
        SafeParcelWriter.writeParcelable(parcel, 4, getConnectionResult(), i10, false);
        SafeParcelWriter.finishObjectHeader(parcel, iBeginObjectHeader);
    }

    public final String zza() {
        String str = this.f7075m;
        return str != null ? str : CommonStatusCodes.getStatusCodeString(this.f7074b);
    }

    public Status(int i10) {
        this(i10, (String) null);
    }

    public Status(ConnectionResult connectionResult, String str) {
        this(connectionResult, str, 17);
    }

    public Status(int i10, String str) {
        this(i10, str, (PendingIntent) null);
    }

    @KeepForSdk
    @Deprecated
    public Status(ConnectionResult connectionResult, String str, int i10) {
        this(i10, str, connectionResult.getResolution(), connectionResult);
    }

    public Status(int i10, String str, PendingIntent pendingIntent) {
        this(i10, str, pendingIntent, null);
    }

    @Override // com.google.android.gms.common.api.Result
    public Status getStatus() {
        return this;
    }
}
