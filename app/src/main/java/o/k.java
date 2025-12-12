package o;

import kg.g0;
import kg.s0;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import qf.c;
import yf.p;

/* loaded from: classes2.dex */
public final class k extends SuspendLambda implements p {

    /* renamed from: b, reason: collision with root package name */
    public yg.b f16863b;

    /* renamed from: m, reason: collision with root package name */
    public String f16864m;

    /* renamed from: n, reason: collision with root package name */
    public yg.a f16865n;

    /* renamed from: o, reason: collision with root package name */
    public int f16866o;

    /* renamed from: p, reason: collision with root package name */
    public final /* synthetic */ yg.b f16867p;

    /* renamed from: q, reason: collision with root package name */
    public final /* synthetic */ String f16868q = "main";

    /* renamed from: r, reason: collision with root package name */
    public final /* synthetic */ String f16869r;

    /* renamed from: s, reason: collision with root package name */
    public final /* synthetic */ int f16870s;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public k(yg.b bVar, String str, int i10, c cVar) {
        super(2, cVar);
        this.f16867p = bVar;
        this.f16869r = str;
        this.f16870s = i10;
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final c create(Object obj, c cVar) {
        return new k(this.f16867p, this.f16869r, this.f16870s, cVar);
    }

    @Override // yf.p
    public final Object invoke(Object obj, Object obj2) {
        return ((k) create((g0) obj, (c) obj2)).invokeSuspend(lf.h.f16056a);
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Object invokeSuspend(Object obj) throws Throwable {
        yg.a aVar;
        yg.b bVar;
        String str;
        Object coroutine_suspended = rf.a.getCOROUTINE_SUSPENDED();
        int i10 = this.f16866o;
        if (i10 == 0) {
            lf.f.throwOnFailure(obj);
            yg.a aVar2 = new yg.a(true);
            kotlinx.coroutines.b io2 = s0.getIO();
            j jVar = new j(aVar2, this.f16869r, this.f16870s, null);
            yg.b bVar2 = this.f16867p;
            this.f16863b = bVar2;
            String str2 = this.f16868q;
            this.f16864m = str2;
            this.f16865n = aVar2;
            this.f16866o = 1;
            if (kg.f.withContext(io2, jVar, this) == coroutine_suspended) {
                return coroutine_suspended;
            }
            aVar = aVar2;
            bVar = bVar2;
            str = str2;
        } else {
            if (i10 != 1) {
                throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
            }
            aVar = this.f16865n;
            str = this.f16864m;
            bVar = this.f16863b;
            lf.f.throwOnFailure(obj);
        }
        bVar.f22539a.put(str, aVar);
        return aVar;
    }
}
