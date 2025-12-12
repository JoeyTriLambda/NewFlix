package f;

import kotlin.coroutines.jvm.internal.ContinuationImpl;
import qf.c;

/* loaded from: classes2.dex */
public final class k extends ContinuationImpl {

    /* renamed from: b, reason: collision with root package name */
    public sb.p f11349b;

    /* renamed from: m, reason: collision with root package name */
    public /* synthetic */ Object f11350m;

    /* renamed from: n, reason: collision with root package name */
    public final /* synthetic */ sb.p f11351n;

    /* renamed from: o, reason: collision with root package name */
    public int f11352o;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public k(sb.p pVar, c cVar) {
        super(cVar);
        this.f11351n = pVar;
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Object invokeSuspend(Object obj) {
        this.f11350m = obj;
        this.f11352o |= Integer.MIN_VALUE;
        return sb.p.a(this.f11351n, null, null, this);
    }
}
