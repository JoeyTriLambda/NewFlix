package we;

import io.reactivex.internal.disposables.DisposableHelper;
import ne.q;

/* compiled from: BasicFuseableObserver.java */
/* loaded from: classes2.dex */
public abstract class a<T, R> implements q<T>, ve.b<R> {

    /* renamed from: b, reason: collision with root package name */
    public final q<? super R> f21124b;

    /* renamed from: m, reason: collision with root package name */
    public qe.b f21125m;

    /* renamed from: n, reason: collision with root package name */
    public ve.b<T> f21126n;

    /* renamed from: o, reason: collision with root package name */
    public boolean f21127o;

    /* renamed from: p, reason: collision with root package name */
    public int f21128p;

    public a(q<? super R> qVar) {
        this.f21124b = qVar;
    }

    public boolean beforeDownstream() {
        return true;
    }

    @Override // ve.f
    public void clear() {
        this.f21126n.clear();
    }

    @Override // qe.b
    public void dispose() {
        this.f21125m.dispose();
    }

    public final void fail(Throwable th2) {
        re.a.throwIfFatal(th2);
        this.f21125m.dispose();
        onError(th2);
    }

    @Override // ve.f
    public boolean isEmpty() {
        return this.f21126n.isEmpty();
    }

    @Override // ve.f
    public final boolean offer(R r10) {
        throw new UnsupportedOperationException("Should not be called!");
    }

    @Override // ne.q
    public void onComplete() {
        if (this.f21127o) {
            return;
        }
        this.f21127o = true;
        this.f21124b.onComplete();
    }

    @Override // ne.q
    public void onError(Throwable th2) {
        if (this.f21127o) {
            ff.a.onError(th2);
        } else {
            this.f21127o = true;
            this.f21124b.onError(th2);
        }
    }

    @Override // ne.q
    public final void onSubscribe(qe.b bVar) {
        if (DisposableHelper.validate(this.f21125m, bVar)) {
            this.f21125m = bVar;
            if (bVar instanceof ve.b) {
                this.f21126n = (ve.b) bVar;
            }
            if (beforeDownstream()) {
                this.f21124b.onSubscribe(this);
                afterDownstream();
            }
        }
    }

    public final int transitiveBoundaryFusion(int i10) {
        ve.b<T> bVar = this.f21126n;
        if (bVar == null || (i10 & 4) != 0) {
            return 0;
        }
        int iRequestFusion = bVar.requestFusion(i10);
        if (iRequestFusion != 0) {
            this.f21128p = iRequestFusion;
        }
        return iRequestFusion;
    }

    public void afterDownstream() {
    }
}
