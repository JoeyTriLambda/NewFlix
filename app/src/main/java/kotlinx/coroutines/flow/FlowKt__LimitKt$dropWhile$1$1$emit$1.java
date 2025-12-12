package kotlinx.coroutines.flow;

import kotlin.coroutines.jvm.internal.ContinuationImpl;
import qf.c;
import sf.d;

/* compiled from: Limit.kt */
@d(c = "kotlinx.coroutines.flow.FlowKt__LimitKt$dropWhile$1$1", f = "Limit.kt", l = {37, 38, 40}, m = "emit")
/* loaded from: classes2.dex */
public final class FlowKt__LimitKt$dropWhile$1$1$emit$1 extends ContinuationImpl {

    /* renamed from: b, reason: collision with root package name */
    public FlowKt__LimitKt$dropWhile$1$1 f15422b;

    /* renamed from: m, reason: collision with root package name */
    public Object f15423m;

    /* renamed from: n, reason: collision with root package name */
    public /* synthetic */ Object f15424n;

    /* renamed from: o, reason: collision with root package name */
    public final /* synthetic */ FlowKt__LimitKt$dropWhile$1$1<T> f15425o;

    /* renamed from: p, reason: collision with root package name */
    public int f15426p;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    /* JADX WARN: Multi-variable type inference failed */
    public FlowKt__LimitKt$dropWhile$1$1$emit$1(FlowKt__LimitKt$dropWhile$1$1<? super T> flowKt__LimitKt$dropWhile$1$1, c<? super FlowKt__LimitKt$dropWhile$1$1$emit$1> cVar) {
        super(cVar);
        this.f15425o = flowKt__LimitKt$dropWhile$1$1;
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Object invokeSuspend(Object obj) {
        this.f15424n = obj;
        this.f15426p |= Integer.MIN_VALUE;
        return this.f15425o.emit(null, this);
    }
}
