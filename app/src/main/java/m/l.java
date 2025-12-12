package m;

import kg.m0;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import lf.f;
import qf.c;
import rf.a;

/* loaded from: classes2.dex */
public final class l extends SuspendLambda implements yf.p {

    /* renamed from: b, reason: collision with root package name */
    public int f16075b;

    /* renamed from: m, reason: collision with root package name */
    public long f16076m;

    /* renamed from: n, reason: collision with root package name */
    public int f16077n;

    /* renamed from: o, reason: collision with root package name */
    public final /* synthetic */ wg.g f16078o;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public l(wg.g gVar, c cVar) {
        super(2, cVar);
        this.f16078o = gVar;
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final c create(Object obj, c cVar) {
        return new l(this.f16078o, cVar);
    }

    @Override // yf.p
    public final Object invoke(Object obj, Object obj2) {
        return new l(this.f16078o, (c) obj2).invokeSuspend(lf.h.f16056a);
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Object invokeSuspend(Object obj) throws Throwable {
        long jCurrentTimeMillis;
        int i10;
        Object coroutine_suspended = a.getCOROUTINE_SUSPENDED();
        int i11 = this.f16077n;
        wg.g gVar = this.f16078o;
        if (i11 == 0) {
            f.throwOnFailure(obj);
            jCurrentTimeMillis = System.currentTimeMillis();
            ng.g gVar2 = k.c.f14701a;
            k.c.a("TcpWindowHandler", "TcpWindowHandler: send: [" + gVar.f21165a + "] start");
            i10 = 0;
        } else {
            if (i11 != 1) {
                throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
            }
            jCurrentTimeMillis = this.f16076m;
            i10 = this.f16075b;
            f.throwOnFailure(obj);
        }
        while (gVar.f21170f - gVar.f21169e > gVar.f21166b) {
            this.f16075b = 1;
            this.f16076m = jCurrentTimeMillis;
            this.f16077n = 1;
            if (m0.delay(10L, this) == coroutine_suspended) {
                return coroutine_suspended;
            }
            i10 = 1;
        }
        ng.g gVar3 = k.c.f14701a;
        StringBuilder sb2 = new StringBuilder("TcpWindowHandler: send: [");
        sb2.append(gVar.f21165a);
        sb2.append("] waiting=");
        sb2.append(i10 != 0);
        sb2.append(", wait=");
        sb2.append(System.currentTimeMillis() - jCurrentTimeMillis);
        sb2.append(" ms");
        k.c.a("TcpWindowHandler", sb2.toString());
        return lf.h.f16056a;
    }
}
