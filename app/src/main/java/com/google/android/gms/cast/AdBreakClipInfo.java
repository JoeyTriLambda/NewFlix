package com.google.android.gms.cast;

import android.os.Parcel;
import android.os.Parcelable;
import android.text.TextUtils;
import android.util.Log;
import com.google.android.gms.cast.internal.CastUtils;
import com.google.android.gms.common.internal.Objects;
import com.google.android.gms.common.internal.safeparcel.AbstractSafeParcelable;
import com.google.android.gms.common.internal.safeparcel.SafeParcelWriter;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable;
import java.util.Locale;
import org.json.JSONException;
import org.json.JSONObject;

/* compiled from: com.google.android.gms:play-services-cast@@21.4.0 */
@SafeParcelable.Class
@SafeParcelable.Reserved
/* loaded from: classes.dex */
public class AdBreakClipInfo extends AbstractSafeParcelable {
    public static final Parcelable.Creator<AdBreakClipInfo> CREATOR = new zza();

    /* renamed from: b, reason: collision with root package name */
    @SafeParcelable.Field
    public final String f6102b;

    /* renamed from: m, reason: collision with root package name */
    @SafeParcelable.Field
    public final String f6103m;

    /* renamed from: n, reason: collision with root package name */
    @SafeParcelable.Field
    public final long f6104n;

    /* renamed from: o, reason: collision with root package name */
    @SafeParcelable.Field
    public final String f6105o;

    /* renamed from: p, reason: collision with root package name */
    @SafeParcelable.Field
    public final String f6106p;

    /* renamed from: q, reason: collision with root package name */
    @SafeParcelable.Field
    public final String f6107q;

    /* renamed from: r, reason: collision with root package name */
    @SafeParcelable.Field
    public final String f6108r;

    /* renamed from: s, reason: collision with root package name */
    @SafeParcelable.Field
    public final String f6109s;

    /* renamed from: t, reason: collision with root package name */
    @SafeParcelable.Field
    public final String f6110t;

    /* renamed from: u, reason: collision with root package name */
    @SafeParcelable.Field
    public final long f6111u;

    /* renamed from: v, reason: collision with root package name */
    @HlsSegmentFormat
    @SafeParcelable.Field
    public final String f6112v;

    /* renamed from: w, reason: collision with root package name */
    @SafeParcelable.Field
    public final VastAdsRequest f6113w;

    /* renamed from: x, reason: collision with root package name */
    public final JSONObject f6114x;

    /* compiled from: com.google.android.gms:play-services-cast@@21.4.0 */
    public static class Builder {
    }

    @SafeParcelable.Constructor
    public AdBreakClipInfo(@SafeParcelable.Param String str, @SafeParcelable.Param String str2, @SafeParcelable.Param long j10, @SafeParcelable.Param String str3, @SafeParcelable.Param String str4, @SafeParcelable.Param String str5, @SafeParcelable.Param String str6, @SafeParcelable.Param String str7, @SafeParcelable.Param String str8, @SafeParcelable.Param long j11, @HlsSegmentFormat @SafeParcelable.Param String str9, @SafeParcelable.Param VastAdsRequest vastAdsRequest) {
        this.f6102b = str;
        this.f6103m = str2;
        this.f6104n = j10;
        this.f6105o = str3;
        this.f6106p = str4;
        this.f6107q = str5;
        this.f6108r = str6;
        this.f6109s = str7;
        this.f6110t = str8;
        this.f6111u = j11;
        this.f6112v = str9;
        this.f6113w = vastAdsRequest;
        if (TextUtils.isEmpty(str6)) {
            this.f6114x = new JSONObject();
            return;
        }
        try {
            this.f6114x = new JSONObject(str6);
        } catch (JSONException e10) {
            Log.w("AdBreakClipInfo", String.format(Locale.ROOT, "Error creating AdBreakClipInfo: %s", e10.getMessage()));
            this.f6108r = null;
            this.f6114x = new JSONObject();
        }
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof AdBreakClipInfo)) {
            return false;
        }
        AdBreakClipInfo adBreakClipInfo = (AdBreakClipInfo) obj;
        return CastUtils.zze(this.f6102b, adBreakClipInfo.f6102b) && CastUtils.zze(this.f6103m, adBreakClipInfo.f6103m) && this.f6104n == adBreakClipInfo.f6104n && CastUtils.zze(this.f6105o, adBreakClipInfo.f6105o) && CastUtils.zze(this.f6106p, adBreakClipInfo.f6106p) && CastUtils.zze(this.f6107q, adBreakClipInfo.f6107q) && CastUtils.zze(this.f6108r, adBreakClipInfo.f6108r) && CastUtils.zze(this.f6109s, adBreakClipInfo.f6109s) && CastUtils.zze(this.f6110t, adBreakClipInfo.f6110t) && this.f6111u == adBreakClipInfo.f6111u && CastUtils.zze(this.f6112v, adBreakClipInfo.f6112v) && CastUtils.zze(this.f6113w, adBreakClipInfo.f6113w);
    }

    public String getClickThroughUrl() {
        return this.f6107q;
    }

    public String getContentId() {
        return this.f6109s;
    }

    public String getContentUrl() {
        return this.f6105o;
    }

    public long getDurationInMs() {
        return this.f6104n;
    }

    public String getHlsSegmentFormat() {
        return this.f6112v;
    }

    public String getId() {
        return this.f6102b;
    }

    public String getImageUrl() {
        return this.f6110t;
    }

    public String getMimeType() {
        return this.f6106p;
    }

    public String getTitle() {
        return this.f6103m;
    }

    public VastAdsRequest getVastAdsRequest() {
        return this.f6113w;
    }

    public long getWhenSkippableInMs() {
        return this.f6111u;
    }

    public int hashCode() {
        return Objects.hashCode(this.f6102b, this.f6103m, Long.valueOf(this.f6104n), this.f6105o, this.f6106p, this.f6107q, this.f6108r, this.f6109s, this.f6110t, Long.valueOf(this.f6111u), this.f6112v, this.f6113w);
    }

    @Override // android.os.Parcelable
    public void writeToParcel(Parcel parcel, int i10) {
        int iBeginObjectHeader = SafeParcelWriter.beginObjectHeader(parcel);
        SafeParcelWriter.writeString(parcel, 2, getId(), false);
        SafeParcelWriter.writeString(parcel, 3, getTitle(), false);
        SafeParcelWriter.writeLong(parcel, 4, getDurationInMs());
        SafeParcelWriter.writeString(parcel, 5, getContentUrl(), false);
        SafeParcelWriter.writeString(parcel, 6, getMimeType(), false);
        SafeParcelWriter.writeString(parcel, 7, getClickThroughUrl(), false);
        SafeParcelWriter.writeString(parcel, 8, this.f6108r, false);
        SafeParcelWriter.writeString(parcel, 9, getContentId(), false);
        SafeParcelWriter.writeString(parcel, 10, getImageUrl(), false);
        SafeParcelWriter.writeLong(parcel, 11, getWhenSkippableInMs());
        SafeParcelWriter.writeString(parcel, 12, getHlsSegmentFormat(), false);
        SafeParcelWriter.writeParcelable(parcel, 13, getVastAdsRequest(), i10, false);
        SafeParcelWriter.finishObjectHeader(parcel, iBeginObjectHeader);
    }

    public final JSONObject zza() throws JSONException {
        JSONObject jSONObject = new JSONObject();
        try {
            jSONObject.put("id", this.f6102b);
            jSONObject.put("duration", CastUtils.millisecToSec(this.f6104n));
            long j10 = this.f6111u;
            if (j10 != -1) {
                jSONObject.put("whenSkippable", CastUtils.millisecToSec(j10));
            }
            String str = this.f6109s;
            if (str != null) {
                jSONObject.put("contentId", str);
            }
            String str2 = this.f6106p;
            if (str2 != null) {
                jSONObject.put("contentType", str2);
            }
            String str3 = this.f6103m;
            if (str3 != null) {
                jSONObject.put("title", str3);
            }
            String str4 = this.f6105o;
            if (str4 != null) {
                jSONObject.put("contentUrl", str4);
            }
            String str5 = this.f6107q;
            if (str5 != null) {
                jSONObject.put("clickThroughUrl", str5);
            }
            JSONObject jSONObject2 = this.f6114x;
            if (jSONObject2 != null) {
                jSONObject.put("customData", jSONObject2);
            }
            String str6 = this.f6110t;
            if (str6 != null) {
                jSONObject.put("posterUrl", str6);
            }
            String str7 = this.f6112v;
            if (str7 != null) {
                jSONObject.put("hlsSegmentFormat", str7);
            }
            VastAdsRequest vastAdsRequest = this.f6113w;
            if (vastAdsRequest != null) {
                jSONObject.put("vastAdsRequest", vastAdsRequest.zza());
            }
        } catch (JSONException unused) {
        }
        return jSONObject;
    }
}
