package rg;

import kg.i0;

/* compiled from: Tasks.kt */
/* loaded from: classes2.dex */
public final class j extends g {

    /* renamed from: n, reason: collision with root package name */
    public final Runnable f18960n;

    public j(Runnable runnable, long j10, h hVar) {
        super(j10, hVar);
        this.f18960n = runnable;
    }

    @Override // java.lang.Runnable
    public void run() {
        try {
            this.f18960n.run();
        } finally {
            this.f18958m.afterTask();
        }
    }

    public String toString() {
        StringBuilder sb2 = new StringBuilder("Task[");
        Runnable runnable = this.f18960n;
        sb2.append(i0.getClassSimpleName(runnable));
        sb2.append('@');
        sb2.append(i0.getHexAddress(runnable));
        sb2.append(", ");
        sb2.append(this.f18957b);
        sb2.append(", ");
        sb2.append(this.f18958m);
        sb2.append(']');
        return sb2.toString();
    }
}
