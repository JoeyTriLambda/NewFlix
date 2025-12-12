package cf;

import io.reactivex.exceptions.ProtocolViolationException;
import io.reactivex.internal.disposables.DisposableHelper;
import java.util.concurrent.atomic.AtomicReference;

/* compiled from: EndConsumerHelper.java */
/* loaded from: classes2.dex */
public final class e {
    public static String composeMessage(String str) {
        return "It is not allowed to subscribe with a(n) " + str + " multiple times. Please create a fresh instance of " + str + " and subscribe that to the target source instead.";
    }

    public static void reportDoubleSubscription(Class<?> cls) {
        ff.a.onError(new ProtocolViolationException(composeMessage(cls.getName())));
    }

    public static boolean setOnce(AtomicReference<qe.b> atomicReference, qe.b bVar, Class<?> cls) {
        boolean z10;
        ue.a.requireNonNull(bVar, "next is null");
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
        if (atomicReference.get() != DisposableHelper.f13533b) {
            reportDoubleSubscription(cls);
        }
        return false;
    }

    public static boolean validate(qe.b bVar, qe.b bVar2, Class<?> cls) {
        ue.a.requireNonNull(bVar2, "next is null");
        if (bVar == null) {
            return true;
        }
        bVar2.dispose();
        if (bVar == DisposableHelper.f13533b) {
            return false;
        }
        reportDoubleSubscription(cls);
        return false;
    }
}
