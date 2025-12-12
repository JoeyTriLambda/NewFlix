package com.google.android.gms.cast;

import android.annotation.SuppressLint;
import android.os.Parcel;
import android.os.Parcelable;
import android.text.TextUtils;
import android.util.SparseArray;
import com.google.android.gms.cast.internal.CastUtils;
import com.google.android.gms.cast.internal.Logger;
import com.google.android.gms.common.annotation.KeepForSdk;
import com.google.android.gms.common.internal.Objects;
import com.google.android.gms.common.internal.safeparcel.AbstractSafeParcelable;
import com.google.android.gms.common.internal.safeparcel.SafeParcelWriter;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable;
import com.google.android.gms.common.util.JsonUtils;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import org.json.JSONException;
import org.json.JSONObject;

/* compiled from: com.google.android.gms:play-services-cast@@21.4.0 */
@SafeParcelable.Class
@SafeParcelable.Reserved
/* loaded from: classes.dex */
public class MediaStatus extends AbstractSafeParcelable {

    @KeepForSdk
    public static final Parcelable.Creator<MediaStatus> CREATOR;

    @SafeParcelable.Field
    public int A;

    @SafeParcelable.Field
    public final ArrayList B;

    @SafeParcelable.Field
    public boolean C;

    @SafeParcelable.Field
    public AdBreakStatus D;

    @SafeParcelable.Field
    public VideoInfo E;

    @SafeParcelable.Field
    public MediaLiveSeekableRange F;

    @SafeParcelable.Field
    public MediaQueueData G;
    public boolean H;
    public final SparseArray I;

    /* renamed from: b, reason: collision with root package name */
    @SafeParcelable.Field
    public MediaInfo f6277b;

    /* renamed from: m, reason: collision with root package name */
    @SafeParcelable.Field
    public long f6278m;

    /* renamed from: n, reason: collision with root package name */
    @SafeParcelable.Field
    public int f6279n;

    /* renamed from: o, reason: collision with root package name */
    @SafeParcelable.Field
    public double f6280o;

    /* renamed from: p, reason: collision with root package name */
    @SafeParcelable.Field
    public int f6281p;

    /* renamed from: q, reason: collision with root package name */
    @SafeParcelable.Field
    public int f6282q;

    /* renamed from: r, reason: collision with root package name */
    @SafeParcelable.Field
    public long f6283r;

    /* renamed from: s, reason: collision with root package name */
    @SafeParcelable.Field
    public long f6284s;

    /* renamed from: t, reason: collision with root package name */
    @SafeParcelable.Field
    public double f6285t;

    /* renamed from: u, reason: collision with root package name */
    @SafeParcelable.Field
    public boolean f6286u;

    /* renamed from: v, reason: collision with root package name */
    @SafeParcelable.Field
    public long[] f6287v;

    /* renamed from: w, reason: collision with root package name */
    @SafeParcelable.Field
    public int f6288w;

    /* renamed from: x, reason: collision with root package name */
    @SafeParcelable.Field
    public int f6289x;

    /* renamed from: y, reason: collision with root package name */
    @SafeParcelable.Field
    public String f6290y;

    /* renamed from: z, reason: collision with root package name */
    public JSONObject f6291z;

    /* compiled from: com.google.android.gms:play-services-cast@@21.4.0 */
    @KeepForSdk
    public static class Builder {
        public Builder() {
            new ArrayList();
        }
    }

    /* compiled from: com.google.android.gms:play-services-cast@@21.4.0 */
    @KeepForSdk
    public class Writer {
        public Writer(MediaStatus mediaStatus) {
        }
    }

    static {
        new Logger("MediaStatus");
        CREATOR = new zzcm();
    }

    @SafeParcelable.Constructor
    @SuppressLint({"NonSdkVisibleApi"})
    public MediaStatus(@SafeParcelable.Param MediaInfo mediaInfo, @SafeParcelable.Param long j10, @SafeParcelable.Param int i10, @SafeParcelable.Param double d10, @SafeParcelable.Param int i11, @SafeParcelable.Param int i12, @SafeParcelable.Param long j11, @SafeParcelable.Param long j12, @SafeParcelable.Param double d11, @SafeParcelable.Param boolean z10, @SafeParcelable.Param long[] jArr, @SafeParcelable.Param int i13, @SafeParcelable.Param int i14, @SafeParcelable.Param String str, @SafeParcelable.Param int i15, @SafeParcelable.Param List list, @SafeParcelable.Param boolean z11, @SafeParcelable.Param AdBreakStatus adBreakStatus, @SafeParcelable.Param VideoInfo videoInfo, @SafeParcelable.Param MediaLiveSeekableRange mediaLiveSeekableRange, @SafeParcelable.Param MediaQueueData mediaQueueData) {
        this.B = new ArrayList();
        this.I = new SparseArray();
        new Writer(this);
        this.f6277b = mediaInfo;
        this.f6278m = j10;
        this.f6279n = i10;
        this.f6280o = d10;
        this.f6281p = i11;
        this.f6282q = i12;
        this.f6283r = j11;
        this.f6284s = j12;
        this.f6285t = d11;
        this.f6286u = z10;
        this.f6287v = jArr;
        this.f6288w = i13;
        this.f6289x = i14;
        this.f6290y = str;
        if (str != null) {
            try {
                this.f6291z = new JSONObject(this.f6290y);
            } catch (JSONException unused) {
                this.f6291z = null;
                this.f6290y = null;
            }
        } else {
            this.f6291z = null;
        }
        this.A = i15;
        if (list != null && !list.isEmpty()) {
            a(list);
        }
        this.C = z11;
        this.D = adBreakStatus;
        this.E = videoInfo;
        this.F = mediaLiveSeekableRange;
        this.G = mediaQueueData;
        this.H = mediaQueueData != null && mediaQueueData.zzk();
    }

    public final void a(List list) {
        ArrayList arrayList = this.B;
        arrayList.clear();
        SparseArray sparseArray = this.I;
        sparseArray.clear();
        if (list != null) {
            for (int i10 = 0; i10 < list.size(); i10++) {
                MediaQueueItem mediaQueueItem = (MediaQueueItem) list.get(i10);
                arrayList.add(mediaQueueItem);
                sparseArray.put(mediaQueueItem.getItemId(), Integer.valueOf(i10));
            }
        }
    }

    public boolean equals(Object obj) {
        JSONObject jSONObject;
        JSONObject jSONObject2;
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof MediaStatus)) {
            return false;
        }
        MediaStatus mediaStatus = (MediaStatus) obj;
        return (this.f6291z == null) == (mediaStatus.f6291z == null) && this.f6278m == mediaStatus.f6278m && this.f6279n == mediaStatus.f6279n && this.f6280o == mediaStatus.f6280o && this.f6281p == mediaStatus.f6281p && this.f6282q == mediaStatus.f6282q && this.f6283r == mediaStatus.f6283r && this.f6285t == mediaStatus.f6285t && this.f6286u == mediaStatus.f6286u && this.f6288w == mediaStatus.f6288w && this.f6289x == mediaStatus.f6289x && this.A == mediaStatus.A && Arrays.equals(this.f6287v, mediaStatus.f6287v) && CastUtils.zze(Long.valueOf(this.f6284s), Long.valueOf(mediaStatus.f6284s)) && CastUtils.zze(this.B, mediaStatus.B) && CastUtils.zze(this.f6277b, mediaStatus.f6277b) && ((jSONObject = this.f6291z) == null || (jSONObject2 = mediaStatus.f6291z) == null || JsonUtils.areJsonValuesEquivalent(jSONObject, jSONObject2)) && this.C == mediaStatus.isPlayingAd() && CastUtils.zze(this.D, mediaStatus.D) && CastUtils.zze(this.E, mediaStatus.E) && CastUtils.zze(this.F, mediaStatus.F) && Objects.equal(this.G, mediaStatus.G) && this.H == mediaStatus.H;
    }

    public long[] getActiveTrackIds() {
        return this.f6287v;
    }

    public AdBreakStatus getAdBreakStatus() {
        return this.D;
    }

    public AdBreakClipInfo getCurrentAdBreakClip() {
        MediaInfo mediaInfo;
        List<AdBreakClipInfo> adBreakClips;
        AdBreakStatus adBreakStatus = this.D;
        if (adBreakStatus == null) {
            return null;
        }
        String breakClipId = adBreakStatus.getBreakClipId();
        if (!TextUtils.isEmpty(breakClipId) && (mediaInfo = this.f6277b) != null && (adBreakClips = mediaInfo.getAdBreakClips()) != null && !adBreakClips.isEmpty()) {
            for (AdBreakClipInfo adBreakClipInfo : adBreakClips) {
                if (breakClipId.equals(adBreakClipInfo.getId())) {
                    return adBreakClipInfo;
                }
            }
        }
        return null;
    }

    public int getCurrentItemId() {
        return this.f6279n;
    }

    public JSONObject getCustomData() {
        return this.f6291z;
    }

    public int getIdleReason() {
        return this.f6282q;
    }

    public Integer getIndexById(int i10) {
        return (Integer) this.I.get(i10);
    }

    public MediaQueueItem getItemById(int i10) {
        Integer num = (Integer) this.I.get(i10);
        if (num == null) {
            return null;
        }
        return (MediaQueueItem) this.B.get(num.intValue());
    }

    public MediaLiveSeekableRange getLiveSeekableRange() {
        return this.F;
    }

    public int getLoadingItemId() {
        return this.f6288w;
    }

    public MediaInfo getMediaInfo() {
        return this.f6277b;
    }

    public double getPlaybackRate() {
        return this.f6280o;
    }

    public int getPlayerState() {
        return this.f6281p;
    }

    public int getPreloadedItemId() {
        return this.f6289x;
    }

    public MediaQueueData getQueueData() {
        return this.G;
    }

    public MediaQueueItem getQueueItemById(int i10) {
        return getItemById(i10);
    }

    public int getQueueItemCount() {
        return this.B.size();
    }

    public int getQueueRepeatMode() {
        return this.A;
    }

    public long getStreamPosition() {
        return this.f6283r;
    }

    public double getStreamVolume() {
        return this.f6285t;
    }

    public VideoInfo getVideoInfo() {
        return this.E;
    }

    public int hashCode() {
        return Objects.hashCode(this.f6277b, Long.valueOf(this.f6278m), Integer.valueOf(this.f6279n), Double.valueOf(this.f6280o), Integer.valueOf(this.f6281p), Integer.valueOf(this.f6282q), Long.valueOf(this.f6283r), Long.valueOf(this.f6284s), Double.valueOf(this.f6285t), Boolean.valueOf(this.f6286u), Integer.valueOf(Arrays.hashCode(this.f6287v)), Integer.valueOf(this.f6288w), Integer.valueOf(this.f6289x), String.valueOf(this.f6291z), Integer.valueOf(this.A), this.B, Boolean.valueOf(this.C), this.D, this.E, this.F, this.G);
    }

    public boolean isMediaCommandSupported(long j10) {
        return (j10 & this.f6284s) != 0;
    }

    public boolean isMute() {
        return this.f6286u;
    }

    public boolean isPlayingAd() {
        return this.C;
    }

    @Override // android.os.Parcelable
    public void writeToParcel(Parcel parcel, int i10) {
        JSONObject jSONObject = this.f6291z;
        this.f6290y = jSONObject == null ? null : jSONObject.toString();
        int iBeginObjectHeader = SafeParcelWriter.beginObjectHeader(parcel);
        SafeParcelWriter.writeParcelable(parcel, 2, getMediaInfo(), i10, false);
        SafeParcelWriter.writeLong(parcel, 3, this.f6278m);
        SafeParcelWriter.writeInt(parcel, 4, getCurrentItemId());
        SafeParcelWriter.writeDouble(parcel, 5, getPlaybackRate());
        SafeParcelWriter.writeInt(parcel, 6, getPlayerState());
        SafeParcelWriter.writeInt(parcel, 7, getIdleReason());
        SafeParcelWriter.writeLong(parcel, 8, getStreamPosition());
        SafeParcelWriter.writeLong(parcel, 9, this.f6284s);
        SafeParcelWriter.writeDouble(parcel, 10, getStreamVolume());
        SafeParcelWriter.writeBoolean(parcel, 11, isMute());
        SafeParcelWriter.writeLongArray(parcel, 12, getActiveTrackIds(), false);
        SafeParcelWriter.writeInt(parcel, 13, getLoadingItemId());
        SafeParcelWriter.writeInt(parcel, 14, getPreloadedItemId());
        SafeParcelWriter.writeString(parcel, 15, this.f6290y, false);
        SafeParcelWriter.writeInt(parcel, 16, this.A);
        SafeParcelWriter.writeTypedList(parcel, 17, this.B, false);
        SafeParcelWriter.writeBoolean(parcel, 18, isPlayingAd());
        SafeParcelWriter.writeParcelable(parcel, 19, getAdBreakStatus(), i10, false);
        SafeParcelWriter.writeParcelable(parcel, 20, getVideoInfo(), i10, false);
        SafeParcelWriter.writeParcelable(parcel, 21, getLiveSeekableRange(), i10, false);
        SafeParcelWriter.writeParcelable(parcel, 22, getQueueData(), i10, false);
        SafeParcelWriter.finishObjectHeader(parcel, iBeginObjectHeader);
    }

    /* JADX WARN: Removed duplicated region for block: B:104:0x0192 A[EDGE_INSN: B:104:0x0192->B:105:0x0196 BREAK  A[LOOP:0: B:97:0x017e->B:101:0x018b]] */
    /* JADX WARN: Removed duplicated region for block: B:135:0x0213  */
    /* JADX WARN: Removed duplicated region for block: B:142:0x021f  */
    /* JADX WARN: Removed duplicated region for block: B:155:0x0253  */
    /* JADX WARN: Removed duplicated region for block: B:158:0x025c  */
    /* JADX WARN: Removed duplicated region for block: B:182:0x02ed  */
    /* JADX WARN: Removed duplicated region for block: B:242:0x03e0  */
    /* JADX WARN: Removed duplicated region for block: B:244:0x03e3  */
    /* JADX WARN: Removed duplicated region for block: B:251:0x03f9  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public final int zza(org.json.JSONObject r26, int r27) throws org.json.JSONException {
        /*
            Method dump skipped, instructions count: 1225
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.gms.cast.MediaStatus.zza(org.json.JSONObject, int):int");
    }

    public final long zzb() {
        return this.f6278m;
    }

    /* JADX WARN: Removed duplicated region for block: B:17:0x0021  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public final boolean zzd() {
        /*
            r6 = this;
            com.google.android.gms.cast.MediaInfo r0 = r6.f6277b
            if (r0 != 0) goto L6
            r0 = -1
            goto La
        L6:
            int r0 = r0.getStreamType()
        La:
            int r1 = r6.f6281p
            int r2 = r6.f6282q
            int r3 = r6.f6288w
            r4 = 0
            r5 = 1
            if (r1 == r5) goto L15
            goto L24
        L15:
            if (r2 == r5) goto L21
            r1 = 2
            if (r2 == r1) goto L1e
            r0 = 3
            if (r2 == r0) goto L21
            goto L23
        L1e:
            if (r0 == r1) goto L24
            goto L23
        L21:
            if (r3 != 0) goto L24
        L23:
            r4 = 1
        L24:
            return r4
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.gms.cast.MediaStatus.zzd():boolean");
    }

    @KeepForSdk
    public MediaStatus(JSONObject jSONObject) throws JSONException {
        this(null, 0L, 0, 0.0d, 0, 0, 0L, 0L, 0.0d, false, null, 0, 0, null, 0, null, false, null, null, null, null);
        zza(jSONObject, 0);
    }
}
