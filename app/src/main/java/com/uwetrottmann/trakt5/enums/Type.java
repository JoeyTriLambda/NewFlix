package com.uwetrottmann.trakt5.enums;

/* loaded from: classes2.dex */
public enum Type implements TraktEnum {
    MOVIE("movie"),
    SHOW("show"),
    EPISODE("episode"),
    PERSON("person"),
    LIST("list");

    private final String value;

    Type(String str) {
        this.value = str;
    }

    @Override // java.lang.Enum, com.uwetrottmann.trakt5.enums.TraktEnum
    public String toString() {
        return this.value;
    }
}
