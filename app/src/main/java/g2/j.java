package g2;

import android.annotation.SuppressLint;
import android.content.Context;
import android.content.Intent;
import android.database.Cursor;
import android.database.SQLException;
import android.database.sqlite.SQLiteException;
import android.util.Log;
import androidx.room.RoomDatabase;
import com.unity3d.ads.metadata.MediationMetaData;
import java.io.IOException;
import java.lang.reflect.InvocationTargetException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.Locale;
import java.util.Map;
import java.util.Set;
import java.util.concurrent.atomic.AtomicBoolean;
import java.util.concurrent.locks.Lock;
import mf.y;
import mf.z;

/* compiled from: InvalidationTracker.kt */
/* loaded from: classes.dex */
public final class j {

    /* renamed from: o, reason: collision with root package name */
    public static final a f12568o = new a(null);

    /* renamed from: p, reason: collision with root package name */
    public static final String[] f12569p = {"UPDATE", "DELETE", "INSERT"};

    /* renamed from: a, reason: collision with root package name */
    public final RoomDatabase f12570a;

    /* renamed from: b, reason: collision with root package name */
    public final Map<String, String> f12571b;

    /* renamed from: c, reason: collision with root package name */
    public final Map<String, Set<String>> f12572c;

    /* renamed from: d, reason: collision with root package name */
    public final LinkedHashMap f12573d;

    /* renamed from: e, reason: collision with root package name */
    public final String[] f12574e;

    /* renamed from: f, reason: collision with root package name */
    public g2.a f12575f;

    /* renamed from: g, reason: collision with root package name */
    public final AtomicBoolean f12576g;

    /* renamed from: h, reason: collision with root package name */
    public volatile boolean f12577h;

    /* renamed from: i, reason: collision with root package name */
    public volatile k2.i f12578i;

    /* renamed from: j, reason: collision with root package name */
    public final b f12579j;

    /* renamed from: k, reason: collision with root package name */
    public final z.b<c, d> f12580k;

    /* renamed from: l, reason: collision with root package name */
    public final Object f12581l;

    /* renamed from: m, reason: collision with root package name */
    public final Object f12582m;

    /* renamed from: n, reason: collision with root package name */
    public final e f12583n;

    /* compiled from: InvalidationTracker.kt */
    public static final class a {
        public a(zf.f fVar) {
        }

        public final void beginTransactionInternal$room_runtime_release(k2.e eVar) {
            zf.i.checkNotNullParameter(eVar, "database");
            if (eVar.isWriteAheadLoggingEnabled()) {
                eVar.beginTransactionNonExclusive();
            } else {
                eVar.beginTransaction();
            }
        }

        public final String getTriggerName$room_runtime_release(String str, String str2) {
            zf.i.checkNotNullParameter(str, "tableName");
            zf.i.checkNotNullParameter(str2, "triggerType");
            return "`room_table_modification_trigger_" + str + '_' + str2 + '`';
        }
    }

    /* compiled from: InvalidationTracker.kt */
    public static final class b {

        /* renamed from: a, reason: collision with root package name */
        public final long[] f12584a;

        /* renamed from: b, reason: collision with root package name */
        public final boolean[] f12585b;

        /* renamed from: c, reason: collision with root package name */
        public final int[] f12586c;

        /* renamed from: d, reason: collision with root package name */
        public boolean f12587d;

        /* compiled from: InvalidationTracker.kt */
        public static final class a {
            public a(zf.f fVar) {
            }
        }

        static {
            new a(null);
        }

        public b(int i10) {
            this.f12584a = new long[i10];
            this.f12585b = new boolean[i10];
            this.f12586c = new int[i10];
        }

        public final int[] getTablesToSync() {
            synchronized (this) {
                if (!this.f12587d) {
                    return null;
                }
                long[] jArr = this.f12584a;
                int length = jArr.length;
                int i10 = 0;
                int i11 = 0;
                while (i10 < length) {
                    int i12 = i11 + 1;
                    int i13 = 1;
                    boolean z10 = jArr[i10] > 0;
                    boolean[] zArr = this.f12585b;
                    if (z10 != zArr[i11]) {
                        int[] iArr = this.f12586c;
                        if (!z10) {
                            i13 = 2;
                        }
                        iArr[i11] = i13;
                    } else {
                        this.f12586c[i11] = 0;
                    }
                    zArr[i11] = z10;
                    i10++;
                    i11 = i12;
                }
                this.f12587d = false;
                return (int[]) this.f12586c.clone();
            }
        }

        public final boolean onAdded(int... iArr) {
            boolean z10;
            zf.i.checkNotNullParameter(iArr, "tableIds");
            synchronized (this) {
                z10 = false;
                for (int i10 : iArr) {
                    long[] jArr = this.f12584a;
                    long j10 = jArr[i10];
                    jArr[i10] = 1 + j10;
                    if (j10 == 0) {
                        z10 = true;
                        this.f12587d = true;
                    }
                }
                lf.h hVar = lf.h.f16056a;
            }
            return z10;
        }

        public final boolean onRemoved(int... iArr) {
            boolean z10;
            zf.i.checkNotNullParameter(iArr, "tableIds");
            synchronized (this) {
                z10 = false;
                for (int i10 : iArr) {
                    long[] jArr = this.f12584a;
                    long j10 = jArr[i10];
                    jArr[i10] = j10 - 1;
                    if (j10 == 1) {
                        z10 = true;
                        this.f12587d = true;
                    }
                }
                lf.h hVar = lf.h.f16056a;
            }
            return z10;
        }

        public final void resetTriggerState() {
            synchronized (this) {
                Arrays.fill(this.f12585b, false);
                this.f12587d = true;
                lf.h hVar = lf.h.f16056a;
            }
        }
    }

    /* compiled from: InvalidationTracker.kt */
    public static abstract class c {

        /* renamed from: a, reason: collision with root package name */
        public final String[] f12588a;

        public c(String[] strArr) {
            zf.i.checkNotNullParameter(strArr, "tables");
            this.f12588a = strArr;
        }

        public final String[] getTables$room_runtime_release() {
            return this.f12588a;
        }

        public boolean isRemote$room_runtime_release() {
            return false;
        }

        public abstract void onInvalidated(Set<String> set);
    }

    /* compiled from: InvalidationTracker.kt */
    public static final class d {

        /* renamed from: a, reason: collision with root package name */
        public final c f12589a;

        /* renamed from: b, reason: collision with root package name */
        public final int[] f12590b;

        /* renamed from: c, reason: collision with root package name */
        public final String[] f12591c;

        /* renamed from: d, reason: collision with root package name */
        public final Set<String> f12592d;

        public d(c cVar, int[] iArr, String[] strArr) {
            zf.i.checkNotNullParameter(cVar, "observer");
            zf.i.checkNotNullParameter(iArr, "tableIds");
            zf.i.checkNotNullParameter(strArr, "tableNames");
            this.f12589a = cVar;
            this.f12590b = iArr;
            this.f12591c = strArr;
            this.f12592d = (strArr.length == 0) ^ true ? y.setOf(strArr[0]) : z.emptySet();
            if (!(iArr.length == strArr.length)) {
                throw new IllegalStateException("Check failed.".toString());
            }
        }

        public final int[] getTableIds$room_runtime_release() {
            return this.f12590b;
        }

        public final void notifyByTableInvalidStatus$room_runtime_release(Set<Integer> set) {
            Set<String> setEmptySet;
            zf.i.checkNotNullParameter(set, "invalidatedTablesIds");
            int[] iArr = this.f12590b;
            int length = iArr.length;
            if (length != 0) {
                int i10 = 0;
                if (length != 1) {
                    Set setCreateSetBuilder = y.createSetBuilder();
                    int length2 = iArr.length;
                    int i11 = 0;
                    while (i10 < length2) {
                        int i12 = i11 + 1;
                        if (set.contains(Integer.valueOf(iArr[i10]))) {
                            setCreateSetBuilder.add(this.f12591c[i11]);
                        }
                        i10++;
                        i11 = i12;
                    }
                    setEmptySet = y.build(setCreateSetBuilder);
                } else {
                    setEmptySet = set.contains(Integer.valueOf(iArr[0])) ? this.f12592d : z.emptySet();
                }
            } else {
                setEmptySet = z.emptySet();
            }
            if (!setEmptySet.isEmpty()) {
                this.f12589a.onInvalidated(setEmptySet);
            }
        }

        public final void notifyByTableNames$room_runtime_release(String[] strArr) {
            Set<String> setEmptySet;
            zf.i.checkNotNullParameter(strArr, "tables");
            String[] strArr2 = this.f12591c;
            int length = strArr2.length;
            if (length != 0) {
                boolean z10 = false;
                if (length != 1) {
                    Set setCreateSetBuilder = y.createSetBuilder();
                    for (String str : strArr) {
                        for (String str2 : strArr2) {
                            if (ig.l.equals(str2, str, true)) {
                                setCreateSetBuilder.add(str2);
                            }
                        }
                    }
                    setEmptySet = y.build(setCreateSetBuilder);
                } else {
                    int length2 = strArr.length;
                    int i10 = 0;
                    while (true) {
                        if (i10 >= length2) {
                            break;
                        }
                        if (ig.l.equals(strArr[i10], strArr2[0], true)) {
                            z10 = true;
                            break;
                        }
                        i10++;
                    }
                    setEmptySet = z10 ? this.f12592d : z.emptySet();
                }
            } else {
                setEmptySet = z.emptySet();
            }
            if (!setEmptySet.isEmpty()) {
                this.f12589a.onInvalidated(setEmptySet);
            }
        }
    }

    /* compiled from: InvalidationTracker.kt */
    public static final class e implements Runnable {
        public e() {
        }

        public final Set<Integer> a() throws IllegalAccessException, IOException, IllegalArgumentException, InvocationTargetException {
            Set setCreateSetBuilder = y.createSetBuilder();
            j jVar = j.this;
            Cursor cursorQuery$default = RoomDatabase.query$default(jVar.getDatabase$room_runtime_release(), new k2.a("SELECT * FROM room_table_modification_log WHERE invalidated = 1;"), null, 2, null);
            while (cursorQuery$default.moveToNext()) {
                try {
                    setCreateSetBuilder.add(Integer.valueOf(cursorQuery$default.getInt(0)));
                } finally {
                }
            }
            lf.h hVar = lf.h.f16056a;
            wf.a.closeFinally(cursorQuery$default, null);
            Set<Integer> setBuild = y.build(setCreateSetBuilder);
            if (!setBuild.isEmpty()) {
                if (jVar.getCleanupStatement$room_runtime_release() == null) {
                    throw new IllegalStateException("Required value was null.".toString());
                }
                k2.i cleanupStatement$room_runtime_release = jVar.getCleanupStatement$room_runtime_release();
                if (cleanupStatement$room_runtime_release == null) {
                    throw new IllegalArgumentException("Required value was null.".toString());
                }
                cleanupStatement$room_runtime_release.executeUpdateDelete();
            }
            return setBuild;
        }

        @Override // java.lang.Runnable
        public void run() {
            Set<Integer> setEmptySet;
            g2.a aVar;
            g2.a aVar2;
            Lock closeLock$room_runtime_release = j.this.getDatabase$room_runtime_release().getCloseLock$room_runtime_release();
            closeLock$room_runtime_release.lock();
            try {
                try {
                } catch (SQLiteException e10) {
                    Log.e("ROOM", "Cannot run invalidation tracker. Is the db closed?", e10);
                    setEmptySet = z.emptySet();
                    closeLock$room_runtime_release.unlock();
                    aVar = j.this.f12575f;
                    if (aVar != null) {
                    }
                } catch (IllegalStateException e11) {
                    Log.e("ROOM", "Cannot run invalidation tracker. Is the db closed?", e11);
                    setEmptySet = z.emptySet();
                    closeLock$room_runtime_release.unlock();
                    aVar = j.this.f12575f;
                    if (aVar != null) {
                    }
                }
                if (!j.this.ensureInitialization$room_runtime_release()) {
                    if (aVar2 != null) {
                        return;
                    } else {
                        return;
                    }
                }
                if (!j.this.getPendingRefresh().compareAndSet(true, false)) {
                    closeLock$room_runtime_release.unlock();
                    g2.a aVar3 = j.this.f12575f;
                    if (aVar3 != null) {
                        aVar3.decrementCountAndScheduleClose();
                        return;
                    }
                    return;
                }
                if (j.this.getDatabase$room_runtime_release().inTransaction()) {
                    closeLock$room_runtime_release.unlock();
                    g2.a aVar4 = j.this.f12575f;
                    if (aVar4 != null) {
                        aVar4.decrementCountAndScheduleClose();
                        return;
                    }
                    return;
                }
                k2.e writableDatabase = j.this.getDatabase$room_runtime_release().getOpenHelper().getWritableDatabase();
                writableDatabase.beginTransactionNonExclusive();
                try {
                    setEmptySet = a();
                    writableDatabase.setTransactionSuccessful();
                    closeLock$room_runtime_release.unlock();
                    aVar = j.this.f12575f;
                    if (aVar != null) {
                        aVar.decrementCountAndScheduleClose();
                    }
                    if (!setEmptySet.isEmpty()) {
                        z.b<c, d> observerMap$room_runtime_release = j.this.getObserverMap$room_runtime_release();
                        j jVar = j.this;
                        synchronized (observerMap$room_runtime_release) {
                            Iterator<Map.Entry<K, V>> it = jVar.getObserverMap$room_runtime_release().iterator();
                            while (it.hasNext()) {
                                ((d) ((Map.Entry) it.next()).getValue()).notifyByTableInvalidStatus$room_runtime_release(setEmptySet);
                            }
                            lf.h hVar = lf.h.f16056a;
                        }
                    }
                } finally {
                    writableDatabase.endTransaction();
                }
            } finally {
                closeLock$room_runtime_release.unlock();
                aVar2 = j.this.f12575f;
                if (aVar2 != null) {
                    aVar2.decrementCountAndScheduleClose();
                }
            }
        }
    }

    public j(RoomDatabase roomDatabase, Map<String, String> map, Map<String, Set<String>> map2, String... strArr) {
        String lowerCase;
        zf.i.checkNotNullParameter(roomDatabase, "database");
        zf.i.checkNotNullParameter(map, "shadowTablesMap");
        zf.i.checkNotNullParameter(map2, "viewTables");
        zf.i.checkNotNullParameter(strArr, "tableNames");
        this.f12570a = roomDatabase;
        this.f12571b = map;
        this.f12572c = map2;
        this.f12576g = new AtomicBoolean(false);
        this.f12579j = new b(strArr.length);
        new i(roomDatabase);
        this.f12580k = new z.b<>();
        this.f12581l = new Object();
        this.f12582m = new Object();
        this.f12573d = new LinkedHashMap();
        int length = strArr.length;
        String[] strArr2 = new String[length];
        for (int i10 = 0; i10 < length; i10++) {
            String str = strArr[i10];
            Locale locale = Locale.US;
            zf.i.checkNotNullExpressionValue(locale, "US");
            String lowerCase2 = str.toLowerCase(locale);
            zf.i.checkNotNullExpressionValue(lowerCase2, "this as java.lang.String).toLowerCase(locale)");
            this.f12573d.put(lowerCase2, Integer.valueOf(i10));
            String str2 = this.f12571b.get(strArr[i10]);
            if (str2 != null) {
                zf.i.checkNotNullExpressionValue(locale, "US");
                lowerCase = str2.toLowerCase(locale);
                zf.i.checkNotNullExpressionValue(lowerCase, "this as java.lang.String).toLowerCase(locale)");
            } else {
                lowerCase = null;
            }
            if (lowerCase != null) {
                lowerCase2 = lowerCase;
            }
            strArr2[i10] = lowerCase2;
        }
        this.f12574e = strArr2;
        for (Map.Entry<String, String> entry : this.f12571b.entrySet()) {
            String value = entry.getValue();
            Locale locale2 = Locale.US;
            zf.i.checkNotNullExpressionValue(locale2, "US");
            String lowerCase3 = value.toLowerCase(locale2);
            zf.i.checkNotNullExpressionValue(lowerCase3, "this as java.lang.String).toLowerCase(locale)");
            if (this.f12573d.containsKey(lowerCase3)) {
                String key = entry.getKey();
                zf.i.checkNotNullExpressionValue(locale2, "US");
                String lowerCase4 = key.toLowerCase(locale2);
                zf.i.checkNotNullExpressionValue(lowerCase4, "this as java.lang.String).toLowerCase(locale)");
                LinkedHashMap linkedHashMap = this.f12573d;
                linkedHashMap.put(lowerCase4, kotlin.collections.a.getValue(linkedHashMap, lowerCase3));
            }
        }
        this.f12583n = new e();
    }

    public final void a(k2.e eVar, int i10) throws SQLException {
        eVar.execSQL("INSERT OR IGNORE INTO room_table_modification_log VALUES(" + i10 + ", 0)");
        String str = this.f12574e[i10];
        for (String str2 : f12569p) {
            String str3 = "CREATE TEMP TRIGGER IF NOT EXISTS " + f12568o.getTriggerName$room_runtime_release(str, str2) + " AFTER " + str2 + " ON `" + str + "` BEGIN UPDATE room_table_modification_log SET invalidated = 1 WHERE table_id = " + i10 + " AND invalidated = 0; END";
            zf.i.checkNotNullExpressionValue(str3, "StringBuilder().apply(builderAction).toString()");
            eVar.execSQL(str3);
        }
    }

    @SuppressLint({"RestrictedApi"})
    public void addObserver(c cVar) {
        d dVarPutIfAbsent;
        zf.i.checkNotNullParameter(cVar, "observer");
        String[] tables$room_runtime_release = cVar.getTables$room_runtime_release();
        Set setCreateSetBuilder = y.createSetBuilder();
        for (String str : tables$room_runtime_release) {
            Locale locale = Locale.US;
            zf.i.checkNotNullExpressionValue(locale, "US");
            String lowerCase = str.toLowerCase(locale);
            zf.i.checkNotNullExpressionValue(lowerCase, "this as java.lang.String).toLowerCase(locale)");
            Map<String, Set<String>> map = this.f12572c;
            if (map.containsKey(lowerCase)) {
                zf.i.checkNotNullExpressionValue(locale, "US");
                String lowerCase2 = str.toLowerCase(locale);
                zf.i.checkNotNullExpressionValue(lowerCase2, "this as java.lang.String).toLowerCase(locale)");
                Set<String> set = map.get(lowerCase2);
                zf.i.checkNotNull(set);
                setCreateSetBuilder.addAll(set);
            } else {
                setCreateSetBuilder.add(str);
            }
        }
        Object[] array = y.build(setCreateSetBuilder).toArray(new String[0]);
        zf.i.checkNotNull(array, "null cannot be cast to non-null type kotlin.Array<T of kotlin.collections.ArraysKt__ArraysJVMKt.toTypedArray>");
        String[] strArr = (String[]) array;
        ArrayList arrayList = new ArrayList(strArr.length);
        for (String str2 : strArr) {
            LinkedHashMap linkedHashMap = this.f12573d;
            Locale locale2 = Locale.US;
            zf.i.checkNotNullExpressionValue(locale2, "US");
            String lowerCase3 = str2.toLowerCase(locale2);
            zf.i.checkNotNullExpressionValue(lowerCase3, "this as java.lang.String).toLowerCase(locale)");
            Integer num = (Integer) linkedHashMap.get(lowerCase3);
            if (num == null) {
                throw new IllegalArgumentException("There is no table with name ".concat(str2));
            }
            arrayList.add(Integer.valueOf(num.intValue()));
        }
        int[] intArray = mf.q.toIntArray(arrayList);
        d dVar = new d(cVar, intArray, strArr);
        synchronized (this.f12580k) {
            dVarPutIfAbsent = this.f12580k.putIfAbsent(cVar, dVar);
        }
        if (dVarPutIfAbsent == null && this.f12579j.onAdded(Arrays.copyOf(intArray, intArray.length))) {
            syncTriggers$room_runtime_release();
        }
    }

    public final void b(k2.e eVar, int i10) throws SQLException {
        String str = this.f12574e[i10];
        for (String str2 : f12569p) {
            String str3 = "DROP TRIGGER IF EXISTS " + f12568o.getTriggerName$room_runtime_release(str, str2);
            zf.i.checkNotNullExpressionValue(str3, "StringBuilder().apply(builderAction).toString()");
            eVar.execSQL(str3);
        }
    }

    public final boolean ensureInitialization$room_runtime_release() {
        if (!this.f12570a.isOpen()) {
            return false;
        }
        if (!this.f12577h) {
            this.f12570a.getOpenHelper().getWritableDatabase();
        }
        if (this.f12577h) {
            return true;
        }
        Log.e("ROOM", "database is not initialized even though it is open");
        return false;
    }

    public final k2.i getCleanupStatement$room_runtime_release() {
        return this.f12578i;
    }

    public final RoomDatabase getDatabase$room_runtime_release() {
        return this.f12570a;
    }

    public final z.b<c, d> getObserverMap$room_runtime_release() {
        return this.f12580k;
    }

    public final AtomicBoolean getPendingRefresh() {
        return this.f12576g;
    }

    public final Map<String, Integer> getTableIdLookup$room_runtime_release() {
        return this.f12573d;
    }

    public final void internalInit$room_runtime_release(k2.e eVar) {
        zf.i.checkNotNullParameter(eVar, "database");
        synchronized (this.f12582m) {
            if (this.f12577h) {
                Log.e("ROOM", "Invalidation tracker is initialized twice :/.");
                return;
            }
            eVar.execSQL("PRAGMA temp_store = MEMORY;");
            eVar.execSQL("PRAGMA recursive_triggers='ON';");
            eVar.execSQL("CREATE TEMP TABLE room_table_modification_log (table_id INTEGER PRIMARY KEY, invalidated INTEGER NOT NULL DEFAULT 0)");
            syncTriggers$room_runtime_release(eVar);
            this.f12578i = eVar.compileStatement("UPDATE room_table_modification_log SET invalidated = 0 WHERE invalidated = 1");
            this.f12577h = true;
            lf.h hVar = lf.h.f16056a;
        }
    }

    public final void notifyObserversByTableNames(String... strArr) {
        zf.i.checkNotNullParameter(strArr, "tables");
        synchronized (this.f12580k) {
            Iterator<Map.Entry<K, V>> it = this.f12580k.iterator();
            while (it.hasNext()) {
                Map.Entry entry = (Map.Entry) it.next();
                zf.i.checkNotNullExpressionValue(entry, "(observer, wrapper)");
                c cVar = (c) entry.getKey();
                d dVar = (d) entry.getValue();
                if (!cVar.isRemote$room_runtime_release()) {
                    dVar.notifyByTableNames$room_runtime_release(strArr);
                }
            }
            lf.h hVar = lf.h.f16056a;
        }
    }

    public final void onAutoCloseCallback$room_runtime_release() {
        synchronized (this.f12582m) {
            this.f12577h = false;
            this.f12579j.resetTriggerState();
            lf.h hVar = lf.h.f16056a;
        }
    }

    public void refreshVersionsAsync() {
        if (this.f12576g.compareAndSet(false, true)) {
            g2.a aVar = this.f12575f;
            if (aVar != null) {
                aVar.incrementCountAndEnsureDbIsOpen();
            }
            this.f12570a.getQueryExecutor().execute(this.f12583n);
        }
    }

    @SuppressLint({"RestrictedApi"})
    public void removeObserver(c cVar) {
        d dVarRemove;
        zf.i.checkNotNullParameter(cVar, "observer");
        synchronized (this.f12580k) {
            dVarRemove = this.f12580k.remove(cVar);
        }
        if (dVarRemove != null) {
            b bVar = this.f12579j;
            int[] tableIds$room_runtime_release = dVarRemove.getTableIds$room_runtime_release();
            if (bVar.onRemoved(Arrays.copyOf(tableIds$room_runtime_release, tableIds$room_runtime_release.length))) {
                syncTriggers$room_runtime_release();
            }
        }
    }

    public final void setAutoCloser$room_runtime_release(g2.a aVar) {
        zf.i.checkNotNullParameter(aVar, "autoCloser");
        this.f12575f = aVar;
        aVar.setAutoCloseCallback(new androidx.activity.d(this, 8));
    }

    public final void startMultiInstanceInvalidation$room_runtime_release(Context context, String str, Intent intent) {
        zf.i.checkNotNullParameter(context, "context");
        zf.i.checkNotNullParameter(str, MediationMetaData.KEY_NAME);
        zf.i.checkNotNullParameter(intent, "serviceIntent");
        new l(context, str, intent, this, this.f12570a.getQueryExecutor());
    }

    public final void syncTriggers$room_runtime_release(k2.e eVar) {
        zf.i.checkNotNullParameter(eVar, "database");
        if (eVar.inTransaction()) {
            return;
        }
        try {
            Lock closeLock$room_runtime_release = this.f12570a.getCloseLock$room_runtime_release();
            closeLock$room_runtime_release.lock();
            try {
                synchronized (this.f12581l) {
                    int[] tablesToSync = this.f12579j.getTablesToSync();
                    if (tablesToSync == null) {
                        return;
                    }
                    f12568o.beginTransactionInternal$room_runtime_release(eVar);
                    try {
                        int length = tablesToSync.length;
                        int i10 = 0;
                        int i11 = 0;
                        while (i10 < length) {
                            int i12 = tablesToSync[i10];
                            int i13 = i11 + 1;
                            if (i12 == 1) {
                                a(eVar, i11);
                            } else if (i12 == 2) {
                                b(eVar, i11);
                            }
                            i10++;
                            i11 = i13;
                        }
                        eVar.setTransactionSuccessful();
                        eVar.endTransaction();
                        lf.h hVar = lf.h.f16056a;
                    } catch (Throwable th2) {
                        eVar.endTransaction();
                        throw th2;
                    }
                }
            } finally {
                closeLock$room_runtime_release.unlock();
            }
        } catch (SQLiteException e10) {
            Log.e("ROOM", "Cannot run invalidation tracker. Is the db closed?", e10);
        } catch (IllegalStateException e11) {
            Log.e("ROOM", "Cannot run invalidation tracker. Is the db closed?", e11);
        }
    }

    public final void syncTriggers$room_runtime_release() {
        RoomDatabase roomDatabase = this.f12570a;
        if (roomDatabase.isOpen()) {
            syncTriggers$room_runtime_release(roomDatabase.getOpenHelper().getWritableDatabase());
        }
    }
}
