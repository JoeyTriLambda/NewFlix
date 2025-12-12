package io.reactivex.internal.operators.observable;

import io.reactivex.internal.disposables.DisposableHelper;
import io.reactivex.internal.observers.InnerQueuedObserver;
import io.reactivex.internal.util.AtomicThrowable;
import io.reactivex.internal.util.ErrorMode;
import java.util.ArrayDeque;
import java.util.concurrent.atomic.AtomicInteger;
import ne.o;
import ne.q;
import qe.b;
import se.n;
import ve.f;
import we.i;

/* loaded from: classes2.dex */
public final class ObservableConcatMapEager<T, R> extends ye.a<T, R> {

    /* renamed from: m, reason: collision with root package name */
    public final n<? super T, ? extends o<? extends R>> f13820m;

    /* renamed from: n, reason: collision with root package name */
    public final ErrorMode f13821n;

    /* renamed from: o, reason: collision with root package name */
    public final int f13822o;

    /* renamed from: p, reason: collision with root package name */
    public final int f13823p;

    public static final class ConcatMapEagerMainObserver<T, R> extends AtomicInteger implements q<T>, b, i<R> {
        private static final long serialVersionUID = 8080567949447303262L;

        /* renamed from: b, reason: collision with root package name */
        public final q<? super R> f13824b;

        /* renamed from: m, reason: collision with root package name */
        public final n<? super T, ? extends o<? extends R>> f13825m;

        /* renamed from: n, reason: collision with root package name */
        public final int f13826n;

        /* renamed from: o, reason: collision with root package name */
        public final int f13827o;

        /* renamed from: p, reason: collision with root package name */
        public final ErrorMode f13828p;

        /* renamed from: q, reason: collision with root package name */
        public final AtomicThrowable f13829q = new AtomicThrowable();

        /* renamed from: r, reason: collision with root package name */
        public final ArrayDeque<InnerQueuedObserver<R>> f13830r = new ArrayDeque<>();

        /* renamed from: s, reason: collision with root package name */
        public f<T> f13831s;

        /* renamed from: t, reason: collision with root package name */
        public b f13832t;

        /* renamed from: u, reason: collision with root package name */
        public volatile boolean f13833u;

        /* renamed from: v, reason: collision with root package name */
        public int f13834v;

        /* renamed from: w, reason: collision with root package name */
        public volatile boolean f13835w;

        /* renamed from: x, reason: collision with root package name */
        public InnerQueuedObserver<R> f13836x;

        /* renamed from: y, reason: collision with root package name */
        public int f13837y;

        public ConcatMapEagerMainObserver(q<? super R> qVar, n<? super T, ? extends o<? extends R>> nVar, int i10, int i11, ErrorMode errorMode) {
            this.f13824b = qVar;
            this.f13825m = nVar;
            this.f13826n = i10;
            this.f13827o = i11;
            this.f13828p = errorMode;
        }

        public final void a() {
            InnerQueuedObserver<R> innerQueuedObserver = this.f13836x;
            if (innerQueuedObserver != null) {
                innerQueuedObserver.dispose();
            }
            while (true) {
                InnerQueuedObserver<R> innerQueuedObserverPoll = this.f13830r.poll();
                if (innerQueuedObserverPoll == null) {
                    return;
                } else {
                    innerQueuedObserverPoll.dispose();
                }
            }
        }

        @Override // qe.b
        public void dispose() {
            if (this.f13835w) {
                return;
            }
            this.f13835w = true;
            this.f13832t.dispose();
            if (getAndIncrement() == 0) {
                do {
                    this.f13831s.clear();
                    a();
                } while (decrementAndGet() != 0);
            }
        }

        /* JADX WARN: Code restructure failed: missing block: B:107:?, code lost:
        
            return;
         */
        /* JADX WARN: Code restructure failed: missing block: B:26:0x0083, code lost:
        
            r14.f13837y = r6;
         */
        /* JADX WARN: Code restructure failed: missing block: B:27:0x0087, code lost:
        
            if (r14.f13835w == false) goto L30;
         */
        /* JADX WARN: Code restructure failed: missing block: B:28:0x0089, code lost:
        
            r0.clear();
            a();
         */
        /* JADX WARN: Code restructure failed: missing block: B:29:0x008f, code lost:
        
            return;
         */
        /* JADX WARN: Code restructure failed: missing block: B:30:0x0090, code lost:
        
            if (r3 != r8) goto L35;
         */
        /* JADX WARN: Code restructure failed: missing block: B:32:0x009a, code lost:
        
            if (r14.f13829q.get() == null) goto L35;
         */
        /* JADX WARN: Code restructure failed: missing block: B:33:0x009c, code lost:
        
            r0.clear();
            a();
            r2.onError(r14.f13829q.terminate());
         */
        /* JADX WARN: Code restructure failed: missing block: B:34:0x00ab, code lost:
        
            return;
         */
        /* JADX WARN: Code restructure failed: missing block: B:35:0x00ac, code lost:
        
            r6 = r14.f13836x;
         */
        /* JADX WARN: Code restructure failed: missing block: B:36:0x00af, code lost:
        
            if (r6 != null) goto L57;
         */
        /* JADX WARN: Code restructure failed: missing block: B:38:0x00b3, code lost:
        
            if (r3 != io.reactivex.internal.util.ErrorMode.BOUNDARY) goto L43;
         */
        /* JADX WARN: Code restructure failed: missing block: B:40:0x00bd, code lost:
        
            if (r14.f13829q.get() == null) goto L43;
         */
        /* JADX WARN: Code restructure failed: missing block: B:41:0x00bf, code lost:
        
            r0.clear();
            a();
            r2.onError(r14.f13829q.terminate());
         */
        /* JADX WARN: Code restructure failed: missing block: B:42:0x00ce, code lost:
        
            return;
         */
        /* JADX WARN: Code restructure failed: missing block: B:43:0x00cf, code lost:
        
            r6 = r14.f13833u;
            r9 = r1.poll();
         */
        /* JADX WARN: Code restructure failed: missing block: B:44:0x00d7, code lost:
        
            if (r9 != null) goto L46;
         */
        /* JADX WARN: Code restructure failed: missing block: B:45:0x00d9, code lost:
        
            r10 = true;
         */
        /* JADX WARN: Code restructure failed: missing block: B:46:0x00db, code lost:
        
            r10 = false;
         */
        /* JADX WARN: Code restructure failed: missing block: B:47:0x00dc, code lost:
        
            if (r6 == false) goto L54;
         */
        /* JADX WARN: Code restructure failed: missing block: B:48:0x00de, code lost:
        
            if (r10 == false) goto L54;
         */
        /* JADX WARN: Code restructure failed: missing block: B:50:0x00e8, code lost:
        
            if (r14.f13829q.get() == null) goto L52;
         */
        /* JADX WARN: Code restructure failed: missing block: B:51:0x00ea, code lost:
        
            r0.clear();
            a();
            r2.onError(r14.f13829q.terminate());
         */
        /* JADX WARN: Code restructure failed: missing block: B:52:0x00fa, code lost:
        
            r2.onComplete();
         */
        /* JADX WARN: Code restructure failed: missing block: B:53:0x00fd, code lost:
        
            return;
         */
        /* JADX WARN: Code restructure failed: missing block: B:54:0x00fe, code lost:
        
            if (r10 != false) goto L56;
         */
        /* JADX WARN: Code restructure failed: missing block: B:55:0x0100, code lost:
        
            r14.f13836x = r9;
         */
        /* JADX WARN: Code restructure failed: missing block: B:56:0x0102, code lost:
        
            r6 = r9;
         */
        /* JADX WARN: Code restructure failed: missing block: B:57:0x0103, code lost:
        
            if (r6 == null) goto L95;
         */
        /* JADX WARN: Code restructure failed: missing block: B:58:0x0105, code lost:
        
            r9 = r6.queue();
         */
        /* JADX WARN: Code restructure failed: missing block: B:60:0x010b, code lost:
        
            if (r14.f13835w == false) goto L63;
         */
        /* JADX WARN: Code restructure failed: missing block: B:61:0x010d, code lost:
        
            r0.clear();
            a();
         */
        /* JADX WARN: Code restructure failed: missing block: B:62:0x0113, code lost:
        
            return;
         */
        /* JADX WARN: Code restructure failed: missing block: B:63:0x0114, code lost:
        
            r10 = r6.isDone();
         */
        /* JADX WARN: Code restructure failed: missing block: B:64:0x0118, code lost:
        
            if (r3 != r8) goto L69;
         */
        /* JADX WARN: Code restructure failed: missing block: B:66:0x0122, code lost:
        
            if (r14.f13829q.get() == null) goto L69;
         */
        /* JADX WARN: Code restructure failed: missing block: B:67:0x0124, code lost:
        
            r0.clear();
            a();
            r2.onError(r14.f13829q.terminate());
         */
        /* JADX WARN: Code restructure failed: missing block: B:68:0x0133, code lost:
        
            return;
         */
        /* JADX WARN: Code restructure failed: missing block: B:70:0x0135, code lost:
        
            r12 = r9.poll();
         */
        /* JADX WARN: Code restructure failed: missing block: B:71:0x0139, code lost:
        
            if (r12 != null) goto L73;
         */
        /* JADX WARN: Code restructure failed: missing block: B:72:0x013b, code lost:
        
            r13 = true;
         */
        /* JADX WARN: Code restructure failed: missing block: B:73:0x013d, code lost:
        
            r13 = false;
         */
        /* JADX WARN: Code restructure failed: missing block: B:74:0x013e, code lost:
        
            if (r10 == false) goto L77;
         */
        /* JADX WARN: Code restructure failed: missing block: B:75:0x0140, code lost:
        
            if (r13 == false) goto L77;
         */
        /* JADX WARN: Code restructure failed: missing block: B:76:0x0142, code lost:
        
            r14.f13836x = null;
            r14.f13837y--;
         */
        /* JADX WARN: Code restructure failed: missing block: B:77:0x014b, code lost:
        
            if (r13 == false) goto L79;
         */
        /* JADX WARN: Code restructure failed: missing block: B:79:0x014e, code lost:
        
            r2.onNext(r12);
         */
        /* JADX WARN: Code restructure failed: missing block: B:80:0x0152, code lost:
        
            r6 = move-exception;
         */
        /* JADX WARN: Code restructure failed: missing block: B:81:0x0153, code lost:
        
            re.a.throwIfFatal(r6);
            r14.f13829q.addThrowable(r6);
            r14.f13836x = null;
            r14.f13837y--;
         */
        /* JADX WARN: Code restructure failed: missing block: B:82:0x0164, code lost:
        
            r5 = addAndGet(-r5);
         */
        /* JADX WARN: Code restructure failed: missing block: B:83:0x0169, code lost:
        
            if (r5 != 0) goto L103;
         */
        /* JADX WARN: Code restructure failed: missing block: B:84:0x016b, code lost:
        
            return;
         */
        @Override // we.i
        /*
            Code decompiled incorrectly, please refer to instructions dump.
            To view partially-correct code enable 'Show inconsistent code' option in preferences
        */
        public void drain() {
            /*
                Method dump skipped, instructions count: 364
                To view this dump change 'Code comments level' option to 'DEBUG'
            */
            throw new UnsupportedOperationException("Method not decompiled: io.reactivex.internal.operators.observable.ObservableConcatMapEager.ConcatMapEagerMainObserver.drain():void");
        }

        @Override // we.i
        public void innerComplete(InnerQueuedObserver<R> innerQueuedObserver) {
            innerQueuedObserver.setDone();
            drain();
        }

        @Override // we.i
        public void innerError(InnerQueuedObserver<R> innerQueuedObserver, Throwable th2) {
            if (!this.f13829q.addThrowable(th2)) {
                ff.a.onError(th2);
                return;
            }
            if (this.f13828p == ErrorMode.IMMEDIATE) {
                this.f13832t.dispose();
            }
            innerQueuedObserver.setDone();
            drain();
        }

        @Override // we.i
        public void innerNext(InnerQueuedObserver<R> innerQueuedObserver, R r10) {
            innerQueuedObserver.queue().offer(r10);
            drain();
        }

        @Override // ne.q
        public void onComplete() {
            this.f13833u = true;
            drain();
        }

        @Override // ne.q
        public void onError(Throwable th2) {
            if (!this.f13829q.addThrowable(th2)) {
                ff.a.onError(th2);
            } else {
                this.f13833u = true;
                drain();
            }
        }

        @Override // ne.q
        public void onNext(T t10) {
            if (this.f13834v == 0) {
                this.f13831s.offer(t10);
            }
            drain();
        }

        @Override // ne.q
        public void onSubscribe(b bVar) {
            if (DisposableHelper.validate(this.f13832t, bVar)) {
                this.f13832t = bVar;
                if (bVar instanceof ve.b) {
                    ve.b bVar2 = (ve.b) bVar;
                    int iRequestFusion = bVar2.requestFusion(3);
                    if (iRequestFusion == 1) {
                        this.f13834v = iRequestFusion;
                        this.f13831s = bVar2;
                        this.f13833u = true;
                        this.f13824b.onSubscribe(this);
                        drain();
                        return;
                    }
                    if (iRequestFusion == 2) {
                        this.f13834v = iRequestFusion;
                        this.f13831s = bVar2;
                        this.f13824b.onSubscribe(this);
                        return;
                    }
                }
                this.f13831s = new af.a(this.f13827o);
                this.f13824b.onSubscribe(this);
            }
        }
    }

    public ObservableConcatMapEager(o<T> oVar, n<? super T, ? extends o<? extends R>> nVar, ErrorMode errorMode, int i10, int i11) {
        super(oVar);
        this.f13820m = nVar;
        this.f13821n = errorMode;
        this.f13822o = i10;
        this.f13823p = i11;
    }

    @Override // ne.k
    public void subscribeActual(q<? super R> qVar) {
        this.f22058b.subscribe(new ConcatMapEagerMainObserver(qVar, this.f13820m, this.f13822o, this.f13823p, this.f13821n));
    }
}
