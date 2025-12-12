package n;

import kotlin.coroutines.jvm.internal.ContinuationImpl;
import qf.c;
import xg.b;

/* loaded from: classes2.dex */
public final class B extends ContinuationImpl {

    /* renamed from: b, reason: collision with root package name */
    public /* synthetic */ Object f16322b;

    /* renamed from: m, reason: collision with root package name */
    public int f16323m;

    /* renamed from: n, reason: collision with root package name */
    public final /* synthetic */ b f16324n;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public B(b bVar, c cVar) {
        super(cVar);
        this.f16324n = bVar;
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Object invokeSuspend(Object obj) {
        this.f16322b = obj;
        this.f16323m |= Integer.MIN_VALUE;
        return this.f16324n.emit(null, this);
    }
}
