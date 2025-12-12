package l6;

/* compiled from: ConditionVariable.java */
/* loaded from: classes.dex */
public final class e {

    /* renamed from: a, reason: collision with root package name */
    public boolean f15853a;

    public synchronized void block() throws InterruptedException {
        while (!this.f15853a) {
            wait();
        }
    }

    public synchronized boolean close() {
        boolean z10;
        z10 = this.f15853a;
        this.f15853a = false;
        return z10;
    }

    public synchronized boolean open() {
        if (this.f15853a) {
            return false;
        }
        this.f15853a = true;
        notifyAll();
        return true;
    }
}
