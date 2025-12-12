package com.squareup.picasso;

/* loaded from: classes2.dex */
public enum NetworkPolicy {
    /* JADX INFO: Fake field, exist only in values array */
    NO_CACHE(1),
    /* JADX INFO: Fake field, exist only in values array */
    NO_STORE(2),
    /* JADX INFO: Fake field, exist only in values array */
    OFFLINE(4);

    NetworkPolicy(int i10) {
    }

    public static boolean isOfflineOnly(int i10) {
        return (i10 & 4) != 0;
    }

    public static boolean shouldReadFromDiskCache(int i10) {
        return (i10 & 1) == 0;
    }

    public static boolean shouldWriteToDiskCache(int i10) {
        return (i10 & 2) == 0;
    }
}
