package io.reactivex.internal.operators.observable;

import io.reactivex.internal.disposables.DisposableHelper;
import io.reactivex.subjects.UnicastSubject;
import java.util.ArrayDeque;
import java.util.Iterator;
import java.util.concurrent.atomic.AtomicBoolean;
import java.util.concurrent.atomic.AtomicInteger;
import ne.k;
import ne.o;
import ne.q;
import qe.b;

/* loaded from: classes2.dex */
public final class ObservableWindow<T> extends ye.a<T, k<T>> {

    /* renamed from: m, reason: collision with root package name */
    public final long f14406m;

    /* renamed from: n, reason: collision with root package name */
    public final long f14407n;

    /* renamed from: o, reason: collision with root package name */
    public final int f14408o;

    public static final class WindowExactObserver<T> extends AtomicInteger implements q<T>, b, Runnable {
        private static final long serialVersionUID = -7481782523886138128L;

        /* renamed from: b, reason: collision with root package name */
        public final q<? super k<T>> f14409b;

        /* renamed from: m, reason: collision with root package name */
        public final long f14410m;

        /* renamed from: n, reason: collision with root package name */
        public final int f14411n;

        /* renamed from: o, reason: collision with root package name */
        public long f14412o;

        /* renamed from: p, reason: collision with root package name */
        public b f14413p;

        /* renamed from: q, reason: collision with root package name */
        public UnicastSubject<T> f14414q;

        /* renamed from: r, reason: collision with root package name */
        public volatile boolean f14415r;

        public WindowExactObserver(q<? super k<T>> qVar, long j10, int i10) {
            this.f14409b = qVar;
            this.f14410m = j10;
            this.f14411n = i10;
        }

        @Override // qe.b
        public void dispose() {
            this.f14415r = true;
        }

        @Override // ne.q
        public void onComplete() {
            UnicastSubject<T> unicastSubject = this.f14414q;
            if (unicastSubject != null) {
                this.f14414q = null;
                unicastSubject.onComplete();
            }
            this.f14409b.onComplete();
        }

        @Override // ne.q
        public void onError(Throwable th2) {
            UnicastSubject<T> unicastSubject = this.f14414q;
            if (unicastSubject != null) {
                this.f14414q = null;
                unicastSubject.onError(th2);
            }
            this.f14409b.onError(th2);
        }

        @Override // ne.q
        public void onNext(T t10) {
            UnicastSubject<T> unicastSubjectCreate = this.f14414q;
            if (unicastSubjectCreate == null && !this.f14415r) {
                unicastSubjectCreate = UnicastSubject.create(this.f14411n, this);
                this.f14414q = unicastSubjectCreate;
                this.f14409b.onNext(unicastSubjectCreate);
            }
            if (unicastSubjectCreate != null) {
                unicastSubjectCreate.onNext(t10);
                long j10 = this.f14412o + 1;
                this.f14412o = j10;
                if (j10 >= this.f14410m) {
                    this.f14412o = 0L;
                    this.f14414q = null;
                    unicastSubjectCreate.onComplete();
                    if (this.f14415r) {
                        this.f14413p.dispose();
                    }
                }
            }
        }

        @Override // ne.q
        public void onSubscribe(b bVar) {
            if (DisposableHelper.validate(this.f14413p, bVar)) {
                this.f14413p = bVar;
                this.f14409b.onSubscribe(this);
            }
        }

        @Override // java.lang.Runnable
        public void run() {
            if (this.f14415r) {
                this.f14413p.dispose();
            }
        }
    }

    public static final class WindowSkipObserver<T> extends AtomicBoolean implements q<T>, b, Runnable {
        private static final long serialVersionUID = 3366976432059579510L;

        /* renamed from: b, reason: collision with root package name */
        public final q<? super k<T>> f14416b;

        /* renamed from: m, reason: collision with root package name */
        public final long f14417m;

        /* renamed from: n, reason: collision with root package name */
        public final long f14418n;

        /* renamed from: o, reason: collision with root package name */
        public final int f14419o;

        /* renamed from: q, reason: collision with root package name */
        public long f14421q;

        /* renamed from: r, reason: collision with root package name */
        public volatile boolean f14422r;

        /* renamed from: s, reason: collision with root package name */
        public long f14423s;

        /* renamed from: t, reason: collision with root package name */
        public b f14424t;

        /* renamed from: u, reason: collision with root package name */
        public final AtomicInteger f14425u = new AtomicInteger();

        /* renamed from: p, reason: collision with root package name */
        public final ArrayDeque<UnicastSubject<T>> f14420p = new ArrayDeque<>();

        public WindowSkipObserver(q<? super k<T>> qVar, long j10, long j11, int i10) {
            this.f14416b = qVar;
            this.f14417m = j10;
            this.f14418n = j11;
            this.f14419o = i10;
        }

        @Override // qe.b
        public void dispose() {
            this.f14422r = true;
        }

        @Override // ne.q
        public void onComplete() {
            ArrayDeque<UnicastSubject<T>> arrayDeque = this.f14420p;
            while (!arrayDeque.isEmpty()) {
                arrayDeque.poll().onComplete();
            }
            this.f14416b.onComplete();
        }

        @Override // ne.q
        public void onError(Throwable th2) {
            ArrayDeque<UnicastSubject<T>> arrayDeque = this.f14420p;
            while (!arrayDeque.isEmpty()) {
                arrayDeque.poll().onError(th2);
            }
            this.f14416b.onError(th2);
        }

        @Override // ne.q
        public void onNext(T t10) {
            ArrayDeque<UnicastSubject<T>> arrayDeque = this.f14420p;
            long j10 = this.f14421q;
            long j11 = this.f14418n;
            if (j10 % j11 == 0 && !this.f14422r) {
                this.f14425u.getAndIncrement();
                UnicastSubject<T> unicastSubjectCreate = UnicastSubject.create(this.f14419o, this);
                arrayDeque.offer(unicastSubjectCreate);
                this.f14416b.onNext(unicastSubjectCreate);
            }
            long j12 = this.f14423s + 1;
            Iterator<UnicastSubject<T>> it = arrayDeque.iterator();
            while (it.hasNext()) {
                it.next().onNext(t10);
            }
            if (j12 >= this.f14417m) {
                arrayDeque.poll().onComplete();
                if (arrayDeque.isEmpty() && this.f14422r) {
                    this.f14424t.dispose();
                    return;
                }
                this.f14423s = j12 - j11;
            } else {
                this.f14423s = j12;
            }
            this.f14421q = j10 + 1;
        }

        @Override // ne.q
        public void onSubscribe(b bVar) {
            if (DisposableHelper.validate(this.f14424t, bVar)) {
                this.f14424t = bVar;
                this.f14416b.onSubscribe(this);
            }
        }

        @Override // java.lang.Runnable
        public void run() {
            if (this.f14425u.decrementAndGet() == 0 && this.f14422r) {
                this.f14424t.dispose();
            }
        }
    }

    public ObservableWindow(o<T> oVar, long j10, long j11, int i10) {
        super(oVar);
        this.f14406m = j10;
        this.f14407n = j11;
        this.f14408o = i10;
    }

    @Override // ne.k
    public void subscribeActual(q<? super k<T>> qVar) {
        long j10 = this.f14407n;
        o<T> oVar = this.f22058b;
        long j11 = this.f14406m;
        if (j11 == j10) {
            oVar.subscribe(new WindowExactObserver(qVar, j11, this.f14408o));
        } else {
            oVar.subscribe(new WindowSkipObserver(qVar, this.f14406m, this.f14407n, this.f14408o));
        }
    }
}
