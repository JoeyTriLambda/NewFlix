package io.reactivex.internal.disposables;

import ff.a;
import io.reactivex.exceptions.ProtocolViolationException;
import java.util.concurrent.atomic.AtomicReference;
import qe.b;

/* JADX WARN: Failed to restore enum class, 'enum' modifier and super class removed */
/* JADX WARN: Unknown enum class pattern. Please report as an issue! */
/* loaded from: classes2.dex */
public final class DisposableHelper implements b {

    /* renamed from: b, reason: collision with root package name */
    public static final DisposableHelper f13533b;

    /* renamed from: m, reason: collision with root package name */
    public static final /* synthetic */ DisposableHelper[] f13534m;

    static {
        DisposableHelper disposableHelper = new DisposableHelper();
        f13533b = disposableHelper;
        f13534m = new DisposableHelper[]{disposableHelper};
    }

    public static boolean isDisposed(b bVar) {
        return bVar == f13533b;
    }

    public static boolean replace(AtomicReference<b> atomicReference, b bVar) {
        boolean z10;
        do {
            b bVar2 = atomicReference.get();
            z10 = false;
            if (bVar2 == f13533b) {
                if (bVar != null) {
                    bVar.dispose();
                }
                return false;
            }
            while (true) {
                if (atomicReference.compareAndSet(bVar2, bVar)) {
                    z10 = true;
                    break;
                }
                if (atomicReference.get() != bVar2) {
                    break;
                }
            }
        } while (!z10);
        return true;
    }

    public static void reportDisposableSet() {
        a.onError(new ProtocolViolationException("Disposable already set!"));
    }

    public static boolean set(AtomicReference<b> atomicReference, b bVar) {
        b bVar2;
        boolean z10;
        do {
            bVar2 = atomicReference.get();
            z10 = false;
            if (bVar2 == f13533b) {
                if (bVar != null) {
                    bVar.dispose();
                }
                return false;
            }
            while (true) {
                if (atomicReference.compareAndSet(bVar2, bVar)) {
                    z10 = true;
                    break;
                }
                if (atomicReference.get() != bVar2) {
                    break;
                }
            }
        } while (!z10);
        if (bVar2 != null) {
            bVar2.dispose();
        }
        return true;
    }

    public static boolean setOnce(AtomicReference<b> atomicReference, b bVar) {
        boolean z10;
        ue.a.requireNonNull(bVar, "d is null");
        while (true) {
            if (atomicReference.compareAndSet(null, bVar)) {
                z10 = true;
                break;
            }
            if (atomicReference.get() != null) {
                z10 = false;
                break;
            }
        }
        if (z10) {
            return true;
        }
        bVar.dispose();
        if (atomicReference.get() != f13533b) {
            reportDisposableSet();
        }
        return false;
    }

    public static boolean trySet(AtomicReference<b> atomicReference, b bVar) {
        boolean z10;
        while (true) {
            if (atomicReference.compareAndSet(null, bVar)) {
                z10 = true;
                break;
            }
            if (atomicReference.get() != null) {
                z10 = false;
                break;
            }
        }
        if (z10) {
            return true;
        }
        if (atomicReference.get() == f13533b) {
            bVar.dispose();
        }
        return false;
    }

    public static boolean validate(b bVar, b bVar2) {
        if (bVar2 == null) {
            a.onError(new NullPointerException("next is null"));
            return false;
        }
        if (bVar == null) {
            return true;
        }
        bVar2.dispose();
        reportDisposableSet();
        return false;
    }

    public static DisposableHelper valueOf(String str) {
        return (DisposableHelper) Enum.valueOf(DisposableHelper.class, str);
    }

    public static DisposableHelper[] values() {
        return (DisposableHelper[]) f13534m.clone();
    }

    @Override // qe.b
    public void dispose() {
    }

    public static boolean dispose(AtomicReference<b> atomicReference) {
        b andSet;
        b bVar = atomicReference.get();
        DisposableHelper disposableHelper = f13533b;
        if (bVar == disposableHelper || (andSet = atomicReference.getAndSet(disposableHelper)) == disposableHelper) {
            return false;
        }
        if (andSet == null) {
            return true;
        }
        andSet.dispose();
        return true;
    }
}
