package kotlin.coroutines.intrinsics;

import kotlin.coroutines.CoroutineContext;
import kotlin.coroutines.EmptyCoroutineContext;
import kotlin.coroutines.jvm.internal.BaseContinuationImpl;
import kotlin.coroutines.jvm.internal.ContinuationImpl;
import kotlin.coroutines.jvm.internal.RestrictedContinuationImpl;
import lf.h;
import qf.c;
import sf.f;
import yf.p;
import zf.i;
import zf.n;

/* compiled from: IntrinsicsJvm.kt */
/* loaded from: classes2.dex */
public class IntrinsicsKt__IntrinsicsJvmKt {
    /* JADX WARN: Multi-variable type inference failed */
    public static final <R, T> c<h> createCoroutineUnintercepted(final p<? super R, ? super c<? super T>, ? extends Object> pVar, final R r10, c<? super T> cVar) {
        i.checkNotNullParameter(pVar, "<this>");
        i.checkNotNullParameter(cVar, "completion");
        final c<?> cVarProbeCoroutineCreated = f.probeCoroutineCreated(cVar);
        if (pVar instanceof BaseContinuationImpl) {
            return ((BaseContinuationImpl) pVar).create(r10, cVarProbeCoroutineCreated);
        }
        final CoroutineContext context = cVarProbeCoroutineCreated.getContext();
        return context == EmptyCoroutineContext.f15239b ? new RestrictedContinuationImpl(cVarProbeCoroutineCreated, pVar, r10) { // from class: kotlin.coroutines.intrinsics.IntrinsicsKt__IntrinsicsJvmKt$createCoroutineUnintercepted$$inlined$createCoroutineFromSuspendFunction$IntrinsicsKt__IntrinsicsJvmKt$3

            /* renamed from: b, reason: collision with root package name */
            public int f15242b;

            /* renamed from: m, reason: collision with root package name */
            public final /* synthetic */ p f15243m;

            /* renamed from: n, reason: collision with root package name */
            public final /* synthetic */ Object f15244n;

            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            {
                super(cVarProbeCoroutineCreated);
                this.f15243m = pVar;
                this.f15244n = r10;
                i.checkNotNull(cVarProbeCoroutineCreated, "null cannot be cast to non-null type kotlin.coroutines.Continuation<kotlin.Any?>");
            }

            @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
            public Object invokeSuspend(Object obj) throws Throwable {
                int i10 = this.f15242b;
                if (i10 != 0) {
                    if (i10 != 1) {
                        throw new IllegalStateException("This coroutine had already completed".toString());
                    }
                    this.f15242b = 2;
                    lf.f.throwOnFailure(obj);
                    return obj;
                }
                this.f15242b = 1;
                lf.f.throwOnFailure(obj);
                p pVar2 = this.f15243m;
                i.checkNotNull(pVar2, "null cannot be cast to non-null type kotlin.Function2<R of kotlin.coroutines.intrinsics.IntrinsicsKt__IntrinsicsJvmKt.createCoroutineUnintercepted$lambda$1, kotlin.coroutines.Continuation<T of kotlin.coroutines.intrinsics.IntrinsicsKt__IntrinsicsJvmKt.createCoroutineUnintercepted$lambda$1>, kotlin.Any?>");
                return ((p) n.beforeCheckcastToFunctionOfArity(pVar2, 2)).invoke(this.f15244n, this);
            }
        } : new ContinuationImpl(cVarProbeCoroutineCreated, context, pVar, r10) { // from class: kotlin.coroutines.intrinsics.IntrinsicsKt__IntrinsicsJvmKt$createCoroutineUnintercepted$$inlined$createCoroutineFromSuspendFunction$IntrinsicsKt__IntrinsicsJvmKt$4

            /* renamed from: b, reason: collision with root package name */
            public int f15245b;

            /* renamed from: m, reason: collision with root package name */
            public final /* synthetic */ p f15246m;

            /* renamed from: n, reason: collision with root package name */
            public final /* synthetic */ Object f15247n;

            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            {
                super(cVarProbeCoroutineCreated, context);
                this.f15246m = pVar;
                this.f15247n = r10;
                i.checkNotNull(cVarProbeCoroutineCreated, "null cannot be cast to non-null type kotlin.coroutines.Continuation<kotlin.Any?>");
            }

            @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
            public Object invokeSuspend(Object obj) throws Throwable {
                int i10 = this.f15245b;
                if (i10 != 0) {
                    if (i10 != 1) {
                        throw new IllegalStateException("This coroutine had already completed".toString());
                    }
                    this.f15245b = 2;
                    lf.f.throwOnFailure(obj);
                    return obj;
                }
                this.f15245b = 1;
                lf.f.throwOnFailure(obj);
                p pVar2 = this.f15246m;
                i.checkNotNull(pVar2, "null cannot be cast to non-null type kotlin.Function2<R of kotlin.coroutines.intrinsics.IntrinsicsKt__IntrinsicsJvmKt.createCoroutineUnintercepted$lambda$1, kotlin.coroutines.Continuation<T of kotlin.coroutines.intrinsics.IntrinsicsKt__IntrinsicsJvmKt.createCoroutineUnintercepted$lambda$1>, kotlin.Any?>");
                return ((p) n.beforeCheckcastToFunctionOfArity(pVar2, 2)).invoke(this.f15247n, this);
            }
        };
    }

    /* JADX WARN: Multi-variable type inference failed */
    public static final <T> c<T> intercepted(c<? super T> cVar) {
        c<T> cVar2;
        i.checkNotNullParameter(cVar, "<this>");
        ContinuationImpl continuationImpl = cVar instanceof ContinuationImpl ? (ContinuationImpl) cVar : null;
        return (continuationImpl == null || (cVar2 = (c<T>) continuationImpl.intercepted()) == null) ? cVar : cVar2;
    }
}
