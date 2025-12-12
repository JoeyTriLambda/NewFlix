package n;

import kotlin.coroutines.jvm.internal.ContinuationImpl;
import qf.c;

/* loaded from: classes2.dex */
public final class e0 extends ContinuationImpl {

    /* renamed from: b, reason: collision with root package name */
    public /* synthetic */ Object f16361b;

    /* renamed from: m, reason: collision with root package name */
    public int f16362m;

    /* renamed from: n, reason: collision with root package name */
    public final /* synthetic */ xg.v f16363n;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public e0(xg.v vVar, c cVar) {
        super(cVar);
        this.f16363n = vVar;
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Object invokeSuspend(Object obj) {
        this.f16361b = obj;
        this.f16362m |= Integer.MIN_VALUE;
        return this.f16363n.emit(null, this);
    }
}
