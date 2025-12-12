package com.google.android.gms.cast;

import android.os.Parcel;
import android.os.Parcelable;
import com.google.android.gms.cast.internal.CastUtils;
import com.google.android.gms.cast.internal.Logger;
import com.google.android.gms.common.annotation.KeepForSdk;
import com.google.android.gms.common.internal.Objects;
import com.google.android.gms.common.internal.safeparcel.AbstractSafeParcelable;
import com.google.android.gms.common.internal.safeparcel.SafeParcelWriter;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable;
import com.google.android.gms.common.util.JsonUtils;
import java.util.Arrays;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

/* compiled from: com.google.android.gms:play-services-cast@@21.4.0 */
@SafeParcelable.Class
@SafeParcelable.Reserved
/* loaded from: classes.dex */
public class MediaLoadRequestData extends AbstractSafeParcelable implements RequestData {

    /* renamed from: b, reason: collision with root package name */
    @SafeParcelable.Field
    public final MediaInfo f6217b;

    /* renamed from: m, reason: collision with root package name */
    @SafeParcelable.Field
    public final MediaQueueData f6218m;

    /* renamed from: n, reason: collision with root package name */
    @SafeParcelable.Field
    public final Boolean f6219n;

    /* renamed from: o, reason: collision with root package name */
    @SafeParcelable.Field
    public final long f6220o;

    /* renamed from: p, reason: collision with root package name */
    @SafeParcelable.Field
    public final double f6221p;

    /* renamed from: q, reason: collision with root package name */
    @SafeParcelable.Field
    public final long[] f6222q;

    /* renamed from: r, reason: collision with root package name */
    @SafeParcelable.Field
    public String f6223r;

    /* renamed from: s, reason: collision with root package name */
    public final JSONObject f6224s;

    /* renamed from: t, reason: collision with root package name */
    @SafeParcelable.Field
    public final String f6225t;

    /* renamed from: u, reason: collision with root package name */
    @SafeParcelable.Field
    public final String f6226u;

    /* renamed from: v, reason: collision with root package name */
    @SafeParcelable.Field
    public final String f6227v;

    /* renamed from: w, reason: collision with root package name */
    @SafeParcelable.Field
    public final String f6228w;

    /* renamed from: x, reason: collision with root package name */
    @SafeParcelable.Field
    public final long f6229x;

    /* renamed from: y, reason: collision with root package name */
    public static final Logger f6216y = new Logger("MediaLoadRequestData");

    @KeepForSdk
    public static final Parcelable.Creator<MediaLoadRequestData> CREATOR = new zzcc();

    /* compiled from: com.google.android.gms:play-services-cast@@21.4.0 */
    public static class Builder {

        /* renamed from: a, reason: collision with root package name */
        public MediaInfo f6230a;

        /* renamed from: b, reason: collision with root package name */
        public MediaQueueData f6231b;

        /* renamed from: c, reason: collision with root package name */
        public Boolean f6232c = Boolean.TRUE;

        /* renamed from: d, reason: collision with root package name */
        public long f6233d = -1;

        /* renamed from: e, reason: collision with root package name */
        public double f6234e = 1.0d;

        /* renamed from: f, reason: collision with root package name */
        public long[] f6235f;

        /* renamed from: g, reason: collision with root package name */
        public JSONObject f6236g;

        public MediaLoadRequestData build() {
            return new MediaLoadRequestData(this.f6230a, this.f6231b, this.f6232c, this.f6233d, this.f6234e, this.f6235f, this.f6236g, null, null, null, null, 0L);
        }

        public Builder setActiveTrackIds(long[] jArr) {
            this.f6235f = jArr;
            return this;
        }

        public Builder setCurrentTime(long j10) {
            this.f6233d = j10;
            return this;
        }

        public Builder setCustomData(JSONObject jSONObject) {
            this.f6236g = jSONObject;
            return this;
        }

        public Builder setMediaInfo(MediaInfo mediaInfo) {
            this.f6230a = mediaInfo;
            return this;
        }

        public Builder setPlaybackRate(double d10) {
            if (Double.compare(d10, 2.0d) > 0 || Double.compare(d10, 0.5d) < 0) {
                throw new IllegalArgumentException("playbackRate must be between PLAYBACK_RATE_MIN and PLAYBACK_RATE_MAX");
            }
            this.f6234e = d10;
            return this;
        }

        public Builder setQueueData(MediaQueueData mediaQueueData) {
            this.f6231b = mediaQueueData;
            return this;
        }
    }

    public MediaLoadRequestData(MediaInfo mediaInfo, MediaQueueData mediaQueueData, Boolean bool, long j10, double d10, long[] jArr, JSONObject jSONObject, String str, String str2, String str3, String str4, long j11) {
        this.f6217b = mediaInfo;
        this.f6218m = mediaQueueData;
        this.f6219n = bool;
        this.f6220o = j10;
        this.f6221p = d10;
        this.f6222q = jArr;
        this.f6224s = jSONObject;
        this.f6225t = str;
        this.f6226u = str2;
        this.f6227v = str3;
        this.f6228w = str4;
        this.f6229x = j11;
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof MediaLoadRequestData)) {
            return false;
        }
        MediaLoadRequestData mediaLoadRequestData = (MediaLoadRequestData) obj;
        return JsonUtils.areJsonValuesEquivalent(this.f6224s, mediaLoadRequestData.f6224s) && Objects.equal(this.f6217b, mediaLoadRequestData.f6217b) && Objects.equal(this.f6218m, mediaLoadRequestData.f6218m) && Objects.equal(this.f6219n, mediaLoadRequestData.f6219n) && this.f6220o == mediaLoadRequestData.f6220o && this.f6221p == mediaLoadRequestData.f6221p && Arrays.equals(this.f6222q, mediaLoadRequestData.f6222q) && Objects.equal(this.f6225t, mediaLoadRequestData.f6225t) && Objects.equal(this.f6226u, mediaLoadRequestData.f6226u) && Objects.equal(this.f6227v, mediaLoadRequestData.f6227v) && Objects.equal(this.f6228w, mediaLoadRequestData.f6228w) && this.f6229x == mediaLoadRequestData.f6229x;
    }

    public long[] getActiveTrackIds() {
        return this.f6222q;
    }

    public Boolean getAutoplay() {
        return this.f6219n;
    }

    public String getCredentials() {
        return this.f6225t;
    }

    public String getCredentialsType() {
        return this.f6226u;
    }

    public long getCurrentTime() {
        return this.f6220o;
    }

    public MediaInfo getMediaInfo() {
        return this.f6217b;
    }

    public double getPlaybackRate() {
        return this.f6221p;
    }

    public MediaQueueData getQueueData() {
        return this.f6218m;
    }

    @KeepForSdk
    public long getRequestId() {
        return this.f6229x;
    }

    public int hashCode() {
        return Objects.hashCode(this.f6217b, this.f6218m, this.f6219n, Long.valueOf(this.f6220o), Double.valueOf(this.f6221p), this.f6222q, String.valueOf(this.f6224s), this.f6225t, this.f6226u, this.f6227v, this.f6228w, Long.valueOf(this.f6229x));
    }

    @KeepForSdk
    public JSONObject toJson() throws JSONException {
        JSONObject jSONObject = new JSONObject();
        try {
            MediaInfo mediaInfo = this.f6217b;
            if (mediaInfo != null) {
                jSONObject.put("media", mediaInfo.zza());
            }
            MediaQueueData mediaQueueData = this.f6218m;
            if (mediaQueueData != null) {
                jSONObject.put("queueData", mediaQueueData.zza());
            }
            jSONObject.putOpt("autoplay", this.f6219n);
            long j10 = this.f6220o;
            if (j10 != -1) {
                jSONObject.put("currentTime", CastUtils.millisecToSec(j10));
            }
            jSONObject.put("playbackRate", this.f6221p);
            jSONObject.putOpt("credentials", this.f6225t);
            jSONObject.putOpt("credentialsType", this.f6226u);
            jSONObject.putOpt("atvCredentials", this.f6227v);
            jSONObject.putOpt("atvCredentialsType", this.f6228w);
            long[] jArr = this.f6222q;
            if (jArr != null) {
                JSONArray jSONArray = new JSONArray();
                for (int i10 = 0; i10 < jArr.length; i10++) {
                    jSONArray.put(i10, jArr[i10]);
                }
                jSONObject.put("activeTrackIds", jSONArray);
            }
            jSONObject.putOpt("customData", this.f6224s);
            jSONObject.put("requestId", this.f6229x);
            return jSONObject;
        } catch (JSONException e10) {
            f6216y.e("Error transforming MediaLoadRequestData into JSONObject", e10);
            return new JSONObject();
        }
    }

    @Override // android.os.Parcelable
    public void writeToParcel(Parcel parcel, int i10) {
        JSONObject jSONObject = this.f6224s;
        this.f6223r = jSONObject == null ? null : jSONObject.toString();
        int iBeginObjectHeader = SafeParcelWriter.beginObjectHeader(parcel);
        SafeParcelWriter.writeParcelable(parcel, 2, getMediaInfo(), i10, false);
        SafeParcelWriter.writeParcelable(parcel, 3, getQueueData(), i10, false);
        SafeParcelWriter.writeBooleanObject(parcel, 4, getAutoplay(), false);
        SafeParcelWriter.writeLong(parcel, 5, getCurrentTime());
        SafeParcelWriter.writeDouble(parcel, 6, getPlaybackRate());
        SafeParcelWriter.writeLongArray(parcel, 7, getActiveTrackIds(), false);
        SafeParcelWriter.writeString(parcel, 8, this.f6223r, false);
        SafeParcelWriter.writeString(parcel, 9, getCredentials(), false);
        SafeParcelWriter.writeString(parcel, 10, getCredentialsType(), false);
        SafeParcelWriter.writeString(parcel, 11, this.f6227v, false);
        SafeParcelWriter.writeString(parcel, 12, this.f6228w, false);
        SafeParcelWriter.writeLong(parcel, 13, getRequestId());
        SafeParcelWriter.finishObjectHeader(parcel, iBeginObjectHeader);
    }
}
