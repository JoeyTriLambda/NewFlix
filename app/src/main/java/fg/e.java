package fg;

import java.util.NoSuchElementException;
import mf.u;

/* compiled from: ProgressionIterators.kt */
/* loaded from: classes2.dex */
public final class e extends u {

    /* renamed from: b, reason: collision with root package name */
    public final long f11557b;

    /* renamed from: m, reason: collision with root package name */
    public final long f11558m;

    /* renamed from: n, reason: collision with root package name */
    public boolean f11559n;

    /* renamed from: o, reason: collision with root package name */
    public long f11560o;

    public e(long j10, long j11, long j12) {
        this.f11557b = j12;
        this.f11558m = j11;
        boolean z10 = true;
        if (j12 <= 0 ? j10 < j11 : j10 > j11) {
            z10 = false;
        }
        this.f11559n = z10;
        this.f11560o = z10 ? j10 : j11;
    }

    @Override // java.util.Iterator
    public boolean hasNext() {
        return this.f11559n;
    }

    @Override // mf.u
    public long nextLong() {
        long j10 = this.f11560o;
        if (j10 != this.f11558m) {
            this.f11560o = this.f11557b + j10;
        } else {
            if (!this.f11559n) {
                throw new NoSuchElementException();
            }
            this.f11559n = false;
        }
        return j10;
    }
}
