package c;

import com.ptrbrynt.kotlin_bloc.core.Bloc;
import kotlin.coroutines.jvm.internal.SuspendLambda;

/* loaded from: classes.dex */
public final class v extends SuspendLambda implements yf.p {

    /* renamed from: b, reason: collision with root package name */
    public int f4997b;

    /* renamed from: m, reason: collision with root package name */
    public /* synthetic */ Object f4998m;

    /* renamed from: n, reason: collision with root package name */
    public final /* synthetic */ a f4999n;

    /* renamed from: o, reason: collision with root package name */
    public final /* synthetic */ Bloc f5000o;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public v(a aVar, Bloc bloc, qf.c cVar) {
        super(2, cVar);
        this.f4999n = aVar;
        this.f5000o = bloc;
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final qf.c create(Object obj, qf.c cVar) {
        v vVar = new v(this.f4999n, this.f5000o, cVar);
        vVar.f4998m = obj;
        return vVar;
    }

    @Override // yf.p
    public final Object invoke(Object obj, Object obj2) {
        return ((v) create(obj, (qf.c) obj2)).invokeSuspend(lf.h.f16056a);
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Object invokeSuspend(Object obj) throws Throwable {
        Object coroutine_suspended = rf.a.getCOROUTINE_SUSPENDED();
        int i10 = this.f4997b;
        if (i10 == 0) {
            lf.f.throwOnFailure(obj);
            Object obj2 = this.f4998m;
            oa.c emitter = this.f5000o.getEmitter();
            this.f4997b = 1;
            if (this.f4999n.invoke(emitter, obj2, this) == coroutine_suspended) {
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
