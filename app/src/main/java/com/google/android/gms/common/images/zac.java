package com.google.android.gms.common.images;

import android.graphics.Bitmap;
import android.net.Uri;
import com.google.android.gms.common.internal.Asserts;
import java.util.concurrent.CountDownLatch;

/* compiled from: com.google.android.gms:play-services-base@@18.0.1 */
/* loaded from: classes.dex */
final class zac implements Runnable {

    /* renamed from: b, reason: collision with root package name */
    public final /* synthetic */ ImageManager f7302b;

    public zac(ImageManager imageManager, Uri uri, Bitmap bitmap, boolean z10, CountDownLatch countDownLatch) {
        this.f7302b = imageManager;
    }

    @Override // java.lang.Runnable
    public final void run() {
        Asserts.checkMainThread("OnBitmapLoadedRunnable must be executed in the main thread");
        ImageManager imageManager = this.f7302b;
        Object obj = ImageManager.f7297a;
        imageManager.getClass();
        throw null;
    }
}
