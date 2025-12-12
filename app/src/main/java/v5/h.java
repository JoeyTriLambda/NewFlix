package v5;

import android.util.Log;
import com.google.android.exoplayer2.upstream.HttpDataSource$InvalidResponseCodeException;
import org.apache.commons.lang3.time.DateUtils;

/* compiled from: ChunkedTrackBlacklistUtil.java */
/* loaded from: classes.dex */
public final class h {
    public static boolean maybeBlacklistTrack(j6.f fVar, int i10, Exception exc) {
        return maybeBlacklistTrack(fVar, i10, exc, DateUtils.MILLIS_PER_MINUTE);
    }

    public static boolean shouldBlacklist(Exception exc) {
        if (!(exc instanceof HttpDataSource$InvalidResponseCodeException)) {
            return false;
        }
        int i10 = ((HttpDataSource$InvalidResponseCodeException) exc).f6027b;
        return i10 == 404 || i10 == 410;
    }

    public static boolean maybeBlacklistTrack(j6.f fVar, int i10, Exception exc, long j10) {
        if (!shouldBlacklist(exc)) {
            return false;
        }
        boolean zBlacklist = fVar.blacklist(i10, j10);
        int i11 = ((HttpDataSource$InvalidResponseCodeException) exc).f6027b;
        if (zBlacklist) {
            Log.w("ChunkedTrackBlacklist", "Blacklisted: duration=" + j10 + ", responseCode=" + i11 + ", format=" + fVar.getFormat(i10));
        } else {
            StringBuilder sbS = ac.c.s("Blacklisting failed (cannot blacklist last enabled track): responseCode=", i11, ", format=");
            sbS.append(fVar.getFormat(i10));
            Log.w("ChunkedTrackBlacklist", sbS.toString());
        }
        return zBlacklist;
    }
}
