package c;

import kotlin.coroutines.jvm.internal.ContinuationImpl;
import l3.t;

/* loaded from: classes.dex */
public final class s extends ContinuationImpl {

    /* renamed from: b, reason: collision with root package name */
    public /* synthetic */ Object f4994b;

    /* renamed from: m, reason: collision with root package name */
    public int f4995m;

    /* renamed from: n, reason: collision with root package name */
    public final /* synthetic */ t f4996n;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public s(t tVar, qf.c cVar) {
        super(cVar);
        this.f4996n = tVar;
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Object invokeSuspend(Object obj) {
        this.f4994b = obj;
        this.f4995m |= Integer.MIN_VALUE;
        return this.f4996n.emit(null, this);
    }
}
