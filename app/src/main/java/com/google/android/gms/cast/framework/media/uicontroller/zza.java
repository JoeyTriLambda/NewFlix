package com.google.android.gms.cast.framework.media.uicontroller;

import android.text.format.DateUtils;
import com.google.android.gms.cast.MediaInfo;
import com.google.android.gms.cast.MediaMetadata;
import com.google.android.gms.cast.MediaQueueItem;
import com.google.android.gms.cast.MediaStatus;
import com.google.android.gms.cast.framework.media.RemoteMediaClient;
import com.google.android.gms.common.internal.Preconditions;
import com.google.android.gms.common.internal.ShowFirstParty;
import java.text.DateFormat;
import java.util.Date;

/* compiled from: com.google.android.gms:play-services-cast-framework@@21.4.0 */
@ShowFirstParty
/* loaded from: classes.dex */
public final class zza {

    /* renamed from: a, reason: collision with root package name */
    public RemoteMediaClient f6623a;

    private zza() {
    }

    public static final String d(long j10) {
        return j10 >= 0 ? DateUtils.formatElapsedTime(j10 / 1000) : "-".concat(String.valueOf(DateUtils.formatElapsedTime((-j10) / 1000)));
    }

    public static zza zzf() {
        return new zza();
    }

    public final Long a() {
        RemoteMediaClient remoteMediaClient;
        MediaStatus mediaStatus;
        RemoteMediaClient remoteMediaClient2 = this.f6623a;
        if (remoteMediaClient2 == null || !remoteMediaClient2.hasMediaSession() || !this.f6623a.isLiveStream() || !this.f6623a.zzw() || (mediaStatus = (remoteMediaClient = this.f6623a).getMediaStatus()) == null || mediaStatus.getLiveSeekableRange() == null) {
            return null;
        }
        return Long.valueOf(remoteMediaClient.getApproximateLiveSeekableRangeEnd());
    }

    public final Long b() {
        RemoteMediaClient remoteMediaClient;
        MediaStatus mediaStatus;
        RemoteMediaClient remoteMediaClient2 = this.f6623a;
        if (remoteMediaClient2 == null || !remoteMediaClient2.hasMediaSession() || !this.f6623a.isLiveStream() || !this.f6623a.zzw() || (mediaStatus = (remoteMediaClient = this.f6623a).getMediaStatus()) == null || mediaStatus.getLiveSeekableRange() == null) {
            return null;
        }
        return Long.valueOf(remoteMediaClient.getApproximateLiveSeekableRangeStart());
    }

    public final Long c() {
        MediaInfo mediaInfo;
        RemoteMediaClient remoteMediaClient = this.f6623a;
        if (remoteMediaClient == null || !remoteMediaClient.hasMediaSession() || !this.f6623a.isLiveStream() || (mediaInfo = this.f6623a.getMediaInfo()) == null || mediaInfo.getStartAbsoluteTime() == -1) {
            return null;
        }
        return Long.valueOf(mediaInfo.getStartAbsoluteTime());
    }

    public final int zza() {
        RemoteMediaClient remoteMediaClient = this.f6623a;
        if (remoteMediaClient != null && remoteMediaClient.hasMediaSession()) {
            RemoteMediaClient remoteMediaClient2 = this.f6623a;
            if (remoteMediaClient2.isLiveStream() || !remoteMediaClient2.isLoadingNextItem()) {
                int approximateStreamPosition = (int) (remoteMediaClient2.getApproximateStreamPosition() - zze());
                if (remoteMediaClient2.zzw()) {
                    int iZzd = zzd();
                    approximateStreamPosition = Math.min(Math.max(approximateStreamPosition, iZzd), zzc());
                }
                return Math.min(Math.max(approximateStreamPosition, 0), zzb());
            }
        }
        return 0;
    }

    public final int zzb() {
        MediaInfo media;
        RemoteMediaClient remoteMediaClient = this.f6623a;
        long jLongValue = 1;
        if (remoteMediaClient != null && remoteMediaClient.hasMediaSession()) {
            RemoteMediaClient remoteMediaClient2 = this.f6623a;
            if (remoteMediaClient2.isLiveStream()) {
                Long lZzi = zzi();
                if (lZzi != null) {
                    jLongValue = lZzi.longValue();
                } else {
                    Long lA = a();
                    jLongValue = lA != null ? lA.longValue() : Math.max(remoteMediaClient2.getApproximateStreamPosition(), 1L);
                }
            } else if (remoteMediaClient2.isLoadingNextItem()) {
                MediaQueueItem loadingItem = remoteMediaClient2.getLoadingItem();
                if (loadingItem != null && (media = loadingItem.getMedia()) != null) {
                    jLongValue = Math.max(media.getStreamDuration(), 1L);
                }
            } else {
                jLongValue = Math.max(remoteMediaClient2.getStreamDuration(), 1L);
            }
        }
        return Math.max((int) (jLongValue - zze()), 1);
    }

    public final int zzc() {
        RemoteMediaClient remoteMediaClient = this.f6623a;
        if (remoteMediaClient == null || !remoteMediaClient.hasMediaSession() || !this.f6623a.isLiveStream()) {
            return zzb();
        }
        if (!this.f6623a.zzw()) {
            return 0;
        }
        long jLongValue = ((Long) Preconditions.checkNotNull(a())).longValue() - zze();
        return Math.min(Math.max((int) jLongValue, 0), zzb());
    }

    public final int zzd() {
        RemoteMediaClient remoteMediaClient = this.f6623a;
        if (remoteMediaClient == null || !remoteMediaClient.hasMediaSession() || !this.f6623a.isLiveStream() || !this.f6623a.zzw()) {
            return 0;
        }
        long jLongValue = ((Long) Preconditions.checkNotNull(b())).longValue() - zze();
        return Math.min(Math.max((int) jLongValue, 0), zzb());
    }

    public final long zze() {
        RemoteMediaClient remoteMediaClient = this.f6623a;
        if (remoteMediaClient == null || !remoteMediaClient.hasMediaSession() || !this.f6623a.isLiveStream()) {
            return 0L;
        }
        RemoteMediaClient remoteMediaClient2 = this.f6623a;
        Long lZzj = zzj();
        if (lZzj != null) {
            return lZzj.longValue();
        }
        Long lB = b();
        return lB != null ? lB.longValue() : remoteMediaClient2.getApproximateStreamPosition();
    }

    public final Long zzi() {
        Long lZzj;
        MediaInfo mediaInfo;
        RemoteMediaClient remoteMediaClient = this.f6623a;
        if (remoteMediaClient != null && remoteMediaClient.hasMediaSession() && this.f6623a.isLiveStream()) {
            RemoteMediaClient remoteMediaClient2 = this.f6623a;
            MediaMetadata metadata = (remoteMediaClient2 == null || !remoteMediaClient2.hasMediaSession() || (mediaInfo = this.f6623a.getMediaInfo()) == null) ? null : mediaInfo.getMetadata();
            if (metadata != null && metadata.containsKey("com.google.android.gms.cast.metadata.SECTION_DURATION") && (lZzj = zzj()) != null) {
                return Long.valueOf(metadata.getTimeMillis("com.google.android.gms.cast.metadata.SECTION_DURATION") + lZzj.longValue());
            }
        }
        return null;
    }

    public final Long zzj() {
        MediaInfo mediaInfo;
        RemoteMediaClient remoteMediaClient = this.f6623a;
        if (remoteMediaClient != null && remoteMediaClient.hasMediaSession() && this.f6623a.isLiveStream()) {
            RemoteMediaClient remoteMediaClient2 = this.f6623a;
            MediaInfo mediaInfo2 = remoteMediaClient2.getMediaInfo();
            RemoteMediaClient remoteMediaClient3 = this.f6623a;
            MediaMetadata metadata = (remoteMediaClient3 == null || !remoteMediaClient3.hasMediaSession() || (mediaInfo = this.f6623a.getMediaInfo()) == null) ? null : mediaInfo.getMetadata();
            if (mediaInfo2 != null && metadata != null && metadata.containsKey("com.google.android.gms.cast.metadata.SECTION_START_TIME_IN_MEDIA") && (metadata.containsKey("com.google.android.gms.cast.metadata.SECTION_DURATION") || remoteMediaClient2.zzw())) {
                return Long.valueOf(metadata.getTimeMillis("com.google.android.gms.cast.metadata.SECTION_START_TIME_IN_MEDIA"));
            }
        }
        return null;
    }

    public final String zzl(long j10) {
        RemoteMediaClient remoteMediaClient = this.f6623a;
        if (remoteMediaClient == null || !remoteMediaClient.hasMediaSession()) {
            return null;
        }
        RemoteMediaClient remoteMediaClient2 = this.f6623a;
        int i10 = 1;
        if (remoteMediaClient2 != null && remoteMediaClient2.hasMediaSession() && this.f6623a.isLiveStream() && c() != null) {
            i10 = 2;
        }
        if (i10 - 1 != 0) {
            return DateFormat.getTimeInstance().format(new Date(((Long) Preconditions.checkNotNull(c())).longValue() + j10));
        }
        return (remoteMediaClient2.isLiveStream() && zzj() == null) ? d(j10) : d(j10 - zze());
    }

    public final boolean zzm() {
        return zzn(zze() + zza());
    }

    public final boolean zzn(long j10) {
        RemoteMediaClient remoteMediaClient = this.f6623a;
        if (remoteMediaClient != null && remoteMediaClient.hasMediaSession() && this.f6623a.zzw()) {
            return (zze() + ((long) zzc())) - j10 < 10000;
        }
        return false;
    }
}
