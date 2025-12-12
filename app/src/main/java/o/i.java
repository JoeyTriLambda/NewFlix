package o;

import kg.s0;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import qf.c;
import yf.p;

/* loaded from: classes2.dex */
public final class i extends SuspendLambda implements p {

    /* renamed from: b, reason: collision with root package name */
    public yg.b f16855b;

    /* renamed from: m, reason: collision with root package name */
    public String f16856m;

    /* renamed from: n, reason: collision with root package name */
    public int f16857n;

    /* renamed from: o, reason: collision with root package name */
    public final /* synthetic */ yg.b f16858o;

    /* renamed from: p, reason: collision with root package name */
    public final /* synthetic */ String f16859p;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public i(yg.b bVar, String str, c cVar) {
        super(2, cVar);
        this.f16858o = bVar;
        this.f16859p = str;
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final c create(Object obj, c cVar) {
        return new i(this.f16858o, this.f16859p, cVar);
    }

    @Override // yf.p
    public final Object invoke(Object obj, Object obj2) {
        return new i(this.f16858o, this.f16859p, (c) obj2).invokeSuspend(lf.h.f16056a);
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Object invokeSuspend(Object obj) throws Throwable {
        yg.b bVar;
        String str;
        Object coroutine_suspended = rf.a.getCOROUTINE_SUSPENDED();
        int i10 = this.f16857n;
        String str2 = this.f16859p;
        if (i10 == 0) {
            lf.f.throwOnFailure(obj);
            bVar = this.f16858o;
            yg.c cVar = (yg.c) bVar.f22540b.get(str2);
            if (cVar != null) {
                kotlinx.coroutines.b io2 = s0.getIO();
                h hVar = new h(cVar, null);
                this.f16855b = bVar;
                this.f16856m = str2;
                this.f16857n = 1;
                if (kg.f.withContext(io2, hVar, this) == coroutine_suspended) {
                    return coroutine_suspended;
                }
                str = str2;
            }
            throw new b(str2);
        }
        if (i10 != 1) {
            throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
        }
        str = this.f16856m;
        bVar = this.f16855b;
        lf.f.throwOnFailure(obj);
        yg.c cVar2 = (yg.c) bVar.f22540b.remove(str);
        if (cVar2 != null) {
            return cVar2;
        }
        throw new b(str2);
    }
}
