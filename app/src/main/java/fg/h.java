package fg;

import fg.a;
import org.apache.commons.lang3.ClassUtils;
import zf.i;

/* compiled from: _Ranges.kt */
/* loaded from: classes2.dex */
public class h extends g {
    public static final int coerceAtLeast(int i10, int i11) {
        return i10 < i11 ? i11 : i10;
    }

    public static final int coerceAtMost(int i10, int i11) {
        return i10 > i11 ? i11 : i10;
    }

    public static final int coerceIn(int i10, int i11, int i12) {
        if (i11 <= i12) {
            return i10 < i11 ? i11 : i10 > i12 ? i12 : i10;
        }
        throw new IllegalArgumentException("Cannot coerce value to an empty range: maximum " + i12 + " is less than minimum " + i11 + ClassUtils.PACKAGE_SEPARATOR_CHAR);
    }

    public static final a downTo(int i10, int i11) {
        return a.f11544o.fromClosedRange(i10, i11, -1);
    }

    public static final a step(a aVar, int i10) {
        i.checkNotNullParameter(aVar, "<this>");
        g.checkStepIsPositive(i10 > 0, Integer.valueOf(i10));
        a.C0139a c0139a = a.f11544o;
        int first = aVar.getFirst();
        int last = aVar.getLast();
        if (aVar.getStep() <= 0) {
            i10 = -i10;
        }
        return c0139a.fromClosedRange(first, last, i10);
    }

    public static final c until(int i10, int i11) {
        return i11 <= Integer.MIN_VALUE ? c.f11552p.getEMPTY() : new c(i10, i11 - 1);
    }

    public static final long coerceAtLeast(long j10, long j11) {
        return j10 < j11 ? j11 : j10;
    }

    public static final long coerceAtMost(long j10, long j11) {
        return j10 > j11 ? j11 : j10;
    }

    public static final long coerceIn(long j10, long j11, long j12) {
        if (j11 <= j12) {
            return j10 < j11 ? j11 : j10 > j12 ? j12 : j10;
        }
        throw new IllegalArgumentException("Cannot coerce value to an empty range: maximum " + j12 + " is less than minimum " + j11 + ClassUtils.PACKAGE_SEPARATOR_CHAR);
    }
}
