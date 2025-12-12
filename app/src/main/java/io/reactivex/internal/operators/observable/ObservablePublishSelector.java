package io.reactivex.internal.operators.observable;

import io.reactivex.internal.disposables.DisposableHelper;
import io.reactivex.internal.disposables.EmptyDisposable;
import io.reactivex.subjects.PublishSubject;
import java.util.concurrent.atomic.AtomicReference;
import ne.k;
import ne.o;
import ne.q;
import qe.b;
import se.n;

/* loaded from: classes2.dex */
public final class ObservablePublishSelector<T, R> extends ye.a<T, R> {

    /* renamed from: m, reason: collision with root package name */
    public final n<? super k<T>, ? extends o<R>> f14086m;

    public static final class TargetObserver<T, R> extends AtomicReference<b> implements q<R>, b {
        private static final long serialVersionUID = 854110278590336484L;

        /* renamed from: b, reason: collision with root package name */
        public final q<? super R> f14087b;

        /* renamed from: m, reason: collision with root package name */
        public b f14088m;

        public TargetObserver(q<? super R> qVar) {
            this.f14087b = qVar;
        }

        @Override // qe.b
        public void dispose() {
            this.f14088m.dispose();
            DisposableHelper.dispose(this);
        }

        @Override // ne.q
        public void onComplete() {
            DisposableHelper.dispose(this);
            this.f14087b.onComplete();
        }

        @Override // ne.q
        public void onError(Throwable th2) {
            DisposableHelper.dispose(this);
            this.f14087b.onError(th2);
        }

        @Override // ne.q
        public void onNext(R r10) {
            this.f14087b.onNext(r10);
        }

        @Override // ne.q
        public void onSubscribe(b bVar) {
            if (DisposableHelper.validate(this.f14088m, bVar)) {
                this.f14088m = bVar;
                this.f14087b.onSubscribe(this);
            }
        }
    }

    public static final class a<T, R> implements q<T> {

        /* renamed from: b, reason: collision with root package name */
        public final PublishSubject<T> f14089b;

        /* renamed from: m, reason: collision with root package name */
        public final AtomicReference<b> f14090m;

        public a(PublishSubject<T> publishSubject, AtomicReference<b> atomicReference) {
            this.f14089b = publishSubject;
            this.f14090m = atomicReference;
        }

        @Override // ne.q
        public void onComplete() {
            this.f14089b.onComplete();
        }

        @Override // ne.q
        public void onError(Throwable th2) {
            this.f14089b.onError(th2);
        }

        @Override // ne.q
        public void onNext(T t10) {
            this.f14089b.onNext(t10);
        }

        @Override // ne.q
        public void onSubscribe(b bVar) {
            DisposableHelper.setOnce(this.f14090m, bVar);
        }
    }

    public ObservablePublishSelector(o<T> oVar, n<? super k<T>, ? extends o<R>> nVar) {
        super(oVar);
        this.f14086m = nVar;
    }

    @Override // ne.k
    public void subscribeActual(q<? super R> qVar) {
        PublishSubject publishSubjectCreate = PublishSubject.create();
        try {
            o oVar = (o) ue.a.requireNonNull(this.f14086m.apply(publishSubjectCreate), "The selector returned a null ObservableSource");
            TargetObserver targetObserver = new TargetObserver(qVar);
            oVar.subscribe(targetObserver);
            this.f22058b.subscribe(new a(publishSubjectCreate, targetObserver));
        } catch (Throwable th2) {
            re.a.throwIfFatal(th2);
            EmptyDisposable.error(th2, qVar);
        }
    }
}
