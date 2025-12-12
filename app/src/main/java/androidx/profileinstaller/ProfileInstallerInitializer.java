package androidx.profileinstaller;

import android.content.Context;
import android.os.Build;
import android.os.Handler;
import android.os.Looper;
import android.view.Choreographer;
import java.util.Collections;
import java.util.List;
import r.x;

/* loaded from: classes.dex */
public class ProfileInstallerInitializer implements n2.a<c> {

    public static class a {
        public static void postFrameCallback(final Runnable runnable) {
            Choreographer.getInstance().postFrameCallback(new Choreographer.FrameCallback() { // from class: f2.e
                @Override // android.view.Choreographer.FrameCallback
                public final void doFrame(long j10) {
                    runnable.run();
                }
            });
        }
    }

    public static class b {
        public static Handler createAsync(Looper looper) {
            return Handler.createAsync(looper);
        }
    }

    public static class c {
    }

    @Override // n2.a
    public List<Class<? extends n2.a<?>>> dependencies() {
        return Collections.emptyList();
    }

    /* JADX WARN: Can't rename method to resolve collision */
    @Override // n2.a
    public c create(Context context) {
        if (Build.VERSION.SDK_INT < 24) {
            return new c();
        }
        a.postFrameCallback(new x(4, this, context.getApplicationContext()));
        return new c();
    }
}
