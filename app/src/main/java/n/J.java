package n;

import kotlin.coroutines.jvm.internal.ContinuationImpl;
import qf.c;
import xg.f;

/* loaded from: classes2.dex */
public final class J extends ContinuationImpl {

    /* renamed from: b, reason: collision with root package name */
    public /* synthetic */ Object f16334b;

    /* renamed from: m, reason: collision with root package name */
    public int f16335m;

    /* renamed from: n, reason: collision with root package name */
    public final /* synthetic */ f f16336n;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public J(f fVar, c cVar) {
        super(cVar);
        this.f16336n = fVar;
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Object invokeSuspend(Object obj) {
        this.f16334b = obj;
        this.f16335m |= Integer.MIN_VALUE;
        return this.f16336n.emit(null, this);
    }
}
