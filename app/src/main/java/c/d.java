package c;

import kotlin.coroutines.jvm.internal.ContinuationImpl;
import l3.w;

/* loaded from: classes.dex */
public final class d extends ContinuationImpl {

    /* renamed from: b, reason: collision with root package name */
    public /* synthetic */ Object f4942b;

    /* renamed from: m, reason: collision with root package name */
    public final /* synthetic */ w f4943m;

    /* renamed from: n, reason: collision with root package name */
    public int f4944n;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public d(w wVar, qf.c cVar) {
        super(cVar);
        this.f4943m = wVar;
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Object invokeSuspend(Object obj) {
        this.f4942b = obj;
        this.f4944n |= Integer.MIN_VALUE;
        return this.f4943m.a(this);
    }
}
