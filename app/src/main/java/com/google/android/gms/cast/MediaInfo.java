package com.google.android.gms.cast;

import android.os.Parcel;
import android.os.Parcelable;
import com.google.android.gms.cast.internal.CastUtils;
import com.google.android.gms.common.annotation.KeepForSdk;
import com.google.android.gms.common.internal.Objects;
import com.google.android.gms.common.internal.ReflectedParcelable;
import com.google.android.gms.common.internal.safeparcel.AbstractSafeParcelable;
import com.google.android.gms.common.internal.safeparcel.SafeParcelWriter;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable;
import com.google.android.gms.common.util.JsonUtils;
import com.google.android.gms.internal.cast.zzfn;
import com.google.android.gms.internal.cast.zzfq;
import com.unity3d.ads.metadata.MediationMetaData;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Iterator;
import java.util.List;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

/* compiled from: com.google.android.gms:play-services-cast@@21.4.0 */
@SafeParcelable.Class
@SafeParcelable.Reserved
/* loaded from: classes.dex */
public class MediaInfo extends AbstractSafeParcelable implements ReflectedParcelable {

    @HlsSegmentFormat
    @SafeParcelable.Field
    public final String A;

    @HlsVideoSegmentFormat
    @SafeParcelable.Field
    public final String B;
    public final JSONObject C;

    /* renamed from: b, reason: collision with root package name */
    @SafeParcelable.Field
    public final String f6191b;

    /* renamed from: m, reason: collision with root package name */
    @SafeParcelable.Field
    public final int f6192m;

    /* renamed from: n, reason: collision with root package name */
    @SafeParcelable.Field
    public final String f6193n;

    /* renamed from: o, reason: collision with root package name */
    @SafeParcelable.Field
    public final MediaMetadata f6194o;

    /* renamed from: p, reason: collision with root package name */
    @SafeParcelable.Field
    public final long f6195p;

    /* renamed from: q, reason: collision with root package name */
    @SafeParcelable.Field
    public final List f6196q;

    /* renamed from: r, reason: collision with root package name */
    @SafeParcelable.Field
    public final TextTrackStyle f6197r;

    /* renamed from: s, reason: collision with root package name */
    @SafeParcelable.Field
    public String f6198s;

    /* renamed from: t, reason: collision with root package name */
    @SafeParcelable.Field
    public List f6199t;

    /* renamed from: u, reason: collision with root package name */
    @SafeParcelable.Field
    public List f6200u;

    /* renamed from: v, reason: collision with root package name */
    @SafeParcelable.Field
    public final String f6201v;

    /* renamed from: w, reason: collision with root package name */
    @SafeParcelable.Field
    public final VastAdsRequest f6202w;

    /* renamed from: x, reason: collision with root package name */
    @SafeParcelable.Field
    public final long f6203x;

    /* renamed from: y, reason: collision with root package name */
    @SafeParcelable.Field
    public final String f6204y;

    /* renamed from: z, reason: collision with root package name */
    @SafeParcelable.Field
    public final String f6205z;
    public static final long D = CastUtils.secToMillisec(-1L);
    public static final Parcelable.Creator<MediaInfo> CREATOR = new zzby();

    /* compiled from: com.google.android.gms:play-services-cast@@21.4.0 */
    public static class Builder {

        /* renamed from: a, reason: collision with root package name */
        public final String f6206a;

        /* renamed from: c, reason: collision with root package name */
        public String f6208c;

        /* renamed from: d, reason: collision with root package name */
        public MediaMetadata f6209d;

        /* renamed from: b, reason: collision with root package name */
        public int f6207b = -1;

        /* renamed from: e, reason: collision with root package name */
        public long f6210e = -1;

        public Builder() {
        }

        public MediaInfo build() {
            return new MediaInfo(this.f6206a, this.f6207b, this.f6208c, this.f6209d, this.f6210e, null, null, null, null, null, null, null, -1L, null, null, null, null);
        }

        public Builder setContentType(String str) {
            this.f6208c = str;
            return this;
        }

        public Builder setMetadata(MediaMetadata mediaMetadata) {
            this.f6209d = mediaMetadata;
            return this;
        }

        public Builder setStreamDuration(long j10) {
            if (j10 < 0 && j10 != -1) {
                throw new IllegalArgumentException("Invalid stream duration");
            }
            this.f6210e = j10;
            return this;
        }

        public Builder setStreamType(int i10) {
            if (i10 < -1 || i10 > 2) {
                throw new IllegalArgumentException("invalid stream type");
            }
            this.f6207b = i10;
            return this;
        }

        public Builder(String str) {
            this.f6206a = str;
        }
    }

    /* compiled from: com.google.android.gms:play-services-cast@@21.4.0 */
    @KeepForSdk
    public class Writer {
        public Writer(MediaInfo mediaInfo) {
        }
    }

    @SafeParcelable.Constructor
    public MediaInfo(@SafeParcelable.Param String str, @SafeParcelable.Param int i10, @SafeParcelable.Param String str2, @SafeParcelable.Param MediaMetadata mediaMetadata, @SafeParcelable.Param long j10, @SafeParcelable.Param ArrayList arrayList, @SafeParcelable.Param TextTrackStyle textTrackStyle, @SafeParcelable.Param String str3, @SafeParcelable.Param ArrayList arrayList2, @SafeParcelable.Param ArrayList arrayList3, @SafeParcelable.Param String str4, @SafeParcelable.Param VastAdsRequest vastAdsRequest, @SafeParcelable.Param long j11, @SafeParcelable.Param String str5, @SafeParcelable.Param String str6, @HlsSegmentFormat @SafeParcelable.Param String str7, @SafeParcelable.Param @HlsVideoSegmentFormat String str8) {
        new Writer(this);
        this.f6191b = str;
        this.f6192m = i10;
        this.f6193n = str2;
        this.f6194o = mediaMetadata;
        this.f6195p = j10;
        this.f6196q = arrayList;
        this.f6197r = textTrackStyle;
        this.f6198s = str3;
        if (str3 != null) {
            try {
                this.C = new JSONObject(this.f6198s);
            } catch (JSONException unused) {
                this.C = null;
                this.f6198s = null;
            }
        } else {
            this.C = null;
        }
        this.f6199t = arrayList2;
        this.f6200u = arrayList3;
        this.f6201v = str4;
        this.f6202w = vastAdsRequest;
        this.f6203x = j11;
        this.f6204y = str5;
        this.f6205z = str6;
        this.A = str7;
        this.B = str8;
        if (this.f6191b == null && str6 == null && str4 == null) {
            throw new IllegalArgumentException("Either contentID or contentUrl or entity should be set");
        }
    }

    /* JADX WARN: Removed duplicated region for block: B:26:0x00aa A[LOOP:0: B:5:0x0022->B:26:0x00aa, LOOP_END] */
    /* JADX WARN: Removed duplicated region for block: B:59:0x0187 A[LOOP:2: B:32:0x00d1->B:59:0x0187, LOOP_END] */
    /* JADX WARN: Removed duplicated region for block: B:68:0x00b1 A[SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:71:0x018e A[SYNTHETIC] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public final void a(org.json.JSONObject r40) throws org.json.JSONException {
        /*
            Method dump skipped, instructions count: 409
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.gms.cast.MediaInfo.a(org.json.JSONObject):void");
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof MediaInfo)) {
            return false;
        }
        MediaInfo mediaInfo = (MediaInfo) obj;
        JSONObject jSONObject = this.C;
        boolean z10 = jSONObject == null;
        JSONObject jSONObject2 = mediaInfo.C;
        if (z10 != (jSONObject2 == null)) {
            return false;
        }
        return (jSONObject == null || jSONObject2 == null || JsonUtils.areJsonValuesEquivalent(jSONObject, jSONObject2)) && CastUtils.zze(this.f6191b, mediaInfo.f6191b) && this.f6192m == mediaInfo.f6192m && CastUtils.zze(this.f6193n, mediaInfo.f6193n) && CastUtils.zze(this.f6194o, mediaInfo.f6194o) && this.f6195p == mediaInfo.f6195p && CastUtils.zze(this.f6196q, mediaInfo.f6196q) && CastUtils.zze(this.f6197r, mediaInfo.f6197r) && CastUtils.zze(this.f6199t, mediaInfo.f6199t) && CastUtils.zze(this.f6200u, mediaInfo.f6200u) && CastUtils.zze(this.f6201v, mediaInfo.f6201v) && CastUtils.zze(this.f6202w, mediaInfo.f6202w) && this.f6203x == mediaInfo.f6203x && CastUtils.zze(this.f6204y, mediaInfo.f6204y) && CastUtils.zze(this.f6205z, mediaInfo.f6205z) && CastUtils.zze(this.A, mediaInfo.A) && CastUtils.zze(this.B, mediaInfo.B);
    }

    public List<AdBreakClipInfo> getAdBreakClips() {
        List list = this.f6200u;
        if (list == null) {
            return null;
        }
        return Collections.unmodifiableList(list);
    }

    public List<AdBreakInfo> getAdBreaks() {
        List list = this.f6199t;
        if (list == null) {
            return null;
        }
        return Collections.unmodifiableList(list);
    }

    public String getContentId() {
        String str = this.f6191b;
        return str == null ? "" : str;
    }

    public String getContentType() {
        return this.f6193n;
    }

    public String getContentUrl() {
        return this.f6205z;
    }

    public String getEntity() {
        return this.f6201v;
    }

    @HlsSegmentFormat
    public String getHlsSegmentFormat() {
        return this.A;
    }

    @HlsVideoSegmentFormat
    public String getHlsVideoSegmentFormat() {
        return this.B;
    }

    public List<MediaTrack> getMediaTracks() {
        return this.f6196q;
    }

    public MediaMetadata getMetadata() {
        return this.f6194o;
    }

    public long getStartAbsoluteTime() {
        return this.f6203x;
    }

    public long getStreamDuration() {
        return this.f6195p;
    }

    public int getStreamType() {
        return this.f6192m;
    }

    public TextTrackStyle getTextTrackStyle() {
        return this.f6197r;
    }

    public VastAdsRequest getVmapAdsRequest() {
        return this.f6202w;
    }

    public int hashCode() {
        return Objects.hashCode(this.f6191b, Integer.valueOf(this.f6192m), this.f6193n, this.f6194o, Long.valueOf(this.f6195p), String.valueOf(this.C), this.f6196q, this.f6197r, this.f6199t, this.f6200u, this.f6201v, this.f6202w, Long.valueOf(this.f6203x), this.f6204y, this.A, this.B);
    }

    @Override // android.os.Parcelable
    public void writeToParcel(Parcel parcel, int i10) {
        JSONObject jSONObject = this.C;
        this.f6198s = jSONObject == null ? null : jSONObject.toString();
        int iBeginObjectHeader = SafeParcelWriter.beginObjectHeader(parcel);
        SafeParcelWriter.writeString(parcel, 2, getContentId(), false);
        SafeParcelWriter.writeInt(parcel, 3, getStreamType());
        SafeParcelWriter.writeString(parcel, 4, getContentType(), false);
        SafeParcelWriter.writeParcelable(parcel, 5, getMetadata(), i10, false);
        SafeParcelWriter.writeLong(parcel, 6, getStreamDuration());
        SafeParcelWriter.writeTypedList(parcel, 7, getMediaTracks(), false);
        SafeParcelWriter.writeParcelable(parcel, 8, getTextTrackStyle(), i10, false);
        SafeParcelWriter.writeString(parcel, 9, this.f6198s, false);
        SafeParcelWriter.writeTypedList(parcel, 10, getAdBreaks(), false);
        SafeParcelWriter.writeTypedList(parcel, 11, getAdBreakClips(), false);
        SafeParcelWriter.writeString(parcel, 12, getEntity(), false);
        SafeParcelWriter.writeParcelable(parcel, 13, getVmapAdsRequest(), i10, false);
        SafeParcelWriter.writeLong(parcel, 14, getStartAbsoluteTime());
        SafeParcelWriter.writeString(parcel, 15, this.f6204y, false);
        SafeParcelWriter.writeString(parcel, 16, getContentUrl(), false);
        SafeParcelWriter.writeString(parcel, 17, getHlsSegmentFormat(), false);
        SafeParcelWriter.writeString(parcel, 18, getHlsVideoSegmentFormat(), false);
        SafeParcelWriter.finishObjectHeader(parcel, iBeginObjectHeader);
    }

    public final JSONObject zza() throws JSONException {
        JSONObject jSONObject = new JSONObject();
        try {
            jSONObject.put("contentId", this.f6191b);
            jSONObject.putOpt("contentUrl", this.f6205z);
            int i10 = this.f6192m;
            jSONObject.put("streamType", i10 != 1 ? i10 != 2 ? "NONE" : "LIVE" : "BUFFERED");
            String str = this.f6193n;
            if (str != null) {
                jSONObject.put("contentType", str);
            }
            MediaMetadata mediaMetadata = this.f6194o;
            if (mediaMetadata != null) {
                jSONObject.put("metadata", mediaMetadata.zza());
            }
            long j10 = this.f6195p;
            if (j10 <= -1) {
                jSONObject.put("duration", JSONObject.NULL);
            } else {
                jSONObject.put("duration", CastUtils.millisecToSec(j10));
            }
            List list = this.f6196q;
            if (list != null) {
                JSONArray jSONArray = new JSONArray();
                Iterator it = list.iterator();
                while (it.hasNext()) {
                    jSONArray.put(((MediaTrack) it.next()).zza());
                }
                jSONObject.put("tracks", jSONArray);
            }
            TextTrackStyle textTrackStyle = this.f6197r;
            if (textTrackStyle != null) {
                jSONObject.put("textTrackStyle", textTrackStyle.zza());
            }
            JSONObject jSONObject2 = this.C;
            if (jSONObject2 != null) {
                jSONObject.put("customData", jSONObject2);
            }
            String str2 = this.f6201v;
            if (str2 != null) {
                jSONObject.put("entity", str2);
            }
            if (this.f6199t != null) {
                JSONArray jSONArray2 = new JSONArray();
                Iterator it2 = this.f6199t.iterator();
                while (it2.hasNext()) {
                    jSONArray2.put(((AdBreakInfo) it2.next()).zza());
                }
                jSONObject.put("breaks", jSONArray2);
            }
            if (this.f6200u != null) {
                JSONArray jSONArray3 = new JSONArray();
                Iterator it3 = this.f6200u.iterator();
                while (it3.hasNext()) {
                    jSONArray3.put(((AdBreakClipInfo) it3.next()).zza());
                }
                jSONObject.put("breakClips", jSONArray3);
            }
            VastAdsRequest vastAdsRequest = this.f6202w;
            if (vastAdsRequest != null) {
                jSONObject.put("vmapAdsRequest", vastAdsRequest.zza());
            }
            long j11 = this.f6203x;
            if (j11 != -1) {
                jSONObject.put("startAbsoluteTime", CastUtils.millisecToSec(j11));
            }
            jSONObject.putOpt("atvEntity", this.f6204y);
            String str3 = this.A;
            if (str3 != null) {
                jSONObject.put("hlsSegmentFormat", str3);
            }
            String str4 = this.B;
            if (str4 != null) {
                jSONObject.put("hlsVideoSegmentFormat", str4);
            }
        } catch (JSONException unused) {
        }
        return jSONObject;
    }

    public MediaInfo(JSONObject jSONObject) throws JSONException {
        MediaInfo mediaInfo;
        int i10;
        int i11;
        zzfq zzfqVarZzc;
        this(jSONObject.optString("contentId"), -1, null, null, -1L, null, null, null, null, null, null, null, -1L, null, null, null, null);
        String strOptString = jSONObject.optString("streamType", "NONE");
        if ("NONE".equals(strOptString)) {
            mediaInfo = this;
            mediaInfo.f6192m = 0;
        } else {
            mediaInfo = this;
            if ("BUFFERED".equals(strOptString)) {
                mediaInfo.f6192m = 1;
            } else if ("LIVE".equals(strOptString)) {
                mediaInfo.f6192m = 2;
            } else {
                mediaInfo.f6192m = -1;
            }
        }
        mediaInfo.f6193n = CastUtils.optStringOrNull(jSONObject, "contentType");
        if (jSONObject.has("metadata")) {
            JSONObject jSONObject2 = jSONObject.getJSONObject("metadata");
            MediaMetadata mediaMetadata = new MediaMetadata(jSONObject2.getInt("metadataType"));
            mediaInfo.f6194o = mediaMetadata;
            mediaMetadata.zzc(jSONObject2);
        }
        mediaInfo.f6195p = -1L;
        if (mediaInfo.f6192m != 2 && jSONObject.has("duration") && !jSONObject.isNull("duration")) {
            double dOptDouble = jSONObject.optDouble("duration", 0.0d);
            if (!Double.isNaN(dOptDouble) && !Double.isInfinite(dOptDouble) && dOptDouble >= 0.0d) {
                mediaInfo.f6195p = CastUtils.secToMillisec(dOptDouble);
            }
        }
        if (jSONObject.has("tracks")) {
            ArrayList arrayList = new ArrayList();
            JSONArray jSONArray = jSONObject.getJSONArray("tracks");
            for (int i12 = 0; i12 < jSONArray.length(); i12++) {
                JSONObject jSONObject3 = jSONArray.getJSONObject(i12);
                Parcelable.Creator<MediaTrack> creator = MediaTrack.CREATOR;
                long j10 = jSONObject3.getLong("trackId");
                String strOptString2 = jSONObject3.optString("type");
                if ("TEXT".equals(strOptString2)) {
                    i10 = 1;
                } else if ("AUDIO".equals(strOptString2)) {
                    i10 = 2;
                } else {
                    i10 = "VIDEO".equals(strOptString2) ? 3 : 0;
                }
                String strOptStringOrNull = CastUtils.optStringOrNull(jSONObject3, "trackContentId");
                String strOptStringOrNull2 = CastUtils.optStringOrNull(jSONObject3, "trackContentType");
                String strOptStringOrNull3 = CastUtils.optStringOrNull(jSONObject3, MediationMetaData.KEY_NAME);
                String strOptStringOrNull4 = CastUtils.optStringOrNull(jSONObject3, "language");
                if (jSONObject3.has("subtype")) {
                    String string = jSONObject3.getString("subtype");
                    if ("SUBTITLES".equals(string)) {
                        i11 = 1;
                    } else if ("CAPTIONS".equals(string)) {
                        i11 = 2;
                    } else if ("DESCRIPTIONS".equals(string)) {
                        i11 = 3;
                    } else if ("CHAPTERS".equals(string)) {
                        i11 = 4;
                    } else {
                        i11 = "METADATA".equals(string) ? 5 : -1;
                    }
                } else {
                    i11 = 0;
                }
                if (jSONObject3.has("roles")) {
                    zzfn zzfnVar = new zzfn();
                    JSONArray jSONArray2 = jSONObject3.getJSONArray("roles");
                    for (int i13 = 0; i13 < jSONArray2.length(); i13++) {
                        zzfnVar.zzb(jSONArray2.optString(i13));
                    }
                    zzfqVarZzc = zzfnVar.zzc();
                } else {
                    zzfqVarZzc = null;
                }
                arrayList.add(new MediaTrack(j10, i10, strOptStringOrNull, strOptStringOrNull2, strOptStringOrNull3, strOptStringOrNull4, i11, zzfqVarZzc, jSONObject3.optJSONObject("customData")));
            }
            mediaInfo.f6196q = new ArrayList(arrayList);
        } else {
            mediaInfo.f6196q = null;
        }
        if (jSONObject.has("textTrackStyle")) {
            JSONObject jSONObject4 = jSONObject.getJSONObject("textTrackStyle");
            TextTrackStyle textTrackStyle = new TextTrackStyle();
            textTrackStyle.fromJson(jSONObject4);
            mediaInfo.f6197r = textTrackStyle;
        } else {
            mediaInfo.f6197r = null;
        }
        a(jSONObject);
        mediaInfo.C = jSONObject.optJSONObject("customData");
        mediaInfo.f6201v = CastUtils.optStringOrNull(jSONObject, "entity");
        mediaInfo.f6204y = CastUtils.optStringOrNull(jSONObject, "atvEntity");
        mediaInfo.f6202w = VastAdsRequest.fromJson(jSONObject.optJSONObject("vmapAdsRequest"));
        if (jSONObject.has("startAbsoluteTime") && !jSONObject.isNull("startAbsoluteTime")) {
            double dOptDouble2 = jSONObject.optDouble("startAbsoluteTime");
            if (!Double.isNaN(dOptDouble2) && !Double.isInfinite(dOptDouble2) && dOptDouble2 >= 0.0d) {
                mediaInfo.f6203x = CastUtils.secToMillisec(dOptDouble2);
            }
        }
        if (jSONObject.has("contentUrl")) {
            mediaInfo.f6205z = jSONObject.optString("contentUrl");
        }
        mediaInfo.A = CastUtils.optStringOrNull(jSONObject, "hlsSegmentFormat");
        mediaInfo.B = CastUtils.optStringOrNull(jSONObject, "hlsVideoSegmentFormat");
    }
}
