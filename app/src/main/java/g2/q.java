package g2;

import java.util.Iterator;
import java.util.Map;
import java.util.TreeMap;

/* compiled from: RoomSQLiteQuery.kt */
/* loaded from: classes.dex */
public final class q implements k2.h, k2.g {

    /* renamed from: t, reason: collision with root package name */
    public static final a f12618t = new a(null);

    /* renamed from: u, reason: collision with root package name */
    public static final TreeMap<Integer, q> f12619u = new TreeMap<>();

    /* renamed from: b, reason: collision with root package name */
    public final int f12620b;

    /* renamed from: m, reason: collision with root package name */
    public volatile String f12621m;

    /* renamed from: n, reason: collision with root package name */
    public final long[] f12622n;

    /* renamed from: o, reason: collision with root package name */
    public final double[] f12623o;

    /* renamed from: p, reason: collision with root package name */
    public final String[] f12624p;

    /* renamed from: q, reason: collision with root package name */
    public final byte[][] f12625q;

    /* renamed from: r, reason: collision with root package name */
    public final int[] f12626r;

    /* renamed from: s, reason: collision with root package name */
    public int f12627s;

    /* compiled from: RoomSQLiteQuery.kt */
    public static final class a {
        public a(zf.f fVar) {
        }

        public final q acquire(String str, int i10) {
            zf.i.checkNotNullParameter(str, "query");
            TreeMap<Integer, q> treeMap = q.f12619u;
            synchronized (treeMap) {
                Map.Entry<Integer, q> entryCeilingEntry = treeMap.ceilingEntry(Integer.valueOf(i10));
                if (entryCeilingEntry == null) {
                    lf.h hVar = lf.h.f16056a;
                    q qVar = new q(i10, null);
                    qVar.init(str, i10);
                    return qVar;
                }
                treeMap.remove(entryCeilingEntry.getKey());
                q value = entryCeilingEntry.getValue();
                value.init(str, i10);
                zf.i.checkNotNullExpressionValue(value, "sqliteQuery");
                return value;
            }
        }

        public final void prunePoolLocked$room_runtime_release() {
            TreeMap<Integer, q> treeMap = q.f12619u;
            if (treeMap.size() <= 15) {
                return;
            }
            int size = treeMap.size() - 10;
            Iterator<Integer> it = treeMap.descendingKeySet().iterator();
            zf.i.checkNotNullExpressionValue(it, "queryPool.descendingKeySet().iterator()");
            while (true) {
                int i10 = size - 1;
                if (size <= 0) {
                    return;
                }
                it.next();
                it.remove();
                size = i10;
            }
        }
    }

    public q(int i10, zf.f fVar) {
        this.f12620b = i10;
        int i11 = i10 + 1;
        this.f12626r = new int[i11];
        this.f12622n = new long[i11];
        this.f12623o = new double[i11];
        this.f12624p = new String[i11];
        this.f12625q = new byte[i11][];
    }

    public static final q acquire(String str, int i10) {
        return f12618t.acquire(str, i10);
    }

    @Override // k2.g
    public void bindBlob(int i10, byte[] bArr) {
        zf.i.checkNotNullParameter(bArr, "value");
        this.f12626r[i10] = 5;
        this.f12625q[i10] = bArr;
    }

    @Override // k2.g
    public void bindDouble(int i10, double d10) {
        this.f12626r[i10] = 3;
        this.f12623o[i10] = d10;
    }

    @Override // k2.g
    public void bindLong(int i10, long j10) {
        this.f12626r[i10] = 2;
        this.f12622n[i10] = j10;
    }

    @Override // k2.g
    public void bindNull(int i10) {
        this.f12626r[i10] = 1;
    }

    @Override // k2.g
    public void bindString(int i10, String str) {
        zf.i.checkNotNullParameter(str, "value");
        this.f12626r[i10] = 4;
        this.f12624p[i10] = str;
    }

    @Override // k2.h
    public void bindTo(k2.g gVar) {
        zf.i.checkNotNullParameter(gVar, "statement");
        int argCount = getArgCount();
        if (1 > argCount) {
            return;
        }
        int i10 = 1;
        while (true) {
            int i11 = this.f12626r[i10];
            if (i11 == 1) {
                gVar.bindNull(i10);
            } else if (i11 == 2) {
                gVar.bindLong(i10, this.f12622n[i10]);
            } else if (i11 == 3) {
                gVar.bindDouble(i10, this.f12623o[i10]);
            } else if (i11 == 4) {
                String str = this.f12624p[i10];
                if (str == null) {
                    throw new IllegalArgumentException("Required value was null.".toString());
                }
                gVar.bindString(i10, str);
            } else if (i11 == 5) {
                byte[] bArr = this.f12625q[i10];
                if (bArr == null) {
                    throw new IllegalArgumentException("Required value was null.".toString());
                }
                gVar.bindBlob(i10, bArr);
            }
            if (i10 == argCount) {
                return;
            } else {
                i10++;
            }
        }
    }

    public int getArgCount() {
        return this.f12627s;
    }

    @Override // k2.h
    public String getSql() {
        String str = this.f12621m;
        if (str != null) {
            return str;
        }
        throw new IllegalStateException("Required value was null.".toString());
    }

    public final void init(String str, int i10) {
        zf.i.checkNotNullParameter(str, "query");
        this.f12621m = str;
        this.f12627s = i10;
    }

    public final void release() {
        TreeMap<Integer, q> treeMap = f12619u;
        synchronized (treeMap) {
            treeMap.put(Integer.valueOf(this.f12620b), this);
            f12618t.prunePoolLocked$room_runtime_release();
            lf.h hVar = lf.h.f16056a;
        }
    }

    @Override // java.io.Closeable, java.lang.AutoCloseable
    public void close() {
    }
}
