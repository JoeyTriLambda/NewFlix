package gf;

import java.util.concurrent.Callable;
import ne.r;

/* compiled from: Schedulers.java */
/* loaded from: classes2.dex */
public final class a {

    /* renamed from: a, reason: collision with root package name */
    public static final r f12823a;

    /* renamed from: b, reason: collision with root package name */
    public static final bf.g f12824b;

    /* renamed from: c, reason: collision with root package name */
    public static final r f12825c;

    /* compiled from: Schedulers.java */
    /* renamed from: gf.a$a, reason: collision with other inner class name */
    public static final class C0157a {

        /* renamed from: a, reason: collision with root package name */
        public static final bf.a f12826a = new bf.a();
    }

    /* compiled from: Schedulers.java */
    public static final class b implements Callable<r> {
        @Override // java.util.concurrent.Callable
        public r call() throws Exception {
            return C0157a.f12826a;
        }
    }

    /* compiled from: Schedulers.java */
    public static final class c implements Callable<r> {
        @Override // java.util.concurrent.Callable
        public r call() throws Exception {
            return d.f12827a;
        }
    }

    /* compiled from: Schedulers.java */
    public static final class d {

        /* renamed from: a, reason: collision with root package name */
        public static final bf.c f12827a = new bf.c();
    }

    /* compiled from: Schedulers.java */
    public static final class e {

        /* renamed from: a, reason: collision with root package name */
        public static final bf.d f12828a = new bf.d();
    }

    /* compiled from: Schedulers.java */
    public static final class f implements Callable<r> {
        @Override // java.util.concurrent.Callable
        public r call() throws Exception {
            return e.f12828a;
        }
    }

    /* compiled from: Schedulers.java */
    public static final class g {

        /* renamed from: a, reason: collision with root package name */
        public static final io.reactivex.internal.schedulers.b f12829a = new io.reactivex.internal.schedulers.b();
    }

    /* compiled from: Schedulers.java */
    public static final class h implements Callable<r> {
        @Override // java.util.concurrent.Callable
        public r call() throws Exception {
            return g.f12829a;
        }
    }

    static {
        ff.a.initSingleScheduler(new h());
        f12823a = ff.a.initComputationScheduler(new b());
        ff.a.initIoScheduler(new c());
        f12824b = bf.g.instance();
        f12825c = ff.a.initNewThreadScheduler(new f());
    }

    public static r computation() {
        return ff.a.onComputationScheduler(f12823a);
    }

    public static r newThread() {
        return ff.a.onNewThreadScheduler(f12825c);
    }

    public static r trampoline() {
        return f12824b;
    }
}
