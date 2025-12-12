package l6;

import android.text.TextUtils;
import com.unity3d.services.core.device.MimeTypes;

/* compiled from: MimeTypes.java */
/* loaded from: classes.dex */
public final class i {
    public static String a(String str) {
        if (str == null) {
            return null;
        }
        int iIndexOf = str.indexOf(47);
        if (iIndexOf != -1) {
            return str.substring(0, iIndexOf);
        }
        throw new IllegalArgumentException("Invalid mime type: ".concat(str));
    }

    public static String getAudioMediaMimeType(String str) {
        if (str == null) {
            return null;
        }
        for (String str2 : str.split(",")) {
            String mediaMimeType = getMediaMimeType(str2);
            if (mediaMimeType != null && isAudio(mediaMimeType)) {
                return mediaMimeType;
            }
        }
        return null;
    }

    public static String getMediaMimeType(String str) {
        if (str == null) {
            return null;
        }
        String strTrim = str.trim();
        if (strTrim.startsWith("avc1") || strTrim.startsWith("avc3")) {
            return MimeTypes.VIDEO_H264;
        }
        if (strTrim.startsWith("hev1") || strTrim.startsWith("hvc1")) {
            return MimeTypes.VIDEO_H265;
        }
        if (strTrim.startsWith("vp9") || strTrim.startsWith("vp09")) {
            return "video/x-vnd.on2.vp9";
        }
        if (strTrim.startsWith("vp8") || strTrim.startsWith("vp08")) {
            return "video/x-vnd.on2.vp8";
        }
        if (strTrim.startsWith("mp4a")) {
            return "audio/mp4a-latm";
        }
        if (strTrim.startsWith("ac-3") || strTrim.startsWith("dac3")) {
            return "audio/ac3";
        }
        if (strTrim.startsWith("ec-3") || strTrim.startsWith("dec3")) {
            return "audio/eac3";
        }
        if (strTrim.startsWith("dtsc") || strTrim.startsWith("dtse")) {
            return "audio/vnd.dts";
        }
        if (strTrim.startsWith("dtsh") || strTrim.startsWith("dtsl")) {
            return "audio/vnd.dts.hd";
        }
        if (strTrim.startsWith("opus")) {
            return "audio/opus";
        }
        if (strTrim.startsWith("vorbis")) {
            return "audio/vorbis";
        }
        return null;
    }

    public static int getTrackType(String str) {
        if (TextUtils.isEmpty(str)) {
            return -1;
        }
        if (isAudio(str)) {
            return 1;
        }
        if (isVideo(str)) {
            return 2;
        }
        if (isText(str) || "application/cea-608".equals(str) || "application/cea-708".equals(str) || "application/x-mp4-cea-608".equals(str) || "application/x-subrip".equals(str) || "application/ttml+xml".equals(str) || "application/x-quicktime-tx3g".equals(str) || "application/x-mp4-vtt".equals(str) || "application/x-rawcc".equals(str) || "application/vobsub".equals(str) || "application/pgs".equals(str) || "application/dvbsubs".equals(str)) {
            return 3;
        }
        return ("application/id3".equals(str) || "application/x-emsg".equals(str) || "application/x-scte35".equals(str) || "application/x-camera-motion".equals(str)) ? 4 : -1;
    }

    public static int getTrackTypeOfCodec(String str) {
        return getTrackType(getMediaMimeType(str));
    }

    public static String getVideoMediaMimeType(String str) {
        if (str == null) {
            return null;
        }
        for (String str2 : str.split(",")) {
            String mediaMimeType = getMediaMimeType(str2);
            if (mediaMimeType != null && isVideo(mediaMimeType)) {
                return mediaMimeType;
            }
        }
        return null;
    }

    public static boolean isAudio(String str) {
        return MimeTypes.BASE_TYPE_AUDIO.equals(a(str));
    }

    public static boolean isText(String str) {
        return "text".equals(a(str));
    }

    public static boolean isVideo(String str) {
        return MimeTypes.BASE_TYPE_VIDEO.equals(a(str));
    }
}
