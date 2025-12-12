package l2;

import android.database.Cursor;
import android.database.sqlite.SQLiteCursor;
import android.database.sqlite.SQLiteCursorDriver;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteQuery;
import k2.h;
import yf.r;
import zf.i;

/* compiled from: R8$$SyntheticClass */
/* loaded from: classes.dex */
public final /* synthetic */ class a implements SQLiteDatabase.CursorFactory {

    /* renamed from: a, reason: collision with root package name */
    public final /* synthetic */ int f15722a;

    /* renamed from: b, reason: collision with root package name */
    public final /* synthetic */ Object f15723b;

    public /* synthetic */ a(Object obj, int i10) {
        this.f15722a = i10;
        this.f15723b = obj;
    }

    @Override // android.database.sqlite.SQLiteDatabase.CursorFactory
    public final Cursor newCursor(SQLiteDatabase sQLiteDatabase, SQLiteCursorDriver sQLiteCursorDriver, String str, SQLiteQuery sQLiteQuery) {
        int i10 = this.f15722a;
        Object obj = this.f15723b;
        switch (i10) {
            case 0:
                h hVar = (h) obj;
                i.checkNotNullParameter(hVar, "$query");
                i.checkNotNull(sQLiteQuery);
                hVar.bindTo(new d(sQLiteQuery));
                return new SQLiteCursor(sQLiteCursorDriver, str, sQLiteQuery);
            default:
                r rVar = (r) obj;
                i.checkNotNullParameter(rVar, "$tmp0");
                return (Cursor) rVar.invoke(sQLiteDatabase, sQLiteCursorDriver, str, sQLiteQuery);
        }
    }
}
