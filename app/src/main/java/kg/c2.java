package kg;

import kotlin.Result;

/* compiled from: JobSupport.kt */
/* loaded from: classes2.dex */
public final class c2 extends q1 {

    /* renamed from: p, reason: collision with root package name */
    public final qf.c<lf.h> f15098p;

    /* JADX WARN: Multi-variable type inference failed */
    public c2(qf.c<? super lf.h> cVar) {
        this.f15098p = cVar;
    }

    @Override // yf.l
    public /* bridge */ /* synthetic */ lf.h invoke(Throwable th2) {
        invoke2(th2);
        return lf.h.f16056a;
    }

    @Override // kg.b0
    /* renamed from: invoke, reason: avoid collision after fix types in other method */
    public void invoke2(Throwable th2) {
        int i10 = Result.f15189m;
        this.f15098p.resumeWith(Result.m59constructorimpl(lf.h.f16056a));
    }
}
