package kotlin;

import java.io.Serializable;
import java.util.concurrent.atomic.AtomicReferenceFieldUpdater;
import lf.e;
import zf.f;
import zf.i;

/* compiled from: LazyJVM.kt */
/* loaded from: classes2.dex */
final class SafePublicationLazyImpl<T> implements e<T>, Serializable {

    /* renamed from: n, reason: collision with root package name */
    public static final AtomicReferenceFieldUpdater<SafePublicationLazyImpl<?>, Object> f15192n;

    /* renamed from: b, reason: collision with root package name */
    public volatile yf.a<? extends T> f15193b;

    /* renamed from: m, reason: collision with root package name */
    public volatile Object f15194m;

    /* compiled from: LazyJVM.kt */
    public static final class a {
        public a(f fVar) {
        }
    }

    static {
        new a(null);
        f15192n = AtomicReferenceFieldUpdater.newUpdater(SafePublicationLazyImpl.class, Object.class, "m");
    }

    public SafePublicationLazyImpl(yf.a<? extends T> aVar) {
        i.checkNotNullParameter(aVar, "initializer");
        this.f15193b = aVar;
        this.f15194m = c8.i.f5250a;
    }

    @Override // lf.e
    public T getValue() {
        boolean z10;
        T t10 = (T) this.f15194m;
        c8.i iVar = c8.i.f5250a;
        if (t10 != iVar) {
            return t10;
        }
        yf.a<? extends T> aVar = this.f15193b;
        if (aVar != null) {
            T tInvoke = aVar.invoke();
            AtomicReferenceFieldUpdater<SafePublicationLazyImpl<?>, Object> atomicReferenceFieldUpdater = f15192n;
            while (true) {
                if (atomicReferenceFieldUpdater.compareAndSet(this, iVar, tInvoke)) {
                    z10 = true;
                    break;
                }
                if (atomicReferenceFieldUpdater.get(this) != iVar) {
                    z10 = false;
                    break;
                }
            }
            if (z10) {
                this.f15193b = null;
                return tInvoke;
            }
        }
        return (T) this.f15194m;
    }

    @Override // lf.e
    public boolean isInitialized() {
        return this.f15194m != c8.i.f5250a;
    }

    public String toString() {
        return isInitialized() ? String.valueOf(getValue()) : "Lazy value not initialized yet.";
    }
}
