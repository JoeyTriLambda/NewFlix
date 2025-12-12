package androidx.lifecycle;

import androidx.lifecycle.Lifecycle;
import kg.h0;
import kotlin.Result;
import kotlin.coroutines.jvm.internal.SuspendLambda;

/* compiled from: RepeatOnLifecycle.kt */
/* loaded from: classes.dex */
final class RepeatOnLifecycleKt$repeatOnLifecycle$3$1$1$1 implements j {

    /* compiled from: RepeatOnLifecycle.kt */
    @sf.d(c = "androidx.lifecycle.RepeatOnLifecycleKt$repeatOnLifecycle$3$1$1$1$1", f = "RepeatOnLifecycle.kt", l = {171, 110}, m = "invokeSuspend")
    /* renamed from: androidx.lifecycle.RepeatOnLifecycleKt$repeatOnLifecycle$3$1$1$1$1, reason: invalid class name */
    public static final class AnonymousClass1 extends SuspendLambda implements yf.p<kg.g0, qf.c<? super lf.h>, Object> {

        /* renamed from: b, reason: collision with root package name */
        public tg.a f3455b;

        /* renamed from: m, reason: collision with root package name */
        public yf.p f3456m;

        /* renamed from: n, reason: collision with root package name */
        public int f3457n;

        /* renamed from: o, reason: collision with root package name */
        public final /* synthetic */ tg.a f3458o;

        /* renamed from: p, reason: collision with root package name */
        public final /* synthetic */ yf.p<kg.g0, qf.c<? super lf.h>, Object> f3459p;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        /* JADX WARN: Multi-variable type inference failed */
        public AnonymousClass1(tg.a aVar, yf.p<? super kg.g0, ? super qf.c<? super lf.h>, ? extends Object> pVar, qf.c<? super AnonymousClass1> cVar) {
            super(2, cVar);
            this.f3458o = aVar;
            this.f3459p = pVar;
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final qf.c<lf.h> create(Object obj, qf.c<?> cVar) {
            return new AnonymousClass1(this.f3458o, this.f3459p, cVar);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Object invokeSuspend(Object obj) throws Throwable {
            yf.p<kg.g0, qf.c<? super lf.h>, Object> pVar;
            tg.a aVar;
            tg.a aVar2;
            Object coroutine_suspended = rf.a.getCOROUTINE_SUSPENDED();
            int i10 = this.f3457n;
            try {
                if (i10 == 0) {
                    lf.f.throwOnFailure(obj);
                    tg.a aVar3 = this.f3458o;
                    this.f3455b = aVar3;
                    pVar = this.f3459p;
                    this.f3456m = pVar;
                    this.f3457n = 1;
                    if (aVar3.lock(null, this) == coroutine_suspended) {
                        return coroutine_suspended;
                    }
                    aVar = aVar3;
                } else {
                    if (i10 != 1) {
                        if (i10 != 2) {
                            throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                        }
                        aVar2 = this.f3455b;
                        try {
                            lf.f.throwOnFailure(obj);
                            lf.h hVar = lf.h.f16056a;
                            aVar2.unlock(null);
                            return lf.h.f16056a;
                        } catch (Throwable th2) {
                            th = th2;
                            aVar = aVar2;
                            aVar.unlock(null);
                            throw th;
                        }
                    }
                    pVar = this.f3456m;
                    aVar = this.f3455b;
                    lf.f.throwOnFailure(obj);
                }
                RepeatOnLifecycleKt$repeatOnLifecycle$3$1$1$1$1$1$1 repeatOnLifecycleKt$repeatOnLifecycle$3$1$1$1$1$1$1 = new RepeatOnLifecycleKt$repeatOnLifecycle$3$1$1$1$1$1$1(pVar, null);
                this.f3455b = aVar;
                this.f3456m = null;
                this.f3457n = 2;
                if (h0.coroutineScope(repeatOnLifecycleKt$repeatOnLifecycle$3$1$1$1$1$1$1, this) == coroutine_suspended) {
                    return coroutine_suspended;
                }
                aVar2 = aVar;
                lf.h hVar2 = lf.h.f16056a;
                aVar2.unlock(null);
                return lf.h.f16056a;
            } catch (Throwable th3) {
                th = th3;
                aVar.unlock(null);
                throw th;
            }
        }

        @Override // yf.p
        public final Object invoke(kg.g0 g0Var, qf.c<? super lf.h> cVar) {
            return ((AnonymousClass1) create(g0Var, cVar)).invokeSuspend(lf.h.f16056a);
        }
    }

    @Override // androidx.lifecycle.j
    public final void onStateChanged(l lVar, Lifecycle.Event event) {
        zf.i.checkNotNullParameter(lVar, "<anonymous parameter 0>");
        zf.i.checkNotNullParameter(event, "event");
        if (event == null) {
            kg.h.launch$default(null, null, null, new AnonymousClass1(null, null, null), 3, null);
            throw null;
        }
        event.getClass();
        if (event != Lifecycle.Event.ON_DESTROY) {
            return;
        }
        int i10 = Result.f15189m;
        Result.m59constructorimpl(lf.h.f16056a);
        throw null;
    }
}
