package com.google.android.gms.common.api.internal;

import android.os.Message;
import android.util.Log;

/* compiled from: com.google.android.gms:play-services-base@@18.0.1 */
/* loaded from: classes.dex */
final class zabc extends com.google.android.gms.internal.base.zaq {
    @Override // android.os.Handler
    public final void handleMessage(Message message) {
        int i10 = message.what;
        if (i10 == 1) {
            int i11 = zabe.f7170c;
            throw null;
        }
        if (i10 == 2) {
            int i12 = zabe.f7170c;
            throw null;
        }
        StringBuilder sb2 = new StringBuilder(31);
        sb2.append("Unknown message id: ");
        sb2.append(i10);
        Log.w("GoogleApiClientImpl", sb2.toString());
    }
}
