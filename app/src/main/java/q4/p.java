package q4;

import java.util.Set;

/* compiled from: TransportFactoryImpl.java */
/* loaded from: classes.dex */
public final class p implements n4.f {

    /* renamed from: a, reason: collision with root package name */
    public final Set<n4.b> f17868a;

    /* renamed from: b, reason: collision with root package name */
    public final o f17869b;

    /* renamed from: c, reason: collision with root package name */
    public final r f17870c;

    public p(Set<n4.b> set, o oVar, r rVar) {
        this.f17868a = set;
        this.f17869b = oVar;
        this.f17870c = rVar;
    }

    @Override // n4.f
    public <T> n4.e<T> getTransport(String str, Class<T> cls, n4.b bVar, n4.d<T, byte[]> dVar) {
        Set<n4.b> set = this.f17868a;
        if (set.contains(bVar)) {
            return new q(this.f17869b, str, bVar, dVar, this.f17870c);
        }
        throw new IllegalArgumentException(String.format("%s is not supported byt this factory. Supported encodings are: %s.", bVar, set));
    }
}
