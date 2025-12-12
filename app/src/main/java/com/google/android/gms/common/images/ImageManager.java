package com.google.android.gms.common.images;

import android.os.Bundle;
import android.os.ResultReceiver;
import com.google.android.gms.common.annotation.KeepName;
import java.util.HashSet;

/* compiled from: com.google.android.gms:play-services-base@@18.0.1 */
/* loaded from: classes.dex */
public final class ImageManager {

    /* renamed from: a, reason: collision with root package name */
    public static final Object f7297a = new Object();

    /* compiled from: com.google.android.gms:play-services-base@@18.0.1 */
    @KeepName
    public final class ImageReceiver extends ResultReceiver {
        public ImageReceiver() {
            throw null;
        }

        @Override // android.os.ResultReceiver
        public final void onReceiveResult(int i10, Bundle bundle) {
            Object obj = ImageManager.f7297a;
            throw null;
        }
    }

    /* compiled from: com.google.android.gms:play-services-base@@18.0.1 */
    public interface OnImageLoadedListener {
    }

    static {
        new HashSet();
    }
}
