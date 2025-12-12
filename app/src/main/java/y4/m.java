package y4;

import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import com.google.android.datatransport.runtime.firebase.transport.LogEventDropped;
import y4.p;

/* compiled from: R8$$SyntheticClass */
/* loaded from: classes.dex */
public final /* synthetic */ class m implements p.a {

    /* renamed from: b, reason: collision with root package name */
    public final /* synthetic */ int f21880b;

    /* renamed from: m, reason: collision with root package name */
    public final /* synthetic */ p f21881m;

    public /* synthetic */ m(p pVar, int i10) {
        this.f21880b = i10;
        this.f21881m = pVar;
    }

    @Override // y4.p.a, n4.d
    public final Object apply(Object obj) {
        int i10 = this.f21880b;
        p pVar = this.f21881m;
        switch (i10) {
            case 0:
                SQLiteDatabase sQLiteDatabase = (SQLiteDatabase) obj;
                pVar.getClass();
                sQLiteDatabase.compileStatement("DELETE FROM log_event_dropped").execute();
                sQLiteDatabase.compileStatement("UPDATE global_log_event_state SET last_metrics_upload_ms=" + pVar.f21890m.getTime()).execute();
                break;
            case 1:
                Cursor cursor = (Cursor) obj;
                pVar.getClass();
                while (cursor.moveToNext()) {
                    pVar.recordLogEventDropped(cursor.getInt(0), LogEventDropped.Reason.MESSAGE_TOO_OLD, cursor.getString(1));
                }
                break;
            default:
                Cursor cursor2 = (Cursor) obj;
                pVar.getClass();
                while (cursor2.moveToNext()) {
                    pVar.recordLogEventDropped(cursor2.getInt(0), LogEventDropped.Reason.MAX_RETRIES_REACHED, cursor2.getString(1));
                }
                break;
        }
        return null;
    }
}
