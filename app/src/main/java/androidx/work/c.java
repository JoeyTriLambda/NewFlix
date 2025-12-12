package androidx.work;

import android.content.Context;
import java.util.UUID;
import java.util.concurrent.Executor;
import w2.p;

/* compiled from: ListenableWorker.java */
/* loaded from: classes.dex */
public abstract class c {

    /* renamed from: b, reason: collision with root package name */
    public final Context f4509b;

    /* renamed from: m, reason: collision with root package name */
    public final WorkerParameters f4510m;

    /* renamed from: n, reason: collision with root package name */
    public volatile boolean f4511n;

    /* renamed from: o, reason: collision with root package name */
    public boolean f4512o;

    /* compiled from: ListenableWorker.java */
    public static abstract class a {

        /* compiled from: ListenableWorker.java */
        /* renamed from: androidx.work.c$a$a, reason: collision with other inner class name */
        public static final class C0048a extends a {

            /* renamed from: a, reason: collision with root package name */
            public final androidx.work.b f4513a;

            public C0048a() {
                this(androidx.work.b.f4506c);
            }

            public boolean equals(Object obj) {
                if (this == obj) {
                    return true;
                }
                if (obj == null || C0048a.class != obj.getClass()) {
                    return false;
                }
                return this.f4513a.equals(((C0048a) obj).f4513a);
            }

            public androidx.work.b getOutputData() {
                return this.f4513a;
            }

            public int hashCode() {
                return this.f4513a.hashCode() + (C0048a.class.getName().hashCode() * 31);
            }

            public String toString() {
                return "Failure {mOutputData=" + this.f4513a + '}';
            }

            public C0048a(androidx.work.b bVar) {
                this.f4513a = bVar;
            }
        }

        /* compiled from: ListenableWorker.java */
        public static final class b extends a {
            public boolean equals(Object obj) {
                if (this == obj) {
                    return true;
                }
                return obj != null && b.class == obj.getClass();
            }

            public int hashCode() {
                return b.class.getName().hashCode();
            }

            public String toString() {
                return "Retry";
            }
        }

        /* compiled from: ListenableWorker.java */
        /* renamed from: androidx.work.c$a$c, reason: collision with other inner class name */
        public static final class C0049c extends a {

            /* renamed from: a, reason: collision with root package name */
            public final androidx.work.b f4514a;

            public C0049c() {
                this(androidx.work.b.f4506c);
            }

            public boolean equals(Object obj) {
                if (this == obj) {
                    return true;
                }
                if (obj == null || C0049c.class != obj.getClass()) {
                    return false;
                }
                return this.f4514a.equals(((C0049c) obj).f4514a);
            }

            public androidx.work.b getOutputData() {
                return this.f4514a;
            }

            public int hashCode() {
                return this.f4514a.hashCode() + (C0049c.class.getName().hashCode() * 31);
            }

            public String toString() {
                return "Success {mOutputData=" + this.f4514a + '}';
            }

            public C0049c(androidx.work.b bVar) {
                this.f4514a = bVar;
            }
        }

        public static a failure() {
            return new C0048a();
        }

        public static a retry() {
            return new b();
        }

        public static a success() {
            return new C0049c();
        }

        public static a success(androidx.work.b bVar) {
            return new C0049c(bVar);
        }
    }

    public c(Context context, WorkerParameters workerParameters) {
        if (context == null) {
            throw new IllegalArgumentException("Application Context is null");
        }
        if (workerParameters == null) {
            throw new IllegalArgumentException("WorkerParameters is null");
        }
        this.f4509b = context;
        this.f4510m = workerParameters;
    }

    public final Context getApplicationContext() {
        return this.f4509b;
    }

    public Executor getBackgroundExecutor() {
        return this.f4510m.getBackgroundExecutor();
    }

    public e8.c<w2.c> getForegroundInfoAsync() {
        h3.a aVarCreate = h3.a.create();
        aVarCreate.setException(new IllegalStateException("Expedited WorkRequests require a ListenableWorker to provide an implementation for `getForegroundInfoAsync()`"));
        return aVarCreate;
    }

    public final UUID getId() {
        return this.f4510m.getId();
    }

    public final b getInputData() {
        return this.f4510m.getInputData();
    }

    public p getWorkerFactory() {
        return this.f4510m.getWorkerFactory();
    }

    public final boolean isStopped() {
        return this.f4511n;
    }

    public final boolean isUsed() {
        return this.f4512o;
    }

    public final void setUsed() {
        this.f4512o = true;
    }

    public abstract e8.c<a> startWork();

    public final void stop() {
        this.f4511n = true;
        onStopped();
    }

    public void onStopped() {
    }
}
