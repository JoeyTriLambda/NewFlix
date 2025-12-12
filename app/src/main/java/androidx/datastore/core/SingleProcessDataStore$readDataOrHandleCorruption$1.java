package androidx.datastore.core;

import kotlin.coroutines.jvm.internal.ContinuationImpl;
import qf.c;
import sf.d;

/* compiled from: SingleProcessDataStore.kt */
@d(c = "androidx.datastore.core.SingleProcessDataStore", f = "SingleProcessDataStore.kt", l = {359, 362, 365}, m = "readDataOrHandleCorruption")
/* loaded from: classes.dex */
public final class SingleProcessDataStore$readDataOrHandleCorruption$1 extends ContinuationImpl {

    /* renamed from: b, reason: collision with root package name */
    public Object f2265b;

    /* renamed from: m, reason: collision with root package name */
    public Object f2266m;

    /* renamed from: n, reason: collision with root package name */
    public /* synthetic */ Object f2267n;

    /* renamed from: o, reason: collision with root package name */
    public final /* synthetic */ SingleProcessDataStore<T> f2268o;

    /* renamed from: p, reason: collision with root package name */
    public int f2269p;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public SingleProcessDataStore$readDataOrHandleCorruption$1(SingleProcessDataStore<T> singleProcessDataStore, c<? super SingleProcessDataStore$readDataOrHandleCorruption$1> cVar) {
        super(cVar);
        this.f2268o = singleProcessDataStore;
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Object invokeSuspend(Object obj) {
        this.f2267n = obj;
        this.f2269p |= Integer.MIN_VALUE;
        return this.f2268o.f(this);
    }
}
