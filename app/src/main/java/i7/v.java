package i7;

import android.content.Context;
import android.graphics.Point;
import android.graphics.Rect;
import android.os.Build;
import android.view.Display;
import android.view.WindowManager;

/* compiled from: WindowUtils.java */
/* loaded from: classes.dex */
public final class v {
    public static Rect getCurrentWindowBounds(Context context) {
        WindowManager windowManager = (WindowManager) context.getSystemService("window");
        if (Build.VERSION.SDK_INT >= 30) {
            return windowManager.getCurrentWindowMetrics().getBounds();
        }
        Display defaultDisplay = windowManager.getDefaultDisplay();
        Point point = new Point();
        defaultDisplay.getRealSize(point);
        Rect rect = new Rect();
        rect.right = point.x;
        rect.bottom = point.y;
        return rect;
    }
}
