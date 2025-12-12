package c;

import kotlin.coroutines.jvm.internal.ContinuationImpl;
import l3.w;

/* loaded from: classes.dex */
public final class h extends ContinuationImpl {

    /* renamed from: b, reason: collision with root package name */
    public w f4954b;

    /* renamed from: m, reason: collision with root package name */
    public l3.j f4955m;

    /* renamed from: n, reason: collision with root package name */
    public oa.c f4956n;

    /* renamed from: o, reason: collision with root package name */
    public /* synthetic */ Object f4957o;

    /* renamed from: p, reason: collision with root package name */
    public final /* synthetic */ w f4958p;

    /* renamed from: q, reason: collision with root package name */
    public int f4959q;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public h(w wVar, qf.c cVar) {
        super(cVar);
        this.f4958p = wVar;
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Object invokeSuspend(Object obj) {
        this.f4957o = obj;
        this.f4959q |= Integer.MIN_VALUE;
        return w.a(this.f4958p, (l3.j) null, (oa.c) null, this);
    }
}
