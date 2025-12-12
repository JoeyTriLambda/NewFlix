package w2;

import android.util.Log;

/* compiled from: Logger.java */
/* loaded from: classes.dex */
public abstract class g {

    /* renamed from: a, reason: collision with root package name */
    public static final Object f20878a = new Object();

    /* renamed from: b, reason: collision with root package name */
    public static volatile g f20879b;

    public g(int i10) {
    }

    public static g get() {
        g gVar;
        synchronized (f20878a) {
            if (f20879b == null) {
                f20879b = new a(3);
            }
            gVar = f20879b;
        }
        return gVar;
    }

    public static void setLogger(g gVar) {
        synchronized (f20878a) {
            f20879b = gVar;
        }
    }

    public static String tagWithPrefix(String str) {
        int length = str.length();
        StringBuilder sbQ = ac.c.q(23, "WM-");
        if (length >= 20) {
            sbQ.append(str.substring(0, 20));
        } else {
            sbQ.append(str);
        }
        return sbQ.toString();
    }

    public abstract void debug(String str, String str2);

    public abstract void debug(String str, String str2, Throwable th2);

    public abstract void error(String str, String str2);

    public abstract void error(String str, String str2, Throwable th2);

    public abstract void info(String str, String str2);

    public abstract void info(String str, String str2, Throwable th2);

    public abstract void verbose(String str, String str2);

    public abstract void warning(String str, String str2);

    public abstract void warning(String str, String str2, Throwable th2);

    /* compiled from: Logger.java */
    public static class a extends g {

        /* renamed from: c, reason: collision with root package name */
        public final int f20880c;

        public a(int i10) {
            super(i10);
            this.f20880c = i10;
        }

        @Override // w2.g
        public void debug(String str, String str2) {
            if (this.f20880c <= 3) {
                Log.d(str, str2);
            }
        }

        @Override // w2.g
        public void error(String str, String str2) {
            if (this.f20880c <= 6) {
                Log.e(str, str2);
            }
        }

        @Override // w2.g
        public void info(String str, String str2) {
            if (this.f20880c <= 4) {
                Log.i(str, str2);
            }
        }

        @Override // w2.g
        public void verbose(String str, String str2) {
            if (this.f20880c <= 2) {
                Log.v(str, str2);
            }
        }

        @Override // w2.g
        public void warning(String str, String str2) {
            if (this.f20880c <= 5) {
                Log.w(str, str2);
            }
        }

        @Override // w2.g
        public void debug(String str, String str2, Throwable th2) {
            if (this.f20880c <= 3) {
                Log.d(str, str2, th2);
            }
        }

        @Override // w2.g
        public void error(String str, String str2, Throwable th2) {
            if (this.f20880c <= 6) {
                Log.e(str, str2, th2);
            }
        }

        @Override // w2.g
        public void info(String str, String str2, Throwable th2) {
            if (this.f20880c <= 4) {
                Log.i(str, str2, th2);
            }
        }

        @Override // w2.g
        public void warning(String str, String str2, Throwable th2) {
            if (this.f20880c <= 5) {
                Log.w(str, str2, th2);
            }
        }
    }
}
