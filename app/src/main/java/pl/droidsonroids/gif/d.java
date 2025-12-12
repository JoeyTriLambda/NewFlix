package pl.droidsonroids.gif;

import ai.e;
import android.os.SystemClock;
import java.util.concurrent.TimeUnit;

/* compiled from: RenderTask.java */
/* loaded from: classes2.dex */
public final class d extends e {
    public d(a aVar) {
        super(aVar);
    }

    @Override // ai.e
    public void doWork() {
        a aVar = this.f738b;
        long jN = aVar.f17755r.n(aVar.f17754q);
        if (jN >= 0) {
            this.f738b.f17751n = SystemClock.uptimeMillis() + jN;
            if (this.f738b.isVisible() && this.f738b.f17750m) {
                a aVar2 = this.f738b;
                if (!aVar2.f17760w) {
                    aVar2.f17749b.remove(this);
                    a aVar3 = this.f738b;
                    aVar3.A = aVar3.f17749b.schedule(this, jN, TimeUnit.MILLISECONDS);
                }
            }
            if (!this.f738b.f17756s.isEmpty() && this.f738b.getCurrentFrameIndex() == this.f738b.f17755r.h() - 1) {
                a aVar4 = this.f738b;
                aVar4.f17761x.sendEmptyMessageAtTime(aVar4.getCurrentLoop(), this.f738b.f17751n);
            }
        } else {
            a aVar5 = this.f738b;
            aVar5.f17751n = Long.MIN_VALUE;
            aVar5.f17750m = false;
        }
        if (!this.f738b.isVisible() || this.f738b.f17761x.hasMessages(-1)) {
            return;
        }
        this.f738b.f17761x.sendEmptyMessageAtTime(-1, 0L);
    }
}
