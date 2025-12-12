package f;

import kotlin.coroutines.jvm.internal.SuspendLambda;
import lf.f;
import lf.h;
import qf.c;
import xg.d0;

/* loaded from: classes2.dex */
public final class u extends SuspendLambda implements yf.p {

    /* renamed from: b, reason: collision with root package name */
    public int f11367b;

    /* renamed from: m, reason: collision with root package name */
    public final /* synthetic */ sb.p f11368m;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public u(sb.p pVar, c cVar) {
        super(2, cVar);
        this.f11368m = pVar;
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final c create(Object obj, c cVar) {
        return new u(this.f11368m, cVar);
    }

    @Override // yf.p
    public final Object invoke(Object obj, Object obj2) {
        return new u(this.f11368m, (c) obj2).invokeSuspend(h.f16056a);
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Object invokeSuspend(Object obj) throws Throwable {
        Object coroutine_suspended = rf.a.getCOROUTINE_SUSPENDED();
        int i10 = this.f11367b;
        if (i10 == 0) {
            f.throwOnFailure(obj);
            d0 d0Var = this.f11368m.f19241v;
            this.f11367b = 1;
            if (d0Var.b(this) == coroutine_suspended) {
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
