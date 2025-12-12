package com.google.android.gms.cast;

import android.os.Parcel;
import android.os.Parcelable;
import com.google.android.gms.cast.internal.CastUtils;
import com.google.android.gms.common.internal.Objects;
import com.google.android.gms.common.internal.safeparcel.AbstractSafeParcelable;
import com.google.android.gms.common.internal.safeparcel.SafeParcelWriter;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable;
import java.util.Locale;

/* compiled from: com.google.android.gms:play-services-cast@@21.4.0 */
@SafeParcelable.Class
@SafeParcelable.Reserved
/* loaded from: classes.dex */
public class LaunchOptions extends AbstractSafeParcelable {
    public static final Parcelable.Creator<LaunchOptions> CREATOR = new zzbw();

    /* renamed from: b, reason: collision with root package name */
    @SafeParcelable.Field
    public boolean f6181b;

    /* renamed from: m, reason: collision with root package name */
    @SafeParcelable.Field
    public final String f6182m;

    /* renamed from: n, reason: collision with root package name */
    @SafeParcelable.Field
    public final boolean f6183n;

    /* renamed from: o, reason: collision with root package name */
    @SafeParcelable.Field
    public final CredentialsData f6184o;

    /* compiled from: com.google.android.gms:play-services-cast@@21.4.0 */
    public static final class Builder {
        public Builder() {
            new LaunchOptions();
        }
    }

    public LaunchOptions() {
        this(false, CastUtils.zzb(Locale.getDefault()), false, null);
    }

    public boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (!(obj instanceof LaunchOptions)) {
            return false;
        }
        LaunchOptions launchOptions = (LaunchOptions) obj;
        return this.f6181b == launchOptions.f6181b && CastUtils.zze(this.f6182m, launchOptions.f6182m) && this.f6183n == launchOptions.f6183n && CastUtils.zze(this.f6184o, launchOptions.f6184o);
    }

    public boolean getAndroidReceiverCompatible() {
        return this.f6183n;
    }

    public CredentialsData getCredentialsData() {
        return this.f6184o;
    }

    public String getLanguage() {
        return this.f6182m;
    }

    public boolean getRelaunchIfRunning() {
        return this.f6181b;
    }

    public int hashCode() {
        return Objects.hashCode(Boolean.valueOf(this.f6181b), this.f6182m, Boolean.valueOf(this.f6183n), this.f6184o);
    }

    public void setRelaunchIfRunning(boolean z10) {
        this.f6181b = z10;
    }

    public String toString() {
        return String.format("LaunchOptions(relaunchIfRunning=%b, language=%s, androidReceiverCompatible: %b)", Boolean.valueOf(this.f6181b), this.f6182m, Boolean.valueOf(this.f6183n));
    }

    @Override // android.os.Parcelable
    public void writeToParcel(Parcel parcel, int i10) {
        int iBeginObjectHeader = SafeParcelWriter.beginObjectHeader(parcel);
        SafeParcelWriter.writeBoolean(parcel, 2, getRelaunchIfRunning());
        SafeParcelWriter.writeString(parcel, 3, getLanguage(), false);
        SafeParcelWriter.writeBoolean(parcel, 4, getAndroidReceiverCompatible());
        SafeParcelWriter.writeParcelable(parcel, 5, getCredentialsData(), i10, false);
        SafeParcelWriter.finishObjectHeader(parcel, iBeginObjectHeader);
    }

    @SafeParcelable.Constructor
    public LaunchOptions(@SafeParcelable.Param boolean z10, @SafeParcelable.Param String str, @SafeParcelable.Param boolean z11, @SafeParcelable.Param CredentialsData credentialsData) {
        this.f6181b = z10;
        this.f6182m = str;
        this.f6183n = z11;
        this.f6184o = credentialsData;
    }
}
