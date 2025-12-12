package androidx.sqlite.db.framework;

import android.content.ContentValues;
import android.database.Cursor;
import android.database.SQLException;
import android.database.sqlite.SQLiteCursor;
import android.database.sqlite.SQLiteCursorDriver;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteQuery;
import android.database.sqlite.SQLiteStatement;
import android.os.CancellationSignal;
import android.text.TextUtils;
import android.util.Pair;
import java.io.IOException;
import java.util.List;
import k2.b;
import k2.e;
import k2.h;
import l2.d;
import yf.r;
import zf.f;
import zf.i;

/* compiled from: FrameworkSQLiteDatabase.kt */
/* loaded from: classes.dex */
public final class FrameworkSQLiteDatabase implements e {

    /* renamed from: n, reason: collision with root package name */
    public static final String[] f4320n;

    /* renamed from: o, reason: collision with root package name */
    public static final String[] f4321o;

    /* renamed from: b, reason: collision with root package name */
    public final SQLiteDatabase f4322b;

    /* renamed from: m, reason: collision with root package name */
    public final List<Pair<String, String>> f4323m;

    /* compiled from: FrameworkSQLiteDatabase.kt */
    public static final class a {
        public a(f fVar) {
        }
    }

    static {
        new a(null);
        f4320n = new String[]{"", " OR ROLLBACK ", " OR ABORT ", " OR FAIL ", " OR IGNORE ", " OR REPLACE "};
        f4321o = new String[0];
    }

    public FrameworkSQLiteDatabase(SQLiteDatabase sQLiteDatabase) {
        i.checkNotNullParameter(sQLiteDatabase, "delegate");
        this.f4322b = sQLiteDatabase;
        this.f4323m = sQLiteDatabase.getAttachedDbs();
    }

    @Override // k2.e
    public void beginTransaction() {
        this.f4322b.beginTransaction();
    }

    @Override // k2.e
    public void beginTransactionNonExclusive() {
        this.f4322b.beginTransactionNonExclusive();
    }

    @Override // java.io.Closeable, java.lang.AutoCloseable
    public void close() throws IOException {
        this.f4322b.close();
    }

    @Override // k2.e
    public k2.i compileStatement(String str) throws SQLException {
        i.checkNotNullParameter(str, "sql");
        SQLiteStatement sQLiteStatementCompileStatement = this.f4322b.compileStatement(str);
        i.checkNotNullExpressionValue(sQLiteStatementCompileStatement, "delegate.compileStatement(sql)");
        return new l2.e(sQLiteStatementCompileStatement);
    }

    @Override // k2.e
    public void endTransaction() {
        this.f4322b.endTransaction();
    }

    @Override // k2.e
    public void execSQL(String str) throws SQLException {
        i.checkNotNullParameter(str, "sql");
        this.f4322b.execSQL(str);
    }

    @Override // k2.e
    public List<Pair<String, String>> getAttachedDbs() {
        return this.f4323m;
    }

    @Override // k2.e
    public String getPath() {
        return this.f4322b.getPath();
    }

    @Override // k2.e
    public boolean inTransaction() {
        return this.f4322b.inTransaction();
    }

    public final boolean isDelegate(SQLiteDatabase sQLiteDatabase) {
        i.checkNotNullParameter(sQLiteDatabase, "sqLiteDatabase");
        return i.areEqual(this.f4322b, sQLiteDatabase);
    }

    @Override // k2.e
    public boolean isOpen() {
        return this.f4322b.isOpen();
    }

    @Override // k2.e
    public boolean isWriteAheadLoggingEnabled() {
        return b.isWriteAheadLoggingEnabled(this.f4322b);
    }

    @Override // k2.e
    public Cursor query(String str) {
        i.checkNotNullParameter(str, "query");
        return query(new k2.a(str));
    }

    @Override // k2.e
    public void setTransactionSuccessful() {
        this.f4322b.setTransactionSuccessful();
    }

    @Override // k2.e
    public int update(String str, int i10, ContentValues contentValues, String str2, Object[] objArr) throws SQLException {
        i.checkNotNullParameter(str, "table");
        i.checkNotNullParameter(contentValues, "values");
        int i11 = 0;
        if (!(contentValues.size() != 0)) {
            throw new IllegalArgumentException("Empty values".toString());
        }
        int size = contentValues.size();
        int length = objArr == null ? size : objArr.length + size;
        Object[] objArr2 = new Object[length];
        StringBuilder sb2 = new StringBuilder("UPDATE ");
        sb2.append(f4320n[i10]);
        sb2.append(str);
        sb2.append(" SET ");
        for (String str3 : contentValues.keySet()) {
            sb2.append(i11 > 0 ? "," : "");
            sb2.append(str3);
            objArr2[i11] = contentValues.get(str3);
            sb2.append("=?");
            i11++;
        }
        if (objArr != null) {
            for (int i12 = size; i12 < length; i12++) {
                objArr2[i12] = objArr[i12 - size];
            }
        }
        if (!TextUtils.isEmpty(str2)) {
            sb2.append(" WHERE ");
            sb2.append(str2);
        }
        String string = sb2.toString();
        i.checkNotNullExpressionValue(string, "StringBuilder().apply(builderAction).toString()");
        k2.i iVarCompileStatement = compileStatement(string);
        k2.a.f14720n.bind(iVarCompileStatement, objArr2);
        return iVarCompileStatement.executeUpdateDelete();
    }

    @Override // k2.e
    public void execSQL(String str, Object[] objArr) throws SQLException {
        i.checkNotNullParameter(str, "sql");
        i.checkNotNullParameter(objArr, "bindArgs");
        this.f4322b.execSQL(str, objArr);
    }

    @Override // k2.e
    public Cursor query(final h hVar) {
        i.checkNotNullParameter(hVar, "query");
        Cursor cursorRawQueryWithFactory = this.f4322b.rawQueryWithFactory(new l2.a(new r<SQLiteDatabase, SQLiteCursorDriver, String, SQLiteQuery, SQLiteCursor>() { // from class: androidx.sqlite.db.framework.FrameworkSQLiteDatabase$query$cursorFactory$1
            {
                super(4);
            }

            @Override // yf.r
            public final SQLiteCursor invoke(SQLiteDatabase sQLiteDatabase, SQLiteCursorDriver sQLiteCursorDriver, String str, SQLiteQuery sQLiteQuery) {
                i.checkNotNull(sQLiteQuery);
                hVar.bindTo(new d(sQLiteQuery));
                return new SQLiteCursor(sQLiteCursorDriver, str, sQLiteQuery);
            }
        }, 1), hVar.getSql(), f4321o, null);
        i.checkNotNullExpressionValue(cursorRawQueryWithFactory, "delegate.rawQueryWithFac…EMPTY_STRING_ARRAY, null)");
        return cursorRawQueryWithFactory;
    }

    @Override // k2.e
    public Cursor query(h hVar, CancellationSignal cancellationSignal) {
        i.checkNotNullParameter(hVar, "query");
        SQLiteDatabase sQLiteDatabase = this.f4322b;
        String sql = hVar.getSql();
        String[] strArr = f4321o;
        i.checkNotNull(cancellationSignal);
        return b.rawQueryWithFactory(sQLiteDatabase, sql, strArr, null, cancellationSignal, new l2.a(hVar, 0));
    }
}
