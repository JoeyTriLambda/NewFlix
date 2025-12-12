package kg;

/* compiled from: JobSupport.kt */
/* loaded from: classes2.dex */
public final class s extends l1 implements r {

    /* renamed from: p, reason: collision with root package name */
    public final t f15146p;

    public s(t tVar) {
        this.f15146p = tVar;
    }

    @Override // kg.r
    public boolean childCancelled(Throwable th2) {
        return getJob().childCancelled(th2);
    }

    @Override // kg.r
    public k1 getParent() {
        return getJob();
    }

    @Override // yf.l
    public /* bridge */ /* synthetic */ lf.h invoke(Throwable th2) {
        invoke2(th2);
        return lf.h.f16056a;
    }

    @Override // kg.b0
    /* renamed from: invoke, reason: avoid collision after fix types in other method */
    public void invoke2(Throwable th2) {
        this.f15146p.parentCancelled(getJob());
    }
}
