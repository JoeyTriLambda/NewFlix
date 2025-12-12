package y4;

import android.content.Context;

/* compiled from: SchemaManager_Factory.java */
/* loaded from: classes.dex */
public final class t implements s4.b<s> {

    /* renamed from: a, reason: collision with root package name */
    public final jf.a<Context> f21907a;

    /* renamed from: b, reason: collision with root package name */
    public final jf.a<String> f21908b;

    /* renamed from: c, reason: collision with root package name */
    public final jf.a<Integer> f21909c;

    public t(jf.a<Context> aVar, jf.a<String> aVar2, jf.a<Integer> aVar3) {
        this.f21907a = aVar;
        this.f21908b = aVar2;
        this.f21909c = aVar3;
    }

    public static t create(jf.a<Context> aVar, jf.a<String> aVar2, jf.a<Integer> aVar3) {
        return new t(aVar, aVar2, aVar3);
    }

    public static s newInstance(Context context, String str, int i10) {
        return new s(context, str, i10);
    }

    @Override // jf.a
    public s get() {
        return newInstance(this.f21907a.get(), this.f21908b.get(), this.f21909c.get().intValue());
    }
}
