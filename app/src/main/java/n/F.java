package n;

import kotlin.coroutines.jvm.internal.ContinuationImpl;
import qf.c;
import xg.d;

/* loaded from: classes2.dex */
public final class F extends ContinuationImpl {

    /* renamed from: b, reason: collision with root package name */
    public /* synthetic */ Object f16328b;

    /* renamed from: m, reason: collision with root package name */
    public int f16329m;

    /* renamed from: n, reason: collision with root package name */
    public final /* synthetic */ d f16330n;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public F(d dVar, c cVar) {
        super(cVar);
        this.f16330n = dVar;
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Object invokeSuspend(Object obj) {
        this.f16328b = obj;
        this.f16329m |= Integer.MIN_VALUE;
        return this.f16330n.emit(null, this);
    }
}
