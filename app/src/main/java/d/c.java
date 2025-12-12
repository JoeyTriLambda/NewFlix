package d;

import kotlin.coroutines.jvm.internal.ContinuationImpl;
import qb.h;

/* loaded from: classes2.dex */
public final class c extends ContinuationImpl {

    /* renamed from: b, reason: collision with root package name */
    public h f10727b;

    /* renamed from: m, reason: collision with root package name */
    public /* synthetic */ Object f10728m;

    /* renamed from: n, reason: collision with root package name */
    public final /* synthetic */ h f10729n;

    /* renamed from: o, reason: collision with root package name */
    public int f10730o;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public c(h hVar, qf.c cVar) {
        super(cVar);
        this.f10729n = hVar;
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Object invokeSuspend(Object obj) {
        this.f10728m = obj;
        this.f10730o |= Integer.MIN_VALUE;
        return h.a(this.f10729n, null, this);
    }
}
