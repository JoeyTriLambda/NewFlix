package l8;

import java.util.Set;

/* compiled from: ComponentContainer.java */
/* loaded from: classes.dex */
public interface d {
    <T> T get(Class<T> cls);

    <T> T get(r<T> rVar);

    <T> h9.a<T> getDeferred(Class<T> cls);

    <T> h9.a<T> getDeferred(r<T> rVar);

    <T> h9.b<T> getProvider(Class<T> cls);

    <T> h9.b<T> getProvider(r<T> rVar);

    <T> Set<T> setOf(Class<T> cls);

    <T> Set<T> setOf(r<T> rVar);

    <T> h9.b<Set<T>> setOfProvider(r<T> rVar);
}
