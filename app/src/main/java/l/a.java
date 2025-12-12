package l;

import kotlin.coroutines.jvm.internal.ContinuationImpl;
import qf.c;

/* loaded from: classes2.dex */
public final class a extends ContinuationImpl {

    /* renamed from: b, reason: collision with root package name */
    public /* synthetic */ Object f15628b;

    /* renamed from: m, reason: collision with root package name */
    public final /* synthetic */ vg.a f15629m;

    /* renamed from: n, reason: collision with root package name */
    public int f15630n;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public a(vg.a aVar, c cVar) {
        super(cVar);
        this.f15629m = aVar;
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Object invokeSuspend(Object obj) {
        this.f15628b = obj;
        this.f15630n |= Integer.MIN_VALUE;
        return this.f15629m.a(null, this);
    }
}
