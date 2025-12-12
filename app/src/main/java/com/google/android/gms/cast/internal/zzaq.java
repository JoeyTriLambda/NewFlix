package com.google.android.gms.cast.internal;

import ac.c;
import android.os.SystemClock;
import com.google.android.gms.cast.AdBreakStatus;
import com.google.android.gms.cast.MediaError;
import com.google.android.gms.cast.MediaInfo;
import com.google.android.gms.cast.MediaLiveSeekableRange;
import com.google.android.gms.cast.MediaLoadRequestData;
import com.google.android.gms.cast.MediaQueueItem;
import com.google.android.gms.cast.MediaSeekOptions;
import com.google.android.gms.cast.MediaStatus;
import com.google.android.gms.cast.internal.media.MediaCommon;
import java.util.Iterator;
import java.util.Locale;
import java.util.regex.Pattern;
import org.apache.commons.lang3.time.DateUtils;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

/* compiled from: com.google.android.gms:play-services-cast@@21.4.0 */
/* loaded from: classes.dex */
public final class zzaq extends zzd {

    /* renamed from: w, reason: collision with root package name */
    public static final String f6824w;

    /* renamed from: e, reason: collision with root package name */
    public long f6825e;

    /* renamed from: f, reason: collision with root package name */
    public MediaStatus f6826f;

    /* renamed from: g, reason: collision with root package name */
    public Long f6827g;

    /* renamed from: h, reason: collision with root package name */
    public zzan f6828h;

    /* renamed from: i, reason: collision with root package name */
    public int f6829i;

    /* renamed from: j, reason: collision with root package name */
    public final zzau f6830j;

    /* renamed from: k, reason: collision with root package name */
    public final zzau f6831k;

    /* renamed from: l, reason: collision with root package name */
    public final zzau f6832l;

    /* renamed from: m, reason: collision with root package name */
    public final zzau f6833m;

    /* renamed from: n, reason: collision with root package name */
    public final zzau f6834n;

    /* renamed from: o, reason: collision with root package name */
    public final zzau f6835o;

    /* renamed from: p, reason: collision with root package name */
    public final zzau f6836p;

    /* renamed from: q, reason: collision with root package name */
    public final zzau f6837q;

    /* renamed from: r, reason: collision with root package name */
    public final zzau f6838r;

    /* renamed from: s, reason: collision with root package name */
    public final zzau f6839s;

    /* renamed from: t, reason: collision with root package name */
    public final zzau f6840t;

    /* renamed from: u, reason: collision with root package name */
    public final zzau f6841u;

    /* renamed from: v, reason: collision with root package name */
    public final zzau f6842v;

    static {
        Pattern pattern = CastUtils.f6800a;
        f6824w = "urn:x-cast:com.google.cast.media";
    }

    public zzaq(String str) {
        super(f6824w, "MediaControlChannel", null);
        this.f6829i = -1;
        zzau zzauVar = new zzau(DateUtils.MILLIS_PER_DAY, "load");
        this.f6830j = zzauVar;
        zzau zzauVar2 = new zzau(DateUtils.MILLIS_PER_DAY, "pause");
        this.f6831k = zzauVar2;
        zzau zzauVar3 = new zzau(DateUtils.MILLIS_PER_DAY, "play");
        this.f6832l = zzauVar3;
        zzau zzauVar4 = new zzau(DateUtils.MILLIS_PER_DAY, "stop");
        zzau zzauVar5 = new zzau(10000L, "seek");
        this.f6833m = zzauVar5;
        zzau zzauVar6 = new zzau(DateUtils.MILLIS_PER_DAY, "volume");
        this.f6834n = zzauVar6;
        zzau zzauVar7 = new zzau(DateUtils.MILLIS_PER_DAY, "mute");
        this.f6835o = zzauVar7;
        zzau zzauVar8 = new zzau(DateUtils.MILLIS_PER_DAY, "status");
        this.f6836p = zzauVar8;
        zzau zzauVar9 = new zzau(DateUtils.MILLIS_PER_DAY, "activeTracks");
        this.f6837q = zzauVar9;
        zzau zzauVar10 = new zzau(DateUtils.MILLIS_PER_DAY, "trackStyle");
        zzau zzauVar11 = new zzau(DateUtils.MILLIS_PER_DAY, "queueInsert");
        zzau zzauVar12 = new zzau(DateUtils.MILLIS_PER_DAY, "queueUpdate");
        this.f6838r = zzauVar12;
        zzau zzauVar13 = new zzau(DateUtils.MILLIS_PER_DAY, "queueRemove");
        zzau zzauVar14 = new zzau(DateUtils.MILLIS_PER_DAY, "queueReorder");
        zzau zzauVar15 = new zzau(DateUtils.MILLIS_PER_DAY, "queueFetchItemIds");
        this.f6839s = zzauVar15;
        zzau zzauVar16 = new zzau(DateUtils.MILLIS_PER_DAY, "queueFetchItemRange");
        this.f6841u = zzauVar16;
        this.f6840t = new zzau(DateUtils.MILLIS_PER_DAY, "queueFetchItems");
        zzau zzauVar17 = new zzau(DateUtils.MILLIS_PER_DAY, "setPlaybackRate");
        zzau zzauVar18 = new zzau(DateUtils.MILLIS_PER_DAY, "skipAd");
        this.f6842v = zzauVar18;
        zzc(zzauVar);
        zzc(zzauVar2);
        zzc(zzauVar3);
        zzc(zzauVar4);
        zzc(zzauVar5);
        zzc(zzauVar6);
        zzc(zzauVar7);
        zzc(zzauVar8);
        zzc(zzauVar9);
        zzc(zzauVar10);
        zzc(zzauVar11);
        zzc(zzauVar12);
        zzc(zzauVar13);
        zzc(zzauVar14);
        zzc(zzauVar15);
        zzc(zzauVar16);
        zzc(zzauVar16);
        zzc(zzauVar17);
        zzc(zzauVar18);
        c();
    }

    public static zzap b(JSONObject jSONObject) {
        MediaError.zza(jSONObject);
        zzap zzapVar = new zzap();
        Pattern pattern = CastUtils.f6800a;
        if (jSONObject.has("customData")) {
            jSONObject.optJSONObject("customData");
        }
        return zzapVar;
    }

    public static int[] e(JSONArray jSONArray) throws JSONException {
        if (jSONArray == null) {
            return null;
        }
        int[] iArr = new int[jSONArray.length()];
        for (int i10 = 0; i10 < jSONArray.length(); i10++) {
            iArr[i10] = jSONArray.getInt(i10);
        }
        return iArr;
    }

    public final long a(double d10, long j10, long j11) {
        long jElapsedRealtime = SystemClock.elapsedRealtime() - this.f6825e;
        if (jElapsedRealtime < 0) {
            jElapsedRealtime = 0;
        }
        if (jElapsedRealtime == 0) {
            return j10;
        }
        long j12 = j10 + ((long) (jElapsedRealtime * d10));
        if (j11 > 0 && j12 > j11) {
            return j11;
        }
        if (j12 >= 0) {
            return j12;
        }
        return 0L;
    }

    public final void c() {
        this.f6825e = 0L;
        this.f6826f = null;
        Iterator it = zza().iterator();
        while (it.hasNext()) {
            ((zzau) it.next()).zzc(2002);
        }
    }

    public final void d(JSONObject jSONObject, String str) {
        if (jSONObject.has("sequenceNumber")) {
            this.f6829i = jSONObject.optInt("sequenceNumber", -1);
        } else {
            this.f6863a.w(str.concat(" message is missing a sequence number."), new Object[0]);
        }
    }

    public final long zzA(zzas zzasVar, int i10, long j10, MediaQueueItem[] mediaQueueItemArr, int i11, Boolean bool, Integer num, JSONObject jSONObject) throws IllegalStateException, JSONException, IllegalArgumentException, zzao {
        if (j10 != -1 && j10 < 0) {
            throw new IllegalArgumentException(c.h("playPosition cannot be negative: ", j10));
        }
        JSONObject jSONObject2 = new JSONObject();
        long jZzd = zzd();
        try {
            jSONObject2.put("requestId", jZzd);
            jSONObject2.put("type", "QUEUE_UPDATE");
            jSONObject2.put("mediaSessionId", zzn());
            if (i10 != 0) {
                jSONObject2.put("currentItemId", i10);
            }
            if (i11 != 0) {
                jSONObject2.put("jump", i11);
            }
            if (mediaQueueItemArr != null && mediaQueueItemArr.length > 0) {
                JSONArray jSONArray = new JSONArray();
                for (int i12 = 0; i12 < mediaQueueItemArr.length; i12++) {
                    jSONArray.put(i12, mediaQueueItemArr[i12].toJson());
                }
                jSONObject2.put("items", jSONArray);
            }
            if (bool != null) {
                jSONObject2.put("shuffle", bool);
            }
            String strZza = MediaCommon.zza(num);
            if (strZza != null) {
                jSONObject2.put("repeatMode", strZza);
            }
            if (j10 != -1) {
                jSONObject2.put("currentTime", CastUtils.millisecToSec(j10));
            }
            if (jSONObject != null) {
                jSONObject2.put("customData", jSONObject);
            }
            int i13 = this.f6829i;
            if (i13 != -1) {
                jSONObject2.put("sequenceNumber", i13);
            }
        } catch (JSONException unused) {
        }
        zzg(jSONObject2.toString(), jZzd, null);
        this.f6838r.zzb(jZzd, new zzam(this, zzasVar));
        return jZzd;
    }

    public final long zzB(zzas zzasVar) throws IllegalStateException, JSONException {
        JSONObject jSONObject = new JSONObject();
        long jZzd = zzd();
        try {
            jSONObject.put("requestId", jZzd);
            jSONObject.put("type", "GET_STATUS");
            MediaStatus mediaStatus = this.f6826f;
            if (mediaStatus != null) {
                jSONObject.put("mediaSessionId", mediaStatus.zzb());
            }
        } catch (JSONException unused) {
        }
        zzg(jSONObject.toString(), jZzd, null);
        this.f6836p.zzb(jZzd, zzasVar);
        return jZzd;
    }

    public final long zzC(zzas zzasVar, MediaSeekOptions mediaSeekOptions) throws IllegalStateException, JSONException, zzao {
        JSONObject jSONObject = new JSONObject();
        long jZzd = zzd();
        long position = mediaSeekOptions.isSeekToInfinite() ? 4294967296000L : mediaSeekOptions.getPosition();
        try {
            jSONObject.put("requestId", jZzd);
            jSONObject.put("type", "SEEK");
            jSONObject.put("mediaSessionId", zzn());
            jSONObject.put("currentTime", CastUtils.millisecToSec(position));
            if (mediaSeekOptions.getResumeState() == 1) {
                jSONObject.put("resumeState", "PLAYBACK_START");
            } else if (mediaSeekOptions.getResumeState() == 2) {
                jSONObject.put("resumeState", "PLAYBACK_PAUSE");
            }
            if (mediaSeekOptions.getCustomData() != null) {
                jSONObject.put("customData", mediaSeekOptions.getCustomData());
            }
        } catch (JSONException unused) {
        }
        zzg(jSONObject.toString(), jZzd, null);
        this.f6827g = Long.valueOf(position);
        this.f6833m.zzb(jZzd, new zzal(this, zzasVar));
        return jZzd;
    }

    public final long zzD(zzas zzasVar, long[] jArr) throws IllegalStateException, JSONException, zzao {
        if (jArr == null) {
            throw new IllegalArgumentException("trackIds cannot be null");
        }
        JSONObject jSONObject = new JSONObject();
        long jZzd = zzd();
        try {
            jSONObject.put("requestId", jZzd);
            jSONObject.put("type", "EDIT_TRACKS_INFO");
            jSONObject.put("mediaSessionId", zzn());
            JSONArray jSONArray = new JSONArray();
            for (int i10 = 0; i10 < jArr.length; i10++) {
                jSONArray.put(i10, jArr[i10]);
            }
            jSONObject.put("activeTrackIds", jSONArray);
        } catch (JSONException unused) {
        }
        zzg(jSONObject.toString(), jZzd, null);
        this.f6837q.zzb(jZzd, zzasVar);
        return jZzd;
    }

    public final long zzI(zzas zzasVar) throws IllegalStateException, JSONException, zzao {
        JSONObject jSONObject = new JSONObject();
        long jZzd = zzd();
        try {
            jSONObject.put("requestId", jZzd);
            jSONObject.put("type", "SKIP_AD");
            jSONObject.put("mediaSessionId", zzn());
        } catch (JSONException e10) {
            this.f6863a.w(String.format(Locale.ROOT, "Error creating SkipAd message: %s", e10.getMessage()), new Object[0]);
        }
        zzg(jSONObject.toString(), jZzd, null);
        this.f6842v.zzb(jZzd, zzasVar);
        return jZzd;
    }

    public final MediaInfo zzK() {
        MediaStatus mediaStatus = this.f6826f;
        if (mediaStatus == null) {
            return null;
        }
        return mediaStatus.getMediaInfo();
    }

    public final MediaStatus zzL() {
        return this.f6826f;
    }

    /* JADX WARN: Can't fix incorrect switch cases order, some code will duplicate */
    /* JADX WARN: Failed to restore switch over string. Please report as a decompilation issue */
    /* JADX WARN: Removed duplicated region for block: B:34:0x008d  */
    /* JADX WARN: Removed duplicated region for block: B:65:0x0122  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public final void zzO(java.lang.String r17) {
        /*
            Method dump skipped, instructions count: 894
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.gms.cast.internal.zzaq.zzO(java.lang.String):void");
    }

    public final void zzP(long j10, int i10) {
        Iterator it = zza().iterator();
        while (it.hasNext()) {
            ((zzau) it.next()).zzd(j10, i10, null);
        }
    }

    public final void zzQ(zzan zzanVar) {
        this.f6828h = zzanVar;
    }

    @Override // com.google.android.gms.cast.internal.zzp
    public final void zzf() {
        zzb();
        c();
    }

    public final long zzj() {
        MediaStatus mediaStatus;
        AdBreakStatus adBreakStatus;
        if (this.f6825e == 0 || (mediaStatus = this.f6826f) == null || (adBreakStatus = mediaStatus.getAdBreakStatus()) == null) {
            return 0L;
        }
        double playbackRate = mediaStatus.getPlaybackRate();
        if (playbackRate == 0.0d) {
            playbackRate = 1.0d;
        }
        return a(mediaStatus.getPlayerState() != 2 ? 0.0d : playbackRate, adBreakStatus.getCurrentBreakClipTimeInMs(), 0L);
    }

    public final long zzk() {
        MediaLiveSeekableRange liveSeekableRange;
        MediaStatus mediaStatus = this.f6826f;
        if (mediaStatus == null || (liveSeekableRange = mediaStatus.getLiveSeekableRange()) == null) {
            return 0L;
        }
        long endTime = liveSeekableRange.getEndTime();
        return !liveSeekableRange.isLiveDone() ? a(1.0d, endTime, -1L) : endTime;
    }

    public final long zzl() {
        MediaLiveSeekableRange liveSeekableRange;
        MediaStatus mediaStatus = this.f6826f;
        if (mediaStatus == null || (liveSeekableRange = mediaStatus.getLiveSeekableRange()) == null) {
            return 0L;
        }
        long startTime = liveSeekableRange.getStartTime();
        if (liveSeekableRange.isMovingWindow()) {
            startTime = a(1.0d, startTime, -1L);
        }
        return liveSeekableRange.isLiveDone() ? Math.min(startTime, liveSeekableRange.getEndTime()) : startTime;
    }

    public final long zzm() {
        MediaStatus mediaStatus;
        MediaInfo mediaInfoZzK = zzK();
        if (mediaInfoZzK == null || (mediaStatus = this.f6826f) == null) {
            return 0L;
        }
        Long l10 = this.f6827g;
        if (l10 == null) {
            if (this.f6825e == 0) {
                return 0L;
            }
            double playbackRate = mediaStatus.getPlaybackRate();
            long streamPosition = mediaStatus.getStreamPosition();
            return (playbackRate == 0.0d || mediaStatus.getPlayerState() != 2) ? streamPosition : a(playbackRate, streamPosition, mediaInfoZzK.getStreamDuration());
        }
        if (l10.equals(4294967296000L)) {
            if (this.f6826f.getLiveSeekableRange() != null) {
                return Math.min(l10.longValue(), zzk());
            }
            if (zzo() >= 0) {
                return Math.min(l10.longValue(), zzo());
            }
        }
        return l10.longValue();
    }

    public final long zzn() throws zzao {
        MediaStatus mediaStatus = this.f6826f;
        if (mediaStatus != null) {
            return mediaStatus.zzb();
        }
        throw new zzao();
    }

    public final long zzo() {
        MediaInfo mediaInfoZzK = zzK();
        if (mediaInfoZzK != null) {
            return mediaInfoZzK.getStreamDuration();
        }
        return 0L;
    }

    public final long zzp(zzas zzasVar, MediaLoadRequestData mediaLoadRequestData) throws IllegalStateException, JSONException, IllegalArgumentException {
        if (mediaLoadRequestData.getMediaInfo() == null && mediaLoadRequestData.getQueueData() == null) {
            throw new IllegalArgumentException("MediaInfo and MediaQueueData should not be both null");
        }
        JSONObject json = mediaLoadRequestData.toJson();
        if (json == null) {
            throw new IllegalArgumentException("Failed to jsonify the load request due to malformed request");
        }
        long jZzd = zzd();
        try {
            json.put("requestId", jZzd);
            json.put("type", "LOAD");
        } catch (JSONException unused) {
        }
        zzg(json.toString(), jZzd, null);
        this.f6830j.zzb(jZzd, zzasVar);
        return jZzd;
    }

    public final long zzq(zzas zzasVar, JSONObject jSONObject) throws IllegalStateException, JSONException, zzao {
        JSONObject jSONObject2 = new JSONObject();
        long jZzd = zzd();
        try {
            jSONObject2.put("requestId", jZzd);
            jSONObject2.put("type", "PAUSE");
            jSONObject2.put("mediaSessionId", zzn());
            if (jSONObject != null) {
                jSONObject2.put("customData", jSONObject);
            }
        } catch (JSONException unused) {
        }
        zzg(jSONObject2.toString(), jZzd, null);
        this.f6831k.zzb(jZzd, zzasVar);
        return jZzd;
    }

    public final long zzr(zzas zzasVar, JSONObject jSONObject) throws IllegalStateException, JSONException, zzao {
        JSONObject jSONObject2 = new JSONObject();
        long jZzd = zzd();
        try {
            jSONObject2.put("requestId", jZzd);
            jSONObject2.put("type", "PLAY");
            jSONObject2.put("mediaSessionId", zzn());
            if (jSONObject != null) {
                jSONObject2.put("customData", jSONObject);
            }
        } catch (JSONException unused) {
        }
        zzg(jSONObject2.toString(), jZzd, null);
        this.f6832l.zzb(jZzd, zzasVar);
        return jZzd;
    }

    public final long zzu(zzas zzasVar) throws IllegalStateException, JSONException, zzao {
        JSONObject jSONObject = new JSONObject();
        long jZzd = zzd();
        try {
            jSONObject.put("requestId", jZzd);
            jSONObject.put("type", "QUEUE_GET_ITEM_IDS");
            jSONObject.put("mediaSessionId", zzn());
        } catch (JSONException unused) {
        }
        zzg(jSONObject.toString(), jZzd, null);
        this.f6839s.zzb(jZzd, zzasVar);
        return jZzd;
    }

    public final long zzv(zzas zzasVar, int[] iArr) throws IllegalStateException, JSONException, IllegalArgumentException, zzao {
        JSONObject jSONObject = new JSONObject();
        long jZzd = zzd();
        try {
            jSONObject.put("requestId", jZzd);
            jSONObject.put("type", "QUEUE_GET_ITEMS");
            jSONObject.put("mediaSessionId", zzn());
            JSONArray jSONArray = new JSONArray();
            for (int i10 : iArr) {
                jSONArray.put(i10);
            }
            jSONObject.put("itemIds", jSONArray);
        } catch (JSONException unused) {
        }
        zzg(jSONObject.toString(), jZzd, null);
        this.f6840t.zzb(jZzd, zzasVar);
        return jZzd;
    }
}
