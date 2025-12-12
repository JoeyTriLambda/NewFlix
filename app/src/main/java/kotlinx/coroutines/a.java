package kotlinx.coroutines;

/* compiled from: EventLoop.kt */
/* loaded from: classes2.dex */
public final class a extends f {

    /* renamed from: s, reason: collision with root package name */
    public final Thread f15301s;

    public a(Thread thread) {
        this.f15301s = thread;
    }

    @Override // kotlinx.coroutines.g
    public Thread getThread() {
        return this.f15301s;
    }
}
