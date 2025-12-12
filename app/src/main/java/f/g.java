package f;

import kotlin.coroutines.jvm.internal.ContinuationImpl;
import qf.c;

/* loaded from: classes2.dex */
public final class g extends ContinuationImpl {

    /* renamed from: b, reason: collision with root package name */
    public /* synthetic */ Object f11344b;

    /* renamed from: m, reason: collision with root package name */
    public int f11345m;

    /* renamed from: n, reason: collision with root package name */
    public final /* synthetic */ sb.j f11346n;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public g(sb.j jVar, c cVar) {
        super(cVar);
        this.f11346n = jVar;
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Object invokeSuspend(Object obj) {
        this.f11344b = obj;
        this.f11345m |= Integer.MIN_VALUE;
        return this.f11346n.emit(null, this);
    }
}
