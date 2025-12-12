package cz.msebera.android.httpclient.pool;

import ac.c;
import cz.msebera.android.httpclient.annotation.Contract;
import cz.msebera.android.httpclient.annotation.ThreadingBehavior;
import java.io.Serializable;

@Contract(threading = ThreadingBehavior.IMMUTABLE)
/* loaded from: classes2.dex */
public class PoolStats implements Serializable {
    private static final long serialVersionUID = -2807686144795228544L;
    private final int available;
    private final int leased;
    private final int max;
    private final int pending;

    public PoolStats(int i10, int i11, int i12, int i13) {
        this.leased = i10;
        this.pending = i11;
        this.available = i12;
        this.max = i13;
    }

    public int getAvailable() {
        return this.available;
    }

    public int getLeased() {
        return this.leased;
    }

    public int getMax() {
        return this.max;
    }

    public int getPending() {
        return this.pending;
    }

    public String toString() {
        StringBuilder sb2 = new StringBuilder("[leased: ");
        sb2.append(this.leased);
        sb2.append("; pending: ");
        sb2.append(this.pending);
        sb2.append("; available: ");
        sb2.append(this.available);
        sb2.append("; max: ");
        return c.m(sb2, this.max, "]");
    }
}
