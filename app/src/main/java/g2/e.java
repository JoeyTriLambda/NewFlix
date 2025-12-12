package g2;

import androidx.room.RoomDatabase;
import androidx.room.SharedSQLiteStatement;

/* compiled from: EntityDeletionOrUpdateAdapter.kt */
/* loaded from: classes.dex */
public abstract class e<T> extends SharedSQLiteStatement {
    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public e(RoomDatabase roomDatabase) {
        super(roomDatabase);
        zf.i.checkNotNullParameter(roomDatabase, "database");
    }

    public abstract void bind(k2.i iVar, T t10);

    public final int handle(T t10) {
        k2.i iVarAcquire = acquire();
        try {
            bind(iVarAcquire, t10);
            return iVarAcquire.executeUpdateDelete();
        } finally {
            release(iVarAcquire);
        }
    }
}
