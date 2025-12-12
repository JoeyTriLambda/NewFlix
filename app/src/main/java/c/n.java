package c;

import kotlin.coroutines.jvm.internal.ContinuationImpl;
import l3.w;

/* loaded from: classes.dex */
public final class n extends ContinuationImpl {

    /* renamed from: b, reason: collision with root package name */
    public w f4978b;

    /* renamed from: m, reason: collision with root package name */
    public l3.p f4979m;

    /* renamed from: n, reason: collision with root package name */
    public oa.c f4980n;

    /* renamed from: o, reason: collision with root package name */
    public /* synthetic */ Object f4981o;

    /* renamed from: p, reason: collision with root package name */
    public final /* synthetic */ w f4982p;

    /* renamed from: q, reason: collision with root package name */
    public int f4983q;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public n(w wVar, qf.c cVar) {
        super(cVar);
        this.f4982p = wVar;
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Object invokeSuspend(Object obj) {
        this.f4981o = obj;
        this.f4983q |= Integer.MIN_VALUE;
        return w.a(this.f4982p, (l3.p) null, (oa.c) null, this);
    }
}
