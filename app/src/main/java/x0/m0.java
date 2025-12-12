package x0;

import android.R;
import android.content.Context;
import android.content.res.Resources;
import android.os.Build;
import android.util.Log;
import android.util.TypedValue;
import android.view.InputDevice;
import android.view.ViewConfiguration;
import com.unity3d.services.core.request.metrics.MetricCommonTags;
import java.lang.reflect.Method;
import java.util.Objects;

/* compiled from: ViewConfigurationCompat.java */
/* loaded from: classes.dex */
public final class m0 {

    /* renamed from: a, reason: collision with root package name */
    public static final Method f21293a;

    /* compiled from: ViewConfigurationCompat.java */
    public static class a {
        public static float a(ViewConfiguration viewConfiguration) {
            return viewConfiguration.getScaledHorizontalScrollFactor();
        }

        public static float b(ViewConfiguration viewConfiguration) {
            return viewConfiguration.getScaledVerticalScrollFactor();
        }
    }

    /* compiled from: ViewConfigurationCompat.java */
    public static class b {
        public static int a(ViewConfiguration viewConfiguration) {
            return viewConfiguration.getScaledHoverSlop();
        }

        public static boolean b(ViewConfiguration viewConfiguration) {
            return viewConfiguration.shouldShowMenuShortcutsWhenKeyboardPresent();
        }
    }

    /* compiled from: ViewConfigurationCompat.java */
    public static class c {
        public static int a(ViewConfiguration viewConfiguration, int i10, int i11, int i12) {
            return viewConfiguration.getScaledMaximumFlingVelocity(i10, i11, i12);
        }

        public static int b(ViewConfiguration viewConfiguration, int i10, int i11, int i12) {
            return viewConfiguration.getScaledMinimumFlingVelocity(i10, i11, i12);
        }
    }

    static {
        if (Build.VERSION.SDK_INT == 25) {
            try {
                f21293a = ViewConfiguration.class.getDeclaredMethod("getScaledScrollFactor", new Class[0]);
            } catch (Exception unused) {
                Log.i("ViewConfigCompat", "Could not find method getScaledScrollFactor() on ViewConfiguration");
            }
        }
    }

    public static float a(ViewConfiguration viewConfiguration, Context context) {
        Method method;
        if (Build.VERSION.SDK_INT >= 25 && (method = f21293a) != null) {
            try {
                return ((Integer) method.invoke(viewConfiguration, new Object[0])).intValue();
            } catch (Exception unused) {
                Log.i("ViewConfigCompat", "Could not find method getScaledScrollFactor() on ViewConfiguration");
            }
        }
        TypedValue typedValue = new TypedValue();
        if (context.getTheme().resolveAttribute(R.attr.listPreferredItemHeight, typedValue, true)) {
            return typedValue.getDimension(context.getResources().getDisplayMetrics());
        }
        return 0.0f;
    }

    public static float getScaledHorizontalScrollFactor(ViewConfiguration viewConfiguration, Context context) {
        return Build.VERSION.SDK_INT >= 26 ? a.a(viewConfiguration) : a(viewConfiguration, context);
    }

    public static int getScaledHoverSlop(ViewConfiguration viewConfiguration) {
        return Build.VERSION.SDK_INT >= 28 ? b.a(viewConfiguration) : viewConfiguration.getScaledTouchSlop() / 2;
    }

    public static int getScaledMaximumFlingVelocity(Context context, ViewConfiguration viewConfiguration, int i10, int i11, int i12) {
        int dimensionPixelSize;
        if (Build.VERSION.SDK_INT >= 34) {
            return c.a(viewConfiguration, i10, i11, i12);
        }
        InputDevice device = InputDevice.getDevice(i10);
        if (!((device == null || device.getMotionRange(i11, i12) == null) ? false : true)) {
            return Integer.MIN_VALUE;
        }
        Resources resources = context.getResources();
        int identifier = (i12 == 4194304 && i11 == 26) ? resources.getIdentifier("config_viewMaxRotaryEncoderFlingVelocity", "dimen", MetricCommonTags.METRIC_COMMON_TAG_PLATFORM_ANDROID) : -1;
        Objects.requireNonNull(viewConfiguration);
        if (identifier == -1) {
            return Integer.valueOf(viewConfiguration.getScaledMaximumFlingVelocity()).intValue();
        }
        if (identifier == 0 || (dimensionPixelSize = resources.getDimensionPixelSize(identifier)) < 0) {
            return Integer.MIN_VALUE;
        }
        return dimensionPixelSize;
    }

    public static int getScaledMinimumFlingVelocity(Context context, ViewConfiguration viewConfiguration, int i10, int i11, int i12) {
        int dimensionPixelSize;
        if (Build.VERSION.SDK_INT >= 34) {
            return c.b(viewConfiguration, i10, i11, i12);
        }
        InputDevice device = InputDevice.getDevice(i10);
        if (!((device == null || device.getMotionRange(i11, i12) == null) ? false : true)) {
            return Integer.MAX_VALUE;
        }
        Resources resources = context.getResources();
        int identifier = (i12 == 4194304 && i11 == 26) ? resources.getIdentifier("config_viewMinRotaryEncoderFlingVelocity", "dimen", MetricCommonTags.METRIC_COMMON_TAG_PLATFORM_ANDROID) : -1;
        Objects.requireNonNull(viewConfiguration);
        if (identifier == -1) {
            return Integer.valueOf(viewConfiguration.getScaledMinimumFlingVelocity()).intValue();
        }
        if (identifier == 0 || (dimensionPixelSize = resources.getDimensionPixelSize(identifier)) < 0) {
            return Integer.MAX_VALUE;
        }
        return dimensionPixelSize;
    }

    public static float getScaledVerticalScrollFactor(ViewConfiguration viewConfiguration, Context context) {
        return Build.VERSION.SDK_INT >= 26 ? a.b(viewConfiguration) : a(viewConfiguration, context);
    }

    public static boolean shouldShowMenuShortcutsWhenKeyboardPresent(ViewConfiguration viewConfiguration, Context context) {
        if (Build.VERSION.SDK_INT >= 28) {
            return b.b(viewConfiguration);
        }
        Resources resources = context.getResources();
        int identifier = resources.getIdentifier("config_showMenuShortcutsWhenKeyboardPresent", "bool", MetricCommonTags.METRIC_COMMON_TAG_PLATFORM_ANDROID);
        return identifier != 0 && resources.getBoolean(identifier);
    }
}
