package n;

import kotlin.coroutines.jvm.internal.ContinuationImpl;
import qf.c;
import xg.e;

/* loaded from: classes2.dex */
public final class H extends ContinuationImpl {

    /* renamed from: b, reason: collision with root package name */
    public /* synthetic */ Object f16331b;

    /* renamed from: m, reason: collision with root package name */
    public int f16332m;

    /* renamed from: n, reason: collision with root package name */
    public final /* synthetic */ e f16333n;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public H(e eVar, c cVar) {
        super(cVar);
        this.f16333n = eVar;
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Object invokeSuspend(Object obj) {
        this.f16331b = obj;
        this.f16332m |= Integer.MIN_VALUE;
        return this.f16333n.emit(null, this);
    }
}
