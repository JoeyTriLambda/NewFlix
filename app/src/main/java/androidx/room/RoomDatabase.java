package androidx.room;

import android.app.ActivityManager;
import android.content.Context;
import android.content.Intent;
import android.database.Cursor;
import android.os.CancellationSignal;
import android.os.Looper;
import android.util.Log;
import g2.j;
import g2.n;
import g2.r;
import g2.s;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.BitSet;
import java.util.Collections;
import java.util.HashSet;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.LinkedHashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.TreeMap;
import java.util.concurrent.Callable;
import java.util.concurrent.Executor;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantReadWriteLock;
import k2.f;
import k2.h;
import mf.k;
import mf.z;
import yf.l;
import zf.i;

/* compiled from: RoomDatabase.kt */
/* loaded from: classes.dex */
public abstract class RoomDatabase {

    /* renamed from: a, reason: collision with root package name */
    public volatile k2.e f4272a;

    /* renamed from: b, reason: collision with root package name */
    public Executor f4273b;

    /* renamed from: c, reason: collision with root package name */
    public f f4274c;

    /* renamed from: e, reason: collision with root package name */
    public boolean f4276e;

    /* renamed from: f, reason: collision with root package name */
    public List<? extends b> f4277f;

    /* renamed from: i, reason: collision with root package name */
    public g2.a f4280i;

    /* renamed from: k, reason: collision with root package name */
    public final Map<String, Object> f4282k;

    /* renamed from: l, reason: collision with root package name */
    public final LinkedHashMap f4283l;

    /* renamed from: d, reason: collision with root package name */
    public final j f4275d = createInvalidationTracker();

    /* renamed from: g, reason: collision with root package name */
    public final LinkedHashMap f4278g = new LinkedHashMap();

    /* renamed from: h, reason: collision with root package name */
    public final ReentrantReadWriteLock f4279h = new ReentrantReadWriteLock();

    /* renamed from: j, reason: collision with root package name */
    public final ThreadLocal<Integer> f4281j = new ThreadLocal<>();

    /* compiled from: RoomDatabase.kt */
    public enum JournalMode {
        AUTOMATIC,
        TRUNCATE,
        WRITE_AHEAD_LOGGING;

        public final JournalMode resolve$room_runtime_release(Context context) {
            i.checkNotNullParameter(context, "context");
            if (this != AUTOMATIC) {
                return this;
            }
            Object systemService = context.getSystemService("activity");
            i.checkNotNull(systemService, "null cannot be cast to non-null type android.app.ActivityManager");
            return !k2.c.isLowRamDevice((ActivityManager) systemService) ? WRITE_AHEAD_LOGGING : TRUNCATE;
        }
    }

    /* compiled from: RoomDatabase.kt */
    public static class a<T extends RoomDatabase> {

        /* renamed from: a, reason: collision with root package name */
        public final Context f4288a;

        /* renamed from: b, reason: collision with root package name */
        public final Class<T> f4289b;

        /* renamed from: c, reason: collision with root package name */
        public final String f4290c;

        /* renamed from: d, reason: collision with root package name */
        public final ArrayList f4291d;

        /* renamed from: e, reason: collision with root package name */
        public final ArrayList f4292e;

        /* renamed from: f, reason: collision with root package name */
        public final ArrayList f4293f;

        /* renamed from: g, reason: collision with root package name */
        public Executor f4294g;

        /* renamed from: h, reason: collision with root package name */
        public Executor f4295h;

        /* renamed from: i, reason: collision with root package name */
        public f.c f4296i;

        /* renamed from: j, reason: collision with root package name */
        public boolean f4297j;

        /* renamed from: k, reason: collision with root package name */
        public final JournalMode f4298k;

        /* renamed from: l, reason: collision with root package name */
        public boolean f4299l;

        /* renamed from: m, reason: collision with root package name */
        public boolean f4300m;

        /* renamed from: n, reason: collision with root package name */
        public final long f4301n;

        /* renamed from: o, reason: collision with root package name */
        public final d f4302o;

        /* renamed from: p, reason: collision with root package name */
        public final LinkedHashSet f4303p;

        /* renamed from: q, reason: collision with root package name */
        public HashSet f4304q;

        public a(Context context, Class<T> cls, String str) {
            i.checkNotNullParameter(context, "context");
            i.checkNotNullParameter(cls, "klass");
            this.f4288a = context;
            this.f4289b = cls;
            this.f4290c = str;
            this.f4291d = new ArrayList();
            this.f4292e = new ArrayList();
            this.f4293f = new ArrayList();
            this.f4298k = JournalMode.AUTOMATIC;
            this.f4299l = true;
            this.f4301n = -1L;
            this.f4302o = new d();
            this.f4303p = new LinkedHashSet();
        }

        public a<T> addCallback(b bVar) {
            i.checkNotNullParameter(bVar, "callback");
            this.f4291d.add(bVar);
            return this;
        }

        public a<T> addMigrations(h2.b... bVarArr) {
            i.checkNotNullParameter(bVarArr, "migrations");
            if (this.f4304q == null) {
                this.f4304q = new HashSet();
            }
            for (h2.b bVar : bVarArr) {
                HashSet hashSet = this.f4304q;
                i.checkNotNull(hashSet);
                hashSet.add(Integer.valueOf(bVar.f12906a));
                HashSet hashSet2 = this.f4304q;
                i.checkNotNull(hashSet2);
                hashSet2.add(Integer.valueOf(bVar.f12907b));
            }
            this.f4302o.addMigrations((h2.b[]) Arrays.copyOf(bVarArr, bVarArr.length));
            return this;
        }

        public a<T> allowMainThreadQueries() {
            this.f4297j = true;
            return this;
        }

        public T build() {
            Executor executor = this.f4294g;
            if (executor == null && this.f4295h == null) {
                Executor iOThreadExecutor = y.b.getIOThreadExecutor();
                this.f4295h = iOThreadExecutor;
                this.f4294g = iOThreadExecutor;
            } else if (executor != null && this.f4295h == null) {
                this.f4295h = executor;
            } else if (executor == null) {
                this.f4294g = this.f4295h;
            }
            HashSet hashSet = this.f4304q;
            LinkedHashSet linkedHashSet = this.f4303p;
            if (hashSet != null) {
                i.checkNotNull(hashSet);
                Iterator it = hashSet.iterator();
                while (it.hasNext()) {
                    int iIntValue = ((Number) it.next()).intValue();
                    if (!(!linkedHashSet.contains(Integer.valueOf(iIntValue)))) {
                        throw new IllegalArgumentException(ac.c.f("Inconsistency detected. A Migration was supplied to addMigration(Migration... migrations) that has a start or end version equal to a start version supplied to fallbackToDestructiveMigrationFrom(int... startVersions). Start version: ", iIntValue).toString());
                    }
                }
            }
            f.c cVar = this.f4296i;
            if (cVar == null) {
                cVar = new l2.c();
            }
            f.c cVar2 = cVar;
            if (this.f4301n > 0) {
                if (this.f4290c != null) {
                    throw new IllegalArgumentException("Required value was null.".toString());
                }
                throw new IllegalArgumentException("Cannot create auto-closing database for an in-memory database.".toString());
            }
            Context context = this.f4288a;
            String str = this.f4290c;
            d dVar = this.f4302o;
            ArrayList arrayList = this.f4291d;
            boolean z10 = this.f4297j;
            JournalMode journalModeResolve$room_runtime_release = this.f4298k.resolve$room_runtime_release(context);
            Executor executor2 = this.f4294g;
            if (executor2 == null) {
                throw new IllegalArgumentException("Required value was null.".toString());
            }
            Executor executor3 = this.f4295h;
            if (executor3 == null) {
                throw new IllegalArgumentException("Required value was null.".toString());
            }
            g2.c cVar3 = new g2.c(context, str, cVar2, dVar, arrayList, z10, journalModeResolve$room_runtime_release, executor2, executor3, null, this.f4299l, this.f4300m, linkedHashSet, null, null, null, null, this.f4292e, this.f4293f);
            T t10 = (T) n.getGeneratedImplementation(this.f4289b, "_Impl");
            t10.init(cVar3);
            return t10;
        }

        public a<T> fallbackToDestructiveMigration() {
            this.f4299l = false;
            this.f4300m = true;
            return this;
        }

        public a<T> openHelperFactory(f.c cVar) {
            this.f4296i = cVar;
            return this;
        }

        public a<T> setQueryExecutor(Executor executor) {
            i.checkNotNullParameter(executor, "executor");
            this.f4294g = executor;
            return this;
        }
    }

    /* compiled from: RoomDatabase.kt */
    public static abstract class b {
        public void onCreate(k2.e eVar) {
            i.checkNotNullParameter(eVar, "db");
        }

        public void onDestructiveMigration(k2.e eVar) {
            i.checkNotNullParameter(eVar, "db");
        }

        public void onOpen(k2.e eVar) {
            i.checkNotNullParameter(eVar, "db");
        }
    }

    /* compiled from: RoomDatabase.kt */
    public static final class c {
        public c(zf.f fVar) {
        }
    }

    /* compiled from: RoomDatabase.kt */
    public static class d {

        /* renamed from: a, reason: collision with root package name */
        public final LinkedHashMap f4306a = new LinkedHashMap();

        public void addMigrations(h2.b... bVarArr) {
            i.checkNotNullParameter(bVarArr, "migrations");
            for (h2.b bVar : bVarArr) {
                int i10 = bVar.f12906a;
                LinkedHashMap linkedHashMap = this.f4306a;
                Integer numValueOf = Integer.valueOf(i10);
                Object treeMap = linkedHashMap.get(numValueOf);
                if (treeMap == null) {
                    treeMap = new TreeMap();
                    linkedHashMap.put(numValueOf, treeMap);
                }
                TreeMap treeMap2 = (TreeMap) treeMap;
                int i11 = bVar.f12907b;
                if (treeMap2.containsKey(Integer.valueOf(i11))) {
                    Log.w("ROOM", "Overriding migration " + treeMap2.get(Integer.valueOf(i11)) + " with " + bVar);
                }
                treeMap2.put(Integer.valueOf(i11), bVar);
            }
        }

        public final boolean contains(int i10, int i11) {
            Map<Integer, Map<Integer, h2.b>> migrations = getMigrations();
            if (!migrations.containsKey(Integer.valueOf(i10))) {
                return false;
            }
            Map<Integer, h2.b> mapEmptyMap = migrations.get(Integer.valueOf(i10));
            if (mapEmptyMap == null) {
                mapEmptyMap = kotlin.collections.a.emptyMap();
            }
            return mapEmptyMap.containsKey(Integer.valueOf(i11));
        }

        /* JADX WARN: Removed duplicated region for block: B:35:0x0066  */
        /* JADX WARN: Removed duplicated region for block: B:36:0x0068  */
        /*
            Code decompiled incorrectly, please refer to instructions dump.
            To view partially-correct code enable 'Show inconsistent code' option in preferences
        */
        public java.util.List<h2.b> findMigrationPath(int r10, int r11) {
            /*
                r9 = this;
                if (r10 != r11) goto L7
                java.util.List r10 = mf.k.emptyList()
                return r10
            L7:
                r0 = 0
                r1 = 1
                if (r11 <= r10) goto Ld
                r2 = 1
                goto Le
            Ld:
                r2 = 0
            Le:
                java.util.ArrayList r3 = new java.util.ArrayList
                r3.<init>()
            L13:
                if (r2 == 0) goto L18
                if (r10 >= r11) goto L1c
                goto L1a
            L18:
                if (r10 <= r11) goto L1c
            L1a:
                r4 = 1
                goto L1d
            L1c:
                r4 = 0
            L1d:
                if (r4 == 0) goto L7f
                java.util.LinkedHashMap r4 = r9.f4306a
                java.lang.Integer r5 = java.lang.Integer.valueOf(r10)
                java.lang.Object r4 = r4.get(r5)
                java.util.TreeMap r4 = (java.util.TreeMap) r4
                if (r4 != 0) goto L2e
                goto L7e
            L2e:
                if (r2 == 0) goto L35
                java.util.NavigableSet r5 = r4.descendingKeySet()
                goto L39
            L35:
                java.util.Set r5 = r4.keySet()
            L39:
                java.util.Iterator r5 = r5.iterator()
            L3d:
                boolean r6 = r5.hasNext()
                if (r6 == 0) goto L7b
                java.lang.Object r6 = r5.next()
                java.lang.Integer r6 = (java.lang.Integer) r6
                java.lang.String r7 = "targetVersion"
                if (r2 == 0) goto L5b
                int r8 = r10 + 1
                zf.i.checkNotNullExpressionValue(r6, r7)
                int r7 = r6.intValue()
                if (r8 > r7) goto L68
                if (r7 > r11) goto L68
                goto L66
            L5b:
                zf.i.checkNotNullExpressionValue(r6, r7)
                int r7 = r6.intValue()
                if (r11 > r7) goto L68
                if (r7 >= r10) goto L68
            L66:
                r7 = 1
                goto L69
            L68:
                r7 = 0
            L69:
                if (r7 == 0) goto L3d
                java.lang.Object r10 = r4.get(r6)
                zf.i.checkNotNull(r10)
                r3.add(r10)
                int r10 = r6.intValue()
                r4 = 1
                goto L7c
            L7b:
                r4 = 0
            L7c:
                if (r4 != 0) goto L13
            L7e:
                r3 = 0
            L7f:
                return r3
            */
            throw new UnsupportedOperationException("Method not decompiled: androidx.room.RoomDatabase.d.findMigrationPath(int, int):java.util.List");
        }

        public Map<Integer, Map<Integer, h2.b>> getMigrations() {
            return this.f4306a;
        }
    }

    /* compiled from: RoomDatabase.kt */
    public static abstract class e {
    }

    static {
        new c(null);
    }

    public RoomDatabase() {
        Map<String, Object> mapSynchronizedMap = Collections.synchronizedMap(new LinkedHashMap());
        i.checkNotNullExpressionValue(mapSynchronizedMap, "synchronizedMap(mutableMapOf())");
        this.f4282k = mapSynchronizedMap;
        this.f4283l = new LinkedHashMap();
    }

    public static final void access$internalEndTransaction(RoomDatabase roomDatabase) {
        roomDatabase.getOpenHelper().getWritableDatabase().endTransaction();
        if (roomDatabase.inTransaction()) {
            return;
        }
        roomDatabase.getInvalidationTracker().refreshVersionsAsync();
    }

    public static Object b(Class cls, f fVar) {
        if (cls.isInstance(fVar)) {
            return fVar;
        }
        if (fVar instanceof g2.d) {
            return b(cls, ((g2.d) fVar).getDelegate());
        }
        return null;
    }

    public static /* synthetic */ Cursor query$default(RoomDatabase roomDatabase, h hVar, CancellationSignal cancellationSignal, int i10, Object obj) {
        if (obj != null) {
            throw new UnsupportedOperationException("Super calls with default arguments not supported in this target, function: query");
        }
        if ((i10 & 2) != 0) {
            cancellationSignal = null;
        }
        return roomDatabase.query(hVar, cancellationSignal);
    }

    public final void a() {
        assertNotMainThread();
        k2.e writableDatabase = getOpenHelper().getWritableDatabase();
        getInvalidationTracker().syncTriggers$room_runtime_release(writableDatabase);
        if (writableDatabase.isWriteAheadLoggingEnabled()) {
            writableDatabase.beginTransactionNonExclusive();
        } else {
            writableDatabase.beginTransaction();
        }
    }

    public void assertNotMainThread() {
        if (!this.f4276e && !(!isMainThread$room_runtime_release())) {
            throw new IllegalStateException("Cannot access database on the main thread since it may potentially lock the UI for a long period of time.".toString());
        }
    }

    public void assertNotSuspendingTransaction() {
        if (!(inTransaction() || this.f4281j.get() == null)) {
            throw new IllegalStateException("Cannot access database on a different coroutine context inherited from a suspending transaction.".toString());
        }
    }

    public void beginTransaction() {
        assertNotMainThread();
        g2.a aVar = this.f4280i;
        if (aVar == null) {
            a();
        } else {
            aVar.executeRefCountingFunction(new l<k2.e, Object>() { // from class: androidx.room.RoomDatabase.beginTransaction.1
                {
                    super(1);
                }

                @Override // yf.l
                public final Object invoke(k2.e eVar) {
                    i.checkNotNullParameter(eVar, "it");
                    RoomDatabase.this.a();
                    return null;
                }
            });
        }
    }

    public k2.i compileStatement(String str) {
        i.checkNotNullParameter(str, "sql");
        assertNotMainThread();
        assertNotSuspendingTransaction();
        return getOpenHelper().getWritableDatabase().compileStatement(str);
    }

    public abstract j createInvalidationTracker();

    public abstract f createOpenHelper(g2.c cVar);

    public void endTransaction() {
        g2.a aVar = this.f4280i;
        if (aVar != null) {
            aVar.executeRefCountingFunction(new l<k2.e, Object>() { // from class: androidx.room.RoomDatabase.endTransaction.1
                {
                    super(1);
                }

                @Override // yf.l
                public final Object invoke(k2.e eVar) {
                    i.checkNotNullParameter(eVar, "it");
                    RoomDatabase.access$internalEndTransaction(RoomDatabase.this);
                    return null;
                }
            });
            return;
        }
        getOpenHelper().getWritableDatabase().endTransaction();
        if (inTransaction()) {
            return;
        }
        getInvalidationTracker().refreshVersionsAsync();
    }

    public List<h2.b> getAutoMigrations(Map<Class<? extends h2.a>, h2.a> map) {
        i.checkNotNullParameter(map, "autoMigrationSpecs");
        return k.emptyList();
    }

    public final Lock getCloseLock$room_runtime_release() {
        ReentrantReadWriteLock.ReadLock lock = this.f4279h.readLock();
        i.checkNotNullExpressionValue(lock, "readWriteLock.readLock()");
        return lock;
    }

    public j getInvalidationTracker() {
        return this.f4275d;
    }

    public f getOpenHelper() {
        f fVar = this.f4274c;
        if (fVar != null) {
            return fVar;
        }
        i.throwUninitializedPropertyAccessException("internalOpenHelper");
        return null;
    }

    public Executor getQueryExecutor() {
        Executor executor = this.f4273b;
        if (executor != null) {
            return executor;
        }
        i.throwUninitializedPropertyAccessException("internalQueryExecutor");
        return null;
    }

    public Set<Class<? extends h2.a>> getRequiredAutoMigrationSpecs() {
        return z.emptySet();
    }

    public Map<Class<?>, List<Class<?>>> getRequiredTypeConverters() {
        return kotlin.collections.a.emptyMap();
    }

    public boolean inTransaction() {
        return getOpenHelper().getWritableDatabase().inTransaction();
    }

    public void init(g2.c cVar) {
        i.checkNotNullParameter(cVar, "configuration");
        this.f4274c = createOpenHelper(cVar);
        Set<Class<? extends h2.a>> requiredAutoMigrationSpecs = getRequiredAutoMigrationSpecs();
        BitSet bitSet = new BitSet();
        Iterator<Class<? extends h2.a>> it = requiredAutoMigrationSpecs.iterator();
        while (true) {
            boolean zHasNext = it.hasNext();
            Map<Class<? extends h2.a>, h2.a> map = this.f4278g;
            int i10 = -1;
            if (zHasNext) {
                Class<? extends h2.a> next = it.next();
                int size = cVar.f12564p.size() - 1;
                List<h2.a> list = cVar.f12564p;
                if (size >= 0) {
                    while (true) {
                        int i11 = size - 1;
                        if (next.isAssignableFrom(list.get(size).getClass())) {
                            bitSet.set(size);
                            i10 = size;
                            break;
                        } else if (i11 < 0) {
                            break;
                        } else {
                            size = i11;
                        }
                    }
                }
                if (!(i10 >= 0)) {
                    throw new IllegalArgumentException(("A required auto migration spec (" + next.getCanonicalName() + ") is missing in the database configuration.").toString());
                }
                map.put(next, list.get(i10));
            } else {
                int size2 = cVar.f12564p.size() - 1;
                if (size2 >= 0) {
                    while (true) {
                        int i12 = size2 - 1;
                        if (!bitSet.get(size2)) {
                            throw new IllegalArgumentException("Unexpected auto migration specs found. Annotate AutoMigrationSpec implementation with @ProvidedAutoMigrationSpec annotation or remove this spec from the builder.".toString());
                        }
                        if (i12 < 0) {
                            break;
                        } else {
                            size2 = i12;
                        }
                    }
                }
                for (h2.b bVar : getAutoMigrations(map)) {
                    int i13 = bVar.f12906a;
                    d dVar = cVar.f12552d;
                    if (!dVar.contains(i13, bVar.f12907b)) {
                        dVar.addMigrations(bVar);
                    }
                }
                r rVar = (r) b(r.class, getOpenHelper());
                if (rVar != null) {
                    rVar.setDatabaseConfiguration(cVar);
                }
                g2.b bVar2 = (g2.b) b(g2.b.class, getOpenHelper());
                if (bVar2 != null) {
                    bVar2.getClass();
                    this.f4280i = null;
                    getInvalidationTracker().setAutoCloser$room_runtime_release(null);
                }
                getOpenHelper().setWriteAheadLoggingEnabled(cVar.f12555g == JournalMode.WRITE_AHEAD_LOGGING);
                this.f4277f = cVar.f12553e;
                this.f4273b = cVar.f12556h;
                new s(cVar.f12557i);
                this.f4276e = cVar.f12554f;
                Intent intent = cVar.f12558j;
                if (intent != null) {
                    String str = cVar.f12550b;
                    if (str == null) {
                        throw new IllegalArgumentException("Required value was null.".toString());
                    }
                    getInvalidationTracker().startMultiInstanceInvalidation$room_runtime_release(cVar.f12549a, str, intent);
                }
                Map<Class<?>, List<Class<?>>> requiredTypeConverters = getRequiredTypeConverters();
                BitSet bitSet2 = new BitSet();
                Iterator<Map.Entry<Class<?>, List<Class<?>>>> it2 = requiredTypeConverters.entrySet().iterator();
                while (true) {
                    boolean zHasNext2 = it2.hasNext();
                    List<Object> list2 = cVar.f12563o;
                    if (zHasNext2) {
                        Map.Entry<Class<?>, List<Class<?>>> next2 = it2.next();
                        Class<?> key = next2.getKey();
                        for (Class<?> cls : next2.getValue()) {
                            int size3 = list2.size() - 1;
                            if (size3 >= 0) {
                                while (true) {
                                    int i14 = size3 - 1;
                                    if (cls.isAssignableFrom(list2.get(size3).getClass())) {
                                        bitSet2.set(size3);
                                        break;
                                    } else if (i14 < 0) {
                                        break;
                                    } else {
                                        size3 = i14;
                                    }
                                }
                                size3 = -1;
                            } else {
                                size3 = -1;
                            }
                            if (!(size3 >= 0)) {
                                throw new IllegalArgumentException(("A required type converter (" + cls + ") for " + key.getCanonicalName() + " is missing in the database configuration.").toString());
                            }
                            this.f4283l.put(cls, list2.get(size3));
                        }
                    } else {
                        int size4 = list2.size() - 1;
                        if (size4 < 0) {
                            return;
                        }
                        while (true) {
                            int i15 = size4 - 1;
                            if (!bitSet2.get(size4)) {
                                throw new IllegalArgumentException("Unexpected type converter " + list2.get(size4) + ". Annotate TypeConverter class with @ProvidedTypeConverter annotation or remove this converter from the builder.");
                            }
                            if (i15 < 0) {
                                return;
                            } else {
                                size4 = i15;
                            }
                        }
                    }
                }
            }
        }
    }

    public void internalInitInvalidationTracker(k2.e eVar) {
        i.checkNotNullParameter(eVar, "db");
        getInvalidationTracker().internalInit$room_runtime_release(eVar);
    }

    public final boolean isMainThread$room_runtime_release() {
        return Looper.getMainLooper().getThread() == Thread.currentThread();
    }

    public boolean isOpen() {
        Boolean boolValueOf;
        boolean zIsOpen;
        g2.a aVar = this.f4280i;
        if (aVar != null) {
            zIsOpen = aVar.isActive();
        } else {
            k2.e eVar = this.f4272a;
            if (eVar == null) {
                boolValueOf = null;
                return i.areEqual(boolValueOf, Boolean.TRUE);
            }
            zIsOpen = eVar.isOpen();
        }
        boolValueOf = Boolean.valueOf(zIsOpen);
        return i.areEqual(boolValueOf, Boolean.TRUE);
    }

    public Cursor query(h hVar, CancellationSignal cancellationSignal) {
        i.checkNotNullParameter(hVar, "query");
        assertNotMainThread();
        assertNotSuspendingTransaction();
        return cancellationSignal != null ? getOpenHelper().getWritableDatabase().query(hVar, cancellationSignal) : getOpenHelper().getWritableDatabase().query(hVar);
    }

    public void runInTransaction(Runnable runnable) {
        i.checkNotNullParameter(runnable, "body");
        beginTransaction();
        try {
            runnable.run();
            setTransactionSuccessful();
        } finally {
            endTransaction();
        }
    }

    public void setTransactionSuccessful() {
        getOpenHelper().getWritableDatabase().setTransactionSuccessful();
    }

    public <V> V runInTransaction(Callable<V> callable) {
        i.checkNotNullParameter(callable, "body");
        beginTransaction();
        try {
            V vCall = callable.call();
            setTransactionSuccessful();
            return vCall;
        } finally {
            endTransaction();
        }
    }
}
