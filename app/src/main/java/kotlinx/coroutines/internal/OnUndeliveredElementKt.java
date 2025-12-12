package kotlinx.coroutines.internal;

import java.lang.reflect.InvocationTargetException;
import kg.f0;
import kotlin.coroutines.CoroutineContext;
import lf.h;
import yf.l;

/* compiled from: OnUndeliveredElement.kt */
/* loaded from: classes2.dex */
public final class OnUndeliveredElementKt {
    public static final <E> l<Throwable, h> bindCancellationFun(final l<? super E, h> lVar, final E e10, final CoroutineContext coroutineContext) {
        return new l<Throwable, h>() { // from class: kotlinx.coroutines.internal.OnUndeliveredElementKt.bindCancellationFun.1
            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            /* JADX WARN: Multi-variable type inference failed */
            {
                super(1);
            }

            @Override // yf.l
            public /* bridge */ /* synthetic */ h invoke(Throwable th2) throws IllegalAccessException, IllegalArgumentException, InvocationTargetException {
                invoke2(th2);
                return h.f16056a;
            }

            /* renamed from: invoke, reason: avoid collision after fix types in other method */
            public final void invoke2(Throwable th2) throws IllegalAccessException, IllegalArgumentException, InvocationTargetException {
                OnUndeliveredElementKt.callUndeliveredElement(lVar, e10, coroutineContext);
            }
        };
    }

    public static final <E> void callUndeliveredElement(l<? super E, h> lVar, E e10, CoroutineContext coroutineContext) throws IllegalAccessException, IllegalArgumentException, InvocationTargetException {
        UndeliveredElementException undeliveredElementExceptionCallUndeliveredElementCatchingException = callUndeliveredElementCatchingException(lVar, e10, null);
        if (undeliveredElementExceptionCallUndeliveredElementCatchingException != null) {
            f0.handleCoroutineException(coroutineContext, undeliveredElementExceptionCallUndeliveredElementCatchingException);
        }
    }

    /* JADX WARN: Multi-variable type inference failed */
    public static final <E> UndeliveredElementException callUndeliveredElementCatchingException(l<? super E, h> lVar, E e10, UndeliveredElementException undeliveredElementException) throws IllegalAccessException, IllegalArgumentException, InvocationTargetException {
        try {
            lVar.invoke(e10);
        } catch (Throwable th2) {
            if (undeliveredElementException == null || undeliveredElementException.getCause() == th2) {
                return new UndeliveredElementException("Exception in undelivered element handler for " + e10, th2);
            }
            lf.a.addSuppressed(undeliveredElementException, th2);
        }
        return undeliveredElementException;
    }

    public static /* synthetic */ UndeliveredElementException callUndeliveredElementCatchingException$default(l lVar, Object obj, UndeliveredElementException undeliveredElementException, int i10, Object obj2) {
        if ((i10 & 2) != 0) {
            undeliveredElementException = null;
        }
        return callUndeliveredElementCatchingException(lVar, obj, undeliveredElementException);
    }
}
