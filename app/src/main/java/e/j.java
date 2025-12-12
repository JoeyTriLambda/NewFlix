package e;

import kotlin.coroutines.jvm.internal.ContinuationImpl;
import rb.i;

/* loaded from: classes2.dex */
public final class j extends ContinuationImpl {

    /* renamed from: b, reason: collision with root package name */
    public /* synthetic */ Object f11090b;

    /* renamed from: m, reason: collision with root package name */
    public int f11091m;

    /* renamed from: n, reason: collision with root package name */
    public final /* synthetic */ i f11092n;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public j(i iVar, qf.c cVar) {
        super(cVar);
        this.f11092n = iVar;
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Object invokeSuspend(Object obj) {
        this.f11090b = obj;
        this.f11091m |= Integer.MIN_VALUE;
        return this.f11092n.emit(null, this);
    }
}
