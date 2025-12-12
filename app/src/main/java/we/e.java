package we;

/* compiled from: BlockingLastObserver.java */
/* loaded from: classes2.dex */
public final class e<T> extends c<T> {
    @Override // ne.q
    public void onError(Throwable th2) {
        this.f21129b = null;
        this.f21130m = th2;
        countDown();
    }

    @Override // ne.q
    public void onNext(T t10) {
        this.f21129b = t10;
    }
}
