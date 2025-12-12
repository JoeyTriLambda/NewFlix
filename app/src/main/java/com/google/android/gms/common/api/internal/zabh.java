package com.google.android.gms.common.api.internal;

import android.os.Message;
import android.util.Log;

/* compiled from: com.google.android.gms:play-services-base@@18.0.1 */
/* loaded from: classes.dex */
final class zabh extends com.google.android.gms.internal.base.zaq {
    @Override // android.os.Handler
    public final void handleMessage(Message message) {
        int i10 = message.what;
        if (i10 == 1) {
            ((zabg) message.obj).zab(null);
        } else {
            if (i10 == 2) {
                throw ((RuntimeException) message.obj);
            }
            StringBuilder sb2 = new StringBuilder(31);
            sb2.append("Unknown message id: ");
            sb2.append(i10);
            Log.w("GACStateManager", sb2.toString());
        }
    }
}
