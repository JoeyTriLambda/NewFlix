package de;

import kg.e0;
import kg.g0;
import kg.h;
import kotlin.coroutines.CoroutineContext;

/* loaded from: classes2.dex */
public final class b extends qf.a implements e0 {

    /* renamed from: b, reason: collision with root package name */
    public final /* synthetic */ g0 f11012b;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public b(e0.b bVar, g0 g0Var) {
        super(bVar);
        this.f11012b = g0Var;
    }

    @Override // kg.e0
    public final void handleException(CoroutineContext coroutineContext, Throwable th2) {
        h.launch$default(this.f11012b, null, null, new h.c(th2, null), 3, null);
    }
}
