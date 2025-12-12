package mc;

import java.util.Map;
import k6.d;
import k6.k;
import k6.n;

/* compiled from: FFHttpDataSourceFactory.java */
/* loaded from: classes2.dex */
public final class b implements d.a {

    /* renamed from: a, reason: collision with root package name */
    public final String f16264a;

    /* renamed from: b, reason: collision with root package name */
    public final n<? super d> f16265b;

    /* renamed from: c, reason: collision with root package name */
    public final int f16266c;

    /* renamed from: d, reason: collision with root package name */
    public final int f16267d;

    /* renamed from: e, reason: collision with root package name */
    public final boolean f16268e;

    /* renamed from: f, reason: collision with root package name */
    public final Map<String, String> f16269f;

    public b(String str, n<? super d> nVar, int i10, int i11, boolean z10, Map<String, String> map) {
        this.f16269f = null;
        this.f16264a = str;
        this.f16265b = nVar;
        this.f16266c = i10;
        this.f16267d = i11;
        this.f16268e = z10;
        this.f16269f = map;
    }

    @Override // k6.d.a
    public k createDataSource() {
        k kVar = new k(this.f16264a, null, this.f16265b, this.f16266c, this.f16267d, this.f16268e, null);
        Map<String, String> map = this.f16269f;
        if (map != null) {
            for (Map.Entry<String, String> entry : map.entrySet()) {
                kVar.setRequestProperty(entry.getKey(), entry.getValue());
            }
        }
        return kVar;
    }
}
