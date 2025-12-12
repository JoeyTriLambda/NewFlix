package q4;

import android.content.Context;
import java.util.concurrent.Executor;
import q4.t;

/* compiled from: DaggerTransportRuntimeComponent.java */
/* loaded from: classes.dex */
public final class e extends t {

    /* renamed from: b, reason: collision with root package name */
    public jf.a<Executor> f17850b = s4.a.provider(j.create());

    /* renamed from: m, reason: collision with root package name */
    public s4.b f17851m;

    /* renamed from: n, reason: collision with root package name */
    public jf.a f17852n;

    /* renamed from: o, reason: collision with root package name */
    public y4.t f17853o;

    /* renamed from: p, reason: collision with root package name */
    public jf.a<String> f17854p;

    /* renamed from: q, reason: collision with root package name */
    public jf.a<y4.p> f17855q;

    /* renamed from: r, reason: collision with root package name */
    public w4.g f17856r;

    /* renamed from: s, reason: collision with root package name */
    public w4.c f17857s;

    /* renamed from: t, reason: collision with root package name */
    public x4.i f17858t;

    /* renamed from: u, reason: collision with root package name */
    public x4.k f17859u;

    /* renamed from: v, reason: collision with root package name */
    public jf.a<s> f17860v;

    /* compiled from: DaggerTransportRuntimeComponent.java */
    public static final class a implements t.a {

        /* renamed from: a, reason: collision with root package name */
        public Context f17861a;

        public t build() {
            s4.d.checkBuilderRequirement(this.f17861a, Context.class);
            return new e(this.f17861a);
        }

        /* renamed from: setApplicationContext, reason: merged with bridge method [inline-methods] */
        public a m236setApplicationContext(Context context) {
            this.f17861a = (Context) s4.d.checkNotNull(context);
            return this;
        }
    }

    public e(Context context) {
        s4.b bVarCreate = s4.c.create(context);
        this.f17851m = bVarCreate;
        this.f17852n = s4.a.provider(r4.j.create(this.f17851m, r4.h.create(bVarCreate, a5.b.create(), a5.c.create())));
        this.f17853o = y4.t.create(this.f17851m, y4.f.create(), y4.h.create());
        this.f17854p = s4.a.provider(y4.g.create(this.f17851m));
        this.f17855q = s4.a.provider(y4.q.create(a5.b.create(), a5.c.create(), y4.i.create(), this.f17853o, this.f17854p));
        w4.g gVarCreate = w4.g.create(this.f17851m, this.f17855q, w4.f.create(a5.b.create()), a5.c.create());
        this.f17856r = gVarCreate;
        jf.a<Executor> aVar = this.f17850b;
        jf.a aVar2 = this.f17852n;
        jf.a<y4.p> aVar3 = this.f17855q;
        this.f17857s = w4.c.create(aVar, aVar2, gVarCreate, aVar3, aVar3);
        s4.b bVar = this.f17851m;
        jf.a aVar4 = this.f17852n;
        jf.a<y4.p> aVar5 = this.f17855q;
        this.f17858t = x4.i.create(bVar, aVar4, aVar5, this.f17856r, this.f17850b, aVar5, a5.b.create(), a5.c.create(), this.f17855q);
        jf.a<Executor> aVar6 = this.f17850b;
        jf.a<y4.p> aVar7 = this.f17855q;
        this.f17859u = x4.k.create(aVar6, aVar7, this.f17856r, aVar7);
        this.f17860v = s4.a.provider(u.create(a5.b.create(), a5.c.create(), this.f17857s, this.f17858t, this.f17859u));
    }

    public static t.a builder() {
        return new a();
    }
}
