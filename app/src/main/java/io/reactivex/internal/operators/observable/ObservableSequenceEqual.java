package io.reactivex.internal.operators.observable;

import io.reactivex.internal.disposables.ArrayCompositeDisposable;
import java.util.concurrent.atomic.AtomicInteger;
import ne.k;
import ne.o;
import ne.q;
import qe.b;
import se.d;
import ue.a;

/* loaded from: classes2.dex */
public final class ObservableSequenceEqual<T> extends k<Boolean> {

    /* renamed from: b, reason: collision with root package name */
    public final o<? extends T> f14219b;

    /* renamed from: m, reason: collision with root package name */
    public final o<? extends T> f14220m;

    /* renamed from: n, reason: collision with root package name */
    public final d<? super T, ? super T> f14221n;

    /* renamed from: o, reason: collision with root package name */
    public final int f14222o;

    public static final class EqualCoordinator<T> extends AtomicInteger implements b {
        private static final long serialVersionUID = -6178010334400373240L;

        /* renamed from: b, reason: collision with root package name */
        public final q<? super Boolean> f14223b;

        /* renamed from: m, reason: collision with root package name */
        public final d<? super T, ? super T> f14224m;

        /* renamed from: n, reason: collision with root package name */
        public final ArrayCompositeDisposable f14225n = new ArrayCompositeDisposable(2);

        /* renamed from: o, reason: collision with root package name */
        public final o<? extends T> f14226o;

        /* renamed from: p, reason: collision with root package name */
        public final o<? extends T> f14227p;

        /* renamed from: q, reason: collision with root package name */
        public final a<T>[] f14228q;

        /* renamed from: r, reason: collision with root package name */
        public volatile boolean f14229r;

        /* renamed from: s, reason: collision with root package name */
        public T f14230s;

        /* renamed from: t, reason: collision with root package name */
        public T f14231t;

        public EqualCoordinator(q<? super Boolean> qVar, int i10, o<? extends T> oVar, o<? extends T> oVar2, d<? super T, ? super T> dVar) {
            this.f14223b = qVar;
            this.f14226o = oVar;
            this.f14227p = oVar2;
            this.f14224m = dVar;
            this.f14228q = new a[]{new a<>(this, 0, i10), new a<>(this, 1, i10)};
        }

        public final void a() {
            Throwable th2;
            Throwable th3;
            if (getAndIncrement() != 0) {
                return;
            }
            a<T>[] aVarArr = this.f14228q;
            a<T> aVar = aVarArr[0];
            af.a<T> aVar2 = aVar.f14233m;
            a<T> aVar3 = aVarArr[1];
            af.a<T> aVar4 = aVar3.f14233m;
            int iAddAndGet = 1;
            while (!this.f14229r) {
                boolean z10 = aVar.f14235o;
                if (z10 && (th3 = aVar.f14236p) != null) {
                    this.f14229r = true;
                    aVar2.clear();
                    aVar4.clear();
                    this.f14223b.onError(th3);
                    return;
                }
                boolean z11 = aVar3.f14235o;
                if (z11 && (th2 = aVar3.f14236p) != null) {
                    this.f14229r = true;
                    aVar2.clear();
                    aVar4.clear();
                    this.f14223b.onError(th2);
                    return;
                }
                if (this.f14230s == null) {
                    this.f14230s = aVar2.poll();
                }
                boolean z12 = this.f14230s == null;
                if (this.f14231t == null) {
                    this.f14231t = aVar4.poll();
                }
                T t10 = this.f14231t;
                boolean z13 = t10 == null;
                if (z10 && z11 && z12 && z13) {
                    this.f14223b.onNext(Boolean.TRUE);
                    this.f14223b.onComplete();
                    return;
                }
                if (z10 && z11 && z12 != z13) {
                    this.f14229r = true;
                    aVar2.clear();
                    aVar4.clear();
                    this.f14223b.onNext(Boolean.FALSE);
                    this.f14223b.onComplete();
                    return;
                }
                if (!z12 && !z13) {
                    try {
                        if (!((a.C0288a) this.f14224m).test(this.f14230s, t10)) {
                            this.f14229r = true;
                            aVar2.clear();
                            aVar4.clear();
                            this.f14223b.onNext(Boolean.FALSE);
                            this.f14223b.onComplete();
                            return;
                        }
                        this.f14230s = null;
                        this.f14231t = null;
                    } catch (Throwable th4) {
                        re.a.throwIfFatal(th4);
                        this.f14229r = true;
                        aVar2.clear();
                        aVar4.clear();
                        this.f14223b.onError(th4);
                        return;
                    }
                }
                if (z12 || z13) {
                    iAddAndGet = addAndGet(-iAddAndGet);
                    if (iAddAndGet == 0) {
                        return;
                    }
                }
            }
            aVar2.clear();
            aVar4.clear();
        }

        @Override // qe.b
        public void dispose() {
            if (this.f14229r) {
                return;
            }
            this.f14229r = true;
            this.f14225n.dispose();
            if (getAndIncrement() == 0) {
                a<T>[] aVarArr = this.f14228q;
                aVarArr[0].f14233m.clear();
                aVarArr[1].f14233m.clear();
            }
        }
    }

    public static final class a<T> implements q<T> {

        /* renamed from: b, reason: collision with root package name */
        public final EqualCoordinator<T> f14232b;

        /* renamed from: m, reason: collision with root package name */
        public final af.a<T> f14233m;

        /* renamed from: n, reason: collision with root package name */
        public final int f14234n;

        /* renamed from: o, reason: collision with root package name */
        public volatile boolean f14235o;

        /* renamed from: p, reason: collision with root package name */
        public Throwable f14236p;

        public a(EqualCoordinator<T> equalCoordinator, int i10, int i11) {
            this.f14232b = equalCoordinator;
            this.f14234n = i10;
            this.f14233m = new af.a<>(i11);
        }

        @Override // ne.q
        public void onComplete() {
            this.f14235o = true;
            this.f14232b.a();
        }

        @Override // ne.q
        public void onError(Throwable th2) {
            this.f14236p = th2;
            this.f14235o = true;
            this.f14232b.a();
        }

        @Override // ne.q
        public void onNext(T t10) {
            this.f14233m.offer(t10);
            this.f14232b.a();
        }

        @Override // ne.q
        public void onSubscribe(b bVar) {
            this.f14232b.f14225n.setResource(this.f14234n, bVar);
        }
    }

    public ObservableSequenceEqual(o<? extends T> oVar, o<? extends T> oVar2, d<? super T, ? super T> dVar, int i10) {
        this.f14219b = oVar;
        this.f14220m = oVar2;
        this.f14221n = dVar;
        this.f14222o = i10;
    }

    @Override // ne.k
    public void subscribeActual(q<? super Boolean> qVar) {
        EqualCoordinator equalCoordinator = new EqualCoordinator(qVar, this.f14222o, this.f14219b, this.f14220m, this.f14221n);
        qVar.onSubscribe(equalCoordinator);
        a<T>[] aVarArr = equalCoordinator.f14228q;
        equalCoordinator.f14226o.subscribe(aVarArr[0]);
        equalCoordinator.f14227p.subscribe(aVarArr[1]);
    }
}
