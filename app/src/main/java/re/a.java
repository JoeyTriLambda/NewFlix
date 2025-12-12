package re;

import io.reactivex.internal.util.ExceptionHelper;

/* compiled from: Exceptions.java */
/* loaded from: classes2.dex */
public final class a {
    public static RuntimeException propagate(Throwable th2) {
        throw ExceptionHelper.wrapOrThrow(th2);
    }

    public static void throwIfFatal(Throwable th2) {
        if (th2 instanceof VirtualMachineError) {
            throw ((VirtualMachineError) th2);
        }
        if (th2 instanceof ThreadDeath) {
            throw ((ThreadDeath) th2);
        }
        if (th2 instanceof LinkageError) {
            throw ((LinkageError) th2);
        }
    }
}
