package lg;

import android.os.Build;
import android.os.Handler;
import android.os.Looper;
import android.view.Choreographer;
import java.lang.reflect.InvocationTargetException;
import kotlin.Result;
import kotlinx.coroutines.android.HandlerContext;
import lf.f;
import zf.i;

/* compiled from: HandlerDispatcher.kt */
/* loaded from: classes2.dex */
public final class e {
    private static volatile Choreographer choreographer;

    static {
        Object objM59constructorimpl;
        byte b10 = 0;
        byte b11 = 0;
        try {
            int i10 = Result.f15189m;
            objM59constructorimpl = Result.m59constructorimpl(new HandlerContext(asHandler(Looper.getMainLooper(), true), b11 == true ? 1 : 0, 2, b10 == true ? 1 : 0));
        } catch (Throwable th2) {
            int i11 = Result.f15189m;
            objM59constructorimpl = Result.m59constructorimpl(f.createFailure(th2));
        }
    }

    public static final Handler asHandler(Looper looper, boolean z10) throws IllegalAccessException, IllegalArgumentException, InvocationTargetException {
        if (!z10) {
            return new Handler(looper);
        }
        if (Build.VERSION.SDK_INT < 28) {
            try {
                return (Handler) Handler.class.getDeclaredConstructor(Looper.class, Handler.Callback.class, Boolean.TYPE).newInstance(looper, null, Boolean.TRUE);
            } catch (NoSuchMethodException unused) {
                return new Handler(looper);
            }
        }
        Object objInvoke = Handler.class.getDeclaredMethod("createAsync", Looper.class).invoke(null, looper);
        i.checkNotNull(objInvoke, "null cannot be cast to non-null type android.os.Handler");
        return (Handler) objInvoke;
    }
}
