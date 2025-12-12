package q4;

import q4.c;

/* compiled from: TransportImpl.java */
/* loaded from: classes.dex */
public final class q<T> implements n4.e<T> {

    /* renamed from: a, reason: collision with root package name */
    public final o f17871a;

    /* renamed from: b, reason: collision with root package name */
    public final String f17872b;

    /* renamed from: c, reason: collision with root package name */
    public final n4.b f17873c;

    /* renamed from: d, reason: collision with root package name */
    public final n4.d<T, byte[]> f17874d;

    /* renamed from: e, reason: collision with root package name */
    public final r f17875e;

    public q(o oVar, String str, n4.b bVar, n4.d<T, byte[]> dVar, r rVar) {
        this.f17871a = oVar;
        this.f17872b = str;
        this.f17873c = bVar;
        this.f17874d = dVar;
        this.f17875e = rVar;
    }

    /* JADX WARN: Multi-variable type inference failed */
    public void schedule(n4.c<T> cVar, n4.g gVar) {
        c.a aVar = (c.a) n.builder().setTransportContext(this.f17871a);
        if (cVar == 0) {
            aVar.getClass();
            throw new NullPointerException("Null event");
        }
        aVar.f17841c = cVar;
        c.a aVar2 = (c.a) aVar.setTransportName(this.f17872b);
        n4.d<T, byte[]> dVar = this.f17874d;
        if (dVar == null) {
            aVar2.getClass();
            throw new NullPointerException("Null transformer");
        }
        aVar2.f17842d = dVar;
        n4.b bVar = this.f17873c;
        if (bVar == null) {
            throw new NullPointerException("Null encoding");
        }
        aVar2.f17843e = bVar;
        ((s) this.f17875e).send(aVar2.build(), gVar);
    }

    public void send(n4.c<T> cVar) {
        schedule(cVar, new pd.a(9));
    }
}
