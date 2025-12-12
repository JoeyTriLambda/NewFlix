package y4;

import android.content.ContentValues;
import android.database.sqlite.SQLiteDatabase;
import y4.p;

/* compiled from: R8$$SyntheticClass */
/* loaded from: classes.dex */
public final /* synthetic */ class k implements p.a {

    /* renamed from: b, reason: collision with root package name */
    public final /* synthetic */ int f21874b = 1;

    /* renamed from: m, reason: collision with root package name */
    public final /* synthetic */ long f21875m;

    /* renamed from: n, reason: collision with root package name */
    public final /* synthetic */ Object f21876n;

    public /* synthetic */ k(q4.o oVar, long j10) {
        this.f21875m = j10;
        this.f21876n = oVar;
    }

    @Override // y4.p.a, n4.d
    public final Object apply(Object obj) {
        int i10 = this.f21874b;
        long j10 = this.f21875m;
        Object obj2 = this.f21876n;
        switch (i10) {
            case 0:
                p pVar = (p) obj2;
                SQLiteDatabase sQLiteDatabase = (SQLiteDatabase) obj;
                pVar.getClass();
                String[] strArr = {String.valueOf(j10)};
                p.g(sQLiteDatabase.rawQuery("SELECT COUNT(*), transport_name FROM events WHERE timestamp_ms < ? GROUP BY transport_name", strArr), new m(pVar, 1));
                return Integer.valueOf(sQLiteDatabase.delete("events", "timestamp_ms < ?", strArr));
            default:
                q4.o oVar = (q4.o) obj2;
                SQLiteDatabase sQLiteDatabase2 = (SQLiteDatabase) obj;
                ContentValues contentValues = new ContentValues();
                contentValues.put("next_request_ms", Long.valueOf(j10));
                if (sQLiteDatabase2.update("transport_contexts", contentValues, "backend_name = ? and priority = ?", new String[]{oVar.getBackendName(), String.valueOf(b5.a.toInt(oVar.getPriority()))}) < 1) {
                    contentValues.put("backend_name", oVar.getBackendName());
                    contentValues.put("priority", Integer.valueOf(b5.a.toInt(oVar.getPriority())));
                    sQLiteDatabase2.insert("transport_contexts", null, contentValues);
                }
                return null;
        }
    }

    public /* synthetic */ k(p pVar, long j10) {
        this.f21876n = pVar;
        this.f21875m = j10;
    }
}
