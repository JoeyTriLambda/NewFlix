package d1;

import android.content.Context;
import android.os.Build;
import android.util.AttributeSet;
import android.widget.EdgeEffect;

/* compiled from: EdgeEffectCompat.java */
/* loaded from: classes.dex */
public final class d {

    /* compiled from: EdgeEffectCompat.java */
    public static class a {
        public static void a(EdgeEffect edgeEffect, float f10, float f11) {
            edgeEffect.onPull(f10, f11);
        }
    }

    /* compiled from: EdgeEffectCompat.java */
    public static class b {
        public static EdgeEffect create(Context context, AttributeSet attributeSet) {
            try {
                return new EdgeEffect(context, attributeSet);
            } catch (Throwable unused) {
                return new EdgeEffect(context);
            }
        }

        public static float getDistance(EdgeEffect edgeEffect) {
            try {
                return edgeEffect.getDistance();
            } catch (Throwable unused) {
                return 0.0f;
            }
        }

        public static float onPullDistance(EdgeEffect edgeEffect, float f10, float f11) {
            try {
                return edgeEffect.onPullDistance(f10, f11);
            } catch (Throwable unused) {
                edgeEffect.onPull(f10, f11);
                return 0.0f;
            }
        }
    }

    public static EdgeEffect create(Context context, AttributeSet attributeSet) {
        return Build.VERSION.SDK_INT >= 31 ? b.create(context, attributeSet) : new EdgeEffect(context);
    }

    public static float getDistance(EdgeEffect edgeEffect) {
        if (Build.VERSION.SDK_INT >= 31) {
            return b.getDistance(edgeEffect);
        }
        return 0.0f;
    }

    public static void onPull(EdgeEffect edgeEffect, float f10, float f11) {
        a.a(edgeEffect, f10, f11);
    }

    public static float onPullDistance(EdgeEffect edgeEffect, float f10, float f11) {
        if (Build.VERSION.SDK_INT >= 31) {
            return b.onPullDistance(edgeEffect, f10, f11);
        }
        onPull(edgeEffect, f10, f11);
        return f10;
    }
}
