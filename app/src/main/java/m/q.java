package m;

import kg.h0;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import lf.f;
import qf.c;
import rf.a;
import yg.b;

/* loaded from: classes2.dex */
public final class q extends SuspendLambda implements yf.p {

    /* renamed from: b, reason: collision with root package name */
    public int f16085b;

    /* renamed from: m, reason: collision with root package name */
    public final /* synthetic */ wg.i f16086m;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public q(wg.i iVar, c cVar) {
        super(2, cVar);
        this.f16086m = iVar;
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final c create(Object obj, c cVar) {
        return new q(this.f16086m, cVar);
    }

    @Override // yf.p
    public final Object invoke(Object obj, Object obj2) {
        return new q(this.f16086m, (c) obj2).invokeSuspend(lf.h.f16056a);
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Object invokeSuspend(Object obj) throws Throwable {
        Object coroutine_suspended = a.getCOROUTINE_SUSPENDED();
        int i10 = this.f16085b;
        if (i10 == 0) {
            f.throwOnFailure(obj);
            wg.i iVar = this.f16086m;
            b bVar = iVar.f21153e;
            String strValueOf = String.valueOf(iVar.f21149a);
            this.f16085b = 1;
            bVar.getClass();
            if (h0.coroutineScope(new o.i(bVar, strValueOf, null), this) == coroutine_suspended) {
                return coroutine_suspended;
            }
        } else {
            if (i10 != 1) {
                throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
            }
            f.throwOnFailure(obj);
        }
        return lf.h.f16056a;
    }
}
