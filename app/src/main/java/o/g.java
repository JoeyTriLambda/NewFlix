package o;

import kg.s0;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import qf.c;
import yf.p;

/* loaded from: classes2.dex */
public final class g extends SuspendLambda implements p {

    /* renamed from: b, reason: collision with root package name */
    public yg.b f16849b;

    /* renamed from: m, reason: collision with root package name */
    public String f16850m;

    /* renamed from: n, reason: collision with root package name */
    public int f16851n;

    /* renamed from: o, reason: collision with root package name */
    public final /* synthetic */ yg.b f16852o;

    /* renamed from: p, reason: collision with root package name */
    public final /* synthetic */ String f16853p;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public g(yg.b bVar, String str, c cVar) {
        super(2, cVar);
        this.f16852o = bVar;
        this.f16853p = str;
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final c create(Object obj, c cVar) {
        return new g(this.f16852o, this.f16853p, cVar);
    }

    @Override // yf.p
    public final Object invoke(Object obj, Object obj2) {
        return new g(this.f16852o, this.f16853p, (c) obj2).invokeSuspend(lf.h.f16056a);
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Object invokeSuspend(Object obj) throws Throwable {
        yg.b bVar;
        String str;
        Object coroutine_suspended = rf.a.getCOROUTINE_SUSPENDED();
        int i10 = this.f16851n;
        String str2 = this.f16853p;
        if (i10 == 0) {
            lf.f.throwOnFailure(obj);
            bVar = this.f16852o;
            yg.a aVar = (yg.a) bVar.f22539a.get(str2);
            if (aVar != null) {
                kotlinx.coroutines.b io2 = s0.getIO();
                f fVar = new f(aVar, null);
                this.f16849b = bVar;
                this.f16850m = str2;
                this.f16851n = 1;
                if (kg.f.withContext(io2, fVar, this) == coroutine_suspended) {
                    return coroutine_suspended;
                }
                str = str2;
            }
            throw new b(str2);
        }
        if (i10 != 1) {
            throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
        }
        str = this.f16850m;
        bVar = this.f16849b;
        lf.f.throwOnFailure(obj);
        yg.a aVar2 = (yg.a) bVar.f22539a.remove(str);
        if (aVar2 != null) {
            return aVar2;
        }
        throw new b(str2);
    }
}
