package k2;

import android.content.Context;
import android.database.sqlite.SQLiteException;
import android.util.Log;
import android.util.Pair;
import ig.l;
import java.io.Closeable;
import java.io.File;
import java.io.IOException;
import java.util.Iterator;
import java.util.List;

/* compiled from: SupportSQLiteOpenHelper.kt */
/* loaded from: classes.dex */
public interface f extends Closeable {

    /* compiled from: SupportSQLiteOpenHelper.kt */
    public static abstract class a {

        /* renamed from: a, reason: collision with root package name */
        public final int f14723a;

        /* compiled from: SupportSQLiteOpenHelper.kt */
        /* renamed from: k2.f$a$a, reason: collision with other inner class name */
        public static final class C0175a {
            public C0175a(zf.f fVar) {
            }
        }

        static {
            new C0175a(null);
        }

        public a(int i10) {
            this.f14723a = i10;
        }

        public static void a(String str) {
            if (l.equals(str, ":memory:", true)) {
                return;
            }
            int length = str.length() - 1;
            int i10 = 0;
            boolean z10 = false;
            while (i10 <= length) {
                boolean z11 = zf.i.compare((int) str.charAt(!z10 ? i10 : length), 32) <= 0;
                if (z10) {
                    if (!z11) {
                        break;
                    } else {
                        length--;
                    }
                } else if (z11) {
                    i10++;
                } else {
                    z10 = true;
                }
            }
            if (str.subSequence(i10, length + 1).toString().length() == 0) {
                return;
            }
            Log.w("SupportSQLite", "deleting the database file: ".concat(str));
            try {
                k2.b.deleteDatabase(new File(str));
            } catch (Exception e10) {
                Log.w("SupportSQLite", "delete failed: ", e10);
            }
        }

        public void onConfigure(e eVar) {
            zf.i.checkNotNullParameter(eVar, "db");
        }

        public void onCorruption(e eVar) {
            zf.i.checkNotNullParameter(eVar, "db");
            Log.e("SupportSQLite", "Corruption reported by sqlite on database: " + eVar + ".path");
            if (!eVar.isOpen()) {
                String path = eVar.getPath();
                if (path != null) {
                    a(path);
                    return;
                }
                return;
            }
            List<Pair<String, String>> attachedDbs = null;
            try {
                try {
                    attachedDbs = eVar.getAttachedDbs();
                } finally {
                    if (attachedDbs != null) {
                        Iterator<T> it = attachedDbs.iterator();
                        while (it.hasNext()) {
                            Object obj = ((Pair) it.next()).second;
                            zf.i.checkNotNullExpressionValue(obj, "p.second");
                            a((String) obj);
                        }
                    } else {
                        String path2 = eVar.getPath();
                        if (path2 != null) {
                            a(path2);
                        }
                    }
                }
            } catch (SQLiteException unused) {
            }
            try {
                eVar.close();
            } catch (IOException unused2) {
            }
            if (attachedDbs != null) {
                return;
            }
        }

        public abstract void onCreate(e eVar);

        public abstract void onDowngrade(e eVar, int i10, int i11);

        public void onOpen(e eVar) {
            zf.i.checkNotNullParameter(eVar, "db");
        }

        public abstract void onUpgrade(e eVar, int i10, int i11);
    }

    /* compiled from: SupportSQLiteOpenHelper.kt */
    public static final class b {

        /* renamed from: f, reason: collision with root package name */
        public static final C0176b f14724f = new C0176b(null);

        /* renamed from: a, reason: collision with root package name */
        public final Context f14725a;

        /* renamed from: b, reason: collision with root package name */
        public final String f14726b;

        /* renamed from: c, reason: collision with root package name */
        public final a f14727c;

        /* renamed from: d, reason: collision with root package name */
        public final boolean f14728d;

        /* renamed from: e, reason: collision with root package name */
        public final boolean f14729e;

        /* compiled from: SupportSQLiteOpenHelper.kt */
        public static class a {

            /* renamed from: a, reason: collision with root package name */
            public final Context f14730a;

            /* renamed from: b, reason: collision with root package name */
            public String f14731b;

            /* renamed from: c, reason: collision with root package name */
            public a f14732c;

            /* renamed from: d, reason: collision with root package name */
            public boolean f14733d;

            /* renamed from: e, reason: collision with root package name */
            public boolean f14734e;

            public a(Context context) {
                zf.i.checkNotNullParameter(context, "context");
                this.f14730a = context;
            }

            public a allowDataLossOnRecovery(boolean z10) {
                this.f14734e = z10;
                return this;
            }

            public b build() {
                a aVar = this.f14732c;
                if (aVar == null) {
                    throw new IllegalArgumentException("Must set a callback to create the configuration.".toString());
                }
                boolean z10 = true;
                if (this.f14733d) {
                    String str = this.f14731b;
                    if (str == null || str.length() == 0) {
                        z10 = false;
                    }
                }
                if (z10) {
                    return new b(this.f14730a, this.f14731b, aVar, this.f14733d, this.f14734e);
                }
                throw new IllegalArgumentException("Must set a non-null database name to a configuration that uses the no backup directory.".toString());
            }

            public a callback(a aVar) {
                zf.i.checkNotNullParameter(aVar, "callback");
                this.f14732c = aVar;
                return this;
            }

            public a name(String str) {
                this.f14731b = str;
                return this;
            }

            public a noBackupDirectory(boolean z10) {
                this.f14733d = z10;
                return this;
            }
        }

        /* compiled from: SupportSQLiteOpenHelper.kt */
        /* renamed from: k2.f$b$b, reason: collision with other inner class name */
        public static final class C0176b {
            public C0176b(zf.f fVar) {
            }

            public final a builder(Context context) {
                zf.i.checkNotNullParameter(context, "context");
                return new a(context);
            }
        }

        public b(Context context, String str, a aVar, boolean z10, boolean z11) {
            zf.i.checkNotNullParameter(context, "context");
            zf.i.checkNotNullParameter(aVar, "callback");
            this.f14725a = context;
            this.f14726b = str;
            this.f14727c = aVar;
            this.f14728d = z10;
            this.f14729e = z11;
        }

        public static final a builder(Context context) {
            return f14724f.builder(context);
        }
    }

    /* compiled from: SupportSQLiteOpenHelper.kt */
    public interface c {
        f create(b bVar);
    }

    @Override // java.io.Closeable, java.lang.AutoCloseable
    void close();

    String getDatabaseName();

    e getWritableDatabase();

    void setWriteAheadLoggingEnabled(boolean z10);
}
