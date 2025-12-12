package com.google.android.gms.common.api.internal;

import com.google.android.gms.common.api.ApiException;
import com.google.android.gms.common.api.Status;
import com.google.android.gms.tasks.TaskCompletionSource;
import java.util.Collections;
import java.util.HashMap;
import java.util.Map;
import java.util.WeakHashMap;

/* compiled from: com.google.android.gms:play-services-base@@18.0.1 */
/* loaded from: classes.dex */
public final class zaad {

    /* renamed from: a, reason: collision with root package name */
    public final Map<BasePendingResult<?>, Boolean> f7139a = Collections.synchronizedMap(new WeakHashMap());

    /* renamed from: b, reason: collision with root package name */
    public final Map<TaskCompletionSource<?>, Boolean> f7140b = Collections.synchronizedMap(new WeakHashMap());

    public final void a(boolean z10, Status status) {
        HashMap map;
        HashMap map2;
        synchronized (this.f7139a) {
            map = new HashMap(this.f7139a);
        }
        synchronized (this.f7140b) {
            map2 = new HashMap(this.f7140b);
        }
        for (Map.Entry entry : map.entrySet()) {
            if (z10 || ((Boolean) entry.getValue()).booleanValue()) {
                ((BasePendingResult) entry.getKey()).forceFailureUnlessReady(status);
            }
        }
        for (Map.Entry entry2 : map2.entrySet()) {
            if (z10 || ((Boolean) entry2.getValue()).booleanValue()) {
                ((TaskCompletionSource) entry2.getKey()).trySetException(new ApiException(status));
            }
        }
    }

    public final void zaf() {
        a(false, GoogleApiManager.A);
    }
}
