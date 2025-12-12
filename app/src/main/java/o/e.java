package o;

import kg.g0;
import kg.s0;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import yf.p;
import yg.c;

/* loaded from: classes2.dex */
public final class e extends SuspendLambda implements p {

    /* renamed from: b, reason: collision with root package name */
    public yg.b f16840b;

    /* renamed from: m, reason: collision with root package name */
    public String f16841m;

    /* renamed from: n, reason: collision with root package name */
    public c f16842n;

    /* renamed from: o, reason: collision with root package name */
    public int f16843o;

    /* renamed from: p, reason: collision with root package name */
    public final /* synthetic */ yg.b f16844p;

    /* renamed from: q, reason: collision with root package name */
    public final /* synthetic */ String f16845q;

    /* renamed from: r, reason: collision with root package name */
    public final /* synthetic */ String f16846r;

    /* renamed from: s, reason: collision with root package name */
    public final /* synthetic */ int f16847s;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public e(yg.b bVar, String str, String str2, int i10, qf.c cVar) {
        super(2, cVar);
        this.f16844p = bVar;
        this.f16845q = str;
        this.f16846r = str2;
        this.f16847s = i10;
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final qf.c create(Object obj, qf.c cVar) {
        return new e(this.f16844p, this.f16845q, this.f16846r, this.f16847s, cVar);
    }

    @Override // yf.p
    public final Object invoke(Object obj, Object obj2) {
        return ((e) create((g0) obj, (qf.c) obj2)).invokeSuspend(lf.h.f16056a);
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Object invokeSuspend(Object obj) throws Throwable {
        c cVar;
        yg.b bVar;
        String str;
        Object coroutine_suspended = rf.a.getCOROUTINE_SUSPENDED();
        int i10 = this.f16843o;
        if (i10 == 0) {
            lf.f.throwOnFailure(obj);
            c cVar2 = new c();
            kotlinx.coroutines.b io2 = s0.getIO();
            d dVar = new d(cVar2, this.f16846r, this.f16847s, null);
            yg.b bVar2 = this.f16844p;
            this.f16840b = bVar2;
            String str2 = this.f16845q;
            this.f16841m = str2;
            this.f16842n = cVar2;
            this.f16843o = 1;
            if (kg.f.withContext(io2, dVar, this) == coroutine_suspended) {
                return coroutine_suspended;
            }
            cVar = cVar2;
            bVar = bVar2;
            str = str2;
        } else {
            if (i10 != 1) {
                throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
            }
            cVar = this.f16842n;
            str = this.f16841m;
            bVar = this.f16840b;
            lf.f.throwOnFailure(obj);
        }
        bVar.f22540b.put(str, cVar);
        return cVar;
    }
}
