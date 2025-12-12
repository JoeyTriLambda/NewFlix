package c;

import kotlin.coroutines.jvm.internal.ContinuationImpl;
import l3.w;

/* renamed from: c.l, reason: case insensitive filesystem */
/* loaded from: classes.dex */
public final class C0341l extends ContinuationImpl {

    /* renamed from: b, reason: collision with root package name */
    public w f4972b;

    /* renamed from: m, reason: collision with root package name */
    public /* synthetic */ Object f4973m;

    /* renamed from: n, reason: collision with root package name */
    public final /* synthetic */ w f4974n;

    /* renamed from: o, reason: collision with root package name */
    public int f4975o;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public C0341l(w wVar, qf.c cVar) {
        super(cVar);
        this.f4974n = wVar;
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Object invokeSuspend(Object obj) {
        this.f4973m = obj;
        this.f4975o |= Integer.MIN_VALUE;
        return w.b(this.f4974n, null, this);
    }
}
