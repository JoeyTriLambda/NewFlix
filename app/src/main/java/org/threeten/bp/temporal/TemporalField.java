package org.threeten.bp.temporal;

import java.util.Locale;
import java.util.Map;
import org.threeten.bp.format.ResolverStyle;

/* loaded from: classes2.dex */
public interface TemporalField {
    <R extends Temporal> R adjustInto(R r10, long j10);

    TemporalUnit getBaseUnit();

    String getDisplayName(Locale locale);

    long getFrom(TemporalAccessor temporalAccessor);

    TemporalUnit getRangeUnit();

    boolean isDateBased();

    boolean isSupportedBy(TemporalAccessor temporalAccessor);

    boolean isTimeBased();

    ValueRange range();

    ValueRange rangeRefinedBy(TemporalAccessor temporalAccessor);

    TemporalAccessor resolve(Map<TemporalField, Long> map, TemporalAccessor temporalAccessor, ResolverStyle resolverStyle);
}
