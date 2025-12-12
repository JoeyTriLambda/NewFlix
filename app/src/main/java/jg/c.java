package jg;

import fg.f;
import fg.h;
import kotlin.time.DurationUnit;
import zf.i;

/* compiled from: Duration.kt */
/* loaded from: classes2.dex */
public final class c {
    public static final long access$millisToNanos(long j10) {
        return j10 * 1000000;
    }

    public static final long toDuration(int i10, DurationUnit durationUnit) {
        i.checkNotNullParameter(durationUnit, "unit");
        return durationUnit.compareTo(DurationUnit.SECONDS) <= 0 ? a.m35constructorimpl(d.convertDurationUnitOverflow(i10, durationUnit, DurationUnit.NANOSECONDS) << 1) : toDuration(i10, durationUnit);
    }

    public static final long toDuration(long j10, DurationUnit durationUnit) {
        i.checkNotNullParameter(durationUnit, "unit");
        DurationUnit durationUnit2 = DurationUnit.NANOSECONDS;
        long jConvertDurationUnitOverflow = d.convertDurationUnitOverflow(4611686018426999999L, durationUnit2, durationUnit);
        if (new f(-jConvertDurationUnitOverflow, jConvertDurationUnitOverflow).contains(j10)) {
            return a.m35constructorimpl(d.convertDurationUnitOverflow(j10, durationUnit, durationUnit2) << 1);
        }
        return a.m35constructorimpl((h.coerceIn(d.convertDurationUnit(j10, durationUnit, DurationUnit.MILLISECONDS), -4611686018427387903L, 4611686018427387903L) << 1) + 1);
    }
}
