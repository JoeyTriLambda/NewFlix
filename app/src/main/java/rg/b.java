package rg;

/* compiled from: Dispatcher.kt */
/* loaded from: classes2.dex */
public final class b extends e {

    /* renamed from: n, reason: collision with root package name */
    public static final b f18954n = new b();

    public b() {
        super(k.f18963c, k.f18964d, k.f18965e, k.f18961a);
    }

    @Override // java.io.Closeable, java.lang.AutoCloseable
    public void close() {
        throw new UnsupportedOperationException("Dispatchers.Default cannot be closed");
    }

    @Override // kotlinx.coroutines.b
    public kotlinx.coroutines.b limitedParallelism(int i10) {
        pg.m.checkParallelism(i10);
        return i10 >= k.f18963c ? this : super.limitedParallelism(i10);
    }

    @Override // kotlinx.coroutines.b
    public String toString() {
        return "Dispatchers.Default";
    }
}
