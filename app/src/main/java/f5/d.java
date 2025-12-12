package f5;

import android.util.Pair;
import com.google.android.exoplayer2.drm.DrmSession;
import java.util.Map;

/* compiled from: WidevineUtil.java */
/* loaded from: classes.dex */
public final class d {
    public static Pair<Long, Long> getLicenseDurationRemainingSec(DrmSession<?> drmSession) throws NumberFormatException {
        String str;
        Map<String, String> mapQueryKeyStatus = ((com.google.android.exoplayer2.drm.a) drmSession).queryKeyStatus();
        if (mapQueryKeyStatus == null) {
            return null;
        }
        long j10 = -9223372036854775807L;
        try {
            str = mapQueryKeyStatus.get("LicenseDurationRemaining");
        } catch (NumberFormatException unused) {
        }
        long j11 = str != null ? Long.parseLong(str) : -9223372036854775807L;
        Long lValueOf = Long.valueOf(j11);
        try {
            String str2 = mapQueryKeyStatus.get("PlaybackDurationRemaining");
            if (str2 != null) {
                j10 = Long.parseLong(str2);
            }
        } catch (NumberFormatException unused2) {
        }
        return new Pair<>(lValueOf, Long.valueOf(j10));
    }
}
