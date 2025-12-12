package e;

import kotlin.coroutines.jvm.internal.ContinuationImpl;
import rb.p;

/* loaded from: classes2.dex */
public final class x extends ContinuationImpl {

    /* renamed from: b, reason: collision with root package name */
    public p f11107b;

    /* renamed from: m, reason: collision with root package name */
    public /* synthetic */ Object f11108m;

    /* renamed from: n, reason: collision with root package name */
    public final /* synthetic */ p f11109n;

    /* renamed from: o, reason: collision with root package name */
    public int f11110o;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public x(p pVar, qf.c cVar) {
        super(cVar);
        this.f11109n = pVar;
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Object invokeSuspend(Object obj) {
        this.f11108m = obj;
        this.f11110o |= Integer.MIN_VALUE;
        return p.a(this.f11109n, null, this);
    }
}
