package n;

import kotlin.coroutines.jvm.internal.ContinuationImpl;
import qf.c;

/* loaded from: classes2.dex */
public final class L extends ContinuationImpl {

    /* renamed from: b, reason: collision with root package name */
    public /* synthetic */ Object f16337b;

    /* renamed from: m, reason: collision with root package name */
    public int f16338m;

    /* renamed from: n, reason: collision with root package name */
    public final /* synthetic */ xg.g f16339n;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public L(xg.g gVar, c cVar) {
        super(cVar);
        this.f16339n = gVar;
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Object invokeSuspend(Object obj) {
        this.f16337b = obj;
        this.f16338m |= Integer.MIN_VALUE;
        return this.f16339n.emit(null, this);
    }
}
