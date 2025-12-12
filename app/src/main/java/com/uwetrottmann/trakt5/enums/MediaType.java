package com.uwetrottmann.trakt5.enums;

import java.util.HashMap;
import java.util.Map;

/* loaded from: classes2.dex */
public enum MediaType implements TraktEnum {
    DIGITAL("digital"),
    BLURAY("bluray"),
    HDDVD("hddvd"),
    DVD("dvd"),
    VCD("vcd"),
    VHS("vhs"),
    BETAMAX("betamax"),
    LASERDISC("laserdisc");

    private static final Map<String, MediaType> STRING_MAPPING = new HashMap();
    private final String value;

    static {
        for (MediaType mediaType : values()) {
            STRING_MAPPING.put(mediaType.toString(), mediaType);
        }
    }

    MediaType(String str) {
        this.value = str;
    }

    public static MediaType fromValue(String str) {
        return STRING_MAPPING.get(str);
    }

    @Override // java.lang.Enum, com.uwetrottmann.trakt5.enums.TraktEnum
    public String toString() {
        return this.value;
    }
}
