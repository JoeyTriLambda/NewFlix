package androidx.datastore.core;

import androidx.datastore.core.DataMigrationInitializer;
import java.io.Serializable;
import java.util.Iterator;
import kotlin.coroutines.jvm.internal.ContinuationImpl;
import qf.c;
import sf.d;

/* compiled from: DataMigrationInitializer.kt */
@d(c = "androidx.datastore.core.DataMigrationInitializer$Companion", f = "DataMigrationInitializer.kt", l = {42, 57}, m = "runMigrations")
/* loaded from: classes.dex */
final class DataMigrationInitializer$Companion$runMigrations$1<T> extends ContinuationImpl {

    /* renamed from: b, reason: collision with root package name */
    public Serializable f2166b;

    /* renamed from: m, reason: collision with root package name */
    public Iterator f2167m;

    /* renamed from: n, reason: collision with root package name */
    public /* synthetic */ Object f2168n;

    /* renamed from: o, reason: collision with root package name */
    public final /* synthetic */ DataMigrationInitializer.Companion f2169o;

    /* renamed from: p, reason: collision with root package name */
    public int f2170p;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public DataMigrationInitializer$Companion$runMigrations$1(DataMigrationInitializer.Companion companion, c<? super DataMigrationInitializer$Companion$runMigrations$1> cVar) {
        super(cVar);
        this.f2169o = companion;
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Object invokeSuspend(Object obj) {
        this.f2168n = obj;
        this.f2170p |= Integer.MIN_VALUE;
        return DataMigrationInitializer.Companion.access$runMigrations(this.f2169o, null, null, this);
    }
}
