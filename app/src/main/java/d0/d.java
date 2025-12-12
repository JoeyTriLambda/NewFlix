package d0;

/* compiled from: Pools.java */
/* loaded from: classes.dex */
public final class d<T> implements c<T> {

    /* renamed from: a, reason: collision with root package name */
    public final Object[] f10748a = new Object[256];

    /* renamed from: b, reason: collision with root package name */
    public int f10749b;

    @Override // d0.c
    public T acquire() {
        int i10 = this.f10749b;
        if (i10 <= 0) {
            return null;
        }
        int i11 = i10 - 1;
        Object[] objArr = this.f10748a;
        T t10 = (T) objArr[i11];
        objArr[i11] = null;
        this.f10749b = i10 - 1;
        return t10;
    }

    @Override // d0.c
    public boolean release(T t10) {
        int i10 = this.f10749b;
        Object[] objArr = this.f10748a;
        if (i10 >= objArr.length) {
            return false;
        }
        objArr[i10] = t10;
        this.f10749b = i10 + 1;
        return true;
    }

    @Override // d0.c
    public void releaseAll(T[] tArr, int i10) {
        if (i10 > tArr.length) {
            i10 = tArr.length;
        }
        for (int i11 = 0; i11 < i10; i11++) {
            T t10 = tArr[i11];
            int i12 = this.f10749b;
            Object[] objArr = this.f10748a;
            if (i12 < objArr.length) {
                objArr[i12] = t10;
                this.f10749b = i12 + 1;
            }
        }
    }
}
