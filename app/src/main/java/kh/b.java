package kh;

import java.util.List;
import kotlin.Pair;
import lf.h;
import org.koin.core.logger.Level;
import zf.f;
import zf.i;

/* compiled from: KoinApplication.kt */
/* loaded from: classes2.dex */
public final class b {

    /* renamed from: c, reason: collision with root package name */
    public static final a f15181c = new a(null);

    /* renamed from: a, reason: collision with root package name */
    public final kh.a f15182a;

    /* renamed from: b, reason: collision with root package name */
    public final boolean f15183b;

    /* compiled from: KoinApplication.kt */
    public static final class a {
        public a(f fVar) {
        }

        public final b init() {
            return new b(null);
        }
    }

    public /* synthetic */ b(f fVar) {
        this();
    }

    public final void createEagerInstances() {
        this.f15182a.createEagerInstances();
    }

    public final kh.a getKoin() {
        return this.f15182a;
    }

    public final b modules(List<rh.a> list) {
        i.checkNotNullParameter(list, "modules");
        kh.a aVar = this.f15182a;
        qh.b logger = aVar.getLogger();
        Level level = Level.INFO;
        boolean zIsAt = logger.isAt(level);
        boolean z10 = this.f15183b;
        if (zIsAt) {
            long timeInNanoSeconds = yh.a.f22542a.getTimeInNanoSeconds();
            aVar.loadModules(list, z10);
            double dDoubleValue = ((Number) new Pair(h.f16056a, Double.valueOf((r1.getTimeInNanoSeconds() - timeInNanoSeconds) / 1000000.0d)).getSecond()).doubleValue();
            int size = aVar.getInstanceRegistry().size();
            aVar.getLogger().display(level, "loaded " + size + " definitions in " + dDoubleValue + " ms");
        } else {
            aVar.loadModules(list, z10);
        }
        return this;
    }

    public b() {
        this.f15182a = new kh.a();
        this.f15183b = true;
    }
}
