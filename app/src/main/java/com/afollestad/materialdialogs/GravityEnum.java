package com.afollestad.materialdialogs;

import android.annotation.SuppressLint;
import android.annotation.TargetApi;

/* loaded from: classes.dex */
public enum GravityEnum {
    START,
    CENTER,
    END;

    @SuppressLint({"RtlHardcoded"})
    public int getGravityInt() {
        int iOrdinal = ordinal();
        if (iOrdinal == 0) {
            return 8388611;
        }
        if (iOrdinal == 1) {
            return 1;
        }
        if (iOrdinal == 2) {
            return 8388613;
        }
        throw new IllegalStateException("Invalid gravity constant");
    }

    @TargetApi(17)
    public int getTextAlignment() {
        int iOrdinal = ordinal();
        if (iOrdinal != 1) {
            return iOrdinal != 2 ? 5 : 6;
        }
        return 4;
    }
}
