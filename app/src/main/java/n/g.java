package n;

import kotlin.coroutines.jvm.internal.ContinuationImpl;
import qf.c;
import xg.y;

/* loaded from: classes2.dex */
public final class g extends ContinuationImpl {

    /* renamed from: b, reason: collision with root package name */
    public /* synthetic */ Object f16364b;

    /* renamed from: m, reason: collision with root package name */
    public int f16365m;

    /* renamed from: n, reason: collision with root package name */
    public final /* synthetic */ y f16366n;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public g(y yVar, c cVar) {
        super(cVar);
        this.f16366n = yVar;
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Object invokeSuspend(Object obj) {
        this.f16364b = obj;
        this.f16365m |= Integer.MIN_VALUE;
        return this.f16366n.emit(null, this);
    }
}
