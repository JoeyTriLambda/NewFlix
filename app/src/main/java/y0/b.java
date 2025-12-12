package y0;

import android.annotation.SuppressLint;
import android.view.accessibility.AccessibilityEvent;

/* compiled from: AccessibilityEventCompat.java */
/* loaded from: classes.dex */
public final class b {
    @SuppressLint({"WrongConstant"})
    public static int getContentChangeTypes(AccessibilityEvent accessibilityEvent) {
        return accessibilityEvent.getContentChangeTypes();
    }

    public static void setContentChangeTypes(AccessibilityEvent accessibilityEvent, int i10) {
        accessibilityEvent.setContentChangeTypes(i10);
    }
}
