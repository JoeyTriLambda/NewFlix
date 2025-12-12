package com.google.android.gms.cast;

import android.os.Parcel;
import android.os.Parcelable;
import com.google.android.gms.cast.internal.CastUtils;
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
public class MediaQueueItem extends AbstractSafeParcelable {

    @KeepForSdk
    public static final Parcelable.Creator<MediaQueueItem> CREATOR = new zzck();

    /* renamed from: b, reason: collision with root package name */
    @SafeParcelable.Field
    public MediaInfo f6259b;

    /* renamed from: m, reason: collision with root package name */
    @SafeParcelable.Field
    public int f6260m;

    /* renamed from: n, reason: collision with root package name */
    @SafeParcelable.Field
    public boolean f6261n;

    /* renamed from: o, reason: collision with root package name */
    @SafeParcelable.Field
    public double f6262o;

    /* renamed from: p, reason: collision with root package name */
    @SafeParcelable.Field
    public double f6263p;

    /* renamed from: q, reason: collision with root package name */
    @SafeParcelable.Field
    public double f6264q;

    /* renamed from: r, reason: collision with root package name */
    @SafeParcelable.Field
    public long[] f6265r;

    /* renamed from: s, reason: collision with root package name */
    @SafeParcelable.Field
    public String f6266s;

    /* renamed from: t, reason: collision with root package name */
    public JSONObject f6267t;

    /* compiled from: com.google.android.gms:play-services-cast@@21.4.0 */
    @KeepForSdk
    public class Writer {
        public Writer(MediaQueueItem mediaQueueItem) {
        }
    }

    @SafeParcelable.Constructor
    public MediaQueueItem(@SafeParcelable.Param MediaInfo mediaInfo, @SafeParcelable.Param int i10, @SafeParcelable.Param boolean z10, @SafeParcelable.Param double d10, @SafeParcelable.Param double d11, @SafeParcelable.Param double d12, @SafeParcelable.Param long[] jArr, @SafeParcelable.Param String str) {
        this.f6262o = Double.NaN;
        new Writer(this);
        this.f6259b = mediaInfo;
        this.f6260m = i10;
        this.f6261n = z10;
        this.f6262o = d10;
        this.f6263p = d11;
        this.f6264q = d12;
        this.f6265r = jArr;
        this.f6266s = str;
        if (str == null) {
            this.f6267t = null;
            return;
        }
        try {
            this.f6267t = new JSONObject(this.f6266s);
        } catch (JSONException unused) {
            this.f6267t = null;
            this.f6266s = null;
        }
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof MediaQueueItem)) {
            return false;
        }
        MediaQueueItem mediaQueueItem = (MediaQueueItem) obj;
        JSONObject jSONObject = this.f6267t;
        boolean z10 = jSONObject == null;
        JSONObject jSONObject2 = mediaQueueItem.f6267t;
        if (z10 != (jSONObject2 == null)) {
            return false;
        }
        return (jSONObject == null || jSONObject2 == null || JsonUtils.areJsonValuesEquivalent(jSONObject, jSONObject2)) && CastUtils.zze(this.f6259b, mediaQueueItem.f6259b) && this.f6260m == mediaQueueItem.f6260m && this.f6261n == mediaQueueItem.f6261n && ((Double.isNaN(this.f6262o) && Double.isNaN(mediaQueueItem.f6262o)) || this.f6262o == mediaQueueItem.f6262o) && this.f6263p == mediaQueueItem.f6263p && this.f6264q == mediaQueueItem.f6264q && Arrays.equals(this.f6265r, mediaQueueItem.f6265r);
    }

    @KeepForSdk
    public boolean fromJson(JSONObject jSONObject) throws JSONException {
        boolean z10;
        long[] jArr;
        boolean z11;
        int i10;
        boolean z12 = false;
        if (jSONObject.has("media")) {
            this.f6259b = new MediaInfo(jSONObject.getJSONObject("media"));
            z10 = true;
        } else {
            z10 = false;
        }
        if (jSONObject.has("itemId") && this.f6260m != (i10 = jSONObject.getInt("itemId"))) {
            this.f6260m = i10;
            z10 = true;
        }
        if (jSONObject.has("autoplay") && this.f6261n != (z11 = jSONObject.getBoolean("autoplay"))) {
            this.f6261n = z11;
            z10 = true;
        }
        double dOptDouble = jSONObject.optDouble("startTime");
        if (Double.isNaN(dOptDouble) != Double.isNaN(this.f6262o) || (!Double.isNaN(dOptDouble) && Math.abs(dOptDouble - this.f6262o) > 1.0E-7d)) {
            this.f6262o = dOptDouble;
            z10 = true;
        }
        if (jSONObject.has("playbackDuration")) {
            double d10 = jSONObject.getDouble("playbackDuration");
            if (Math.abs(d10 - this.f6263p) > 1.0E-7d) {
                this.f6263p = d10;
                z10 = true;
            }
        }
        if (jSONObject.has("preloadTime")) {
            double d11 = jSONObject.getDouble("preloadTime");
            if (Math.abs(d11 - this.f6264q) > 1.0E-7d) {
                this.f6264q = d11;
                z10 = true;
            }
        }
        if (jSONObject.has("activeTrackIds")) {
            JSONArray jSONArray = jSONObject.getJSONArray("activeTrackIds");
            int length = jSONArray.length();
            jArr = new long[length];
            for (int i11 = 0; i11 < length; i11++) {
                jArr[i11] = jSONArray.getLong(i11);
            }
            long[] jArr2 = this.f6265r;
            if (jArr2 == null || jArr2.length != length) {
                z12 = true;
                break;
            }
            for (int i12 = 0; i12 < length; i12++) {
                if (this.f6265r[i12] != jArr[i12]) {
                    z12 = true;
                    break;
                }
            }
        } else {
            jArr = null;
        }
        if (z12) {
            this.f6265r = jArr;
            z10 = true;
        }
        if (!jSONObject.has("customData")) {
            return z10;
        }
        this.f6267t = jSONObject.getJSONObject("customData");
        return true;
    }

    public long[] getActiveTrackIds() {
        return this.f6265r;
    }

    public boolean getAutoplay() {
        return this.f6261n;
    }

    public int getItemId() {
        return this.f6260m;
    }

    public MediaInfo getMedia() {
        return this.f6259b;
    }

    public double getPlaybackDuration() {
        return this.f6263p;
    }

    public double getPreloadTime() {
        return this.f6264q;
    }

    public double getStartTime() {
        return this.f6262o;
    }

    public int hashCode() {
        return Objects.hashCode(this.f6259b, Integer.valueOf(this.f6260m), Boolean.valueOf(this.f6261n), Double.valueOf(this.f6262o), Double.valueOf(this.f6263p), Double.valueOf(this.f6264q), Integer.valueOf(Arrays.hashCode(this.f6265r)), String.valueOf(this.f6267t));
    }

    @KeepForSdk
    public JSONObject toJson() throws JSONException {
        JSONObject jSONObject = new JSONObject();
        try {
            MediaInfo mediaInfo = this.f6259b;
            if (mediaInfo != null) {
                jSONObject.put("media", mediaInfo.zza());
            }
            int i10 = this.f6260m;
            if (i10 != 0) {
                jSONObject.put("itemId", i10);
            }
            jSONObject.put("autoplay", this.f6261n);
            if (!Double.isNaN(this.f6262o)) {
                jSONObject.put("startTime", this.f6262o);
            }
            double d10 = this.f6263p;
            if (d10 != Double.POSITIVE_INFINITY) {
                jSONObject.put("playbackDuration", d10);
            }
            jSONObject.put("preloadTime", this.f6264q);
            if (this.f6265r != null) {
                JSONArray jSONArray = new JSONArray();
                for (long j10 : this.f6265r) {
                    jSONArray.put(j10);
                }
                jSONObject.put("activeTrackIds", jSONArray);
            }
            JSONObject jSONObject2 = this.f6267t;
            if (jSONObject2 != null) {
                jSONObject.put("customData", jSONObject2);
            }
        } catch (JSONException unused) {
        }
        return jSONObject;
    }

    @Override // android.os.Parcelable
    public void writeToParcel(Parcel parcel, int i10) {
        JSONObject jSONObject = this.f6267t;
        this.f6266s = jSONObject == null ? null : jSONObject.toString();
        int iBeginObjectHeader = SafeParcelWriter.beginObjectHeader(parcel);
        SafeParcelWriter.writeParcelable(parcel, 2, getMedia(), i10, false);
        SafeParcelWriter.writeInt(parcel, 3, getItemId());
        SafeParcelWriter.writeBoolean(parcel, 4, getAutoplay());
        SafeParcelWriter.writeDouble(parcel, 5, getStartTime());
        SafeParcelWriter.writeDouble(parcel, 6, getPlaybackDuration());
        SafeParcelWriter.writeDouble(parcel, 7, getPreloadTime());
        SafeParcelWriter.writeLongArray(parcel, 8, getActiveTrackIds(), false);
        SafeParcelWriter.writeString(parcel, 9, this.f6266s, false);
        SafeParcelWriter.finishObjectHeader(parcel, iBeginObjectHeader);
    }

    @KeepForSdk
    public MediaQueueItem(JSONObject jSONObject) throws JSONException {
        this(null, 0, true, Double.NaN, Double.POSITIVE_INFINITY, 0.0d, null, null);
        fromJson(jSONObject);
    }

    /* compiled from: com.google.android.gms:play-services-cast@@21.4.0 */
    public static class Builder {

        /* renamed from: a, reason: collision with root package name */
        public final MediaQueueItem f6268a;

        public Builder(MediaInfo mediaInfo) throws IllegalArgumentException {
            MediaQueueItem mediaQueueItem = new MediaQueueItem(mediaInfo, 0, true, Double.NaN, Double.POSITIVE_INFINITY, 0.0d, null, null);
            if (mediaInfo == null) {
                throw new IllegalArgumentException("media cannot be null.");
            }
            this.f6268a = mediaQueueItem;
        }

        public MediaQueueItem build() {
            MediaQueueItem mediaQueueItem = this.f6268a;
            if (mediaQueueItem.f6259b == null) {
                throw new IllegalArgumentException("media cannot be null.");
            }
            if (!Double.isNaN(mediaQueueItem.f6262o) && mediaQueueItem.f6262o < 0.0d) {
                throw new IllegalArgumentException("startTime cannot be negative or NaN.");
            }
            if (Double.isNaN(mediaQueueItem.f6263p)) {
                throw new IllegalArgumentException("playbackDuration cannot be NaN.");
            }
            if (Double.isNaN(mediaQueueItem.f6264q) || mediaQueueItem.f6264q < 0.0d) {
                throw new IllegalArgumentException("preloadTime cannot be negative or Nan.");
            }
            return mediaQueueItem;
        }

        public Builder(JSONObject jSONObject) throws JSONException {
            this.f6268a = new MediaQueueItem(jSONObject);
        }
    }
}
