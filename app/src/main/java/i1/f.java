package i1;

/* compiled from: SingleProcessDataStore.kt */
/* loaded from: classes.dex */
public final class f<T> extends j<T> {

    /* renamed from: a, reason: collision with root package name */
    public final Throwable f13105a;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public f(Throwable th2) {
        super(null);
        zf.i.checkNotNullParameter(th2, "finalException");
        this.f13105a = th2;
    }

    public final Throwable getFinalException() {
        return this.f13105a;
    }
}
