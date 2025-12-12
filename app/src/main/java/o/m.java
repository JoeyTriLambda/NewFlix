package o;

import kg.g0;
import kg.s0;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import qf.c;
import yf.p;

/* loaded from: classes2.dex */
public final class m extends SuspendLambda implements p {

    /* renamed from: b, reason: collision with root package name */
    public yg.b f16874b;

    /* renamed from: m, reason: collision with root package name */
    public String f16875m;

    /* renamed from: n, reason: collision with root package name */
    public yg.a f16876n;

    /* renamed from: o, reason: collision with root package name */
    public int f16877o;

    /* renamed from: p, reason: collision with root package name */
    public final /* synthetic */ yg.b f16878p;

    /* renamed from: q, reason: collision with root package name */
    public final /* synthetic */ String f16879q;

    /* renamed from: r, reason: collision with root package name */
    public final /* synthetic */ String f16880r;

    /* renamed from: s, reason: collision with root package name */
    public final /* synthetic */ int f16881s;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public m(yg.b bVar, String str, String str2, int i10, c cVar) {
        super(2, cVar);
        this.f16878p = bVar;
        this.f16879q = str;
        this.f16880r = str2;
        this.f16881s = i10;
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final c create(Object obj, c cVar) {
        return new m(this.f16878p, this.f16879q, this.f16880r, this.f16881s, cVar);
    }

    @Override // yf.p
    public final Object invoke(Object obj, Object obj2) {
        return ((m) create((g0) obj, (c) obj2)).invokeSuspend(lf.h.f16056a);
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Object invokeSuspend(Object obj) throws Throwable {
        yg.a aVar;
        yg.b bVar;
        String str;
        Object coroutine_suspended = rf.a.getCOROUTINE_SUSPENDED();
        int i10 = this.f16877o;
        if (i10 == 0) {
            lf.f.throwOnFailure(obj);
            yg.a aVar2 = new yg.a(false);
            kotlinx.coroutines.b io2 = s0.getIO();
            l lVar = new l(aVar2, this.f16880r, this.f16881s, null);
            yg.b bVar2 = this.f16878p;
            this.f16874b = bVar2;
            String str2 = this.f16879q;
            this.f16875m = str2;
            this.f16876n = aVar2;
            this.f16877o = 1;
            if (kg.f.withContext(io2, lVar, this) == coroutine_suspended) {
                return coroutine_suspended;
            }
            aVar = aVar2;
            bVar = bVar2;
            str = str2;
        } else {
            if (i10 != 1) {
                throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
            }
            aVar = this.f16876n;
            str = this.f16875m;
            bVar = this.f16874b;
            lf.f.throwOnFailure(obj);
        }
        bVar.f22539a.put(str, aVar);
        return aVar;
    }
}
