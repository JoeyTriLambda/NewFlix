package ai;

import android.os.Handler;
import android.os.Looper;
import android.os.Message;
import java.lang.ref.WeakReference;
import java.util.Iterator;

/* compiled from: InvalidationHandler.java */
/* loaded from: classes2.dex */
public final class c extends Handler {

    /* renamed from: a, reason: collision with root package name */
    public final WeakReference<pl.droidsonroids.gif.a> f736a;

    public c(pl.droidsonroids.gif.a aVar) {
        super(Looper.getMainLooper());
        this.f736a = new WeakReference<>(aVar);
    }

    @Override // android.os.Handler
    public void handleMessage(Message message) {
        pl.droidsonroids.gif.a aVar = this.f736a.get();
        if (aVar == null) {
            return;
        }
        if (message.what == -1) {
            aVar.invalidateSelf();
            return;
        }
        Iterator<a> it = aVar.f17756s.iterator();
        while (it.hasNext()) {
            it.next().onAnimationCompleted(message.what);
        }
    }
}
