package io.reactivex.internal.operators.observable;

import io.reactivex.internal.disposables.DisposableHelper;
import java.util.concurrent.atomic.AtomicReference;
import ne.d;
import ne.k;
import ne.m;
import ne.q;
import qe.b;

/* loaded from: classes2.dex */
public final class ObservableCreate<T> extends k<T> {

    public static final class CreateEmitter<T> extends AtomicReference<b> implements d, b {
        private static final long serialVersionUID = -3434801548987643227L;

        /* renamed from: b, reason: collision with root package name */
        public final q<? super T> f13850b;

        public CreateEmitter(q<? super T> qVar) {
            this.f13850b = qVar;
        }

        @Override // qe.b
        public void dispose() {
            DisposableHelper.dispose(this);
        }

        public boolean isDisposed() {
            return DisposableHelper.isDisposed(get());
        }

        public void onError(Throwable th2) {
            if (tryOnError(th2)) {
                return;
            }
            ff.a.onError(th2);
        }

        @Override // java.util.concurrent.atomic.AtomicReference
        public String toString() {
            return String.format("%s{%s}", CreateEmitter.class.getSimpleName(), super.toString());
        }

        public boolean tryOnError(Throwable th2) {
            if (th2 == null) {
                th2 = new NullPointerException("onError called with null. Null values are generally not allowed in 2.x operators and sources.");
            }
            if (isDisposed()) {
                return false;
            }
            try {
                this.f13850b.onError(th2);
                dispose();
                return true;
            } catch (Throwable th3) {
                dispose();
                throw th3;
            }
        }
    }

    public ObservableCreate(m<T> mVar) {
    }

    @Override // ne.k
    public void subscribeActual(q<? super T> qVar) {
        CreateEmitter createEmitter = new CreateEmitter(qVar);
        qVar.onSubscribe(createEmitter);
        try {
            throw null;
        } catch (Throwable th2) {
            re.a.throwIfFatal(th2);
            createEmitter.onError(th2);
        }
    }
}
