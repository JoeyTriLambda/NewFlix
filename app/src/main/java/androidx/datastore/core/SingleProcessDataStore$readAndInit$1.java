package androidx.datastore.core;

import cz.msebera.android.httpclient.HttpStatus;
import java.io.Serializable;
import java.util.Iterator;
import kotlin.coroutines.jvm.internal.ContinuationImpl;
import qf.c;
import sf.d;

/* compiled from: SingleProcessDataStore.kt */
@d(c = "androidx.datastore.core.SingleProcessDataStore", f = "SingleProcessDataStore.kt", l = {322, 348, HttpStatus.SC_HTTP_VERSION_NOT_SUPPORTED}, m = "readAndInit")
/* loaded from: classes.dex */
public final class SingleProcessDataStore$readAndInit$1 extends ContinuationImpl {

    /* renamed from: b, reason: collision with root package name */
    public SingleProcessDataStore f2231b;

    /* renamed from: m, reason: collision with root package name */
    public Object f2232m;

    /* renamed from: n, reason: collision with root package name */
    public Serializable f2233n;

    /* renamed from: o, reason: collision with root package name */
    public Object f2234o;

    /* renamed from: p, reason: collision with root package name */
    public SingleProcessDataStore$readAndInit$api$1 f2235p;

    /* renamed from: q, reason: collision with root package name */
    public Iterator f2236q;

    /* renamed from: r, reason: collision with root package name */
    public /* synthetic */ Object f2237r;

    /* renamed from: s, reason: collision with root package name */
    public final /* synthetic */ SingleProcessDataStore<T> f2238s;

    /* renamed from: t, reason: collision with root package name */
    public int f2239t;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public SingleProcessDataStore$readAndInit$1(SingleProcessDataStore<T> singleProcessDataStore, c<? super SingleProcessDataStore$readAndInit$1> cVar) {
        super(cVar);
        this.f2238s = singleProcessDataStore;
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Object invokeSuspend(Object obj) {
        this.f2237r = obj;
        this.f2239t |= Integer.MIN_VALUE;
        return this.f2238s.b(this);
    }
}
