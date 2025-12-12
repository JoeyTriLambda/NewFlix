package cf;

import java.util.concurrent.CountDownLatch;

/* compiled from: BlockingIgnoringReceiver.java */
/* loaded from: classes2.dex */
public final class d extends CountDownLatch implements se.f<Throwable>, se.a {

    /* renamed from: b, reason: collision with root package name */
    public Throwable f5275b;

    public d() {
        super(1);
    }

    @Override // se.a
    public void run() {
        countDown();
    }

    @Override // se.f
    public void accept(Throwable th2) {
        this.f5275b = th2;
        countDown();
    }
}
