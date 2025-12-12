package o;

import kg.g0;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import qf.c;
import yf.p;

/* loaded from: classes2.dex */
public final class l extends SuspendLambda implements p {

    /* renamed from: b, reason: collision with root package name */
    public final /* synthetic */ yg.a f16871b;

    /* renamed from: m, reason: collision with root package name */
    public final /* synthetic */ String f16872m;

    /* renamed from: n, reason: collision with root package name */
    public final /* synthetic */ int f16873n;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public l(yg.a aVar, String str, int i10, c cVar) {
        super(2, cVar);
        this.f16871b = aVar;
        this.f16872m = str;
        this.f16873n = i10;
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final c create(Object obj, c cVar) {
        return new l(this.f16871b, this.f16872m, this.f16873n, cVar);
    }

    @Override // yf.p
    public final Object invoke(Object obj, Object obj2) {
        return ((l) create((g0) obj, (c) obj2)).invokeSuspend(lf.h.f16056a);
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Object invokeSuspend(Object obj) throws Throwable {
        rf.a.getCOROUTINE_SUSPENDED();
        lf.f.throwOnFailure(obj);
        this.f16871b.a(this.f16872m, this.f16873n);
        return lf.h.f16056a;
    }
}
