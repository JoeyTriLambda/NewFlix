package bi;

import java.util.ArrayList;

/* compiled from: Timber.java */
/* loaded from: classes2.dex */
public final class a {

    /* renamed from: a, reason: collision with root package name */
    public static final ArrayList f4933a = new ArrayList();

    /* renamed from: b, reason: collision with root package name */
    public static volatile b[] f4934b = new b[0];

    /* renamed from: c, reason: collision with root package name */
    public static final C0060a f4935c = new C0060a();

    /* compiled from: Timber.java */
    public static abstract class b {
        public b() {
            new ThreadLocal();
        }

        public abstract void d(String str, Object... objArr);

        public abstract void e(String str, Object... objArr);

        public abstract void e(Throwable th2);

        public abstract void e(Throwable th2, String str, Object... objArr);

        public abstract void i(String str, Object... objArr);

        public abstract void w(String str, Object... objArr);
    }

    public static void d(String str, Object... objArr) {
        f4935c.d(str, objArr);
    }

    public static void e(String str, Object... objArr) {
        f4935c.e(str, objArr);
    }

    public static void i(String str, Object... objArr) {
        f4935c.i(str, objArr);
    }

    public static int treeCount() {
        int size;
        ArrayList arrayList = f4933a;
        synchronized (arrayList) {
            size = arrayList.size();
        }
        return size;
    }

    public static void w(String str, Object... objArr) {
        f4935c.w(str, objArr);
    }

    public static void e(Throwable th2, String str, Object... objArr) {
        f4935c.e(th2, str, objArr);
    }

    /* compiled from: Timber.java */
    /* renamed from: bi.a$a, reason: collision with other inner class name */
    public static class C0060a extends b {
        @Override // bi.a.b
        public void d(String str, Object... objArr) {
            for (b bVar : a.f4934b) {
                bVar.d(str, objArr);
            }
        }

        @Override // bi.a.b
        public void e(String str, Object... objArr) {
            for (b bVar : a.f4934b) {
                bVar.e(str, objArr);
            }
        }

        @Override // bi.a.b
        public void i(String str, Object... objArr) {
            for (b bVar : a.f4934b) {
                bVar.i(str, objArr);
            }
        }

        @Override // bi.a.b
        public void w(String str, Object... objArr) {
            for (b bVar : a.f4934b) {
                bVar.w(str, objArr);
            }
        }

        @Override // bi.a.b
        public void e(Throwable th2, String str, Object... objArr) {
            for (b bVar : a.f4934b) {
                bVar.e(th2, str, objArr);
            }
        }

        @Override // bi.a.b
        public void e(Throwable th2) {
            for (b bVar : a.f4934b) {
                bVar.e(th2);
            }
        }
    }

    public static void e(Throwable th2) {
        f4935c.e(th2);
    }
}
