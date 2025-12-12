package kotlinx.coroutines.flow;

import kg.g0;
import kg.k1;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import lf.f;
import lf.h;
import ng.a;
import ng.b;
import og.i;
import qf.c;
import sf.d;
import yf.p;

/* compiled from: Collect.kt */
/* loaded from: classes2.dex */
public final /* synthetic */ class FlowKt__CollectKt {

    /* compiled from: Collect.kt */
    @d(c = "kotlinx.coroutines.flow.FlowKt__CollectKt$launchIn$1", f = "Collect.kt", l = {50}, m = "invokeSuspend")
    /* renamed from: kotlinx.coroutines.flow.FlowKt__CollectKt$launchIn$1, reason: invalid class name */
    public static final class AnonymousClass1 extends SuspendLambda implements p<g0, c<? super h>, Object> {

        /* renamed from: b, reason: collision with root package name */
        public int f15387b;

        /* renamed from: m, reason: collision with root package name */
        public final /* synthetic */ a<T> f15388m;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        /* JADX WARN: Multi-variable type inference failed */
        public AnonymousClass1(a<? extends T> aVar, c<? super AnonymousClass1> cVar) {
            super(2, cVar);
            this.f15388m = aVar;
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final c<h> create(Object obj, c<?> cVar) {
            return new AnonymousClass1(this.f15388m, cVar);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Object invokeSuspend(Object obj) throws Throwable {
            Object coroutine_suspended = rf.a.getCOROUTINE_SUSPENDED();
            int i10 = this.f15387b;
            if (i10 == 0) {
                f.throwOnFailure(obj);
                this.f15387b = 1;
                if (ng.c.collect(this.f15388m, this) == coroutine_suspended) {
                    return coroutine_suspended;
                }
            } else {
                if (i10 != 1) {
                    throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                }
                f.throwOnFailure(obj);
            }
            return h.f16056a;
        }

        @Override // yf.p
        public final Object invoke(g0 g0Var, c<? super h> cVar) {
            return ((AnonymousClass1) create(g0Var, cVar)).invokeSuspend(h.f16056a);
        }
    }

    public static final Object collect(a<?> aVar, c<? super h> cVar) {
        Object objCollect = aVar.collect(i.f17094b, cVar);
        return objCollect == rf.a.getCOROUTINE_SUSPENDED() ? objCollect : h.f16056a;
    }

    public static final <T> Object emitAll(b<? super T> bVar, a<? extends T> aVar, c<? super h> cVar) {
        ng.c.ensureActive(bVar);
        Object objCollect = aVar.collect(bVar, cVar);
        return objCollect == rf.a.getCOROUTINE_SUSPENDED() ? objCollect : h.f16056a;
    }

    public static final <T> k1 launchIn(a<? extends T> aVar, g0 g0Var) {
        return kg.h.launch$default(g0Var, null, null, new AnonymousClass1(aVar, null), 3, null);
    }
}
