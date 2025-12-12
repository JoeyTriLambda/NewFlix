package k2;

import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.os.CancellationSignal;
import java.io.File;

/* compiled from: SupportSQLiteCompat.kt */
/* loaded from: classes.dex */
public final class b {
    public static final boolean deleteDatabase(File file) {
        zf.i.checkNotNullParameter(file, "file");
        return SQLiteDatabase.deleteDatabase(file);
    }

    public static final boolean isWriteAheadLoggingEnabled(SQLiteDatabase sQLiteDatabase) {
        zf.i.checkNotNullParameter(sQLiteDatabase, "sQLiteDatabase");
        return sQLiteDatabase.isWriteAheadLoggingEnabled();
    }

    public static final Cursor rawQueryWithFactory(SQLiteDatabase sQLiteDatabase, String str, String[] strArr, String str2, CancellationSignal cancellationSignal, SQLiteDatabase.CursorFactory cursorFactory) {
        zf.i.checkNotNullParameter(sQLiteDatabase, "sQLiteDatabase");
        zf.i.checkNotNullParameter(str, "sql");
        zf.i.checkNotNullParameter(strArr, "selectionArgs");
        zf.i.checkNotNullParameter(cancellationSignal, "cancellationSignal");
        zf.i.checkNotNullParameter(cursorFactory, "cursorFactory");
        Cursor cursorRawQueryWithFactory = sQLiteDatabase.rawQueryWithFactory(cursorFactory, str, strArr, str2, cancellationSignal);
        zf.i.checkNotNullExpressionValue(cursorRawQueryWithFactory, "sQLiteDatabase.rawQueryW…ationSignal\n            )");
        return cursorRawQueryWithFactory;
    }

    public static final void setWriteAheadLoggingEnabled(SQLiteOpenHelper sQLiteOpenHelper, boolean z10) {
        zf.i.checkNotNullParameter(sQLiteOpenHelper, "sQLiteOpenHelper");
        sQLiteOpenHelper.setWriteAheadLoggingEnabled(z10);
    }
}
