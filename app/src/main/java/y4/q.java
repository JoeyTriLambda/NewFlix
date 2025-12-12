package y4;

/* compiled from: SQLiteEventStore_Factory.java */
/* loaded from: classes.dex */
public final class q implements s4.b<p> {

    /* renamed from: a, reason: collision with root package name */
    public final jf.a<a5.a> f21896a;

    /* renamed from: b, reason: collision with root package name */
    public final jf.a<a5.a> f21897b;

    /* renamed from: c, reason: collision with root package name */
    public final jf.a<e> f21898c;

    /* renamed from: d, reason: collision with root package name */
    public final jf.a<s> f21899d;

    /* renamed from: e, reason: collision with root package name */
    public final jf.a<String> f21900e;

    public q(jf.a<a5.a> aVar, jf.a<a5.a> aVar2, jf.a<e> aVar3, jf.a<s> aVar4, jf.a<String> aVar5) {
        this.f21896a = aVar;
        this.f21897b = aVar2;
        this.f21898c = aVar3;
        this.f21899d = aVar4;
        this.f21900e = aVar5;
    }

    public static q create(jf.a<a5.a> aVar, jf.a<a5.a> aVar2, jf.a<e> aVar3, jf.a<s> aVar4, jf.a<String> aVar5) {
        return new q(aVar, aVar2, aVar3, aVar4, aVar5);
    }

    public static p newInstance(a5.a aVar, a5.a aVar2, Object obj, Object obj2, jf.a<String> aVar3) {
        return new p(aVar, aVar2, (e) obj, (s) obj2, aVar3);
    }

    @Override // jf.a
    public p get() {
        return newInstance(this.f21896a.get(), this.f21897b.get(), this.f21898c.get(), this.f21899d.get(), this.f21900e);
    }
}
