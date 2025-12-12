package kotlinx.coroutines.flow.internal;

import kg.n1;
import kotlin.Result;
import kotlin.coroutines.CoroutineContext;
import kotlin.coroutines.EmptyCoroutineContext;
import kotlin.coroutines.jvm.internal.ContinuationImpl;
import kotlin.text.a;
import lf.h;
import ng.b;
import og.d;
import qf.c;
import sf.f;
import yf.p;
import yf.q;
import zf.i;

/* compiled from: SafeCollector.kt */
/* loaded from: classes2.dex */
public final class SafeCollector<T> extends ContinuationImpl implements b<T> {

    /* renamed from: b, reason: collision with root package name */
    public final b<T> f15547b;

    /* renamed from: m, reason: collision with root package name */
    public final CoroutineContext f15548m;

    /* renamed from: n, reason: collision with root package name */
    public final int f15549n;

    /* renamed from: o, reason: collision with root package name */
    public CoroutineContext f15550o;

    /* renamed from: p, reason: collision with root package name */
    public c<? super h> f15551p;

    /* JADX WARN: Multi-variable type inference failed */
    public SafeCollector(b<? super T> bVar, CoroutineContext coroutineContext) {
        super(og.h.f17092b, EmptyCoroutineContext.f15239b);
        this.f15547b = bVar;
        this.f15548m = coroutineContext;
        this.f15549n = ((Number) coroutineContext.fold(0, new p<Integer, CoroutineContext.a, Integer>() { // from class: kotlinx.coroutines.flow.internal.SafeCollector$collectContextSize$1
            public final Integer invoke(int i10, CoroutineContext.a aVar) {
                return Integer.valueOf(i10 + 1);
            }

            @Override // yf.p
            public /* bridge */ /* synthetic */ Integer invoke(Integer num, CoroutineContext.a aVar) {
                return invoke(num.intValue(), aVar);
            }
        })).intValue();
    }

    public final Object a(c<? super h> cVar, T t10) {
        CoroutineContext context = cVar.getContext();
        n1.ensureActive(context);
        CoroutineContext coroutineContext = this.f15550o;
        if (coroutineContext != context) {
            if (coroutineContext instanceof d) {
                throw new IllegalStateException(a.trimIndent("\n            Flow exception transparency is violated:\n                Previous 'emit' call has thrown exception " + ((d) coroutineContext).f17090b + ", but then emission attempt of value '" + t10 + "' has been detected.\n                Emissions from 'catch' blocks are prohibited in order to avoid unspecified behaviour, 'Flow.catch' operator can be used instead.\n                For a more detailed explanation, please refer to Flow documentation.\n            ").toString());
            }
            SafeCollector_commonKt.checkContext(this, context);
            this.f15550o = context;
        }
        this.f15551p = cVar;
        q qVar = SafeCollectorKt.f15553a;
        b<T> bVar = this.f15547b;
        i.checkNotNull(bVar, "null cannot be cast to non-null type kotlinx.coroutines.flow.FlowCollector<kotlin.Any?>");
        i.checkNotNull(this, "null cannot be cast to non-null type kotlin.coroutines.Continuation<kotlin.Unit>");
        Object objInvoke = qVar.invoke(bVar, t10, this);
        if (!i.areEqual(objInvoke, rf.a.getCOROUTINE_SUSPENDED())) {
            this.f15551p = null;
        }
        return objInvoke;
    }

    @Override // ng.b
    public Object emit(T t10, c<? super h> cVar) {
        try {
            Object objA = a(cVar, t10);
            if (objA == rf.a.getCOROUTINE_SUSPENDED()) {
                f.probeCoroutineSuspended(cVar);
            }
            return objA == rf.a.getCOROUTINE_SUSPENDED() ? objA : h.f16056a;
        } catch (Throwable th2) {
            this.f15550o = new d(th2, cVar.getContext());
            throw th2;
        }
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl, sf.c
    public sf.c getCallerFrame() {
        c<? super h> cVar = this.f15551p;
        if (cVar instanceof sf.c) {
            return (sf.c) cVar;
        }
        return null;
    }

    @Override // kotlin.coroutines.jvm.internal.ContinuationImpl, qf.c
    public CoroutineContext getContext() {
        CoroutineContext coroutineContext = this.f15550o;
        return coroutineContext == null ? EmptyCoroutineContext.f15239b : coroutineContext;
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public StackTraceElement getStackTraceElement() {
        return null;
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public Object invokeSuspend(Object obj) {
        Throwable thM61exceptionOrNullimpl = Result.m61exceptionOrNullimpl(obj);
        if (thM61exceptionOrNullimpl != null) {
            this.f15550o = new d(thM61exceptionOrNullimpl, getContext());
        }
        c<? super h> cVar = this.f15551p;
        if (cVar != null) {
            cVar.resumeWith(obj);
        }
        return rf.a.getCOROUTINE_SUSPENDED();
    }

    @Override // kotlin.coroutines.jvm.internal.ContinuationImpl, kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public void releaseIntercepted() {
        super.releaseIntercepted();
    }
}
