package df;

import io.reactivex.internal.operators.observable.ObservablePublishAlt;
import io.reactivex.internal.operators.observable.ObservableRefCount;
import ne.k;
import se.f;
import ye.c1;

/* compiled from: ConnectableObservable.java */
/* loaded from: classes2.dex */
public abstract class a<T> extends k<T> {
    public abstract void connect(f<? super qe.b> fVar);

    /* JADX WARN: Multi-variable type inference failed */
    public k<T> refCount() {
        return ff.a.onAssembly(new ObservableRefCount(this instanceof c1 ? ff.a.onAssembly((a) new ObservablePublishAlt(((c1) this).publishSource())) : this));
    }
}
