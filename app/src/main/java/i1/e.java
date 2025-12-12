package i1;

import androidx.datastore.core.DataMigrationInitializer;
import androidx.datastore.core.SingleProcessDataStore;
import java.io.File;
import java.util.List;
import kg.g0;

/* compiled from: DataStoreFactory.kt */
/* loaded from: classes.dex */
public final class e {

    /* renamed from: a, reason: collision with root package name */
    public static final e f13104a = new e();

    public final <T> d<T> create(i<T> iVar, j1.b<T> bVar, List<? extends c<T>> list, g0 g0Var, yf.a<? extends File> aVar) {
        zf.i.checkNotNullParameter(iVar, "serializer");
        zf.i.checkNotNullParameter(list, "migrations");
        zf.i.checkNotNullParameter(g0Var, "scope");
        zf.i.checkNotNullParameter(aVar, "produceFile");
        if (bVar == null) {
            bVar = (j1.b<T>) new j1.a();
        }
        return new SingleProcessDataStore(aVar, iVar, mf.j.listOf(DataMigrationInitializer.f2162a.getInitializer(list)), bVar, g0Var);
    }
}
