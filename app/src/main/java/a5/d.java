package a5;

import android.os.SystemClock;

/* compiled from: UptimeClock.java */
/* loaded from: classes.dex */
public final class d implements a {
    @Override // a5.a
    public long getTime() {
        return SystemClock.elapsedRealtime();
    }
}
