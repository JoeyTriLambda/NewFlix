package y4;

import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import y4.p;

/* compiled from: R8$$SyntheticClass */
/* loaded from: classes.dex */
public final /* synthetic */ class o implements p.a {

    /* renamed from: b, reason: collision with root package name */
    public final /* synthetic */ int f21886b;

    /* renamed from: m, reason: collision with root package name */
    public final /* synthetic */ long f21887m;

    public /* synthetic */ o(long j10, int i10) {
        this.f21886b = i10;
        this.f21887m = j10;
    }

    @Override // y4.p.a, n4.d
    public final Object apply(Object obj) {
        int i10 = this.f21886b;
        long j10 = this.f21887m;
        switch (i10) {
            case 0:
                return (t4.e) p.g(((SQLiteDatabase) obj).rawQuery("SELECT last_metrics_upload_ms FROM global_log_event_state LIMIT 1", new String[0]), new o(j10, 1));
            default:
                Cursor cursor = (Cursor) obj;
                cursor.moveToNext();
                return t4.e.newBuilder().setStartMs(cursor.getLong(0)).setEndMs(j10).build();
        }
    }
}
