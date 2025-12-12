package n;

import kotlin.coroutines.jvm.internal.ContinuationImpl;
import qf.c;
import xg.h;

/* loaded from: classes2.dex */
public final class N extends ContinuationImpl {

    /* renamed from: b, reason: collision with root package name */
    public /* synthetic */ Object f16340b;

    /* renamed from: m, reason: collision with root package name */
    public int f16341m;

    /* renamed from: n, reason: collision with root package name */
    public final /* synthetic */ h f16342n;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public N(h hVar, c cVar) {
        super(cVar);
        this.f16342n = hVar;
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Object invokeSuspend(Object obj) {
        this.f16340b = obj;
        this.f16341m |= Integer.MIN_VALUE;
        return this.f16342n.emit(null, this);
    }
}
