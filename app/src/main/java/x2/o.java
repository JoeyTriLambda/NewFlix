package x2;

import w2.i;

/* compiled from: OperationImpl.java */
/* loaded from: classes.dex */
public final class o implements w2.i {

    /* renamed from: c, reason: collision with root package name */
    public final androidx.lifecycle.r<i.a> f21456c = new androidx.lifecycle.r<>();

    /* renamed from: d, reason: collision with root package name */
    public final h3.a<i.a.c> f21457d = h3.a.create();

    public o() {
        markState(w2.i.f20883b);
    }

    public void markState(i.a aVar) {
        this.f21456c.postValue(aVar);
        boolean z10 = aVar instanceof i.a.c;
        h3.a<i.a.c> aVar2 = this.f21457d;
        if (z10) {
            aVar2.set((i.a.c) aVar);
        } else if (aVar instanceof i.a.C0303a) {
            aVar2.setException(((i.a.C0303a) aVar).getThrowable());
        }
    }
}
