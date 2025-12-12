package n;

import kotlin.coroutines.jvm.internal.ContinuationImpl;
import qf.c;

/* loaded from: classes2.dex */
public final class h0 extends ContinuationImpl {

    /* renamed from: b, reason: collision with root package name */
    public /* synthetic */ Object f16367b;

    /* renamed from: m, reason: collision with root package name */
    public int f16368m;

    /* renamed from: n, reason: collision with root package name */
    public final /* synthetic */ xg.z f16369n;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public h0(xg.z zVar, c cVar) {
        super(cVar);
        this.f16369n = zVar;
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Object invokeSuspend(Object obj) {
        this.f16367b = obj;
        this.f16368m |= Integer.MIN_VALUE;
        return this.f16369n.emit(null, this);
    }
}
