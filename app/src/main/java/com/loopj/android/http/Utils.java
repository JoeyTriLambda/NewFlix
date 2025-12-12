package com.loopj.android.http;

import ac.c;

/* loaded from: classes.dex */
class Utils {
    private Utils() {
    }

    public static void asserts(boolean z10, String str) {
        if (!z10) {
            throw new AssertionError(str);
        }
    }

    public static <T> T notNull(T t10, String str) {
        if (t10 != null) {
            return t10;
        }
        throw new IllegalArgumentException(c.B(str, " should not be null!"));
    }
}
