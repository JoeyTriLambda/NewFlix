package kh;

import java.util.List;
import java.util.Set;
import kotlin.Pair;
import lf.h;
import org.koin.core.error.DefinitionOverrideException;
import org.koin.core.logger.Level;
import uh.c;
import zf.i;

/* compiled from: Koin.kt */
/* loaded from: classes2.dex */
public final class a {

    /* renamed from: a, reason: collision with root package name */
    public final c f15176a = new c(this);

    /* renamed from: b, reason: collision with root package name */
    public final uh.a f15177b = new uh.a(this);

    /* renamed from: c, reason: collision with root package name */
    public final uh.b f15178c = new uh.b(this);

    /* renamed from: d, reason: collision with root package name */
    public final oh.a f15179d = new oh.a(this);

    /* renamed from: e, reason: collision with root package name */
    public qh.b f15180e = new qh.a();

    public static /* synthetic */ void loadModules$default(a aVar, List list, boolean z10, int i10, Object obj) throws DefinitionOverrideException {
        if ((i10 & 2) != 0) {
            z10 = true;
        }
        aVar.loadModules(list, z10);
    }

    public final void close() {
        this.f15176a.close$koin_core();
        this.f15177b.close$koin_core();
        this.f15178c.close();
        this.f15179d.close();
    }

    public final void createEagerInstances() {
        qh.b bVar = this.f15180e;
        Level level = Level.DEBUG;
        if (bVar.isAt(level)) {
            bVar.display(level, "Eager instances ...");
        }
        long timeInNanoSeconds = yh.a.f22542a.getTimeInNanoSeconds();
        this.f15177b.createAllEagerInstances$koin_core();
        double dDoubleValue = ((Number) new Pair(h.f16056a, Double.valueOf((r0.getTimeInNanoSeconds() - timeInNanoSeconds) / 1000000.0d)).getSecond()).doubleValue();
        qh.b bVar2 = this.f15180e;
        String str = "Eager instances created in " + dDoubleValue + " ms";
        if (bVar2.isAt(level)) {
            bVar2.display(level, str);
        }
    }

    public final uh.a getInstanceRegistry() {
        return this.f15177b;
    }

    public final qh.b getLogger() {
        return this.f15180e;
    }

    public final c getScopeRegistry() {
        return this.f15176a;
    }

    public final void loadModules(List<rh.a> list, boolean z10) throws DefinitionOverrideException {
        i.checkNotNullParameter(list, "modules");
        Set<rh.a> setFlatten$default = rh.b.flatten$default(list, null, 2, null);
        this.f15177b.loadModules$koin_core(setFlatten$default, z10);
        this.f15176a.loadScopes(setFlatten$default);
    }

    public final void setupLogger(qh.b bVar) {
        i.checkNotNullParameter(bVar, "logger");
        this.f15180e = bVar;
    }
}
