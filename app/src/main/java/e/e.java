package e;

import kg.g0;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import xg.r;
import yf.p;

/* loaded from: classes2.dex */
public final class e extends SuspendLambda implements p {

    /* renamed from: b, reason: collision with root package name */
    public final /* synthetic */ rb.p f11078b;

    /* renamed from: m, reason: collision with root package name */
    public final /* synthetic */ int f11079m;

    /* renamed from: n, reason: collision with root package name */
    public final /* synthetic */ byte[] f11080n;

    /* renamed from: o, reason: collision with root package name */
    public final /* synthetic */ int f11081o;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public e(rb.p pVar, int i10, byte[] bArr, int i11, qf.c cVar) {
        super(2, cVar);
        this.f11078b = pVar;
        this.f11079m = i10;
        this.f11080n = bArr;
        this.f11081o = i11;
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final qf.c create(Object obj, qf.c cVar) {
        return new e(this.f11078b, this.f11079m, this.f11080n, this.f11081o, cVar);
    }

    @Override // yf.p
    public final Object invoke(Object obj, Object obj2) {
        return ((e) create((g0) obj, (qf.c) obj2)).invokeSuspend(lf.h.f16056a);
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Object invokeSuspend(Object obj) throws Throwable {
        rf.a.getCOROUTINE_SUSPENDED();
        lf.f.throwOnFailure(obj);
        this.f11078b.f18912t.a(new r(this.f11079m, true, this.f11080n, this.f11081o, null, 16));
        return lf.h.f16056a;
    }
}
