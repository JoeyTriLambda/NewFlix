package w0;

import zf.i;

/* compiled from: Pools.kt */
/* loaded from: classes.dex */
public final class g<T> extends f<T> {

    /* renamed from: c, reason: collision with root package name */
    public final Object f20847c;

    public g(int i10) {
        super(i10);
        this.f20847c = new Object();
    }

    @Override // w0.f, w0.e
    public T acquire() {
        T t10;
        synchronized (this.f20847c) {
            t10 = (T) super.acquire();
        }
        return t10;
    }

    @Override // w0.f, w0.e
    public boolean release(T t10) {
        boolean zRelease;
        i.checkNotNullParameter(t10, "instance");
        synchronized (this.f20847c) {
            zRelease = super.release(t10);
        }
        return zRelease;
    }
}
