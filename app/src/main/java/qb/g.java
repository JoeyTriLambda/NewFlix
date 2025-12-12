package qb;

/* loaded from: classes2.dex */
public final class g implements ng.a {

    /* renamed from: b, reason: collision with root package name */
    public final /* synthetic */ ng.a f18057b;

    public g(ng.a aVar) {
        this.f18057b = aVar;
    }

    @Override // ng.a
    public final Object collect(ng.b bVar, qf.c cVar) {
        Object objCollect = this.f18057b.collect(new f(bVar), cVar);
        return objCollect == rf.a.getCOROUTINE_SUSPENDED() ? objCollect : lf.h.f16056a;
    }
}
