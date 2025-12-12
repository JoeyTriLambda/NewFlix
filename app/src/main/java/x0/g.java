package x0;

import android.annotation.SuppressLint;
import android.content.Context;
import android.os.Handler;
import android.view.GestureDetector;
import android.view.MotionEvent;

/* compiled from: GestureDetectorCompat.java */
@Deprecated
/* loaded from: classes.dex */
public final class g {

    /* renamed from: a, reason: collision with root package name */
    public final GestureDetector f21264a;

    public g(Context context, GestureDetector.OnGestureListener onGestureListener) {
        this(context, onGestureListener, null);
    }

    public boolean onTouchEvent(MotionEvent motionEvent) {
        return this.f21264a.onTouchEvent(motionEvent);
    }

    @SuppressLint({"KotlinPropertyAccess"})
    public void setIsLongpressEnabled(boolean z10) {
        this.f21264a.setIsLongpressEnabled(z10);
    }

    public g(Context context, GestureDetector.OnGestureListener onGestureListener, Handler handler) {
        this.f21264a = new GestureDetector(context, onGestureListener, handler);
    }
}
