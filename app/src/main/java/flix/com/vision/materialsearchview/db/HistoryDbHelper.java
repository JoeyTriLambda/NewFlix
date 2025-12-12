package flix.com.vision.materialsearchview.db;

import android.content.Context;
import android.database.SQLException;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

/* loaded from: classes2.dex */
public class HistoryDbHelper extends SQLiteOpenHelper {
    public HistoryDbHelper(Context context) {
        super(context, "SearchHistory.db", (SQLiteDatabase.CursorFactory) null, 4);
    }

    @Override // android.database.sqlite.SQLiteOpenHelper
    public void onCreate(SQLiteDatabase sQLiteDatabase) throws SQLException {
        sQLiteDatabase.execSQL("CREATE TABLE SEARCH_HISTORY (_id INTEGER PRIMARY KEY,query TEXT NOT NULL,insert_date INTEGER DEFAULT 0,is_history INTEGER NOT NULL DEFAULT 0,UNIQUE (query) ON CONFLICT REPLACE);");
    }

    @Override // android.database.sqlite.SQLiteOpenHelper
    public void onDowngrade(SQLiteDatabase sQLiteDatabase, int i10, int i11) throws SQLException {
        sQLiteDatabase.execSQL("DROP TABLE IF EXISTS SEARCH_HISTORY");
        onCreate(sQLiteDatabase);
    }

    @Override // android.database.sqlite.SQLiteOpenHelper
    public void onUpgrade(SQLiteDatabase sQLiteDatabase, int i10, int i11) throws SQLException {
        sQLiteDatabase.execSQL("DROP TABLE IF EXISTS SEARCH_HISTORY");
        onCreate(sQLiteDatabase);
    }
}
