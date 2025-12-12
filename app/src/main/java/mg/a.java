package mg;

import pg.c0;

/* compiled from: Channel.kt */
/* loaded from: classes2.dex */
public interface a<E> extends j<E>, i<E> {

    /* renamed from: k, reason: collision with root package name */
    public static final C0203a f16312k = C0203a.f16313a;

    /* compiled from: Channel.kt */
    /* renamed from: mg.a$a, reason: collision with other inner class name */
    public static final class C0203a {

        /* renamed from: a, reason: collision with root package name */
        public static final /* synthetic */ C0203a f16313a = new C0203a();

        /* renamed from: b, reason: collision with root package name */
        public static final int f16314b = c0.systemProp("kotlinx.coroutines.channels.defaultBuffer", 64, 1, 2147483646);

        public final int getCHANNEL_DEFAULT_CAPACITY$kotlinx_coroutines_core() {
            return f16314b;
        }
    }
}
