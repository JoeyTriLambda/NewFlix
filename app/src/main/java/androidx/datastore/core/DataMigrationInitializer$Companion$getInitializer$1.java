package androidx.datastore.core;

import androidx.datastore.core.DataMigrationInitializer;
import i1.g;
import java.util.List;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import lf.f;
import lf.h;
import qf.c;
import rf.a;
import sf.d;
import yf.p;

/* JADX INFO: Add missing generic type declarations: [T] */
/* compiled from: DataMigrationInitializer.kt */
@d(c = "androidx.datastore.core.DataMigrationInitializer$Companion$getInitializer$1", f = "DataMigrationInitializer.kt", l = {33}, m = "invokeSuspend")
/* loaded from: classes.dex */
public final class DataMigrationInitializer$Companion$getInitializer$1<T> extends SuspendLambda implements p<g<T>, c<? super h>, Object> {

    /* renamed from: b, reason: collision with root package name */
    public int f2163b;

    /* renamed from: m, reason: collision with root package name */
    public /* synthetic */ Object f2164m;

    /* renamed from: n, reason: collision with root package name */
    public final /* synthetic */ List<i1.c<T>> f2165n;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    /* JADX WARN: Multi-variable type inference failed */
    public DataMigrationInitializer$Companion$getInitializer$1(List<? extends i1.c<T>> list, c<? super DataMigrationInitializer$Companion$getInitializer$1> cVar) {
        super(2, cVar);
        this.f2165n = list;
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final c<h> create(Object obj, c<?> cVar) {
        DataMigrationInitializer$Companion$getInitializer$1 dataMigrationInitializer$Companion$getInitializer$1 = new DataMigrationInitializer$Companion$getInitializer$1(this.f2165n, cVar);
        dataMigrationInitializer$Companion$getInitializer$1.f2164m = obj;
        return dataMigrationInitializer$Companion$getInitializer$1;
    }

    @Override // yf.p
    public final Object invoke(g<T> gVar, c<? super h> cVar) {
        return ((DataMigrationInitializer$Companion$getInitializer$1) create(gVar, cVar)).invokeSuspend(h.f16056a);
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Object invokeSuspend(Object obj) throws Throwable {
        Object coroutine_suspended = a.getCOROUTINE_SUSPENDED();
        int i10 = this.f2163b;
        if (i10 == 0) {
            f.throwOnFailure(obj);
            g gVar = (g) this.f2164m;
            DataMigrationInitializer.Companion companion = DataMigrationInitializer.f2162a;
            this.f2163b = 1;
            if (DataMigrationInitializer.Companion.access$runMigrations(companion, this.f2165n, gVar, this) == coroutine_suspended) {
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
}
