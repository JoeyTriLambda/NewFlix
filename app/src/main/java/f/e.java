package f;

import kotlin.Triple;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import lf.f;
import lf.h;
import qb.n;
import qf.c;
import yf.r;

/* loaded from: classes2.dex */
public final class e extends SuspendLambda implements r {

    /* renamed from: b, reason: collision with root package name */
    public /* synthetic */ boolean f11341b;

    /* renamed from: m, reason: collision with root package name */
    public /* synthetic */ l3.g f11342m;

    /* renamed from: n, reason: collision with root package name */
    public /* synthetic */ n f11343n;

    public e(c cVar) {
        super(4, cVar);
    }

    @Override // yf.r
    public final Object invoke(Object obj, Object obj2, Object obj3, Object obj4) {
        boolean zBooleanValue = ((Boolean) obj).booleanValue();
        e eVar = new e((c) obj4);
        eVar.f11341b = zBooleanValue;
        eVar.f11342m = (l3.g) obj2;
        eVar.f11343n = (n) obj3;
        return eVar.invokeSuspend(h.f16056a);
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Object invokeSuspend(Object obj) throws Throwable {
        rf.a.getCOROUTINE_SUSPENDED();
        f.throwOnFailure(obj);
        boolean z10 = this.f11341b;
        return new Triple(sf.a.boxBoolean(z10), this.f11342m, this.f11343n);
    }
}
