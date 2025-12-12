package androidx.datastore.core;

import java.io.File;
import java.io.FileOutputStream;
import kotlin.coroutines.jvm.internal.ContinuationImpl;
import qf.c;
import sf.d;

/* compiled from: SingleProcessDataStore.kt */
@d(c = "androidx.datastore.core.SingleProcessDataStore", f = "SingleProcessDataStore.kt", l = {426}, m = "writeData$datastore_core")
/* loaded from: classes.dex */
public final class SingleProcessDataStore$writeData$1 extends ContinuationImpl {

    /* renamed from: b, reason: collision with root package name */
    public SingleProcessDataStore f2279b;

    /* renamed from: m, reason: collision with root package name */
    public File f2280m;

    /* renamed from: n, reason: collision with root package name */
    public FileOutputStream f2281n;

    /* renamed from: o, reason: collision with root package name */
    public FileOutputStream f2282o;

    /* renamed from: p, reason: collision with root package name */
    public /* synthetic */ Object f2283p;

    /* renamed from: q, reason: collision with root package name */
    public final /* synthetic */ SingleProcessDataStore<T> f2284q;

    /* renamed from: r, reason: collision with root package name */
    public int f2285r;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public SingleProcessDataStore$writeData$1(SingleProcessDataStore<T> singleProcessDataStore, c<? super SingleProcessDataStore$writeData$1> cVar) {
        super(cVar);
        this.f2284q = singleProcessDataStore;
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Object invokeSuspend(Object obj) {
        this.f2283p = obj;
        this.f2285r |= Integer.MIN_VALUE;
        return this.f2284q.writeData$datastore_core(null, this);
    }
}
