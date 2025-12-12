package w2;

import android.annotation.SuppressLint;

/* compiled from: Operation.java */
/* loaded from: classes.dex */
public interface i {

    /* renamed from: a, reason: collision with root package name */
    @SuppressLint({"SyntheticAccessor"})
    public static final a.c f20882a = new a.c();

    /* renamed from: b, reason: collision with root package name */
    @SuppressLint({"SyntheticAccessor"})
    public static final a.b f20883b = new a.b(0);

    /* compiled from: Operation.java */
    public static abstract class a {

        /* compiled from: Operation.java */
        /* renamed from: w2.i$a$a, reason: collision with other inner class name */
        public static final class C0303a extends a {

            /* renamed from: a, reason: collision with root package name */
            public final Throwable f20884a;

            public C0303a(Throwable th2) {
                this.f20884a = th2;
            }

            public Throwable getThrowable() {
                return this.f20884a;
            }

            public String toString() {
                return "FAILURE (" + this.f20884a.getMessage() + ")";
            }
        }

        /* compiled from: Operation.java */
        public static final class b extends a {
            public b(int i10) {
            }

            public String toString() {
                return "IN_PROGRESS";
            }
        }

        /* compiled from: Operation.java */
        public static final class c extends a {
            public String toString() {
                return "SUCCESS";
            }
        }
    }
}
