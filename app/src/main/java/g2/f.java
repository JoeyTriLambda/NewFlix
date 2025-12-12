package g2;

import androidx.room.RoomDatabase;
import androidx.room.SharedSQLiteStatement;

/* compiled from: EntityInsertionAdapter.kt */
/* loaded from: classes.dex */
public abstract class f<T> extends SharedSQLiteStatement {
    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public f(RoomDatabase roomDatabase) {
        super(roomDatabase);
        zf.i.checkNotNullParameter(roomDatabase, "database");
    }

    public abstract void bind(k2.i iVar, T t10);

    public final void insert(T t10) {
        k2.i iVarAcquire = acquire();
        try {
            bind(iVarAcquire, t10);
            iVarAcquire.executeInsert();
        } finally {
            release(iVarAcquire);
        }
    }
}
