package androidx.activity;

import android.window.BackEvent;

/* compiled from: BackEventCompat.kt */
/* loaded from: classes.dex */
public final class a {

    /* renamed from: a, reason: collision with root package name */
    public static final a f801a = new a();

    public final BackEvent createOnBackEvent(float f10, float f11, float f12, int i10) {
        return new BackEvent(f10, f11, f12, i10);
    }

    public final float progress(BackEvent backEvent) {
        zf.i.checkNotNullParameter(backEvent, "backEvent");
        return backEvent.getProgress();
    }

    public final int swipeEdge(BackEvent backEvent) {
        zf.i.checkNotNullParameter(backEvent, "backEvent");
        return backEvent.getSwipeEdge();
    }

    public final float touchX(BackEvent backEvent) {
        zf.i.checkNotNullParameter(backEvent, "backEvent");
        return backEvent.getTouchX();
    }

    public final float touchY(BackEvent backEvent) {
        zf.i.checkNotNullParameter(backEvent, "backEvent");
        return backEvent.getTouchY();
    }
}
