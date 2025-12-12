package qb;

/* loaded from: classes2.dex */
public final class e implements ng.a {

    /* renamed from: b, reason: collision with root package name */
    public final /* synthetic */ ng.a f18055b;

    public e(ng.a aVar) {
        this.f18055b = aVar;
    }

    @Override // ng.a
    public final Object collect(ng.b bVar, qf.c cVar) {
        Object objCollect = this.f18055b.collect(new d(bVar), cVar);
        return objCollect == rf.a.getCOROUTINE_SUSPENDED() ? objCollect : lf.h.f16056a;
    }
}
