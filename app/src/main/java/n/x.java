package n;

import kotlin.coroutines.jvm.internal.ContinuationImpl;
import qf.c;
import xg.l0;

/* loaded from: classes2.dex */
public final class x extends ContinuationImpl {

    /* renamed from: b, reason: collision with root package name */
    public /* synthetic */ Object f16394b;

    /* renamed from: m, reason: collision with root package name */
    public int f16395m;

    /* renamed from: n, reason: collision with root package name */
    public final /* synthetic */ l0 f16396n;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public x(l0 l0Var, c cVar) {
        super(cVar);
        this.f16396n = l0Var;
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Object invokeSuspend(Object obj) {
        this.f16394b = obj;
        this.f16395m |= Integer.MIN_VALUE;
        return this.f16396n.emit(null, this);
    }
}
