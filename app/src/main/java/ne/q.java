package ne;

/* compiled from: Observer.java */
/* loaded from: classes2.dex */
public interface q<T> {
    void onComplete();

    void onError(Throwable th2);

    void onNext(T t10);

    void onSubscribe(qe.b bVar);
}
