package kg;

/* compiled from: CancellableContinuationImpl.kt */
/* loaded from: classes2.dex */
public final class h1 extends j {

    /* renamed from: b, reason: collision with root package name */
    public final yf.l<Throwable, lf.h> f15109b;

    /* JADX WARN: Multi-variable type inference failed */
    public h1(yf.l<? super Throwable, lf.h> lVar) {
        this.f15109b = lVar;
    }

    @Override // yf.l
    public /* bridge */ /* synthetic */ lf.h invoke(Throwable th2) {
        invoke2(th2);
        return lf.h.f16056a;
    }

    public String toString() {
        return "InvokeOnCancel[" + i0.getClassSimpleName(this.f15109b) + '@' + i0.getHexAddress(this) + ']';
    }

    @Override // kg.k
    /* renamed from: invoke, reason: avoid collision after fix types in other method */
    public void invoke2(Throwable th2) {
        this.f15109b.invoke(th2);
    }
}
