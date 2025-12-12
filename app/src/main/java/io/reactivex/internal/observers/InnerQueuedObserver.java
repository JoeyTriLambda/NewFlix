package io.reactivex.internal.observers;

import cf.j;
import io.reactivex.internal.disposables.DisposableHelper;
import java.util.concurrent.atomic.AtomicReference;
import ne.q;
import qe.b;
import ve.f;
import we.i;

/* loaded from: classes2.dex */
public final class InnerQueuedObserver<T> extends AtomicReference<b> implements q<T>, b {
    private static final long serialVersionUID = -5417183359794346637L;

    /* renamed from: b, reason: collision with root package name */
    public final i<T> f13578b;

    /* renamed from: m, reason: collision with root package name */
    public final int f13579m;

    /* renamed from: n, reason: collision with root package name */
    public f<T> f13580n;

    /* renamed from: o, reason: collision with root package name */
    public volatile boolean f13581o;

    /* renamed from: p, reason: collision with root package name */
    public int f13582p;

    public InnerQueuedObserver(i<T> iVar, int i10) {
        this.f13578b = iVar;
        this.f13579m = i10;
    }

    @Override // qe.b
    public void dispose() {
        DisposableHelper.dispose(this);
    }

    public boolean isDone() {
        return this.f13581o;
    }

    @Override // ne.q
    public void onComplete() {
        this.f13578b.innerComplete(this);
    }

    @Override // ne.q
    public void onError(Throwable th2) {
        this.f13578b.innerError(this, th2);
    }

    @Override // ne.q
    public void onNext(T t10) {
        int i10 = this.f13582p;
        i<T> iVar = this.f13578b;
        if (i10 == 0) {
            iVar.innerNext(this, t10);
        } else {
            iVar.drain();
        }
    }

    @Override // ne.q
    public void onSubscribe(b bVar) {
        if (DisposableHelper.setOnce(this, bVar)) {
            if (bVar instanceof ve.b) {
                ve.b bVar2 = (ve.b) bVar;
                int iRequestFusion = bVar2.requestFusion(3);
                if (iRequestFusion == 1) {
                    this.f13582p = iRequestFusion;
                    this.f13580n = bVar2;
                    this.f13581o = true;
                    this.f13578b.innerComplete(this);
                    return;
                }
                if (iRequestFusion == 2) {
                    this.f13582p = iRequestFusion;
                    this.f13580n = bVar2;
                    return;
                }
            }
            this.f13580n = j.createQueue(-this.f13579m);
        }
    }

    public f<T> queue() {
        return this.f13580n;
    }

    public void setDone() {
        this.f13581o = true;
    }
}
