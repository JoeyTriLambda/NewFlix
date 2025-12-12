package io.reactivex.internal.disposables;

import java.util.concurrent.atomic.AtomicReferenceArray;
import qe.b;

/* loaded from: classes2.dex */
public final class ArrayCompositeDisposable extends AtomicReferenceArray<b> implements b {
    private static final long serialVersionUID = 2746389416410565408L;

    public ArrayCompositeDisposable(int i10) {
        super(i10);
    }

    @Override // qe.b
    public void dispose() {
        b andSet;
        b bVar = get(0);
        DisposableHelper disposableHelper = DisposableHelper.f13533b;
        if (bVar != disposableHelper) {
            int length = length();
            for (int i10 = 0; i10 < length; i10++) {
                if (get(i10) != disposableHelper && (andSet = getAndSet(i10, disposableHelper)) != disposableHelper && andSet != null) {
                    andSet.dispose();
                }
            }
        }
    }

    public boolean setResource(int i10, b bVar) {
        b bVar2;
        do {
            bVar2 = get(i10);
            if (bVar2 == DisposableHelper.f13533b) {
                bVar.dispose();
                return false;
            }
        } while (!compareAndSet(i10, bVar2, bVar));
        if (bVar2 == null) {
            return true;
        }
        bVar2.dispose();
        return true;
    }
}
