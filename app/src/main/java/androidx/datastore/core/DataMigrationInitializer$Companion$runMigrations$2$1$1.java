package androidx.datastore.core;

import kotlin.coroutines.jvm.internal.SuspendLambda;
import lf.f;
import lf.h;
import qf.c;
import rf.a;
import sf.d;
import yf.l;

/* compiled from: DataMigrationInitializer.kt */
@d(c = "androidx.datastore.core.DataMigrationInitializer$Companion$runMigrations$2$1$1", f = "DataMigrationInitializer.kt", l = {45}, m = "invokeSuspend")
/* loaded from: classes.dex */
public final class DataMigrationInitializer$Companion$runMigrations$2$1$1 extends SuspendLambda implements l<c<? super h>, Object> {

    /* renamed from: b, reason: collision with root package name */
    public int f2178b;

    /* renamed from: m, reason: collision with root package name */
    public final /* synthetic */ i1.c<Object> f2179m;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public DataMigrationInitializer$Companion$runMigrations$2$1$1(i1.c<Object> cVar, c<? super DataMigrationInitializer$Companion$runMigrations$2$1$1> cVar2) {
        super(1, cVar2);
        this.f2179m = cVar;
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final c<h> create(c<?> cVar) {
        return new DataMigrationInitializer$Companion$runMigrations$2$1$1(this.f2179m, cVar);
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Object invokeSuspend(Object obj) throws Throwable {
        Object coroutine_suspended = a.getCOROUTINE_SUSPENDED();
        int i10 = this.f2178b;
        if (i10 == 0) {
            f.throwOnFailure(obj);
            this.f2178b = 1;
            if (this.f2179m.cleanUp(this) == coroutine_suspended) {
                return coroutine_suspended;
            }
        } else {
            if (i10 != 1) {
                throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
            }
            f.throwOnFailure(obj);
        }
        return h.f16056a;
    }

    @Override // yf.l
    public final Object invoke(c<? super h> cVar) {
        return ((DataMigrationInitializer$Companion$runMigrations$2$1$1) create(cVar)).invokeSuspend(h.f16056a);
    }
}
