package f4;

import android.graphics.Color;

/* compiled from: ColorUtils.java */
/* loaded from: classes.dex */
public final class a {
    public static int getDarkerColor(int i10) {
        float[] fArr = {0.0f, 0.0f, f};
        Color.colorToHSV(i10, fArr);
        float f10 = fArr[2];
        float f11 = 0.8f * f10 * f10;
        if (f11 > 1.0f) {
            fArr[2] = 1.0f;
        } else if (f11 < 0.0f) {
            fArr[2] = 0.0f;
        }
        return Color.HSVToColor(fArr);
    }

    public static int getNewColorAlpha(int i10, float f10) {
        return Color.argb(Math.round(Color.alpha(i10) * f10), Color.red(i10), Color.green(i10), Color.blue(i10));
    }
}
