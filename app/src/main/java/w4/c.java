package w4;

import java.util.concurrent.Executor;
import x4.l;

/* compiled from: DefaultScheduler_Factory.java */
/* loaded from: classes.dex */
public final class c implements s4.b<b> {

    /* renamed from: a, reason: collision with root package name */
    public final jf.a<Executor> f20943a;

    /* renamed from: b, reason: collision with root package name */
    public final jf.a<r4.d> f20944b;

    /* renamed from: c, reason: collision with root package name */
    public final jf.a<l> f20945c;

    /* renamed from: d, reason: collision with root package name */
    public final jf.a<y4.d> f20946d;

    /* renamed from: e, reason: collision with root package name */
    public final jf.a<z4.a> f20947e;

    public c(jf.a<Executor> aVar, jf.a<r4.d> aVar2, jf.a<l> aVar3, jf.a<y4.d> aVar4, jf.a<z4.a> aVar5) {
        this.f20943a = aVar;
        this.f20944b = aVar2;
        this.f20945c = aVar3;
        this.f20946d = aVar4;
        this.f20947e = aVar5;
    }

    public static c create(jf.a<Executor> aVar, jf.a<r4.d> aVar2, jf.a<l> aVar3, jf.a<y4.d> aVar4, jf.a<z4.a> aVar5) {
        return new c(aVar, aVar2, aVar3, aVar4, aVar5);
    }

    public static b newInstance(Executor executor, r4.d dVar, l lVar, y4.d dVar2, z4.a aVar) {
        return new b(executor, dVar, lVar, dVar2, aVar);
    }

    @Override // jf.a
    public b get() {
        return newInstance(this.f20943a.get(), this.f20944b.get(), this.f20945c.get(), this.f20946d.get(), this.f20947e.get());
    }
}
