package n;

import kotlin.coroutines.jvm.internal.ContinuationImpl;
import qf.c;
import xg.k;

/* loaded from: classes2.dex */
public final class U extends ContinuationImpl {

    /* renamed from: b, reason: collision with root package name */
    public /* synthetic */ Object f16349b;

    /* renamed from: m, reason: collision with root package name */
    public int f16350m;

    /* renamed from: n, reason: collision with root package name */
    public final /* synthetic */ k f16351n;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public U(k kVar, c cVar) {
        super(cVar);
        this.f16351n = kVar;
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Object invokeSuspend(Object obj) {
        this.f16349b = obj;
        this.f16350m |= Integer.MIN_VALUE;
        return this.f16351n.emit(null, this);
    }
}
