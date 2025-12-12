package com.google.android.gms.common.util;

import android.os.SystemClock;
import com.google.android.gms.common.annotation.KeepForSdk;

/* compiled from: com.google.android.gms:play-services-basement@@18.3.0 */
@KeepForSdk
/* loaded from: classes.dex */
public class DefaultClock implements Clock {

    /* renamed from: a, reason: collision with root package name */
    public static final DefaultClock f7500a = new DefaultClock();

    private DefaultClock() {
    }

    @KeepForSdk
    public static Clock getInstance() {
        return f7500a;
    }

    @Override // com.google.android.gms.common.util.Clock
    public final long currentTimeMillis() {
        return System.currentTimeMillis();
    }

    @Override // com.google.android.gms.common.util.Clock
    public final long elapsedRealtime() {
        return SystemClock.elapsedRealtime();
    }

    @Override // com.google.android.gms.common.util.Clock
    public final long nanoTime() {
        return System.nanoTime();
    }
}
