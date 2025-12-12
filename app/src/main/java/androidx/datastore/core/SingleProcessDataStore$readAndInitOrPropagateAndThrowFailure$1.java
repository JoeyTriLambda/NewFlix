package androidx.datastore.core;

import cz.msebera.android.httpclient.HttpStatus;
import kotlin.coroutines.jvm.internal.ContinuationImpl;
import qf.c;
import sf.d;

/* compiled from: SingleProcessDataStore.kt */
@d(c = "androidx.datastore.core.SingleProcessDataStore", f = "SingleProcessDataStore.kt", l = {HttpStatus.SC_MOVED_TEMPORARILY}, m = "readAndInitOrPropagateAndThrowFailure")
/* loaded from: classes.dex */
public final class SingleProcessDataStore$readAndInitOrPropagateAndThrowFailure$1 extends ContinuationImpl {

    /* renamed from: b, reason: collision with root package name */
    public SingleProcessDataStore f2252b;

    /* renamed from: m, reason: collision with root package name */
    public /* synthetic */ Object f2253m;

    /* renamed from: n, reason: collision with root package name */
    public final /* synthetic */ SingleProcessDataStore<T> f2254n;

    /* renamed from: o, reason: collision with root package name */
    public int f2255o;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public SingleProcessDataStore$readAndInitOrPropagateAndThrowFailure$1(SingleProcessDataStore<T> singleProcessDataStore, c<? super SingleProcessDataStore$readAndInitOrPropagateAndThrowFailure$1> cVar) {
        super(cVar);
        this.f2254n = singleProcessDataStore;
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Object invokeSuspend(Object obj) {
        this.f2253m = obj;
        this.f2255o |= Integer.MIN_VALUE;
        return this.f2254n.c(this);
    }
}
