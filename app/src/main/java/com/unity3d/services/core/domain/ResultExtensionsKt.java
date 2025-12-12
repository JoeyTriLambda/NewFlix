package com.unity3d.services.core.domain;

import com.unity3d.services.core.domain.task.InitializationException;
import kotlin.Result;
import zf.i;

/* compiled from: ResultExtensions.kt */
/* loaded from: classes2.dex */
public final class ResultExtensionsKt {
    public static final /* synthetic */ <E extends Exception> E getCustomExceptionOrNull(Object obj) {
        Throwable thM61exceptionOrNullimpl = Result.m61exceptionOrNullimpl(obj);
        i.reifiedOperationMarker(3, "E");
        if (thM61exceptionOrNullimpl instanceof Exception) {
            return (E) thM61exceptionOrNullimpl;
        }
        return null;
    }

    public static final /* synthetic */ <E extends Exception> E getCustomExceptionOrThrow(Object obj) {
        Throwable thM61exceptionOrNullimpl = Result.m61exceptionOrNullimpl(obj);
        i.reifiedOperationMarker(3, "E");
        if (thM61exceptionOrNullimpl instanceof Exception) {
            return (E) thM61exceptionOrNullimpl;
        }
        throw new IllegalArgumentException("Wrong Exception type found");
    }

    public static final InitializationException getInitializationExceptionOrNull(Object obj) {
        Throwable thM61exceptionOrNullimpl = Result.m61exceptionOrNullimpl(obj);
        if (thM61exceptionOrNullimpl instanceof InitializationException) {
            return (InitializationException) thM61exceptionOrNullimpl;
        }
        return null;
    }

    public static final InitializationException getInitializationExceptionOrThrow(Object obj) {
        Throwable thM61exceptionOrNullimpl = Result.m61exceptionOrNullimpl(obj);
        if (thM61exceptionOrNullimpl instanceof InitializationException) {
            return (InitializationException) thM61exceptionOrNullimpl;
        }
        throw new IllegalArgumentException("Wrong Exception type found");
    }
}
