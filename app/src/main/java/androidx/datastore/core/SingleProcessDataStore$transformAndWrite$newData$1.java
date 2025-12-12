package androidx.datastore.core;

import cz.msebera.android.httpclient.HttpStatus;
import kg.g0;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import lf.f;
import lf.h;
import qf.c;
import rf.a;
import sf.d;
import yf.p;

/* compiled from: SingleProcessDataStore.kt */
@d(c = "androidx.datastore.core.SingleProcessDataStore$transformAndWrite$newData$1", f = "SingleProcessDataStore.kt", l = {HttpStatus.SC_PAYMENT_REQUIRED}, m = "invokeSuspend")
/* loaded from: classes.dex */
final class SingleProcessDataStore$transformAndWrite$newData$1 extends SuspendLambda implements p<g0, c<Object>, Object> {

    /* renamed from: b, reason: collision with root package name */
    public int f2276b;

    /* renamed from: m, reason: collision with root package name */
    public final /* synthetic */ p<Object, c<Object>, Object> f2277m;

    /* renamed from: n, reason: collision with root package name */
    public final /* synthetic */ Object f2278n;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    /* JADX WARN: Multi-variable type inference failed */
    public SingleProcessDataStore$transformAndWrite$newData$1(p<Object, ? super c<Object>, ? extends Object> pVar, Object obj, c<? super SingleProcessDataStore$transformAndWrite$newData$1> cVar) {
        super(2, cVar);
        this.f2277m = pVar;
        this.f2278n = obj;
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final c<h> create(Object obj, c<?> cVar) {
        return new SingleProcessDataStore$transformAndWrite$newData$1(this.f2277m, this.f2278n, cVar);
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Object invokeSuspend(Object obj) throws Throwable {
        Object coroutine_suspended = a.getCOROUTINE_SUSPENDED();
        int i10 = this.f2276b;
        if (i10 == 0) {
            f.throwOnFailure(obj);
            this.f2276b = 1;
            obj = this.f2277m.invoke(this.f2278n, this);
            if (obj == coroutine_suspended) {
                return coroutine_suspended;
            }
        } else {
            if (i10 != 1) {
                throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
            }
            f.throwOnFailure(obj);
        }
        return obj;
    }

    @Override // yf.p
    public final Object invoke(g0 g0Var, c<Object> cVar) {
        return ((SingleProcessDataStore$transformAndWrite$newData$1) create(g0Var, cVar)).invokeSuspend(h.f16056a);
    }
}
