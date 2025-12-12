package n;

import kotlin.coroutines.jvm.internal.ContinuationImpl;
import qf.c;
import xg.j0;

/* loaded from: classes2.dex */
public final class t extends ContinuationImpl {

    /* renamed from: b, reason: collision with root package name */
    public /* synthetic */ Object f16388b;

    /* renamed from: m, reason: collision with root package name */
    public int f16389m;

    /* renamed from: n, reason: collision with root package name */
    public final /* synthetic */ j0 f16390n;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public t(j0 j0Var, c cVar) {
        super(cVar);
        this.f16390n = j0Var;
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Object invokeSuspend(Object obj) {
        this.f16388b = obj;
        this.f16389m |= Integer.MIN_VALUE;
        return this.f16390n.emit(null, this);
    }
}
