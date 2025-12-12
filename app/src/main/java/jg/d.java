package jg;

import kotlin.time.DurationUnit;
import zf.i;

/* compiled from: DurationUnitJvm.kt */
/* loaded from: classes2.dex */
public class d {
    public static final long convertDurationUnit(long j10, DurationUnit durationUnit, DurationUnit durationUnit2) {
        i.checkNotNullParameter(durationUnit, "sourceUnit");
        i.checkNotNullParameter(durationUnit2, "targetUnit");
        return durationUnit2.getTimeUnit$kotlin_stdlib().convert(j10, durationUnit.getTimeUnit$kotlin_stdlib());
    }

    public static final long convertDurationUnitOverflow(long j10, DurationUnit durationUnit, DurationUnit durationUnit2) {
        i.checkNotNullParameter(durationUnit, "sourceUnit");
        i.checkNotNullParameter(durationUnit2, "targetUnit");
        return durationUnit2.getTimeUnit$kotlin_stdlib().convert(j10, durationUnit.getTimeUnit$kotlin_stdlib());
    }
}
