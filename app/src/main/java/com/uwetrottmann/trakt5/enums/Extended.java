package com.uwetrottmann.trakt5.enums;

/* loaded from: classes2.dex */
public enum Extended implements TraktEnum {
    FULL("full"),
    NOSEASONS("noseasons"),
    EPISODES("episodes"),
    FULLEPISODES("full,episodes"),
    METADATA("metadata");

    private final String value;

    Extended(String str) {
        this.value = str;
    }

    @Override // java.lang.Enum, com.uwetrottmann.trakt5.enums.TraktEnum
    public String toString() {
        return this.value;
    }
}
