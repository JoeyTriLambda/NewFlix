package c;

import kotlin.coroutines.jvm.internal.ContinuationImpl;
import l3.w;

/* loaded from: classes.dex */
public final class e extends ContinuationImpl {

    /* renamed from: b, reason: collision with root package name */
    public /* synthetic */ Object f4945b;

    /* renamed from: m, reason: collision with root package name */
    public final /* synthetic */ w f4946m;

    /* renamed from: n, reason: collision with root package name */
    public int f4947n;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public e(w wVar, qf.c cVar) {
        super(cVar);
        this.f4946m = wVar;
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Object invokeSuspend(Object obj) {
        this.f4945b = obj;
        this.f4947n |= Integer.MIN_VALUE;
        return w.a(this.f4946m, (String) null, this);
    }
}
