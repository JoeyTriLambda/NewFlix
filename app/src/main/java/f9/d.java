package f9;

import java.util.concurrent.Executor;

/* compiled from: Subscriber.java */
/* loaded from: classes.dex */
public interface d {
    <T> void subscribe(Class<T> cls, Executor executor, b<? super T> bVar);
}
