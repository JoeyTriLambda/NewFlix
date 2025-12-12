package io.reactivex.internal.operators.observable;

import io.reactivex.internal.disposables.DisposableHelper;
import io.reactivex.internal.disposables.EmptyDisposable;
import java.util.ArrayDeque;
import java.util.Collection;
import java.util.Iterator;
import java.util.concurrent.Callable;
import java.util.concurrent.atomic.AtomicBoolean;
import ne.o;
import ne.q;
import qe.b;

/* loaded from: classes2.dex */
public final class ObservableBuffer<T, U extends Collection<? super T>> extends ye.a<T, U> {

    /* renamed from: m, reason: collision with root package name */
    public final int f13720m;

    /* renamed from: n, reason: collision with root package name */
    public final int f13721n;

    /* renamed from: o, reason: collision with root package name */
    public final Callable<U> f13722o;

    public static final class BufferSkipObserver<T, U extends Collection<? super T>> extends AtomicBoolean implements q<T>, b {
        private static final long serialVersionUID = -8223395059921494546L;

        /* renamed from: b, reason: collision with root package name */
        public final q<? super U> f13723b;

        /* renamed from: m, reason: collision with root package name */
        public final int f13724m;

        /* renamed from: n, reason: collision with root package name */
        public final int f13725n;

        /* renamed from: o, reason: collision with root package name */
        public final Callable<U> f13726o;

        /* renamed from: p, reason: collision with root package name */
        public b f13727p;

        /* renamed from: q, reason: collision with root package name */
        public final ArrayDeque<U> f13728q = new ArrayDeque<>();

        /* renamed from: r, reason: collision with root package name */
        public long f13729r;

        public BufferSkipObserver(q<? super U> qVar, int i10, int i11, Callable<U> callable) {
            this.f13723b = qVar;
            this.f13724m = i10;
            this.f13725n = i11;
            this.f13726o = callable;
        }

        @Override // qe.b
        public void dispose() {
            this.f13727p.dispose();
        }

        @Override // ne.q
        public void onComplete() {
            while (true) {
                ArrayDeque<U> arrayDeque = this.f13728q;
                boolean zIsEmpty = arrayDeque.isEmpty();
                q<? super U> qVar = this.f13723b;
                if (zIsEmpty) {
                    qVar.onComplete();
                    return;
                }
                qVar.onNext(arrayDeque.poll());
            }
        }

        @Override // ne.q
        public void onError(Throwable th2) {
            this.f13728q.clear();
            this.f13723b.onError(th2);
        }

        @Override // ne.q
        public void onNext(T t10) {
            long j10 = this.f13729r;
            this.f13729r = 1 + j10;
            long j11 = j10 % this.f13725n;
            q<? super U> qVar = this.f13723b;
            ArrayDeque<U> arrayDeque = this.f13728q;
            if (j11 == 0) {
                try {
                    arrayDeque.offer((Collection) ue.a.requireNonNull(this.f13726o.call(), "The bufferSupplier returned a null collection. Null values are generally not allowed in 2.x operators and sources."));
                } catch (Throwable th2) {
                    arrayDeque.clear();
                    this.f13727p.dispose();
                    qVar.onError(th2);
                    return;
                }
            }
            Iterator it = arrayDeque.iterator();
            while (it.hasNext()) {
                Collection collection = (Collection) it.next();
                collection.add(t10);
                if (this.f13724m <= collection.size()) {
                    it.remove();
                    qVar.onNext(collection);
                }
            }
        }

        @Override // ne.q
        public void onSubscribe(b bVar) {
            if (DisposableHelper.validate(this.f13727p, bVar)) {
                this.f13727p = bVar;
                this.f13723b.onSubscribe(this);
            }
        }
    }

    public static final class a<T, U extends Collection<? super T>> implements q<T>, b {

        /* renamed from: b, reason: collision with root package name */
        public final q<? super U> f13730b;

        /* renamed from: m, reason: collision with root package name */
        public final int f13731m;

        /* renamed from: n, reason: collision with root package name */
        public final Callable<U> f13732n;

        /* renamed from: o, reason: collision with root package name */
        public U f13733o;

        /* renamed from: p, reason: collision with root package name */
        public int f13734p;

        /* renamed from: q, reason: collision with root package name */
        public b f13735q;

        public a(q<? super U> qVar, int i10, Callable<U> callable) {
            this.f13730b = qVar;
            this.f13731m = i10;
            this.f13732n = callable;
        }

        public final boolean a() {
            try {
                this.f13733o = (U) ue.a.requireNonNull(this.f13732n.call(), "Empty buffer supplied");
                return true;
            } catch (Throwable th2) {
                re.a.throwIfFatal(th2);
                this.f13733o = null;
                b bVar = this.f13735q;
                q<? super U> qVar = this.f13730b;
                if (bVar == null) {
                    EmptyDisposable.error(th2, qVar);
                    return false;
                }
                bVar.dispose();
                qVar.onError(th2);
                return false;
            }
        }

        @Override // qe.b
        public void dispose() {
            this.f13735q.dispose();
        }

        @Override // ne.q
        public void onComplete() {
            U u10 = this.f13733o;
            if (u10 != null) {
                this.f13733o = null;
                boolean zIsEmpty = u10.isEmpty();
                q<? super U> qVar = this.f13730b;
                if (!zIsEmpty) {
                    qVar.onNext(u10);
                }
                qVar.onComplete();
            }
        }

        @Override // ne.q
        public void onError(Throwable th2) {
            this.f13733o = null;
            this.f13730b.onError(th2);
        }

        @Override // ne.q
        public void onNext(T t10) {
            U u10 = this.f13733o;
            if (u10 != null) {
                u10.add(t10);
                int i10 = this.f13734p + 1;
                this.f13734p = i10;
                if (i10 >= this.f13731m) {
                    this.f13730b.onNext(u10);
                    this.f13734p = 0;
                    a();
                }
            }
        }

        @Override // ne.q
        public void onSubscribe(b bVar) {
            if (DisposableHelper.validate(this.f13735q, bVar)) {
                this.f13735q = bVar;
                this.f13730b.onSubscribe(this);
            }
        }
    }

    public ObservableBuffer(o<T> oVar, int i10, int i11, Callable<U> callable) {
        super(oVar);
        this.f13720m = i10;
        this.f13721n = i11;
        this.f13722o = callable;
    }

    @Override // ne.k
    public void subscribeActual(q<? super U> qVar) {
        Callable<U> callable = this.f13722o;
        o<T> oVar = this.f22058b;
        int i10 = this.f13721n;
        int i11 = this.f13720m;
        if (i10 != i11) {
            oVar.subscribe(new BufferSkipObserver(qVar, i11, i10, callable));
            return;
        }
        a aVar = new a(qVar, i11, callable);
        if (aVar.a()) {
            oVar.subscribe(aVar);
        }
    }
}
