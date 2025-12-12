package com.google.android.gms.flags;

import com.google.android.gms.common.annotation.KeepForSdk;

/* compiled from: com.google.android.gms:play-services-flags@@17.0.1 */
@KeepForSdk
/* loaded from: classes.dex */
public final class Singletons {
    static {
        new Singletons();
        synchronized (Singletons.class) {
        }
    }

    private Singletons() {
        new FlagRegistry();
        new zzb();
    }
}
