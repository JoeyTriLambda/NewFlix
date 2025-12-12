package ne;

/* compiled from: MaybeObserver.java */
/* loaded from: classes2.dex */
public interface h<T> {
    void onComplete();

    void onError(Throwable th2);

    void onSubscribe(qe.b bVar);

    void onSuccess(T t10);
}
