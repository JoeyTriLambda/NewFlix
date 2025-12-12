package x4;

import android.content.ContentValues;
import android.database.SQLException;
import android.database.sqlite.SQLiteDatabase;
import com.google.android.datatransport.runtime.firebase.transport.LogEventDropped;
import q4.o;
import y4.p;
import z4.a;

/* compiled from: R8$$SyntheticClass */
/* loaded from: classes.dex */
public final /* synthetic */ class g implements a.InterfaceC0331a, p.a {

    /* renamed from: b, reason: collision with root package name */
    public final /* synthetic */ long f21528b;

    /* renamed from: m, reason: collision with root package name */
    public final /* synthetic */ Object f21529m;

    /* renamed from: n, reason: collision with root package name */
    public final /* synthetic */ Object f21530n;

    public /* synthetic */ g(Object obj, long j10, Object obj2) {
        this.f21529m = obj;
        this.f21530n = obj2;
        this.f21528b = j10;
    }

    @Override // y4.p.a, n4.d
    public final Object apply(Object obj) throws SQLException {
        String str = (String) this.f21529m;
        LogEventDropped.Reason reason = (LogEventDropped.Reason) this.f21530n;
        SQLiteDatabase sQLiteDatabase = (SQLiteDatabase) obj;
        n4.b bVar = p.f21888q;
        boolean zBooleanValue = ((Boolean) p.g(sQLiteDatabase.rawQuery("SELECT 1 FROM log_event_dropped WHERE log_source = ? AND reason = ?", new String[]{str, Integer.toString(reason.getNumber())}), new pd.a(16))).booleanValue();
        long j10 = this.f21528b;
        if (zBooleanValue) {
            sQLiteDatabase.execSQL("UPDATE log_event_dropped SET events_dropped_count = events_dropped_count + " + j10 + " WHERE log_source = ? AND reason = ?", new String[]{str, Integer.toString(reason.getNumber())});
        } else {
            ContentValues contentValues = new ContentValues();
            contentValues.put("log_source", str);
            contentValues.put("reason", Integer.valueOf(reason.getNumber()));
            contentValues.put("events_dropped_count", Long.valueOf(j10));
            sQLiteDatabase.insert("log_event_dropped", null, contentValues);
        }
        return null;
    }

    @Override // z4.a.InterfaceC0331a
    public final Object execute() {
        h hVar = (h) this.f21529m;
        hVar.f21533c.recordNextCallTime((o) this.f21530n, hVar.f21537g.getTime() + this.f21528b);
        return null;
    }
}
