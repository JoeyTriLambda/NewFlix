package p5;

import ac.c;
import android.annotation.TargetApi;
import android.graphics.Point;
import android.media.MediaCodecInfo;
import android.util.Log;
import android.util.Pair;
import com.google.android.exoplayer2.mediacodec.MediaCodecUtil;
import l6.i;
import l6.u;

/* compiled from: MediaCodecInfo.java */
@TargetApi(16)
/* loaded from: classes.dex */
public final class a {

    /* renamed from: a, reason: collision with root package name */
    public final String f17598a;

    /* renamed from: b, reason: collision with root package name */
    public final boolean f17599b;

    /* renamed from: c, reason: collision with root package name */
    public final boolean f17600c;

    /* renamed from: d, reason: collision with root package name */
    public final boolean f17601d;

    /* renamed from: e, reason: collision with root package name */
    public final String f17602e;

    /* renamed from: f, reason: collision with root package name */
    public final MediaCodecInfo.CodecCapabilities f17603f;

    /* JADX WARN: Removed duplicated region for block: B:13:0x002a  */
    /* JADX WARN: Removed duplicated region for block: B:24:0x0044  */
    /* JADX WARN: Removed duplicated region for block: B:36:0x005d  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public a(java.lang.String r2, java.lang.String r3, android.media.MediaCodecInfo.CodecCapabilities r4, boolean r5, boolean r6) {
        /*
            r1 = this;
            r1.<init>()
            java.lang.Object r2 = l6.a.checkNotNull(r2)
            java.lang.String r2 = (java.lang.String) r2
            r1.f17598a = r2
            r1.f17602e = r3
            r1.f17603f = r4
            r2 = 1
            r3 = 0
            if (r5 != 0) goto L2a
            if (r4 == 0) goto L2a
            int r5 = l6.u.f15907a
            r0 = 19
            if (r5 < r0) goto L25
            java.lang.String r5 = "adaptive-playback"
            boolean r5 = r4.isFeatureSupported(r5)
            if (r5 == 0) goto L25
            r5 = 1
            goto L26
        L25:
            r5 = 0
        L26:
            if (r5 == 0) goto L2a
            r5 = 1
            goto L2b
        L2a:
            r5 = 0
        L2b:
            r1.f17599b = r5
            r5 = 21
            if (r4 == 0) goto L44
            int r0 = l6.u.f15907a
            if (r0 < r5) goto L3f
            java.lang.String r0 = "tunneled-playback"
            boolean r0 = r4.isFeatureSupported(r0)
            if (r0 == 0) goto L3f
            r0 = 1
            goto L40
        L3f:
            r0 = 0
        L40:
            if (r0 == 0) goto L44
            r0 = 1
            goto L45
        L44:
            r0 = 0
        L45:
            r1.f17600c = r0
            if (r6 != 0) goto L5e
            if (r4 == 0) goto L5d
            int r6 = l6.u.f15907a
            if (r6 < r5) goto L59
            java.lang.String r5 = "secure-playback"
            boolean r4 = r4.isFeatureSupported(r5)
            if (r4 == 0) goto L59
            r4 = 1
            goto L5a
        L59:
            r4 = 0
        L5a:
            if (r4 == 0) goto L5d
            goto L5e
        L5d:
            r2 = 0
        L5e:
            r1.f17601d = r2
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: p5.a.<init>(java.lang.String, java.lang.String, android.media.MediaCodecInfo$CodecCapabilities, boolean, boolean):void");
    }

    public static a newInstance(String str, String str2, MediaCodecInfo.CodecCapabilities codecCapabilities, boolean z10, boolean z11) {
        return new a(str, str2, codecCapabilities, z10, z11);
    }

    public static a newPassthroughInstance(String str) {
        return new a(str, null, null, false, false);
    }

    public final void a(String str) {
        StringBuilder sbV = c.v("NoSupport [", str, "] [");
        sbV.append(this.f17598a);
        sbV.append(", ");
        sbV.append(this.f17602e);
        sbV.append("] [");
        sbV.append(u.f15911e);
        sbV.append("]");
        Log.d("MediaCodecInfo", sbV.toString());
    }

    @TargetApi(21)
    public Point alignVideoSizeV21(int i10, int i11) {
        MediaCodecInfo.CodecCapabilities codecCapabilities = this.f17603f;
        if (codecCapabilities == null) {
            a("align.caps");
            return null;
        }
        MediaCodecInfo.VideoCapabilities videoCapabilities = codecCapabilities.getVideoCapabilities();
        if (videoCapabilities == null) {
            a("align.vCaps");
            return null;
        }
        int widthAlignment = videoCapabilities.getWidthAlignment();
        int heightAlignment = videoCapabilities.getHeightAlignment();
        return new Point(u.ceilDivide(i10, widthAlignment) * widthAlignment, u.ceilDivide(i11, heightAlignment) * heightAlignment);
    }

    public MediaCodecInfo.CodecProfileLevel[] getProfileLevels() {
        MediaCodecInfo.CodecProfileLevel[] codecProfileLevelArr;
        MediaCodecInfo.CodecCapabilities codecCapabilities = this.f17603f;
        return (codecCapabilities == null || (codecProfileLevelArr = codecCapabilities.profileLevels) == null) ? new MediaCodecInfo.CodecProfileLevel[0] : codecProfileLevelArr;
    }

    @TargetApi(21)
    public boolean isAudioChannelCountSupportedV21(int i10) {
        MediaCodecInfo.CodecCapabilities codecCapabilities = this.f17603f;
        if (codecCapabilities == null) {
            a("channelCount.caps");
            return false;
        }
        MediaCodecInfo.AudioCapabilities audioCapabilities = codecCapabilities.getAudioCapabilities();
        if (audioCapabilities == null) {
            a("channelCount.aCaps");
            return false;
        }
        int maxInputChannelCount = audioCapabilities.getMaxInputChannelCount();
        if (maxInputChannelCount <= 1 && (u.f15907a < 26 || maxInputChannelCount <= 0)) {
            String str = this.f17602e;
            if (!"audio/mpeg".equals(str) && !"audio/3gpp".equals(str) && !"audio/amr-wb".equals(str) && !"audio/mp4a-latm".equals(str) && !"audio/vorbis".equals(str) && !"audio/opus".equals(str) && !"audio/raw".equals(str) && !"audio/flac".equals(str) && !"audio/g711-alaw".equals(str) && !"audio/g711-mlaw".equals(str) && !"audio/gsm".equals(str)) {
                int i11 = "audio/ac3".equals(str) ? 6 : "audio/eac3".equals(str) ? 16 : 30;
                Log.w("MediaCodecInfo", "AssumedMaxChannelAdjustment: " + this.f17598a + ", [" + maxInputChannelCount + " to " + i11 + "]");
                maxInputChannelCount = i11;
            }
        }
        if (maxInputChannelCount >= i10) {
            return true;
        }
        a("channelCount.support, " + i10);
        return false;
    }

    @TargetApi(21)
    public boolean isAudioSampleRateSupportedV21(int i10) {
        MediaCodecInfo.CodecCapabilities codecCapabilities = this.f17603f;
        if (codecCapabilities == null) {
            a("sampleRate.caps");
            return false;
        }
        MediaCodecInfo.AudioCapabilities audioCapabilities = codecCapabilities.getAudioCapabilities();
        if (audioCapabilities == null) {
            a("sampleRate.aCaps");
            return false;
        }
        if (audioCapabilities.isSampleRateSupported(i10)) {
            return true;
        }
        a("sampleRate.support, " + i10);
        return false;
    }

    public boolean isCodecSupported(String str) {
        String str2;
        String mediaMimeType;
        if (str == null || (str2 = this.f17602e) == null || (mediaMimeType = i.getMediaMimeType(str)) == null) {
            return true;
        }
        if (!str2.equals(mediaMimeType)) {
            a("codec.mime " + str + ", " + mediaMimeType);
            return false;
        }
        Pair<Integer, Integer> codecProfileAndLevel = MediaCodecUtil.getCodecProfileAndLevel(str);
        if (codecProfileAndLevel == null) {
            return true;
        }
        for (MediaCodecInfo.CodecProfileLevel codecProfileLevel : getProfileLevels()) {
            if (codecProfileLevel.profile == ((Integer) codecProfileAndLevel.first).intValue() && codecProfileLevel.level >= ((Integer) codecProfileAndLevel.second).intValue()) {
                return true;
            }
        }
        a("codec.profileLevel, " + str + ", " + mediaMimeType);
        return false;
    }

    @TargetApi(21)
    public boolean isVideoSizeAndRateSupportedV21(int i10, int i11, double d10) {
        MediaCodecInfo.CodecCapabilities codecCapabilities = this.f17603f;
        if (codecCapabilities == null) {
            a("sizeAndRate.caps");
            return false;
        }
        MediaCodecInfo.VideoCapabilities videoCapabilities = codecCapabilities.getVideoCapabilities();
        if (videoCapabilities == null) {
            a("sizeAndRate.vCaps");
            return false;
        }
        if ((d10 == -1.0d || d10 <= 0.0d) ? videoCapabilities.isSizeSupported(i10, i11) : videoCapabilities.areSizeAndRateSupported(i10, i11, d10)) {
            return true;
        }
        if (i10 < i11) {
            if ((d10 == -1.0d || d10 <= 0.0d) ? videoCapabilities.isSizeSupported(i11, i10) : videoCapabilities.areSizeAndRateSupported(i11, i10, d10)) {
                StringBuilder sbT = c.t("sizeAndRate.rotated, ", i10, "x", i11, "x");
                sbT.append(d10);
                StringBuilder sbV = c.v("AssumedSupport [", sbT.toString(), "] [");
                sbV.append(this.f17598a);
                sbV.append(", ");
                sbV.append(this.f17602e);
                sbV.append("] [");
                sbV.append(u.f15911e);
                sbV.append("]");
                Log.d("MediaCodecInfo", sbV.toString());
                return true;
            }
        }
        StringBuilder sbT2 = c.t("sizeAndRate.support, ", i10, "x", i11, "x");
        sbT2.append(d10);
        a(sbT2.toString());
        return false;
    }
}
