package c;

import kotlin.coroutines.jvm.internal.ContinuationImpl;
import l3.w;

/* loaded from: classes.dex */
public final class o extends ContinuationImpl {

    /* renamed from: b, reason: collision with root package name */
    public w f4984b;

    /* renamed from: m, reason: collision with root package name */
    public /* synthetic */ Object f4985m;

    /* renamed from: n, reason: collision with root package name */
    public final /* synthetic */ w f4986n;

    /* renamed from: o, reason: collision with root package name */
    public int f4987o;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public o(w wVar, qf.c cVar) {
        super(cVar);
        this.f4986n = wVar;
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Object invokeSuspend(Object obj) {
        this.f4985m = obj;
        this.f4987o |= Integer.MIN_VALUE;
        return w.a(this.f4986n, (l3.q) null, (oa.c) null, this);
    }
}
