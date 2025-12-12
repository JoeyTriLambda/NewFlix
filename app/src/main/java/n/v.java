package n;

import kotlin.coroutines.jvm.internal.ContinuationImpl;
import qf.c;

/* loaded from: classes2.dex */
public final class v extends ContinuationImpl {

    /* renamed from: b, reason: collision with root package name */
    public /* synthetic */ Object f16391b;

    /* renamed from: m, reason: collision with root package name */
    public int f16392m;

    /* renamed from: n, reason: collision with root package name */
    public final /* synthetic */ xg.k0 f16393n;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public v(xg.k0 k0Var, c cVar) {
        super(cVar);
        this.f16393n = k0Var;
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Object invokeSuspend(Object obj) {
        this.f16391b = obj;
        this.f16392m |= Integer.MIN_VALUE;
        return this.f16393n.emit(null, this);
    }
}
