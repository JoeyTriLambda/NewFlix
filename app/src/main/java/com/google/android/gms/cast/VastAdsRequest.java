package com.google.android.gms.cast;

import android.os.Parcel;
import android.os.Parcelable;
import com.google.android.gms.cast.internal.CastUtils;
import com.google.android.gms.common.internal.Objects;
import com.google.android.gms.common.internal.safeparcel.AbstractSafeParcelable;
import com.google.android.gms.common.internal.safeparcel.SafeParcelWriter;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable;
import org.json.JSONException;
import org.json.JSONObject;

/* compiled from: com.google.android.gms:play-services-cast@@21.4.0 */
@SafeParcelable.Class
@SafeParcelable.Reserved
/* loaded from: classes.dex */
public class VastAdsRequest extends AbstractSafeParcelable {
    public static final Parcelable.Creator<VastAdsRequest> CREATOR = new zzdt();

    /* renamed from: b, reason: collision with root package name */
    @SafeParcelable.Field
    public final String f6327b;

    /* renamed from: m, reason: collision with root package name */
    @SafeParcelable.Field
    public final String f6328m;

    /* compiled from: com.google.android.gms:play-services-cast@@21.4.0 */
    public static class Builder {
    }

    @SafeParcelable.Constructor
    public VastAdsRequest(@SafeParcelable.Param String str, @SafeParcelable.Param String str2) {
        this.f6327b = str;
        this.f6328m = str2;
    }

    public static VastAdsRequest fromJson(JSONObject jSONObject) {
        if (jSONObject == null) {
            return null;
        }
        return new VastAdsRequest(CastUtils.optStringOrNull(jSONObject, "adTagUrl"), CastUtils.optStringOrNull(jSONObject, "adsResponse"));
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof VastAdsRequest)) {
            return false;
        }
        VastAdsRequest vastAdsRequest = (VastAdsRequest) obj;
        return CastUtils.zze(this.f6327b, vastAdsRequest.f6327b) && CastUtils.zze(this.f6328m, vastAdsRequest.f6328m);
    }

    public String getAdTagUrl() {
        return this.f6327b;
    }

    public String getAdsResponse() {
        return this.f6328m;
    }

    public int hashCode() {
        return Objects.hashCode(this.f6327b, this.f6328m);
    }

    @Override // android.os.Parcelable
    public void writeToParcel(Parcel parcel, int i10) {
        int iBeginObjectHeader = SafeParcelWriter.beginObjectHeader(parcel);
        SafeParcelWriter.writeString(parcel, 2, getAdTagUrl(), false);
        SafeParcelWriter.writeString(parcel, 3, getAdsResponse(), false);
        SafeParcelWriter.finishObjectHeader(parcel, iBeginObjectHeader);
    }

    public final JSONObject zza() throws JSONException {
        JSONObject jSONObject = new JSONObject();
        try {
            String str = this.f6327b;
            if (str != null) {
                jSONObject.put("adTagUrl", str);
            }
            String str2 = this.f6328m;
            if (str2 != null) {
                jSONObject.put("adsResponse", str2);
            }
        } catch (JSONException unused) {
        }
        return jSONObject;
    }
}
