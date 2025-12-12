package y4;

import android.content.Context;

/* compiled from: EventStoreModule_PackageNameFactory.java */
/* loaded from: classes.dex */
public final class g implements s4.b<String> {

    /* renamed from: a, reason: collision with root package name */
    public final jf.a<Context> f21871a;

    public g(jf.a<Context> aVar) {
        this.f21871a = aVar;
    }

    public static g create(jf.a<Context> aVar) {
        return new g(aVar);
    }

    public static String packageName(Context context) {
        return (String) s4.d.checkNotNull(context.getPackageName(), "Cannot return null from a non-@Nullable @Provides method");
    }

    @Override // jf.a
    public String get() {
        return packageName(this.f21871a.get());
    }
}
