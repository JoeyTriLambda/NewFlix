package l8;

import com.google.firebase.components.DependencyException;
import java.util.Collections;
import java.util.HashSet;
import java.util.Set;

/* compiled from: RestrictedComponentContainer.java */
/* loaded from: classes.dex */
public final class s implements d {

    /* renamed from: a, reason: collision with root package name */
    public final Set<r<?>> f15989a;

    /* renamed from: b, reason: collision with root package name */
    public final Set<r<?>> f15990b;

    /* renamed from: c, reason: collision with root package name */
    public final Set<r<?>> f15991c;

    /* renamed from: d, reason: collision with root package name */
    public final Set<r<?>> f15992d;

    /* renamed from: e, reason: collision with root package name */
    public final Set<r<?>> f15993e;

    /* renamed from: f, reason: collision with root package name */
    public final Set<Class<?>> f15994f;

    /* renamed from: g, reason: collision with root package name */
    public final d f15995g;

    /* compiled from: RestrictedComponentContainer.java */
    public static class a implements f9.c {

        /* renamed from: a, reason: collision with root package name */
        public final f9.c f15996a;

        public a(Set<Class<?>> set, f9.c cVar) {
            this.f15996a = cVar;
        }
    }

    public s(b bVar, j jVar) {
        HashSet hashSet = new HashSet();
        HashSet hashSet2 = new HashSet();
        HashSet hashSet3 = new HashSet();
        HashSet hashSet4 = new HashSet();
        HashSet hashSet5 = new HashSet();
        for (l lVar : bVar.getDependencies()) {
            if (lVar.isDirectInjection()) {
                if (lVar.isSet()) {
                    hashSet4.add(lVar.getInterface());
                } else {
                    hashSet.add(lVar.getInterface());
                }
            } else if (lVar.isDeferred()) {
                hashSet3.add(lVar.getInterface());
            } else if (lVar.isSet()) {
                hashSet5.add(lVar.getInterface());
            } else {
                hashSet2.add(lVar.getInterface());
            }
        }
        if (!bVar.getPublishedEvents().isEmpty()) {
            hashSet.add(r.unqualified(f9.c.class));
        }
        this.f15989a = Collections.unmodifiableSet(hashSet);
        this.f15990b = Collections.unmodifiableSet(hashSet2);
        this.f15991c = Collections.unmodifiableSet(hashSet3);
        this.f15992d = Collections.unmodifiableSet(hashSet4);
        this.f15993e = Collections.unmodifiableSet(hashSet5);
        this.f15994f = bVar.getPublishedEvents();
        this.f15995g = jVar;
    }

    @Override // l8.d
    public <T> T get(Class<T> cls) {
        if (!this.f15989a.contains(r.unqualified(cls))) {
            throw new DependencyException(String.format("Attempting to request an undeclared dependency %s.", cls));
        }
        T t10 = (T) this.f15995g.get(cls);
        return !cls.equals(f9.c.class) ? t10 : (T) new a(this.f15994f, (f9.c) t10);
    }

    @Override // l8.d
    public <T> h9.a<T> getDeferred(Class<T> cls) {
        return getDeferred(r.unqualified(cls));
    }

    @Override // l8.d
    public <T> h9.b<T> getProvider(Class<T> cls) {
        return getProvider(r.unqualified(cls));
    }

    @Override // l8.d
    public final /* synthetic */ Set setOf(Class cls) {
        return c.e(this, cls);
    }

    @Override // l8.d
    public <T> h9.b<Set<T>> setOfProvider(r<T> rVar) {
        if (this.f15993e.contains(rVar)) {
            return this.f15995g.setOfProvider(rVar);
        }
        throw new DependencyException(String.format("Attempting to request an undeclared dependency Provider<Set<%s>>.", rVar));
    }

    @Override // l8.d
    public <T> h9.a<T> getDeferred(r<T> rVar) {
        if (this.f15991c.contains(rVar)) {
            return this.f15995g.getDeferred(rVar);
        }
        throw new DependencyException(String.format("Attempting to request an undeclared dependency Deferred<%s>.", rVar));
    }

    @Override // l8.d
    public <T> h9.b<T> getProvider(r<T> rVar) {
        if (this.f15990b.contains(rVar)) {
            return this.f15995g.getProvider(rVar);
        }
        throw new DependencyException(String.format("Attempting to request an undeclared dependency Provider<%s>.", rVar));
    }

    @Override // l8.d
    public <T> Set<T> setOf(r<T> rVar) {
        if (this.f15992d.contains(rVar)) {
            return this.f15995g.setOf(rVar);
        }
        throw new DependencyException(String.format("Attempting to request an undeclared dependency Set<%s>.", rVar));
    }

    @Override // l8.d
    public <T> T get(r<T> rVar) {
        if (this.f15989a.contains(rVar)) {
            return (T) this.f15995g.get(rVar);
        }
        throw new DependencyException(String.format("Attempting to request an undeclared dependency %s.", rVar));
    }
}
