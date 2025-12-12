package c;

import kotlin.coroutines.jvm.internal.ContinuationImpl;
import l3.w;

/* loaded from: classes.dex */
public final class q extends ContinuationImpl {

    /* renamed from: b, reason: collision with root package name */
    public /* synthetic */ Object f4991b;

    /* renamed from: m, reason: collision with root package name */
    public final /* synthetic */ w f4992m;

    /* renamed from: n, reason: collision with root package name */
    public int f4993n;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public q(w wVar, qf.c cVar) {
        super(cVar);
        this.f4992m = wVar;
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Object invokeSuspend(Object obj) {
        this.f4991b = obj;
        this.f4993n |= Integer.MIN_VALUE;
        return w.a(this.f4992m, this);
    }
}
