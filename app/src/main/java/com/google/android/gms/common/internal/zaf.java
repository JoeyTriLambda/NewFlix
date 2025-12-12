package com.google.android.gms.common.internal;

import android.content.Intent;
import com.google.android.gms.common.api.internal.LifecycleFragment;

/* compiled from: com.google.android.gms:play-services-base@@18.0.1 */
/* loaded from: classes.dex */
final class zaf extends zag {

    /* renamed from: b, reason: collision with root package name */
    public final /* synthetic */ Intent f7378b;

    /* renamed from: m, reason: collision with root package name */
    public final /* synthetic */ LifecycleFragment f7379m;

    public zaf(LifecycleFragment lifecycleFragment, Intent intent) {
        this.f7378b = intent;
        this.f7379m = lifecycleFragment;
    }

    @Override // com.google.android.gms.common.internal.zag
    public final void zaa() {
        Intent intent = this.f7378b;
        if (intent != null) {
            this.f7379m.startActivityForResult(intent, 2);
        }
    }
}
