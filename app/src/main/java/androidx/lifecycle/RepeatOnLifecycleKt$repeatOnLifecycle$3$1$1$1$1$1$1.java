package androidx.lifecycle;

import kotlin.coroutines.jvm.internal.SuspendLambda;

/* compiled from: RepeatOnLifecycle.kt */
@sf.d(c = "androidx.lifecycle.RepeatOnLifecycleKt$repeatOnLifecycle$3$1$1$1$1$1$1", f = "RepeatOnLifecycle.kt", l = {111}, m = "invokeSuspend")
/* loaded from: classes.dex */
public final class RepeatOnLifecycleKt$repeatOnLifecycle$3$1$1$1$1$1$1 extends SuspendLambda implements yf.p<kg.g0, qf.c<? super lf.h>, Object> {

    /* renamed from: b, reason: collision with root package name */
    public int f3460b;

    /* renamed from: m, reason: collision with root package name */
    public /* synthetic */ Object f3461m;

    /* renamed from: n, reason: collision with root package name */
    public final /* synthetic */ yf.p<kg.g0, qf.c<? super lf.h>, Object> f3462n;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    /* JADX WARN: Multi-variable type inference failed */
    public RepeatOnLifecycleKt$repeatOnLifecycle$3$1$1$1$1$1$1(yf.p<? super kg.g0, ? super qf.c<? super lf.h>, ? extends Object> pVar, qf.c<? super RepeatOnLifecycleKt$repeatOnLifecycle$3$1$1$1$1$1$1> cVar) {
        super(2, cVar);
        this.f3462n = pVar;
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final qf.c<lf.h> create(Object obj, qf.c<?> cVar) {
        RepeatOnLifecycleKt$repeatOnLifecycle$3$1$1$1$1$1$1 repeatOnLifecycleKt$repeatOnLifecycle$3$1$1$1$1$1$1 = new RepeatOnLifecycleKt$repeatOnLifecycle$3$1$1$1$1$1$1(this.f3462n, cVar);
        repeatOnLifecycleKt$repeatOnLifecycle$3$1$1$1$1$1$1.f3461m = obj;
        return repeatOnLifecycleKt$repeatOnLifecycle$3$1$1$1$1$1$1;
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Object invokeSuspend(Object obj) throws Throwable {
        Object coroutine_suspended = rf.a.getCOROUTINE_SUSPENDED();
        int i10 = this.f3460b;
        if (i10 == 0) {
            lf.f.throwOnFailure(obj);
            kg.g0 g0Var = (kg.g0) this.f3461m;
            this.f3460b = 1;
            if (this.f3462n.invoke(g0Var, this) == coroutine_suspended) {
                return coroutine_suspended;
            }
        } else {
            if (i10 != 1) {
                throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
            }
            lf.f.throwOnFailure(obj);
        }
        return lf.h.f16056a;
    }

    @Override // yf.p
    public final Object invoke(kg.g0 g0Var, qf.c<? super lf.h> cVar) {
        return ((RepeatOnLifecycleKt$repeatOnLifecycle$3$1$1$1$1$1$1) create(g0Var, cVar)).invokeSuspend(lf.h.f16056a);
    }
}
