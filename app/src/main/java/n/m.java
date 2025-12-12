package n;

import kotlin.coroutines.jvm.internal.ContinuationImpl;
import qf.c;
import xg.d0;

/* loaded from: classes2.dex */
public final class m extends ContinuationImpl {

    /* renamed from: b, reason: collision with root package name */
    public /* synthetic */ Object f16376b;

    /* renamed from: m, reason: collision with root package name */
    public final /* synthetic */ d0 f16377m;

    /* renamed from: n, reason: collision with root package name */
    public int f16378n;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public m(d0 d0Var, c cVar) {
        super(cVar);
        this.f16377m = d0Var;
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Object invokeSuspend(Object obj) {
        this.f16376b = obj;
        this.f16378n |= Integer.MIN_VALUE;
        return this.f16377m.a(this);
    }
}
