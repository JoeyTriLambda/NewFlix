package d;

import kotlin.coroutines.jvm.internal.ContinuationImpl;
import qb.f;

/* loaded from: classes2.dex */
public final class k extends ContinuationImpl {

    /* renamed from: b, reason: collision with root package name */
    public /* synthetic */ Object f10738b;

    /* renamed from: m, reason: collision with root package name */
    public int f10739m;

    /* renamed from: n, reason: collision with root package name */
    public final /* synthetic */ f f10740n;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public k(f fVar, qf.c cVar) {
        super(cVar);
        this.f10740n = fVar;
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Object invokeSuspend(Object obj) {
        this.f10738b = obj;
        this.f10739m |= Integer.MIN_VALUE;
        return this.f10740n.emit(null, this);
    }
}
