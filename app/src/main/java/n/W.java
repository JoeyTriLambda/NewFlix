package n;

import kotlin.coroutines.jvm.internal.ContinuationImpl;
import qf.c;
import xg.l;

/* loaded from: classes2.dex */
public final class W extends ContinuationImpl {

    /* renamed from: b, reason: collision with root package name */
    public /* synthetic */ Object f16352b;

    /* renamed from: m, reason: collision with root package name */
    public int f16353m;

    /* renamed from: n, reason: collision with root package name */
    public final /* synthetic */ l f16354n;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public W(l lVar, c cVar) {
        super(cVar);
        this.f16354n = lVar;
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Object invokeSuspend(Object obj) {
        this.f16352b = obj;
        this.f16353m |= Integer.MIN_VALUE;
        return this.f16354n.emit(null, this);
    }
}
