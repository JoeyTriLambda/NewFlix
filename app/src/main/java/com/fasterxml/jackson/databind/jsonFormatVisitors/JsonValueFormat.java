package com.fasterxml.jackson.databind.jsonFormatVisitors;

import com.fasterxml.jackson.annotation.JsonValue;
import org.adblockplus.libadblockplus.HttpClient;

/* loaded from: classes.dex */
public enum JsonValueFormat {
    COLOR("color"),
    DATE(HttpClient.HEADER_DATE),
    DATE_TIME("date-time"),
    EMAIL("email"),
    HOST_NAME("host-name"),
    IP_ADDRESS("ip-address"),
    IPV6("ipv6"),
    PHONE("phone"),
    REGEX("regex"),
    STYLE("style"),
    TIME("time"),
    URI("uri"),
    UTC_MILLISEC("utc-millisec"),
    UUID("uuid");

    private final String _desc;

    JsonValueFormat(String str) {
        this._desc = str;
    }

    @Override // java.lang.Enum
    @JsonValue
    public String toString() {
        return this._desc;
    }
}
