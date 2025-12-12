package com.google.android.exoplayer2.mediacodec;

import android.annotation.SuppressLint;
import android.annotation.TargetApi;
import android.media.MediaCodecInfo;
import android.media.MediaCodecList;
import android.text.TextUtils;
import android.util.Log;
import android.util.SparseIntArray;
import com.unity3d.services.core.device.MimeTypes;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.regex.Pattern;
import l6.u;
import okhttp3.internal.http2.Http2;
import okhttp3.internal.http2.Http2Connection;

@SuppressLint({"InlinedApi"})
@TargetApi(16)
/* loaded from: classes.dex */
public final class MediaCodecUtil {

    /* renamed from: d, reason: collision with root package name */
    public static final SparseIntArray f5872d;

    /* renamed from: e, reason: collision with root package name */
    public static final SparseIntArray f5873e;

    /* renamed from: f, reason: collision with root package name */
    public static final HashMap f5874f;

    /* renamed from: a, reason: collision with root package name */
    public static final p5.a f5869a = p5.a.newPassthroughInstance("OMX.google.raw.decoder");

    /* renamed from: b, reason: collision with root package name */
    public static final Pattern f5870b = Pattern.compile("^\\D?(\\d+)$");

    /* renamed from: c, reason: collision with root package name */
    public static final HashMap<a, List<p5.a>> f5871c = new HashMap<>();

    /* renamed from: g, reason: collision with root package name */
    public static int f5875g = -1;

    public static class DecoderQueryException extends Exception {
        public DecoderQueryException(Exception exc) {
            super("Failed to query underlying media codecs", exc);
        }
    }

    public static final class a {

        /* renamed from: a, reason: collision with root package name */
        public final String f5876a;

        /* renamed from: b, reason: collision with root package name */
        public final boolean f5877b;

        public a(String str, boolean z10) {
            this.f5876a = str;
            this.f5877b = z10;
        }

        public boolean equals(Object obj) {
            if (this == obj) {
                return true;
            }
            if (obj == null || obj.getClass() != a.class) {
                return false;
            }
            a aVar = (a) obj;
            return TextUtils.equals(this.f5876a, aVar.f5876a) && this.f5877b == aVar.f5877b;
        }

        public int hashCode() {
            String str = this.f5876a;
            return (((str == null ? 0 : str.hashCode()) + 31) * 31) + (this.f5877b ? 1231 : 1237);
        }
    }

    public interface b {
        int getCodecCount();

        MediaCodecInfo getCodecInfoAt(int i10);

        boolean isSecurePlaybackSupported(String str, MediaCodecInfo.CodecCapabilities codecCapabilities);

        boolean secureDecodersExplicit();
    }

    public static final class c implements b {
        @Override // com.google.android.exoplayer2.mediacodec.MediaCodecUtil.b
        public int getCodecCount() {
            return MediaCodecList.getCodecCount();
        }

        @Override // com.google.android.exoplayer2.mediacodec.MediaCodecUtil.b
        public MediaCodecInfo getCodecInfoAt(int i10) {
            return MediaCodecList.getCodecInfoAt(i10);
        }

        @Override // com.google.android.exoplayer2.mediacodec.MediaCodecUtil.b
        public boolean isSecurePlaybackSupported(String str, MediaCodecInfo.CodecCapabilities codecCapabilities) {
            return MimeTypes.VIDEO_H264.equals(str);
        }

        @Override // com.google.android.exoplayer2.mediacodec.MediaCodecUtil.b
        public boolean secureDecodersExplicit() {
            return false;
        }
    }

    @TargetApi(21)
    public static final class d implements b {

        /* renamed from: a, reason: collision with root package name */
        public final int f5878a;

        /* renamed from: b, reason: collision with root package name */
        public MediaCodecInfo[] f5879b;

        public d(boolean z10) {
            this.f5878a = z10 ? 1 : 0;
        }

        @Override // com.google.android.exoplayer2.mediacodec.MediaCodecUtil.b
        public int getCodecCount() {
            if (this.f5879b == null) {
                this.f5879b = new MediaCodecList(this.f5878a).getCodecInfos();
            }
            return this.f5879b.length;
        }

        @Override // com.google.android.exoplayer2.mediacodec.MediaCodecUtil.b
        public MediaCodecInfo getCodecInfoAt(int i10) {
            if (this.f5879b == null) {
                this.f5879b = new MediaCodecList(this.f5878a).getCodecInfos();
            }
            return this.f5879b[i10];
        }

        @Override // com.google.android.exoplayer2.mediacodec.MediaCodecUtil.b
        public boolean isSecurePlaybackSupported(String str, MediaCodecInfo.CodecCapabilities codecCapabilities) {
            return codecCapabilities.isFeatureSupported("secure-playback");
        }

        @Override // com.google.android.exoplayer2.mediacodec.MediaCodecUtil.b
        public boolean secureDecodersExplicit() {
            return true;
        }
    }

    static {
        SparseIntArray sparseIntArray = new SparseIntArray();
        f5872d = sparseIntArray;
        sparseIntArray.put(66, 1);
        sparseIntArray.put(77, 2);
        sparseIntArray.put(88, 4);
        sparseIntArray.put(100, 8);
        SparseIntArray sparseIntArray2 = new SparseIntArray();
        f5873e = sparseIntArray2;
        sparseIntArray2.put(10, 1);
        sparseIntArray2.put(11, 4);
        sparseIntArray2.put(12, 8);
        sparseIntArray2.put(13, 16);
        sparseIntArray2.put(20, 32);
        sparseIntArray2.put(21, 64);
        sparseIntArray2.put(22, 128);
        sparseIntArray2.put(30, 256);
        sparseIntArray2.put(31, 512);
        sparseIntArray2.put(32, 1024);
        sparseIntArray2.put(40, 2048);
        sparseIntArray2.put(41, 4096);
        sparseIntArray2.put(42, 8192);
        sparseIntArray2.put(50, Http2.INITIAL_MAX_FRAME_SIZE);
        sparseIntArray2.put(51, 32768);
        sparseIntArray2.put(52, 65536);
        HashMap map = new HashMap();
        f5874f = map;
        o1.a.i(1, map, "L30", 4, "L60", 16, "L63", 64, "L90");
        o1.a.i(256, map, "L93", 1024, "L120", 4096, "L123", Http2.INITIAL_MAX_FRAME_SIZE, "L150");
        o1.a.i(65536, map, "L153", 262144, "L156", 1048576, "L180", 4194304, "L183");
        o1.a.i(Http2Connection.OKHTTP_CLIENT_WINDOW_SIZE, map, "L186", 2, "H30", 8, "H60", 32, "H63");
        o1.a.i(128, map, "H90", 512, "H93", 2048, "H120", 8192, "H123");
        o1.a.i(32768, map, "H150", 131072, "H153", 524288, "H156", 2097152, "H180");
        map.put("H183", 8388608);
        map.put("H186", 33554432);
    }

    public static void a(ArrayList arrayList) {
        if (u.f15907a < 26) {
            if (arrayList.size() <= 1 || !"OMX.MTK.AUDIO.DECODER.RAW".equals(((p5.a) arrayList.get(0)).f17598a)) {
                return;
            }
            for (int i10 = 1; i10 < arrayList.size(); i10++) {
                p5.a aVar = (p5.a) arrayList.get(i10);
                if ("OMX.google.raw.decoder".equals(aVar.f17598a)) {
                    arrayList.remove(i10);
                    arrayList.add(0, aVar);
                    return;
                }
            }
        }
    }

    /* JADX WARN: Removed duplicated region for block: B:25:0x006b  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public static java.util.ArrayList b(com.google.android.exoplayer2.mediacodec.MediaCodecUtil.a r17, com.google.android.exoplayer2.mediacodec.MediaCodecUtil.b r18) throws java.lang.Exception {
        /*
            Method dump skipped, instructions count: 262
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.exoplayer2.mediacodec.MediaCodecUtil.b(com.google.android.exoplayer2.mediacodec.MediaCodecUtil$a, com.google.android.exoplayer2.mediacodec.MediaCodecUtil$b):java.util.ArrayList");
    }

    public static boolean c(MediaCodecInfo mediaCodecInfo, String str, boolean z10) {
        if (mediaCodecInfo.isEncoder() || (!z10 && str.endsWith(".secure"))) {
            return false;
        }
        int i10 = u.f15907a;
        if (i10 < 21 && ("CIPAACDecoder".equals(str) || "CIPMP3Decoder".equals(str) || "CIPVorbisDecoder".equals(str) || "CIPAMRNBDecoder".equals(str) || "AACDecoder".equals(str) || "MP3Decoder".equals(str))) {
            return false;
        }
        if (i10 < 18 && "OMX.SEC.MP3.Decoder".equals(str)) {
            return false;
        }
        if (i10 < 18 && "OMX.MTK.AUDIO.DECODER.AAC".equals(str)) {
            String str2 = u.f15908b;
            if ("a70".equals(str2) || ("Xiaomi".equals(u.f15909c) && str2.startsWith("HM"))) {
                return false;
            }
        }
        if (i10 == 16 && "OMX.qcom.audio.decoder.mp3".equals(str)) {
            String str3 = u.f15908b;
            if ("dlxu".equals(str3) || "protou".equals(str3) || "ville".equals(str3) || "villeplus".equals(str3) || "villec2".equals(str3) || str3.startsWith("gee") || "C6602".equals(str3) || "C6603".equals(str3) || "C6606".equals(str3) || "C6616".equals(str3) || "L36h".equals(str3) || "SO-02E".equals(str3)) {
                return false;
            }
        }
        if (i10 == 16 && "OMX.qcom.audio.decoder.aac".equals(str)) {
            String str4 = u.f15908b;
            if ("C1504".equals(str4) || "C1505".equals(str4) || "C1604".equals(str4) || "C1605".equals(str4)) {
                return false;
            }
        }
        if (i10 < 24 && (("OMX.SEC.aac.dec".equals(str) || "OMX.Exynos.AAC.Decoder".equals(str)) && u.f15909c.equals("samsung"))) {
            String str5 = u.f15908b;
            if (str5.startsWith("zeroflte") || str5.startsWith("zerolte") || str5.startsWith("zenlte") || str5.equals("SC-05G") || str5.equals("marinelteatt") || str5.equals("404SC") || str5.equals("SC-04G") || str5.equals("SCV31")) {
                return false;
            }
        }
        if (i10 <= 19 && "OMX.SEC.vp8.dec".equals(str) && "samsung".equals(u.f15909c)) {
            String str6 = u.f15908b;
            if (str6.startsWith("d2") || str6.startsWith("serrano") || str6.startsWith("jflte") || str6.startsWith("santos") || str6.startsWith("t0")) {
                return false;
            }
        }
        return (i10 <= 19 && u.f15908b.startsWith("jflte") && "OMX.qcom.video.decoder.vp8".equals(str)) ? false : true;
    }

    /* JADX WARN: Can't fix incorrect switch cases order, some code will duplicate */
    /* JADX WARN: Failed to restore switch over string. Please report as a decompilation issue */
    /* JADX WARN: Removed duplicated region for block: B:24:0x0047  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public static android.util.Pair<java.lang.Integer, java.lang.Integer> getCodecProfileAndLevel(java.lang.String r11) {
        /*
            Method dump skipped, instructions count: 388
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.exoplayer2.mediacodec.MediaCodecUtil.getCodecProfileAndLevel(java.lang.String):android.util.Pair");
    }

    public static p5.a getDecoderInfo(String str, boolean z10) throws DecoderQueryException {
        List<p5.a> decoderInfos = getDecoderInfos(str, z10);
        if (decoderInfos.isEmpty()) {
            return null;
        }
        return decoderInfos.get(0);
    }

    public static synchronized List<p5.a> getDecoderInfos(String str, boolean z10) throws DecoderQueryException {
        a aVar = new a(str, z10);
        HashMap<a, List<p5.a>> map = f5871c;
        List<p5.a> list = map.get(aVar);
        if (list != null) {
            return list;
        }
        int i10 = u.f15907a;
        ArrayList arrayListB = b(aVar, i10 >= 21 ? new d(z10) : new c());
        if (z10 && arrayListB.isEmpty() && 21 <= i10 && i10 <= 23) {
            arrayListB = b(aVar, new c());
            if (!arrayListB.isEmpty()) {
                Log.w("MediaCodecUtil", "MediaCodecList API didn't list secure decoder for: " + str + ". Assuming: " + ((p5.a) arrayListB.get(0)).f17598a);
            }
        }
        a(arrayListB);
        List<p5.a> listUnmodifiableList = Collections.unmodifiableList(arrayListB);
        map.put(aVar, listUnmodifiableList);
        return listUnmodifiableList;
    }

    public static p5.a getPassthroughDecoderInfo() {
        return f5869a;
    }

    public static int maxH264DecodableFrameSize() throws DecoderQueryException {
        int i10;
        if (f5875g == -1) {
            int iMax = 0;
            p5.a decoderInfo = getDecoderInfo(MimeTypes.VIDEO_H264, false);
            if (decoderInfo != null) {
                MediaCodecInfo.CodecProfileLevel[] profileLevels = decoderInfo.getProfileLevels();
                int length = profileLevels.length;
                int iMax2 = 0;
                while (iMax < length) {
                    int i11 = profileLevels[iMax].level;
                    if (i11 != 1 && i11 != 2) {
                        switch (i11) {
                            case 8:
                            case 16:
                            case 32:
                                i10 = 101376;
                                break;
                            case 64:
                                i10 = 202752;
                                break;
                            case 128:
                            case 256:
                                i10 = 414720;
                                break;
                            case 512:
                                i10 = 921600;
                                break;
                            case 1024:
                                i10 = 1310720;
                                break;
                            case 2048:
                            case 4096:
                                i10 = 2097152;
                                break;
                            case 8192:
                                i10 = 2228224;
                                break;
                            case Http2.INITIAL_MAX_FRAME_SIZE /* 16384 */:
                                i10 = 5652480;
                                break;
                            case 32768:
                            case 65536:
                                i10 = 9437184;
                                break;
                            default:
                                i10 = -1;
                                break;
                        }
                    } else {
                        i10 = 25344;
                    }
                    iMax2 = Math.max(i10, iMax2);
                    iMax++;
                }
                iMax = Math.max(iMax2, u.f15907a >= 21 ? 345600 : 172800);
            }
            f5875g = iMax;
        }
        return f5875g;
    }
}
