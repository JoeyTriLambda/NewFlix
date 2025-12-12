package t0;

/* compiled from: CancellationSignal.java */
@Deprecated
/* loaded from: classes.dex */
public final class d {

    /* renamed from: a, reason: collision with root package name */
    public boolean f19358a;

    /* renamed from: b, reason: collision with root package name */
    public a f19359b;

    /* renamed from: c, reason: collision with root package name */
    public boolean f19360c;

    /* compiled from: CancellationSignal.java */
    public interface a {
        void onCancel();
    }

    public void cancel() {
        synchronized (this) {
            if (this.f19358a) {
                return;
            }
            this.f19358a = true;
            this.f19360c = true;
            a aVar = this.f19359b;
            if (aVar != null) {
                try {
                    aVar.onCancel();
                } catch (Throwable th2) {
                    synchronized (this) {
                        this.f19360c = false;
                        notifyAll();
                        throw th2;
                    }
                }
            }
            synchronized (this) {
                this.f19360c = false;
                notifyAll();
            }
        }
    }

    public void setOnCancelListener(a aVar) {
        synchronized (this) {
            while (this.f19360c) {
                try {
                    wait();
                } catch (InterruptedException unused) {
                }
            }
            if (this.f19359b == aVar) {
                return;
            }
            this.f19359b = aVar;
            if (this.f19358a && aVar != null) {
                aVar.onCancel();
            }
        }
    }
}
