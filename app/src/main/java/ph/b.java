package ph;

import org.koin.core.scope.Scope;
import zf.f;
import zf.i;

/* compiled from: InstanceContext.kt */
/* loaded from: classes2.dex */
public final class b {

    /* renamed from: a, reason: collision with root package name */
    public final qh.b f17735a;

    /* renamed from: b, reason: collision with root package name */
    public final Scope f17736b;

    /* renamed from: c, reason: collision with root package name */
    public final sh.a f17737c;

    public b(qh.b bVar, Scope scope, sh.a aVar) {
        i.checkNotNullParameter(bVar, "logger");
        i.checkNotNullParameter(scope, "scope");
        this.f17735a = bVar;
        this.f17736b = scope;
        this.f17737c = aVar;
    }

    public final qh.b getLogger() {
        return this.f17735a;
    }

    public final sh.a getParameters() {
        return this.f17737c;
    }

    public final Scope getScope() {
        return this.f17736b;
    }

    public /* synthetic */ b(qh.b bVar, Scope scope, sh.a aVar, int i10, f fVar) {
        this(bVar, scope, (i10 & 4) != 0 ? null : aVar);
    }
}
