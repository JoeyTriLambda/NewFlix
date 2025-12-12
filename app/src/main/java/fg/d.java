package fg;

import java.util.Iterator;

/* compiled from: Progressions.kt */
/* loaded from: classes2.dex */
public class d implements Iterable<Long>, ag.a {

    /* renamed from: b, reason: collision with root package name */
    public final long f11554b;

    /* renamed from: m, reason: collision with root package name */
    public final long f11555m;

    /* renamed from: n, reason: collision with root package name */
    public final long f11556n;

    /* compiled from: Progressions.kt */
    public static final class a {
        public a(zf.f fVar) {
        }
    }

    static {
        new a(null);
    }

    public d(long j10, long j11, long j12) {
        if (j12 == 0) {
            throw new IllegalArgumentException("Step must be non-zero.");
        }
        if (j12 == Long.MIN_VALUE) {
            throw new IllegalArgumentException("Step must be greater than Long.MIN_VALUE to avoid overflow on negation.");
        }
        this.f11554b = j10;
        this.f11555m = tf.c.getProgressionLastElement(j10, j11, j12);
        this.f11556n = j12;
    }

    public final long getFirst() {
        return this.f11554b;
    }

    public final long getLast() {
        return this.f11555m;
    }

    @Override // java.lang.Iterable
    public Iterator<Long> iterator() {
        return new e(this.f11554b, this.f11555m, this.f11556n);
    }
}
