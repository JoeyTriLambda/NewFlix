package nh;

import zf.i;

/* compiled from: KoinDefinition.kt */
/* loaded from: classes2.dex */
public final class c<R> {

    /* renamed from: a, reason: collision with root package name */
    public final rh.a f16835a;

    /* renamed from: b, reason: collision with root package name */
    public final ph.c<R> f16836b;

    public c(rh.a aVar, ph.c<R> cVar) {
        i.checkNotNullParameter(aVar, "module");
        i.checkNotNullParameter(cVar, "factory");
        this.f16835a = aVar;
        this.f16836b = cVar;
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof c)) {
            return false;
        }
        c cVar = (c) obj;
        return i.areEqual(this.f16835a, cVar.f16835a) && i.areEqual(this.f16836b, cVar.f16836b);
    }

    public final ph.c<R> getFactory() {
        return this.f16836b;
    }

    public final rh.a getModule() {
        return this.f16835a;
    }

    public int hashCode() {
        return this.f16836b.hashCode() + (this.f16835a.hashCode() * 31);
    }

    public String toString() {
        return "KoinDefinition(module=" + this.f16835a + ", factory=" + this.f16836b + ')';
    }
}
