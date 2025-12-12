package io.reactivex.internal.operators.observable;

import io.reactivex.internal.disposables.ArrayCompositeDisposable;
import java.util.concurrent.atomic.AtomicInteger;
import ne.k;
import ne.o;
import ne.q;
import ne.s;
import ne.t;
import qe.b;
import se.d;
import ue.a;

/* loaded from: classes2.dex */
public final class ObservableSequenceEqualSingle<T> extends s<Boolean> implements ve.a<Boolean> {

    /* renamed from: a, reason: collision with root package name */
    public final o<? extends T> f14237a;

    /* renamed from: b, reason: collision with root package name */
    public final o<? extends T> f14238b;

    /* renamed from: c, reason: collision with root package name */
    public final d<? super T, ? super T> f14239c;

    /* renamed from: d, reason: collision with root package name */
    public final int f14240d;

    public static final class EqualCoordinator<T> extends AtomicInteger implements b {
        private static final long serialVersionUID = -6178010334400373240L;

        /* renamed from: b, reason: collision with root package name */
        public final t<? super Boolean> f14241b;

        /* renamed from: m, reason: collision with root package name */
        public final d<? super T, ? super T> f14242m;

        /* renamed from: n, reason: collision with root package name */
        public final ArrayCompositeDisposable f14243n = new ArrayCompositeDisposable(2);

        /* renamed from: o, reason: collision with root package name */
        public final o<? extends T> f14244o;

        /* renamed from: p, reason: collision with root package name */
        public final o<? extends T> f14245p;

        /* renamed from: q, reason: collision with root package name */
        public final a<T>[] f14246q;

        /* renamed from: r, reason: collision with root package name */
        public volatile boolean f14247r;

        /* renamed from: s, reason: collision with root package name */
        public T f14248s;

        /* renamed from: t, reason: collision with root package name */
        public T f14249t;

        public EqualCoordinator(t<? super Boolean> tVar, int i10, o<? extends T> oVar, o<? extends T> oVar2, d<? super T, ? super T> dVar) {
            this.f14241b = tVar;
            this.f14244o = oVar;
            this.f14245p = oVar2;
            this.f14242m = dVar;
            this.f14246q = new a[]{new a<>(this, 0, i10), new a<>(this, 1, i10)};
        }

        public final void a() {
            Throwable th2;
            Throwable th3;
            if (getAndIncrement() != 0) {
                return;
            }
            a<T>[] aVarArr = this.f14246q;
            a<T> aVar = aVarArr[0];
            af.a<T> aVar2 = aVar.f14251m;
            a<T> aVar3 = aVarArr[1];
            af.a<T> aVar4 = aVar3.f14251m;
            int iAddAndGet = 1;
            while (!this.f14247r) {
                boolean z10 = aVar.f14253o;
                if (z10 && (th3 = aVar.f14254p) != null) {
                    this.f14247r = true;
                    aVar2.clear();
                    aVar4.clear();
                    this.f14241b.onError(th3);
                    return;
                }
                boolean z11 = aVar3.f14253o;
                if (z11 && (th2 = aVar3.f14254p) != null) {
                    this.f14247r = true;
                    aVar2.clear();
                    aVar4.clear();
                    this.f14241b.onError(th2);
                    return;
                }
                if (this.f14248s == null) {
                    this.f14248s = aVar2.poll();
                }
                boolean z12 = this.f14248s == null;
                if (this.f14249t == null) {
                    this.f14249t = aVar4.poll();
                }
                T t10 = this.f14249t;
                boolean z13 = t10 == null;
                if (z10 && z11 && z12 && z13) {
                    this.f14241b.onSuccess(Boolean.TRUE);
                    return;
                }
                if (z10 && z11 && z12 != z13) {
                    this.f14247r = true;
                    aVar2.clear();
                    aVar4.clear();
                    this.f14241b.onSuccess(Boolean.FALSE);
                    return;
                }
                if (!z12 && !z13) {
                    try {
                        if (!((a.C0288a) this.f14242m).test(this.f14248s, t10)) {
                            this.f14247r = true;
                            aVar2.clear();
                            aVar4.clear();
                            this.f14241b.onSuccess(Boolean.FALSE);
                            return;
                        }
                        this.f14248s = null;
                        this.f14249t = null;
                    } catch (Throwable th4) {
                        re.a.throwIfFatal(th4);
                        this.f14247r = true;
                        aVar2.clear();
                        aVar4.clear();
                        this.f14241b.onError(th4);
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
            if (this.f14247r) {
                return;
            }
            this.f14247r = true;
            this.f14243n.dispose();
            if (getAndIncrement() == 0) {
                a<T>[] aVarArr = this.f14246q;
                aVarArr[0].f14251m.clear();
                aVarArr[1].f14251m.clear();
            }
        }
    }

    public static final class a<T> implements q<T> {

        /* renamed from: b, reason: collision with root package name */
        public final EqualCoordinator<T> f14250b;

        /* renamed from: m, reason: collision with root package name */
        public final af.a<T> f14251m;

        /* renamed from: n, reason: collision with root package name */
        public final int f14252n;

        /* renamed from: o, reason: collision with root package name */
        public volatile boolean f14253o;

        /* renamed from: p, reason: collision with root package name */
        public Throwable f14254p;

        public a(EqualCoordinator<T> equalCoordinator, int i10, int i11) {
            this.f14250b = equalCoordinator;
            this.f14252n = i10;
            this.f14251m = new af.a<>(i11);
        }

        @Override // ne.q
        public void onComplete() {
            this.f14253o = true;
            this.f14250b.a();
        }

        @Override // ne.q
        public void onError(Throwable th2) {
            this.f14254p = th2;
            this.f14253o = true;
            this.f14250b.a();
        }

        @Override // ne.q
        public void onNext(T t10) {
            this.f14251m.offer(t10);
            this.f14250b.a();
        }

        @Override // ne.q
        public void onSubscribe(b bVar) {
            this.f14250b.f14243n.setResource(this.f14252n, bVar);
        }
    }

    public ObservableSequenceEqualSingle(o<? extends T> oVar, o<? extends T> oVar2, d<? super T, ? super T> dVar, int i10) {
        this.f14237a = oVar;
        this.f14238b = oVar2;
        this.f14239c = dVar;
        this.f14240d = i10;
    }

    @Override // ve.a
    public k<Boolean> fuseToObservable() {
        return ff.a.onAssembly(new ObservableSequenceEqual(this.f14237a, this.f14238b, this.f14239c, this.f14240d));
    }

    @Override // ne.s
    public void subscribeActual(t<? super Boolean> tVar) {
        EqualCoordinator equalCoordinator = new EqualCoordinator(tVar, this.f14240d, this.f14237a, this.f14238b, this.f14239c);
        tVar.onSubscribe(equalCoordinator);
        a<T>[] aVarArr = equalCoordinator.f14246q;
        equalCoordinator.f14244o.subscribe(aVarArr[0]);
        equalCoordinator.f14245p.subscribe(aVarArr[1]);
    }
}
