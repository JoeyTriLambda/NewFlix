package kg;

import java.util.concurrent.Executor;

/* compiled from: Executors.kt */
/* loaded from: classes2.dex */
public final class c1 {
    public static final Executor asExecutor(kotlinx.coroutines.b bVar) {
        Executor executor;
        kotlinx.coroutines.h hVar = bVar instanceof kotlinx.coroutines.h ? (kotlinx.coroutines.h) bVar : null;
        return (hVar == null || (executor = hVar.getExecutor()) == null) ? new r0(bVar) : executor;
    }

    public static final kotlinx.coroutines.b from(Executor executor) {
        kotlinx.coroutines.b bVar;
        r0 r0Var = executor instanceof r0 ? (r0) executor : null;
        return (r0Var == null || (bVar = r0Var.f15134b) == null) ? new kotlinx.coroutines.i(executor) : bVar;
    }
}
