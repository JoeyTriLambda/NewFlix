package com.uwetrottmann.trakt5.enums;

import java.util.HashMap;
import java.util.Map;

/* loaded from: classes2.dex */
public enum Hdr implements TraktEnum {
    DOLBY_VISION("dolby_vision"),
    HDR10("hdr10"),
    HDR10_PLUS("hdr10_plus"),
    HLG("hlg");

    private static final Map<String, Hdr> STRING_MAPPING = new HashMap();
    private final String value;

    static {
        for (Hdr hdr : values()) {
            STRING_MAPPING.put(hdr.toString(), hdr);
        }
    }

    Hdr(String str) {
        this.value = str;
    }

    public static Hdr fromValue(String str) {
        return STRING_MAPPING.get(str);
    }

    @Override // java.lang.Enum, com.uwetrottmann.trakt5.enums.TraktEnum
    public String toString() {
        return this.value;
    }
}
