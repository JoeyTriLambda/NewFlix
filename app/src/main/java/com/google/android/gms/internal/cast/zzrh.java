package com.google.android.gms.internal.cast;

import java.util.concurrent.atomic.AtomicReferenceFieldUpdater;

/* compiled from: com.google.android.gms:play-services-cast@@21.4.0 */
/* loaded from: classes.dex */
public final /* synthetic */ class zzrh {
    public static /* synthetic */ boolean zza(AtomicReferenceFieldUpdater atomicReferenceFieldUpdater, Object obj, Object obj2, Object obj3) {
        boolean z10;
        while (true) {
            if (atomicReferenceFieldUpdater.compareAndSet(obj, obj2, obj3)) {
                z10 = true;
            } else if (atomicReferenceFieldUpdater.get(obj) != obj2) {
                z10 = false;
            } else {
                continue;
            }
            if (z10) {
                return true;
            }
            if (atomicReferenceFieldUpdater.get(obj) != obj2) {
                return false;
            }
        }
    }
}
