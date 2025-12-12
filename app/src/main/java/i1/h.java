package i1;

/* compiled from: SingleProcessDataStore.kt */
/* loaded from: classes.dex */
public final class h<T> extends j<T> {

    /* renamed from: a, reason: collision with root package name */
    public final Throwable f13106a;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public h(Throwable th2) {
        super(null);
        zf.i.checkNotNullParameter(th2, "readException");
        this.f13106a = th2;
    }

    public final Throwable getReadException() {
        return this.f13106a;
    }
}
