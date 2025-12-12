package n;

import kotlin.coroutines.jvm.internal.ContinuationImpl;
import qf.c;

/* loaded from: classes2.dex */
public final class S extends ContinuationImpl {

    /* renamed from: b, reason: collision with root package name */
    public /* synthetic */ Object f16346b;

    /* renamed from: m, reason: collision with root package name */
    public int f16347m;

    /* renamed from: n, reason: collision with root package name */
    public final /* synthetic */ xg.j f16348n;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public S(xg.j jVar, c cVar) {
        super(cVar);
        this.f16348n = jVar;
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Object invokeSuspend(Object obj) {
        this.f16346b = obj;
        this.f16347m |= Integer.MIN_VALUE;
        return this.f16348n.emit(null, this);
    }
}
