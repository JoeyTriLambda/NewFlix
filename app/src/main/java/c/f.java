package c;

import kotlin.coroutines.jvm.internal.ContinuationImpl;
import l3.w;

/* loaded from: classes.dex */
public final class f extends ContinuationImpl {

    /* renamed from: b, reason: collision with root package name */
    public w f4948b;

    /* renamed from: m, reason: collision with root package name */
    public /* synthetic */ Object f4949m;

    /* renamed from: n, reason: collision with root package name */
    public final /* synthetic */ w f4950n;

    /* renamed from: o, reason: collision with root package name */
    public int f4951o;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public f(w wVar, qf.c cVar) {
        super(cVar);
        this.f4950n = wVar;
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Object invokeSuspend(Object obj) {
        this.f4949m = obj;
        this.f4951o |= Integer.MIN_VALUE;
        return w.a(this.f4950n, (oa.c) null, this);
    }
}
