package com.google.android.gms.common.internal;

import android.app.Activity;
import android.content.Intent;

/* compiled from: com.google.android.gms:play-services-base@@18.0.1 */
/* loaded from: classes.dex */
final class zad extends zag {

    /* renamed from: b, reason: collision with root package name */
    public final /* synthetic */ Intent f7375b;

    /* renamed from: m, reason: collision with root package name */
    public final /* synthetic */ Activity f7376m;

    /* renamed from: n, reason: collision with root package name */
    public final /* synthetic */ int f7377n;

    public zad(Activity activity, Intent intent, int i10) {
        this.f7375b = intent;
        this.f7376m = activity;
        this.f7377n = i10;
    }

    @Override // com.google.android.gms.common.internal.zag
    public final void zaa() {
        Intent intent = this.f7375b;
        if (intent != null) {
            this.f7376m.startActivityForResult(intent, this.f7377n);
        }
    }
}
