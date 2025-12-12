package com.google.android.gms.cast;

import android.os.Parcel;
import android.os.Parcelable;
import com.google.android.gms.cast.internal.CastUtils;
import com.google.android.gms.common.annotation.KeepForSdk;
import com.google.android.gms.common.internal.ReflectedParcelable;
import com.google.android.gms.common.internal.safeparcel.AbstractSafeParcelable;
import com.google.android.gms.common.internal.safeparcel.SafeParcelWriter;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable;
import org.json.JSONObject;

/* compiled from: com.google.android.gms:play-services-cast@@21.4.0 */
@SafeParcelable.Class
@SafeParcelable.Reserved
/* loaded from: classes.dex */
public class MediaError extends AbstractSafeParcelable implements ReflectedParcelable {

    @KeepForSdk
    public static final Parcelable.Creator<MediaError> CREATOR = new zzbx();

    /* renamed from: b, reason: collision with root package name */
    @SafeParcelable.Field
    public final String f6185b;

    /* renamed from: m, reason: collision with root package name */
    @SafeParcelable.Field
    public final long f6186m;

    /* renamed from: n, reason: collision with root package name */
    @DetailedErrorCode
    @SafeParcelable.Field
    public final Integer f6187n;

    /* renamed from: o, reason: collision with root package name */
    @SafeParcelable.Field
    public final String f6188o;

    /* renamed from: p, reason: collision with root package name */
    @SafeParcelable.Field
    public String f6189p;

    /* renamed from: q, reason: collision with root package name */
    public final JSONObject f6190q;

    /* compiled from: com.google.android.gms:play-services-cast@@21.4.0 */
    public static class Builder {
    }

    /* compiled from: com.google.android.gms:play-services-cast@@21.4.0 */
    public @interface DetailedErrorCode {
    }

    @KeepForSdk
    public MediaError(String str, long j10, Integer num, String str2, JSONObject jSONObject) {
        this.f6185b = str;
        this.f6186m = j10;
        this.f6187n = num;
        this.f6188o = str2;
        this.f6190q = jSONObject;
    }

    public static MediaError zza(JSONObject jSONObject) {
        return new MediaError(jSONObject.optString("type", "ERROR"), jSONObject.optLong("requestId"), jSONObject.has("detailedErrorCode") ? Integer.valueOf(jSONObject.optInt("detailedErrorCode")) : null, CastUtils.optStringOrNull(jSONObject, "reason"), jSONObject.has("customData") ? jSONObject.optJSONObject("customData") : null);
    }

    public Integer getDetailedErrorCode() {
        return this.f6187n;
    }

    public String getReason() {
        return this.f6188o;
    }

    @KeepForSdk
    public long getRequestId() {
        return this.f6186m;
    }

    public String getType() {
        return this.f6185b;
    }

    @Override // android.os.Parcelable
    public void writeToParcel(Parcel parcel, int i10) {
        JSONObject jSONObject = this.f6190q;
        this.f6189p = jSONObject == null ? null : jSONObject.toString();
        int iBeginObjectHeader = SafeParcelWriter.beginObjectHeader(parcel);
        SafeParcelWriter.writeString(parcel, 2, getType(), false);
        SafeParcelWriter.writeLong(parcel, 3, getRequestId());
        SafeParcelWriter.writeIntegerObject(parcel, 4, getDetailedErrorCode(), false);
        SafeParcelWriter.writeString(parcel, 5, getReason(), false);
        SafeParcelWriter.writeString(parcel, 6, this.f6189p, false);
        SafeParcelWriter.finishObjectHeader(parcel, iBeginObjectHeader);
    }
}
