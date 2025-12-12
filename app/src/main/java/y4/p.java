package y4;

import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteDatabaseLockedException;
import android.os.SystemClock;
import android.util.Base64;
import com.google.android.datatransport.runtime.firebase.transport.LogEventDropped;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Objects;
import t4.a;
import z4.a;

/* compiled from: SQLiteEventStore.java */
/* loaded from: classes.dex */
public final class p implements d, z4.a, c {

    /* renamed from: q, reason: collision with root package name */
    public static final n4.b f21888q = n4.b.of("proto");

    /* renamed from: b, reason: collision with root package name */
    public final s f21889b;

    /* renamed from: m, reason: collision with root package name */
    public final a5.a f21890m;

    /* renamed from: n, reason: collision with root package name */
    public final a5.a f21891n;

    /* renamed from: o, reason: collision with root package name */
    public final e f21892o;

    /* renamed from: p, reason: collision with root package name */
    public final jf.a<String> f21893p;

    /* compiled from: SQLiteEventStore.java */
    public interface a<T, U> {
        U apply(T t10);
    }

    /* compiled from: SQLiteEventStore.java */
    public static class b {

        /* renamed from: a, reason: collision with root package name */
        public final String f21894a;

        /* renamed from: b, reason: collision with root package name */
        public final String f21895b;

        public b(String str, String str2) {
            this.f21894a = str;
            this.f21895b = str2;
        }
    }

    public p(a5.a aVar, a5.a aVar2, e eVar, s sVar, jf.a<String> aVar3) {
        this.f21889b = sVar;
        this.f21890m = aVar;
        this.f21891n = aVar2;
        this.f21892o = eVar;
        this.f21893p = aVar3;
    }

    public static Long b(SQLiteDatabase sQLiteDatabase, q4.o oVar) {
        StringBuilder sb2 = new StringBuilder("backend_name = ? and priority = ?");
        ArrayList arrayList = new ArrayList(Arrays.asList(oVar.getBackendName(), String.valueOf(b5.a.toInt(oVar.getPriority()))));
        if (oVar.getExtras() != null) {
            sb2.append(" and extras = ?");
            arrayList.add(Base64.encodeToString(oVar.getExtras(), 0));
        } else {
            sb2.append(" and extras is null");
        }
        return (Long) g(sQLiteDatabase.query("transport_contexts", new String[]{"_id"}, sb2.toString(), (String[]) arrayList.toArray(new String[0]), null, null, null), new pd.a(15));
    }

    public static String f(Iterable<j> iterable) {
        StringBuilder sb2 = new StringBuilder("(");
        Iterator<j> it = iterable.iterator();
        while (it.hasNext()) {
            sb2.append(it.next().getId());
            if (it.hasNext()) {
                sb2.append(',');
            }
        }
        sb2.append(')');
        return sb2.toString();
    }

    public static <T> T g(Cursor cursor, a<Cursor, T> aVar) {
        try {
            return aVar.apply(cursor);
        } finally {
            cursor.close();
        }
    }

    public final SQLiteDatabase a() {
        s sVar = this.f21889b;
        Objects.requireNonNull(sVar);
        return (SQLiteDatabase) e(new c1.c(sVar, 6), new pd.a(11));
    }

    public final <T> T c(a<SQLiteDatabase, T> aVar) {
        SQLiteDatabase sQLiteDatabaseA = a();
        sQLiteDatabaseA.beginTransaction();
        try {
            T tApply = aVar.apply(sQLiteDatabaseA);
            sQLiteDatabaseA.setTransactionSuccessful();
            return tApply;
        } finally {
            sQLiteDatabaseA.endTransaction();
        }
    }

    @Override // y4.d
    public int cleanUp() {
        return ((Integer) c(new k(this, this.f21890m.getTime() - this.f21892o.b()))).intValue();
    }

    @Override // java.io.Closeable, java.lang.AutoCloseable
    public void close() {
        this.f21889b.close();
    }

    public final ArrayList d(SQLiteDatabase sQLiteDatabase, q4.o oVar, int i10) {
        ArrayList arrayList = new ArrayList();
        Long lB = b(sQLiteDatabase, oVar);
        if (lB == null) {
            return arrayList;
        }
        g(sQLiteDatabase.query("events", new String[]{"_id", "transport_name", "timestamp_ms", "uptime_ms", "payload_encoding", "payload", "code", "inline"}, "context_id = ?", new String[]{lB.toString()}, null, null, null, String.valueOf(i10)), new q2.b(4, this, arrayList, oVar));
        return arrayList;
    }

    public final Object e(c1.c cVar, pd.a aVar) {
        a5.a aVar2 = this.f21891n;
        long time = aVar2.getTime();
        while (true) {
            try {
                return cVar.d();
            } catch (SQLiteDatabaseLockedException e10) {
                if (aVar2.getTime() >= this.f21892o.a() + time) {
                    return aVar.apply(e10);
                }
                SystemClock.sleep(50L);
            }
        }
    }

    @Override // y4.d
    public long getNextCallTime(q4.o oVar) {
        return ((Long) g(a().rawQuery("SELECT next_request_ms FROM transport_contexts WHERE backend_name = ? and priority = ?", new String[]{oVar.getBackendName(), String.valueOf(b5.a.toInt(oVar.getPriority()))}), new pd.a(12))).longValue();
    }

    @Override // y4.d
    public boolean hasPendingEventsFor(q4.o oVar) {
        return ((Boolean) c(new l(this, oVar, 0))).booleanValue();
    }

    @Override // y4.d
    public Iterable<q4.o> loadActiveContexts() {
        return (Iterable) c(new pd.a(10));
    }

    @Override // y4.d
    public Iterable<j> loadBatch(q4.o oVar) {
        return (Iterable) c(new l(this, oVar, 1));
    }

    @Override // y4.c
    public t4.a loadClientMetrics() {
        a.C0257a c0257aNewBuilder = t4.a.newBuilder();
        HashMap map = new HashMap();
        SQLiteDatabase sQLiteDatabaseA = a();
        sQLiteDatabaseA.beginTransaction();
        try {
            t4.a aVar = (t4.a) g(sQLiteDatabaseA.rawQuery("SELECT log_source, reason, events_dropped_count FROM log_event_dropped", new String[0]), new q2.b(5, this, map, c0257aNewBuilder));
            sQLiteDatabaseA.setTransactionSuccessful();
            return aVar;
        } finally {
            sQLiteDatabaseA.endTransaction();
        }
    }

    @Override // y4.d
    public j persist(q4.o oVar, q4.i iVar) {
        u4.a.d("SQLiteEventStore", "Storing event with priority=%s, name=%s for destination %s", oVar.getPriority(), iVar.getTransportName(), oVar.getBackendName());
        long jLongValue = ((Long) c(new q2.b(2, this, iVar, oVar))).longValue();
        if (jLongValue < 1) {
            return null;
        }
        return j.create(jLongValue, oVar, iVar);
    }

    @Override // y4.d
    public void recordFailure(Iterable<j> iterable) {
        if (iterable.iterator().hasNext()) {
            c(new q2.b(3, this, "UPDATE events SET num_attempts = num_attempts + 1 WHERE _id in " + f(iterable), "SELECT COUNT(*), transport_name FROM events WHERE num_attempts >= 16 GROUP BY transport_name"));
        }
    }

    @Override // y4.c
    public void recordLogEventDropped(long j10, LogEventDropped.Reason reason, String str) {
        c(new x4.g(str, j10, reason));
    }

    @Override // y4.d
    public void recordNextCallTime(q4.o oVar, long j10) {
        c(new k(oVar, j10));
    }

    @Override // y4.d
    public void recordSuccess(Iterable<j> iterable) {
        if (iterable.iterator().hasNext()) {
            a().compileStatement("DELETE FROM events WHERE _id in " + f(iterable)).execute();
        }
    }

    @Override // y4.c
    public void resetClientMetrics() {
        c(new m(this, 0));
    }

    @Override // z4.a
    public <T> T runCriticalSection(a.InterfaceC0331a<T> interfaceC0331a) {
        SQLiteDatabase sQLiteDatabaseA = a();
        e(new c1.c(sQLiteDatabaseA, 7), new pd.a(13));
        try {
            T tExecute = interfaceC0331a.execute();
            sQLiteDatabaseA.setTransactionSuccessful();
            return tExecute;
        } finally {
            sQLiteDatabaseA.endTransaction();
        }
    }
}
