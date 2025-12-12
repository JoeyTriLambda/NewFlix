package io.reactivex.internal.util;

import java.util.concurrent.atomic.AtomicReference;

/* loaded from: classes2.dex */
public final class AtomicThrowable extends AtomicReference<Throwable> {
    private static final long serialVersionUID = 3949248817947090603L;

    public boolean addThrowable(Throwable th2) {
        return ExceptionHelper.addThrowable(this, th2);
    }

    public Throwable terminate() {
        return ExceptionHelper.terminate(this);
    }
}
