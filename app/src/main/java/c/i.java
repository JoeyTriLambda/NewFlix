package c;

import kotlin.coroutines.jvm.internal.ContinuationImpl;
import l3.w;

/* loaded from: classes.dex */
public final class i extends ContinuationImpl {

    /* renamed from: b, reason: collision with root package name */
    public w f4960b;

    /* renamed from: m, reason: collision with root package name */
    public /* synthetic */ Object f4961m;

    /* renamed from: n, reason: collision with root package name */
    public final /* synthetic */ w f4962n;

    /* renamed from: o, reason: collision with root package name */
    public int f4963o;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public i(w wVar, qf.c cVar) {
        super(cVar);
        this.f4962n = wVar;
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Object invokeSuspend(Object obj) {
        this.f4961m = obj;
        this.f4963o |= Integer.MIN_VALUE;
        return w.a(this.f4962n, (l3.k) null, (oa.c) null, this);
    }
}
