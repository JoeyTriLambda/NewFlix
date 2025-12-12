package k2;

import android.annotation.SuppressLint;

/* compiled from: SimpleSQLiteQuery.kt */
/* loaded from: classes.dex */
public final class a implements h {

    /* renamed from: n, reason: collision with root package name */
    public static final C0174a f14720n = new C0174a(null);

    /* renamed from: b, reason: collision with root package name */
    public final String f14721b;

    /* renamed from: m, reason: collision with root package name */
    public final Object[] f14722m;

    /* compiled from: SimpleSQLiteQuery.kt */
    /* renamed from: k2.a$a, reason: collision with other inner class name */
    public static final class C0174a {
        public C0174a(zf.f fVar) {
        }

        @SuppressLint({"SyntheticAccessor"})
        public final void bind(g gVar, Object[] objArr) {
            zf.i.checkNotNullParameter(gVar, "statement");
            if (objArr == null) {
                return;
            }
            int length = objArr.length;
            int i10 = 0;
            while (i10 < length) {
                Object obj = objArr[i10];
                i10++;
                if (obj == null) {
                    gVar.bindNull(i10);
                } else if (obj instanceof byte[]) {
                    gVar.bindBlob(i10, (byte[]) obj);
                } else if (obj instanceof Float) {
                    gVar.bindDouble(i10, ((Number) obj).floatValue());
                } else if (obj instanceof Double) {
                    gVar.bindDouble(i10, ((Number) obj).doubleValue());
                } else if (obj instanceof Long) {
                    gVar.bindLong(i10, ((Number) obj).longValue());
                } else if (obj instanceof Integer) {
                    gVar.bindLong(i10, ((Number) obj).intValue());
                } else if (obj instanceof Short) {
                    gVar.bindLong(i10, ((Number) obj).shortValue());
                } else if (obj instanceof Byte) {
                    gVar.bindLong(i10, ((Number) obj).byteValue());
                } else if (obj instanceof String) {
                    gVar.bindString(i10, (String) obj);
                } else {
                    if (!(obj instanceof Boolean)) {
                        throw new IllegalArgumentException("Cannot bind " + obj + " at index " + i10 + " Supported types: Null, ByteArray, Float, Double, Long, Int, Short, Byte, String");
                    }
                    gVar.bindLong(i10, ((Boolean) obj).booleanValue() ? 1L : 0L);
                }
            }
        }
    }

    public a(String str, Object[] objArr) {
        zf.i.checkNotNullParameter(str, "query");
        this.f14721b = str;
        this.f14722m = objArr;
    }

    @Override // k2.h
    public void bindTo(g gVar) {
        zf.i.checkNotNullParameter(gVar, "statement");
        f14720n.bind(gVar, this.f14722m);
    }

    @Override // k2.h
    public String getSql() {
        return this.f14721b;
    }

    /* JADX WARN: 'this' call moved to the top of the method (can break code semantics) */
    public a(String str) {
        this(str, null);
        zf.i.checkNotNullParameter(str, "query");
    }
}
