package com.google.android.gms.internal.common;

import ac.c;
import org.jspecify.nullness.NullMarked;

/* compiled from: com.google.android.gms:play-services-basement@@18.3.0 */
@NullMarked
/* loaded from: classes.dex */
public final class zzah {
    public static Object[] zza(Object[] objArr, int i10) {
        for (int i11 = 0; i11 < i10; i11++) {
            if (objArr[i11] == null) {
                throw new NullPointerException(c.f("at index ", i11));
            }
        }
        return objArr;
    }
}
