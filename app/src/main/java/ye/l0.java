package ye;

import io.reactivex.internal.disposables.EmptyDisposable;
import java.util.Iterator;

/* compiled from: ObservableFromIterable.java */
/* loaded from: classes2.dex */
public final class l0<T> extends ne.k<T> {

    /* renamed from: b, reason: collision with root package name */
    public final Iterable<? extends T> f22251b;

    /* compiled from: ObservableFromIterable.java */
    public static final class a<T> extends we.b<T> {

        /* renamed from: b, reason: collision with root package name */
        public final ne.q<? super T> f22252b;

        /* renamed from: m, reason: collision with root package name */
        public final Iterator<? extends T> f22253m;

        /* renamed from: n, reason: collision with root package name */
        public volatile boolean f22254n;

        /* renamed from: o, reason: collision with root package name */
        public boolean f22255o;

        /* renamed from: p, reason: collision with root package name */
        public boolean f22256p;

        /* renamed from: q, reason: collision with root package name */
        public boolean f22257q;

        public a(ne.q<? super T> qVar, Iterator<? extends T> it) {
            this.f22252b = qVar;
            this.f22253m = it;
        }

        @Override // ve.f
        public void clear() {
            this.f22256p = true;
        }

        @Override // qe.b
        public void dispose() {
            this.f22254n = true;
        }

        public boolean isDisposed() {
            return this.f22254n;
        }

        @Override // ve.f
        public boolean isEmpty() {
            return this.f22256p;
        }

        @Override // ve.f
        public T poll() {
            if (this.f22256p) {
                return null;
            }
            boolean z10 = this.f22257q;
            Iterator<? extends T> it = this.f22253m;
            if (!z10) {
                this.f22257q = true;
            } else if (!it.hasNext()) {
                this.f22256p = true;
                return null;
            }
            return (T) ue.a.requireNonNull(it.next(), "The iterator returned a null value");
        }

        @Override // ve.c
        public int requestFusion(int i10) {
            if ((i10 & 1) == 0) {
                return 0;
            }
            this.f22255o = true;
            return 1;
        }
    }

    public l0(Iterable<? extends T> iterable) {
        this.f22251b = iterable;
    }

    @Override // ne.k
    public void subscribeActual(ne.q<? super T> qVar) {
        try {
            Iterator<? extends T> it = this.f22251b.iterator();
            try {
                if (!it.hasNext()) {
                    EmptyDisposable.complete(qVar);
                    return;
                }
                a aVar = new a(qVar, it);
                qVar.onSubscribe(aVar);
                if (aVar.f22255o) {
                    return;
                }
                Iterator<? extends T> it2 = aVar.f22253m;
                ne.q<? super T> qVar2 = aVar.f22252b;
                while (!aVar.isDisposed()) {
                    try {
                        qVar2.onNext((Object) ue.a.requireNonNull(it2.next(), "The iterator returned a null value"));
                        if (aVar.isDisposed()) {
                            return;
                        }
                        try {
                            if (!it2.hasNext()) {
                                if (aVar.isDisposed()) {
                                    return;
                                }
                                qVar2.onComplete();
                                return;
                            }
                        } catch (Throwable th2) {
                            re.a.throwIfFatal(th2);
                            qVar2.onError(th2);
                            return;
                        }
                    } catch (Throwable th3) {
                        re.a.throwIfFatal(th3);
                        qVar2.onError(th3);
                        return;
                    }
                }
            } catch (Throwable th4) {
                re.a.throwIfFatal(th4);
                EmptyDisposable.error(th4, qVar);
            }
        } catch (Throwable th5) {
            re.a.throwIfFatal(th5);
            EmptyDisposable.error(th5, qVar);
        }
    }
}
