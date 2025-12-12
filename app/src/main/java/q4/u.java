package q4;

/* compiled from: TransportRuntime_Factory.java */
/* loaded from: classes.dex */
public final class u implements s4.b<s> {

    /* renamed from: a, reason: collision with root package name */
    public final jf.a<a5.a> f17881a;

    /* renamed from: b, reason: collision with root package name */
    public final jf.a<a5.a> f17882b;

    /* renamed from: c, reason: collision with root package name */
    public final jf.a<w4.d> f17883c;

    /* renamed from: d, reason: collision with root package name */
    public final jf.a<x4.h> f17884d;

    /* renamed from: e, reason: collision with root package name */
    public final jf.a<x4.j> f17885e;

    public u(jf.a<a5.a> aVar, jf.a<a5.a> aVar2, jf.a<w4.d> aVar3, jf.a<x4.h> aVar4, jf.a<x4.j> aVar5) {
        this.f17881a = aVar;
        this.f17882b = aVar2;
        this.f17883c = aVar3;
        this.f17884d = aVar4;
        this.f17885e = aVar5;
    }

    public static u create(jf.a<a5.a> aVar, jf.a<a5.a> aVar2, jf.a<w4.d> aVar3, jf.a<x4.h> aVar4, jf.a<x4.j> aVar5) {
        return new u(aVar, aVar2, aVar3, aVar4, aVar5);
    }

    public static s newInstance(a5.a aVar, a5.a aVar2, w4.d dVar, x4.h hVar, x4.j jVar) {
        return new s(aVar, aVar2, dVar, hVar, jVar);
    }

    @Override // jf.a
    public s get() {
        return newInstance(this.f17881a.get(), this.f17882b.get(), this.f17883c.get(), this.f17884d.get(), this.f17885e.get());
    }
}
