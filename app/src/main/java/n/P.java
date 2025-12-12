package n;

import kotlin.coroutines.jvm.internal.ContinuationImpl;
import qf.c;
import xg.i;

/* loaded from: classes2.dex */
public final class P extends ContinuationImpl {

    /* renamed from: b, reason: collision with root package name */
    public /* synthetic */ Object f16343b;

    /* renamed from: m, reason: collision with root package name */
    public int f16344m;

    /* renamed from: n, reason: collision with root package name */
    public final /* synthetic */ i f16345n;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public P(i iVar, c cVar) {
        super(cVar);
        this.f16345n = iVar;
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Object invokeSuspend(Object obj) {
        this.f16343b = obj;
        this.f16344m |= Integer.MIN_VALUE;
        return this.f16345n.emit(null, this);
    }
}
