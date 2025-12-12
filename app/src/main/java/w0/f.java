package w0;

import zf.i;

/* compiled from: Pools.kt */
/* loaded from: classes.dex */
public class f<T> implements e<T> {

    /* renamed from: a, reason: collision with root package name */
    public final Object[] f20845a;

    /* renamed from: b, reason: collision with root package name */
    public int f20846b;

    public f(int i10) {
        if (!(i10 > 0)) {
            throw new IllegalArgumentException("The max pool size must be > 0".toString());
        }
        this.f20845a = new Object[i10];
    }

    @Override // w0.e
    public T acquire() {
        int i10 = this.f20846b;
        if (i10 <= 0) {
            return null;
        }
        int i11 = i10 - 1;
        Object[] objArr = this.f20845a;
        T t10 = (T) objArr[i11];
        i.checkNotNull(t10, "null cannot be cast to non-null type T of androidx.core.util.Pools.SimplePool");
        objArr[i11] = null;
        this.f20846b--;
        return t10;
    }

    @Override // w0.e
    public boolean release(T t10) {
        Object[] objArr;
        boolean z10;
        i.checkNotNullParameter(t10, "instance");
        int i10 = this.f20846b;
        int i11 = 0;
        while (true) {
            objArr = this.f20845a;
            if (i11 >= i10) {
                z10 = false;
                break;
            }
            if (objArr[i11] == t10) {
                z10 = true;
                break;
            }
            i11++;
        }
        if (!(!z10)) {
            throw new IllegalStateException("Already in the pool!".toString());
        }
        int i12 = this.f20846b;
        if (i12 >= objArr.length) {
            return false;
        }
        objArr[i12] = t10;
        this.f20846b = i12 + 1;
        return true;
    }
}
