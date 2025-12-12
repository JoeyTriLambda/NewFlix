package f;

import kotlin.coroutines.jvm.internal.ContinuationImpl;
import qf.c;

/* loaded from: classes2.dex */
public final class t extends ContinuationImpl {

    /* renamed from: b, reason: collision with root package name */
    public sb.p f11363b;

    /* renamed from: m, reason: collision with root package name */
    public /* synthetic */ Object f11364m;

    /* renamed from: n, reason: collision with root package name */
    public final /* synthetic */ sb.p f11365n;

    /* renamed from: o, reason: collision with root package name */
    public int f11366o;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public t(sb.p pVar, c cVar) {
        super(cVar);
        this.f11365n = pVar;
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Object invokeSuspend(Object obj) {
        this.f11364m = obj;
        this.f11366o |= Integer.MIN_VALUE;
        return sb.p.a(this.f11365n, null, this);
    }
}
