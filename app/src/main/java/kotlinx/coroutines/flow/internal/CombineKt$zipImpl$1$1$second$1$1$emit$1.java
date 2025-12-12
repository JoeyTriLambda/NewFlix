package kotlinx.coroutines.flow.internal;

import kotlin.coroutines.jvm.internal.ContinuationImpl;
import kotlinx.coroutines.flow.internal.CombineKt$zipImpl$1$1$second$1;
import qf.c;
import sf.d;

/* compiled from: Combine.kt */
@d(c = "kotlinx.coroutines.flow.internal.CombineKt$zipImpl$1$1$second$1$1", f = "Combine.kt", l = {90}, m = "emit")
/* loaded from: classes2.dex */
public final class CombineKt$zipImpl$1$1$second$1$1$emit$1 extends ContinuationImpl {

    /* renamed from: b, reason: collision with root package name */
    public /* synthetic */ Object f15544b;

    /* renamed from: m, reason: collision with root package name */
    public final /* synthetic */ CombineKt$zipImpl$1$1$second$1.AnonymousClass1<T> f15545m;

    /* renamed from: n, reason: collision with root package name */
    public int f15546n;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    /* JADX WARN: Multi-variable type inference failed */
    public CombineKt$zipImpl$1$1$second$1$1$emit$1(CombineKt$zipImpl$1$1$second$1.AnonymousClass1<? super T> anonymousClass1, c<? super CombineKt$zipImpl$1$1$second$1$1$emit$1> cVar) {
        super(cVar);
        this.f15545m = anonymousClass1;
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Object invokeSuspend(Object obj) {
        this.f15544b = obj;
        this.f15546n |= Integer.MIN_VALUE;
        return this.f15545m.emit(null, this);
    }
}
