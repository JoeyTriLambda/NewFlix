package g8;

import android.os.SystemClock;
import com.google.auto.value.AutoValue;

/* compiled from: StartupTime.java */
@AutoValue
/* loaded from: classes.dex */
public abstract class j {
    public static j create(long j10, long j11, long j12) {
        return new a(j10, j11, j12);
    }

    public static j now() {
        return create(System.currentTimeMillis(), SystemClock.elapsedRealtime(), SystemClock.uptimeMillis());
    }

    public abstract long getElapsedRealtime();

    public abstract long getEpochMillis();

    public abstract long getUptimeMillis();
}
