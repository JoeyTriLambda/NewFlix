package k2;

import android.content.ContentValues;
import android.database.Cursor;
import android.database.SQLException;
import android.os.CancellationSignal;
import android.util.Pair;
import java.io.Closeable;
import java.util.List;

/* compiled from: SupportSQLiteDatabase.kt */
/* loaded from: classes.dex */
public interface e extends Closeable {
    void beginTransaction();

    void beginTransactionNonExclusive();

    i compileStatement(String str);

    void endTransaction();

    void execSQL(String str) throws SQLException;

    void execSQL(String str, Object[] objArr) throws SQLException;

    List<Pair<String, String>> getAttachedDbs();

    String getPath();

    boolean inTransaction();

    boolean isOpen();

    boolean isWriteAheadLoggingEnabled();

    Cursor query(String str);

    Cursor query(h hVar);

    Cursor query(h hVar, CancellationSignal cancellationSignal);

    void setTransactionSuccessful();

    int update(String str, int i10, ContentValues contentValues, String str2, Object[] objArr);
}
