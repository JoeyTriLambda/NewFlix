package n;

import kotlin.coroutines.jvm.internal.ContinuationImpl;
import qf.c;
import xg.i0;

/* loaded from: classes2.dex */
public final class r extends ContinuationImpl {

    /* renamed from: b, reason: collision with root package name */
    public /* synthetic */ Object f16385b;

    /* renamed from: m, reason: collision with root package name */
    public int f16386m;

    /* renamed from: n, reason: collision with root package name */
    public final /* synthetic */ i0 f16387n;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public r(i0 i0Var, c cVar) {
        super(cVar);
        this.f16387n = i0Var;
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Object invokeSuspend(Object obj) {
        this.f16385b = obj;
        this.f16386m |= Integer.MIN_VALUE;
        return this.f16387n.emit(null, this);
    }
}
