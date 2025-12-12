package com.google.android.gms.cast.framework;

import java.util.concurrent.Callable;

/* compiled from: com.google.android.gms:play-services-cast-framework@@21.4.0 */
/* loaded from: classes.dex */
public final /* synthetic */ class zzi implements Callable {
    @Override // java.util.concurrent.Callable
    public final Object call() {
        synchronized (CastContext.f6338n) {
            if (CastContext.f6339o == null) {
                throw null;
            }
        }
        return CastContext.f6339o;
    }
}
