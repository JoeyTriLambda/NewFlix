package com.google.android.gms.common.api.internal;

import android.app.Activity;
import android.content.Intent;
import com.google.android.gms.common.annotation.KeepForSdk;

/* compiled from: com.google.android.gms:play-services-basement@@18.3.0 */
@KeepForSdk
/* loaded from: classes.dex */
public interface LifecycleFragment {
    @KeepForSdk
    Activity getLifecycleActivity();

    @KeepForSdk
    void startActivityForResult(Intent intent, int i10);
}
