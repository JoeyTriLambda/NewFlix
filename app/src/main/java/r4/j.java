package r4;

import android.content.Context;

/* compiled from: MetadataBackendRegistry_Factory.java */
/* loaded from: classes.dex */
public final class j implements s4.b<i> {

    /* renamed from: a, reason: collision with root package name */
    public final jf.a<Context> f18599a;

    /* renamed from: b, reason: collision with root package name */
    public final jf.a<g> f18600b;

    public j(jf.a<Context> aVar, jf.a<g> aVar2) {
        this.f18599a = aVar;
        this.f18600b = aVar2;
    }

    public static j create(jf.a<Context> aVar, jf.a<g> aVar2) {
        return new j(aVar, aVar2);
    }

    public static i newInstance(Context context, Object obj) {
        return new i(context, (g) obj);
    }

    @Override // jf.a
    public i get() {
        return newInstance(this.f18599a.get(), this.f18600b.get());
    }
}
