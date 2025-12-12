package n;

import kotlin.coroutines.jvm.internal.ContinuationImpl;
import xg.c;

/* loaded from: classes2.dex */
public final class D extends ContinuationImpl {

    /* renamed from: b, reason: collision with root package name */
    public /* synthetic */ Object f16325b;

    /* renamed from: m, reason: collision with root package name */
    public int f16326m;

    /* renamed from: n, reason: collision with root package name */
    public final /* synthetic */ c f16327n;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public D(c cVar, qf.c cVar2) {
        super(cVar2);
        this.f16327n = cVar;
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Object invokeSuspend(Object obj) {
        this.f16325b = obj;
        this.f16326m |= Integer.MIN_VALUE;
        return this.f16327n.emit(null, this);
    }
}
