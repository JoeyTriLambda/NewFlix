package com.google.android.gms.cast;

import android.os.Parcel;
import android.os.Parcelable;
import com.google.android.gms.cast.internal.CastUtils;
import com.google.android.gms.common.annotation.KeepForSdk;
import com.google.android.gms.common.internal.safeparcel.AbstractSafeParcelable;
import com.google.android.gms.common.internal.safeparcel.SafeParcelWriter;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable;
import java.util.Arrays;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

/* compiled from: com.google.android.gms:play-services-cast@@21.4.0 */
@SafeParcelable.Class
@SafeParcelable.Reserved
/* loaded from: classes.dex */
public class AdBreakInfo extends AbstractSafeParcelable {
    public static final Parcelable.Creator<AdBreakInfo> CREATOR = new zzb();

    /* renamed from: b, reason: collision with root package name */
    @SafeParcelable.Field
    public final long f6115b;

    /* renamed from: m, reason: collision with root package name */
    @SafeParcelable.Field
    public final String f6116m;

    /* renamed from: n, reason: collision with root package name */
    @SafeParcelable.Field
    public final long f6117n;

    /* renamed from: o, reason: collision with root package name */
    @SafeParcelable.Field
    public final boolean f6118o;

    /* renamed from: p, reason: collision with root package name */
    @SafeParcelable.Field
    public final String[] f6119p;

    /* renamed from: q, reason: collision with root package name */
    @SafeParcelable.Field
    public final boolean f6120q;

    /* renamed from: r, reason: collision with root package name */
    @SafeParcelable.Field
    public final boolean f6121r;

    /* compiled from: com.google.android.gms:play-services-cast@@21.4.0 */
    public static class Builder {
    }

    @SafeParcelable.Constructor
    public AdBreakInfo(@SafeParcelable.Param long j10, @SafeParcelable.Param String str, @SafeParcelable.Param long j11, @SafeParcelable.Param boolean z10, @SafeParcelable.Param String[] strArr, @SafeParcelable.Param boolean z11, @SafeParcelable.Param boolean z12) {
        this.f6115b = j10;
        this.f6116m = str;
        this.f6117n = j11;
        this.f6118o = z10;
        this.f6119p = strArr;
        this.f6120q = z11;
        this.f6121r = z12;
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof AdBreakInfo)) {
            return false;
        }
        AdBreakInfo adBreakInfo = (AdBreakInfo) obj;
        return CastUtils.zze(this.f6116m, adBreakInfo.f6116m) && this.f6115b == adBreakInfo.f6115b && this.f6117n == adBreakInfo.f6117n && this.f6118o == adBreakInfo.f6118o && Arrays.equals(this.f6119p, adBreakInfo.f6119p) && this.f6120q == adBreakInfo.f6120q && this.f6121r == adBreakInfo.f6121r;
    }

    public String[] getBreakClipIds() {
        return this.f6119p;
    }

    public long getDurationInMs() {
        return this.f6117n;
    }

    public String getId() {
        return this.f6116m;
    }

    public long getPlaybackPositionInMs() {
        return this.f6115b;
    }

    public int hashCode() {
        return this.f6116m.hashCode();
    }

    public boolean isEmbedded() {
        return this.f6120q;
    }

    @KeepForSdk
    public boolean isExpanded() {
        return this.f6121r;
    }

    public boolean isWatched() {
        return this.f6118o;
    }

    @Override // android.os.Parcelable
    public void writeToParcel(Parcel parcel, int i10) {
        int iBeginObjectHeader = SafeParcelWriter.beginObjectHeader(parcel);
        SafeParcelWriter.writeLong(parcel, 2, getPlaybackPositionInMs());
        SafeParcelWriter.writeString(parcel, 3, getId(), false);
        SafeParcelWriter.writeLong(parcel, 4, getDurationInMs());
        SafeParcelWriter.writeBoolean(parcel, 5, isWatched());
        SafeParcelWriter.writeStringArray(parcel, 6, getBreakClipIds(), false);
        SafeParcelWriter.writeBoolean(parcel, 7, isEmbedded());
        SafeParcelWriter.writeBoolean(parcel, 8, isExpanded());
        SafeParcelWriter.finishObjectHeader(parcel, iBeginObjectHeader);
    }

    public final JSONObject zza() throws JSONException {
        JSONObject jSONObject = new JSONObject();
        try {
            jSONObject.put("id", this.f6116m);
            jSONObject.put("position", CastUtils.millisecToSec(this.f6115b));
            jSONObject.put("isWatched", this.f6118o);
            jSONObject.put("isEmbedded", this.f6120q);
            jSONObject.put("duration", CastUtils.millisecToSec(this.f6117n));
            jSONObject.put("expanded", this.f6121r);
            String[] strArr = this.f6119p;
            if (strArr != null) {
                JSONArray jSONArray = new JSONArray();
                for (String str : strArr) {
                    jSONArray.put(str);
                }
                jSONObject.put("breakClipIds", jSONArray);
            }
        } catch (JSONException unused) {
        }
        return jSONObject;
    }
}
