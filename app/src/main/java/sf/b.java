package sf;

import kotlin.coroutines.CoroutineContext;

/* compiled from: ContinuationImpl.kt */
/* loaded from: classes2.dex */
public final class b implements qf.c<Object> {

    /* renamed from: b, reason: collision with root package name */
    public static final b f19280b = new b();

    @Override // qf.c
    public CoroutineContext getContext() {
        throw new IllegalStateException("This continuation is already complete".toString());
    }

    @Override // qf.c
    public void resumeWith(Object obj) {
        throw new IllegalStateException("This continuation is already complete".toString());
    }

    public String toString() {
        return "This continuation is already complete";
    }
}
