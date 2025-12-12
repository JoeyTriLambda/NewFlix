package io.reactivex.internal.operators.observable;

import bf.g;
import io.reactivex.internal.disposables.DisposableHelper;
import io.reactivex.internal.observers.BasicIntQueueDisposable;
import ne.o;
import ne.q;
import ne.r;
import qe.b;
import ve.f;

/* loaded from: classes2.dex */
public final class ObservableObserveOn<T> extends ye.a<T, T> {

    /* renamed from: m, reason: collision with root package name */
    public final r f14052m;

    /* renamed from: n, reason: collision with root package name */
    public final boolean f14053n;

    /* renamed from: o, reason: collision with root package name */
    public final int f14054o;

    public static final class ObserveOnObserver<T> extends BasicIntQueueDisposable<T> implements q<T>, Runnable {
        private static final long serialVersionUID = 6576896619930983584L;

        /* renamed from: b, reason: collision with root package name */
        public final q<? super T> f14055b;

        /* renamed from: m, reason: collision with root package name */
        public final r.c f14056m;

        /* renamed from: n, reason: collision with root package name */
        public final boolean f14057n;

        /* renamed from: o, reason: collision with root package name */
        public final int f14058o;

        /* renamed from: p, reason: collision with root package name */
        public f<T> f14059p;

        /* renamed from: q, reason: collision with root package name */
        public b f14060q;

        /* renamed from: r, reason: collision with root package name */
        public Throwable f14061r;

        /* renamed from: s, reason: collision with root package name */
        public volatile boolean f14062s;

        /* renamed from: t, reason: collision with root package name */
        public volatile boolean f14063t;

        /* renamed from: u, reason: collision with root package name */
        public int f14064u;

        /* renamed from: v, reason: collision with root package name */
        public boolean f14065v;

        public ObserveOnObserver(q<? super T> qVar, r.c cVar, boolean z10, int i10) {
            this.f14055b = qVar;
            this.f14056m = cVar;
            this.f14057n = z10;
            this.f14058o = i10;
        }

        public final boolean a(boolean z10, boolean z11, q<? super T> qVar) {
            if (this.f14063t) {
                this.f14059p.clear();
                return true;
            }
            if (!z10) {
                return false;
            }
            Throwable th2 = this.f14061r;
            if (this.f14057n) {
                if (!z11) {
                    return false;
                }
                this.f14063t = true;
                if (th2 != null) {
                    qVar.onError(th2);
                } else {
                    qVar.onComplete();
                }
                this.f14056m.dispose();
                return true;
            }
            if (th2 != null) {
                this.f14063t = true;
                this.f14059p.clear();
                qVar.onError(th2);
                this.f14056m.dispose();
                return true;
            }
            if (!z11) {
                return false;
            }
            this.f14063t = true;
            qVar.onComplete();
            this.f14056m.dispose();
            return true;
        }

        @Override // ve.f
        public void clear() {
            this.f14059p.clear();
        }

        @Override // qe.b
        public void dispose() {
            if (this.f14063t) {
                return;
            }
            this.f14063t = true;
            this.f14060q.dispose();
            this.f14056m.dispose();
            if (this.f14065v || getAndIncrement() != 0) {
                return;
            }
            this.f14059p.clear();
        }

        @Override // ve.f
        public boolean isEmpty() {
            return this.f14059p.isEmpty();
        }

        @Override // ne.q
        public void onComplete() {
            if (this.f14062s) {
                return;
            }
            this.f14062s = true;
            if (getAndIncrement() == 0) {
                this.f14056m.schedule(this);
            }
        }

        @Override // ne.q
        public void onError(Throwable th2) {
            if (this.f14062s) {
                ff.a.onError(th2);
                return;
            }
            this.f14061r = th2;
            this.f14062s = true;
            if (getAndIncrement() == 0) {
                this.f14056m.schedule(this);
            }
        }

        @Override // ne.q
        public void onNext(T t10) {
            if (this.f14062s) {
                return;
            }
            if (this.f14064u != 2) {
                this.f14059p.offer(t10);
            }
            if (getAndIncrement() == 0) {
                this.f14056m.schedule(this);
            }
        }

        @Override // ne.q
        public void onSubscribe(b bVar) {
            if (DisposableHelper.validate(this.f14060q, bVar)) {
                this.f14060q = bVar;
                if (bVar instanceof ve.b) {
                    ve.b bVar2 = (ve.b) bVar;
                    int iRequestFusion = bVar2.requestFusion(7);
                    if (iRequestFusion == 1) {
                        this.f14064u = iRequestFusion;
                        this.f14059p = bVar2;
                        this.f14062s = true;
                        this.f14055b.onSubscribe(this);
                        if (getAndIncrement() == 0) {
                            this.f14056m.schedule(this);
                            return;
                        }
                        return;
                    }
                    if (iRequestFusion == 2) {
                        this.f14064u = iRequestFusion;
                        this.f14059p = bVar2;
                        this.f14055b.onSubscribe(this);
                        return;
                    }
                }
                this.f14059p = new af.a(this.f14058o);
                this.f14055b.onSubscribe(this);
            }
        }

        @Override // ve.f
        public T poll() throws Exception {
            return this.f14059p.poll();
        }

        @Override // ve.c
        public int requestFusion(int i10) {
            if ((i10 & 2) == 0) {
                return 0;
            }
            this.f14065v = true;
            return 2;
        }

        /* JADX WARN: Code restructure failed: missing block: B:36:0x0075, code lost:
        
            r3 = addAndGet(-r3);
         */
        /* JADX WARN: Code restructure failed: missing block: B:37:0x007a, code lost:
        
            if (r3 != 0) goto L53;
         */
        /* JADX WARN: Code restructure failed: missing block: B:60:?, code lost:
        
            return;
         */
        @Override // java.lang.Runnable
        /*
            Code decompiled incorrectly, please refer to instructions dump.
            To view partially-correct code enable 'Show inconsistent code' option in preferences
        */
        public void run() {
            /*
                r7 = this;
                boolean r0 = r7.f14065v
                r1 = 1
                if (r0 == 0) goto L4f
                r0 = 1
            L6:
                boolean r2 = r7.f14063t
                if (r2 == 0) goto Lc
                goto L97
            Lc:
                boolean r2 = r7.f14062s
                java.lang.Throwable r3 = r7.f14061r
                boolean r4 = r7.f14057n
                if (r4 != 0) goto L28
                if (r2 == 0) goto L28
                if (r3 == 0) goto L28
                r7.f14063t = r1
                ne.q<? super T> r0 = r7.f14055b
                java.lang.Throwable r1 = r7.f14061r
                r0.onError(r1)
                ne.r$c r0 = r7.f14056m
                r0.dispose()
                goto L97
            L28:
                ne.q<? super T> r3 = r7.f14055b
                r4 = 0
                r3.onNext(r4)
                if (r2 == 0) goto L47
                r7.f14063t = r1
                java.lang.Throwable r0 = r7.f14061r
                if (r0 == 0) goto L3c
                ne.q<? super T> r1 = r7.f14055b
                r1.onError(r0)
                goto L41
            L3c:
                ne.q<? super T> r0 = r7.f14055b
                r0.onComplete()
            L41:
                ne.r$c r0 = r7.f14056m
                r0.dispose()
                goto L97
            L47:
                int r0 = -r0
                int r0 = r7.addAndGet(r0)
                if (r0 != 0) goto L6
                goto L97
            L4f:
                ve.f<T> r0 = r7.f14059p
                ne.q<? super T> r2 = r7.f14055b
                r3 = 1
            L54:
                boolean r4 = r7.f14062s
                boolean r5 = r0.isEmpty()
                boolean r4 = r7.a(r4, r5, r2)
                if (r4 == 0) goto L61
                goto L97
            L61:
                boolean r4 = r7.f14062s
                java.lang.Object r5 = r0.poll()     // Catch: java.lang.Throwable -> L81
                if (r5 != 0) goto L6b
                r6 = 1
                goto L6c
            L6b:
                r6 = 0
            L6c:
                boolean r4 = r7.a(r4, r6, r2)
                if (r4 == 0) goto L73
                goto L97
            L73:
                if (r6 == 0) goto L7d
                int r3 = -r3
                int r3 = r7.addAndGet(r3)
                if (r3 != 0) goto L54
                goto L97
            L7d:
                r2.onNext(r5)
                goto L61
            L81:
                r3 = move-exception
                re.a.throwIfFatal(r3)
                r7.f14063t = r1
                qe.b r1 = r7.f14060q
                r1.dispose()
                r0.clear()
                r2.onError(r3)
                ne.r$c r0 = r7.f14056m
                r0.dispose()
            L97:
                return
            */
            throw new UnsupportedOperationException("Method not decompiled: io.reactivex.internal.operators.observable.ObservableObserveOn.ObserveOnObserver.run():void");
        }
    }

    public ObservableObserveOn(o<T> oVar, r rVar, boolean z10, int i10) {
        super(oVar);
        this.f14052m = rVar;
        this.f14053n = z10;
        this.f14054o = i10;
    }

    @Override // ne.k
    public void subscribeActual(q<? super T> qVar) {
        r rVar = this.f14052m;
        boolean z10 = rVar instanceof g;
        o<T> oVar = this.f22058b;
        if (z10) {
            oVar.subscribe(qVar);
        } else {
            oVar.subscribe(new ObserveOnObserver(qVar, rVar.createWorker(), this.f14053n, this.f14054o));
        }
    }
}
