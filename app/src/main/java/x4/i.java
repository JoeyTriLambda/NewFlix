package x4;

import android.content.Context;
import java.util.concurrent.Executor;

/* compiled from: Uploader_Factory.java */
/* loaded from: classes.dex */
public final class i implements s4.b<h> {

    /* renamed from: a, reason: collision with root package name */
    public final jf.a<Context> f21540a;

    /* renamed from: b, reason: collision with root package name */
    public final jf.a<r4.d> f21541b;

    /* renamed from: c, reason: collision with root package name */
    public final jf.a<y4.d> f21542c;

    /* renamed from: d, reason: collision with root package name */
    public final jf.a<l> f21543d;

    /* renamed from: e, reason: collision with root package name */
    public final jf.a<Executor> f21544e;

    /* renamed from: f, reason: collision with root package name */
    public final jf.a<z4.a> f21545f;

    /* renamed from: g, reason: collision with root package name */
    public final jf.a<a5.a> f21546g;

    /* renamed from: h, reason: collision with root package name */
    public final jf.a<a5.a> f21547h;

    /* renamed from: i, reason: collision with root package name */
    public final jf.a<y4.c> f21548i;

    public i(jf.a<Context> aVar, jf.a<r4.d> aVar2, jf.a<y4.d> aVar3, jf.a<l> aVar4, jf.a<Executor> aVar5, jf.a<z4.a> aVar6, jf.a<a5.a> aVar7, jf.a<a5.a> aVar8, jf.a<y4.c> aVar9) {
        this.f21540a = aVar;
        this.f21541b = aVar2;
        this.f21542c = aVar3;
        this.f21543d = aVar4;
        this.f21544e = aVar5;
        this.f21545f = aVar6;
        this.f21546g = aVar7;
        this.f21547h = aVar8;
        this.f21548i = aVar9;
    }

    public static i create(jf.a<Context> aVar, jf.a<r4.d> aVar2, jf.a<y4.d> aVar3, jf.a<l> aVar4, jf.a<Executor> aVar5, jf.a<z4.a> aVar6, jf.a<a5.a> aVar7, jf.a<a5.a> aVar8, jf.a<y4.c> aVar9) {
        return new i(aVar, aVar2, aVar3, aVar4, aVar5, aVar6, aVar7, aVar8, aVar9);
    }

    public static h newInstance(Context context, r4.d dVar, y4.d dVar2, l lVar, Executor executor, z4.a aVar, a5.a aVar2, a5.a aVar3, y4.c cVar) {
        return new h(context, dVar, dVar2, lVar, executor, aVar, aVar2, aVar3, cVar);
    }

    @Override // jf.a
    public h get() {
        return newInstance(this.f21540a.get(), this.f21541b.get(), this.f21542c.get(), this.f21543d.get(), this.f21544e.get(), this.f21545f.get(), this.f21546g.get(), this.f21547h.get(), this.f21548i.get());
    }
}
