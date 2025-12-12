package x0;

import android.content.Context;
import android.view.MotionEvent;
import android.view.VelocityTracker;
import androidx.core.widget.NestedScrollView;

/* compiled from: DifferentialMotionFlingController.java */
/* loaded from: classes.dex */
public final class d {

    /* renamed from: a, reason: collision with root package name */
    public final Context f21248a;

    /* renamed from: b, reason: collision with root package name */
    public final e f21249b;

    /* renamed from: c, reason: collision with root package name */
    public final b f21250c;

    /* renamed from: d, reason: collision with root package name */
    public final a f21251d;

    /* renamed from: e, reason: collision with root package name */
    public VelocityTracker f21252e;

    /* renamed from: f, reason: collision with root package name */
    public float f21253f;

    /* renamed from: g, reason: collision with root package name */
    public int f21254g;

    /* renamed from: h, reason: collision with root package name */
    public int f21255h;

    /* renamed from: i, reason: collision with root package name */
    public int f21256i;

    /* renamed from: j, reason: collision with root package name */
    public final int[] f21257j;

    /* compiled from: DifferentialMotionFlingController.java */
    public interface a {
    }

    /* compiled from: DifferentialMotionFlingController.java */
    public interface b {
    }

    public d(Context context, e eVar) {
        pd.a aVar = new pd.a(0);
        pd.a aVar2 = new pd.a(1);
        this.f21254g = -1;
        this.f21255h = -1;
        this.f21256i = -1;
        this.f21257j = new int[]{Integer.MAX_VALUE, 0};
        this.f21248a = context;
        this.f21249b = eVar;
        this.f21250c = aVar;
        this.f21251d = aVar2;
    }

    public void onMotionEvent(MotionEvent motionEvent, int i10) {
        boolean z10;
        int source = motionEvent.getSource();
        int deviceId = motionEvent.getDeviceId();
        int i11 = this.f21255h;
        int[] iArr = this.f21257j;
        if (i11 == source && this.f21256i == deviceId && this.f21254g == i10) {
            z10 = false;
        } else {
            ((pd.a) this.f21250c).a(this.f21248a, iArr, motionEvent, i10);
            this.f21255h = source;
            this.f21256i = deviceId;
            this.f21254g = i10;
            z10 = true;
        }
        if (iArr[0] == Integer.MAX_VALUE) {
            VelocityTracker velocityTracker = this.f21252e;
            if (velocityTracker != null) {
                velocityTracker.recycle();
                this.f21252e = null;
                return;
            }
            return;
        }
        if (this.f21252e == null) {
            this.f21252e = VelocityTracker.obtain();
        }
        float fD = ((pd.a) this.f21251d).d(this.f21252e, motionEvent, i10);
        e eVar = this.f21249b;
        float scaledScrollFactor = ((NestedScrollView.c) eVar).getScaledScrollFactor() * fD;
        float fSignum = Math.signum(scaledScrollFactor);
        if (z10 || (fSignum != Math.signum(this.f21253f) && fSignum != 0.0f)) {
            ((NestedScrollView.c) eVar).stopDifferentialMotionFling();
        }
        if (Math.abs(scaledScrollFactor) < iArr[0]) {
            return;
        }
        float fMax = Math.max(-r8, Math.min(scaledScrollFactor, iArr[1]));
        this.f21253f = ((NestedScrollView.c) eVar).startDifferentialMotionFling(fMax) ? fMax : 0.0f;
    }
}
