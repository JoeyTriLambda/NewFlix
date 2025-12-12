package f;

import kotlin.coroutines.jvm.internal.SuspendLambda;
import lf.f;
import lf.h;
import qf.c;
import sb.i;

/* loaded from: classes2.dex */
public final class j extends SuspendLambda implements yf.p {

    /* renamed from: b, reason: collision with root package name */
    public int f11347b;

    /* renamed from: m, reason: collision with root package name */
    public final /* synthetic */ sb.p f11348m;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public j(sb.p pVar, c cVar) {
        super(2, cVar);
        this.f11348m = pVar;
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final c create(Object obj, c cVar) {
        return new j(this.f11348m, cVar);
    }

    @Override // yf.p
    public final Object invoke(Object obj, Object obj2) {
        return new j(this.f11348m, (c) obj2).invokeSuspend(h.f16056a);
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Object invokeSuspend(Object obj) throws Throwable {
        Object coroutine_suspended = rf.a.getCOROUTINE_SUSPENDED();
        int i10 = this.f11347b;
        if (i10 == 0) {
            f.throwOnFailure(obj);
            sb.p pVar = this.f11348m;
            ng.a aVarCombine = ng.c.combine(ng.c.distinctUntilChanged(new sb.k(pVar.f19242w.f13438a)), pVar.f19239t.getStateFlow(), pVar.f19240u.getStateFlow(), new e(null));
            i iVar = new i(pVar);
            this.f11347b = 1;
            if (aVarCombine.collect(iVar, this) == coroutine_suspended) {
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
