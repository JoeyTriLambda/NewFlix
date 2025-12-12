package kotlin;

import java.io.Serializable;
import lf.e;
import zf.f;
import zf.i;

/* compiled from: LazyJVM.kt */
/* loaded from: classes2.dex */
final class SynchronizedLazyImpl<T> implements e<T>, Serializable {

    /* renamed from: b, reason: collision with root package name */
    public yf.a<? extends T> f15195b;

    /* renamed from: m, reason: collision with root package name */
    public volatile Object f15196m;

    /* renamed from: n, reason: collision with root package name */
    public final Object f15197n;

    public SynchronizedLazyImpl(yf.a<? extends T> aVar, Object obj) {
        i.checkNotNullParameter(aVar, "initializer");
        this.f15195b = aVar;
        this.f15196m = c8.i.f5250a;
        this.f15197n = obj == null ? this : obj;
    }

    @Override // lf.e
    public T getValue() {
        T tInvoke;
        T t10 = (T) this.f15196m;
        c8.i iVar = c8.i.f5250a;
        if (t10 != iVar) {
            return t10;
        }
        synchronized (this.f15197n) {
            tInvoke = (T) this.f15196m;
            if (tInvoke == iVar) {
                yf.a<? extends T> aVar = this.f15195b;
                i.checkNotNull(aVar);
                tInvoke = aVar.invoke();
                this.f15196m = tInvoke;
                this.f15195b = null;
            }
        }
        return tInvoke;
    }

    @Override // lf.e
    public boolean isInitialized() {
        return this.f15196m != c8.i.f5250a;
    }

    public String toString() {
        return isInitialized() ? String.valueOf(getValue()) : "Lazy value not initialized yet.";
    }

    public /* synthetic */ SynchronizedLazyImpl(yf.a aVar, Object obj, int i10, f fVar) {
        this(aVar, (i10 & 2) != 0 ? null : obj);
    }
}
