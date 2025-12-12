package n;

import kotlin.coroutines.jvm.internal.ContinuationImpl;
import qf.c;

/* loaded from: classes2.dex */
public final class Z extends ContinuationImpl {

    /* renamed from: b, reason: collision with root package name */
    public /* synthetic */ Object f16355b;

    /* renamed from: m, reason: collision with root package name */
    public int f16356m;

    /* renamed from: n, reason: collision with root package name */
    public final /* synthetic */ xg.n f16357n;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public Z(xg.n nVar, c cVar) {
        super(cVar);
        this.f16357n = nVar;
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Object invokeSuspend(Object obj) {
        this.f16355b = obj;
        this.f16356m |= Integer.MIN_VALUE;
        return this.f16357n.emit(null, this);
    }
}
