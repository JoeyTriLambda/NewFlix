package com.uwetrottmann.trakt5.enums;

/* loaded from: classes2.dex */
public enum Rating implements TraktEnum {
    WEAKSAUCE(1),
    TERRIBLE(2),
    BAD(3),
    POOR(4),
    MEH(5),
    FAIR(6),
    GOOD(7),
    GREAT(8),
    SUPERB(9),
    TOTALLYNINJA(10);

    public int value;

    Rating(int i10) {
        this.value = i10;
    }

    public static Rating fromValue(int i10) {
        return values()[i10 - 1];
    }

    @Override // java.lang.Enum, com.uwetrottmann.trakt5.enums.TraktEnum
    public String toString() {
        return String.valueOf(this.value);
    }
}
