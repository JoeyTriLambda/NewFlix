package com.google.android.gms.common.internal;

import android.os.Handler;
import android.os.Message;
import android.util.Log;

/* compiled from: com.google.android.gms:play-services-base@@18.0.1 */
/* loaded from: classes.dex */
public final class zak implements Handler.Callback {
    @Override // android.os.Handler.Callback
    public final boolean handleMessage(Message message) {
        int i10 = message.what;
        if (i10 == 1) {
            throw null;
        }
        StringBuilder sb2 = new StringBuilder(45);
        sb2.append("Don't know how to handle message: ");
        sb2.append(i10);
        Log.wtf("GmsClientEvents", sb2.toString(), new Exception());
        return false;
    }
}
