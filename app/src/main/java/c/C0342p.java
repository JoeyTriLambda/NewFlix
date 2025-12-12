package c;

import kotlin.coroutines.jvm.internal.ContinuationImpl;
import l3.w;

/* renamed from: c.p, reason: case insensitive filesystem */
/* loaded from: classes.dex */
public final class C0342p extends ContinuationImpl {

    /* renamed from: b, reason: collision with root package name */
    public /* synthetic */ Object f4988b;

    /* renamed from: m, reason: collision with root package name */
    public final /* synthetic */ w f4989m;

    /* renamed from: n, reason: collision with root package name */
    public int f4990n;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public C0342p(w wVar, qf.c cVar) {
        super(cVar);
        this.f4989m = wVar;
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Object invokeSuspend(Object obj) {
        this.f4988b = obj;
        this.f4990n |= Integer.MIN_VALUE;
        return this.f4989m.b(this);
    }
}
