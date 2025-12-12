package com.uwetrottmann.trakt5.enums;

import java.util.HashMap;
import java.util.Locale;
import java.util.Map;

/* loaded from: classes2.dex */
public enum Status implements TraktEnum {
    ENDED("ended"),
    RETURNING("returning series"),
    CANCELED("canceled"),
    IN_PRODUCTION("in production");

    private static final Map<String, Status> STRING_MAPPING = new HashMap();
    private final String value;

    static {
        for (Status status : values()) {
            STRING_MAPPING.put(status.toString().toUpperCase(Locale.ROOT), status);
        }
    }

    Status(String str) {
        this.value = str;
    }

    public static Status fromValue(String str) {
        return STRING_MAPPING.get(str.toUpperCase(Locale.ROOT));
    }

    @Override // java.lang.Enum, com.uwetrottmann.trakt5.enums.TraktEnum
    public String toString() {
        return this.value;
    }
}
