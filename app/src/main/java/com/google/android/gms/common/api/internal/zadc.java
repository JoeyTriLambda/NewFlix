package com.google.android.gms.common.api.internal;

import com.google.android.gms.common.api.Status;
import com.google.android.gms.common.util.VisibleForTesting;
import java.util.Collections;
import java.util.Set;
import java.util.WeakHashMap;

/* compiled from: com.google.android.gms:play-services-base@@18.0.1 */
/* loaded from: classes.dex */
public final class zadc {

    /* renamed from: a, reason: collision with root package name */
    @VisibleForTesting
    public final Set<BasePendingResult<?>> f7256a = Collections.synchronizedSet(Collections.newSetFromMap(new WeakHashMap()));

    static {
        new Status(8, "The connection to Google Play services was lost");
    }
}
