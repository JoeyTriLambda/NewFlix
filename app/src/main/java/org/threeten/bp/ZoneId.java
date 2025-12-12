package org.threeten.bp;

import ac.c;
import java.io.DataOutput;
import java.io.IOException;
import java.io.Serializable;
import java.util.Collections;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Locale;
import java.util.Map;
import java.util.Set;
import java.util.TimeZone;
import o1.a;
import org.apache.commons.lang3.time.TimeZones;
import org.threeten.bp.format.DateTimeFormatterBuilder;
import org.threeten.bp.format.TextStyle;
import org.threeten.bp.jdk8.DefaultInterfaceTemporalAccessor;
import org.threeten.bp.jdk8.Jdk8Methods;
import org.threeten.bp.temporal.TemporalAccessor;
import org.threeten.bp.temporal.TemporalField;
import org.threeten.bp.temporal.TemporalQueries;
import org.threeten.bp.temporal.TemporalQuery;
import org.threeten.bp.temporal.UnsupportedTemporalTypeException;
import org.threeten.bp.zone.ZoneRules;
import org.threeten.bp.zone.ZoneRulesException;
import org.threeten.bp.zone.ZoneRulesProvider;

/* loaded from: classes2.dex */
public abstract class ZoneId implements Serializable {
    public static final TemporalQuery<ZoneId> FROM = new TemporalQuery<ZoneId>() { // from class: org.threeten.bp.ZoneId.1
        @Override // org.threeten.bp.temporal.TemporalQuery
        public ZoneId queryFrom(TemporalAccessor temporalAccessor) {
            return ZoneId.from(temporalAccessor);
        }
    };
    public static final Map<String, String> SHORT_IDS;
    private static final long serialVersionUID = 8352817235686L;

    static {
        HashMap mapX = c.x("ACT", "Australia/Darwin", "AET", "Australia/Sydney");
        mapX.put("AGT", "America/Argentina/Buenos_Aires");
        mapX.put("ART", "Africa/Cairo");
        mapX.put("AST", "America/Anchorage");
        mapX.put("BET", "America/Sao_Paulo");
        mapX.put("BST", "Asia/Dhaka");
        mapX.put("CAT", "Africa/Harare");
        mapX.put("CNT", "America/St_Johns");
        mapX.put("CST", "America/Chicago");
        mapX.put("CTT", "Asia/Shanghai");
        mapX.put("EAT", "Africa/Addis_Ababa");
        mapX.put("ECT", "Europe/Paris");
        mapX.put("IET", "America/Indiana/Indianapolis");
        mapX.put("IST", "Asia/Kolkata");
        mapX.put("JST", "Asia/Tokyo");
        mapX.put("MIT", "Pacific/Apia");
        mapX.put("NET", "Asia/Yerevan");
        mapX.put("NST", "Pacific/Auckland");
        mapX.put("PLT", "Asia/Karachi");
        mapX.put("PNT", "America/Phoenix");
        mapX.put("PRT", "America/Puerto_Rico");
        mapX.put("PST", "America/Los_Angeles");
        mapX.put("SST", "Pacific/Guadalcanal");
        mapX.put("VST", "Asia/Ho_Chi_Minh");
        mapX.put("EST", "-05:00");
        mapX.put("MST", "-07:00");
        mapX.put("HST", "-10:00");
        SHORT_IDS = Collections.unmodifiableMap(mapX);
    }

    public ZoneId() {
        if (getClass() != ZoneOffset.class && getClass() != ZoneRegion.class) {
            throw new AssertionError("Invalid subclass");
        }
    }

    public static ZoneId from(TemporalAccessor temporalAccessor) {
        ZoneId zoneId = (ZoneId) temporalAccessor.query(TemporalQueries.zone());
        if (zoneId != null) {
            return zoneId;
        }
        throw new DateTimeException("Unable to obtain ZoneId from TemporalAccessor: " + temporalAccessor + ", type " + temporalAccessor.getClass().getName());
    }

    public static Set<String> getAvailableZoneIds() {
        return new HashSet(ZoneRulesProvider.getAvailableZoneIds());
    }

    public static ZoneId of(String str, Map<String, String> map) {
        Jdk8Methods.requireNonNull(str, "zoneId");
        Jdk8Methods.requireNonNull(map, "aliasMap");
        String str2 = map.get(str);
        if (str2 != null) {
            str = str2;
        }
        return of(str);
    }

    public static ZoneId ofOffset(String str, ZoneOffset zoneOffset) {
        Jdk8Methods.requireNonNull(str, "prefix");
        Jdk8Methods.requireNonNull(zoneOffset, "offset");
        if (str.length() == 0) {
            return zoneOffset;
        }
        if (!str.equals(TimeZones.GMT_ID) && !str.equals("UTC") && !str.equals("UT")) {
            throw new IllegalArgumentException("Invalid prefix, must be GMT, UTC or UT: ".concat(str));
        }
        if (zoneOffset.getTotalSeconds() == 0) {
            return new ZoneRegion(str, zoneOffset.getRules());
        }
        StringBuilder sbR = c.r(str);
        sbR.append(zoneOffset.getId());
        return new ZoneRegion(sbR.toString(), zoneOffset.getRules());
    }

    public static ZoneId systemDefault() {
        return of(TimeZone.getDefault().getID(), SHORT_IDS);
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj instanceof ZoneId) {
            return getId().equals(((ZoneId) obj).getId());
        }
        return false;
    }

    public String getDisplayName(TextStyle textStyle, Locale locale) {
        return new DateTimeFormatterBuilder().appendZoneText(textStyle).toFormatter(locale).format(new DefaultInterfaceTemporalAccessor() { // from class: org.threeten.bp.ZoneId.2
            @Override // org.threeten.bp.temporal.TemporalAccessor
            public long getLong(TemporalField temporalField) {
                throw new UnsupportedTemporalTypeException(a.e("Unsupported field: ", temporalField));
            }

            @Override // org.threeten.bp.temporal.TemporalAccessor
            public boolean isSupported(TemporalField temporalField) {
                return false;
            }

            @Override // org.threeten.bp.jdk8.DefaultInterfaceTemporalAccessor, org.threeten.bp.temporal.TemporalAccessor
            public <R> R query(TemporalQuery<R> temporalQuery) {
                return temporalQuery == TemporalQueries.zoneId() ? (R) ZoneId.this : (R) super.query(temporalQuery);
            }
        });
    }

    public abstract String getId();

    public abstract ZoneRules getRules();

    public int hashCode() {
        return getId().hashCode();
    }

    public ZoneId normalized() {
        try {
            ZoneRules rules = getRules();
            if (rules.isFixedOffset()) {
                return rules.getOffset(Instant.EPOCH);
            }
        } catch (ZoneRulesException unused) {
        }
        return this;
    }

    public String toString() {
        return getId();
    }

    public abstract void write(DataOutput dataOutput) throws IOException;

    public static ZoneId of(String str) {
        Jdk8Methods.requireNonNull(str, "zoneId");
        if (str.equals("Z")) {
            return ZoneOffset.UTC;
        }
        if (str.length() != 1) {
            if (!str.startsWith("+") && !str.startsWith("-")) {
                if (!str.equals("UTC") && !str.equals(TimeZones.GMT_ID) && !str.equals("UT")) {
                    if (!str.startsWith("UTC+") && !str.startsWith("GMT+") && !str.startsWith("UTC-") && !str.startsWith("GMT-")) {
                        if (!str.startsWith("UT+") && !str.startsWith("UT-")) {
                            return ZoneRegion.ofId(str, true);
                        }
                        ZoneOffset zoneOffsetOf = ZoneOffset.of(str.substring(2));
                        if (zoneOffsetOf.getTotalSeconds() == 0) {
                            return new ZoneRegion("UT", zoneOffsetOf.getRules());
                        }
                        return new ZoneRegion("UT" + zoneOffsetOf.getId(), zoneOffsetOf.getRules());
                    }
                    ZoneOffset zoneOffsetOf2 = ZoneOffset.of(str.substring(3));
                    if (zoneOffsetOf2.getTotalSeconds() == 0) {
                        return new ZoneRegion(str.substring(0, 3), zoneOffsetOf2.getRules());
                    }
                    return new ZoneRegion(str.substring(0, 3) + zoneOffsetOf2.getId(), zoneOffsetOf2.getRules());
                }
                return new ZoneRegion(str, ZoneOffset.UTC.getRules());
            }
            return ZoneOffset.of(str);
        }
        throw new DateTimeException("Invalid zone: ".concat(str));
    }
}
