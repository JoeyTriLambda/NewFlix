package com.google.firebase.sessions.settings;

import android.util.Log;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import lf.f;
import lf.h;
import qf.c;
import rf.a;
import sf.d;
import yf.p;

/* compiled from: RemoteSettings.kt */
@d(c = "com.google.firebase.sessions.settings.RemoteSettings$updateSettings$2$2", f = "RemoteSettings.kt", l = {}, m = "invokeSuspend")
/* loaded from: classes.dex */
public final class RemoteSettings$updateSettings$2$2 extends SuspendLambda implements p<String, c<? super h>, Object> {

    /* renamed from: b, reason: collision with root package name */
    public /* synthetic */ Object f9998b;

    public RemoteSettings$updateSettings$2$2(c<? super RemoteSettings$updateSettings$2$2> cVar) {
        super(2, cVar);
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final c<h> create(Object obj, c<?> cVar) {
        RemoteSettings$updateSettings$2$2 remoteSettings$updateSettings$2$2 = new RemoteSettings$updateSettings$2$2(cVar);
        remoteSettings$updateSettings$2$2.f9998b = obj;
        return remoteSettings$updateSettings$2$2;
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Object invokeSuspend(Object obj) throws Throwable {
        a.getCOROUTINE_SUSPENDED();
        f.throwOnFailure(obj);
        Log.e("SessionConfigFetcher", "Error failing to fetch the remote configs: " + ((String) this.f9998b));
        return h.f16056a;
    }

    @Override // yf.p
    public final Object invoke(String str, c<? super h> cVar) {
        return ((RemoteSettings$updateSettings$2$2) create(str, cVar)).invokeSuspend(h.f16056a);
    }
}
