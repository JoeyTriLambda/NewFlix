package n;

import kotlin.coroutines.jvm.internal.ContinuationImpl;
import qf.c;
import xg.g0;

/* renamed from: n.n, reason: case insensitive filesystem */
/* loaded from: classes2.dex */
public final class C0349n extends ContinuationImpl {

    /* renamed from: b, reason: collision with root package name */
    public /* synthetic */ Object f16379b;

    /* renamed from: m, reason: collision with root package name */
    public int f16380m;

    /* renamed from: n, reason: collision with root package name */
    public final /* synthetic */ g0 f16381n;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public C0349n(g0 g0Var, c cVar) {
        super(cVar);
        this.f16381n = g0Var;
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Object invokeSuspend(Object obj) {
        this.f16379b = obj;
        this.f16380m |= Integer.MIN_VALUE;
        return this.f16381n.emit(null, this);
    }
}
