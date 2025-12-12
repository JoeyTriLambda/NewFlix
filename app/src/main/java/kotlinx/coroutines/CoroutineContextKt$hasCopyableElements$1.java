package kotlinx.coroutines;

import kg.d0;
import kotlin.coroutines.CoroutineContext;
import kotlin.jvm.internal.Lambda;
import yf.p;

/* compiled from: CoroutineContext.kt */
/* loaded from: classes2.dex */
final class CoroutineContextKt$hasCopyableElements$1 extends Lambda implements p<Boolean, CoroutineContext.a, Boolean> {

    /* renamed from: b, reason: collision with root package name */
    public static final CoroutineContextKt$hasCopyableElements$1 f15289b = new CoroutineContextKt$hasCopyableElements$1();

    public CoroutineContextKt$hasCopyableElements$1() {
        super(2);
    }

    public final Boolean invoke(boolean z10, CoroutineContext.a aVar) {
        return Boolean.valueOf(z10 || (aVar instanceof d0));
    }

    @Override // yf.p
    public /* bridge */ /* synthetic */ Boolean invoke(Boolean bool, CoroutineContext.a aVar) {
        return invoke(bool.booleanValue(), aVar);
    }
}
