package androidx.datastore.core;

import androidx.datastore.core.SingleProcessDataStore;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import lf.f;
import lf.h;
import qf.c;
import rf.a;
import sf.d;
import yf.p;

/* JADX INFO: Add missing generic type declarations: [T] */
/* compiled from: SingleProcessDataStore.kt */
@d(c = "androidx.datastore.core.SingleProcessDataStore$actor$3", f = "SingleProcessDataStore.kt", l = {239, 242}, m = "invokeSuspend")
/* loaded from: classes.dex */
public final class SingleProcessDataStore$actor$3<T> extends SuspendLambda implements p<SingleProcessDataStore.b<T>, c<? super h>, Object> {

    /* renamed from: b, reason: collision with root package name */
    public int f2210b;

    /* renamed from: m, reason: collision with root package name */
    public /* synthetic */ Object f2211m;

    /* renamed from: n, reason: collision with root package name */
    public final /* synthetic */ SingleProcessDataStore<T> f2212n;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public SingleProcessDataStore$actor$3(SingleProcessDataStore<T> singleProcessDataStore, c<? super SingleProcessDataStore$actor$3> cVar) {
        super(2, cVar);
        this.f2212n = singleProcessDataStore;
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final c<h> create(Object obj, c<?> cVar) {
        SingleProcessDataStore$actor$3 singleProcessDataStore$actor$3 = new SingleProcessDataStore$actor$3(this.f2212n, cVar);
        singleProcessDataStore$actor$3.f2211m = obj;
        return singleProcessDataStore$actor$3;
    }

    @Override // yf.p
    public final Object invoke(SingleProcessDataStore.b<T> bVar, c<? super h> cVar) {
        return ((SingleProcessDataStore$actor$3) create(bVar, cVar)).invokeSuspend(h.f16056a);
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Object invokeSuspend(Object obj) throws Throwable {
        Object coroutine_suspended = a.getCOROUTINE_SUSPENDED();
        int i10 = this.f2210b;
        if (i10 == 0) {
            f.throwOnFailure(obj);
            SingleProcessDataStore.b bVar = (SingleProcessDataStore.b) this.f2211m;
            boolean z10 = bVar instanceof SingleProcessDataStore.b.a;
            SingleProcessDataStore<T> singleProcessDataStore = this.f2212n;
            if (z10) {
                this.f2210b = 1;
                if (SingleProcessDataStore.access$handleRead(singleProcessDataStore, (SingleProcessDataStore.b.a) bVar, this) == coroutine_suspended) {
                    return coroutine_suspended;
                }
            } else if (bVar instanceof SingleProcessDataStore.b.C0021b) {
                this.f2210b = 2;
                if (SingleProcessDataStore.access$handleUpdate(singleProcessDataStore, (SingleProcessDataStore.b.C0021b) bVar, this) == coroutine_suspended) {
                    return coroutine_suspended;
                }
            }
        } else {
            if (i10 != 1 && i10 != 2) {
                throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
            }
            f.throwOnFailure(obj);
        }
        return h.f16056a;
    }
}
