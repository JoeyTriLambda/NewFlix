package com.uwetrottmann.trakt5.enums;

import java.util.HashMap;
import java.util.Locale;
import java.util.Map;

/* loaded from: classes2.dex */
public enum ProgressLastActivity implements TraktEnum {
    COLLECTED("collected"),
    WATCHED("watched");

    private static final Map<String, ProgressLastActivity> STRING_MAPPING = new HashMap();
    private final String value;

    static {
        for (ProgressLastActivity progressLastActivity : values()) {
            STRING_MAPPING.put(progressLastActivity.toString().toUpperCase(Locale.ROOT), progressLastActivity);
        }
    }

    ProgressLastActivity(String str) {
        this.value = str;
    }

    public static ProgressLastActivity fromValue(String str) {
        return STRING_MAPPING.get(str.toUpperCase(Locale.ROOT));
    }

    @Override // java.lang.Enum, com.uwetrottmann.trakt5.enums.TraktEnum
    public String toString() {
        return this.value;
    }
}
