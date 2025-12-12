package x2;

import android.content.ContentValues;
import android.database.SQLException;

/* compiled from: WorkDatabaseMigrations.kt */
/* loaded from: classes.dex */
public final class b implements h2.a {
    @Override // h2.a
    public void onPostMigrate(k2.e eVar) throws SQLException {
        zf.i.checkNotNullParameter(eVar, "db");
        eVar.execSQL("UPDATE workspec SET period_count = 1 WHERE last_enqueue_time <> 0 AND interval_duration <> 0");
        ContentValues contentValues = new ContentValues(1);
        contentValues.put("last_enqueue_time", Long.valueOf(System.currentTimeMillis()));
        eVar.update("WorkSpec", 3, contentValues, "last_enqueue_time = 0 AND interval_duration <> 0 ", new Object[0]);
    }
}
