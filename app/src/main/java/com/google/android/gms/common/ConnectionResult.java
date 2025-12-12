package com.google.android.gms.common;

import android.app.PendingIntent;
import android.os.Parcel;
import android.os.Parcelable;
import com.google.android.gms.common.annotation.KeepForSdk;
import com.google.android.gms.common.internal.Objects;
import com.google.android.gms.common.internal.ShowFirstParty;
import com.google.android.gms.common.internal.safeparcel.AbstractSafeParcelable;
import com.google.android.gms.common.internal.safeparcel.SafeParcelWriter;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable;
import o1.a;

/* compiled from: com.google.android.gms:play-services-basement@@18.3.0 */
@SafeParcelable.Class
/* loaded from: classes.dex */
public final class ConnectionResult extends AbstractSafeParcelable {

    /* renamed from: b, reason: collision with root package name */
    @SafeParcelable.VersionField
    public final int f7015b;

    /* renamed from: m, reason: collision with root package name */
    @SafeParcelable.Field
    public final int f7016m;

    /* renamed from: n, reason: collision with root package name */
    @SafeParcelable.Field
    public final PendingIntent f7017n;

    /* renamed from: o, reason: collision with root package name */
    @SafeParcelable.Field
    public final String f7018o;

    /* renamed from: p, reason: collision with root package name */
    @ShowFirstParty
    @KeepForSdk
    public static final ConnectionResult f7014p = new ConnectionResult(0);
    public static final Parcelable.Creator<ConnectionResult> CREATOR = new zzb();

    @SafeParcelable.Constructor
    public ConnectionResult(@SafeParcelable.Param int i10, @SafeParcelable.Param int i11, @SafeParcelable.Param PendingIntent pendingIntent, @SafeParcelable.Param String str) {
        this.f7015b = i10;
        this.f7016m = i11;
        this.f7017n = pendingIntent;
        this.f7018o = str;
    }

    public static String a(int i10) {
        if (i10 == 99) {
            return "UNFINISHED";
        }
        if (i10 == 1500) {
            return "DRIVE_EXTERNAL_STORAGE_REQUIRED";
        }
        switch (i10) {
            case -1:
                return "UNKNOWN";
            case 0:
                return "SUCCESS";
            case 1:
                return "SERVICE_MISSING";
            case 2:
                return "SERVICE_VERSION_UPDATE_REQUIRED";
            case 3:
                return "SERVICE_DISABLED";
            case 4:
                return "SIGN_IN_REQUIRED";
            case 5:
                return "INVALID_ACCOUNT";
            case 6:
                return "RESOLUTION_REQUIRED";
            case 7:
                return "NETWORK_ERROR";
            case 8:
                return "INTERNAL_ERROR";
            case 9:
                return "SERVICE_INVALID";
            case 10:
                return "DEVELOPER_ERROR";
            case 11:
                return "LICENSE_CHECK_FAILED";
            default:
                switch (i10) {
                    case 13:
                        return "CANCELED";
                    case 14:
                        return "TIMEOUT";
                    case 15:
                        return "INTERRUPTED";
                    case 16:
                        return "API_UNAVAILABLE";
                    case 17:
                        return "SIGN_IN_FAILED";
                    case 18:
                        return "SERVICE_UPDATING";
                    case 19:
                        return "SERVICE_MISSING_PERMISSION";
                    case 20:
                        return "RESTRICTED_PROFILE";
                    case 21:
                        return "API_VERSION_UPDATE_REQUIRED";
                    case 22:
                        return "RESOLUTION_ACTIVITY_NOT_FOUND";
                    case 23:
                        return "API_DISABLED";
                    case 24:
                        return "API_DISABLED_FOR_CONNECTION";
                    default:
                        return a.d("UNKNOWN_ERROR_CODE(", i10, ")");
                }
        }
    }

    public boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (!(obj instanceof ConnectionResult)) {
            return false;
        }
        ConnectionResult connectionResult = (ConnectionResult) obj;
        return this.f7016m == connectionResult.f7016m && Objects.equal(this.f7017n, connectionResult.f7017n) && Objects.equal(this.f7018o, connectionResult.f7018o);
    }

    public int getErrorCode() {
        return this.f7016m;
    }

    public String getErrorMessage() {
        return this.f7018o;
    }

    public PendingIntent getResolution() {
        return this.f7017n;
    }

    public boolean hasResolution() {
        return (this.f7016m == 0 || this.f7017n == null) ? false : true;
    }

    public int hashCode() {
        return Objects.hashCode(Integer.valueOf(this.f7016m), this.f7017n, this.f7018o);
    }

    public boolean isSuccess() {
        return this.f7016m == 0;
    }

    public String toString() {
        Objects.ToStringHelper stringHelper = Objects.toStringHelper(this);
        stringHelper.add("statusCode", a(this.f7016m));
        stringHelper.add("resolution", this.f7017n);
        stringHelper.add("message", this.f7018o);
        return stringHelper.toString();
    }

    @Override // android.os.Parcelable
    public void writeToParcel(Parcel parcel, int i10) {
        int iBeginObjectHeader = SafeParcelWriter.beginObjectHeader(parcel);
        SafeParcelWriter.writeInt(parcel, 1, this.f7015b);
        SafeParcelWriter.writeInt(parcel, 2, getErrorCode());
        SafeParcelWriter.writeParcelable(parcel, 3, getResolution(), i10, false);
        SafeParcelWriter.writeString(parcel, 4, getErrorMessage(), false);
        SafeParcelWriter.finishObjectHeader(parcel, iBeginObjectHeader);
    }

    public ConnectionResult(int i10) {
        this(i10, null, null);
    }

    public ConnectionResult(int i10, PendingIntent pendingIntent) {
        this(i10, pendingIntent, null);
    }

    public ConnectionResult(int i10, PendingIntent pendingIntent, String str) {
        this(1, i10, pendingIntent, str);
    }
}
