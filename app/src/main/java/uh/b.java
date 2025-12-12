package uh;

import java.util.Map;
import zf.i;

/* compiled from: PropertyRegistry.kt */
/* loaded from: classes2.dex */
public final class b {

    /* renamed from: a, reason: collision with root package name */
    public final Map<String, Object> f20382a;

    public b(kh.a aVar) {
        i.checkNotNullParameter(aVar, "_koin");
        this.f20382a = yh.b.f22543a.safeHashMap();
    }

    public final void close() {
        this.f20382a.clear();
    }
}
