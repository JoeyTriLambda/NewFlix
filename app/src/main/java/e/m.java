package e;

import com.ptrbrynt.kotlin_bloc.core.Bloc;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import yf.p;

/* loaded from: classes2.dex */
public final class m extends SuspendLambda implements p {

    /* renamed from: b, reason: collision with root package name */
    public int f11093b;

    /* renamed from: m, reason: collision with root package name */
    public /* synthetic */ Object f11094m;

    /* renamed from: n, reason: collision with root package name */
    public final /* synthetic */ a f11095n;

    /* renamed from: o, reason: collision with root package name */
    public final /* synthetic */ Bloc f11096o;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public m(a aVar, Bloc bloc, qf.c cVar) {
        super(2, cVar);
        this.f11095n = aVar;
        this.f11096o = bloc;
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final qf.c create(Object obj, qf.c cVar) {
        m mVar = new m(this.f11095n, this.f11096o, cVar);
        mVar.f11094m = obj;
        return mVar;
    }

    @Override // yf.p
    public final Object invoke(Object obj, Object obj2) {
        return ((m) create(obj, (qf.c) obj2)).invokeSuspend(lf.h.f16056a);
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Object invokeSuspend(Object obj) throws Throwable {
        Object coroutine_suspended = rf.a.getCOROUTINE_SUSPENDED();
        int i10 = this.f11093b;
        if (i10 == 0) {
            lf.f.throwOnFailure(obj);
            Object obj2 = this.f11094m;
            oa.c emitter = this.f11096o.getEmitter();
            this.f11093b = 1;
            if (this.f11095n.invoke(emitter, obj2, this) == coroutine_suspended) {
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
}
