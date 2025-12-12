package com.uwetrottmann.trakt5.enums;

/* loaded from: classes2.dex */
public enum HistoryType implements TraktEnum {
    MOVIES("movies"),
    SHOWS("shows"),
    SEASONS("seasons"),
    EPISODES("episodes");

    private final String value;

    HistoryType(String str) {
        this.value = str;
    }

    @Override // java.lang.Enum, com.uwetrottmann.trakt5.enums.TraktEnum
    public String toString() {
        return this.value;
    }
}
