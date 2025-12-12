package x4;

import java.util.concurrent.Executor;

/* compiled from: WorkInitializer_Factory.java */
/* loaded from: classes.dex */
public final class k implements s4.b<j> {

    /* renamed from: a, reason: collision with root package name */
    public final jf.a<Executor> f21553a;

    /* renamed from: b, reason: collision with root package name */
    public final jf.a<y4.d> f21554b;

    /* renamed from: c, reason: collision with root package name */
    public final jf.a<l> f21555c;

    /* renamed from: d, reason: collision with root package name */
    public final jf.a<z4.a> f21556d;

    public k(jf.a<Executor> aVar, jf.a<y4.d> aVar2, jf.a<l> aVar3, jf.a<z4.a> aVar4) {
        this.f21553a = aVar;
        this.f21554b = aVar2;
        this.f21555c = aVar3;
        this.f21556d = aVar4;
    }

    public static k create(jf.a<Executor> aVar, jf.a<y4.d> aVar2, jf.a<l> aVar3, jf.a<z4.a> aVar4) {
        return new k(aVar, aVar2, aVar3, aVar4);
    }

    public static j newInstance(Executor executor, y4.d dVar, l lVar, z4.a aVar) {
        return new j(executor, dVar, lVar, aVar);
    }

    @Override // jf.a
    public j get() {
        return newInstance(this.f21553a.get(), this.f21554b.get(), this.f21555c.get(), this.f21556d.get());
    }
}
