package tg;

import kotlinx.coroutines.sync.MutexImpl;
import pg.b0;

/* compiled from: Mutex.kt */
/* loaded from: classes2.dex */
public final class b {

    /* renamed from: a, reason: collision with root package name */
    public static final b0 f19916a = new b0("NO_OWNER");

    static {
        new b0("ALREADY_LOCKED_BY_OWNER");
    }

    public static final a Mutex(boolean z10) {
        return new MutexImpl(z10);
    }

    public static /* synthetic */ a Mutex$default(boolean z10, int i10, Object obj) {
        if ((i10 & 1) != 0) {
            z10 = false;
        }
        return Mutex(z10);
    }
}
