package com.google.android.gms.common.api.internal;

import android.os.Looper;
import android.os.Message;
import android.util.Log;
import com.google.android.gms.common.api.PendingResult;
import com.google.android.gms.common.api.Status;
import com.google.android.gms.common.internal.Preconditions;

/* compiled from: com.google.android.gms:play-services-base@@18.0.1 */
/* loaded from: classes.dex */
final class zacz extends com.google.android.gms.internal.base.zaq {

    /* renamed from: a, reason: collision with root package name */
    public final /* synthetic */ zada f7246a;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public zacz(zada zadaVar, Looper looper) {
        super(looper);
        this.f7246a = zadaVar;
    }

    @Override // android.os.Handler
    public final void handleMessage(Message message) {
        int i10 = message.what;
        if (i10 != 0) {
            if (i10 == 1) {
                RuntimeException runtimeException = (RuntimeException) message.obj;
                String strValueOf = String.valueOf(runtimeException.getMessage());
                Log.e("TransformedResultImpl", strValueOf.length() != 0 ? "Runtime exception on the transformation worker thread: ".concat(strValueOf) : new String("Runtime exception on the transformation worker thread: "));
                throw runtimeException;
            }
            StringBuilder sb2 = new StringBuilder(70);
            sb2.append("TransformationResultHandler received unknown message type: ");
            sb2.append(i10);
            Log.e("TransformedResultImpl", sb2.toString());
            return;
        }
        PendingResult<?> pendingResult = (PendingResult) message.obj;
        synchronized (this.f7246a.f7251d) {
            try {
                zada zadaVar = (zada) Preconditions.checkNotNull(this.f7246a.f7249b);
                if (pendingResult == null) {
                    zadaVar.a(new Status(13, "Transform returned null"));
                } else if (pendingResult instanceof zacp) {
                    zadaVar.a(null);
                } else {
                    zadaVar.zai(pendingResult);
                }
            } catch (Throwable th2) {
                throw th2;
            }
        }
    }
}
