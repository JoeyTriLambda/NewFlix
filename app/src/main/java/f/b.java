package f;

import kotlin.coroutines.jvm.internal.SuspendLambda;
import lf.f;
import lf.h;
import oa.c;
import yf.q;
import zf.i;

/* loaded from: classes2.dex */
public final class b extends SuspendLambda implements q {

    /* renamed from: b, reason: collision with root package name */
    public int f11335b;

    /* renamed from: m, reason: collision with root package name */
    public /* synthetic */ c f11336m;

    /* renamed from: n, reason: collision with root package name */
    public /* synthetic */ sb.q f11337n;

    /* renamed from: o, reason: collision with root package name */
    public final /* synthetic */ sb.p f11338o;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public b(sb.p pVar, qf.c cVar) {
        super(3, cVar);
        this.f11338o = pVar;
    }

    @Override // yf.q
    public final Object invoke(Object obj, Object obj2, Object obj3) {
        b bVar = new b(this.f11338o, (qf.c) obj3);
        bVar.f11336m = (c) obj;
        bVar.f11337n = (sb.q) obj2;
        return bVar.invokeSuspend(h.f16056a);
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Object invokeSuspend(Object obj) throws Throwable {
        Object coroutine_suspended = rf.a.getCOROUTINE_SUSPENDED();
        int i10 = this.f11335b;
        if (i10 == 0) {
            f.throwOnFailure(obj);
            c cVar = this.f11336m;
            sb.q qVar = this.f11337n;
            boolean zAreEqual = i.areEqual(qVar, sb.c.f19227a);
            sb.p pVar = this.f11338o;
            if (zAreEqual) {
                this.f11336m = null;
                this.f11335b = 1;
                if (sb.p.a(pVar, cVar, this) == coroutine_suspended) {
                    return coroutine_suspended;
                }
            } else if (i.areEqual(qVar, sb.f.f19230a)) {
                this.f11336m = null;
                this.f11335b = 2;
                if (sb.p.b(pVar, cVar, this) == coroutine_suspended) {
                    return coroutine_suspended;
                }
            } else if (qVar instanceof sb.a) {
                this.f11336m = null;
                this.f11335b = 3;
                if (sb.p.a(pVar, (sb.a) qVar, cVar, this) == coroutine_suspended) {
                    return coroutine_suspended;
                }
            }
        } else {
            if (i10 != 1 && i10 != 2 && i10 != 3) {
                throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
            }
            f.throwOnFailure(obj);
        }
        return h.f16056a;
    }
}
