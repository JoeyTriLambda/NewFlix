package i1;

/* compiled from: DataMigration.kt */
/* loaded from: classes.dex */
public interface c<T> {
    Object cleanUp(qf.c<? super lf.h> cVar);

    Object migrate(T t10, qf.c<? super T> cVar);

    Object shouldMigrate(T t10, qf.c<? super Boolean> cVar);
}
