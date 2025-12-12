package d0;

/* compiled from: Pools.java */
/* loaded from: classes.dex */
public interface c<T> {
    T acquire();

    boolean release(T t10);

    void releaseAll(T[] tArr, int i10);
}
