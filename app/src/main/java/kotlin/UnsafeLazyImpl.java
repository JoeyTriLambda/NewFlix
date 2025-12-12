package kotlin;

import java.io.Serializable;
import lf.e;
import zf.i;

/* compiled from: Lazy.kt */
/* loaded from: classes2.dex */
public final class UnsafeLazyImpl<T> implements e<T>, Serializable {

    /* renamed from: b, reason: collision with root package name */
    public yf.a<? extends T> f15201b;

    /* renamed from: m, reason: collision with root package name */
    public Object f15202m;

    public UnsafeLazyImpl(yf.a<? extends T> aVar) {
        i.checkNotNullParameter(aVar, "initializer");
        this.f15201b = aVar;
        this.f15202m = c8.i.f5250a;
    }

    @Override // lf.e
    public T getValue() {
        if (this.f15202m == c8.i.f5250a) {
            yf.a<? extends T> aVar = this.f15201b;
            i.checkNotNull(aVar);
            this.f15202m = aVar.invoke();
            this.f15201b = null;
        }
        return (T) this.f15202m;
    }

    @Override // lf.e
    public boolean isInitialized() {
        return this.f15202m != c8.i.f5250a;
    }

    public String toString() {
        return isInitialized() ? String.valueOf(getValue()) : "Lazy value not initialized yet.";
    }
}
