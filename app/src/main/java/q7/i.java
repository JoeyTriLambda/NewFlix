package q7;

import android.graphics.drawable.Drawable;
import android.view.View;

/* compiled from: MaterialShapeUtils.java */
/* loaded from: classes.dex */
public final class i {
    public static d a(int i10) {
        return i10 != 0 ? i10 != 1 ? new k() : new e() : new k();
    }

    public static void setElevation(View view, float f10) {
        Drawable background = view.getBackground();
        if (background instanceof g) {
            ((g) background).setElevation(f10);
        }
    }

    public static void setParentAbsoluteElevation(View view) {
        Drawable background = view.getBackground();
        if (background instanceof g) {
            setParentAbsoluteElevation(view, (g) background);
        }
    }

    public static void setParentAbsoluteElevation(View view, g gVar) {
        if (gVar.isElevationOverlayEnabled()) {
            gVar.setParentAbsoluteElevation(i7.t.getParentAbsoluteElevation(view));
        }
    }
}
