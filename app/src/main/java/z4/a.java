package z4;

/* compiled from: SynchronizationGuard.java */
/* loaded from: classes.dex */
public interface a {

    /* compiled from: SynchronizationGuard.java */
    /* renamed from: z4.a$a, reason: collision with other inner class name */
    public interface InterfaceC0331a<T> {
        T execute();
    }

    <T> T runCriticalSection(InterfaceC0331a<T> interfaceC0331a);
}
