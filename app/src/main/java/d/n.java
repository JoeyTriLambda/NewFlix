package d;

import com.ptrbrynt.kotlin_bloc.core.Bloc;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import lf.f;
import lf.h;
import rf.a;
import yf.p;

/* loaded from: classes2.dex */
public final class n extends SuspendLambda implements p {

    /* renamed from: b, reason: collision with root package name */
    public int f10741b;

    /* renamed from: m, reason: collision with root package name */
    public /* synthetic */ Object f10742m;

    /* renamed from: n, reason: collision with root package name */
    public final /* synthetic */ b f10743n;

    /* renamed from: o, reason: collision with root package name */
    public final /* synthetic */ Bloc f10744o;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public n(b bVar, Bloc bloc, qf.c cVar) {
        super(2, cVar);
        this.f10743n = bVar;
        this.f10744o = bloc;
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final qf.c create(Object obj, qf.c cVar) {
        n nVar = new n(this.f10743n, this.f10744o, cVar);
        nVar.f10742m = obj;
        return nVar;
    }

    @Override // yf.p
    public final Object invoke(Object obj, Object obj2) {
        return ((n) create(obj, (qf.c) obj2)).invokeSuspend(h.f16056a);
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Object invokeSuspend(Object obj) throws Throwable {
        Object coroutine_suspended = a.getCOROUTINE_SUSPENDED();
        int i10 = this.f10741b;
        if (i10 == 0) {
            f.throwOnFailure(obj);
            Object obj2 = this.f10742m;
            oa.c emitter = this.f10744o.getEmitter();
            this.f10741b = 1;
            if (this.f10743n.invoke(emitter, obj2, this) == coroutine_suspended) {
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
}
