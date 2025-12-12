package com.uwetrottmann.trakt5.enums;

/* loaded from: classes2.dex */
public enum IdType implements TraktEnum {
    TRAKT("trakt"),
    IMDB("imdb"),
    TMDB("tmdb"),
    TVDB("tvdb"),
    TVRAGE("tvrage");

    private final String value;

    IdType(String str) {
        this.value = str;
    }

    @Override // java.lang.Enum, com.uwetrottmann.trakt5.enums.TraktEnum
    public String toString() {
        return this.value;
    }
}
