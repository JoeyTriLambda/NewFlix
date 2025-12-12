package androidx.datastore.core;

import kg.u;
import kotlin.coroutines.jvm.internal.ContinuationImpl;
import qf.c;
import sf.d;

/* compiled from: SingleProcessDataStore.kt */
@d(c = "androidx.datastore.core.SingleProcessDataStore", f = "SingleProcessDataStore.kt", l = {276, 281, 284}, m = "handleUpdate")
/* loaded from: classes.dex */
final class SingleProcessDataStore$handleUpdate$1 extends ContinuationImpl {

    /* renamed from: b, reason: collision with root package name */
    public Object f2225b;

    /* renamed from: m, reason: collision with root package name */
    public SingleProcessDataStore f2226m;

    /* renamed from: n, reason: collision with root package name */
    public u f2227n;

    /* renamed from: o, reason: collision with root package name */
    public /* synthetic */ Object f2228o;

    /* renamed from: p, reason: collision with root package name */
    public final /* synthetic */ SingleProcessDataStore<Object> f2229p;

    /* renamed from: q, reason: collision with root package name */
    public int f2230q;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public SingleProcessDataStore$handleUpdate$1(SingleProcessDataStore<Object> singleProcessDataStore, c<? super SingleProcessDataStore$handleUpdate$1> cVar) {
        super(cVar);
        this.f2229p = singleProcessDataStore;
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Object invokeSuspend(Object obj) {
        this.f2228o = obj;
        this.f2230q |= Integer.MIN_VALUE;
        return SingleProcessDataStore.access$handleUpdate(this.f2229p, null, this);
    }
}
