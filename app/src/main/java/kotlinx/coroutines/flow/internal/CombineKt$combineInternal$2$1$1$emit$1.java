package kotlinx.coroutines.flow.internal;

import kotlin.coroutines.jvm.internal.ContinuationImpl;
import kotlinx.coroutines.flow.internal.CombineKt;
import qf.c;
import sf.d;

/* compiled from: Combine.kt */
@d(c = "kotlinx.coroutines.flow.internal.CombineKt$combineInternal$2$1$1", f = "Combine.kt", l = {32, 33}, m = "emit")
/* loaded from: classes2.dex */
public final class CombineKt$combineInternal$2$1$1$emit$1 extends ContinuationImpl {

    /* renamed from: b, reason: collision with root package name */
    public /* synthetic */ Object f15508b;

    /* renamed from: m, reason: collision with root package name */
    public final /* synthetic */ CombineKt.AnonymousClass2.AnonymousClass1.C01821<T> f15509m;

    /* renamed from: n, reason: collision with root package name */
    public int f15510n;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    /* JADX WARN: Multi-variable type inference failed */
    public CombineKt$combineInternal$2$1$1$emit$1(CombineKt.AnonymousClass2.AnonymousClass1.C01821<? super T> c01821, c<? super CombineKt$combineInternal$2$1$1$emit$1> cVar) {
        super(cVar);
        this.f15509m = c01821;
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Object invokeSuspend(Object obj) {
        this.f15508b = obj;
        this.f15510n |= Integer.MIN_VALUE;
        return this.f15509m.emit(null, this);
    }
}
