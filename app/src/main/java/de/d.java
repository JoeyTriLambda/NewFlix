package de;

import kg.e0;
import kotlin.coroutines.CoroutineContext;
import ng.g;

/* loaded from: classes2.dex */
public final class d extends qf.a implements e0 {
    public d(e0.b bVar) {
        super(bVar);
    }

    @Override // kg.e0
    public final void handleException(CoroutineContext coroutineContext, Throwable th2) {
        g gVar = k.c.f14701a;
        k.c.a("ApiSender", "Exception: on [" + coroutineContext + "]: " + th2.getMessage(), th2);
    }
}
