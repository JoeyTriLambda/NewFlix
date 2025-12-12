package r4;

import android.content.Context;

/* compiled from: CreationContextFactory_Factory.java */
/* loaded from: classes.dex */
public final class h implements s4.b<g> {

    /* renamed from: a, reason: collision with root package name */
    public final jf.a<Context> f18591a;

    /* renamed from: b, reason: collision with root package name */
    public final jf.a<a5.a> f18592b;

    /* renamed from: c, reason: collision with root package name */
    public final jf.a<a5.a> f18593c;

    public h(jf.a<Context> aVar, jf.a<a5.a> aVar2, jf.a<a5.a> aVar3) {
        this.f18591a = aVar;
        this.f18592b = aVar2;
        this.f18593c = aVar3;
    }

    public static h create(jf.a<Context> aVar, jf.a<a5.a> aVar2, jf.a<a5.a> aVar3) {
        return new h(aVar, aVar2, aVar3);
    }

    public static g newInstance(Context context, a5.a aVar, a5.a aVar2) {
        return new g(context, aVar, aVar2);
    }

    @Override // jf.a
    public g get() {
        return newInstance(this.f18591a.get(), this.f18592b.get(), this.f18593c.get());
    }
}
