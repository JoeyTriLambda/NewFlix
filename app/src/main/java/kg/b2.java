package kg;

import kotlin.Result;

/* compiled from: JobSupport.kt */
/* loaded from: classes2.dex */
public final class b2<T> extends q1 {

    /* renamed from: p, reason: collision with root package name */
    public final m<T> f15097p;

    /* JADX WARN: Multi-variable type inference failed */
    public b2(m<? super T> mVar) {
        this.f15097p = mVar;
    }

    @Override // yf.l
    public /* bridge */ /* synthetic */ lf.h invoke(Throwable th2) {
        invoke2(th2);
        return lf.h.f16056a;
    }

    @Override // kg.b0
    /* renamed from: invoke, reason: avoid collision after fix types in other method */
    public void invoke2(Throwable th2) {
        Object state$kotlinx_coroutines_core = getJob().getState$kotlinx_coroutines_core();
        boolean z10 = state$kotlinx_coroutines_core instanceof z;
        m<T> mVar = this.f15097p;
        if (z10) {
            int i10 = Result.f15189m;
            mVar.resumeWith(Result.m59constructorimpl(lf.f.createFailure(((z) state$kotlinx_coroutines_core).f15175a)));
        } else {
            int i11 = Result.f15189m;
            mVar.resumeWith(Result.m59constructorimpl(t1.unboxState(state$kotlinx_coroutines_core)));
        }
    }
}
