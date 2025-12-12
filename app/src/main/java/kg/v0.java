package kg;

/* compiled from: CancellableContinuation.kt */
/* loaded from: classes2.dex */
public final class v0 extends j {

    /* renamed from: b, reason: collision with root package name */
    public final u0 f15161b;

    public v0(u0 u0Var) {
        this.f15161b = u0Var;
    }

    @Override // yf.l
    public /* bridge */ /* synthetic */ lf.h invoke(Throwable th2) {
        invoke2(th2);
        return lf.h.f16056a;
    }

    public String toString() {
        return "DisposeOnCancel[" + this.f15161b + ']';
    }

    @Override // kg.k
    /* renamed from: invoke, reason: avoid collision after fix types in other method */
    public void invoke2(Throwable th2) {
        this.f15161b.dispose();
    }
}
