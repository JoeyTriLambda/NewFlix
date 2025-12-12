package io.reactivex.internal.operators.mixed;

import c8.i;
import io.reactivex.internal.disposables.DisposableHelper;
import io.reactivex.internal.util.AtomicThrowable;
import io.reactivex.internal.util.ErrorMode;
import io.reactivex.internal.util.ExceptionHelper;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.concurrent.atomic.AtomicReference;
import ne.a;
import ne.c;
import ne.k;
import ne.q;
import qe.b;
import se.n;
import ve.f;

/* loaded from: classes2.dex */
public final class ObservableConcatMapCompletable<T> extends a {

    /* renamed from: a, reason: collision with root package name */
    public final k<T> f13616a;

    /* renamed from: b, reason: collision with root package name */
    public final n<? super T, ? extends c> f13617b;

    /* renamed from: c, reason: collision with root package name */
    public final ErrorMode f13618c;

    /* renamed from: d, reason: collision with root package name */
    public final int f13619d;

    public static final class ConcatMapCompletableObserver<T> extends AtomicInteger implements q<T>, b {
        private static final long serialVersionUID = 3610901111000061034L;

        /* renamed from: b, reason: collision with root package name */
        public final ne.b f13620b;

        /* renamed from: m, reason: collision with root package name */
        public final n<? super T, ? extends c> f13621m;

        /* renamed from: n, reason: collision with root package name */
        public final ErrorMode f13622n;

        /* renamed from: o, reason: collision with root package name */
        public final AtomicThrowable f13623o = new AtomicThrowable();

        /* renamed from: p, reason: collision with root package name */
        public final ConcatMapInnerObserver f13624p = new ConcatMapInnerObserver(this);

        /* renamed from: q, reason: collision with root package name */
        public final int f13625q;

        /* renamed from: r, reason: collision with root package name */
        public f<T> f13626r;

        /* renamed from: s, reason: collision with root package name */
        public b f13627s;

        /* renamed from: t, reason: collision with root package name */
        public volatile boolean f13628t;

        /* renamed from: u, reason: collision with root package name */
        public volatile boolean f13629u;

        /* renamed from: v, reason: collision with root package name */
        public volatile boolean f13630v;

        public static final class ConcatMapInnerObserver extends AtomicReference<b> implements ne.b {
            private static final long serialVersionUID = 5638352172918776687L;

            /* renamed from: b, reason: collision with root package name */
            public final ConcatMapCompletableObserver<?> f13631b;

            public ConcatMapInnerObserver(ConcatMapCompletableObserver<?> concatMapCompletableObserver) {
                this.f13631b = concatMapCompletableObserver;
            }

            @Override // ne.b
            public void onComplete() {
                ConcatMapCompletableObserver<?> concatMapCompletableObserver = this.f13631b;
                concatMapCompletableObserver.f13628t = false;
                concatMapCompletableObserver.a();
            }

            @Override // ne.b
            public void onError(Throwable th2) {
                ConcatMapCompletableObserver<?> concatMapCompletableObserver = this.f13631b;
                if (!concatMapCompletableObserver.f13623o.addThrowable(th2)) {
                    ff.a.onError(th2);
                    return;
                }
                if (concatMapCompletableObserver.f13622n != ErrorMode.IMMEDIATE) {
                    concatMapCompletableObserver.f13628t = false;
                    concatMapCompletableObserver.a();
                    return;
                }
                concatMapCompletableObserver.f13630v = true;
                concatMapCompletableObserver.f13627s.dispose();
                Throwable thTerminate = concatMapCompletableObserver.f13623o.terminate();
                if (thTerminate != ExceptionHelper.f14544a) {
                    concatMapCompletableObserver.f13620b.onError(thTerminate);
                }
                if (concatMapCompletableObserver.getAndIncrement() == 0) {
                    concatMapCompletableObserver.f13626r.clear();
                }
            }

            @Override // ne.b
            public void onSubscribe(b bVar) {
                DisposableHelper.replace(this, bVar);
            }
        }

        public ConcatMapCompletableObserver(ne.b bVar, n<? super T, ? extends c> nVar, ErrorMode errorMode, int i10) {
            this.f13620b = bVar;
            this.f13621m = nVar;
            this.f13622n = errorMode;
            this.f13625q = i10;
        }

        public final void a() {
            c cVar;
            boolean z10;
            if (getAndIncrement() != 0) {
                return;
            }
            AtomicThrowable atomicThrowable = this.f13623o;
            ErrorMode errorMode = this.f13622n;
            while (!this.f13630v) {
                if (!this.f13628t) {
                    if (errorMode == ErrorMode.BOUNDARY && atomicThrowable.get() != null) {
                        this.f13630v = true;
                        this.f13626r.clear();
                        this.f13620b.onError(atomicThrowable.terminate());
                        return;
                    }
                    boolean z11 = this.f13629u;
                    try {
                        T tPoll = this.f13626r.poll();
                        if (tPoll != null) {
                            cVar = (c) ue.a.requireNonNull(this.f13621m.apply(tPoll), "The mapper returned a null CompletableSource");
                            z10 = false;
                        } else {
                            cVar = null;
                            z10 = true;
                        }
                        if (z11 && z10) {
                            this.f13630v = true;
                            Throwable thTerminate = atomicThrowable.terminate();
                            if (thTerminate != null) {
                                this.f13620b.onError(thTerminate);
                                return;
                            } else {
                                this.f13620b.onComplete();
                                return;
                            }
                        }
                        if (!z10) {
                            this.f13628t = true;
                            cVar.subscribe(this.f13624p);
                        }
                    } catch (Throwable th2) {
                        re.a.throwIfFatal(th2);
                        this.f13630v = true;
                        this.f13626r.clear();
                        this.f13627s.dispose();
                        atomicThrowable.addThrowable(th2);
                        this.f13620b.onError(atomicThrowable.terminate());
                        return;
                    }
                }
                if (decrementAndGet() == 0) {
                    return;
                }
            }
            this.f13626r.clear();
        }

        @Override // qe.b
        public void dispose() {
            this.f13630v = true;
            this.f13627s.dispose();
            ConcatMapInnerObserver concatMapInnerObserver = this.f13624p;
            concatMapInnerObserver.getClass();
            DisposableHelper.dispose(concatMapInnerObserver);
            if (getAndIncrement() == 0) {
                this.f13626r.clear();
            }
        }

        @Override // ne.q
        public void onComplete() {
            this.f13629u = true;
            a();
        }

        @Override // ne.q
        public void onError(Throwable th2) {
            if (!this.f13623o.addThrowable(th2)) {
                ff.a.onError(th2);
                return;
            }
            if (this.f13622n != ErrorMode.IMMEDIATE) {
                this.f13629u = true;
                a();
                return;
            }
            this.f13630v = true;
            ConcatMapInnerObserver concatMapInnerObserver = this.f13624p;
            concatMapInnerObserver.getClass();
            DisposableHelper.dispose(concatMapInnerObserver);
            Throwable thTerminate = this.f13623o.terminate();
            if (thTerminate != ExceptionHelper.f14544a) {
                this.f13620b.onError(thTerminate);
            }
            if (getAndIncrement() == 0) {
                this.f13626r.clear();
            }
        }

        @Override // ne.q
        public void onNext(T t10) {
            if (t10 != null) {
                this.f13626r.offer(t10);
            }
            a();
        }

        @Override // ne.q
        public void onSubscribe(b bVar) {
            if (DisposableHelper.validate(this.f13627s, bVar)) {
                this.f13627s = bVar;
                if (bVar instanceof ve.b) {
                    ve.b bVar2 = (ve.b) bVar;
                    int iRequestFusion = bVar2.requestFusion(3);
                    if (iRequestFusion == 1) {
                        this.f13626r = bVar2;
                        this.f13629u = true;
                        this.f13620b.onSubscribe(this);
                        a();
                        return;
                    }
                    if (iRequestFusion == 2) {
                        this.f13626r = bVar2;
                        this.f13620b.onSubscribe(this);
                        return;
                    }
                }
                this.f13626r = new af.a(this.f13625q);
                this.f13620b.onSubscribe(this);
            }
        }
    }

    public ObservableConcatMapCompletable(k<T> kVar, n<? super T, ? extends c> nVar, ErrorMode errorMode, int i10) {
        this.f13616a = kVar;
        this.f13617b = nVar;
        this.f13618c = errorMode;
        this.f13619d = i10;
    }

    @Override // ne.a
    public void subscribeActual(ne.b bVar) {
        k<T> kVar = this.f13616a;
        n<? super T, ? extends c> nVar = this.f13617b;
        if (i.n(kVar, nVar, bVar)) {
            return;
        }
        kVar.subscribe(new ConcatMapCompletableObserver(bVar, nVar, this.f13618c, this.f13619d));
    }
}
