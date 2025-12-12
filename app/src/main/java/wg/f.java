package wg;

import java.util.Timer;
import java.util.TimerTask;

/* loaded from: classes2.dex */
public final class f extends TimerTask {

    /* renamed from: b, reason: collision with root package name */
    public final /* synthetic */ g f21164b;

    public f(g gVar) {
        this.f21164b = gVar;
    }

    @Override // java.util.TimerTask, java.lang.Runnable
    public final void run() {
        g gVar = this.f21164b;
        Timer timer = gVar.f21175k;
        if (timer != null) {
            timer.cancel();
        }
        gVar.f21175k = null;
        if (gVar.f21174j) {
            return;
        }
        gVar.a();
    }
}
