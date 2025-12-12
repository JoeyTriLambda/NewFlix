package k6;

import android.content.Context;
import k6.d;

/* compiled from: DefaultDataSourceFactory.java */
/* loaded from: classes.dex */
public final class j implements d.a {

    /* renamed from: a, reason: collision with root package name */
    public final Context f14990a;

    /* renamed from: b, reason: collision with root package name */
    public final n<? super d> f14991b;

    /* renamed from: c, reason: collision with root package name */
    public final d.a f14992c;

    public j(Context context, n<? super d> nVar, d.a aVar) {
        this.f14990a = context.getApplicationContext();
        this.f14991b = nVar;
        this.f14992c = aVar;
    }

    @Override // k6.d.a
    public i createDataSource() {
        return new i(this.f14990a, this.f14991b, this.f14992c.createDataSource());
    }
}
