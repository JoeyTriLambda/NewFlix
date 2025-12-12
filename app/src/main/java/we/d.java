package we;

/* compiled from: BlockingFirstObserver.java */
/* loaded from: classes2.dex */
public final class d<T> extends c<T> {
    @Override // ne.q
    public void onError(Throwable th2) {
        if (this.f21129b == null) {
            this.f21130m = th2;
        }
        countDown();
    }

    @Override // ne.q
    public void onNext(T t10) {
        if (this.f21129b == null) {
            this.f21129b = t10;
            this.f21131n.dispose();
            countDown();
        }
    }
}
