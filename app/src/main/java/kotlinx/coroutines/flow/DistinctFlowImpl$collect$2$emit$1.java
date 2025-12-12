package kotlinx.coroutines.flow;

import kotlin.coroutines.jvm.internal.ContinuationImpl;
import kotlinx.coroutines.flow.DistinctFlowImpl;
import qf.c;
import sf.d;

/* compiled from: Distinct.kt */
@d(c = "kotlinx.coroutines.flow.DistinctFlowImpl$collect$2", f = "Distinct.kt", l = {77}, m = "emit")
/* loaded from: classes2.dex */
public final class DistinctFlowImpl$collect$2$emit$1 extends ContinuationImpl {

    /* renamed from: b, reason: collision with root package name */
    public /* synthetic */ Object f15384b;

    /* renamed from: m, reason: collision with root package name */
    public final /* synthetic */ DistinctFlowImpl.AnonymousClass2<T> f15385m;

    /* renamed from: n, reason: collision with root package name */
    public int f15386n;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    /* JADX WARN: Multi-variable type inference failed */
    public DistinctFlowImpl$collect$2$emit$1(DistinctFlowImpl.AnonymousClass2<? super T> anonymousClass2, c<? super DistinctFlowImpl$collect$2$emit$1> cVar) {
        super(cVar);
        this.f15385m = anonymousClass2;
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Object invokeSuspend(Object obj) {
        this.f15384b = obj;
        this.f15386n |= Integer.MIN_VALUE;
        return this.f15385m.emit(null, this);
    }
}
