package n;

import kotlin.coroutines.jvm.internal.ContinuationImpl;
import qf.c;
import xg.d0;

/* loaded from: classes2.dex */
public final class c0 extends ContinuationImpl {

    /* renamed from: b, reason: collision with root package name */
    public /* synthetic */ Object f16358b;

    /* renamed from: m, reason: collision with root package name */
    public final /* synthetic */ d0 f16359m;

    /* renamed from: n, reason: collision with root package name */
    public int f16360n;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public c0(d0 d0Var, c cVar) {
        super(cVar);
        this.f16359m = d0Var;
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Object invokeSuspend(Object obj) {
        this.f16358b = obj;
        this.f16360n |= Integer.MIN_VALUE;
        return this.f16359m.b(this);
    }
}
