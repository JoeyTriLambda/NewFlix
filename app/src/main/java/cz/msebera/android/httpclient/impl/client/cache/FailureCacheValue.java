package cz.msebera.android.httpclient.impl.client.cache;

import ac.c;
import cz.msebera.android.httpclient.annotation.Contract;
import cz.msebera.android.httpclient.annotation.ThreadingBehavior;

@Contract(threading = ThreadingBehavior.IMMUTABLE)
/* loaded from: classes2.dex */
public class FailureCacheValue {
    private final long creationTimeInNanos = System.nanoTime();
    private final int errorCount;
    private final String key;

    public FailureCacheValue(String str, int i10) {
        this.key = str;
        this.errorCount = i10;
    }

    public long getCreationTimeInNanos() {
        return this.creationTimeInNanos;
    }

    public int getErrorCount() {
        return this.errorCount;
    }

    public String getKey() {
        return this.key;
    }

    public String toString() {
        StringBuilder sb2 = new StringBuilder("[entry creationTimeInNanos=");
        sb2.append(this.creationTimeInNanos);
        sb2.append("; key=");
        sb2.append(this.key);
        sb2.append("; errorCount=");
        return c.l(sb2, this.errorCount, ']');
    }
}
