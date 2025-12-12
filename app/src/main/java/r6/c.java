package r6;

import android.graphics.Rect;
import android.view.View;
import android.widget.FrameLayout;

/* compiled from: BadgeUtils.java */
/* loaded from: classes.dex */
public final class c {
    public static void attachBadgeDrawable(a aVar, View view, FrameLayout frameLayout) {
        setBadgeDrawableBounds(aVar, view, frameLayout);
        if (aVar.getCustomBadgeParent() != null) {
            aVar.getCustomBadgeParent().setForeground(aVar);
        } else {
            view.getOverlay().add(aVar);
        }
    }

    public static void detachBadgeDrawable(a aVar, View view) {
        if (aVar == null) {
            return;
        }
        if (aVar.getCustomBadgeParent() != null) {
            aVar.getCustomBadgeParent().setForeground(null);
        } else {
            view.getOverlay().remove(aVar);
        }
    }

    public static void setBadgeDrawableBounds(a aVar, View view, FrameLayout frameLayout) {
        Rect rect = new Rect();
        view.getDrawingRect(rect);
        aVar.setBounds(rect);
        aVar.updateBadgeCoordinates(view, frameLayout);
    }

    public static void updateBadgeBounds(Rect rect, float f10, float f11, float f12, float f13) {
        rect.set((int) (f10 - f12), (int) (f11 - f13), (int) (f10 + f12), (int) (f11 + f13));
    }
}
