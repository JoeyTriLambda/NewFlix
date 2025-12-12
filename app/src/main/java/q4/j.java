package q4;

import java.util.concurrent.Executor;
import java.util.concurrent.Executors;

/* compiled from: ExecutionModule_ExecutorFactory.java */
/* loaded from: classes.dex */
public final class j implements s4.b<Executor> {

    /* compiled from: ExecutionModule_ExecutorFactory.java */
    public static final class a {

        /* renamed from: a, reason: collision with root package name */
        public static final j f17864a = new j();
    }

    public static j create() {
        return a.f17864a;
    }

    public static Executor executor() {
        return (Executor) s4.d.checkNotNull(new m(Executors.newSingleThreadExecutor()), "Cannot return null from a non-@Nullable @Provides method");
    }

    @Override // jf.a
    public Executor get() {
        return executor();
    }
}
