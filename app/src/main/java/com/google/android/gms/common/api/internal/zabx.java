package com.google.android.gms.common.api.internal;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.net.Uri;

/* compiled from: com.google.android.gms:play-services-base@@18.0.1 */
/* loaded from: classes.dex */
public final class zabx extends BroadcastReceiver {

    /* renamed from: a, reason: collision with root package name */
    public Context f7208a;

    /* renamed from: b, reason: collision with root package name */
    public final zabw f7209b;

    public zabx(zabw zabwVar) {
        this.f7209b = zabwVar;
    }

    @Override // android.content.BroadcastReceiver
    public final void onReceive(Context context, Intent intent) {
        Uri data = intent.getData();
        if ("com.google.android.gms".equals(data != null ? data.getSchemeSpecificPart() : null)) {
            this.f7209b.zaa();
            zab();
        }
    }

    public final void zaa(Context context) {
        this.f7208a = context;
    }

    public final synchronized void zab() {
        Context context = this.f7208a;
        if (context != null) {
            context.unregisterReceiver(this);
        }
        this.f7208a = null;
    }
}
