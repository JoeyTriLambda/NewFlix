package androidx.datastore.core;

import kotlin.coroutines.jvm.internal.ContinuationImpl;
import qf.c;
import sf.d;

/* compiled from: SingleProcessDataStore.kt */
@d(c = "androidx.datastore.core.SingleProcessDataStore", f = "SingleProcessDataStore.kt", l = {311}, m = "readAndInitOrPropagateFailure")
/* loaded from: classes.dex */
public final class SingleProcessDataStore$readAndInitOrPropagateFailure$1 extends ContinuationImpl {

    /* renamed from: b, reason: collision with root package name */
    public SingleProcessDataStore f2256b;

    /* renamed from: m, reason: collision with root package name */
    public /* synthetic */ Object f2257m;

    /* renamed from: n, reason: collision with root package name */
    public final /* synthetic */ SingleProcessDataStore<T> f2258n;

    /* renamed from: o, reason: collision with root package name */
    public int f2259o;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public SingleProcessDataStore$readAndInitOrPropagateFailure$1(SingleProcessDataStore<T> singleProcessDataStore, c<? super SingleProcessDataStore$readAndInitOrPropagateFailure$1> cVar) {
        super(cVar);
        this.f2258n = singleProcessDataStore;
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Object invokeSuspend(Object obj) {
        this.f2257m = obj;
        this.f2259o |= Integer.MIN_VALUE;
        return this.f2258n.d(this);
    }
}
