package kotlinx.coroutines.flow;

import kotlin.coroutines.jvm.internal.ContinuationImpl;
import qf.c;
import sf.d;

/* compiled from: Limit.kt */
@d(c = "kotlinx.coroutines.flow.FlowKt__LimitKt$drop$2$1", f = "Limit.kt", l = {25}, m = "emit")
/* loaded from: classes2.dex */
public final class FlowKt__LimitKt$drop$2$1$emit$1 extends ContinuationImpl {

    /* renamed from: b, reason: collision with root package name */
    public /* synthetic */ Object f15416b;

    /* renamed from: m, reason: collision with root package name */
    public final /* synthetic */ FlowKt__LimitKt$drop$2$1<T> f15417m;

    /* renamed from: n, reason: collision with root package name */
    public int f15418n;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    /* JADX WARN: Multi-variable type inference failed */
    public FlowKt__LimitKt$drop$2$1$emit$1(FlowKt__LimitKt$drop$2$1<? super T> flowKt__LimitKt$drop$2$1, c<? super FlowKt__LimitKt$drop$2$1$emit$1> cVar) {
        super(cVar);
        this.f15417m = flowKt__LimitKt$drop$2$1;
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Object invokeSuspend(Object obj) {
        this.f15416b = obj;
        this.f15418n |= Integer.MIN_VALUE;
        return this.f15417m.emit(null, this);
    }
}
