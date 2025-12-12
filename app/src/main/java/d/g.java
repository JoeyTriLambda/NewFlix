package d;

import kotlin.coroutines.jvm.internal.ContinuationImpl;
import qb.d;

/* loaded from: classes2.dex */
public final class g extends ContinuationImpl {

    /* renamed from: b, reason: collision with root package name */
    public /* synthetic */ Object f10733b;

    /* renamed from: m, reason: collision with root package name */
    public int f10734m;

    /* renamed from: n, reason: collision with root package name */
    public final /* synthetic */ d f10735n;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public g(d dVar, qf.c cVar) {
        super(cVar);
        this.f10735n = dVar;
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Object invokeSuspend(Object obj) {
        this.f10733b = obj;
        this.f10734m |= Integer.MIN_VALUE;
        return this.f10735n.emit(null, this);
    }
}
