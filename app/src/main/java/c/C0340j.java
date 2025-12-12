package c;

import kotlin.coroutines.jvm.internal.ContinuationImpl;
import l3.w;

/* renamed from: c.j, reason: case insensitive filesystem */
/* loaded from: classes.dex */
public final class C0340j extends ContinuationImpl {

    /* renamed from: b, reason: collision with root package name */
    public w f4964b;

    /* renamed from: m, reason: collision with root package name */
    public l3.l f4965m;

    /* renamed from: n, reason: collision with root package name */
    public /* synthetic */ Object f4966n;

    /* renamed from: o, reason: collision with root package name */
    public final /* synthetic */ w f4967o;

    /* renamed from: p, reason: collision with root package name */
    public int f4968p;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public C0340j(w wVar, qf.c cVar) {
        super(cVar);
        this.f4967o = wVar;
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Object invokeSuspend(Object obj) {
        this.f4966n = obj;
        this.f4968p |= Integer.MIN_VALUE;
        return w.a(this.f4967o, (l3.l) null, (oa.c) null, this);
    }
}
