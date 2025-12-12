package n;

import kotlin.coroutines.jvm.internal.ContinuationImpl;
import qf.c;

/* renamed from: n.j, reason: case insensitive filesystem */
/* loaded from: classes2.dex */
public final class C0348j extends ContinuationImpl {

    /* renamed from: b, reason: collision with root package name */
    public /* synthetic */ Object f16370b;

    /* renamed from: m, reason: collision with root package name */
    public int f16371m;

    /* renamed from: n, reason: collision with root package name */
    public final /* synthetic */ xg.c0 f16372n;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public C0348j(xg.c0 c0Var, c cVar) {
        super(cVar);
        this.f16372n = c0Var;
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Object invokeSuspend(Object obj) {
        this.f16370b = obj;
        this.f16371m |= Integer.MIN_VALUE;
        return this.f16372n.emit(null, this);
    }
}
