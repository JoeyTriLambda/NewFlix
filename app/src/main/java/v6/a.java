package v6;

import android.graphics.Canvas;
import android.os.Build;

/* compiled from: CanvasCompat.java */
/* loaded from: classes.dex */
public final class a {

    /* compiled from: CanvasCompat.java */
    /* renamed from: v6.a$a, reason: collision with other inner class name */
    public interface InterfaceC0296a {
    }

    public static int saveLayerAlpha(Canvas canvas, float f10, float f11, float f12, float f13, int i10) {
        return Build.VERSION.SDK_INT > 21 ? canvas.saveLayerAlpha(f10, f11, f12, f13, i10) : canvas.saveLayerAlpha(f10, f11, f12, f13, i10, 31);
    }
}
