package com.google.android.gms.common.api;

import android.os.Parcel;
import android.os.Parcelable;
import com.google.android.gms.common.annotation.KeepForSdk;
import com.google.android.gms.common.internal.Preconditions;
import com.google.android.gms.common.internal.ReflectedParcelable;
import com.google.android.gms.common.internal.safeparcel.AbstractSafeParcelable;
import com.google.android.gms.common.internal.safeparcel.SafeParcelWriter;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable;

/* compiled from: com.google.android.gms:play-services-basement@@18.3.0 */
@SafeParcelable.Class
/* loaded from: classes.dex */
public final class Scope extends AbstractSafeParcelable implements ReflectedParcelable {
    public static final Parcelable.Creator<Scope> CREATOR = new zza();

    /* renamed from: b, reason: collision with root package name */
    @SafeParcelable.VersionField
    public final int f7067b;

    /* renamed from: m, reason: collision with root package name */
    @SafeParcelable.Field
    public final String f7068m;

    @SafeParcelable.Constructor
    public Scope(@SafeParcelable.Param int i10, @SafeParcelable.Param String str) {
        Preconditions.checkNotEmpty(str, "scopeUri must not be null or empty");
        this.f7067b = i10;
        this.f7068m = str;
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof Scope)) {
            return false;
        }
        return this.f7068m.equals(((Scope) obj).f7068m);
    }

    @KeepForSdk
    public String getScopeUri() {
        return this.f7068m;
    }

    public int hashCode() {
        return this.f7068m.hashCode();
    }

    public String toString() {
        return this.f7068m;
    }

    @Override // android.os.Parcelable
    public void writeToParcel(Parcel parcel, int i10) {
        int iBeginObjectHeader = SafeParcelWriter.beginObjectHeader(parcel);
        SafeParcelWriter.writeInt(parcel, 1, this.f7067b);
        SafeParcelWriter.writeString(parcel, 2, getScopeUri(), false);
        SafeParcelWriter.finishObjectHeader(parcel, iBeginObjectHeader);
    }

    public Scope(String str) {
        this(1, str);
    }
}
