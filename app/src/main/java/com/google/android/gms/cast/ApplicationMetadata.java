package com.google.android.gms.cast;

import android.net.Uri;
import android.os.Parcel;
import android.os.Parcelable;
import com.google.android.gms.cast.internal.CastUtils;
import com.google.android.gms.common.images.WebImage;
import com.google.android.gms.common.internal.Objects;
import com.google.android.gms.common.internal.safeparcel.AbstractSafeParcelable;
import com.google.android.gms.common.internal.safeparcel.SafeParcelWriter;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/* compiled from: com.google.android.gms:play-services-cast@@21.4.0 */
@SafeParcelable.Class
@SafeParcelable.Reserved
/* loaded from: classes.dex */
public class ApplicationMetadata extends AbstractSafeParcelable {
    public static final Parcelable.Creator<ApplicationMetadata> CREATOR = new zzd();

    /* renamed from: b, reason: collision with root package name */
    @SafeParcelable.Field
    public final String f6128b;

    /* renamed from: m, reason: collision with root package name */
    @SafeParcelable.Field
    public final String f6129m;

    /* renamed from: n, reason: collision with root package name */
    @SafeParcelable.Field
    public final List f6130n;

    /* renamed from: o, reason: collision with root package name */
    @SafeParcelable.Field
    public final String f6131o;

    /* renamed from: p, reason: collision with root package name */
    @SafeParcelable.Field
    public final Uri f6132p;

    /* renamed from: q, reason: collision with root package name */
    @SafeParcelable.Field
    public final String f6133q;

    /* renamed from: r, reason: collision with root package name */
    @SafeParcelable.Field
    public final String f6134r;

    /* renamed from: s, reason: collision with root package name */
    @SafeParcelable.Field
    public final Boolean f6135s;

    /* renamed from: t, reason: collision with root package name */
    @SafeParcelable.Field
    public final Boolean f6136t;

    private ApplicationMetadata() {
        this.f6130n = new ArrayList();
    }

    public boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (!(obj instanceof ApplicationMetadata)) {
            return false;
        }
        ApplicationMetadata applicationMetadata = (ApplicationMetadata) obj;
        return CastUtils.zze(this.f6128b, applicationMetadata.f6128b) && CastUtils.zze(this.f6129m, applicationMetadata.f6129m) && CastUtils.zze(this.f6130n, applicationMetadata.f6130n) && CastUtils.zze(this.f6131o, applicationMetadata.f6131o) && CastUtils.zze(this.f6132p, applicationMetadata.f6132p) && CastUtils.zze(this.f6133q, applicationMetadata.f6133q) && CastUtils.zze(this.f6134r, applicationMetadata.f6134r);
    }

    public String getApplicationId() {
        return this.f6128b;
    }

    public String getIconUrl() {
        return this.f6133q;
    }

    @Deprecated
    public List<WebImage> getImages() {
        return null;
    }

    public String getName() {
        return this.f6129m;
    }

    public String getSenderAppIdentifier() {
        return this.f6131o;
    }

    public List<String> getSupportedNamespaces() {
        return Collections.unmodifiableList(this.f6130n);
    }

    public int hashCode() {
        return Objects.hashCode(this.f6128b, this.f6129m, this.f6130n, this.f6131o, this.f6132p, this.f6133q);
    }

    public String toString() {
        List list = this.f6130n;
        return "applicationId: " + this.f6128b + ", name: " + this.f6129m + ", namespaces.count: " + (list == null ? 0 : list.size()) + ", senderAppIdentifier: " + this.f6131o + ", senderAppLaunchUrl: " + String.valueOf(this.f6132p) + ", iconUrl: " + this.f6133q + ", type: " + this.f6134r;
    }

    @Override // android.os.Parcelable
    public void writeToParcel(Parcel parcel, int i10) {
        int iBeginObjectHeader = SafeParcelWriter.beginObjectHeader(parcel);
        SafeParcelWriter.writeString(parcel, 2, getApplicationId(), false);
        SafeParcelWriter.writeString(parcel, 3, getName(), false);
        SafeParcelWriter.writeTypedList(parcel, 4, getImages(), false);
        SafeParcelWriter.writeStringList(parcel, 5, getSupportedNamespaces(), false);
        SafeParcelWriter.writeString(parcel, 6, getSenderAppIdentifier(), false);
        SafeParcelWriter.writeParcelable(parcel, 7, this.f6132p, i10, false);
        SafeParcelWriter.writeString(parcel, 8, getIconUrl(), false);
        SafeParcelWriter.writeString(parcel, 9, this.f6134r, false);
        SafeParcelWriter.writeBooleanObject(parcel, 10, this.f6135s, false);
        SafeParcelWriter.writeBooleanObject(parcel, 11, this.f6136t, false);
        SafeParcelWriter.finishObjectHeader(parcel, iBeginObjectHeader);
    }

    @SafeParcelable.Constructor
    public ApplicationMetadata(@SafeParcelable.Param String str, @SafeParcelable.Param String str2, @SafeParcelable.Param ArrayList arrayList, @SafeParcelable.Param String str3, @SafeParcelable.Param Uri uri, @SafeParcelable.Param String str4, @SafeParcelable.Param String str5, @SafeParcelable.Param Boolean bool, @SafeParcelable.Param Boolean bool2) {
        this.f6128b = str;
        this.f6129m = str2;
        this.f6130n = arrayList;
        this.f6131o = str3;
        this.f6132p = uri;
        this.f6133q = str4;
        this.f6134r = str5;
        this.f6135s = bool;
        this.f6136t = bool2;
    }
}
