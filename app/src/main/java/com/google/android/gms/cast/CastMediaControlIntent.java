package com.google.android.gms.cast;

import java.util.Collection;

/* compiled from: com.google.android.gms:play-services-cast@@21.4.0 */
/* loaded from: classes.dex */
public final class CastMediaControlIntent {
    private CastMediaControlIntent() {
    }

    public static String categoryForCast(String str) throws IllegalArgumentException {
        if (str != null) {
            return zzw.a(new zzw("com.google.android.gms.cast.CATEGORY_CAST", str, new zzu(0).f7008a));
        }
        throw new IllegalArgumentException("applicationId cannot be null");
    }

    public static String categoryForCast(String str, Collection<String> collection) {
        if (str == null) {
            throw new IllegalArgumentException("applicationId cannot be null");
        }
        if (collection != null) {
            new zzu(0).f7008a = collection;
            return zzw.a(new zzw("com.google.android.gms.cast.CATEGORY_CAST", str, collection));
        }
        throw new IllegalArgumentException("namespaces cannot be null");
    }
}
