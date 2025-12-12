package androidx.datastore.core;

import cz.msebera.android.httpclient.HttpStatus;
import kotlin.coroutines.jvm.internal.ContinuationImpl;
import qf.c;
import sf.d;

/* compiled from: SingleProcessDataStore.kt */
@d(c = "androidx.datastore.core.SingleProcessDataStore", f = "SingleProcessDataStore.kt", l = {HttpStatus.SC_PAYMENT_REQUIRED, HttpStatus.SC_GONE}, m = "transformAndWrite")
/* loaded from: classes.dex */
final class SingleProcessDataStore$transformAndWrite$1 extends ContinuationImpl {

    /* renamed from: b, reason: collision with root package name */
    public SingleProcessDataStore f2270b;

    /* renamed from: m, reason: collision with root package name */
    public Object f2271m;

    /* renamed from: n, reason: collision with root package name */
    public Object f2272n;

    /* renamed from: o, reason: collision with root package name */
    public /* synthetic */ Object f2273o;

    /* renamed from: p, reason: collision with root package name */
    public final /* synthetic */ SingleProcessDataStore<Object> f2274p;

    /* renamed from: q, reason: collision with root package name */
    public int f2275q;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public SingleProcessDataStore$transformAndWrite$1(SingleProcessDataStore<Object> singleProcessDataStore, c<? super SingleProcessDataStore$transformAndWrite$1> cVar) {
        super(cVar);
        this.f2274p = singleProcessDataStore;
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Object invokeSuspend(Object obj) {
        this.f2273o = obj;
        this.f2275q |= Integer.MIN_VALUE;
        return this.f2274p.g(null, null, this);
    }
}
