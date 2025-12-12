package x0;

import android.view.MotionEvent;

/* compiled from: MotionEventCompat.java */
/* loaded from: classes.dex */
public final class p {
    @Deprecated
    public static int getActionIndex(MotionEvent motionEvent) {
        return motionEvent.getActionIndex();
    }

    @Deprecated
    public static int getActionMasked(MotionEvent motionEvent) {
        return motionEvent.getActionMasked();
    }

    public static boolean isFromSource(MotionEvent motionEvent, int i10) {
        return (motionEvent.getSource() & i10) == i10;
    }
}
