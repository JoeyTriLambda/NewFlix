package org.threeten.bp.temporal;

import org.threeten.bp.Duration;

/* loaded from: classes2.dex */
public interface TemporalUnit {
    <R extends Temporal> R addTo(R r10, long j10);

    long between(Temporal temporal, Temporal temporal2);

    Duration getDuration();

    boolean isDateBased();

    boolean isDurationEstimated();

    boolean isSupportedBy(Temporal temporal);

    boolean isTimeBased();

    String toString();
}
