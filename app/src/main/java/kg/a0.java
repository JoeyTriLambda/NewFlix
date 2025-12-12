package kg;

/* compiled from: CompletionState.kt */
/* loaded from: classes2.dex */
public final class a0 {

    /* renamed from: a, reason: collision with root package name */
    public final Object f15093a;

    /* renamed from: b, reason: collision with root package name */
    public final yf.l<Throwable, lf.h> f15094b;

    /* JADX WARN: Multi-variable type inference failed */
    public a0(Object obj, yf.l<? super Throwable, lf.h> lVar) {
        this.f15093a = obj;
        this.f15094b = lVar;
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof a0)) {
            return false;
        }
        a0 a0Var = (a0) obj;
        return zf.i.areEqual(this.f15093a, a0Var.f15093a) && zf.i.areEqual(this.f15094b, a0Var.f15094b);
    }

    public int hashCode() {
        Object obj = this.f15093a;
        return this.f15094b.hashCode() + ((obj == null ? 0 : obj.hashCode()) * 31);
    }

    public String toString() {
        return "CompletedWithCancellation(result=" + this.f15093a + ", onCancellation=" + this.f15094b + ')';
    }
}
