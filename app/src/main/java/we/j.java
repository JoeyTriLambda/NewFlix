package we;

import java.util.concurrent.atomic.AtomicInteger;
import ne.q;
import r.z;

/* compiled from: QueueDrainObserver.java */
/* loaded from: classes2.dex */
public abstract class j<T, U, V> extends z implements q<T>, cf.g<U, V> {

    /* renamed from: m, reason: collision with root package name */
    public final q<? super V> f21144m;

    /* renamed from: n, reason: collision with root package name */
    public final ve.e<U> f21145n;

    /* renamed from: o, reason: collision with root package name */
    public volatile boolean f21146o;

    /* renamed from: p, reason: collision with root package name */
    public volatile boolean f21147p;

    /* renamed from: q, reason: collision with root package name */
    public Throwable f21148q;

    public j(q<? super V> qVar, ve.e<U> eVar) {
        super(2);
        this.f21144m = qVar;
        this.f21145n = eVar;
    }

    public final boolean cancelled() {
        return this.f21146o;
    }

    public final boolean done() {
        return this.f21147p;
    }

    public final boolean enter() {
        return ((AtomicInteger) this.f18349b).getAndIncrement() == 0;
    }

    public final Throwable error() {
        return this.f21148q;
    }

    public final boolean fastEnter() {
        return ((AtomicInteger) this.f18349b).get() == 0 && ((AtomicInteger) this.f18349b).compareAndSet(0, 1);
    }

    public final void fastPathEmit(U u10, boolean z10, qe.b bVar) {
        int i10 = ((AtomicInteger) this.f18349b).get();
        q<? super V> qVar = this.f21144m;
        ve.e<U> eVar = this.f21145n;
        if (i10 == 0 && ((AtomicInteger) this.f18349b).compareAndSet(0, 1)) {
            accept(qVar, u10);
            if (leave(-1) == 0) {
                return;
            }
        } else {
            eVar.offer(u10);
            if (!enter()) {
                return;
            }
        }
        cf.j.drainLoop(eVar, qVar, z10, bVar, this);
    }

    public final void fastPathOrderedEmit(U u10, boolean z10, qe.b bVar) {
        int i10 = ((AtomicInteger) this.f18349b).get();
        q<? super V> qVar = this.f21144m;
        ve.e<U> eVar = this.f21145n;
        if (i10 != 0 || !((AtomicInteger) this.f18349b).compareAndSet(0, 1)) {
            eVar.offer(u10);
            if (!enter()) {
                return;
            }
        } else if (eVar.isEmpty()) {
            accept(qVar, u10);
            if (leave(-1) == 0) {
                return;
            }
        } else {
            eVar.offer(u10);
        }
        cf.j.drainLoop(eVar, qVar, z10, bVar, this);
    }

    public final int leave(int i10) {
        return ((AtomicInteger) this.f18349b).addAndGet(i10);
    }

    @Override // cf.g
    public void accept(q<? super V> qVar, U u10) {
    }
}
