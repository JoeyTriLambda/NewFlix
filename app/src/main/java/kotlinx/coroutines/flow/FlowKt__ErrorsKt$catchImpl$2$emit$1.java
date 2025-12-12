package kotlinx.coroutines.flow;

import kotlin.coroutines.jvm.internal.ContinuationImpl;
import kotlinx.coroutines.flow.FlowKt__ErrorsKt;
import qf.c;
import sf.d;

/* compiled from: Errors.kt */
@d(c = "kotlinx.coroutines.flow.FlowKt__ErrorsKt$catchImpl$2", f = "Errors.kt", l = {158}, m = "emit")
/* loaded from: classes2.dex */
public final class FlowKt__ErrorsKt$catchImpl$2$emit$1 extends ContinuationImpl {

    /* renamed from: b, reason: collision with root package name */
    public FlowKt__ErrorsKt.AnonymousClass2 f15405b;

    /* renamed from: m, reason: collision with root package name */
    public /* synthetic */ Object f15406m;

    /* renamed from: n, reason: collision with root package name */
    public final /* synthetic */ FlowKt__ErrorsKt.AnonymousClass2<T> f15407n;

    /* renamed from: o, reason: collision with root package name */
    public int f15408o;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    /* JADX WARN: Multi-variable type inference failed */
    public FlowKt__ErrorsKt$catchImpl$2$emit$1(FlowKt__ErrorsKt.AnonymousClass2<? super T> anonymousClass2, c<? super FlowKt__ErrorsKt$catchImpl$2$emit$1> cVar) {
        super(cVar);
        this.f15407n = anonymousClass2;
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Object invokeSuspend(Object obj) {
        this.f15406m = obj;
        this.f15408o |= Integer.MIN_VALUE;
        return this.f15407n.emit(null, this);
    }
}
