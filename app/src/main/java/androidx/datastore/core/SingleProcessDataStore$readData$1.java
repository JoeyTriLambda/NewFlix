package androidx.datastore.core;

import java.io.FileInputStream;
import kotlin.coroutines.jvm.internal.ContinuationImpl;
import qf.c;
import sf.d;

/* compiled from: SingleProcessDataStore.kt */
@d(c = "androidx.datastore.core.SingleProcessDataStore", f = "SingleProcessDataStore.kt", l = {381}, m = "readData")
/* loaded from: classes.dex */
public final class SingleProcessDataStore$readData$1 extends ContinuationImpl {

    /* renamed from: b, reason: collision with root package name */
    public SingleProcessDataStore f2260b;

    /* renamed from: m, reason: collision with root package name */
    public FileInputStream f2261m;

    /* renamed from: n, reason: collision with root package name */
    public /* synthetic */ Object f2262n;

    /* renamed from: o, reason: collision with root package name */
    public final /* synthetic */ SingleProcessDataStore<T> f2263o;

    /* renamed from: p, reason: collision with root package name */
    public int f2264p;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public SingleProcessDataStore$readData$1(SingleProcessDataStore<T> singleProcessDataStore, c<? super SingleProcessDataStore$readData$1> cVar) {
        super(cVar);
        this.f2263o = singleProcessDataStore;
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Object invokeSuspend(Object obj) {
        this.f2262n = obj;
        this.f2264p |= Integer.MIN_VALUE;
        return this.f2263o.e(this);
    }
}
