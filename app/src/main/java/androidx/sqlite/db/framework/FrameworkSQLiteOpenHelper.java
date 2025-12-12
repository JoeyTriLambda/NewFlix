package androidx.sqlite.db.framework;

import android.content.Context;
import android.database.DatabaseErrorHandler;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteException;
import android.database.sqlite.SQLiteOpenHelper;
import android.os.Build;
import android.util.Log;
import androidx.sqlite.db.framework.FrameworkSQLiteOpenHelper;
import java.io.File;
import java.io.IOException;
import java.util.UUID;
import k2.b;
import k2.d;
import k2.f;
import lf.e;
import zf.i;

/* compiled from: FrameworkSQLiteOpenHelper.kt */
/* loaded from: classes.dex */
public final class FrameworkSQLiteOpenHelper implements f {

    /* renamed from: b, reason: collision with root package name */
    public final Context f4325b;

    /* renamed from: m, reason: collision with root package name */
    public final String f4326m;

    /* renamed from: n, reason: collision with root package name */
    public final f.a f4327n;

    /* renamed from: o, reason: collision with root package name */
    public final boolean f4328o;

    /* renamed from: p, reason: collision with root package name */
    public final boolean f4329p;

    /* renamed from: q, reason: collision with root package name */
    public final e<OpenHelper> f4330q;

    /* renamed from: r, reason: collision with root package name */
    public boolean f4331r;

    /* compiled from: FrameworkSQLiteOpenHelper.kt */
    public static final class OpenHelper extends SQLiteOpenHelper {

        /* renamed from: s, reason: collision with root package name */
        public static final a f4332s = new a(null);

        /* renamed from: b, reason: collision with root package name */
        public final Context f4333b;

        /* renamed from: m, reason: collision with root package name */
        public final b f4334m;

        /* renamed from: n, reason: collision with root package name */
        public final f.a f4335n;

        /* renamed from: o, reason: collision with root package name */
        public final boolean f4336o;

        /* renamed from: p, reason: collision with root package name */
        public boolean f4337p;

        /* renamed from: q, reason: collision with root package name */
        public final m2.a f4338q;

        /* renamed from: r, reason: collision with root package name */
        public boolean f4339r;

        /* compiled from: FrameworkSQLiteOpenHelper.kt */
        public static final class CallbackException extends RuntimeException {

            /* renamed from: b, reason: collision with root package name */
            public final CallbackName f4340b;

            /* renamed from: m, reason: collision with root package name */
            public final Throwable f4341m;

            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            public CallbackException(CallbackName callbackName, Throwable th2) {
                super(th2);
                i.checkNotNullParameter(callbackName, "callbackName");
                i.checkNotNullParameter(th2, "cause");
                this.f4340b = callbackName;
                this.f4341m = th2;
            }

            public final CallbackName getCallbackName() {
                return this.f4340b;
            }

            @Override // java.lang.Throwable
            public Throwable getCause() {
                return this.f4341m;
            }
        }

        /* compiled from: FrameworkSQLiteOpenHelper.kt */
        public enum CallbackName {
            ON_CONFIGURE,
            ON_CREATE,
            ON_UPGRADE,
            ON_DOWNGRADE,
            ON_OPEN
        }

        /* compiled from: FrameworkSQLiteOpenHelper.kt */
        public static final class a {
            public a(zf.f fVar) {
            }

            public final FrameworkSQLiteDatabase getWrappedDb(b bVar, SQLiteDatabase sQLiteDatabase) {
                i.checkNotNullParameter(bVar, "refHolder");
                i.checkNotNullParameter(sQLiteDatabase, "sqLiteDatabase");
                FrameworkSQLiteDatabase db2 = bVar.getDb();
                if (db2 != null && db2.isDelegate(sQLiteDatabase)) {
                    return db2;
                }
                FrameworkSQLiteDatabase frameworkSQLiteDatabase = new FrameworkSQLiteDatabase(sQLiteDatabase);
                bVar.setDb(frameworkSQLiteDatabase);
                return frameworkSQLiteDatabase;
            }
        }

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public OpenHelper(Context context, String str, final b bVar, final f.a aVar, boolean z10) {
            super(context, str, null, aVar.f14723a, new DatabaseErrorHandler() { // from class: l2.b
                @Override // android.database.DatabaseErrorHandler
                public final void onCorruption(SQLiteDatabase sQLiteDatabase) {
                    f.a aVar2 = aVar;
                    i.checkNotNullParameter(aVar2, "$callback");
                    FrameworkSQLiteOpenHelper.b bVar2 = bVar;
                    i.checkNotNullParameter(bVar2, "$dbRef");
                    i.checkNotNullExpressionValue(sQLiteDatabase, "dbObj");
                    aVar2.onCorruption(FrameworkSQLiteOpenHelper.OpenHelper.f4332s.getWrappedDb(bVar2, sQLiteDatabase));
                }
            });
            i.checkNotNullParameter(context, "context");
            i.checkNotNullParameter(bVar, "dbRef");
            i.checkNotNullParameter(aVar, "callback");
            this.f4333b = context;
            this.f4334m = bVar;
            this.f4335n = aVar;
            this.f4336o = z10;
            if (str == null) {
                str = UUID.randomUUID().toString();
                i.checkNotNullExpressionValue(str, "randomUUID().toString()");
            }
            File cacheDir = context.getCacheDir();
            i.checkNotNullExpressionValue(cacheDir, "context.cacheDir");
            this.f4338q = new m2.a(str, cacheDir, false);
        }

        public final SQLiteDatabase a(boolean z10) {
            if (z10) {
                SQLiteDatabase writableDatabase = getWritableDatabase();
                i.checkNotNullExpressionValue(writableDatabase, "{\n                super.…eDatabase()\n            }");
                return writableDatabase;
            }
            SQLiteDatabase readableDatabase = getReadableDatabase();
            i.checkNotNullExpressionValue(readableDatabase, "{\n                super.…eDatabase()\n            }");
            return readableDatabase;
        }

        public final SQLiteDatabase b(boolean z10) throws Throwable {
            File parentFile;
            String databaseName = getDatabaseName();
            Context context = this.f4333b;
            if (databaseName != null && (parentFile = context.getDatabasePath(databaseName).getParentFile()) != null) {
                parentFile.mkdirs();
                if (!parentFile.isDirectory()) {
                    Log.w("SupportSQLite", "Invalid database parent file, not a directory: " + parentFile);
                }
            }
            try {
                return a(z10);
            } catch (Throwable unused) {
                super.close();
                try {
                    Thread.sleep(500L);
                } catch (InterruptedException unused2) {
                }
                try {
                    return a(z10);
                } catch (Throwable th2) {
                    super.close();
                    if (th2 instanceof CallbackException) {
                        CallbackException callbackException = th2;
                        Throwable cause = callbackException.getCause();
                        int iOrdinal = callbackException.getCallbackName().ordinal();
                        if (iOrdinal == 0 || iOrdinal == 1 || iOrdinal == 2 || iOrdinal == 3 || !(cause instanceof SQLiteException)) {
                            throw cause;
                        }
                    } else if (!(th2 instanceof SQLiteException) || databaseName == null || !this.f4336o) {
                        throw th2;
                    }
                    context.deleteDatabase(databaseName);
                    try {
                        return a(z10);
                    } catch (CallbackException e10) {
                        throw e10.getCause();
                    }
                }
            }
        }

        @Override // android.database.sqlite.SQLiteOpenHelper, java.lang.AutoCloseable
        public void close() throws IOException {
            m2.a aVar = this.f4338q;
            try {
                m2.a.lock$default(aVar, false, 1, null);
                super.close();
                this.f4334m.setDb(null);
                this.f4339r = false;
            } finally {
                aVar.unlock();
            }
        }

        public final k2.e getSupportDatabase(boolean z10) throws IOException {
            m2.a aVar = this.f4338q;
            try {
                aVar.lock((this.f4339r || getDatabaseName() == null) ? false : true);
                this.f4337p = false;
                SQLiteDatabase sQLiteDatabaseB = b(z10);
                if (!this.f4337p) {
                    return getWrappedDb(sQLiteDatabaseB);
                }
                close();
                return getSupportDatabase(z10);
            } finally {
                aVar.unlock();
            }
        }

        public final FrameworkSQLiteDatabase getWrappedDb(SQLiteDatabase sQLiteDatabase) {
            i.checkNotNullParameter(sQLiteDatabase, "sqLiteDatabase");
            return f4332s.getWrappedDb(this.f4334m, sQLiteDatabase);
        }

        @Override // android.database.sqlite.SQLiteOpenHelper
        public void onConfigure(SQLiteDatabase sQLiteDatabase) {
            i.checkNotNullParameter(sQLiteDatabase, "db");
            try {
                this.f4335n.onConfigure(getWrappedDb(sQLiteDatabase));
            } catch (Throwable th2) {
                throw new CallbackException(CallbackName.ON_CONFIGURE, th2);
            }
        }

        @Override // android.database.sqlite.SQLiteOpenHelper
        public void onCreate(SQLiteDatabase sQLiteDatabase) {
            i.checkNotNullParameter(sQLiteDatabase, "sqLiteDatabase");
            try {
                this.f4335n.onCreate(getWrappedDb(sQLiteDatabase));
            } catch (Throwable th2) {
                throw new CallbackException(CallbackName.ON_CREATE, th2);
            }
        }

        @Override // android.database.sqlite.SQLiteOpenHelper
        public void onDowngrade(SQLiteDatabase sQLiteDatabase, int i10, int i11) {
            i.checkNotNullParameter(sQLiteDatabase, "db");
            this.f4337p = true;
            try {
                this.f4335n.onDowngrade(getWrappedDb(sQLiteDatabase), i10, i11);
            } catch (Throwable th2) {
                throw new CallbackException(CallbackName.ON_DOWNGRADE, th2);
            }
        }

        @Override // android.database.sqlite.SQLiteOpenHelper
        public void onOpen(SQLiteDatabase sQLiteDatabase) {
            i.checkNotNullParameter(sQLiteDatabase, "db");
            if (!this.f4337p) {
                try {
                    this.f4335n.onOpen(getWrappedDb(sQLiteDatabase));
                } catch (Throwable th2) {
                    throw new CallbackException(CallbackName.ON_OPEN, th2);
                }
            }
            this.f4339r = true;
        }

        @Override // android.database.sqlite.SQLiteOpenHelper
        public void onUpgrade(SQLiteDatabase sQLiteDatabase, int i10, int i11) {
            i.checkNotNullParameter(sQLiteDatabase, "sqLiteDatabase");
            this.f4337p = true;
            try {
                this.f4335n.onUpgrade(getWrappedDb(sQLiteDatabase), i10, i11);
            } catch (Throwable th2) {
                throw new CallbackException(CallbackName.ON_UPGRADE, th2);
            }
        }
    }

    /* compiled from: FrameworkSQLiteOpenHelper.kt */
    public static final class a {
        public a(zf.f fVar) {
        }
    }

    /* compiled from: FrameworkSQLiteOpenHelper.kt */
    public static final class b {

        /* renamed from: a, reason: collision with root package name */
        public FrameworkSQLiteDatabase f4348a;

        public b(FrameworkSQLiteDatabase frameworkSQLiteDatabase) {
            this.f4348a = frameworkSQLiteDatabase;
        }

        public final FrameworkSQLiteDatabase getDb() {
            return this.f4348a;
        }

        public final void setDb(FrameworkSQLiteDatabase frameworkSQLiteDatabase) {
            this.f4348a = frameworkSQLiteDatabase;
        }
    }

    static {
        new a(null);
    }

    public FrameworkSQLiteOpenHelper(Context context, String str, f.a aVar, boolean z10, boolean z11) {
        i.checkNotNullParameter(context, "context");
        i.checkNotNullParameter(aVar, "callback");
        this.f4325b = context;
        this.f4326m = str;
        this.f4327n = aVar;
        this.f4328o = z10;
        this.f4329p = z11;
        this.f4330q = kotlin.a.lazy(new yf.a<OpenHelper>() { // from class: androidx.sqlite.db.framework.FrameworkSQLiteOpenHelper$lazyDelegate$1
            {
                super(0);
            }

            /* JADX WARN: Can't rename method to resolve collision */
            @Override // yf.a
            public final FrameworkSQLiteOpenHelper.OpenHelper invoke() {
                FrameworkSQLiteOpenHelper.OpenHelper openHelper;
                int i10 = Build.VERSION.SDK_INT;
                FrameworkSQLiteOpenHelper frameworkSQLiteOpenHelper = this.f4349b;
                if (i10 < 23 || frameworkSQLiteOpenHelper.f4326m == null || !frameworkSQLiteOpenHelper.f4328o) {
                    openHelper = new FrameworkSQLiteOpenHelper.OpenHelper(frameworkSQLiteOpenHelper.f4325b, frameworkSQLiteOpenHelper.f4326m, new FrameworkSQLiteOpenHelper.b(null), frameworkSQLiteOpenHelper.f4327n, frameworkSQLiteOpenHelper.f4329p);
                } else {
                    openHelper = new FrameworkSQLiteOpenHelper.OpenHelper(frameworkSQLiteOpenHelper.f4325b, new File(d.getNoBackupFilesDir(frameworkSQLiteOpenHelper.f4325b), frameworkSQLiteOpenHelper.f4326m).getAbsolutePath(), new FrameworkSQLiteOpenHelper.b(null), frameworkSQLiteOpenHelper.f4327n, frameworkSQLiteOpenHelper.f4329p);
                }
                b.setWriteAheadLoggingEnabled(openHelper, frameworkSQLiteOpenHelper.f4331r);
                return openHelper;
            }
        });
    }

    @Override // k2.f, java.io.Closeable, java.lang.AutoCloseable
    public void close() throws IOException {
        e<OpenHelper> eVar = this.f4330q;
        if (eVar.isInitialized()) {
            eVar.getValue().close();
        }
    }

    @Override // k2.f
    public String getDatabaseName() {
        return this.f4326m;
    }

    @Override // k2.f
    public k2.e getWritableDatabase() {
        return this.f4330q.getValue().getSupportDatabase(true);
    }

    @Override // k2.f
    public void setWriteAheadLoggingEnabled(boolean z10) {
        e<OpenHelper> eVar = this.f4330q;
        if (eVar.isInitialized()) {
            k2.b.setWriteAheadLoggingEnabled(eVar.getValue(), z10);
        }
        this.f4331r = z10;
    }
}
