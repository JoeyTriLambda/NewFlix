package org.threeten.bp.format;

import java.util.Locale;
import org.apache.commons.lang3.StringUtils;
import org.threeten.bp.DateTimeException;
import org.threeten.bp.Instant;
import org.threeten.bp.ZoneId;
import org.threeten.bp.ZoneOffset;
import org.threeten.bp.chrono.ChronoLocalDate;
import org.threeten.bp.chrono.Chronology;
import org.threeten.bp.chrono.IsoChronology;
import org.threeten.bp.jdk8.DefaultInterfaceTemporalAccessor;
import org.threeten.bp.jdk8.Jdk8Methods;
import org.threeten.bp.temporal.ChronoField;
import org.threeten.bp.temporal.TemporalAccessor;
import org.threeten.bp.temporal.TemporalField;
import org.threeten.bp.temporal.TemporalQueries;
import org.threeten.bp.temporal.TemporalQuery;
import org.threeten.bp.temporal.ValueRange;

/* loaded from: classes2.dex */
final class DateTimePrintContext {
    private Locale locale;
    private int optional;
    private DecimalStyle symbols;
    private TemporalAccessor temporal;

    public DateTimePrintContext(TemporalAccessor temporalAccessor, DateTimeFormatter dateTimeFormatter) {
        this.temporal = adjust(temporalAccessor, dateTimeFormatter);
        this.locale = dateTimeFormatter.getLocale();
        this.symbols = dateTimeFormatter.getDecimalStyle();
    }

    private static TemporalAccessor adjust(final TemporalAccessor temporalAccessor, DateTimeFormatter dateTimeFormatter) {
        Chronology chronology = dateTimeFormatter.getChronology();
        ZoneId zone = dateTimeFormatter.getZone();
        if (chronology == null && zone == null) {
            return temporalAccessor;
        }
        Chronology chronology2 = (Chronology) temporalAccessor.query(TemporalQueries.chronology());
        final ZoneId zoneId = (ZoneId) temporalAccessor.query(TemporalQueries.zoneId());
        final ChronoLocalDate chronoLocalDateDate = null;
        if (Jdk8Methods.equals(chronology2, chronology)) {
            chronology = null;
        }
        if (Jdk8Methods.equals(zoneId, zone)) {
            zone = null;
        }
        if (chronology == null && zone == null) {
            return temporalAccessor;
        }
        final Chronology chronology3 = chronology != null ? chronology : chronology2;
        if (zone != null) {
            zoneId = zone;
        }
        if (zone != null) {
            if (temporalAccessor.isSupported(ChronoField.INSTANT_SECONDS)) {
                if (chronology3 == null) {
                    chronology3 = IsoChronology.INSTANCE;
                }
                return chronology3.zonedDateTime(Instant.from(temporalAccessor), zone);
            }
            ZoneId zoneIdNormalized = zone.normalized();
            ZoneOffset zoneOffset = (ZoneOffset) temporalAccessor.query(TemporalQueries.offset());
            if ((zoneIdNormalized instanceof ZoneOffset) && zoneOffset != null && !zoneIdNormalized.equals(zoneOffset)) {
                throw new DateTimeException("Invalid override zone for temporal: " + zone + StringUtils.SPACE + temporalAccessor);
            }
        }
        if (chronology != null) {
            if (temporalAccessor.isSupported(ChronoField.EPOCH_DAY)) {
                chronoLocalDateDate = chronology3.date(temporalAccessor);
            } else if (chronology != IsoChronology.INSTANCE || chronology2 != null) {
                for (ChronoField chronoField : ChronoField.values()) {
                    if (chronoField.isDateBased() && temporalAccessor.isSupported(chronoField)) {
                        throw new DateTimeException("Invalid override chronology for temporal: " + chronology + StringUtils.SPACE + temporalAccessor);
                    }
                }
            }
        }
        return new DefaultInterfaceTemporalAccessor() { // from class: org.threeten.bp.format.DateTimePrintContext.1
            @Override // org.threeten.bp.temporal.TemporalAccessor
            public long getLong(TemporalField temporalField) {
                return (chronoLocalDateDate == null || !temporalField.isDateBased()) ? temporalAccessor.getLong(temporalField) : chronoLocalDateDate.getLong(temporalField);
            }

            @Override // org.threeten.bp.temporal.TemporalAccessor
            public boolean isSupported(TemporalField temporalField) {
                return (chronoLocalDateDate == null || !temporalField.isDateBased()) ? temporalAccessor.isSupported(temporalField) : chronoLocalDateDate.isSupported(temporalField);
            }

            @Override // org.threeten.bp.jdk8.DefaultInterfaceTemporalAccessor, org.threeten.bp.temporal.TemporalAccessor
            public <R> R query(TemporalQuery<R> temporalQuery) {
                return temporalQuery == TemporalQueries.chronology() ? (R) chronology3 : temporalQuery == TemporalQueries.zoneId() ? (R) zoneId : temporalQuery == TemporalQueries.precision() ? (R) temporalAccessor.query(temporalQuery) : temporalQuery.queryFrom(this);
            }

            @Override // org.threeten.bp.jdk8.DefaultInterfaceTemporalAccessor, org.threeten.bp.temporal.TemporalAccessor
            public ValueRange range(TemporalField temporalField) {
                return (chronoLocalDateDate == null || !temporalField.isDateBased()) ? temporalAccessor.range(temporalField) : chronoLocalDateDate.range(temporalField);
            }
        };
    }

    public void endOptional() {
        this.optional--;
    }

    public Locale getLocale() {
        return this.locale;
    }

    public DecimalStyle getSymbols() {
        return this.symbols;
    }

    public TemporalAccessor getTemporal() {
        return this.temporal;
    }

    public <R> R getValue(TemporalQuery<R> temporalQuery) {
        R r10 = (R) this.temporal.query(temporalQuery);
        if (r10 != null || this.optional != 0) {
            return r10;
        }
        throw new DateTimeException("Unable to extract value: " + this.temporal.getClass());
    }

    public void setDateTime(TemporalAccessor temporalAccessor) {
        Jdk8Methods.requireNonNull(temporalAccessor, "temporal");
        this.temporal = temporalAccessor;
    }

    public void setLocale(Locale locale) {
        Jdk8Methods.requireNonNull(locale, "locale");
        this.locale = locale;
    }

    public void startOptional() {
        this.optional++;
    }

    public String toString() {
        return this.temporal.toString();
    }

    public Long getValue(TemporalField temporalField) {
        try {
            return Long.valueOf(this.temporal.getLong(temporalField));
        } catch (DateTimeException e10) {
            if (this.optional > 0) {
                return null;
            }
            throw e10;
        }
    }

    public DateTimePrintContext(TemporalAccessor temporalAccessor, Locale locale, DecimalStyle decimalStyle) {
        this.temporal = temporalAccessor;
        this.locale = locale;
        this.symbols = decimalStyle;
    }
}
