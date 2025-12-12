package kg;

/* compiled from: DefaultExecutor.kt */
/* loaded from: classes2.dex */
public final class j0 {

    /* renamed from: a, reason: collision with root package name */
    public static final kotlinx.coroutines.e f15115a;

    /* JADX WARN: Multi-variable type inference failed */
    static {
        kotlinx.coroutines.e eVar;
        if (pg.c0.systemProp("kotlinx.coroutines.main.delay", false)) {
            w1 main = s0.getMain();
            eVar = (pg.s.isMissing(main) || !(main instanceof kotlinx.coroutines.e)) ? kotlinx.coroutines.d.f15363s : (kotlinx.coroutines.e) main;
        } else {
            eVar = kotlinx.coroutines.d.f15363s;
        }
        f15115a = eVar;
    }

    public static final kotlinx.coroutines.e getDefaultDelay() {
        return f15115a;
    }
}
