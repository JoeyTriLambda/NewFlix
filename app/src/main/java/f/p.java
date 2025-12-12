package f;

import kotlin.coroutines.jvm.internal.ContinuationImpl;
import qf.c;
import sb.n;

/* loaded from: classes2.dex */
public final class p extends ContinuationImpl {

    /* renamed from: b, reason: collision with root package name */
    public /* synthetic */ Object f11356b;

    /* renamed from: m, reason: collision with root package name */
    public int f11357m;

    /* renamed from: n, reason: collision with root package name */
    public final /* synthetic */ n f11358n;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public p(n nVar, c cVar) {
        super(cVar);
        this.f11358n = nVar;
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Object invokeSuspend(Object obj) {
        this.f11356b = obj;
        this.f11357m |= Integer.MIN_VALUE;
        return this.f11358n.emit(null, this);
    }
}
