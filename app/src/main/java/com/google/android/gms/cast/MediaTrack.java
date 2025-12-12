package com.google.android.gms.cast;

import ac.c;
import android.annotation.TargetApi;
import android.os.Parcel;
import android.os.Parcelable;
import android.text.TextUtils;
import com.google.android.gms.cast.internal.CastUtils;
import com.google.android.gms.common.annotation.KeepForSdk;
import com.google.android.gms.common.internal.Objects;
import com.google.android.gms.common.internal.ReflectedParcelable;
import com.google.android.gms.common.internal.safeparcel.AbstractSafeParcelable;
import com.google.android.gms.common.internal.safeparcel.SafeParcelWriter;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable;
import com.google.android.gms.common.util.JsonUtils;
import com.google.android.gms.common.util.PlatformVersion;
import com.unity3d.ads.metadata.MediationMetaData;
import java.util.Collection;
import java.util.List;
import java.util.Locale;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

/* compiled from: com.google.android.gms:play-services-cast@@21.4.0 */
@SafeParcelable.Class
@SafeParcelable.Reserved
/* loaded from: classes.dex */
public final class MediaTrack extends AbstractSafeParcelable implements ReflectedParcelable {

    @KeepForSdk
    public static final Parcelable.Creator<MediaTrack> CREATOR = new zzcn();

    /* renamed from: b, reason: collision with root package name */
    @SafeParcelable.Field
    public final long f6292b;

    /* renamed from: m, reason: collision with root package name */
    @SafeParcelable.Field
    public final int f6293m;

    /* renamed from: n, reason: collision with root package name */
    @SafeParcelable.Field
    public final String f6294n;

    /* renamed from: o, reason: collision with root package name */
    @SafeParcelable.Field
    public final String f6295o;

    /* renamed from: p, reason: collision with root package name */
    @SafeParcelable.Field
    public final String f6296p;

    /* renamed from: q, reason: collision with root package name */
    @SafeParcelable.Field
    public final String f6297q;

    /* renamed from: r, reason: collision with root package name */
    @SafeParcelable.Field
    public final int f6298r;

    /* renamed from: s, reason: collision with root package name */
    @SafeParcelable.Field
    public final List f6299s;

    /* renamed from: t, reason: collision with root package name */
    @SafeParcelable.Field
    public String f6300t;

    /* renamed from: u, reason: collision with root package name */
    public final JSONObject f6301u;

    /* compiled from: com.google.android.gms:play-services-cast@@21.4.0 */
    public static class Builder {

        /* renamed from: a, reason: collision with root package name */
        public final long f6302a;

        /* renamed from: b, reason: collision with root package name */
        public final int f6303b;

        /* renamed from: c, reason: collision with root package name */
        public String f6304c;

        /* renamed from: d, reason: collision with root package name */
        public String f6305d;

        /* renamed from: e, reason: collision with root package name */
        public int f6306e = 0;

        public Builder(long j10, int i10) throws IllegalArgumentException {
            this.f6302a = j10;
            this.f6303b = i10;
        }

        public MediaTrack build() {
            return new MediaTrack(this.f6302a, this.f6303b, this.f6304c, null, this.f6305d, null, this.f6306e, null, null);
        }

        public Builder setContentId(String str) {
            this.f6304c = str;
            return this;
        }

        public Builder setName(String str) {
            this.f6305d = str;
            return this;
        }

        public Builder setSubtype(int i10) throws IllegalArgumentException {
            if (i10 < -1 || i10 > 5) {
                throw new IllegalArgumentException(c.f("invalid subtype ", i10));
            }
            if (i10 != 0 && this.f6303b != 1) {
                throw new IllegalArgumentException("subtypes are only valid for text tracks");
            }
            this.f6306e = i10;
            return this;
        }
    }

    public MediaTrack(long j10, int i10, String str, String str2, String str3, String str4, int i11, List list, JSONObject jSONObject) {
        this.f6292b = j10;
        this.f6293m = i10;
        this.f6294n = str;
        this.f6295o = str2;
        this.f6296p = str3;
        this.f6297q = str4;
        this.f6298r = i11;
        this.f6299s = list;
        this.f6301u = jSONObject;
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof MediaTrack)) {
            return false;
        }
        MediaTrack mediaTrack = (MediaTrack) obj;
        JSONObject jSONObject = this.f6301u;
        boolean z10 = jSONObject == null;
        JSONObject jSONObject2 = mediaTrack.f6301u;
        if (z10 != (jSONObject2 == null)) {
            return false;
        }
        return (jSONObject == null || jSONObject2 == null || JsonUtils.areJsonValuesEquivalent(jSONObject, jSONObject2)) && this.f6292b == mediaTrack.f6292b && this.f6293m == mediaTrack.f6293m && CastUtils.zze(this.f6294n, mediaTrack.f6294n) && CastUtils.zze(this.f6295o, mediaTrack.f6295o) && CastUtils.zze(this.f6296p, mediaTrack.f6296p) && CastUtils.zze(this.f6297q, mediaTrack.f6297q) && this.f6298r == mediaTrack.f6298r && CastUtils.zze(this.f6299s, mediaTrack.f6299s);
    }

    public String getContentId() {
        return this.f6294n;
    }

    public String getContentType() {
        return this.f6295o;
    }

    public long getId() {
        return this.f6292b;
    }

    public String getLanguage() {
        return this.f6297q;
    }

    @TargetApi(21)
    public Locale getLanguageLocale() {
        String str = this.f6297q;
        if (TextUtils.isEmpty(str)) {
            return null;
        }
        if (PlatformVersion.isAtLeastLollipop()) {
            return Locale.forLanguageTag(str);
        }
        String[] strArrSplit = str.split("-", -1);
        return strArrSplit.length == 1 ? new Locale(strArrSplit[0]) : new Locale(strArrSplit[0], strArrSplit[1]);
    }

    public String getName() {
        return this.f6296p;
    }

    public List<String> getRoles() {
        return this.f6299s;
    }

    public int getSubtype() {
        return this.f6298r;
    }

    public int getType() {
        return this.f6293m;
    }

    public int hashCode() {
        return Objects.hashCode(Long.valueOf(this.f6292b), Integer.valueOf(this.f6293m), this.f6294n, this.f6295o, this.f6296p, this.f6297q, Integer.valueOf(this.f6298r), this.f6299s, String.valueOf(this.f6301u));
    }

    @Override // android.os.Parcelable
    public void writeToParcel(Parcel parcel, int i10) {
        JSONObject jSONObject = this.f6301u;
        this.f6300t = jSONObject == null ? null : jSONObject.toString();
        int iBeginObjectHeader = SafeParcelWriter.beginObjectHeader(parcel);
        SafeParcelWriter.writeLong(parcel, 2, getId());
        SafeParcelWriter.writeInt(parcel, 3, getType());
        SafeParcelWriter.writeString(parcel, 4, getContentId(), false);
        SafeParcelWriter.writeString(parcel, 5, getContentType(), false);
        SafeParcelWriter.writeString(parcel, 6, getName(), false);
        SafeParcelWriter.writeString(parcel, 7, getLanguage(), false);
        SafeParcelWriter.writeInt(parcel, 8, getSubtype());
        SafeParcelWriter.writeStringList(parcel, 9, getRoles(), false);
        SafeParcelWriter.writeString(parcel, 10, this.f6300t, false);
        SafeParcelWriter.finishObjectHeader(parcel, iBeginObjectHeader);
    }

    public final JSONObject zza() throws JSONException {
        String str = this.f6297q;
        JSONObject jSONObject = new JSONObject();
        try {
            jSONObject.put("trackId", this.f6292b);
            int i10 = this.f6293m;
            if (i10 == 1) {
                jSONObject.put("type", "TEXT");
            } else if (i10 == 2) {
                jSONObject.put("type", "AUDIO");
            } else if (i10 == 3) {
                jSONObject.put("type", "VIDEO");
            }
            String str2 = this.f6294n;
            if (str2 != null) {
                jSONObject.put("trackContentId", str2);
            }
            String str3 = this.f6295o;
            if (str3 != null) {
                jSONObject.put("trackContentType", str3);
            }
            String str4 = this.f6296p;
            if (str4 != null) {
                jSONObject.put(MediationMetaData.KEY_NAME, str4);
            }
            if (!TextUtils.isEmpty(str)) {
                jSONObject.put("language", str);
            }
            int i11 = this.f6298r;
            if (i11 == 1) {
                jSONObject.put("subtype", "SUBTITLES");
            } else if (i11 == 2) {
                jSONObject.put("subtype", "CAPTIONS");
            } else if (i11 == 3) {
                jSONObject.put("subtype", "DESCRIPTIONS");
            } else if (i11 == 4) {
                jSONObject.put("subtype", "CHAPTERS");
            } else if (i11 == 5) {
                jSONObject.put("subtype", "METADATA");
            }
            List list = this.f6299s;
            if (list != null) {
                jSONObject.put("roles", new JSONArray((Collection) list));
            }
            JSONObject jSONObject2 = this.f6301u;
            if (jSONObject2 != null) {
                jSONObject.put("customData", jSONObject2);
            }
        } catch (JSONException unused) {
        }
        return jSONObject;
    }
}
