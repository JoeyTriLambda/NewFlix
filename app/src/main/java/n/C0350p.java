package n;

import kotlin.coroutines.jvm.internal.ContinuationImpl;
import qf.c;

/* renamed from: n.p, reason: case insensitive filesystem */
/* loaded from: classes2.dex */
public final class C0350p extends ContinuationImpl {

    /* renamed from: b, reason: collision with root package name */
    public /* synthetic */ Object f16382b;

    /* renamed from: m, reason: collision with root package name */
    public int f16383m;

    /* renamed from: n, reason: collision with root package name */
    public final /* synthetic */ xg.h0 f16384n;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public C0350p(xg.h0 h0Var, c cVar) {
        super(cVar);
        this.f16384n = h0Var;
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Object invokeSuspend(Object obj) {
        this.f16382b = obj;
        this.f16383m |= Integer.MIN_VALUE;
        return this.f16384n.emit(null, this);
    }
}
