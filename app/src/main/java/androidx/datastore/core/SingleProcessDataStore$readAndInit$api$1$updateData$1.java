package androidx.datastore.core;

import cz.msebera.android.httpclient.HttpStatus;
import kotlin.coroutines.jvm.internal.ContinuationImpl;
import kotlin.jvm.internal.Ref$ObjectRef;
import qf.c;
import sf.d;

/* compiled from: SingleProcessDataStore.kt */
@d(c = "androidx.datastore.core.SingleProcessDataStore$readAndInit$api$1", f = "SingleProcessDataStore.kt", l = {HttpStatus.SC_SERVICE_UNAVAILABLE, 337, 339}, m = "updateData")
/* loaded from: classes.dex */
public final class SingleProcessDataStore$readAndInit$api$1$updateData$1 extends ContinuationImpl {

    /* renamed from: b, reason: collision with root package name */
    public Object f2244b;

    /* renamed from: m, reason: collision with root package name */
    public Object f2245m;

    /* renamed from: n, reason: collision with root package name */
    public Object f2246n;

    /* renamed from: o, reason: collision with root package name */
    public Ref$ObjectRef f2247o;

    /* renamed from: p, reason: collision with root package name */
    public SingleProcessDataStore f2248p;

    /* renamed from: q, reason: collision with root package name */
    public /* synthetic */ Object f2249q;

    /* renamed from: r, reason: collision with root package name */
    public final /* synthetic */ SingleProcessDataStore$readAndInit$api$1 f2250r;

    /* renamed from: s, reason: collision with root package name */
    public int f2251s;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public SingleProcessDataStore$readAndInit$api$1$updateData$1(SingleProcessDataStore$readAndInit$api$1 singleProcessDataStore$readAndInit$api$1, c<? super SingleProcessDataStore$readAndInit$api$1$updateData$1> cVar) {
        super(cVar);
        this.f2250r = singleProcessDataStore$readAndInit$api$1;
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Object invokeSuspend(Object obj) {
        this.f2249q = obj;
        this.f2251s |= Integer.MIN_VALUE;
        return this.f2250r.updateData(null, this);
    }
}
