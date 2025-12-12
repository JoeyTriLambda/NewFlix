package cb;

import java.util.concurrent.ConcurrentHashMap;

/* compiled from: SignalsStorage.java */
/* loaded from: classes2.dex */
public final class g<T> {

    /* renamed from: a, reason: collision with root package name */
    public final ConcurrentHashMap f5260a = new ConcurrentHashMap();

    public T getQueryInfo(String str) {
        return (T) this.f5260a.get(str);
    }
}
