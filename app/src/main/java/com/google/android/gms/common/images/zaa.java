package com.google.android.gms.common.images;

import com.google.android.gms.common.internal.Asserts;
import java.util.concurrent.CountDownLatch;

/* compiled from: com.google.android.gms:play-services-base@@18.0.1 */
/* loaded from: classes.dex */
final class zaa implements Runnable {
    @Override // java.lang.Runnable
    public final void run() {
        Asserts.checkNotMainThread("LoadBitmapFromDiskRunnable can't be executed in the main thread");
        new CountDownLatch(1);
        Object obj = ImageManager.f7297a;
        throw null;
    }
}
