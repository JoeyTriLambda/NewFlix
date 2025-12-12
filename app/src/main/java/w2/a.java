package w2;

import java.util.concurrent.ThreadFactory;
import java.util.concurrent.atomic.AtomicInteger;

/* compiled from: Configuration.java */
/* loaded from: classes.dex */
public final class a implements ThreadFactory {

    /* renamed from: b, reason: collision with root package name */
    public final AtomicInteger f20861b = new AtomicInteger(0);

    /* renamed from: m, reason: collision with root package name */
    public final /* synthetic */ boolean f20862m;

    public a(boolean z10) {
        this.f20862m = z10;
    }

    @Override // java.util.concurrent.ThreadFactory
    public Thread newThread(Runnable runnable) {
        StringBuilder sbR = ac.c.r(this.f20862m ? "WM.task-" : "androidx.work-");
        sbR.append(this.f20861b.incrementAndGet());
        return new Thread(runnable, sbR.toString());
    }
}
