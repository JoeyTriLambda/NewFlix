package f;

import com.ptrbrynt.kotlin_bloc.core.Bloc;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import lf.f;
import lf.h;
import qf.c;

/* loaded from: classes2.dex */
public final class s extends SuspendLambda implements yf.p {

    /* renamed from: b, reason: collision with root package name */
    public int f11359b;

    /* renamed from: m, reason: collision with root package name */
    public /* synthetic */ Object f11360m;

    /* renamed from: n, reason: collision with root package name */
    public final /* synthetic */ b f11361n;

    /* renamed from: o, reason: collision with root package name */
    public final /* synthetic */ Bloc f11362o;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public s(b bVar, Bloc bloc, c cVar) {
        super(2, cVar);
        this.f11361n = bVar;
        this.f11362o = bloc;
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final c create(Object obj, c cVar) {
        s sVar = new s(this.f11361n, this.f11362o, cVar);
        sVar.f11360m = obj;
        return sVar;
    }

    @Override // yf.p
    public final Object invoke(Object obj, Object obj2) {
        return ((s) create(obj, (c) obj2)).invokeSuspend(h.f16056a);
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Object invokeSuspend(Object obj) throws Throwable {
        Object coroutine_suspended = rf.a.getCOROUTINE_SUSPENDED();
        int i10 = this.f11359b;
        if (i10 == 0) {
            f.throwOnFailure(obj);
            Object obj2 = this.f11360m;
            oa.c emitter = this.f11362o.getEmitter();
            this.f11359b = 1;
            if (this.f11361n.invoke(emitter, obj2, this) == coroutine_suspended) {
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
