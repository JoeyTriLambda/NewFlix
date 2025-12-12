package f;

import kotlin.coroutines.jvm.internal.ContinuationImpl;
import qf.c;

/* loaded from: classes2.dex */
public final class v extends ContinuationImpl {

    /* renamed from: b, reason: collision with root package name */
    public sb.p f11369b;

    /* renamed from: m, reason: collision with root package name */
    public /* synthetic */ Object f11370m;

    /* renamed from: n, reason: collision with root package name */
    public final /* synthetic */ sb.p f11371n;

    /* renamed from: o, reason: collision with root package name */
    public int f11372o;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public v(sb.p pVar, c cVar) {
        super(cVar);
        this.f11371n = pVar;
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Object invokeSuspend(Object obj) {
        this.f11370m = obj;
        this.f11372o |= Integer.MIN_VALUE;
        return sb.p.b(this.f11371n, null, this);
    }
}
